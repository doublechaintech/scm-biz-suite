
package com.doublechaintech.retailscm.secuser;
import com.doublechaintech.retailscm.AccessKey;


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
	
	
}


