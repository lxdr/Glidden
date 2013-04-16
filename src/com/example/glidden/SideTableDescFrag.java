package com.example.glidden;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class SideTableDescFrag extends Fragment
{
	ImageButton button3;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.sidetable_description_frag, container, false);
		
		// Inflate the layout for this fragment
		return view;
	}
}
