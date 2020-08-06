
package com.doublechaintech.retailscm.transporttruck;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class TransportTruckTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="transport_truck_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PLATE_NUMBER = "plate_number";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_VEHICLE_LICENSE_NUMBER = "vehicle_license_number";
	static final String COLUMN_ENGINE_NUMBER = "engine_number";
	static final String COLUMN_MAKE_DATE = "make_date";
	static final String COLUMN_MILEAGE = "mileage";
	static final String COLUMN_BODY_COLOR = "body_color";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_PLATE_NUMBER,COLUMN_CONTACT_NUMBER,COLUMN_VEHICLE_LICENSE_NUMBER,COLUMN_ENGINE_NUMBER,COLUMN_MAKE_DATE,COLUMN_MILEAGE,COLUMN_BODY_COLOR,COLUMN_OWNER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_PLATE_NUMBER,COLUMN_CONTACT_NUMBER,COLUMN_VEHICLE_LICENSE_NUMBER,COLUMN_ENGINE_NUMBER,COLUMN_MAKE_DATE,COLUMN_MILEAGE,COLUMN_BODY_COLOR,COLUMN_OWNER};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "transport_truck_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(16)","","名称","",""},
                new String[]{"plate_number","varchar(16)","","车牌号码","",""},
                new String[]{"contact_number","varchar(48)","","联系电话","",""},
                new String[]{"vehicle_license_number","varchar(24)","","汽车牌照号码","",""},
                new String[]{"engine_number","varchar(28)","","发动机号","",""},
                new String[]{"make_date","date","","制造日期","",""},
                new String[]{"mileage","varchar(24)","","里程","",""},
                new String[]{"body_color","varchar(8)","","车身颜色","",""},
                new String[]{"owner","varchar(48)","","业主","transport_fleet_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "运输车", new String[]{
                "create unique index idx4id_ver_of_transport_truck on transport_truck_data (id, version);",
                "create  index idx4make_date_of_transport_truck on transport_truck_data (make_date);"
         }, new String[]{
                "alter table transport_truck_data add constraint pk4id_of_transport_truck_data primary key (id);",
                "alter table transport_truck_data add constraint fk4owner_of_transport_truck_data foreign key (owner) references transport_fleet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


