package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This will be a shopping list for the supplies to 
 * complete a project. 
 * 
 * @author alexdrawbond
 *
 */
public class SuppliesActivity extends Activity {
	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_supplies);
		
		ActionBar actionBar = getActionBar();   	
    	actionBar.setDisplayHomeAsUpEnabled(true);
    	
		button = (Button) findViewById(R.id.button1);
		
		//back button to ShoppingActivity
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
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in Action Bar clicked; go home
	            Intent intent = new Intent(this, ShoppingActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}

