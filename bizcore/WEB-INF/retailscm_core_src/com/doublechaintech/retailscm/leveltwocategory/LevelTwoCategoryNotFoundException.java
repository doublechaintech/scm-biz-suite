package com.doublechaintech.retailscm.leveltwocategory;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LevelTwoCategoryNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public LevelTwoCategoryNotFoundException(String string) {
    super(string);
  }
}
