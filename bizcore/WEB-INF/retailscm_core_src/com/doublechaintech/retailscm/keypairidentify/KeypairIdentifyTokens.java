
package com.doublechaintech.retailscm.keypairidentify;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class KeypairIdentifyTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="keypairIdentify";
	
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
	protected KeypairIdentifyTokens(){
		//ensure not initialized outside the class
	}
	public  static  KeypairIdentifyTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		KeypairIdentifyTokens tokens = new KeypairIdentifyTokens(options);
		return tokens;
		
	}
	protected KeypairIdentifyTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public KeypairIdentifyTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static KeypairIdentifyTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected KeypairIdentifyTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static KeypairIdentifyTokens start(){
		return new KeypairIdentifyTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public KeypairIdentifyTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static KeypairIdentifyTokens allTokens(){
		
		return start()
			.withKeyType()
			.withSecUser();
	
	}
	public static KeypairIdentifyTokens withoutListsTokens(){
		
		return start()
			.withKeyType()
			.withSecUser();
	
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
	
	public KeypairIdentifyTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String KEYTYPE = "keyType";
	public String getKeyType(){
		return KEYTYPE;
	}
	public KeypairIdentifyTokens withKeyType(){		
		addSimpleOptions(KEYTYPE);
		return this;
	}
	
	
	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public KeypairIdentifyTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	
	public  KeypairIdentifyTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

