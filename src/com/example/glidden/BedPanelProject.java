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

public class BedPanelProject extends FragmentActivity {
	
	private ShareActionProvider myShareActionProvider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bed_panel_project);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    setTitle("Bedboard Paneling");
    	
	    ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
	    ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
	    ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");
	  
	    Fragment DescriptionFragment = new BedPanelDescFrag();
	    Fragment ShoppingListFragment = new BedPanelShopFrag();
	    Fragment DirectionsListFragment = new BedPanelDircFrag();
	    
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
		            Intent intent = new Intent(this, Cottage.class);
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
			String bedPanelShare = "Painting these panels can be tricky, but our instructions help you get the most out of these accents. " +
					"Color match or accentuate to make these parts of your wall pop. " +
					"Done right the texture of beadboard panels makes for a fun accent to a room."+
					"\n"+
					"\nPainter’s tape"+
					"\n2-3” chip brush"+
					"\nFoam roller"+
					"\nGliddenTM paint — Color: We used Lavender Cloud and Antique Purple! Type: Glidden® High EnduranceTM Plus, Glidden® High EnduranceTM, or Glidden® High EnduranceTM Grab-N-Go" +
					"\n"+
					"\n1. Clean and dry the paneling to ensure the paint can adhere to the paneling properly."+
					"\n2. Apply painter’s tape to the edges surrounding the paneling. Don’t cover the edge of the trim if you want to paint it the same color as the paneling." +
					"\n3. Paint the grooves with the chip brush in a 2-foot-wide section."+
					"\n4. Paint the beadboard paneling with the foam roller."+
					"\n5. If you didn’t tape it off, paint the trim."+
					"\n6. Repeat steps 3-5 until the paneling is completely painted." +
					"\n7. Once the paint is completely dry, remove the tape." +
					"\n8. If you wanted the trim to be a different color, tape above and below the trim."+
					"\n9. Paint the trim using a foam roller. Remove the tape after the paint is dry.";
			shareIntent.putExtra(Intent.EXTRA_TEXT, bedPanelShare);

			return shareIntent;
		}
}
