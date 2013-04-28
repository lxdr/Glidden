package com.example.glidden;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * This is the Main activity for the Glidden how-to app. 
 * @author alexdrawbond
 *
 */
public class MainActivity extends FragmentActivity {
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	String TAG = "Main Activity";
	boolean styles = true, first = true;

	String[] sortingOptions = new String[] {"Decorating Styles", "Project Types"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, sortingOptions);

		ActionBar actionBar = getActionBar();
		/** Enabling dropdown list navigation for the action bar */
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setDisplayShowTitleEnabled(false);

		/** Defining Navigation listener */
		OnNavigationListener navigationListener = new OnNavigationListener()
		{
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) 
			{	
				if (itemPosition == 0)
				{
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.fragment_placeholder, new CategoryFragment());
					ft.commit(); 
				}

				if (itemPosition == 1)
				{
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.fragment_placeholder, new TypesFragment());
					ft.commit(); 
				}
				return false;
			}
		};

		/** Setting dropdown items and item navigation listener for the actionbar */
		actionBar.setListNavigationCallbacks(adapter, navigationListener);
	}
}
