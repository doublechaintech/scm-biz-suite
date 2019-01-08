
package com.doublechaintech.retailscm.jobapplication;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class JobApplicationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="jobApplication";
	
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
	protected JobApplicationTokens(){
		//ensure not initialized outside the class
	}
	
	public JobApplicationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static JobApplicationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected JobApplicationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static JobApplicationTokens start(){
		return new JobApplicationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static JobApplicationTokens allTokens(){
		
		return start()
			.withEmployeeList();
	
	}
	public static JobApplicationTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}
	public JobApplicationTokens withEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}
	public JobApplicationTokens analyzeEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEmployeeListEnabled(){		
		
		return checkOptions(this.options(), EMPLOYEE_LIST+".anaylze");
	}
	public JobApplicationTokens extractMoreFromEmployeeList(String idsSeperatedWithComma){		
		addSimpleOptions(EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int employeeListSortCounter = 0;
	public JobApplicationTokens sortEmployeeListWith(String field, String descOrAsc){		
		addSortMoreOptions(EMPLOYEE_LIST,employeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeListSearchCounter = 0;
	public JobApplicationTokens searchEmployeeListWith(String field, String verb, String value){		
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}
	
	public JobApplicationTokens searchAllTextOfEmployeeList(String verb, String value){	
		String field = "id|title|familyName|givenName|email|city|address|cellPhone|salaryAccount|currentStatus";
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public JobApplicationTokens rowsPerPageOfEmployeeList(int rowsPerPage){		
		addSimpleOptions(EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public JobApplicationTokens currentPageNumberOfEmployeeList(int currentPageNumber){		
		addSimpleOptions(EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public JobApplicationTokens retainColumnsOfEmployeeList(String[] columns){		
		addSimpleOptions(EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public JobApplicationTokens excludeColumnsOfEmployeeList(String[] columns){		
		addSimpleOptions(EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  JobApplicationTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfEmployeeList(verb, value);	
		return this;
	}
}

