
package com.doublechaintech.retailscm.shippingspace;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ShippingSpaceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="shippingSpace";
	
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
	protected ShippingSpaceTokens(){
		//ensure not initialized outside the class
	}
	public  static  ShippingSpaceTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ShippingSpaceTokens tokens = new ShippingSpaceTokens(options);
		return tokens;
		
	}
	protected ShippingSpaceTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ShippingSpaceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ShippingSpaceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ShippingSpaceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static ShippingSpaceTokens start(){
		return new ShippingSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public ShippingSpaceTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static ShippingSpaceTokens allTokens(){
		
		return start()
			.withWarehouse()
			.withGoodsList();
	
	}
	public static ShippingSpaceTokens withoutListsTokens(){
		
		return start()
			.withWarehouse();
	
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
	
	public ShippingSpaceTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String WAREHOUSE = "warehouse";
	public String getWarehouse(){
		return WAREHOUSE;
	}
	public ShippingSpaceTokens withWarehouse(){		
		addSimpleOptions(WAREHOUSE);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public ShippingSpaceTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}
	public ShippingSpaceTokens analyzeGoodsList(){		
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
	public ShippingSpaceTokens extractMoreFromGoodsList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsListSortCounter = 0;
	public ShippingSpaceTokens sortGoodsListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_LIST,goodsListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsListSearchCounter = 0;
	public ShippingSpaceTokens searchGoodsListWith(String field, String verb, String value){		
		
		withGoodsList();
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ShippingSpaceTokens searchAllTextOfGoodsList(String verb, String value){	
		String field = "id|name|rfid|uom";
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ShippingSpaceTokens rowsPerPageOfGoodsList(int rowsPerPage){		
		addSimpleOptions(GOODS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ShippingSpaceTokens currentPageNumberOfGoodsList(int currentPageNumber){		
		addSimpleOptions(GOODS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ShippingSpaceTokens retainColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"RetainColumns",columns);
		return this;
	}
	public ShippingSpaceTokens excludeColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ShippingSpaceTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfGoodsList(verb, value);	
		return this;
	}
}

