
package com.doublechaintech.retailscm.loginhistory;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class LoginHistoryTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="login_history_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOGIN_TIME = "login_time";
	static final String COLUMN_FROM_IP = "from_ip";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_LOGIN_TIME,COLUMN_FROM_IP,COLUMN_DESCRIPTION,COLUMN_SEC_USER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_LOGIN_TIME,COLUMN_FROM_IP,COLUMN_DESCRIPTION,COLUMN_SEC_USER};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "login_history_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"login_time","datetime","","登录时间","",""},
                new String[]{"from_ip","varchar(44)","","来自IP","",""},
                new String[]{"description","varchar(16)","","描述","",""},
                new String[]{"sec_user","varchar(48)","","系统用户","sec_user_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "登录历史", new String[]{
                "create unique index idx4id_ver_of_login_history on login_history_data (id, version);",
                "create  index idx4login_time_of_login_history on login_history_data (login_time);"
         }, new String[]{
                "alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);",
                "alter table login_history_data add constraint fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


