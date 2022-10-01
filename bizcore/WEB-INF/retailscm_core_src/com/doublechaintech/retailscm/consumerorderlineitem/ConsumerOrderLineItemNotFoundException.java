package com.doublechaintech.retailscm.consumerorderlineitem;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ConsumerOrderLineItemNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderLineItemNotFoundException(String string) {
    super(string);
  }
}
