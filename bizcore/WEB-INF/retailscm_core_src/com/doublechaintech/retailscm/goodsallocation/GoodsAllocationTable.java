
package com.doublechaintech.retailscm.goodsallocation;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class GoodsAllocationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_allocation_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_GOODS_SHELF = "goods_shelf";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_LOCATION,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_GOODS_SHELF,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_LOCATION,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_GOODS_SHELF};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "goods_allocation_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"location","varchar(84)","","位置","",""},
                new String[]{"latitude","numeric(9,6)","","纬度","",""},
                new String[]{"longitude","numeric(10,6)","","经度","",""},
                new String[]{"goods_shelf","varchar(48)","","货架","goods_shelf_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "货位", new String[]{
                "create unique index idx4id_ver_of_goods_allocation on goods_allocation_data (id, version);",
                "create  index idx4latitude_of_goods_allocation on goods_allocation_data (latitude);",
                "create  index idx4longitude_of_goods_allocation on goods_allocation_data (longitude);"
         }, new String[]{
                "alter table goods_allocation_data add constraint pk4id_of_goods_allocation_data primary key (id);",
                "alter table goods_allocation_data add constraint fk4goods_shelf_of_goods_allocation_data foreign key (goods_shelf) references goods_shelf_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


