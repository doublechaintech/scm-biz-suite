
package com.doublechaintech.retailscm.keypairidentity;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeTokens;
import com.doublechaintech.retailscm.secuser.SecUserTokens;





public class KeyPairIdentityTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="keyPairIdentity";

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
	protected KeyPairIdentityTokens(){
		//ensure not initialized outside the class
	}
	public  static  KeyPairIdentityTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		KeyPairIdentityTokens tokens = new KeyPairIdentityTokens(options);
		return tokens;

	}
	protected KeyPairIdentityTokens(Map<String,Object> options){
		this.options = options;
	}

	public KeyPairIdentityTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static KeyPairIdentityTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected KeyPairIdentityTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static KeyPairIdentityTokens start(){
		return new KeyPairIdentityTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public KeyPairIdentityTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static KeyPairIdentityTokens loadGroupTokens(String... groupNames){
    KeyPairIdentityTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, KEYTYPE, groupNames, new String[]{"default"});addToken(tokens, SECUSER, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(KeyPairIdentityTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static KeyPairIdentityTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withKeyType()
			.withSecUser();

	}

	public static KeyPairIdentityTokens allTokens(){

		return start()
			.withKeyType()
			.withSecUser();

	}
	public static KeyPairIdentityTokens withoutListsTokens(){

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

	public KeyPairIdentityTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String KEYTYPE = "keyType";
	public String getKeyType(){
		return KEYTYPE;
	}
	//
	public KeyPairIdentityTokens withKeyType(){
		addSimpleOptions(KEYTYPE);
		return this;
	}

	public PublicKeyTypeTokens withKeyTypeTokens(){
		//addSimpleOptions(KEYTYPE);
		return PublicKeyTypeTokens.start();
	}

	
	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	//
	public KeyPairIdentityTokens withSecUser(){
		addSimpleOptions(SECUSER);
		return this;
	}

	public SecUserTokens withSecUserTokens(){
		//addSimpleOptions(SECUSER);
		return SecUserTokens.start();
	}

	

	public  KeyPairIdentityTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}

