
package com.doublechaintech.retailscm.transporttasktrack;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

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

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "transport_task_track_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"track_time","date","","跟踪时间","",""},
                new String[]{"latitude","numeric(9,6)","","纬度","",""},
                new String[]{"longitude","numeric(10,6)","","经度","",""},
                new String[]{"movement","varchar(48)","","运动","transport_task_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "运输任务跟踪", new String[]{
                "create unique index idx4id_ver_of_transport_task_track on transport_task_track_data (id, version);",
                "create  index idx4track_time_of_transport_task_track on transport_task_track_data (track_time);",
                "create  index idx4latitude_of_transport_task_track on transport_task_track_data (latitude);",
                "create  index idx4longitude_of_transport_task_track on transport_task_track_data (longitude);"
         }, new String[]{
                "alter table transport_task_track_data add constraint pk4id_of_transport_task_track_data primary key (id);",
                "alter table transport_task_track_data add constraint fk4movement_of_transport_task_track_data foreign key (movement) references transport_task_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


