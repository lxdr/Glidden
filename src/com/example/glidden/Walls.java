package com.example.glidden;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Walls extends Activity {
		//array for title of each project
		protected String[] PROJECT_NAMES = new String[] {"ChevronWallProject2", "AccentWallProject2", "BedPanelProject2", "FireplaceMantel2"};

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_walls);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			
			ActionBar actionBar = getActionBar();
		    actionBar.setDisplayHomeAsUpEnabled(true);
		    setTitle("Walls");
		    
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
	    	item_details.setName("ChevronWall");
	    	item_details.setNameTitle("Chevron Wall");
	    	item_details.setProjectDescription("A new trend in design found on furniture, clothes and purses can...");
	    	item_details.setImageNumber(4);
	    	results.add(item_details);
	    	
	    	item_details = new ItemDetails();
	    	item_details.setName("BoldAccentWall");
	    	item_details.setNameTitle("Bold Accent Wall");
	    	item_details.setProjectDescription("Bring dimension to the room with a bright wall. Use contrasting colors...");
	    	item_details.setImageNumber(7);
	    	results.add(item_details);
	    	
	    	item_details = new ItemDetails();
	    	item_details.setName("BeadedBoardPaneling");
	    	item_details.setNameTitle("Beaded Board Paneling");
	    	item_details.setProjectDescription("Painting these panels can be tricky, but our instructions help you get the most...");
	    	item_details.setImageNumber(9);
	    	results.add(item_details);
	    	
	    	item_details = new ItemDetails();
	    	item_details.setName("FireplaceMantel");
	    	item_details.setNameTitle("Fireplace Mantel");
	    	item_details.setProjectDescription("A fireplace is the focal point for any room, but a dinged up fireplace is an eyesore...");
	    	item_details.setImageNumber(3);
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
