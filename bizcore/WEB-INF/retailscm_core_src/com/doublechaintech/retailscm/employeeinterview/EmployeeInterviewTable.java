
package com.doublechaintech.retailscm.employeeinterview;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeInterviewTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="employee_interview_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_EMPLOYEE = "employee";
	static final String COLUMN_INTERVIEW_TYPE = "interview_type";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_EMPLOYEE,COLUMN_INTERVIEW_TYPE,COLUMN_REMARK,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_EMPLOYEE,COLUMN_INTERVIEW_TYPE,COLUMN_REMARK};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "employee_interview_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"employee","varchar(48)","","员工","employee_data","id"},
                new String[]{"interview_type","varchar(48)","","面试类型","interview_type_data","id"},
                new String[]{"remark","varchar(40)","","备注","",""},
                new String[]{"version","int","","版本","",""}
            }, "员工面试", new String[]{
                "create unique index idx4id_ver_of_employee_interview on employee_interview_data (id, version);"
         }, new String[]{
                "alter table employee_interview_data add constraint pk4id_of_employee_interview_data primary key (id);",
                "alter table employee_interview_data add constraint fk4employee_of_employee_interview_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_interview_data add constraint fk4interview_type_of_employee_interview_data foreign key (interview_type) references interview_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


