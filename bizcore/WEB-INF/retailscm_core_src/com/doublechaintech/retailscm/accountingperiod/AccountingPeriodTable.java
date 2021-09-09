
package com.doublechaintech.retailscm.accountingperiod;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class AccountingPeriodTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="accounting_period_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_START_DATE = "start_date";
	static final String COLUMN_END_DATE = "end_date";
	static final String COLUMN_ACCOUNT_SET = "account_set";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_START_DATE,COLUMN_END_DATE,COLUMN_ACCOUNT_SET,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_START_DATE,COLUMN_END_DATE,COLUMN_ACCOUNT_SET};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "accounting_period_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(32)","","名称","",""},
                new String[]{"start_date","date","","开始日期","",""},
                new String[]{"end_date","date","","结束日期","",""},
                new String[]{"account_set","varchar(48)","","账套","account_set_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "会计期间", new String[]{
                "create unique index idx4id_ver_of_accounting_period on accounting_period_data (id, version);",
                "create  index idx4start_date_of_accounting_period on accounting_period_data (start_date);",
                "create  index idx4end_date_of_accounting_period on accounting_period_data (end_date);"
         }, new String[]{
                "alter table accounting_period_data add constraint pk4id_of_accounting_period_data primary key (id);",
                "alter table accounting_period_data add constraint fk4account_set_of_accounting_period_data foreign key (account_set) references account_set_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


