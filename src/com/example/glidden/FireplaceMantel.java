package com.example.glidden;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

public class FireplaceMantel extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fireplace_mantel);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("Fireplace Mantel");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new FireplaceMantelDescFrag();
	    Fragment ShoppingListFragment = new FireplaceMantelShopFrag();
	    Fragment DirectionsListFragment = new FireplaceMantelDircFrag();
	    
	    tab1.setTabListener(new MyTabsListener(DescriptionFragment));
	    tab2.setTabListener(new MyTabsListener(ShoppingListFragment));
	    tab3.setTabListener(new MyTabsListener(DirectionsListFragment));
	    
	    actionBar.addTab(tab1);
	    actionBar.addTab(tab2);
	    actionBar.addTab(tab3);
	}

	//Navigate up using logo.
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle item selection
			switch (item.getItemId()) 
			{
			case android.R.id.home:
				Intent intent1 = new Intent(this, Traditional.class);
				intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent1);
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}
}
