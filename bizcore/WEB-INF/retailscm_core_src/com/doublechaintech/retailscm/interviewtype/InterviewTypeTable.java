package com.doublechaintech.retailscm.interviewtype;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class InterviewTypeTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "interview_type_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_CODE = "code";
  static final String COLUMN_COMPANY = "company";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_DETAIL_DESCRIPTION = "detail_description";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_CODE,
    COLUMN_COMPANY,
    COLUMN_DESCRIPTION,
    COLUMN_DETAIL_DESCRIPTION,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_CODE, COLUMN_COMPANY, COLUMN_DESCRIPTION, COLUMN_DETAIL_DESCRIPTION
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "interview_type_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"code", "varchar(32)", "", "代码", "", ""},
          new String[] {
            "company", "varchar(48)", "", "公司", "retail_store_country_center_data", "id"
          },
          new String[] {"description", "varchar(24)", "", "描述", "", ""},
          new String[] {"detail_description", "varchar(244)", "", "详细描述", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "面试类型",
        new String[] {
          "create unique index idx4id_ver_of_interview_type on interview_type_data (id, version);",
          "create  index idx4version_of_interview_type on interview_type_data (version);"
        },
        new String[] {
          "alter table interview_type_data add constraint pk4id_of_interview_type_data primary key (id);",
          "alter table interview_type_data add constraint fk4company_of_interview_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
