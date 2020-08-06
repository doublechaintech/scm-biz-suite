
package com.doublechaintech.retailscm.userdomain;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class UserDomainTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userDomain";
	
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
	protected UserDomainTokens(){
		//ensure not initialized outside the class
	}
	public  static  UserDomainTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UserDomainTokens tokens = new UserDomainTokens(options);
		return tokens;
		
	}
	protected UserDomainTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public UserDomainTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserDomainTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserDomainTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static UserDomainTokens start(){
		return new UserDomainTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public UserDomainTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static UserDomainTokens allTokens(){
		
		return start()
			.withUserAllowListList()
			.withSecUserList()
			.withPublicKeyTypeList();
	
	}
	public static UserDomainTokens withoutListsTokens(){
		
		return start();
	
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
	
	public UserDomainTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USER_ALLOW_LIST_LIST = "userAllowListList";
	public String getUserAllowListList(){
		return USER_ALLOW_LIST_LIST;
	}
	public UserDomainTokens withUserAllowListList(){		
		addSimpleOptions(USER_ALLOW_LIST_LIST);
		return this;
	}
	public UserDomainTokens analyzeUserAllowListList(){		
		addSimpleOptions(USER_ALLOW_LIST_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserAllowListListEnabled(){		
		
		if(checkOptions(this.options(), USER_ALLOW_LIST_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public UserDomainTokens extractMoreFromUserAllowListList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ALLOW_LIST_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userAllowListListSortCounter = 0;
	public UserDomainTokens sortUserAllowListListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ALLOW_LIST_LIST,userAllowListListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userAllowListListSearchCounter = 0;
	public UserDomainTokens searchUserAllowListListWith(String field, String verb, String value){		
		
		withUserAllowListList();
		addSearchMoreOptions(USER_ALLOW_LIST_LIST,userAllowListListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens searchAllTextOfUserAllowListList(String verb, String value){	
		String field = "id|userIdentity|userSpecialFunctions";
		addSearchMoreOptions(USER_ALLOW_LIST_LIST,userAllowListListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens rowsPerPageOfUserAllowListList(int rowsPerPage){		
		addSimpleOptions(USER_ALLOW_LIST_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserDomainTokens currentPageNumberOfUserAllowListList(int currentPageNumber){		
		addSimpleOptions(USER_ALLOW_LIST_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserDomainTokens retainColumnsOfUserAllowListList(String[] columns){		
		addSimpleOptions(USER_ALLOW_LIST_LIST+"RetainColumns",columns);
		return this;
	}
	public UserDomainTokens excludeColumnsOfUserAllowListList(String[] columns){		
		addSimpleOptions(USER_ALLOW_LIST_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SEC_USER_LIST = "secUserList";
	public String getSecUserList(){
		return SEC_USER_LIST;
	}
	public UserDomainTokens withSecUserList(){		
		addSimpleOptions(SEC_USER_LIST);
		return this;
	}
	public UserDomainTokens analyzeSecUserList(){		
		addSimpleOptions(SEC_USER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSecUserListEnabled(){		
		
		if(checkOptions(this.options(), SEC_USER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public UserDomainTokens extractMoreFromSecUserList(String idsSeperatedWithComma){		
		addSimpleOptions(SEC_USER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int secUserListSortCounter = 0;
	public UserDomainTokens sortSecUserListWith(String field, String descOrAsc){		
		addSortMoreOptions(SEC_USER_LIST,secUserListSortCounter++, field, descOrAsc);
		return this;
	}
	private int secUserListSearchCounter = 0;
	public UserDomainTokens searchSecUserListWith(String field, String verb, String value){		
		
		withSecUserList();
		addSearchMoreOptions(SEC_USER_LIST,secUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens searchAllTextOfSecUserList(String verb, String value){	
		String field = "id|login|mobile|email|pwd|weixinOpenid|weixinAppid|accessToken";
		addSearchMoreOptions(SEC_USER_LIST,secUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens rowsPerPageOfSecUserList(int rowsPerPage){		
		addSimpleOptions(SEC_USER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserDomainTokens currentPageNumberOfSecUserList(int currentPageNumber){		
		addSimpleOptions(SEC_USER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserDomainTokens retainColumnsOfSecUserList(String[] columns){		
		addSimpleOptions(SEC_USER_LIST+"RetainColumns",columns);
		return this;
	}
	public UserDomainTokens excludeColumnsOfSecUserList(String[] columns){		
		addSimpleOptions(SEC_USER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PUBLIC_KEY_TYPE_LIST = "publicKeyTypeList";
	public String getPublicKeyTypeList(){
		return PUBLIC_KEY_TYPE_LIST;
	}
	public UserDomainTokens withPublicKeyTypeList(){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST);
		return this;
	}
	public UserDomainTokens analyzePublicKeyTypeList(){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzePublicKeyTypeListEnabled(){		
		
		if(checkOptions(this.options(), PUBLIC_KEY_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public UserDomainTokens extractMoreFromPublicKeyTypeList(String idsSeperatedWithComma){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int publicKeyTypeListSortCounter = 0;
	public UserDomainTokens sortPublicKeyTypeListWith(String field, String descOrAsc){		
		addSortMoreOptions(PUBLIC_KEY_TYPE_LIST,publicKeyTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int publicKeyTypeListSearchCounter = 0;
	public UserDomainTokens searchPublicKeyTypeListWith(String field, String verb, String value){		
		
		withPublicKeyTypeList();
		addSearchMoreOptions(PUBLIC_KEY_TYPE_LIST,publicKeyTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens searchAllTextOfPublicKeyTypeList(String verb, String value){	
		String field = "id|name|code";
		addSearchMoreOptions(PUBLIC_KEY_TYPE_LIST,publicKeyTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens rowsPerPageOfPublicKeyTypeList(int rowsPerPage){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserDomainTokens currentPageNumberOfPublicKeyTypeList(int currentPageNumber){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserDomainTokens retainColumnsOfPublicKeyTypeList(String[] columns){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public UserDomainTokens excludeColumnsOfPublicKeyTypeList(String[] columns){		
		addSimpleOptions(PUBLIC_KEY_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  UserDomainTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserAllowListList(verb, value);	
		searchAllTextOfSecUserList(verb, value);	
		searchAllTextOfPublicKeyTypeList(verb, value);	
		return this;
	}
}

