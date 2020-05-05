
package com.doublechaintech.retailscm.accountingdocument;

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


import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.accountingdocumenttype.CandidateAccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.CandidateAccountingPeriod;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;






public class AccountingDocumentManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentTokens.start().withTokenFromListName(listName).done();
		AccountingDocument  accountingDocument = (AccountingDocument) this.loadAccountingDocument(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocument.collectRefercencesFromLists();
		accountingDocumentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocument, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocument";
	@Override
	public AccountingDocumentDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	
 	 public AccountingDocument searchAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	

 	protected AccountingDocument present(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocument,tokens);
		
		
		AccountingDocument  accountingDocumentToPresent = accountingDocumentDaoOf(userContext).present(accountingDocument, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentToPresent.collectRefercencesFromLists();
		accountingDocumentDaoOf(userContext).alias(entityListToNaming);
		
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
 		return accountingDocumentDaoOf(userContext).save(accountingDocument, tokens);
 	}
 	protected AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 
 		return accountingDocumentDaoOf(userContext).load(accountingDocumentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocument, tokens);
		
		addAction(userContext, accountingDocument, tokens,"@create","createAccountingDocument","createAccountingDocument/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@update","updateAccountingDocument","updateAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@copy","cloneAccountingDocument","cloneAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_accounting_period","transferToAnotherAccountingPeriod","transferToAnotherAccountingPeriod/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_document_type","transferToAnotherDocumentType","transferToAnotherDocumentType/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addAccountingDocumentLine","addAccountingDocumentLine","addAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeAccountingDocumentLine","removeAccountingDocumentLine","removeAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateAccountingDocumentLine","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name,Date accountingDocumentDate,String accountingPeriodId,String documentTypeId) throws Exception
	//public AccountingDocument createAccountingDocument(RetailscmUserContext userContext,String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfAccountingDocument(name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


		AccountingDocument accountingDocument=createNewAccountingDocument();	

		accountingDocument.setName(name);
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
			
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId,emptyOptions());
		accountingDocument.setAccountingPeriod(accountingPeriod);
		
		
			
		AccountingDocumentType documentType = loadAccountingDocumentType(userContext, documentTypeId,emptyOptions());
		accountingDocument.setDocumentType(documentType);
		
		

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
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument( accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
			
		}
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


	}



	public AccountingDocument clone(RetailscmUserContext userContext, String fromAccountingDocumentId) throws Exception{

		return accountingDocumentDaoOf(userContext).clone(fromAccountingDocumentId, this.allTokens());
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
			if (accountingDocument.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingPeriod(anotherAccountingPeriodId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		SmartList<AccountingPeriod> candidateList = accountingPeriodDaoOf(userContext).requestCandidateAccountingPeriodForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDocumentType(RetailscmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingDocumentType(anotherDocumentTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		SmartList<AccountingDocumentType> candidateList = accountingDocumentTypeDaoOf(userContext).requestCandidateAccountingDocumentTypeForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected AccountingPeriod loadAccountingPeriod(RetailscmUserContext userContext, String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{

 		return accountingPeriodDaoOf(userContext).load(newAccountingPeriodId, options);
 	}
 	


	

 	protected AccountingDocumentType loadAccountingDocumentType(RetailscmUserContext userContext, String newDocumentTypeId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentTypeDaoOf(userContext).load(newDocumentTypeId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentId, accountingDocumentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{

		accountingDocumentDaoOf(userContext).delete(accountingDocumentId, accountingDocumentVersion);
	}

	public AccountingDocument forgetByAll(RetailscmUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentId, accountingDocumentVersion);
	}
	protected AccountingDocument forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{

		return accountingDocumentDaoOf(userContext).disconnectFromAll(accountingDocumentId, accountingDocumentVersion);
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
		return accountingDocumentDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocument with accounting_subject in AccountingDocumentLine
	protected AccountingDocument breakWithAccountingDocumentLineByAccountingSubject(RetailscmUserContext userContext, String accountingDocumentId, String accountingSubjectId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());

			synchronized(accountingDocument){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentDaoOf(userContext).planToRemoveAccountingDocumentLineListWithAccountingSubject(accountingDocument, accountingSubjectId, this.emptyOptions());

				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
				return accountingDocument;
			}
	}






	protected void checkParamsForAddingOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);

		
		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


	}
	public  AccountingDocument addOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingOriginalVoucher(userContext,accountingDocumentId,title, madeBy, receivedBy, voucherType, voucherImage,tokensExpr);

		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage);

		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, emptyOptions());
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

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(id);

		checkerOf(userContext).checkTitleOfOriginalVoucher( title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher( madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher( receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher( voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher( voucherImage);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		for(String originalVoucherIdItem: originalVoucherIds){
			checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument removeOriginalVoucherList(RetailscmUserContext userContext, String accountingDocumentId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingOriginalVoucherList(userContext, accountingDocumentId,  originalVoucherIds, tokensExpr);


			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
			synchronized(accountingDocument){
				//Will be good when the accountingDocument loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentDaoOf(userContext).planToRemoveOriginalVoucherList(accountingDocument, originalVoucherIds, allTokens());
				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, accountingDocument.getOriginalVoucherList());
				return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMadeByOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkReceivedByOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVoucherImageOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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

	*/




	protected void checkParamsForAddingAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);

		
		checkerOf(userContext).checkNameOfAccountingDocumentLine(name);
		
		checkerOf(userContext).checkCodeOfAccountingDocumentLine(code);
		
		checkerOf(userContext).checkDirectOfAccountingDocumentLine(direct);
		
		checkerOf(userContext).checkAmountOfAccountingDocumentLine(amount);
		
		checkerOf(userContext).checkAccountingSubjectIdOfAccountingDocumentLine(accountingSubjectId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


	}
	public  AccountingDocument addAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocumentLine(userContext,accountingDocumentId,name, code, direct, amount, accountingSubjectId,tokensExpr);

		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, accountingSubjectId);

		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, emptyOptions());
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

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(id);

		checkerOf(userContext).checkNameOfAccountingDocumentLine( name);
		checkerOf(userContext).checkCodeOfAccountingDocumentLine( code);
		checkerOf(userContext).checkDirectOfAccountingDocumentLine( direct);
		checkerOf(userContext).checkAmountOfAccountingDocumentLine( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		for(String accountingDocumentLineIdItem: accountingDocumentLineIds){
			checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument removeAccountingDocumentLineList(RetailscmUserContext userContext, String accountingDocumentId,
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentLineList(userContext, accountingDocumentId,  accountingDocumentLineIds, tokensExpr);


			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
			synchronized(accountingDocument){
				//Will be good when the accountingDocument loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentDaoOf(userContext).planToRemoveAccountingDocumentLineList(accountingDocument, accountingDocumentLineIds, allTokens());
				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
				deleteRelationListInGraph(userContext, accountingDocument.getAccountingDocumentLineList());
				return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId,
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		

		if(AccountingDocumentLine.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocumentLine(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentLine.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfAccountingDocumentLine(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentLine.DIRECT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDirectOfAccountingDocumentLine(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentLine.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfAccountingDocumentLine(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

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
		//   AccountingDocument newAccountingDocument = this.createAccountingDocument(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocument
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocument.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocument> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountingPeriod> accountingPeriodList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingPeriod.class);
		userContext.getDAOGroup().enhanceList(accountingPeriodList, AccountingPeriod.class);
		List<AccountingDocumentType> documentTypeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocumentType.class);
		userContext.getDAOGroup().enhanceList(documentTypeList, AccountingDocumentType.class);


    }
	
	public Object listByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId) throws Exception {
		return listPageByAccountingPeriod(userContext, accountingPeriodId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int start, int count) throws Exception {
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByAccountingPeriod(accountingPeriodId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingPeriod.withId(accountingPeriodId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
		page.setRequestName("listByAccountingPeriod");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAccountingPeriod/%s/",  getBeanName(), accountingPeriodId)));

		page.assemblerContent(userContext, "listByAccountingPeriod");
		return page.doRender(userContext);
	}
  
	public Object listByDocumentType(RetailscmUserContext userContext,String documentTypeId) throws Exception {
		return listPageByDocumentType(userContext, documentTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDocumentType(RetailscmUserContext userContext,String documentTypeId, int start, int count) throws Exception {
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByDocumentType(documentTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingDocumentType.withId(documentTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
		page.setRequestName("listByDocumentType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDocumentType/%s/",  getBeanName(), documentTypeId)));

		page.assemblerContent(userContext, "listByDocumentType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentDetailScope().clone();
		AccountingDocument merchantObj = (AccountingDocument) this.view(userContext, accountingDocumentId);
    String merchantObjId = accountingDocumentId;
    String linkToUrl =	"accountingDocumentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证"+"详情";
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
				MapUtil.put("id", "3-accountingDocumentDate")
				    .put("fieldName", "accountingDocumentDate")
				    .put("label", "会计凭证日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingDocumentDate", merchantObj.getAccountingDocumentDate());

		propList.add(
				MapUtil.put("id", "4-accountingPeriod")
				    .put("fieldName", "accountingPeriod")
				    .put("label", "会计期间")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingPeriodManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"start_date\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("accountingPeriod", merchantObj.getAccountingPeriod());

		propList.add(
				MapUtil.put("id", "5-documentType")
				    .put("fieldName", "documentType")
				    .put("label", "文档类型")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("documentType", merchantObj.getDocumentType());

		//处理 sectionList

		//处理Section：originalVoucherListSection
		Map originalVoucherListSection = ListofUtils.buildSection(
		    "originalVoucherListSection",
		    "原始凭证列表",
		    null,
		    "",
		    "__no_group",
		    "originalVoucherManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(originalVoucherListSection);

		result.put("originalVoucherListSection", ListofUtils.toShortList(merchantObj.getOriginalVoucherList(), "originalVoucher"));
		vscope.field("originalVoucherListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( OriginalVoucher.class.getName(), null));

		//处理Section：accountingDocumentLineListSection
		Map accountingDocumentLineListSection = ListofUtils.buildSection(
		    "accountingDocumentLineListSection",
		    "会计文件行表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentLineManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingDocumentLineListSection);

		result.put("accountingDocumentLineListSection", ListofUtils.toShortList(merchantObj.getAccountingDocumentLineList(), "accountingDocumentLine"));
		vscope.field("accountingDocumentLineListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountingDocumentLine.class.getName(), null));

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


