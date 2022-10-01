package com.doublechaintech.retailscm.supplierspace;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SupplierSpaceNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public SupplierSpaceNotFoundException(String string) {
    super(string);
  }
}
