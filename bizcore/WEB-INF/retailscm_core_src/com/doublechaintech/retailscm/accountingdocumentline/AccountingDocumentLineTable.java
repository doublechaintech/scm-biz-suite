package com.doublechaintech.retailscm.accountingdocumentline;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class AccountingDocumentLineTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "accounting_document_line_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_CODE = "code";
  static final String COLUMN_DIRECT = "direct";
  static final String COLUMN_AMOUNT = "amount";
  static final String COLUMN_BELONGS_TO = "belongs_to";
  static final String COLUMN_ACCOUNTING_SUBJECT = "accounting_subject";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_CODE,
    COLUMN_DIRECT,
    COLUMN_AMOUNT,
    COLUMN_BELONGS_TO,
    COLUMN_ACCOUNTING_SUBJECT,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME,
    COLUMN_CODE,
    COLUMN_DIRECT,
    COLUMN_AMOUNT,
    COLUMN_BELONGS_TO,
    COLUMN_ACCOUNTING_SUBJECT
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "accounting_document_line_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(16)", "", "名称", "", ""},
          new String[] {"code", "varchar(24)", "", "代码", "", ""},
          new String[] {"direct", "varchar(4)", "", "直接", "", ""},
          new String[] {"amount", "numeric(10,2)", "", "金额", "", ""},
          new String[] {"belongs_to", "varchar(48)", "", "属于", "accounting_document_data", "id"},
          new String[] {
            "accounting_subject", "varchar(48)", "", "会计科目", "accounting_subject_data", "id"
          },
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "会计凭证行",
        new String[] {
          "create unique index idx4id_ver_of_accounting_document_line on accounting_document_line_data (id, version);",
          "create  index idx4amount_of_accounting_document_line on accounting_document_line_data (amount);",
          "create  index idx4version_of_accounting_document_line on accounting_document_line_data (version);"
        },
        new String[] {
          "alter table accounting_document_line_data add constraint pk4id_of_accounting_document_line_data primary key (id);",
          "alter table accounting_document_line_data add constraint fk4belongs_to_of_accounting_document_line_data foreign key (belongs_to) references accounting_document_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table accounting_document_line_data add constraint fk4accounting_subject_of_accounting_document_line_data foreign key (accounting_subject) references accounting_subject_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
