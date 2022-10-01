package com.doublechaintech.retailscm.companytraining;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CompanyTrainingVersionChangedException extends CompanyTrainingManagerException {
  private static final long serialVersionUID = 1L;

  public CompanyTrainingVersionChangedException(String string) {
    super(string);
  }
}
