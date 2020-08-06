
package com.doublechaintech.retailscm.consumerordershippinggroup;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ConsumerOrderShippingGroupTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="consumer_order_shipping_group_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_BIZ_ORDER,COLUMN_AMOUNT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_BIZ_ORDER,COLUMN_AMOUNT};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "consumer_order_shipping_group_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(24)","","名称","",""},
                new String[]{"biz_order","varchar(48)","","订单","consumer_order_data","id"},
                new String[]{"amount","numeric(7,2)","","金额","",""},
                new String[]{"version","int","","版本","",""}
            }, "消费订单送货分组", new String[]{
                "create unique index idx4id_ver_of_consumer_order_shipping_group on consumer_order_shipping_group_data (id, version);",
                "create  index idx4amount_of_consumer_order_shipping_group on consumer_order_shipping_group_data (amount);"
         }, new String[]{
                "alter table consumer_order_shipping_group_data add constraint pk4id_of_consumer_order_shipping_group_data primary key (id);",
                "alter table consumer_order_shipping_group_data add constraint fk4biz_order_of_consumer_order_shipping_group_data foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


