
package com.doublechaintech.retailscm.pagetype;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class PageTypeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	
	public static AccessKey withCode(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_CODE);
		accessKey.setValue(value);
		return accessKey;
	}
	 

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="page_type_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CODE = "code";
	static final String COLUMN_MOBILE_APP = "mobile_app";
	static final String COLUMN_FOOTER_TAB = "footer_tab";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CODE,COLUMN_MOBILE_APP,COLUMN_FOOTER_TAB,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CODE,COLUMN_MOBILE_APP,COLUMN_FOOTER_TAB};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "page_type_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(40)","","名称","",""},
                new String[]{"code","varchar(40)","","代码","",""},
                new String[]{"mobile_app","varchar(48)","","手机应用程序","mobile_app_data","id"},
                new String[]{"footer_tab","tinyint","","页脚选项卡","",""},
                new String[]{"version","int","","版本","",""}
            }, "页面类型", new String[]{
                "create unique index idx4id_ver_of_page_type on page_type_data (id, version);",
                "create unique index idx4code_of_page_type on page_type_data (code);"
         }, new String[]{
                "alter table page_type_data add constraint pk4id_of_page_type_data primary key (id);",
                "alter table page_type_data add constraint fk4mobile_app_of_page_type_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }

    public static void ensureData(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureDataByCode(userContext, result, "page_type_data", new String[][]{
                new String[]{"home","'home','首页','home','MA000001','1','1'"},
                new String[]{"me","'me','我的','me','MA000001','1','1'"},
                new String[]{"generic-page","'generic-page','Generic Page','generic-page','MA000001','1','1'"},
                new String[]{"listof-page","'listof-page','Listof Page','listof-page','MA000001','1','1'"},
                new String[]{"service-center","'service-center','功能大厅','service-center','MA000001','1','1'"},
                new String[]{"simple","'simple','普通','simple','MA000001','1','1'"}
            });
    }

}


