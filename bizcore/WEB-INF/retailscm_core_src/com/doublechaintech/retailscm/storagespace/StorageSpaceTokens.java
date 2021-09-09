
package com.doublechaintech.retailscm.storagespace;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.warehouse.WarehouseTokens;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfTokens;





public class StorageSpaceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="storageSpace";

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
	protected StorageSpaceTokens(){
		//ensure not initialized outside the class
	}
	public  static  StorageSpaceTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		StorageSpaceTokens tokens = new StorageSpaceTokens(options);
		return tokens;

	}
	protected StorageSpaceTokens(Map<String,Object> options){
		this.options = options;
	}

	public StorageSpaceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static StorageSpaceTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected StorageSpaceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static StorageSpaceTokens start(){
		return new StorageSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public StorageSpaceTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static StorageSpaceTokens loadGroupTokens(String... groupNames){
    StorageSpaceTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, WAREHOUSE, groupNames, new String[]{"default"});

  
     addToken(tokens, GOODS_SHELF_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(StorageSpaceTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static StorageSpaceTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withWarehouse()
			.withGoodsShelfListIfViewGroupInclude(viewGroups);

	}

	public static StorageSpaceTokens allTokens(){

		return start()
			.withWarehouse()
			.withGoodsShelfList();

	}
	public static StorageSpaceTokens withoutListsTokens(){

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

	public StorageSpaceTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String WAREHOUSE = "warehouse";
	public String getWarehouse(){
		return WAREHOUSE;
	}
	//
	public StorageSpaceTokens withWarehouse(){
		addSimpleOptions(WAREHOUSE);
		return this;
	}

	public WarehouseTokens withWarehouseTokens(){
		//addSimpleOptions(WAREHOUSE);
		return WarehouseTokens.start();
	}

	
	protected static final String GOODS_SHELF_LIST = "goodsShelfList";
	public String getGoodsShelfList(){
		return GOODS_SHELF_LIST;
	}



	public StorageSpaceTokens withGoodsShelfListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(GOODS_SHELF_LIST);
		}
		return this;
	}


	public StorageSpaceTokens withGoodsShelfList(){
		addSimpleOptions(GOODS_SHELF_LIST);
		return this;
	}

	public GoodsShelfTokens withGoodsShelfListTokens(){
		//addSimpleOptions(GOODS_SHELF_LIST);
		return GoodsShelfTokens.start();
	}

	public StorageSpaceTokens analyzeGoodsShelfList(){
		addSimpleOptions(GOODS_SHELF_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsShelfListEnabled(){

		if(checkOptions(this.options(), GOODS_SHELF_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public StorageSpaceTokens extractMoreFromGoodsShelfList(String idsSeperatedWithComma){
		addSimpleOptions(GOODS_SHELF_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int goodsShelfListSortCounter = 0;
	public StorageSpaceTokens sortGoodsShelfListWith(String field, String descOrAsc){
		addSortMoreOptions(GOODS_SHELF_LIST,goodsShelfListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsShelfListSearchCounter = 0;
	public StorageSpaceTokens searchGoodsShelfListWith(String field, String verb, String value){

		withGoodsShelfList();
		addSearchMoreOptions(GOODS_SHELF_LIST,goodsShelfListSearchCounter++, field, verb, value);
		return this;
	}



	public StorageSpaceTokens searchAllTextOfGoodsShelfList(String verb, String value){
		String field = "id|location";
		addSearchMoreOptions(GOODS_SHELF_LIST,goodsShelfListSearchCounter++, field, verb, value);
		return this;
	}



	public StorageSpaceTokens rowsPerPageOfGoodsShelfList(int rowsPerPage){
		addSimpleOptions(GOODS_SHELF_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public StorageSpaceTokens currentPageNumberOfGoodsShelfList(int currentPageNumber){
		addSimpleOptions(GOODS_SHELF_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public StorageSpaceTokens retainColumnsOfGoodsShelfList(String[] columns){
		addSimpleOptions(GOODS_SHELF_LIST+"RetainColumns",columns);
		return this;
	}
	public StorageSpaceTokens excludeColumnsOfGoodsShelfList(String[] columns){
		addSimpleOptions(GOODS_SHELF_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  StorageSpaceTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfGoodsShelfList(verb, value);
		return this;
	}
}

