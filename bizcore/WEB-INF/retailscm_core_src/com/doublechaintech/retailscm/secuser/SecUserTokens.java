
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
	
	protected static SecUserTokens allTokens(){
		
		return start()
			.withDomain()
			.withBlocking()
			.withUserAppList()
			.withLoginHistoryList();
	
	}
	public static SecUserTokens withoutListsTokens(){
		
		return start()
			.withDomain()
			.withBlocking();
	
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

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	public SecUserTokens withDomain(){		
		addSimpleOptions(DOMAIN);
		return this;
	}
	
	
	protected static final String BLOCKING = "blocking";
	public String getBlocking(){
		return BLOCKING;
	}
	public SecUserTokens withBlocking(){		
		addSimpleOptions(BLOCKING);
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
	
	
		
	
	public  SecUserTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserAppList(verb, value);	
		searchAllTextOfLoginHistoryList(verb, value);	
		return this;
	}
}

