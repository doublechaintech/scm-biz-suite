package com.doublechaintech.retailscm.levelthreecategory;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryTokens;
import com.doublechaintech.retailscm.product.ProductTokens;

public class LevelThreeCategoryTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "levelThreeCategory";

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

  protected LevelThreeCategoryTokens() {
    // ensure not initialized outside the class
  }

  public static LevelThreeCategoryTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    LevelThreeCategoryTokens tokens = new LevelThreeCategoryTokens(options);
    return tokens;
  }

  protected LevelThreeCategoryTokens(Map<String, Object> options) {
    this.options = options;
  }

  public LevelThreeCategoryTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static LevelThreeCategoryTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected LevelThreeCategoryTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static LevelThreeCategoryTokens start() {
    return new LevelThreeCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public LevelThreeCategoryTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static LevelThreeCategoryTokens loadGroupTokens(String... groupNames) {
    LevelThreeCategoryTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, PARENTCATEGORY, groupNames, new String[] {"default"});

    addToken(tokens, PRODUCT_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      LevelThreeCategoryTokens pTokens,
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

  public static LevelThreeCategoryTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withParentCategory().withProductListIfViewGroupInclude(viewGroups);
  }

  public static LevelThreeCategoryTokens allTokens() {

    return start().withParentCategory().withProductList();
  }

  public static LevelThreeCategoryTokens withoutListsTokens() {

    return start().withParentCategory();
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

  public LevelThreeCategoryTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String PARENTCATEGORY = "parentCategory";

  public String getParentCategory() {
    return PARENTCATEGORY;
  }
  //
  public LevelThreeCategoryTokens withParentCategory() {
    addSimpleOptions(PARENTCATEGORY);
    return this;
  }

  public LevelTwoCategoryTokens withParentCategoryTokens() {
    // addSimpleOptions(PARENTCATEGORY);
    return LevelTwoCategoryTokens.start();
  }

  protected static final String PRODUCT_LIST = "productList";

  public String getProductList() {
    return PRODUCT_LIST;
  }

  public LevelThreeCategoryTokens withProductListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(PRODUCT_LIST);
    }
    return this;
  }

  public LevelThreeCategoryTokens withProductList() {
    addSimpleOptions(PRODUCT_LIST);
    return this;
  }

  public ProductTokens withProductListTokens() {
    // addSimpleOptions(PRODUCT_LIST);
    return ProductTokens.start();
  }

  public LevelThreeCategoryTokens analyzeProductList() {
    addSimpleOptions(PRODUCT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeProductListEnabled() {

    if (checkOptions(this.options(), PRODUCT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public LevelThreeCategoryTokens extractMoreFromProductList(String idsSeperatedWithComma) {
    addSimpleOptions(PRODUCT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int productListSortCounter = 0;

  public LevelThreeCategoryTokens sortProductListWith(String field, String descOrAsc) {
    addSortMoreOptions(PRODUCT_LIST, productListSortCounter++, field, descOrAsc);
    return this;
  }

  private int productListSearchCounter = 0;

  public LevelThreeCategoryTokens searchProductListWith(String field, String verb, String value) {

    withProductList();
    addSearchMoreOptions(PRODUCT_LIST, productListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelThreeCategoryTokens searchAllTextOfProductList(String verb, String value) {
    String field = "id|name|origin|remark|brand";
    addSearchMoreOptions(PRODUCT_LIST, productListSearchCounter++, field, verb, value);
    return this;
  }

  public LevelThreeCategoryTokens rowsPerPageOfProductList(int rowsPerPage) {
    addSimpleOptions(PRODUCT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public LevelThreeCategoryTokens currentPageNumberOfProductList(int currentPageNumber) {
    addSimpleOptions(PRODUCT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public LevelThreeCategoryTokens retainColumnsOfProductList(String[] columns) {
    addSimpleOptions(PRODUCT_LIST + "RetainColumns", columns);
    return this;
  }

  public LevelThreeCategoryTokens excludeColumnsOfProductList(String[] columns) {
    addSimpleOptions(PRODUCT_LIST + "ExcludeColumns", columns);
    return this;
  }

  public LevelThreeCategoryTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfProductList(verb, value);
    return this;
  }
}
