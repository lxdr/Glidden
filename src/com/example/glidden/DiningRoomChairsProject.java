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

public class DiningRoomChairsProject extends FragmentActivity 
{
	
	private ShareActionProvider myShareActionProvider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dining_room_chairs_project);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("Dining Room Chairs");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new DiningRoomChairDescFrag();
	    Fragment ShoppingListFragment = new DiningRoomChairsShopFrag();
	    Fragment DirectionsListFragment = new DiningRoomChairsDircFrag();
	    
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
	            Intent intent = new Intent(this, Modern.class);
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
		String diningRoomChairShare = "Let your dining room dazzle with this makeover for your chairs. " +
				"Add a pop of color by painting half of the chair."+
				"\n"+
				"\nMedium grade sander"+
				"\n3” brush"+ 
				"\nDropcloth"+ 
				"\nPainter’s tape"+
				"\nMeasuring tape"+ 
				"\nPencil"+
				"\nGliddenTM paint — Color: We used white! Type: Glidden® Brilliance Collection®"+
				"\n2N1TM Paint+Primer, or Glidden® High EnduranceTM Grab-N-Go" +
				"\n"+
				"\n1. Remove any chair pads or extra cushions. Use the tape " +
				"measure and pencil to line up how far down the chair you want to paint, place painter’s " +
				"tape along this line."+ "\n2. Lay the drop cloth under the chairs, use the sander to dull " +
				"the part of the chairs you want to paint. Place a drop cloth over the seat of the " +
				"chair if you don’t plan to paint it."+ "\n3. Paint above the line of tape. Allow the paint to " +
				"completely dry before removing the tape.";
		shareIntent.putExtra(Intent.EXTRA_TEXT, diningRoomChairShare);

		return shareIntent;
	}
	
}
