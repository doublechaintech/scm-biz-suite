
package com.doublechaintech.retailscm.provincecenterdepartment;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class ProvinceCenterDepartmentGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for ProvinceCenterDepartment", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(ProvinceCenterDepartment.PROVINCE_CENTER_EMPLOYEE_LIST.equals(listName)){
			return new String[]{"id","name","mobile","email","founded","department","province_center","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(ProvinceCenterDepartment.PROVINCE_CENTER_EMPLOYEE_LIST.equals(listName)){
			return "province_center_employee";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





