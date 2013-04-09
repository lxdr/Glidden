package com.example.glidden;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PaintingActivity extends Activity {

	private ListView lView;
	private String lv_items[] = {"1. Remove the back cover, glass insert and hardware pieces from the frame.",
								"2. Rough the surface of the frame with sandpaper. Remove as much of the original " +
								"paint/varnish as you can. The frame doesn’t have to be completely stripped, but " +
								"the paint will do better the cleaner the frame is.", "3. Place newspapers or a tarp " +
								"to create a work surface and place the frame on it. Place the frame front side up—the" +
								" part that will be painted.", "4. Use the stir stick to mix the paint.", "5. Paint an even " +
								"layer over the frame using the brush. Add another coat after the first has completely dried. " +
								"Reassemble the frame around the corkboard rather than the glass  insert when the second coat of paint is dry."};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_painting);
		
		ActionBar actionBar = getActionBar();
    	actionBar.setDisplayHomeAsUpEnabled(true);
    	setTitle("PaintingActivity");
    	
    	lView = (ListView) findViewById(R.id.ListView01);
    	//Set option as Multiple Choice. So that user can able to select more the one option from list
    	lView.setAdapter(new ArrayAdapter<String>(this,
    	android.R.layout.simple_list_item_1, lv_items));
    	
	}

	//Navigate up using logo
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		        case android.R.id.home:
		            // app icon in Action Bar clicked; go home
		            Intent intent = new Intent(this, WoodenSideProject.class);
		            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            startActivity(intent);
		            return true;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}
}

