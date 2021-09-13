
package com.doublechaintech.retailscm.warehouse;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class WarehouseTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="warehouse_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_TOTAL_AREA = "total_area";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_CONTRACT = "contract";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_LOCATION,COLUMN_CONTACT_NUMBER,COLUMN_TOTAL_AREA,COLUMN_OWNER,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_CONTRACT,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_LOCATION,COLUMN_CONTACT_NUMBER,COLUMN_TOTAL_AREA,COLUMN_OWNER,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_CONTRACT,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "warehouse_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"location","varchar(44)","","位置","",""},
                new String[]{"contact_number","varchar(48)","","联系电话","",""},
                new String[]{"total_area","varchar(36)","","总面积","",""},
                new String[]{"owner","varchar(48)","","业主","retail_store_country_center_data","id"},
                new String[]{"latitude","numeric(9,6)","","纬度","",""},
                new String[]{"longitude","numeric(10,6)","","经度","",""},
                new String[]{"contract","varchar(1024)","","合同","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "仓库", new String[]{
                "create unique index idx4id_ver_of_warehouse on warehouse_data (id, version);",
                "create  index idx4latitude_of_warehouse on warehouse_data (latitude);",
                "create  index idx4longitude_of_warehouse on warehouse_data (longitude);",
                "create  index idx4last_update_time_of_warehouse on warehouse_data (last_update_time);"
         }, new String[]{
                "alter table warehouse_data add constraint pk4id_of_warehouse_data primary key (id);",
                "alter table warehouse_data add constraint fk4owner_of_warehouse_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


