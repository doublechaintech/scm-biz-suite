
package com.doublechaintech.retailscm.accountingperiod;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountset.CandidateAccountSet;

import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;






public class AccountingPeriodManagerImpl extends CustomRetailscmCheckerManager implements AccountingPeriodManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingPeriodTokens.start().withTokenFromListName(listName).done();
		AccountingPeriod  accountingPeriod = (AccountingPeriod) this.loadAccountingPeriod(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingPeriod.collectRefercencesFromLists();
		accountingPeriodDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingPeriod, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingPeriodGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingPeriod";
	@Override
	public AccountingPeriodDAO daoOf(RetailscmUserContext userContext) {
		return accountingPeriodDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingPeriodManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingPeriodManagerException(message);

	}



 	protected AccountingPeriod saveAccountingPeriod(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, String [] tokensExpr) throws Exception{	
 		//return getAccountingPeriodDAO().save(accountingPeriod, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingPeriod(userContext, accountingPeriod, tokens);
 	}
 	
 	protected AccountingPeriod saveAccountingPeriodDetail(RetailscmUserContext userContext, AccountingPeriod accountingPeriod) throws Exception{	

 		
 		return saveAccountingPeriod(userContext, accountingPeriod, allTokens());
 	}
 	
 	public AccountingPeriod loadAccountingPeriod(RetailscmUserContext userContext, String accountingPeriodId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingPeriodManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingPeriod, tokens);
 	}
 	
 	
 	 public AccountingPeriod searchAccountingPeriod(RetailscmUserContext userContext, String accountingPeriodId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingPeriodManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingPeriod, tokens);
 	}
 	
 	

 	protected AccountingPeriod present(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingPeriod,tokens);
		
		
		AccountingPeriod  accountingPeriodToPresent = accountingPeriodDaoOf(userContext).present(accountingPeriod, tokens);
		
		List<BaseEntity> entityListToNaming = accountingPeriodToPresent.collectRefercencesFromLists();
		accountingPeriodDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingPeriodToPresent;
		
		
	}
 
 	
 	
 	public AccountingPeriod loadAccountingPeriodDetail(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{	
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, allTokens());
 		return present(userContext,accountingPeriod, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{	
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, viewTokens());
 		return present(userContext,accountingPeriod, allTokens());
		
 	}
 	protected AccountingPeriod saveAccountingPeriod(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, Map<String,Object>tokens) throws Exception{	
 		return accountingPeriodDaoOf(userContext).save(accountingPeriod, tokens);
 	}
 	protected AccountingPeriod loadAccountingPeriod(RetailscmUserContext userContext, String accountingPeriodId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingPeriodManagerException.class);

 
 		return accountingPeriodDaoOf(userContext).load(accountingPeriodId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens){
		super.addActions(userContext, accountingPeriod, tokens);
		
		addAction(userContext, accountingPeriod, tokens,"@create","createAccountingPeriod","createAccountingPeriod/","main","primary");
		addAction(userContext, accountingPeriod, tokens,"@update","updateAccountingPeriod","updateAccountingPeriod/"+accountingPeriod.getId()+"/","main","primary");
		addAction(userContext, accountingPeriod, tokens,"@copy","cloneAccountingPeriod","cloneAccountingPeriod/"+accountingPeriod.getId()+"/","main","primary");
		
		addAction(userContext, accountingPeriod, tokens,"accounting_period.transfer_to_account_set","transferToAnotherAccountSet","transferToAnotherAccountSet/"+accountingPeriod.getId()+"/","main","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingPeriod createAccountingPeriod(RetailscmUserContext userContext, String name,Date startDate,Date endDate,String accountSetId) throws Exception
	//public AccountingPeriod createAccountingPeriod(RetailscmUserContext userContext,String name, Date startDate, Date endDate, String accountSetId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfAccountingPeriod(name);
		checkerOf(userContext).checkStartDateOfAccountingPeriod(startDate);
		checkerOf(userContext).checkEndDateOfAccountingPeriod(endDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);


		AccountingPeriod accountingPeriod=createNewAccountingPeriod();	

		accountingPeriod.setName(name);
		accountingPeriod.setStartDate(startDate);
		accountingPeriod.setEndDate(endDate);
			
		AccountSet accountSet = loadAccountSet(userContext, accountSetId,emptyOptions());
		accountingPeriod.setAccountSet(accountSet);
		
		

		accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingPeriod);
		return accountingPeriod;


	}
	protected AccountingPeriod createNewAccountingPeriod()
	{

		return new AccountingPeriod();
	}

	protected void checkParamsForUpdatingAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).checkVersionOfAccountingPeriod( accountingPeriodVersion);
		

		if(AccountingPeriod.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingPeriod(parseString(newValueExpr));
		
			
		}
		if(AccountingPeriod.START_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStartDateOfAccountingPeriod(parseDate(newValueExpr));
		
			
		}
		if(AccountingPeriod.END_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEndDateOfAccountingPeriod(parseDate(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);


	}



	public AccountingPeriod clone(RetailscmUserContext userContext, String fromAccountingPeriodId) throws Exception{

		return accountingPeriodDaoOf(userContext).clone(fromAccountingPeriodId, this.allTokens());
	}

	public AccountingPeriod internalSaveAccountingPeriod(RetailscmUserContext userContext, AccountingPeriod accountingPeriod) throws Exception
	{
		return internalSaveAccountingPeriod(userContext, accountingPeriod, allTokens());

	}
	public AccountingPeriod internalSaveAccountingPeriod(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingPeriod(userContext, accountingPeriodId, accountingPeriodVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingPeriod){
			//will be good when the accountingPeriod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingPeriod.
			if (accountingPeriod.isChanged()){
			
			}
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, options);
			return accountingPeriod;

		}

	}

	public AccountingPeriod updateAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingPeriod(userContext, accountingPeriodId, accountingPeriodVersion, property, newValueExpr, tokensExpr);



		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		if(accountingPeriod.getVersion() != accountingPeriodVersion){
			String message = "The target version("+accountingPeriod.getVersion()+") is not equals to version("+accountingPeriodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingPeriod){
			//will be good when the accountingPeriod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingPeriod.
			
			accountingPeriod.changeProperty(property, newValueExpr);
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
			//return saveAccountingPeriod(userContext, accountingPeriod, tokens().done());
		}

	}

	public AccountingPeriod updateAccountingPeriodProperty(RetailscmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingPeriod(userContext, accountingPeriodId, accountingPeriodVersion, property, newValueExpr, tokensExpr);

		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		if(accountingPeriod.getVersion() != accountingPeriodVersion){
			String message = "The target version("+accountingPeriod.getVersion()+") is not equals to version("+accountingPeriodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingPeriod){
			//will be good when the accountingPeriod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingPeriod.

			accountingPeriod.changeProperty(property, newValueExpr);
			
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
			//return saveAccountingPeriod(userContext, accountingPeriod, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingPeriodTokens tokens(){
		return AccountingPeriodTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingPeriodTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingPeriodTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountSet(RetailscmUserContext userContext, String accountingPeriodId, String anotherAccountSetId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
 		checkerOf(userContext).checkIdOfAccountSet(anotherAccountSetId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);

 	}
 	public AccountingPeriod transferToAnotherAccountSet(RetailscmUserContext userContext, String accountingPeriodId, String anotherAccountSetId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountSet(userContext, accountingPeriodId,anotherAccountSetId);
 
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());	
		synchronized(accountingPeriod){
			//will be good when the accountingPeriod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountSet accountSet = loadAccountSet(userContext, anotherAccountSetId, emptyOptions());		
			accountingPeriod.updateAccountSet(accountSet);		
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, emptyOptions());
			
			return present(userContext,accountingPeriod, allTokens());
			
		}

 	}

	


	public CandidateAccountSet requestCandidateAccountSet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<AccountSet> candidateList = accountSetDaoOf(userContext).requestCandidateAccountSetForAccountingPeriod(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected AccountSet loadAccountSet(RetailscmUserContext userContext, String newAccountSetId, Map<String,Object> options) throws Exception
 	{

 		return accountSetDaoOf(userContext).load(newAccountSetId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingPeriodId, int accountingPeriodVersion) throws Exception {
		//deleteInternal(userContext, accountingPeriodId, accountingPeriodVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingPeriodId, int accountingPeriodVersion) throws Exception{

		accountingPeriodDaoOf(userContext).delete(accountingPeriodId, accountingPeriodVersion);
	}

	public AccountingPeriod forgetByAll(RetailscmUserContext userContext, String accountingPeriodId, int accountingPeriodVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingPeriodId, accountingPeriodVersion);
	}
	protected AccountingPeriod forgetByAllInternal(RetailscmUserContext userContext,
			String accountingPeriodId, int accountingPeriodVersion) throws Exception{

		return accountingPeriodDaoOf(userContext).disconnectFromAll(accountingPeriodId, accountingPeriodVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingPeriodManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountingPeriodDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingPeriod with document_type in AccountingDocument
	protected AccountingPeriod breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingPeriodId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());

			synchronized(accountingPeriod){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingPeriodDaoOf(userContext).planToRemoveAccountingDocumentListWithDocumentType(accountingPeriod, documentTypeId, this.emptyOptions());

				accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
				return accountingPeriod;
			}
	}






	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);

		
		checkerOf(userContext).checkNameOfAccountingDocument(name);
		
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		checkerOf(userContext).checkDocumentTypeIdOfAccountingDocument(documentTypeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);


	}
	public  AccountingPeriod addAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocument(userContext,accountingPeriodId,name, accountingDocumentDate, documentTypeId,tokensExpr);

		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, documentTypeId);

		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, emptyOptions());
		synchronized(accountingPeriod){
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingPeriod.addAccountingDocument( accountingDocument );
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingPeriodId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).checkIdOfAccountingDocument(id);

		checkerOf(userContext).checkNameOfAccountingDocument( name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);

	}
	public  AccountingPeriod updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingPeriodId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingPeriodId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();

		AccountingPeriod accountingPeriodToUpdate = loadAccountingPeriod(userContext, accountingPeriodId, options);

		if(accountingPeriodToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingPeriodManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocument item = accountingPeriodToUpdate.getAccountingDocumentList().first();

		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );


		//checkParamsForAddingAccountingDocument(userContext,accountingPeriodId,name, code, used,tokensExpr);
		AccountingPeriod accountingPeriod = saveAccountingPeriod(userContext, accountingPeriodToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingPeriod){
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String documentTypeId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingDocumentType  documentType = new AccountingDocumentType();
		documentType.setId(documentTypeId);		
		accountingDocument.setDocumentType(documentType);
	
		
		return accountingDocument;


	}

	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;

	}

	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingPeriodId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		for(String accountingDocumentIdItem: accountingDocumentIds){
			checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);

	}
	public  AccountingPeriod removeAccountingDocumentList(RetailscmUserContext userContext, String accountingPeriodId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentList(userContext, accountingPeriodId,  accountingDocumentIds, tokensExpr);


			AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
			synchronized(accountingPeriod){
				//Will be good when the accountingPeriod loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingPeriodDaoOf(userContext).planToRemoveAccountingDocumentList(accountingPeriod, accountingDocumentIds, allTokens());
				accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingPeriod.getAccountingDocumentList());
				return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingPeriod( accountingPeriodId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);

	}
	public  AccountingPeriod removeAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocument(userContext,accountingPeriodId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		synchronized(accountingPeriod){
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingPeriod.removeAccountingDocument( accountingDocument );
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingPeriod( accountingPeriodId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);

	}
	public  AccountingPeriod copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingPeriodId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocument(userContext,accountingPeriodId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		synchronized(accountingPeriod){
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingPeriod.copyAccountingDocumentFrom( accountingDocument );
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingPeriod.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingPeriodManagerException.class);

	}

	public  AccountingPeriod updateAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocument(userContext, accountingPeriodId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();



		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, loadTokens);

		synchronized(accountingPeriod){
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingPeriod.removeAccountingDocument( accountingDocument );
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

			AccountingDocument accountingDocument = accountingPeriod.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingPeriodManagerException(accountingDocument+" is NOT FOUND" );
			}

			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingPeriod newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   AccountingPeriod newAccountingPeriod = this.createAccountingPeriod(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingPeriod
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingPeriod.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingPeriod> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountSet> accountSetList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountSet.class);
		userContext.getDAOGroup().enhanceList(accountSetList, AccountSet.class);


    }
	
	public Object listByAccountSet(RetailscmUserContext userContext,String accountSetId) throws Exception {
		return listPageByAccountSet(userContext, accountSetId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByAccountSet(RetailscmUserContext userContext,String accountSetId, int start, int count) throws Exception {
		SmartList<AccountingPeriod> list = accountingPeriodDaoOf(userContext).findAccountingPeriodByAccountSet(accountSetId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingPeriod.class);
		page.setContainerObject(AccountSet.withId(accountSetId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计期间列表");
		page.setRequestName("listByAccountSet");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAccountSet/%s/",  getBeanName(), accountSetId)));

		page.assemblerContent(userContext, "listByAccountSet");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingPeriodDetailScope().clone();
		AccountingPeriod merchantObj = (AccountingPeriod) this.view(userContext, accountingPeriodId);
    String merchantObjId = accountingPeriodId;
    String linkToUrl =	"accountingPeriodManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计期间"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-startDate")
				    .put("fieldName", "startDate")
				    .put("label", "开始日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("startDate", merchantObj.getStartDate());

		propList.add(
				MapUtil.put("id", "4-endDate")
				    .put("fieldName", "endDate")
				    .put("label", "结束日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("endDate", merchantObj.getEndDate());

		propList.add(
				MapUtil.put("id", "5-accountSet")
				    .put("fieldName", "accountSet")
				    .put("label", "账套")
				    .put("type", "auto")
				    .put("linkToUrl", "accountSetManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"year_set\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("accountSet", merchantObj.getAccountSet());

		//处理 sectionList

		//处理Section：accountingDocumentListSection
		Map accountingDocumentListSection = ListofUtils.buildSection(
		    "accountingDocumentListSection",
		    "会计文档列表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentManager/listByAccountingPeriod/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingDocumentListSection);

		result.put("accountingDocumentListSection", ListofUtils.toShortList(merchantObj.getAccountingDocumentList(), "accountingDocument"));
		vscope.field("accountingDocumentListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountingDocument.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


