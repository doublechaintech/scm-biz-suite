
package com.doublechaintech.retailscm.userwhitelist;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class UserWhiteListTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userWhiteList";
	
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
	protected UserWhiteListTokens(){
		//ensure not initialized outside the class
	}
	public  static  UserWhiteListTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UserWhiteListTokens tokens = new UserWhiteListTokens(options);
		return tokens;
		
	}
	protected UserWhiteListTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public UserWhiteListTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserWhiteListTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserWhiteListTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static UserWhiteListTokens start(){
		return new UserWhiteListTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public UserWhiteListTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static UserWhiteListTokens allTokens(){
		
		return start()
			.withDomain();
	
	}
	public static UserWhiteListTokens withoutListsTokens(){
		
		return start()
			.withDomain();
	
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
	
	public UserWhiteListTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	public UserWhiteListTokens withDomain(){		
		addSimpleOptions(DOMAIN);
		return this;
	}
	
	
	
	public  UserWhiteListTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

