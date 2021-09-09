
package com.doublechaintech.retailscm.secuser;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.userdomain.UserDomainTokens;
import com.doublechaintech.retailscm.userapp.UserAppTokens;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryTokens;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityTokens;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityTokens;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityTokens;





public class SecUserTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="secUser";

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
	protected SecUserTokens(){
		//ensure not initialized outside the class
	}
	public  static  SecUserTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SecUserTokens tokens = new SecUserTokens(options);
		return tokens;

	}
	protected SecUserTokens(Map<String,Object> options){
		this.options = options;
	}

	public SecUserTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static SecUserTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected SecUserTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static SecUserTokens start(){
		return new SecUserTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public SecUserTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static SecUserTokens loadGroupTokens(String... groupNames){
    SecUserTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, DOMAIN, groupNames, new String[]{"default"});

  
     addToken(tokens, USER_APP_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, LOGIN_HISTORY_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, WECHAT_WORKAPP_IDENTITY_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, WECHAT_MINIAPP_IDENTITY_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, KEY_PAIR_IDENTITY_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(SecUserTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static SecUserTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withDomain()
			.withUserAppListIfViewGroupInclude(viewGroups)
			.withLoginHistoryListIfViewGroupInclude(viewGroups)
			.withWechatWorkappIdentityListIfViewGroupInclude(viewGroups)
			.withWechatMiniappIdentityListIfViewGroupInclude(viewGroups)
			.withKeyPairIdentityListIfViewGroupInclude(viewGroups);

	}

	public static SecUserTokens allTokens(){

		return start()
			.withDomain()
			.withUserAppList()
			.withLoginHistoryList()
			.withWechatWorkappIdentityList()
			.withWechatMiniappIdentityList()
			.withKeyPairIdentityList();

	}
	public static SecUserTokens withoutListsTokens(){

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

	public SecUserTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	//
	public SecUserTokens withDomain(){
		addSimpleOptions(DOMAIN);
		return this;
	}

	public UserDomainTokens withDomainTokens(){
		//addSimpleOptions(DOMAIN);
		return UserDomainTokens.start();
	}

	
	protected static final String USER_APP_LIST = "userAppList";
	public String getUserAppList(){
		return USER_APP_LIST;
	}



	public SecUserTokens withUserAppListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(USER_APP_LIST);
		}
		return this;
	}


	public SecUserTokens withUserAppList(){
		addSimpleOptions(USER_APP_LIST);
		return this;
	}

	public UserAppTokens withUserAppListTokens(){
		//addSimpleOptions(USER_APP_LIST);
		return UserAppTokens.start();
	}

	public SecUserTokens analyzeUserAppList(){
		addSimpleOptions(USER_APP_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserAppListEnabled(){

		if(checkOptions(this.options(), USER_APP_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public SecUserTokens extractMoreFromUserAppList(String idsSeperatedWithComma){
		addSimpleOptions(USER_APP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int userAppListSortCounter = 0;
	public SecUserTokens sortUserAppListWith(String field, String descOrAsc){
		addSortMoreOptions(USER_APP_LIST,userAppListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userAppListSearchCounter = 0;
	public SecUserTokens searchUserAppListWith(String field, String verb, String value){

		withUserAppList();
		addSearchMoreOptions(USER_APP_LIST,userAppListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens searchAllTextOfUserAppList(String verb, String value){
		String field = "id|title|appIcon|permission|appType|appId|ctxType|ctxId|location";
		addSearchMoreOptions(USER_APP_LIST,userAppListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens rowsPerPageOfUserAppList(int rowsPerPage){
		addSimpleOptions(USER_APP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserTokens currentPageNumberOfUserAppList(int currentPageNumber){
		addSimpleOptions(USER_APP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserTokens retainColumnsOfUserAppList(String[] columns){
		addSimpleOptions(USER_APP_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserTokens excludeColumnsOfUserAppList(String[] columns){
		addSimpleOptions(USER_APP_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String LOGIN_HISTORY_LIST = "loginHistoryList";
	public String getLoginHistoryList(){
		return LOGIN_HISTORY_LIST;
	}



	public SecUserTokens withLoginHistoryListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(LOGIN_HISTORY_LIST);
		}
		return this;
	}


	public SecUserTokens withLoginHistoryList(){
		addSimpleOptions(LOGIN_HISTORY_LIST);
		return this;
	}

	public LoginHistoryTokens withLoginHistoryListTokens(){
		//addSimpleOptions(LOGIN_HISTORY_LIST);
		return LoginHistoryTokens.start();
	}

	public SecUserTokens analyzeLoginHistoryList(){
		addSimpleOptions(LOGIN_HISTORY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLoginHistoryListEnabled(){

		if(checkOptions(this.options(), LOGIN_HISTORY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public SecUserTokens extractMoreFromLoginHistoryList(String idsSeperatedWithComma){
		addSimpleOptions(LOGIN_HISTORY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int loginHistoryListSortCounter = 0;
	public SecUserTokens sortLoginHistoryListWith(String field, String descOrAsc){
		addSortMoreOptions(LOGIN_HISTORY_LIST,loginHistoryListSortCounter++, field, descOrAsc);
		return this;
	}
	private int loginHistoryListSearchCounter = 0;
	public SecUserTokens searchLoginHistoryListWith(String field, String verb, String value){

		withLoginHistoryList();
		addSearchMoreOptions(LOGIN_HISTORY_LIST,loginHistoryListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens searchAllTextOfLoginHistoryList(String verb, String value){
		String field = "id|fromIp|description";
		addSearchMoreOptions(LOGIN_HISTORY_LIST,loginHistoryListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens rowsPerPageOfLoginHistoryList(int rowsPerPage){
		addSimpleOptions(LOGIN_HISTORY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserTokens currentPageNumberOfLoginHistoryList(int currentPageNumber){
		addSimpleOptions(LOGIN_HISTORY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserTokens retainColumnsOfLoginHistoryList(String[] columns){
		addSimpleOptions(LOGIN_HISTORY_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserTokens excludeColumnsOfLoginHistoryList(String[] columns){
		addSimpleOptions(LOGIN_HISTORY_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String WECHAT_WORKAPP_IDENTITY_LIST = "wechatWorkappIdentityList";
	public String getWechatWorkappIdentityList(){
		return WECHAT_WORKAPP_IDENTITY_LIST;
	}



	public SecUserTokens withWechatWorkappIdentityListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST);
		}
		return this;
	}


	public SecUserTokens withWechatWorkappIdentityList(){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST);
		return this;
	}

	public WechatWorkappIdentityTokens withWechatWorkappIdentityListTokens(){
		//addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST);
		return WechatWorkappIdentityTokens.start();
	}

	public SecUserTokens analyzeWechatWorkappIdentityList(){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeWechatWorkappIdentityListEnabled(){

		if(checkOptions(this.options(), WECHAT_WORKAPP_IDENTITY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public SecUserTokens extractMoreFromWechatWorkappIdentityList(String idsSeperatedWithComma){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int wechatWorkappIdentityListSortCounter = 0;
	public SecUserTokens sortWechatWorkappIdentityListWith(String field, String descOrAsc){
		addSortMoreOptions(WECHAT_WORKAPP_IDENTITY_LIST,wechatWorkappIdentityListSortCounter++, field, descOrAsc);
		return this;
	}
	private int wechatWorkappIdentityListSearchCounter = 0;
	public SecUserTokens searchWechatWorkappIdentityListWith(String field, String verb, String value){

		withWechatWorkappIdentityList();
		addSearchMoreOptions(WECHAT_WORKAPP_IDENTITY_LIST,wechatWorkappIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens searchAllTextOfWechatWorkappIdentityList(String verb, String value){
		String field = "id|corpId|userId";
		addSearchMoreOptions(WECHAT_WORKAPP_IDENTITY_LIST,wechatWorkappIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens rowsPerPageOfWechatWorkappIdentityList(int rowsPerPage){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserTokens currentPageNumberOfWechatWorkappIdentityList(int currentPageNumber){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserTokens retainColumnsOfWechatWorkappIdentityList(String[] columns){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserTokens excludeColumnsOfWechatWorkappIdentityList(String[] columns){
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String WECHAT_MINIAPP_IDENTITY_LIST = "wechatMiniappIdentityList";
	public String getWechatMiniappIdentityList(){
		return WECHAT_MINIAPP_IDENTITY_LIST;
	}



	public SecUserTokens withWechatMiniappIdentityListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST);
		}
		return this;
	}


	public SecUserTokens withWechatMiniappIdentityList(){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST);
		return this;
	}

	public WechatMiniappIdentityTokens withWechatMiniappIdentityListTokens(){
		//addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST);
		return WechatMiniappIdentityTokens.start();
	}

	public SecUserTokens analyzeWechatMiniappIdentityList(){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeWechatMiniappIdentityListEnabled(){

		if(checkOptions(this.options(), WECHAT_MINIAPP_IDENTITY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public SecUserTokens extractMoreFromWechatMiniappIdentityList(String idsSeperatedWithComma){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int wechatMiniappIdentityListSortCounter = 0;
	public SecUserTokens sortWechatMiniappIdentityListWith(String field, String descOrAsc){
		addSortMoreOptions(WECHAT_MINIAPP_IDENTITY_LIST,wechatMiniappIdentityListSortCounter++, field, descOrAsc);
		return this;
	}
	private int wechatMiniappIdentityListSearchCounter = 0;
	public SecUserTokens searchWechatMiniappIdentityListWith(String field, String verb, String value){

		withWechatMiniappIdentityList();
		addSearchMoreOptions(WECHAT_MINIAPP_IDENTITY_LIST,wechatMiniappIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens searchAllTextOfWechatMiniappIdentityList(String verb, String value){
		String field = "id|openId|appId|unionId";
		addSearchMoreOptions(WECHAT_MINIAPP_IDENTITY_LIST,wechatMiniappIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens rowsPerPageOfWechatMiniappIdentityList(int rowsPerPage){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserTokens currentPageNumberOfWechatMiniappIdentityList(int currentPageNumber){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserTokens retainColumnsOfWechatMiniappIdentityList(String[] columns){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserTokens excludeColumnsOfWechatMiniappIdentityList(String[] columns){
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String KEY_PAIR_IDENTITY_LIST = "keyPairIdentityList";
	public String getKeyPairIdentityList(){
		return KEY_PAIR_IDENTITY_LIST;
	}



	public SecUserTokens withKeyPairIdentityListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(KEY_PAIR_IDENTITY_LIST);
		}
		return this;
	}


	public SecUserTokens withKeyPairIdentityList(){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST);
		return this;
	}

	public KeyPairIdentityTokens withKeyPairIdentityListTokens(){
		//addSimpleOptions(KEY_PAIR_IDENTITY_LIST);
		return KeyPairIdentityTokens.start();
	}

	public SecUserTokens analyzeKeyPairIdentityList(){
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
	public SecUserTokens extractMoreFromKeyPairIdentityList(String idsSeperatedWithComma){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int keyPairIdentityListSortCounter = 0;
	public SecUserTokens sortKeyPairIdentityListWith(String field, String descOrAsc){
		addSortMoreOptions(KEY_PAIR_IDENTITY_LIST,keyPairIdentityListSortCounter++, field, descOrAsc);
		return this;
	}
	private int keyPairIdentityListSearchCounter = 0;
	public SecUserTokens searchKeyPairIdentityListWith(String field, String verb, String value){

		withKeyPairIdentityList();
		addSearchMoreOptions(KEY_PAIR_IDENTITY_LIST,keyPairIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens searchAllTextOfKeyPairIdentityList(String verb, String value){
		String field = "id|publicKey";
		addSearchMoreOptions(KEY_PAIR_IDENTITY_LIST,keyPairIdentityListSearchCounter++, field, verb, value);
		return this;
	}



	public SecUserTokens rowsPerPageOfKeyPairIdentityList(int rowsPerPage){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserTokens currentPageNumberOfKeyPairIdentityList(int currentPageNumber){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserTokens retainColumnsOfKeyPairIdentityList(String[] columns){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserTokens excludeColumnsOfKeyPairIdentityList(String[] columns){
		addSimpleOptions(KEY_PAIR_IDENTITY_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  SecUserTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfUserAppList(verb, value);
		searchAllTextOfLoginHistoryList(verb, value);
		searchAllTextOfWechatWorkappIdentityList(verb, value);
		searchAllTextOfWechatMiniappIdentityList(verb, value);
		searchAllTextOfKeyPairIdentityList(verb, value);
		return this;
	}
}

