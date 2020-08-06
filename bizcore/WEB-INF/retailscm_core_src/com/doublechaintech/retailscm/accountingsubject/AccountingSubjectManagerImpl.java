
package com.doublechaintech.retailscm.accountingsubject;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
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
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountset.CandidateAccountSet;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;






public class AccountingSubjectManagerImpl extends CustomRetailscmCheckerManager implements AccountingSubjectManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = AccountingSubjectTokens.start().withTokenFromListName(listName).done();
		AccountingSubject  accountingSubject = (AccountingSubject) this.loadAccountingSubject(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingSubject.collectRefercencesFromLists();
		accountingSubjectDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, accountingSubject, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingSubjectGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "AccountingSubject";
	@Override
	public AccountingSubjectDAO daoOf(RetailscmUserContext userContext) {
		return accountingSubjectDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingSubjectManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingSubject, tokens);
 	}
 	
 	
 	 public AccountingSubject searchAccountingSubject(RetailscmUserContext userContext, String accountingSubjectId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingSubjectManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingSubject, tokens);
 	}
 	
 	

 	protected AccountingSubject present(RetailscmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingSubject,tokens);
		
		
		AccountingSubject  accountingSubjectToPresent = accountingSubjectDaoOf(userContext).present(accountingSubject, tokens);
		
		List<BaseEntity> entityListToNaming = accountingSubjectToPresent.collectRefercencesFromLists();
		accountingSubjectDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,accountingSubject,tokens);
		
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
 		return accountingSubjectDaoOf(userContext).save(accountingSubject, tokens);
 	}
 	protected AccountingSubject loadAccountingSubject(RetailscmUserContext userContext, String accountingSubjectId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingSubjectManagerException.class);

 
 		return accountingSubjectDaoOf(userContext).load(accountingSubjectId, tokens);
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
	
 	
 	
 
 	
 	

	public AccountingSubject createAccountingSubject(RetailscmUserContext userContext, String accountingSubjectCode,String accountingSubjectName,int accountingSubjectClassCode,String accountingSubjectClassName,String accountSetId) throws Exception
	//public AccountingSubject createAccountingSubject(RetailscmUserContext userContext,String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String accountSetId) throws Exception
	{

		

		

		checkerOf(userContext).checkAccountingSubjectCodeOfAccountingSubject(accountingSubjectCode);
		checkerOf(userContext).checkAccountingSubjectNameOfAccountingSubject(accountingSubjectName);
		checkerOf(userContext).checkAccountingSubjectClassCodeOfAccountingSubject(accountingSubjectClassCode);
		checkerOf(userContext).checkAccountingSubjectClassNameOfAccountingSubject(accountingSubjectClassName);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).checkVersionOfAccountingSubject( accountingSubjectVersion);
		

		if(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingSubjectCodeOfAccountingSubject(parseString(newValueExpr));
		
			
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingSubjectNameOfAccountingSubject(parseString(newValueExpr));
		
			
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingSubjectClassCodeOfAccountingSubject(parseInt(newValueExpr));
		
			
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingSubjectClassNameOfAccountingSubject(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);


	}



	public AccountingSubject clone(RetailscmUserContext userContext, String fromAccountingSubjectId) throws Exception{

		return accountingSubjectDaoOf(userContext).clone(fromAccountingSubjectId, this.allTokens());
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
			if (accountingSubject.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingSubjectTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountSet(RetailscmUserContext userContext, String accountingSubjectId, String anotherAccountSetId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
 		checkerOf(userContext).checkIdOfAccountSet(anotherAccountSetId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

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
		SmartList<AccountSet> candidateList = accountSetDaoOf(userContext).requestCandidateAccountSetForAccountingSubject(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String accountingSubjectId, int accountingSubjectVersion) throws Exception {
		//deleteInternal(userContext, accountingSubjectId, accountingSubjectVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingSubjectId, int accountingSubjectVersion) throws Exception{

		accountingSubjectDaoOf(userContext).delete(accountingSubjectId, accountingSubjectVersion);
	}

	public AccountingSubject forgetByAll(RetailscmUserContext userContext, String accountingSubjectId, int accountingSubjectVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingSubjectId, accountingSubjectVersion);
	}
	protected AccountingSubject forgetByAllInternal(RetailscmUserContext userContext,
			String accountingSubjectId, int accountingSubjectVersion) throws Exception{

		return accountingSubjectDaoOf(userContext).disconnectFromAll(accountingSubjectId, accountingSubjectVersion);
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
		return accountingSubjectDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingSubject with belongs_to in AccountingDocumentLine
	protected AccountingSubject breakWithAccountingDocumentLineByBelongsTo(RetailscmUserContext userContext, String accountingSubjectId, String belongsToId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());

			synchronized(accountingSubject){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingSubjectDaoOf(userContext).planToRemoveAccountingDocumentLineListWithBelongsTo(accountingSubject, belongsToId, this.emptyOptions());

				accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
				return accountingSubject;
			}
	}






	protected void checkParamsForAddingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String name, String code, String direct, BigDecimal amount, String belongsToId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);

		
		checkerOf(userContext).checkNameOfAccountingDocumentLine(name);
		
		checkerOf(userContext).checkCodeOfAccountingDocumentLine(code);
		
		checkerOf(userContext).checkDirectOfAccountingDocumentLine(direct);
		
		checkerOf(userContext).checkAmountOfAccountingDocumentLine(amount);
		
		checkerOf(userContext).checkBelongsToIdOfAccountingDocumentLine(belongsToId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);


	}
	public  AccountingSubject addAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String name, String code, String direct, BigDecimal amount, String belongsToId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocumentLine(userContext,accountingSubjectId,name, code, direct, amount, belongsToId,tokensExpr);

		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, belongsToId);

		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, emptyOptions());
		synchronized(accountingSubject){
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingSubject.addAccountingDocumentLine( accountingDocumentLine );
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			
			accountingDocumentLineManagerOf(userContext).onNewInstanceCreated(userContext, accountingDocumentLine);
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentLineProperties(RetailscmUserContext userContext, String accountingSubjectId,String id,String name,String code,String direct,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(id);

		checkerOf(userContext).checkNameOfAccountingDocumentLine( name);
		checkerOf(userContext).checkCodeOfAccountingDocumentLine( code);
		checkerOf(userContext).checkDirectOfAccountingDocumentLine( direct);
		checkerOf(userContext).checkAmountOfAccountingDocumentLine( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

	}
	public  AccountingSubject updateAccountingDocumentLineProperties(RetailscmUserContext userContext, String accountingSubjectId, String id,String name,String code,String direct,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentLineProperties(userContext,accountingSubjectId,id,name,code,direct,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentLineListList()
				.searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, tokens().is(), id).done();

		AccountingSubject accountingSubjectToUpdate = loadAccountingSubject(userContext, accountingSubjectId, options);

		if(accountingSubjectToUpdate.getAccountingDocumentLineList().isEmpty()){
			throw new AccountingSubjectManagerException("AccountingDocumentLine is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocumentLine item = accountingSubjectToUpdate.getAccountingDocumentLineList().first();
		beforeUpdateAccountingDocumentLineProperties(userContext,item, accountingSubjectId,id,name,code,direct,amount,tokensExpr);
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

	protected  void beforeUpdateAccountingDocumentLineProperties(RetailscmUserContext userContext, AccountingDocumentLine item, String accountingSubjectId, String id,String name,String code,String direct,BigDecimal amount, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		for(String accountingDocumentLineIdItem: accountingDocumentLineIds){
			checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

	}
	public  AccountingSubject removeAccountingDocumentLineList(RetailscmUserContext userContext, String accountingSubjectId,
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentLineList(userContext, accountingSubjectId,  accountingDocumentLineIds, tokensExpr);


			AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
			synchronized(accountingSubject){
				//Will be good when the accountingSubject loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingSubjectDaoOf(userContext).planToRemoveAccountingDocumentLineList(accountingSubject, accountingDocumentLineIds, allTokens());
				accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
				deleteRelationListInGraph(userContext, accountingSubject.getAccountingDocumentLineList());
				return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId,
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingSubject( accountingSubjectId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

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
		
		checkerOf(userContext).checkIdOfAccountingSubject( accountingSubjectId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

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
			
			accountingDocumentLineManagerOf(userContext).onNewInstanceCreated(userContext, (AccountingDocumentLine)accountingSubject.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
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
		

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingSubjectManagerException.class);

	}

	public  AccountingSubject updateAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentLineList().searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, tokens().equals(), accountingDocumentLineId).done();



		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, loadTokens);

		synchronized(accountingSubject){
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingSubject.removeAccountingDocumentLine( accountingDocumentLine );
			//make changes to AcceleraterAccount.
			AccountingDocumentLine accountingDocumentLineIdVersionKey = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);

			AccountingDocumentLine accountingDocumentLine = accountingSubject.findTheAccountingDocumentLine(accountingDocumentLineIdVersionKey);
			if(accountingDocumentLine == null){
				throw new AccountingSubjectManagerException(accountingDocumentLineId+" is NOT FOUND" );
			}

			beforeUpdateAccountingDocumentLine(userContext, accountingDocumentLine, accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);
			accountingDocumentLine.changeProperty(property, newValueExpr);
			
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine existed, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingSubject newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    accountingSubjectDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
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
		//   AccountingSubject newAccountingSubject = this.createAccountingSubject(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingSubject
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingSubject.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingSubject> list) throws Exception {
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
		SmartList<AccountingSubject> list = accountingSubjectDaoOf(userContext).findAccountingSubjectByAccountSet(accountSetId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingSubject.class);
		page.setContainerObject(AccountSet.withId(accountSetId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计科目列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String accountingSubjectId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingSubjectDetailScope().clone();
		AccountingSubject merchantObj = (AccountingSubject) this.view(userContext, accountingSubjectId);
    String merchantObjId = accountingSubjectId;
    String linkToUrl =	"accountingSubjectManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计科目"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-accountingSubjectCode")
				    .put("fieldName", "accountingSubjectCode")
				    .put("label", "会计科目代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingSubjectCode", merchantObj.getAccountingSubjectCode());

		propList.add(
				MapUtil.put("id", "3-accountingSubjectName")
				    .put("fieldName", "accountingSubjectName")
				    .put("label", "会计科目名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingSubjectName", merchantObj.getAccountingSubjectName());

		propList.add(
				MapUtil.put("id", "4-accountingSubjectClassCode")
				    .put("fieldName", "accountingSubjectClassCode")
				    .put("label", "会计科目类别代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingSubjectClassCode", merchantObj.getAccountingSubjectClassCode());

		propList.add(
				MapUtil.put("id", "5-accountingSubjectClassName")
				    .put("fieldName", "accountingSubjectClassName")
				    .put("label", "会计科目类别名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingSubjectClassName", merchantObj.getAccountingSubjectClassName());

		propList.add(
				MapUtil.put("id", "6-accountSet")
				    .put("fieldName", "accountSet")
				    .put("label", "账套")
				    .put("type", "auto")
				    .put("linkToUrl", "accountSetManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"year_set\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("accountSet", merchantObj.getAccountSet());

		//处理 sectionList

		//处理Section：accountingDocumentLineListSection
		Map accountingDocumentLineListSection = ListofUtils.buildSection(
		    "accountingDocumentLineListSection",
		    "会计文件行表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentLineManager/listByAccountingSubject/"+merchantObjId+"/",
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


