
package com.doublechaintech.retailscm.provincecenterdepartment;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTokens;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeTokens;





public class ProvinceCenterDepartmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="provinceCenterDepartment";

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
	protected ProvinceCenterDepartmentTokens(){
		//ensure not initialized outside the class
	}
	public  static  ProvinceCenterDepartmentTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ProvinceCenterDepartmentTokens tokens = new ProvinceCenterDepartmentTokens(options);
		return tokens;

	}
	protected ProvinceCenterDepartmentTokens(Map<String,Object> options){
		this.options = options;
	}

	public ProvinceCenterDepartmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static ProvinceCenterDepartmentTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected ProvinceCenterDepartmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static ProvinceCenterDepartmentTokens start(){
		return new ProvinceCenterDepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public ProvinceCenterDepartmentTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static ProvinceCenterDepartmentTokens loadGroupTokens(String... groupNames){
    ProvinceCenterDepartmentTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, PROVINCECENTER, groupNames, new String[]{"default"});

  
     addToken(tokens, PROVINCE_CENTER_EMPLOYEE_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(ProvinceCenterDepartmentTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static ProvinceCenterDepartmentTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withProvinceCenter()
			.withProvinceCenterEmployeeListIfViewGroupInclude(viewGroups);

	}

	public static ProvinceCenterDepartmentTokens allTokens(){

		return start()
			.withProvinceCenter()
			.withProvinceCenterEmployeeList();

	}
	public static ProvinceCenterDepartmentTokens withoutListsTokens(){

		return start()
			.withProvinceCenter();

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

	public ProvinceCenterDepartmentTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PROVINCECENTER = "provinceCenter";
	public String getProvinceCenter(){
		return PROVINCECENTER;
	}
	//
	public ProvinceCenterDepartmentTokens withProvinceCenter(){
		addSimpleOptions(PROVINCECENTER);
		return this;
	}

	public RetailStoreProvinceCenterTokens withProvinceCenterTokens(){
		//addSimpleOptions(PROVINCECENTER);
		return RetailStoreProvinceCenterTokens.start();
	}

	
	protected static final String PROVINCE_CENTER_EMPLOYEE_LIST = "provinceCenterEmployeeList";
	public String getProvinceCenterEmployeeList(){
		return PROVINCE_CENTER_EMPLOYEE_LIST;
	}



	public ProvinceCenterDepartmentTokens withProvinceCenterEmployeeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		}
		return this;
	}


	public ProvinceCenterDepartmentTokens withProvinceCenterEmployeeList(){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		return this;
	}

	public ProvinceCenterEmployeeTokens withProvinceCenterEmployeeListTokens(){
		//addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		return ProvinceCenterEmployeeTokens.start();
	}

	public ProvinceCenterDepartmentTokens analyzeProvinceCenterEmployeeList(){
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
	public ProvinceCenterDepartmentTokens extractMoreFromProvinceCenterEmployeeList(String idsSeperatedWithComma){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int provinceCenterEmployeeListSortCounter = 0;
	public ProvinceCenterDepartmentTokens sortProvinceCenterEmployeeListWith(String field, String descOrAsc){
		addSortMoreOptions(PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterEmployeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int provinceCenterEmployeeListSearchCounter = 0;
	public ProvinceCenterDepartmentTokens searchProvinceCenterEmployeeListWith(String field, String verb, String value){

		withProvinceCenterEmployeeList();
		addSearchMoreOptions(PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}



	public ProvinceCenterDepartmentTokens searchAllTextOfProvinceCenterEmployeeList(String verb, String value){
		String field = "id|name|mobile|email";
		addSearchMoreOptions(PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}



	public ProvinceCenterDepartmentTokens rowsPerPageOfProvinceCenterEmployeeList(int rowsPerPage){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProvinceCenterDepartmentTokens currentPageNumberOfProvinceCenterEmployeeList(int currentPageNumber){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProvinceCenterDepartmentTokens retainColumnsOfProvinceCenterEmployeeList(String[] columns){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public ProvinceCenterDepartmentTokens excludeColumnsOfProvinceCenterEmployeeList(String[] columns){
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  ProvinceCenterDepartmentTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfProvinceCenterEmployeeList(verb, value);
		return this;
	}
}

