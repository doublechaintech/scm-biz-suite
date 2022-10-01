package com.doublechaintech.retailscm.sku;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.product.ProductTokens;
import com.doublechaintech.retailscm.goods.GoodsTokens;

public class SkuTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "sku";

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

  protected SkuTokens() {
    // ensure not initialized outside the class
  }

  public static SkuTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    SkuTokens tokens = new SkuTokens(options);
    return tokens;
  }

  protected SkuTokens(Map<String, Object> options) {
    this.options = options;
  }

  public SkuTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static SkuTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected SkuTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static SkuTokens start() {
    return new SkuTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public SkuTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static SkuTokens loadGroupTokens(String... groupNames) {
    SkuTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, PRODUCT, groupNames, new String[] {"default"});

    addToken(tokens, GOODS_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      SkuTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static SkuTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withProduct().withGoodsListIfViewGroupInclude(viewGroups);
  }

  public static SkuTokens allTokens() {

    return start().withProduct().withGoodsList();
  }

  public static SkuTokens withoutListsTokens() {

    return start().withProduct();
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

  public SkuTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String PRODUCT = "product";

  public String getProduct() {
    return PRODUCT;
  }
  //
  public SkuTokens withProduct() {
    addSimpleOptions(PRODUCT);
    return this;
  }

  public ProductTokens withProductTokens() {
    // addSimpleOptions(PRODUCT);
    return ProductTokens.start();
  }

  protected static final String GOODS_LIST = "goodsList";

  public String getGoodsList() {
    return GOODS_LIST;
  }

  public SkuTokens withGoodsListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(GOODS_LIST);
    }
    return this;
  }

  public SkuTokens withGoodsList() {
    addSimpleOptions(GOODS_LIST);
    return this;
  }

  public GoodsTokens withGoodsListTokens() {
    // addSimpleOptions(GOODS_LIST);
    return GoodsTokens.start();
  }

  public SkuTokens analyzeGoodsList() {
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

  public SkuTokens extractMoreFromGoodsList(String idsSeperatedWithComma) {
    addSimpleOptions(GOODS_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int goodsListSortCounter = 0;

  public SkuTokens sortGoodsListWith(String field, String descOrAsc) {
    addSortMoreOptions(GOODS_LIST, goodsListSortCounter++, field, descOrAsc);
    return this;
  }

  private int goodsListSearchCounter = 0;

  public SkuTokens searchGoodsListWith(String field, String verb, String value) {

    withGoodsList();
    addSearchMoreOptions(GOODS_LIST, goodsListSearchCounter++, field, verb, value);
    return this;
  }

  public SkuTokens searchAllTextOfGoodsList(String verb, String value) {
    String field = "id|name|rfid|uom";
    addSearchMoreOptions(GOODS_LIST, goodsListSearchCounter++, field, verb, value);
    return this;
  }

  public SkuTokens rowsPerPageOfGoodsList(int rowsPerPage) {
    addSimpleOptions(GOODS_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public SkuTokens currentPageNumberOfGoodsList(int currentPageNumber) {
    addSimpleOptions(GOODS_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public SkuTokens retainColumnsOfGoodsList(String[] columns) {
    addSimpleOptions(GOODS_LIST + "RetainColumns", columns);
    return this;
  }

  public SkuTokens excludeColumnsOfGoodsList(String[] columns) {
    addSimpleOptions(GOODS_LIST + "ExcludeColumns", columns);
    return this;
  }

  public SkuTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfGoodsList(verb, value);
    return this;
  }
}
