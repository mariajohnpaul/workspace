package freelancer.john.rfid.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	// Intent request codes
	private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
	private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
	private static final int REQUEST_ENABLE_BT = 3;

	// for debug john
	private Button Send;
	private Button Next;
	private Button bsettings;

	// Message types sent from the Bluetoothserverclient Handler
	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;

	// Key names received from the BluetoothChatService Handler
	public static final String DEVICE_NAME = "device_name";
	public static final String TOAST = "toast";

	// Name of the connected device
	private String mConnectedDeviceName = null;
	// Array adapter for the conversation thread
	// john private ArrayAdapter<String> mConversationArrayAdapter;
	// String buffer for outgoing messages
	private StringBuffer mOutStringBuffer;
	// Local Bluetooth adapter
	private BluetoothAdapter mBluetoothAdapter = null;
	// Member object for the chat services
	private Bluetoothserverclient mChatService = null;

	TextView RFIDtag;
	EditText EditText1;
	EditText EditText2;
	EditText EditText3;
	EditText EditText4;
	EditText EditText5;
	private static String search_RF;

	static ArrayList<String> lines = new ArrayList<String>();
	static ArrayList<String> lines1 = new ArrayList<String>();
	static int Index;

	static String sendmsg = "";

	static int sIndex;

	static String setting = "";

	static String connect = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// to avoid multiple instance
		if (!isTaskRoot()) {
			final Intent intent = getIntent();
			final String intentAction = intent.getAction();
			if (intent.hasCategory(Intent.CATEGORY_LAUNCHER)
					&& intentAction != null
					&& intentAction.equals(Intent.ACTION_MAIN)) {

				finish();
				return;
			}
		}

		this.getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_main);

		// JOHN TEST
		// openOptionsMenu();
		// this.onAttachedToWindow();

		// Get local Bluetooth adapter
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		// If the adapter is null, then Bluetooth is not supported
		if (mBluetoothAdapter == null) {
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			// finish();
			return;
		}
		lines.clear();
		lines1.clear();

		sIndex = 0;

		this.onStart();
	}

	@Override
	public synchronized void onResume() {
		super.onResume();
		// if(D) Log.e(TAG, "+ ON RESUME +");

		// Performing this check in onResume() covers the case in which BT was
		// not enabled during onStart(), so we were paused to enable it...
		// onResume() will be called when ACTION_REQUEST_ENABLE activity
		// returns.

		if (mChatService != null) {
			// Only if the state is STATE_NONE, do we know that we haven't
			// started already
			if (mChatService.getState() == Bluetoothserverclient.STATE_NONE) {
				// Start the Bluetooth chat services
				mChatService.start();
			}
		}
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		// If BT is not on, request that it be enabled.
		// setupChat() will then be called during onActivityResult

		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
			// Otherwise, setup the chat session
		} else {

			EditText1 = (EditText) findViewById(R.id.editText1);
			EditText2 = (EditText) findViewById(R.id.editText2);
			EditText3 = (EditText) findViewById(R.id.editText3);
			EditText4 = (EditText) findViewById(R.id.editText4);
			EditText5 = (EditText) findViewById(R.id.editText5);

			// john read and fill it first time

			File myFile = new File(Environment.getExternalStorageDirectory()
					.getPath() + "/RFAnalyzer/RFanalyzerdata.csv");

			FileInputStream is = null;

			if (myFile.exists()) {
				try {
					is = new FileInputStream(myFile);
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(is));

					String aDataRow = null;
					while ((aDataRow = reader.readLine()) != null) {

						TextView tv1 = (TextView) findViewById(R.id.textView1);
						TextView tv2 = (TextView) findViewById(R.id.textView2);
						TextView tv3 = (TextView) findViewById(R.id.textView3);
						TextView tv4 = (TextView) findViewById(R.id.textView4);
						TextView tv5 = (TextView) findViewById(R.id.textView5);

						String[] RowData_first = aDataRow.split(",");

						if (RowData_first.length > 1)
							tv1.setText(RowData_first[1]);
						if (RowData_first.length > 2)
							tv2.setText(RowData_first[2]);
						if (RowData_first.length > 3)
							tv3.setText(RowData_first[3]);
						if (RowData_first.length > 4)
							tv4.setText(RowData_first[4]);
						if (RowData_first.length > 5)
							tv5.setText(RowData_first[5]);

						break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						// handle exception
					}
				}
			}

			myFile = new File(Environment.getExternalStorageDirectory()
					.getPath() + "/RFAnalyzer/settings.csv");

			is = null;

			if (myFile.exists()) {
				try {
					is = new FileInputStream(myFile);
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(is));

					String aDataRow = null;
					while ((aDataRow = reader.readLine()) != null) {

						setting = aDataRow;

						break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						// handle exception
					}
				}

			}
		}

		// if (mChatService == null) setupChat();
		start_serverclient();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case REQUEST_CONNECT_DEVICE_SECURE:
			// When DeviceListActivity returns with a device to connect
			if (resultCode == Activity.RESULT_OK) {

				connectDevice(data, true);
			}
			break;
		case REQUEST_CONNECT_DEVICE_INSECURE:
			// When DeviceListActivity returns with a device to connect
			if (resultCode == Activity.RESULT_OK) {
				connectDevice(data, false);
			}
			break;
		case REQUEST_ENABLE_BT:
			// When the request to enable Bluetooth returns
			if (resultCode == Activity.RESULT_OK) {
				// Bluetooth is now enabled, so set up a chat session
				// john setupChat();
				start_serverclient();
			} else {
				// User did not enable Bluetooth or an error occurred

				Toast.makeText(this, "Blue Tooth Not enabled",
						Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}

	private void start_serverclient() {

		Intent intent1 = getIntent();
		Bundle bundle1 = intent1.getExtras();
		if (bundle1 != null) {
			setting = bundle1.getString("Settings");
			search_RF = bundle1.getString("Search Value");
			connect = bundle1.getString("Connect_BT");
		}

		if (connect.contains("Connect")) {
			// openOptionsMenu();
		}

		// Search the RFID given in the front page
		if (search_RF != null) {
			readandfilldatacsv(search_RF, false);

		}

		RFIDtag = (TextView) findViewById(R.id.RFID_value);
		Send = (Button) findViewById(R.id.Save);
		Send.setOnClickListener((OnClickListener) this);

		bsettings = (Button) findViewById(R.id.bsettings);
		bsettings.setOnClickListener(this);
		// John testing Ends

		EditText1 = (EditText) findViewById(R.id.editText1);
		EditText2 = (EditText) findViewById(R.id.editText2);
		EditText3 = (EditText) findViewById(R.id.editText3);
		EditText4 = (EditText) findViewById(R.id.editText4);
		EditText5 = (EditText) findViewById(R.id.editText5);

		// Initialize the Bluetoothserverclient to perform bluetooth connections
		mChatService = new Bluetoothserverclient(this, mHandler);

		// Initialize the buffer for outgoing messages
		mOutStringBuffer = new StringBuffer("");

		if (setting != null) {

			if (setting.contains("1")) {
				EditText1.setVisibility(View.INVISIBLE);
			} else {
				EditText1.setVisibility(View.VISIBLE);
			}
			if (setting.contains("2")) {
				EditText1.setInputType(InputType.TYPE_CLASS_TEXT);

			} else {
				EditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
			}

			if (setting.contains("3")) {
				EditText2.setVisibility(View.INVISIBLE);
			} else {
				EditText2.setVisibility(View.VISIBLE);
			}
			if (setting.contains("4")) {
				EditText2.setInputType(InputType.TYPE_CLASS_TEXT);
			} else {
				EditText2.setInputType(InputType.TYPE_CLASS_NUMBER);

			}
			if (setting.contains("5")) {
				EditText3.setVisibility(View.INVISIBLE);
			} else {
				EditText3.setVisibility(View.VISIBLE);
			}
			if (setting.contains("6")) {

				EditText3.setInputType(InputType.TYPE_CLASS_TEXT);
			} else {
				EditText3.setInputType(InputType.TYPE_CLASS_NUMBER);
			}

			if (setting.contains("7")) {
				EditText4.setVisibility(View.INVISIBLE);
			} else {
				EditText4.setVisibility(View.VISIBLE);
			}
			if (setting.contains("8")) {

				EditText4.setInputType(InputType.TYPE_CLASS_TEXT);
			} else {
				EditText4.setInputType(InputType.TYPE_CLASS_NUMBER);
			}
			if (setting.contains("9")) {
				EditText5.setVisibility(View.INVISIBLE);
			} else {
				EditText5.setVisibility(View.VISIBLE);
			}
			if (setting.contains("10")) {

				EditText5.setInputType(InputType.TYPE_CLASS_TEXT);
			} else {
				EditText5.setInputType(InputType.TYPE_CLASS_NUMBER);
			}
		}

	}

	private void connectDevice(Intent data, boolean secure) {
		// Get the device MAC address
		String address = data.getExtras().getString(
				DeviceListActivity.EXTRA_DEVICE_ADDRESS);

		// Get the BluetoothDevice object
		BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
		// Attempt to connect to the device
		mChatService.connect(device, secure);
	}

	private final void setStatus(int resId) {
		// final ActionBar actionBar = getActionBar();
		// actionBar.setSubtitle(resId);

		// EditText jp1 = (EditText) findViewById(R.id.editText3);
		// jp1.setText(getString(resId));
	}

	private final void setStatus(CharSequence subTitle) {
		// final ActionBar actionBar = getActionBar();
		// actionBar.setSubtitle(subTitle);
		Toast.makeText(this, subTitle, Toast.LENGTH_SHORT).show();
	}

	// The Handler that gets information back from the Bluetoothserverclient
	private final Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MESSAGE_STATE_CHANGE:
				// if(D) Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
				switch (msg.arg1) {
				case Bluetoothserverclient.STATE_CONNECTED:
					// john setStatus(getString(R.string.title_connected_to,
					// mConnectedDeviceName));
					setStatus(R.string.title_connected_to);
					// mConversationArrayAdapter.clear();
					break;
				case Bluetoothserverclient.STATE_CONNECTING:
					setStatus(R.string.title_connecting);
					break;
				case Bluetoothserverclient.STATE_LISTEN:
				case Bluetoothserverclient.STATE_NONE:
					setStatus(R.string.title_not_connected);
					break;
				}
				break;
			case MESSAGE_WRITE:
				byte[] writeBuf = (byte[]) msg.obj;
				// construct a string from the buffer
				String writeMessage = new String(writeBuf);
				// mConversationArrayAdapter.add("Me:  " + writeMessage);
				break;
			case MESSAGE_READ:
				// byte[] readBuf = (byte[]) msg.obj;
				// construct a string from the valid bytes in the buffer
				// String readMessage = new String(readBuf, 0, msg.arg1);
				String readMessage = (String) msg.obj;

				if (readMessage.length() < 17) {
					setStatus("Error in reading please Rescan");
					break;
				}

				readMessage = readMessage.substring(0, 16);

				// setContentView(R.layout.activity_main);
				RFIDtag = (TextView) findViewById(R.id.RFID_value);

				String rfidvalue = RFIDtag.getText().toString();

				if (rfidvalue != null) {
					break;
				}

				RFIDtag.setText(readMessage);

				// do it later read SD card and fill the data ...

				// john readandfilldata(readMessage);

				readandfilldatacsv(readMessage, false);
				// mConversationArrayAdapter.add(mConnectedDeviceName+":  " +
				// readMessage);
				break;
			case MESSAGE_DEVICE_NAME:
				// save the connected device's name
				mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
				Toast.makeText(getApplicationContext(),
						"Connected to " + mConnectedDeviceName,
						Toast.LENGTH_SHORT).show();
				break;
			case MESSAGE_TOAST:
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(TOAST), Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}

		/*
		 * final private void readandfilldata(String readMessage) { // TODO
		 * Auto-generated method stub // setContentView(R.layout.activity_main);
		 * EditText1 = (EditText) findViewById(R.id.editText1); EditText2 =
		 * (EditText) findViewById(R.id.editText2); EditText3 = (EditText)
		 * findViewById(R.id.editText3); EditText4 = (EditText)
		 * findViewById(R.id.editText4);
		 * 
		 * EditText1.setText(""); EditText2.setText(""); EditText3.setText("");
		 * EditText4.setText("");
		 * 
		 * File myFile = new File(Environment.getExternalStorageDirectory()
		 * .getPath() + "/RFAnalyzer/RFanalyzer.txt"); Index = -1; if
		 * (myFile.exists()) { try { FileInputStream fIn = new
		 * FileInputStream(myFile); BufferedReader myReader = new
		 * BufferedReader( new InputStreamReader(fIn)); String aDataRow = "";
		 * lines.clear();
		 * 
		 * while ((aDataRow = myReader.readLine()) != null) { // john filling
		 * the arraylist lines.add(aDataRow);
		 * 
		 * if (aDataRow.contains(readMessage)) {
		 * 
		 * Index = lines.lastIndexOf(aDataRow);
		 * 
		 * int ind1 = aDataRow.indexOf(",-1-,"); int ind2 =
		 * aDataRow.indexOf(",-2-,");
		 * 
		 * String Edtxt = aDataRow.substring(ind1 + 5, ind2);
		 * EditText1.setText(Edtxt);
		 * 
		 * ind1 = aDataRow.indexOf(",-2-,"); ind2 = aDataRow.indexOf(",-3-,");
		 * 
		 * Edtxt = aDataRow.substring(ind1 + 5, ind2); EditText2.setText(Edtxt);
		 * 
		 * ind1 = aDataRow.indexOf(",-3-,"); ind2 = aDataRow.indexOf(",-4-,");
		 * 
		 * Edtxt = aDataRow.substring(ind1 + 5, ind2); EditText3.setText(Edtxt);
		 * 
		 * ind1 = aDataRow.indexOf(",-4-,"); ind2 = aDataRow.indexOf(",-5-,");
		 * 
		 * Edtxt = aDataRow.substring(ind1 + 5, ind2); EditText4.setText(Edtxt);
		 * 
		 * }
		 * 
		 * } fIn.close(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 * 
		 * } if (Index == -1) { writetoSD(Index); } }
		 */
	};

	final private void readandfilldatacsv(String readMessage, boolean first) {
		// TODO Auto-generated method stub

		// setContentView(R.layout.activity_main);
		EditText1 = (EditText) findViewById(R.id.editText1);
		EditText2 = (EditText) findViewById(R.id.editText2);
		EditText3 = (EditText) findViewById(R.id.editText3);
		EditText4 = (EditText) findViewById(R.id.editText4);
		EditText5 = (EditText) findViewById(R.id.editText5);

		EditText1.setText("");
		EditText2.setText("");
		EditText3.setText("");
		EditText4.setText("");
		EditText5.setText("");

		RFIDtag = (TextView) findViewById(R.id.RFID_value);
		RFIDtag.setText(readMessage);

		File myFile = new File(Environment.getExternalStorageDirectory()
				.getPath() + "/RFAnalyzer/RFanalyzerdata.csv");

		FileInputStream is = null;

		lines1.clear();
		Index = -1;

		if (myFile.exists()) {
			try {
				is = new FileInputStream(myFile);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));

				String aDataRow = null;
				while ((aDataRow = reader.readLine()) != null) {

					// john filling the arraylist
					lines1.add(aDataRow);

					if (aDataRow.contains(readMessage)) {

						Index = lines1.lastIndexOf(aDataRow);

						String[] RowData = aDataRow.split(",");

						int val = RowData.length;

						if (val > 1) {
							EditText1.setText(RowData[1]);
						}
						if (val > 2) {
							EditText2.setText(RowData[2]);
						}
						if (val > 3) {
							EditText3.setText(RowData[3]);
						}
						if (val > 4) {
							EditText4.setText(RowData[4]);
						}
						if (val > 5) {
							EditText5.setText(RowData[5]);
						}
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					// handle exception
				}
			}
		}

		if (Index == -1 && (search_RF != null)) {
			search_RF = null;

		} else if (Index == -1) {
			writetoSD(Index);
		}

	}

	private void sendMessage(String message) {
		// Check that we're actually connected before trying anything
		if (mChatService.getState() != Bluetoothserverclient.STATE_CONNECTED) {
			Toast.makeText(this, "Not connected", Toast.LENGTH_SHORT).show();
			return;
		}

		// Check that there's actually something to send
		if (message.length() > 0) {
			// Get the message bytes and tell the BluetoothChatService to write
			byte[] send = message.getBytes();
			mChatService.write(send);

			// Reset out string buffer to zero and clear the edit text field
			// mOutStringBuffer.setLength(0);
			// mOutEditText.setText(mOutStringBuffer);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.option_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent serverIntent = null;
		switch (item.getItemId()) {
		case R.id.secure_connect_scan:
			// Launch the DeviceListActivity to see devices and do scan
			serverIntent = new Intent(this, DeviceListActivity.class);
			startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_SECURE);
			return true;
		case R.id.insecure_connect_scan:
			// Launch the DeviceListActivity to see devices and do scan
			serverIntent = new Intent(this, DeviceListActivity.class);
			startActivityForResult(serverIntent,
					REQUEST_CONNECT_DEVICE_INSECURE);
			return true;
		case R.id.discoverable:
			// Ensure this device is discoverable by others
			ensureDiscoverable();
			return true;
		}
		return false;
	}

	private void ensureDiscoverable() {
		// if(D) Log.d(TAG, "ensure discoverable");
		if (mBluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
			Intent discoverableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			discoverableIntent.putExtra(
					BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
			startActivity(discoverableIntent);
		}
	}

	public void onClick(View arg0) {

		switch (arg0.getId()) {
		case R.id.Save: {

			{// John searching

				RFIDtag = (TextView) findViewById(R.id.RFID_value);
				String readMessage = RFIDtag.getText().toString();

				/*
				 * File myFile = new
				 * File(Environment.getExternalStorageDirectory() .getPath() +
				 * "/RFAnalyzer/RFanalyzer.txt"); Index = -1; if
				 * (myFile.exists()) { try { FileInputStream fIn = new
				 * FileInputStream(myFile); BufferedReader myReader = new
				 * BufferedReader( new InputStreamReader(fIn)); String aDataRow
				 * = ""; lines.clear();
				 * 
				 * 
				 * 
				 * while ((aDataRow = myReader.readLine()) != null) { // john
				 * filling the arraylist lines.add(aDataRow);
				 * 
				 * if (aDataRow.contains(readMessage)) {
				 * 
				 * //Index = lines.size()-1;
				 * 
				 * Index =lines.lastIndexOf(aDataRow);
				 * 
				 * //break; }
				 * 
				 * } fIn.close(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); } }
				 */

				File myFile = new File(Environment
						.getExternalStorageDirectory().getPath()
						+ "/RFAnalyzer/RFanalyzerdata.csv");
				Index = -1;
				if (myFile.exists()) {
					try {
						FileInputStream fIn = new FileInputStream(myFile);
						BufferedReader myReader = new BufferedReader(
								new InputStreamReader(fIn));
						String aDataRow = null;
						lines1.clear();

						/*
						 * Toast.makeText(this, "I am in try file exsists",
						 * Toast.LENGTH_SHORT).show();
						 */

						while ((aDataRow = myReader.readLine()) != null) {
							// john filling the arraylist
							lines1.add(aDataRow);

							if (aDataRow.contains(readMessage)) {

								// Index = lines.size()-1;

								Index = lines1.lastIndexOf(aDataRow);
								Toast.makeText(this, "match found",
										Toast.LENGTH_SHORT).show();

								// break;
							}

						}
						fIn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			// if the searching returns 1 look for this data is user entered one
			if (Index == -1 && (search_RF != null)) {
				search_RF = null;

			} else {
				writetoSD(Index);
			}

			// cleanup
			RFIDtag = (TextView) findViewById(R.id.RFID_value);
			RFIDtag.setText("");

			// After saving go to front screen
			final Context context = this;
			Intent intent = new Intent(context, front_screen.class);
			startActivity(intent);

			break;
		}

		case R.id.bsettings: {

			final Context context = this;

			Intent intent = new Intent(context, settings.class);
			startActivity(intent);

			/*
			 * Toast.makeText(this, "Future implementation",
			 * Toast.LENGTH_SHORT).show();
			 * 
			 * RFIDtag = (TextView) findViewById(R.id.RFID_value);
			 * 
			 * 
			 * 
			 * if(sendmsg.contains("932 123456789")) { sendmsg =
			 * "123 123456789012"; } else
			 * if(sendmsg.contains("123 123456789012")){ sendmsg =
			 * "000 111222333444";
			 * 
			 * }else { sendmsg = "932 123456789012"; }
			 * 
			 * 
			 * sendMessage(sendmsg);
			 */

			break;
		}
		case R.id.shome: {
			setContentView(R.layout.activity_main);
		}
		}
	}

	private void readSD() {
		// TODO Auto-generated method stub

		File myFile = new File(Environment.getExternalStorageDirectory()
				.getPath() + "/RFAnalyzer/RFanalyzer.txt");

		if (myFile.exists()) {
			try {
				FileInputStream fIn = new FileInputStream(myFile);
				BufferedReader myReader = new BufferedReader(
						new InputStreamReader(fIn));
				String aDataRow = "";
				lines.clear();

				while ((aDataRow = myReader.readLine()) != null) {
					// john filling the arraylist
					lines.add(aDataRow);

				}

				fIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void writetoSD(int LocIndex) {
		// TODO Auto-generated method stub

		// sendMessage("Ave Maria John Paul");
		// Do it later write the content to the SD card

		// Write on the External Storage

		if (RFIDtag.getText().toString().contains(".......")) {
			Toast.makeText(this, "Scan a RFID first", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		File root = new File(Environment.getExternalStorageDirectory()
				+ "/RFAnalyzer/");

		root.mkdir();

		/*
		 * File RFanalyzer = new File(root, "RFanalyzer.txt");
		 * 
		 * FileOutputStream fo = null; try { //John no appending fo = new
		 * FileOutputStream(RFanalyzer, true); fo = new
		 * FileOutputStream(RFanalyzer); } catch (FileNotFoundException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// converting String to Byte deleted
		/* OutputStreamWriter fosw = new OutputStreamWriter(fo); */

		String Temp2 = RFIDtag.getText().toString() + ","
				+ EditText1.getText().toString() + ","
				+ EditText2.getText().toString() + ","
				+ EditText3.getText().toString() + ","
				+ EditText4.getText().toString() + ","
				+ EditText5.getText().toString();

		/*
		 * String Temp = "<START>" + RFIDtag.getText().toString() + ",-1-,"
		 * +EditText1.getText().toString() + ",-2-,"
		 * +EditText2.getText().toString() + ",-3-,"
		 * +EditText3.getText().toString() + ",-4-,"
		 * +EditText4.getText().toString() + ",-5-,";
		 */

		Toast.makeText(this, Integer.toString(Index), Toast.LENGTH_SHORT)
				.show();

		// John writing the ArrayList
		if (Index == -1) {
			/*
			 * lines.add(Temp); Index = lines.lastIndexOf(Temp);
			 */
			lines1.add(Temp2);
			Index = lines.lastIndexOf(Temp2);
		} else {
			/* lines.set(Index,Temp); */
			lines1.set(Index, Temp2);

		}
		// writing to the file
		// try {

		/*
		 * fosw.append("<START>" + RFIDtag.getText().toString() + ",-1-,");
		 * fosw.append(EditText1.getText().toString() + ",-2-,");
		 * fosw.append(EditText2.getText().toString() + ",-3-,");
		 * fosw.append(EditText3.getText().toString() + ",-4-,");
		 * fosw.append(EditText4.getText().toString() + ",-5-,\n");
		 */

		String csvfilestring = Environment.getExternalStorageDirectory()
				+ "/RFAnalyzer/RFanalyzerdata.csv";
		File file = new File(csvfilestring);

		try {

			file.delete();

		} catch (Exception e) {

			e.printStackTrace();

		}

		for (int i = 0; i < lines1.size(); i++) {
			// String Temp1 = lines.get(i)+"\r\n";
			String Temp3 = lines1.get(i);

			// fosw.append(Temp1);

			// csv file john

			writeData(Temp3, csvfilestring);

		}
		// fosw.close();
		// fo.close();

		// } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public void writeData(String data, String strFilePath) {

		PrintWriter csvWriter;
		try {

			File file = new File(strFilePath);
			if (!file.exists()) {
				file = new File(strFilePath);
			}
			csvWriter = new PrintWriter(new FileWriter(file, true));

			csvWriter.append(data);
			csvWriter.append("\r\n");

			csvWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		// JOHN TEST
		openOptionsMenu();
	}

}
