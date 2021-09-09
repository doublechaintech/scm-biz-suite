
package com.doublechaintech.retailscm.keypairidentity;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class KeyPairIdentityTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="key_pair_identity_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_PUBLIC_KEY = "public_key";
	static final String COLUMN_KEY_TYPE = "key_type";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_PUBLIC_KEY,COLUMN_KEY_TYPE,COLUMN_SEC_USER,COLUMN_CREATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_PUBLIC_KEY,COLUMN_KEY_TYPE,COLUMN_SEC_USER,COLUMN_CREATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "key_pair_identity_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"public_key","longtext","","公钥","",""},
                new String[]{"key_type","varchar(48)","","秘钥类型","public_key_type_data","id"},
                new String[]{"sec_user","varchar(48)","","系统用户","sec_user_data","id"},
                new String[]{"create_time","datetime","","创建时间","",""},
                new String[]{"version","int","","版本","",""}
            }, "秘钥对认证", new String[]{
                "create unique index idx4id_ver_of_key_pair_identity on key_pair_identity_data (id, version);",
                "create  index idx4create_time_of_key_pair_identity on key_pair_identity_data (create_time);"
         }, new String[]{
                "alter table key_pair_identity_data add constraint pk4id_of_key_pair_identity_data primary key (id);",
                "alter table key_pair_identity_data add constraint fk4key_type_of_key_pair_identity_data foreign key (key_type) references public_key_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table key_pair_identity_data add constraint fk4sec_user_of_key_pair_identity_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


