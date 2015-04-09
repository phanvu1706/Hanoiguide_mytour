package com.example.hanoiguide_lichtrinh;

import java.util.ArrayList;

import hanoi.database_hanlder.ExecuteQuery;

import com.example.hanoiguide_lichtrinh.model.DiemDuLich;
import com.example.hanoiguide_lichtrinh.model.LichTrinh;
import com.example.hanoiguide_lichtrinh.ultis.myCustomAlert;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.hanoiguide_lichtrinh.app.Global;

import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.util.Log;
import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class My_tour_add_new extends ActionBarActivity implements
		ConnectionCallbacks, OnConnectionFailedListener {
	private myCustomAlert mca;

	private EditText etDiemDB;
	private EditText etTenTour;
	private EditText etNgaybatdau;
	private EditText etNgayketthuc;

	private Button btnTieptuc;

	private ExecuteQuery execQ;

	private GoogleApiClient mGoogleApiClient;

	private Location mLastLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mytour_addnew);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		etDiemDB = (EditText) findViewById(R.id.etDiembd);
		etTenTour = (EditText) findViewById(R.id.etTenlt);
		etNgaybatdau = (EditText) findViewById(R.id.etNgaybd);
		etNgayketthuc = (EditText) findViewById(R.id.etNgaykt);

		execQ = new ExecuteQuery(this);
		execQ.createDatabase();
		execQ.open();

		// Global.LIST_DIEMDULICH = execQ.getAllDiemDL();
		Global.DL();
		execQ.insertDiemDL(Global.LIST_DIEMDULICH);
		buildGoogleApiClient();

		mca = new myCustomAlert(My_tour_add_new.this, getTenDiemL());

		Time now = new Time(Time.getCurrentTimezone());
		now.setToNow();
		String a = now.monthDay + "/" + (now.month + 1) + "/" + now.year;
		etNgaybatdau.setText(a);
		etNgayketthuc.setText(a);
		etDiemDB.setText("Vị trí hiện tại");

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
				String ten = etTenTour.getText().toString();
				String ngayBD = etNgaybatdau.getText().toString();
				String ngayKT = etNgayketthuc.getText().toString();
				String diemDB = etDiemDB.getText().toString();

				if (ten.equals("")) {
					Toast.makeText(My_tour_add_new.this, "Tên lịch trình",
							Toast.LENGTH_SHORT).show();
					return;
				}
				String lat = null, lon = null, madiemdl = null, tenDiemDL = null;

				Time now = new Time(Time.getCurrentTimezone());
				now.setToNow();
				String ma = now.monthDay + "" + now.month + "" + now.year + ""
						+ now.hour + "" + now.minute + "" + now.second;

				if (diemDB.equals("Vị trí hiện tại")) {
					madiemdl = ma;
					tenDiemDL = "Vi tri hien tai";
					lat = getLatLng().latitude + "";
					lon = getLatLng().longitude + "";
				} else {
					for (DiemDuLich dl : Global.LIST_DIEMDULICH) {
						if (diemDB.trim().equals(dl.getTenDiemDL())) {
							lat = dl.getLatitude();
							lon = dl.getLongtitude();
							madiemdl = dl.getMaDiemDL();
							tenDiemDL = dl.getTenDiemDL();
							break;
						}
					}
				}

				// if (execQ.insert_table_lichtrinh(new LichTrinh(ma, ten, "",
				// "",
				// "1", ngayBD, ngayKT, "1", "user", lat, lon)) == 1) {
				// Intent i = new Intent(My_tour_add_new.this,
				// My_tour_map.class);
				// i.putExtra("MALICHTRINH", ma);
				// i.putExtra("LAT", lat);
				// i.putExtra("LON", lon);
				// i.putExtra("MADIEMDL", madiemdl);
				// i.putExtra("TenDiemDL", tenDiemDL);
				// startActivity(i);
				// } else {
				// Toast.makeText(getApplicationContext(), "FAIL",
				// Toast.LENGTH_SHORT).show();
				// return;
				//
				// }
				execQ.insert_table_lichtrinh(new LichTrinh(ma, ten, "", "",
						"1", ngayBD, ngayKT, "1", "user", lat, lon));
				
				String t = execQ.getTenLichtrinh(ma);
				Log.d("TEN LICH TRINH", t);
				
				Intent i = new Intent(My_tour_add_new.this, My_tour_map.class);
				i.putExtra("MALICHTRINH", ma);
				i.putExtra("LAT", lat);
				i.putExtra("LON", lon);
				i.putExtra("MADIEMDL", madiemdl);
				i.putExtra("TenDiemDL", tenDiemDL);
				startActivity(i);
			}
		});

		etNgaybatdau.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(My_tour_add_new.this);

				dialog.setContentView(R.layout.custom_dialog_datetimepicker);
				dialog.setTitle("Ngày bắt đầu");

				Button btnSetDate = (Button) dialog
						.findViewById(R.id.btnSetDate);
				final DatePicker date = (DatePicker) dialog
						.findViewById(R.id.datePicker1);

				btnSetDate.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						int dayOfMonth = date.getDayOfMonth();
						int month = date.getMonth() + 1;
						int year = date.getYear();
						etNgaybatdau.setText(dayOfMonth + "/" + month + "/"
								+ year);
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});

		etNgayketthuc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(My_tour_add_new.this);

				dialog.setContentView(R.layout.custom_dialog_datetimepicker);
				dialog.setTitle("Ngày kết thúc");

				Button btnSetDate = (Button) dialog
						.findViewById(R.id.btnSetDate);
				final DatePicker date = (DatePicker) dialog
						.findViewById(R.id.datePicker1);

				btnSetDate.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						int dayOfMonth = date.getDayOfMonth();
						int month = date.getMonth() + 1;
						int year = date.getYear();
						etNgayketthuc.setText(dayOfMonth + "/" + month + "/"
								+ year);
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});
	}

	protected synchronized void buildGoogleApiClient() {
		mGoogleApiClient = new GoogleApiClient.Builder(this)
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this)
				.addApi(LocationServices.API).build();
	}

	public ArrayList<String> getTenDiemL() {
		ArrayList<String> list = new ArrayList<String>();
		for (DiemDuLich dl : Global.LIST_DIEMDULICH) {
			list.add(dl.getTenDiemDL());
		}
		return list;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if (mGoogleApiClient.isConnected()) {
			mGoogleApiClient.disconnect();
		}
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		mGoogleApiClient.connect();
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		mLastLocation = LocationServices.FusedLocationApi
				.getLastLocation(mGoogleApiClient);

		// Toast.makeText(getApplicationContext(), myLocation.latitude + "",
		// Toast.LENGTH_LONG).show();
	}

	public LatLng getLatLng() {
		if (mLastLocation != null) {
			LatLng myLocation = new LatLng(mLastLocation.getLatitude(),
					mLastLocation.getLongitude());
			return myLocation;
		}
		return null;
	}

	@Override
	public void onConnectionSuspended(int cause) {
		// TODO Auto-generated method stub
		mGoogleApiClient.connect();
	}
}
