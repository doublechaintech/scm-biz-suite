package com.doublechaintech.retailscm.employeeworkexperience;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeWorkExperienceVersionChangedException
    extends EmployeeWorkExperienceManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeWorkExperienceVersionChangedException(String string) {
    super(string);
  }
}
