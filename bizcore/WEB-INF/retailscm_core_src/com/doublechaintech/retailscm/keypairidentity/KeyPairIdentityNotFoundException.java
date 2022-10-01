package com.doublechaintech.retailscm.keypairidentity;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class KeyPairIdentityNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public KeyPairIdentityNotFoundException(String string) {
    super(string);
  }
}
