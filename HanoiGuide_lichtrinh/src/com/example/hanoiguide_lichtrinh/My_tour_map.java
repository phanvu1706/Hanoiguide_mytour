package com.example.hanoiguide_lichtrinh;

import hanoi.database_hanlder.ExecuteQuery;

import java.util.ArrayList;

import com.example.hanoiguide_lichtrinh.model.DiemDuLich;
import com.example.hanoiguide_lichtrinh.model.LichTrinh_Diemdulich;
import com.example.hanoiguide_lichtrinh.ultis.CircularImageView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hanoiguide_lichtrinh.app.Global;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class My_tour_map extends ActionBarActivity implements
		GoogleApiClient.ConnectionCallbacks,
		GoogleApiClient.OnConnectionFailedListener, LocationListener {

	CircularImageView btnCircleAdd;

	private GoogleMap mMap;

	private String MALICHTRINH;
	private String LAT;
	private String LON;
	private String MADIEMDL;
	
	private ArrayList<DiemDuLich> list = new ArrayList<DiemDuLich>();
	private ArrayList<String> listSave = new ArrayList<String>();
	
	private ExecuteQuery execQ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mytour_map);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		execQ = new ExecuteQuery(this);
		execQ.createDatabase();
		execQ.close();
		
		list = Global.LIST_DIEMDULICH;
		
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		if (mMap != null) {
			mMap.setMyLocationEnabled(true);
		}

		Bundle extras = getIntent().getExtras();
		MALICHTRINH = extras.getString("MALICHTRINH");
		LAT = extras.getString("LAT");
		LON = extras.getString("LON");
		MADIEMDL = extras.getString("MADIEMDL");
		String tenDiemDL = extras.getString("TenDiemDL");
		
		listSave.add(MADIEMDL);
		
		LatLng l = new LatLng(Double.parseDouble(LAT), Double.parseDouble(LON));
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(l, 15f));

		mMap.addMarker(new MarkerOptions()
				.position(l)
				.title(tenDiemDL)
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.marker_done)).snippet(MADIEMDL));

		searchPlace();

		btnCircleAdd = (CircularImageView) findViewById(R.id.btnCircularAdd);

		btnCircleAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for (String s : listSave) {
					if (s.equals(MADIEMDL)) {
						Toast.makeText(getApplicationContext(), "Đã có trong danh sách", Toast.LENGTH_SHORT).show();
						return;
					}
				}
				LatLng ll = new LatLng(Double.parseDouble(LAT), Double.parseDouble(LON));
				for (int i=0; i<list.size();++i) {
					if (list.get(i).getMaDiemDL().equals(MADIEMDL)) {
						mMap.addMarker(new MarkerOptions()
						.position(ll)
						.title(list.get(i).getTenDiemDL())
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.marker_done)).snippet(MADIEMDL));
						list.remove(i);
						break;
					}
				}
				listSave.add(MADIEMDL);
				searchPlace();
			}
		});

		/*
		 * Click Marker
		 */
		mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker marker) {
				marker.showInfoWindow();
				LAT = marker.getPosition().latitude + "";
				LON = marker.getPosition().longitude + "";
				MADIEMDL = marker.getSnippet();
				return true;
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
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_next_complete) {
			for (String s : listSave) {
				LichTrinh_Diemdulich lt = new LichTrinh_Diemdulich(MALICHTRINH, s, "");
				execQ.insert_table_lichtrinh_diemdulich(lt);
			}
			Intent t = new Intent(getApplicationContext(),
					My_tour_complete.class);
			t.putExtra("MALICHTRINH", MALICHTRINH);
			startActivity(t);
			return true;
		} else if (id == android.R.id.home) {
			Intent t = new Intent(getApplicationContext(),
					My_tour_add_new.class);
			t.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(t);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConnected(Bundle arg0) {
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		if (mMap != null) {
			mMap.setMyLocationEnabled(true);
		}
	}

	@Override
	public void onConnectionSuspended(int arg0) {
		// TODO Auto-generated method stub

	}

	public void searchPlace() {
		LatLng startP = new LatLng(Double.parseDouble(LAT),
				Double.parseDouble(LON));
		for (DiemDuLich dl : list) {
			LatLng EndP = new LatLng(Double.parseDouble(dl.getLatitude()),
					Double.parseDouble(dl.getLongtitude()));
			double distance = CalculationByDistance(startP, EndP);
			/*
			 * 2km
			 */
			if ((distance > 0) && (distance < 0.000002)) {
				mMap.addMarker(new MarkerOptions()
						.position(EndP)
						.title(dl.getTenDiemDL())
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.marker_choose)).snippet(dl.getMaDiemDL()));
			}
		}
	}

	public double CalculationByDistance(LatLng StartP, LatLng EndP) {
		double lat1 = StartP.latitude / 1E6;
		double lat2 = EndP.latitude / 1E6;
		double lon1 = StartP.longitude / 1E6;
		double lon2 = EndP.longitude / 1E6;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return 6371.00 * c;
	}
}
