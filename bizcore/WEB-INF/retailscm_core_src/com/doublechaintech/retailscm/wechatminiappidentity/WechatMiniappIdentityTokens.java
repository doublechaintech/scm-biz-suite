
package com.doublechaintech.retailscm.wechatminiappidentity;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.secuser.SecUserTokens;





public class WechatMiniappIdentityTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="wechatMiniappIdentity";

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
	protected WechatMiniappIdentityTokens(){
		//ensure not initialized outside the class
	}
	public  static  WechatMiniappIdentityTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WechatMiniappIdentityTokens tokens = new WechatMiniappIdentityTokens(options);
		return tokens;

	}
	protected WechatMiniappIdentityTokens(Map<String,Object> options){
		this.options = options;
	}

	public WechatMiniappIdentityTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static WechatMiniappIdentityTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected WechatMiniappIdentityTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static WechatMiniappIdentityTokens start(){
		return new WechatMiniappIdentityTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public WechatMiniappIdentityTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static WechatMiniappIdentityTokens loadGroupTokens(String... groupNames){
    WechatMiniappIdentityTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, SECUSER, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(WechatMiniappIdentityTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static WechatMiniappIdentityTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withSecUser();

	}

	public static WechatMiniappIdentityTokens allTokens(){

		return start()
			.withSecUser();

	}
	public static WechatMiniappIdentityTokens withoutListsTokens(){

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

	public WechatMiniappIdentityTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	//
	public WechatMiniappIdentityTokens withSecUser(){
		addSimpleOptions(SECUSER);
		return this;
	}

	public SecUserTokens withSecUserTokens(){
		//addSimpleOptions(SECUSER);
		return SecUserTokens.start();
	}

	

	public  WechatMiniappIdentityTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}

