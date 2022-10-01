package com.doublechaintech.retailscm.leveltwodepartment;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentTokens;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentTokens;

public class LevelTwoDepartmentTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "levelTwoDepartment";

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

  protected LevelTwoDepartmentTokens() {
    // ensure not initialized outside the class
  }

  public static LevelTwoDepartmentTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    LevelTwoDepartmentTokens tokens = new LevelTwoDepartmentTokens(options);
    return tokens;
  }

  protected LevelTwoDepartmentTokens(Map<String, Object> options) {
    this.options = options;
  }

  public LevelTwoDepartmentTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static LevelTwoDepartmentTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected LevelTwoDepartmentTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static LevelTwoDepartmentTokens start() {
    return new LevelTwoDepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public LevelTwoDepartmentTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static LevelTwoDepartmentTokens loadGroupTokens(String... groupNames) {
    LevelTwoDepartmentTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, BELONGSTO, groupNames, new String[] {"default"});

    addToken(tokens, LEVEL_THREE_DEPARTMENT_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      LevelTwoDepartmentTokens pTokens,
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

  public static LevelTwoDepartmentTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withBelongsTo().withLevelThreeDepartmentListIfViewGroupInclude(viewGroups);
  }

  public static LevelTwoDepartmentTokens allTokens() {

    return start().withBelongsTo().withLevelThreeDepartmentList();
  }

  public static LevelTwoDepartmentTokens withoutListsTokens() {

    return start().withBelongsTo();
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

  public LevelTwoDepartmentTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String BELONGSTO = "belongsTo";

  public String getBelongsTo() {
    return BELONGSTO;
  }
  //
  public LevelTwoDepartmentTokens withBelongsTo() {
    addSimpleOptions(BELONGSTO);
    return this;
  }

  public LevelOneDepartmentTokens withBelongsToTokens() {
    // addSimpleOptions(BELONGSTO);
    return LevelOneDepartmentTokens.start();
  }

  protected static final String LEVEL_THREE_DEPARTMENT_LIST = "levelThreeDepartmentList";

  public String getLevelThreeDepartmentList() {
    return LEVEL_THREE_DEPARTMENT_LIST;
  }

  public LevelTwoDepartmentTokens withLevelThreeDepartmentListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST);
    }
    return this;
  }

  public LevelTwoDepartmentTokens withLevelThreeDepartmentList() {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST);
    return this;
  }

  public LevelThreeDepartmentTokens withLevelThreeDepartmentListTokens() {
    // addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST);
    return LevelThreeDepartmentTokens.start();
  }

  public LevelTwoDepartmentTokens analyzeLevelThreeDepartmentList() {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeLevelThreeDepartmentListEnabled() {

    if (checkOptions(this.options(), LEVEL_THREE_DEPARTMENT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public LevelTwoDepartmentTokens extractMoreFromLevelThreeDepartmentList(
      String idsSeperatedWithComma) {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int levelThreeDepartmentListSortCounter = 0;

  public LevelTwoDepartmentTokens sortLevelThreeDepartmentListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        LEVEL_THREE_DEPARTMENT_LIST, levelThreeDepartmentListSortCounter++, field, descOrAsc);
    return this;
  }

  private int levelThreeDepartmentListSearchCounter = 0;

  public LevelTwoDepartmentTokens searchLevelThreeDepartmentListWith(
      String field, String verb, String value) {

    withLevelThreeDepartmentList();
    addSearchMoreOptions(
        LEVEL_THREE_DEPARTMENT_LIST, levelThreeDepartmentListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelTwoDepartmentTokens searchAllTextOfLevelThreeDepartmentList(
      String verb, String value) {
    String field = "id|name|description";
    addSearchMoreOptions(
        LEVEL_THREE_DEPARTMENT_LIST, levelThreeDepartmentListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelTwoDepartmentTokens rowsPerPageOfLevelThreeDepartmentList(int rowsPerPage) {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public LevelTwoDepartmentTokens currentPageNumberOfLevelThreeDepartmentList(
      int currentPageNumber) {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public LevelTwoDepartmentTokens retainColumnsOfLevelThreeDepartmentList(String[] columns) {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST + "RetainColumns", columns);
    return this;
  }

  public LevelTwoDepartmentTokens excludeColumnsOfLevelThreeDepartmentList(String[] columns) {
    addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST + "ExcludeColumns", columns);
    return this;
  }

  public LevelTwoDepartmentTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfLevelThreeDepartmentList(verb, value);
    return this;
  }
}
