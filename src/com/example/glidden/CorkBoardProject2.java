package com.example.glidden;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class CorkBoardProject2 extends Activity {
	private ShareActionProvider myShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cork_board_project2);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("Creative Coarkboard");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new CorkBoardDescFrag();
	    Fragment ShoppingListFragment = new CorkBoardShopFrag();
	    Fragment DirectionsListFragment = new CorkBoardDircFrag();
	    
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
	            Intent intent = new Intent(this, HomeDecor.class);
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
		
		MenuItem item = menu.findItem(R.id.menu_item_share);
	     myShareActionProvider = (ShareActionProvider)item.getActionProvider();
	     myShareActionProvider.setShareHistoryFileName(
	       ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
	     myShareActionProvider.setShareIntent(createShareIntent());
		
		return true;
	}
	
	private Intent createShareIntent() {
		  Intent shareIntent = new Intent(Intent.ACTION_SEND);
		        shareIntent.setType("text/plain");
		        shareIntent.putExtra(Intent.EXTRA_TEXT, "It works!");
		        return shareIntent;
		    }
}
