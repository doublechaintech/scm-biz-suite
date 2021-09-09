
package com.doublechaintech.retailscm.payingoff;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class PayingOffTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="paying_off_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_PAID_FOR = "paid_for";
	static final String COLUMN_PAID_TIME = "paid_time";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_WHO,COLUMN_PAID_FOR,COLUMN_PAID_TIME,COLUMN_AMOUNT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_WHO,COLUMN_PAID_FOR,COLUMN_PAID_TIME,COLUMN_AMOUNT};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "paying_off_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"who","varchar(8)","","谁","",""},
                new String[]{"paid_for","varchar(48)","","支付","employee_data","id"},
                new String[]{"paid_time","date","","支付时间","",""},
                new String[]{"amount","numeric(8,2)","","金额","",""},
                new String[]{"version","int","","版本","",""}
            }, "工资支付", new String[]{
                "create unique index idx4id_ver_of_paying_off on paying_off_data (id, version);",
                "create  index idx4paid_time_of_paying_off on paying_off_data (paid_time);",
                "create  index idx4amount_of_paying_off on paying_off_data (amount);"
         }, new String[]{
                "alter table paying_off_data add constraint pk4id_of_paying_off_data primary key (id);",
                "alter table paying_off_data add constraint fk4paid_for_of_paying_off_data foreign key (paid_for) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


