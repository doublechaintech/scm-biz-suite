
package com.doublechaintech.retailscm.secuser;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SecUserTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	
	public static AccessKey withLogin(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_LOGIN);
		accessKey.setValue(value);
		return accessKey;
	}
	 
	public static AccessKey withEmail(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_EMAIL);
		accessKey.setValue(value);
		return accessKey;
	}
	 
	public static AccessKey withMobile(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_MOBILE);
		accessKey.setValue(value);
		return accessKey;
	}
	 

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="sec_user_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOGIN = "login";
	static final String COLUMN_MOBILE = "mobile";
	static final String COLUMN_EMAIL = "email";
	static final String COLUMN_PWD = "pwd";
	static final String COLUMN_WEIXIN_OPENID = "weixin_openid";
	static final String COLUMN_WEIXIN_APPID = "weixin_appid";
	static final String COLUMN_ACCESS_TOKEN = "access_token";
	static final String COLUMN_VERIFICATION_CODE = "verification_code";
	static final String COLUMN_VERIFICATION_CODE_EXPIRE = "verification_code_expire";
	static final String COLUMN_LAST_LOGIN_TIME = "last_login_time";
	static final String COLUMN_DOMAIN = "domain";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_LOGIN,COLUMN_MOBILE,COLUMN_EMAIL,COLUMN_PWD,COLUMN_WEIXIN_OPENID,COLUMN_WEIXIN_APPID,COLUMN_ACCESS_TOKEN,COLUMN_VERIFICATION_CODE,COLUMN_VERIFICATION_CODE_EXPIRE,COLUMN_LAST_LOGIN_TIME,COLUMN_DOMAIN,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_LOGIN,COLUMN_MOBILE,COLUMN_EMAIL,COLUMN_PWD,COLUMN_WEIXIN_OPENID,COLUMN_WEIXIN_APPID,COLUMN_ACCESS_TOKEN,COLUMN_VERIFICATION_CODE,COLUMN_VERIFICATION_CODE_EXPIRE,COLUMN_LAST_LOGIN_TIME,COLUMN_DOMAIN};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "sec_user_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"login","varchar(256)","","登录","",""},
                new String[]{"mobile","varchar(11)","","手机","",""},
                new String[]{"email","varchar(256)","","电子邮件","",""},
                new String[]{"pwd","varchar(64)","","PWD","",""},
                new String[]{"weixin_openid","varchar(128)","","微信openid","",""},
                new String[]{"weixin_appid","varchar(128)","","微信Appid","",""},
                new String[]{"access_token","varchar(128)","","访问令牌","",""},
                new String[]{"verification_code","int","","验证码","",""},
                new String[]{"verification_code_expire","datetime","","验证码过期","",""},
                new String[]{"last_login_time","datetime","","最后登录时间","",""},
                new String[]{"domain","varchar(48)","","域","user_domain_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "安全用户", new String[]{
                "create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);",
                "create unique index idx4login_of_sec_user on sec_user_data (login);",
                "create unique index idx4email_of_sec_user on sec_user_data (email);",
                "create unique index idx4mobile_of_sec_user on sec_user_data (mobile);",
                "create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);",
                "create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);",
                "create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);"
         }, new String[]{
                "alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);",
                "alter table sec_user_data add constraint fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


