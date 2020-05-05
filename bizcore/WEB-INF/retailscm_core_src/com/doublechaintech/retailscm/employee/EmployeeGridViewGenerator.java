
package com.doublechaintech.retailscm.employee;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class EmployeeGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for Employee", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(Employee.EMPLOYEE_COMPANY_TRAINING_LIST.equals(listName)){
			return new String[]{"id","employee","training","scoring","version"};
		}
		if(Employee.EMPLOYEE_SKILL_LIST.equals(listName)){
			return new String[]{"id","employee","skill_type","description","version"};
		}
		if(Employee.EMPLOYEE_PERFORMANCE_LIST.equals(listName)){
			return new String[]{"id","employee","performance_comment","version"};
		}
		if(Employee.EMPLOYEE_WORK_EXPERIENCE_LIST.equals(listName)){
			return new String[]{"id","employee","start","end","company","description","version"};
		}
		if(Employee.EMPLOYEE_LEAVE_LIST.equals(listName)){
			return new String[]{"id","who","type","leave_duration_hour","remark","version"};
		}
		if(Employee.EMPLOYEE_INTERVIEW_LIST.equals(listName)){
			return new String[]{"id","employee","interview_type","remark","version"};
		}
		if(Employee.EMPLOYEE_ATTENDANCE_LIST.equals(listName)){
			return new String[]{"id","employee","enter_time","leave_time","duration_hours","remark","version"};
		}
		if(Employee.EMPLOYEE_QUALIFIER_LIST.equals(listName)){
			return new String[]{"id","employee","qualified_time","type","level","remark","version"};
		}
		if(Employee.EMPLOYEE_EDUCATION_LIST.equals(listName)){
			return new String[]{"id","employee","complete_time","type","remark","version"};
		}
		if(Employee.EMPLOYEE_AWARD_LIST.equals(listName)){
			return new String[]{"id","employee","complete_time","type","remark","version"};
		}
		if(Employee.EMPLOYEE_SALARY_SHEET_LIST.equals(listName)){
			return new String[]{"id","employee","current_salary_grade","base_salary","bonus","reward","personal_tax","social_security","housing_found","job_insurance","paying_off","version"};
		}
		if(Employee.PAYING_OFF_LIST.equals(listName)){
			return new String[]{"id","who","paid_for","paid_time","amount","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(Employee.EMPLOYEE_COMPANY_TRAINING_LIST.equals(listName)){
			return "employee_company_training";
		}
		if(Employee.EMPLOYEE_SKILL_LIST.equals(listName)){
			return "employee_skill";
		}
		if(Employee.EMPLOYEE_PERFORMANCE_LIST.equals(listName)){
			return "employee_performance";
		}
		if(Employee.EMPLOYEE_WORK_EXPERIENCE_LIST.equals(listName)){
			return "employee_work_experience";
		}
		if(Employee.EMPLOYEE_LEAVE_LIST.equals(listName)){
			return "employee_leave";
		}
		if(Employee.EMPLOYEE_INTERVIEW_LIST.equals(listName)){
			return "employee_interview";
		}
		if(Employee.EMPLOYEE_ATTENDANCE_LIST.equals(listName)){
			return "employee_attendance";
		}
		if(Employee.EMPLOYEE_QUALIFIER_LIST.equals(listName)){
			return "employee_qualifier";
		}
		if(Employee.EMPLOYEE_EDUCATION_LIST.equals(listName)){
			return "employee_education";
		}
		if(Employee.EMPLOYEE_AWARD_LIST.equals(listName)){
			return "employee_award";
		}
		if(Employee.EMPLOYEE_SALARY_SHEET_LIST.equals(listName)){
			return "employee_salary_sheet";
		}
		if(Employee.PAYING_OFF_LIST.equals(listName)){
			return "paying_off";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





