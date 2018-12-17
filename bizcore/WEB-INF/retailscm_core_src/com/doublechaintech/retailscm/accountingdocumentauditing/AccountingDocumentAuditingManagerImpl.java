
package com.doublechaintech.retailscm.accountingdocumentauditing;

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






public class AccountingDocumentAuditingManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentAuditingManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentAuditing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingDocumentAuditingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentAuditingManagerException(message);

	}
	
	

 	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentAuditingDAO().save(accountingDocumentAuditing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens);
 	}
 	
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditingDetail(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception{	

 		
 		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, allTokens());
 	}
 	
 	public AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentAuditingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentAuditing, tokens);
 	}
 	
 	
 	 public AccountingDocumentAuditing searchAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentAuditingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentAuditing, tokens);
 	}
 	
 	

 	protected AccountingDocumentAuditing present(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentAuditing,tokens);
		
		
		AccountingDocumentAuditing  accountingDocumentAuditingToPresent = userContext.getDAOGroup().getAccountingDocumentAuditingDAO().present(accountingDocumentAuditing, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentAuditingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingDocumentAuditingDAO().alias(entityListToNaming);
		
		return  accountingDocumentAuditingToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentAuditing loadAccountingDocumentAuditingDetail(RetailscmUserContext userContext, String accountingDocumentAuditingId) throws Exception{	
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, allTokens());
 		return present(userContext,accountingDocumentAuditing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentAuditingId) throws Exception{	
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, viewTokens());
 		return present(userContext,accountingDocumentAuditing, allTokens());
		
 	}
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().save(accountingDocumentAuditing, tokens);
 	}
 	protected AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentAuditingManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().load(accountingDocumentAuditingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentAuditing, tokens);
		
		addAction(userContext, accountingDocumentAuditing, tokens,"@create","createAccountingDocumentAuditing","createAccountingDocumentAuditing/","main","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"@update","updateAccountingDocumentAuditing","updateAccountingDocumentAuditing/"+accountingDocumentAuditing.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"@copy","cloneAccountingDocumentAuditing","cloneAccountingDocumentAuditing/"+accountingDocumentAuditing.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentAuditing createAccountingDocumentAuditing(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfAccountingDocumentAuditing(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentAuditing(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentAuditing(makeDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);


		AccountingDocumentAuditing accountingDocumentAuditing=createNewAccountingDocumentAuditing();	

		accountingDocumentAuditing.setWho(who);
		accountingDocumentAuditing.setComments(comments);
		accountingDocumentAuditing.setMakeDate(makeDate);

		accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentAuditing);
		return accountingDocumentAuditing;

		
	}
	protected AccountingDocumentAuditing createNewAccountingDocumentAuditing() 
	{
		
		return new AccountingDocumentAuditing();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentAuditing(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		userContext.getChecker().checkVersionOfAccountingDocumentAuditing( accountingDocumentAuditingVersion);
		

		if(AccountingDocumentAuditing.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfAccountingDocumentAuditing(parseString(newValueExpr));
		}
		if(AccountingDocumentAuditing.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfAccountingDocumentAuditing(parseString(newValueExpr));
		}
		if(AccountingDocumentAuditing.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfAccountingDocumentAuditing(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);
	
		
	}
	
	
	
	public AccountingDocumentAuditing clone(RetailscmUserContext userContext, String fromAccountingDocumentAuditingId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().clone(fromAccountingDocumentAuditingId, this.allTokens());
	}
	
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception 
	{
		return internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, allTokens());

	}
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingDocumentAuditing){ 
			//will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.
			
			
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, options);
			return accountingDocumentAuditing;
			
		}

	}
	
	public AccountingDocumentAuditing updateAccountingDocumentAuditing(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		if(accountingDocumentAuditing.getVersion() != accountingDocumentAuditingVersion){
			String message = "The target version("+accountingDocumentAuditing.getVersion()+") is not equals to version("+accountingDocumentAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentAuditing){ 
			//will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.
			
			accountingDocumentAuditing.changeProperty(property, newValueExpr);
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
		}

	}
	
	public AccountingDocumentAuditing updateAccountingDocumentAuditingProperty(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		if(accountingDocumentAuditing.getVersion() != accountingDocumentAuditingVersion){
			String message = "The target version("+accountingDocumentAuditing.getVersion()+") is not equals to version("+accountingDocumentAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentAuditing){ 
			//will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.
			
			accountingDocumentAuditing.changeProperty(property, newValueExpr);
			
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentAuditingTokens tokens(){
		return AccountingDocumentAuditingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentAuditingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentAuditingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingDocumentAuditingDAO().delete(accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}
	
	public AccountingDocumentAuditing forgetByAll(RetailscmUserContext userContext, String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion);		
	}
	protected AccountingDocumentAuditing forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().disconnectFromAll(accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentAuditingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().deleteAll();
	}


	//disconnect AccountingDocumentAuditing with accounting_period in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentAuditingDAO().planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentAuditing, accountingPeriodId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}
	//disconnect AccountingDocumentAuditing with document_type in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentAuditingId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentAuditingDAO().planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentAuditing, documentTypeId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);

		
		userContext.getChecker().checkNameOfAccountingDocument(name);
		
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		userContext.getChecker().checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		userContext.getChecker().checkDocumentTypeIdOfAccountingDocument(documentTypeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);

	
	}
	public  AccountingDocumentAuditing addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentAuditingId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.addAccountingDocument( accountingDocument );		
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentAuditingId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		userContext.getChecker().checkIdOfAccountingDocument(id);
		
		userContext.getChecker().checkNameOfAccountingDocument( name);
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);
		
	}
	public  AccountingDocumentAuditing updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentAuditingId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentAuditingId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();
		
		AccountingDocumentAuditing accountingDocumentAuditingToUpdate = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		if(accountingDocumentAuditingToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentAuditingManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocument item = accountingDocumentAuditingToUpdate.getAccountingDocumentList().first();
		
		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );

		
		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentAuditingId,name, code, used,tokensExpr);
		AccountingDocumentAuditing accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditingToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentAuditing){ 
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentAuditingId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		for(String accountingDocumentId: accountingDocumentIds){
			userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);
		
	}
	public  AccountingDocumentAuditing removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentAuditingId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentAuditingId,  accountingDocumentIds, tokensExpr);
			
			
			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
			synchronized(accountingDocumentAuditing){ 
				//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentAuditingDAO().planToRemoveAccountingDocumentList(accountingDocumentAuditing, accountingDocumentIds, allTokens());
				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentAuditing.getAccountingDocumentList());
				return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing( accountingDocumentAuditingId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);
	
	}
	public  AccountingDocumentAuditing removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.removeAccountingDocument( accountingDocument );		
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing( accountingDocumentAuditingId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);
	
	}
	public  AccountingDocumentAuditing copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocumentAuditing.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentAuditing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocument(parseString(newValueExpr));
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);
	
	}
	
	public  AccountingDocumentAuditing updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();
		
		
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, loadTokens);
		
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentAuditing.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentAuditing.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentAuditingManagerException(accountingDocument+" is NOT FOUND" );
			}
			
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  AccountingDocumentAuditing associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingDocumentAuditingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().createAccountingDocumentCreation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentAuditing.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing);
	}	public  AccountingDocumentAuditing associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentAuditingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().createAccountingDocumentConfirmation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentAuditing.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing);
	}	public  AccountingDocumentAuditing associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingDocumentAuditingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().createAccountingDocumentPosting(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentAuditing.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing);
	}
	*/
	
	public  AccountingDocumentAuditing associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingDocumentAuditingId, String  accountingDocumentIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().loadAccountingDocumentCreation(userContext,creationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentAuditing.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing);
	}	public  AccountingDocumentAuditing associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentAuditingId, String  accountingDocumentIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().loadAccountingDocumentConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentAuditing.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing);
	}	public  AccountingDocumentAuditing associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingDocumentAuditingId, String  accountingDocumentIds[], String postingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().loadAccountingDocumentPosting(userContext,postingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentAuditing.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentAuditing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


