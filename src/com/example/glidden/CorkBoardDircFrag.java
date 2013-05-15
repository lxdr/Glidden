package com.example.glidden;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class CorkBoardDircFrag extends Fragment 
{
	private ShareActionProvider myShareActionProvider;
	
	private String[] directions_items = {"1. Remove the back cover, glass insert and hardware pieces from the frame.", 
			"2. Rough the surface of the frame with sandpaper. Remove as much of the original paint/varnish as you can. " +
			"The frame doesn’t have to be completely stripped, but the paint will do better the cleaner the frame is.", 
			"3. Place newspapers or a tarp to create a work surface and place the frame on it. Place the frame front " +
			"side up—the part that will be painted.", "4. Use the stir stick to mix the paint.", "5. Paint an even layer " +
			"over the frame using the brush. Add another coat after the first has completely dried. Reassemble the " +
			"frame around the corkboard rather than the glass insert when the second coat of paint is dry"};
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cork_board_dirc_frag, container, false);
		
		createListView(view);
		
        // Inflate the layout for this fragment
        return view;
    }
	
	/*@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    super.onPrepareOptionsMenu(menu);
		
	    MenuItem item = menu.findItem(R.id.menu_item_share);
	     myShareActionProvider = (ShareActionProvider)item.getActionProvider();
	     myShareActionProvider.setShareHistoryFileName(
	       ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
	     myShareActionProvider.setShareIntent(createShareIntent());
	     
	}*/
	
	private void createListView(View view)
	{
		lView1 = (ListView) view.findViewById(R.id.directions_list_view);
		
    	lView1.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, directions_items));
	}
	
	/*private Intent createShareIntent() {
		  Intent shareIntent = new Intent(Intent.ACTION_SEND);
		        shareIntent.setType("text/plain");
		        shareIntent.putExtra(Intent.EXTRA_TEXT, "It works in the direction frag!");
		        return shareIntent;
		    }*/

}
