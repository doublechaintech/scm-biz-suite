
package com.doublechaintech.retailscm.accountingsubject;
import com.doublechaintech.retailscm.AccessKey;


public class AccountingSubjectTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="accounting_subject_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_ACCOUNTING_SUBJECT_CODE = "accounting_subject_code";
	static final String COLUMN_ACCOUNTING_SUBJECT_NAME = "accounting_subject_name";
	static final String COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE = "accounting_subject_class_code";
	static final String COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME = "accounting_subject_class_name";
	static final String COLUMN_ACCOUNT_SET = "account_set";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_ACCOUNTING_SUBJECT_CODE,COLUMN_ACCOUNTING_SUBJECT_NAME,COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE,COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME,COLUMN_ACCOUNT_SET,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_ACCOUNTING_SUBJECT_CODE,COLUMN_ACCOUNTING_SUBJECT_NAME,COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE,COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME,COLUMN_ACCOUNT_SET};
	
	
}


