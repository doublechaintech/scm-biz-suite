package com.doublechaintech.retailscm.levelthreecategory;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelThreeCategoryNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public LevelThreeCategoryNotFoundException(String string) {
    super(string);
  }
}
