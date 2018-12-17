
package com.doublechaintech.retailscm.accountingdocumentposting;

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






public class AccountingDocumentPostingManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentPostingManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentPosting";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingDocumentPostingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentPostingManagerException(message);

	}
	
	

 	protected AccountingDocumentPosting saveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentPostingDAO().save(accountingDocumentPosting, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens);
 	}
 	
 	protected AccountingDocumentPosting saveAccountingDocumentPostingDetail(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception{	

 		
 		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, allTokens());
 	}
 	
 	public AccountingDocumentPosting loadAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentPostingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentPosting, tokens);
 	}
 	
 	
 	 public AccountingDocumentPosting searchAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentPostingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentPosting, tokens);
 	}
 	
 	

 	protected AccountingDocumentPosting present(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentPosting,tokens);
		
		
		AccountingDocumentPosting  accountingDocumentPostingToPresent = userContext.getDAOGroup().getAccountingDocumentPostingDAO().present(accountingDocumentPosting, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentPostingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingDocumentPostingDAO().alias(entityListToNaming);
		
		return  accountingDocumentPostingToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentPosting loadAccountingDocumentPostingDetail(RetailscmUserContext userContext, String accountingDocumentPostingId) throws Exception{	
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, allTokens());
 		return present(userContext,accountingDocumentPosting, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentPostingId) throws Exception{	
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, viewTokens());
 		return present(userContext,accountingDocumentPosting, allTokens());
		
 	}
 	protected AccountingDocumentPosting saveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().save(accountingDocumentPosting, tokens);
 	}
 	protected AccountingDocumentPosting loadAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentPostingManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().load(accountingDocumentPostingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentPosting, tokens);
		
		addAction(userContext, accountingDocumentPosting, tokens,"@create","createAccountingDocumentPosting","createAccountingDocumentPosting/","main","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"@update","updateAccountingDocumentPosting","updateAccountingDocumentPosting/"+accountingDocumentPosting.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"@copy","cloneAccountingDocumentPosting","cloneAccountingDocumentPosting/"+accountingDocumentPosting.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentPosting createAccountingDocumentPosting(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfAccountingDocumentPosting(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentPosting(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentPosting(makeDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);


		AccountingDocumentPosting accountingDocumentPosting=createNewAccountingDocumentPosting();	

		accountingDocumentPosting.setWho(who);
		accountingDocumentPosting.setComments(comments);
		accountingDocumentPosting.setMakeDate(makeDate);

		accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentPosting);
		return accountingDocumentPosting;

		
	}
	protected AccountingDocumentPosting createNewAccountingDocumentPosting() 
	{
		
		return new AccountingDocumentPosting();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentPosting(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		userContext.getChecker().checkVersionOfAccountingDocumentPosting( accountingDocumentPostingVersion);
		

		if(AccountingDocumentPosting.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfAccountingDocumentPosting(parseString(newValueExpr));
		}
		if(AccountingDocumentPosting.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfAccountingDocumentPosting(parseString(newValueExpr));
		}
		if(AccountingDocumentPosting.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfAccountingDocumentPosting(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);
	
		
	}
	
	
	
	public AccountingDocumentPosting clone(RetailscmUserContext userContext, String fromAccountingDocumentPostingId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().clone(fromAccountingDocumentPostingId, this.allTokens());
	}
	
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception 
	{
		return internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting, allTokens());

	}
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingDocumentPosting){ 
			//will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.
			
			
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, options);
			return accountingDocumentPosting;
			
		}

	}
	
	public AccountingDocumentPosting updateAccountingDocumentPosting(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		if(accountingDocumentPosting.getVersion() != accountingDocumentPostingVersion){
			String message = "The target version("+accountingDocumentPosting.getVersion()+") is not equals to version("+accountingDocumentPostingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentPosting){ 
			//will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.
			
			accountingDocumentPosting.changeProperty(property, newValueExpr);
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
		}

	}
	
	public AccountingDocumentPosting updateAccountingDocumentPostingProperty(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		if(accountingDocumentPosting.getVersion() != accountingDocumentPostingVersion){
			String message = "The target version("+accountingDocumentPosting.getVersion()+") is not equals to version("+accountingDocumentPostingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentPosting){ 
			//will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.
			
			accountingDocumentPosting.changeProperty(property, newValueExpr);
			
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentPostingTokens tokens(){
		return AccountingDocumentPostingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentPostingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentPostingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingDocumentPostingDAO().delete(accountingDocumentPostingId, accountingDocumentPostingVersion);
	}
	
	public AccountingDocumentPosting forgetByAll(RetailscmUserContext userContext, String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion);		
	}
	protected AccountingDocumentPosting forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().disconnectFromAll(accountingDocumentPostingId, accountingDocumentPostingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentPostingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().deleteAll();
	}


	//disconnect AccountingDocumentPosting with accounting_period in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentPostingDAO().planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentPosting, accountingPeriodId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}
	//disconnect AccountingDocumentPosting with document_type in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentPostingId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentPostingDAO().planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentPosting, documentTypeId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);

		
		userContext.getChecker().checkNameOfAccountingDocument(name);
		
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		userContext.getChecker().checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		userContext.getChecker().checkDocumentTypeIdOfAccountingDocument(documentTypeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);

	
	}
	public  AccountingDocumentPosting addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentPostingId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.addAccountingDocument( accountingDocument );		
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentPostingId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		userContext.getChecker().checkIdOfAccountingDocument(id);
		
		userContext.getChecker().checkNameOfAccountingDocument( name);
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);
		
	}
	public  AccountingDocumentPosting updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentPostingId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentPostingId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();
		
		AccountingDocumentPosting accountingDocumentPostingToUpdate = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		if(accountingDocumentPostingToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentPostingManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocument item = accountingDocumentPostingToUpdate.getAccountingDocumentList().first();
		
		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );

		
		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentPostingId,name, code, used,tokensExpr);
		AccountingDocumentPosting accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPostingToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentPosting){ 
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentPostingId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		for(String accountingDocumentId: accountingDocumentIds){
			userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);
		
	}
	public  AccountingDocumentPosting removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentPostingId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentPostingId,  accountingDocumentIds, tokensExpr);
			
			
			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
			synchronized(accountingDocumentPosting){ 
				//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentPostingDAO().planToRemoveAccountingDocumentList(accountingDocumentPosting, accountingDocumentIds, allTokens());
				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentPosting.getAccountingDocumentList());
				return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentPosting( accountingDocumentPostingId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);
	
	}
	public  AccountingDocumentPosting removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.removeAccountingDocument( accountingDocument );		
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentPosting( accountingDocumentPostingId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);
	
	}
	public  AccountingDocumentPosting copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocumentPosting.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentPosting.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocument(parseString(newValueExpr));
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);
	
	}
	
	public  AccountingDocumentPosting updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();
		
		
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, loadTokens);
		
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentPosting.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentPosting.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentPostingManagerException(accountingDocument+" is NOT FOUND" );
			}
			
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  AccountingDocumentPosting associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().createAccountingDocumentCreation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentPosting.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting);
	}	public  AccountingDocumentPosting associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().createAccountingDocumentConfirmation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentPosting.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting);
	}	public  AccountingDocumentPosting associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().createAccountingDocumentAuditing(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentPosting.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting);
	}
	*/
	
	public  AccountingDocumentPosting associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().loadAccountingDocumentCreation(userContext,creationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentPosting.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting);
	}	public  AccountingDocumentPosting associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().loadAccountingDocumentConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentPosting.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting);
	}	public  AccountingDocumentPosting associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String auditingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().loadAccountingDocumentAuditing(userContext,auditingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentPosting.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentPosting newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


