package freelancer.john.rfid.analyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class settings extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		final Context context = this;

		Button save = (Button) findViewById(R.id.save1);
		save.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String Temp = "";

				CheckBox CB1 = (CheckBox) findViewById(R.id.checkBox1);

				if (CB1.isChecked() == false) {
					// EditText1.setVisibility(View.INVISIBLE);
					Temp = Temp + "1";
				}

				CheckBox CB2 = (CheckBox) findViewById(R.id.checkBox2);

				if (CB2.isChecked() == false) {
					// EditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
					Temp = Temp + "2";
				}

				CheckBox CB3 = (CheckBox) findViewById(R.id.checkBox3);
				if (CB3.isChecked() == false) {
					// EditText1.setVisibility(View.INVISIBLE);
					Temp = Temp + "3";
				}

				CheckBox CB4 = (CheckBox) findViewById(R.id.checkBox3);

				if (CB4.isChecked() == false) {
					// EditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
					Temp = Temp + "4";
				}

				CheckBox CB5 = (CheckBox) findViewById(R.id.checkBox5);
				if (CB5.isChecked() == false) {
					// EditText1.setVisibility(View.INVISIBLE);
					Temp = Temp + "5";
				}

				CheckBox CB6 = (CheckBox) findViewById(R.id.checkBox6);

				if (CB6.isChecked() == false) {
					// EditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
					Temp = Temp + "6";
				}

				CheckBox CB7 = (CheckBox) findViewById(R.id.checkBox7);
				if (CB7.isChecked() == false) {
					// EditText1.setVisibility(View.INVISIBLE);
					Temp = Temp + "7";
				}

				CheckBox CB8 = (CheckBox) findViewById(R.id.checkBox8);

				if (CB8.isChecked() == false) {
					// EditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
					Temp = Temp + "8";
				}
				
				CheckBox CB9 = (CheckBox) findViewById(R.id.checkBox9);
				if (CB9.isChecked() == false) {
					// EditText1.setVisibility(View.INVISIBLE);
					Temp = Temp + "9";
				}
				
				CheckBox CB10 = (CheckBox) findViewById(R.id.checkBox10);
				if (CB10.isChecked() == false) {
					// EditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
					Temp = Temp + "10";
				}
				

				File root = new File(Environment.getExternalStorageDirectory()
						+ "/RFAnalyzer/");

				root.mkdir();

				String csvfilestring = Environment
						.getExternalStorageDirectory()
						+ "/RFAnalyzer/settings.csv";

				PrintWriter csvWriter;
				try {
					File file = new File(csvfilestring);
					file.delete();
					if (!file.exists()) {

						file = new File(csvfilestring);
					}
					csvWriter = new PrintWriter(new FileWriter(file, true));

					csvWriter.append(Temp);
					csvWriter.append("\r\n");

					csvWriter.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

				Intent intent = new Intent(context, MainActivity.class);
				intent.putExtra("Settings", Temp);

				startActivity(intent);

			}

		});

	}

}
