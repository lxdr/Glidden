package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChevronDircFrag extends Fragment 
{
	private String[] directions_items = {"1. Paint your wall with your desired main color," +
			" we used (insert Glidden color name). Allow to dry overnight.", "2. Use a pencil to" +
			" mark every 10 inches along the width of the wall beginning at the baseboard.", "3. " +
			"From each of those points, measure 6 inches vertically and mark with a pencil. Repeat " +
			"the pencil marks up to the ceiling.", "4. Connect the dots using painter's tape to alternating " +
			"rows to create peaks and valleys. Trim the tape with a crafts knife to get a perfect point. ",
			"5. Between the rows of painter’s tape, paint the colors of your choice. Let paint dry, then peal " +
			"the tape to reveal your new wall. "};
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.chevron_dirc_frag, container, false);
		
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
