package com.doublechaintech.retailscm.employeequalifier;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeQualifierVersionChangedException extends EmployeeQualifierManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeQualifierVersionChangedException(String string) {
    super(string);
  }
}
