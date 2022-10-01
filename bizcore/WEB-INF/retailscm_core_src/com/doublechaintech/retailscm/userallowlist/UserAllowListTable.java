package com.doublechaintech.retailscm.userallowlist;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class UserAllowListTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "user_allow_list_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_USER_IDENTITY = "user_identity";
  static final String COLUMN_USER_SPECIAL_FUNCTIONS = "user_special_functions";
  static final String COLUMN_DOMAIN = "domain";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_USER_IDENTITY, COLUMN_USER_SPECIAL_FUNCTIONS, COLUMN_DOMAIN, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_USER_IDENTITY, COLUMN_USER_SPECIAL_FUNCTIONS, COLUMN_DOMAIN
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "user_allow_list_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"user_identity", "varchar(40)", "", "用户身份", "", ""},
          new String[] {"user_special_functions", "varchar(200)", "", "用户特殊功能", "", ""},
          new String[] {"domain", "varchar(48)", "", "域", "user_domain_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "用户权限列表",
        new String[] {
          "create unique index idx4id_ver_of_user_allow_list on user_allow_list_data (id, version);",
          "create  index idx4user_identity_of_user_allow_list on user_allow_list_data (user_identity);",
          "create  index idx4version_of_user_allow_list on user_allow_list_data (version);"
        },
        new String[] {
          "alter table user_allow_list_data add constraint pk4id_of_user_allow_list_data primary key (id);",
          "alter table user_allow_list_data add constraint fk4domain_of_user_allow_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
