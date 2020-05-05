
package com.doublechaintech.retailscm.product;
import com.doublechaintech.retailscm.AccessKey;


public class ProductTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="product_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PARENT_CATEGORY = "parent_category";
	static final String COLUMN_ORIGIN = "origin";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_BRAND = "brand";
	static final String COLUMN_PICTURE = "picture";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_PARENT_CATEGORY,COLUMN_ORIGIN,COLUMN_REMARK,COLUMN_BRAND,COLUMN_PICTURE,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_PARENT_CATEGORY,COLUMN_ORIGIN,COLUMN_REMARK,COLUMN_BRAND,COLUMN_PICTURE,COLUMN_LAST_UPDATE_TIME};
	
	
}


