package com.doublechaintech.retailscm.interviewtype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class InterviewTypeNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public InterviewTypeNotFoundException(String string) {
    super(string);
  }
}
