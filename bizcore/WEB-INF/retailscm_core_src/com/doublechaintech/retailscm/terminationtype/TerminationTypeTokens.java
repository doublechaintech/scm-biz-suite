
package com.doublechaintech.retailscm.terminationtype;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class TerminationTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="terminationType";
	
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
	protected TerminationTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  TerminationTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TerminationTypeTokens tokens = new TerminationTypeTokens(options);
		return tokens;
		
	}
	protected TerminationTypeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TerminationTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TerminationTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TerminationTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static TerminationTypeTokens start(){
		return new TerminationTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public TerminationTypeTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static TerminationTypeTokens allTokens(){
		
		return start()
			.withCompany()
			.withTerminationList();
	
	}
	public static TerminationTypeTokens withoutListsTokens(){
		
		return start()
			.withCompany();
	
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
	
	public TerminationTypeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public TerminationTypeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String TERMINATION_LIST = "terminationList";
	public String getTerminationList(){
		return TERMINATION_LIST;
	}
	public TerminationTypeTokens withTerminationList(){		
		addSimpleOptions(TERMINATION_LIST);
		return this;
	}
	public TerminationTypeTokens analyzeTerminationList(){		
		addSimpleOptions(TERMINATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTerminationListEnabled(){		
		
		if(checkOptions(this.options(), TERMINATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public TerminationTypeTokens extractMoreFromTerminationList(String idsSeperatedWithComma){		
		addSimpleOptions(TERMINATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int terminationListSortCounter = 0;
	public TerminationTypeTokens sortTerminationListWith(String field, String descOrAsc){		
		addSortMoreOptions(TERMINATION_LIST,terminationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int terminationListSearchCounter = 0;
	public TerminationTypeTokens searchTerminationListWith(String field, String verb, String value){		
		
		withTerminationList();
		addSearchMoreOptions(TERMINATION_LIST,terminationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TerminationTypeTokens searchAllTextOfTerminationList(String verb, String value){	
		String field = "id|comment";
		addSearchMoreOptions(TERMINATION_LIST,terminationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TerminationTypeTokens rowsPerPageOfTerminationList(int rowsPerPage){		
		addSimpleOptions(TERMINATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TerminationTypeTokens currentPageNumberOfTerminationList(int currentPageNumber){		
		addSimpleOptions(TERMINATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TerminationTypeTokens retainColumnsOfTerminationList(String[] columns){		
		addSimpleOptions(TERMINATION_LIST+"RetainColumns",columns);
		return this;
	}
	public TerminationTypeTokens excludeColumnsOfTerminationList(String[] columns){		
		addSimpleOptions(TERMINATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TerminationTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTerminationList(verb, value);	
		return this;
	}
}

