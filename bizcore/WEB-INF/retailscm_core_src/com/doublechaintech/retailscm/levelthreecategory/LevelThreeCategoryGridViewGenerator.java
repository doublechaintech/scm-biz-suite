
package com.doublechaintech.retailscm.levelthreecategory;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class LevelThreeCategoryGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for LevelThreeCategory", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(LevelThreeCategory.PRODUCT_LIST.equals(listName)){
			return new String[]{"id","name","parent_category","origin","remark","brand","picture","last_update_time","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(LevelThreeCategory.PRODUCT_LIST.equals(listName)){
			return "product";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





