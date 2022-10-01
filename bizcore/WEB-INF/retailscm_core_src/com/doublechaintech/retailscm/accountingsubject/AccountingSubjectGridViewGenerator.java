package com.doublechaintech.retailscm.accountingsubject;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class AccountingSubjectGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for AccountingSubject", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (AccountingSubject.ACCOUNTING_DOCUMENT_LINE_LIST.equals(listName)) {
      return new String[] {
        "id", "name", "code", "direct", "amount", "belongs_to", "accounting_subject", "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (AccountingSubject.ACCOUNTING_DOCUMENT_LINE_LIST.equals(listName)) {
      return "accounting_document_line";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
