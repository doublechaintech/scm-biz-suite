
package com.doublechaintech.retailscm.goods;
import com.doublechaintech.retailscm.AccessKey;


public class GoodsTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_RFID = "rfid";
	static final String COLUMN_UOM = "uom";
	static final String COLUMN_MAX_PACKAGE = "max_package";
	static final String COLUMN_EXPIRE_TIME = "expire_time";
	static final String COLUMN_SKU = "sku";
	static final String COLUMN_RECEIVING_SPACE = "receiving_space";
	static final String COLUMN_GOODS_ALLOCATION = "goods_allocation";
	static final String COLUMN_SMART_PALLET = "smart_pallet";
	static final String COLUMN_SHIPPING_SPACE = "shipping_space";
	static final String COLUMN_TRANSPORT_TASK = "transport_task";
	static final String COLUMN_RETAIL_STORE = "retail_store";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_RETAIL_STORE_ORDER = "retail_store_order";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_RFID,COLUMN_UOM,COLUMN_MAX_PACKAGE,COLUMN_EXPIRE_TIME,COLUMN_SKU,COLUMN_RECEIVING_SPACE,COLUMN_GOODS_ALLOCATION,COLUMN_SMART_PALLET,COLUMN_SHIPPING_SPACE,COLUMN_TRANSPORT_TASK,COLUMN_RETAIL_STORE,COLUMN_BIZ_ORDER,COLUMN_RETAIL_STORE_ORDER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_RFID,COLUMN_UOM,COLUMN_MAX_PACKAGE,COLUMN_EXPIRE_TIME,COLUMN_SKU,COLUMN_RECEIVING_SPACE,COLUMN_GOODS_ALLOCATION,COLUMN_SMART_PALLET,COLUMN_SHIPPING_SPACE,COLUMN_TRANSPORT_TASK,COLUMN_RETAIL_STORE,COLUMN_BIZ_ORDER,COLUMN_RETAIL_STORE_ORDER};
	
	
}


