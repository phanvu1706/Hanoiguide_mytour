package com.example.hanoiguide_lichtrinh;

import hanoi.database_hanlder.ExecuteQuery;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hanoiguide_lichtrinh.ultis.MyTourComplete_Item;
import com.hanoiguide_lichtrinh.adapter.MyTourCompleteAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class My_tour_complete extends ActionBarActivity {

	private Button btnHoanthanh;
	private ListView lvDiemTime;
	
	private String MALICHTRINH;
	
	private ArrayList<MyTourComplete_Item> listTourComplete = new ArrayList<MyTourComplete_Item>();
	private MyTourCompleteAdapter adapter = null;

	private ExecuteQuery execQ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mytour_complete);

		Bundle bundle = getIntent().getExtras();
		MALICHTRINH = bundle.getString("MALICHTRINH");
		
		execQ = new ExecuteQuery(this);
		execQ.createDatabase();
		execQ.open();
		
		listTourComplete = execQ.select_tenma_tbl_lichtrinh_diemdulich(MALICHTRINH);
		
		btnHoanthanh = (Button) findViewById(R.id.btnHoanthanh);
		btnHoanthanh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t = new Intent(getApplicationContext(),
						My_tour_list.class);
				startActivity(t);

			}
		});
		
		lvDiemTime = (ListView) findViewById(R.id.lvDiemTime);
		adapter = new MyTourCompleteAdapter(this, R.layout.mytourcomplete_itemrow, listTourComplete);
		lvDiemTime.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
