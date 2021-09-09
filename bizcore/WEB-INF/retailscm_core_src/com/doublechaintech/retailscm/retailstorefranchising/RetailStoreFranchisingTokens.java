
package com.doublechaintech.retailscm.retailstorefranchising;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;





public class RetailStoreFranchisingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreFranchising";

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
	protected RetailStoreFranchisingTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreFranchisingTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreFranchisingTokens tokens = new RetailStoreFranchisingTokens(options);
		return tokens;

	}
	protected RetailStoreFranchisingTokens(Map<String,Object> options){
		this.options = options;
	}

	public RetailStoreFranchisingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static RetailStoreFranchisingTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected RetailStoreFranchisingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static RetailStoreFranchisingTokens start(){
		return new RetailStoreFranchisingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public RetailStoreFranchisingTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static RetailStoreFranchisingTokens loadGroupTokens(String... groupNames){
    RetailStoreFranchisingTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    

  
     addToken(tokens, RETAIL_STORE_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(RetailStoreFranchisingTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static RetailStoreFranchisingTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withRetailStoreListIfViewGroupInclude(viewGroups);

	}

	public static RetailStoreFranchisingTokens allTokens(){

		return start()
			.withRetailStoreList();

	}
	public static RetailStoreFranchisingTokens withoutListsTokens(){

		return start();

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

	public RetailStoreFranchisingTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String RETAIL_STORE_LIST = "retailStoreList";
	public String getRetailStoreList(){
		return RETAIL_STORE_LIST;
	}



	public RetailStoreFranchisingTokens withRetailStoreListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(RETAIL_STORE_LIST);
		}
		return this;
	}


	public RetailStoreFranchisingTokens withRetailStoreList(){
		addSimpleOptions(RETAIL_STORE_LIST);
		return this;
	}

	public RetailStoreTokens withRetailStoreListTokens(){
		//addSimpleOptions(RETAIL_STORE_LIST);
		return RetailStoreTokens.start();
	}

	public RetailStoreFranchisingTokens analyzeRetailStoreList(){
		addSimpleOptions(RETAIL_STORE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreFranchisingTokens extractMoreFromRetailStoreList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreListSortCounter = 0;
	public RetailStoreFranchisingTokens sortRetailStoreListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_LIST,retailStoreListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreListSearchCounter = 0;
	public RetailStoreFranchisingTokens searchRetailStoreListWith(String field, String verb, String value){

		withRetailStoreList();
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreFranchisingTokens searchAllTextOfRetailStoreList(String verb, String value){
		String field = "id|name|telephone|owner|description";
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreFranchisingTokens rowsPerPageOfRetailStoreList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreFranchisingTokens currentPageNumberOfRetailStoreList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreFranchisingTokens retainColumnsOfRetailStoreList(String[] columns){
		addSimpleOptions(RETAIL_STORE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreFranchisingTokens excludeColumnsOfRetailStoreList(String[] columns){
		addSimpleOptions(RETAIL_STORE_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  RetailStoreFranchisingTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfRetailStoreList(verb, value);
		return this;
	}
}

