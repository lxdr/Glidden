package com.example.glidden;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Cottage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cottage);
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cottage, menu);
		return true;
	}

}
