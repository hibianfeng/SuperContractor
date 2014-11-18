/**
 * 
 */
package com.superc.adapter;

import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import android.widget.TextView;

import com.superc.supercontactor.R;
import com.superc.bean.*;
/**
 * @author Administrator
 *
 */
public class ContactorInfoAdapter extends BaseAdapter {

	private List<BeanContactorInfo> data;
	private Context context;
	private LayoutInflater mLayoutInflater;
	
	public ContactorInfoAdapter(Context context, List<BeanContactorInfo>  data) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.data=data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(mLayoutInflater == null)	{
			mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		if (arg1 == null) {
			arg1=mLayoutInflater.inflate(R.layout.item_contactor, null, false);	
		}
		
		TextView tvContactorName = (TextView)arg1.findViewById(R.id.tv_contactor_name);
		TextView tvContactorNum = (TextView)arg1.findViewById(R.id.tv_contactor_number);
		
		BeanContactorInfo contactorInfo=data.get(arg0);
		tvContactorName.setText(contactorInfo.getContactorName());
		tvContactorNum.setText(contactorInfo.getContactorNumber());
		
		return arg1;
	}

	

}
