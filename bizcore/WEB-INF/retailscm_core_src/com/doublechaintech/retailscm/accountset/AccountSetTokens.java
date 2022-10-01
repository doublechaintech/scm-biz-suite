package com.doublechaintech.retailscm.accountset;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierTokens;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectTokens;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodTokens;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeTokens;

public class AccountSetTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "accountSet";

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

  protected AccountSetTokens() {
    // ensure not initialized outside the class
  }

  public static AccountSetTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    AccountSetTokens tokens = new AccountSetTokens(options);
    return tokens;
  }

  protected AccountSetTokens(Map<String, Object> options) {
    this.options = options;
  }

  public AccountSetTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static AccountSetTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected AccountSetTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static AccountSetTokens start() {
    return new AccountSetTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public AccountSetTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static AccountSetTokens loadGroupTokens(String... groupNames) {
    AccountSetTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COUNTRYCENTER, groupNames, new String[] {"default"});
    addToken(tokens, RETAILSTORE, groupNames, new String[] {"default"});
    addToken(tokens, GOODSSUPPLIER, groupNames, new String[] {"default"});

    addToken(tokens, ACCOUNTING_SUBJECT_LIST, groupNames, new String[] {"default"});

    addToken(tokens, ACCOUNTING_PERIOD_LIST, groupNames, new String[] {"default"});

    addToken(tokens, ACCOUNTING_DOCUMENT_TYPE_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      AccountSetTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static AccountSetTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withCountryCenter()
        .withRetailStore()
        .withGoodsSupplier()
        .withAccountingSubjectListIfViewGroupInclude(viewGroups)
        .withAccountingPeriodListIfViewGroupInclude(viewGroups)
        .withAccountingDocumentTypeListIfViewGroupInclude(viewGroups);
  }

  public static AccountSetTokens allTokens() {

    return start()
        .withCountryCenter()
        .withRetailStore()
        .withGoodsSupplier()
        .withAccountingSubjectList()
        .withAccountingPeriodList()
        .withAccountingDocumentTypeList();
  }

  public static AccountSetTokens withoutListsTokens() {

    return start().withCountryCenter().withRetailStore().withGoodsSupplier();
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

  public AccountSetTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COUNTRYCENTER = "countryCenter";

  public String getCountryCenter() {
    return COUNTRYCENTER;
  }
  //
  public AccountSetTokens withCountryCenter() {
    addSimpleOptions(COUNTRYCENTER);
    return this;
  }

  public RetailStoreCountryCenterTokens withCountryCenterTokens() {
    // addSimpleOptions(COUNTRYCENTER);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String RETAILSTORE = "retailStore";

  public String getRetailStore() {
    return RETAILSTORE;
  }
  //
  public AccountSetTokens withRetailStore() {
    addSimpleOptions(RETAILSTORE);
    return this;
  }

  public RetailStoreTokens withRetailStoreTokens() {
    // addSimpleOptions(RETAILSTORE);
    return RetailStoreTokens.start();
  }

  protected static final String GOODSSUPPLIER = "goodsSupplier";

  public String getGoodsSupplier() {
    return GOODSSUPPLIER;
  }
  //
  public AccountSetTokens withGoodsSupplier() {
    addSimpleOptions(GOODSSUPPLIER);
    return this;
  }

  public GoodsSupplierTokens withGoodsSupplierTokens() {
    // addSimpleOptions(GOODSSUPPLIER);
    return GoodsSupplierTokens.start();
  }

  protected static final String ACCOUNTING_SUBJECT_LIST = "accountingSubjectList";

  public String getAccountingSubjectList() {
    return ACCOUNTING_SUBJECT_LIST;
  }

  public AccountSetTokens withAccountingSubjectListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(ACCOUNTING_SUBJECT_LIST);
    }
    return this;
  }

  public AccountSetTokens withAccountingSubjectList() {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST);
    return this;
  }

  public AccountingSubjectTokens withAccountingSubjectListTokens() {
    // addSimpleOptions(ACCOUNTING_SUBJECT_LIST);
    return AccountingSubjectTokens.start();
  }

  public AccountSetTokens analyzeAccountingSubjectList() {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeAccountingSubjectListEnabled() {

    if (checkOptions(this.options(), ACCOUNTING_SUBJECT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public AccountSetTokens extractMoreFromAccountingSubjectList(String idsSeperatedWithComma) {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int accountingSubjectListSortCounter = 0;

  public AccountSetTokens sortAccountingSubjectListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        ACCOUNTING_SUBJECT_LIST, accountingSubjectListSortCounter++, field, descOrAsc);
    return this;
  }

  private int accountingSubjectListSearchCounter = 0;

  public AccountSetTokens searchAccountingSubjectListWith(String field, String verb, String value) {

    withAccountingSubjectList();
    addSearchMoreOptions(
        ACCOUNTING_SUBJECT_LIST, accountingSubjectListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountSetTokens searchAllTextOfAccountingSubjectList(String verb, String value) {
    String field = "id|accountingSubjectCode|accountingSubjectName|accountingSubjectClassName";
    addSearchMoreOptions(
        ACCOUNTING_SUBJECT_LIST, accountingSubjectListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountSetTokens rowsPerPageOfAccountingSubjectList(int rowsPerPage) {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public AccountSetTokens currentPageNumberOfAccountingSubjectList(int currentPageNumber) {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public AccountSetTokens retainColumnsOfAccountingSubjectList(String[] columns) {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST + "RetainColumns", columns);
    return this;
  }

  public AccountSetTokens excludeColumnsOfAccountingSubjectList(String[] columns) {
    addSimpleOptions(ACCOUNTING_SUBJECT_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String ACCOUNTING_PERIOD_LIST = "accountingPeriodList";

  public String getAccountingPeriodList() {
    return ACCOUNTING_PERIOD_LIST;
  }

  public AccountSetTokens withAccountingPeriodListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(ACCOUNTING_PERIOD_LIST);
    }
    return this;
  }

  public AccountSetTokens withAccountingPeriodList() {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST);
    return this;
  }

  public AccountingPeriodTokens withAccountingPeriodListTokens() {
    // addSimpleOptions(ACCOUNTING_PERIOD_LIST);
    return AccountingPeriodTokens.start();
  }

  public AccountSetTokens analyzeAccountingPeriodList() {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeAccountingPeriodListEnabled() {

    if (checkOptions(this.options(), ACCOUNTING_PERIOD_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public AccountSetTokens extractMoreFromAccountingPeriodList(String idsSeperatedWithComma) {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int accountingPeriodListSortCounter = 0;

  public AccountSetTokens sortAccountingPeriodListWith(String field, String descOrAsc) {
    addSortMoreOptions(ACCOUNTING_PERIOD_LIST, accountingPeriodListSortCounter++, field, descOrAsc);
    return this;
  }

  private int accountingPeriodListSearchCounter = 0;

  public AccountSetTokens searchAccountingPeriodListWith(String field, String verb, String value) {

    withAccountingPeriodList();
    addSearchMoreOptions(
        ACCOUNTING_PERIOD_LIST, accountingPeriodListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountSetTokens searchAllTextOfAccountingPeriodList(String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        ACCOUNTING_PERIOD_LIST, accountingPeriodListSearchCounter++, field, verb, value);
    return this;
  }

  public AccountSetTokens rowsPerPageOfAccountingPeriodList(int rowsPerPage) {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public AccountSetTokens currentPageNumberOfAccountingPeriodList(int currentPageNumber) {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public AccountSetTokens retainColumnsOfAccountingPeriodList(String[] columns) {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST + "RetainColumns", columns);
    return this;
  }

  public AccountSetTokens excludeColumnsOfAccountingPeriodList(String[] columns) {
    addSimpleOptions(ACCOUNTING_PERIOD_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String ACCOUNTING_DOCUMENT_TYPE_LIST = "accountingDocumentTypeList";

  public String getAccountingDocumentTypeList() {
    return ACCOUNTING_DOCUMENT_TYPE_LIST;
  }

  public AccountSetTokens withAccountingDocumentTypeListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST);
    }
    return this;
  }

  public AccountSetTokens withAccountingDocumentTypeList() {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST);
    return this;
  }

  public AccountingDocumentTypeTokens withAccountingDocumentTypeListTokens() {
    // addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST);
    return AccountingDocumentTypeTokens.start();
  }

  public AccountSetTokens analyzeAccountingDocumentTypeList() {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeAccountingDocumentTypeListEnabled() {

    if (checkOptions(this.options(), ACCOUNTING_DOCUMENT_TYPE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public AccountSetTokens extractMoreFromAccountingDocumentTypeList(String idsSeperatedWithComma) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int accountingDocumentTypeListSortCounter = 0;

  public AccountSetTokens sortAccountingDocumentTypeListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        ACCOUNTING_DOCUMENT_TYPE_LIST, accountingDocumentTypeListSortCounter++, field, descOrAsc);
    return this;
  }

  private int accountingDocumentTypeListSearchCounter = 0;

  public AccountSetTokens searchAccountingDocumentTypeListWith(
      String field, String verb, String value) {

    withAccountingDocumentTypeList();
    addSearchMoreOptions(
        ACCOUNTING_DOCUMENT_TYPE_LIST,
        accountingDocumentTypeListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public AccountSetTokens searchAllTextOfAccountingDocumentTypeList(String verb, String value) {
    String field = "id|name|description";
    addSearchMoreOptions(
        ACCOUNTING_DOCUMENT_TYPE_LIST,
        accountingDocumentTypeListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public AccountSetTokens rowsPerPageOfAccountingDocumentTypeList(int rowsPerPage) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public AccountSetTokens currentPageNumberOfAccountingDocumentTypeList(int currentPageNumber) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public AccountSetTokens retainColumnsOfAccountingDocumentTypeList(String[] columns) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST + "RetainColumns", columns);
    return this;
  }

  public AccountSetTokens excludeColumnsOfAccountingDocumentTypeList(String[] columns) {
    addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST + "ExcludeColumns", columns);
    return this;
  }

  public AccountSetTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfAccountingSubjectList(verb, value);
    searchAllTextOfAccountingPeriodList(verb, value);
    searchAllTextOfAccountingDocumentTypeList(verb, value);
    return this;
  }
}
