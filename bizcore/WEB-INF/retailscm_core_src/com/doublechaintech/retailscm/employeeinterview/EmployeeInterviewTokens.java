
package com.doublechaintech.retailscm.employeeinterview;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class EmployeeInterviewTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employeeInterview";
	
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
	protected EmployeeInterviewTokens(){
		//ensure not initialized outside the class
	}
	public  static  EmployeeInterviewTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		EmployeeInterviewTokens tokens = new EmployeeInterviewTokens(options);
		return tokens;
		
	}
	protected EmployeeInterviewTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public EmployeeInterviewTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeeInterviewTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeeInterviewTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static EmployeeInterviewTokens start(){
		return new EmployeeInterviewTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public EmployeeInterviewTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static EmployeeInterviewTokens allTokens(){
		
		return start()
			.withEmployee()
			.withInterviewType();
	
	}
	public static EmployeeInterviewTokens withoutListsTokens(){
		
		return start()
			.withEmployee()
			.withInterviewType();
	
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
	
	public EmployeeInterviewTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EMPLOYEE = "employee";
	public String getEmployee(){
		return EMPLOYEE;
	}
	public EmployeeInterviewTokens withEmployee(){		
		addSimpleOptions(EMPLOYEE);
		return this;
	}
	
	
	protected static final String INTERVIEWTYPE = "interviewType";
	public String getInterviewType(){
		return INTERVIEWTYPE;
	}
	public EmployeeInterviewTokens withInterviewType(){		
		addSimpleOptions(INTERVIEWTYPE);
		return this;
	}
	
	
	
	public  EmployeeInterviewTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

