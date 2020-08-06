
package com.doublechaintech.retailscm.uiaction;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

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

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "ui_action_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"code","varchar(40)","","代码","",""},
                new String[]{"icon","varchar(512)","","图标","",""},
                new String[]{"title","varchar(40)","","头衔","",""},
                new String[]{"display_order","int","","顺序","",""},
                new String[]{"brief","varchar(200)","","短暂的","",""},
                new String[]{"image_url","varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci","","图片链接","",""},
                new String[]{"link_to_url","varchar(512)","","链接网址","",""},
                new String[]{"extra_data","longtext","","额外的数据","",""},
                new String[]{"page","varchar(48)","","页面","page_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "用户界面操作", new String[]{
                "create unique index idx4id_ver_of_ui_action on ui_action_data (id, version);",
                "create  index idx4display_order_of_ui_action on ui_action_data (display_order);"
         }, new String[]{
                "alter table ui_action_data add constraint pk4id_of_ui_action_data primary key (id);",
                "alter table ui_action_data add constraint fk4page_of_ui_action_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


