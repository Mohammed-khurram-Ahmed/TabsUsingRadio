package com.example.tabsusingradio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentTab1 extends Fragment {
	ViewGroup container;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragmenttab1, container, false);
		this.container = container;
		this.view = view;
		Button mybutton = (Button) view.findViewById(R.id.button1);
		mybutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				replaceCurrentFragment();
			}
		});
		return view;
	}

	public void replaceCurrentFragment() {

		if (view.findViewById(R.id.framFragments).getTag() == null) {
			ChildFragment cf = new ChildFragment();
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fT = fragmentManager.beginTransaction();
			fT.replace(R.id.framFragments, cf, "tag");
			fT.addToBackStack(null);
			fT.commit();
			Log.e("test","Null");
		} else {
			Toast.makeText(getActivity(), "Already Replaced", Toast.LENGTH_LONG)
					.show();
			Log.e("test","Not Null");
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}

}