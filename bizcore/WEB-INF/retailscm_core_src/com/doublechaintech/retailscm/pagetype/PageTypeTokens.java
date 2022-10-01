package com.doublechaintech.retailscm.pagetype;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.mobileapp.MobileAppTokens;
import com.doublechaintech.retailscm.page.PageTokens;

public class PageTypeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "pageType";

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

  protected PageTypeTokens() {
    // ensure not initialized outside the class
  }

  public static PageTypeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    PageTypeTokens tokens = new PageTypeTokens(options);
    return tokens;
  }

  protected PageTypeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public PageTypeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static PageTypeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected PageTypeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static PageTypeTokens start() {
    return new PageTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public PageTypeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static PageTypeTokens loadGroupTokens(String... groupNames) {
    PageTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, MOBILEAPP, groupNames, new String[] {"default"});

    addToken(tokens, PAGE_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      PageTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static PageTypeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withMobileApp().withPageListIfViewGroupInclude(viewGroups);
  }

  public static PageTypeTokens allTokens() {

    return start().withMobileApp().withPageList();
  }

  public static PageTypeTokens withoutListsTokens() {

    return start().withMobileApp();
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

  public PageTypeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String MOBILEAPP = "mobileApp";

  public String getMobileApp() {
    return MOBILEAPP;
  }
  //
  public PageTypeTokens withMobileApp() {
    addSimpleOptions(MOBILEAPP);
    return this;
  }

  public MobileAppTokens withMobileAppTokens() {
    // addSimpleOptions(MOBILEAPP);
    return MobileAppTokens.start();
  }

  protected static final String PAGE_LIST = "pageList";

  public String getPageList() {
    return PAGE_LIST;
  }

  public PageTypeTokens withPageListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(PAGE_LIST);
    }
    return this;
  }

  public PageTypeTokens withPageList() {
    addSimpleOptions(PAGE_LIST);
    return this;
  }

  public PageTokens withPageListTokens() {
    // addSimpleOptions(PAGE_LIST);
    return PageTokens.start();
  }

  public PageTypeTokens analyzePageList() {
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

  public PageTypeTokens extractMoreFromPageList(String idsSeperatedWithComma) {
    addSimpleOptions(PAGE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int pageListSortCounter = 0;

  public PageTypeTokens sortPageListWith(String field, String descOrAsc) {
    addSortMoreOptions(PAGE_LIST, pageListSortCounter++, field, descOrAsc);
    return this;
  }

  private int pageListSearchCounter = 0;

  public PageTypeTokens searchPageListWith(String field, String verb, String value) {

    withPageList();
    addSearchMoreOptions(PAGE_LIST, pageListSearchCounter++, field, verb, value);
    return this;
  }

  public PageTypeTokens searchAllTextOfPageList(String verb, String value) {
    String field = "id|pageTitle|linkToUrl";
    addSearchMoreOptions(PAGE_LIST, pageListSearchCounter++, field, verb, value);
    return this;
  }

  public PageTypeTokens rowsPerPageOfPageList(int rowsPerPage) {
    addSimpleOptions(PAGE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public PageTypeTokens currentPageNumberOfPageList(int currentPageNumber) {
    addSimpleOptions(PAGE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public PageTypeTokens retainColumnsOfPageList(String[] columns) {
    addSimpleOptions(PAGE_LIST + "RetainColumns", columns);
    return this;
  }

  public PageTypeTokens excludeColumnsOfPageList(String[] columns) {
    addSimpleOptions(PAGE_LIST + "ExcludeColumns", columns);
    return this;
  }

  public PageTypeTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfPageList(verb, value);
    return this;
  }
}
