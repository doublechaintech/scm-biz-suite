
package com.doublechaintech.retailscm.employeeworkexperience;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeWorkExperienceTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="employee_work_experience_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_EMPLOYEE = "employee";
	static final String COLUMN_START = "start";
	static final String COLUMN_END = "end";
	static final String COLUMN_COMPANY = "company";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_EMPLOYEE,COLUMN_START,COLUMN_END,COLUMN_COMPANY,COLUMN_DESCRIPTION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_EMPLOYEE,COLUMN_START,COLUMN_END,COLUMN_COMPANY,COLUMN_DESCRIPTION};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "employee_work_experience_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"employee","varchar(48)","","员工","employee_data","id"},
                new String[]{"start","date","","开始","",""},
                new String[]{"end","date","","结束","",""},
                new String[]{"company","varchar(32)","","公司","",""},
                new String[]{"description","varchar(84)","","描述","",""},
                new String[]{"version","int","","版本","",""}
            }, "员工工作经验", new String[]{
                "create unique index idx4id_ver_of_employee_work_experience on employee_work_experience_data (id, version);",
                "create  index idx4start_of_employee_work_experience on employee_work_experience_data (start);",
                "create  index idx4end_of_employee_work_experience on employee_work_experience_data (end);"
         }, new String[]{
                "alter table employee_work_experience_data add constraint pk4id_of_employee_work_experience_data primary key (id);",
                "alter table employee_work_experience_data add constraint fk4employee_of_employee_work_experience_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


