package com.doublechaintech.retailscm.employeeperformance;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeePerformanceTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "employee_performance_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_EMPLOYEE = "employee";
  static final String COLUMN_PERFORMANCE_COMMENT = "performance_comment";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_EMPLOYEE, COLUMN_PERFORMANCE_COMMENT, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {COLUMN_EMPLOYEE, COLUMN_PERFORMANCE_COMMENT};

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "employee_performance_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"employee", "varchar(48)", "", "员工", "employee_data", "id"},
          new String[] {"performance_comment", "varchar(28)", "", "绩效评价", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "员工绩效",
        new String[] {
          "create unique index idx4id_ver_of_employee_performance on employee_performance_data (id, version);",
          "create  index idx4version_of_employee_performance on employee_performance_data (version);"
        },
        new String[] {
          "alter table employee_performance_data add constraint pk4id_of_employee_performance_data primary key (id);",
          "alter table employee_performance_data add constraint fk4employee_of_employee_performance_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
