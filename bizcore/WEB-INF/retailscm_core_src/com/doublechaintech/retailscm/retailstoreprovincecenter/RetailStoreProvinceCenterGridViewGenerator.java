
package com.doublechaintech.retailscm.retailstoreprovincecenter;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreProvinceCenterGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for RetailStoreProvinceCenter", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(RetailStoreProvinceCenter.PROVINCE_CENTER_DEPARTMENT_LIST.equals(listName)){
			return new String[]{"id","name","founded","province_center","manager","version"};
		}
		if(RetailStoreProvinceCenter.PROVINCE_CENTER_EMPLOYEE_LIST.equals(listName)){
			return new String[]{"id","name","mobile","email","founded","department","province_center","version"};
		}
		if(RetailStoreProvinceCenter.RETAIL_STORE_CITY_SERVICE_CENTER_LIST.equals(listName)){
			return new String[]{"id","name","founded","belongs_to","last_update_time","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(RetailStoreProvinceCenter.PROVINCE_CENTER_DEPARTMENT_LIST.equals(listName)){
			return "province_center_department";
		}
		if(RetailStoreProvinceCenter.PROVINCE_CENTER_EMPLOYEE_LIST.equals(listName)){
			return "province_center_employee";
		}
		if(RetailStoreProvinceCenter.RETAIL_STORE_CITY_SERVICE_CENTER_LIST.equals(listName)){
			return "retail_store_city_service_center";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





