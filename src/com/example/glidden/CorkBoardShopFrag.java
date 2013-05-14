package com.example.glidden;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class CorkBoardShopFrag extends Fragment 
{
	private ShareActionProvider myShareActionProvider;
	
	private String[] shopping_items = {"Picture frame", "Corkboard (cut to fit your picture frame)", "1-1.5Ó brush", 
			"Glidden¨ High EnduranceTM Grab-N-Go in White Sage"};
	
	private ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cork_board_shop_frag, container, false);
		
		/*
	    // Get the menu item.
	    MenuItem menuItem = menu.findItem(R.id.menu_item_share);
	    // Get the provider and hold onto it to set/change the share intent.
	    myShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();

	    // Attach an intent to this ShareActionProvider.  You can update this at any time,
	    // like when the user selects a new piece of data they might like to share.
	    myShareActionProvider.setShareIntent(createShareIntent());

	    // This line chooses a custom shared history xml file. Omit the line if using
	    // the default share history file is desired.
	    myShareActionProvider.setShareHistoryFileName("custom_share_history.xml");
		*/
		
		createListView(view);
		
        // Inflate the layout for this fragment
        return view;
    }
	
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    super.onPrepareOptionsMenu(menu);
		
	    /*MenuItem item = menu.findItem(R.id.menu_item_share);
	     myShareActionProvider = (ShareActionProvider)item.getActionProvider();
	     myShareActionProvider.setShareHistoryFileName(
	       ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
	     myShareActionProvider.setShareIntent(createShareIntent());
	     */
	    

	}
	
	private void createListView(View view)
	{
		lView1 = (ListView) view.findViewById(R.id.shopping_list_view);
		
    	lView1.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, shopping_items));
    	
    	lView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
	
	private Intent createShareIntent() {
		  Intent shareIntent = new Intent(Intent.ACTION_SEND);
		        shareIntent.setType("text/plain");
		        shareIntent.putExtra(Intent.EXTRA_TEXT, "It works!");
		        return shareIntent;
		    }
}
