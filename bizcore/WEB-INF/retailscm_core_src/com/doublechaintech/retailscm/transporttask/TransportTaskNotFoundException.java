package com.doublechaintech.retailscm.transporttask;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TransportTaskNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public TransportTaskNotFoundException(String string) {
    super(string);
  }
}
