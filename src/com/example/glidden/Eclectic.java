package com.example.glidden;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Eclectic extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eclectic);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eclectic, menu);
		return true;
	}

}
