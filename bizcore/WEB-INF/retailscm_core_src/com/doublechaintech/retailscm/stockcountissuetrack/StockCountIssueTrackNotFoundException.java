package com.doublechaintech.retailscm.stockcountissuetrack;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class StockCountIssueTrackNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public StockCountIssueTrackNotFoundException(String string) {
    super(string);
  }
}
