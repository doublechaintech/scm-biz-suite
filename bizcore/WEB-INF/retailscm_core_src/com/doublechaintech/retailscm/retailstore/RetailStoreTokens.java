
package com.doublechaintech.retailscm.retailstore;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStore";
	
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
	protected RetailStoreTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreTokens tokens = new RetailStoreTokens(options);
		return tokens;
		
	}
	protected RetailStoreTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public RetailStoreTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static RetailStoreTokens start(){
		return new RetailStoreTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public RetailStoreTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static RetailStoreTokens allTokens(){
		
		return start()
			.withRetailStoreCountryCenter()
			.withCityServiceCenter()
			.withCreation()
			.withInvestmentInvitation()
			.withFranchising()
			.withDecoration()
			.withOpening()
			.withClosing()
			.withConsumerOrderList()
			.withRetailStoreOrderList()
			.withGoodsList()
			.withTransportTaskList()
			.withAccountSetList();
	
	}
	public static RetailStoreTokens withoutListsTokens(){
		
		return start()
			.withRetailStoreCountryCenter()
			.withCityServiceCenter()
			.withCreation()
			.withInvestmentInvitation()
			.withFranchising()
			.withDecoration()
			.withOpening()
			.withClosing();
	
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
	
	public RetailStoreTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String RETAILSTORECOUNTRYCENTER = "retailStoreCountryCenter";
	public String getRetailStoreCountryCenter(){
		return RETAILSTORECOUNTRYCENTER;
	}
	public RetailStoreTokens withRetailStoreCountryCenter(){		
		addSimpleOptions(RETAILSTORECOUNTRYCENTER);
		return this;
	}
	
	
	protected static final String CITYSERVICECENTER = "cityServiceCenter";
	public String getCityServiceCenter(){
		return CITYSERVICECENTER;
	}
	public RetailStoreTokens withCityServiceCenter(){		
		addSimpleOptions(CITYSERVICECENTER);
		return this;
	}
	
	
	protected static final String CREATION = "creation";
	public String getCreation(){
		return CREATION;
	}
	public RetailStoreTokens withCreation(){		
		addSimpleOptions(CREATION);
		return this;
	}
	
	
	protected static final String INVESTMENTINVITATION = "investmentInvitation";
	public String getInvestmentInvitation(){
		return INVESTMENTINVITATION;
	}
	public RetailStoreTokens withInvestmentInvitation(){		
		addSimpleOptions(INVESTMENTINVITATION);
		return this;
	}
	
	
	protected static final String FRANCHISING = "franchising";
	public String getFranchising(){
		return FRANCHISING;
	}
	public RetailStoreTokens withFranchising(){		
		addSimpleOptions(FRANCHISING);
		return this;
	}
	
	
	protected static final String DECORATION = "decoration";
	public String getDecoration(){
		return DECORATION;
	}
	public RetailStoreTokens withDecoration(){		
		addSimpleOptions(DECORATION);
		return this;
	}
	
	
	protected static final String OPENING = "opening";
	public String getOpening(){
		return OPENING;
	}
	public RetailStoreTokens withOpening(){		
		addSimpleOptions(OPENING);
		return this;
	}
	
	
	protected static final String CLOSING = "closing";
	public String getClosing(){
		return CLOSING;
	}
	public RetailStoreTokens withClosing(){		
		addSimpleOptions(CLOSING);
		return this;
	}
	
	
	protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	public String getConsumerOrderList(){
		return CONSUMER_ORDER_LIST;
	}
	public RetailStoreTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}
	public RetailStoreTokens analyzeConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeConsumerOrderListEnabled(){		
		
		if(checkOptions(this.options(), CONSUMER_ORDER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreTokens extractMoreFromConsumerOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(CONSUMER_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int consumerOrderListSortCounter = 0;
	public RetailStoreTokens sortConsumerOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int consumerOrderListSearchCounter = 0;
	public RetailStoreTokens searchConsumerOrderListWith(String field, String verb, String value){		
		
		withConsumerOrderList();
		addSearchMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens searchAllTextOfConsumerOrderList(String verb, String value){	
		String field = "id|title";
		addSearchMoreOptions(CONSUMER_ORDER_LIST,consumerOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens rowsPerPageOfConsumerOrderList(int rowsPerPage){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreTokens currentPageNumberOfConsumerOrderList(int currentPageNumber){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreTokens retainColumnsOfConsumerOrderList(String[] columns){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreTokens excludeColumnsOfConsumerOrderList(String[] columns){		
		addSimpleOptions(CONSUMER_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}
	public RetailStoreTokens withRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}
	public RetailStoreTokens analyzeRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreOrderListEnabled(){		
		
		if(checkOptions(this.options(), RETAIL_STORE_ORDER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreTokens extractMoreFromRetailStoreOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreOrderListSortCounter = 0;
	public RetailStoreTokens sortRetailStoreOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderListSearchCounter = 0;
	public RetailStoreTokens searchRetailStoreOrderListWith(String field, String verb, String value){		
		
		withRetailStoreOrderList();
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens searchAllTextOfRetailStoreOrderList(String verb, String value){	
		String field = "id|title";
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens rowsPerPageOfRetailStoreOrderList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreTokens currentPageNumberOfRetailStoreOrderList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreTokens retainColumnsOfRetailStoreOrderList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreTokens excludeColumnsOfRetailStoreOrderList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public RetailStoreTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}
	public RetailStoreTokens analyzeGoodsList(){		
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
	public RetailStoreTokens extractMoreFromGoodsList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsListSortCounter = 0;
	public RetailStoreTokens sortGoodsListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_LIST,goodsListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsListSearchCounter = 0;
	public RetailStoreTokens searchGoodsListWith(String field, String verb, String value){		
		
		withGoodsList();
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens searchAllTextOfGoodsList(String verb, String value){	
		String field = "id|name|rfid|uom";
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens rowsPerPageOfGoodsList(int rowsPerPage){		
		addSimpleOptions(GOODS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreTokens currentPageNumberOfGoodsList(int currentPageNumber){		
		addSimpleOptions(GOODS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreTokens retainColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreTokens excludeColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}
	public RetailStoreTokens withTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}
	public RetailStoreTokens analyzeTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListEnabled(){		
		
		if(checkOptions(this.options(), TRANSPORT_TASK_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreTokens extractMoreFromTransportTaskList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListSortCounter = 0;
	public RetailStoreTokens sortTransportTaskListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListSearchCounter = 0;
	public RetailStoreTokens searchTransportTaskListWith(String field, String verb, String value){		
		
		withTransportTaskList();
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens searchAllTextOfTransportTaskList(String verb, String value){	
		String field = "id|name|start";
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens rowsPerPageOfTransportTaskList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreTokens currentPageNumberOfTransportTaskList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreTokens retainColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreTokens excludeColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String ACCOUNT_SET_LIST = "accountSetList";
	public String getAccountSetList(){
		return ACCOUNT_SET_LIST;
	}
	public RetailStoreTokens withAccountSetList(){		
		addSimpleOptions(ACCOUNT_SET_LIST);
		return this;
	}
	public RetailStoreTokens analyzeAccountSetList(){		
		addSimpleOptions(ACCOUNT_SET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeAccountSetListEnabled(){		
		
		if(checkOptions(this.options(), ACCOUNT_SET_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreTokens extractMoreFromAccountSetList(String idsSeperatedWithComma){		
		addSimpleOptions(ACCOUNT_SET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int accountSetListSortCounter = 0;
	public RetailStoreTokens sortAccountSetListWith(String field, String descOrAsc){		
		addSortMoreOptions(ACCOUNT_SET_LIST,accountSetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountSetListSearchCounter = 0;
	public RetailStoreTokens searchAccountSetListWith(String field, String verb, String value){		
		
		withAccountSetList();
		addSearchMoreOptions(ACCOUNT_SET_LIST,accountSetListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens searchAllTextOfAccountSetList(String verb, String value){	
		String field = "id|name|yearSet|accountingSystem|domesticCurrencyCode|domesticCurrencyName|openingBank|accountNumber";
		addSearchMoreOptions(ACCOUNT_SET_LIST,accountSetListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreTokens rowsPerPageOfAccountSetList(int rowsPerPage){		
		addSimpleOptions(ACCOUNT_SET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreTokens currentPageNumberOfAccountSetList(int currentPageNumber){		
		addSimpleOptions(ACCOUNT_SET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreTokens retainColumnsOfAccountSetList(String[] columns){		
		addSimpleOptions(ACCOUNT_SET_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreTokens excludeColumnsOfAccountSetList(String[] columns){		
		addSimpleOptions(ACCOUNT_SET_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  RetailStoreTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfConsumerOrderList(verb, value);	
		searchAllTextOfRetailStoreOrderList(verb, value);	
		searchAllTextOfGoodsList(verb, value);	
		searchAllTextOfTransportTaskList(verb, value);	
		searchAllTextOfAccountSetList(verb, value);	
		return this;
	}
}

