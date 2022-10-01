package com.doublechaintech.retailscm.consumerorder;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberTokens;
import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemTokens;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupTokens;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupTokens;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentTokens;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTokens;

public class ConsumerOrderTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "consumerOrder";

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

  protected ConsumerOrderTokens() {
    // ensure not initialized outside the class
  }

  public static ConsumerOrderTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    ConsumerOrderTokens tokens = new ConsumerOrderTokens(options);
    return tokens;
  }

  protected ConsumerOrderTokens(Map<String, Object> options) {
    this.options = options;
  }

  public ConsumerOrderTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static ConsumerOrderTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected ConsumerOrderTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static ConsumerOrderTokens start() {
    return new ConsumerOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public ConsumerOrderTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static ConsumerOrderTokens loadGroupTokens(String... groupNames) {
    ConsumerOrderTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, CONSUMER, groupNames, new String[] {"default"});
    addToken(tokens, STORE, groupNames, new String[] {"default"});

    addToken(tokens, CONSUMER_ORDER_LINE_ITEM_LIST, groupNames, new String[] {"default"});

    addToken(tokens, CONSUMER_ORDER_SHIPPING_GROUP_LIST, groupNames, new String[] {"default"});

    addToken(tokens, CONSUMER_ORDER_PAYMENT_GROUP_LIST, groupNames, new String[] {"default"});

    addToken(tokens, CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, groupNames, new String[] {"default"});

    addToken(
        tokens,
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,
        groupNames,
        new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      ConsumerOrderTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static ConsumerOrderTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withConsumer()
        .withStore()
        .withConsumerOrderLineItemListIfViewGroupInclude(viewGroups)
        .withConsumerOrderShippingGroupListIfViewGroupInclude(viewGroups)
        .withConsumerOrderPaymentGroupListIfViewGroupInclude(viewGroups)
        .withConsumerOrderPriceAdjustmentListIfViewGroupInclude(viewGroups)
        .withRetailStoreMemberGiftCardConsumeRecordListIfViewGroupInclude(viewGroups);
  }

  public static ConsumerOrderTokens allTokens() {

    return start()
        .withConsumer()
        .withStore()
        .withConsumerOrderLineItemList()
        .withConsumerOrderShippingGroupList()
        .withConsumerOrderPaymentGroupList()
        .withConsumerOrderPriceAdjustmentList()
        .withRetailStoreMemberGiftCardConsumeRecordList();
  }

  public static ConsumerOrderTokens withoutListsTokens() {

    return start().withConsumer().withStore();
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

  public ConsumerOrderTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String CONSUMER = "consumer";

  public String getConsumer() {
    return CONSUMER;
  }
  //
  public ConsumerOrderTokens withConsumer() {
    addSimpleOptions(CONSUMER);
    return this;
  }

  public RetailStoreMemberTokens withConsumerTokens() {
    // addSimpleOptions(CONSUMER);
    return RetailStoreMemberTokens.start();
  }

  protected static final String STORE = "store";

  public String getStore() {
    return STORE;
  }
  //
  public ConsumerOrderTokens withStore() {
    addSimpleOptions(STORE);
    return this;
  }

  public RetailStoreTokens withStoreTokens() {
    // addSimpleOptions(STORE);
    return RetailStoreTokens.start();
  }

  protected static final String CONSUMER_ORDER_LINE_ITEM_LIST = "consumerOrderLineItemList";

  public String getConsumerOrderLineItemList() {
    return CONSUMER_ORDER_LINE_ITEM_LIST;
  }

  public ConsumerOrderTokens withConsumerOrderLineItemListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST);
    }
    return this;
  }

  public ConsumerOrderTokens withConsumerOrderLineItemList() {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST);
    return this;
  }

  public ConsumerOrderLineItemTokens withConsumerOrderLineItemListTokens() {
    // addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST);
    return ConsumerOrderLineItemTokens.start();
  }

  public ConsumerOrderTokens analyzeConsumerOrderLineItemList() {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeConsumerOrderLineItemListEnabled() {

    if (checkOptions(this.options(), CONSUMER_ORDER_LINE_ITEM_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public ConsumerOrderTokens extractMoreFromConsumerOrderLineItemList(
      String idsSeperatedWithComma) {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int consumerOrderLineItemListSortCounter = 0;

  public ConsumerOrderTokens sortConsumerOrderLineItemListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        CONSUMER_ORDER_LINE_ITEM_LIST, consumerOrderLineItemListSortCounter++, field, descOrAsc);
    return this;
  }

  private int consumerOrderLineItemListSearchCounter = 0;

  public ConsumerOrderTokens searchConsumerOrderLineItemListWith(
      String field, String verb, String value) {

    withConsumerOrderLineItemList();
    addSearchMoreOptions(
        CONSUMER_ORDER_LINE_ITEM_LIST,
        consumerOrderLineItemListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens searchAllTextOfConsumerOrderLineItemList(String verb, String value) {
    String field = "id|skuId|skuName";
    addSearchMoreOptions(
        CONSUMER_ORDER_LINE_ITEM_LIST,
        consumerOrderLineItemListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens rowsPerPageOfConsumerOrderLineItemList(int rowsPerPage) {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public ConsumerOrderTokens currentPageNumberOfConsumerOrderLineItemList(int currentPageNumber) {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public ConsumerOrderTokens retainColumnsOfConsumerOrderLineItemList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST + "RetainColumns", columns);
    return this;
  }

  public ConsumerOrderTokens excludeColumnsOfConsumerOrderLineItemList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String CONSUMER_ORDER_SHIPPING_GROUP_LIST =
      "consumerOrderShippingGroupList";

  public String getConsumerOrderShippingGroupList() {
    return CONSUMER_ORDER_SHIPPING_GROUP_LIST;
  }

  public ConsumerOrderTokens withConsumerOrderShippingGroupListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST);
    }
    return this;
  }

  public ConsumerOrderTokens withConsumerOrderShippingGroupList() {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST);
    return this;
  }

  public ConsumerOrderShippingGroupTokens withConsumerOrderShippingGroupListTokens() {
    // addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST);
    return ConsumerOrderShippingGroupTokens.start();
  }

  public ConsumerOrderTokens analyzeConsumerOrderShippingGroupList() {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeConsumerOrderShippingGroupListEnabled() {

    if (checkOptions(this.options(), CONSUMER_ORDER_SHIPPING_GROUP_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public ConsumerOrderTokens extractMoreFromConsumerOrderShippingGroupList(
      String idsSeperatedWithComma) {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int consumerOrderShippingGroupListSortCounter = 0;

  public ConsumerOrderTokens sortConsumerOrderShippingGroupListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        CONSUMER_ORDER_SHIPPING_GROUP_LIST,
        consumerOrderShippingGroupListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int consumerOrderShippingGroupListSearchCounter = 0;

  public ConsumerOrderTokens searchConsumerOrderShippingGroupListWith(
      String field, String verb, String value) {

    withConsumerOrderShippingGroupList();
    addSearchMoreOptions(
        CONSUMER_ORDER_SHIPPING_GROUP_LIST,
        consumerOrderShippingGroupListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens searchAllTextOfConsumerOrderShippingGroupList(
      String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        CONSUMER_ORDER_SHIPPING_GROUP_LIST,
        consumerOrderShippingGroupListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens rowsPerPageOfConsumerOrderShippingGroupList(int rowsPerPage) {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public ConsumerOrderTokens currentPageNumberOfConsumerOrderShippingGroupList(
      int currentPageNumber) {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public ConsumerOrderTokens retainColumnsOfConsumerOrderShippingGroupList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST + "RetainColumns", columns);
    return this;
  }

  public ConsumerOrderTokens excludeColumnsOfConsumerOrderShippingGroupList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String CONSUMER_ORDER_PAYMENT_GROUP_LIST = "consumerOrderPaymentGroupList";

  public String getConsumerOrderPaymentGroupList() {
    return CONSUMER_ORDER_PAYMENT_GROUP_LIST;
  }

  public ConsumerOrderTokens withConsumerOrderPaymentGroupListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST);
    }
    return this;
  }

  public ConsumerOrderTokens withConsumerOrderPaymentGroupList() {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST);
    return this;
  }

  public ConsumerOrderPaymentGroupTokens withConsumerOrderPaymentGroupListTokens() {
    // addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST);
    return ConsumerOrderPaymentGroupTokens.start();
  }

  public ConsumerOrderTokens analyzeConsumerOrderPaymentGroupList() {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeConsumerOrderPaymentGroupListEnabled() {

    if (checkOptions(this.options(), CONSUMER_ORDER_PAYMENT_GROUP_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public ConsumerOrderTokens extractMoreFromConsumerOrderPaymentGroupList(
      String idsSeperatedWithComma) {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int consumerOrderPaymentGroupListSortCounter = 0;

  public ConsumerOrderTokens sortConsumerOrderPaymentGroupListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        CONSUMER_ORDER_PAYMENT_GROUP_LIST,
        consumerOrderPaymentGroupListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int consumerOrderPaymentGroupListSearchCounter = 0;

  public ConsumerOrderTokens searchConsumerOrderPaymentGroupListWith(
      String field, String verb, String value) {

    withConsumerOrderPaymentGroupList();
    addSearchMoreOptions(
        CONSUMER_ORDER_PAYMENT_GROUP_LIST,
        consumerOrderPaymentGroupListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens searchAllTextOfConsumerOrderPaymentGroupList(
      String verb, String value) {
    String field = "id|name|cardNumber";
    addSearchMoreOptions(
        CONSUMER_ORDER_PAYMENT_GROUP_LIST,
        consumerOrderPaymentGroupListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens rowsPerPageOfConsumerOrderPaymentGroupList(int rowsPerPage) {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public ConsumerOrderTokens currentPageNumberOfConsumerOrderPaymentGroupList(
      int currentPageNumber) {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public ConsumerOrderTokens retainColumnsOfConsumerOrderPaymentGroupList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST + "RetainColumns", columns);
    return this;
  }

  public ConsumerOrderTokens excludeColumnsOfConsumerOrderPaymentGroupList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST =
      "consumerOrderPriceAdjustmentList";

  public String getConsumerOrderPriceAdjustmentList() {
    return CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST;
  }

  public ConsumerOrderTokens withConsumerOrderPriceAdjustmentListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
    }
    return this;
  }

  public ConsumerOrderTokens withConsumerOrderPriceAdjustmentList() {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
    return this;
  }

  public ConsumerOrderPriceAdjustmentTokens withConsumerOrderPriceAdjustmentListTokens() {
    // addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
    return ConsumerOrderPriceAdjustmentTokens.start();
  }

  public ConsumerOrderTokens analyzeConsumerOrderPriceAdjustmentList() {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeConsumerOrderPriceAdjustmentListEnabled() {

    if (checkOptions(this.options(), CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public ConsumerOrderTokens extractMoreFromConsumerOrderPriceAdjustmentList(
      String idsSeperatedWithComma) {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int consumerOrderPriceAdjustmentListSortCounter = 0;

  public ConsumerOrderTokens sortConsumerOrderPriceAdjustmentListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST,
        consumerOrderPriceAdjustmentListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int consumerOrderPriceAdjustmentListSearchCounter = 0;

  public ConsumerOrderTokens searchConsumerOrderPriceAdjustmentListWith(
      String field, String verb, String value) {

    withConsumerOrderPriceAdjustmentList();
    addSearchMoreOptions(
        CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST,
        consumerOrderPriceAdjustmentListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens searchAllTextOfConsumerOrderPriceAdjustmentList(
      String verb, String value) {
    String field = "id|name|provider";
    addSearchMoreOptions(
        CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST,
        consumerOrderPriceAdjustmentListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens rowsPerPageOfConsumerOrderPriceAdjustmentList(int rowsPerPage) {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public ConsumerOrderTokens currentPageNumberOfConsumerOrderPriceAdjustmentList(
      int currentPageNumber) {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public ConsumerOrderTokens retainColumnsOfConsumerOrderPriceAdjustmentList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + "RetainColumns", columns);
    return this;
  }

  public ConsumerOrderTokens excludeColumnsOfConsumerOrderPriceAdjustmentList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST =
      "retailStoreMemberGiftCardConsumeRecordList";

  public String getRetailStoreMemberGiftCardConsumeRecordList() {
    return RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST;
  }

  public ConsumerOrderTokens withRetailStoreMemberGiftCardConsumeRecordListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
    }
    return this;
  }

  public ConsumerOrderTokens withRetailStoreMemberGiftCardConsumeRecordList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordTokens
      withRetailStoreMemberGiftCardConsumeRecordListTokens() {
    // addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
    return RetailStoreMemberGiftCardConsumeRecordTokens.start();
  }

  public ConsumerOrderTokens analyzeRetailStoreMemberGiftCardConsumeRecordList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeRetailStoreMemberGiftCardConsumeRecordListEnabled() {

    if (checkOptions(
        this.options(), RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public ConsumerOrderTokens extractMoreFromRetailStoreMemberGiftCardConsumeRecordList(
      String idsSeperatedWithComma) {
    addSimpleOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int retailStoreMemberGiftCardConsumeRecordListSortCounter = 0;

  public ConsumerOrderTokens sortRetailStoreMemberGiftCardConsumeRecordListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,
        retailStoreMemberGiftCardConsumeRecordListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int retailStoreMemberGiftCardConsumeRecordListSearchCounter = 0;

  public ConsumerOrderTokens searchRetailStoreMemberGiftCardConsumeRecordListWith(
      String field, String verb, String value) {

    withRetailStoreMemberGiftCardConsumeRecordList();
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,
        retailStoreMemberGiftCardConsumeRecordListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens searchAllTextOfRetailStoreMemberGiftCardConsumeRecordList(
      String verb, String value) {
    String field = "id|number";
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,
        retailStoreMemberGiftCardConsumeRecordListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public ConsumerOrderTokens rowsPerPageOfRetailStoreMemberGiftCardConsumeRecordList(
      int rowsPerPage) {
    addSimpleOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public ConsumerOrderTokens currentPageNumberOfRetailStoreMemberGiftCardConsumeRecordList(
      int currentPageNumber) {
    addSimpleOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public ConsumerOrderTokens retainColumnsOfRetailStoreMemberGiftCardConsumeRecordList(
      String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + "RetainColumns", columns);
    return this;
  }

  public ConsumerOrderTokens excludeColumnsOfRetailStoreMemberGiftCardConsumeRecordList(
      String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST + "ExcludeColumns", columns);
    return this;
  }

  public ConsumerOrderTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfConsumerOrderLineItemList(verb, value);
    searchAllTextOfConsumerOrderShippingGroupList(verb, value);
    searchAllTextOfConsumerOrderPaymentGroupList(verb, value);
    searchAllTextOfConsumerOrderPriceAdjustmentList(verb, value);
    searchAllTextOfRetailStoreMemberGiftCardConsumeRecordList(verb, value);
    return this;
  }
}
