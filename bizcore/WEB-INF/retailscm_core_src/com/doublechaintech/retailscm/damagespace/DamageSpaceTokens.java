package com.doublechaintech.retailscm.damagespace;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.warehouse.WarehouseTokens;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfTokens;

public class DamageSpaceTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "damageSpace";

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

  protected DamageSpaceTokens() {
    // ensure not initialized outside the class
  }

  public static DamageSpaceTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    DamageSpaceTokens tokens = new DamageSpaceTokens(options);
    return tokens;
  }

  protected DamageSpaceTokens(Map<String, Object> options) {
    this.options = options;
  }

  public DamageSpaceTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static DamageSpaceTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected DamageSpaceTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static DamageSpaceTokens start() {
    return new DamageSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public DamageSpaceTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static DamageSpaceTokens loadGroupTokens(String... groupNames) {
    DamageSpaceTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, WAREHOUSE, groupNames, new String[] {"default"});

    addToken(tokens, GOODS_SHELF_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      DamageSpaceTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static DamageSpaceTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withWarehouse().withGoodsShelfListIfViewGroupInclude(viewGroups);
  }

  public static DamageSpaceTokens allTokens() {

    return start().withWarehouse().withGoodsShelfList();
  }

  public static DamageSpaceTokens withoutListsTokens() {

    return start().withWarehouse();
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

  public DamageSpaceTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String WAREHOUSE = "warehouse";

  public String getWarehouse() {
    return WAREHOUSE;
  }
  //
  public DamageSpaceTokens withWarehouse() {
    addSimpleOptions(WAREHOUSE);
    return this;
  }

  public WarehouseTokens withWarehouseTokens() {
    // addSimpleOptions(WAREHOUSE);
    return WarehouseTokens.start();
  }

  protected static final String GOODS_SHELF_LIST = "goodsShelfList";

  public String getGoodsShelfList() {
    return GOODS_SHELF_LIST;
  }

  public DamageSpaceTokens withGoodsShelfListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(GOODS_SHELF_LIST);
    }
    return this;
  }

  public DamageSpaceTokens withGoodsShelfList() {
    addSimpleOptions(GOODS_SHELF_LIST);
    return this;
  }

  public GoodsShelfTokens withGoodsShelfListTokens() {
    // addSimpleOptions(GOODS_SHELF_LIST);
    return GoodsShelfTokens.start();
  }

  public DamageSpaceTokens analyzeGoodsShelfList() {
    addSimpleOptions(GOODS_SHELF_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeGoodsShelfListEnabled() {

    if (checkOptions(this.options(), GOODS_SHELF_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public DamageSpaceTokens extractMoreFromGoodsShelfList(String idsSeperatedWithComma) {
    addSimpleOptions(GOODS_SHELF_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int goodsShelfListSortCounter = 0;

  public DamageSpaceTokens sortGoodsShelfListWith(String field, String descOrAsc) {
    addSortMoreOptions(GOODS_SHELF_LIST, goodsShelfListSortCounter++, field, descOrAsc);
    return this;
  }

  private int goodsShelfListSearchCounter = 0;

  public DamageSpaceTokens searchGoodsShelfListWith(String field, String verb, String value) {

    withGoodsShelfList();
    addSearchMoreOptions(GOODS_SHELF_LIST, goodsShelfListSearchCounter++, field, verb, value);
    return this;
  }

  public DamageSpaceTokens searchAllTextOfGoodsShelfList(String verb, String value) {
    String field = "id|location";
    addSearchMoreOptions(GOODS_SHELF_LIST, goodsShelfListSearchCounter++, field, verb, value);
    return this;
  }

  public DamageSpaceTokens rowsPerPageOfGoodsShelfList(int rowsPerPage) {
    addSimpleOptions(GOODS_SHELF_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public DamageSpaceTokens currentPageNumberOfGoodsShelfList(int currentPageNumber) {
    addSimpleOptions(GOODS_SHELF_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public DamageSpaceTokens retainColumnsOfGoodsShelfList(String[] columns) {
    addSimpleOptions(GOODS_SHELF_LIST + "RetainColumns", columns);
    return this;
  }

  public DamageSpaceTokens excludeColumnsOfGoodsShelfList(String[] columns) {
    addSimpleOptions(GOODS_SHELF_LIST + "ExcludeColumns", columns);
    return this;
  }

  public DamageSpaceTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfGoodsShelfList(verb, value);
    return this;
  }
}
