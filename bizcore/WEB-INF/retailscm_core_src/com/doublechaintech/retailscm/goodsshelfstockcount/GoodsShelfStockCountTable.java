
package com.doublechaintech.retailscm.goodsshelfstockcount;
import com.doublechaintech.retailscm.AccessKey;


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
	
	
}


