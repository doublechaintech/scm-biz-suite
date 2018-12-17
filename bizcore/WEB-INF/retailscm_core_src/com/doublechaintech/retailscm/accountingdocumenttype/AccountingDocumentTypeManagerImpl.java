
package com.doublechaintech.retailscm.accountingdocumenttype;

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
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountset.CandidateAccountSet;

import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;






public class AccountingDocumentTypeManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentTypeManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingDocumentTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentTypeManagerException(message);

	}
	
	

 	protected AccountingDocumentType saveAccountingDocumentType(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentTypeDAO().save(accountingDocumentType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentType(userContext, accountingDocumentType, tokens);
 	}
 	
 	protected AccountingDocumentType saveAccountingDocumentTypeDetail(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType) throws Exception{	

 		
 		return saveAccountingDocumentType(userContext, accountingDocumentType, allTokens());
 	}
 	
 	public AccountingDocumentType loadAccountingDocumentType(RetailscmUserContext userContext, String accountingDocumentTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentType, tokens);
 	}
 	
 	
 	 public AccountingDocumentType searchAccountingDocumentType(RetailscmUserContext userContext, String accountingDocumentTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentType, tokens);
 	}
 	
 	

 	protected AccountingDocumentType present(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentType,tokens);
		
		
		AccountingDocumentType  accountingDocumentTypeToPresent = userContext.getDAOGroup().getAccountingDocumentTypeDAO().present(accountingDocumentType, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingDocumentTypeDAO().alias(entityListToNaming);
		
		return  accountingDocumentTypeToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentType loadAccountingDocumentTypeDetail(RetailscmUserContext userContext, String accountingDocumentTypeId) throws Exception{	
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, allTokens());
 		return present(userContext,accountingDocumentType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentTypeId) throws Exception{	
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, viewTokens());
 		return present(userContext,accountingDocumentType, allTokens());
		
 	}
 	protected AccountingDocumentType saveAccountingDocumentType(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingDocumentTypeDAO().save(accountingDocumentType, tokens);
 	}
 	protected AccountingDocumentType loadAccountingDocumentType(RetailscmUserContext userContext, String accountingDocumentTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentTypeManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingDocumentTypeDAO().load(accountingDocumentTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentType, tokens);
		
		addAction(userContext, accountingDocumentType, tokens,"@create","createAccountingDocumentType","createAccountingDocumentType/","main","primary");
		addAction(userContext, accountingDocumentType, tokens,"@update","updateAccountingDocumentType","updateAccountingDocumentType/"+accountingDocumentType.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentType, tokens,"@copy","cloneAccountingDocumentType","cloneAccountingDocumentType/"+accountingDocumentType.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.transfer_to_accounting_period","transferToAnotherAccountingPeriod","transferToAnotherAccountingPeriod/"+accountingDocumentType.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentType createAccountingDocumentType(RetailscmUserContext userContext,String name, String description, String accountingPeriodId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfAccountingDocumentType(name);
		userContext.getChecker().checkDescriptionOfAccountingDocumentType(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);


		AccountingDocumentType accountingDocumentType=createNewAccountingDocumentType();	

		accountingDocumentType.setName(name);
		accountingDocumentType.setDescription(description);
			
		AccountSet accountingPeriod = loadAccountSet(userContext, accountingPeriodId,emptyOptions());
		accountingDocumentType.setAccountingPeriod(accountingPeriod);
		
		

		accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentType);
		return accountingDocumentType;

		
	}
	protected AccountingDocumentType createNewAccountingDocumentType() 
	{
		
		return new AccountingDocumentType();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentType(RetailscmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().checkVersionOfAccountingDocumentType( accountingDocumentTypeVersion);
		

		if(AccountingDocumentType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocumentType(parseString(newValueExpr));
		}
		if(AccountingDocumentType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfAccountingDocumentType(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
	
		
	}
	
	
	
	public AccountingDocumentType clone(RetailscmUserContext userContext, String fromAccountingDocumentTypeId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingDocumentTypeDAO().clone(fromAccountingDocumentTypeId, this.allTokens());
	}
	
	public AccountingDocumentType internalSaveAccountingDocumentType(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType) throws Exception 
	{
		return internalSaveAccountingDocumentType(userContext, accountingDocumentType, allTokens());

	}
	public AccountingDocumentType internalSaveAccountingDocumentType(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingDocumentType(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingDocumentType){ 
			//will be good when the accountingDocumentType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentType.
			
			
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, options);
			return accountingDocumentType;
			
		}

	}
	
	public AccountingDocumentType updateAccountingDocumentType(RetailscmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentType(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		if(accountingDocumentType.getVersion() != accountingDocumentTypeVersion){
			String message = "The target version("+accountingDocumentType.getVersion()+") is not equals to version("+accountingDocumentTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentType){ 
			//will be good when the accountingDocumentType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentType.
			
			accountingDocumentType.changeProperty(property, newValueExpr);
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
		}

	}
	
	public AccountingDocumentType updateAccountingDocumentTypeProperty(RetailscmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentType(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		if(accountingDocumentType.getVersion() != accountingDocumentTypeVersion){
			String message = "The target version("+accountingDocumentType.getVersion()+") is not equals to version("+accountingDocumentTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentType){ 
			//will be good when the accountingDocumentType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentType.
			
			accountingDocumentType.changeProperty(property, newValueExpr);
			
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentTypeTokens tokens(){
		return AccountingDocumentTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
 		userContext.getChecker().checkIdOfAccountSet(anotherAccountingPeriodId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
 		
 	}
 	public AccountingDocumentType transferToAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingPeriod(userContext, accountingDocumentTypeId,anotherAccountingPeriodId);
 
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());	
		synchronized(accountingDocumentType){
			//will be good when the accountingDocumentType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountSet accountingPeriod = loadAccountSet(userContext, anotherAccountingPeriodId, emptyOptions());		
			accountingDocumentType.updateAccountingPeriod(accountingPeriod);		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, emptyOptions());
			
			return present(userContext,accountingDocumentType, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountSet requestCandidateAccountingPeriod(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountSet result = new CandidateAccountSet();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountSet> candidateList = userContext.getDAOGroup().getAccountSetDAO().requestCandidateAccountSetForAccountingDocumentType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected AccountSet loadAccountSet(RetailscmUserContext userContext, String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountSetDAO().load(newAccountingPeriodId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingDocumentTypeDAO().delete(accountingDocumentTypeId, accountingDocumentTypeVersion);
	}
	
	public AccountingDocumentType forgetByAll(RetailscmUserContext userContext, String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion);		
	}
	protected AccountingDocumentType forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingDocumentTypeDAO().disconnectFromAll(accountingDocumentTypeId, accountingDocumentTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingDocumentTypeDAO().deleteAll();
	}


	//disconnect AccountingDocumentType with accounting_period in AccountingDocument
	protected AccountingDocumentType breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentTypeId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());

			synchronized(accountingDocumentType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentTypeDAO().planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentType, accountingPeriodId, this.emptyOptions());

				accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
				return accountingDocumentType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);

		
		userContext.getChecker().checkNameOfAccountingDocument(name);
		
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		userContext.getChecker().checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

	
	}
	public  AccountingDocumentType addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentTypeId,name, accountingDocumentDate, accountingPeriodId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId);
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentType.addAccountingDocument( accountingDocument );		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentTypeId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().checkIdOfAccountingDocument(id);
		
		userContext.getChecker().checkNameOfAccountingDocument( name);
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
		
	}
	public  AccountingDocumentType updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentTypeId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentTypeId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();
		
		AccountingDocumentType accountingDocumentTypeToUpdate = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		if(accountingDocumentTypeToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentTypeManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocument item = accountingDocumentTypeToUpdate.getAccountingDocumentList().first();
		
		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );

		
		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentTypeId,name, code, used,tokensExpr);
		AccountingDocumentType accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentTypeToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentType){ 
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingPeriod  accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(accountingPeriodId);		
		accountingDocument.setAccountingPeriod(accountingPeriod);		
		accountingDocument.setCurrentStatus("INIT");
	
		
		return accountingDocument;
	
		
	}
	
	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;			
		
	}
	
	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentTypeId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		for(String accountingDocumentId: accountingDocumentIds){
			userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
		
	}
	public  AccountingDocumentType removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentTypeId, 
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentTypeId,  accountingDocumentIds, tokensExpr);
			
			
			AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
			synchronized(accountingDocumentType){ 
				//Will be good when the accountingDocumentType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentTypeDAO().planToRemoveAccountingDocumentList(accountingDocumentType, accountingDocumentIds, allTokens());
				accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentType.getAccountingDocumentList());
				return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentType( accountingDocumentTypeId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
	
	}
	public  AccountingDocumentType removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentTypeId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentType.removeAccountingDocument( accountingDocument );		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocumentType( accountingDocumentTypeId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
	
	}
	public  AccountingDocumentType copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentTypeId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocumentType.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocument(parseString(newValueExpr));
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
	
	}
	
	public  AccountingDocumentType updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentTypeId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();
		
		
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, loadTokens);
		
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentType.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentType.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentTypeManagerException(accountingDocument+" is NOT FOUND" );
			}
			
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  AccountingDocumentType associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().createAccountingDocumentCreation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}	public  AccountingDocumentType associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().createAccountingDocumentConfirmation(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}	public  AccountingDocumentType associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().createAccountingDocumentAuditing(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}	public  AccountingDocumentType associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().createAccountingDocumentPosting(userContext,  who,  comments,  makeDate);
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}
	*/
	
	public  AccountingDocumentType associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentCreation creation = userContext.getManagerGroup().getAccountingDocumentCreationManager().loadAccountingDocumentCreation(userContext,creationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateCreation(creation);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}	public  AccountingDocumentType associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentConfirmation confirmation = userContext.getManagerGroup().getAccountingDocumentConfirmationManager().loadAccountingDocumentConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}	public  AccountingDocumentType associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String auditingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentAuditing auditing = userContext.getManagerGroup().getAccountingDocumentAuditingManager().loadAccountingDocumentAuditing(userContext,auditingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}	public  AccountingDocumentType associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String postingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "oneof", this.joinArray("|", accountingDocumentIds)).done();
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);
		
		AccountingDocumentPosting posting = userContext.getManagerGroup().getAccountingDocumentPostingManager().loadAccountingDocumentPosting(userContext,postingId,new String[]{"none"} );
		
		for(AccountingDocument accountingDocument: accountingDocumentType.getAccountingDocumentList()) {
			//TODO: need to check if already associated
			accountingDocument.updatePosting(posting);
		}
		return this.internalSaveAccountingDocumentType(userContext, accountingDocumentType);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


