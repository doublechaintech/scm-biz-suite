
package com.doublechaintech.retailscm.transportfleet;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class TransportFleetTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="transport_fleet_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_CONTRACT = "contract";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CONTACT_NUMBER,COLUMN_OWNER,COLUMN_CONTRACT,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CONTACT_NUMBER,COLUMN_OWNER,COLUMN_CONTRACT,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "transport_fleet_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(28)","","名称","",""},
                new String[]{"contact_number","varchar(48)","","联系电话","",""},
                new String[]{"owner","varchar(48)","","业主","retail_store_country_center_data","id"},
                new String[]{"contract","varchar(1024)","","合同","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "运输车队", new String[]{
                "create unique index idx4id_ver_of_transport_fleet on transport_fleet_data (id, version);",
                "create  index idx4last_update_time_of_transport_fleet on transport_fleet_data (last_update_time);"
         }, new String[]{
                "alter table transport_fleet_data add constraint pk4id_of_transport_fleet_data primary key (id);",
                "alter table transport_fleet_data add constraint fk4owner_of_transport_fleet_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


