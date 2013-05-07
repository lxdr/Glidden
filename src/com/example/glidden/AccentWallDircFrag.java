package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AccentWallDircFrag extends Fragment
{
	private String[] directions_items = {"1. Tape off the surrounding walls’ edges as well as any trim and molding you don’t wish to paint.",
			"2. Lay drop cloths over the floor and any furniture you aren’t moving away from the wall.", "3. Start using the brush to create " +
			"a 2-3” border around the edge of the wall.", "4. Paint from ceiling to baseboards in blocks that are roughly 4 x 4 feet, first in " +
			"diagonals or zigzag patterns, then over the patch up and down to even out the paint.", "5. Remove tape after the wall is completely dry."};
	
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.accent_wall_dirc_frag, container, false);
		
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
