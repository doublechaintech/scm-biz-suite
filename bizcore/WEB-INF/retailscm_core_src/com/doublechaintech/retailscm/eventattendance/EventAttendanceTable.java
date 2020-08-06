
package com.doublechaintech.retailscm.eventattendance;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EventAttendanceTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="event_attendance_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_POTENTIAL_CUSTOMER = "potential_customer";
	static final String COLUMN_CITY_EVENT = "city_event";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_POTENTIAL_CUSTOMER,COLUMN_CITY_EVENT,COLUMN_DESCRIPTION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_POTENTIAL_CUSTOMER,COLUMN_CITY_EVENT,COLUMN_DESCRIPTION};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "event_attendance_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(36)","","名称","",""},
                new String[]{"potential_customer","varchar(48)","","潜在的客户","potential_customer_data","id"},
                new String[]{"city_event","varchar(48)","","城市活动","city_event_data","id"},
                new String[]{"description","varchar(36)","","描述","",""},
                new String[]{"version","int","","版本","",""}
            }, "活动的参与情况", new String[]{
                "create unique index idx4id_ver_of_event_attendance on event_attendance_data (id, version);"
         }, new String[]{
                "alter table event_attendance_data add constraint pk4id_of_event_attendance_data primary key (id);",
                "alter table event_attendance_data add constraint fk4potential_customer_of_event_attendance_data foreign key (potential_customer) references potential_customer_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table event_attendance_data add constraint fk4city_event_of_event_attendance_data foreign key (city_event) references city_event_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


