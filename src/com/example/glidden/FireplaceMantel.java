package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FireplaceMantel extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fireplace_mantel);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    setTitle("Fireplace Mantel");
		
		Button buttonYT = (Button) findViewById(R.id.button1);
		buttonYT.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				startActivity(new Intent(
						Intent.ACTION_VIEW, 
                        Uri.parse("http://www.youtube.com/watch?v=vSYadh2xmcI")));
			}
		});
	}

	//Navigate up using logo.
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle item selection
			switch (item.getItemId()) 
			{
			case android.R.id.home:
				Intent intent1 = new Intent(this, Traditional.class);
				intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent1);
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}


}
