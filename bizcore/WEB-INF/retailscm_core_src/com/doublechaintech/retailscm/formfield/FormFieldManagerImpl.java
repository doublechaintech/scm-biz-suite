
package com.doublechaintech.retailscm.formfield;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.genericform.GenericForm;

import com.doublechaintech.retailscm.genericform.CandidateGenericForm;







public class FormFieldManagerImpl extends CustomRetailscmCheckerManager implements FormFieldManager {
	
	private static final String SERVICE_TYPE = "FormField";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormFieldManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormFieldManagerException(message);

	}
	
	

 	protected FormField saveFormField(RetailscmUserContext userContext, FormField formField, String [] tokensExpr) throws Exception{	
 		//return getFormFieldDAO().save(formField, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormField(userContext, formField, tokens);
 	}
 	
 	protected FormField saveFormFieldDetail(RetailscmUserContext userContext, FormField formField) throws Exception{	

 		
 		return saveFormField(userContext, formField, allTokens());
 	}
 	
 	public FormField loadFormField(RetailscmUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().throwExceptionIfHasErrors( FormFieldManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormField formField = loadFormField( userContext, formFieldId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formField, tokens);
 	}
 	
 	
 	 public FormField searchFormField(RetailscmUserContext userContext, String formFieldId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().throwExceptionIfHasErrors( FormFieldManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormField formField = loadFormField( userContext, formFieldId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formField, tokens);
 	}
 	
 	

 	protected FormField present(RetailscmUserContext userContext, FormField formField, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formField,tokens);
		
		
		FormField  formFieldToPresent = userContext.getDAOGroup().getFormFieldDAO().present(formField, tokens);
		
		List<BaseEntity> entityListToNaming = formFieldToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getFormFieldDAO().alias(entityListToNaming);
		
		return  formFieldToPresent;
		
		
	}
 
 	
 	
 	public FormField loadFormFieldDetail(RetailscmUserContext userContext, String formFieldId) throws Exception{	
 		FormField formField = loadFormField( userContext, formFieldId, allTokens());
 		return present(userContext,formField, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String formFieldId) throws Exception{	
 		FormField formField = loadFormField( userContext, formFieldId, viewTokens());
 		return present(userContext,formField, allTokens());
		
 	}
 	protected FormField saveFormField(RetailscmUserContext userContext, FormField formField, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getFormFieldDAO().save(formField, tokens);
 	}
 	protected FormField loadFormField(RetailscmUserContext userContext, String formFieldId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().throwExceptionIfHasErrors( FormFieldManagerException.class);

 
 		return userContext.getDAOGroup().getFormFieldDAO().load(formFieldId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, FormField formField, Map<String, Object> tokens){
		super.addActions(userContext, formField, tokens);
		
		addAction(userContext, formField, tokens,"@create","createFormField","createFormField/","main","primary");
		addAction(userContext, formField, tokens,"@update","updateFormField","updateFormField/"+formField.getId()+"/","main","primary");
		addAction(userContext, formField, tokens,"@copy","cloneFormField","cloneFormField/"+formField.getId()+"/","main","primary");
		
		addAction(userContext, formField, tokens,"form_field.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formField.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, FormField formField, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormField createFormField(RetailscmUserContext userContext,String label, String localeKey, String parameterName, String type, String formId, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception
	{
		
		

		

		userContext.getChecker().checkLabelOfFormField(label);
		userContext.getChecker().checkLocaleKeyOfFormField(localeKey);
		userContext.getChecker().checkParameterNameOfFormField(parameterName);
		userContext.getChecker().checkTypeOfFormField(type);
		userContext.getChecker().checkPlaceholderOfFormField(placeholder);
		userContext.getChecker().checkDefaultValueOfFormField(defaultValue);
		userContext.getChecker().checkDescriptionOfFormField(description);
		userContext.getChecker().checkFieldGroupOfFormField(fieldGroup);
		userContext.getChecker().checkMinimumValueOfFormField(minimumValue);
		userContext.getChecker().checkMaximumValueOfFormField(maximumValue);
		userContext.getChecker().checkRequiredOfFormField(required);
		userContext.getChecker().checkDisabledOfFormField(disabled);
		userContext.getChecker().checkCustomRenderingOfFormField(customRendering);
		userContext.getChecker().checkCandidateValuesOfFormField(candidateValues);
		userContext.getChecker().checkSuggestValuesOfFormField(suggestValues);
	
		userContext.getChecker().throwExceptionIfHasErrors(FormFieldManagerException.class);


		FormField formField=createNewFormField();	

		formField.setLabel(label);
		formField.setLocaleKey(localeKey);
		formField.setParameterName(parameterName);
		formField.setType(type);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formField.setForm(form);
		
		
		formField.setPlaceholder(placeholder);
		formField.setDefaultValue(defaultValue);
		formField.setDescription(description);
		formField.setFieldGroup(fieldGroup);
		formField.setMinimumValue(minimumValue);
		formField.setMaximumValue(maximumValue);
		formField.setRequired(required);
		formField.setDisabled(disabled);
		formField.setCustomRendering(customRendering);
		formField.setCandidateValues(candidateValues);
		formField.setSuggestValues(suggestValues);

		formField = saveFormField(userContext, formField, emptyOptions());
		
		onNewInstanceCreated(userContext, formField);
		return formField;

		
	}
	protected FormField createNewFormField() 
	{
		
		return new FormField();		
	}
	
	protected void checkParamsForUpdatingFormField(RetailscmUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().checkVersionOfFormField( formFieldVersion);
		

		if(FormField.LABEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLabelOfFormField(parseString(newValueExpr));
		}
		if(FormField.LOCALE_KEY_PROPERTY.equals(property)){
			userContext.getChecker().checkLocaleKeyOfFormField(parseString(newValueExpr));
		}
		if(FormField.PARAMETER_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkParameterNameOfFormField(parseString(newValueExpr));
		}
		if(FormField.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfFormField(parseString(newValueExpr));
		}		

		
		if(FormField.PLACEHOLDER_PROPERTY.equals(property)){
			userContext.getChecker().checkPlaceholderOfFormField(parseString(newValueExpr));
		}
		if(FormField.DEFAULT_VALUE_PROPERTY.equals(property)){
			userContext.getChecker().checkDefaultValueOfFormField(parseString(newValueExpr));
		}
		if(FormField.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfFormField(parseString(newValueExpr));
		}
		if(FormField.FIELD_GROUP_PROPERTY.equals(property)){
			userContext.getChecker().checkFieldGroupOfFormField(parseString(newValueExpr));
		}
		if(FormField.MINIMUM_VALUE_PROPERTY.equals(property)){
			userContext.getChecker().checkMinimumValueOfFormField(parseString(newValueExpr));
		}
		if(FormField.MAXIMUM_VALUE_PROPERTY.equals(property)){
			userContext.getChecker().checkMaximumValueOfFormField(parseString(newValueExpr));
		}
		if(FormField.REQUIRED_PROPERTY.equals(property)){
			userContext.getChecker().checkRequiredOfFormField(parseBoolean(newValueExpr));
		}
		if(FormField.DISABLED_PROPERTY.equals(property)){
			userContext.getChecker().checkDisabledOfFormField(parseBoolean(newValueExpr));
		}
		if(FormField.CUSTOM_RENDERING_PROPERTY.equals(property)){
			userContext.getChecker().checkCustomRenderingOfFormField(parseBoolean(newValueExpr));
		}
		if(FormField.CANDIDATE_VALUES_PROPERTY.equals(property)){
			userContext.getChecker().checkCandidateValuesOfFormField(parseString(newValueExpr));
		}
		if(FormField.SUGGEST_VALUES_PROPERTY.equals(property)){
			userContext.getChecker().checkSuggestValuesOfFormField(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(FormFieldManagerException.class);
	
		
	}
	
	
	
	public FormField clone(RetailscmUserContext userContext, String fromFormFieldId) throws Exception{
		
		return userContext.getDAOGroup().getFormFieldDAO().clone(fromFormFieldId, this.allTokens());
	}
	
	public FormField internalSaveFormField(RetailscmUserContext userContext, FormField formField) throws Exception 
	{
		return internalSaveFormField(userContext, formField, allTokens());

	}
	public FormField internalSaveFormField(RetailscmUserContext userContext, FormField formField, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formField){ 
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			
			
			formField = saveFormField(userContext, formField, options);
			return formField;
			
		}

	}
	
	public FormField updateFormField(RetailscmUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormField formField = loadFormField(userContext, formFieldId, allTokens());
		if(formField.getVersion() != formFieldVersion){
			String message = "The target version("+formField.getVersion()+") is not equals to version("+formFieldVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formField){ 
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			
			formField.changeProperty(property, newValueExpr);
			formField = saveFormField(userContext, formField, tokens().done());
			return present(userContext,formField, mergedAllTokens(tokensExpr));
			//return saveFormField(userContext, formField, tokens().done());
		}

	}
	
	public FormField updateFormFieldProperty(RetailscmUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);
		
		FormField formField = loadFormField(userContext, formFieldId, allTokens());
		if(formField.getVersion() != formFieldVersion){
			String message = "The target version("+formField.getVersion()+") is not equals to version("+formFieldVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formField){ 
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			
			formField.changeProperty(property, newValueExpr);
			
			formField = saveFormField(userContext, formField, tokens().done());
			return present(userContext,formField, mergedAllTokens(tokensExpr));
			//return saveFormField(userContext, formField, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormFieldTokens tokens(){
		return FormFieldTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormFieldTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormFieldTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(RetailscmUserContext userContext, String formFieldId, String anotherFormId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfFormField(formFieldId);
 		userContext.getChecker().checkIdOfGenericForm(anotherFormId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(FormFieldManagerException.class);
 		
 	}
 	public FormField transferToAnotherForm(RetailscmUserContext userContext, String formFieldId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formFieldId,anotherFormId);
 
		FormField formField = loadFormField(userContext, formFieldId, allTokens());	
		synchronized(formField){
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formField.updateForm(form);		
			formField = saveFormField(userContext, formField, emptyOptions());
			
			return present(userContext,formField, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGenericForm requestCandidateForm(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGenericForm result = new CandidateGenericForm();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GenericForm> candidateList = userContext.getDAOGroup().getGenericFormDAO().requestCandidateGenericFormForFormField(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GenericForm loadGenericForm(RetailscmUserContext userContext, String newFormId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGenericFormDAO().load(newFormId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String formFieldId, int formFieldVersion) throws Exception {
		//deleteInternal(userContext, formFieldId, formFieldVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String formFieldId, int formFieldVersion) throws Exception{
			
		userContext.getDAOGroup().getFormFieldDAO().delete(formFieldId, formFieldVersion);
	}
	
	public FormField forgetByAll(RetailscmUserContext userContext, String formFieldId, int formFieldVersion) throws Exception {
		return forgetByAllInternal(userContext, formFieldId, formFieldVersion);		
	}
	protected FormField forgetByAllInternal(RetailscmUserContext userContext,
			String formFieldId, int formFieldVersion) throws Exception{
			
		return userContext.getDAOGroup().getFormFieldDAO().disconnectFromAll(formFieldId, formFieldVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormFieldManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getFormFieldDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, FormField newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


