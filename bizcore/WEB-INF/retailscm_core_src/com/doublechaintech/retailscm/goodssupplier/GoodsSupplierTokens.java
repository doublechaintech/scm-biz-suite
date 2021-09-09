
package com.doublechaintech.retailscm.goodssupplier;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductTokens;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderTokens;
import com.doublechaintech.retailscm.accountset.AccountSetTokens;





public class GoodsSupplierTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsSupplier";

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
	protected GoodsSupplierTokens(){
		//ensure not initialized outside the class
	}
	public  static  GoodsSupplierTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GoodsSupplierTokens tokens = new GoodsSupplierTokens(options);
		return tokens;

	}
	protected GoodsSupplierTokens(Map<String,Object> options){
		this.options = options;
	}

	public GoodsSupplierTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static GoodsSupplierTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected GoodsSupplierTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static GoodsSupplierTokens start(){
		return new GoodsSupplierTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public GoodsSupplierTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static GoodsSupplierTokens loadGroupTokens(String... groupNames){
    GoodsSupplierTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, BELONGTO, groupNames, new String[]{"default"});

  
     addToken(tokens, SUPPLIER_PRODUCT_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SUPPLY_ORDER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, ACCOUNT_SET_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(GoodsSupplierTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static GoodsSupplierTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withBelongTo()
			.withSupplierProductListIfViewGroupInclude(viewGroups)
			.withSupplyOrderListIfViewGroupInclude(viewGroups)
			.withAccountSetListIfViewGroupInclude(viewGroups);

	}

	public static GoodsSupplierTokens allTokens(){

		return start()
			.withBelongTo()
			.withSupplierProductList()
			.withSupplyOrderList()
			.withAccountSetList();

	}
	public static GoodsSupplierTokens withoutListsTokens(){

		return start()
			.withBelongTo();

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

	public GoodsSupplierTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BELONGTO = "belongTo";
	public String getBelongTo(){
		return BELONGTO;
	}
	//
	public GoodsSupplierTokens withBelongTo(){
		addSimpleOptions(BELONGTO);
		return this;
	}

	public RetailStoreCountryCenterTokens withBelongToTokens(){
		//addSimpleOptions(BELONGTO);
		return RetailStoreCountryCenterTokens.start();
	}

	
	protected static final String SUPPLIER_PRODUCT_LIST = "supplierProductList";
	public String getSupplierProductList(){
		return SUPPLIER_PRODUCT_LIST;
	}



	public GoodsSupplierTokens withSupplierProductListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SUPPLIER_PRODUCT_LIST);
		}
		return this;
	}


	public GoodsSupplierTokens withSupplierProductList(){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST);
		return this;
	}

	public SupplierProductTokens withSupplierProductListTokens(){
		//addSimpleOptions(SUPPLIER_PRODUCT_LIST);
		return SupplierProductTokens.start();
	}

	public GoodsSupplierTokens analyzeSupplierProductList(){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplierProductListEnabled(){

		if(checkOptions(this.options(), SUPPLIER_PRODUCT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsSupplierTokens extractMoreFromSupplierProductList(String idsSeperatedWithComma){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int supplierProductListSortCounter = 0;
	public GoodsSupplierTokens sortSupplierProductListWith(String field, String descOrAsc){
		addSortMoreOptions(SUPPLIER_PRODUCT_LIST,supplierProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplierProductListSearchCounter = 0;
	public GoodsSupplierTokens searchSupplierProductListWith(String field, String verb, String value){

		withSupplierProductList();
		addSearchMoreOptions(SUPPLIER_PRODUCT_LIST,supplierProductListSearchCounter++, field, verb, value);
		return this;
	}



	public GoodsSupplierTokens searchAllTextOfSupplierProductList(String verb, String value){
		String field = "id|productName|productDescription|productUnit";
		addSearchMoreOptions(SUPPLIER_PRODUCT_LIST,supplierProductListSearchCounter++, field, verb, value);
		return this;
	}



	public GoodsSupplierTokens rowsPerPageOfSupplierProductList(int rowsPerPage){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsSupplierTokens currentPageNumberOfSupplierProductList(int currentPageNumber){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsSupplierTokens retainColumnsOfSupplierProductList(String[] columns){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsSupplierTokens excludeColumnsOfSupplierProductList(String[] columns){
		addSimpleOptions(SUPPLIER_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}



	public GoodsSupplierTokens withSupplyOrderListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SUPPLY_ORDER_LIST);
		}
		return this;
	}


	public GoodsSupplierTokens withSupplyOrderList(){
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}

	public SupplyOrderTokens withSupplyOrderListTokens(){
		//addSimpleOptions(SUPPLY_ORDER_LIST);
		return SupplyOrderTokens.start();
	}

	public GoodsSupplierTokens analyzeSupplyOrderList(){
		addSimpleOptions(SUPPLY_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplyOrderListEnabled(){

		if(checkOptions(this.options(), SUPPLY_ORDER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsSupplierTokens extractMoreFromSupplyOrderList(String idsSeperatedWithComma){
		addSimpleOptions(SUPPLY_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int supplyOrderListSortCounter = 0;
	public GoodsSupplierTokens sortSupplyOrderListWith(String field, String descOrAsc){
		addSortMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderListSearchCounter = 0;
	public GoodsSupplierTokens searchSupplyOrderListWith(String field, String verb, String value){

		withSupplyOrderList();
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}



	public GoodsSupplierTokens searchAllTextOfSupplyOrderList(String verb, String value){
		String field = "id|title";
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}



	public GoodsSupplierTokens rowsPerPageOfSupplyOrderList(int rowsPerPage){
		addSimpleOptions(SUPPLY_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsSupplierTokens currentPageNumberOfSupplyOrderList(int currentPageNumber){
		addSimpleOptions(SUPPLY_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsSupplierTokens retainColumnsOfSupplyOrderList(String[] columns){
		addSimpleOptions(SUPPLY_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsSupplierTokens excludeColumnsOfSupplyOrderList(String[] columns){
		addSimpleOptions(SUPPLY_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String ACCOUNT_SET_LIST = "accountSetList";
	public String getAccountSetList(){
		return ACCOUNT_SET_LIST;
	}



	public GoodsSupplierTokens withAccountSetListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(ACCOUNT_SET_LIST);
		}
		return this;
	}


	public GoodsSupplierTokens withAccountSetList(){
		addSimpleOptions(ACCOUNT_SET_LIST);
		return this;
	}

	public AccountSetTokens withAccountSetListTokens(){
		//addSimpleOptions(ACCOUNT_SET_LIST);
		return AccountSetTokens.start();
	}

	public GoodsSupplierTokens analyzeAccountSetList(){
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
	public GoodsSupplierTokens extractMoreFromAccountSetList(String idsSeperatedWithComma){
		addSimpleOptions(ACCOUNT_SET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int accountSetListSortCounter = 0;
	public GoodsSupplierTokens sortAccountSetListWith(String field, String descOrAsc){
		addSortMoreOptions(ACCOUNT_SET_LIST,accountSetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountSetListSearchCounter = 0;
	public GoodsSupplierTokens searchAccountSetListWith(String field, String verb, String value){

		withAccountSetList();
		addSearchMoreOptions(ACCOUNT_SET_LIST,accountSetListSearchCounter++, field, verb, value);
		return this;
	}



	public GoodsSupplierTokens searchAllTextOfAccountSetList(String verb, String value){
		String field = "id|name|yearSet|accountingSystem|domesticCurrencyCode|domesticCurrencyName|openingBank|accountNumber";
		addSearchMoreOptions(ACCOUNT_SET_LIST,accountSetListSearchCounter++, field, verb, value);
		return this;
	}



	public GoodsSupplierTokens rowsPerPageOfAccountSetList(int rowsPerPage){
		addSimpleOptions(ACCOUNT_SET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsSupplierTokens currentPageNumberOfAccountSetList(int currentPageNumber){
		addSimpleOptions(ACCOUNT_SET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsSupplierTokens retainColumnsOfAccountSetList(String[] columns){
		addSimpleOptions(ACCOUNT_SET_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsSupplierTokens excludeColumnsOfAccountSetList(String[] columns){
		addSimpleOptions(ACCOUNT_SET_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  GoodsSupplierTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfSupplierProductList(verb, value);
		searchAllTextOfSupplyOrderList(verb, value);
		searchAllTextOfAccountSetList(verb, value);
		return this;
	}
}

