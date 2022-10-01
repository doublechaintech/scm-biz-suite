package com.doublechaintech.retailscm.accountingdocumenttype;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class AccountingDocumentTypeTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "accounting_document_type_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_ACCOUNTING_PERIOD = "accounting_period";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_ACCOUNTING_PERIOD, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_ACCOUNTING_PERIOD
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "accounting_document_type_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(16)", "", "名称", "", ""},
          new String[] {"description", "varchar(280)", "", "描述", "", ""},
          new String[] {"accounting_period", "varchar(48)", "", "会计期间", "account_set_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "会计凭证类型",
        new String[] {
          "create unique index idx4id_ver_of_accounting_document_type on accounting_document_type_data (id, version);",
          "create  index idx4version_of_accounting_document_type on accounting_document_type_data (version);"
        },
        new String[] {
          "alter table accounting_document_type_data add constraint pk4id_of_accounting_document_type_data primary key (id);",
          "alter table accounting_document_type_data add constraint fk4accounting_period_of_accounting_document_type_data foreign key (accounting_period) references account_set_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
