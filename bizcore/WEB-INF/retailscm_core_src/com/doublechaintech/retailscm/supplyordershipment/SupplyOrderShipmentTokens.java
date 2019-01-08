
package com.doublechaintech.retailscm.supplyordershipment;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderShipmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderShipment";
	
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
	protected SupplyOrderShipmentTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderShipmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderShipmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderShipmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderShipmentTokens start(){
		return new SupplyOrderShipmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderShipmentTokens allTokens(){
		
		return start()
			.withConsumerOrderList()
			.withSupplyOrderList();
	
	}
	public static SupplyOrderShipmentTokens withoutListsTokens(){
		
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
	public SupplyOrderShipmentTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}
	public SupplyOrderShipmentTokens analyzeConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeConsumerOrderListEnabled(){		
		
		return checkOptions(this.options(), CONSUMER_ORDER_LIST+".anaylze");
	}
	public SupplyOrderShipmentTokens extractMoreFromConsumerOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(CONSUMER_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int consumerOrderListSortCounter = 0;
	public SupplyOrderShipmentTokens sortConsumerOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int consumerOrderListSearchCounter = 0;
	public SupplyOrderShipmentTokens searchConsumerOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderShipmentTokens searchAllTextOfConsumerOrderList(String verb, String value){	
		String field = "id|title|currentStatus";
		addSearchMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderShipmentTokens rowsPerPageOfConsumerOrderList(int rowsPerPage){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderShipmentTokens currentPageNumberOfConsumerOrderList(int currentPageNumber){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderShipmentTokens retainColumnsOfConsumerOrderList(String[] columns){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderShipmentTokens excludeColumnsOfConsumerOrderList(String[] columns){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public SupplyOrderShipmentTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}
	public SupplyOrderShipmentTokens analyzeSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplyOrderListEnabled(){		
		
		return checkOptions(this.options(), SUPPLY_ORDER_LIST+".anaylze");
	}
	public SupplyOrderShipmentTokens extractMoreFromSupplyOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(SUPPLY_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int supplyOrderListSortCounter = 0;
	public SupplyOrderShipmentTokens sortSupplyOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderListSearchCounter = 0;
	public SupplyOrderShipmentTokens searchSupplyOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderShipmentTokens searchAllTextOfSupplyOrderList(String verb, String value){	
		String field = "id|title|currentStatus";
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderShipmentTokens rowsPerPageOfSupplyOrderList(int rowsPerPage){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderShipmentTokens currentPageNumberOfSupplyOrderList(int currentPageNumber){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderShipmentTokens retainColumnsOfSupplyOrderList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderShipmentTokens excludeColumnsOfSupplyOrderList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  SupplyOrderShipmentTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfConsumerOrderList(verb, value);	
		searchAllTextOfSupplyOrderList(verb, value);	
		return this;
	}
}

