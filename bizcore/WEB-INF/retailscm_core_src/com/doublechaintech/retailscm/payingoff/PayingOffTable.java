
package com.doublechaintech.retailscm.payingoff;
import com.doublechaintech.retailscm.AccessKey;


public class PayingOffTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="paying_off_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_PAID_FOR = "paid_for";
	static final String COLUMN_PAID_TIME = "paid_time";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_WHO,COLUMN_PAID_FOR,COLUMN_PAID_TIME,COLUMN_AMOUNT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_WHO,COLUMN_PAID_FOR,COLUMN_PAID_TIME,COLUMN_AMOUNT};
	
	
}


