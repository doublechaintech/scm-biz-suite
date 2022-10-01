package com.doublechaintech.retailscm.employeeinterview;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.interviewtype.InterviewType;

public class EmployeeInterviewMapper extends BaseRowMapper<EmployeeInterview> {

  public static EmployeeInterviewMapper mapperForClass(Class<?> clazz) {

    EmployeeInterviewMapper mapperForOverride = new EmployeeInterviewMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected EmployeeInterview internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    EmployeeInterview employeeInterview = getEmployeeInterview();

    setId(employeeInterview, rs, rowNumber);
    setEmployee(employeeInterview, rs, rowNumber);
    setInterviewType(employeeInterview, rs, rowNumber);
    setRemark(employeeInterview, rs, rowNumber);
    setVersion(employeeInterview, rs, rowNumber);

    return employeeInterview;
  }

  protected EmployeeInterview getEmployeeInterview() {
    if (null == clazz) {

      EmployeeInterview entity = new EmployeeInterview();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(EmployeeInterview employeeInterview, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(EmployeeInterviewTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeInterview.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setEmployee(EmployeeInterview employeeInterview, ResultSet rs, int rowNumber)
      throws SQLException {
    String employeeId;
    try {
      employeeId = rs.getString(EmployeeInterviewTable.COLUMN_EMPLOYEE);
    } catch (SQLException e) {
      return;
    }
    if (employeeId == null) {
      return;
    }
    if (employeeId.isEmpty()) {
      return;
    }
    Employee employee = employeeInterview.getEmployee();
    if (employee != null) {
      // if the root object 'employeeInterview' already have the property, just set the id for it;
      employee.setId(employeeId);

      return;
    }
    employeeInterview.setEmployee(createEmptyEmployee(employeeId));
  }

  protected void setInterviewType(EmployeeInterview employeeInterview, ResultSet rs, int rowNumber)
      throws SQLException {
    String interviewTypeId;
    try {
      interviewTypeId = rs.getString(EmployeeInterviewTable.COLUMN_INTERVIEW_TYPE);
    } catch (SQLException e) {
      return;
    }
    if (interviewTypeId == null) {
      return;
    }
    if (interviewTypeId.isEmpty()) {
      return;
    }
    InterviewType interviewType = employeeInterview.getInterviewType();
    if (interviewType != null) {
      // if the root object 'employeeInterview' already have the property, just set the id for it;
      interviewType.setId(interviewTypeId);

      return;
    }
    employeeInterview.setInterviewType(createEmptyInterviewType(interviewTypeId));
  }

  protected void setRemark(EmployeeInterview employeeInterview, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String remark = rs.getString(EmployeeInterviewTable.COLUMN_REMARK);

      if (remark == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeInterview.setRemark(remark);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(EmployeeInterview employeeInterview, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(EmployeeInterviewTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      employeeInterview.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected Employee createEmptyEmployee(String employeeId) {

    Employee employee = new Employee();

    employee.setId(employeeId);
    employee.setVersion(Integer.MAX_VALUE);
    return employee;
  }

  protected InterviewType createEmptyInterviewType(String interviewTypeId) {

    InterviewType interviewType = new InterviewType();

    interviewType.setId(interviewTypeId);
    interviewType.setVersion(Integer.MAX_VALUE);
    return interviewType;
  }
}
