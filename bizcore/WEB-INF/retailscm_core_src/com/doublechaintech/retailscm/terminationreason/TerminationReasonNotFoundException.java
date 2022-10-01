package com.doublechaintech.retailscm.terminationreason;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TerminationReasonNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public TerminationReasonNotFoundException(String string) {
    super(string);
  }
}
