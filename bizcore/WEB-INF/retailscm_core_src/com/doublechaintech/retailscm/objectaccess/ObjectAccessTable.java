
package com.doublechaintech.retailscm.objectaccess;
import com.doublechaintech.retailscm.AccessKey;


public class ObjectAccessTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="object_access_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_OBJECT_TYPE = "object_type";
	static final String COLUMN_LIST1 = "list1";
	static final String COLUMN_LIST2 = "list2";
	static final String COLUMN_LIST3 = "list3";
	static final String COLUMN_LIST4 = "list4";
	static final String COLUMN_LIST5 = "list5";
	static final String COLUMN_LIST6 = "list6";
	static final String COLUMN_LIST7 = "list7";
	static final String COLUMN_LIST8 = "list8";
	static final String COLUMN_LIST9 = "list9";
	static final String COLUMN_APP = "app";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_OBJECT_TYPE, COLUMN_LIST1, COLUMN_LIST2, COLUMN_LIST3, COLUMN_LIST4, COLUMN_LIST5, COLUMN_LIST6, COLUMN_LIST7, COLUMN_LIST8, COLUMN_LIST9, COLUMN_APP, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_OBJECT_TYPE, COLUMN_LIST1, COLUMN_LIST2, COLUMN_LIST3, COLUMN_LIST4, COLUMN_LIST5, COLUMN_LIST6, COLUMN_LIST7, COLUMN_LIST8, COLUMN_LIST9, COLUMN_APP
		};
	
	
}


