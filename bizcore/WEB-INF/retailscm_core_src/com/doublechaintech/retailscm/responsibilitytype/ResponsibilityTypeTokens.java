
package com.doublechaintech.retailscm.responsibilitytype;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.employee.EmployeeTokens;





public class ResponsibilityTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="responsibilityType";

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
	protected ResponsibilityTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  ResponsibilityTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ResponsibilityTypeTokens tokens = new ResponsibilityTypeTokens(options);
		return tokens;

	}
	protected ResponsibilityTypeTokens(Map<String,Object> options){
		this.options = options;
	}

	public ResponsibilityTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static ResponsibilityTypeTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected ResponsibilityTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static ResponsibilityTypeTokens start(){
		return new ResponsibilityTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public ResponsibilityTypeTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static ResponsibilityTypeTokens loadGroupTokens(String... groupNames){
    ResponsibilityTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[]{"default"});

  
     addToken(tokens, EMPLOYEE_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(ResponsibilityTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static ResponsibilityTypeTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCompany()
			.withEmployeeListIfViewGroupInclude(viewGroups);

	}

	public static ResponsibilityTypeTokens allTokens(){

		return start()
			.withCompany()
			.withEmployeeList();

	}
	public static ResponsibilityTypeTokens withoutListsTokens(){

		return start()
			.withCompany();

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

	public ResponsibilityTypeTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	//
	public ResponsibilityTypeTokens withCompany(){
		addSimpleOptions(COMPANY);
		return this;
	}

	public RetailStoreCountryCenterTokens withCompanyTokens(){
		//addSimpleOptions(COMPANY);
		return RetailStoreCountryCenterTokens.start();
	}

	
	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}



	public ResponsibilityTypeTokens withEmployeeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(EMPLOYEE_LIST);
		}
		return this;
	}


	public ResponsibilityTypeTokens withEmployeeList(){
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}

	public EmployeeTokens withEmployeeListTokens(){
		//addSimpleOptions(EMPLOYEE_LIST);
		return EmployeeTokens.start();
	}

	public ResponsibilityTypeTokens analyzeEmployeeList(){
		addSimpleOptions(EMPLOYEE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEmployeeListEnabled(){

		if(checkOptions(this.options(), EMPLOYEE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ResponsibilityTypeTokens extractMoreFromEmployeeList(String idsSeperatedWithComma){
		addSimpleOptions(EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int employeeListSortCounter = 0;
	public ResponsibilityTypeTokens sortEmployeeListWith(String field, String descOrAsc){
		addSortMoreOptions(EMPLOYEE_LIST,employeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeListSearchCounter = 0;
	public ResponsibilityTypeTokens searchEmployeeListWith(String field, String verb, String value){

		withEmployeeList();
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}



	public ResponsibilityTypeTokens searchAllTextOfEmployeeList(String verb, String value){
		String field = "id|title|familyName|givenName|email|city|address|cellPhone|salaryAccount";
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}



	public ResponsibilityTypeTokens rowsPerPageOfEmployeeList(int rowsPerPage){
		addSimpleOptions(EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ResponsibilityTypeTokens currentPageNumberOfEmployeeList(int currentPageNumber){
		addSimpleOptions(EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ResponsibilityTypeTokens retainColumnsOfEmployeeList(String[] columns){
		addSimpleOptions(EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public ResponsibilityTypeTokens excludeColumnsOfEmployeeList(String[] columns){
		addSimpleOptions(EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  ResponsibilityTypeTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfEmployeeList(verb, value);
		return this;
	}
}

