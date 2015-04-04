package com.example.hanoiguide_lichtrinh;

import com.example.hanoiguide_lichtrinh.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;

public class FragmentManagerActivity extends MaterialNavigationDrawer implements
		MaterialAccountListener {

	private MaterialAccount account;
	private MaterialSection<Fragment> haNoi, diemDuLich, nhaHang, muaSam,
			giaoThong, lichTrinh;

	@Override
	public void init(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		account = new MaterialAccount(this.getResources(), "Thor", "Thor",
				R.drawable.ava_1, R.drawable.cover_1);
		this.addAccount(account);

		// close material navigation drawer at first
		this.disableLearningPattern();

		haNoi = newSection("Hà Nội", R.drawable.instagram32,
				new HaNoiFragment());
		this.addSection(haNoi);

		this.addSection(newSection("Điểm du lịch", R.drawable.menu_giaothong,
				new FragmentIndex()));
		this.addSection(newSection("Khách sạn", R.drawable.menu_khachsan,
				new FragmentIndex()));
		this.addSection(newSection("Nhà hàng", R.drawable.menu_diemdulich,
				new FragmentIndex()));
		this.addSection(newSection("Mua sắm", R.drawable.menu_muasam,
				new FragmentIndex()));
		this.addSection(newSection("Giao thông", R.drawable.menu_giaothong,
				new FragmentIndex()));
		this.addSection(newSection("Lịch trình", R.drawable.menu_diemdulich,
				new Intent(FragmentManagerActivity.this, My_tour_list.class)));
	}

	@Override
	public void onAccountOpening(MaterialAccount account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChangeAccount(MaterialAccount newAccount) {
		// TODO Auto-generated method stub

	}

}
