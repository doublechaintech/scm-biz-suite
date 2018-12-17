
package com.doublechaintech.retailscm.goodspackaging;
import com.doublechaintech.retailscm.AccessKey;


public class GoodsPackagingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="goods_packaging_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_PACKAGE_NAME = "package_name";
	static final String COLUMN_RFID = "rfid";
	static final String COLUMN_PACKAGE_TIME = "package_time";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_PACKAGE_NAME, COLUMN_RFID, COLUMN_PACKAGE_TIME, COLUMN_DESCRIPTION, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_PACKAGE_NAME, COLUMN_RFID, COLUMN_PACKAGE_TIME, COLUMN_DESCRIPTION
		};
	
	
}


