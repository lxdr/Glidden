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
 * This will be a specific project. It will have a picture/video 
 * and a description.
 * @author alexdrawbond
 */
public class Project extends Activity {

	Button button;
	Button button2;
	ImageButton button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    setTitle("ProjectActivity");
	    
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				finish();
				Intent intent = new Intent(v.getContext(), ShoppingActivity.class);
				startActivity(intent);
			}
		});
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				finish();
				Intent intent = new Intent(v.getContext(), PaintingActivity.class);
				startActivity(intent);
			}
		});
		
		button3 = (ImageButton) findViewById(R.id.youTubeButton);
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				finish();
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:v=QkNrSpqUr-E" ));
				startActivity(intent);
			}
		});
	}

	//Navigate up using logo
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            Intent intent = new Intent(this, Category.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	//Load action bar buttons
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_menu, menu);
		return true;
	}
}

	

