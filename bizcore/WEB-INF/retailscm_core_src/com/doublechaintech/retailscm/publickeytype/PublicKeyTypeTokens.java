
package com.doublechaintech.retailscm.publickeytype;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.userdomain.UserDomainTokens;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityTokens;





public class PublicKeyTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="publicKeyType";

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
	protected PublicKeyTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  PublicKeyTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PublicKeyTypeTokens tokens = new PublicKeyTypeTokens(options);
		return tokens;

	}
	protected PublicKeyTypeTokens(Map<String,Object> options){
		this.options = options;
	}

	public PublicKeyTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static PublicKeyTypeTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected PublicKeyTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static PublicKeyTypeTokens start(){
		return new PublicKeyTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public PublicKeyTypeTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static PublicKeyTypeTokens loadGroupTokens(String... groupNames){
    PublicKeyTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, DOMAIN, groupNames, new String[]{"default"});

  
     addToken(tokens, KEY_PAIR_IDENTITY_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(PublicKeyTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static PublicKeyTypeTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withDomain()
			.withKeyPairIdentityListIfViewGroupInclude(viewGroups);

	}

	public static PublicKeyTypeTokens allTokens(){

		return start()
			.withDomain()
			.withKeyPairIdentityList();

	}
	public static PublicKeyTypeTokens withoutListsTokens(){

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

	public PublicKeyTypeTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	//
	public PublicKeyTypeTokens withDomain(){
		addSimpleOptions(DOMAIN);
		return this;
	}

	public UserDomainTokens withDomainTokens(){
		//addSimpleOptions(DOMAIN);
		return UserDomainTokens.start();
	}

	
	protected static final String KEY_PAIR_IDENTITY_LIST = "keyPairIdentityList";
	public String getKeyPairIdentityList(){
		return KEY_PAIR_IDENTITY_LIST;
	}



	public PublicKeyTypeTokens withKeyPairIdentityListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(KEY_PAIR_IDENTITY_LIST);
		}
		return this;
	}


	public PublicKeyTypeTokens withKeyPairIdentityList(){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST);
		return this;
	}

	public KeyPairIdentityTokens withKeyPairIdentityListTokens(){
		//addSimpleOptions(KEY_PAIR_IDENTITY_LIST);
		return KeyPairIdentityTokens.start();
	}

	public PublicKeyTypeTokens analyzeKeyPairIdentityList(){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeKeyPairIdentityListEnabled(){

		if(checkOptions(this.options(), KEY_PAIR_IDENTITY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PublicKeyTypeTokens extractMoreFromKeyPairIdentityList(String idsSeperatedWithComma){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int keyPairIdentityListSortCounter = 0;
	public PublicKeyTypeTokens sortKeyPairIdentityListWith(String field, String descOrAsc){
		addSortMoreOptions(KEY_PAIR_IDENTITY_LIST,keyPairIdentityListSortCounter++, field, descOrAsc);
		return this;
	}
	private int keyPairIdentityListSearchCounter = 0;
	public PublicKeyTypeTokens searchKeyPairIdentityListWith(String field, String verb, String value){

		withKeyPairIdentityList();
		addSearchMoreOptions(KEY_PAIR_IDENTITY_LIST,keyPairIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public PublicKeyTypeTokens searchAllTextOfKeyPairIdentityList(String verb, String value){
		String field = "id|publicKey";
		addSearchMoreOptions(KEY_PAIR_IDENTITY_LIST,keyPairIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public PublicKeyTypeTokens rowsPerPageOfKeyPairIdentityList(int rowsPerPage){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PublicKeyTypeTokens currentPageNumberOfKeyPairIdentityList(int currentPageNumber){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PublicKeyTypeTokens retainColumnsOfKeyPairIdentityList(String[] columns){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"RetainColumns",columns);
		return this;
	}
	public PublicKeyTypeTokens excludeColumnsOfKeyPairIdentityList(String[] columns){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  PublicKeyTypeTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfKeyPairIdentityList(verb, value);
		return this;
	}
}

