
package com.doublechaintech.retailscm.consumerorder;
import com.doublechaintech.retailscm.AccessKey;


public class ConsumerOrderTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="consumer_order_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_CONSUMER = "consumer";
	static final String COLUMN_CONFIRMATION = "confirmation";
	static final String COLUMN_APPROVAL = "approval";
	static final String COLUMN_PROCESSING = "processing";
	static final String COLUMN_SHIPMENT = "shipment";
	static final String COLUMN_DELIVERY = "delivery";
	static final String COLUMN_STORE = "store";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_CURRENT_STATUS = "current_status";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_CONSUMER, COLUMN_CONFIRMATION, COLUMN_APPROVAL, COLUMN_PROCESSING, COLUMN_SHIPMENT, COLUMN_DELIVERY, COLUMN_STORE, COLUMN_LAST_UPDATE_TIME, COLUMN_CURRENT_STATUS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_CONSUMER, COLUMN_CONFIRMATION, COLUMN_APPROVAL, COLUMN_PROCESSING, COLUMN_SHIPMENT, COLUMN_DELIVERY, COLUMN_STORE, COLUMN_LAST_UPDATE_TIME, COLUMN_CURRENT_STATUS
		};
	
	
}


