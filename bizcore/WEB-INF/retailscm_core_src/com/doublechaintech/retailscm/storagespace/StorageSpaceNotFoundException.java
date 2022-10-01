package com.doublechaintech.retailscm.storagespace;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class StorageSpaceNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public StorageSpaceNotFoundException(String string) {
    super(string);
  }
}
