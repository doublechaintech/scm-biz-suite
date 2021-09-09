
package com.doublechaintech.retailscm.leveltwocategory;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryTokens;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryTokens;





public class LevelTwoCategoryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="levelTwoCategory";

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
	protected LevelTwoCategoryTokens(){
		//ensure not initialized outside the class
	}
	public  static  LevelTwoCategoryTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		LevelTwoCategoryTokens tokens = new LevelTwoCategoryTokens(options);
		return tokens;

	}
	protected LevelTwoCategoryTokens(Map<String,Object> options){
		this.options = options;
	}

	public LevelTwoCategoryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static LevelTwoCategoryTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected LevelTwoCategoryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static LevelTwoCategoryTokens start(){
		return new LevelTwoCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public LevelTwoCategoryTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static LevelTwoCategoryTokens loadGroupTokens(String... groupNames){
    LevelTwoCategoryTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, PARENTCATEGORY, groupNames, new String[]{"default"});

  
     addToken(tokens, LEVEL_THREE_CATEGORY_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(LevelTwoCategoryTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static LevelTwoCategoryTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withParentCategory()
			.withLevelThreeCategoryListIfViewGroupInclude(viewGroups);

	}

	public static LevelTwoCategoryTokens allTokens(){

		return start()
			.withParentCategory()
			.withLevelThreeCategoryList();

	}
	public static LevelTwoCategoryTokens withoutListsTokens(){

		return start()
			.withParentCategory();

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

	public LevelTwoCategoryTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	//
	public LevelTwoCategoryTokens withParentCategory(){
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}

	public LevelOneCategoryTokens withParentCategoryTokens(){
		//addSimpleOptions(PARENTCATEGORY);
		return LevelOneCategoryTokens.start();
	}

	
	protected static final String LEVEL_THREE_CATEGORY_LIST = "levelThreeCategoryList";
	public String getLevelThreeCategoryList(){
		return LEVEL_THREE_CATEGORY_LIST;
	}



	public LevelTwoCategoryTokens withLevelThreeCategoryListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(LEVEL_THREE_CATEGORY_LIST);
		}
		return this;
	}


	public LevelTwoCategoryTokens withLevelThreeCategoryList(){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST);
		return this;
	}

	public LevelThreeCategoryTokens withLevelThreeCategoryListTokens(){
		//addSimpleOptions(LEVEL_THREE_CATEGORY_LIST);
		return LevelThreeCategoryTokens.start();
	}

	public LevelTwoCategoryTokens analyzeLevelThreeCategoryList(){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLevelThreeCategoryListEnabled(){

		if(checkOptions(this.options(), LEVEL_THREE_CATEGORY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public LevelTwoCategoryTokens extractMoreFromLevelThreeCategoryList(String idsSeperatedWithComma){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int levelThreeCategoryListSortCounter = 0;
	public LevelTwoCategoryTokens sortLevelThreeCategoryListWith(String field, String descOrAsc){
		addSortMoreOptions(LEVEL_THREE_CATEGORY_LIST,levelThreeCategoryListSortCounter++, field, descOrAsc);
		return this;
	}
	private int levelThreeCategoryListSearchCounter = 0;
	public LevelTwoCategoryTokens searchLevelThreeCategoryListWith(String field, String verb, String value){

		withLevelThreeCategoryList();
		addSearchMoreOptions(LEVEL_THREE_CATEGORY_LIST,levelThreeCategoryListSearchCounter++, field, verb, value);
		return this;
	}



	public LevelTwoCategoryTokens searchAllTextOfLevelThreeCategoryList(String verb, String value){
		String field = "id|name";
		addSearchMoreOptions(LEVEL_THREE_CATEGORY_LIST,levelThreeCategoryListSearchCounter++, field, verb, value);
		return this;
	}



	public LevelTwoCategoryTokens rowsPerPageOfLevelThreeCategoryList(int rowsPerPage){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelTwoCategoryTokens currentPageNumberOfLevelThreeCategoryList(int currentPageNumber){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelTwoCategoryTokens retainColumnsOfLevelThreeCategoryList(String[] columns){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelTwoCategoryTokens excludeColumnsOfLevelThreeCategoryList(String[] columns){
		addSimpleOptions(LEVEL_THREE_CATEGORY_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  LevelTwoCategoryTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfLevelThreeCategoryList(verb, value);
		return this;
	}
}

