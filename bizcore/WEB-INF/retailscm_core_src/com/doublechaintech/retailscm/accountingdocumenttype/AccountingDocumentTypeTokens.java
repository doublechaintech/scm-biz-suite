package com.doublechaintech.retailscm.accountingdocumenttype;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.accountset.AccountSetTokens;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentTokens;

public class AccountingDocumentTypeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "accountingDocumentType";

  public static boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    if (options == null) {
      return false; // completely no option here
    }
    if (options.containsKey(ALL)) {
      // danger, debug only, might load the entire database!, really terrible
      return true;
    }
    String ownerKey = getOwnerObjectKey();
    Object ownerObject = (String) options.get(ownerKey);
    if (ownerObject == null) {
      return false;
    }
    if (!ownerObject.equals(OWNER_OBJECT_NAME)) { // is the owner?
      return false;
    }

    if (options.containsKey(optionToCheck)) {
      // options.remove(optionToCheck);
      // consume the key, can not use any more to extract the data with the same token.
      return true;
    }

    return false;
  }

  protected AccountingDocumentTypeTokens() {
    // ensure not initialized outside the class
  }

  public static AccountingDocumentTypeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    AccountingDocumentTypeTokens tokens = new AccountingDocumentTypeTokens(options);
    return tokens;
  }

  protected AccountingDocumentTypeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public AccountingDocumentTypeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static AccountingDocumentTypeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected AccountingDocumentTypeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static AccountingDocumentTypeTokens start() {
    return new AccountingDocumentTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public AccountingDocumentTypeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static AccountingDocumentTypeTokens loadGroupTokens(String... groupNames) {
    AccountingDocumentTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, ACCOUNTINGPERIOD, groupNames, new String[] {"default"});

    addToken(tokens, ACCOUNTING_DOCUMENT_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      AccountingDocumentTypeTokens pTokens,
      String pTokenName,
      String[] pGroupNames,
      String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null) {
      return;
    }

    for (String groupName : pGroupNames) {
      for (String g : fieldGroups) {
        if (Objects.equals(groupName, g)) {
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

  public static AccountingDocumentTypeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withAccountingPeriod().withAccountingDocumentListIfViewGroupInclude(viewGroups);
  }

  public static AccountingDocumentTypeTokens allTokens() {

    return start().withAccountingPeriod().withAccountingDocumentList();
  }

  public static AccountingDocumentTypeTokens withoutListsTokens() {

    return start().withAccountingPeriod();
  }

  public static Map<String, Object> all() {
    return allTokens().done();
  }

  public static Map<String, Object> withoutLists() {
    return withoutListsTokens().done();
  }

  public static Map<String, Object> empty() {
    return start().done();
  }

  public AccountingDocumentTypeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String ACCOUNTINGPERIOD = "accountingPeriod";

  public String getAccountingPeriod() {
    return ACCOUNTINGPERIOD;
  }
  //
  public AccountingDocumentTypeTokens withAccountingPeriod() {
    addSimpleOptions(ACCOUNTINGPERIOD);
    return this;
  }

  public AccountSetTokens withAccountingPeriodTokens() {
    // addSimpleOptions(ACCOUNTINGPERIOD);
    return AccountSetTokens.start();
  }

  protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";

  public String getAccountingDocumentList() {
    return ACCOUNTING_DOCUMENT_LIST;
  }

  public AccountingDocumentTypeTokens withAccountingDocumentListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
    }
    return this;
  }

  public AccountingDocumentTypeTokens withAccountingDocumentList() {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
    return this;
  }

  public AccountingDocumentTokens withAccountingDocumentListTokens() {
    // addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
    return AccountingDocumentTokens.start();
  }

  public AccountingDocumentTypeTokens analyzeAccountingDocumentList() {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeAccountingDocumentListEnabled() {

    if (checkOptions(this.options(), ACCOUNTING_DOCUMENT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public AccountingDocumentTypeTokens extractMoreFromAccountingDocumentList(
      String idsSeperatedWithComma) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int accountingDocumentListSortCounter = 0;

  public AccountingDocumentTypeTokens sortAccountingDocumentListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        ACCOUNTING_DOCUMENT_LIST, accountingDocumentListSortCounter++, field, descOrAsc);
    return this;
  }

  private int accountingDocumentListSearchCounter = 0;

  public AccountingDocumentTypeTokens searchAccountingDocumentListWith(
      String field, String verb, String value) {

    withAccountingDocumentList();
    addSearchMoreOptions(
        ACCOUNTING_DOCUMENT_LIST, accountingDocumentListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountingDocumentTypeTokens searchAllTextOfAccountingDocumentList(
      String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        ACCOUNTING_DOCUMENT_LIST, accountingDocumentListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountingDocumentTypeTokens rowsPerPageOfAccountingDocumentList(int rowsPerPage) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public AccountingDocumentTypeTokens currentPageNumberOfAccountingDocumentList(
      int currentPageNumber) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public AccountingDocumentTypeTokens retainColumnsOfAccountingDocumentList(String[] columns) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST + "RetainColumns", columns);
    return this;
  }

  public AccountingDocumentTypeTokens excludeColumnsOfAccountingDocumentList(String[] columns) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LIST + "ExcludeColumns", columns);
    return this;
  }

  public AccountingDocumentTypeTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfAccountingDocumentList(verb, value);
    return this;
  }
}
