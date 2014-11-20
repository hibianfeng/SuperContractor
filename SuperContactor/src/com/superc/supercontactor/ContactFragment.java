package com.superc.supercontactor;

import java.util.ArrayList;
import java.util.List;

import com.superc.abstractlayer.ALOperateDB;
import com.superc.adapter.ContactorInfoAdapter;
import com.superc.bean.BeanContactorInfo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ContactFragment extends Fragment {

	List<BeanContactorInfo> info;
	ContactorInfoAdapter adapter;
	ListView lv;

	public ContactFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		ListView lv = (ListView) rootView.findViewById(R.id.list_Contactors);
		info = new ArrayList<BeanContactorInfo>();
		adapter = new ContactorInfoAdapter(this.getActivity(), info);
		lv.setAdapter(adapter);
		InitListView();
		return rootView;
	}

	void InitListView() {
		// get contact information from database

		ALOperateDB db = new ALOperateDB(this.getActivity().getContentResolver());
		Cursor cur = db.getAllContact();
		// fill data used to fill listview
		if (cur == null) {
			System.out.println("There is no data in database");
		}
		while (cur.moveToNext()) {
			BeanContactorInfo element = new BeanContactorInfo();
			element.setContactorName(cur
					.getString(ALOperateDB.PHONES_DISPLAY_NAME_INDEX));
			element.setContactorNumber(cur
					.getString(ALOperateDB.PHONES_NUMBER_INDEX));
			info.add(element);
		}

		// inform list view display all information
		adapter.notifyDataSetChanged();

	}
}
