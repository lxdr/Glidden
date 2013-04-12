package com.example.glidden;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/**
 * This will be a specific project. It will have a picture/video 
 * and a description.
 * @author alexdrawbond
 */
public class WoodenSideProject extends FragmentActivity {
	public static Context appContext;
	public static String TAG="WoodenSideTable";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("WoodenSideProject");
		
	    Log.e(TAG, "Here!!!");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Directions");
	  
	    Fragment DescriptionFragment = new DescriptionFragment();
	    Fragment ShoppingListFragment = new ShoppingFragment();
	    Fragment DirectionsListFragment = new DirectionsFragment();
	    
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
	            Intent intent = new Intent(this, Category.class);
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

class MyTabsListener implements ActionBar.TabListener {
	public Fragment fragment;
	//public ListFragment listFrag;
	public static String TAG="MyTabsListener";
	
	public MyTabsListener(Fragment fragment) {
		this.fragment = fragment;
	}

	//public MyTabsListener(ListFragment listFrag) {
		//this.listFrag = listFrag;
	//}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.e(TAG, "RESELECTED");
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		ft.replace(R.id.fragment_placeholder, fragment);
		Log.e(TAG, "SELECTED");
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		Log.e(TAG, "UNSELECTED");
		ft.remove(fragment);
	}
}
	

