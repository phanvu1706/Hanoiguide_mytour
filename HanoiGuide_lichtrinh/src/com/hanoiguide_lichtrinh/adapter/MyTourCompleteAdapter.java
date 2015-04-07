package com.hanoiguide_lichtrinh.adapter;

import java.util.ArrayList;

import com.example.hanoiguide_lichtrinh.R;
import com.example.hanoiguide_lichtrinh.ultis.MyTourComplete_Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyTourCompleteAdapter extends ArrayAdapter<MyTourComplete_Item> {

	private Context context;
	private int layoutResourceId;
	ArrayList<MyTourComplete_Item> array;

	public MyTourCompleteAdapter(Context context, int layoutResourceId,
			ArrayList<MyTourComplete_Item> array) {
		super(context, layoutResourceId, array);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.array = array;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		LayoutInflater inf = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);

		View rowView = inf.inflate(R.layout.mytourcomplete_itemrow, parent,
				false);

		TextView stt = (TextView) rowView.findViewById(R.id.tvStt);
		TextView tenDiemDL = (TextView) rowView.findViewById(R.id.tvTenDiadiem);
		TextView thoigian = (TextView) rowView.findViewById(R.id.tvTime);

		stt.setText((position + 1) + "");
		tenDiemDL.setText(array.get(position).getTenDiemDL());
		thoigian.setText(array.get(position).getThoigian());

		return rowView;

	}

	class ItemHolder {
		TextView stt;
		TextView tenDiemDL;
		TextView thoigian;
	}
}
