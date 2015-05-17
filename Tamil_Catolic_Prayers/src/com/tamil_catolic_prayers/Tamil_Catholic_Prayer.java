package com.tamil_catolic_prayers;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class Tamil_Catholic_Prayer extends Activity {
	
	TextView text; // initialize to your textview

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF"); 
        
        text = (TextView)findViewById(R.id.pothu_prayer);
    	text.setTypeface(tf);
    	text.setTextSize(20); 
    	text.setText("n[gq;fs");
    	
    	text = (TextView)findViewById(R.id.rosary);
    	text.setTypeface(tf);
    	text.setTextSize(20); 
    	text.setText("nrgkhiy");
    	
    	
        
    	
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
