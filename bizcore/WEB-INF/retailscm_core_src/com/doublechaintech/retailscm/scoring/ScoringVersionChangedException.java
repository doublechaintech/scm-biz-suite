package com.doublechaintech.retailscm.scoring;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ScoringVersionChangedException extends ScoringManagerException {
  private static final long serialVersionUID = 1L;

  public ScoringVersionChangedException(String string) {
    super(string);
  }
}
