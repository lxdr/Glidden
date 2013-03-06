package com.example.glidden;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This is the Main activity for the Glidden how-to app. 
 * @author alexdrawbond
 *
 */
public class MainActivity extends Activity {
	Button button1;
	Button button2;
	Button button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//declare buttons
		button1 = (Button) findViewById(R.id.button1); 
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.imageButton1);
		
		//go to Camera class when Camera is clicked
        button1.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(v.getContext(), Camera.class);
        		startActivity(intent);
        	}
        });
        
        //go to ShoppingList class when Shopping List is clicked
        button2.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(v.getContext(), ShoppingList.class);
        		startActivity(intent);
        	}
        });
       
        //go to Category class when Project1 is clicked
        button3.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(v.getContext(), Category.class);
        		startActivity(intent);
        	}
        });
	}

}
