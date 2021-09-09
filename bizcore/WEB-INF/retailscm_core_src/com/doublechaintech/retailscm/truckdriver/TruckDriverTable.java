
package com.doublechaintech.retailscm.truckdriver;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class TruckDriverTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="truck_driver_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_DRIVER_LICENSE_NUMBER = "driver_license_number";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_BELONGS_TO = "belongs_to";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_DRIVER_LICENSE_NUMBER,COLUMN_CONTACT_NUMBER,COLUMN_BELONGS_TO,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_DRIVER_LICENSE_NUMBER,COLUMN_CONTACT_NUMBER,COLUMN_BELONGS_TO};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "truck_driver_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(24)","","名称","",""},
                new String[]{"driver_license_number","varchar(52)","","驾驶执照号码","",""},
                new String[]{"contact_number","varchar(44)","","联系电话","",""},
                new String[]{"belongs_to","varchar(48)","","属于","transport_fleet_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "卡车司机", new String[]{
                "create unique index idx4id_ver_of_truck_driver on truck_driver_data (id, version);",
                "create  index idx4contact_number_of_truck_driver on truck_driver_data (contact_number);"
         }, new String[]{
                "alter table truck_driver_data add constraint pk4id_of_truck_driver_data primary key (id);",
                "alter table truck_driver_data add constraint fk4belongs_to_of_truck_driver_data foreign key (belongs_to) references transport_fleet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


