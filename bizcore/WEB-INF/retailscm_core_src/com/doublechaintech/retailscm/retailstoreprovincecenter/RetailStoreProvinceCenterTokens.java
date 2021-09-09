
package com.doublechaintech.retailscm.retailstoreprovincecenter;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTokens;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeTokens;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTokens;





public class RetailStoreProvinceCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreProvinceCenter";

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
	protected RetailStoreProvinceCenterTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreProvinceCenterTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreProvinceCenterTokens tokens = new RetailStoreProvinceCenterTokens(options);
		return tokens;

	}
	protected RetailStoreProvinceCenterTokens(Map<String,Object> options){
		this.options = options;
	}

	public RetailStoreProvinceCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static RetailStoreProvinceCenterTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected RetailStoreProvinceCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static RetailStoreProvinceCenterTokens start(){
		return new RetailStoreProvinceCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public RetailStoreProvinceCenterTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static RetailStoreProvinceCenterTokens loadGroupTokens(String... groupNames){
    RetailStoreProvinceCenterTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, COUNTRY, groupNames, new String[]{"default"});

  
     addToken(tokens, PROVINCE_CENTER_DEPARTMENT_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, PROVINCE_CENTER_EMPLOYEE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RETAIL_STORE_CITY_SERVICE_CENTER_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(RetailStoreProvinceCenterTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static RetailStoreProvinceCenterTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCountry()
			.withProvinceCenterDepartmentListIfViewGroupInclude(viewGroups)
			.withProvinceCenterEmployeeListIfViewGroupInclude(viewGroups)
			.withRetailStoreCityServiceCenterListIfViewGroupInclude(viewGroups);

	}

	public static RetailStoreProvinceCenterTokens allTokens(){

		return start()
			.withCountry()
			.withProvinceCenterDepartmentList()
			.withProvinceCenterEmployeeList()
			.withRetailStoreCityServiceCenterList();

	}
	public static RetailStoreProvinceCenterTokens withoutListsTokens(){

		return start()
			.withCountry();

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

	public RetailStoreProvinceCenterTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COUNTRY = "country";
	public String getCountry(){
		return COUNTRY;
	}
	//
	public RetailStoreProvinceCenterTokens withCountry(){
		addSimpleOptions(COUNTRY);
		return this;
	}

	public RetailStoreCountryCenterTokens withCountryTokens(){
		//addSimpleOptions(COUNTRY);
		return RetailStoreCountryCenterTokens.start();
	}

	
	protected static final String PROVINCE_CENTER_DEPARTMENT_LIST = "provinceCenterDepartmentList";
	public String getProvinceCenterDepartmentList(){
		return PROVINCE_CENTER_DEPARTMENT_LIST;
	}



	public RetailStoreProvinceCenterTokens withProvinceCenterDepartmentListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST);
		}
		return this;
	}


	public RetailStoreProvinceCenterTokens withProvinceCenterDepartmentList(){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST);
		return this;
	}

	public ProvinceCenterDepartmentTokens withProvinceCenterDepartmentListTokens(){
		//addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST);
		return ProvinceCenterDepartmentTokens.start();
	}

	public RetailStoreProvinceCenterTokens analyzeProvinceCenterDepartmentList(){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProvinceCenterDepartmentListEnabled(){

		if(checkOptions(this.options(), PROVINCE_CENTER_DEPARTMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreProvinceCenterTokens extractMoreFromProvinceCenterDepartmentList(String idsSeperatedWithComma){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int provinceCenterDepartmentListSortCounter = 0;
	public RetailStoreProvinceCenterTokens sortProvinceCenterDepartmentListWith(String field, String descOrAsc){
		addSortMoreOptions(PROVINCE_CENTER_DEPARTMENT_LIST,provinceCenterDepartmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int provinceCenterDepartmentListSearchCounter = 0;
	public RetailStoreProvinceCenterTokens searchProvinceCenterDepartmentListWith(String field, String verb, String value){

		withProvinceCenterDepartmentList();
		addSearchMoreOptions(PROVINCE_CENTER_DEPARTMENT_LIST,provinceCenterDepartmentListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreProvinceCenterTokens searchAllTextOfProvinceCenterDepartmentList(String verb, String value){
		String field = "id|name|manager";
		addSearchMoreOptions(PROVINCE_CENTER_DEPARTMENT_LIST,provinceCenterDepartmentListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreProvinceCenterTokens rowsPerPageOfProvinceCenterDepartmentList(int rowsPerPage){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreProvinceCenterTokens currentPageNumberOfProvinceCenterDepartmentList(int currentPageNumber){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreProvinceCenterTokens retainColumnsOfProvinceCenterDepartmentList(String[] columns){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreProvinceCenterTokens excludeColumnsOfProvinceCenterDepartmentList(String[] columns){
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String PROVINCE_CENTER_EMPLOYEE_LIST = "provinceCenterEmployeeList";
	public String getProvinceCenterEmployeeList(){
		return PROVINCE_CENTER_EMPLOYEE_LIST;
	}



	public RetailStoreProvinceCenterTokens withProvinceCenterEmployeeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		}
		return this;
	}


	public RetailStoreProvinceCenterTokens withProvinceCenterEmployeeList(){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		return this;
	}

	public ProvinceCenterEmployeeTokens withProvinceCenterEmployeeListTokens(){
		//addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		return ProvinceCenterEmployeeTokens.start();
	}

	public RetailStoreProvinceCenterTokens analyzeProvinceCenterEmployeeList(){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProvinceCenterEmployeeListEnabled(){

		if(checkOptions(this.options(), PROVINCE_CENTER_EMPLOYEE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreProvinceCenterTokens extractMoreFromProvinceCenterEmployeeList(String idsSeperatedWithComma){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int provinceCenterEmployeeListSortCounter = 0;
	public RetailStoreProvinceCenterTokens sortProvinceCenterEmployeeListWith(String field, String descOrAsc){
		addSortMoreOptions(PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterEmployeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int provinceCenterEmployeeListSearchCounter = 0;
	public RetailStoreProvinceCenterTokens searchProvinceCenterEmployeeListWith(String field, String verb, String value){

		withProvinceCenterEmployeeList();
		addSearchMoreOptions(PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreProvinceCenterTokens searchAllTextOfProvinceCenterEmployeeList(String verb, String value){
		String field = "id|name|mobile|email";
		addSearchMoreOptions(PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreProvinceCenterTokens rowsPerPageOfProvinceCenterEmployeeList(int rowsPerPage){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreProvinceCenterTokens currentPageNumberOfProvinceCenterEmployeeList(int currentPageNumber){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreProvinceCenterTokens retainColumnsOfProvinceCenterEmployeeList(String[] columns){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreProvinceCenterTokens excludeColumnsOfProvinceCenterEmployeeList(String[] columns){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RETAIL_STORE_CITY_SERVICE_CENTER_LIST = "retailStoreCityServiceCenterList";
	public String getRetailStoreCityServiceCenterList(){
		return RETAIL_STORE_CITY_SERVICE_CENTER_LIST;
	}



	public RetailStoreProvinceCenterTokens withRetailStoreCityServiceCenterListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		}
		return this;
	}


	public RetailStoreProvinceCenterTokens withRetailStoreCityServiceCenterList(){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		return this;
	}

	public RetailStoreCityServiceCenterTokens withRetailStoreCityServiceCenterListTokens(){
		//addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		return RetailStoreCityServiceCenterTokens.start();
	}

	public RetailStoreProvinceCenterTokens analyzeRetailStoreCityServiceCenterList(){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreCityServiceCenterListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_CITY_SERVICE_CENTER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreProvinceCenterTokens extractMoreFromRetailStoreCityServiceCenterList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreCityServiceCenterListSortCounter = 0;
	public RetailStoreProvinceCenterTokens sortRetailStoreCityServiceCenterListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST,retailStoreCityServiceCenterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreCityServiceCenterListSearchCounter = 0;
	public RetailStoreProvinceCenterTokens searchRetailStoreCityServiceCenterListWith(String field, String verb, String value){

		withRetailStoreCityServiceCenterList();
		addSearchMoreOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST,retailStoreCityServiceCenterListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreProvinceCenterTokens searchAllTextOfRetailStoreCityServiceCenterList(String verb, String value){
		String field = "id|name";
		addSearchMoreOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST,retailStoreCityServiceCenterListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreProvinceCenterTokens rowsPerPageOfRetailStoreCityServiceCenterList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreProvinceCenterTokens currentPageNumberOfRetailStoreCityServiceCenterList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreProvinceCenterTokens retainColumnsOfRetailStoreCityServiceCenterList(String[] columns){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreProvinceCenterTokens excludeColumnsOfRetailStoreCityServiceCenterList(String[] columns){
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  RetailStoreProvinceCenterTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfProvinceCenterDepartmentList(verb, value);
		searchAllTextOfProvinceCenterEmployeeList(verb, value);
		searchAllTextOfRetailStoreCityServiceCenterList(verb, value);
		return this;
	}
}

