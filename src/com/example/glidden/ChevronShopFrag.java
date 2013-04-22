package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChevronShopFrag extends Fragment 
{
	private String[] shopping_items = {"Painters tape", "Pencil", "Tape measure", 
			"Crafts knife", "Glidden ______ (amounts vary by wall size)"  };
	
	private ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.chevron_shop_frag, container, false);
		
		createListView(view);
		
        // Inflate the layout for this fragment
        return view;
    }
	
	private void createListView(View view)
	{
		lView1 = (ListView) view.findViewById(R.id.shopping_list_view);
		
    	lView1.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, shopping_items));
    	
    	lView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
}
