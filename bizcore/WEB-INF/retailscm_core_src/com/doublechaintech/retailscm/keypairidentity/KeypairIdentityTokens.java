
package com.doublechaintech.retailscm.keypairidentity;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class KeypairIdentityTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="keypairIdentity";
	
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
	protected KeypairIdentityTokens(){
		//ensure not initialized outside the class
	}
	public  static  KeypairIdentityTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		KeypairIdentityTokens tokens = new KeypairIdentityTokens(options);
		return tokens;
		
	}
	protected KeypairIdentityTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public KeypairIdentityTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static KeypairIdentityTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected KeypairIdentityTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static KeypairIdentityTokens start(){
		return new KeypairIdentityTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public KeypairIdentityTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static KeypairIdentityTokens allTokens(){
		
		return start()
			.withKeyType()
			.withSecUser();
	
	}
	public static KeypairIdentityTokens withoutListsTokens(){
		
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
	
	public KeypairIdentityTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String KEYTYPE = "keyType";
	public String getKeyType(){
		return KEYTYPE;
	}
	public KeypairIdentityTokens withKeyType(){		
		addSimpleOptions(KEYTYPE);
		return this;
	}
	
	
	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public KeypairIdentityTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	
	public  KeypairIdentityTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

