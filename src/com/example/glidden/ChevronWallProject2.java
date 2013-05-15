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
import android.widget.ShareActionProvider;

public class ChevronWallProject2 extends FragmentActivity {
	
	private ShareActionProvider myShareActionProvider;
	
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
		String chevronWallShare = "A new trend in design found on furniture, clothes and purses can now be found on your walls. " +
				"Take a weekend to give your room this modern twist." +
				" This pattern looks complicated but is made easy with these directions."+
				"\n"+
				"\nPainters tape"+
				"\nPencil"+
				"\nTape measure" +
				"\nCrafts knife"+
				"\nGlidden ______ (amounts vary by wall size)" +
				"\n"+
				"\n1. Paint your wall with your desired main color, we used (insert Glidden color name). Allow to dry overnight."+
				"\n2. Use a pencil to mark every 10 inches along the width of the wall beginning at the baseboard."+
				"\n3. From each of those points, measure 6 inches vertically and mark with a pencil. Repeat the pencil marks up to the ceiling."+
				"\n4. Connect the dots using painter's tape to alternating rows to create peaks and valleys. Trim the tape with a crafts knife to get a perfect point. "+
				"\n5. Between the rows of painter’s tape, paint the colors of your choice. Let paint dry, then peal the tape to reveal your new wall. ";
		shareIntent.putExtra(Intent.EXTRA_TEXT, chevronWallShare);

		return shareIntent;
	}
	
}
