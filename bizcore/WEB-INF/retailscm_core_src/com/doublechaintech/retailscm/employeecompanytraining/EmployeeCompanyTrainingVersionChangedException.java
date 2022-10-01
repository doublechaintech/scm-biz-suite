package com.doublechaintech.retailscm.employeecompanytraining;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeCompanyTrainingVersionChangedException
    extends EmployeeCompanyTrainingManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeCompanyTrainingVersionChangedException(String string) {
    super(string);
  }
}
