package com.doublechaintech.retailscm.companytraining;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class CompanyTrainingNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public CompanyTrainingNotFoundException(String string) {
    super(string);
  }
}
