
package com.doublechaintech.retailscm.eventattendance;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class EventAttendanceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="eventAttendance";
	
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
	protected EventAttendanceTokens(){
		//ensure not initialized outside the class
	}
	public  static  EventAttendanceTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		EventAttendanceTokens tokens = new EventAttendanceTokens(options);
		return tokens;
		
	}
	protected EventAttendanceTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public EventAttendanceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EventAttendanceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EventAttendanceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static EventAttendanceTokens start(){
		return new EventAttendanceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public EventAttendanceTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static EventAttendanceTokens allTokens(){
		
		return start()
			.withPotentialCustomer()
			.withCityEvent();
	
	}
	public static EventAttendanceTokens withoutListsTokens(){
		
		return start()
			.withPotentialCustomer()
			.withCityEvent();
	
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
	
	public EventAttendanceTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String POTENTIALCUSTOMER = "potentialCustomer";
	public String getPotentialCustomer(){
		return POTENTIALCUSTOMER;
	}
	public EventAttendanceTokens withPotentialCustomer(){		
		addSimpleOptions(POTENTIALCUSTOMER);
		return this;
	}
	
	
	protected static final String CITYEVENT = "cityEvent";
	public String getCityEvent(){
		return CITYEVENT;
	}
	public EventAttendanceTokens withCityEvent(){		
		addSimpleOptions(CITYEVENT);
		return this;
	}
	
	
	
	public  EventAttendanceTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

