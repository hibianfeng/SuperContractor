package com.superc.abstractlayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public class ALOperateDB {
	
	ContentResolver m_resolver;
	private static final String[] PHONES_PROJECTION=new String[]{Phone.DISPLAY_NAME,Phone.NUMBER};
	  /**联系人显示名称**/  
	public static final int PHONES_DISPLAY_NAME_INDEX = 0;   
	  /**电话号码**/  
	public static final int PHONES_NUMBER_INDEX = 1;  
	
	public ALOperateDB(ContentResolver resolver)
	{
		m_resolver=resolver;
	}		

	//Retrieve contact's information include name,number
	public  Cursor getAllContact()
	{
		Cursor cur = m_resolver.query(Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);

		return cur;
		
	}
}
