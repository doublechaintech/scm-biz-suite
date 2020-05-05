
package com.doublechaintech.retailscm.employeeeducation;
import com.doublechaintech.retailscm.AccessKey;


public class EmployeeEducationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="employee_education_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_EMPLOYEE = "employee";
	static final String COLUMN_COMPLETE_TIME = "complete_time";
	static final String COLUMN_TYPE = "type";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_EMPLOYEE,COLUMN_COMPLETE_TIME,COLUMN_TYPE,COLUMN_REMARK,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_EMPLOYEE,COLUMN_COMPLETE_TIME,COLUMN_TYPE,COLUMN_REMARK};
	
	
}


