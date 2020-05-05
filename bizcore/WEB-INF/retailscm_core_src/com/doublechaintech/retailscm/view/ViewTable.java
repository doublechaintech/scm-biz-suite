
package com.doublechaintech.retailscm.view;
import com.doublechaintech.retailscm.AccessKey;


public class ViewTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="view_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_ASSESSMENT = "assessment";
	static final String COLUMN_INTERVIEW_TIME = "interview_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_WHO,COLUMN_ASSESSMENT,COLUMN_INTERVIEW_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_WHO,COLUMN_ASSESSMENT,COLUMN_INTERVIEW_TIME};
	
	
}


