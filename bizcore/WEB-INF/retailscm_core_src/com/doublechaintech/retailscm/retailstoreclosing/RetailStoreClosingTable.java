
package com.doublechaintech.retailscm.retailstoreclosing;
import com.doublechaintech.retailscm.AccessKey;


public class RetailStoreClosingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_closing_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_COMMENT = "comment";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_COMMENT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_COMMENT};
	
	
}


