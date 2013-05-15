package com.example.glidden;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class FireplaceMantel extends FragmentActivity {
	
	private ShareActionProvider myShareActionProvider;
	
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
			String firePlaceMantelShare = "A fireplace is the focal point for any room, but a dinged up fireplace is an eyesore. " +
					"Fix up your fireplace with our helpful directions. " +
					"You can delight in a fireplace painted in a color that accentuates your room. "+
					"\n"+
					"\nPaint remover"+ 
					"\nPutty knife"+ 
					"\nWood filler"+ 
					"\n100-grit sandpaper"+
					"\nPainter’s tape"+
					"\n3” brush"+
					"\nDrop cloth"+
					"\nWork gloves"+
					"\nGliddenTM paint — Color: We used Dove White! Type: Glidden® High EnduranceTM, or Glidden® High EnduranceTM Grab-N-Go" +
					"\n"+
					"\n1. Remove all furniture and possessions away from the fireplace and lay " +
					"a drop cloth on the floor."+ "\n2. Wearing your work gloves, apply the paint remover, following the " +
					"directions on the container. Scrape any excess paint off with the putty knife."+ "\n3. After the mantel " +
					"dries fill in any cracks with the wood filler and putty knife."+ "\n4. Use the sandpaper to butt out smaller " +
					"scratches and smooth the dried wood filler."+ "\n5. Tape around the edges of the mantle."+ "\n6. Paint the mantel " +
					"and allow it to dry 2-3 hours before touching up or removing the tape. Wait at least 24 hours after this to place " +
					"belongings on the mantle again to ensure the paint isn’t still tacky.";
			shareIntent.putExtra(Intent.EXTRA_TEXT, firePlaceMantelShare);

			return shareIntent;
		}
		
}
