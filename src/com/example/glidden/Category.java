package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * This will have a list of projects within a specific category. 
 * @author alexdrawbond
 */
public class Category extends Activity{

	Button button;
	private static final String TAG="CategoryActivity";
	
	//array for title of each project
	protected String[] PROJECT_NAMES = new String[] {"Project 1", "Project 2",  "Project 3", "Project 4"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traditional);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    setTitle("CategoryActivity");
	    
	    //an adapter that adds the list items in to a listView
	    ArrayAdapter<String> adapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, PROJECT_NAMES);
	   
	    //makes the listView from our layout
	    ListView projectNames = (ListView) findViewById(R.id.projects);
	    
	    //adds adapter
	    projectNames.setAdapter(adapter);
	    
		//button that goes to a particular project
		//button = (Button) findViewById(R.id.button1);
	    
	    //sets the click listener to the adapter and not a button
		projectNames.setOnItemClickListener(new OnItemClickListener() {
			
			/*@Override
			public void onClick(View v){
				finish();
				Intent intent = new Intent(v.getContext(), Project.class);
				startActivity(intent);
			}*/

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
				// TODO Auto-generated method stub
				finish();
				//Intent intent = new Intent(v.getContext(), Project.class);
				//startActivity(intent);
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
			Intent intent1 = new Intent(this, MainActivity.class);
			intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent1);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
