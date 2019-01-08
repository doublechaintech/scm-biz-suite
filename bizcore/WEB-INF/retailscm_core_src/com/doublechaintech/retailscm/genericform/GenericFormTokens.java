
package com.doublechaintech.retailscm.genericform;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class GenericFormTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="genericForm";
	
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
	protected GenericFormTokens(){
		//ensure not initialized outside the class
	}
	
	public GenericFormTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GenericFormTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GenericFormTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GenericFormTokens start(){
		return new GenericFormTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GenericFormTokens allTokens(){
		
		return start()
			.withFormMessageList()
			.withFormFieldMessageList()
			.withFormFieldList()
			.withFormActionList();
	
	}
	public static GenericFormTokens withoutListsTokens(){
		
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

	protected static final String FORM_MESSAGE_LIST = "formMessageList";
	public String getFormMessageList(){
		return FORM_MESSAGE_LIST;
	}
	public GenericFormTokens withFormMessageList(){		
		addSimpleOptions(FORM_MESSAGE_LIST);
		return this;
	}
	public GenericFormTokens analyzeFormMessageList(){		
		addSimpleOptions(FORM_MESSAGE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFormMessageListEnabled(){		
		
		return checkOptions(this.options(), FORM_MESSAGE_LIST+".anaylze");
	}
	public GenericFormTokens extractMoreFromFormMessageList(String idsSeperatedWithComma){		
		addSimpleOptions(FORM_MESSAGE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int formMessageListSortCounter = 0;
	public GenericFormTokens sortFormMessageListWith(String field, String descOrAsc){		
		addSortMoreOptions(FORM_MESSAGE_LIST,formMessageListSortCounter++, field, descOrAsc);
		return this;
	}
	private int formMessageListSearchCounter = 0;
	public GenericFormTokens searchFormMessageListWith(String field, String verb, String value){		
		addSearchMoreOptions(FORM_MESSAGE_LIST,formMessageListSearchCounter++, field, verb, value);
		return this;
	}
	
	public GenericFormTokens searchAllTextOfFormMessageList(String verb, String value){	
		String field = "id|title|level";
		addSearchMoreOptions(FORM_MESSAGE_LIST,formMessageListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GenericFormTokens rowsPerPageOfFormMessageList(int rowsPerPage){		
		addSimpleOptions(FORM_MESSAGE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GenericFormTokens currentPageNumberOfFormMessageList(int currentPageNumber){		
		addSimpleOptions(FORM_MESSAGE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GenericFormTokens retainColumnsOfFormMessageList(String[] columns){		
		addSimpleOptions(FORM_MESSAGE_LIST+"RetainColumns",columns);
		return this;
	}
	public GenericFormTokens excludeColumnsOfFormMessageList(String[] columns){		
		addSimpleOptions(FORM_MESSAGE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FORM_FIELD_MESSAGE_LIST = "formFieldMessageList";
	public String getFormFieldMessageList(){
		return FORM_FIELD_MESSAGE_LIST;
	}
	public GenericFormTokens withFormFieldMessageList(){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST);
		return this;
	}
	public GenericFormTokens analyzeFormFieldMessageList(){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFormFieldMessageListEnabled(){		
		
		return checkOptions(this.options(), FORM_FIELD_MESSAGE_LIST+".anaylze");
	}
	public GenericFormTokens extractMoreFromFormFieldMessageList(String idsSeperatedWithComma){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int formFieldMessageListSortCounter = 0;
	public GenericFormTokens sortFormFieldMessageListWith(String field, String descOrAsc){		
		addSortMoreOptions(FORM_FIELD_MESSAGE_LIST,formFieldMessageListSortCounter++, field, descOrAsc);
		return this;
	}
	private int formFieldMessageListSearchCounter = 0;
	public GenericFormTokens searchFormFieldMessageListWith(String field, String verb, String value){		
		addSearchMoreOptions(FORM_FIELD_MESSAGE_LIST,formFieldMessageListSearchCounter++, field, verb, value);
		return this;
	}
	
	public GenericFormTokens searchAllTextOfFormFieldMessageList(String verb, String value){	
		String field = "id|title|parameterName|level";
		addSearchMoreOptions(FORM_FIELD_MESSAGE_LIST,formFieldMessageListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GenericFormTokens rowsPerPageOfFormFieldMessageList(int rowsPerPage){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GenericFormTokens currentPageNumberOfFormFieldMessageList(int currentPageNumber){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GenericFormTokens retainColumnsOfFormFieldMessageList(String[] columns){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST+"RetainColumns",columns);
		return this;
	}
	public GenericFormTokens excludeColumnsOfFormFieldMessageList(String[] columns){		
		addSimpleOptions(FORM_FIELD_MESSAGE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FORM_FIELD_LIST = "formFieldList";
	public String getFormFieldList(){
		return FORM_FIELD_LIST;
	}
	public GenericFormTokens withFormFieldList(){		
		addSimpleOptions(FORM_FIELD_LIST);
		return this;
	}
	public GenericFormTokens analyzeFormFieldList(){		
		addSimpleOptions(FORM_FIELD_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFormFieldListEnabled(){		
		
		return checkOptions(this.options(), FORM_FIELD_LIST+".anaylze");
	}
	public GenericFormTokens extractMoreFromFormFieldList(String idsSeperatedWithComma){		
		addSimpleOptions(FORM_FIELD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int formFieldListSortCounter = 0;
	public GenericFormTokens sortFormFieldListWith(String field, String descOrAsc){		
		addSortMoreOptions(FORM_FIELD_LIST,formFieldListSortCounter++, field, descOrAsc);
		return this;
	}
	private int formFieldListSearchCounter = 0;
	public GenericFormTokens searchFormFieldListWith(String field, String verb, String value){		
		addSearchMoreOptions(FORM_FIELD_LIST,formFieldListSearchCounter++, field, verb, value);
		return this;
	}
	
	public GenericFormTokens searchAllTextOfFormFieldList(String verb, String value){	
		String field = "id|label|localeKey|parameterName|type|placeholder|defaultValue|description|fieldGroup|minimumValue|maximumValue|candidateValues|suggestValues";
		addSearchMoreOptions(FORM_FIELD_LIST,formFieldListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GenericFormTokens rowsPerPageOfFormFieldList(int rowsPerPage){		
		addSimpleOptions(FORM_FIELD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GenericFormTokens currentPageNumberOfFormFieldList(int currentPageNumber){		
		addSimpleOptions(FORM_FIELD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GenericFormTokens retainColumnsOfFormFieldList(String[] columns){		
		addSimpleOptions(FORM_FIELD_LIST+"RetainColumns",columns);
		return this;
	}
	public GenericFormTokens excludeColumnsOfFormFieldList(String[] columns){		
		addSimpleOptions(FORM_FIELD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FORM_ACTION_LIST = "formActionList";
	public String getFormActionList(){
		return FORM_ACTION_LIST;
	}
	public GenericFormTokens withFormActionList(){		
		addSimpleOptions(FORM_ACTION_LIST);
		return this;
	}
	public GenericFormTokens analyzeFormActionList(){		
		addSimpleOptions(FORM_ACTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFormActionListEnabled(){		
		
		return checkOptions(this.options(), FORM_ACTION_LIST+".anaylze");
	}
	public GenericFormTokens extractMoreFromFormActionList(String idsSeperatedWithComma){		
		addSimpleOptions(FORM_ACTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int formActionListSortCounter = 0;
	public GenericFormTokens sortFormActionListWith(String field, String descOrAsc){		
		addSortMoreOptions(FORM_ACTION_LIST,formActionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int formActionListSearchCounter = 0;
	public GenericFormTokens searchFormActionListWith(String field, String verb, String value){		
		addSearchMoreOptions(FORM_ACTION_LIST,formActionListSearchCounter++, field, verb, value);
		return this;
	}
	
	public GenericFormTokens searchAllTextOfFormActionList(String verb, String value){	
		String field = "id|label|localeKey|actionKey|level|url";
		addSearchMoreOptions(FORM_ACTION_LIST,formActionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GenericFormTokens rowsPerPageOfFormActionList(int rowsPerPage){		
		addSimpleOptions(FORM_ACTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GenericFormTokens currentPageNumberOfFormActionList(int currentPageNumber){		
		addSimpleOptions(FORM_ACTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GenericFormTokens retainColumnsOfFormActionList(String[] columns){		
		addSimpleOptions(FORM_ACTION_LIST+"RetainColumns",columns);
		return this;
	}
	public GenericFormTokens excludeColumnsOfFormActionList(String[] columns){		
		addSimpleOptions(FORM_ACTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  GenericFormTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfFormMessageList(verb, value);	
		searchAllTextOfFormFieldMessageList(verb, value);	
		searchAllTextOfFormFieldList(verb, value);	
		searchAllTextOfFormActionList(verb, value);	
		return this;
	}
}

