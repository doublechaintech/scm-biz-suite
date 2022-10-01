package com.doublechaintech.retailscm.employee;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeVersionChangedException extends EmployeeManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeVersionChangedException(String string) {
    super(string);
  }
}
