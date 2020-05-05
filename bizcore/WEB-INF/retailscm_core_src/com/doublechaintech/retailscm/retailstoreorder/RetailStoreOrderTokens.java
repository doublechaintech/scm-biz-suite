
package com.doublechaintech.retailscm.retailstoreorder;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreOrderTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreOrder";
	
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
	protected RetailStoreOrderTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreOrderTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreOrderTokens tokens = new RetailStoreOrderTokens(options);
		return tokens;
		
	}
	protected RetailStoreOrderTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public RetailStoreOrderTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreOrderTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreOrderTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static RetailStoreOrderTokens start(){
		return new RetailStoreOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public RetailStoreOrderTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static RetailStoreOrderTokens allTokens(){
		
		return start()
			.withBuyer()
			.withSeller()
			.withRetailStoreOrderLineItemList()
			.withRetailStoreOrderShippingGroupList()
			.withRetailStoreOrderPaymentGroupList()
			.withGoodsList();
	
	}
	public static RetailStoreOrderTokens withoutListsTokens(){
		
		return start()
			.withBuyer()
			.withSeller();
	
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
	
	public RetailStoreOrderTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BUYER = "buyer";
	public String getBuyer(){
		return BUYER;
	}
	public RetailStoreOrderTokens withBuyer(){		
		addSimpleOptions(BUYER);
		return this;
	}
	
	
	protected static final String SELLER = "seller";
	public String getSeller(){
		return SELLER;
	}
	public RetailStoreOrderTokens withSeller(){		
		addSimpleOptions(SELLER);
		return this;
	}
	
	
	protected static final String RETAIL_STORE_ORDER_LINE_ITEM_LIST = "retailStoreOrderLineItemList";
	public String getRetailStoreOrderLineItemList(){
		return RETAIL_STORE_ORDER_LINE_ITEM_LIST;
	}
	public RetailStoreOrderTokens withRetailStoreOrderLineItemList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST);
		return this;
	}
	public RetailStoreOrderTokens analyzeRetailStoreOrderLineItemList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreOrderLineItemListEnabled(){		
		
		if(checkOptions(this.options(), RETAIL_STORE_ORDER_LINE_ITEM_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreOrderTokens extractMoreFromRetailStoreOrderLineItemList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreOrderLineItemListSortCounter = 0;
	public RetailStoreOrderTokens sortRetailStoreOrderLineItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST,retailStoreOrderLineItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderLineItemListSearchCounter = 0;
	public RetailStoreOrderTokens searchRetailStoreOrderLineItemListWith(String field, String verb, String value){		
		
		withRetailStoreOrderLineItemList();
		addSearchMoreOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST,retailStoreOrderLineItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens searchAllTextOfRetailStoreOrderLineItemList(String verb, String value){	
		String field = "id|skuId|skuName|unitOfMeasurement";
		addSearchMoreOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST,retailStoreOrderLineItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens rowsPerPageOfRetailStoreOrderLineItemList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreOrderTokens currentPageNumberOfRetailStoreOrderLineItemList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreOrderTokens retainColumnsOfRetailStoreOrderLineItemList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreOrderTokens excludeColumnsOfRetailStoreOrderLineItemList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST = "retailStoreOrderShippingGroupList";
	public String getRetailStoreOrderShippingGroupList(){
		return RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST;
	}
	public RetailStoreOrderTokens withRetailStoreOrderShippingGroupList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
		return this;
	}
	public RetailStoreOrderTokens analyzeRetailStoreOrderShippingGroupList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreOrderShippingGroupListEnabled(){		
		
		if(checkOptions(this.options(), RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreOrderTokens extractMoreFromRetailStoreOrderShippingGroupList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreOrderShippingGroupListSortCounter = 0;
	public RetailStoreOrderTokens sortRetailStoreOrderShippingGroupListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST,retailStoreOrderShippingGroupListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderShippingGroupListSearchCounter = 0;
	public RetailStoreOrderTokens searchRetailStoreOrderShippingGroupListWith(String field, String verb, String value){		
		
		withRetailStoreOrderShippingGroupList();
		addSearchMoreOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST,retailStoreOrderShippingGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens searchAllTextOfRetailStoreOrderShippingGroupList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST,retailStoreOrderShippingGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens rowsPerPageOfRetailStoreOrderShippingGroupList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreOrderTokens currentPageNumberOfRetailStoreOrderShippingGroupList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreOrderTokens retainColumnsOfRetailStoreOrderShippingGroupList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreOrderTokens excludeColumnsOfRetailStoreOrderShippingGroupList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST = "retailStoreOrderPaymentGroupList";
	public String getRetailStoreOrderPaymentGroupList(){
		return RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST;
	}
	public RetailStoreOrderTokens withRetailStoreOrderPaymentGroupList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
		return this;
	}
	public RetailStoreOrderTokens analyzeRetailStoreOrderPaymentGroupList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreOrderPaymentGroupListEnabled(){		
		
		if(checkOptions(this.options(), RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreOrderTokens extractMoreFromRetailStoreOrderPaymentGroupList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreOrderPaymentGroupListSortCounter = 0;
	public RetailStoreOrderTokens sortRetailStoreOrderPaymentGroupListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST,retailStoreOrderPaymentGroupListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderPaymentGroupListSearchCounter = 0;
	public RetailStoreOrderTokens searchRetailStoreOrderPaymentGroupListWith(String field, String verb, String value){		
		
		withRetailStoreOrderPaymentGroupList();
		addSearchMoreOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST,retailStoreOrderPaymentGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens searchAllTextOfRetailStoreOrderPaymentGroupList(String verb, String value){	
		String field = "id|name|cardNumber";
		addSearchMoreOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST,retailStoreOrderPaymentGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens rowsPerPageOfRetailStoreOrderPaymentGroupList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreOrderTokens currentPageNumberOfRetailStoreOrderPaymentGroupList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreOrderTokens retainColumnsOfRetailStoreOrderPaymentGroupList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreOrderTokens excludeColumnsOfRetailStoreOrderPaymentGroupList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public RetailStoreOrderTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}
	public RetailStoreOrderTokens analyzeGoodsList(){		
		addSimpleOptions(GOODS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsListEnabled(){		
		
		if(checkOptions(this.options(), GOODS_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreOrderTokens extractMoreFromGoodsList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsListSortCounter = 0;
	public RetailStoreOrderTokens sortGoodsListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_LIST,goodsListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsListSearchCounter = 0;
	public RetailStoreOrderTokens searchGoodsListWith(String field, String verb, String value){		
		
		withGoodsList();
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens searchAllTextOfGoodsList(String verb, String value){	
		String field = "id|name|rfid|uom";
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderTokens rowsPerPageOfGoodsList(int rowsPerPage){		
		addSimpleOptions(GOODS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreOrderTokens currentPageNumberOfGoodsList(int currentPageNumber){		
		addSimpleOptions(GOODS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreOrderTokens retainColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreOrderTokens excludeColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  RetailStoreOrderTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRetailStoreOrderLineItemList(verb, value);	
		searchAllTextOfRetailStoreOrderShippingGroupList(verb, value);	
		searchAllTextOfRetailStoreOrderPaymentGroupList(verb, value);	
		searchAllTextOfGoodsList(verb, value);	
		return this;
	}
}

