package com.doublechaintech.retailscm.employeeattendance;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeAttendanceTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "employee_attendance_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_EMPLOYEE = "employee";
  static final String COLUMN_ENTER_TIME = "enter_time";
  static final String COLUMN_LEAVE_TIME = "leave_time";
  static final String COLUMN_DURATION_HOURS = "duration_hours";
  static final String COLUMN_REMARK = "remark";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_EMPLOYEE,
    COLUMN_ENTER_TIME,
    COLUMN_LEAVE_TIME,
    COLUMN_DURATION_HOURS,
    COLUMN_REMARK,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_EMPLOYEE, COLUMN_ENTER_TIME, COLUMN_LEAVE_TIME, COLUMN_DURATION_HOURS, COLUMN_REMARK
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "employee_attendance_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"employee", "varchar(48)", "", "员工", "employee_data", "id"},
          new String[] {"enter_time", "date", "", "进入时间", "", ""},
          new String[] {"leave_time", "date", "", "离开的时候", "", ""},
          new String[] {"duration_hours", "int", "", "持续时间", "", ""},
          new String[] {"remark", "varchar(28)", "", "备注", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "员工考勤",
        new String[] {
          "create unique index idx4id_ver_of_employee_attendance on employee_attendance_data (id, version);",
          "create  index idx4enter_time_of_employee_attendance on employee_attendance_data (enter_time);",
          "create  index idx4leave_time_of_employee_attendance on employee_attendance_data (leave_time);",
          "create  index idx4duration_hours_of_employee_attendance on employee_attendance_data (duration_hours);",
          "create  index idx4version_of_employee_attendance on employee_attendance_data (version);"
        },
        new String[] {
          "alter table employee_attendance_data add constraint pk4id_of_employee_attendance_data primary key (id);",
          "alter table employee_attendance_data add constraint fk4employee_of_employee_attendance_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
