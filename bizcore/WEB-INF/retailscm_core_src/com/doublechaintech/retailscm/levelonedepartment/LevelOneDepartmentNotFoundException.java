package com.doublechaintech.retailscm.levelonedepartment;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelOneDepartmentNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public LevelOneDepartmentNotFoundException(String string) {
    super(string);
  }
}
