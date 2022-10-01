package com.doublechaintech.retailscm.consumerorderpaymentgroup;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class ConsumerOrderPaymentGroupNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderPaymentGroupNotFoundException(String string) {
    super(string);
  }
}
