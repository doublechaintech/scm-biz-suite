package com.doublechaintech.retailscm.treenode;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

public class TreeNodeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "treeNode";

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

  protected TreeNodeTokens() {
    // ensure not initialized outside the class
  }

  public static TreeNodeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    TreeNodeTokens tokens = new TreeNodeTokens(options);
    return tokens;
  }

  protected TreeNodeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public TreeNodeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static TreeNodeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected TreeNodeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static TreeNodeTokens start() {
    return new TreeNodeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public TreeNodeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static TreeNodeTokens loadGroupTokens(String... groupNames) {
    TreeNodeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }

    return tokens;
  }

  private static void addToken(
      TreeNodeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static TreeNodeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start();
  }

  public static TreeNodeTokens allTokens() {

    return start();
  }

  public static TreeNodeTokens withoutListsTokens() {

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

  public TreeNodeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  public TreeNodeTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
