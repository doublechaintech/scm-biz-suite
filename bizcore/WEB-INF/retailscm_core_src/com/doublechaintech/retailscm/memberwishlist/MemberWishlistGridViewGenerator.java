package com.doublechaintech.retailscm.memberwishlist;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class MemberWishlistGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for MemberWishlist", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (MemberWishlist.MEMBER_WISHLIST_PRODUCT_LIST.equals(listName)) {
      return new String[] {"id", "name", "owner", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (MemberWishlist.MEMBER_WISHLIST_PRODUCT_LIST.equals(listName)) {
      return "member_wishlist_product";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
