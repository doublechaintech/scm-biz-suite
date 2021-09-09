
package com.doublechaintech.retailscm.levelonedepartment;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class LevelOneDepartmentGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for LevelOneDepartment", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(LevelOneDepartment.LEVEL_TWO_DEPARTMENT_LIST.equals(listName)){
			return new String[]{"id","belongs_to","name","description","founded","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(LevelOneDepartment.LEVEL_TWO_DEPARTMENT_LIST.equals(listName)){
			return "level_two_department";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





