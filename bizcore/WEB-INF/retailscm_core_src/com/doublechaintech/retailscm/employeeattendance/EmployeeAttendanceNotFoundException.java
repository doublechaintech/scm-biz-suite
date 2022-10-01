package com.doublechaintech.retailscm.employeeattendance;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeAttendanceNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EmployeeAttendanceNotFoundException(String string) {
    super(string);
  }
}
