package com.doublechaintech.retailscm.employee;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EmployeeNotFoundException(String string) {
    super(string);
  }
}
