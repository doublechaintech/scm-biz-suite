package com.doublechaintech.retailscm.employeeleave;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeLeaveNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EmployeeLeaveNotFoundException(String string) {
    super(string);
  }
}
