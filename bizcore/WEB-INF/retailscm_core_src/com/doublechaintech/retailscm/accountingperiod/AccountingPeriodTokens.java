
package com.doublechaintech.retailscm.accountingperiod;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.accountset.AccountSetTokens;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentTokens;





public class AccountingPeriodTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingPeriod";

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
	protected AccountingPeriodTokens(){
		//ensure not initialized outside the class
	}
	public  static  AccountingPeriodTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		AccountingPeriodTokens tokens = new AccountingPeriodTokens(options);
		return tokens;

	}
	protected AccountingPeriodTokens(Map<String,Object> options){
		this.options = options;
	}

	public AccountingPeriodTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static AccountingPeriodTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected AccountingPeriodTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static AccountingPeriodTokens start(){
		return new AccountingPeriodTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public AccountingPeriodTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static AccountingPeriodTokens loadGroupTokens(String... groupNames){
    AccountingPeriodTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, ACCOUNTSET, groupNames, new String[]{"default"});

  
     addToken(tokens, ACCOUNTING_DOCUMENT_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(AccountingPeriodTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static AccountingPeriodTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withAccountSet()
			.withAccountingDocumentListIfViewGroupInclude(viewGroups);

	}

	public static AccountingPeriodTokens allTokens(){

		return start()
			.withAccountSet()
			.withAccountingDocumentList();

	}
	public static AccountingPeriodTokens withoutListsTokens(){

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

	public AccountingPeriodTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String ACCOUNTSET = "accountSet";
	public String getAccountSet(){
		return ACCOUNTSET;
	}
	//
	public AccountingPeriodTokens withAccountSet(){
		addSimpleOptions(ACCOUNTSET);
		return this;
	}

	public AccountSetTokens withAccountSetTokens(){
		//addSimpleOptions(ACCOUNTSET);
		return AccountSetTokens.start();
	}

	
	protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	public String getAccountingDocumentList(){
		return ACCOUNTING_DOCUMENT_LIST;
	}



	public AccountingPeriodTokens withAccountingDocumentListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		}
		return this;
	}


	public AccountingPeriodTokens withAccountingDocumentList(){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		return this;
	}

	public AccountingDocumentTokens withAccountingDocumentListTokens(){
		//addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		return AccountingDocumentTokens.start();
	}

	public AccountingPeriodTokens analyzeAccountingDocumentList(){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeAccountingDocumentListEnabled(){

		if(checkOptions(this.options(), ACCOUNTING_DOCUMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public AccountingPeriodTokens extractMoreFromAccountingDocumentList(String idsSeperatedWithComma){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int accountingDocumentListSortCounter = 0;
	public AccountingPeriodTokens sortAccountingDocumentListWith(String field, String descOrAsc){
		addSortMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountingDocumentListSearchCounter = 0;
	public AccountingPeriodTokens searchAccountingDocumentListWith(String field, String verb, String value){

		withAccountingDocumentList();
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSearchCounter++, field, verb, value);
		return this;
	}



	public AccountingPeriodTokens searchAllTextOfAccountingDocumentList(String verb, String value){
		String field = "id|name";
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSearchCounter++, field, verb, value);
		return this;
	}



	public AccountingPeriodTokens rowsPerPageOfAccountingDocumentList(int rowsPerPage){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public AccountingPeriodTokens currentPageNumberOfAccountingDocumentList(int currentPageNumber){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public AccountingPeriodTokens retainColumnsOfAccountingDocumentList(String[] columns){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public AccountingPeriodTokens excludeColumnsOfAccountingDocumentList(String[] columns){
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  AccountingPeriodTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfAccountingDocumentList(verb, value);
		return this;
	}
}

