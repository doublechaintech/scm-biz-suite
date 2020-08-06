
package com.doublechaintech.retailscm.candidatecontainer;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class CandidateContainerTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="candidate_container_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "candidate_container_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(28)","","名称","",""},
                new String[]{"version","int","","版本","",""}
            }, "候选人容器", new String[]{
                "create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);"
         }, new String[]{
                "alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);",
                ""
         });
  }


}


