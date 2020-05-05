
package com.doublechaintech.retailscm.scoring;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ScoringTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="scoring";
	
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
	protected ScoringTokens(){
		//ensure not initialized outside the class
	}
	public  static  ScoringTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ScoringTokens tokens = new ScoringTokens(options);
		return tokens;
		
	}
	protected ScoringTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ScoringTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ScoringTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ScoringTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static ScoringTokens start(){
		return new ScoringTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public ScoringTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static ScoringTokens allTokens(){
		
		return start()
			.withEmployeeCompanyTrainingList();
	
	}
	public static ScoringTokens withoutListsTokens(){
		
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
	
	public ScoringTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	public String getEmployeeCompanyTrainingList(){
		return EMPLOYEE_COMPANY_TRAINING_LIST;
	}
	public ScoringTokens withEmployeeCompanyTrainingList(){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
		return this;
	}
	public ScoringTokens analyzeEmployeeCompanyTrainingList(){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEmployeeCompanyTrainingListEnabled(){		
		
		if(checkOptions(this.options(), EMPLOYEE_COMPANY_TRAINING_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ScoringTokens extractMoreFromEmployeeCompanyTrainingList(String idsSeperatedWithComma){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int employeeCompanyTrainingListSortCounter = 0;
	public ScoringTokens sortEmployeeCompanyTrainingListWith(String field, String descOrAsc){		
		addSortMoreOptions(EMPLOYEE_COMPANY_TRAINING_LIST,employeeCompanyTrainingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeCompanyTrainingListSearchCounter = 0;
	public ScoringTokens searchEmployeeCompanyTrainingListWith(String field, String verb, String value){		
		
		withEmployeeCompanyTrainingList();
		addSearchMoreOptions(EMPLOYEE_COMPANY_TRAINING_LIST,employeeCompanyTrainingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ScoringTokens searchAllTextOfEmployeeCompanyTrainingList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(EMPLOYEE_COMPANY_TRAINING_LIST,employeeCompanyTrainingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ScoringTokens rowsPerPageOfEmployeeCompanyTrainingList(int rowsPerPage){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ScoringTokens currentPageNumberOfEmployeeCompanyTrainingList(int currentPageNumber){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ScoringTokens retainColumnsOfEmployeeCompanyTrainingList(String[] columns){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"RetainColumns",columns);
		return this;
	}
	public ScoringTokens excludeColumnsOfEmployeeCompanyTrainingList(String[] columns){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ScoringTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfEmployeeCompanyTrainingList(verb, value);	
		return this;
	}
}

