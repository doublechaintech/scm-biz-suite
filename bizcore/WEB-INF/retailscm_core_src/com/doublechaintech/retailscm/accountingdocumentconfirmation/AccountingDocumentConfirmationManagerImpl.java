
package com.doublechaintech.retailscm.accountingdocumentconfirmation;

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

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;


import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;






public class AccountingDocumentConfirmationManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentConfirmationManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingDocumentConfirmationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentConfirmationManagerException(message);

	}
	
	

 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentConfirmationDAO().save(accountingDocumentConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens);
 	}
 	
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmationDetail(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception{	

 		
 		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, allTokens());
 	}
 	
 	public AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentConfirmation, tokens);
 	}
 	
 	
 	 public AccountingDocumentConfirmation searchAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentConfirmation, tokens);
 	}
 	
 	

 	protected AccountingDocumentConfirmation present(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentConfirmation,tokens);
		
		
		AccountingDocumentConfirmation  accountingDocumentConfirmationToPresent = userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().present(accountingDocumentConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentConfirmationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().alias(entityListToNaming);
		
		return  accountingDocumentConfirmationToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentConfirmation loadAccountingDocumentConfirmationDetail(RetailscmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{	
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, allTokens());
 		return present(userContext,accountingDocumentConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{	
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, viewTokens());
 		return present(userContext,accountingDocumentConfirmation, allTokens());
		
 	}
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().save(accountingDocumentConfirmation, tokens);
 	}
 	protected AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentConfirmationManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().load(accountingDocumentConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentConfirmation, tokens);
		
		addAction(userContext, accountingDocumentConfirmation, tokens,"@create","createAccountingDocumentConfirmation","createAccountingDocumentConfirmation/","main","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"@update","updateAccountingDocumentConfirmation","updateAccountingDocumentConfirmation/"+accountingDocumentConfirmation.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"@copy","cloneAccountingDocumentConfirmation","cloneAccountingDocumentConfirmation/"+accountingDocumentConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfAccountingDocumentConfirmation(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentConfirmation(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentConfirmation(makeDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);


		AccountingDocumentConfirmation accountingDocumentConfirmation=createNewAccountingDocumentConfirmation();	

		accountingDocumentConfirmation.setWho(who);
		accountingDocumentConfirmation.setComments(comments);
		accountingDocumentConfirmation.setMakeDate(makeDate);

		accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentConfirmation);
		return accountingDocumentConfirmation;

		
	}
	protected AccountingDocumentConfirmation createNewAccountingDocumentConfirmation() 
	{
		
		return new AccountingDocumentConfirmation();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentConfirmation(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		userContext.getChecker().checkVersionOfAccountingDocumentConfirmation( accountingDocumentConfirmationVersion);
		

		if(AccountingDocumentConfirmation.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfAccountingDocumentConfirmation(parseString(newValueExpr));
		}
		if(AccountingDocumentConfirmation.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfAccountingDocumentConfirmation(parseString(newValueExpr));
		}
		if(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfAccountingDocumentConfirmation(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);
	
		
	}
	
	
	
	public AccountingDocumentConfirmation clone(RetailscmUserContext userContext, String fromAccountingDocumentConfirmationId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().clone(fromAccountingDocumentConfirmationId, this.allTokens());
	}
	
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception 
	{
		return internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, allTokens());

	}
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingDocumentConfirmation){ 
			//will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.
			
			
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, options);
			return accountingDocumentConfirmation;
			
		}

	}
	
	public AccountingDocumentConfirmation updateAccountingDocumentConfirmation(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		if(accountingDocumentConfirmation.getVersion() != accountingDocumentConfirmationVersion){
			String message = "The target version("+accountingDocumentConfirmation.getVersion()+") is not equals to version("+accountingDocumentConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentConfirmation){ 
			//will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.
			
			accountingDocumentConfirmation.changeProperty(property, newValueExpr);
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
		}

	}
	
	public AccountingDocumentConfirmation updateAccountingDocumentConfirmationProperty(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		if(accountingDocumentConfirmation.getVersion() != accountingDocumentConfirmationVersion){
			String message = "The target version("+accountingDocumentConfirmation.getVersion()+") is not equals to version("+accountingDocumentConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentConfirmation){ 
			//will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.
			
			accountingDocumentConfirmation.changeProperty(property, newValueExpr);
			
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentConfirmationTokens tokens(){
		return AccountingDocumentConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().delete(accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}
	
	public AccountingDocumentConfirmation forgetByAll(RetailscmUserContext userContext, String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);		
	}
	protected AccountingDocumentConfirmation forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().disconnectFromAll(accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().deleteAll();
	}


	//disconnect AccountingDocumentConfirmation with accounting_period in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentConfirmation, accountingPeriodId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}
	//disconnect AccountingDocumentConfirmation with document_type in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentConfirmation, documentTypeId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);

		
		userContext.getChecker().checkNameOfAccountingDocument(name);
		
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		userContext.getChecker().checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		userContext.getChecker().checkDocumentTypeIdOfAccountingDocument(documentTypeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);

	
	}
	public  AccountingDocumentConfirmation addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentConfirmationId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.addAccountingDocument( accountingDocument );		
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentConfirmationId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		userContext.getChecker().checkIdOfAccountingDocument(id);
		
		userContext.getChecker().checkNameOfAccountingDocument( name);
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);
		
	}
	public  AccountingDocumentConfirmation updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentConfirmationId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmationToUpdate = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		if(accountingDocumentConfirmationToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentConfirmationManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocument item = accountingDocumentConfirmationToUpdate.getAccountingDocumentList().first();
		
		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );

		
		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentConfirmationId,name, code, used,tokensExpr);
		AccountingDocumentConfirmation accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentConfirmation){ 
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingPeriod  accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(accountingPeriodId);		
		accountingDocument.setAccountingPeriod(accountingPeriod);		
		AccountingDocumentType  documentType = new AccountingDocumentType();
		documentType.setId(documentTypeId);		
		accountingDocument.setDocumentType(documentType);		
		accountingDocument.setCurrentStatus("INIT");
	
		
		return accountingDocument;
	
		
	}
	
	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;			
		
	}
	
	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentConfirmationId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		for(String accountingDocumentId: accountingDocumentIds){
			userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);
		
	}
	public  AccountingDocumentConfirmation removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentConfirmationId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentConfirmationId,  accountingDocumentIds, tokensExpr);
			
			
			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
			synchronized(accountingDocumentConfirmation){ 
				//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().planToRemoveAccountingDocumentList(accountingDocumentConfirmation, accountingDocumentIds, allTokens());
				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentConfirmation.getAccountingDocumentList());
				return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation( accountingDocumentConfirmationId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);
	
	}
	public  AccountingDocumentConfirmation removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.removeAccountingDocument( accountingDocument );		
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation( accountingDocumentConfirmationId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);
	
	}
	public  AccountingDocumentConfirmation copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocumentConfirmation.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocument(parseString(newValueExpr));
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);
	
	}
	
	public  AccountingDocumentConfirmation updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();
		
		
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, loadTokens);
		
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentConfirmation.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentConfirmation.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentConfirmationManagerException(accountingDocument+" is NOT FOUND" );
			}
			
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  AccountingDocumentConfirmation associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().createAccountingDocumentCreation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentConfirmation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation);
	}	public  AccountingDocumentConfirmation associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().createAccountingDocumentAuditing(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentConfirmation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation);
	}	public  AccountingDocumentConfirmation associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().createAccountingDocumentPosting(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentConfirmation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation);
	}
	*/
	
	public  AccountingDocumentConfirmation associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String  accountingDocumentIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().loadAccountingDocumentCreation(userContext,creationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentConfirmation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation);
	}	public  AccountingDocumentConfirmation associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String  accountingDocumentIds[], String auditingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().loadAccountingDocumentAuditing(userContext,auditingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentConfirmation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation);
	}	public  AccountingDocumentConfirmation associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String  accountingDocumentIds[], String postingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().loadAccountingDocumentPosting(userContext,postingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentConfirmation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentConfirmation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


