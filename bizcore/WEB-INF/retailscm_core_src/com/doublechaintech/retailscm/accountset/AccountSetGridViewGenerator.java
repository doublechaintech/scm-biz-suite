package com.doublechaintech.retailscm.accountset;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class AccountSetGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for AccountSet", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (AccountSet.ACCOUNTING_SUBJECT_LIST.equals(listName)) {
      return new String[] {
        "id",
        "accounting_subject_code",
        "accounting_subject_name",
        "accounting_subject_class_code",
        "accounting_subject_class_name",
        "account_set",
        "version"
      };
    }
    if (AccountSet.ACCOUNTING_PERIOD_LIST.equals(listName)) {
      return new String[] {"id", "name", "start_date", "end_date", "account_set", "version"};
    }
    if (AccountSet.ACCOUNTING_DOCUMENT_TYPE_LIST.equals(listName)) {
      return new String[] {"id", "name", "description", "accounting_period", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (AccountSet.ACCOUNTING_SUBJECT_LIST.equals(listName)) {
      return "accounting_subject";
    }
    if (AccountSet.ACCOUNTING_PERIOD_LIST.equals(listName)) {
      return "accounting_period";
    }
    if (AccountSet.ACCOUNTING_DOCUMENT_TYPE_LIST.equals(listName)) {
      return "accounting_document_type";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
