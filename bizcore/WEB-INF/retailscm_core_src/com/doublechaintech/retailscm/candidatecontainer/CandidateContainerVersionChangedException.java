package com.doublechaintech.retailscm.candidatecontainer;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CandidateContainerVersionChangedException extends CandidateContainerManagerException {
  private static final long serialVersionUID = 1L;

  public CandidateContainerVersionChangedException(String string) {
    super(string);
  }
}
