
package com.doublechaintech.retailscm.transporttasktrack;
import com.doublechaintech.retailscm.AccessKey;


public class TransportTaskTrackTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="transport_task_track_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TRACK_TIME = "track_time";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_MOVEMENT = "movement";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TRACK_TIME,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_MOVEMENT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TRACK_TIME,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_MOVEMENT};
	
	
}


