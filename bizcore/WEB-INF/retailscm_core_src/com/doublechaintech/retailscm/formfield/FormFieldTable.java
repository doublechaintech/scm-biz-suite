
package com.doublechaintech.retailscm.formfield;
import com.doublechaintech.retailscm.AccessKey;


public class FormFieldTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="form_field_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LABEL = "label";
	static final String COLUMN_LOCALE_KEY = "locale_key";
	static final String COLUMN_PARAMETER_NAME = "parameter_name";
	static final String COLUMN_TYPE = "type";
	static final String COLUMN_FORM = "form";
	static final String COLUMN_PLACEHOLDER = "placeholder";
	static final String COLUMN_DEFAULT_VALUE = "default_value";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_FIELD_GROUP = "field_group";
	static final String COLUMN_MINIMUM_VALUE = "minimum_value";
	static final String COLUMN_MAXIMUM_VALUE = "maximum_value";
	static final String COLUMN_REQUIRED = "required";
	static final String COLUMN_DISABLED = "disabled";
	static final String COLUMN_CUSTOM_RENDERING = "custom_rendering";
	static final String COLUMN_CANDIDATE_VALUES = "candidate_values";
	static final String COLUMN_SUGGEST_VALUES = "suggest_values";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_LABEL, COLUMN_LOCALE_KEY, COLUMN_PARAMETER_NAME, COLUMN_TYPE, COLUMN_FORM, COLUMN_PLACEHOLDER, COLUMN_DEFAULT_VALUE, COLUMN_DESCRIPTION, COLUMN_FIELD_GROUP, COLUMN_MINIMUM_VALUE, COLUMN_MAXIMUM_VALUE, COLUMN_REQUIRED, COLUMN_DISABLED, COLUMN_CUSTOM_RENDERING, COLUMN_CANDIDATE_VALUES, COLUMN_SUGGEST_VALUES, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_LABEL, COLUMN_LOCALE_KEY, COLUMN_PARAMETER_NAME, COLUMN_TYPE, COLUMN_FORM, COLUMN_PLACEHOLDER, COLUMN_DEFAULT_VALUE, COLUMN_DESCRIPTION, COLUMN_FIELD_GROUP, COLUMN_MINIMUM_VALUE, COLUMN_MAXIMUM_VALUE, COLUMN_REQUIRED, COLUMN_DISABLED, COLUMN_CUSTOM_RENDERING, COLUMN_CANDIDATE_VALUES, COLUMN_SUGGEST_VALUES
		};
	
	
}


