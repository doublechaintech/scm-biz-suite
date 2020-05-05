
package com.doublechaintech.retailscm.accountingdocument;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class AccountingDocumentGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for AccountingDocument", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(AccountingDocument.ORIGINAL_VOUCHER_LIST.equals(listName)){
			return new String[]{"id","title","made_by","received_by","voucher_type","voucher_image","belongs_to","version"};
		}
		if(AccountingDocument.ACCOUNTING_DOCUMENT_LINE_LIST.equals(listName)){
			return new String[]{"id","name","code","direct","amount","belongs_to","accounting_subject","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(AccountingDocument.ORIGINAL_VOUCHER_LIST.equals(listName)){
			return "original_voucher";
		}
		if(AccountingDocument.ACCOUNTING_DOCUMENT_LINE_LIST.equals(listName)){
			return "accounting_document_line";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





