
package com.doublechaintech.retailscm.retailstorecityservicecenter;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTokens;
import com.doublechaintech.retailscm.citypartner.CityPartnerTokens;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerTokens;
import com.doublechaintech.retailscm.cityevent.CityEventTokens;
import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;





public class RetailStoreCityServiceCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreCityServiceCenter";

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
	protected RetailStoreCityServiceCenterTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreCityServiceCenterTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreCityServiceCenterTokens tokens = new RetailStoreCityServiceCenterTokens(options);
		return tokens;

	}
	protected RetailStoreCityServiceCenterTokens(Map<String,Object> options){
		this.options = options;
	}

	public RetailStoreCityServiceCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static RetailStoreCityServiceCenterTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected RetailStoreCityServiceCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static RetailStoreCityServiceCenterTokens start(){
		return new RetailStoreCityServiceCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public RetailStoreCityServiceCenterTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static RetailStoreCityServiceCenterTokens loadGroupTokens(String... groupNames){
    RetailStoreCityServiceCenterTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, BELONGSTO, groupNames, new String[]{"default"});

  
     addToken(tokens, CITY_PARTNER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, POTENTIAL_CUSTOMER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, CITY_EVENT_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RETAIL_STORE_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(RetailStoreCityServiceCenterTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static RetailStoreCityServiceCenterTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withBelongsTo()
			.withCityPartnerListIfViewGroupInclude(viewGroups)
			.withPotentialCustomerListIfViewGroupInclude(viewGroups)
			.withCityEventListIfViewGroupInclude(viewGroups)
			.withRetailStoreListIfViewGroupInclude(viewGroups);

	}

	public static RetailStoreCityServiceCenterTokens allTokens(){

		return start()
			.withBelongsTo()
			.withCityPartnerList()
			.withPotentialCustomerList()
			.withCityEventList()
			.withRetailStoreList();

	}
	public static RetailStoreCityServiceCenterTokens withoutListsTokens(){

		return start()
			.withBelongsTo();

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

	public RetailStoreCityServiceCenterTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	//
	public RetailStoreCityServiceCenterTokens withBelongsTo(){
		addSimpleOptions(BELONGSTO);
		return this;
	}

	public RetailStoreProvinceCenterTokens withBelongsToTokens(){
		//addSimpleOptions(BELONGSTO);
		return RetailStoreProvinceCenterTokens.start();
	}

	
	protected static final String CITY_PARTNER_LIST = "cityPartnerList";
	public String getCityPartnerList(){
		return CITY_PARTNER_LIST;
	}



	public RetailStoreCityServiceCenterTokens withCityPartnerListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(CITY_PARTNER_LIST);
		}
		return this;
	}


	public RetailStoreCityServiceCenterTokens withCityPartnerList(){
		addSimpleOptions(CITY_PARTNER_LIST);
		return this;
	}

	public CityPartnerTokens withCityPartnerListTokens(){
		//addSimpleOptions(CITY_PARTNER_LIST);
		return CityPartnerTokens.start();
	}

	public RetailStoreCityServiceCenterTokens analyzeCityPartnerList(){
		addSimpleOptions(CITY_PARTNER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityPartnerListEnabled(){

		if(checkOptions(this.options(), CITY_PARTNER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCityServiceCenterTokens extractMoreFromCityPartnerList(String idsSeperatedWithComma){
		addSimpleOptions(CITY_PARTNER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int cityPartnerListSortCounter = 0;
	public RetailStoreCityServiceCenterTokens sortCityPartnerListWith(String field, String descOrAsc){
		addSortMoreOptions(CITY_PARTNER_LIST,cityPartnerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityPartnerListSearchCounter = 0;
	public RetailStoreCityServiceCenterTokens searchCityPartnerListWith(String field, String verb, String value){

		withCityPartnerList();
		addSearchMoreOptions(CITY_PARTNER_LIST,cityPartnerListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens searchAllTextOfCityPartnerList(String verb, String value){
		String field = "id|name|mobile|description";
		addSearchMoreOptions(CITY_PARTNER_LIST,cityPartnerListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens rowsPerPageOfCityPartnerList(int rowsPerPage){
		addSimpleOptions(CITY_PARTNER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCityServiceCenterTokens currentPageNumberOfCityPartnerList(int currentPageNumber){
		addSimpleOptions(CITY_PARTNER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCityServiceCenterTokens retainColumnsOfCityPartnerList(String[] columns){
		addSimpleOptions(CITY_PARTNER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCityServiceCenterTokens excludeColumnsOfCityPartnerList(String[] columns){
		addSimpleOptions(CITY_PARTNER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	public String getPotentialCustomerList(){
		return POTENTIAL_CUSTOMER_LIST;
	}



	public RetailStoreCityServiceCenterTokens withPotentialCustomerListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		}
		return this;
	}


	public RetailStoreCityServiceCenterTokens withPotentialCustomerList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return this;
	}

	public PotentialCustomerTokens withPotentialCustomerListTokens(){
		//addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return PotentialCustomerTokens.start();
	}

	public RetailStoreCityServiceCenterTokens analyzePotentialCustomerList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+".anaylze");
		return this;
	}
	public boolean analyzePotentialCustomerListEnabled(){

		if(checkOptions(this.options(), POTENTIAL_CUSTOMER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCityServiceCenterTokens extractMoreFromPotentialCustomerList(String idsSeperatedWithComma){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int potentialCustomerListSortCounter = 0;
	public RetailStoreCityServiceCenterTokens sortPotentialCustomerListWith(String field, String descOrAsc){
		addSortMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int potentialCustomerListSearchCounter = 0;
	public RetailStoreCityServiceCenterTokens searchPotentialCustomerListWith(String field, String verb, String value){

		withPotentialCustomerList();
		addSearchMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens searchAllTextOfPotentialCustomerList(String verb, String value){
		String field = "id|name|mobile|description";
		addSearchMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens rowsPerPageOfPotentialCustomerList(int rowsPerPage){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCityServiceCenterTokens currentPageNumberOfPotentialCustomerList(int currentPageNumber){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCityServiceCenterTokens retainColumnsOfPotentialCustomerList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCityServiceCenterTokens excludeColumnsOfPotentialCustomerList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String CITY_EVENT_LIST = "cityEventList";
	public String getCityEventList(){
		return CITY_EVENT_LIST;
	}



	public RetailStoreCityServiceCenterTokens withCityEventListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(CITY_EVENT_LIST);
		}
		return this;
	}


	public RetailStoreCityServiceCenterTokens withCityEventList(){
		addSimpleOptions(CITY_EVENT_LIST);
		return this;
	}

	public CityEventTokens withCityEventListTokens(){
		//addSimpleOptions(CITY_EVENT_LIST);
		return CityEventTokens.start();
	}

	public RetailStoreCityServiceCenterTokens analyzeCityEventList(){
		addSimpleOptions(CITY_EVENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityEventListEnabled(){

		if(checkOptions(this.options(), CITY_EVENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCityServiceCenterTokens extractMoreFromCityEventList(String idsSeperatedWithComma){
		addSimpleOptions(CITY_EVENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int cityEventListSortCounter = 0;
	public RetailStoreCityServiceCenterTokens sortCityEventListWith(String field, String descOrAsc){
		addSortMoreOptions(CITY_EVENT_LIST,cityEventListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityEventListSearchCounter = 0;
	public RetailStoreCityServiceCenterTokens searchCityEventListWith(String field, String verb, String value){

		withCityEventList();
		addSearchMoreOptions(CITY_EVENT_LIST,cityEventListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens searchAllTextOfCityEventList(String verb, String value){
		String field = "id|name|mobile|description";
		addSearchMoreOptions(CITY_EVENT_LIST,cityEventListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens rowsPerPageOfCityEventList(int rowsPerPage){
		addSimpleOptions(CITY_EVENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCityServiceCenterTokens currentPageNumberOfCityEventList(int currentPageNumber){
		addSimpleOptions(CITY_EVENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCityServiceCenterTokens retainColumnsOfCityEventList(String[] columns){
		addSimpleOptions(CITY_EVENT_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCityServiceCenterTokens excludeColumnsOfCityEventList(String[] columns){
		addSimpleOptions(CITY_EVENT_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RETAIL_STORE_LIST = "retailStoreList";
	public String getRetailStoreList(){
		return RETAIL_STORE_LIST;
	}



	public RetailStoreCityServiceCenterTokens withRetailStoreListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(RETAIL_STORE_LIST);
		}
		return this;
	}


	public RetailStoreCityServiceCenterTokens withRetailStoreList(){
		addSimpleOptions(RETAIL_STORE_LIST);
		return this;
	}

	public RetailStoreTokens withRetailStoreListTokens(){
		//addSimpleOptions(RETAIL_STORE_LIST);
		return RetailStoreTokens.start();
	}

	public RetailStoreCityServiceCenterTokens analyzeRetailStoreList(){
		addSimpleOptions(RETAIL_STORE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCityServiceCenterTokens extractMoreFromRetailStoreList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreListSortCounter = 0;
	public RetailStoreCityServiceCenterTokens sortRetailStoreListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_LIST,retailStoreListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreListSearchCounter = 0;
	public RetailStoreCityServiceCenterTokens searchRetailStoreListWith(String field, String verb, String value){

		withRetailStoreList();
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens searchAllTextOfRetailStoreList(String verb, String value){
		String field = "id|name|telephone|owner|description";
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCityServiceCenterTokens rowsPerPageOfRetailStoreList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCityServiceCenterTokens currentPageNumberOfRetailStoreList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCityServiceCenterTokens retainColumnsOfRetailStoreList(String[] columns){
		addSimpleOptions(RETAIL_STORE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCityServiceCenterTokens excludeColumnsOfRetailStoreList(String[] columns){
		addSimpleOptions(RETAIL_STORE_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  RetailStoreCityServiceCenterTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfCityPartnerList(verb, value);
		searchAllTextOfPotentialCustomerList(verb, value);
		searchAllTextOfCityEventList(verb, value);
		searchAllTextOfRetailStoreList(verb, value);
		return this;
	}
}

