package stMarys.qrcodescanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button Start = (Button) findViewById(R.id.button1);

		Start.setOnClickListener((OnClickListener) this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		this.scanSomething();
	}

	public void scanSomething() {
		// I need things done! Do I have any volunteers?
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		// This flag clears the called app from the activity stack, so users
		// arrive in the expected
		// place next time this application is restarted.
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 0);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				// Handle successful scan
				// The Intents Fairy has delivered us some data!
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

				Toast.makeText(this, "Got the reslt John", Toast.LENGTH_LONG)
						.show();

				//to send email
				
				/*Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL,
						new String[] { "mariajohnpaul@gmail.com" });
				i.putExtra(Intent.EXTRA_SUBJECT, "QR SCAN RESULT");
				i.putExtra(Intent.EXTRA_TEXT, "JOHN QR APP "+contents+ "\nType: "+format);
				try {
					startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(this,
							"There are no email clients installed.",
							Toast.LENGTH_SHORT).show();
				}*/
				
				//Write on the External Storage
				
				File root = Environment.getExternalStorageDirectory();
				
				File john = new File(root,"John.txt"); 
				
				FileOutputStream fo = null;
				try {
					fo = new FileOutputStream(john);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//converting String to Byte
				byte[] jp= new byte[50];
				try {
					jp = contents.getBytes("UTF-16LE");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//writing to the file
				try {
					fo.write(jp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//Just to check read from File
				FileInputStream Fi = null;
				try {
					Fi = new FileInputStream(john);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				byte []input= new byte[250];
				try {
					Fi.read(input);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//String inString = input.toString(); Byte string can not be reading form
				
				String inString = new String(input);
				
				Toast.makeText(this, "I am able to read=  "+inString, Toast.LENGTH_LONG).show(); 
				
				
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		}
	}

}
