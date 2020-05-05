
package com.doublechaintech.retailscm.wechatminiappidentify;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class WechatMiniappIdentifyTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="wechatMiniappIdentify";
	
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
	protected WechatMiniappIdentifyTokens(){
		//ensure not initialized outside the class
	}
	public  static  WechatMiniappIdentifyTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WechatMiniappIdentifyTokens tokens = new WechatMiniappIdentifyTokens(options);
		return tokens;
		
	}
	protected WechatMiniappIdentifyTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public WechatMiniappIdentifyTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WechatMiniappIdentifyTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WechatMiniappIdentifyTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static WechatMiniappIdentifyTokens start(){
		return new WechatMiniappIdentifyTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public WechatMiniappIdentifyTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static WechatMiniappIdentifyTokens allTokens(){
		
		return start()
			.withSecUser();
	
	}
	public static WechatMiniappIdentifyTokens withoutListsTokens(){
		
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
	
	public WechatMiniappIdentifyTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public WechatMiniappIdentifyTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	
	public  WechatMiniappIdentifyTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

