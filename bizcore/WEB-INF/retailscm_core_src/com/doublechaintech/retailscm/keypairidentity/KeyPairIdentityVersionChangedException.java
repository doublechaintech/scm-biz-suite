package com.doublechaintech.retailscm.keypairidentity;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class KeyPairIdentityVersionChangedException extends KeyPairIdentityManagerException {
  private static final long serialVersionUID = 1L;

  public KeyPairIdentityVersionChangedException(String string) {
    super(string);
  }
}
