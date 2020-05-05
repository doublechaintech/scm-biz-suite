
package com.doublechaintech.retailscm.retailstorecreation;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreCreationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreCreation";
	
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
	protected RetailStoreCreationTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreCreationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreCreationTokens tokens = new RetailStoreCreationTokens(options);
		return tokens;
		
	}
	protected RetailStoreCreationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public RetailStoreCreationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreCreationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreCreationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static RetailStoreCreationTokens start(){
		return new RetailStoreCreationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public RetailStoreCreationTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static RetailStoreCreationTokens allTokens(){
		
		return start()
			.withRetailStoreList();
	
	}
	public static RetailStoreCreationTokens withoutListsTokens(){
		
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
	
	public RetailStoreCreationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String RETAIL_STORE_LIST = "retailStoreList";
	public String getRetailStoreList(){
		return RETAIL_STORE_LIST;
	}
	public RetailStoreCreationTokens withRetailStoreList(){		
		addSimpleOptions(RETAIL_STORE_LIST);
		return this;
	}
	public RetailStoreCreationTokens analyzeRetailStoreList(){		
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
	public RetailStoreCreationTokens extractMoreFromRetailStoreList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreListSortCounter = 0;
	public RetailStoreCreationTokens sortRetailStoreListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_LIST,retailStoreListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreListSearchCounter = 0;
	public RetailStoreCreationTokens searchRetailStoreListWith(String field, String verb, String value){		
		
		withRetailStoreList();
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreCreationTokens searchAllTextOfRetailStoreList(String verb, String value){	
		String field = "id|name|telephone|owner|description";
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreCreationTokens rowsPerPageOfRetailStoreList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCreationTokens currentPageNumberOfRetailStoreList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCreationTokens retainColumnsOfRetailStoreList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCreationTokens excludeColumnsOfRetailStoreList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  RetailStoreCreationTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRetailStoreList(verb, value);	
		return this;
	}
}

