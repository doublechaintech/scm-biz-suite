
package com.doublechaintech.retailscm.employee;
import com.doublechaintech.retailscm.AccessKey;


public class EmployeeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="employee_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_COMPANY = "company";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_DEPARTMENT = "department";
	static final String COLUMN_FAMILY_NAME = "family_name";
	static final String COLUMN_GIVEN_NAME = "given_name";
	static final String COLUMN_EMAIL = "email";
	static final String COLUMN_CITY = "city";
	static final String COLUMN_ADDRESS = "address";
	static final String COLUMN_CELL_PHONE = "cell_phone";
	static final String COLUMN_OCCUPATION = "occupation";
	static final String COLUMN_RESPONSIBLE_FOR = "responsible_for";
	static final String COLUMN_CURRENT_SALARY_GRADE = "current_salary_grade";
	static final String COLUMN_SALARY_ACCOUNT = "salary_account";
	static final String COLUMN_JOB_APPLICATION = "job_application";
	static final String COLUMN_PROFESSION_INTERVIEW = "profession_interview";
	static final String COLUMN_HR_INTERVIEW = "hr_interview";
	static final String COLUMN_OFFER_APPROVAL = "offer_approval";
	static final String COLUMN_OFFER_ACCEPTANCE = "offer_acceptance";
	static final String COLUMN_EMPLOYEE_BOARDING = "employee_boarding";
	static final String COLUMN_TERMINATION = "termination";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_CURRENT_STATUS = "current_status";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_COMPANY, COLUMN_TITLE, COLUMN_DEPARTMENT, COLUMN_FAMILY_NAME, COLUMN_GIVEN_NAME, COLUMN_EMAIL, COLUMN_CITY, COLUMN_ADDRESS, COLUMN_CELL_PHONE, COLUMN_OCCUPATION, COLUMN_RESPONSIBLE_FOR, COLUMN_CURRENT_SALARY_GRADE, COLUMN_SALARY_ACCOUNT, COLUMN_JOB_APPLICATION, COLUMN_PROFESSION_INTERVIEW, COLUMN_HR_INTERVIEW, COLUMN_OFFER_APPROVAL, COLUMN_OFFER_ACCEPTANCE, COLUMN_EMPLOYEE_BOARDING, COLUMN_TERMINATION, COLUMN_LAST_UPDATE_TIME, COLUMN_CURRENT_STATUS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_COMPANY, COLUMN_TITLE, COLUMN_DEPARTMENT, COLUMN_FAMILY_NAME, COLUMN_GIVEN_NAME, COLUMN_EMAIL, COLUMN_CITY, COLUMN_ADDRESS, COLUMN_CELL_PHONE, COLUMN_OCCUPATION, COLUMN_RESPONSIBLE_FOR, COLUMN_CURRENT_SALARY_GRADE, COLUMN_SALARY_ACCOUNT, COLUMN_JOB_APPLICATION, COLUMN_PROFESSION_INTERVIEW, COLUMN_HR_INTERVIEW, COLUMN_OFFER_APPROVAL, COLUMN_OFFER_ACCEPTANCE, COLUMN_EMPLOYEE_BOARDING, COLUMN_TERMINATION, COLUMN_LAST_UPDATE_TIME, COLUMN_CURRENT_STATUS
		};
	
	
}


