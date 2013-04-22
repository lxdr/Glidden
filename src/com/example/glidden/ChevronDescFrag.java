package com.example.glidden;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChevronDescFrag extends Fragment 
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.chevron_desc_frag, container, false);
		
		// Inflate the layout for this fragment
		return view;
	}
}
