
package com.doublechaintech.retailscm.goods;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class GoodsGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for Goods", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(Goods.GOODS_MOVEMENT_LIST.equals(listName)){
			return new String[]{"id","move_time","facility","facility_id","from_ip","user_agent","session_id","latitude","longitude","goods","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(Goods.GOODS_MOVEMENT_LIST.equals(listName)){
			return "goods_movement";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





