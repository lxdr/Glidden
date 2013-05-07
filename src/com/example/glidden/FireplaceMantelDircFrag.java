package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FireplaceMantelDircFrag extends Fragment {
	private String[] directions_items = {"1. Remove all furniture and possessions away from the fireplace and lay " +
			"a drop cloth on the floor.", "2. Wearing your work gloves, apply the paint remover, following the " +
			"directions on the container. Scrape any excess paint off with the putty knife.", "3. After the mantel " +
			"dries fill in any cracks with the wood filler and putty knife.", "4. Use the sandpaper to butt out smaller " +
			"scratches and smooth the dried wood filler.", "5. Tape around the edges of the mantle.", "6. Paint the mantel " +
			"and allow it to dry 2-3 hours before touching up or removing the tape. Wait at least 24 hours after this to place " +
			"belongings on the mantle again to ensure the paint isn’t still tacky."};
	ListView lView1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fireplace_mantel_dirc_frag, container, false);

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
