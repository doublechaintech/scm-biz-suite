
package com.doublechaintech.retailscm.retailstoreorderapproval;
import com.doublechaintech.retailscm.AccessKey;


public class RetailStoreOrderApprovalTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="retail_store_order_approval_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_APPROVE_TIME = "approve_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_WHO, COLUMN_APPROVE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_WHO, COLUMN_APPROVE_TIME
		};
	
	
}


