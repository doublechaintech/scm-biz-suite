package com.doublechaintech.retailscm.employeeaward;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeAwardVersionChangedException extends EmployeeAwardManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeAwardVersionChangedException(String string) {
    super(string);
  }
}
