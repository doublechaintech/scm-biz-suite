
package com.doublechaintech.retailscm.interviewtype;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class InterviewTypeGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for InterviewType", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(InterviewType.EMPLOYEE_INTERVIEW_LIST.equals(listName)){
			return new String[]{"id","employee","interview_type","remark","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(InterviewType.EMPLOYEE_INTERVIEW_LIST.equals(listName)){
			return "employee_interview";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





