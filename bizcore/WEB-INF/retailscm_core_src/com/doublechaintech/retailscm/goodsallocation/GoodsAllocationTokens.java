package com.doublechaintech.retailscm.goodsallocation;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.goodsshelf.GoodsShelfTokens;
import com.doublechaintech.retailscm.goods.GoodsTokens;

public class GoodsAllocationTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "goodsAllocation";

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

  protected GoodsAllocationTokens() {
    // ensure not initialized outside the class
  }

  public static GoodsAllocationTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    GoodsAllocationTokens tokens = new GoodsAllocationTokens(options);
    return tokens;
  }

  protected GoodsAllocationTokens(Map<String, Object> options) {
    this.options = options;
  }

  public GoodsAllocationTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static GoodsAllocationTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected GoodsAllocationTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static GoodsAllocationTokens start() {
    return new GoodsAllocationTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public GoodsAllocationTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static GoodsAllocationTokens loadGroupTokens(String... groupNames) {
    GoodsAllocationTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, GOODSSHELF, groupNames, new String[] {"default"});

    addToken(tokens, GOODS_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      GoodsAllocationTokens pTokens,
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

  public static GoodsAllocationTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withGoodsShelf().withGoodsListIfViewGroupInclude(viewGroups);
  }

  public static GoodsAllocationTokens allTokens() {

    return start().withGoodsShelf().withGoodsList();
  }

  public static GoodsAllocationTokens withoutListsTokens() {

    return start().withGoodsShelf();
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

  public GoodsAllocationTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String GOODSSHELF = "goodsShelf";

  public String getGoodsShelf() {
    return GOODSSHELF;
  }
  //
  public GoodsAllocationTokens withGoodsShelf() {
    addSimpleOptions(GOODSSHELF);
    return this;
  }

  public GoodsShelfTokens withGoodsShelfTokens() {
    // addSimpleOptions(GOODSSHELF);
    return GoodsShelfTokens.start();
  }

  protected static final String GOODS_LIST = "goodsList";

  public String getGoodsList() {
    return GOODS_LIST;
  }

  public GoodsAllocationTokens withGoodsListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(GOODS_LIST);
    }
    return this;
  }

  public GoodsAllocationTokens withGoodsList() {
    addSimpleOptions(GOODS_LIST);
    return this;
  }

  public GoodsTokens withGoodsListTokens() {
    // addSimpleOptions(GOODS_LIST);
    return GoodsTokens.start();
  }

  public GoodsAllocationTokens analyzeGoodsList() {
    addSimpleOptions(GOODS_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeGoodsListEnabled() {

    if (checkOptions(this.options(), GOODS_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public GoodsAllocationTokens extractMoreFromGoodsList(String idsSeperatedWithComma) {
    addSimpleOptions(GOODS_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int goodsListSortCounter = 0;

  public GoodsAllocationTokens sortGoodsListWith(String field, String descOrAsc) {
    addSortMoreOptions(GOODS_LIST, goodsListSortCounter++, field, descOrAsc);
    return this;
  }

  private int goodsListSearchCounter = 0;

  public GoodsAllocationTokens searchGoodsListWith(String field, String verb, String value) {

    withGoodsList();
    addSearchMoreOptions(GOODS_LIST, goodsListSearchCounter++, field, verb, value);
    return this;
  }

  public GoodsAllocationTokens searchAllTextOfGoodsList(String verb, String value) {
    String field = "id|name|rfid|uom";
    addSearchMoreOptions(GOODS_LIST, goodsListSearchCounter++, field, verb, value);
    return this;
  }

  public GoodsAllocationTokens rowsPerPageOfGoodsList(int rowsPerPage) {
    addSimpleOptions(GOODS_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public GoodsAllocationTokens currentPageNumberOfGoodsList(int currentPageNumber) {
    addSimpleOptions(GOODS_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public GoodsAllocationTokens retainColumnsOfGoodsList(String[] columns) {
    addSimpleOptions(GOODS_LIST + "RetainColumns", columns);
    return this;
  }

  public GoodsAllocationTokens excludeColumnsOfGoodsList(String[] columns) {
    addSimpleOptions(GOODS_LIST + "ExcludeColumns", columns);
    return this;
  }

  public GoodsAllocationTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfGoodsList(verb, value);
    return this;
  }
}
