
package com.doublechaintech.retailscm.userallowlist;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.userdomain.UserDomainTokens;





public class UserAllowListTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userAllowList";

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
	protected UserAllowListTokens(){
		//ensure not initialized outside the class
	}
	public  static  UserAllowListTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UserAllowListTokens tokens = new UserAllowListTokens(options);
		return tokens;

	}
	protected UserAllowListTokens(Map<String,Object> options){
		this.options = options;
	}

	public UserAllowListTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static UserAllowListTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected UserAllowListTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static UserAllowListTokens start(){
		return new UserAllowListTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public UserAllowListTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static UserAllowListTokens loadGroupTokens(String... groupNames){
    UserAllowListTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, DOMAIN, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(UserAllowListTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static UserAllowListTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withDomain();

	}

	public static UserAllowListTokens allTokens(){

		return start()
			.withDomain();

	}
	public static UserAllowListTokens withoutListsTokens(){

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

	public UserAllowListTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	//
	public UserAllowListTokens withDomain(){
		addSimpleOptions(DOMAIN);
		return this;
	}

	public UserDomainTokens withDomainTokens(){
		//addSimpleOptions(DOMAIN);
		return UserDomainTokens.start();
	}

	

	public  UserAllowListTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}

