package com.example.hanoiguide_lichtrinh.ultis;

import com.example.hanoiguide_lichtrinh.My_tour_review;
import com.example.hanoiguide_lichtrinh.R;
import com.example.hanoiguide_lichtrinh.R.id;
import com.example.hanoiguide_lichtrinh.R.layout;
import com.example.hanoiguide_lichtrinh.entity.ItemTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemLT extends Fragment {
	private int imageResource;
	private String text;
	private ItemTest item;
	private View android;

	public ItemLT(int imageResource, String text) {
		super();
		this.imageResource = imageResource;
		this.text = text;
	}

	public ItemLT(ItemTest item) {
		super();
		this.item = item;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		android = inflater.inflate(R.layout.mytour_list_item, container, false);
		setHasOptionsMenu(true);
		ImageView iv = (ImageView) android.findViewById(R.id.circularImg);
		iv.setImageResource(item.getImageResource());
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t = new Intent(getActivity(), My_tour_review.class);
				t.putExtra("item", item);
				startActivity(t);
			}
		});

		((TextView) android.findViewById(R.id.tvTourName)).setText(item
				.getText());

		return android;
	}

}
