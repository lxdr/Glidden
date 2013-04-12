package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DirectionsFragment extends Fragment
{
	public static String TAG="DirectionsFragment";
	private String[] directions_items = {"1. Follow the directions on the paint stripper, or use a sander " +
			"to strip old paint and finishes off of the table. If using the sander, wipe the table down with a damp rag after.",
			"2. Cover any hinges and handles you don’t wish to paint with painter’s tape.", "3. Paint an even layer over the table " +
			"using the brush. Add additional coats to reach desired color, allowing time to dry between each coat. ", "4. Remove tape " +
			"after the final coat is dry."};
	ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_directions_fragment, container, false);
		createListView(view);
        // Inflate the layout for this fragment
        return view;
    }
	
	private void createListView(View view)
	{
		lView1 = (ListView) view.findViewById(R.id.Lv1);
    	//Set option as Multiple Choice. So that user can able to select more the one option from list
    	lView1.setAdapter(new ArrayAdapter<String>(getActivity(),
    	android.R.layout.simple_list_item_1, directions_items));
    	Log.e(TAG, "Here!!!");
	}
}
