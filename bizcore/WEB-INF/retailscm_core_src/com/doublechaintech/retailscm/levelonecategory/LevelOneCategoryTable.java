
package com.doublechaintech.retailscm.levelonecategory;
import com.doublechaintech.retailscm.AccessKey;


public class LevelOneCategoryTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="level_one_category_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_CATALOG = "catalog";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_CATALOG,COLUMN_NAME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_CATALOG,COLUMN_NAME};
	
	
}


