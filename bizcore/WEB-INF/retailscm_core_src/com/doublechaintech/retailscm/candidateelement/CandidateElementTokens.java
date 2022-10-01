package com.doublechaintech.retailscm.candidateelement;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerTokens;

public class CandidateElementTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "candidateElement";

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

  protected CandidateElementTokens() {
    // ensure not initialized outside the class
  }

  public static CandidateElementTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    CandidateElementTokens tokens = new CandidateElementTokens(options);
    return tokens;
  }

  protected CandidateElementTokens(Map<String, Object> options) {
    this.options = options;
  }

  public CandidateElementTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static CandidateElementTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected CandidateElementTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static CandidateElementTokens start() {
    return new CandidateElementTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public CandidateElementTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static CandidateElementTokens loadGroupTokens(String... groupNames) {
    CandidateElementTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, CONTAINER, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      CandidateElementTokens pTokens,
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

  public static CandidateElementTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withContainer();
  }

  public static CandidateElementTokens allTokens() {

    return start().withContainer();
  }

  public static CandidateElementTokens withoutListsTokens() {

    return start().withContainer();
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

  public CandidateElementTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String CONTAINER = "container";

  public String getContainer() {
    return CONTAINER;
  }
  //
  public CandidateElementTokens withContainer() {
    addSimpleOptions(CONTAINER);
    return this;
  }

  public CandidateContainerTokens withContainerTokens() {
    // addSimpleOptions(CONTAINER);
    return CandidateContainerTokens.start();
  }

  public CandidateElementTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
