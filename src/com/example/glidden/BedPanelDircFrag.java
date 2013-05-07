package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BedPanelDircFrag extends Fragment 
{
	private String[] directions_items = {"1. Clean and dry the paneling to ensure the paint can adhere to the paneling properly.",
										"2. Apply painter’s tape to the edges surrounding the paneling. Don’t cover the edge of the " +
										"trim if you want to paint it the same color as the paneling.", "3. Paint the grooves with the " +
										"chip brush in a 2-foot-wide section.", "4. Paint the beadboard paneling with the foam roller.", 
										"5. If you didn’t tape it off, paint the trim.", "6. Repeat steps 3-5 until the paneling is completely " +
										"painted.", "7. Once the paint is completely dry, remove the tape.", "8. If you wanted the trim to be a " +
										"different color, tape above and below the trim.", "9. Paint the trim using a foam roller. Remove the tape after " +
										"the paint is dry."};
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bed_panel_dirc_frag, container, false);
		
		createListView(view);
		
        // Inflate the layout for this fragment
        return view;
    }
	
	private void createListView(View view)
	{
		lView1 = (ListView) view.findViewById(R.id.directions_list_view);
		
    	lView1.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, directions_items));
	}
}
