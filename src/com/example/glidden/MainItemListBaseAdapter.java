package com.example.glidden;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainItemListBaseAdapter extends BaseAdapter {
private static ArrayList<MainItemDetails> itemDetailsarrayList;
	
	private Integer[] imgid = {
			R.drawable.traditional,
			R.drawable.modern,
			R.drawable.eclectic,
			R.drawable.cottage,
			R.drawable.homedecor,
			R.drawable.furniture_,
			R.drawable.walls,
			R.drawable.out_door
			};
	
	private LayoutInflater l_Inflater;

	public MainItemListBaseAdapter(Context context, ArrayList<MainItemDetails> results) {
		itemDetailsarrayList = results;
		l_Inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return itemDetailsarrayList.size();
	}

	public Object getItem(int position) {
		return itemDetailsarrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.main_listview, null);
			holder = new ViewHolder();
			holder.itemImage = (ImageView) convertView.findViewById(R.id.photo);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.itemImage.setBackgroundResource(imgid[itemDetailsarrayList.get(position).getImageNumber() - 1]);

		return convertView;
	}

	static class ViewHolder {
		TextView txt_itemName;
		ImageView itemImage;
	}
}
