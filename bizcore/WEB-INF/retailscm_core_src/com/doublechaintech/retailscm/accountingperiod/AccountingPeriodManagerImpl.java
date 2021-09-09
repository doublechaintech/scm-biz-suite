
package com.doublechaintech.retailscm.accountingperiod;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;import com.doublechaintech.retailscm.accountset.AccountSet;import com.doublechaintech.retailscm.accountset.CandidateAccountSet;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


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



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingPeriod, tokens);
 	}



 	protected AccountingPeriod present(RetailscmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens) throws Exception {


		addActions(userContext,accountingPeriod,tokens);
    

		AccountingPeriod  accountingPeriodToPresent = accountingPeriodDaoOf(userContext).present(accountingPeriod, tokens);

		List<BaseEntity> entityListToNaming = accountingPeriodToPresent.collectRefercencesFromLists();
		accountingPeriodDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,accountingPeriod,tokens);

		return  accountingPeriodToPresent;


	}



 	public AccountingPeriod loadAccountingPeriodDetail(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, allTokens());
 		return present(userContext,accountingPeriod, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, viewTokens());
 		markVisited(userContext, accountingPeriod);
 		return present(userContext,accountingPeriod, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{
		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, viewTokens());
		accountingPeriod.summarySuffix();
		markVisited(userContext, accountingPeriod);
 		return present(userContext,accountingPeriod, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String accountingPeriodId) throws Exception{
		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, analyzeTokens());
		markVisited(userContext, accountingPeriod);
		return present(userContext,accountingPeriod, analyzeTokens());

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








  @Override
  public List<AccountingPeriod> searchAccountingPeriodList(RetailscmUserContext ctx, AccountingPeriodRequest pRequest){
      pRequest.setUserContext(ctx);
      List<AccountingPeriod> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public AccountingPeriod searchAccountingPeriod(RetailscmUserContext ctx, AccountingPeriodRequest pRequest){
    pRequest.limit(0, 1);
    List<AccountingPeriod> list = searchAccountingPeriodList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public AccountingPeriod createAccountingPeriod(RetailscmUserContext userContext, String name,Date startDate,Date endDate,String accountSetId) throws Exception
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

      //checkerOf(userContext).checkAndFixAccountingPeriod(accountingPeriod);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith(AccountingDocument.ID_PROPERTY,sortDesc())
		.done();

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
			
			accountingDocumentManagerOf(userContext).onNewInstanceCreated(userContext, accountingDocument);
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
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, tokens().is(), id).done();

		AccountingPeriod accountingPeriodToUpdate = loadAccountingPeriod(userContext, accountingPeriodId, options);

		if(accountingPeriodToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingPeriodManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocument item = accountingPeriodToUpdate.getAccountingDocumentList().first();
		beforeUpdateAccountingDocumentProperties(userContext,item, accountingPeriodId,id,name,accountingDocumentDate,tokensExpr);
		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );


		//checkParamsForAddingAccountingDocument(userContext,accountingPeriodId,name, code, used,tokensExpr);
		AccountingPeriod accountingPeriod = saveAccountingPeriod(userContext, accountingPeriodToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingPeriod){
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateAccountingDocumentProperties(RetailscmUserContext userContext, AccountingDocument item, String accountingPeriodId, String id,String name,Date accountingDocumentDate, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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
			
			accountingDocumentManagerOf(userContext).onNewInstanceCreated(userContext, (AccountingDocument)accountingPeriod.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
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

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, tokens().equals(), accountingDocumentId).done();



		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, loadTokens);

		synchronized(accountingPeriod){
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingPeriod.removeAccountingDocument( accountingDocument );
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIdVersionKey = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

			AccountingDocument accountingDocument = accountingPeriod.findTheAccountingDocument(accountingDocumentIdVersionKey);
			if(accountingDocument == null){
				throw new AccountingPeriodManagerException(accountingDocumentId+" is NOT FOUND" );
			}

			beforeUpdateAccountingDocument(userContext, accountingDocument, accountingPeriodId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			accountingDocumentManagerOf(userContext).onUpdated(userContext, accountingDocument, this, "updateAccountingDocument");
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateAccountingDocument(RetailscmUserContext userContext, AccountingDocument existed, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingPeriod newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    accountingPeriodDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
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
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, AccountingPeriod.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
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
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
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
				    .put("label", "ID")
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




