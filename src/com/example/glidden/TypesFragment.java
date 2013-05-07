package com.example.glidden;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TypesFragment extends Fragment {
	protected String[] PROJECT_TYPES = new String[] {"HomeDecor", "Furniture", "Walls", "Outdoor"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.types_fragment, container, false);
		
		ArrayList<MainItemDetails> main_image_details = GetSearchResultsTypes();

		final ListView lv1 = (ListView) view.findViewById(R.id.listV_main2);
		lv1.setAdapter(new MainItemListBaseAdapter(getActivity(), main_image_details));

		//sets the click listener to the adapter and not a button
		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {      		
				String openClass = PROJECT_TYPES[position];
				try{
					Class selected = Class.forName("com.example.glidden." + openClass);
					Intent intent = new Intent(v.getContext(), selected);
					startActivity(intent);
				}catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
		});
		
		// Inflate the layout for this fragment
		return view;
	}
	
	private ArrayList<MainItemDetails> GetSearchResultsTypes(){
		ArrayList<MainItemDetails> results = new ArrayList<MainItemDetails>();

		MainItemDetails main_item_details = new MainItemDetails();
		main_item_details.setName("Home Decor");
		main_item_details.setImageNumber(5);
		results.add(main_item_details);

		main_item_details = new MainItemDetails();
		main_item_details.setName("Furniture");
		main_item_details.setImageNumber(6);
		results.add(main_item_details);

		main_item_details = new MainItemDetails();
		main_item_details.setName("Rooms");
		main_item_details.setImageNumber(7);
		results.add(main_item_details);

		main_item_details = new MainItemDetails();
		main_item_details.setName("Outdoor");
		main_item_details.setImageNumber(8);
		results.add(main_item_details);

		return results;
	}
}
