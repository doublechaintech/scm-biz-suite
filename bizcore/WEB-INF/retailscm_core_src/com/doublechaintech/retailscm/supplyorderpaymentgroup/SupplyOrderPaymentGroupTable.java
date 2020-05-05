
package com.doublechaintech.retailscm.supplyorderpaymentgroup;
import com.doublechaintech.retailscm.AccessKey;


public class SupplyOrderPaymentGroupTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="supply_order_payment_group_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_CARD_NUMBER = "card_number";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_BIZ_ORDER,COLUMN_CARD_NUMBER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_BIZ_ORDER,COLUMN_CARD_NUMBER};
	
	
}


