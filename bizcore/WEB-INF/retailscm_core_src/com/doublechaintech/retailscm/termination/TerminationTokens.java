
package com.doublechaintech.retailscm.termination;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class TerminationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="termination";
	
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
	protected TerminationTokens(){
		//ensure not initialized outside the class
	}
	public  static  TerminationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TerminationTokens tokens = new TerminationTokens(options);
		return tokens;
		
	}
	protected TerminationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TerminationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TerminationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TerminationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static TerminationTokens start(){
		return new TerminationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public TerminationTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static TerminationTokens allTokens(){
		
		return start()
			.withReason()
			.withType();
	
	}
	public static TerminationTokens withoutListsTokens(){
		
		return start()
			.withReason()
			.withType();
	
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
	
	public TerminationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String REASON = "reason";
	public String getReason(){
		return REASON;
	}
	public TerminationTokens withReason(){		
		addSimpleOptions(REASON);
		return this;
	}
	
	
	protected static final String TYPE = "type";
	public String getType(){
		return TYPE;
	}
	public TerminationTokens withType(){		
		addSimpleOptions(TYPE);
		return this;
	}
	
	
	
	public  TerminationTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

