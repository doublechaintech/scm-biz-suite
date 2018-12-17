
package com.doublechaintech.retailscm.employeeboarding;
import com.doublechaintech.retailscm.AccessKey;


public class EmployeeBoardingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="employee_boarding_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_EMPLOY_TIME = "employ_time";
	static final String COLUMN_COMMENTS = "comments";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_WHO, COLUMN_EMPLOY_TIME, COLUMN_COMMENTS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_WHO, COLUMN_EMPLOY_TIME, COLUMN_COMMENTS
		};
	
	
}


