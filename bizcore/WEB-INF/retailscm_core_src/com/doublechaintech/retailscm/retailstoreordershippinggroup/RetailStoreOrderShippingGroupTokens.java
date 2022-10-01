package com.doublechaintech.retailscm.retailstoreordershippinggroup;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderTokens;

public class RetailStoreOrderShippingGroupTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "retailStoreOrderShippingGroup";

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

  protected RetailStoreOrderShippingGroupTokens() {
    // ensure not initialized outside the class
  }

  public static RetailStoreOrderShippingGroupTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    RetailStoreOrderShippingGroupTokens tokens = new RetailStoreOrderShippingGroupTokens(options);
    return tokens;
  }

  protected RetailStoreOrderShippingGroupTokens(Map<String, Object> options) {
    this.options = options;
  }

  public RetailStoreOrderShippingGroupTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static RetailStoreOrderShippingGroupTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected RetailStoreOrderShippingGroupTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static RetailStoreOrderShippingGroupTokens start() {
    return new RetailStoreOrderShippingGroupTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public RetailStoreOrderShippingGroupTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static RetailStoreOrderShippingGroupTokens loadGroupTokens(String... groupNames) {
    RetailStoreOrderShippingGroupTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, BIZORDER, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      RetailStoreOrderShippingGroupTokens pTokens,
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

  public static RetailStoreOrderShippingGroupTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withBizOrder();
  }

  public static RetailStoreOrderShippingGroupTokens allTokens() {

    return start().withBizOrder();
  }

  public static RetailStoreOrderShippingGroupTokens withoutListsTokens() {

    return start().withBizOrder();
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

  public RetailStoreOrderShippingGroupTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String BIZORDER = "bizOrder";

  public String getBizOrder() {
    return BIZORDER;
  }
  //
  public RetailStoreOrderShippingGroupTokens withBizOrder() {
    addSimpleOptions(BIZORDER);
    return this;
  }

  public RetailStoreOrderTokens withBizOrderTokens() {
    // addSimpleOptions(BIZORDER);
    return RetailStoreOrderTokens.start();
  }

  public RetailStoreOrderShippingGroupTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
