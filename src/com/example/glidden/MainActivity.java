package com.example.glidden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * This is the Main activity for the Glidden how-to app. 
 * @author alexdrawbond
 *
 */
public class MainActivity extends Activity {
	Button button1;
	Button button2;
	ImageButton button3;
	private static final String TAG="MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		//declare buttons
		button3 = (ImageButton) findViewById(R.id.imageButton1);
		
    	setTitle("Glidden on the Go");

		//go to Category class when Project1 is clicked
		button3.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Log.e(TAG, "button pressed");
				Intent intent = new Intent(v.getContext(), Category.class);
				startActivity(intent);
			}
		});
	}
}
