package com.example.glidden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class ShoppingActivity extends Activity {
	Button button1;
	ImageButton button2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping);
		
		//declare buttons
		button1 = (Button) findViewById(R.id.button1); 
		button2 = (ImageButton) findViewById(R.id.image_button);
		
		//go to Camera class when Camera is clicked
        button1.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		finish(); 
        		
        		Intent intent = new Intent(v.getContext(), MainActivity.class);
        		startActivity(intent);
        	}
        });
        
      //go to Camera class when Camera is clicked
        button2.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		finish();
        		
        		Intent intent = new Intent(v.getContext(), SuppliesActivity.class);
        		startActivity(intent);
        	}
        });
	}

	

}
