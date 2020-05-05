
package com.doublechaintech.retailscm.accountset;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.CandidateGoodsSupplier;
import com.doublechaintech.retailscm.retailstore.CandidateRetailStore;

import com.doublechaintech.retailscm.accountset.AccountSet;






public class AccountSetManagerImpl extends CustomRetailscmCheckerManager implements AccountSetManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountSetTokens.start().withTokenFromListName(listName).done();
		AccountSet  accountSet = (AccountSet) this.loadAccountSet(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountSet.collectRefercencesFromLists();
		accountSetDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountSet, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountSetGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountSet";
	@Override
	public AccountSetDAO daoOf(RetailscmUserContext userContext) {
		return accountSetDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountSetManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountSetManagerException(message);

	}



 	protected AccountSet saveAccountSet(RetailscmUserContext userContext, AccountSet accountSet, String [] tokensExpr) throws Exception{	
 		//return getAccountSetDAO().save(accountSet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountSet(userContext, accountSet, tokens);
 	}
 	
 	protected AccountSet saveAccountSetDetail(RetailscmUserContext userContext, AccountSet accountSet) throws Exception{	

 		
 		return saveAccountSet(userContext, accountSet, allTokens());
 	}
 	
 	public AccountSet loadAccountSet(RetailscmUserContext userContext, String accountSetId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountSetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountSet, tokens);
 	}
 	
 	
 	 public AccountSet searchAccountSet(RetailscmUserContext userContext, String accountSetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountSetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountSet, tokens);
 	}
 	
 	

 	protected AccountSet present(RetailscmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountSet,tokens);
		
		
		AccountSet  accountSetToPresent = accountSetDaoOf(userContext).present(accountSet, tokens);
		
		List<BaseEntity> entityListToNaming = accountSetToPresent.collectRefercencesFromLists();
		accountSetDaoOf(userContext).alias(entityListToNaming);
		
		return  accountSetToPresent;
		
		
	}
 
 	
 	
 	public AccountSet loadAccountSetDetail(RetailscmUserContext userContext, String accountSetId) throws Exception{	
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, allTokens());
 		return present(userContext,accountSet, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountSetId) throws Exception{	
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, viewTokens());
 		return present(userContext,accountSet, allTokens());
		
 	}
 	protected AccountSet saveAccountSet(RetailscmUserContext userContext, AccountSet accountSet, Map<String,Object>tokens) throws Exception{	
 		return accountSetDaoOf(userContext).save(accountSet, tokens);
 	}
 	protected AccountSet loadAccountSet(RetailscmUserContext userContext, String accountSetId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountSetManagerException.class);

 
 		return accountSetDaoOf(userContext).load(accountSetId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens){
		super.addActions(userContext, accountSet, tokens);
		
		addAction(userContext, accountSet, tokens,"@create","createAccountSet","createAccountSet/","main","primary");
		addAction(userContext, accountSet, tokens,"@update","updateAccountSet","updateAccountSet/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"@copy","cloneAccountSet","cloneAccountSet/"+accountSet.getId()+"/","main","primary");
		
		addAction(userContext, accountSet, tokens,"account_set.transfer_to_country_center","transferToAnotherCountryCenter","transferToAnotherCountryCenter/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"account_set.transfer_to_retail_store","transferToAnotherRetailStore","transferToAnotherRetailStore/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"account_set.transfer_to_goods_supplier","transferToAnotherGoodsSupplier","transferToAnotherGoodsSupplier/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"account_set.addAccountingSubject","addAccountingSubject","addAccountingSubject/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.removeAccountingSubject","removeAccountingSubject","removeAccountingSubject/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.updateAccountingSubject","updateAccountingSubject","updateAccountingSubject/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.copyAccountingSubjectFrom","copyAccountingSubjectFrom","copyAccountingSubjectFrom/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.addAccountingPeriod","addAccountingPeriod","addAccountingPeriod/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.removeAccountingPeriod","removeAccountingPeriod","removeAccountingPeriod/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.updateAccountingPeriod","updateAccountingPeriod","updateAccountingPeriod/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.copyAccountingPeriodFrom","copyAccountingPeriodFrom","copyAccountingPeriodFrom/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.addAccountingDocumentType","addAccountingDocumentType","addAccountingDocumentType/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
		addAction(userContext, accountSet, tokens,"account_set.removeAccountingDocumentType","removeAccountingDocumentType","removeAccountingDocumentType/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
		addAction(userContext, accountSet, tokens,"account_set.updateAccountingDocumentType","updateAccountingDocumentType","updateAccountingDocumentType/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
		addAction(userContext, accountSet, tokens,"account_set.copyAccountingDocumentTypeFrom","copyAccountingDocumentTypeFrom","copyAccountingDocumentTypeFrom/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountSet createAccountSet(RetailscmUserContext userContext, String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String countryCenterId,String retailStoreId,String goodsSupplierId) throws Exception
	//public AccountSet createAccountSet(RetailscmUserContext userContext,String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId, String goodsSupplierId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfAccountSet(name);
		checkerOf(userContext).checkYearSetOfAccountSet(yearSet);
		checkerOf(userContext).checkEffectiveDateOfAccountSet(effectiveDate);
		checkerOf(userContext).checkAccountingSystemOfAccountSet(accountingSystem);
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);
		checkerOf(userContext).checkOpeningBankOfAccountSet(openingBank);
		checkerOf(userContext).checkAccountNumberOfAccountSet(accountNumber);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);


		AccountSet accountSet=createNewAccountSet();	

		accountSet.setName(name);
		accountSet.setYearSet(yearSet);
		accountSet.setEffectiveDate(effectiveDate);
		accountSet.setAccountingSystem(accountingSystem);
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);
		accountSet.setDomesticCurrencyName(domesticCurrencyName);
		accountSet.setOpeningBank(openingBank);
		accountSet.setAccountNumber(accountNumber);
			
		RetailStoreCountryCenter countryCenter = loadRetailStoreCountryCenter(userContext, countryCenterId,emptyOptions());
		accountSet.setCountryCenter(countryCenter);
		
		
			
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId,emptyOptions());
		accountSet.setRetailStore(retailStore);
		
		
			
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId,emptyOptions());
		accountSet.setGoodsSupplier(goodsSupplier);
		
		
		accountSet.setLastUpdateTime(userContext.now());

		accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
		
		onNewInstanceCreated(userContext, accountSet);
		return accountSet;


	}
	protected AccountSet createNewAccountSet()
	{

		return new AccountSet();
	}

	protected void checkParamsForUpdatingAccountSet(RetailscmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet( accountSetVersion);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountSet(parseString(newValueExpr));
		
			
		}
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkYearSetOfAccountSet(parseString(newValueExpr));
		
			
		}
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEffectiveDateOfAccountSet(parseDate(newValueExpr));
		
			
		}
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingSystemOfAccountSet(parseString(newValueExpr));
		
			
		}
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(parseString(newValueExpr));
		
			
		}
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(parseString(newValueExpr));
		
			
		}
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOpeningBankOfAccountSet(parseString(newValueExpr));
		
			
		}
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountNumberOfAccountSet(parseString(newValueExpr));
		
			
		}		

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);


	}



	public AccountSet clone(RetailscmUserContext userContext, String fromAccountSetId) throws Exception{

		return accountSetDaoOf(userContext).clone(fromAccountSetId, this.allTokens());
	}

	public AccountSet internalSaveAccountSet(RetailscmUserContext userContext, AccountSet accountSet) throws Exception
	{
		return internalSaveAccountSet(userContext, accountSet, allTokens());

	}
	public AccountSet internalSaveAccountSet(RetailscmUserContext userContext, AccountSet accountSet, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountSet(userContext, accountSetId, accountSetVersion, property, newValueExpr, tokensExpr);


		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountSet.
			if (accountSet.isChanged()){
			accountSet.updateLastUpdateTime(userContext.now());
			}
			accountSet = saveAccountSet(userContext, accountSet, options);
			return accountSet;

		}

	}

	public AccountSet updateAccountSet(RetailscmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountSet(userContext, accountSetId, accountSetVersion, property, newValueExpr, tokensExpr);



		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		if(accountSet.getVersion() != accountSetVersion){
			String message = "The target version("+accountSet.getVersion()+") is not equals to version("+accountSetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountSet.
			accountSet.updateLastUpdateTime(userContext.now());
			accountSet.changeProperty(property, newValueExpr);
			accountSet = saveAccountSet(userContext, accountSet, tokens().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			//return saveAccountSet(userContext, accountSet, tokens().done());
		}

	}

	public AccountSet updateAccountSetProperty(RetailscmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountSet(userContext, accountSetId, accountSetVersion, property, newValueExpr, tokensExpr);

		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		if(accountSet.getVersion() != accountSetVersion){
			String message = "The target version("+accountSet.getVersion()+") is not equals to version("+accountSetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountSet.

			accountSet.changeProperty(property, newValueExpr);
			accountSet.updateLastUpdateTime(userContext.now());
			accountSet = saveAccountSet(userContext, accountSet, tokens().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			//return saveAccountSet(userContext, accountSet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountSetTokens tokens(){
		return AccountSetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountSetTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingSubjectListWith("id","desc")
		.sortAccountingPeriodListWith("id","desc")
		.sortAccountingDocumentTypeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountSetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCountryCenter(RetailscmUserContext userContext, String accountSetId, String anotherCountryCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCountryCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

 	}
 	public AccountSet transferToAnotherCountryCenter(RetailscmUserContext userContext, String accountSetId, String anotherCountryCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCountryCenter(userContext, accountSetId,anotherCountryCenterId);
 
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());	
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter countryCenter = loadRetailStoreCountryCenter(userContext, anotherCountryCenterId, emptyOptions());		
			accountSet.updateCountryCenter(countryCenter);		
			accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
			
			return present(userContext,accountSet, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateCountryCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForAccountSet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherRetailStore(RetailscmUserContext userContext, String accountSetId, String anotherRetailStoreId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
 		checkerOf(userContext).checkIdOfRetailStore(anotherRetailStoreId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

 	}
 	public AccountSet transferToAnotherRetailStore(RetailscmUserContext userContext, String accountSetId, String anotherRetailStoreId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStore(userContext, accountSetId,anotherRetailStoreId);
 
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());	
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore retailStore = loadRetailStore(userContext, anotherRetailStoreId, emptyOptions());		
			accountSet.updateRetailStore(retailStore);		
			accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
			
			return present(userContext,accountSet, allTokens());
			
		}

 	}

	


	public CandidateRetailStore requestCandidateRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStore result = new CandidateRetailStore();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStore> candidateList = retailStoreDaoOf(userContext).requestCandidateRetailStoreForAccountSet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherGoodsSupplier(RetailscmUserContext userContext, String accountSetId, String anotherGoodsSupplierId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
 		checkerOf(userContext).checkIdOfGoodsSupplier(anotherGoodsSupplierId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

 	}
 	public AccountSet transferToAnotherGoodsSupplier(RetailscmUserContext userContext, String accountSetId, String anotherGoodsSupplierId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoodsSupplier(userContext, accountSetId,anotherGoodsSupplierId);
 
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());	
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, anotherGoodsSupplierId, emptyOptions());		
			accountSet.updateGoodsSupplier(goodsSupplier);		
			accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
			
			return present(userContext,accountSet, allTokens());
			
		}

 	}

	


	public CandidateGoodsSupplier requestCandidateGoodsSupplier(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsSupplier result = new CandidateGoodsSupplier();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsSupplier> candidateList = goodsSupplierDaoOf(userContext).requestCandidateGoodsSupplierForAccountSet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCountryCenterId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCountryCenterId, options);
 	}
 	


	

 	protected GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String newGoodsSupplierId, Map<String,Object> options) throws Exception
 	{

 		return goodsSupplierDaoOf(userContext).load(newGoodsSupplierId, options);
 	}
 	


	

 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String newRetailStoreId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreDaoOf(userContext).load(newRetailStoreId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountSetId, int accountSetVersion) throws Exception {
		//deleteInternal(userContext, accountSetId, accountSetVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountSetId, int accountSetVersion) throws Exception{

		accountSetDaoOf(userContext).delete(accountSetId, accountSetVersion);
	}

	public AccountSet forgetByAll(RetailscmUserContext userContext, String accountSetId, int accountSetVersion) throws Exception {
		return forgetByAllInternal(userContext, accountSetId, accountSetVersion);
	}
	protected AccountSet forgetByAllInternal(RetailscmUserContext userContext,
			String accountSetId, int accountSetVersion) throws Exception{

		return accountSetDaoOf(userContext).disconnectFromAll(accountSetId, accountSetVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountSetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountSetDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountSet(accountSetId);

		
		checkerOf(userContext).checkAccountingSubjectCodeOfAccountingSubject(accountingSubjectCode);
		
		checkerOf(userContext).checkAccountingSubjectNameOfAccountingSubject(accountingSubjectName);
		
		checkerOf(userContext).checkAccountingSubjectClassCodeOfAccountingSubject(accountingSubjectClassCode);
		
		checkerOf(userContext).checkAccountingSubjectClassNameOfAccountingSubject(accountingSubjectClassName);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);


	}
	public  AccountSet addAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingSubject(userContext,accountSetId,accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName,tokensExpr);

		AccountingSubject accountingSubject = createAccountingSubject(userContext,accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName);

		AccountSet accountSet = loadAccountSet(userContext, accountSetId, emptyOptions());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.addAccountingSubject( accountingSubject );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			
			userContext.getManagerGroup().getAccountingSubjectManager().onNewInstanceCreated(userContext, accountingSubject);
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingSubjectProperties(RetailscmUserContext userContext, String accountSetId,String id,String accountingSubjectCode,String accountingSubjectName,int accountingSubjectClassCode,String accountingSubjectClassName,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkIdOfAccountingSubject(id);

		checkerOf(userContext).checkAccountingSubjectCodeOfAccountingSubject( accountingSubjectCode);
		checkerOf(userContext).checkAccountingSubjectNameOfAccountingSubject( accountingSubjectName);
		checkerOf(userContext).checkAccountingSubjectClassCodeOfAccountingSubject( accountingSubjectClassCode);
		checkerOf(userContext).checkAccountingSubjectClassNameOfAccountingSubject( accountingSubjectClassName);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet updateAccountingSubjectProperties(RetailscmUserContext userContext, String accountSetId, String id,String accountingSubjectCode,String accountingSubjectName,int accountingSubjectClassCode,String accountingSubjectClassName, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingSubjectProperties(userContext,accountSetId,id,accountingSubjectCode,accountingSubjectName,accountingSubjectClassCode,accountingSubjectClassName,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingSubjectListList()
				.searchAccountingSubjectListWith(AccountingSubject.ID_PROPERTY, "is", id).done();

		AccountSet accountSetToUpdate = loadAccountSet(userContext, accountSetId, options);

		if(accountSetToUpdate.getAccountingSubjectList().isEmpty()){
			throw new AccountSetManagerException("AccountingSubject is NOT FOUND with id: '"+id+"'");
		}

		AccountingSubject item = accountSetToUpdate.getAccountingSubjectList().first();

		item.updateAccountingSubjectCode( accountingSubjectCode );
		item.updateAccountingSubjectName( accountingSubjectName );
		item.updateAccountingSubjectClassCode( accountingSubjectClassCode );
		item.updateAccountingSubjectClassName( accountingSubjectClassName );


		//checkParamsForAddingAccountingSubject(userContext,accountSetId,name, code, used,tokensExpr);
		AccountSet accountSet = saveAccountSet(userContext, accountSetToUpdate, tokens().withAccountingSubjectList().done());
		synchronized(accountSet){
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingSubject createAccountingSubject(RetailscmUserContext userContext, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName) throws Exception{

		AccountingSubject accountingSubject = new AccountingSubject();
		
		
		accountingSubject.setAccountingSubjectCode(accountingSubjectCode);		
		accountingSubject.setAccountingSubjectName(accountingSubjectName);		
		accountingSubject.setAccountingSubjectClassCode(accountingSubjectClassCode);		
		accountingSubject.setAccountingSubjectClassName(accountingSubjectClassName);
	
		
		return accountingSubject;


	}

	protected AccountingSubject createIndexedAccountingSubject(String id, int version){

		AccountingSubject accountingSubject = new AccountingSubject();
		accountingSubject.setId(id);
		accountingSubject.setVersion(version);
		return accountingSubject;

	}

	protected void checkParamsForRemovingAccountingSubjectList(RetailscmUserContext userContext, String accountSetId,
			String accountingSubjectIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		for(String accountingSubjectIdItem: accountingSubjectIds){
			checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet removeAccountingSubjectList(RetailscmUserContext userContext, String accountSetId,
			String accountingSubjectIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingSubjectList(userContext, accountSetId,  accountingSubjectIds, tokensExpr);


			AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
			synchronized(accountSet){
				//Will be good when the accountSet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountSetDaoOf(userContext).planToRemoveAccountingSubjectList(accountSet, accountingSubjectIds, allTokens());
				accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
				deleteRelationListInGraph(userContext, accountSet.getAccountingSubjectList());
				return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingSubject(RetailscmUserContext userContext, String accountSetId,
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountSet( accountSetId);
		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).checkVersionOfAccountingSubject(accountingSubjectVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet removeAccountingSubject(RetailscmUserContext userContext, String accountSetId,
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingSubject(userContext,accountSetId, accountingSubjectId, accountingSubjectVersion,tokensExpr);

		AccountingSubject accountingSubject = createIndexedAccountingSubject(accountingSubjectId, accountingSubjectVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.removeAccountingSubject( accountingSubject );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			deleteRelationInGraph(userContext, accountingSubject);
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingSubject(RetailscmUserContext userContext, String accountSetId,
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountSet( accountSetId);
		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).checkVersionOfAccountingSubject(accountingSubjectVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet copyAccountingSubjectFrom(RetailscmUserContext userContext, String accountSetId,
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingSubject(userContext,accountSetId, accountingSubjectId, accountingSubjectVersion,tokensExpr);

		AccountingSubject accountingSubject = createIndexedAccountingSubject(accountingSubjectId, accountingSubjectVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountSet.copyAccountingSubjectFrom( accountingSubject );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			
			userContext.getManagerGroup().getAccountingSubjectManager().onNewInstanceCreated(userContext, (AccountingSubject)accountSet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkIdOfAccountingSubject(accountingSubjectId);
		checkerOf(userContext).checkVersionOfAccountingSubject(accountingSubjectVersion);
		

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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}

	public  AccountSet updateAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingSubject(userContext, accountSetId, accountingSubjectId, accountingSubjectVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingSubjectList().searchAccountingSubjectListWith(AccountingSubject.ID_PROPERTY, "eq", accountingSubjectId).done();



		AccountSet accountSet = loadAccountSet(userContext, accountSetId, loadTokens);

		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountSet.removeAccountingSubject( accountingSubject );
			//make changes to AcceleraterAccount.
			AccountingSubject accountingSubjectIndex = createIndexedAccountingSubject(accountingSubjectId, accountingSubjectVersion);

			AccountingSubject accountingSubject = accountSet.findTheAccountingSubject(accountingSubjectIndex);
			if(accountingSubject == null){
				throw new AccountSetManagerException(accountingSubject+" is NOT FOUND" );
			}

			accountingSubject.changeProperty(property, newValueExpr);
			
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountSet(accountSetId);

		
		checkerOf(userContext).checkNameOfAccountingPeriod(name);
		
		checkerOf(userContext).checkStartDateOfAccountingPeriod(startDate);
		
		checkerOf(userContext).checkEndDateOfAccountingPeriod(endDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);


	}
	public  AccountSet addAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingPeriod(userContext,accountSetId,name, startDate, endDate,tokensExpr);

		AccountingPeriod accountingPeriod = createAccountingPeriod(userContext,name, startDate, endDate);

		AccountSet accountSet = loadAccountSet(userContext, accountSetId, emptyOptions());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.addAccountingPeriod( accountingPeriod );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			
			userContext.getManagerGroup().getAccountingPeriodManager().onNewInstanceCreated(userContext, accountingPeriod);
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingPeriodProperties(RetailscmUserContext userContext, String accountSetId,String id,String name,Date startDate,Date endDate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkIdOfAccountingPeriod(id);

		checkerOf(userContext).checkNameOfAccountingPeriod( name);
		checkerOf(userContext).checkStartDateOfAccountingPeriod( startDate);
		checkerOf(userContext).checkEndDateOfAccountingPeriod( endDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet updateAccountingPeriodProperties(RetailscmUserContext userContext, String accountSetId, String id,String name,Date startDate,Date endDate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingPeriodProperties(userContext,accountSetId,id,name,startDate,endDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingPeriodListList()
				.searchAccountingPeriodListWith(AccountingPeriod.ID_PROPERTY, "is", id).done();

		AccountSet accountSetToUpdate = loadAccountSet(userContext, accountSetId, options);

		if(accountSetToUpdate.getAccountingPeriodList().isEmpty()){
			throw new AccountSetManagerException("AccountingPeriod is NOT FOUND with id: '"+id+"'");
		}

		AccountingPeriod item = accountSetToUpdate.getAccountingPeriodList().first();

		item.updateName( name );
		item.updateStartDate( startDate );
		item.updateEndDate( endDate );


		//checkParamsForAddingAccountingPeriod(userContext,accountSetId,name, code, used,tokensExpr);
		AccountSet accountSet = saveAccountSet(userContext, accountSetToUpdate, tokens().withAccountingPeriodList().done());
		synchronized(accountSet){
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingPeriod createAccountingPeriod(RetailscmUserContext userContext, String name, Date startDate, Date endDate) throws Exception{

		AccountingPeriod accountingPeriod = new AccountingPeriod();
		
		
		accountingPeriod.setName(name);		
		accountingPeriod.setStartDate(startDate);		
		accountingPeriod.setEndDate(endDate);
	
		
		return accountingPeriod;


	}

	protected AccountingPeriod createIndexedAccountingPeriod(String id, int version){

		AccountingPeriod accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(id);
		accountingPeriod.setVersion(version);
		return accountingPeriod;

	}

	protected void checkParamsForRemovingAccountingPeriodList(RetailscmUserContext userContext, String accountSetId,
			String accountingPeriodIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		for(String accountingPeriodIdItem: accountingPeriodIds){
			checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet removeAccountingPeriodList(RetailscmUserContext userContext, String accountSetId,
			String accountingPeriodIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingPeriodList(userContext, accountSetId,  accountingPeriodIds, tokensExpr);


			AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
			synchronized(accountSet){
				//Will be good when the accountSet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountSetDaoOf(userContext).planToRemoveAccountingPeriodList(accountSet, accountingPeriodIds, allTokens());
				accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
				deleteRelationListInGraph(userContext, accountSet.getAccountingPeriodList());
				return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingPeriod(RetailscmUserContext userContext, String accountSetId,
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountSet( accountSetId);
		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).checkVersionOfAccountingPeriod(accountingPeriodVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet removeAccountingPeriod(RetailscmUserContext userContext, String accountSetId,
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingPeriod(userContext,accountSetId, accountingPeriodId, accountingPeriodVersion,tokensExpr);

		AccountingPeriod accountingPeriod = createIndexedAccountingPeriod(accountingPeriodId, accountingPeriodVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.removeAccountingPeriod( accountingPeriod );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			deleteRelationInGraph(userContext, accountingPeriod);
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingPeriod(RetailscmUserContext userContext, String accountSetId,
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountSet( accountSetId);
		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).checkVersionOfAccountingPeriod(accountingPeriodVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet copyAccountingPeriodFrom(RetailscmUserContext userContext, String accountSetId,
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingPeriod(userContext,accountSetId, accountingPeriodId, accountingPeriodVersion,tokensExpr);

		AccountingPeriod accountingPeriod = createIndexedAccountingPeriod(accountingPeriodId, accountingPeriodVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountSet.copyAccountingPeriodFrom( accountingPeriod );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			
			userContext.getManagerGroup().getAccountingPeriodManager().onNewInstanceCreated(userContext, (AccountingPeriod)accountSet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkIdOfAccountingPeriod(accountingPeriodId);
		checkerOf(userContext).checkVersionOfAccountingPeriod(accountingPeriodVersion);
		

		if(AccountingPeriod.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingPeriod(parseString(newValueExpr));
		
		}
		
		if(AccountingPeriod.START_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStartDateOfAccountingPeriod(parseDate(newValueExpr));
		
		}
		
		if(AccountingPeriod.END_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEndDateOfAccountingPeriod(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}

	public  AccountSet updateAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingPeriod(userContext, accountSetId, accountingPeriodId, accountingPeriodVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingPeriodList().searchAccountingPeriodListWith(AccountingPeriod.ID_PROPERTY, "eq", accountingPeriodId).done();



		AccountSet accountSet = loadAccountSet(userContext, accountSetId, loadTokens);

		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountSet.removeAccountingPeriod( accountingPeriod );
			//make changes to AcceleraterAccount.
			AccountingPeriod accountingPeriodIndex = createIndexedAccountingPeriod(accountingPeriodId, accountingPeriodVersion);

			AccountingPeriod accountingPeriod = accountSet.findTheAccountingPeriod(accountingPeriodIndex);
			if(accountingPeriod == null){
				throw new AccountSetManagerException(accountingPeriod+" is NOT FOUND" );
			}

			accountingPeriod.changeProperty(property, newValueExpr);
			
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String name, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountSet(accountSetId);

		
		checkerOf(userContext).checkNameOfAccountingDocumentType(name);
		
		checkerOf(userContext).checkDescriptionOfAccountingDocumentType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);


	}
	public  AccountSet addAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String name, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocumentType(userContext,accountSetId,name, description,tokensExpr);

		AccountingDocumentType accountingDocumentType = createAccountingDocumentType(userContext,name, description);

		AccountSet accountSet = loadAccountSet(userContext, accountSetId, emptyOptions());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.addAccountingDocumentType( accountingDocumentType );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			
			userContext.getManagerGroup().getAccountingDocumentTypeManager().onNewInstanceCreated(userContext, accountingDocumentType);
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentTypeProperties(RetailscmUserContext userContext, String accountSetId,String id,String name,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkIdOfAccountingDocumentType(id);

		checkerOf(userContext).checkNameOfAccountingDocumentType( name);
		checkerOf(userContext).checkDescriptionOfAccountingDocumentType( description);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet updateAccountingDocumentTypeProperties(RetailscmUserContext userContext, String accountSetId, String id,String name,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentTypeProperties(userContext,accountSetId,id,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentTypeListList()
				.searchAccountingDocumentTypeListWith(AccountingDocumentType.ID_PROPERTY, "is", id).done();

		AccountSet accountSetToUpdate = loadAccountSet(userContext, accountSetId, options);

		if(accountSetToUpdate.getAccountingDocumentTypeList().isEmpty()){
			throw new AccountSetManagerException("AccountingDocumentType is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocumentType item = accountSetToUpdate.getAccountingDocumentTypeList().first();

		item.updateName( name );
		item.updateDescription( description );


		//checkParamsForAddingAccountingDocumentType(userContext,accountSetId,name, code, used,tokensExpr);
		AccountSet accountSet = saveAccountSet(userContext, accountSetToUpdate, tokens().withAccountingDocumentTypeList().done());
		synchronized(accountSet){
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocumentType createAccountingDocumentType(RetailscmUserContext userContext, String name, String description) throws Exception{

		AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
		
		
		accountingDocumentType.setName(name);		
		accountingDocumentType.setDescription(description);
	
		
		return accountingDocumentType;


	}

	protected AccountingDocumentType createIndexedAccountingDocumentType(String id, int version){

		AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
		accountingDocumentType.setId(id);
		accountingDocumentType.setVersion(version);
		return accountingDocumentType;

	}

	protected void checkParamsForRemovingAccountingDocumentTypeList(RetailscmUserContext userContext, String accountSetId,
			String accountingDocumentTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		for(String accountingDocumentTypeIdItem: accountingDocumentTypeIds){
			checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet removeAccountingDocumentTypeList(RetailscmUserContext userContext, String accountSetId,
			String accountingDocumentTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentTypeList(userContext, accountSetId,  accountingDocumentTypeIds, tokensExpr);


			AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
			synchronized(accountSet){
				//Will be good when the accountSet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountSetDaoOf(userContext).planToRemoveAccountingDocumentTypeList(accountSet, accountingDocumentTypeIds, allTokens());
				accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
				deleteRelationListInGraph(userContext, accountSet.getAccountingDocumentTypeList());
				return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocumentType(RetailscmUserContext userContext, String accountSetId,
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountSet( accountSetId);
		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet removeAccountingDocumentType(RetailscmUserContext userContext, String accountSetId,
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocumentType(userContext,accountSetId, accountingDocumentTypeId, accountingDocumentTypeVersion,tokensExpr);

		AccountingDocumentType accountingDocumentType = createIndexedAccountingDocumentType(accountingDocumentTypeId, accountingDocumentTypeVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.removeAccountingDocumentType( accountingDocumentType );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			deleteRelationInGraph(userContext, accountingDocumentType);
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocumentType(RetailscmUserContext userContext, String accountSetId,
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountSet( accountSetId);
		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}
	public  AccountSet copyAccountingDocumentTypeFrom(RetailscmUserContext userContext, String accountSetId,
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocumentType(userContext,accountSetId, accountingDocumentTypeId, accountingDocumentTypeVersion,tokensExpr);

		AccountingDocumentType accountingDocumentType = createIndexedAccountingDocumentType(accountingDocumentTypeId, accountingDocumentTypeVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountSet.copyAccountingDocumentTypeFrom( accountingDocumentType );
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			
			userContext.getManagerGroup().getAccountingDocumentTypeManager().onNewInstanceCreated(userContext, (AccountingDocumentType)accountSet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		checkerOf(userContext).checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);
		

		if(AccountingDocumentType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocumentType(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfAccountingDocumentType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountSetManagerException.class);

	}

	public  AccountSet updateAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocumentType(userContext, accountSetId, accountingDocumentTypeId, accountingDocumentTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentTypeList().searchAccountingDocumentTypeListWith(AccountingDocumentType.ID_PROPERTY, "eq", accountingDocumentTypeId).done();



		AccountSet accountSet = loadAccountSet(userContext, accountSetId, loadTokens);

		synchronized(accountSet){
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountSet.removeAccountingDocumentType( accountingDocumentType );
			//make changes to AcceleraterAccount.
			AccountingDocumentType accountingDocumentTypeIndex = createIndexedAccountingDocumentType(accountingDocumentTypeId, accountingDocumentTypeVersion);

			AccountingDocumentType accountingDocumentType = accountSet.findTheAccountingDocumentType(accountingDocumentTypeIndex);
			if(accountingDocumentType == null){
				throw new AccountSetManagerException(accountingDocumentType+" is NOT FOUND" );
			}

			accountingDocumentType.changeProperty(property, newValueExpr);
			
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountSet newCreated) throws Exception{
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
		//   AccountSet newAccountSet = this.createAccountSet(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountSet
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountSet.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountSet> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> countryCenterList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(countryCenterList, RetailStoreCountryCenter.class);
		List<RetailStore> retailStoreList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStore.class);
		userContext.getDAOGroup().enhanceList(retailStoreList, RetailStore.class);
		List<GoodsSupplier> goodsSupplierList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsSupplier.class);
		userContext.getDAOGroup().enhanceList(goodsSupplierList, GoodsSupplier.class);


    }
	
	public Object listByCountryCenter(RetailscmUserContext userContext,String countryCenterId) throws Exception {
		return listPageByCountryCenter(userContext, countryCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCountryCenter(RetailscmUserContext userContext,String countryCenterId, int start, int count) throws Exception {
		SmartList<AccountSet> list = accountSetDaoOf(userContext).findAccountSetByCountryCenter(countryCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountSet.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(countryCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("账套列表");
		page.setRequestName("listByCountryCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCountryCenter/%s/",  getBeanName(), countryCenterId)));

		page.assemblerContent(userContext, "listByCountryCenter");
		return page.doRender(userContext);
	}
  
	public Object listByRetailStore(RetailscmUserContext userContext,String retailStoreId) throws Exception {
		return listPageByRetailStore(userContext, retailStoreId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByRetailStore(RetailscmUserContext userContext,String retailStoreId, int start, int count) throws Exception {
		SmartList<AccountSet> list = accountSetDaoOf(userContext).findAccountSetByRetailStore(retailStoreId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountSet.class);
		page.setContainerObject(RetailStore.withId(retailStoreId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("账套列表");
		page.setRequestName("listByRetailStore");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByRetailStore/%s/",  getBeanName(), retailStoreId)));

		page.assemblerContent(userContext, "listByRetailStore");
		return page.doRender(userContext);
	}
  
	public Object listByGoodsSupplier(RetailscmUserContext userContext,String goodsSupplierId) throws Exception {
		return listPageByGoodsSupplier(userContext, goodsSupplierId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByGoodsSupplier(RetailscmUserContext userContext,String goodsSupplierId, int start, int count) throws Exception {
		SmartList<AccountSet> list = accountSetDaoOf(userContext).findAccountSetByGoodsSupplier(goodsSupplierId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountSet.class);
		page.setContainerObject(GoodsSupplier.withId(goodsSupplierId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("账套列表");
		page.setRequestName("listByGoodsSupplier");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByGoodsSupplier/%s/",  getBeanName(), goodsSupplierId)));

		page.assemblerContent(userContext, "listByGoodsSupplier");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String accountSetId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountSetDetailScope().clone();
		AccountSet merchantObj = (AccountSet) this.view(userContext, accountSetId);
    String merchantObjId = accountSetId;
    String linkToUrl =	"accountSetManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "账套"+"详情";
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
				MapUtil.put("id", "3-yearSet")
				    .put("fieldName", "yearSet")
				    .put("label", "年组")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("yearSet", merchantObj.getYearSet());

		propList.add(
				MapUtil.put("id", "4-effectiveDate")
				    .put("fieldName", "effectiveDate")
				    .put("label", "生效日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("effectiveDate", merchantObj.getEffectiveDate());

		propList.add(
				MapUtil.put("id", "5-accountingSystem")
				    .put("fieldName", "accountingSystem")
				    .put("label", "会计制度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingSystem", merchantObj.getAccountingSystem());

		propList.add(
				MapUtil.put("id", "6-domesticCurrencyCode")
				    .put("fieldName", "domesticCurrencyCode")
				    .put("label", "本币代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("domesticCurrencyCode", merchantObj.getDomesticCurrencyCode());

		propList.add(
				MapUtil.put("id", "7-domesticCurrencyName")
				    .put("fieldName", "domesticCurrencyName")
				    .put("label", "本币名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("domesticCurrencyName", merchantObj.getDomesticCurrencyName());

		propList.add(
				MapUtil.put("id", "8-openingBank")
				    .put("fieldName", "openingBank")
				    .put("label", "开户银行")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("openingBank", merchantObj.getOpeningBank());

		propList.add(
				MapUtil.put("id", "9-accountNumber")
				    .put("fieldName", "accountNumber")
				    .put("label", "帐户号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountNumber", merchantObj.getAccountNumber());

		propList.add(
				MapUtil.put("id", "10-countryCenter")
				    .put("fieldName", "countryCenter")
				    .put("label", "全国运营中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("countryCenter", merchantObj.getCountryCenter());

		propList.add(
				MapUtil.put("id", "11-retailStore")
				    .put("fieldName", "retailStore")
				    .put("label", "双链小超")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("retailStore", merchantObj.getRetailStore());

		propList.add(
				MapUtil.put("id", "12-goodsSupplier")
				    .put("fieldName", "goodsSupplier")
				    .put("label", "产品供应商")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsSupplierManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("goodsSupplier", merchantObj.getGoodsSupplier());

		propList.add(
				MapUtil.put("id", "13-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：accountingSubjectListSection
		Map accountingSubjectListSection = ListofUtils.buildSection(
		    "accountingSubjectListSection",
		    "会计科目表",
		    null,
		    "",
		    "__no_group",
		    "accountingSubjectManager/listByAccountSet/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingSubjectListSection);

		result.put("accountingSubjectListSection", ListofUtils.toShortList(merchantObj.getAccountingSubjectList(), "accountingSubject"));
		vscope.field("accountingSubjectListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountingSubject.class.getName(), null));

		//处理Section：accountingPeriodListSection
		Map accountingPeriodListSection = ListofUtils.buildSection(
		    "accountingPeriodListSection",
		    "会计期间列表",
		    null,
		    "",
		    "__no_group",
		    "accountingPeriodManager/listByAccountSet/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingPeriodListSection);

		result.put("accountingPeriodListSection", ListofUtils.toShortList(merchantObj.getAccountingPeriodList(), "accountingPeriod"));
		vscope.field("accountingPeriodListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountingPeriod.class.getName(), null));

		//处理Section：accountingDocumentTypeListSection
		Map accountingDocumentTypeListSection = ListofUtils.buildSection(
		    "accountingDocumentTypeListSection",
		    "会计凭证种类表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentTypeManager/listByAccountingPeriod/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingDocumentTypeListSection);

		result.put("accountingDocumentTypeListSection", ListofUtils.toShortList(merchantObj.getAccountingDocumentTypeList(), "accountingDocumentType"));
		vscope.field("accountingDocumentTypeListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountingDocumentType.class.getName(), null));

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


