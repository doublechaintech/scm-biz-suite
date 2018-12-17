
package com.doublechaintech.retailscm.secuserblocking;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class SecUserBlockingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="secUserBlocking";
	
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
	protected SecUserBlockingTokens(){
		//ensure not initialized outside the class
	}
	
	public SecUserBlockingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SecUserBlockingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SecUserBlockingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SecUserBlockingTokens start(){
		return new SecUserBlockingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SecUserBlockingTokens allTokens(){
		
		return start()
			.withSecUserList();
	
	}
	public static SecUserBlockingTokens withoutListsTokens(){
		
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

	protected static final String SEC_USER_LIST = "secUserList";
	public String getSecUserList(){
		return SEC_USER_LIST;
	}
	public SecUserBlockingTokens withSecUserList(){		
		addSimpleOptions(SEC_USER_LIST);
		return this;
	}

	public SecUserBlockingTokens extractMoreFromSecUserList(String idsSeperatedWithComma){		
		addSimpleOptions(SEC_USER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int secUserListSortCounter = 0;
	public SecUserBlockingTokens sortSecUserListWith(String field, String descOrAsc){		
		addSortMoreOptions(SEC_USER_LIST,secUserListSortCounter++, field, descOrAsc);
		return this;
	}
	private int secUserListSearchCounter = 0;
	public SecUserBlockingTokens searchSecUserListWith(String field, String verb, String value){		
		addSearchMoreOptions(SEC_USER_LIST,secUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SecUserBlockingTokens searchAllTextOfSecUserList(String verb, String value){	
		String field = "id|login|mobile|email|pwd|currentStatus";
		addSearchMoreOptions(SEC_USER_LIST,secUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SecUserBlockingTokens rowsPerPageOfSecUserList(int rowsPerPage){		
		addSimpleOptions(SEC_USER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SecUserBlockingTokens currentPageNumberOfSecUserList(int currentPageNumber){		
		addSimpleOptions(SEC_USER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SecUserBlockingTokens retainColumnsOfSecUserList(String[] columns){		
		addSimpleOptions(SEC_USER_LIST+"RetainColumns",columns);
		return this;
	}
	public SecUserBlockingTokens excludeColumnsOfSecUserList(String[] columns){		
		addSimpleOptions(SEC_USER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  SecUserBlockingTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfSecUserList(verb, value);	
		return this;
	}
}

