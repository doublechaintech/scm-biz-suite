
package com.doublechaintech.retailscm.secuser;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
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
	
	protected static SecUserTokens allTokens(){
		
		return start()
			.withDomain()
			.withUserAppList()
			.withLoginHistoryList()
			.withWechatWorkappIdentityList()
			.withWechatMiniappIdentityList()
			.withKeypairIdentityList();
	
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
	public SecUserTokens withDomain(){		
		addSimpleOptions(DOMAIN);
		return this;
	}
	
	
	protected static final String USER_APP_LIST = "userAppList";
	public String getUserAppList(){
		return USER_APP_LIST;
	}
	public SecUserTokens withUserAppList(){		
		addSimpleOptions(USER_APP_LIST);
		return this;
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
		String field = "id|title|appIcon|permission|objectType|objectId|location";
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
	public SecUserTokens withLoginHistoryList(){		
		addSimpleOptions(LOGIN_HISTORY_LIST);
		return this;
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
	public SecUserTokens withWechatWorkappIdentityList(){		
		addSimpleOptions(WECHAT_WORKAPP_IDENTITY_LIST);
		return this;
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
	public SecUserTokens withWechatMiniappIdentityList(){		
		addSimpleOptions(WECHAT_MINIAPP_IDENTITY_LIST);
		return this;
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
		String field = "id|openId|appId";
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
	
	
		
	protected static final String KEYPAIR_IDENTITY_LIST = "keypairIdentityList";
	public String getKeypairIdentityList(){
		return KEYPAIR_IDENTITY_LIST;
	}
	public SecUserTokens withKeypairIdentityList(){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST);
		return this;
	}
	public SecUserTokens analyzeKeypairIdentityList(){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeKeypairIdentityListEnabled(){		
		
		if(checkOptions(this.options(), KEYPAIR_IDENTITY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public SecUserTokens extractMoreFromKeypairIdentityList(String idsSeperatedWithComma){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int keypairIdentityListSortCounter = 0;
	public SecUserTokens sortKeypairIdentityListWith(String field, String descOrAsc){		
		addSortMoreOptions(KEYPAIR_IDENTITY_LIST,keypairIdentityListSortCounter++, field, descOrAsc);
		return this;
	}
	private int keypairIdentityListSearchCounter = 0;
	public SecUserTokens searchKeypairIdentityListWith(String field, String verb, String value){		
		
		withKeypairIdentityList();
		addSearchMoreOptions(KEYPAIR_IDENTITY_LIST,keypairIdentityListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SecUserTokens searchAllTextOfKeypairIdentityList(String verb, String value){	
		String field = "id|publicKey";
		addSearchMoreOptions(KEYPAIR_IDENTITY_LIST,keypairIdentityListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SecUserTokens rowsPerPageOfKeypairIdentityList(int rowsPerPage){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserTokens currentPageNumberOfKeypairIdentityList(int currentPageNumber){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserTokens retainColumnsOfKeypairIdentityList(String[] columns){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserTokens excludeColumnsOfKeypairIdentityList(String[] columns){		
		addSimpleOptions(KEYPAIR_IDENTITY_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  SecUserTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserAppList(verb, value);	
		searchAllTextOfLoginHistoryList(verb, value);	
		searchAllTextOfWechatWorkappIdentityList(verb, value);	
		searchAllTextOfWechatMiniappIdentityList(verb, value);	
		searchAllTextOfKeypairIdentityList(verb, value);	
		return this;
	}
}

