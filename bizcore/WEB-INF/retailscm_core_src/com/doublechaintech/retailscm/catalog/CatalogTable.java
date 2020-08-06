
package com.doublechaintech.retailscm.catalog;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class CatalogTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="catalog_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_SUB_COUNT = "sub_count";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_OWNER,COLUMN_SUB_COUNT,COLUMN_AMOUNT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_OWNER,COLUMN_SUB_COUNT,COLUMN_AMOUNT};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "catalog_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(201)","","名称","",""},
                new String[]{"owner","varchar(48)","","业主","retail_store_country_center_data","id"},
                new String[]{"sub_count","int","","子数","",""},
                new String[]{"amount","numeric(6,2)","","金额","",""},
                new String[]{"version","int","","版本","",""}
            }, "目录", new String[]{
                "create unique index idx4id_ver_of_catalog on catalog_data (id, version);",
                "create  index idx4sub_count_of_catalog on catalog_data (sub_count);",
                "create  index idx4amount_of_catalog on catalog_data (amount);"
         }, new String[]{
                "alter table catalog_data add constraint pk4id_of_catalog_data primary key (id);",
                "alter table catalog_data add constraint fk4owner_of_catalog_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


