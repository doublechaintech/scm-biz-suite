package com.doublechaintech.retailscm.termination;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TerminationNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public TerminationNotFoundException(String string) {
    super(string);
  }
}
