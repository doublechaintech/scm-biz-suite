package com.doublechaintech.retailscm.accountingsubject;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class AccountingSubjectTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "accounting_subject_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_ACCOUNTING_SUBJECT_CODE = "accounting_subject_code";
  static final String COLUMN_ACCOUNTING_SUBJECT_NAME = "accounting_subject_name";
  static final String COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE = "accounting_subject_class_code";
  static final String COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME = "accounting_subject_class_name";
  static final String COLUMN_ACCOUNT_SET = "account_set";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_ACCOUNTING_SUBJECT_CODE,
    COLUMN_ACCOUNTING_SUBJECT_NAME,
    COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE,
    COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME,
    COLUMN_ACCOUNT_SET,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_ACCOUNTING_SUBJECT_CODE,
    COLUMN_ACCOUNTING_SUBJECT_NAME,
    COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE,
    COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME,
    COLUMN_ACCOUNT_SET
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "accounting_subject_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"accounting_subject_code", "varchar(24)", "", "会计科目代码", "", ""},
          new String[] {"accounting_subject_name", "varchar(16)", "", "会计科目名称", "", ""},
          new String[] {"accounting_subject_class_code", "int", "", "会计科目类别代码", "", ""},
          new String[] {"accounting_subject_class_name", "varchar(24)", "", "会计科目类别名称", "", ""},
          new String[] {"account_set", "varchar(48)", "", "账套", "account_set_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "会计科目",
        new String[] {
          "create unique index idx4id_ver_of_accounting_subject on accounting_subject_data (id, version);",
          "create  index idx4accounting_subject_class_code_of_accounting_subject on accounting_subject_data (accounting_subject_class_code);",
          "create  index idx4version_of_accounting_subject on accounting_subject_data (version);"
        },
        new String[] {
          "alter table accounting_subject_data add constraint pk4id_of_accounting_subject_data primary key (id);",
          "alter table accounting_subject_data add constraint fk4account_set_of_accounting_subject_data foreign key (account_set) references account_set_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
