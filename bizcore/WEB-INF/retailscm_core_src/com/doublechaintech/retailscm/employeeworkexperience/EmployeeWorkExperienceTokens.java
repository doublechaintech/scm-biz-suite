
package com.doublechaintech.retailscm.employeeworkexperience;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class EmployeeWorkExperienceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employeeWorkExperience";
	
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
	protected EmployeeWorkExperienceTokens(){
		//ensure not initialized outside the class
	}
	public  static  EmployeeWorkExperienceTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		EmployeeWorkExperienceTokens tokens = new EmployeeWorkExperienceTokens(options);
		return tokens;
		
	}
	protected EmployeeWorkExperienceTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public EmployeeWorkExperienceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeeWorkExperienceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeeWorkExperienceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static EmployeeWorkExperienceTokens start(){
		return new EmployeeWorkExperienceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public EmployeeWorkExperienceTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static EmployeeWorkExperienceTokens allTokens(){
		
		return start()
			.withEmployee();
	
	}
	public static EmployeeWorkExperienceTokens withoutListsTokens(){
		
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
	
	public EmployeeWorkExperienceTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EMPLOYEE = "employee";
	public String getEmployee(){
		return EMPLOYEE;
	}
	public EmployeeWorkExperienceTokens withEmployee(){		
		addSimpleOptions(EMPLOYEE);
		return this;
	}
	
	
	
	public  EmployeeWorkExperienceTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

