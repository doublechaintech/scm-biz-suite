package com.doublechaintech.retailscm.supplierproduct;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierTokens;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationTokens;

public class SupplierProductTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "supplierProduct";

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

  protected SupplierProductTokens() {
    // ensure not initialized outside the class
  }

  public static SupplierProductTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    SupplierProductTokens tokens = new SupplierProductTokens(options);
    return tokens;
  }

  protected SupplierProductTokens(Map<String, Object> options) {
    this.options = options;
  }

  public SupplierProductTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static SupplierProductTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected SupplierProductTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static SupplierProductTokens start() {
    return new SupplierProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public SupplierProductTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static SupplierProductTokens loadGroupTokens(String... groupNames) {
    SupplierProductTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, SUPPLIER, groupNames, new String[] {"default"});

    addToken(tokens, PRODUCT_SUPPLY_DURATION_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      SupplierProductTokens pTokens,
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

  public static SupplierProductTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withSupplier().withProductSupplyDurationListIfViewGroupInclude(viewGroups);
  }

  public static SupplierProductTokens allTokens() {

    return start().withSupplier().withProductSupplyDurationList();
  }

  public static SupplierProductTokens withoutListsTokens() {

    return start().withSupplier();
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

  public SupplierProductTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String SUPPLIER = "supplier";

  public String getSupplier() {
    return SUPPLIER;
  }
  //
  public SupplierProductTokens withSupplier() {
    addSimpleOptions(SUPPLIER);
    return this;
  }

  public GoodsSupplierTokens withSupplierTokens() {
    // addSimpleOptions(SUPPLIER);
    return GoodsSupplierTokens.start();
  }

  protected static final String PRODUCT_SUPPLY_DURATION_LIST = "productSupplyDurationList";

  public String getProductSupplyDurationList() {
    return PRODUCT_SUPPLY_DURATION_LIST;
  }

  public SupplierProductTokens withProductSupplyDurationListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST);
    }
    return this;
  }

  public SupplierProductTokens withProductSupplyDurationList() {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST);
    return this;
  }

  public ProductSupplyDurationTokens withProductSupplyDurationListTokens() {
    // addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST);
    return ProductSupplyDurationTokens.start();
  }

  public SupplierProductTokens analyzeProductSupplyDurationList() {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeProductSupplyDurationListEnabled() {

    if (checkOptions(this.options(), PRODUCT_SUPPLY_DURATION_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public SupplierProductTokens extractMoreFromProductSupplyDurationList(
      String idsSeperatedWithComma) {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int productSupplyDurationListSortCounter = 0;

  public SupplierProductTokens sortProductSupplyDurationListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        PRODUCT_SUPPLY_DURATION_LIST, productSupplyDurationListSortCounter++, field, descOrAsc);
    return this;
  }

  private int productSupplyDurationListSearchCounter = 0;

  public SupplierProductTokens searchProductSupplyDurationListWith(
      String field, String verb, String value) {

    withProductSupplyDurationList();
    addSearchMoreOptions(
        PRODUCT_SUPPLY_DURATION_LIST, productSupplyDurationListSearchCounter++, field, verb, value);
    return this;
  }

  public SupplierProductTokens searchAllTextOfProductSupplyDurationList(String verb, String value) {
    String field = "id|duration";
    addSearchMoreOptions(
        PRODUCT_SUPPLY_DURATION_LIST, productSupplyDurationListSearchCounter++, field, verb, value);
    return this;
  }

  public SupplierProductTokens rowsPerPageOfProductSupplyDurationList(int rowsPerPage) {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public SupplierProductTokens currentPageNumberOfProductSupplyDurationList(int currentPageNumber) {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public SupplierProductTokens retainColumnsOfProductSupplyDurationList(String[] columns) {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST + "RetainColumns", columns);
    return this;
  }

  public SupplierProductTokens excludeColumnsOfProductSupplyDurationList(String[] columns) {
    addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST + "ExcludeColumns", columns);
    return this;
  }

  public SupplierProductTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfProductSupplyDurationList(verb, value);
    return this;
  }
}
