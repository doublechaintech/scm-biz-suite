
package com.doublechaintech.retailscm.payingoff;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class PayingOffTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="payingOff";
	
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
	protected PayingOffTokens(){
		//ensure not initialized outside the class
	}
	public  static  PayingOffTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PayingOffTokens tokens = new PayingOffTokens(options);
		return tokens;
		
	}
	protected PayingOffTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PayingOffTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PayingOffTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PayingOffTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static PayingOffTokens start(){
		return new PayingOffTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public PayingOffTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static PayingOffTokens allTokens(){
		
		return start()
			.withPaidFor()
			.withEmployeeSalarySheetList();
	
	}
	public static PayingOffTokens withoutListsTokens(){
		
		return start()
			.withPaidFor();
	
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
	
	public PayingOffTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PAIDFOR = "paidFor";
	public String getPaidFor(){
		return PAIDFOR;
	}
	public PayingOffTokens withPaidFor(){		
		addSimpleOptions(PAIDFOR);
		return this;
	}
	
	
	protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	public String getEmployeeSalarySheetList(){
		return EMPLOYEE_SALARY_SHEET_LIST;
	}
	public PayingOffTokens withEmployeeSalarySheetList(){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
		return this;
	}
	public PayingOffTokens analyzeEmployeeSalarySheetList(){		
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
	public PayingOffTokens extractMoreFromEmployeeSalarySheetList(String idsSeperatedWithComma){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int employeeSalarySheetListSortCounter = 0;
	public PayingOffTokens sortEmployeeSalarySheetListWith(String field, String descOrAsc){		
		addSortMoreOptions(EMPLOYEE_SALARY_SHEET_LIST,employeeSalarySheetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeSalarySheetListSearchCounter = 0;
	public PayingOffTokens searchEmployeeSalarySheetListWith(String field, String verb, String value){		
		
		withEmployeeSalarySheetList();
		addSearchMoreOptions(EMPLOYEE_SALARY_SHEET_LIST,employeeSalarySheetListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PayingOffTokens searchAllTextOfEmployeeSalarySheetList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(EMPLOYEE_SALARY_SHEET_LIST,employeeSalarySheetListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PayingOffTokens rowsPerPageOfEmployeeSalarySheetList(int rowsPerPage){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PayingOffTokens currentPageNumberOfEmployeeSalarySheetList(int currentPageNumber){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PayingOffTokens retainColumnsOfEmployeeSalarySheetList(String[] columns){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"RetainColumns",columns);
		return this;
	}
	public PayingOffTokens excludeColumnsOfEmployeeSalarySheetList(String[] columns){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PayingOffTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfEmployeeSalarySheetList(verb, value);	
		return this;
	}
}

