
package com.doublechaintech.retailscm.wechatworkappidentify;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class WechatWorkappIdentifyTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="wechatWorkappIdentify";
	
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
	protected WechatWorkappIdentifyTokens(){
		//ensure not initialized outside the class
	}
	public  static  WechatWorkappIdentifyTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WechatWorkappIdentifyTokens tokens = new WechatWorkappIdentifyTokens(options);
		return tokens;
		
	}
	protected WechatWorkappIdentifyTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public WechatWorkappIdentifyTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WechatWorkappIdentifyTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WechatWorkappIdentifyTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static WechatWorkappIdentifyTokens start(){
		return new WechatWorkappIdentifyTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public WechatWorkappIdentifyTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static WechatWorkappIdentifyTokens allTokens(){
		
		return start()
			.withSecUser();
	
	}
	public static WechatWorkappIdentifyTokens withoutListsTokens(){
		
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
	
	public WechatWorkappIdentifyTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public WechatWorkappIdentifyTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	
	public  WechatWorkappIdentifyTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

