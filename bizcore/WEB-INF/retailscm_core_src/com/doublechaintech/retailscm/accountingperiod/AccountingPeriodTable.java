
package com.doublechaintech.retailscm.accountingperiod;
import com.doublechaintech.retailscm.AccessKey;


public class AccountingPeriodTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="accounting_period_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_START_DATE = "start_date";
	static final String COLUMN_END_DATE = "end_date";
	static final String COLUMN_ACCOUNT_SET = "account_set";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_START_DATE,COLUMN_END_DATE,COLUMN_ACCOUNT_SET,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_START_DATE,COLUMN_END_DATE,COLUMN_ACCOUNT_SET};
	
	
}


