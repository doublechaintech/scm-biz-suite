
package com.doublechaintech.retailscm.quicklink;
import com.doublechaintech.retailscm.AccessKey;


public class QuickLinkTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="quick_link_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_ICON = "icon";
	static final String COLUMN_IMAGE_PATH = "image_path";
	static final String COLUMN_LINK_TARGET = "link_target";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_APP = "app";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_ICON,COLUMN_IMAGE_PATH,COLUMN_LINK_TARGET,COLUMN_CREATE_TIME,COLUMN_APP,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_ICON,COLUMN_IMAGE_PATH,COLUMN_LINK_TARGET,COLUMN_CREATE_TIME,COLUMN_APP};
	
	
}


