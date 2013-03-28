package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * This is the ShoppingActivity class. It will contain a list of
 * projects to be completed with links to shopping lists for their
 * supplies.
 * 
 * @author alexdrawbond
 *
 */
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
		
		ActionBar actionBar = getActionBar();
    	actionBar.setDisplayHomeAsUpEnabled(true);
    	
      //go to the supplies list when project is clicked
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in Action Bar clicked; go home
	            Intent intent = new Intent(this, MainActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}

