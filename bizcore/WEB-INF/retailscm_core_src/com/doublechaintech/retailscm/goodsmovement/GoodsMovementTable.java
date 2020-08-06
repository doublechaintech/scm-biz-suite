
package com.doublechaintech.retailscm.goodsmovement;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

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

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "goods_movement_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"move_time","datetime","","移动时间","",""},
                new String[]{"facility","varchar(16)","","设施","",""},
                new String[]{"facility_id","varchar(16)","","设备ID","",""},
                new String[]{"from_ip","varchar(48)","","从IP","",""},
                new String[]{"user_agent","varchar(444)","","用户代理","",""},
                new String[]{"session_id","varchar(80)","","会话ID","",""},
                new String[]{"latitude","numeric(9,6)","","纬度","",""},
                new String[]{"longitude","numeric(10,6)","","经度","",""},
                new String[]{"goods","varchar(48)","","货物","goods_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "货物移动", new String[]{
                "create unique index idx4id_ver_of_goods_movement on goods_movement_data (id, version);",
                "create  index idx4move_time_of_goods_movement on goods_movement_data (move_time);",
                "create  index idx4facility_id_of_goods_movement on goods_movement_data (facility_id);",
                "create  index idx4session_id_of_goods_movement on goods_movement_data (session_id);",
                "create  index idx4latitude_of_goods_movement on goods_movement_data (latitude);",
                "create  index idx4longitude_of_goods_movement on goods_movement_data (longitude);"
         }, new String[]{
                "alter table goods_movement_data add constraint pk4id_of_goods_movement_data primary key (id);",
                "alter table goods_movement_data add constraint fk4goods_of_goods_movement_data foreign key (goods) references goods_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


