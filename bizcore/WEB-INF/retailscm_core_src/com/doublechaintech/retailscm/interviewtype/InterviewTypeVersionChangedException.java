package com.doublechaintech.retailscm.interviewtype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class InterviewTypeVersionChangedException extends InterviewTypeManagerException {
  private static final long serialVersionUID = 1L;

  public InterviewTypeVersionChangedException(String string) {
    super(string);
  }
}
