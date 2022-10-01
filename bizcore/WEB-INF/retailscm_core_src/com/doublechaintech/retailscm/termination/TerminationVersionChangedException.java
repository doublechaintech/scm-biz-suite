package com.doublechaintech.retailscm.termination;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TerminationVersionChangedException extends TerminationManagerException {
  private static final long serialVersionUID = 1L;

  public TerminationVersionChangedException(String string) {
    super(string);
  }
}
