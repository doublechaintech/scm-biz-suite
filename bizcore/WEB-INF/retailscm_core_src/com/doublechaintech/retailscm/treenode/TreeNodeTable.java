
package com.doublechaintech.retailscm.treenode;
import com.doublechaintech.retailscm.AccessKey;


public class TreeNodeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="tree_node_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NODE_ID = "node_id";
	static final String COLUMN_NODE_TYPE = "node_type";
	static final String COLUMN_LEFT_VALUE = "left_value";
	static final String COLUMN_RIGHT_VALUE = "right_value";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NODE_ID,COLUMN_NODE_TYPE,COLUMN_LEFT_VALUE,COLUMN_RIGHT_VALUE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NODE_ID,COLUMN_NODE_TYPE,COLUMN_LEFT_VALUE,COLUMN_RIGHT_VALUE};
	
	
}



















