
package com.doublechaintech.retailscm.trainingcoursetype;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class TrainingCourseTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="trainingCourseType";
	
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
	protected TrainingCourseTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  TrainingCourseTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TrainingCourseTypeTokens tokens = new TrainingCourseTypeTokens(options);
		return tokens;
		
	}
	protected TrainingCourseTypeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TrainingCourseTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TrainingCourseTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TrainingCourseTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static TrainingCourseTypeTokens start(){
		return new TrainingCourseTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public TrainingCourseTypeTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static TrainingCourseTypeTokens allTokens(){
		
		return start()
			.withCompany()
			.withCompanyTrainingList();
	
	}
	public static TrainingCourseTypeTokens withoutListsTokens(){
		
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
	
	public TrainingCourseTypeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public TrainingCourseTypeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";
	public String getCompanyTrainingList(){
		return COMPANY_TRAINING_LIST;
	}
	public TrainingCourseTypeTokens withCompanyTrainingList(){		
		addSimpleOptions(COMPANY_TRAINING_LIST);
		return this;
	}
	public TrainingCourseTypeTokens analyzeCompanyTrainingList(){		
		addSimpleOptions(COMPANY_TRAINING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCompanyTrainingListEnabled(){		
		
		if(checkOptions(this.options(), COMPANY_TRAINING_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public TrainingCourseTypeTokens extractMoreFromCompanyTrainingList(String idsSeperatedWithComma){		
		addSimpleOptions(COMPANY_TRAINING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int companyTrainingListSortCounter = 0;
	public TrainingCourseTypeTokens sortCompanyTrainingListWith(String field, String descOrAsc){		
		addSortMoreOptions(COMPANY_TRAINING_LIST,companyTrainingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int companyTrainingListSearchCounter = 0;
	public TrainingCourseTypeTokens searchCompanyTrainingListWith(String field, String verb, String value){		
		
		withCompanyTrainingList();
		addSearchMoreOptions(COMPANY_TRAINING_LIST,companyTrainingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TrainingCourseTypeTokens searchAllTextOfCompanyTrainingList(String verb, String value){	
		String field = "id|title";
		addSearchMoreOptions(COMPANY_TRAINING_LIST,companyTrainingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TrainingCourseTypeTokens rowsPerPageOfCompanyTrainingList(int rowsPerPage){		
		addSimpleOptions(COMPANY_TRAINING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TrainingCourseTypeTokens currentPageNumberOfCompanyTrainingList(int currentPageNumber){		
		addSimpleOptions(COMPANY_TRAINING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TrainingCourseTypeTokens retainColumnsOfCompanyTrainingList(String[] columns){		
		addSimpleOptions(COMPANY_TRAINING_LIST+"RetainColumns",columns);
		return this;
	}
	public TrainingCourseTypeTokens excludeColumnsOfCompanyTrainingList(String[] columns){		
		addSimpleOptions(COMPANY_TRAINING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TrainingCourseTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfCompanyTrainingList(verb, value);	
		return this;
	}
}

