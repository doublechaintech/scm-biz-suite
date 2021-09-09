
package com.doublechaintech.retailscm.supplierspace;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class SupplierSpaceGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for SupplierSpace", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(SupplierSpace.GOODS_SHELF_LIST.equals(listName)){
			return new String[]{"id","location","storage_space","supplier_space","damage_space","last_update_time","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(SupplierSpace.GOODS_SHELF_LIST.equals(listName)){
			return "goods_shelf";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





