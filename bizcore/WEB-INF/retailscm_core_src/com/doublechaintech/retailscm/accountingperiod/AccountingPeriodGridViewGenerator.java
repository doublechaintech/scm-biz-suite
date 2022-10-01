package com.doublechaintech.retailscm.accountingperiod;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class AccountingPeriodGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for AccountingPeriod", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (AccountingPeriod.ACCOUNTING_DOCUMENT_LIST.equals(listName)) {
      return new String[] {
        "id", "name", "accounting_document_date", "accounting_period", "document_type", "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (AccountingPeriod.ACCOUNTING_DOCUMENT_LIST.equals(listName)) {
      return "accounting_document";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
