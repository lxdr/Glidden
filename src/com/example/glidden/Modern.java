package com.example.glidden;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Modern extends Activity {
	
	//array for title of each project
	protected String[] PROJECT_NAMES = new String[] {"ChevronWallProject", "DiningRoomChairsProject"};
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modern);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    setTitle("Modern");
	    
	    ArrayList<ItemDetails> image_details = GetSearchResults();
        
        final ListView projectNames = (ListView) findViewById(R.id.projects2);
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
	    	item_details.setProjectDescription("A new trend in design found on furniture, clothes and purses can now be found on your walls. Take a weekend to give your room this modern twist.");
	    	item_details.setImageNumber(4);
	    	results.add(item_details);
	    	
	    	item_details = new ItemDetails();
	    	item_details.setName("DiningChairs");
	    	item_details.setNameTitle("Dining Chairs");
	    	item_details.setProjectDescription("Let your dining room dazzle with this makeover for your chairs. Add a pop of color by painting half of the chair.");
	    	item_details.setImageNumber(5);
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
