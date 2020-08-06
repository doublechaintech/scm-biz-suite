
package com.doublechaintech.retailscm.listaccess;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ListAccessTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="list_access_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_INTERNAL_NAME = "internal_name";
	static final String COLUMN_READ_PERMISSION = "read_permission";
	static final String COLUMN_CREATE_PERMISSION = "create_permission";
	static final String COLUMN_DELETE_PERMISSION = "delete_permission";
	static final String COLUMN_UPDATE_PERMISSION = "update_permission";
	static final String COLUMN_EXECUTION_PERMISSION = "execution_permission";
	static final String COLUMN_APP = "app";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_INTERNAL_NAME,COLUMN_READ_PERMISSION,COLUMN_CREATE_PERMISSION,COLUMN_DELETE_PERMISSION,COLUMN_UPDATE_PERMISSION,COLUMN_EXECUTION_PERMISSION,COLUMN_APP,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_INTERNAL_NAME,COLUMN_READ_PERMISSION,COLUMN_CREATE_PERMISSION,COLUMN_DELETE_PERMISSION,COLUMN_UPDATE_PERMISSION,COLUMN_EXECUTION_PERMISSION,COLUMN_APP};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "list_access_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(200)","","名称","",""},
                new String[]{"internal_name","varchar(200)","","内部名称","",""},
                new String[]{"read_permission","tinyint","","读权限","",""},
                new String[]{"create_permission","tinyint","","创建权限","",""},
                new String[]{"delete_permission","tinyint","","删除权限","",""},
                new String[]{"update_permission","tinyint","","更新权限","",""},
                new String[]{"execution_permission","tinyint","","执行权限","",""},
                new String[]{"app","varchar(48)","","应用程序","user_app_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "访问列表", new String[]{
                "create unique index idx4id_ver_of_list_access on list_access_data (id, version);"
         }, new String[]{
                "alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);",
                "alter table list_access_data add constraint fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


