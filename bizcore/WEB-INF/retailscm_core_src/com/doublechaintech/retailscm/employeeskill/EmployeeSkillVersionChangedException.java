package com.doublechaintech.retailscm.employeeskill;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeSkillVersionChangedException extends EmployeeSkillManagerException {
  private static final long serialVersionUID = 1L;

  public EmployeeSkillVersionChangedException(String string) {
    super(string);
  }
}
