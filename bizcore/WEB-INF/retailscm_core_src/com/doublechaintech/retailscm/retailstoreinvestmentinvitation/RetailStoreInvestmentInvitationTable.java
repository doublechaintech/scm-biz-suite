package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreInvestmentInvitationTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "retail_store_investment_invitation_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_COMMENT = "comment";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {COLUMN_ID, COLUMN_COMMENT, COLUMN_VERSION};
  public static final String[] NORMAL_CLOUMNS = {COLUMN_COMMENT};

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "retail_store_investment_invitation_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"comment", "varchar(24)", "", "评论", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "生超招商",
        new String[] {
          "create unique index idx4id_ver_of_retail_store_investment_invitation on retail_store_investment_invitation_data (id, version);",
          "create  index idx4version_of_retail_store_investment_invitation on retail_store_investment_invitation_data (version);"
        },
        new String[] {
          "alter table retail_store_investment_invitation_data add constraint pk4id_of_retail_store_investment_invitation_data primary key (id);",
          ""
        });
  }
}
