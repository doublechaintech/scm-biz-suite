
package com.doublechaintech.retailscm.consumerorderpriceadjustment;
import com.doublechaintech.retailscm.AccessKey;


public class ConsumerOrderPriceAdjustmentTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="consumer_order_price_adjustment_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_PROVIDER = "provider";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_BIZ_ORDER,COLUMN_AMOUNT,COLUMN_PROVIDER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_BIZ_ORDER,COLUMN_AMOUNT,COLUMN_PROVIDER};
	
	
}


