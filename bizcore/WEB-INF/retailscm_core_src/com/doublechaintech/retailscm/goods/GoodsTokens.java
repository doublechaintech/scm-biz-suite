
package com.doublechaintech.retailscm.goods;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class GoodsTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goods";
	
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
	protected GoodsTokens(){
		//ensure not initialized outside the class
	}
	public  static  GoodsTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GoodsTokens tokens = new GoodsTokens(options);
		return tokens;
		
	}
	protected GoodsTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public GoodsTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static GoodsTokens start(){
		return new GoodsTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public GoodsTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static GoodsTokens allTokens(){
		
		return start()
			.withSku()
			.withReceivingSpace()
			.withGoodsAllocation()
			.withSmartPallet()
			.withShippingSpace()
			.withTransportTask()
			.withRetailStore()
			.withBizOrder()
			.withRetailStoreOrder()
			.withGoodsMovementList();
	
	}
	public static GoodsTokens withoutListsTokens(){
		
		return start()
			.withSku()
			.withReceivingSpace()
			.withGoodsAllocation()
			.withSmartPallet()
			.withShippingSpace()
			.withTransportTask()
			.withRetailStore()
			.withBizOrder()
			.withRetailStoreOrder();
	
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
	
	public GoodsTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SKU = "sku";
	public String getSku(){
		return SKU;
	}
	public GoodsTokens withSku(){		
		addSimpleOptions(SKU);
		return this;
	}
	
	
	protected static final String RECEIVINGSPACE = "receivingSpace";
	public String getReceivingSpace(){
		return RECEIVINGSPACE;
	}
	public GoodsTokens withReceivingSpace(){		
		addSimpleOptions(RECEIVINGSPACE);
		return this;
	}
	
	
	protected static final String GOODSALLOCATION = "goodsAllocation";
	public String getGoodsAllocation(){
		return GOODSALLOCATION;
	}
	public GoodsTokens withGoodsAllocation(){		
		addSimpleOptions(GOODSALLOCATION);
		return this;
	}
	
	
	protected static final String SMARTPALLET = "smartPallet";
	public String getSmartPallet(){
		return SMARTPALLET;
	}
	public GoodsTokens withSmartPallet(){		
		addSimpleOptions(SMARTPALLET);
		return this;
	}
	
	
	protected static final String SHIPPINGSPACE = "shippingSpace";
	public String getShippingSpace(){
		return SHIPPINGSPACE;
	}
	public GoodsTokens withShippingSpace(){		
		addSimpleOptions(SHIPPINGSPACE);
		return this;
	}
	
	
	protected static final String TRANSPORTTASK = "transportTask";
	public String getTransportTask(){
		return TRANSPORTTASK;
	}
	public GoodsTokens withTransportTask(){		
		addSimpleOptions(TRANSPORTTASK);
		return this;
	}
	
	
	protected static final String RETAILSTORE = "retailStore";
	public String getRetailStore(){
		return RETAILSTORE;
	}
	public GoodsTokens withRetailStore(){		
		addSimpleOptions(RETAILSTORE);
		return this;
	}
	
	
	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public GoodsTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	protected static final String RETAILSTOREORDER = "retailStoreOrder";
	public String getRetailStoreOrder(){
		return RETAILSTOREORDER;
	}
	public GoodsTokens withRetailStoreOrder(){		
		addSimpleOptions(RETAILSTOREORDER);
		return this;
	}
	
	
	protected static final String GOODS_MOVEMENT_LIST = "goodsMovementList";
	public String getGoodsMovementList(){
		return GOODS_MOVEMENT_LIST;
	}
	public GoodsTokens withGoodsMovementList(){		
		addSimpleOptions(GOODS_MOVEMENT_LIST);
		return this;
	}
	public GoodsTokens analyzeGoodsMovementList(){		
		addSimpleOptions(GOODS_MOVEMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsMovementListEnabled(){		
		
		if(checkOptions(this.options(), GOODS_MOVEMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsTokens extractMoreFromGoodsMovementList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_MOVEMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsMovementListSortCounter = 0;
	public GoodsTokens sortGoodsMovementListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_MOVEMENT_LIST,goodsMovementListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsMovementListSearchCounter = 0;
	public GoodsTokens searchGoodsMovementListWith(String field, String verb, String value){		
		
		withGoodsMovementList();
		addSearchMoreOptions(GOODS_MOVEMENT_LIST,goodsMovementListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsTokens searchAllTextOfGoodsMovementList(String verb, String value){	
		String field = "id|facility|facilityId|fromIp|userAgent|sessionId";
		addSearchMoreOptions(GOODS_MOVEMENT_LIST,goodsMovementListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsTokens rowsPerPageOfGoodsMovementList(int rowsPerPage){		
		addSimpleOptions(GOODS_MOVEMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsTokens currentPageNumberOfGoodsMovementList(int currentPageNumber){		
		addSimpleOptions(GOODS_MOVEMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsTokens retainColumnsOfGoodsMovementList(String[] columns){		
		addSimpleOptions(GOODS_MOVEMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsTokens excludeColumnsOfGoodsMovementList(String[] columns){		
		addSimpleOptions(GOODS_MOVEMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  GoodsTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfGoodsMovementList(verb, value);	
		return this;
	}
}

