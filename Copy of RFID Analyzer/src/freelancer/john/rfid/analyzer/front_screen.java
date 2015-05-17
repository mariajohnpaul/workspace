package freelancer.john.rfid.analyzer;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class front_screen extends Activity implements OnClickListener{
	
	String Search_value;
	// Message types sent from the Bluetoothserverclient Handler
		public static final int MESSAGE_STATE_CHANGE = 1;
		public static final int MESSAGE_READ = 2;
		public static final int MESSAGE_WRITE = 3;
		public static final int MESSAGE_DEVICE_NAME = 4;
		public static final int MESSAGE_TOAST = 5;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//to avoid multiple instance
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
		
		setContentView(R.layout.front_screen);
		
		Button search = (Button) findViewById(R.id.button_search);		
		search.setOnClickListener((OnClickListener) this);
		Button connect_bluetooth = (Button) findViewById(R.id.connect_button);		
		connect_bluetooth.setOnClickListener((OnClickListener) this);
		
		


		

	}
	
	private final Handler mHandler1 = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MESSAGE_STATE_CHANGE:
				
				switch (msg.arg1) {
				case Bluetoothserverclient.STATE_CONNECTED:
						TextView tv1 = (TextView) findViewById(R.id.tvstatus);
						tv1.setText("Connected");
					break;
				case Bluetoothserverclient.STATE_CONNECTING:
					tv1 = (TextView) findViewById(R.id.tvstatus);
					tv1.setText("Connecting");
					break;
				case Bluetoothserverclient.STATE_LISTEN:
					tv1 = (TextView) findViewById(R.id.tvstatus);
					tv1.setText("Listen");
					break;
				case Bluetoothserverclient.STATE_NONE:
					tv1 = (TextView) findViewById(R.id.tvstatus);
					tv1.setText("Disconnected");
					break;
				}
				break;
			}	
			}
	};

	
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId())
		{
			case R.id.button_search:
			{
				final Context context = this;
				
				EditText EDSString = (EditText) findViewById(R.id.search_string);
				
				Search_value = EDSString.getText().toString();
				
				if (Search_value.isEmpty())
				{
					Toast.makeText(this, "Please enter the values to search or scan RF id",
							Toast.LENGTH_LONG).show();
				}
				else{

				Intent intent = new Intent(context, MainActivity.class);
				intent.putExtra("Search Value", Search_value);
				startActivity(intent);
				}
				break;
			}
			case R.id.connect_button:
			{
			openOptionsMenu();
				break;
			}
		}
		
	}
	
	

}


	