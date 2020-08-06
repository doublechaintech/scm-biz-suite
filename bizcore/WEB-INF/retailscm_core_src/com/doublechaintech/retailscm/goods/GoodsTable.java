
package com.doublechaintech.retailscm.goods;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class GoodsTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_RFID = "rfid";
	static final String COLUMN_UOM = "uom";
	static final String COLUMN_MAX_PACKAGE = "max_package";
	static final String COLUMN_EXPIRE_TIME = "expire_time";
	static final String COLUMN_SKU = "sku";
	static final String COLUMN_RECEIVING_SPACE = "receiving_space";
	static final String COLUMN_GOODS_ALLOCATION = "goods_allocation";
	static final String COLUMN_SMART_PALLET = "smart_pallet";
	static final String COLUMN_SHIPPING_SPACE = "shipping_space";
	static final String COLUMN_TRANSPORT_TASK = "transport_task";
	static final String COLUMN_RETAIL_STORE = "retail_store";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_RETAIL_STORE_ORDER = "retail_store_order";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_RFID,COLUMN_UOM,COLUMN_MAX_PACKAGE,COLUMN_EXPIRE_TIME,COLUMN_SKU,COLUMN_RECEIVING_SPACE,COLUMN_GOODS_ALLOCATION,COLUMN_SMART_PALLET,COLUMN_SHIPPING_SPACE,COLUMN_TRANSPORT_TASK,COLUMN_RETAIL_STORE,COLUMN_BIZ_ORDER,COLUMN_RETAIL_STORE_ORDER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_RFID,COLUMN_UOM,COLUMN_MAX_PACKAGE,COLUMN_EXPIRE_TIME,COLUMN_SKU,COLUMN_RECEIVING_SPACE,COLUMN_GOODS_ALLOCATION,COLUMN_SMART_PALLET,COLUMN_SHIPPING_SPACE,COLUMN_TRANSPORT_TASK,COLUMN_RETAIL_STORE,COLUMN_BIZ_ORDER,COLUMN_RETAIL_STORE_ORDER};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "goods_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(16)","","名称","",""},
                new String[]{"rfid","varchar(28)","","RFID","",""},
                new String[]{"uom","varchar(4)","","计量单位","",""},
                new String[]{"max_package","int","","最大包装","",""},
                new String[]{"expire_time","date","","到期时间","",""},
                new String[]{"sku","varchar(48)","","SKU","sku_data","id"},
                new String[]{"receiving_space","varchar(48)","","收货区","receiving_space_data","id"},
                new String[]{"goods_allocation","varchar(48)","","货位","goods_allocation_data","id"},
                new String[]{"smart_pallet","varchar(48)","","智能托盘","smart_pallet_data","id"},
                new String[]{"shipping_space","varchar(48)","","发货区","shipping_space_data","id"},
                new String[]{"transport_task","varchar(48)","","运输任务","transport_task_data","id"},
                new String[]{"retail_store","varchar(48)","","双链小超","retail_store_data","id"},
                new String[]{"biz_order","varchar(48)","","订单","supply_order_data","id"},
                new String[]{"retail_store_order","varchar(48)","","生超的订单","retail_store_order_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "货物", new String[]{
                "create unique index idx4id_ver_of_goods on goods_data (id, version);",
                "create  index idx4max_package_of_goods on goods_data (max_package);",
                "create  index idx4expire_time_of_goods on goods_data (expire_time);"
         }, new String[]{
                "alter table goods_data add constraint pk4id_of_goods_data primary key (id);",
                "alter table goods_data add constraint fk4sku_of_goods_data foreign key (sku) references sku_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4receiving_space_of_goods_data foreign key (receiving_space) references receiving_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4goods_allocation_of_goods_data foreign key (goods_allocation) references goods_allocation_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4smart_pallet_of_goods_data foreign key (smart_pallet) references smart_pallet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4shipping_space_of_goods_data foreign key (shipping_space) references shipping_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4transport_task_of_goods_data foreign key (transport_task) references transport_task_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4retail_store_of_goods_data foreign key (retail_store) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4biz_order_of_goods_data foreign key (biz_order) references supply_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table goods_data add constraint fk4retail_store_order_of_goods_data foreign key (retail_store_order) references retail_store_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


