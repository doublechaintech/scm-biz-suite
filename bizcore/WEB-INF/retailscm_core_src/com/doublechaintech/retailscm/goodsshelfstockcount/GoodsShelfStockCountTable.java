
package com.doublechaintech.retailscm.goodsshelfstockcount;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class GoodsShelfStockCountTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_shelf_stock_count_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_COUNT_TIME = "count_time";
	static final String COLUMN_SUMMARY = "summary";
	static final String COLUMN_SHELF = "shelf";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_COUNT_TIME,COLUMN_SUMMARY,COLUMN_SHELF,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_COUNT_TIME,COLUMN_SUMMARY,COLUMN_SHELF};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "goods_shelf_stock_count_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"title","varchar(16)","","头衔","",""},
                new String[]{"count_time","date","","计数时间","",""},
                new String[]{"summary","varchar(72)","","概览","",""},
                new String[]{"shelf","varchar(48)","","架","goods_shelf_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "货架库存盘点", new String[]{
                "create unique index idx4id_ver_of_goods_shelf_stock_count on goods_shelf_stock_count_data (id, version);",
                "create  index idx4count_time_of_goods_shelf_stock_count on goods_shelf_stock_count_data (count_time);"
         }, new String[]{
                "alter table goods_shelf_stock_count_data add constraint pk4id_of_goods_shelf_stock_count_data primary key (id);",
                "alter table goods_shelf_stock_count_data add constraint fk4shelf_of_goods_shelf_stock_count_data foreign key (shelf) references goods_shelf_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


