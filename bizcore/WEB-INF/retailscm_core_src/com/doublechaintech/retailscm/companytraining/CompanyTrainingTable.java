
package com.doublechaintech.retailscm.companytraining;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class CompanyTrainingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="company_training_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_COMPANY = "company";
	static final String COLUMN_INSTRUCTOR = "instructor";
	static final String COLUMN_TRAINING_COURSE_TYPE = "training_course_type";
	static final String COLUMN_TIME_START = "time_start";
	static final String COLUMN_DURATION_HOURS = "duration_hours";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_COMPANY,COLUMN_INSTRUCTOR,COLUMN_TRAINING_COURSE_TYPE,COLUMN_TIME_START,COLUMN_DURATION_HOURS,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_COMPANY,COLUMN_INSTRUCTOR,COLUMN_TRAINING_COURSE_TYPE,COLUMN_TIME_START,COLUMN_DURATION_HOURS,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "company_training_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"title","varchar(16)","","头衔","",""},
                new String[]{"company","varchar(48)","","公司","retail_store_country_center_data","id"},
                new String[]{"instructor","varchar(48)","","讲师","instructor_data","id"},
                new String[]{"training_course_type","varchar(48)","","培训课程类型","training_course_type_data","id"},
                new String[]{"time_start","date","","时间开始","",""},
                new String[]{"duration_hours","int","","持续时间","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "公司培训", new String[]{
                "create unique index idx4id_ver_of_company_training on company_training_data (id, version);",
                "create  index idx4time_start_of_company_training on company_training_data (time_start);",
                "create  index idx4duration_hours_of_company_training on company_training_data (duration_hours);",
                "create  index idx4last_update_time_of_company_training on company_training_data (last_update_time);"
         }, new String[]{
                "alter table company_training_data add constraint pk4id_of_company_training_data primary key (id);",
                "alter table company_training_data add constraint fk4company_of_company_training_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table company_training_data add constraint fk4instructor_of_company_training_data foreign key (instructor) references instructor_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table company_training_data add constraint fk4training_course_type_of_company_training_data foreign key (training_course_type) references training_course_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


