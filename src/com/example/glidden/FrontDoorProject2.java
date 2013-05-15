package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class FrontDoorProject2 extends Activity {
	
	private ShareActionProvider myShareActionProvider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front_door_project2);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("Re-Do Your Door");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new FrontDoorDescFrag();
	    Fragment ShoppingListFragment = new FrontDoorShopFrag();
	    Fragment DirectionsListFragment = new FrontDoorDircFrag();
	    
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
	            Intent intent = new Intent(this, Outdoor.class);
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
		String frontDoorShare = "There's nothing like a good first impression. " +
				"Paint your door a bright color to bring a pop to any home. " +
				"Take an afternoon and give the front of your house a facelift."+
				"\n"+
				"\nRubber cement"+
				"\n2-2.5Ó brush"+
				"\n4Ó brush or foam roller"+
				"\nGlidden Red Delicious Paint GLR30 (amounts vary by door size)"+
				"\n"+
				"\n1. Give the surface a quick wash and rise. Be sure to let it dry completely."+
				"\n2. Use a few coats of rubber cement to cover the metal hinges. Mask the doorknob, lock and any other hardware."+
				"\n3. Here is the exciting part. Using a 2-2.5Ó brush begin by painting the frame, work up from the inside bottom, " +
				"across the top and down the other side."+ "\n4. Use a 4Ó brush or foam roller to paint the door.";
		shareIntent.putExtra(Intent.EXTRA_TEXT, frontDoorShare);

		return shareIntent;
	}
}
