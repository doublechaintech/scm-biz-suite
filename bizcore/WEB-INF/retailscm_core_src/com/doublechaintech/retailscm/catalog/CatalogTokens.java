
package com.doublechaintech.retailscm.catalog;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryTokens;





public class CatalogTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="catalog";

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
	protected CatalogTokens(){
		//ensure not initialized outside the class
	}
	public  static  CatalogTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		CatalogTokens tokens = new CatalogTokens(options);
		return tokens;

	}
	protected CatalogTokens(Map<String,Object> options){
		this.options = options;
	}

	public CatalogTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static CatalogTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected CatalogTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static CatalogTokens start(){
		return new CatalogTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public CatalogTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static CatalogTokens loadGroupTokens(String... groupNames){
    CatalogTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, OWNER, groupNames, new String[]{"default"});

  
     addToken(tokens, LEVEL_ONE_CATEGORY_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(CatalogTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static CatalogTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withOwner()
			.withLevelOneCategoryListIfViewGroupInclude(viewGroups);

	}

	public static CatalogTokens allTokens(){

		return start()
			.withOwner()
			.withLevelOneCategoryList();

	}
	public static CatalogTokens withoutListsTokens(){

		return start()
			.withOwner();

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

	public CatalogTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	//
	public CatalogTokens withOwner(){
		addSimpleOptions(OWNER);
		return this;
	}

	public RetailStoreCountryCenterTokens withOwnerTokens(){
		//addSimpleOptions(OWNER);
		return RetailStoreCountryCenterTokens.start();
	}

	
	protected static final String LEVEL_ONE_CATEGORY_LIST = "levelOneCategoryList";
	public String getLevelOneCategoryList(){
		return LEVEL_ONE_CATEGORY_LIST;
	}



	public CatalogTokens withLevelOneCategoryListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(LEVEL_ONE_CATEGORY_LIST);
		}
		return this;
	}


	public CatalogTokens withLevelOneCategoryList(){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST);
		return this;
	}

	public LevelOneCategoryTokens withLevelOneCategoryListTokens(){
		//addSimpleOptions(LEVEL_ONE_CATEGORY_LIST);
		return LevelOneCategoryTokens.start();
	}

	public CatalogTokens analyzeLevelOneCategoryList(){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLevelOneCategoryListEnabled(){

		if(checkOptions(this.options(), LEVEL_ONE_CATEGORY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public CatalogTokens extractMoreFromLevelOneCategoryList(String idsSeperatedWithComma){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int levelOneCategoryListSortCounter = 0;
	public CatalogTokens sortLevelOneCategoryListWith(String field, String descOrAsc){
		addSortMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSortCounter++, field, descOrAsc);
		return this;
	}
	private int levelOneCategoryListSearchCounter = 0;
	public CatalogTokens searchLevelOneCategoryListWith(String field, String verb, String value){

		withLevelOneCategoryList();
		addSearchMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSearchCounter++, field, verb, value);
		return this;
	}



	public CatalogTokens searchAllTextOfLevelOneCategoryList(String verb, String value){
		String field = "id|name";
		addSearchMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSearchCounter++, field, verb, value);
		return this;
	}



	public CatalogTokens rowsPerPageOfLevelOneCategoryList(int rowsPerPage){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfLevelOneCategoryList(int currentPageNumber){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfLevelOneCategoryList(String[] columns){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfLevelOneCategoryList(String[] columns){
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  CatalogTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfLevelOneCategoryList(verb, value);
		return this;
	}
}

