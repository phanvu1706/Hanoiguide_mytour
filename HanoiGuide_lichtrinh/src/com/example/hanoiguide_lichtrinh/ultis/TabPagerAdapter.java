package com.example.hanoiguide_lichtrinh.ultis;

import com.hanoiguide_lichtrinh.app.Global;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		return new ItemLT(Global.LIST.get(i));
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Global.LIST.size(); // No of Tabs
	}

}