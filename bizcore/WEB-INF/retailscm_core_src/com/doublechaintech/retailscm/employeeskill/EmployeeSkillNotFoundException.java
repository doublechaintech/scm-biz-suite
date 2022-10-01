package com.doublechaintech.retailscm.employeeskill;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EmployeeSkillNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EmployeeSkillNotFoundException(String string) {
    super(string);
  }
}
