
package com.doublechaintech.retailscm.accountingsubject;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class AccountingSubjectTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingSubject";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected AccountingSubjectTokens(){
		//ensure not initialized outside the class
	}
	
	public AccountingSubjectTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountingSubjectTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountingSubjectTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AccountingSubjectTokens start(){
		return new AccountingSubjectTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AccountingSubjectTokens allTokens(){
		
		return start()
			.withAccountSet()
			.withAccountingDocumentLineList();
	
	}
	public static AccountingSubjectTokens withoutListsTokens(){
		
		return start()
			.withAccountSet();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String ACCOUNTSET = "accountSet";
	public String getAccountSet(){
		return ACCOUNTSET;
	}
	public AccountingSubjectTokens withAccountSet(){		
		addSimpleOptions(ACCOUNTSET);
		return this;
	}
	
	
	protected static final String ACCOUNTING_DOCUMENT_LINE_LIST = "accountingDocumentLineList";
	public String getAccountingDocumentLineList(){
		return ACCOUNTING_DOCUMENT_LINE_LIST;
	}
	public AccountingSubjectTokens withAccountingDocumentLineList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST);
		return this;
	}

	public AccountingSubjectTokens extractMoreFromAccountingDocumentLineList(String idsSeperatedWithComma){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int accountingDocumentLineListSortCounter = 0;
	public AccountingSubjectTokens sortAccountingDocumentLineListWith(String field, String descOrAsc){		
		addSortMoreOptions(ACCOUNTING_DOCUMENT_LINE_LIST,accountingDocumentLineListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountingDocumentLineListSearchCounter = 0;
	public AccountingSubjectTokens searchAccountingDocumentLineListWith(String field, String verb, String value){		
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LINE_LIST,accountingDocumentLineListSearchCounter++, field, verb, value);
		return this;
	}
	
	public AccountingSubjectTokens searchAllTextOfAccountingDocumentLineList(String verb, String value){	
		String field = "id|name|code|direct";
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LINE_LIST,accountingDocumentLineListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public AccountingSubjectTokens rowsPerPageOfAccountingDocumentLineList(int rowsPerPage){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public AccountingSubjectTokens currentPageNumberOfAccountingDocumentLineList(int currentPageNumber){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public AccountingSubjectTokens retainColumnsOfAccountingDocumentLineList(String[] columns){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST+"RetainColumns",columns);
		return this;
	}
	public AccountingSubjectTokens excludeColumnsOfAccountingDocumentLineList(String[] columns){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  AccountingSubjectTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfAccountingDocumentLineList(verb, value);	
		return this;
	}
}

