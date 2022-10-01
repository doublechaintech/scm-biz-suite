package com.doublechaintech.retailscm.employeeattendance;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;

public class EmployeeAttendanceMapper extends BaseRowMapper<EmployeeAttendance> {

  public static EmployeeAttendanceMapper mapperForClass(Class<?> clazz) {

    EmployeeAttendanceMapper mapperForOverride = new EmployeeAttendanceMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected EmployeeAttendance internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    EmployeeAttendance employeeAttendance = getEmployeeAttendance();

    setId(employeeAttendance, rs, rowNumber);
    setEmployee(employeeAttendance, rs, rowNumber);
    setEnterTime(employeeAttendance, rs, rowNumber);
    setLeaveTime(employeeAttendance, rs, rowNumber);
    setDurationHours(employeeAttendance, rs, rowNumber);
    setRemark(employeeAttendance, rs, rowNumber);
    setVersion(employeeAttendance, rs, rowNumber);

    return employeeAttendance;
  }

  protected EmployeeAttendance getEmployeeAttendance() {
    if (null == clazz) {

      EmployeeAttendance entity = new EmployeeAttendance();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(EmployeeAttendanceTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeAttendance.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setEmployee(EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    String employeeId;
    try {
      employeeId = rs.getString(EmployeeAttendanceTable.COLUMN_EMPLOYEE);
    } catch (SQLException e) {
      return;
    }
    if (employeeId == null) {
      return;
    }
    if (employeeId.isEmpty()) {
      return;
    }
    Employee employee = employeeAttendance.getEmployee();
    if (employee != null) {
      // if the root object 'employeeAttendance' already have the property, just set the id for it;
      employee.setId(employeeId);

      return;
    }
    employeeAttendance.setEmployee(createEmptyEmployee(employeeId));
  }

  protected void setEnterTime(EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date enterTime = rs.getDate(EmployeeAttendanceTable.COLUMN_ENTER_TIME);

      if (enterTime == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeAttendance.setEnterTime(enterTime);
    } catch (SQLException e) {

    }
  }

  protected void setLeaveTime(EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date leaveTime = rs.getDate(EmployeeAttendanceTable.COLUMN_LEAVE_TIME);

      if (leaveTime == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeAttendance.setLeaveTime(leaveTime);
    } catch (SQLException e) {

    }
  }

  protected void setDurationHours(
      EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer durationHours = rs.getInt(EmployeeAttendanceTable.COLUMN_DURATION_HOURS);

      if (durationHours == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeAttendance.setDurationHours(durationHours);
    } catch (SQLException e) {

    }
  }

  protected void setRemark(EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String remark = rs.getString(EmployeeAttendanceTable.COLUMN_REMARK);

      if (remark == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeAttendance.setRemark(remark);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(EmployeeAttendance employeeAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(EmployeeAttendanceTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeAttendance.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected Employee createEmptyEmployee(String employeeId) {

    Employee employee = new Employee();

    employee.setId(employeeId);
    employee.setVersion(Integer.MAX_VALUE);
    return employee;
  }
}
