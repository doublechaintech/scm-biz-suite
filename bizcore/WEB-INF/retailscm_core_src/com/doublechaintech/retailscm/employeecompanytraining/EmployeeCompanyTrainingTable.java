
package com.doublechaintech.retailscm.employeecompanytraining;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class EmployeeCompanyTrainingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="employee_company_training_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_EMPLOYEE = "employee";
	static final String COLUMN_TRAINING = "training";
	static final String COLUMN_SCORING = "scoring";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_EMPLOYEE,COLUMN_TRAINING,COLUMN_SCORING,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_EMPLOYEE,COLUMN_TRAINING,COLUMN_SCORING};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "employee_company_training_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"employee","varchar(48)","","员工","employee_data","id"},
                new String[]{"training","varchar(48)","","训练","company_training_data","id"},
                new String[]{"scoring","varchar(48)","","评分","scoring_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "员工参与的公司培训", new String[]{
                "create unique index idx4id_ver_of_employee_company_training on employee_company_training_data (id, version);"
         }, new String[]{
                "alter table employee_company_training_data add constraint pk4id_of_employee_company_training_data primary key (id);",
                "alter table employee_company_training_data add constraint fk4employee_of_employee_company_training_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_company_training_data add constraint fk4training_of_employee_company_training_data foreign key (training) references company_training_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table employee_company_training_data add constraint fk4scoring_of_employee_company_training_data foreign key (scoring) references scoring_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


