package com.doublechaintech.retailscm.quicklink;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.userapp.UserAppTokens;

public class QuickLinkTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "quickLink";

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

  protected QuickLinkTokens() {
    // ensure not initialized outside the class
  }

  public static QuickLinkTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    QuickLinkTokens tokens = new QuickLinkTokens(options);
    return tokens;
  }

  protected QuickLinkTokens(Map<String, Object> options) {
    this.options = options;
  }

  public QuickLinkTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static QuickLinkTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected QuickLinkTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static QuickLinkTokens start() {
    return new QuickLinkTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public QuickLinkTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static QuickLinkTokens loadGroupTokens(String... groupNames) {
    QuickLinkTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, APP, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      QuickLinkTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static QuickLinkTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withApp();
  }

  public static QuickLinkTokens allTokens() {

    return start().withApp();
  }

  public static QuickLinkTokens withoutListsTokens() {

    return start().withApp();
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

  public QuickLinkTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String APP = "app";

  public String getApp() {
    return APP;
  }
  //
  public QuickLinkTokens withApp() {
    addSimpleOptions(APP);
    return this;
  }

  public UserAppTokens withAppTokens() {
    // addSimpleOptions(APP);
    return UserAppTokens.start();
  }

  public QuickLinkTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
