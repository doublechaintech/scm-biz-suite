
package com.doublechaintech.retailscm.companytraining;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class CompanyTrainingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="companyTraining";
	
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
	protected CompanyTrainingTokens(){
		//ensure not initialized outside the class
	}
	public  static  CompanyTrainingTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		CompanyTrainingTokens tokens = new CompanyTrainingTokens(options);
		return tokens;
		
	}
	protected CompanyTrainingTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public CompanyTrainingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CompanyTrainingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CompanyTrainingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static CompanyTrainingTokens start(){
		return new CompanyTrainingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public CompanyTrainingTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static CompanyTrainingTokens allTokens(){
		
		return start()
			.withCompany()
			.withInstructor()
			.withTrainingCourseType()
			.withEmployeeCompanyTrainingList();
	
	}
	public static CompanyTrainingTokens withoutListsTokens(){
		
		return start()
			.withCompany()
			.withInstructor()
			.withTrainingCourseType();
	
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
	
	public CompanyTrainingTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public CompanyTrainingTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String INSTRUCTOR = "instructor";
	public String getInstructor(){
		return INSTRUCTOR;
	}
	public CompanyTrainingTokens withInstructor(){		
		addSimpleOptions(INSTRUCTOR);
		return this;
	}
	
	
	protected static final String TRAININGCOURSETYPE = "trainingCourseType";
	public String getTrainingCourseType(){
		return TRAININGCOURSETYPE;
	}
	public CompanyTrainingTokens withTrainingCourseType(){		
		addSimpleOptions(TRAININGCOURSETYPE);
		return this;
	}
	
	
	protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	public String getEmployeeCompanyTrainingList(){
		return EMPLOYEE_COMPANY_TRAINING_LIST;
	}
	public CompanyTrainingTokens withEmployeeCompanyTrainingList(){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
		return this;
	}
	public CompanyTrainingTokens analyzeEmployeeCompanyTrainingList(){		
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
	public CompanyTrainingTokens extractMoreFromEmployeeCompanyTrainingList(String idsSeperatedWithComma){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int employeeCompanyTrainingListSortCounter = 0;
	public CompanyTrainingTokens sortEmployeeCompanyTrainingListWith(String field, String descOrAsc){		
		addSortMoreOptions(EMPLOYEE_COMPANY_TRAINING_LIST,employeeCompanyTrainingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeCompanyTrainingListSearchCounter = 0;
	public CompanyTrainingTokens searchEmployeeCompanyTrainingListWith(String field, String verb, String value){		
		
		withEmployeeCompanyTrainingList();
		addSearchMoreOptions(EMPLOYEE_COMPANY_TRAINING_LIST,employeeCompanyTrainingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CompanyTrainingTokens searchAllTextOfEmployeeCompanyTrainingList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(EMPLOYEE_COMPANY_TRAINING_LIST,employeeCompanyTrainingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CompanyTrainingTokens rowsPerPageOfEmployeeCompanyTrainingList(int rowsPerPage){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CompanyTrainingTokens currentPageNumberOfEmployeeCompanyTrainingList(int currentPageNumber){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CompanyTrainingTokens retainColumnsOfEmployeeCompanyTrainingList(String[] columns){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"RetainColumns",columns);
		return this;
	}
	public CompanyTrainingTokens excludeColumnsOfEmployeeCompanyTrainingList(String[] columns){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  CompanyTrainingTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfEmployeeCompanyTrainingList(verb, value);	
		return this;
	}
}

