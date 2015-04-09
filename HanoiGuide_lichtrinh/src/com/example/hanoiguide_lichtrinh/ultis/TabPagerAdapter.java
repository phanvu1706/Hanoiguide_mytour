package com.example.hanoiguide_lichtrinh.ultis;

import java.util.ArrayList;

import com.example.hanoiguide_lichtrinh.R;
import com.example.hanoiguide_lichtrinh.model.LichTrinh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
	
	ArrayList<LichTrinh> listLichTrinh;
	public TabPagerAdapter(FragmentManager fm, ArrayList<LichTrinh> listLichTrinh) {
		super(fm);
		this.listLichTrinh = listLichTrinh;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		if (this.getCount() != 0) {
			return new ItemLT(listLichTrinh.get(i));			
		}else{
			return new ItemLT(R.drawable.button_add, "Add New");
		}
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listLichTrinh.size(); // No of Tabs
	}

}