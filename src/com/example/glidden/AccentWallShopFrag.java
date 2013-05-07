package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AccentWallShopFrag extends Fragment 
{
	private String[] shopping_items = {"Drop cloth", "2-3” brush", "Roller with extension handle", "Paint tray", "Painter’s tape",
										"GliddenTM paint — Color: We used Pink Salmon! Type: Glidden® High EnduranceTM Plus, Glidden® " +
										"High EnduranceTM, or Glidden® High EnduranceTMGrab-N-Go"};
	
	private ListView lView1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.accent_wall_shop_frag, container, false);
		
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
