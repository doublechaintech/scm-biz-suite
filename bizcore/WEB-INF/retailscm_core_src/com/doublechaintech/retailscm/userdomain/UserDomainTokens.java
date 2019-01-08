
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
	
	protected static UserDomainTokens allTokens(){
		
		return start()
			.withUserWhiteListList()
			.withSecUserList();
	
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

	protected static final String USER_WHITE_LIST_LIST = "userWhiteListList";
	public String getUserWhiteListList(){
		return USER_WHITE_LIST_LIST;
	}
	public UserDomainTokens withUserWhiteListList(){		
		addSimpleOptions(USER_WHITE_LIST_LIST);
		return this;
	}
	public UserDomainTokens analyzeUserWhiteListList(){		
		addSimpleOptions(USER_WHITE_LIST_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserWhiteListListEnabled(){		
		
		return checkOptions(this.options(), USER_WHITE_LIST_LIST+".anaylze");
	}
	public UserDomainTokens extractMoreFromUserWhiteListList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_WHITE_LIST_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userWhiteListListSortCounter = 0;
	public UserDomainTokens sortUserWhiteListListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_WHITE_LIST_LIST,userWhiteListListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userWhiteListListSearchCounter = 0;
	public UserDomainTokens searchUserWhiteListListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_WHITE_LIST_LIST,userWhiteListListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserDomainTokens searchAllTextOfUserWhiteListList(String verb, String value){	
		String field = "id|userIdentity|userSpecialFunctions";
		addSearchMoreOptions(USER_WHITE_LIST_LIST,userWhiteListListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserDomainTokens rowsPerPageOfUserWhiteListList(int rowsPerPage){		
		addSimpleOptions(USER_WHITE_LIST_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserDomainTokens currentPageNumberOfUserWhiteListList(int currentPageNumber){		
		addSimpleOptions(USER_WHITE_LIST_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserDomainTokens retainColumnsOfUserWhiteListList(String[] columns){		
		addSimpleOptions(USER_WHITE_LIST_LIST+"RetainColumns",columns);
		return this;
	}
	public UserDomainTokens excludeColumnsOfUserWhiteListList(String[] columns){		
		addSimpleOptions(USER_WHITE_LIST_LIST+"ExcludeColumns",columns);
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
		
		return checkOptions(this.options(), SEC_USER_LIST+".anaylze");
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
		addSearchMoreOptions(SEC_USER_LIST,secUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserDomainTokens searchAllTextOfSecUserList(String verb, String value){	
		String field = "id|login|mobile|email|pwd|currentStatus";
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
	
	
		
	
	public  UserDomainTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserWhiteListList(verb, value);	
		searchAllTextOfSecUserList(verb, value);	
		return this;
	}
}

