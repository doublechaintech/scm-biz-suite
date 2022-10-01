package com.doublechaintech.retailscm.section;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.page.PageTokens;

public class SectionTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "section";

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

  protected SectionTokens() {
    // ensure not initialized outside the class
  }

  public static SectionTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    SectionTokens tokens = new SectionTokens(options);
    return tokens;
  }

  protected SectionTokens(Map<String, Object> options) {
    this.options = options;
  }

  public SectionTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static SectionTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected SectionTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static SectionTokens start() {
    return new SectionTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public SectionTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static SectionTokens loadGroupTokens(String... groupNames) {
    SectionTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, PAGE, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      SectionTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static SectionTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withPage();
  }

  public static SectionTokens allTokens() {

    return start().withPage();
  }

  public static SectionTokens withoutListsTokens() {

    return start().withPage();
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

  public SectionTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String PAGE = "page";

  public String getPage() {
    return PAGE;
  }
  //
  public SectionTokens withPage() {
    addSimpleOptions(PAGE);
    return this;
  }

  public PageTokens withPageTokens() {
    // addSimpleOptions(PAGE);
    return PageTokens.start();
  }

  public SectionTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
