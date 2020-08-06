
package com.doublechaintech.retailscm.provincecenteremployee;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ProvinceCenterEmployeeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="province_center_employee_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_MOBILE = "mobile";
	static final String COLUMN_EMAIL = "email";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_DEPARTMENT = "department";
	static final String COLUMN_PROVINCE_CENTER = "province_center";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_MOBILE,COLUMN_EMAIL,COLUMN_FOUNDED,COLUMN_DEPARTMENT,COLUMN_PROVINCE_CENTER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_MOBILE,COLUMN_EMAIL,COLUMN_FOUNDED,COLUMN_DEPARTMENT,COLUMN_PROVINCE_CENTER};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "province_center_employee_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(12)","","名称","",""},
                new String[]{"mobile","varchar(44)","","手机","",""},
                new String[]{"email","varchar(256)","","电子邮件","",""},
                new String[]{"founded","date","","成立","",""},
                new String[]{"department","varchar(48)","","部门","province_center_department_data","id"},
                new String[]{"province_center","varchar(48)","","省中心","retail_store_province_center_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "省中心员工", new String[]{
                "create unique index idx4id_ver_of_province_center_employee on province_center_employee_data (id, version);",
                "create  index idx4mobile_of_province_center_employee on province_center_employee_data (mobile);",
                "create  index idx4founded_of_province_center_employee on province_center_employee_data (founded);"
         }, new String[]{
                "alter table province_center_employee_data add constraint pk4id_of_province_center_employee_data primary key (id);",
                "alter table province_center_employee_data add constraint fk4department_of_province_center_employee_data foreign key (department) references province_center_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table province_center_employee_data add constraint fk4province_center_of_province_center_employee_data foreign key (province_center) references retail_store_province_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


