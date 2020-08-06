
package com.doublechaintech.retailscm.provincecenterdepartment;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ProvinceCenterDepartmentTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="province_center_department_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_PROVINCE_CENTER = "province_center";
	static final String COLUMN_MANAGER = "manager";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_FOUNDED,COLUMN_PROVINCE_CENTER,COLUMN_MANAGER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_FOUNDED,COLUMN_PROVINCE_CENTER,COLUMN_MANAGER};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "province_center_department_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(20)","","名称","",""},
                new String[]{"founded","date","","成立","",""},
                new String[]{"province_center","varchar(48)","","省中心","retail_store_province_center_data","id"},
                new String[]{"manager","varchar(12)","","经理","",""},
                new String[]{"version","int","","版本","",""}
            }, "省中心", new String[]{
                "create unique index idx4id_ver_of_province_center_department on province_center_department_data (id, version);",
                "create  index idx4founded_of_province_center_department on province_center_department_data (founded);"
         }, new String[]{
                "alter table province_center_department_data add constraint pk4id_of_province_center_department_data primary key (id);",
                "alter table province_center_department_data add constraint fk4province_center_of_province_center_department_data foreign key (province_center) references retail_store_province_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


