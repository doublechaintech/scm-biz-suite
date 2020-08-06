
package com.doublechaintech.retailscm.supplyorder;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SupplyOrderTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="supply_order_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_BUYER = "buyer";
	static final String COLUMN_SELLER = "seller";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_TOTAL_AMOUNT = "total_amount";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_BUYER,COLUMN_SELLER,COLUMN_TITLE,COLUMN_TOTAL_AMOUNT,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_BUYER,COLUMN_SELLER,COLUMN_TITLE,COLUMN_TOTAL_AMOUNT,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "supply_order_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"buyer","varchar(48)","","买方","retail_store_country_center_data","id"},
                new String[]{"seller","varchar(48)","","卖方","goods_supplier_data","id"},
                new String[]{"title","varchar(40)","","头衔","",""},
                new String[]{"total_amount","numeric(14,2)","","总金额","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "供应订单", new String[]{
                "create unique index idx4id_ver_of_supply_order on supply_order_data (id, version);",
                "create  index idx4total_amount_of_supply_order on supply_order_data (total_amount);",
                "create  index idx4last_update_time_of_supply_order on supply_order_data (last_update_time);"
         }, new String[]{
                "alter table supply_order_data add constraint pk4id_of_supply_order_data primary key (id);",
                "alter table supply_order_data add constraint fk4buyer_of_supply_order_data foreign key (buyer) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table supply_order_data add constraint fk4seller_of_supply_order_data foreign key (seller) references goods_supplier_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


