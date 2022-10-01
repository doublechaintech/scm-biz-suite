package com.doublechaintech.retailscm.consumerorder;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ConsumerOrderVersionChangedException extends ConsumerOrderManagerException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderVersionChangedException(String string) {
    super(string);
  }
}
