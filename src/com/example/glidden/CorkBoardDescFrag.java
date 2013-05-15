package com.example.glidden;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;

public class CorkBoardDescFrag extends Fragment
{
	private ShareActionProvider myShareActionProvider;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.cork_board_desc_frag, container, false);
		
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
	     
	}
	
	private Intent createShareIntent() {
		  Intent shareIntent = new Intent(Intent.ACTION_SEND);
		        shareIntent.setType("text/plain");
		        shareIntent.putExtra(Intent.EXTRA_TEXT, "It works in the description frag!");
		        return shareIntent;
		    }*/

}
