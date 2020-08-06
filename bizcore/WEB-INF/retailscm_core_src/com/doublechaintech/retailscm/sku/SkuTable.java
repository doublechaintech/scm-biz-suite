
package com.doublechaintech.retailscm.sku;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SkuTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="sku_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SIZE = "size";
	static final String COLUMN_PRODUCT = "product";
	static final String COLUMN_BARCODE = "barcode";
	static final String COLUMN_PACKAGE_TYPE = "package_type";
	static final String COLUMN_NET_CONTENT = "net_content";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_PICTURE = "picture";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_SIZE,COLUMN_PRODUCT,COLUMN_BARCODE,COLUMN_PACKAGE_TYPE,COLUMN_NET_CONTENT,COLUMN_PRICE,COLUMN_PICTURE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_SIZE,COLUMN_PRODUCT,COLUMN_BARCODE,COLUMN_PACKAGE_TYPE,COLUMN_NET_CONTENT,COLUMN_PRICE,COLUMN_PICTURE};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "sku_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(24)","","名称","",""},
                new String[]{"size","varchar(4)","","大小","",""},
                new String[]{"product","varchar(48)","","产品","product_data","id"},
                new String[]{"barcode","varchar(52)","","条码","",""},
                new String[]{"package_type","varchar(16)","","包装类型","",""},
                new String[]{"net_content","varchar(92)","","净含量","",""},
                new String[]{"price","numeric(8,2)","","价格","",""},
                new String[]{"picture","varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci","","图片","",""},
                new String[]{"version","int","","版本","",""}
            }, "SKU", new String[]{
                "create unique index idx4id_ver_of_sku on sku_data (id, version);",
                "create  index idx4price_of_sku on sku_data (price);"
         }, new String[]{
                "alter table sku_data add constraint pk4id_of_sku_data primary key (id);",
                "alter table sku_data add constraint fk4product_of_sku_data foreign key (product) references product_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


