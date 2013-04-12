package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShoppingFragment extends Fragment
{
	public static String TAG = "Shopping Fragment";
	
	private String[] shopping_items = {"Sander or paint stripper", "Dropcloth", 
			"Rags", "Painters tape", "2-2.5Ó brush", "Glidden ____ paint (amounts vary by size)" };
	private ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_shopping_fragment, container, false);
		createListView(view);
        // Inflate the layout for this fragment
        return view;
    }
	
	private void createListView(View view)
	{
		lView1 = (ListView) view.findViewById(R.id.Lv02);
    	lView1.setAdapter(new ArrayAdapter<String>(getActivity(),
    	android.R.layout.simple_list_item_multiple_choice, shopping_items));
    	lView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	Log.e(TAG, "HERE!!!!");
	}
}
