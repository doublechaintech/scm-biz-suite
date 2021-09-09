
package com.doublechaintech.retailscm.smartpallet;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.warehouse.WarehouseTokens;
import com.doublechaintech.retailscm.goods.GoodsTokens;





public class SmartPalletTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="smartPallet";

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
	protected SmartPalletTokens(){
		//ensure not initialized outside the class
	}
	public  static  SmartPalletTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SmartPalletTokens tokens = new SmartPalletTokens(options);
		return tokens;

	}
	protected SmartPalletTokens(Map<String,Object> options){
		this.options = options;
	}

	public SmartPalletTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static SmartPalletTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected SmartPalletTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static SmartPalletTokens start(){
		return new SmartPalletTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public SmartPalletTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static SmartPalletTokens loadGroupTokens(String... groupNames){
    SmartPalletTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, WAREHOUSE, groupNames, new String[]{"default"});

  
     addToken(tokens, GOODS_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(SmartPalletTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static SmartPalletTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withWarehouse()
			.withGoodsListIfViewGroupInclude(viewGroups);

	}

	public static SmartPalletTokens allTokens(){

		return start()
			.withWarehouse()
			.withGoodsList();

	}
	public static SmartPalletTokens withoutListsTokens(){

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

	public SmartPalletTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String WAREHOUSE = "warehouse";
	public String getWarehouse(){
		return WAREHOUSE;
	}
	//
	public SmartPalletTokens withWarehouse(){
		addSimpleOptions(WAREHOUSE);
		return this;
	}

	public WarehouseTokens withWarehouseTokens(){
		//addSimpleOptions(WAREHOUSE);
		return WarehouseTokens.start();
	}

	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}



	public SmartPalletTokens withGoodsListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(GOODS_LIST);
		}
		return this;
	}


	public SmartPalletTokens withGoodsList(){
		addSimpleOptions(GOODS_LIST);
		return this;
	}

	public GoodsTokens withGoodsListTokens(){
		//addSimpleOptions(GOODS_LIST);
		return GoodsTokens.start();
	}

	public SmartPalletTokens analyzeGoodsList(){
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
	public SmartPalletTokens extractMoreFromGoodsList(String idsSeperatedWithComma){
		addSimpleOptions(GOODS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int goodsListSortCounter = 0;
	public SmartPalletTokens sortGoodsListWith(String field, String descOrAsc){
		addSortMoreOptions(GOODS_LIST,goodsListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsListSearchCounter = 0;
	public SmartPalletTokens searchGoodsListWith(String field, String verb, String value){

		withGoodsList();
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}



	public SmartPalletTokens searchAllTextOfGoodsList(String verb, String value){
		String field = "id|name|rfid|uom";
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}



	public SmartPalletTokens rowsPerPageOfGoodsList(int rowsPerPage){
		addSimpleOptions(GOODS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SmartPalletTokens currentPageNumberOfGoodsList(int currentPageNumber){
		addSimpleOptions(GOODS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SmartPalletTokens retainColumnsOfGoodsList(String[] columns){
		addSimpleOptions(GOODS_LIST+"RetainColumns",columns);
		return this;
	}
	public SmartPalletTokens excludeColumnsOfGoodsList(String[] columns){
		addSimpleOptions(GOODS_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  SmartPalletTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfGoodsList(verb, value);
		return this;
	}
}

