package com.doublechaintech.retailscm.transporttask;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TransportTaskVersionChangedException extends TransportTaskManagerException {
  private static final long serialVersionUID = 1L;

  public TransportTaskVersionChangedException(String string) {
    super(string);
  }
}
