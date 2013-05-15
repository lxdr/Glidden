package com.example.glidden;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

/**
 * This is the Main activity for the Glidden how-to app. 
 * @author alexdrawbond
 *
 */
public class MainActivity extends FragmentActivity {
	String TAG = "Main Activity";
	boolean styles = true, first = true;

	String[] sortingOptions = new String[] {"Decorating Styles", "Project Types"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	

		final String PREFS_NAME = "MyPrefsFile";
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, sortingOptions);

		final ActionBar actionBar = getActionBar();
		/** Enabling dropdown list navigation for the action bar */
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setDisplayShowTitleEnabled(false);

		/** Defining Navigation listener */
		OnNavigationListener navigationListener = new OnNavigationListener()
		{	
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) 
			{	
				final String SPINNER = "SpinnerFile";
				SharedPreferences settings2 = getSharedPreferences(SPINNER, 0);
				
				int spinnerOption = settings2.getInt("spinner", 0);
				boolean sameInstance = settings2.getBoolean("instance",	true);
				
				if (sameInstance)
				{
					Log.e(TAG, Integer.toString(settings2.getInt("spinner", 0)));
					if (spinnerOption == 0)
					{
						FragmentTransaction ft = getFragmentManager().beginTransaction();
						ft.replace(R.id.fragment_placeholder, new CategoryFragment());
						ft.commit(); 
						settings2.edit().putInt("spinner", 1).commit();
					}

					if (spinnerOption == 1)
					{
						FragmentTransaction ft = getFragmentManager().beginTransaction();
						ft.replace(R.id.fragment_placeholder, new TypesFragment());
						ft.commit(); 
						settings2.edit().putInt("spinner", 0).commit();
					}
				}
				
				else
				{
					if (spinnerOption == 0)
					{
						actionBar.setSelectedNavigationItem(0);
						FragmentTransaction ft = getFragmentManager().beginTransaction();
						ft.replace(R.id.fragment_placeholder, new CategoryFragment());
						ft.commit(); 
						settings2.edit().putBoolean("instance", true).commit();
						settings2.edit().putInt("spinner", 1).commit();
					}

					if (spinnerOption == 1)
					{
						actionBar.setSelectedNavigationItem(1);
						FragmentTransaction ft = getFragmentManager().beginTransaction();
						ft.replace(R.id.fragment_placeholder, new TypesFragment());
						ft.commit(); 
						settings2.edit().putBoolean("instance", true).commit();
					}
				}
				return false;
			}

		};

		if (settings.getBoolean("my_first_time", true)) {

			AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

			dlgAlert.setMessage("Select a decorating theme to discover your new project or touch the button above to sort by project types and select the type of project you’re looking for.");
			dlgAlert.setTitle("Glidden.bomb.com");
			dlgAlert.setPositiveButton("OK", null);
			dlgAlert.setCancelable(true);
			dlgAlert.create().show();

			dlgAlert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					//dismiss the dialog  
				}
			});
			// record the fact that the app has been started at least once
			settings.edit().putBoolean("my_first_time", false).commit(); 
		}

		/** Setting dropdown items and item navigation listener for the actionbar */
		actionBar.setListNavigationCallbacks(adapter, navigationListener);
	}
}
