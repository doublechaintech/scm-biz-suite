
package com.doublechaintech.retailscm.employeesalarysheet;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

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

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "employee_salary_sheet_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"employee","varchar(48)","","员工","employee_data","id"},
                new String[]{"current_salary_grade","varchar(48)","","目前工资等级","salary_grade_data","id"},
                new String[]{"base_salary","numeric(8,2)","","基本工资","",""},
                new String[]{"bonus","numeric(8,2)","","奖金","",""},
                new String[]{"reward","numeric(8,2)","","奖励","",""},
                new String[]{"personal_tax","numeric(7,2)","","个人所得税","",""},
                new String[]{"social_security","numeric(8,2)","","社会保险","",""},
                new String[]{"housing_found","numeric(8,2)","","住房公积金","",""},
                new String[]{"job_insurance","numeric(5,2)","","失业保险","",""},
                new String[]{"paying_off","varchar(48)","","工资支付","paying_off_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "工资单", new String[]{
                "create unique index idx4id_ver_of_employee_salary_sheet on employee_salary_sheet_data (id, version);",
                "create  index idx4base_salary_of_employee_salary_sheet on employee_salary_sheet_data (base_salary);",
                "create  index idx4bonus_of_employee_salary_sheet on employee_salary_sheet_data (bonus);",
                "create  index idx4reward_of_employee_salary_sheet on employee_salary_sheet_data (reward);",
                "create  index idx4personal_tax_of_employee_salary_sheet on employee_salary_sheet_data (personal_tax);",
                "create  index idx4social_security_of_employee_salary_sheet on employee_salary_sheet_data (social_security);",
                "create  index idx4housing_found_of_employee_salary_sheet on employee_salary_sheet_data (housing_found);",
                "create  index idx4job_insurance_of_employee_salary_sheet on employee_salary_sheet_data (job_insurance);"
         }, new String[]{
                "alter table employee_salary_sheet_data add constraint pk4id_of_employee_salary_sheet_data primary key (id);",
                "alter table employee_salary_sheet_data add constraint fk4employee_of_employee_salary_sheet_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_salary_sheet_data add constraint fk4current_salary_grade_of_employee_salary_sheet_data foreign key (current_salary_grade) references salary_grade_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_salary_sheet_data add constraint fk4paying_off_of_employee_salary_sheet_data foreign key (paying_off) references paying_off_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


