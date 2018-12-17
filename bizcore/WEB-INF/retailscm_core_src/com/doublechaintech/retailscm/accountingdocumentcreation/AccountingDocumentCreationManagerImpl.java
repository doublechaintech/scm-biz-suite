
package com.doublechaintech.retailscm.accountingdocumentcreation;

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






public class AccountingDocumentCreationManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentCreationManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentCreation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingDocumentCreationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentCreationManagerException(message);

	}
	
	

 	protected AccountingDocumentCreation saveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentCreationDAO().save(accountingDocumentCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens);
 	}
 	
 	protected AccountingDocumentCreation saveAccountingDocumentCreationDetail(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception{	

 		
 		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, allTokens());
 	}
 	
 	public AccountingDocumentCreation loadAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentCreationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentCreation, tokens);
 	}
 	
 	
 	 public AccountingDocumentCreation searchAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentCreationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentCreation, tokens);
 	}
 	
 	

 	protected AccountingDocumentCreation present(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentCreation,tokens);
		
		
		AccountingDocumentCreation  accountingDocumentCreationToPresent = userContext.getDAOGroup().getAccountingDocumentCreationDAO().present(accountingDocumentCreation, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentCreationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingDocumentCreationDAO().alias(entityListToNaming);
		
		return  accountingDocumentCreationToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentCreation loadAccountingDocumentCreationDetail(RetailscmUserContext userContext, String accountingDocumentCreationId) throws Exception{	
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, allTokens());
 		return present(userContext,accountingDocumentCreation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentCreationId) throws Exception{	
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, viewTokens());
 		return present(userContext,accountingDocumentCreation, allTokens());
		
 	}
 	protected AccountingDocumentCreation saveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().save(accountingDocumentCreation, tokens);
 	}
 	protected AccountingDocumentCreation loadAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentCreationManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().load(accountingDocumentCreationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentCreation, tokens);
		
		addAction(userContext, accountingDocumentCreation, tokens,"@create","createAccountingDocumentCreation","createAccountingDocumentCreation/","main","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"@update","updateAccountingDocumentCreation","updateAccountingDocumentCreation/"+accountingDocumentCreation.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"@copy","cloneAccountingDocumentCreation","cloneAccountingDocumentCreation/"+accountingDocumentCreation.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentCreation createAccountingDocumentCreation(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfAccountingDocumentCreation(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentCreation(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentCreation(makeDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);


		AccountingDocumentCreation accountingDocumentCreation=createNewAccountingDocumentCreation();	

		accountingDocumentCreation.setWho(who);
		accountingDocumentCreation.setComments(comments);
		accountingDocumentCreation.setMakeDate(makeDate);

		accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentCreation);
		return accountingDocumentCreation;

		
	}
	protected AccountingDocumentCreation createNewAccountingDocumentCreation() 
	{
		
		return new AccountingDocumentCreation();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentCreation(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		userContext.getChecker().checkVersionOfAccountingDocumentCreation( accountingDocumentCreationVersion);
		

		if(AccountingDocumentCreation.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfAccountingDocumentCreation(parseString(newValueExpr));
		}
		if(AccountingDocumentCreation.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfAccountingDocumentCreation(parseString(newValueExpr));
		}
		if(AccountingDocumentCreation.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfAccountingDocumentCreation(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);
	
		
	}
	
	
	
	public AccountingDocumentCreation clone(RetailscmUserContext userContext, String fromAccountingDocumentCreationId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().clone(fromAccountingDocumentCreationId, this.allTokens());
	}
	
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception 
	{
		return internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation, allTokens());

	}
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingDocumentCreation){ 
			//will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.
			
			
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, options);
			return accountingDocumentCreation;
			
		}

	}
	
	public AccountingDocumentCreation updateAccountingDocumentCreation(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		if(accountingDocumentCreation.getVersion() != accountingDocumentCreationVersion){
			String message = "The target version("+accountingDocumentCreation.getVersion()+") is not equals to version("+accountingDocumentCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentCreation){ 
			//will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.
			
			accountingDocumentCreation.changeProperty(property, newValueExpr);
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
		}

	}
	
	public AccountingDocumentCreation updateAccountingDocumentCreationProperty(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		if(accountingDocumentCreation.getVersion() != accountingDocumentCreationVersion){
			String message = "The target version("+accountingDocumentCreation.getVersion()+") is not equals to version("+accountingDocumentCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentCreation){ 
			//will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.
			
			accountingDocumentCreation.changeProperty(property, newValueExpr);
			
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentCreationTokens tokens(){
		return AccountingDocumentCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentCreationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentCreationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingDocumentCreationDAO().delete(accountingDocumentCreationId, accountingDocumentCreationVersion);
	}
	
	public AccountingDocumentCreation forgetByAll(RetailscmUserContext userContext, String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion);		
	}
	protected AccountingDocumentCreation forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().disconnectFromAll(accountingDocumentCreationId, accountingDocumentCreationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().deleteAll();
	}


	//disconnect AccountingDocumentCreation with accounting_period in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentCreationDAO().planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentCreation, accountingPeriodId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}
	//disconnect AccountingDocumentCreation with document_type in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentCreationId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentCreationDAO().planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentCreation, documentTypeId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);

		
		userContext.getChecker().checkNameOfAccountingDocument(name);
		
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		userContext.getChecker().checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		userContext.getChecker().checkDocumentTypeIdOfAccountingDocument(documentTypeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);

	
	}
	public  AccountingDocumentCreation addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentCreationId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.addAccountingDocument( accountingDocument );		
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentCreationId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		userContext.getChecker().checkIdOfAccountingDocument(id);
		
		userContext.getChecker().checkNameOfAccountingDocument( name);
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);
		
	}
	public  AccountingDocumentCreation updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentCreationId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentCreationId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();
		
		AccountingDocumentCreation accountingDocumentCreationToUpdate = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		if(accountingDocumentCreationToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentCreationManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocument item = accountingDocumentCreationToUpdate.getAccountingDocumentList().first();
		
		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );

		
		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentCreationId,name, code, used,tokensExpr);
		AccountingDocumentCreation accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreationToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentCreation){ 
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentCreationId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		for(String accountingDocumentId: accountingDocumentIds){
			userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);
		
	}
	public  AccountingDocumentCreation removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentCreationId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentCreationId,  accountingDocumentIds, tokensExpr);
			
			
			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
			synchronized(accountingDocumentCreation){ 
				//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentCreationDAO().planToRemoveAccountingDocumentList(accountingDocumentCreation, accountingDocumentIds, allTokens());
				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentCreation.getAccountingDocumentList());
				return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentCreation( accountingDocumentCreationId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);
	
	}
	public  AccountingDocumentCreation removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.removeAccountingDocument( accountingDocument );		
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentCreation( accountingDocumentCreationId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);
	
	}
	public  AccountingDocumentCreation copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocumentCreation.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentCreation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocument(parseString(newValueExpr));
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);
	
	}
	
	public  AccountingDocumentCreation updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();
		
		
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, loadTokens);
		
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentCreation.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentCreation.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentCreationManagerException(accountingDocument+" is NOT FOUND" );
			}
			
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  AccountingDocumentCreation associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().createAccountingDocumentConfirmation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentCreation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation);
	}	public  AccountingDocumentCreation associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().createAccountingDocumentAuditing(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentCreation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation);
	}	public  AccountingDocumentCreation associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().createAccountingDocumentPosting(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentCreation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation);
	}
	*/
	
	public  AccountingDocumentCreation associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().loadAccountingDocumentConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentCreation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation);
	}	public  AccountingDocumentCreation associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String auditingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().loadAccountingDocumentAuditing(userContext,auditingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentCreation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation);
	}	public  AccountingDocumentCreation associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String postingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().loadAccountingDocumentPosting(userContext,postingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentCreation.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentCreation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


