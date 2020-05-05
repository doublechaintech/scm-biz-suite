
package com.doublechaintech.retailscm.stockcountissuetrack;
import com.doublechaintech.retailscm.AccessKey;


public class StockCountIssueTrackTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="stock_count_issue_track_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_COUNT_TIME = "count_time";
	static final String COLUMN_SUMMARY = "summary";
	static final String COLUMN_STOCK_COUNT = "stock_count";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_COUNT_TIME,COLUMN_SUMMARY,COLUMN_STOCK_COUNT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_COUNT_TIME,COLUMN_SUMMARY,COLUMN_STOCK_COUNT};
	
	
}


