package com.doublechaintech.retailscm.terminationtype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TerminationTypeVersionChangedException extends TerminationTypeManagerException {
  private static final long serialVersionUID = 1L;

  public TerminationTypeVersionChangedException(String string) {
    super(string);
  }
}
