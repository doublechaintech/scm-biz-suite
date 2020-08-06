
package com.doublechaintech.retailscm.slide;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SlideTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="slide_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_DISPLAY_ORDER = "display_order";
	static final String COLUMN_IMAGE_URL = "image_url";
	static final String COLUMN_VIDEO_URL = "video_url";
	static final String COLUMN_LINK_TO_URL = "link_to_url";
	static final String COLUMN_PAGE = "page";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_DISPLAY_ORDER,COLUMN_IMAGE_URL,COLUMN_VIDEO_URL,COLUMN_LINK_TO_URL,COLUMN_PAGE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_DISPLAY_ORDER,COLUMN_IMAGE_URL,COLUMN_VIDEO_URL,COLUMN_LINK_TO_URL,COLUMN_PAGE};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "slide_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(40)","","名称","",""},
                new String[]{"display_order","int","","顺序","",""},
                new String[]{"image_url","varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci","","图片链接","",""},
                new String[]{"video_url","varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci","","视频网址","",""},
                new String[]{"link_to_url","varchar(512)","","链接网址","",""},
                new String[]{"page","varchar(48)","","页面","page_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "轮播内容", new String[]{
                "create unique index idx4id_ver_of_slide on slide_data (id, version);",
                "create  index idx4display_order_of_slide on slide_data (display_order);"
         }, new String[]{
                "alter table slide_data add constraint pk4id_of_slide_data primary key (id);",
                "alter table slide_data add constraint fk4page_of_slide_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


