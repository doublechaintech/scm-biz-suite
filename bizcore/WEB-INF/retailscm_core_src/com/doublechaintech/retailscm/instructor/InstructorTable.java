package com.doublechaintech.retailscm.instructor;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class InstructorTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "instructor_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_TITLE = "title";
  static final String COLUMN_FAMILY_NAME = "family_name";
  static final String COLUMN_GIVEN_NAME = "given_name";
  static final String COLUMN_CELL_PHONE = "cell_phone";
  static final String COLUMN_EMAIL = "email";
  static final String COLUMN_COMPANY = "company";
  static final String COLUMN_INTRODUCTION = "introduction";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_TITLE,
    COLUMN_FAMILY_NAME,
    COLUMN_GIVEN_NAME,
    COLUMN_CELL_PHONE,
    COLUMN_EMAIL,
    COLUMN_COMPANY,
    COLUMN_INTRODUCTION,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_TITLE,
    COLUMN_FAMILY_NAME,
    COLUMN_GIVEN_NAME,
    COLUMN_CELL_PHONE,
    COLUMN_EMAIL,
    COLUMN_COMPANY,
    COLUMN_INTRODUCTION,
    COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "instructor_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"title", "varchar(16)", "", "头衔", "", ""},
          new String[] {"family_name", "varchar(4)", "", "姓", "", ""},
          new String[] {"given_name", "varchar(8)", "", "名", "", ""},
          new String[] {"cell_phone", "varchar(44)", "", "手机", "", ""},
          new String[] {"email", "varchar(256)", "", "电子邮件", "", ""},
          new String[] {
            "company", "varchar(48)", "", "公司", "retail_store_country_center_data", "id"
          },
          new String[] {"introduction", "varchar(60)", "", "介绍", "", ""},
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "讲师",
        new String[] {
          "create unique index idx4id_ver_of_instructor on instructor_data (id, version);",
          "create  index idx4cell_phone_of_instructor on instructor_data (cell_phone);",
          "create  index idx4last_update_time_of_instructor on instructor_data (last_update_time);",
          "create  index idx4version_of_instructor on instructor_data (version);"
        },
        new String[] {
          "alter table instructor_data add constraint pk4id_of_instructor_data primary key (id);",
          "alter table instructor_data add constraint fk4company_of_instructor_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
