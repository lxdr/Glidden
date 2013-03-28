package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//declare buttons
		button1 = (Button) findViewById(R.id.button1); 
		button2 = (Button) findViewById(R.id.button2);
		button3 = (ImageButton) findViewById(R.id.imageButton1);
		
    	setTitle("Glidden on the Go");

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) 
		{
		case R.id.snap:
			Intent intent1 = new Intent(this, CameraActivity.class);
			intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent1);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
