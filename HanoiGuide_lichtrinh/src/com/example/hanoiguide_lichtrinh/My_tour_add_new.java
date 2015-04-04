package com.example.hanoiguide_lichtrinh;

import java.util.ArrayList;
import java.util.List;

import com.example.hanoiguide_lichtrinh.entity.Global;
import com.example.hanoiguide_lichtrinh.entity.ItemTest;
import com.example.hanoiguide_lichtrinh.ultis.myCustomAlert;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class My_tour_add_new extends ActionBarActivity {
	myCustomAlert mca;
	EditText etDiemDB;
	EditText etTenTour;
	Button btnTieptuc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mytour_addnew);
		etDiemDB = (EditText) findViewById(R.id.etDiembd);
		etTenTour = (EditText) findViewById(R.id.etTenlt);		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);		
		mca = new myCustomAlert(My_tour_add_new.this);
		etDiemDB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mca.show();
				ListView lv = (ListView) mca.findViewById(R.id.lvItemDiemBD);
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						etDiemDB.setText(parent.getItemAtPosition(position)
								.toString());
						mca.dismiss();
					}
				});
			}
		});
		btnTieptuc = (Button) findViewById(R.id.btnTieptuc);
		btnTieptuc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), My_tour_map.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case android.R.id.home:
			
			break;
		case R.id.action_settings:
			
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
