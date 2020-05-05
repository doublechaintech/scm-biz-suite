
package com.doublechaintech.retailscm.goodsshelfstockcount;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class GoodsShelfStockCountGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for GoodsShelfStockCount", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(GoodsShelfStockCount.STOCK_COUNT_ISSUE_TRACK_LIST.equals(listName)){
			return new String[]{"id","title","count_time","summary","stock_count","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(GoodsShelfStockCount.STOCK_COUNT_ISSUE_TRACK_LIST.equals(listName)){
			return "stock_count_issue_track";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





