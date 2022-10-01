package com.doublechaintech.retailscm.memberwishlist;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class MemberWishlistTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "member_wishlist_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_OWNER = "owner";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_OWNER, COLUMN_VERSION};
  public static final String[] NORMAL_CLOUMNS = {COLUMN_NAME, COLUMN_OWNER};

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "member_wishlist_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(24)", "", "名称", "", ""},
          new String[] {"owner", "varchar(48)", "", "业主", "retail_store_member_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "会员收藏",
        new String[] {
          "create unique index idx4id_ver_of_member_wishlist on member_wishlist_data (id, version);",
          "create  index idx4version_of_member_wishlist on member_wishlist_data (version);"
        },
        new String[] {
          "alter table member_wishlist_data add constraint pk4id_of_member_wishlist_data primary key (id);",
          "alter table member_wishlist_data add constraint fk4owner_of_member_wishlist_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
