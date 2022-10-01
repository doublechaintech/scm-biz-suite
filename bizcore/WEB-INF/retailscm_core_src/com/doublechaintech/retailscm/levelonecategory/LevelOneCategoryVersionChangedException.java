package com.doublechaintech.retailscm.levelonecategory;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelOneCategoryVersionChangedException extends LevelOneCategoryManagerException {
  private static final long serialVersionUID = 1L;

  public LevelOneCategoryVersionChangedException(String string) {
    super(string);
  }
}
