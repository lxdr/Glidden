package com.example.glidden;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HomeDecor extends Activity {
			//array for title of each project
			protected String[] PROJECT_NAMES = new String[] {"CorkBoardProject2"};

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_home_decor);
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				
				ActionBar actionBar = getActionBar();
			    actionBar.setDisplayHomeAsUpEnabled(true);
			    setTitle("Home Decor");
			    
			    ArrayList<ItemDetails> image_details = GetSearchResults();
		        
		        final ListView projectNames = (ListView) findViewById(R.id.projects4);
		        projectNames.setAdapter(new ItemListBaseAdapter(this, image_details));
			   
		        
			    //sets the click listener to the adapter and not a button
				projectNames.setOnItemClickListener(new OnItemClickListener() {
				
					@Override
					public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
						// TODO Auto-generated method stub
						String openClass = PROJECT_NAMES[position];
						try{
							Class selected = Class.forName("com.example.glidden." + openClass);
							Intent intent = new Intent(v.getContext(), selected);
							startActivity(intent);
						}catch (ClassNotFoundException e){
							e.printStackTrace();
						}
					}
				});
			}

			//puts items inside of the list view
			private ArrayList<ItemDetails> GetSearchResults(){
		    	ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();
		    	
		    	ItemDetails item_details = new ItemDetails();
		    	item_details.setName("CorkboardFrame");
		    	item_details.setNameTitle("Corkboard Frame");
		    	item_details.setProjectDescription("Bland boards make for boring walls. Bump up your reminder board�s...");
		    	item_details.setImageNumber(8);
		    	results.add(item_details);
		    	
		    	return results;
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
