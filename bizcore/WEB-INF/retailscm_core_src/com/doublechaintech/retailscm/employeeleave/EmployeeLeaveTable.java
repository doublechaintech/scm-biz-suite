package com.doublechaintech.retailscm.employeeleave;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeLeaveTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "employee_leave_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_WHO = "who";
  static final String COLUMN_TYPE = "type";
  static final String COLUMN_LEAVE_DURATION_HOUR = "leave_duration_hour";
  static final String COLUMN_REMARK = "remark";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_WHO, COLUMN_TYPE, COLUMN_LEAVE_DURATION_HOUR, COLUMN_REMARK, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_WHO, COLUMN_TYPE, COLUMN_LEAVE_DURATION_HOUR, COLUMN_REMARK
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "employee_leave_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"who", "varchar(48)", "", "谁", "employee_data", "id"},
          new String[] {"type", "varchar(48)", "", "类型", "leave_type_data", "id"},
          new String[] {"leave_duration_hour", "int", "", "请假时长", "", ""},
          new String[] {"remark", "varchar(44)", "", "备注", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "请假记录",
        new String[] {
          "create unique index idx4id_ver_of_employee_leave on employee_leave_data (id, version);",
          "create  index idx4leave_duration_hour_of_employee_leave on employee_leave_data (leave_duration_hour);",
          "create  index idx4version_of_employee_leave on employee_leave_data (version);"
        },
        new String[] {
          "alter table employee_leave_data add constraint pk4id_of_employee_leave_data primary key (id);",
          "alter table employee_leave_data add constraint fk4who_of_employee_leave_data foreign key (who) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table employee_leave_data add constraint fk4type_of_employee_leave_data foreign key (type) references leave_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
