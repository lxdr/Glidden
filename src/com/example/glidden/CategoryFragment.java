package com.example.glidden;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CategoryFragment extends Fragment {
	protected String[] PROJECT_CATEGORIES = new String[]{"Traditional", "Modern", "Eclectic", "Cottage"};
	String TAG = "CategoryFragment";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		Log.e(TAG, "HERE!!!");
		View view = inflater.inflate(R.layout.category_fragment, container, false);
		
		ArrayList<MainItemDetails> main_image_details = GetSearchResultsCategories();

		final ListView lv1 = (ListView) view.findViewById(R.id.listV_main);
		lv1.setAdapter(new MainCategoriesListBaseAdapter(getActivity(), main_image_details));

		//sets the click listener to the adapter and not a button
		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) 
			{      		
				String openClass = PROJECT_CATEGORIES[position];
				try
				{
					Class selected = Class.forName("com.example.glidden." + openClass);
					Intent intent = new Intent(v.getContext(), selected);
					startActivity(intent);
				}catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}

		});

		// Inflate the layout for this fragment
		return view;
	}

	private ArrayList<MainItemDetails> GetSearchResultsCategories(){
		ArrayList<MainItemDetails> results = new ArrayList<MainItemDetails>();

		MainItemDetails main_item_details = new MainItemDetails();
		main_item_details.setName("Traditional");
		main_item_details.setImageNumber(1);
		results.add(main_item_details);

		main_item_details = new MainItemDetails();
		main_item_details.setName("Modern");
		main_item_details.setImageNumber(2);
		results.add(main_item_details);

		main_item_details = new MainItemDetails();
		main_item_details.setName("Ecletic");
		main_item_details.setImageNumber(3);
		results.add(main_item_details);

		main_item_details = new MainItemDetails();
		main_item_details.setName("Cottage");
		main_item_details.setImageNumber(4);
		results.add(main_item_details);

		return results;
	}

}
