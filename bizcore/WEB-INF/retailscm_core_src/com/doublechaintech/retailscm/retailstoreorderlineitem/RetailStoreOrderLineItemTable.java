
package com.doublechaintech.retailscm.retailstoreorderlineitem;
import com.doublechaintech.retailscm.AccessKey;


public class RetailStoreOrderLineItemTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_order_line_item_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_SKU_ID = "sku_id";
	static final String COLUMN_SKU_NAME = "sku_name";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_QUANTITY = "quantity";
	static final String COLUMN_UNIT_OF_MEASUREMENT = "unit_of_measurement";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_BIZ_ORDER,COLUMN_SKU_ID,COLUMN_SKU_NAME,COLUMN_AMOUNT,COLUMN_QUANTITY,COLUMN_UNIT_OF_MEASUREMENT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_BIZ_ORDER,COLUMN_SKU_ID,COLUMN_SKU_NAME,COLUMN_AMOUNT,COLUMN_QUANTITY,COLUMN_UNIT_OF_MEASUREMENT};
	
	
}


