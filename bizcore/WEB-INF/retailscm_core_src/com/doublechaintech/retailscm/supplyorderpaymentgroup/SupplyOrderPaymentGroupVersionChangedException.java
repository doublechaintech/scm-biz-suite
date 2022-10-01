package com.doublechaintech.retailscm.supplyorderpaymentgroup;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class SupplyOrderPaymentGroupVersionChangedException
    extends SupplyOrderPaymentGroupManagerException {
  private static final long serialVersionUID = 1L;

  public SupplyOrderPaymentGroupVersionChangedException(String string) {
    super(string);
  }
}
