
package com.doublechaintech.retailscm.scoring;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ScoringTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="scoring_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_SCORED_BY = "scored_by";
	static final String COLUMN_SCORE = "score";
	static final String COLUMN_COMMENT = "comment";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_SCORED_BY,COLUMN_SCORE,COLUMN_COMMENT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_SCORED_BY,COLUMN_SCORE,COLUMN_COMMENT};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "scoring_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"scored_by","varchar(12)","","由谁打分","",""},
                new String[]{"score","int","","分数","",""},
                new String[]{"comment","varchar(36)","","评论","",""},
                new String[]{"version","int","","版本","",""}
            }, "评分", new String[]{
                "create unique index idx4id_ver_of_scoring on scoring_data (id, version);",
                "create  index idx4score_of_scoring on scoring_data (score);"
         }, new String[]{
                "alter table scoring_data add constraint pk4id_of_scoring_data primary key (id);",
                ""
         });
  }


}


