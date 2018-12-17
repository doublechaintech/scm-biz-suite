
package com.doublechaintech.retailscm.formfieldmessage;
import com.doublechaintech.retailscm.AccessKey;


public class FormFieldMessageTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="form_field_message_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_PARAMETER_NAME = "parameter_name";
	static final String COLUMN_FORM = "form";
	static final String COLUMN_LEVEL = "level";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_PARAMETER_NAME, COLUMN_FORM, COLUMN_LEVEL, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_PARAMETER_NAME, COLUMN_FORM, COLUMN_LEVEL
		};
	
	
}


