
package com.doublechaintech.retailscm.accountingdocumenttype;

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






public class AccountingDocumentTypeManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentTypeTokens.start().withTokenFromListName(listName).done();
		AccountingDocumentType  accountingDocumentType = (AccountingDocumentType) this.loadAccountingDocumentType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocumentType.collectRefercencesFromLists();
		accountingDocumentTypeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocumentType, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentTypeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocumentType";
	@Override
	public AccountingDocumentTypeDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentTypeDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentType, tokens);
 	}
 	
 	
 	 public AccountingDocumentType searchAccountingDocumentType(RetailscmUserContext userContext, String accountingDocumentTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentType, tokens);
 	}
 	
 	

 	protected AccountingDocumentType present(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentType,tokens);
		
		
		AccountingDocumentType  accountingDocumentTypeToPresent = accountingDocumentTypeDaoOf(userContext).present(accountingDocumentType, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentTypeToPresent.collectRefercencesFromLists();
		accountingDocumentTypeDaoOf(userContext).alias(entityListToNaming);
		
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
 		return accountingDocumentTypeDaoOf(userContext).save(accountingDocumentType, tokens);
 	}
 	protected AccountingDocumentType loadAccountingDocumentType(RetailscmUserContext userContext, String accountingDocumentTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentTypeManagerException.class);

 
 		return accountingDocumentTypeDaoOf(userContext).load(accountingDocumentTypeId, tokens);
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
	
 	
 	
 
 	
 	

	public AccountingDocumentType createAccountingDocumentType(RetailscmUserContext userContext, String name,String description,String accountingPeriodId) throws Exception
	//public AccountingDocumentType createAccountingDocumentType(RetailscmUserContext userContext,String name, String description, String accountingPeriodId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfAccountingDocumentType(name);
		checkerOf(userContext).checkDescriptionOfAccountingDocumentType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).checkVersionOfAccountingDocumentType( accountingDocumentTypeVersion);
		

		if(AccountingDocumentType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocumentType(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfAccountingDocumentType(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);


	}



	public AccountingDocumentType clone(RetailscmUserContext userContext, String fromAccountingDocumentTypeId) throws Exception{

		return accountingDocumentTypeDaoOf(userContext).clone(fromAccountingDocumentTypeId, this.allTokens());
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
			if (accountingDocumentType.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
 		checkerOf(userContext).checkIdOfAccountSet(anotherAccountingPeriodId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

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
		SmartList<AccountSet> candidateList = accountSetDaoOf(userContext).requestCandidateAccountSetForAccountingDocumentType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected AccountSet loadAccountSet(RetailscmUserContext userContext, String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{

 		return accountSetDaoOf(userContext).load(newAccountingPeriodId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception{

		accountingDocumentTypeDaoOf(userContext).delete(accountingDocumentTypeId, accountingDocumentTypeVersion);
	}

	public AccountingDocumentType forgetByAll(RetailscmUserContext userContext, String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion);
	}
	protected AccountingDocumentType forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception{

		return accountingDocumentTypeDaoOf(userContext).disconnectFromAll(accountingDocumentTypeId, accountingDocumentTypeVersion);
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
		return accountingDocumentTypeDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocumentType with accounting_period in AccountingDocument
	protected AccountingDocumentType breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentTypeId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());

			synchronized(accountingDocumentType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentTypeDaoOf(userContext).planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentType, accountingPeriodId, this.emptyOptions());

				accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
				return accountingDocumentType;
			}
	}






	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);

		
		checkerOf(userContext).checkNameOfAccountingDocument(name);
		
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		checkerOf(userContext).checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);


	}
	public  AccountingDocumentType addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocument(userContext,accountingDocumentTypeId,name, accountingDocumentDate, accountingPeriodId,tokensExpr);

		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId);

		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).checkIdOfAccountingDocument(id);

		checkerOf(userContext).checkNameOfAccountingDocument( name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

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

		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		for(String accountingDocumentIdItem: accountingDocumentIds){
			checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

	}
	public  AccountingDocumentType removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentTypeId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentTypeId,  accountingDocumentIds, tokensExpr);


			AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
			synchronized(accountingDocumentType){
				//Will be good when the accountingDocumentType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentTypeDaoOf(userContext).planToRemoveAccountingDocumentList(accountingDocumentType, accountingDocumentIds, allTokens());
				accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentType.getAccountingDocumentList());
				return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentType( accountingDocumentTypeId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfAccountingDocumentType( accountingDocumentTypeId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

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

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentType newCreated) throws Exception{
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
		//   AccountingDocumentType newAccountingDocumentType = this.createAccountingDocumentType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocumentType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocumentType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocumentType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountSet> accountingPeriodList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountSet.class);
		userContext.getDAOGroup().enhanceList(accountingPeriodList, AccountSet.class);


    }
	
	public Object listByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId) throws Exception {
		return listPageByAccountingPeriod(userContext, accountingPeriodId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int start, int count) throws Exception {
		SmartList<AccountingDocumentType> list = accountingDocumentTypeDaoOf(userContext).findAccountingDocumentTypeByAccountingPeriod(accountingPeriodId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingDocumentType.class);
		page.setContainerObject(AccountSet.withId(accountingPeriodId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证类型列表");
		page.setRequestName("listByAccountingPeriod");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAccountingPeriod/%s/",  getBeanName(), accountingPeriodId)));

		page.assemblerContent(userContext, "listByAccountingPeriod");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentTypeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentTypeDetailScope().clone();
		AccountingDocumentType merchantObj = (AccountingDocumentType) this.view(userContext, accountingDocumentTypeId);
    String merchantObjId = accountingDocumentTypeId;
    String linkToUrl =	"accountingDocumentTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证类型"+"详情";
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
				MapUtil.put("id", "3-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "4-accountingPeriod")
				    .put("fieldName", "accountingPeriod")
				    .put("label", "会计期间")
				    .put("type", "auto")
				    .put("linkToUrl", "accountSetManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"year_set\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("accountingPeriod", merchantObj.getAccountingPeriod());

		//处理 sectionList

		//处理Section：accountingDocumentListSection
		Map accountingDocumentListSection = ListofUtils.buildSection(
		    "accountingDocumentListSection",
		    "会计文档列表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentManager/listByDocumentType/"+merchantObjId+"/",
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


