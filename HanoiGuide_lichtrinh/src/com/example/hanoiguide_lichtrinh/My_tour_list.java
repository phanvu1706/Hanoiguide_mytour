package com.example.hanoiguide_lichtrinh;

import java.util.ArrayList;
import java.util.List;

import com.example.hanoiguide_lichtrinh.model.Global;
import com.example.hanoiguide_lichtrinh.model.ItemTest;
import com.example.hanoiguide_lichtrinh.ultis.TabPagerAdapter;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class My_tour_list extends Fragment {
	ViewPager pageView;
	TabPagerAdapter TabAdapter;
	ActionBar actionBar;
	private DrawerLayout mDrawerLayout;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.mytour_list, container, false);
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 1"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 2"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 3"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 4"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 5"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 6"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 7"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 8"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 9"));
		Global.LIST.add(new ItemTest(R.drawable.quoc_tu_dam, "Test 10"));

		// create the TabHost that will contain the Tabs
		TabAdapter = new TabPagerAdapter(getChildFragmentManager());
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
		return view;
	}
}
