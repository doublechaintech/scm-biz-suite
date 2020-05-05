
package com.doublechaintech.retailscm.scoring;
import com.doublechaintech.retailscm.AccessKey;


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
	
	
}


