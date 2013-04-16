/*package com.example.glidden;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TraditionalListAdapter extends ArrayAdapter<String>{

	private Context context;
	private String[] values;
	
	public TraditionalListAdapter(Context context,
			String[] values) {
		// TODO Auto-generated constructor stub
		super(context, R.layout.traditional_listview, values);
		this.context = context;
		this.values = values; 
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflator =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflator.inflate(R.layout.activity_category, parent, false);
		
		TextView textView = (TextView)rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		
		textView.setText(values[position]);
		
		String str = values[position];
		
		if(str.startsWith("FireplaceMantel")){
			imageView.setImageResource(R.drawable.ic_launcher);
		}
		else
			if(str.equalsIgnoreCase("WoodenSideProject")){
				imageView.setImageResource(R.drawable.project_one);
			}
		
		return rowView;
		//return super.getView(position, convertView, parent);
	}
	
}

*/
