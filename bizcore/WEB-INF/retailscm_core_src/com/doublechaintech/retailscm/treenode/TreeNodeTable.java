
package com.doublechaintech.retailscm.treenode;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

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

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "tree_node_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"node_id","varchar(40)","","节点ID","",""},
                new String[]{"node_type","varchar(32)","","节点类型","",""},
                new String[]{"left_value","int","","左值","",""},
                new String[]{"right_value","int","","右值","",""},
                new String[]{"version","int","","版本","",""}
            }, "节点", new String[]{
                "create unique index idx4id_ver_of_tree_node on tree_node_data (id, version);",
                "create  index idx4node_id_of_tree_node on tree_node_data (node_id);",
                "create  index idx4left_value_of_tree_node on tree_node_data (left_value);",
                "create  index idx4right_value_of_tree_node on tree_node_data (right_value);"
         }, new String[]{
                "alter table tree_node_data add constraint pk4id_of_tree_node_data primary key (id);",
                ""
         });
  }


}



















