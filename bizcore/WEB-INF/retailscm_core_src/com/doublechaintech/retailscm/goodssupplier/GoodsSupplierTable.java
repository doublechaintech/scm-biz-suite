
package com.doublechaintech.retailscm.goodssupplier;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class GoodsSupplierTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_supplier_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SUPPLY_PRODUCT = "supply_product";
	static final String COLUMN_BELONG_TO = "belong_to";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_SUPPLY_PRODUCT,COLUMN_BELONG_TO,COLUMN_CONTACT_NUMBER,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_SUPPLY_PRODUCT,COLUMN_BELONG_TO,COLUMN_CONTACT_NUMBER,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "goods_supplier_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(12)","","名称","",""},
                new String[]{"supply_product","varchar(16)","","供应产品","",""},
                new String[]{"belong_to","varchar(48)","","属于","retail_store_country_center_data","id"},
                new String[]{"contact_number","varchar(44)","","联系电话","",""},
                new String[]{"description","varchar(72)","","描述","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "产品供应商", new String[]{
                "create unique index idx4id_ver_of_goods_supplier on goods_supplier_data (id, version);",
                "create  index idx4contact_number_of_goods_supplier on goods_supplier_data (contact_number);",
                "create  index idx4last_update_time_of_goods_supplier on goods_supplier_data (last_update_time);"
         }, new String[]{
                "alter table goods_supplier_data add constraint pk4id_of_goods_supplier_data primary key (id);",
                "alter table goods_supplier_data add constraint fk4belong_to_of_goods_supplier_data foreign key (belong_to) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


