package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiningRoomChairsDircFrag extends Fragment
{
	private String[] directions_items = {"1. Remove any chair pads or extra cushions. Use the tape " +
			"measure and pencil to line up how far down the chair you want to paint, place painter’s " +
			"tape along this line.", "2. Lay the drop cloth under the chairs, use the sander to dull " +
			"the part of the chairs you want to paint. Place a drop cloth over the seat of the " +
			"chair if you don’t plan to paint it.", "3. Paint above the line of tape. Allow the paint to " +
			"completely dry before removing the tape."};
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dining_room_chairs_dirc_frag, container, false);
		
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
