package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
public class Traditional extends Activity{

	Button button;
	private static final String TAG="CategoryActivity";
	
	//array for title of each project
	protected String[] PROJECT_NAMES = new String[] {"WoodenSideProject", "FireplaceMantel","PaintingActivity"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    setTitle("Traditional");
	    
	    Log.e(TAG, "HERE!!!");
	    //setListAdapter(new TraditionalListAdapter(this, PROJECT_NAMES));
	    
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
	
	private void setListAdapter(TraditionalListAdapter traditionalListAdapter) {
		// TODO Auto-generated method stub
		
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
