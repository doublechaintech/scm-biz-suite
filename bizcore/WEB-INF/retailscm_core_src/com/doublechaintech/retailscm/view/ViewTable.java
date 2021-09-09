
package com.doublechaintech.retailscm.view;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ViewTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="view_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_ASSESSMENT = "assessment";
	static final String COLUMN_INTERVIEW_TIME = "interview_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_WHO,COLUMN_ASSESSMENT,COLUMN_INTERVIEW_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_WHO,COLUMN_ASSESSMENT,COLUMN_INTERVIEW_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "view_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"who","varchar(12)","","谁","",""},
                new String[]{"assessment","varchar(40)","","评估","",""},
                new String[]{"interview_time","date","","面试时间","",""},
                new String[]{"version","int","","版本","",""}
            }, "观", new String[]{
                "create unique index idx4id_ver_of_view on view_data (id, version);",
                "create  index idx4interview_time_of_view on view_data (interview_time);"
         }, new String[]{
                "alter table view_data add constraint pk4id_of_view_data primary key (id);",
                ""
         });
  }


}


