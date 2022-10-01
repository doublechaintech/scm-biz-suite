package com.doublechaintech.retailscm.consumerorderlineitem;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ConsumerOrderLineItemVersionChangedException
    extends ConsumerOrderLineItemManagerException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderLineItemVersionChangedException(String string) {
    super(string);
  }
}
