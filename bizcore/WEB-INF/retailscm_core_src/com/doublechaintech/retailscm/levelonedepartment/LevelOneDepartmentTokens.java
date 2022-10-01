package com.doublechaintech.retailscm.levelonedepartment;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentTokens;

public class LevelOneDepartmentTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "levelOneDepartment";

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

  protected LevelOneDepartmentTokens() {
    // ensure not initialized outside the class
  }

  public static LevelOneDepartmentTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    LevelOneDepartmentTokens tokens = new LevelOneDepartmentTokens(options);
    return tokens;
  }

  protected LevelOneDepartmentTokens(Map<String, Object> options) {
    this.options = options;
  }

  public LevelOneDepartmentTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static LevelOneDepartmentTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected LevelOneDepartmentTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static LevelOneDepartmentTokens start() {
    return new LevelOneDepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public LevelOneDepartmentTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static LevelOneDepartmentTokens loadGroupTokens(String... groupNames) {
    LevelOneDepartmentTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, BELONGSTO, groupNames, new String[] {"default"});

    addToken(tokens, LEVEL_TWO_DEPARTMENT_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      LevelOneDepartmentTokens pTokens,
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

  public static LevelOneDepartmentTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withBelongsTo().withLevelTwoDepartmentListIfViewGroupInclude(viewGroups);
  }

  public static LevelOneDepartmentTokens allTokens() {

    return start().withBelongsTo().withLevelTwoDepartmentList();
  }

  public static LevelOneDepartmentTokens withoutListsTokens() {

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

  public LevelOneDepartmentTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String BELONGSTO = "belongsTo";

  public String getBelongsTo() {
    return BELONGSTO;
  }
  //
  public LevelOneDepartmentTokens withBelongsTo() {
    addSimpleOptions(BELONGSTO);
    return this;
  }

  public RetailStoreCountryCenterTokens withBelongsToTokens() {
    // addSimpleOptions(BELONGSTO);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String LEVEL_TWO_DEPARTMENT_LIST = "levelTwoDepartmentList";

  public String getLevelTwoDepartmentList() {
    return LEVEL_TWO_DEPARTMENT_LIST;
  }

  public LevelOneDepartmentTokens withLevelTwoDepartmentListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST);
    }
    return this;
  }

  public LevelOneDepartmentTokens withLevelTwoDepartmentList() {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST);
    return this;
  }

  public LevelTwoDepartmentTokens withLevelTwoDepartmentListTokens() {
    // addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST);
    return LevelTwoDepartmentTokens.start();
  }

  public LevelOneDepartmentTokens analyzeLevelTwoDepartmentList() {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeLevelTwoDepartmentListEnabled() {

    if (checkOptions(this.options(), LEVEL_TWO_DEPARTMENT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public LevelOneDepartmentTokens extractMoreFromLevelTwoDepartmentList(
      String idsSeperatedWithComma) {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int levelTwoDepartmentListSortCounter = 0;

  public LevelOneDepartmentTokens sortLevelTwoDepartmentListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        LEVEL_TWO_DEPARTMENT_LIST, levelTwoDepartmentListSortCounter++, field, descOrAsc);
    return this;
  }

  private int levelTwoDepartmentListSearchCounter = 0;

  public LevelOneDepartmentTokens searchLevelTwoDepartmentListWith(
      String field, String verb, String value) {

    withLevelTwoDepartmentList();
    addSearchMoreOptions(
        LEVEL_TWO_DEPARTMENT_LIST, levelTwoDepartmentListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelOneDepartmentTokens searchAllTextOfLevelTwoDepartmentList(String verb, String value) {
    String field = "id|name|description";
    addSearchMoreOptions(
        LEVEL_TWO_DEPARTMENT_LIST, levelTwoDepartmentListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelOneDepartmentTokens rowsPerPageOfLevelTwoDepartmentList(int rowsPerPage) {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public LevelOneDepartmentTokens currentPageNumberOfLevelTwoDepartmentList(int currentPageNumber) {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public LevelOneDepartmentTokens retainColumnsOfLevelTwoDepartmentList(String[] columns) {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST + "RetainColumns", columns);
    return this;
  }

  public LevelOneDepartmentTokens excludeColumnsOfLevelTwoDepartmentList(String[] columns) {
    addSimpleOptions(LEVEL_TWO_DEPARTMENT_LIST + "ExcludeColumns", columns);
    return this;
  }

  public LevelOneDepartmentTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfLevelTwoDepartmentList(verb, value);
    return this;
  }
}
