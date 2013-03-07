package com.example.glidden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class Camera extends Activity {
	
	Button button;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
	
		button = (Button) findViewById(R.id.button1);
		button1 = (Button) findViewById(R.id.button2);
        
		button.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(v.getContext(), Share.class);
        		startActivity(intent);
        		
        	}
        });
		
		button1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(v.getContext(), MainActivity.class);
        		startActivity(intent);
        		
        	}
        });
	}
}
