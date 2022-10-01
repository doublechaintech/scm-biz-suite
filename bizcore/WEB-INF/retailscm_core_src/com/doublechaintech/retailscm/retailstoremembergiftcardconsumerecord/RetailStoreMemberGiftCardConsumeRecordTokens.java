package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTokens;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderTokens;

public class RetailStoreMemberGiftCardConsumeRecordTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "retailStoreMemberGiftCardConsumeRecord";

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

  protected RetailStoreMemberGiftCardConsumeRecordTokens() {
    // ensure not initialized outside the class
  }

  public static RetailStoreMemberGiftCardConsumeRecordTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    RetailStoreMemberGiftCardConsumeRecordTokens tokens =
        new RetailStoreMemberGiftCardConsumeRecordTokens(options);
    return tokens;
  }

  protected RetailStoreMemberGiftCardConsumeRecordTokens(Map<String, Object> options) {
    this.options = options;
  }

  public RetailStoreMemberGiftCardConsumeRecordTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static RetailStoreMemberGiftCardConsumeRecordTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected RetailStoreMemberGiftCardConsumeRecordTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static RetailStoreMemberGiftCardConsumeRecordTokens start() {
    return new RetailStoreMemberGiftCardConsumeRecordTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public RetailStoreMemberGiftCardConsumeRecordTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static RetailStoreMemberGiftCardConsumeRecordTokens loadGroupTokens(String... groupNames) {
    RetailStoreMemberGiftCardConsumeRecordTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, OWNER, groupNames, new String[] {"default"});
    addToken(tokens, BIZORDER, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      RetailStoreMemberGiftCardConsumeRecordTokens pTokens,
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

  public static RetailStoreMemberGiftCardConsumeRecordTokens filterWithTokenViewGroups(
      String[] viewGroups) {

    return start().withOwner().withBizOrder();
  }

  public static RetailStoreMemberGiftCardConsumeRecordTokens allTokens() {

    return start().withOwner().withBizOrder();
  }

  public static RetailStoreMemberGiftCardConsumeRecordTokens withoutListsTokens() {

    return start().withOwner().withBizOrder();
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

  public RetailStoreMemberGiftCardConsumeRecordTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String OWNER = "owner";

  public String getOwner() {
    return OWNER;
  }
  //
  public RetailStoreMemberGiftCardConsumeRecordTokens withOwner() {
    addSimpleOptions(OWNER);
    return this;
  }

  public RetailStoreMemberGiftCardTokens withOwnerTokens() {
    // addSimpleOptions(OWNER);
    return RetailStoreMemberGiftCardTokens.start();
  }

  protected static final String BIZORDER = "bizOrder";

  public String getBizOrder() {
    return BIZORDER;
  }
  //
  public RetailStoreMemberGiftCardConsumeRecordTokens withBizOrder() {
    addSimpleOptions(BIZORDER);
    return this;
  }

  public ConsumerOrderTokens withBizOrderTokens() {
    // addSimpleOptions(BIZORDER);
    return ConsumerOrderTokens.start();
  }

  public RetailStoreMemberGiftCardConsumeRecordTokens searchEntireObjectText(
      String verb, String value) {

    return this;
  }
}
