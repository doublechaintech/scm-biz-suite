
package com.doublechaintech.retailscm.uiaction;
import com.doublechaintech.retailscm.AccessKey;


public class UiActionTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="ui_action_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_CODE = "code";
	static final String COLUMN_ICON = "icon";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_DISPLAY_ORDER = "display_order";
	static final String COLUMN_BRIEF = "brief";
	static final String COLUMN_IMAGE_URL = "image_url";
	static final String COLUMN_LINK_TO_URL = "link_to_url";
	static final String COLUMN_EXTRA_DATA = "extra_data";
	static final String COLUMN_PAGE = "page";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_CODE,COLUMN_ICON,COLUMN_TITLE,COLUMN_DISPLAY_ORDER,COLUMN_BRIEF,COLUMN_IMAGE_URL,COLUMN_LINK_TO_URL,COLUMN_EXTRA_DATA,COLUMN_PAGE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_CODE,COLUMN_ICON,COLUMN_TITLE,COLUMN_DISPLAY_ORDER,COLUMN_BRIEF,COLUMN_IMAGE_URL,COLUMN_LINK_TO_URL,COLUMN_EXTRA_DATA,COLUMN_PAGE};
	
	
}


