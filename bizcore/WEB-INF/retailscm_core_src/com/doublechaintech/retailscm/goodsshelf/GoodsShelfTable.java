
package com.doublechaintech.retailscm.goodsshelf;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class GoodsShelfTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_shelf_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_STORAGE_SPACE = "storage_space";
	static final String COLUMN_SUPPLIER_SPACE = "supplier_space";
	static final String COLUMN_DAMAGE_SPACE = "damage_space";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_LOCATION,COLUMN_STORAGE_SPACE,COLUMN_SUPPLIER_SPACE,COLUMN_DAMAGE_SPACE,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_LOCATION,COLUMN_STORAGE_SPACE,COLUMN_SUPPLIER_SPACE,COLUMN_DAMAGE_SPACE,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "goods_shelf_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"location","varchar(64)","","位置","",""},
                new String[]{"storage_space","varchar(48)","","存货区","storage_space_data","id"},
                new String[]{"supplier_space","varchar(48)","","供应商的空间","supplier_space_data","id"},
                new String[]{"damage_space","varchar(48)","","残次货物存放区","damage_space_data","id"},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "货架", new String[]{
                "create unique index idx4id_ver_of_goods_shelf on goods_shelf_data (id, version);",
                "create  index idx4last_update_time_of_goods_shelf on goods_shelf_data (last_update_time);"
         }, new String[]{
                "alter table goods_shelf_data add constraint pk4id_of_goods_shelf_data primary key (id);",
                "alter table goods_shelf_data add constraint fk4storage_space_of_goods_shelf_data foreign key (storage_space) references storage_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_shelf_data add constraint fk4supplier_space_of_goods_shelf_data foreign key (supplier_space) references supplier_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_shelf_data add constraint fk4damage_space_of_goods_shelf_data foreign key (damage_space) references damage_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


