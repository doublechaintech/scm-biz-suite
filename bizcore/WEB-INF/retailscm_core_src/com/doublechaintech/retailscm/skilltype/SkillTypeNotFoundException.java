package com.doublechaintech.retailscm.skilltype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SkillTypeNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public SkillTypeNotFoundException(String string) {
    super(string);
  }
}
