package com.doublechaintech.retailscm.transporttruck;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TransportTruckVersionChangedException extends TransportTruckManagerException {
  private static final long serialVersionUID = 1L;

  public TransportTruckVersionChangedException(String string) {
    super(string);
  }
}
