
package com.doublechaintech.retailscm.wechatworkappidentity;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class WechatWorkappIdentityTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="wechatWorkappIdentity";
	
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
	protected WechatWorkappIdentityTokens(){
		//ensure not initialized outside the class
	}
	public  static  WechatWorkappIdentityTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WechatWorkappIdentityTokens tokens = new WechatWorkappIdentityTokens(options);
		return tokens;
		
	}
	protected WechatWorkappIdentityTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public WechatWorkappIdentityTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WechatWorkappIdentityTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WechatWorkappIdentityTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static WechatWorkappIdentityTokens start(){
		return new WechatWorkappIdentityTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public WechatWorkappIdentityTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static WechatWorkappIdentityTokens allTokens(){
		
		return start()
			.withSecUser();
	
	}
	public static WechatWorkappIdentityTokens withoutListsTokens(){
		
		return start()
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
	
	public WechatWorkappIdentityTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public WechatWorkappIdentityTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	
	public  WechatWorkappIdentityTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

