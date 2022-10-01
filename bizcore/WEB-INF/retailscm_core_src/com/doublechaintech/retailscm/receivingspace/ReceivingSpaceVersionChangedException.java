package com.doublechaintech.retailscm.receivingspace;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ReceivingSpaceVersionChangedException extends ReceivingSpaceManagerException {
  private static final long serialVersionUID = 1L;

  public ReceivingSpaceVersionChangedException(String string) {
    super(string);
  }
}
