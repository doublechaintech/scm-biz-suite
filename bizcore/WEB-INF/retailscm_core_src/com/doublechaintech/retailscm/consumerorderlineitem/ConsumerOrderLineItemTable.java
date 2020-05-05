
package com.doublechaintech.retailscm.consumerorderlineitem;
import com.doublechaintech.retailscm.AccessKey;


public class ConsumerOrderLineItemTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="consumer_order_line_item_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_SKU_ID = "sku_id";
	static final String COLUMN_SKU_NAME = "sku_name";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_QUANTITY = "quantity";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_BIZ_ORDER,COLUMN_SKU_ID,COLUMN_SKU_NAME,COLUMN_PRICE,COLUMN_QUANTITY,COLUMN_AMOUNT,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_BIZ_ORDER,COLUMN_SKU_ID,COLUMN_SKU_NAME,COLUMN_PRICE,COLUMN_QUANTITY,COLUMN_AMOUNT,COLUMN_LAST_UPDATE_TIME};
	
	
}


