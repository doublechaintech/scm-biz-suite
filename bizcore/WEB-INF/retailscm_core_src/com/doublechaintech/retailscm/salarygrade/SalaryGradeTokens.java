
package com.doublechaintech.retailscm.salarygrade;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.employee.EmployeeTokens;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetTokens;





public class SalaryGradeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="salaryGrade";

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
	protected SalaryGradeTokens(){
		//ensure not initialized outside the class
	}
	public  static  SalaryGradeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SalaryGradeTokens tokens = new SalaryGradeTokens(options);
		return tokens;

	}
	protected SalaryGradeTokens(Map<String,Object> options){
		this.options = options;
	}

	public SalaryGradeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static SalaryGradeTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected SalaryGradeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static SalaryGradeTokens start(){
		return new SalaryGradeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public SalaryGradeTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static SalaryGradeTokens loadGroupTokens(String... groupNames){
    SalaryGradeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[]{"default"});

  
     addToken(tokens, EMPLOYEE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, EMPLOYEE_SALARY_SHEET_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(SalaryGradeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static SalaryGradeTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCompany()
			.withEmployeeListIfViewGroupInclude(viewGroups)
			.withEmployeeSalarySheetListIfViewGroupInclude(viewGroups);

	}

	public static SalaryGradeTokens allTokens(){

		return start()
			.withCompany()
			.withEmployeeList()
			.withEmployeeSalarySheetList();

	}
	public static SalaryGradeTokens withoutListsTokens(){

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

	public SalaryGradeTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	//
	public SalaryGradeTokens withCompany(){
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



	public SalaryGradeTokens withEmployeeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(EMPLOYEE_LIST);
		}
		return this;
	}


	public SalaryGradeTokens withEmployeeList(){
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}

	public EmployeeTokens withEmployeeListTokens(){
		//addSimpleOptions(EMPLOYEE_LIST);
		return EmployeeTokens.start();
	}

	public SalaryGradeTokens analyzeEmployeeList(){
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
	public SalaryGradeTokens extractMoreFromEmployeeList(String idsSeperatedWithComma){
		addSimpleOptions(EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int employeeListSortCounter = 0;
	public SalaryGradeTokens sortEmployeeListWith(String field, String descOrAsc){
		addSortMoreOptions(EMPLOYEE_LIST,employeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeListSearchCounter = 0;
	public SalaryGradeTokens searchEmployeeListWith(String field, String verb, String value){

		withEmployeeList();
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}



	public SalaryGradeTokens searchAllTextOfEmployeeList(String verb, String value){
		String field = "id|title|familyName|givenName|email|city|address|cellPhone|salaryAccount";
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}



	public SalaryGradeTokens rowsPerPageOfEmployeeList(int rowsPerPage){
		addSimpleOptions(EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SalaryGradeTokens currentPageNumberOfEmployeeList(int currentPageNumber){
		addSimpleOptions(EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SalaryGradeTokens retainColumnsOfEmployeeList(String[] columns){
		addSimpleOptions(EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public SalaryGradeTokens excludeColumnsOfEmployeeList(String[] columns){
		addSimpleOptions(EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	public String getEmployeeSalarySheetList(){
		return EMPLOYEE_SALARY_SHEET_LIST;
	}



	public SalaryGradeTokens withEmployeeSalarySheetListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
		}
		return this;
	}


	public SalaryGradeTokens withEmployeeSalarySheetList(){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
		return this;
	}

	public EmployeeSalarySheetTokens withEmployeeSalarySheetListTokens(){
		//addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
		return EmployeeSalarySheetTokens.start();
	}

	public SalaryGradeTokens analyzeEmployeeSalarySheetList(){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEmployeeSalarySheetListEnabled(){

		if(checkOptions(this.options(), EMPLOYEE_SALARY_SHEET_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public SalaryGradeTokens extractMoreFromEmployeeSalarySheetList(String idsSeperatedWithComma){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int employeeSalarySheetListSortCounter = 0;
	public SalaryGradeTokens sortEmployeeSalarySheetListWith(String field, String descOrAsc){
		addSortMoreOptions(EMPLOYEE_SALARY_SHEET_LIST,employeeSalarySheetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeSalarySheetListSearchCounter = 0;
	public SalaryGradeTokens searchEmployeeSalarySheetListWith(String field, String verb, String value){

		withEmployeeSalarySheetList();
		addSearchMoreOptions(EMPLOYEE_SALARY_SHEET_LIST,employeeSalarySheetListSearchCounter++, field, verb, value);
		return this;
	}



	public SalaryGradeTokens searchAllTextOfEmployeeSalarySheetList(String verb, String value){
		String field = "id";
		addSearchMoreOptions(EMPLOYEE_SALARY_SHEET_LIST,employeeSalarySheetListSearchCounter++, field, verb, value);
		return this;
	}



	public SalaryGradeTokens rowsPerPageOfEmployeeSalarySheetList(int rowsPerPage){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SalaryGradeTokens currentPageNumberOfEmployeeSalarySheetList(int currentPageNumber){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SalaryGradeTokens retainColumnsOfEmployeeSalarySheetList(String[] columns){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"RetainColumns",columns);
		return this;
	}
	public SalaryGradeTokens excludeColumnsOfEmployeeSalarySheetList(String[] columns){
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  SalaryGradeTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfEmployeeList(verb, value);
		searchAllTextOfEmployeeSalarySheetList(verb, value);
		return this;
	}
}

