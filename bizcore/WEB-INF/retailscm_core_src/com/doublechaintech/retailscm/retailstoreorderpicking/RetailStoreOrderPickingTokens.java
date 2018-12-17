
package com.doublechaintech.retailscm.retailstoreorderpicking;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreOrderPickingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreOrderPicking";
	
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
	protected RetailStoreOrderPickingTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreOrderPickingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreOrderPickingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreOrderPickingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreOrderPickingTokens start(){
		return new RetailStoreOrderPickingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreOrderPickingTokens allTokens(){
		
		return start()
			.withRetailStoreOrderList();
	
	}
	public static RetailStoreOrderPickingTokens withoutListsTokens(){
		
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

	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}
	public RetailStoreOrderPickingTokens withRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}

	public RetailStoreOrderPickingTokens extractMoreFromRetailStoreOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreOrderListSortCounter = 0;
	public RetailStoreOrderPickingTokens sortRetailStoreOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderListSearchCounter = 0;
	public RetailStoreOrderPickingTokens searchRetailStoreOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public RetailStoreOrderPickingTokens searchAllTextOfRetailStoreOrderList(String verb, String value){	
		String field = "id|title|currentStatus";
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderPickingTokens rowsPerPageOfRetailStoreOrderList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreOrderPickingTokens currentPageNumberOfRetailStoreOrderList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreOrderPickingTokens retainColumnsOfRetailStoreOrderList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreOrderPickingTokens excludeColumnsOfRetailStoreOrderList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  RetailStoreOrderPickingTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRetailStoreOrderList(verb, value);	
		return this;
	}
}

