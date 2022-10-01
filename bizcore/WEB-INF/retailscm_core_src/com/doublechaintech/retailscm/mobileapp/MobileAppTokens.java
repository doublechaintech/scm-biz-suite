package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.page.PageTokens;
import com.doublechaintech.retailscm.pagetype.PageTypeTokens;

public class MobileAppTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "mobileApp";

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

  protected MobileAppTokens() {
    // ensure not initialized outside the class
  }

  public static MobileAppTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    MobileAppTokens tokens = new MobileAppTokens(options);
    return tokens;
  }

  protected MobileAppTokens(Map<String, Object> options) {
    this.options = options;
  }

  public MobileAppTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static MobileAppTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected MobileAppTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static MobileAppTokens start() {
    return new MobileAppTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public MobileAppTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static MobileAppTokens loadGroupTokens(String... groupNames) {
    MobileAppTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }

    addToken(tokens, PAGE_LIST, groupNames, new String[] {"default"});

    addToken(tokens, PAGE_TYPE_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      MobileAppTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static MobileAppTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withPageListIfViewGroupInclude(viewGroups)
        .withPageTypeListIfViewGroupInclude(viewGroups);
  }

  public static MobileAppTokens allTokens() {

    return start().withPageList().withPageTypeList();
  }

  public static MobileAppTokens withoutListsTokens() {

    return start();
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

  public MobileAppTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String PAGE_LIST = "pageList";

  public String getPageList() {
    return PAGE_LIST;
  }

  public MobileAppTokens withPageListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("页面管理", viewGroups)) {
      addSimpleOptions(PAGE_LIST);
    }
    return this;
  }

  public MobileAppTokens withPageList() {
    addSimpleOptions(PAGE_LIST);
    return this;
  }

  public PageTokens withPageListTokens() {
    // addSimpleOptions(PAGE_LIST);
    return PageTokens.start();
  }

  public MobileAppTokens analyzePageList() {
    addSimpleOptions(PAGE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzePageListEnabled() {

    if (checkOptions(this.options(), PAGE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public MobileAppTokens extractMoreFromPageList(String idsSeperatedWithComma) {
    addSimpleOptions(PAGE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int pageListSortCounter = 0;

  public MobileAppTokens sortPageListWith(String field, String descOrAsc) {
    addSortMoreOptions(PAGE_LIST, pageListSortCounter++, field, descOrAsc);
    return this;
  }

  private int pageListSearchCounter = 0;

  public MobileAppTokens searchPageListWith(String field, String verb, String value) {

    withPageList();
    addSearchMoreOptions(PAGE_LIST, pageListSearchCounter++, field, verb, value);
    return this;
  }

  public MobileAppTokens searchAllTextOfPageList(String verb, String value) {
    String field = "id|pageTitle|linkToUrl";
    addSearchMoreOptions(PAGE_LIST, pageListSearchCounter++, field, verb, value);
    return this;
  }

  public MobileAppTokens rowsPerPageOfPageList(int rowsPerPage) {
    addSimpleOptions(PAGE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public MobileAppTokens currentPageNumberOfPageList(int currentPageNumber) {
    addSimpleOptions(PAGE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public MobileAppTokens retainColumnsOfPageList(String[] columns) {
    addSimpleOptions(PAGE_LIST + "RetainColumns", columns);
    return this;
  }

  public MobileAppTokens excludeColumnsOfPageList(String[] columns) {
    addSimpleOptions(PAGE_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String PAGE_TYPE_LIST = "pageTypeList";

  public String getPageTypeList() {
    return PAGE_TYPE_LIST;
  }

  public MobileAppTokens withPageTypeListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(PAGE_TYPE_LIST);
    }
    return this;
  }

  public MobileAppTokens withPageTypeList() {
    addSimpleOptions(PAGE_TYPE_LIST);
    return this;
  }

  public PageTypeTokens withPageTypeListTokens() {
    // addSimpleOptions(PAGE_TYPE_LIST);
    return PageTypeTokens.start();
  }

  public MobileAppTokens analyzePageTypeList() {
    addSimpleOptions(PAGE_TYPE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzePageTypeListEnabled() {

    if (checkOptions(this.options(), PAGE_TYPE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public MobileAppTokens extractMoreFromPageTypeList(String idsSeperatedWithComma) {
    addSimpleOptions(PAGE_TYPE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int pageTypeListSortCounter = 0;

  public MobileAppTokens sortPageTypeListWith(String field, String descOrAsc) {
    addSortMoreOptions(PAGE_TYPE_LIST, pageTypeListSortCounter++, field, descOrAsc);
    return this;
  }

  private int pageTypeListSearchCounter = 0;

  public MobileAppTokens searchPageTypeListWith(String field, String verb, String value) {

    withPageTypeList();
    addSearchMoreOptions(PAGE_TYPE_LIST, pageTypeListSearchCounter++, field, verb, value);
    return this;
  }

  public MobileAppTokens searchAllTextOfPageTypeList(String verb, String value) {
    String field = "id|name|code";
    addSearchMoreOptions(PAGE_TYPE_LIST, pageTypeListSearchCounter++, field, verb, value);
    return this;
  }

  public MobileAppTokens rowsPerPageOfPageTypeList(int rowsPerPage) {
    addSimpleOptions(PAGE_TYPE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public MobileAppTokens currentPageNumberOfPageTypeList(int currentPageNumber) {
    addSimpleOptions(PAGE_TYPE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public MobileAppTokens retainColumnsOfPageTypeList(String[] columns) {
    addSimpleOptions(PAGE_TYPE_LIST + "RetainColumns", columns);
    return this;
  }

  public MobileAppTokens excludeColumnsOfPageTypeList(String[] columns) {
    addSimpleOptions(PAGE_TYPE_LIST + "ExcludeColumns", columns);
    return this;
  }

  public MobileAppTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfPageList(verb, value);
    searchAllTextOfPageTypeList(verb, value);
    return this;
  }
}
