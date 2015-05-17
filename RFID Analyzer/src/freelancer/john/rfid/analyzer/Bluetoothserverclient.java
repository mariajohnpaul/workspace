package freelancer.john.rfid.analyzer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class Bluetoothserverclient {

	// Debugging
	private static final String TAG = "BluetoothService";
	private static final boolean D = true;

	// Name for the SDP record when creating server socket
	private static final String NAME_SECURE = "MainActivitySecure";
	private static final String NAME_INSECURE = "MainActivityInsecure";

	// Unique UUID for this application
	/*
	 * private static final UUID MY_UUID_SECURE = UUID
	 * .fromString("15622108-19f3-11e2-8899-f23c91aec05e");
	 * 
	 * 
	 * private static final UUID MY_UUID_INSECURE = UUID
	 * .fromString("15622108-19f3-11e2-8899-f23c91aec05e");
	 */

	private static final UUID MY_UUID_SECURE = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");
	private static final UUID MY_UUID_INSECURE = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");

	// Member fields
	private final BluetoothAdapter mAdapter;
	private final Handler mHandler;
	private AcceptThread mSecureAcceptThread;
	private AcceptThread mInsecureAcceptThread;
	private ConnectThread mConnectThread;
	private ConnectedThread mConnectedThread;
	private int mState;

	// Constants that indicate the current connection state
	public static final int STATE_NONE = 0; // we're doing nothing
	public static final int STATE_LISTEN = 1; // now listening for incoming
												// connections
	public static final int STATE_CONNECTING = 2; // now initiating an outgoing
													// connection
	public static final int STATE_CONNECTED = 3; // now connected to a remote
													// device

	/**
	 * Constructor. Prepares a new MainActivity session.
	 * 
	 * @param context
	 *            The UI Activity Context
	 * @param handler
	 *            A Handler to send messages back to the UI Activity
	 */
	public Bluetoothserverclient(Context context, Handler handler) {
		mAdapter = BluetoothAdapter.getDefaultAdapter();
		mState = STATE_NONE;
		mHandler = handler;
	}

	/**
	 * Set the current state of the chat connection
	 * 
	 * @param state
	 *            An integer defining the current connection state
	 */
	private synchronized void setState(int state) {
		if (D)
			Log.d(TAG, "setState() " + mState + " -> " + state);
		mState = state;

		/*// John Debugging it...
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.TOAST, "setState");
		msg.setData(bundle);
		mHandler.sendMessage(msg);
		// John finished
*/
		// Give the new state to the Handler so the UI Activity can update
		mHandler.obtainMessage(MainActivity.MESSAGE_STATE_CHANGE, state, -1)
				.sendToTarget();
		
		mHandler.obtainMessage(front_screen.MESSAGE_STATE_CHANGE, state, -1)
		.sendToTarget();
		
		
	}

	/**
	 * Return the current connection state.
	 */
	public synchronized int getState() {

		/*// John Debugging it...
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.TOAST, "getState");
		msg.setData(bundle);
		mHandler.sendMessage(msg);
		// John finished
*/
		return mState;
	}

	/**
	 * Start the chat service. Specifically start AcceptThread to begin a
	 * session in listening (server) mode. Called by the Activity onResume()
	 */
	public synchronized void start() {
		
		if (D)
			Log.d(TAG, "start");
		return;

	/*	// John Debugging it...
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.TOAST, "start");
		msg.setData(bundle);
		mHandler.sendMessage(msg);
		// John finished
*/
		// Cancel any thread attempting to make a connection
/*		if (mConnectThread != null) {
			mConnectThread.cancel();
			mConnectThread = null;
		}

		// Cancel any thread currently running a connection
		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}

		setState(STATE_LISTEN);

		// Start the thread to listen on a BluetoothServerSocket
		if (mSecureAcceptThread == null) {
			mSecureAcceptThread = new AcceptThread(true);
			mSecureAcceptThread.start();
		}
		if (mInsecureAcceptThread == null) {
			mInsecureAcceptThread = new AcceptThread(false);
			mInsecureAcceptThread.start();
		}*/
	}

	/**
	 * Start the ConnectThread to initiate a connection to a remote device.
	 * 
	 * @param device
	 *            The BluetoothDevice to connect
	 * @param secure
	 *            Socket Security type - Secure (true) , Insecure (false)
	 */
	public synchronized void connect(BluetoothDevice device, boolean secure) {
		if (D)
			Log.d(TAG, "connect to: " + device);

/*		// John Debugging it...
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.TOAST, "connect");
		msg.setData(bundle);
		mHandler.sendMessage(msg);
		// John finished
*/
		// Cancel any thread attempting to make a connection
		if (mState == STATE_CONNECTING) {
			if (mConnectThread != null) {
/*				// John Debugging it...
				Message msg1 = mHandler
						.obtainMessage(MainActivity.MESSAGE_TOAST);
				Bundle bundle1 = new Bundle();
				bundle.putString(MainActivity.TOAST,
						"connect INSIDE IF MCONNECT");
				msg1.setData(bundle);
				mHandler.sendMessage(msg1);
				// John finished
*/				mConnectThread.cancel();
				mConnectThread = null;
			}
		}

		// Cancel any thread currently running a connection
		if (mConnectedThread != null) {
			/*// John Debugging it...
			Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle1 = new Bundle();
			bundle.putString(MainActivity.TOAST, "connect DONT KNOW");
			msg1.setData(bundle);
			mHandler.sendMessage(msg1);
			// John finished
*/			mConnectedThread.cancel();
			mConnectedThread = null;
		}

		// Start the thread to connect with the given device
		mConnectThread = new ConnectThread(device, secure);
		mConnectThread.start();
		setState(STATE_CONNECTING);
	}

	/**
	 * Start the ConnectedThread to begin managing a Bluetooth connection
	 * 
	 * @param socket
	 *            The BluetoothSocket on which the connection was made
	 * @param device
	 *            The BluetoothDevice that has been connected
	 */
	public synchronized void connected(BluetoothSocket socket,
			BluetoothDevice device, final String socketType) {
		if (D)
			Log.d(TAG, "connected, Socket Type:" + socketType);

/*		// John Debugging it...
		Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle1 = new Bundle();
		bundle1.putString(MainActivity.TOAST, "connected");
		msg1.setData(bundle1);
		mHandler.sendMessage(msg1);
		// John finished
*/
		// Cancel the thread that completed the connection
		if (mConnectThread != null) {
			mConnectThread.cancel();
			mConnectThread = null;
		}

		// Cancel any thread currently running a connection
		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}

		// Cancel the accept thread because we only want to connect to one
		// device
		if (mSecureAcceptThread != null) {
			mSecureAcceptThread.cancel();
			mSecureAcceptThread = null;
		}
		if (mInsecureAcceptThread != null) {
			mInsecureAcceptThread.cancel();
			mInsecureAcceptThread = null;
		}

		// Start the thread to manage the connection and perform transmissions
		mConnectedThread = new ConnectedThread(socket, socketType);
		mConnectedThread.start();

		// Send the name of the connected device back to the UI Activity
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_DEVICE_NAME);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.DEVICE_NAME, device.getName());
		msg.setData(bundle);
		mHandler.sendMessage(msg);

		setState(STATE_CONNECTED);
	}

	/**
	 * Stop all threads
	 */
	public synchronized void stop() {
		if (D)
			Log.d(TAG, "stop");

		if (mConnectThread != null) {
			mConnectThread.cancel();
			mConnectThread = null;
		}

		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}

		if (mSecureAcceptThread != null) {
			mSecureAcceptThread.cancel();
			mSecureAcceptThread = null;
		}

		if (mInsecureAcceptThread != null) {
			mInsecureAcceptThread.cancel();
			mInsecureAcceptThread = null;
		}
		setState(STATE_NONE);
	}

	/**
	 * Write to the ConnectedThread in an unsynchronized manner
	 * 
	 * @param out
	 *            The bytes to write
	 * @see ConnectedThread#write(byte[])
	 */
	public void write(byte[] out) {
		// Create temporary object
		ConnectedThread r;
		// Synchronize a copy of the ConnectedThread

/*		// John Debugging it...
		Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle1 = new Bundle();
		bundle1.putString(MainActivity.TOAST, "write");
		msg1.setData(bundle1);
		mHandler.sendMessage(msg1);
		// John finished
*/
		synchronized (this) {
			if (mState != STATE_CONNECTED)
				return;
			r = mConnectedThread;
		}
		// Perform the write unsynchronized
		r.write(out);
	}

	/**
	 * Indicate that the connection attempt failed and notify the UI Activity.
	 */
	private void connectionFailed() {
		// Send a failure message back to the Activity
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.TOAST, "Unable to connect device");
		msg.setData(bundle);
		mHandler.sendMessage(msg);

		// Start the service over to restart listening mode
		Bluetoothserverclient.this.start();
	}

	/**
	 * Indicate that the connection was lost and notify the UI Activity.
	 */
	private void connectionLost() {
		// Send a failure message back to the Activity
		Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(MainActivity.TOAST, "Device connection was lost");
		msg.setData(bundle);
		mHandler.sendMessage(msg);

		// Start the service over to restart listening mode
		Bluetoothserverclient.this.start();
	}

	/**
	 * This thread runs while listening for incoming connections. It behaves
	 * like a server-side client. It runs until a connection is accepted (or
	 * until cancelled).
	 */
	private class AcceptThread extends Thread {
		// The local server socket
		private final BluetoothServerSocket mmServerSocket;
		private String mSocketType;

		public AcceptThread(boolean secure) {
			BluetoothServerSocket tmp = null;
			mSocketType = secure ? "Secure" : "Insecure";

/*			// John Debugging it...
			Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle = new Bundle();
			bundle.putString(MainActivity.TOAST, "AcceptThread");
			msg.setData(bundle);
			mHandler.sendMessage(msg);
			// John finished
*/
			// Create a new listening server socket
			try {
				if (secure) {
					tmp = mAdapter.listenUsingRfcommWithServiceRecord(
							NAME_SECURE, MY_UUID_SECURE);
				} else {
					tmp = mAdapter.listenUsingInsecureRfcommWithServiceRecord(
							NAME_INSECURE, MY_UUID_INSECURE);
				}
			} catch (IOException e) {
				Log.e(TAG, "Socket Type: " + mSocketType + "listen() failed", e);
			}
			mmServerSocket = tmp;
		}

		public void run() {
			if (D)
				Log.d(TAG, "Socket Type: " + mSocketType
						+ "BEGIN mAcceptThread" + this);
			setName("AcceptThread" + mSocketType);

			BluetoothSocket socket = null;

/*			// John Debugging it...
			Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle1 = new Bundle();
			bundle1.putString(MainActivity.TOAST, "run");
			msg1.setData(bundle1);
			mHandler.sendMessage(msg1);
			// John finished
*/
			// Listen to the server socket if we're not connected
			while (mState != STATE_CONNECTED) {
				try {
					// This is a blocking call and will only return on a
					// successful connection or an exception
					socket = mmServerSocket.accept();
				} catch (IOException e) {
					Log.e(TAG, "Socket Type: " + mSocketType
							+ "accept() failed", e);
					break;
				}

				// If a connection was accepted
				if (socket != null) {
					synchronized (Bluetoothserverclient.this) {
						switch (mState) {
						case STATE_LISTEN:
						case STATE_CONNECTING:
							// Situation normal. Start the connected thread.
							connected(socket, socket.getRemoteDevice(),
									mSocketType);
							break;
						case STATE_NONE:
						case STATE_CONNECTED:
							// Either not ready or already connected. Terminate
							// new socket.
							try {
								socket.close();
							} catch (IOException e) {
								Log.e(TAG, "Could not close unwanted socket", e);
							}
							break;
						}
					}
				}
			}
			if (D)
				Log.i(TAG, "END mAcceptThread, socket Type: " + mSocketType);

		}

		public void cancel() {
			if (D)
				Log.d(TAG, "Socket Type" + mSocketType + "cancel " + this);
			try {
				mmServerSocket.close();
			} catch (IOException e) {
				Log.e(TAG, "Socket Type" + mSocketType
						+ "close() of server failed", e);
			}
		}
	}

	/**
	 * This thread runs while attempting to make an outgoing connection with a
	 * device. It runs straight through; the connection either succeeds or
	 * fails.
	 */
	private class ConnectThread extends Thread {
		private final BluetoothSocket mmSocket;
		private final BluetoothDevice mmDevice;
		private String mSocketType;

		public ConnectThread(BluetoothDevice device, boolean secure) {
			mmDevice = device;
			BluetoothSocket tmp = null;
			mSocketType = secure ? "Secure" : "Insecure";

/*			// John Debugging it...
			Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle = new Bundle();
			bundle.putString(MainActivity.TOAST, "connectThread");
			msg.setData(bundle);
			mHandler.sendMessage(msg);
			// John finished
*/
			// Get a BluetoothSocket for a connection with the
			// given BluetoothDevice

			try {
				if (secure) {

					// tmp = device
					// .createRfcommSocketToServiceRecord(MY_UUID_SECURE);

					Method m;

					try {
						m = device.getClass().getMethod("createRfcommSocket",
								new Class[] { int.class });
						tmp = (BluetoothSocket) m.invoke(device, 1);
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					tmp = device
							.createInsecureRfcommSocketToServiceRecord(MY_UUID_INSECURE);

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.e(TAG, "Socket Type: " + mSocketType + "create() failed", e);
				/*// John Debugging it...
				Message msg2 = mHandler
						.obtainMessage(MainActivity.MESSAGE_TOAST);
				Bundle bundle2 = new Bundle();
				bundle2.putString(MainActivity.TOAST, "connectThread socket");
				msg2.setData(bundle2);
				mHandler.sendMessage(msg2);
				// John finished
*/
				e.printStackTrace();
			}
			mmSocket = tmp;
		}

		public void run() {
			Log.i(TAG, "BEGIN mConnectThread SocketType:" + mSocketType);
			setName("ConnectThread" + mSocketType);

			// Always cancel discovery because it will slow down a connection
			mAdapter.cancelDiscovery();

/*			// John Debugging it...
			Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle1 = new Bundle();
			bundle1.putString(MainActivity.TOAST, "connectThreadrun");
			msg1.setData(bundle1);
			mHandler.sendMessage(msg1);
			// John finished
*/
			// Make a connection to the BluetoothSocket
			try {
				// This is a blocking call and will only return on a
				// successful connection or an exception
				mmSocket.connect();
			} catch (IOException e) {
				// Close the socket
				try {

/*					// John Debugging it...
					Message msg2 = mHandler
							.obtainMessage(MainActivity.MESSAGE_TOAST);
					Bundle bundle2 = new Bundle();
					bundle2.putString(MainActivity.TOAST, "socket closed");
					msg2.setData(bundle2);
					mHandler.sendMessage(msg2);
					// John finished
*/
					mmSocket.close();
				} catch (IOException e2) {
					Log.e(TAG, "unable to close() " + mSocketType
							+ " socket during connection failure", e2);
				}
				connectionFailed();
				return;
			}

			// John Debugging it...
			Message msg3 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle3 = new Bundle();
			bundle3.putString(MainActivity.TOAST, "socket con synch");
			msg3.setData(bundle3);
			mHandler.sendMessage(msg3);
			// John finished

			// Reset the ConnectThread because we're done
			synchronized (Bluetoothserverclient.this) {
				mConnectThread = null;
			}

/*			// John Debugging it...
			Message msg2 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle2 = new Bundle();
			bundle2.putString(MainActivity.TOAST, "socket created going nxt");
			msg2.setData(bundle2);
			mHandler.sendMessage(msg2);
			// John finished
*/
			// Start the connected thread
			connected(mmSocket, mmDevice, mSocketType);
		}

		public void cancel() {
			try {
				mmSocket.close();
			} catch (IOException e) {
				Log.e(TAG, "close() of connect " + mSocketType
						+ " socket failed", e);
			}
		}
	}

	/**
	 * This thread runs during a connection with a remote device. It handles all
	 * incoming and outgoing transmissions.
	 */
	private class ConnectedThread extends Thread {
		private final BluetoothSocket mmSocket;
		private final InputStream mmInStream;
		private final OutputStream mmOutStream;

		public ConnectedThread(BluetoothSocket socket, String socketType) {
			Log.d(TAG, "create ConnectedThread: " + socketType);
			mmSocket = socket;
			InputStream tmpIn = null;
			OutputStream tmpOut = null;

/*			// John Debugging it...
			Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle1 = new Bundle();
			bundle1.putString(MainActivity.TOAST, "connectedThreadconstructor");
			msg1.setData(bundle1);
			mHandler.sendMessage(msg1);
			// John finished
*/
			// Get the BluetoothSocket input and output streams
			try {
				tmpIn = socket.getInputStream();
				tmpOut = socket.getOutputStream();
			} catch (IOException e) {
				Log.e(TAG, "temp sockets not created", e);
			}

			mmInStream = tmpIn;
			mmOutStream = tmpOut;
		}

		public void run() {
			Log.i(TAG, "BEGIN mConnectedThread");
			byte[] buffer = new byte[100];
			int bytes;

/*			// John Debugging it...
			Message msg1 = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
			Bundle bundle1 = new Bundle();
			bundle1.putString(MainActivity.TOAST, "connected Thread run");
			msg1.setData(bundle1);
			mHandler.sendMessage(msg1);
			// John finished
*/
			// Keep listening to the InputStream while connected
			while (true) {
				try {
					if (mmInStream.available() > 16) {//john changed to 16 from 0
						// Read from the InputStream
						bytes = mmInStream.read(buffer);
						String readMessage = new String(buffer, 0, bytes);


						// Send the obtained bytes to the UI Activity
						mHandler.obtainMessage(MainActivity.MESSAGE_READ,
								bytes, -1, readMessage).sendToTarget();
					}
				} catch (IOException e) {
					Log.e(TAG, "disconnected", e);
					connectionLost();
					// Start the service over to restart listening mode
					Bluetoothserverclient.this.start();
					break;
				}
			}
		}

		/**
		 * Write to the connected OutStream.
		 * 
		 * @param buffer
		 *            The bytes to write
		 */
		public void write(byte[] buffer) {
			try {

/*				// John Debugging it...
				Message msg1 = mHandler
						.obtainMessage(MainActivity.MESSAGE_TOAST);
				Bundle bundle1 = new Bundle();
				bundle1.putString(MainActivity.TOAST, "connectedThreadWrite");
				msg1.setData(bundle1);
				mHandler.sendMessage(msg1);
				// John finished
*/
				mmOutStream.write(buffer);

				// Share the sent message back to the UI Activity
				mHandler.obtainMessage(MainActivity.MESSAGE_WRITE, -1, -1,
						buffer).sendToTarget();
			} catch (IOException e) {
				Log.e(TAG, "Exception during write", e);
			}
		}

		public void cancel() {
			try {
				mmSocket.close();
			} catch (IOException e) {
				Log.e(TAG, "close() of connect socket failed", e);
			}
		}
	}
}
