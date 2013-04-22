package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FrontDoorDircFrag extends Fragment
{
	private String[] directions_items = {"1. Give the surface a quick wash and rise. Be sure to let it dry completely.",
			"2. Use a few coats of rubber cement to cover the metal hinges. Mask the doorknob, lock and any other hardware.",
			"3. Here is the exciting part. Using a 2-2.5Ó brush begin by painting the frame, work up from the inside bottom, " +
			"across the top and down the other side.", "4. Use a 4Ó brush or foam roller to paint the door."};
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.front_door_dirc_frag, container, false);
		
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
