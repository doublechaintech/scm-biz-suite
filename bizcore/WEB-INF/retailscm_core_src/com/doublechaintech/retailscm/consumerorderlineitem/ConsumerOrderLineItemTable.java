
package com.doublechaintech.retailscm.consumerorderlineitem;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ConsumerOrderLineItemTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="consumer_order_line_item_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_SKU_ID = "sku_id";
	static final String COLUMN_SKU_NAME = "sku_name";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_QUANTITY = "quantity";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_BIZ_ORDER,COLUMN_SKU_ID,COLUMN_SKU_NAME,COLUMN_PRICE,COLUMN_QUANTITY,COLUMN_AMOUNT,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_BIZ_ORDER,COLUMN_SKU_ID,COLUMN_SKU_NAME,COLUMN_PRICE,COLUMN_QUANTITY,COLUMN_AMOUNT,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "consumer_order_line_item_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"biz_order","varchar(48)","","订单","consumer_order_data","id"},
                new String[]{"sku_id","varchar(12)","","产品ID","",""},
                new String[]{"sku_name","varchar(16)","","产品名称","",""},
                new String[]{"price","numeric(5,2)","","价格","",""},
                new String[]{"quantity","numeric(7,2)","","数量","",""},
                new String[]{"amount","numeric(8,2)","","金额","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "消费者订单行项目", new String[]{
                "create unique index idx4id_ver_of_consumer_order_line_item on consumer_order_line_item_data (id, version);",
                "create  index idx4sku_id_of_consumer_order_line_item on consumer_order_line_item_data (sku_id);",
                "create  index idx4price_of_consumer_order_line_item on consumer_order_line_item_data (price);",
                "create  index idx4quantity_of_consumer_order_line_item on consumer_order_line_item_data (quantity);",
                "create  index idx4amount_of_consumer_order_line_item on consumer_order_line_item_data (amount);",
                "create  index idx4last_update_time_of_consumer_order_line_item on consumer_order_line_item_data (last_update_time);"
         }, new String[]{
                "alter table consumer_order_line_item_data add constraint pk4id_of_consumer_order_line_item_data primary key (id);",
                "alter table consumer_order_line_item_data add constraint fk4biz_order_of_consumer_order_line_item_data foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


