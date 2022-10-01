package com.doublechaintech.retailscm.employeesalarysheet;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeSalarySheetNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EmployeeSalarySheetNotFoundException(String string) {
    super(string);
  }
}
