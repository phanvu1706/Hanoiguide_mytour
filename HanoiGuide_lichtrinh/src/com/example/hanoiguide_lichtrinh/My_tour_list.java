package com.example.hanoiguide_lichtrinh;

import hanoi.database_hanlder.ExecuteQuery;

import java.util.ArrayList;

import com.example.hanoiguide_lichtrinh.model.ItemTest;
import com.example.hanoiguide_lichtrinh.model.LichTrinh;
import com.example.hanoiguide_lichtrinh.ultis.TabPagerAdapter;
import com.hanoiguide_lichtrinh.app.Global;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class My_tour_list extends Fragment {
	ViewPager pageView;
	TabPagerAdapter TabAdapter;	
	View view;
	private ExecuteQuery execQ;
	ArrayList<LichTrinh> listLT;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.mytour_list, container, false);
		execQ = new ExecuteQuery(getActivity().getApplicationContext());
		execQ.createDatabase();
		execQ.open();
		listLT = execQ.select_table_lichtrinh();		
		// create the TabHost that will contain the Tabs
		TabAdapter = new TabPagerAdapter(getChildFragmentManager(), listLT);		
		pageView = (ViewPager) view.findViewById(R.id.pager);
		pageView.setAdapter(TabAdapter);
		pageView.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		setHasOptionsMenu(true);
		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.mytour_map, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.action_next_map) {
			Intent t = new Intent(getActivity(), My_tour_add_new.class);
			startActivity(t);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
