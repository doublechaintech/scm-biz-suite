
package com.doublechaintech.retailscm.genericform;

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

import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;
import com.doublechaintech.retailscm.formfield.FormField;


import com.doublechaintech.retailscm.genericform.GenericForm;






public class GenericFormManagerImpl extends CustomRetailscmCheckerManager implements GenericFormManager {
	
	private static final String SERVICE_TYPE = "GenericForm";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws GenericFormManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new GenericFormManagerException(message);

	}
	
	

 	protected GenericForm saveGenericForm(RetailscmUserContext userContext, GenericForm genericForm, String [] tokensExpr) throws Exception{	
 		//return getGenericFormDAO().save(genericForm, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGenericForm(userContext, genericForm, tokens);
 	}
 	
 	protected GenericForm saveGenericFormDetail(RetailscmUserContext userContext, GenericForm genericForm) throws Exception{	

 		
 		return saveGenericForm(userContext, genericForm, allTokens());
 	}
 	
 	public GenericForm loadGenericForm(RetailscmUserContext userContext, String genericFormId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().throwExceptionIfHasErrors( GenericFormManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,genericForm, tokens);
 	}
 	
 	
 	 public GenericForm searchGenericForm(RetailscmUserContext userContext, String genericFormId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().throwExceptionIfHasErrors( GenericFormManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,genericForm, tokens);
 	}
 	
 	

 	protected GenericForm present(RetailscmUserContext userContext, GenericForm genericForm, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,genericForm,tokens);
		
		
		GenericForm  genericFormToPresent = userContext.getDAOGroup().getGenericFormDAO().present(genericForm, tokens);
		
		List<BaseEntity> entityListToNaming = genericFormToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getGenericFormDAO().alias(entityListToNaming);
		
		return  genericFormToPresent;
		
		
	}
 
 	
 	
 	public GenericForm loadGenericFormDetail(RetailscmUserContext userContext, String genericFormId) throws Exception{	
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, allTokens());
 		return present(userContext,genericForm, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String genericFormId) throws Exception{	
 		GenericForm genericForm = loadGenericForm( userContext, genericFormId, viewTokens());
 		return present(userContext,genericForm, allTokens());
		
 	}
 	protected GenericForm saveGenericForm(RetailscmUserContext userContext, GenericForm genericForm, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getGenericFormDAO().save(genericForm, tokens);
 	}
 	protected GenericForm loadGenericForm(RetailscmUserContext userContext, String genericFormId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().throwExceptionIfHasErrors( GenericFormManagerException.class);

 
 		return userContext.getDAOGroup().getGenericFormDAO().load(genericFormId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GenericForm genericForm, Map<String, Object> tokens){
		super.addActions(userContext, genericForm, tokens);
		
		addAction(userContext, genericForm, tokens,"@create","createGenericForm","createGenericForm/","main","primary");
		addAction(userContext, genericForm, tokens,"@update","updateGenericForm","updateGenericForm/"+genericForm.getId()+"/","main","primary");
		addAction(userContext, genericForm, tokens,"@copy","cloneGenericForm","cloneGenericForm/"+genericForm.getId()+"/","main","primary");
		
		addAction(userContext, genericForm, tokens,"generic_form.addFormMessage","addFormMessage","addFormMessage/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormMessage","removeFormMessage","removeFormMessage/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormMessage","updateFormMessage","updateFormMessage/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormMessageFrom","copyFormMessageFrom","copyFormMessageFrom/"+genericForm.getId()+"/","formMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.addFormFieldMessage","addFormFieldMessage","addFormFieldMessage/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormFieldMessage","removeFormFieldMessage","removeFormFieldMessage/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormFieldMessage","updateFormFieldMessage","updateFormFieldMessage/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormFieldMessageFrom","copyFormFieldMessageFrom","copyFormFieldMessageFrom/"+genericForm.getId()+"/","formFieldMessageList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.addFormField","addFormField","addFormField/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormField","removeFormField","removeFormField/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormField","updateFormField","updateFormField/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormFieldFrom","copyFormFieldFrom","copyFormFieldFrom/"+genericForm.getId()+"/","formFieldList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.addFormAction","addFormAction","addFormAction/"+genericForm.getId()+"/","formActionList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.removeFormAction","removeFormAction","removeFormAction/"+genericForm.getId()+"/","formActionList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.updateFormAction","updateFormAction","updateFormAction/"+genericForm.getId()+"/","formActionList","primary");
		addAction(userContext, genericForm, tokens,"generic_form.copyFormActionFrom","copyFormActionFrom","copyFormActionFrom/"+genericForm.getId()+"/","formActionList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GenericForm genericForm, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GenericForm createGenericForm(RetailscmUserContext userContext,String title, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfGenericForm(title);
		userContext.getChecker().checkDescriptionOfGenericForm(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);


		GenericForm genericForm=createNewGenericForm();	

		genericForm.setTitle(title);
		genericForm.setDescription(description);

		genericForm = saveGenericForm(userContext, genericForm, emptyOptions());
		
		onNewInstanceCreated(userContext, genericForm);
		return genericForm;

		
	}
	protected GenericForm createNewGenericForm() 
	{
		
		return new GenericForm();		
	}
	
	protected void checkParamsForUpdatingGenericForm(RetailscmUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkVersionOfGenericForm( genericFormVersion);
		

		if(GenericForm.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfGenericForm(parseString(newValueExpr));
		}
		if(GenericForm.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfGenericForm(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
		
	}
	
	
	
	public GenericForm clone(RetailscmUserContext userContext, String fromGenericFormId) throws Exception{
		
		return userContext.getDAOGroup().getGenericFormDAO().clone(fromGenericFormId, this.allTokens());
	}
	
	public GenericForm internalSaveGenericForm(RetailscmUserContext userContext, GenericForm genericForm) throws Exception 
	{
		return internalSaveGenericForm(userContext, genericForm, allTokens());

	}
	public GenericForm internalSaveGenericForm(RetailscmUserContext userContext, GenericForm genericForm, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingGenericForm(userContext, genericFormId, genericFormVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(genericForm){ 
			//will be good when the genericForm loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GenericForm.
			
			
			genericForm = saveGenericForm(userContext, genericForm, options);
			return genericForm;
			
		}

	}
	
	public GenericForm updateGenericForm(RetailscmUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGenericForm(userContext, genericFormId, genericFormVersion, property, newValueExpr, tokensExpr);
		
		
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		if(genericForm.getVersion() != genericFormVersion){
			String message = "The target version("+genericForm.getVersion()+") is not equals to version("+genericFormVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(genericForm){ 
			//will be good when the genericForm loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GenericForm.
			
			genericForm.changeProperty(property, newValueExpr);
			genericForm = saveGenericForm(userContext, genericForm, tokens().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			//return saveGenericForm(userContext, genericForm, tokens().done());
		}

	}
	
	public GenericForm updateGenericFormProperty(RetailscmUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGenericForm(userContext, genericFormId, genericFormVersion, property, newValueExpr, tokensExpr);
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		if(genericForm.getVersion() != genericFormVersion){
			String message = "The target version("+genericForm.getVersion()+") is not equals to version("+genericFormVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(genericForm){ 
			//will be good when the genericForm loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GenericForm.
			
			genericForm.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			//return saveGenericForm(userContext, genericForm, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GenericFormTokens tokens(){
		return GenericFormTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GenericFormTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortFormMessageListWith("id","desc")
		.sortFormFieldMessageListWith("id","desc")
		.sortFormFieldListWith("id","desc")
		.sortFormActionListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GenericFormTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String genericFormId, int genericFormVersion) throws Exception {
		//deleteInternal(userContext, genericFormId, genericFormVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String genericFormId, int genericFormVersion) throws Exception{
			
		userContext.getDAOGroup().getGenericFormDAO().delete(genericFormId, genericFormVersion);
	}
	
	public GenericForm forgetByAll(RetailscmUserContext userContext, String genericFormId, int genericFormVersion) throws Exception {
		return forgetByAllInternal(userContext, genericFormId, genericFormVersion);		
	}
	protected GenericForm forgetByAllInternal(RetailscmUserContext userContext,
			String genericFormId, int genericFormVersion) throws Exception{
			
		return userContext.getDAOGroup().getGenericFormDAO().disconnectFromAll(genericFormId, genericFormVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GenericFormManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getGenericFormDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingFormMessage(RetailscmUserContext userContext, String genericFormId, String title, String level,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);

		
		userContext.getChecker().checkTitleOfFormMessage(title);
		
		userContext.getChecker().checkLevelOfFormMessage(level);
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);

	
	}
	public  GenericForm addFormMessage(RetailscmUserContext userContext, String genericFormId, String title, String level, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFormMessage(userContext,genericFormId,title, level,tokensExpr);
		
		FormMessage formMessage = createFormMessage(userContext,title, level);
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormMessage( formMessage );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			
			userContext.getManagerGroup().getFormMessageManager().onNewInstanceCreated(userContext, formMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormMessageProperties(RetailscmUserContext userContext, String genericFormId,String id,String title,String level,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormMessage(id);
		
		userContext.getChecker().checkTitleOfFormMessage( title);
		userContext.getChecker().checkLevelOfFormMessage( level);

		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm updateFormMessageProperties(RetailscmUserContext userContext, String genericFormId, String id,String title,String level, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFormMessageProperties(userContext,genericFormId,id,title,level,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormMessageListList()
				.searchFormMessageListWith(FormMessage.ID_PROPERTY, "is", id).done();
		
		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);
		
		if(genericFormToUpdate.getFormMessageList().isEmpty()){
			throw new GenericFormManagerException("FormMessage is NOT FOUND with id: '"+id+"'");
		}
		
		FormMessage item = genericFormToUpdate.getFormMessageList().first();
		
		item.updateTitle( title );
		item.updateLevel( level );

		
		//checkParamsForAddingFormMessage(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormMessageList().done());
		synchronized(genericForm){ 
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FormMessage createFormMessage(RetailscmUserContext userContext, String title, String level) throws Exception{

		FormMessage formMessage = new FormMessage();
		
		
		formMessage.setTitle(title);		
		formMessage.setLevel(level);
	
		
		return formMessage;
	
		
	}
	
	protected FormMessage createIndexedFormMessage(String id, int version){

		FormMessage formMessage = new FormMessage();
		formMessage.setId(id);
		formMessage.setVersion(version);
		return formMessage;			
		
	}
	
	protected void checkParamsForRemovingFormMessageList(RetailscmUserContext userContext, String genericFormId, 
			String formMessageIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		for(String formMessageId: formMessageIds){
			userContext.getChecker().checkIdOfFormMessage(formMessageId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm removeFormMessageList(RetailscmUserContext userContext, String genericFormId, 
			String formMessageIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFormMessageList(userContext, genericFormId,  formMessageIds, tokensExpr);
			
			
			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){ 
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGenericFormDAO().planToRemoveFormMessageList(genericForm, formMessageIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormMessageList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFormMessage(RetailscmUserContext userContext, String genericFormId, 
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormMessage(formMessageId);
		userContext.getChecker().checkVersionOfFormMessage(formMessageVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm removeFormMessage(RetailscmUserContext userContext, String genericFormId, 
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFormMessage(userContext,genericFormId, formMessageId, formMessageVersion,tokensExpr);
		
		FormMessage formMessage = createIndexedFormMessage(formMessageId, formMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormMessage( formMessage );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			deleteRelationInGraph(userContext, formMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFormMessage(RetailscmUserContext userContext, String genericFormId, 
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormMessage(formMessageId);
		userContext.getChecker().checkVersionOfFormMessage(formMessageVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm copyFormMessageFrom(RetailscmUserContext userContext, String genericFormId, 
		String formMessageId, int formMessageVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFormMessage(userContext,genericFormId, formMessageId, formMessageVersion,tokensExpr);
		
		FormMessage formMessage = createIndexedFormMessage(formMessageId, formMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			genericForm.copyFormMessageFrom( formMessage );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			
			userContext.getManagerGroup().getFormMessageManager().onNewInstanceCreated(userContext, (FormMessage)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFormMessage(RetailscmUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormMessage(formMessageId);
		userContext.getChecker().checkVersionOfFormMessage(formMessageVersion);
		

		if(FormMessage.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfFormMessage(parseString(newValueExpr));
		}
		
		if(FormMessage.LEVEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLevelOfFormMessage(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	
	public  GenericForm updateFormMessage(RetailscmUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFormMessage(userContext, genericFormId, formMessageId, formMessageVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFormMessageList().searchFormMessageListWith(FormMessage.ID_PROPERTY, "eq", formMessageId).done();
		
		
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);
		
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormMessage( formMessage );	
			//make changes to AcceleraterAccount.
			FormMessage formMessageIndex = createIndexedFormMessage(formMessageId, formMessageVersion);
		
			FormMessage formMessage = genericForm.findTheFormMessage(formMessageIndex);
			if(formMessage == null){
				throw new GenericFormManagerException(formMessage+" is NOT FOUND" );
			}
			
			formMessage.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormMessageList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFormFieldMessage(RetailscmUserContext userContext, String genericFormId, String title, String parameterName, String level,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);

		
		userContext.getChecker().checkTitleOfFormFieldMessage(title);
		
		userContext.getChecker().checkParameterNameOfFormFieldMessage(parameterName);
		
		userContext.getChecker().checkLevelOfFormFieldMessage(level);
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);

	
	}
	public  GenericForm addFormFieldMessage(RetailscmUserContext userContext, String genericFormId, String title, String parameterName, String level, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFormFieldMessage(userContext,genericFormId,title, parameterName, level,tokensExpr);
		
		FormFieldMessage formFieldMessage = createFormFieldMessage(userContext,title, parameterName, level);
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormFieldMessage( formFieldMessage );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			
			userContext.getManagerGroup().getFormFieldMessageManager().onNewInstanceCreated(userContext, formFieldMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormFieldMessageProperties(RetailscmUserContext userContext, String genericFormId,String id,String title,String parameterName,String level,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormFieldMessage(id);
		
		userContext.getChecker().checkTitleOfFormFieldMessage( title);
		userContext.getChecker().checkParameterNameOfFormFieldMessage( parameterName);
		userContext.getChecker().checkLevelOfFormFieldMessage( level);

		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm updateFormFieldMessageProperties(RetailscmUserContext userContext, String genericFormId, String id,String title,String parameterName,String level, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFormFieldMessageProperties(userContext,genericFormId,id,title,parameterName,level,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormFieldMessageListList()
				.searchFormFieldMessageListWith(FormFieldMessage.ID_PROPERTY, "is", id).done();
		
		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);
		
		if(genericFormToUpdate.getFormFieldMessageList().isEmpty()){
			throw new GenericFormManagerException("FormFieldMessage is NOT FOUND with id: '"+id+"'");
		}
		
		FormFieldMessage item = genericFormToUpdate.getFormFieldMessageList().first();
		
		item.updateTitle( title );
		item.updateParameterName( parameterName );
		item.updateLevel( level );

		
		//checkParamsForAddingFormFieldMessage(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormFieldMessageList().done());
		synchronized(genericForm){ 
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FormFieldMessage createFormFieldMessage(RetailscmUserContext userContext, String title, String parameterName, String level) throws Exception{

		FormFieldMessage formFieldMessage = new FormFieldMessage();
		
		
		formFieldMessage.setTitle(title);		
		formFieldMessage.setParameterName(parameterName);		
		formFieldMessage.setLevel(level);
	
		
		return formFieldMessage;
	
		
	}
	
	protected FormFieldMessage createIndexedFormFieldMessage(String id, int version){

		FormFieldMessage formFieldMessage = new FormFieldMessage();
		formFieldMessage.setId(id);
		formFieldMessage.setVersion(version);
		return formFieldMessage;			
		
	}
	
	protected void checkParamsForRemovingFormFieldMessageList(RetailscmUserContext userContext, String genericFormId, 
			String formFieldMessageIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		for(String formFieldMessageId: formFieldMessageIds){
			userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm removeFormFieldMessageList(RetailscmUserContext userContext, String genericFormId, 
			String formFieldMessageIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFormFieldMessageList(userContext, genericFormId,  formFieldMessageIds, tokensExpr);
			
			
			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){ 
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGenericFormDAO().planToRemoveFormFieldMessageList(genericForm, formFieldMessageIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormFieldMessageList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFormFieldMessage(RetailscmUserContext userContext, String genericFormId, 
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().checkVersionOfFormFieldMessage(formFieldMessageVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm removeFormFieldMessage(RetailscmUserContext userContext, String genericFormId, 
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFormFieldMessage(userContext,genericFormId, formFieldMessageId, formFieldMessageVersion,tokensExpr);
		
		FormFieldMessage formFieldMessage = createIndexedFormFieldMessage(formFieldMessageId, formFieldMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormFieldMessage( formFieldMessage );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			deleteRelationInGraph(userContext, formFieldMessage);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFormFieldMessage(RetailscmUserContext userContext, String genericFormId, 
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().checkVersionOfFormFieldMessage(formFieldMessageVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm copyFormFieldMessageFrom(RetailscmUserContext userContext, String genericFormId, 
		String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFormFieldMessage(userContext,genericFormId, formFieldMessageId, formFieldMessageVersion,tokensExpr);
		
		FormFieldMessage formFieldMessage = createIndexedFormFieldMessage(formFieldMessageId, formFieldMessageVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			genericForm.copyFormFieldMessageFrom( formFieldMessage );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			
			userContext.getManagerGroup().getFormFieldMessageManager().onNewInstanceCreated(userContext, (FormFieldMessage)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFormFieldMessage(RetailscmUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().checkVersionOfFormFieldMessage(formFieldMessageVersion);
		

		if(FormFieldMessage.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfFormFieldMessage(parseString(newValueExpr));
		}
		
		if(FormFieldMessage.PARAMETER_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkParameterNameOfFormFieldMessage(parseString(newValueExpr));
		}
		
		if(FormFieldMessage.LEVEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLevelOfFormFieldMessage(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	
	public  GenericForm updateFormFieldMessage(RetailscmUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFormFieldMessage(userContext, genericFormId, formFieldMessageId, formFieldMessageVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFormFieldMessageList().searchFormFieldMessageListWith(FormFieldMessage.ID_PROPERTY, "eq", formFieldMessageId).done();
		
		
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);
		
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormFieldMessage( formFieldMessage );	
			//make changes to AcceleraterAccount.
			FormFieldMessage formFieldMessageIndex = createIndexedFormFieldMessage(formFieldMessageId, formFieldMessageVersion);
		
			FormFieldMessage formFieldMessage = genericForm.findTheFormFieldMessage(formFieldMessageIndex);
			if(formFieldMessage == null){
				throw new GenericFormManagerException(formFieldMessage+" is NOT FOUND" );
			}
			
			formFieldMessage.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldMessageList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFormField(RetailscmUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);

	
	}
	public  GenericForm addFormField(RetailscmUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFormField(userContext,genericFormId,label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, required, disabled, customRendering, candidateValues, suggestValues,tokensExpr);
		
		FormField formField = createFormField(userContext,label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, required, disabled, customRendering, candidateValues, suggestValues);
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormField( formField );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			
			userContext.getManagerGroup().getFormFieldManager().onNewInstanceCreated(userContext, formField);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormFieldProperties(RetailscmUserContext userContext, String genericFormId,String id,String label,String localeKey,String parameterName,String type,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormField(id);
		
		userContext.getChecker().checkLabelOfFormField( label);
		userContext.getChecker().checkLocaleKeyOfFormField( localeKey);
		userContext.getChecker().checkParameterNameOfFormField( parameterName);
		userContext.getChecker().checkTypeOfFormField( type);
		userContext.getChecker().checkPlaceholderOfFormField( placeholder);
		userContext.getChecker().checkDefaultValueOfFormField( defaultValue);
		userContext.getChecker().checkDescriptionOfFormField( description);
		userContext.getChecker().checkFieldGroupOfFormField( fieldGroup);
		userContext.getChecker().checkMinimumValueOfFormField( minimumValue);
		userContext.getChecker().checkMaximumValueOfFormField( maximumValue);
		userContext.getChecker().checkRequiredOfFormField( required);
		userContext.getChecker().checkDisabledOfFormField( disabled);
		userContext.getChecker().checkCustomRenderingOfFormField( customRendering);
		userContext.getChecker().checkCandidateValuesOfFormField( candidateValues);
		userContext.getChecker().checkSuggestValuesOfFormField( suggestValues);

		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm updateFormFieldProperties(RetailscmUserContext userContext, String genericFormId, String id,String label,String localeKey,String parameterName,String type,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFormFieldProperties(userContext,genericFormId,id,label,localeKey,parameterName,type,placeholder,defaultValue,description,fieldGroup,minimumValue,maximumValue,required,disabled,customRendering,candidateValues,suggestValues,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormFieldListList()
				.searchFormFieldListWith(FormField.ID_PROPERTY, "is", id).done();
		
		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);
		
		if(genericFormToUpdate.getFormFieldList().isEmpty()){
			throw new GenericFormManagerException("FormField is NOT FOUND with id: '"+id+"'");
		}
		
		FormField item = genericFormToUpdate.getFormFieldList().first();
		
		item.updateLabel( label );
		item.updateLocaleKey( localeKey );
		item.updateParameterName( parameterName );
		item.updateType( type );
		item.updatePlaceholder( placeholder );
		item.updateDefaultValue( defaultValue );
		item.updateDescription( description );
		item.updateFieldGroup( fieldGroup );
		item.updateMinimumValue( minimumValue );
		item.updateMaximumValue( maximumValue );
		item.updateRequired( required );
		item.updateDisabled( disabled );
		item.updateCustomRendering( customRendering );
		item.updateCandidateValues( candidateValues );
		item.updateSuggestValues( suggestValues );

		
		//checkParamsForAddingFormField(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormFieldList().done());
		synchronized(genericForm){ 
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FormField createFormField(RetailscmUserContext userContext, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception{

		FormField formField = new FormField();
		
		
		formField.setLabel(label);		
		formField.setLocaleKey(localeKey);		
		formField.setParameterName(parameterName);		
		formField.setType(type);		
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
	
		
		return formField;
	
		
	}
	
	protected FormField createIndexedFormField(String id, int version){

		FormField formField = new FormField();
		formField.setId(id);
		formField.setVersion(version);
		return formField;			
		
	}
	
	protected void checkParamsForRemovingFormFieldList(RetailscmUserContext userContext, String genericFormId, 
			String formFieldIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		for(String formFieldId: formFieldIds){
			userContext.getChecker().checkIdOfFormField(formFieldId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm removeFormFieldList(RetailscmUserContext userContext, String genericFormId, 
			String formFieldIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFormFieldList(userContext, genericFormId,  formFieldIds, tokensExpr);
			
			
			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){ 
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGenericFormDAO().planToRemoveFormFieldList(genericForm, formFieldIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormFieldList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFormField(RetailscmUserContext userContext, String genericFormId, 
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().checkVersionOfFormField(formFieldVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm removeFormField(RetailscmUserContext userContext, String genericFormId, 
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFormField(userContext,genericFormId, formFieldId, formFieldVersion,tokensExpr);
		
		FormField formField = createIndexedFormField(formFieldId, formFieldVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormField( formField );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			deleteRelationInGraph(userContext, formField);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFormField(RetailscmUserContext userContext, String genericFormId, 
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().checkVersionOfFormField(formFieldVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm copyFormFieldFrom(RetailscmUserContext userContext, String genericFormId, 
		String formFieldId, int formFieldVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFormField(userContext,genericFormId, formFieldId, formFieldVersion,tokensExpr);
		
		FormField formField = createIndexedFormField(formFieldId, formFieldVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			genericForm.copyFormFieldFrom( formField );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			
			userContext.getManagerGroup().getFormFieldManager().onNewInstanceCreated(userContext, (FormField)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFormField(RetailscmUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormField(formFieldId);
		userContext.getChecker().checkVersionOfFormField(formFieldVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	
	public  GenericForm updateFormField(RetailscmUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFormField(userContext, genericFormId, formFieldId, formFieldVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFormFieldList().searchFormFieldListWith(FormField.ID_PROPERTY, "eq", formFieldId).done();
		
		
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);
		
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormField( formField );	
			//make changes to AcceleraterAccount.
			FormField formFieldIndex = createIndexedFormField(formFieldId, formFieldVersion);
		
			FormField formField = genericForm.findTheFormField(formFieldIndex);
			if(formField == null){
				throw new GenericFormManagerException(formField+" is NOT FOUND" );
			}
			
			formField.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormFieldList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFormAction(RetailscmUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);

		
		userContext.getChecker().checkLabelOfFormAction(label);
		
		userContext.getChecker().checkLocaleKeyOfFormAction(localeKey);
		
		userContext.getChecker().checkActionKeyOfFormAction(actionKey);
		
		userContext.getChecker().checkLevelOfFormAction(level);
		
		userContext.getChecker().checkUrlOfFormAction(url);
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);

	
	}
	public  GenericForm addFormAction(RetailscmUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFormAction(userContext,genericFormId,label, localeKey, actionKey, level, url,tokensExpr);
		
		FormAction formAction = createFormAction(userContext,label, localeKey, actionKey, level, url);
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.addFormAction( formAction );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			
			userContext.getManagerGroup().getFormActionManager().onNewInstanceCreated(userContext, formAction);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFormActionProperties(RetailscmUserContext userContext, String genericFormId,String id,String label,String localeKey,String actionKey,String level,String url,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormAction(id);
		
		userContext.getChecker().checkLabelOfFormAction( label);
		userContext.getChecker().checkLocaleKeyOfFormAction( localeKey);
		userContext.getChecker().checkActionKeyOfFormAction( actionKey);
		userContext.getChecker().checkLevelOfFormAction( level);
		userContext.getChecker().checkUrlOfFormAction( url);

		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm updateFormActionProperties(RetailscmUserContext userContext, String genericFormId, String id,String label,String localeKey,String actionKey,String level,String url, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFormActionProperties(userContext,genericFormId,id,label,localeKey,actionKey,level,url,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFormActionListList()
				.searchFormActionListWith(FormAction.ID_PROPERTY, "is", id).done();
		
		GenericForm genericFormToUpdate = loadGenericForm(userContext, genericFormId, options);
		
		if(genericFormToUpdate.getFormActionList().isEmpty()){
			throw new GenericFormManagerException("FormAction is NOT FOUND with id: '"+id+"'");
		}
		
		FormAction item = genericFormToUpdate.getFormActionList().first();
		
		item.updateLabel( label );
		item.updateLocaleKey( localeKey );
		item.updateActionKey( actionKey );
		item.updateLevel( level );
		item.updateUrl( url );

		
		//checkParamsForAddingFormAction(userContext,genericFormId,name, code, used,tokensExpr);
		GenericForm genericForm = saveGenericForm(userContext, genericFormToUpdate, tokens().withFormActionList().done());
		synchronized(genericForm){ 
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FormAction createFormAction(RetailscmUserContext userContext, String label, String localeKey, String actionKey, String level, String url) throws Exception{

		FormAction formAction = new FormAction();
		
		
		formAction.setLabel(label);		
		formAction.setLocaleKey(localeKey);		
		formAction.setActionKey(actionKey);		
		formAction.setLevel(level);		
		formAction.setUrl(url);
	
		
		return formAction;
	
		
	}
	
	protected FormAction createIndexedFormAction(String id, int version){

		FormAction formAction = new FormAction();
		formAction.setId(id);
		formAction.setVersion(version);
		return formAction;			
		
	}
	
	protected void checkParamsForRemovingFormActionList(RetailscmUserContext userContext, String genericFormId, 
			String formActionIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		for(String formActionId: formActionIds){
			userContext.getChecker().checkIdOfFormAction(formActionId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
		
	}
	public  GenericForm removeFormActionList(RetailscmUserContext userContext, String genericFormId, 
			String formActionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFormActionList(userContext, genericFormId,  formActionIds, tokensExpr);
			
			
			GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
			synchronized(genericForm){ 
				//Will be good when the genericForm loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGenericFormDAO().planToRemoveFormActionList(genericForm, formActionIds, allTokens());
				genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
				deleteRelationListInGraph(userContext, genericForm.getFormActionList());
				return present(userContext,genericForm, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFormAction(RetailscmUserContext userContext, String genericFormId, 
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().checkVersionOfFormAction(formActionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm removeFormAction(RetailscmUserContext userContext, String genericFormId, 
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFormAction(userContext,genericFormId, formActionId, formActionVersion,tokensExpr);
		
		FormAction formAction = createIndexedFormAction(formActionId, formActionVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			genericForm.removeFormAction( formAction );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			deleteRelationInGraph(userContext, formAction);
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFormAction(RetailscmUserContext userContext, String genericFormId, 
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGenericForm( genericFormId);
		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().checkVersionOfFormAction(formActionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	public  GenericForm copyFormActionFrom(RetailscmUserContext userContext, String genericFormId, 
		String formActionId, int formActionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFormAction(userContext,genericFormId, formActionId, formActionVersion,tokensExpr);
		
		FormAction formAction = createIndexedFormAction(formActionId, formActionVersion);
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, allTokens());
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			genericForm.copyFormActionFrom( formAction );		
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			
			userContext.getManagerGroup().getFormActionManager().onNewInstanceCreated(userContext, (FormAction)genericForm.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFormAction(RetailscmUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGenericForm(genericFormId);
		userContext.getChecker().checkIdOfFormAction(formActionId);
		userContext.getChecker().checkVersionOfFormAction(formActionVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GenericFormManagerException.class);
	
	}
	
	public  GenericForm updateFormAction(RetailscmUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFormAction(userContext, genericFormId, formActionId, formActionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFormActionList().searchFormActionListWith(FormAction.ID_PROPERTY, "eq", formActionId).done();
		
		
		
		GenericForm genericForm = loadGenericForm(userContext, genericFormId, loadTokens);
		
		synchronized(genericForm){ 
			//Will be good when the genericForm loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//genericForm.removeFormAction( formAction );	
			//make changes to AcceleraterAccount.
			FormAction formActionIndex = createIndexedFormAction(formActionId, formActionVersion);
		
			FormAction formAction = genericForm.findTheFormAction(formActionIndex);
			if(formAction == null){
				throw new GenericFormManagerException(formAction+" is NOT FOUND" );
			}
			
			formAction.changeProperty(property, newValueExpr);
			
			genericForm = saveGenericForm(userContext, genericForm, tokens().withFormActionList().done());
			return present(userContext,genericForm, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, GenericForm newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


