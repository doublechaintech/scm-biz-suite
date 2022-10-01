package com.doublechaintech.retailscm.levelonecategory;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.catalog.CatalogTokens;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryTokens;

public class LevelOneCategoryTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "levelOneCategory";

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

  protected LevelOneCategoryTokens() {
    // ensure not initialized outside the class
  }

  public static LevelOneCategoryTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    LevelOneCategoryTokens tokens = new LevelOneCategoryTokens(options);
    return tokens;
  }

  protected LevelOneCategoryTokens(Map<String, Object> options) {
    this.options = options;
  }

  public LevelOneCategoryTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static LevelOneCategoryTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected LevelOneCategoryTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static LevelOneCategoryTokens start() {
    return new LevelOneCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public LevelOneCategoryTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static LevelOneCategoryTokens loadGroupTokens(String... groupNames) {
    LevelOneCategoryTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, CATALOG, groupNames, new String[] {"default"});

    addToken(tokens, LEVEL_TWO_CATEGORY_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      LevelOneCategoryTokens pTokens,
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

  public static LevelOneCategoryTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withCatalog().withLevelTwoCategoryListIfViewGroupInclude(viewGroups);
  }

  public static LevelOneCategoryTokens allTokens() {

    return start().withCatalog().withLevelTwoCategoryList();
  }

  public static LevelOneCategoryTokens withoutListsTokens() {

    return start().withCatalog();
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

  public LevelOneCategoryTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String CATALOG = "catalog";

  public String getCatalog() {
    return CATALOG;
  }
  //
  public LevelOneCategoryTokens withCatalog() {
    addSimpleOptions(CATALOG);
    return this;
  }

  public CatalogTokens withCatalogTokens() {
    // addSimpleOptions(CATALOG);
    return CatalogTokens.start();
  }

  protected static final String LEVEL_TWO_CATEGORY_LIST = "levelTwoCategoryList";

  public String getLevelTwoCategoryList() {
    return LEVEL_TWO_CATEGORY_LIST;
  }

  public LevelOneCategoryTokens withLevelTwoCategoryListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(LEVEL_TWO_CATEGORY_LIST);
    }
    return this;
  }

  public LevelOneCategoryTokens withLevelTwoCategoryList() {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST);
    return this;
  }

  public LevelTwoCategoryTokens withLevelTwoCategoryListTokens() {
    // addSimpleOptions(LEVEL_TWO_CATEGORY_LIST);
    return LevelTwoCategoryTokens.start();
  }

  public LevelOneCategoryTokens analyzeLevelTwoCategoryList() {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeLevelTwoCategoryListEnabled() {

    if (checkOptions(this.options(), LEVEL_TWO_CATEGORY_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public LevelOneCategoryTokens extractMoreFromLevelTwoCategoryList(String idsSeperatedWithComma) {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int levelTwoCategoryListSortCounter = 0;

  public LevelOneCategoryTokens sortLevelTwoCategoryListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        LEVEL_TWO_CATEGORY_LIST, levelTwoCategoryListSortCounter++, field, descOrAsc);
    return this;
  }

  private int levelTwoCategoryListSearchCounter = 0;

  public LevelOneCategoryTokens searchLevelTwoCategoryListWith(
      String field, String verb, String value) {

    withLevelTwoCategoryList();
    addSearchMoreOptions(
        LEVEL_TWO_CATEGORY_LIST, levelTwoCategoryListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelOneCategoryTokens searchAllTextOfLevelTwoCategoryList(String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        LEVEL_TWO_CATEGORY_LIST, levelTwoCategoryListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelOneCategoryTokens rowsPerPageOfLevelTwoCategoryList(int rowsPerPage) {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public LevelOneCategoryTokens currentPageNumberOfLevelTwoCategoryList(int currentPageNumber) {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public LevelOneCategoryTokens retainColumnsOfLevelTwoCategoryList(String[] columns) {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST + "RetainColumns", columns);
    return this;
  }

  public LevelOneCategoryTokens excludeColumnsOfLevelTwoCategoryList(String[] columns) {
    addSimpleOptions(LEVEL_TWO_CATEGORY_LIST + "ExcludeColumns", columns);
    return this;
  }

  public LevelOneCategoryTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfLevelTwoCategoryList(verb, value);
    return this;
  }
}
