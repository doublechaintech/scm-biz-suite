package com.doublechaintech.retailscm.employeequalifier;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeQualifierNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EmployeeQualifierNotFoundException(String string) {
    super(string);
  }
}
