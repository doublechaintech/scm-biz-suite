
package com.doublechaintech.retailscm.supplyorderdelivery;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderDeliveryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderDelivery";
	
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
	protected SupplyOrderDeliveryTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderDeliveryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderDeliveryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderDeliveryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderDeliveryTokens start(){
		return new SupplyOrderDeliveryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderDeliveryTokens allTokens(){
		
		return start()
			.withConsumerOrderList()
			.withSupplyOrderList();
	
	}
	public static SupplyOrderDeliveryTokens withoutListsTokens(){
		
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

	protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	public String getConsumerOrderList(){
		return CONSUMER_ORDER_LIST;
	}
	public SupplyOrderDeliveryTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}

	public SupplyOrderDeliveryTokens extractMoreFromConsumerOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(CONSUMER_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int consumerOrderListSortCounter = 0;
	public SupplyOrderDeliveryTokens sortConsumerOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int consumerOrderListSearchCounter = 0;
	public SupplyOrderDeliveryTokens searchConsumerOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderDeliveryTokens searchAllTextOfConsumerOrderList(String verb, String value){	
		String field = "id|title|currentStatus";
		addSearchMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderDeliveryTokens rowsPerPageOfConsumerOrderList(int rowsPerPage){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderDeliveryTokens currentPageNumberOfConsumerOrderList(int currentPageNumber){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderDeliveryTokens retainColumnsOfConsumerOrderList(String[] columns){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderDeliveryTokens excludeColumnsOfConsumerOrderList(String[] columns){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public SupplyOrderDeliveryTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}

	public SupplyOrderDeliveryTokens extractMoreFromSupplyOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(SUPPLY_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int supplyOrderListSortCounter = 0;
	public SupplyOrderDeliveryTokens sortSupplyOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderListSearchCounter = 0;
	public SupplyOrderDeliveryTokens searchSupplyOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderDeliveryTokens searchAllTextOfSupplyOrderList(String verb, String value){	
		String field = "id|title|currentStatus";
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderDeliveryTokens rowsPerPageOfSupplyOrderList(int rowsPerPage){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderDeliveryTokens currentPageNumberOfSupplyOrderList(int currentPageNumber){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderDeliveryTokens retainColumnsOfSupplyOrderList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderDeliveryTokens excludeColumnsOfSupplyOrderList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  SupplyOrderDeliveryTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfConsumerOrderList(verb, value);	
		searchAllTextOfSupplyOrderList(verb, value);	
		return this;
	}
}

