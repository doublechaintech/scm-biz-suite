
package com.doublechaintech.retailscm.supplyorder;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrder";
	
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
	protected SupplyOrderTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderTokens start(){
		return new SupplyOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderTokens allTokens(){
		
		return start()
			.withBuyer()
			.withSeller()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withPicking()
			.withShipment()
			.withDelivery()
			.withSupplyOrderLineItemList()
			.withSupplyOrderShippingGroupList()
			.withSupplyOrderPaymentGroupList()
			.withGoodsList();
	
	}
	public static SupplyOrderTokens withoutListsTokens(){
		
		return start()
			.withBuyer()
			.withSeller()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withPicking()
			.withShipment()
			.withDelivery();
	
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

	protected static final String BUYER = "buyer";
	public String getBuyer(){
		return BUYER;
	}
	public SupplyOrderTokens withBuyer(){		
		addSimpleOptions(BUYER);
		return this;
	}
	
	
	protected static final String SELLER = "seller";
	public String getSeller(){
		return SELLER;
	}
	public SupplyOrderTokens withSeller(){		
		addSimpleOptions(SELLER);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public SupplyOrderTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String APPROVAL = "approval";
	public String getApproval(){
		return APPROVAL;
	}
	public SupplyOrderTokens withApproval(){		
		addSimpleOptions(APPROVAL);
		return this;
	}
	
	
	protected static final String PROCESSING = "processing";
	public String getProcessing(){
		return PROCESSING;
	}
	public SupplyOrderTokens withProcessing(){		
		addSimpleOptions(PROCESSING);
		return this;
	}
	
	
	protected static final String PICKING = "picking";
	public String getPicking(){
		return PICKING;
	}
	public SupplyOrderTokens withPicking(){		
		addSimpleOptions(PICKING);
		return this;
	}
	
	
	protected static final String SHIPMENT = "shipment";
	public String getShipment(){
		return SHIPMENT;
	}
	public SupplyOrderTokens withShipment(){		
		addSimpleOptions(SHIPMENT);
		return this;
	}
	
	
	protected static final String DELIVERY = "delivery";
	public String getDelivery(){
		return DELIVERY;
	}
	public SupplyOrderTokens withDelivery(){		
		addSimpleOptions(DELIVERY);
		return this;
	}
	
	
	protected static final String SUPPLY_ORDER_LINE_ITEM_LIST = "supplyOrderLineItemList";
	public String getSupplyOrderLineItemList(){
		return SUPPLY_ORDER_LINE_ITEM_LIST;
	}
	public SupplyOrderTokens withSupplyOrderLineItemList(){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST);
		return this;
	}
	public SupplyOrderTokens analyzeSupplyOrderLineItemList(){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplyOrderLineItemListEnabled(){		
		
		return checkOptions(this.options(), SUPPLY_ORDER_LINE_ITEM_LIST+".anaylze");
	}
	public SupplyOrderTokens extractMoreFromSupplyOrderLineItemList(String idsSeperatedWithComma){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int supplyOrderLineItemListSortCounter = 0;
	public SupplyOrderTokens sortSupplyOrderLineItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(SUPPLY_ORDER_LINE_ITEM_LIST,supplyOrderLineItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderLineItemListSearchCounter = 0;
	public SupplyOrderTokens searchSupplyOrderLineItemListWith(String field, String verb, String value){		
		addSearchMoreOptions(SUPPLY_ORDER_LINE_ITEM_LIST,supplyOrderLineItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderTokens searchAllTextOfSupplyOrderLineItemList(String verb, String value){	
		String field = "id|skuId|skuName|unitOfMeasurement";
		addSearchMoreOptions(SUPPLY_ORDER_LINE_ITEM_LIST,supplyOrderLineItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderTokens rowsPerPageOfSupplyOrderLineItemList(int rowsPerPage){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderTokens currentPageNumberOfSupplyOrderLineItemList(int currentPageNumber){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderTokens retainColumnsOfSupplyOrderLineItemList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderTokens excludeColumnsOfSupplyOrderLineItemList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SUPPLY_ORDER_SHIPPING_GROUP_LIST = "supplyOrderShippingGroupList";
	public String getSupplyOrderShippingGroupList(){
		return SUPPLY_ORDER_SHIPPING_GROUP_LIST;
	}
	public SupplyOrderTokens withSupplyOrderShippingGroupList(){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST);
		return this;
	}
	public SupplyOrderTokens analyzeSupplyOrderShippingGroupList(){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplyOrderShippingGroupListEnabled(){		
		
		return checkOptions(this.options(), SUPPLY_ORDER_SHIPPING_GROUP_LIST+".anaylze");
	}
	public SupplyOrderTokens extractMoreFromSupplyOrderShippingGroupList(String idsSeperatedWithComma){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int supplyOrderShippingGroupListSortCounter = 0;
	public SupplyOrderTokens sortSupplyOrderShippingGroupListWith(String field, String descOrAsc){		
		addSortMoreOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST,supplyOrderShippingGroupListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderShippingGroupListSearchCounter = 0;
	public SupplyOrderTokens searchSupplyOrderShippingGroupListWith(String field, String verb, String value){		
		addSearchMoreOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST,supplyOrderShippingGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderTokens searchAllTextOfSupplyOrderShippingGroupList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST,supplyOrderShippingGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderTokens rowsPerPageOfSupplyOrderShippingGroupList(int rowsPerPage){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderTokens currentPageNumberOfSupplyOrderShippingGroupList(int currentPageNumber){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderTokens retainColumnsOfSupplyOrderShippingGroupList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderTokens excludeColumnsOfSupplyOrderShippingGroupList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SUPPLY_ORDER_PAYMENT_GROUP_LIST = "supplyOrderPaymentGroupList";
	public String getSupplyOrderPaymentGroupList(){
		return SUPPLY_ORDER_PAYMENT_GROUP_LIST;
	}
	public SupplyOrderTokens withSupplyOrderPaymentGroupList(){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST);
		return this;
	}
	public SupplyOrderTokens analyzeSupplyOrderPaymentGroupList(){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplyOrderPaymentGroupListEnabled(){		
		
		return checkOptions(this.options(), SUPPLY_ORDER_PAYMENT_GROUP_LIST+".anaylze");
	}
	public SupplyOrderTokens extractMoreFromSupplyOrderPaymentGroupList(String idsSeperatedWithComma){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int supplyOrderPaymentGroupListSortCounter = 0;
	public SupplyOrderTokens sortSupplyOrderPaymentGroupListWith(String field, String descOrAsc){		
		addSortMoreOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST,supplyOrderPaymentGroupListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderPaymentGroupListSearchCounter = 0;
	public SupplyOrderTokens searchSupplyOrderPaymentGroupListWith(String field, String verb, String value){		
		addSearchMoreOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST,supplyOrderPaymentGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderTokens searchAllTextOfSupplyOrderPaymentGroupList(String verb, String value){	
		String field = "id|name|cardNumber";
		addSearchMoreOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST,supplyOrderPaymentGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderTokens rowsPerPageOfSupplyOrderPaymentGroupList(int rowsPerPage){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderTokens currentPageNumberOfSupplyOrderPaymentGroupList(int currentPageNumber){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderTokens retainColumnsOfSupplyOrderPaymentGroupList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderTokens excludeColumnsOfSupplyOrderPaymentGroupList(String[] columns){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public SupplyOrderTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}
	public SupplyOrderTokens analyzeGoodsList(){		
		addSimpleOptions(GOODS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsListEnabled(){		
		
		return checkOptions(this.options(), GOODS_LIST+".anaylze");
	}
	public SupplyOrderTokens extractMoreFromGoodsList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsListSortCounter = 0;
	public SupplyOrderTokens sortGoodsListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_LIST,goodsListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsListSearchCounter = 0;
	public SupplyOrderTokens searchGoodsListWith(String field, String verb, String value){		
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SupplyOrderTokens searchAllTextOfGoodsList(String verb, String value){	
		String field = "id|name|rfid|uom|currentStatus";
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SupplyOrderTokens rowsPerPageOfGoodsList(int rowsPerPage){		
		addSimpleOptions(GOODS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SupplyOrderTokens currentPageNumberOfGoodsList(int currentPageNumber){		
		addSimpleOptions(GOODS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SupplyOrderTokens retainColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"RetainColumns",columns);
		return this;
	}
	public SupplyOrderTokens excludeColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  SupplyOrderTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfSupplyOrderLineItemList(verb, value);	
		searchAllTextOfSupplyOrderShippingGroupList(verb, value);	
		searchAllTextOfSupplyOrderPaymentGroupList(verb, value);	
		searchAllTextOfGoodsList(verb, value);	
		return this;
	}
}

