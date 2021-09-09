
package com.doublechaintech.retailscm.retailstore;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for RetailStore", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(RetailStore.CONSUMER_ORDER_LIST.equals(listName)){
			return new String[]{"id","title","consumer","store","last_update_time","version"};
		}
		if(RetailStore.RETAIL_STORE_ORDER_LIST.equals(listName)){
			return new String[]{"id","buyer","seller","title","total_amount","last_update_time","version"};
		}
		if(RetailStore.GOODS_LIST.equals(listName)){
			return new String[]{"id","name","rfid","uom","max_package","expire_time","sku","receiving_space","goods_allocation","smart_pallet","shipping_space","transport_task","retail_store","biz_order","retail_store_order","version"};
		}
		if(RetailStore.TRANSPORT_TASK_LIST.equals(listName)){
			return new String[]{"id","name","start","begin_time","end","driver","truck","belongs_to","latitude","longitude","version"};
		}
		if(RetailStore.ACCOUNT_SET_LIST.equals(listName)){
			return new String[]{"id","name","year_set","effective_date","accounting_system","domestic_currency_code","domestic_currency_name","opening_bank","account_number","country_center","retail_store","goods_supplier","last_update_time","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(RetailStore.CONSUMER_ORDER_LIST.equals(listName)){
			return "consumer_order";
		}
		if(RetailStore.RETAIL_STORE_ORDER_LIST.equals(listName)){
			return "retail_store_order";
		}
		if(RetailStore.GOODS_LIST.equals(listName)){
			return "goods";
		}
		if(RetailStore.TRANSPORT_TASK_LIST.equals(listName)){
			return "transport_task";
		}
		if(RetailStore.ACCOUNT_SET_LIST.equals(listName)){
			return "account_set";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





