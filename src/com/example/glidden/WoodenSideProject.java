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
//import android.util.Log;

/**
 * This will be a specific project. It will have a picture/video 
 * and a description.
 * @author alexdrawbond
 */
public class WoodenSideProject extends FragmentActivity {
	
	private ShareActionProvider myShareActionProvider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sidetable_project);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("WoodenSideProject");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new SideTableDescFrag();
	    Fragment ShoppingListFragment = new SideTableShopFrag();
	    Fragment DirectionsListFragment = new SideTableDircFrag();
	    
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
	            Intent intent = new Intent(this, Traditional.class);
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
		String sideTableShare = "Spruce up an old side table with this quick and easy how-to. " +
				"Take a weekend to bring a new centerpiece to your room. " +
				"Perfect for first time painters these steps include tips and tricks to help you freshen up your space.  "+
				"\n"+
				"\nSander or paint stripper"+
				"\nDropcloth"+
				"\nRags"+ 
				"\nPainters tape"+ 
				"\n2-2.5” brush"+
				"\nGlidden ____ paint (amounts vary by size)"+
				"\n"+
				"\n1. Follow the directions on the paint stripper, or use a sander " +
				"to strip old paint and finishes off of the table. If using the sander, wipe the table down with a damp rag after."+
				"\n2. Cover any hinges and handles you don’t wish to paint with painter’s tape."+ "\n3. Paint an even layer over the table " +
				"using the brush. Add additional coats to reach desired color, allowing time to dry between each coat. " + "\n4. Remove tape " +
				"after the final coat is dry.";
		shareIntent.putExtra(Intent.EXTRA_TEXT, sideTableShare);

		return shareIntent;
	}
}
