
package com.doublechaintech.retailscm.payingoff;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class PayingOffGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for PayingOff", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(PayingOff.EMPLOYEE_SALARY_SHEET_LIST.equals(listName)){
			return new String[]{"id","employee","current_salary_grade","base_salary","bonus","reward","personal_tax","social_security","housing_found","job_insurance","paying_off","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(PayingOff.EMPLOYEE_SALARY_SHEET_LIST.equals(listName)){
			return "employee_salary_sheet";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





