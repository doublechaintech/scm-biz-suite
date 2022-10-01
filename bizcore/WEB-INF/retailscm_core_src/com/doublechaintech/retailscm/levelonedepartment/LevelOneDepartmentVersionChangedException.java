package com.doublechaintech.retailscm.levelonedepartment;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelOneDepartmentVersionChangedException extends LevelOneDepartmentManagerException {
  private static final long serialVersionUID = 1L;

  public LevelOneDepartmentVersionChangedException(String string) {
    super(string);
  }
}
