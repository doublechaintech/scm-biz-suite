package com.doublechaintech.retailscm.retailstoremember;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderTokens;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponTokens;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistTokens;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointTokens;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionTokens;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressTokens;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTokens;

public class RetailStoreMemberTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "retailStoreMember";

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

  protected RetailStoreMemberTokens() {
    // ensure not initialized outside the class
  }

  public static RetailStoreMemberTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    RetailStoreMemberTokens tokens = new RetailStoreMemberTokens(options);
    return tokens;
  }

  protected RetailStoreMemberTokens(Map<String, Object> options) {
    this.options = options;
  }

  public RetailStoreMemberTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static RetailStoreMemberTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected RetailStoreMemberTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static RetailStoreMemberTokens start() {
    return new RetailStoreMemberTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public RetailStoreMemberTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static RetailStoreMemberTokens loadGroupTokens(String... groupNames) {
    RetailStoreMemberTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, OWNER, groupNames, new String[] {"default"});

    addToken(tokens, CONSUMER_ORDER_LIST, groupNames, new String[] {"default"});

    addToken(tokens, RETAIL_STORE_MEMBER_COUPON_LIST, groupNames, new String[] {"default"});

    addToken(tokens, MEMBER_WISHLIST_LIST, groupNames, new String[] {"default"});

    addToken(tokens, MEMBER_REWARD_POINT_LIST, groupNames, new String[] {"default"});

    addToken(tokens, MEMBER_REWARD_POINT_REDEMPTION_LIST, groupNames, new String[] {"default"});

    addToken(tokens, RETAIL_STORE_MEMBER_ADDRESS_LIST, groupNames, new String[] {"default"});

    addToken(tokens, RETAIL_STORE_MEMBER_GIFT_CARD_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      RetailStoreMemberTokens pTokens,
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

  public static RetailStoreMemberTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withOwner()
        .withConsumerOrderListIfViewGroupInclude(viewGroups)
        .withRetailStoreMemberCouponListIfViewGroupInclude(viewGroups)
        .withMemberWishlistListIfViewGroupInclude(viewGroups)
        .withMemberRewardPointListIfViewGroupInclude(viewGroups)
        .withMemberRewardPointRedemptionListIfViewGroupInclude(viewGroups)
        .withRetailStoreMemberAddressListIfViewGroupInclude(viewGroups)
        .withRetailStoreMemberGiftCardListIfViewGroupInclude(viewGroups);
  }

  public static RetailStoreMemberTokens allTokens() {

    return start()
        .withOwner()
        .withConsumerOrderList()
        .withRetailStoreMemberCouponList()
        .withMemberWishlistList()
        .withMemberRewardPointList()
        .withMemberRewardPointRedemptionList()
        .withRetailStoreMemberAddressList()
        .withRetailStoreMemberGiftCardList();
  }

  public static RetailStoreMemberTokens withoutListsTokens() {

    return start().withOwner();
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

  public RetailStoreMemberTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String OWNER = "owner";

  public String getOwner() {
    return OWNER;
  }
  //
  public RetailStoreMemberTokens withOwner() {
    addSimpleOptions(OWNER);
    return this;
  }

  public RetailStoreCountryCenterTokens withOwnerTokens() {
    // addSimpleOptions(OWNER);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";

  public String getConsumerOrderList() {
    return CONSUMER_ORDER_LIST;
  }

  public RetailStoreMemberTokens withConsumerOrderListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(CONSUMER_ORDER_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withConsumerOrderList() {
    addSimpleOptions(CONSUMER_ORDER_LIST);
    return this;
  }

  public ConsumerOrderTokens withConsumerOrderListTokens() {
    // addSimpleOptions(CONSUMER_ORDER_LIST);
    return ConsumerOrderTokens.start();
  }

  public RetailStoreMemberTokens analyzeConsumerOrderList() {
    addSimpleOptions(CONSUMER_ORDER_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeConsumerOrderListEnabled() {

    if (checkOptions(this.options(), CONSUMER_ORDER_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromConsumerOrderList(String idsSeperatedWithComma) {
    addSimpleOptions(CONSUMER_ORDER_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int consumerOrderListSortCounter = 0;

  public RetailStoreMemberTokens sortConsumerOrderListWith(String field, String descOrAsc) {
    addSortMoreOptions(CONSUMER_ORDER_LIST, consumerOrderListSortCounter++, field, descOrAsc);
    return this;
  }

  private int consumerOrderListSearchCounter = 0;

  public RetailStoreMemberTokens searchConsumerOrderListWith(
      String field, String verb, String value) {

    withConsumerOrderList();
    addSearchMoreOptions(CONSUMER_ORDER_LIST, consumerOrderListSearchCounter++, field, verb, value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfConsumerOrderList(String verb, String value) {
    String field = "id|title";
    addSearchMoreOptions(CONSUMER_ORDER_LIST, consumerOrderListSearchCounter++, field, verb, value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfConsumerOrderList(int rowsPerPage) {
    addSimpleOptions(CONSUMER_ORDER_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfConsumerOrderList(int currentPageNumber) {
    addSimpleOptions(CONSUMER_ORDER_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfConsumerOrderList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfConsumerOrderList(String[] columns) {
    addSimpleOptions(CONSUMER_ORDER_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String RETAIL_STORE_MEMBER_COUPON_LIST = "retailStoreMemberCouponList";

  public String getRetailStoreMemberCouponList() {
    return RETAIL_STORE_MEMBER_COUPON_LIST;
  }

  public RetailStoreMemberTokens withRetailStoreMemberCouponListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withRetailStoreMemberCouponList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST);
    return this;
  }

  public RetailStoreMemberCouponTokens withRetailStoreMemberCouponListTokens() {
    // addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST);
    return RetailStoreMemberCouponTokens.start();
  }

  public RetailStoreMemberTokens analyzeRetailStoreMemberCouponList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeRetailStoreMemberCouponListEnabled() {

    if (checkOptions(this.options(), RETAIL_STORE_MEMBER_COUPON_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromRetailStoreMemberCouponList(
      String idsSeperatedWithComma) {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int retailStoreMemberCouponListSortCounter = 0;

  public RetailStoreMemberTokens sortRetailStoreMemberCouponListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        RETAIL_STORE_MEMBER_COUPON_LIST,
        retailStoreMemberCouponListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int retailStoreMemberCouponListSearchCounter = 0;

  public RetailStoreMemberTokens searchRetailStoreMemberCouponListWith(
      String field, String verb, String value) {

    withRetailStoreMemberCouponList();
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_COUPON_LIST,
        retailStoreMemberCouponListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfRetailStoreMemberCouponList(
      String verb, String value) {
    String field = "id|name|number";
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_COUPON_LIST,
        retailStoreMemberCouponListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfRetailStoreMemberCouponList(int rowsPerPage) {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfRetailStoreMemberCouponList(
      int currentPageNumber) {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfRetailStoreMemberCouponList(String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfRetailStoreMemberCouponList(String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String MEMBER_WISHLIST_LIST = "memberWishlistList";

  public String getMemberWishlistList() {
    return MEMBER_WISHLIST_LIST;
  }

  public RetailStoreMemberTokens withMemberWishlistListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(MEMBER_WISHLIST_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withMemberWishlistList() {
    addSimpleOptions(MEMBER_WISHLIST_LIST);
    return this;
  }

  public MemberWishlistTokens withMemberWishlistListTokens() {
    // addSimpleOptions(MEMBER_WISHLIST_LIST);
    return MemberWishlistTokens.start();
  }

  public RetailStoreMemberTokens analyzeMemberWishlistList() {
    addSimpleOptions(MEMBER_WISHLIST_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeMemberWishlistListEnabled() {

    if (checkOptions(this.options(), MEMBER_WISHLIST_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromMemberWishlistList(String idsSeperatedWithComma) {
    addSimpleOptions(MEMBER_WISHLIST_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int memberWishlistListSortCounter = 0;

  public RetailStoreMemberTokens sortMemberWishlistListWith(String field, String descOrAsc) {
    addSortMoreOptions(MEMBER_WISHLIST_LIST, memberWishlistListSortCounter++, field, descOrAsc);
    return this;
  }

  private int memberWishlistListSearchCounter = 0;

  public RetailStoreMemberTokens searchMemberWishlistListWith(
      String field, String verb, String value) {

    withMemberWishlistList();
    addSearchMoreOptions(
        MEMBER_WISHLIST_LIST, memberWishlistListSearchCounter++, field, verb, value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfMemberWishlistList(String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        MEMBER_WISHLIST_LIST, memberWishlistListSearchCounter++, field, verb, value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfMemberWishlistList(int rowsPerPage) {
    addSimpleOptions(MEMBER_WISHLIST_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfMemberWishlistList(int currentPageNumber) {
    addSimpleOptions(MEMBER_WISHLIST_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfMemberWishlistList(String[] columns) {
    addSimpleOptions(MEMBER_WISHLIST_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfMemberWishlistList(String[] columns) {
    addSimpleOptions(MEMBER_WISHLIST_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String MEMBER_REWARD_POINT_LIST = "memberRewardPointList";

  public String getMemberRewardPointList() {
    return MEMBER_REWARD_POINT_LIST;
  }

  public RetailStoreMemberTokens withMemberRewardPointListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(MEMBER_REWARD_POINT_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withMemberRewardPointList() {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST);
    return this;
  }

  public MemberRewardPointTokens withMemberRewardPointListTokens() {
    // addSimpleOptions(MEMBER_REWARD_POINT_LIST);
    return MemberRewardPointTokens.start();
  }

  public RetailStoreMemberTokens analyzeMemberRewardPointList() {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeMemberRewardPointListEnabled() {

    if (checkOptions(this.options(), MEMBER_REWARD_POINT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromMemberRewardPointList(
      String idsSeperatedWithComma) {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int memberRewardPointListSortCounter = 0;

  public RetailStoreMemberTokens sortMemberRewardPointListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        MEMBER_REWARD_POINT_LIST, memberRewardPointListSortCounter++, field, descOrAsc);
    return this;
  }

  private int memberRewardPointListSearchCounter = 0;

  public RetailStoreMemberTokens searchMemberRewardPointListWith(
      String field, String verb, String value) {

    withMemberRewardPointList();
    addSearchMoreOptions(
        MEMBER_REWARD_POINT_LIST, memberRewardPointListSearchCounter++, field, verb, value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfMemberRewardPointList(String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        MEMBER_REWARD_POINT_LIST, memberRewardPointListSearchCounter++, field, verb, value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfMemberRewardPointList(int rowsPerPage) {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfMemberRewardPointList(int currentPageNumber) {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfMemberRewardPointList(String[] columns) {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfMemberRewardPointList(String[] columns) {
    addSimpleOptions(MEMBER_REWARD_POINT_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String MEMBER_REWARD_POINT_REDEMPTION_LIST =
      "memberRewardPointRedemptionList";

  public String getMemberRewardPointRedemptionList() {
    return MEMBER_REWARD_POINT_REDEMPTION_LIST;
  }

  public RetailStoreMemberTokens withMemberRewardPointRedemptionListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withMemberRewardPointRedemptionList() {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST);
    return this;
  }

  public MemberRewardPointRedemptionTokens withMemberRewardPointRedemptionListTokens() {
    // addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST);
    return MemberRewardPointRedemptionTokens.start();
  }

  public RetailStoreMemberTokens analyzeMemberRewardPointRedemptionList() {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeMemberRewardPointRedemptionListEnabled() {

    if (checkOptions(this.options(), MEMBER_REWARD_POINT_REDEMPTION_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromMemberRewardPointRedemptionList(
      String idsSeperatedWithComma) {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int memberRewardPointRedemptionListSortCounter = 0;

  public RetailStoreMemberTokens sortMemberRewardPointRedemptionListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        MEMBER_REWARD_POINT_REDEMPTION_LIST,
        memberRewardPointRedemptionListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int memberRewardPointRedemptionListSearchCounter = 0;

  public RetailStoreMemberTokens searchMemberRewardPointRedemptionListWith(
      String field, String verb, String value) {

    withMemberRewardPointRedemptionList();
    addSearchMoreOptions(
        MEMBER_REWARD_POINT_REDEMPTION_LIST,
        memberRewardPointRedemptionListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfMemberRewardPointRedemptionList(
      String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(
        MEMBER_REWARD_POINT_REDEMPTION_LIST,
        memberRewardPointRedemptionListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfMemberRewardPointRedemptionList(int rowsPerPage) {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfMemberRewardPointRedemptionList(
      int currentPageNumber) {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfMemberRewardPointRedemptionList(String[] columns) {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfMemberRewardPointRedemptionList(String[] columns) {
    addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String RETAIL_STORE_MEMBER_ADDRESS_LIST = "retailStoreMemberAddressList";

  public String getRetailStoreMemberAddressList() {
    return RETAIL_STORE_MEMBER_ADDRESS_LIST;
  }

  public RetailStoreMemberTokens withRetailStoreMemberAddressListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withRetailStoreMemberAddressList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST);
    return this;
  }

  public RetailStoreMemberAddressTokens withRetailStoreMemberAddressListTokens() {
    // addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST);
    return RetailStoreMemberAddressTokens.start();
  }

  public RetailStoreMemberTokens analyzeRetailStoreMemberAddressList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeRetailStoreMemberAddressListEnabled() {

    if (checkOptions(this.options(), RETAIL_STORE_MEMBER_ADDRESS_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromRetailStoreMemberAddressList(
      String idsSeperatedWithComma) {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int retailStoreMemberAddressListSortCounter = 0;

  public RetailStoreMemberTokens sortRetailStoreMemberAddressListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        RETAIL_STORE_MEMBER_ADDRESS_LIST,
        retailStoreMemberAddressListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int retailStoreMemberAddressListSearchCounter = 0;

  public RetailStoreMemberTokens searchRetailStoreMemberAddressListWith(
      String field, String verb, String value) {

    withRetailStoreMemberAddressList();
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_ADDRESS_LIST,
        retailStoreMemberAddressListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfRetailStoreMemberAddressList(
      String verb, String value) {
    String field = "id|name|mobilePhone|address";
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_ADDRESS_LIST,
        retailStoreMemberAddressListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfRetailStoreMemberAddressList(int rowsPerPage) {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfRetailStoreMemberAddressList(
      int currentPageNumber) {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfRetailStoreMemberAddressList(String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfRetailStoreMemberAddressList(String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_LIST =
      "retailStoreMemberGiftCardList";

  public String getRetailStoreMemberGiftCardList() {
    return RETAIL_STORE_MEMBER_GIFT_CARD_LIST;
  }

  public RetailStoreMemberTokens withRetailStoreMemberGiftCardListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
    }
    return this;
  }

  public RetailStoreMemberTokens withRetailStoreMemberGiftCardList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
    return this;
  }

  public RetailStoreMemberGiftCardTokens withRetailStoreMemberGiftCardListTokens() {
    // addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
    return RetailStoreMemberGiftCardTokens.start();
  }

  public RetailStoreMemberTokens analyzeRetailStoreMemberGiftCardList() {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeRetailStoreMemberGiftCardListEnabled() {

    if (checkOptions(this.options(), RETAIL_STORE_MEMBER_GIFT_CARD_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public RetailStoreMemberTokens extractMoreFromRetailStoreMemberGiftCardList(
      String idsSeperatedWithComma) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int retailStoreMemberGiftCardListSortCounter = 0;

  public RetailStoreMemberTokens sortRetailStoreMemberGiftCardListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_LIST,
        retailStoreMemberGiftCardListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int retailStoreMemberGiftCardListSearchCounter = 0;

  public RetailStoreMemberTokens searchRetailStoreMemberGiftCardListWith(
      String field, String verb, String value) {

    withRetailStoreMemberGiftCardList();
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_LIST,
        retailStoreMemberGiftCardListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens searchAllTextOfRetailStoreMemberGiftCardList(
      String verb, String value) {
    String field = "id|name|number";
    addSearchMoreOptions(
        RETAIL_STORE_MEMBER_GIFT_CARD_LIST,
        retailStoreMemberGiftCardListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public RetailStoreMemberTokens rowsPerPageOfRetailStoreMemberGiftCardList(int rowsPerPage) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public RetailStoreMemberTokens currentPageNumberOfRetailStoreMemberGiftCardList(
      int currentPageNumber) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public RetailStoreMemberTokens retainColumnsOfRetailStoreMemberGiftCardList(String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST + "RetainColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens excludeColumnsOfRetailStoreMemberGiftCardList(String[] columns) {
    addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST + "ExcludeColumns", columns);
    return this;
  }

  public RetailStoreMemberTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfConsumerOrderList(verb, value);
    searchAllTextOfRetailStoreMemberCouponList(verb, value);
    searchAllTextOfMemberWishlistList(verb, value);
    searchAllTextOfMemberRewardPointList(verb, value);
    searchAllTextOfMemberRewardPointRedemptionList(verb, value);
    searchAllTextOfRetailStoreMemberAddressList(verb, value);
    searchAllTextOfRetailStoreMemberGiftCardList(verb, value);
    return this;
  }
}
