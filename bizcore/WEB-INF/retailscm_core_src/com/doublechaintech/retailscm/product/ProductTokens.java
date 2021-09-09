
package com.doublechaintech.retailscm.product;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryTokens;
import com.doublechaintech.retailscm.sku.SkuTokens;





public class ProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="product";

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
	protected ProductTokens(){
		//ensure not initialized outside the class
	}
	public  static  ProductTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ProductTokens tokens = new ProductTokens(options);
		return tokens;

	}
	protected ProductTokens(Map<String,Object> options){
		this.options = options;
	}

	public ProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static ProductTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected ProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static ProductTokens start(){
		return new ProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public ProductTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static ProductTokens loadGroupTokens(String... groupNames){
    ProductTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, PARENTCATEGORY, groupNames, new String[]{"default"});

  
     addToken(tokens, SKU_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(ProductTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static ProductTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withParentCategory()
			.withSkuListIfViewGroupInclude(viewGroups);

	}

	public static ProductTokens allTokens(){

		return start()
			.withParentCategory()
			.withSkuList();

	}
	public static ProductTokens withoutListsTokens(){

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

	public ProductTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	//
	public ProductTokens withParentCategory(){
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}

	public LevelThreeCategoryTokens withParentCategoryTokens(){
		//addSimpleOptions(PARENTCATEGORY);
		return LevelThreeCategoryTokens.start();
	}

	
	protected static final String SKU_LIST = "skuList";
	public String getSkuList(){
		return SKU_LIST;
	}



	public ProductTokens withSkuListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SKU_LIST);
		}
		return this;
	}


	public ProductTokens withSkuList(){
		addSimpleOptions(SKU_LIST);
		return this;
	}

	public SkuTokens withSkuListTokens(){
		//addSimpleOptions(SKU_LIST);
		return SkuTokens.start();
	}

	public ProductTokens analyzeSkuList(){
		addSimpleOptions(SKU_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSkuListEnabled(){

		if(checkOptions(this.options(), SKU_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ProductTokens extractMoreFromSkuList(String idsSeperatedWithComma){
		addSimpleOptions(SKU_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int skuListSortCounter = 0;
	public ProductTokens sortSkuListWith(String field, String descOrAsc){
		addSortMoreOptions(SKU_LIST,skuListSortCounter++, field, descOrAsc);
		return this;
	}
	private int skuListSearchCounter = 0;
	public ProductTokens searchSkuListWith(String field, String verb, String value){

		withSkuList();
		addSearchMoreOptions(SKU_LIST,skuListSearchCounter++, field, verb, value);
		return this;
	}



	public ProductTokens searchAllTextOfSkuList(String verb, String value){
		String field = "id|name|size|barcode|packageType|netContent";
		addSearchMoreOptions(SKU_LIST,skuListSearchCounter++, field, verb, value);
		return this;
	}



	public ProductTokens rowsPerPageOfSkuList(int rowsPerPage){
		addSimpleOptions(SKU_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProductTokens currentPageNumberOfSkuList(int currentPageNumber){
		addSimpleOptions(SKU_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProductTokens retainColumnsOfSkuList(String[] columns){
		addSimpleOptions(SKU_LIST+"RetainColumns",columns);
		return this;
	}
	public ProductTokens excludeColumnsOfSkuList(String[] columns){
		addSimpleOptions(SKU_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  ProductTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfSkuList(verb, value);
		return this;
	}
}

