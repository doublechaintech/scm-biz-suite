package com.doublechaintech.retailscm.userapp;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.secuser.SecUserTokens;
import com.doublechaintech.retailscm.quicklink.QuickLinkTokens;
import com.doublechaintech.retailscm.listaccess.ListAccessTokens;

public class UserAppTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "userApp";

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

  protected UserAppTokens() {
    // ensure not initialized outside the class
  }

  public static UserAppTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    UserAppTokens tokens = new UserAppTokens(options);
    return tokens;
  }

  protected UserAppTokens(Map<String, Object> options) {
    this.options = options;
  }

  public UserAppTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static UserAppTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected UserAppTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static UserAppTokens start() {
    return new UserAppTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public UserAppTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static UserAppTokens loadGroupTokens(String... groupNames) {
    UserAppTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, SECUSER, groupNames, new String[] {"default"});

    addToken(tokens, QUICK_LINK_LIST, groupNames, new String[] {"default"});

    addToken(tokens, LIST_ACCESS_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      UserAppTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static UserAppTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withSecUser()
        .withQuickLinkListIfViewGroupInclude(viewGroups)
        .withListAccessListIfViewGroupInclude(viewGroups);
  }

  public static UserAppTokens allTokens() {

    return start().withSecUser().withQuickLinkList().withListAccessList();
  }

  public static UserAppTokens withoutListsTokens() {

    return start().withSecUser();
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

  public UserAppTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String SECUSER = "secUser";

  public String getSecUser() {
    return SECUSER;
  }
  //
  public UserAppTokens withSecUser() {
    addSimpleOptions(SECUSER);
    return this;
  }

  public SecUserTokens withSecUserTokens() {
    // addSimpleOptions(SECUSER);
    return SecUserTokens.start();
  }

  protected static final String QUICK_LINK_LIST = "quickLinkList";

  public String getQuickLinkList() {
    return QUICK_LINK_LIST;
  }

  public UserAppTokens withQuickLinkListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(QUICK_LINK_LIST);
    }
    return this;
  }

  public UserAppTokens withQuickLinkList() {
    addSimpleOptions(QUICK_LINK_LIST);
    return this;
  }

  public QuickLinkTokens withQuickLinkListTokens() {
    // addSimpleOptions(QUICK_LINK_LIST);
    return QuickLinkTokens.start();
  }

  public UserAppTokens analyzeQuickLinkList() {
    addSimpleOptions(QUICK_LINK_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeQuickLinkListEnabled() {

    if (checkOptions(this.options(), QUICK_LINK_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public UserAppTokens extractMoreFromQuickLinkList(String idsSeperatedWithComma) {
    addSimpleOptions(QUICK_LINK_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int quickLinkListSortCounter = 0;

  public UserAppTokens sortQuickLinkListWith(String field, String descOrAsc) {
    addSortMoreOptions(QUICK_LINK_LIST, quickLinkListSortCounter++, field, descOrAsc);
    return this;
  }

  private int quickLinkListSearchCounter = 0;

  public UserAppTokens searchQuickLinkListWith(String field, String verb, String value) {

    withQuickLinkList();
    addSearchMoreOptions(QUICK_LINK_LIST, quickLinkListSearchCounter++, field, verb, value);
    return this;
  }

  public UserAppTokens searchAllTextOfQuickLinkList(String verb, String value) {
    String field = "id|name|icon|linkTarget";
    addSearchMoreOptions(QUICK_LINK_LIST, quickLinkListSearchCounter++, field, verb, value);
    return this;
  }

  public UserAppTokens rowsPerPageOfQuickLinkList(int rowsPerPage) {
    addSimpleOptions(QUICK_LINK_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public UserAppTokens currentPageNumberOfQuickLinkList(int currentPageNumber) {
    addSimpleOptions(QUICK_LINK_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public UserAppTokens retainColumnsOfQuickLinkList(String[] columns) {
    addSimpleOptions(QUICK_LINK_LIST + "RetainColumns", columns);
    return this;
  }

  public UserAppTokens excludeColumnsOfQuickLinkList(String[] columns) {
    addSimpleOptions(QUICK_LINK_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String LIST_ACCESS_LIST = "listAccessList";

  public String getListAccessList() {
    return LIST_ACCESS_LIST;
  }

  public UserAppTokens withListAccessListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(LIST_ACCESS_LIST);
    }
    return this;
  }

  public UserAppTokens withListAccessList() {
    addSimpleOptions(LIST_ACCESS_LIST);
    return this;
  }

  public ListAccessTokens withListAccessListTokens() {
    // addSimpleOptions(LIST_ACCESS_LIST);
    return ListAccessTokens.start();
  }

  public UserAppTokens analyzeListAccessList() {
    addSimpleOptions(LIST_ACCESS_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeListAccessListEnabled() {

    if (checkOptions(this.options(), LIST_ACCESS_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public UserAppTokens extractMoreFromListAccessList(String idsSeperatedWithComma) {
    addSimpleOptions(LIST_ACCESS_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int listAccessListSortCounter = 0;

  public UserAppTokens sortListAccessListWith(String field, String descOrAsc) {
    addSortMoreOptions(LIST_ACCESS_LIST, listAccessListSortCounter++, field, descOrAsc);
    return this;
  }

  private int listAccessListSearchCounter = 0;

  public UserAppTokens searchListAccessListWith(String field, String verb, String value) {

    withListAccessList();
    addSearchMoreOptions(LIST_ACCESS_LIST, listAccessListSearchCounter++, field, verb, value);
    return this;
  }

  public UserAppTokens searchAllTextOfListAccessList(String verb, String value) {
    String field = "id|name|internalName";
    addSearchMoreOptions(LIST_ACCESS_LIST, listAccessListSearchCounter++, field, verb, value);
    return this;
  }

  public UserAppTokens rowsPerPageOfListAccessList(int rowsPerPage) {
    addSimpleOptions(LIST_ACCESS_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public UserAppTokens currentPageNumberOfListAccessList(int currentPageNumber) {
    addSimpleOptions(LIST_ACCESS_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public UserAppTokens retainColumnsOfListAccessList(String[] columns) {
    addSimpleOptions(LIST_ACCESS_LIST + "RetainColumns", columns);
    return this;
  }

  public UserAppTokens excludeColumnsOfListAccessList(String[] columns) {
    addSimpleOptions(LIST_ACCESS_LIST + "ExcludeColumns", columns);
    return this;
  }

  public UserAppTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfQuickLinkList(verb, value);
    searchAllTextOfListAccessList(verb, value);
    return this;
  }
}
