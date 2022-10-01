package com.doublechaintech.retailscm.employeeeducation;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeEducationTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "employee_education_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_EMPLOYEE = "employee";
  static final String COLUMN_COMPLETE_TIME = "complete_time";
  static final String COLUMN_TYPE = "type";
  static final String COLUMN_REMARK = "remark";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_EMPLOYEE, COLUMN_COMPLETE_TIME, COLUMN_TYPE, COLUMN_REMARK, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_EMPLOYEE, COLUMN_COMPLETE_TIME, COLUMN_TYPE, COLUMN_REMARK
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "employee_education_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"employee", "varchar(48)", "", "员工", "employee_data", "id"},
          new String[] {"complete_time", "date", "", "完成时间", "", ""},
          new String[] {"type", "varchar(16)", "", "类型", "", ""},
          new String[] {"remark", "varchar(36)", "", "备注", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "员工教育",
        new String[] {
          "create unique index idx4id_ver_of_employee_education on employee_education_data (id, version);",
          "create  index idx4complete_time_of_employee_education on employee_education_data (complete_time);",
          "create  index idx4version_of_employee_education on employee_education_data (version);"
        },
        new String[] {
          "alter table employee_education_data add constraint pk4id_of_employee_education_data primary key (id);",
          "alter table employee_education_data add constraint fk4employee_of_employee_education_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
