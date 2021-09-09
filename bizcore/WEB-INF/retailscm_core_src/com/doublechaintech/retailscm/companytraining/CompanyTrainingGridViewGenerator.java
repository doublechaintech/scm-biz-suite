
package com.doublechaintech.retailscm.companytraining;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class CompanyTrainingGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for CompanyTraining", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(CompanyTraining.EMPLOYEE_COMPANY_TRAINING_LIST.equals(listName)){
			return new String[]{"id","employee","training","scoring","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(CompanyTraining.EMPLOYEE_COMPANY_TRAINING_LIST.equals(listName)){
			return "employee_company_training";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





