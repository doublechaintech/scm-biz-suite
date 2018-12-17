
package com.doublechaintech.retailscm.accountingdocument;

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

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.accountingdocumentposting.CandidateAccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.CandidateAccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.CandidateAccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.CandidateAccountingDocumentConfirmation;
import com.doublechaintech.retailscm.accountingdocumenttype.CandidateAccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.CandidateAccountingPeriod;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;






public class AccountingDocumentManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentManager {
	
	private static final String SERVICE_TYPE = "AccountingDocument";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingDocumentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentManagerException(message);

	}
	
	

 	protected AccountingDocument saveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentDAO().save(accountingDocument, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocument(userContext, accountingDocument, tokens);
 	}
 	
 	protected AccountingDocument saveAccountingDocumentDetail(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception{	

 		
 		return saveAccountingDocument(userContext, accountingDocument, allTokens());
 	}
 	
 	public AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	
 	 public AccountingDocument searchAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	

 	protected AccountingDocument present(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocument,tokens);
		
		
		AccountingDocument  accountingDocumentToPresent = userContext.getDAOGroup().getAccountingDocumentDAO().present(accountingDocument, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingDocumentDAO().alias(entityListToNaming);
		
		return  accountingDocumentToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocument loadAccountingDocumentDetail(RetailscmUserContext userContext, String accountingDocumentId) throws Exception{	
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, allTokens());
 		return present(userContext,accountingDocument, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentId) throws Exception{	
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, viewTokens());
 		return present(userContext,accountingDocument, allTokens());
		
 	}
 	protected AccountingDocument saveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingDocumentDAO().save(accountingDocument, tokens);
 	}
 	protected AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingDocumentDAO().load(accountingDocumentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocument, tokens);
		
		addAction(userContext, accountingDocument, tokens,"@create","createAccountingDocument","createAccountingDocument/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@update","updateAccountingDocument","updateAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@copy","cloneAccountingDocument","cloneAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_accounting_period","transferToAnotherAccountingPeriod","transferToAnotherAccountingPeriod/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_document_type","transferToAnotherDocumentType","transferToAnotherDocumentType/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.create","create","createActionForm/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.confirm","confirm","confirmActionForm/"+accountingDocument.getId()+"/","main","success");
		addAction(userContext, accountingDocument, tokens,"accounting_document.audit","audit","auditActionForm/"+accountingDocument.getId()+"/","main","success");
		addAction(userContext, accountingDocument, tokens,"accounting_document.post","post","postActionForm/"+accountingDocument.getId()+"/","main","danger");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addAccountingDocumentLine","addAccountingDocumentLine","addAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeAccountingDocumentLine","removeAccountingDocumentLine","removeAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateAccountingDocumentLine","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocument createAccountingDocument(RetailscmUserContext userContext,String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfAccountingDocument(name);
		userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


		AccountingDocument accountingDocument=createNewAccountingDocument();	

		accountingDocument.setName(name);
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
			
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId,emptyOptions());
		accountingDocument.setAccountingPeriod(accountingPeriod);
		
		
			
		AccountingDocumentType documentType = loadAccountingDocumentType(userContext, documentTypeId,emptyOptions());
		accountingDocument.setDocumentType(documentType);
		
		
		accountingDocument.setCurrentStatus("INIT");

		accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocument);
		return accountingDocument;

		
	}
	protected AccountingDocument createNewAccountingDocument() 
	{
		
		return new AccountingDocument();		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkVersionOfAccountingDocument( accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocument(parseString(newValueExpr));
		}
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
		
	}
	
	
	
	public AccountingDocument clone(RetailscmUserContext userContext, String fromAccountingDocumentId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingDocumentDAO().clone(fromAccountingDocumentId, this.allTokens());
	}
	
	public AccountingDocument internalSaveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception 
	{
		return internalSaveAccountingDocument(userContext, accountingDocument, allTokens());

	}
	public AccountingDocument internalSaveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingDocument){ 
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.
			
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, options);
			return accountingDocument;
			
		}

	}
	
	public AccountingDocument updateAccountingDocument(RetailscmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		if(accountingDocument.getVersion() != accountingDocumentVersion){
			String message = "The target version("+accountingDocument.getVersion()+") is not equals to version("+accountingDocumentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocument){ 
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.
			
			accountingDocument.changeProperty(property, newValueExpr);
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			//return saveAccountingDocument(userContext, accountingDocument, tokens().done());
		}

	}
	
	public AccountingDocument updateAccountingDocumentProperty(RetailscmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		if(accountingDocument.getVersion() != accountingDocumentVersion){
			String message = "The target version("+accountingDocument.getVersion()+") is not equals to version("+accountingDocumentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocument){ 
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.
			
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			//return saveAccountingDocument(userContext, accountingDocument, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentTokens tokens(){
		return AccountingDocumentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.sortAccountingDocumentLineListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"CREATED","CONFIRMED","AUDITED","POSTED"};
 	protected String[] getNextCandidateStatus(RetailscmUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(RetailscmUserContext userContext, AccountingDocument accountingDocument, String expectedNextStatus) throws Exception{
		String currentStatus = accountingDocument.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
 		userContext.getChecker().checkIdOfAccountingPeriod(anotherAccountingPeriodId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
 		
 	}
 	public AccountingDocument transferToAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingPeriod(userContext, accountingDocumentId,anotherAccountingPeriodId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, anotherAccountingPeriodId, emptyOptions());		
			accountingDocument.updateAccountingPeriod(accountingPeriod);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingPeriod requestCandidateAccountingPeriod(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingPeriod result = new CandidateAccountingPeriod();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingPeriod> candidateList = userContext.getDAOGroup().getAccountingPeriodDAO().requestCandidateAccountingPeriodForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherDocumentType(RetailscmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
 		userContext.getChecker().checkIdOfAccountingDocumentType(anotherDocumentTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
 		
 	}
 	public AccountingDocument transferToAnotherDocumentType(RetailscmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherDocumentType(userContext, accountingDocumentId,anotherDocumentTypeId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentType documentType = loadAccountingDocumentType(userContext, anotherDocumentTypeId, emptyOptions());		
			accountingDocument.updateDocumentType(documentType);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingDocumentType requestCandidateDocumentType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentType result = new CandidateAccountingDocumentType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentType> candidateList = userContext.getDAOGroup().getAccountingDocumentTypeDAO().requestCandidateAccountingDocumentTypeForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCreation(RetailscmUserContext userContext, String accountingDocumentId, String anotherCreationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
 		userContext.getChecker().checkIdOfAccountingDocumentCreation(anotherCreationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
 		
 	}
 	public AccountingDocument transferToAnotherCreation(RetailscmUserContext userContext, String accountingDocumentId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, accountingDocumentId,anotherCreationId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentCreation creation = loadAccountingDocumentCreation(userContext, anotherCreationId, emptyOptions());		
			accountingDocument.updateCreation(creation);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingDocumentCreation requestCandidateCreation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentCreation result = new CandidateAccountingDocumentCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentCreation> candidateList = userContext.getDAOGroup().getAccountingDocumentCreationDAO().requestCandidateAccountingDocumentCreationForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CREATED_STATUS = "CREATED";
 	protected void checkParamsForCreation(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkWhoOfAccountingDocumentCreation(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentCreation(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentCreation(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument create(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForCreation(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForCreation(userContext,accountingDocument);
 		

			accountingDocument.updateCurrentStatus(CREATED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentCreation creation = createCreation(userContext, who, comments, makeDate);		
			accountingDocument.updateCreation(creation);		
			
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withCreation().done());
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public AccountingDocumentForm createActionForm(RetailscmUserContext userContext, String accountingDocumentId) throws Exception
 	{
		return new AccountingDocumentForm()
			.withTitle("create")
			.accountingDocumentIdField(accountingDocumentId)
			.whoFieldOfAccountingDocumentCreation()
			.commentsFieldOfAccountingDocumentCreation()
			.makeDateFieldOfAccountingDocumentCreation()
			.createAction();
 	}
	
 	
 	protected AccountingDocumentCreation createCreation(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		AccountingDocumentCreation creation = new AccountingDocumentCreation();
 		//who, comments, makeDate
 		
		creation.setWho(who);
		creation.setComments(comments);
		creation.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().save(creation,emptyOptions());
 	}
 	protected void checkIfEligibleForCreation(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 
 		ensureStatus(userContext,accountingDocument, CREATED_STATUS);
 		
 		AccountingDocumentCreation creation = accountingDocument.getCreation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = creation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( creation != null){
				throwExceptionWithMessage("The AccountingDocument("+accountingDocument.getId()+") has already been "+ CREATED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String anotherConfirmationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
 		userContext.getChecker().checkIdOfAccountingDocumentConfirmation(anotherConfirmationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
 		
 	}
 	public AccountingDocument transferToAnotherConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, accountingDocumentId,anotherConfirmationId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentConfirmation confirmation = loadAccountingDocumentConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			accountingDocument.updateConfirmation(confirmation);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingDocumentConfirmation requestCandidateConfirmation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentConfirmation result = new CandidateAccountingDocumentConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentConfirmation> candidateList = userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().requestCandidateAccountingDocumentConfirmationForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CONFIRMED_STATUS = "CONFIRMED";
 	protected void checkParamsForConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkWhoOfAccountingDocumentConfirmation(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentConfirmation(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentConfirmation(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument confirm(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForConfirmation(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForConfirmation(userContext,accountingDocument);
 		

			accountingDocument.updateCurrentStatus(CONFIRMED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentConfirmation confirmation = createConfirmation(userContext, who, comments, makeDate);		
			accountingDocument.updateConfirmation(confirmation);		
			
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withConfirmation().done());
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public AccountingDocumentForm confirmActionForm(RetailscmUserContext userContext, String accountingDocumentId) throws Exception
 	{
		return new AccountingDocumentForm()
			.withTitle("confirm")
			.accountingDocumentIdField(accountingDocumentId)
			.whoFieldOfAccountingDocumentConfirmation()
			.commentsFieldOfAccountingDocumentConfirmation()
			.makeDateFieldOfAccountingDocumentConfirmation()
			.confirmAction();
 	}
	
 	
 	protected AccountingDocumentConfirmation createConfirmation(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		AccountingDocumentConfirmation confirmation = new AccountingDocumentConfirmation();
 		//who, comments, makeDate
 		
		confirmation.setWho(who);
		confirmation.setComments(comments);
		confirmation.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForConfirmation(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 
 		ensureStatus(userContext,accountingDocument, CONFIRMED_STATUS);
 		
 		AccountingDocumentConfirmation confirmation = accountingDocument.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throwExceptionWithMessage("The AccountingDocument("+accountingDocument.getId()+") has already been "+ CONFIRMED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherAuditing(RetailscmUserContext userContext, String accountingDocumentId, String anotherAuditingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
 		userContext.getChecker().checkIdOfAccountingDocumentAuditing(anotherAuditingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
 		
 	}
 	public AccountingDocument transferToAnotherAuditing(RetailscmUserContext userContext, String accountingDocumentId, String anotherAuditingId) throws Exception
 	{
 		checkParamsForTransferingAnotherAuditing(userContext, accountingDocumentId,anotherAuditingId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentAuditing auditing = loadAccountingDocumentAuditing(userContext, anotherAuditingId, emptyOptions());		
			accountingDocument.updateAuditing(auditing);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingDocumentAuditing requestCandidateAuditing(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentAuditing result = new CandidateAccountingDocumentAuditing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentAuditing> candidateList = userContext.getDAOGroup().getAccountingDocumentAuditingDAO().requestCandidateAccountingDocumentAuditingForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String AUDITED_STATUS = "AUDITED";
 	protected void checkParamsForAuditing(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkWhoOfAccountingDocumentAuditing(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentAuditing(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentAuditing(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument audit(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForAuditing(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForAuditing(userContext,accountingDocument);
 		

			accountingDocument.updateCurrentStatus(AUDITED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentAuditing auditing = createAuditing(userContext, who, comments, makeDate);		
			accountingDocument.updateAuditing(auditing);		
			
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAuditing().done());
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public AccountingDocumentForm auditActionForm(RetailscmUserContext userContext, String accountingDocumentId) throws Exception
 	{
		return new AccountingDocumentForm()
			.withTitle("audit")
			.accountingDocumentIdField(accountingDocumentId)
			.whoFieldOfAccountingDocumentAuditing()
			.commentsFieldOfAccountingDocumentAuditing()
			.makeDateFieldOfAccountingDocumentAuditing()
			.auditAction();
 	}
	
 	
 	protected AccountingDocumentAuditing createAuditing(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		AccountingDocumentAuditing auditing = new AccountingDocumentAuditing();
 		//who, comments, makeDate
 		
		auditing.setWho(who);
		auditing.setComments(comments);
		auditing.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().save(auditing,emptyOptions());
 	}
 	protected void checkIfEligibleForAuditing(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 
 		ensureStatus(userContext,accountingDocument, AUDITED_STATUS);
 		
 		AccountingDocumentAuditing auditing = accountingDocument.getAuditing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = auditing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( auditing != null){
				throwExceptionWithMessage("The AccountingDocument("+accountingDocument.getId()+") has already been "+ AUDITED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherPosting(RetailscmUserContext userContext, String accountingDocumentId, String anotherPostingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
 		userContext.getChecker().checkIdOfAccountingDocumentPosting(anotherPostingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
 		
 	}
 	public AccountingDocument transferToAnotherPosting(RetailscmUserContext userContext, String accountingDocumentId, String anotherPostingId) throws Exception
 	{
 		checkParamsForTransferingAnotherPosting(userContext, accountingDocumentId,anotherPostingId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentPosting posting = loadAccountingDocumentPosting(userContext, anotherPostingId, emptyOptions());		
			accountingDocument.updatePosting(posting);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingDocumentPosting requestCandidatePosting(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentPosting result = new CandidateAccountingDocumentPosting();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentPosting> candidateList = userContext.getDAOGroup().getAccountingDocumentPostingDAO().requestCandidateAccountingDocumentPostingForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String POSTED_STATUS = "POSTED";
 	protected void checkParamsForPosting(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkWhoOfAccountingDocumentPosting(who);
		userContext.getChecker().checkCommentsOfAccountingDocumentPosting(comments);
		userContext.getChecker().checkMakeDateOfAccountingDocumentPosting(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument post(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForPosting(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForPosting(userContext,accountingDocument);
 		

			accountingDocument.updateCurrentStatus(POSTED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentPosting posting = createPosting(userContext, who, comments, makeDate);		
			accountingDocument.updatePosting(posting);		
			
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withPosting().done());
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public AccountingDocumentForm postActionForm(RetailscmUserContext userContext, String accountingDocumentId) throws Exception
 	{
		return new AccountingDocumentForm()
			.withTitle("post")
			.accountingDocumentIdField(accountingDocumentId)
			.whoFieldOfAccountingDocumentPosting()
			.commentsFieldOfAccountingDocumentPosting()
			.makeDateFieldOfAccountingDocumentPosting()
			.postAction();
 	}
	
 	
 	protected AccountingDocumentPosting createPosting(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		AccountingDocumentPosting posting = new AccountingDocumentPosting();
 		//who, comments, makeDate
 		
		posting.setWho(who);
		posting.setComments(comments);
		posting.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().save(posting,emptyOptions());
 	}
 	protected void checkIfEligibleForPosting(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 
 		ensureStatus(userContext,accountingDocument, POSTED_STATUS);
 		
 		AccountingDocumentPosting posting = accountingDocument.getPosting();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = posting 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( posting != null){
				throwExceptionWithMessage("The AccountingDocument("+accountingDocument.getId()+") has already been "+ POSTED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected AccountingDocumentType loadAccountingDocumentType(RetailscmUserContext userContext, String newDocumentTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingDocumentTypeDAO().load(newDocumentTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected AccountingDocumentPosting loadAccountingDocumentPosting(RetailscmUserContext userContext, String newPostingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingDocumentPostingDAO().load(newPostingId, options);
 	}
 	
 	
 	
	
	 	
 	protected AccountingDocumentCreation loadAccountingDocumentCreation(RetailscmUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingDocumentCreationDAO().load(newCreationId, options);
 	}
 	
 	
 	
	
	 	
 	protected AccountingPeriod loadAccountingPeriod(RetailscmUserContext userContext, String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingPeriodDAO().load(newAccountingPeriodId, options);
 	}
 	
 	
 	
	
	 	
 	protected AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailscmUserContext userContext, String newAuditingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().load(newAuditingId, options);
 	}
 	
 	
 	
	
	 	
 	protected AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailscmUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().load(newConfirmationId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentId, accountingDocumentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingDocumentDAO().delete(accountingDocumentId, accountingDocumentVersion);
	}
	
	public AccountingDocument forgetByAll(RetailscmUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentId, accountingDocumentVersion);		
	}
	protected AccountingDocument forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingDocumentDAO().disconnectFromAll(accountingDocumentId, accountingDocumentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingDocumentDAO().deleteAll();
	}


	//disconnect AccountingDocument with accounting_subject in AccountingDocumentLine
	protected AccountingDocument breakWithAccountingDocumentLineByAccountingSubject(RetailscmUserContext userContext, String accountingDocumentId, String accountingSubjectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());

			synchronized(accountingDocument){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingDocumentDAO().planToRemoveAccountingDocumentLineListWithAccountingSubject(accountingDocument, accountingSubjectId, this.emptyOptions());

				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
				return accountingDocument;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);

		
		userContext.getChecker().checkTitleOfOriginalVoucher(title);
		
		userContext.getChecker().checkMadeByOfOriginalVoucher(madeBy);
		
		userContext.getChecker().checkReceivedByOfOriginalVoucher(receivedBy);
		
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher(voucherType);
		
		userContext.getChecker().checkVoucherImageOfOriginalVoucher(voucherImage);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	
	}
	public  AccountingDocument addOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,accountingDocumentId,title, madeBy, receivedBy, voucherType, voucherImage,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage);
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.addOriginalVoucher( originalVoucher );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(RetailscmUserContext userContext, String accountingDocumentId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkIdOfOriginalVoucher(id);
		
		userContext.getChecker().checkTitleOfOriginalVoucher( title);
		userContext.getChecker().checkMadeByOfOriginalVoucher( madeBy);
		userContext.getChecker().checkReceivedByOfOriginalVoucher( receivedBy);
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher( voucherType);
		userContext.getChecker().checkVoucherImageOfOriginalVoucher( voucherImage);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
		
	}
	public  AccountingDocument updateOriginalVoucherProperties(RetailscmUserContext userContext, String accountingDocumentId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingOriginalVoucherProperties(userContext,accountingDocumentId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();
		
		AccountingDocument accountingDocumentToUpdate = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		if(accountingDocumentToUpdate.getOriginalVoucherList().isEmpty()){
			throw new AccountingDocumentManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}
		
		OriginalVoucher item = accountingDocumentToUpdate.getOriginalVoucherList().first();
		
		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );

		
		//checkParamsForAddingOriginalVoucher(userContext,accountingDocumentId,name, code, used,tokensExpr);
		AccountingDocument accountingDocument = saveAccountingDocument(userContext, accountingDocumentToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(accountingDocument){ 
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected OriginalVoucher createOriginalVoucher(RetailscmUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);		
		originalVoucher.setCurrentStatus("INIT");
	
		
		return originalVoucher;
	
		
	}
	
	protected OriginalVoucher createIndexedOriginalVoucher(String id, int version){

		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(version);
		return originalVoucher;			
		
	}
	
	protected void checkParamsForRemovingOriginalVoucherList(RetailscmUserContext userContext, String accountingDocumentId, 
			String originalVoucherIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		for(String originalVoucherId: originalVoucherIds){
			userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
		
	}
	public  AccountingDocument removeOriginalVoucherList(RetailscmUserContext userContext, String accountingDocumentId, 
			String originalVoucherIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingOriginalVoucherList(userContext, accountingDocumentId,  originalVoucherIds, tokensExpr);
			
			
			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
			synchronized(accountingDocument){ 
				//Will be good when the accountingDocument loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentDAO().planToRemoveOriginalVoucherList(accountingDocument, originalVoucherIds, allTokens());
				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, accountingDocument.getOriginalVoucherList());
				return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocument( accountingDocumentId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
	}
	public  AccountingDocument removeOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,accountingDocumentId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.removeOriginalVoucher( originalVoucher );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocument( accountingDocumentId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
	}
	public  AccountingDocument copyOriginalVoucherFrom(RetailscmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,accountingDocumentId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocument.copyOriginalVoucherFrom( originalVoucher );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)accountingDocument.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkMadeByOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkReceivedByOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkVoucherTypeOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkVoucherImageOfOriginalVoucher(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
	}
	
	public  AccountingDocument updateOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, accountingDocumentId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();
		
		
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, loadTokens);
		
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocument.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = accountingDocument.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new AccountingDocumentManagerException(originalVoucher+" is NOT FOUND" );
			}
			
			originalVoucher.changeProperty(property, newValueExpr);
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  AccountingDocument associateOriginalVoucherListToNewCreation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		OriginalVoucherCreation creation = userContext.getManagerGroup().getOriginalVoucherCreationManager().createOriginalVoucherCreation(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: accountingDocument.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateCreation(creation);
		}
		return this.internalSaveAccountingDocument(userContext, accountingDocument);
	}	public  AccountingDocument associateOriginalVoucherListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		OriginalVoucherConfirmation confirmation = userContext.getManagerGroup().getOriginalVoucherConfirmationManager().createOriginalVoucherConfirmation(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: accountingDocument.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocument(userContext, accountingDocument);
	}	public  AccountingDocument associateOriginalVoucherListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		OriginalVoucherAuditing auditing = userContext.getManagerGroup().getOriginalVoucherAuditingManager().createOriginalVoucherAuditing(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: accountingDocument.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocument(userContext, accountingDocument);
	}
	*/
	
	public  AccountingDocument associateOriginalVoucherListToCreation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		OriginalVoucherCreation creation = userContext.getManagerGroup().getOriginalVoucherCreationManager().loadOriginalVoucherCreation(userContext,creationId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: accountingDocument.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateCreation(creation);
		}
		return this.internalSaveAccountingDocument(userContext, accountingDocument);
	}	public  AccountingDocument associateOriginalVoucherListToConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		OriginalVoucherConfirmation confirmation = userContext.getManagerGroup().getOriginalVoucherConfirmationManager().loadOriginalVoucherConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: accountingDocument.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateConfirmation(confirmation);
		}
		return this.internalSaveAccountingDocument(userContext, accountingDocument);
	}	public  AccountingDocument associateOriginalVoucherListToAuditing(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String auditingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		OriginalVoucherAuditing auditing = userContext.getManagerGroup().getOriginalVoucherAuditingManager().loadOriginalVoucherAuditing(userContext,auditingId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: accountingDocument.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateAuditing(auditing);
		}
		return this.internalSaveAccountingDocument(userContext, accountingDocument);
	}


	protected void checkParamsForAddingAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);

		
		userContext.getChecker().checkNameOfAccountingDocumentLine(name);
		
		userContext.getChecker().checkCodeOfAccountingDocumentLine(code);
		
		userContext.getChecker().checkDirectOfAccountingDocumentLine(direct);
		
		userContext.getChecker().checkAmountOfAccountingDocumentLine(amount);
		
		userContext.getChecker().checkAccountingSubjectIdOfAccountingDocumentLine(accountingSubjectId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	
	}
	public  AccountingDocument addAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocumentLine(userContext,accountingDocumentId,name, code, direct, amount, accountingSubjectId,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, accountingSubjectId);
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.addAccountingDocumentLine( accountingDocumentLine );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			
			userContext.getManagerGroup().getAccountingDocumentLineManager().onNewInstanceCreated(userContext, accountingDocumentLine);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentLineProperties(RetailscmUserContext userContext, String accountingDocumentId,String id,String name,String code,String direct,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(id);
		
		userContext.getChecker().checkNameOfAccountingDocumentLine( name);
		userContext.getChecker().checkCodeOfAccountingDocumentLine( code);
		userContext.getChecker().checkDirectOfAccountingDocumentLine( direct);
		userContext.getChecker().checkAmountOfAccountingDocumentLine( amount);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
		
	}
	public  AccountingDocument updateAccountingDocumentLineProperties(RetailscmUserContext userContext, String accountingDocumentId, String id,String name,String code,String direct,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentLineProperties(userContext,accountingDocumentId,id,name,code,direct,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentLineListList()
				.searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, "is", id).done();
		
		AccountingDocument accountingDocumentToUpdate = loadAccountingDocument(userContext, accountingDocumentId, options);
		
		if(accountingDocumentToUpdate.getAccountingDocumentLineList().isEmpty()){
			throw new AccountingDocumentManagerException("AccountingDocumentLine is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocumentLine item = accountingDocumentToUpdate.getAccountingDocumentLineList().first();
		
		item.updateName( name );
		item.updateCode( code );
		item.updateDirect( direct );
		item.updateAmount( amount );

		
		//checkParamsForAddingAccountingDocumentLine(userContext,accountingDocumentId,name, code, used,tokensExpr);
		AccountingDocument accountingDocument = saveAccountingDocument(userContext, accountingDocumentToUpdate, tokens().withAccountingDocumentLineList().done());
		synchronized(accountingDocument){ 
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AccountingDocumentLine createAccountingDocumentLine(RetailscmUserContext userContext, String name, String code, String direct, BigDecimal amount, String accountingSubjectId) throws Exception{

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		
		
		accountingDocumentLine.setName(name);		
		accountingDocumentLine.setCode(code);		
		accountingDocumentLine.setDirect(direct);		
		accountingDocumentLine.setAmount(amount);		
		AccountingSubject  accountingSubject = new AccountingSubject();
		accountingSubject.setId(accountingSubjectId);		
		accountingDocumentLine.setAccountingSubject(accountingSubject);
	
		
		return accountingDocumentLine;
	
		
	}
	
	protected AccountingDocumentLine createIndexedAccountingDocumentLine(String id, int version){

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLine.setId(id);
		accountingDocumentLine.setVersion(version);
		return accountingDocumentLine;			
		
	}
	
	protected void checkParamsForRemovingAccountingDocumentLineList(RetailscmUserContext userContext, String accountingDocumentId, 
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		for(String accountingDocumentLineId: accountingDocumentLineIds){
			userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
		
	}
	public  AccountingDocument removeAccountingDocumentLineList(RetailscmUserContext userContext, String accountingDocumentId, 
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentLineList(userContext, accountingDocumentId,  accountingDocumentLineIds, tokensExpr);
			
			
			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
			synchronized(accountingDocument){ 
				//Will be good when the accountingDocument loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingDocumentDAO().planToRemoveAccountingDocumentLineList(accountingDocument, accountingDocumentLineIds, allTokens());
				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
				deleteRelationListInGraph(userContext, accountingDocument.getAccountingDocumentLineList());
				return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocument( accountingDocumentId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		userContext.getChecker().checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
	}
	public  AccountingDocument removeAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocumentLine(userContext,accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.removeAccountingDocumentLine( accountingDocumentLine );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			deleteRelationInGraph(userContext, accountingDocumentLine);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingDocument( accountingDocumentId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		userContext.getChecker().checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
	}
	public  AccountingDocument copyAccountingDocumentLineFrom(RetailscmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocumentLine(userContext,accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingDocument.copyAccountingDocumentLineFrom( accountingDocumentLine );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			
			userContext.getManagerGroup().getAccountingDocumentLineManager().onNewInstanceCreated(userContext, (AccountingDocumentLine)accountingDocument.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingDocument(accountingDocumentId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		userContext.getChecker().checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		

		if(AccountingDocumentLine.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocumentLine(parseString(newValueExpr));
		}
		
		if(AccountingDocumentLine.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfAccountingDocumentLine(parseString(newValueExpr));
		}
		
		if(AccountingDocumentLine.DIRECT_PROPERTY.equals(property)){
			userContext.getChecker().checkDirectOfAccountingDocumentLine(parseString(newValueExpr));
		}
		
		if(AccountingDocumentLine.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfAccountingDocumentLine(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingDocumentManagerException.class);
	
	}
	
	public  AccountingDocument updateAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentLineList().searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, "eq", accountingDocumentLineId).done();
		
		
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, loadTokens);
		
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocument.removeAccountingDocumentLine( accountingDocumentLine );	
			//make changes to AcceleraterAccount.
			AccountingDocumentLine accountingDocumentLineIndex = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		
			AccountingDocumentLine accountingDocumentLine = accountingDocument.findTheAccountingDocumentLine(accountingDocumentLineIndex);
			if(accountingDocumentLine == null){
				throw new AccountingDocumentManagerException(accountingDocumentLine+" is NOT FOUND" );
			}
			
			accountingDocumentLine.changeProperty(property, newValueExpr);
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocument newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


