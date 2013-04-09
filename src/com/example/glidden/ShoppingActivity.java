package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * This is the ShoppingActivity class. It will contain a list of
 * supplies that need to be bought for a project. 
 * 
 * @author alexdrawbond
 */
public class ShoppingActivity extends Activity {
	Button button1;
	ImageButton button2;
	private ListView lView;
	private String lv_items[] = { "Android", "iPhone", "BlackBerry", "Galaxy SIII",
			"AndroidPeople", "J2ME", "Listview", "ArrayAdapter", "ListItem",
			"Us", "UK", "India", "Nigeria", "Columbia" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping);
		
		ActionBar actionBar = getActionBar();
    	actionBar.setDisplayHomeAsUpEnabled(true);
    	setTitle("ShoppingActivity");
    	
    	lView = (ListView) findViewById(R.id.ListView01);
    	//Set option as Multiple Choice. So that user can able to select more the one option from list
    	lView.setAdapter(new ArrayAdapter<String>(this,
    	android.R.layout.simple_list_item_multiple_choice, lv_items));
    	lView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
	
	//Navigate up using logo
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in Action Bar clicked; go home
	            Intent intent = new Intent(this, WoodenSideProject.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	//Load action buttons
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_menu, menu);
		return true;
	}
}

