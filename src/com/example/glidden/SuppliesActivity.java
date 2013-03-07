package com.example.glidden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SuppliesActivity extends Activity {
	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_supplies);
		
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener()
		{
	      	@Override
	      	public void onClick(View v)
	      	{
	      		finish(); 
	      		
	      		Intent intent = new Intent(v.getContext(), ShoppingActivity.class);
	      		startActivity(intent);
	        }
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_supplies, menu);
		return true;
	}

}
