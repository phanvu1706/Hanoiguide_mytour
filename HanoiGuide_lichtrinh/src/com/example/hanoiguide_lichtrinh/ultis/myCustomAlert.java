package com.example.hanoiguide_lichtrinh.ultis;

import java.util.ArrayList;
import java.util.List;

import com.example.hanoiguide_lichtrinh.R;
import com.example.hanoiguide_lichtrinh.R.id;
import com.example.hanoiguide_lichtrinh.R.layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class myCustomAlert extends Dialog{
	
	Context context;
	ArrayAdapter<String> adapter;
	ArrayList<String> list;

	public myCustomAlert(Context context, ArrayList<String> list) {
		super(context);		
		// TODO Auto-generated constructor stub
		
		this.context = context;
		this.list = list;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_dialog_search);
		this.setTitle("Điểm bắt đầu");
		
		EditText etSearch = (EditText) findViewById(R.id.etSearch);
		ListView lv = (ListView) findViewById(R.id.lvItemDiemBD);
		
		lv.setTextFilterEnabled(true);
		
		list.add(0, "Vị trí hiện tại");
		
		adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
		lv.setAdapter(adapter);
		etSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				adapter.getFilter().filter(s);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
