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

public class CorkBoardProject extends FragmentActivity {

	private ShareActionProvider myShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cork_board_project);
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
		myShareActionProvider.setShareIntent(createShareIntent());
		myShareActionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);

		return true;
	}


	private Intent createShareIntent() {
		
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		String corkBoardShare = "Bland boards make for boring walls." +
				" Bump up your reminder board’s look with a picture frame in your favorite color." +
				"\n" +
				"\nPicture frame"+
				"\nCorkboard (cut to fit your picture frame)"+ "\n1-1.5” brush"+
				"\nStir stick"+"\nGlidden ____ paint" +
				"\n" +
				"\n1. Remove the back cover, glass insert and hardware pieces from the frame."+
				"\n2. Rough the surface of the frame with sandpaper. Remove as much of the original paint/varnish as you can. " +
				"The frame doesn’t have to be completely stripped, but the paint will do better the cleaner the frame is."+ 
				"\n3. Place newspapers or a tarp to create a work surface and place the frame on it. Place the frame front " +
				"side up—the part that will be painted."+ "\n4. Use the stir stick to mix the paint."+ "\n5. Paint an even layer " +
				"over the frame using the brush. Add another coat after the first has completely dried. Reassemble the " +
				"frame around the corkboard rather than the glass insert when the second coat of paint is dry";
		shareIntent.putExtra(Intent.EXTRA_TEXT, corkBoardShare);
		
		return shareIntent;
	}




}
