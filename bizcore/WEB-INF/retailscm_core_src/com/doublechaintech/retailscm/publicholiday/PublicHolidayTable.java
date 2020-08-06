
package com.doublechaintech.retailscm.publicholiday;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class PublicHolidayTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="public_holiday_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_CODE = "code";
	static final String COLUMN_COMPANY = "company";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_CODE,COLUMN_COMPANY,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_CODE,COLUMN_COMPANY,COLUMN_NAME,COLUMN_DESCRIPTION};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "public_holiday_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"code","varchar(16)","","代码","",""},
                new String[]{"company","varchar(48)","","公司","retail_store_country_center_data","id"},
                new String[]{"name","varchar(12)","","名称","",""},
                new String[]{"description","varchar(40)","","描述","",""},
                new String[]{"version","int","","版本","",""}
            }, "公共假日", new String[]{
                "create unique index idx4id_ver_of_public_holiday on public_holiday_data (id, version);"
         }, new String[]{
                "alter table public_holiday_data add constraint pk4id_of_public_holiday_data primary key (id);",
                "alter table public_holiday_data add constraint fk4company_of_public_holiday_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


