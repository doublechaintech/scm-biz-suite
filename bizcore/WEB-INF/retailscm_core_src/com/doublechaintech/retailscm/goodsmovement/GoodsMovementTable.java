
package com.doublechaintech.retailscm.goodsmovement;
import com.doublechaintech.retailscm.AccessKey;


public class GoodsMovementTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_movement_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_MOVE_TIME = "move_time";
	static final String COLUMN_FACILITY = "facility";
	static final String COLUMN_FACILITY_ID = "facility_id";
	static final String COLUMN_FROM_IP = "from_ip";
	static final String COLUMN_USER_AGENT = "user_agent";
	static final String COLUMN_SESSION_ID = "session_id";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_GOODS = "goods";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_MOVE_TIME,COLUMN_FACILITY,COLUMN_FACILITY_ID,COLUMN_FROM_IP,COLUMN_USER_AGENT,COLUMN_SESSION_ID,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_GOODS,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_MOVE_TIME,COLUMN_FACILITY,COLUMN_FACILITY_ID,COLUMN_FROM_IP,COLUMN_USER_AGENT,COLUMN_SESSION_ID,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_GOODS};
	
	
}


