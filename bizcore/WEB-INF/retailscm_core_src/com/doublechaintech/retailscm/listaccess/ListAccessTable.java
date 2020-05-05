
package com.doublechaintech.retailscm.listaccess;
import com.doublechaintech.retailscm.AccessKey;


public class ListAccessTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="list_access_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_INTERNAL_NAME = "internal_name";
	static final String COLUMN_READ_PERMISSION = "read_permission";
	static final String COLUMN_CREATE_PERMISSION = "create_permission";
	static final String COLUMN_DELETE_PERMISSION = "delete_permission";
	static final String COLUMN_UPDATE_PERMISSION = "update_permission";
	static final String COLUMN_EXECUTION_PERMISSION = "execution_permission";
	static final String COLUMN_APP = "app";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_INTERNAL_NAME,COLUMN_READ_PERMISSION,COLUMN_CREATE_PERMISSION,COLUMN_DELETE_PERMISSION,COLUMN_UPDATE_PERMISSION,COLUMN_EXECUTION_PERMISSION,COLUMN_APP,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_INTERNAL_NAME,COLUMN_READ_PERMISSION,COLUMN_CREATE_PERMISSION,COLUMN_DELETE_PERMISSION,COLUMN_UPDATE_PERMISSION,COLUMN_EXECUTION_PERMISSION,COLUMN_APP};
	
	
}


