package com.doublechaintech.retailscm.publickeytype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class PublicKeyTypeNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public PublicKeyTypeNotFoundException(String string) {
    super(string);
  }
}
