package com.doublechaintech.retailscm.leveltwodepartment;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelTwoDepartmentVersionChangedException extends LevelTwoDepartmentManagerException {
  private static final long serialVersionUID = 1L;

  public LevelTwoDepartmentVersionChangedException(String string) {
    super(string);
  }
}
