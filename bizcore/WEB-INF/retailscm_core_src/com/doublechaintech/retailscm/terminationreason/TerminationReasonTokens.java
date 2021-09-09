
package com.doublechaintech.retailscm.terminationreason;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.termination.TerminationTokens;





public class TerminationReasonTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="terminationReason";

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
	protected TerminationReasonTokens(){
		//ensure not initialized outside the class
	}
	public  static  TerminationReasonTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TerminationReasonTokens tokens = new TerminationReasonTokens(options);
		return tokens;

	}
	protected TerminationReasonTokens(Map<String,Object> options){
		this.options = options;
	}

	public TerminationReasonTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static TerminationReasonTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected TerminationReasonTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static TerminationReasonTokens start(){
		return new TerminationReasonTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public TerminationReasonTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static TerminationReasonTokens loadGroupTokens(String... groupNames){
    TerminationReasonTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[]{"default"});

  
     addToken(tokens, TERMINATION_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(TerminationReasonTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static TerminationReasonTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCompany()
			.withTerminationListIfViewGroupInclude(viewGroups);

	}

	public static TerminationReasonTokens allTokens(){

		return start()
			.withCompany()
			.withTerminationList();

	}
	public static TerminationReasonTokens withoutListsTokens(){

		return start()
			.withCompany();

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

	public TerminationReasonTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	//
	public TerminationReasonTokens withCompany(){
		addSimpleOptions(COMPANY);
		return this;
	}

	public RetailStoreCountryCenterTokens withCompanyTokens(){
		//addSimpleOptions(COMPANY);
		return RetailStoreCountryCenterTokens.start();
	}

	
	protected static final String TERMINATION_LIST = "terminationList";
	public String getTerminationList(){
		return TERMINATION_LIST;
	}



	public TerminationReasonTokens withTerminationListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(TERMINATION_LIST);
		}
		return this;
	}


	public TerminationReasonTokens withTerminationList(){
		addSimpleOptions(TERMINATION_LIST);
		return this;
	}

	public TerminationTokens withTerminationListTokens(){
		//addSimpleOptions(TERMINATION_LIST);
		return TerminationTokens.start();
	}

	public TerminationReasonTokens analyzeTerminationList(){
		addSimpleOptions(TERMINATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTerminationListEnabled(){

		if(checkOptions(this.options(), TERMINATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public TerminationReasonTokens extractMoreFromTerminationList(String idsSeperatedWithComma){
		addSimpleOptions(TERMINATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int terminationListSortCounter = 0;
	public TerminationReasonTokens sortTerminationListWith(String field, String descOrAsc){
		addSortMoreOptions(TERMINATION_LIST,terminationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int terminationListSearchCounter = 0;
	public TerminationReasonTokens searchTerminationListWith(String field, String verb, String value){

		withTerminationList();
		addSearchMoreOptions(TERMINATION_LIST,terminationListSearchCounter++, field, verb, value);
		return this;
	}



	public TerminationReasonTokens searchAllTextOfTerminationList(String verb, String value){
		String field = "id|comment";
		addSearchMoreOptions(TERMINATION_LIST,terminationListSearchCounter++, field, verb, value);
		return this;
	}



	public TerminationReasonTokens rowsPerPageOfTerminationList(int rowsPerPage){
		addSimpleOptions(TERMINATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TerminationReasonTokens currentPageNumberOfTerminationList(int currentPageNumber){
		addSimpleOptions(TERMINATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TerminationReasonTokens retainColumnsOfTerminationList(String[] columns){
		addSimpleOptions(TERMINATION_LIST+"RetainColumns",columns);
		return this;
	}
	public TerminationReasonTokens excludeColumnsOfTerminationList(String[] columns){
		addSimpleOptions(TERMINATION_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  TerminationReasonTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfTerminationList(verb, value);
		return this;
	}
}

