package com.doublechaintech.retailscm.retailstoremembergiftcard;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreMemberGiftCardGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message =
        String.format("List '%s' is not found for RetailStoreMemberGiftCard", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (RetailStoreMemberGiftCard.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(
        listName)) {
      return new String[] {
        "id", "occure_time", "owner", "biz_order", "number", "amount", "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (RetailStoreMemberGiftCard.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(
        listName)) {
      return "retail_store_member_gift_card_consume_record";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
