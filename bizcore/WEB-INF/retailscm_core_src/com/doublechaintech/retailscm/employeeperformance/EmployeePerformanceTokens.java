
package com.doublechaintech.retailscm.employeeperformance;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class EmployeePerformanceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employeePerformance";
	
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
	protected EmployeePerformanceTokens(){
		//ensure not initialized outside the class
	}
	public  static  EmployeePerformanceTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		EmployeePerformanceTokens tokens = new EmployeePerformanceTokens(options);
		return tokens;
		
	}
	protected EmployeePerformanceTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public EmployeePerformanceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeePerformanceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeePerformanceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static EmployeePerformanceTokens start(){
		return new EmployeePerformanceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public EmployeePerformanceTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static EmployeePerformanceTokens allTokens(){
		
		return start()
			.withEmployee();
	
	}
	public static EmployeePerformanceTokens withoutListsTokens(){
		
		return start()
			.withEmployee();
	
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
	
	public EmployeePerformanceTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EMPLOYEE = "employee";
	public String getEmployee(){
		return EMPLOYEE;
	}
	public EmployeePerformanceTokens withEmployee(){		
		addSimpleOptions(EMPLOYEE);
		return this;
	}
	
	
	
	public  EmployeePerformanceTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

