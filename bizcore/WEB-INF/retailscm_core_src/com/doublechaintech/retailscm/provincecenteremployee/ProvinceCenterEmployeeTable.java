
package com.doublechaintech.retailscm.provincecenteremployee;
import com.doublechaintech.retailscm.AccessKey;


public class ProvinceCenterEmployeeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="province_center_employee_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_MOBILE = "mobile";
	static final String COLUMN_EMAIL = "email";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_DEPARTMENT = "department";
	static final String COLUMN_PROVINCE_CENTER = "province_center";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_MOBILE,COLUMN_EMAIL,COLUMN_FOUNDED,COLUMN_DEPARTMENT,COLUMN_PROVINCE_CENTER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_MOBILE,COLUMN_EMAIL,COLUMN_FOUNDED,COLUMN_DEPARTMENT,COLUMN_PROVINCE_CENTER};
	
	
}


