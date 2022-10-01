package com.doublechaintech.retailscm.levelonecategory;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelOneCategoryNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public LevelOneCategoryNotFoundException(String string) {
    super(string);
  }
}
