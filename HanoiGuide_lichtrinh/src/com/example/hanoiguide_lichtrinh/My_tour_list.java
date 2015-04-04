package com.example.hanoiguide_lichtrinh;

import java.util.ArrayList;
import java.util.List;

import com.example.hanoiguide_lichtrinh.entity.Global;
import com.example.hanoiguide_lichtrinh.entity.ItemTest;
import com.example.hanoiguide_lichtrinh.ultis.TabPagerAdapter;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class My_tour_list extends FragmentActivity {
	ViewPager pageView;
	TabPagerAdapter TabAdapter;
	ActionBar actionBar;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private ImageView ivLeft;
	private ImageView ivRight;
	private ImageView addNew;

	private ListView mLeftDrawerView;
	private ListView mRightDrawerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mytour_list);
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
		ivLeft = (ImageView)findViewById(R.id.topImg1);
		ivRight = (ImageView)findViewById(R.id.topImg2);
		addNew = (ImageView)findViewById(R.id.topImg3);
		
		ivLeft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mDrawerLayout.isDrawerOpen(mLeftDrawerView)) {
					mDrawerLayout.closeDrawer(mLeftDrawerView);
				}
				mDrawerLayout.openDrawer(mLeftDrawerView);
			}
		});
		
		ivRight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mDrawerLayout.isDrawerOpen(mRightDrawerView)) {
					mDrawerLayout.closeDrawer(mRightDrawerView);
				}
				mDrawerLayout.openDrawer(mRightDrawerView);
			}
		});

		addNew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t = new Intent(getApplicationContext(), My_tour_add_new.class);
				startActivity(t);
			}
		});

		// create the TabHost that will contain the Tabs
		TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
		pageView = (ViewPager) findViewById(R.id.pager);
		pageView.setAdapter(TabAdapter);
		pageView.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				invalidateOptionsMenu();
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
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if (mDrawerLayout == null || mLeftDrawerView == null
				|| mRightDrawerView == null || mDrawerToggle == null) {
			// Configure navigation drawer
			mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			mLeftDrawerView = (ListView) findViewById(R.id.left_drawer);
			mRightDrawerView = (ListView) findViewById(R.id.right_drawer);
			List<String> ls = new ArrayList<>();
			ls.add("Hien tai");
			ls.add("Diem 1");
			ls.add("Diem 2");
			ls.add("Diem 3");
			mLeftDrawerView.setAdapter(new ArrayAdapter<>(
					getApplicationContext(),
					android.R.layout.simple_list_item_1, ls));
			mRightDrawerView.setAdapter(new ArrayAdapter<>(
					getApplicationContext(),
					android.R.layout.simple_list_item_1, ls));
			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					R.drawable.ic_launcher, R.string.drawer_open,
					R.string.drawer_close) {

				/**
				 * Called when a drawer has settled in a completely closed
				 * state.
				 */
				public void onDrawerClosed(View drawerView) {
					if (drawerView.equals(mLeftDrawerView)) {

						supportInvalidateOptionsMenu(); // creates call to
														// onPrepareOptionsMenu()
						mDrawerToggle.syncState();
					}
				}

				/** Called when a drawer has settled in a completely open state. */
				public void onDrawerOpened(View drawerView) {
					if (drawerView.equals(mLeftDrawerView)) {

						supportInvalidateOptionsMenu(); // creates call to
														// onPrepareOptionsMenu()
						mDrawerToggle.syncState();
					}
				}

				@Override
				public void onDrawerSlide(View drawerView, float slideOffset) {
					// Avoid normal indicator glyph behaviour. This is to avoid
					// glyph movement when opening the right drawer
					// super.onDrawerSlide(drawerView, slideOffset);
				}
			};

			mDrawerLayout.setDrawerListener(mDrawerToggle); // Set the drawer
															// toggle as the
															// DrawerListener
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.clear();
		getMenuInflater().inflate(R.menu.main, menu);

		return super.onCreateOptionsMenu(menu);
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
