
package com.doublechaintech.retailscm.loginhistory;
import com.doublechaintech.retailscm.AccessKey;


public class LoginHistoryTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="login_history_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOGIN_TIME = "login_time";
	static final String COLUMN_FROM_IP = "from_ip";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_LOGIN_TIME,COLUMN_FROM_IP,COLUMN_DESCRIPTION,COLUMN_SEC_USER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_LOGIN_TIME,COLUMN_FROM_IP,COLUMN_DESCRIPTION,COLUMN_SEC_USER};
	
	
}


