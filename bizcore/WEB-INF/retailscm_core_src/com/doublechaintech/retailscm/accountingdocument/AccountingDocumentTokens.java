package com.doublechaintech.retailscm.accountingdocument;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodTokens;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeTokens;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherTokens;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineTokens;

public class AccountingDocumentTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "accountingDocument";

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

  protected AccountingDocumentTokens() {
    // ensure not initialized outside the class
  }

  public static AccountingDocumentTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    AccountingDocumentTokens tokens = new AccountingDocumentTokens(options);
    return tokens;
  }

  protected AccountingDocumentTokens(Map<String, Object> options) {
    this.options = options;
  }

  public AccountingDocumentTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static AccountingDocumentTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected AccountingDocumentTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static AccountingDocumentTokens start() {
    return new AccountingDocumentTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public AccountingDocumentTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static AccountingDocumentTokens loadGroupTokens(String... groupNames) {
    AccountingDocumentTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, ACCOUNTINGPERIOD, groupNames, new String[] {"default"});
    addToken(tokens, DOCUMENTTYPE, groupNames, new String[] {"default"});

    addToken(tokens, ORIGINAL_VOUCHER_LIST, groupNames, new String[] {"default"});

    addToken(tokens, ACCOUNTING_DOCUMENT_LINE_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      AccountingDocumentTokens pTokens,
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

  public static AccountingDocumentTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withAccountingPeriod()
        .withDocumentType()
        .withOriginalVoucherListIfViewGroupInclude(viewGroups)
        .withAccountingDocumentLineListIfViewGroupInclude(viewGroups);
  }

  public static AccountingDocumentTokens allTokens() {

    return start()
        .withAccountingPeriod()
        .withDocumentType()
        .withOriginalVoucherList()
        .withAccountingDocumentLineList();
  }

  public static AccountingDocumentTokens withoutListsTokens() {

    return start().withAccountingPeriod().withDocumentType();
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

  public AccountingDocumentTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String ACCOUNTINGPERIOD = "accountingPeriod";

  public String getAccountingPeriod() {
    return ACCOUNTINGPERIOD;
  }
  //
  public AccountingDocumentTokens withAccountingPeriod() {
    addSimpleOptions(ACCOUNTINGPERIOD);
    return this;
  }

  public AccountingPeriodTokens withAccountingPeriodTokens() {
    // addSimpleOptions(ACCOUNTINGPERIOD);
    return AccountingPeriodTokens.start();
  }

  protected static final String DOCUMENTTYPE = "documentType";

  public String getDocumentType() {
    return DOCUMENTTYPE;
  }
  //
  public AccountingDocumentTokens withDocumentType() {
    addSimpleOptions(DOCUMENTTYPE);
    return this;
  }

  public AccountingDocumentTypeTokens withDocumentTypeTokens() {
    // addSimpleOptions(DOCUMENTTYPE);
    return AccountingDocumentTypeTokens.start();
  }

  protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";

  public String getOriginalVoucherList() {
    return ORIGINAL_VOUCHER_LIST;
  }

  public AccountingDocumentTokens withOriginalVoucherListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(ORIGINAL_VOUCHER_LIST);
    }
    return this;
  }

  public AccountingDocumentTokens withOriginalVoucherList() {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST);
    return this;
  }

  public OriginalVoucherTokens withOriginalVoucherListTokens() {
    // addSimpleOptions(ORIGINAL_VOUCHER_LIST);
    return OriginalVoucherTokens.start();
  }

  public AccountingDocumentTokens analyzeOriginalVoucherList() {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeOriginalVoucherListEnabled() {

    if (checkOptions(this.options(), ORIGINAL_VOUCHER_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public AccountingDocumentTokens extractMoreFromOriginalVoucherList(String idsSeperatedWithComma) {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int originalVoucherListSortCounter = 0;

  public AccountingDocumentTokens sortOriginalVoucherListWith(String field, String descOrAsc) {
    addSortMoreOptions(ORIGINAL_VOUCHER_LIST, originalVoucherListSortCounter++, field, descOrAsc);
    return this;
  }

  private int originalVoucherListSearchCounter = 0;

  public AccountingDocumentTokens searchOriginalVoucherListWith(
      String field, String verb, String value) {

    withOriginalVoucherList();
    addSearchMoreOptions(
        ORIGINAL_VOUCHER_LIST, originalVoucherListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountingDocumentTokens searchAllTextOfOriginalVoucherList(String verb, String value) {
    String field = "id|title|madeBy|receivedBy|voucherType";
    addSearchMoreOptions(
        ORIGINAL_VOUCHER_LIST, originalVoucherListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountingDocumentTokens rowsPerPageOfOriginalVoucherList(int rowsPerPage) {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public AccountingDocumentTokens currentPageNumberOfOriginalVoucherList(int currentPageNumber) {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public AccountingDocumentTokens retainColumnsOfOriginalVoucherList(String[] columns) {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST + "RetainColumns", columns);
    return this;
  }

  public AccountingDocumentTokens excludeColumnsOfOriginalVoucherList(String[] columns) {
    addSimpleOptions(ORIGINAL_VOUCHER_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String ACCOUNTING_DOCUMENT_LINE_LIST = "accountingDocumentLineList";

  public String getAccountingDocumentLineList() {
    return ACCOUNTING_DOCUMENT_LINE_LIST;
  }

  public AccountingDocumentTokens withAccountingDocumentLineListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST);
    }
    return this;
  }

  public AccountingDocumentTokens withAccountingDocumentLineList() {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST);
    return this;
  }

  public AccountingDocumentLineTokens withAccountingDocumentLineListTokens() {
    // addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST);
    return AccountingDocumentLineTokens.start();
  }

  public AccountingDocumentTokens analyzeAccountingDocumentLineList() {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeAccountingDocumentLineListEnabled() {

    if (checkOptions(this.options(), ACCOUNTING_DOCUMENT_LINE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public AccountingDocumentTokens extractMoreFromAccountingDocumentLineList(
      String idsSeperatedWithComma) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int accountingDocumentLineListSortCounter = 0;

  public AccountingDocumentTokens sortAccountingDocumentLineListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        ACCOUNTING_DOCUMENT_LINE_LIST, accountingDocumentLineListSortCounter++, field, descOrAsc);
    return this;
  }

  private int accountingDocumentLineListSearchCounter = 0;

  public AccountingDocumentTokens searchAccountingDocumentLineListWith(
      String field, String verb, String value) {

    withAccountingDocumentLineList();
    addSearchMoreOptions(
        ACCOUNTING_DOCUMENT_LINE_LIST,
        accountingDocumentLineListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public AccountingDocumentTokens searchAllTextOfAccountingDocumentLineList(
      String verb, String value) {
    String field = "id|name|code|direct";
    addSearchMoreOptions(
        ACCOUNTING_DOCUMENT_LINE_LIST,
        accountingDocumentLineListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public AccountingDocumentTokens rowsPerPageOfAccountingDocumentLineList(int rowsPerPage) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public AccountingDocumentTokens currentPageNumberOfAccountingDocumentLineList(
      int currentPageNumber) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public AccountingDocumentTokens retainColumnsOfAccountingDocumentLineList(String[] columns) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST + "RetainColumns", columns);
    return this;
  }

  public AccountingDocumentTokens excludeColumnsOfAccountingDocumentLineList(String[] columns) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST + "ExcludeColumns", columns);
    return this;
  }

  public AccountingDocumentTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfOriginalVoucherList(verb, value);
    searchAllTextOfAccountingDocumentLineList(verb, value);
    return this;
  }
}
