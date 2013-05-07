package com.example.glidden;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Video extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		Button buttonYT = (Button) findViewById(R.id.button1);
		buttonYT.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				startActivity(new Intent(
						Intent.ACTION_VIEW, 
                        Uri.parse("http://www.youtube.com/watch?v=jOLBBrJ52mo")));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
		return true;
	}
	
	//Navigate up using logo
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		        case android.R.id.home:
		            Intent intent = new Intent(this, HomeDecor.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            startActivity(intent);
		            return true;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}
}
