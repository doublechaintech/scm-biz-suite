
package com.doublechaintech.retailscm.memberrewardpoint;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberTokens;





public class MemberRewardPointTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="memberRewardPoint";

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
	protected MemberRewardPointTokens(){
		//ensure not initialized outside the class
	}
	public  static  MemberRewardPointTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		MemberRewardPointTokens tokens = new MemberRewardPointTokens(options);
		return tokens;

	}
	protected MemberRewardPointTokens(Map<String,Object> options){
		this.options = options;
	}

	public MemberRewardPointTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static MemberRewardPointTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected MemberRewardPointTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static MemberRewardPointTokens start(){
		return new MemberRewardPointTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public MemberRewardPointTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static MemberRewardPointTokens loadGroupTokens(String... groupNames){
    MemberRewardPointTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, OWNER, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(MemberRewardPointTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static MemberRewardPointTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withOwner();

	}

	public static MemberRewardPointTokens allTokens(){

		return start()
			.withOwner();

	}
	public static MemberRewardPointTokens withoutListsTokens(){

		return start()
			.withOwner();

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

	public MemberRewardPointTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	//
	public MemberRewardPointTokens withOwner(){
		addSimpleOptions(OWNER);
		return this;
	}

	public RetailStoreMemberTokens withOwnerTokens(){
		//addSimpleOptions(OWNER);
		return RetailStoreMemberTokens.start();
	}

	

	public  MemberRewardPointTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}

