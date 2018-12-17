
package com.doublechaintech.retailscm.accountingsubject;

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
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountset.CandidateAccountSet;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;






public class AccountingSubjectManagerImpl extends CustomRetailscmCheckerManager implements AccountingSubjectManager {
	
	private static final String SERVICE_TYPE = "AccountingSubject";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AccountingSubjectManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AccountingSubjectManagerException(message);

	}
	
	

 	protected AccountingSubject saveAccountingSubject(RetailscmUserContext userContext, AccountingSubject accountingSubject, String [] tokensExpr) throws Exception{	
 		//return getAccountingSubjectDAO().save(accountingSubject, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingSubject(userContext, accountingSubject, tokens);
 	}
 	
 	protected AccountingSubject saveAccountingSubjectDetail(RetailscmUserContext userContext, AccountingSubject accountingSubject) throws Exception{	

 		
 		return saveAccountingSubject(userContext, accountingSubject, allTokens());
 	}
 	
 	public AccountingSubject loadAccountingSubject(RetailscmUserContext userContext, String accountingSubjectId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingSubjectManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingSubject, tokens);
 	}
 	
 	
 	 public AccountingSubject searchAccountingSubject(RetailscmUserContext userContext, String accountingSubjectId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingSubjectManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingSubject, tokens);
 	}
 	
 	

 	protected AccountingSubject present(RetailscmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingSubject,tokens);
		
		
		AccountingSubject  accountingSubjectToPresent = userContext.getDAOGroup().getAccountingSubjectDAO().present(accountingSubject, tokens);
		
		List<BaseEntity> entityListToNaming = accountingSubjectToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountingSubjectDAO().alias(entityListToNaming);
		
		return  accountingSubjectToPresent;
		
		
	}
 
 	
 	
 	public AccountingSubject loadAccountingSubjectDetail(RetailscmUserContext userContext, String accountingSubjectId) throws Exception{	
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, allTokens());
 		return present(userContext,accountingSubject, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingSubjectId) throws Exception{	
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, viewTokens());
 		return present(userContext,accountingSubject, allTokens());
		
 	}
 	protected AccountingSubject saveAccountingSubject(RetailscmUserContext userContext, AccountingSubject accountingSubject, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAccountingSubjectDAO().save(accountingSubject, tokens);
 	}
 	protected AccountingSubject loadAccountingSubject(RetailscmUserContext userContext, String accountingSubjectId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountingSubjectManagerException.class);

 
 		return userContext.getDAOGroup().getAccountingSubjectDAO().load(accountingSubjectId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens){
		super.addActions(userContext, accountingSubject, tokens);
		
		addAction(userContext, accountingSubject, tokens,"@create","createAccountingSubject","createAccountingSubject/","main","primary");
		addAction(userContext, accountingSubject, tokens,"@update","updateAccountingSubject","updateAccountingSubject/"+accountingSubject.getId()+"/","main","primary");
		addAction(userContext, accountingSubject, tokens,"@copy","cloneAccountingSubject","cloneAccountingSubject/"+accountingSubject.getId()+"/","main","primary");
		
		addAction(userContext, accountingSubject, tokens,"accounting_subject.transfer_to_account_set","transferToAnotherAccountSet","transferToAnotherAccountSet/"+accountingSubject.getId()+"/","main","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.addAccountingDocumentLine","addAccountingDocumentLine","addAccountingDocumentLine/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.removeAccountingDocumentLine","removeAccountingDocumentLine","removeAccountingDocumentLine/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.updateAccountingDocumentLine","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingSubject createAccountingSubject(RetailscmUserContext userContext,String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String accountSetId) throws Exception
	{
		
		

		

		userContext.getChecker().checkAccountingSubjectCodeOfAccountingSubject(accountingSubjectCode);
		userContext.getChecker().checkAccountingSubjectNameOfAccountingSubject(accountingSubjectName);
		userContext.getChecker().checkAccountingSubjectClassCodeOfAccountingSubject(accountingSubjectClassCode);
		userContext.getChecker().checkAccountingSubjectClassNameOfAccountingSubject(accountingSubjectClassName);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);


		AccountingSubject accountingSubject=createNewAccountingSubject();	

		accountingSubject.setAccountingSubjectCode(accountingSubjectCode);
		accountingSubject.setAccountingSubjectName(accountingSubjectName);
		accountingSubject.setAccountingSubjectClassCode(accountingSubjectClassCode);
		accountingSubject.setAccountingSubjectClassName(accountingSubjectClassName);
			
		AccountSet accountSet = loadAccountSet(userContext, accountSetId,emptyOptions());
		accountingSubject.setAccountSet(accountSet);
		
		

		accountingSubject = saveAccountingSubject(userContext, accountingSubject, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingSubject);
		return accountingSubject;

		
	}
	protected AccountingSubject createNewAccountingSubject() 
	{
		
		return new AccountingSubject();		
	}
	
	protected void checkParamsForUpdatingAccountingSubject(RetailscmUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().checkVersionOfAccountingSubject( accountingSubjectVersion);
		

		if(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingSubjectCodeOfAccountingSubject(parseString(newValueExpr));
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingSubjectNameOfAccountingSubject(parseString(newValueExpr));
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingSubjectClassCodeOfAccountingSubject(parseInt(newValueExpr));
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingSubjectClassNameOfAccountingSubject(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
	
		
	}
	
	
	
	public AccountingSubject clone(RetailscmUserContext userContext, String fromAccountingSubjectId) throws Exception{
		
		return userContext.getDAOGroup().getAccountingSubjectDAO().clone(fromAccountingSubjectId, this.allTokens());
	}
	
	public AccountingSubject internalSaveAccountingSubject(RetailscmUserContext userContext, AccountingSubject accountingSubject) throws Exception 
	{
		return internalSaveAccountingSubject(userContext, accountingSubject, allTokens());

	}
	public AccountingSubject internalSaveAccountingSubject(RetailscmUserContext userContext, AccountingSubject accountingSubject, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAccountingSubject(userContext, accountingSubjectId, accountingSubjectVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(accountingSubject){ 
			//will be good when the accountingSubject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingSubject.
			
			
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, options);
			return accountingSubject;
			
		}

	}
	
	public AccountingSubject updateAccountingSubject(RetailscmUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingSubject(userContext, accountingSubjectId, accountingSubjectVersion, property, newValueExpr, tokensExpr);
		
		
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		if(accountingSubject.getVersion() != accountingSubjectVersion){
			String message = "The target version("+accountingSubject.getVersion()+") is not equals to version("+accountingSubjectVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingSubject){ 
			//will be good when the accountingSubject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingSubject.
			
			accountingSubject.changeProperty(property, newValueExpr);
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
			//return saveAccountingSubject(userContext, accountingSubject, tokens().done());
		}

	}
	
	public AccountingSubject updateAccountingSubjectProperty(RetailscmUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingSubject(userContext, accountingSubjectId, accountingSubjectVersion, property, newValueExpr, tokensExpr);
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		if(accountingSubject.getVersion() != accountingSubjectVersion){
			String message = "The target version("+accountingSubject.getVersion()+") is not equals to version("+accountingSubjectVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingSubject){ 
			//will be good when the accountingSubject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingSubject.
			
			accountingSubject.changeProperty(property, newValueExpr);
			
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
			//return saveAccountingSubject(userContext, accountingSubject, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingSubjectTokens tokens(){
		return AccountingSubjectTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingSubjectTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentLineListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingSubjectTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountSet(RetailscmUserContext userContext, String accountingSubjectId, String anotherAccountSetId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
 		userContext.getChecker().checkIdOfAccountSet(anotherAccountSetId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
 		
 	}
 	public AccountingSubject transferToAnotherAccountSet(RetailscmUserContext userContext, String accountingSubjectId, String anotherAccountSetId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountSet(userContext, accountingSubjectId,anotherAccountSetId);
 
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());	
		synchronized(accountingSubject){
			//will be good when the accountingSubject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountSet accountSet = loadAccountSet(userContext, anotherAccountSetId, emptyOptions());		
			accountingSubject.updateAccountSet(accountSet);		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, emptyOptions());
			
			return present(userContext,accountingSubject, allTokens());
			
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
		SmartList<AccountSet> candidateList = userContext.getDAOGroup().getAccountSetDAO().requestCandidateAccountSetForAccountingSubject(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected AccountSet loadAccountSet(RetailscmUserContext userContext, String newAccountSetId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountSetDAO().load(newAccountSetId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingSubjectId, int accountingSubjectVersion) throws Exception {
		//deleteInternal(userContext, accountingSubjectId, accountingSubjectVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingSubjectId, int accountingSubjectVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountingSubjectDAO().delete(accountingSubjectId, accountingSubjectVersion);
	}
	
	public AccountingSubject forgetByAll(RetailscmUserContext userContext, String accountingSubjectId, int accountingSubjectVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingSubjectId, accountingSubjectVersion);		
	}
	protected AccountingSubject forgetByAllInternal(RetailscmUserContext userContext,
			String accountingSubjectId, int accountingSubjectVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountingSubjectDAO().disconnectFromAll(accountingSubjectId, accountingSubjectVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingSubjectManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAccountingSubjectDAO().deleteAll();
	}


	//disconnect AccountingSubject with belongs_to in AccountingDocumentLine
	protected AccountingSubject breakWithAccountingDocumentLineByBelongsTo(RetailscmUserContext userContext, String accountingSubjectId, String belongsToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());

			synchronized(accountingSubject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getAccountingSubjectDAO().planToRemoveAccountingDocumentLineListWithBelongsTo(accountingSubject, belongsToId, this.emptyOptions());

				accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
				return accountingSubject;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String name, String code, String direct, BigDecimal amount, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);

		
		userContext.getChecker().checkNameOfAccountingDocumentLine(name);
		
		userContext.getChecker().checkCodeOfAccountingDocumentLine(code);
		
		userContext.getChecker().checkDirectOfAccountingDocumentLine(direct);
		
		userContext.getChecker().checkAmountOfAccountingDocumentLine(amount);
		
		userContext.getChecker().checkBelongsToIdOfAccountingDocumentLine(belongsToId);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

	
	}
	public  AccountingSubject addAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String name, String code, String direct, BigDecimal amount, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocumentLine(userContext,accountingSubjectId,name, code, direct, amount, belongsToId,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, belongsToId);
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingSubject.addAccountingDocumentLine( accountingDocumentLine );		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			
			userContext.getManagerGroup().getAccountingDocumentLineManager().onNewInstanceCreated(userContext, accountingDocumentLine);
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentLineProperties(RetailscmUserContext userContext, String accountingSubjectId,String id,String name,String code,String direct,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(id);
		
		userContext.getChecker().checkNameOfAccountingDocumentLine( name);
		userContext.getChecker().checkCodeOfAccountingDocumentLine( code);
		userContext.getChecker().checkDirectOfAccountingDocumentLine( direct);
		userContext.getChecker().checkAmountOfAccountingDocumentLine( amount);

		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
		
	}
	public  AccountingSubject updateAccountingDocumentLineProperties(RetailscmUserContext userContext, String accountingSubjectId, String id,String name,String code,String direct,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountingDocumentLineProperties(userContext,accountingSubjectId,id,name,code,direct,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentLineListList()
				.searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, "is", id).done();
		
		AccountingSubject accountingSubjectToUpdate = loadAccountingSubject(userContext, accountingSubjectId, options);
		
		if(accountingSubjectToUpdate.getAccountingDocumentLineList().isEmpty()){
			throw new AccountingSubjectManagerException("AccountingDocumentLine is NOT FOUND with id: '"+id+"'");
		}
		
		AccountingDocumentLine item = accountingSubjectToUpdate.getAccountingDocumentLineList().first();
		
		item.updateName( name );
		item.updateCode( code );
		item.updateDirect( direct );
		item.updateAmount( amount );

		
		//checkParamsForAddingAccountingDocumentLine(userContext,accountingSubjectId,name, code, used,tokensExpr);
		AccountingSubject accountingSubject = saveAccountingSubject(userContext, accountingSubjectToUpdate, tokens().withAccountingDocumentLineList().done());
		synchronized(accountingSubject){ 
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AccountingDocumentLine createAccountingDocumentLine(RetailscmUserContext userContext, String name, String code, String direct, BigDecimal amount, String belongsToId) throws Exception{

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		
		
		accountingDocumentLine.setName(name);		
		accountingDocumentLine.setCode(code);		
		accountingDocumentLine.setDirect(direct);		
		accountingDocumentLine.setAmount(amount);		
		AccountingDocument  belongsTo = new AccountingDocument();
		belongsTo.setId(belongsToId);		
		accountingDocumentLine.setBelongsTo(belongsTo);
	
		
		return accountingDocumentLine;
	
		
	}
	
	protected AccountingDocumentLine createIndexedAccountingDocumentLine(String id, int version){

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLine.setId(id);
		accountingDocumentLine.setVersion(version);
		return accountingDocumentLine;			
		
	}
	
	protected void checkParamsForRemovingAccountingDocumentLineList(RetailscmUserContext userContext, String accountingSubjectId, 
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		for(String accountingDocumentLineId: accountingDocumentLineIds){
			userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
		
	}
	public  AccountingSubject removeAccountingDocumentLineList(RetailscmUserContext userContext, String accountingSubjectId, 
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentLineList(userContext, accountingSubjectId,  accountingDocumentLineIds, tokensExpr);
			
			
			AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
			synchronized(accountingSubject){ 
				//Will be good when the accountingSubject loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountingSubjectDAO().planToRemoveAccountingDocumentLineList(accountingSubject, accountingDocumentLineIds, allTokens());
				accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
				deleteRelationListInGraph(userContext, accountingSubject.getAccountingDocumentLineList());
				return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingSubject( accountingSubjectId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		userContext.getChecker().checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
	
	}
	public  AccountingSubject removeAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocumentLine(userContext,accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingSubject.removeAccountingDocumentLine( accountingDocumentLine );		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			deleteRelationInGraph(userContext, accountingDocumentLine);
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountingSubject( accountingSubjectId);
		userContext.getChecker().checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		userContext.getChecker().checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
	
	}
	public  AccountingSubject copyAccountingDocumentLineFrom(RetailscmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocumentLine(userContext,accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			accountingSubject.copyAccountingDocumentLineFrom( accountingDocumentLine );		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			
			userContext.getManagerGroup().getAccountingDocumentLineManager().onNewInstanceCreated(userContext, (AccountingDocumentLine)accountingSubject.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountingSubjectManagerException.class);
	
	}
	
	public  AccountingSubject updateAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentLineList().searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, "eq", accountingDocumentLineId).done();
		
		
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, loadTokens);
		
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingSubject.removeAccountingDocumentLine( accountingDocumentLine );	
			//make changes to AcceleraterAccount.
			AccountingDocumentLine accountingDocumentLineIndex = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		
			AccountingDocumentLine accountingDocumentLine = accountingSubject.findTheAccountingDocumentLine(accountingDocumentLineIndex);
			if(accountingDocumentLine == null){
				throw new AccountingSubjectManagerException(accountingDocumentLine+" is NOT FOUND" );
			}
			
			accountingDocumentLine.changeProperty(property, newValueExpr);
			
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingSubject newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


