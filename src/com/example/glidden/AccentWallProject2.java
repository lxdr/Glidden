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

public class AccentWallProject2 extends FragmentActivity {

	private ShareActionProvider myShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accent_wall_project2);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		setTitle("Bold Accent Wall");

		ActionBar.Tab tab1 = actionBar.newTab().setText("Description");
		ActionBar.Tab tab2 = actionBar.newTab().setText("Shopping List");
		ActionBar.Tab tab3 = actionBar.newTab().setText("Instructions");

		Fragment DescriptionFragment = new AccentWallDescFrag();
		Fragment ShoppingListFragment = new AccentWallShopFrag();
		Fragment DirectionsListFragment = new AccentWallDircFrag();

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
		String accentWallShare = "Bring dimension to the room with a bright wall. " +
				"Use contrasting colors or just go deeper, darker and brighter to make your room new again. " +
				"Re-doing one wall can recreate your entire room with these simple steps."+
				"\n"+
				"\nDrop cloth"+ "\n2-3” brush"+ "\nRoller with extension handle"+ "\nPaint tray"+ "\nPainter’s tape"+
				"\nGliddenTM paint — Color: We used Pink Salmon! Type: Glidden® High EnduranceTM Plus, Glidden® " +
				"High EnduranceTM, or Glidden® High EnduranceTMGrab-N-Go" +
				"\n"+
				"\n1. Tape off the surrounding walls’ edges as well as any trim and molding you don’t wish to paint."+
				"\n2. Lay drop cloths over the floor and any furniture you aren’t moving away from the wall."+ 
				"\n3. Start using the brush to create a 2-3” border around the edge of the wall."+ 
				"\n4. Paint from ceiling to baseboards in blocks that are roughly 4 x 4 feet, first in " +
				"diagonals or zigzag patterns, then over the patch up and down to even out the paint."+ 
				"\n5. Remove tape after the wall is completely dry.";
		shareIntent.putExtra(Intent.EXTRA_TEXT, accentWallShare);

		return shareIntent;
	}

}
