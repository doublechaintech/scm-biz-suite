
package com.doublechaintech.retailscm.objectaccess;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ObjectAccessTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="objectAccess";
	
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
	protected ObjectAccessTokens(){
		//ensure not initialized outside the class
	}
	
	public ObjectAccessTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ObjectAccessTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ObjectAccessTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ObjectAccessTokens start(){
		return new ObjectAccessTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ObjectAccessTokens allTokens(){
		
		return start()
			.withApp();
	
	}
	public static ObjectAccessTokens withoutListsTokens(){
		
		return start()
			.withApp();
	
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

	protected static final String APP = "app";
	public String getApp(){
		return APP;
	}
	public ObjectAccessTokens withApp(){		
		addSimpleOptions(APP);
		return this;
	}
	
	
	
	public  ObjectAccessTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

