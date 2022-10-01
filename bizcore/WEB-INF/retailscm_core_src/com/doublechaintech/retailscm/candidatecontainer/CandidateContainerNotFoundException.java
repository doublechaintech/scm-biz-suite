package com.doublechaintech.retailscm.candidatecontainer;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CandidateContainerNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public CandidateContainerNotFoundException(String string) {
    super(string);
  }
}
