package com.example.tabsusingradio;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	MyPageAdapter pageAdapter;
	RadioGroup radioGroupTabs;
	RadioGroup radioGroupIndicators;
	ViewPager pager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<Fragment> fragments = getFragments();
		pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
		pager = (ViewPager) findViewById(R.id.viewpager);
		pager.setAdapter(pageAdapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				selectedItemChange(arg0);
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		addRadioTabsListner();
		selectedItemChange(0);
	}

	private void addRadioTabsListner() {
		radioGroupTabs = (RadioGroup) findViewById(R.id.radioGroupTabs);
		radioGroupIndicators = (RadioGroup) findViewById(R.id.radioGrpIndicator);
		radioGroupTabs
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						int pos = 0;
						if (checkedId == R.id.btn1) {
							pos = 0;
						} else if (checkedId == R.id.btn2) {
							pos = 1;
						} else if (checkedId == R.id.btn3) {
							pos = 2;
						} else if (checkedId == R.id.btn4) {
							pos = 3;
						}
						selectedItemChange(pos);
					}
				});

		radioGroupIndicators
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						int pos = 0;
						if (checkedId == R.id.btn1) {
							pos = 0;
						} else if (checkedId == R.id.btn2) {
							pos = 1;
						} else if (checkedId == R.id.btn3) {
							pos = 2;
						} else if (checkedId == R.id.btn4) {
							pos = 3;
						}
					}
				});

	}

	void selectedItemChange(int position) {
		// Toast.makeText(getApplicationContext(), "" + position,
		// Toast.LENGTH_SHORT).show();
		pager.setCurrentItem(position);
		RadioButton radioButtonTabs = (RadioButton) radioGroupTabs
				.getChildAt(position);
		radioButtonTabs.setChecked(true);
		RadioButton radioButtonIndicator = (RadioButton) radioGroupIndicators
				.getChildAt(position);
		radioButtonIndicator.setChecked(true);
	}

	private List<Fragment> getFragments() {
		List<Fragment> fList = new ArrayList<Fragment>();
//		fList.add(MyFragment.newInstance("Fragment 1"));
//		fList.add(MyFragment.newInstance("Fragment 2"));
//		fList.add(MyFragment.newInstance("Fragment 3"));
//		fList.add(MyFragment.newInstance("Fragment 4"));
		fList.add(new FragmentTab1());
		fList.add(new FragmentTab2());
		fList.add(new FragmentTab3());
		fList.add(new FragmentTab4());

		
		return fList;
	}
}
