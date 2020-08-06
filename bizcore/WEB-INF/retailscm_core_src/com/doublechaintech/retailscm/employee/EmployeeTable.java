
package com.doublechaintech.retailscm.employee;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="employee_data";
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
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_COMPANY,COLUMN_TITLE,COLUMN_DEPARTMENT,COLUMN_FAMILY_NAME,COLUMN_GIVEN_NAME,COLUMN_EMAIL,COLUMN_CITY,COLUMN_ADDRESS,COLUMN_CELL_PHONE,COLUMN_OCCUPATION,COLUMN_RESPONSIBLE_FOR,COLUMN_CURRENT_SALARY_GRADE,COLUMN_SALARY_ACCOUNT,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_COMPANY,COLUMN_TITLE,COLUMN_DEPARTMENT,COLUMN_FAMILY_NAME,COLUMN_GIVEN_NAME,COLUMN_EMAIL,COLUMN_CITY,COLUMN_ADDRESS,COLUMN_CELL_PHONE,COLUMN_OCCUPATION,COLUMN_RESPONSIBLE_FOR,COLUMN_CURRENT_SALARY_GRADE,COLUMN_SALARY_ACCOUNT,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "employee_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"company","varchar(48)","","公司","retail_store_country_center_data","id"},
                new String[]{"title","varchar(12)","","头衔","",""},
                new String[]{"department","varchar(48)","","部门","level_three_department_data","id"},
                new String[]{"family_name","varchar(4)","","姓","",""},
                new String[]{"given_name","varchar(8)","","名","",""},
                new String[]{"email","varchar(256)","","电子邮件","",""},
                new String[]{"city","varchar(8)","","城市","",""},
                new String[]{"address","varchar(28)","","地址","",""},
                new String[]{"cell_phone","varchar(44)","","手机","",""},
                new String[]{"occupation","varchar(48)","","职业","occupation_type_data","id"},
                new String[]{"responsible_for","varchar(48)","","负责","responsibility_type_data","id"},
                new String[]{"current_salary_grade","varchar(48)","","目前工资等级","salary_grade_data","id"},
                new String[]{"salary_account","varchar(60)","","工资账户","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "员工", new String[]{
                "create unique index idx4id_ver_of_employee on employee_data (id, version);",
                "create  index idx4cell_phone_of_employee on employee_data (cell_phone);",
                "create  index idx4last_update_time_of_employee on employee_data (last_update_time);"
         }, new String[]{
                "alter table employee_data add constraint pk4id_of_employee_data primary key (id);",
                "alter table employee_data add constraint fk4company_of_employee_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_data add constraint fk4department_of_employee_data foreign key (department) references level_three_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_data add constraint fk4occupation_of_employee_data foreign key (occupation) references occupation_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_data add constraint fk4responsible_for_of_employee_data foreign key (responsible_for) references responsibility_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_data add constraint fk4current_salary_grade_of_employee_data foreign key (current_salary_grade) references salary_grade_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


