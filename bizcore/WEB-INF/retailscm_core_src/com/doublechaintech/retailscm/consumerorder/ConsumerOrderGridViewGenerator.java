
package com.doublechaintech.retailscm.consumerorder;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class ConsumerOrderGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for ConsumerOrder", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(ConsumerOrder.CONSUMER_ORDER_LINE_ITEM_LIST.equals(listName)){
			return new String[]{"id","biz_order","sku_id","sku_name","price","quantity","amount","last_update_time","version"};
		}
		if(ConsumerOrder.CONSUMER_ORDER_SHIPPING_GROUP_LIST.equals(listName)){
			return new String[]{"id","name","biz_order","amount","version"};
		}
		if(ConsumerOrder.CONSUMER_ORDER_PAYMENT_GROUP_LIST.equals(listName)){
			return new String[]{"id","name","biz_order","card_number","version"};
		}
		if(ConsumerOrder.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST.equals(listName)){
			return new String[]{"id","name","biz_order","amount","provider","version"};
		}
		if(ConsumerOrder.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(listName)){
			return new String[]{"id","occure_time","owner","biz_order","number","amount","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(ConsumerOrder.CONSUMER_ORDER_LINE_ITEM_LIST.equals(listName)){
			return "consumer_order_line_item";
		}
		if(ConsumerOrder.CONSUMER_ORDER_SHIPPING_GROUP_LIST.equals(listName)){
			return "consumer_order_shipping_group";
		}
		if(ConsumerOrder.CONSUMER_ORDER_PAYMENT_GROUP_LIST.equals(listName)){
			return "consumer_order_payment_group";
		}
		if(ConsumerOrder.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST.equals(listName)){
			return "consumer_order_price_adjustment";
		}
		if(ConsumerOrder.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(listName)){
			return "retail_store_member_gift_card_consume_record";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





