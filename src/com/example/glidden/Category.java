package com.example.glidden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Category extends Activity {

	Button button;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		//button that pops screen and goes to home page
		button = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				finish(); 
        		
        		Intent intent = new Intent(v.getContext(), MainActivity.class);
        		startActivity(intent);
	}
		});
		
		//button that goes to a particular project
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(), Project.class);
				startActivity(intent);
			}
		});
	}

}
