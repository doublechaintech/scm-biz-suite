package com.doublechaintech.retailscm.employeesalarysheet;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeSalarySheetVersionChangedException
    extends EmployeeSalarySheetManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeSalarySheetVersionChangedException(String string) {
    super(string);
  }
}
