package com.example.glidden;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ChevronWallProject2 extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chevron_wall_project2);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("Chevron Walls");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new ChevronDescFrag();
	    Fragment ShoppingListFragment = new ChevronShopFrag();
	    Fragment DirectionsListFragment = new ChevronDircFrag();
	    
	    tab1.setTabListener(new MyTabsListener(DescriptionFragment));
	    tab2.setTabListener(new MyTabsListener(ShoppingListFragment));
	    tab3.setTabListener(new MyTabsListener(DirectionsListFragment));
	    
	    actionBar.addTab(tab1);
	    actionBar.addTab(tab2);
	    actionBar.addTab(tab3);
	}

	//Navigate up using logo
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            Intent intent = new Intent(this, Walls.class);
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
