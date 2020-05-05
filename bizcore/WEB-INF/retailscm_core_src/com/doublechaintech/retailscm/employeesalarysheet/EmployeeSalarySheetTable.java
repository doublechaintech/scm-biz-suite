
package com.doublechaintech.retailscm.employeesalarysheet;
import com.doublechaintech.retailscm.AccessKey;


public class EmployeeSalarySheetTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="employee_salary_sheet_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_EMPLOYEE = "employee";
	static final String COLUMN_CURRENT_SALARY_GRADE = "current_salary_grade";
	static final String COLUMN_BASE_SALARY = "base_salary";
	static final String COLUMN_BONUS = "bonus";
	static final String COLUMN_REWARD = "reward";
	static final String COLUMN_PERSONAL_TAX = "personal_tax";
	static final String COLUMN_SOCIAL_SECURITY = "social_security";
	static final String COLUMN_HOUSING_FOUND = "housing_found";
	static final String COLUMN_JOB_INSURANCE = "job_insurance";
	static final String COLUMN_PAYING_OFF = "paying_off";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_EMPLOYEE,COLUMN_CURRENT_SALARY_GRADE,COLUMN_BASE_SALARY,COLUMN_BONUS,COLUMN_REWARD,COLUMN_PERSONAL_TAX,COLUMN_SOCIAL_SECURITY,COLUMN_HOUSING_FOUND,COLUMN_JOB_INSURANCE,COLUMN_PAYING_OFF,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_EMPLOYEE,COLUMN_CURRENT_SALARY_GRADE,COLUMN_BASE_SALARY,COLUMN_BONUS,COLUMN_REWARD,COLUMN_PERSONAL_TAX,COLUMN_SOCIAL_SECURITY,COLUMN_HOUSING_FOUND,COLUMN_JOB_INSURANCE,COLUMN_PAYING_OFF};
	
	
}


