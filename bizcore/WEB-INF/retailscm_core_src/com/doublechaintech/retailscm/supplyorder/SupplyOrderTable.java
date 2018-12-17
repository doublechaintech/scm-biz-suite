
package com.doublechaintech.retailscm.supplyorder;
import com.doublechaintech.retailscm.AccessKey;


public class SupplyOrderTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="supply_order_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_BUYER = "buyer";
	static final String COLUMN_SELLER = "seller";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_TOTAL_AMOUNT = "total_amount";
	static final String COLUMN_CONFIRMATION = "confirmation";
	static final String COLUMN_APPROVAL = "approval";
	static final String COLUMN_PROCESSING = "processing";
	static final String COLUMN_PICKING = "picking";
	static final String COLUMN_SHIPMENT = "shipment";
	static final String COLUMN_DELIVERY = "delivery";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_CURRENT_STATUS = "current_status";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_BUYER, COLUMN_SELLER, COLUMN_TITLE, COLUMN_TOTAL_AMOUNT, COLUMN_CONFIRMATION, COLUMN_APPROVAL, COLUMN_PROCESSING, COLUMN_PICKING, COLUMN_SHIPMENT, COLUMN_DELIVERY, COLUMN_LAST_UPDATE_TIME, COLUMN_CURRENT_STATUS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_BUYER, COLUMN_SELLER, COLUMN_TITLE, COLUMN_TOTAL_AMOUNT, COLUMN_CONFIRMATION, COLUMN_APPROVAL, COLUMN_PROCESSING, COLUMN_PICKING, COLUMN_SHIPMENT, COLUMN_DELIVERY, COLUMN_LAST_UPDATE_TIME, COLUMN_CURRENT_STATUS
		};
	
	
}


