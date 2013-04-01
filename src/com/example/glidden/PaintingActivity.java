package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PaintingActivity extends Activity {

	private ListView lView;
	private String lv_items[] = { "Android", "iPhone", "BlackBerry", "Galaxy SIII",
			"AndroidPeople", "J2ME", "Listview", "ArrayAdapter", "ListItem",
			"Us", "UK", "India", "Nigeria", "Columbia" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_painting);
		
		ActionBar actionBar = getActionBar();
    	actionBar.setDisplayHomeAsUpEnabled(true);
    	setTitle("PaintingActivity");
    	
    	lView = (ListView) findViewById(R.id.ListView01);
    	//Set option as Multiple Choice. So that user can able to select more the one option from list
    	lView.setAdapter(new ArrayAdapter<String>(this,
    	android.R.layout.simple_list_item_1, lv_items));
    	
	}

	//Navigate up using logo
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		        case android.R.id.home:
		            // app icon in Action Bar clicked; go home
		            Intent intent = new Intent(this, Project.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            startActivity(intent);
		            return true;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}
}

