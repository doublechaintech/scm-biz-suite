
package com.doublechaintech.retailscm.userapp;
import com.doublechaintech.retailscm.AccessKey;


public class UserAppTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="user_app_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_APP_ICON = "app_icon";
	static final String COLUMN_FULL_ACCESS = "full_access";
	static final String COLUMN_PERMISSION = "permission";
	static final String COLUMN_OBJECT_TYPE = "object_type";
	static final String COLUMN_OBJECT_ID = "object_id";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_SEC_USER,COLUMN_APP_ICON,COLUMN_FULL_ACCESS,COLUMN_PERMISSION,COLUMN_OBJECT_TYPE,COLUMN_OBJECT_ID,COLUMN_LOCATION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_SEC_USER,COLUMN_APP_ICON,COLUMN_FULL_ACCESS,COLUMN_PERMISSION,COLUMN_OBJECT_TYPE,COLUMN_OBJECT_ID,COLUMN_LOCATION};
	
	
}


