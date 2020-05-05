
package com.doublechaintech.retailscm.goodsshelf;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class GoodsShelfTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsShelf";
	
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
	protected GoodsShelfTokens(){
		//ensure not initialized outside the class
	}
	public  static  GoodsShelfTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GoodsShelfTokens tokens = new GoodsShelfTokens(options);
		return tokens;
		
	}
	protected GoodsShelfTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public GoodsShelfTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsShelfTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsShelfTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static GoodsShelfTokens start(){
		return new GoodsShelfTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public GoodsShelfTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static GoodsShelfTokens allTokens(){
		
		return start()
			.withStorageSpace()
			.withSupplierSpace()
			.withDamageSpace()
			.withGoodsShelfStockCountList()
			.withGoodsAllocationList();
	
	}
	public static GoodsShelfTokens withoutListsTokens(){
		
		return start()
			.withStorageSpace()
			.withSupplierSpace()
			.withDamageSpace();
	
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
	
	public GoodsShelfTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String STORAGESPACE = "storageSpace";
	public String getStorageSpace(){
		return STORAGESPACE;
	}
	public GoodsShelfTokens withStorageSpace(){		
		addSimpleOptions(STORAGESPACE);
		return this;
	}
	
	
	protected static final String SUPPLIERSPACE = "supplierSpace";
	public String getSupplierSpace(){
		return SUPPLIERSPACE;
	}
	public GoodsShelfTokens withSupplierSpace(){		
		addSimpleOptions(SUPPLIERSPACE);
		return this;
	}
	
	
	protected static final String DAMAGESPACE = "damageSpace";
	public String getDamageSpace(){
		return DAMAGESPACE;
	}
	public GoodsShelfTokens withDamageSpace(){		
		addSimpleOptions(DAMAGESPACE);
		return this;
	}
	
	
	protected static final String GOODS_SHELF_STOCK_COUNT_LIST = "goodsShelfStockCountList";
	public String getGoodsShelfStockCountList(){
		return GOODS_SHELF_STOCK_COUNT_LIST;
	}
	public GoodsShelfTokens withGoodsShelfStockCountList(){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST);
		return this;
	}
	public GoodsShelfTokens analyzeGoodsShelfStockCountList(){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsShelfStockCountListEnabled(){		
		
		if(checkOptions(this.options(), GOODS_SHELF_STOCK_COUNT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsShelfTokens extractMoreFromGoodsShelfStockCountList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsShelfStockCountListSortCounter = 0;
	public GoodsShelfTokens sortGoodsShelfStockCountListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_SHELF_STOCK_COUNT_LIST,goodsShelfStockCountListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsShelfStockCountListSearchCounter = 0;
	public GoodsShelfTokens searchGoodsShelfStockCountListWith(String field, String verb, String value){		
		
		withGoodsShelfStockCountList();
		addSearchMoreOptions(GOODS_SHELF_STOCK_COUNT_LIST,goodsShelfStockCountListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsShelfTokens searchAllTextOfGoodsShelfStockCountList(String verb, String value){	
		String field = "id|title|summary";
		addSearchMoreOptions(GOODS_SHELF_STOCK_COUNT_LIST,goodsShelfStockCountListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsShelfTokens rowsPerPageOfGoodsShelfStockCountList(int rowsPerPage){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsShelfTokens currentPageNumberOfGoodsShelfStockCountList(int currentPageNumber){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsShelfTokens retainColumnsOfGoodsShelfStockCountList(String[] columns){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsShelfTokens excludeColumnsOfGoodsShelfStockCountList(String[] columns){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String GOODS_ALLOCATION_LIST = "goodsAllocationList";
	public String getGoodsAllocationList(){
		return GOODS_ALLOCATION_LIST;
	}
	public GoodsShelfTokens withGoodsAllocationList(){		
		addSimpleOptions(GOODS_ALLOCATION_LIST);
		return this;
	}
	public GoodsShelfTokens analyzeGoodsAllocationList(){		
		addSimpleOptions(GOODS_ALLOCATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsAllocationListEnabled(){		
		
		if(checkOptions(this.options(), GOODS_ALLOCATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsShelfTokens extractMoreFromGoodsAllocationList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_ALLOCATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsAllocationListSortCounter = 0;
	public GoodsShelfTokens sortGoodsAllocationListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_ALLOCATION_LIST,goodsAllocationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsAllocationListSearchCounter = 0;
	public GoodsShelfTokens searchGoodsAllocationListWith(String field, String verb, String value){		
		
		withGoodsAllocationList();
		addSearchMoreOptions(GOODS_ALLOCATION_LIST,goodsAllocationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsShelfTokens searchAllTextOfGoodsAllocationList(String verb, String value){	
		String field = "id|location";
		addSearchMoreOptions(GOODS_ALLOCATION_LIST,goodsAllocationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsShelfTokens rowsPerPageOfGoodsAllocationList(int rowsPerPage){		
		addSimpleOptions(GOODS_ALLOCATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsShelfTokens currentPageNumberOfGoodsAllocationList(int currentPageNumber){		
		addSimpleOptions(GOODS_ALLOCATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsShelfTokens retainColumnsOfGoodsAllocationList(String[] columns){		
		addSimpleOptions(GOODS_ALLOCATION_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsShelfTokens excludeColumnsOfGoodsAllocationList(String[] columns){		
		addSimpleOptions(GOODS_ALLOCATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  GoodsShelfTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfGoodsShelfStockCountList(verb, value);	
		searchAllTextOfGoodsAllocationList(verb, value);	
		return this;
	}
}

