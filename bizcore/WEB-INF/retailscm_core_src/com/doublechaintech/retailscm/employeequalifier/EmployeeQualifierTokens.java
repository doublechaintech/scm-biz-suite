
package com.doublechaintech.retailscm.employeequalifier;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class EmployeeQualifierTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employeeQualifier";
	
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
	protected EmployeeQualifierTokens(){
		//ensure not initialized outside the class
	}
	
	public EmployeeQualifierTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeeQualifierTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeeQualifierTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static EmployeeQualifierTokens start(){
		return new EmployeeQualifierTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static EmployeeQualifierTokens allTokens(){
		
		return start()
			.withEmployee();
	
	}
	public static EmployeeQualifierTokens withoutListsTokens(){
		
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

	protected static final String EMPLOYEE = "employee";
	public String getEmployee(){
		return EMPLOYEE;
	}
	public EmployeeQualifierTokens withEmployee(){		
		addSimpleOptions(EMPLOYEE);
		return this;
	}
	
	
	
	public  EmployeeQualifierTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

