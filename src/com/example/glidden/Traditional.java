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
import android.widget.Button;
import android.widget.ListView;

/**
 * This will have a list of projects within a specific category. 
 * @author alexdrawbond
 */
public class Traditional extends Activity{

	Button button;
	private static final String TAG="CategoryActivity";
	
	//array for title of each project
	protected String[] PROJECT_NAMES = new String[] {"WoodenSideProject", "FireplaceMantel"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traditional);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    setTitle("Traditional");
	    
	    //Log.e(TAG, "HERE!!!");
	    
	    //an adapter that adds the list items in to a listView
	    //ArrayAdapter<String> adapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, PROJECT_NAMES);
	    //makes the listView from our layout
	    //ListView projectNames = (ListView) findViewById(R.id.projects);
	    //adds adapter
	    //projectNames.setAdapter(adapter);
	    
	    ArrayList<ItemDetails> image_details = GetSearchResults();
        
        final ListView projectNames = (ListView) findViewById(R.id.projects);
        projectNames.setAdapter(new ItemListBaseAdapter(this, image_details));
	    
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
    	item_details.setName("WoodenSideProject");
    	item_details.setProjectDescription("gobbly gook, blahh blah blahh lol rotflol omg nonsenese nonsens oh yea. YOLO!");
    	item_details.setImageNumber(1);
    	results.add(item_details);
    	
    	item_details = new ItemDetails();
    	item_details.setName("FireplaceMantel");
    	item_details.setProjectDescription("gobbly gook, blahh blah blahh lol rotflol omg nonsenese nonsens oh yea. YOLO!");
    	item_details.setImageNumber(2);
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
