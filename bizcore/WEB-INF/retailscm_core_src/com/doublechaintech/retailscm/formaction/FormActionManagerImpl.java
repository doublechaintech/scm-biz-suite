
package com.doublechaintech.retailscm.formaction;

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







public class FormActionManagerImpl extends CustomRetailscmCheckerManager implements FormActionManager {
	
	private static final String SERVICE_TYPE = "FormAction";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormActionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormActionManagerException(message);

	}
	
	

 	protected FormAction saveFormAction(RetailscmUserContext userContext, FormAction formAction, String [] tokensExpr) throws Exception{	
 		//return getFormActionDAO().save(formAction, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormAction(userContext, formAction, tokens);
 	}
 	
 	protected FormAction saveFormActionDetail(RetailscmUserContext userContext, FormAction formAction) throws Exception{	

 		
 		return saveFormAction(userContext, formAction, allTokens());
 	}
 	
 	public FormAction loadFormAction(RetailscmUserContext userContext, String formActionId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().throwExceptionIfHasErrors( FormActionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	
 	 public FormAction searchFormAction(RetailscmUserContext userContext, String formActionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().throwExceptionIfHasErrors( FormActionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	

 	protected FormAction present(RetailscmUserContext userContext, FormAction formAction, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formAction,tokens);
		
		
		FormAction  formActionToPresent = userContext.getDAOGroup().getFormActionDAO().present(formAction, tokens);
		
		List<BaseEntity> entityListToNaming = formActionToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getFormActionDAO().alias(entityListToNaming);
		
		return  formActionToPresent;
		
		
	}
 
 	
 	
 	public FormAction loadFormActionDetail(RetailscmUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, allTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, viewTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	protected FormAction saveFormAction(RetailscmUserContext userContext, FormAction formAction, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getFormActionDAO().save(formAction, tokens);
 	}
 	protected FormAction loadFormAction(RetailscmUserContext userContext, String formActionId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().throwExceptionIfHasErrors( FormActionManagerException.class);

 
 		return userContext.getDAOGroup().getFormActionDAO().load(formActionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, FormAction formAction, Map<String, Object> tokens){
		super.addActions(userContext, formAction, tokens);
		
		addAction(userContext, formAction, tokens,"@create","createFormAction","createFormAction/","main","primary");
		addAction(userContext, formAction, tokens,"@update","updateFormAction","updateFormAction/"+formAction.getId()+"/","main","primary");
		addAction(userContext, formAction, tokens,"@copy","cloneFormAction","cloneFormAction/"+formAction.getId()+"/","main","primary");
		
		addAction(userContext, formAction, tokens,"form_action.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formAction.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, FormAction formAction, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormAction createFormAction(RetailscmUserContext userContext,String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception
	{
		
		

		

		userContext.getChecker().checkLabelOfFormAction(label);
		userContext.getChecker().checkLocaleKeyOfFormAction(localeKey);
		userContext.getChecker().checkActionKeyOfFormAction(actionKey);
		userContext.getChecker().checkLevelOfFormAction(level);
		userContext.getChecker().checkUrlOfFormAction(url);
	
		userContext.getChecker().throwExceptionIfHasErrors(FormActionManagerException.class);


		FormAction formAction=createNewFormAction();	

		formAction.setLabel(label);
		formAction.setLocaleKey(localeKey);
		formAction.setActionKey(actionKey);
		formAction.setLevel(level);
		formAction.setUrl(url);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formAction.setForm(form);
		
		

		formAction = saveFormAction(userContext, formAction, emptyOptions());
		
		onNewInstanceCreated(userContext, formAction);
		return formAction;

		
	}
	protected FormAction createNewFormAction() 
	{
		
		return new FormAction();		
	}
	
	protected void checkParamsForUpdatingFormAction(RetailscmUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().checkVersionOfFormAction( formActionVersion);
		

		if(FormAction.LABEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLabelOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.LOCALE_KEY_PROPERTY.equals(property)){
			userContext.getChecker().checkLocaleKeyOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.ACTION_KEY_PROPERTY.equals(property)){
			userContext.getChecker().checkActionKeyOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.LEVEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLevelOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.URL_PROPERTY.equals(property)){
			userContext.getChecker().checkUrlOfFormAction(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(FormActionManagerException.class);
	
		
	}
	
	
	
	public FormAction clone(RetailscmUserContext userContext, String fromFormActionId) throws Exception{
		
		return userContext.getDAOGroup().getFormActionDAO().clone(fromFormActionId, this.allTokens());
	}
	
	public FormAction internalSaveFormAction(RetailscmUserContext userContext, FormAction formAction) throws Exception 
	{
		return internalSaveFormAction(userContext, formAction, allTokens());

	}
	public FormAction internalSaveFormAction(RetailscmUserContext userContext, FormAction formAction, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formAction){ 
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			
			formAction = saveFormAction(userContext, formAction, options);
			return formAction;
			
		}

	}
	
	public FormAction updateFormAction(RetailscmUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){ 
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			formAction.changeProperty(property, newValueExpr);
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}
	
	public FormAction updateFormActionProperty(RetailscmUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);
		
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){ 
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			formAction.changeProperty(property, newValueExpr);
			
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormActionTokens tokens(){
		return FormActionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormActionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormActionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(RetailscmUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfFormAction(formActionId);
 		userContext.getChecker().checkIdOfGenericForm(anotherFormId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(FormActionManagerException.class);
 		
 	}
 	public FormAction transferToAnotherForm(RetailscmUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formActionId,anotherFormId);
 
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());	
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formAction.updateForm(form);		
			formAction = saveFormAction(userContext, formAction, emptyOptions());
			
			return present(userContext,formAction, allTokens());
			
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
		SmartList<GenericForm> candidateList = userContext.getDAOGroup().getGenericFormDAO().requestCandidateGenericFormForFormAction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		//deleteInternal(userContext, formActionId, formActionVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{
			
		userContext.getDAOGroup().getFormActionDAO().delete(formActionId, formActionVersion);
	}
	
	public FormAction forgetByAll(RetailscmUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		return forgetByAllInternal(userContext, formActionId, formActionVersion);		
	}
	protected FormAction forgetByAllInternal(RetailscmUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{
			
		return userContext.getDAOGroup().getFormActionDAO().disconnectFromAll(formActionId, formActionVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormActionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getFormActionDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, FormAction newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}










