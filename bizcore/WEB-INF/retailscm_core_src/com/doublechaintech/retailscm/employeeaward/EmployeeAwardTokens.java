
package com.doublechaintech.retailscm.employeeaward;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class EmployeeAwardTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employeeAward";
	
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
	protected EmployeeAwardTokens(){
		//ensure not initialized outside the class
	}
	public  static  EmployeeAwardTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		EmployeeAwardTokens tokens = new EmployeeAwardTokens(options);
		return tokens;
		
	}
	protected EmployeeAwardTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public EmployeeAwardTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeeAwardTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeeAwardTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static EmployeeAwardTokens start(){
		return new EmployeeAwardTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public EmployeeAwardTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static EmployeeAwardTokens allTokens(){
		
		return start()
			.withEmployee();
	
	}
	public static EmployeeAwardTokens withoutListsTokens(){
		
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
	
	public EmployeeAwardTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EMPLOYEE = "employee";
	public String getEmployee(){
		return EMPLOYEE;
	}
	public EmployeeAwardTokens withEmployee(){		
		addSimpleOptions(EMPLOYEE);
		return this;
	}
	
	
	
	public  EmployeeAwardTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

