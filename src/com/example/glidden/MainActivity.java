package com.example.glidden;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> 4db8ae1b8645214a5764cfb5485c99a32b01084d
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This is the Main activity for the Glidden how-to app. 
 * @author alexdrawbond
 *
 */
public class MainActivity extends Activity {
	Button button1;
	Button button2;
	ImageButton button3;
	private static final String TAG="MainActivity";
	private Spinner spinner;
	//private String[] filter = new String[] {"Theme", "Type"};
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Log.e(TAG, "HERE!!!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	
		spinner = (Spinner) findViewById(R.id.spinner);
		
<<<<<<< HEAD
		/*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.categories_array, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);*/
=======
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.categories_array, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
>>>>>>> 4db8ae1b8645214a5764cfb5485c99a32b01084d
		
		 /** Create an array adapter to populate dropdownlist */
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, filter);
		
        /** Enabling dropdown list navigation for the action bar */
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        
		//declare buttons
		button1 = (Button) findViewById(R.id.button1);
		
		getActionBar().setDisplayShowTitleEnabled(false);
		
		//go to Category class when Project1 is clicked
		button1.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Log.e(TAG, "button pressed");
<<<<<<< HEAD
				Intent intent = new Intent(v.getContext(), Traditional.class);
=======
				Intent intent = new Intent(v.getContext(), Category.class);
>>>>>>> 4db8ae1b8645214a5764cfb5485c99a32b01084d
				startActivity(intent);
			}
		});
		
		/** Defining Navigation listener */
        ActionBar.OnNavigationListener navigationListener = new OnNavigationListener()
        {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "You selected : " , Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        
        /** Setting dropdown items and item navigation listener for the actionbar */
<<<<<<< HEAD
       //getActionBar().setListNavigationCallbacks(adapter, navigationListener);
=======
        getActionBar().setListNavigationCallbacks(adapter, navigationListener);
>>>>>>> 4db8ae1b8645214a5764cfb5485c99a32b01084d
	}
}
