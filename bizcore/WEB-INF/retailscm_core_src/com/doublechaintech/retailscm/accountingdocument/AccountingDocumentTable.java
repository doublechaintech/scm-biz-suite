
package com.doublechaintech.retailscm.accountingdocument;
import com.doublechaintech.retailscm.AccessKey;


public class AccountingDocumentTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="accounting_document_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_ACCOUNTING_DOCUMENT_DATE = "accounting_document_date";
	static final String COLUMN_ACCOUNTING_PERIOD = "accounting_period";
	static final String COLUMN_DOCUMENT_TYPE = "document_type";
	static final String COLUMN_CREATION = "creation";
	static final String COLUMN_CONFIRMATION = "confirmation";
	static final String COLUMN_AUDITING = "auditing";
	static final String COLUMN_POSTING = "posting";
	static final String COLUMN_CURRENT_STATUS = "current_status";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_ACCOUNTING_DOCUMENT_DATE, COLUMN_ACCOUNTING_PERIOD, COLUMN_DOCUMENT_TYPE, COLUMN_CREATION, COLUMN_CONFIRMATION, COLUMN_AUDITING, COLUMN_POSTING, COLUMN_CURRENT_STATUS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_ACCOUNTING_DOCUMENT_DATE, COLUMN_ACCOUNTING_PERIOD, COLUMN_DOCUMENT_TYPE, COLUMN_CREATION, COLUMN_CONFIRMATION, COLUMN_AUDITING, COLUMN_POSTING, COLUMN_CURRENT_STATUS
		};
	
	
}


