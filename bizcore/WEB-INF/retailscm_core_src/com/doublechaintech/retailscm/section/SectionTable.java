
package com.doublechaintech.retailscm.section;
import com.doublechaintech.retailscm.AccessKey;


public class SectionTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="section_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_BRIEF = "brief";
	static final String COLUMN_ICON = "icon";
	static final String COLUMN_DISPLAY_ORDER = "display_order";
	static final String COLUMN_VIEW_GROUP = "view_group";
	static final String COLUMN_LINK_TO_URL = "link_to_url";
	static final String COLUMN_PAGE = "page";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_BRIEF,COLUMN_ICON,COLUMN_DISPLAY_ORDER,COLUMN_VIEW_GROUP,COLUMN_LINK_TO_URL,COLUMN_PAGE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_BRIEF,COLUMN_ICON,COLUMN_DISPLAY_ORDER,COLUMN_VIEW_GROUP,COLUMN_LINK_TO_URL,COLUMN_PAGE};
	
	
}


