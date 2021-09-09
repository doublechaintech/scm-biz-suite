
package com.doublechaintech.retailscm.retailstoremember;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreMemberGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for RetailStoreMember", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(RetailStoreMember.CONSUMER_ORDER_LIST.equals(listName)){
			return new String[]{"id","title","consumer","store","last_update_time","version"};
		}
		if(RetailStoreMember.RETAIL_STORE_MEMBER_COUPON_LIST.equals(listName)){
			return new String[]{"id","name","owner","number","last_update_time","version"};
		}
		if(RetailStoreMember.MEMBER_WISHLIST_LIST.equals(listName)){
			return new String[]{"id","name","owner","version"};
		}
		if(RetailStoreMember.MEMBER_REWARD_POINT_LIST.equals(listName)){
			return new String[]{"id","name","point","owner","version"};
		}
		if(RetailStoreMember.MEMBER_REWARD_POINT_REDEMPTION_LIST.equals(listName)){
			return new String[]{"id","name","point","owner","version"};
		}
		if(RetailStoreMember.RETAIL_STORE_MEMBER_ADDRESS_LIST.equals(listName)){
			return new String[]{"id","name","owner","mobile_phone","address","version"};
		}
		if(RetailStoreMember.RETAIL_STORE_MEMBER_GIFT_CARD_LIST.equals(listName)){
			return new String[]{"id","name","owner","number","remain","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(RetailStoreMember.CONSUMER_ORDER_LIST.equals(listName)){
			return "consumer_order";
		}
		if(RetailStoreMember.RETAIL_STORE_MEMBER_COUPON_LIST.equals(listName)){
			return "retail_store_member_coupon";
		}
		if(RetailStoreMember.MEMBER_WISHLIST_LIST.equals(listName)){
			return "member_wishlist";
		}
		if(RetailStoreMember.MEMBER_REWARD_POINT_LIST.equals(listName)){
			return "member_reward_point";
		}
		if(RetailStoreMember.MEMBER_REWARD_POINT_REDEMPTION_LIST.equals(listName)){
			return "member_reward_point_redemption";
		}
		if(RetailStoreMember.RETAIL_STORE_MEMBER_ADDRESS_LIST.equals(listName)){
			return "retail_store_member_address";
		}
		if(RetailStoreMember.RETAIL_STORE_MEMBER_GIFT_CARD_LIST.equals(listName)){
			return "retail_store_member_gift_card";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





