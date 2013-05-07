package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BedPanelShopFrag extends Fragment
{
	private String[] shopping_items = {"Painter’s tape", "2-3” chip brush", "Foam roller", "GliddenTM paint — Color: " +
			"We used Lavender Cloud and Antique Purple! Type: Glidden® High EnduranceTM Plus, Glidden® High EnduranceTM, " +
			"or Glidden® High EnduranceTM Grab-N-Go"};
	private ListView lView1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bed_panel_shop_frag, container, false);

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
