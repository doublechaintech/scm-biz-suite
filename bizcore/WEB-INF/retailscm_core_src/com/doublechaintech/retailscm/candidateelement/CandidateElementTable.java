
package com.doublechaintech.retailscm.candidateelement;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class CandidateElementTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="candidate_element_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_TYPE = "type";
	static final String COLUMN_IMAGE = "image";
	static final String COLUMN_CONTAINER = "container";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_TYPE,COLUMN_IMAGE,COLUMN_CONTAINER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_TYPE,COLUMN_IMAGE,COLUMN_CONTAINER};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "candidate_element_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(200)","","标题","",""},
                new String[]{"type","varchar(200)","","类型","",""},
                new String[]{"image","varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci","","图像","",""},
                new String[]{"container","varchar(48)","","容器","candidate_container_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "候选人元素", new String[]{
                "create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);"
         }, new String[]{
                "alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);",
                "alter table candidate_element_data add constraint fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


