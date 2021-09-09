
package com.doublechaintech.retailscm.wechatminiappidentity;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class WechatMiniappIdentityTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="wechat_miniapp_identity_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_OPEN_ID = "open_id";
	static final String COLUMN_APP_ID = "app_id";
	static final String COLUMN_UNION_ID = "union_id";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_LAST_LOGIN_TIME = "last_login_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_OPEN_ID,COLUMN_APP_ID,COLUMN_UNION_ID,COLUMN_SEC_USER,COLUMN_CREATE_TIME,COLUMN_LAST_LOGIN_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_OPEN_ID,COLUMN_APP_ID,COLUMN_UNION_ID,COLUMN_SEC_USER,COLUMN_CREATE_TIME,COLUMN_LAST_LOGIN_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "wechat_miniapp_identity_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"open_id","varchar(128)","","openId","",""},
                new String[]{"app_id","varchar(128)","","应用ID","",""},
                new String[]{"union_id","varchar(128)","","UnionID","",""},
                new String[]{"sec_user","varchar(48)","","系统用户","sec_user_data","id"},
                new String[]{"create_time","datetime","","创建时间","",""},
                new String[]{"last_login_time","datetime","","最后登录时间","",""},
                new String[]{"version","int","","版本","",""}
            }, "微信小程序认证", new String[]{
                "create unique index idx4id_ver_of_wechat_miniapp_identity on wechat_miniapp_identity_data (id, version);",
                "create  index idx4open_id_of_wechat_miniapp_identity on wechat_miniapp_identity_data (open_id);",
                "create  index idx4app_id_of_wechat_miniapp_identity on wechat_miniapp_identity_data (app_id);",
                "create  index idx4union_id_of_wechat_miniapp_identity on wechat_miniapp_identity_data (union_id);",
                "create  index idx4create_time_of_wechat_miniapp_identity on wechat_miniapp_identity_data (create_time);",
                "create  index idx4last_login_time_of_wechat_miniapp_identity on wechat_miniapp_identity_data (last_login_time);"
         }, new String[]{
                "alter table wechat_miniapp_identity_data add constraint pk4id_of_wechat_miniapp_identity_data primary key (id);",
                "alter table wechat_miniapp_identity_data add constraint fk4sec_user_of_wechat_miniapp_identity_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


