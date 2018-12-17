
package com.doublechaintech.retailscm.accountset;

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






public class AccountSetManagerImpl extends CustomRetailscmCheckerManager implements AccountSetManager {
	
	private static final String SERVICE_TYPE = "AccountSet";
	
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
 
 		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountSetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountSet, tokens);
 	}
 	
 	
 	 public AccountSet searchAccountSet(RetailscmUserContext userContext, String accountSetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountSetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountSet, tokens);
 	}
 	
 	

 	protected AccountSet present(RetailscmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountSet,tokens);
		
		
		AccountSet  accountSetToPresent = userContext.getDAOGroup().getAccountSetDAO().present(accountSet, tokens);
		
		List<BaseEntity> entityListToNaming = accountSetToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAccountSetDAO().alias(entityListToNaming);
		
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
 		return userContext.getDAOGroup().getAccountSetDAO().save(accountSet, tokens);
 	}
 	protected AccountSet loadAccountSet(RetailscmUserContext userContext, String accountSetId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().throwExceptionIfHasErrors( AccountSetManagerException.class);

 
 		return userContext.getDAOGroup().getAccountSetDAO().load(accountSetId, tokens);
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
	
 	
 	
 
 	
 	


	public AccountSet createAccountSet(RetailscmUserContext userContext,String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId, String goodsSupplierId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfAccountSet(name);
		userContext.getChecker().checkYearSetOfAccountSet(yearSet);
		userContext.getChecker().checkEffectiveDateOfAccountSet(effectiveDate);
		userContext.getChecker().checkAccountingSystemOfAccountSet(accountingSystem);
		userContext.getChecker().checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);
		userContext.getChecker().checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);
		userContext.getChecker().checkOpeningBankOfAccountSet(openingBank);
		userContext.getChecker().checkAccountNumberOfAccountSet(accountNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);


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
		

		
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkVersionOfAccountSet( accountSetVersion);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountSet(parseString(newValueExpr));
		}
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			userContext.getChecker().checkYearSetOfAccountSet(parseString(newValueExpr));
		}
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkEffectiveDateOfAccountSet(parseDate(newValueExpr));
		}
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingSystemOfAccountSet(parseString(newValueExpr));
		}
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkDomesticCurrencyCodeOfAccountSet(parseString(newValueExpr));
		}
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDomesticCurrencyNameOfAccountSet(parseString(newValueExpr));
		}
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			userContext.getChecker().checkOpeningBankOfAccountSet(parseString(newValueExpr));
		}
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountNumberOfAccountSet(parseString(newValueExpr));
		}		

				

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
		
	}
	
	
	
	public AccountSet clone(RetailscmUserContext userContext, String fromAccountSetId) throws Exception{
		
		return userContext.getDAOGroup().getAccountSetDAO().clone(fromAccountSetId, this.allTokens());
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
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountSetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCountryCenter(RetailscmUserContext userContext, String accountSetId, String anotherCountryCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountSet(accountSetId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCountryCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
 		
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForAccountSet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherRetailStore(RetailscmUserContext userContext, String accountSetId, String anotherRetailStoreId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountSet(accountSetId);
 		userContext.getChecker().checkIdOfRetailStore(anotherRetailStoreId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
 		
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
		SmartList<RetailStore> candidateList = userContext.getDAOGroup().getRetailStoreDAO().requestCandidateRetailStoreForAccountSet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherGoodsSupplier(RetailscmUserContext userContext, String accountSetId, String anotherGoodsSupplierId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAccountSet(accountSetId);
 		userContext.getChecker().checkIdOfGoodsSupplier(anotherGoodsSupplierId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
 		
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
		SmartList<GoodsSupplier> candidateList = userContext.getDAOGroup().getGoodsSupplierDAO().requestCandidateGoodsSupplierForAccountSet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCountryCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCountryCenterId, options);
 	}
 	
 	
 	
	
	 	
 	protected GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String newGoodsSupplierId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsSupplierDAO().load(newGoodsSupplierId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String newRetailStoreId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreDAO().load(newRetailStoreId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountSetId, int accountSetVersion) throws Exception {
		//deleteInternal(userContext, accountSetId, accountSetVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountSetId, int accountSetVersion) throws Exception{
			
		userContext.getDAOGroup().getAccountSetDAO().delete(accountSetId, accountSetVersion);
	}
	
	public AccountSet forgetByAll(RetailscmUserContext userContext, String accountSetId, int accountSetVersion) throws Exception {
		return forgetByAllInternal(userContext, accountSetId, accountSetVersion);		
	}
	protected AccountSet forgetByAllInternal(RetailscmUserContext userContext,
			String accountSetId, int accountSetVersion) throws Exception{
			
		return userContext.getDAOGroup().getAccountSetDAO().disconnectFromAll(accountSetId, accountSetVersion);
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
		return userContext.getDAOGroup().getAccountSetDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);

		
		userContext.getChecker().checkAccountingSubjectCodeOfAccountingSubject(accountingSubjectCode);
		
		userContext.getChecker().checkAccountingSubjectNameOfAccountingSubject(accountingSubjectName);
		
		userContext.getChecker().checkAccountingSubjectClassCodeOfAccountingSubject(accountingSubjectClassCode);
		
		userContext.getChecker().checkAccountingSubjectClassNameOfAccountingSubject(accountingSubjectClassName);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);

	
	}
	public  AccountSet addAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingSubject(userContext,accountSetId,accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName,tokensExpr);
		
		AccountingSubject accountingSubject = createAccountingSubject(userContext,accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
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
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkIdOfAccountingSubject(id);
		
		userContext.getChecker().checkAccountingSubjectCodeOfAccountingSubject( accountingSubjectCode);
		userContext.getChecker().checkAccountingSubjectNameOfAccountingSubject( accountingSubjectName);
		userContext.getChecker().checkAccountingSubjectClassCodeOfAccountingSubject( accountingSubjectClassCode);
		userContext.getChecker().checkAccountingSubjectClassNameOfAccountingSubject( accountingSubjectClassName);

		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
		
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
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		for(String accountingSubjectId: accountingSubjectIds){
			userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
		
	}
	public  AccountSet removeAccountingSubjectList(RetailscmUserContext userContext, String accountSetId, 
			String accountingSubjectIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingSubjectList(userContext, accountSetId,  accountingSubjectIds, tokensExpr);
			
			
			AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
			synchronized(accountSet){ 
				//Will be good when the accountSet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountSetDAO().planToRemoveAccountingSubjectList(accountSet, accountingSubjectIds, allTokens());
				accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
				deleteRelationListInGraph(userContext, accountSet.getAccountingSubjectList());
				return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingSubject(RetailscmUserContext userContext, String accountSetId, 
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountSet( accountSetId);
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().checkVersionOfAccountingSubject(accountingSubjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		
		userContext.getChecker().checkIdOfAccountSet( accountSetId);
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().checkVersionOfAccountingSubject(accountingSubjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		

		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkIdOfAccountingSubject(accountingSubjectId);
		userContext.getChecker().checkVersionOfAccountingSubject(accountingSubjectVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		
		

		
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);

		
		userContext.getChecker().checkNameOfAccountingPeriod(name);
		
		userContext.getChecker().checkStartDateOfAccountingPeriod(startDate);
		
		userContext.getChecker().checkEndDateOfAccountingPeriod(endDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);

	
	}
	public  AccountSet addAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingPeriod(userContext,accountSetId,name, startDate, endDate,tokensExpr);
		
		AccountingPeriod accountingPeriod = createAccountingPeriod(userContext,name, startDate, endDate);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
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
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkIdOfAccountingPeriod(id);
		
		userContext.getChecker().checkNameOfAccountingPeriod( name);
		userContext.getChecker().checkStartDateOfAccountingPeriod( startDate);
		userContext.getChecker().checkEndDateOfAccountingPeriod( endDate);

		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
		
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
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		for(String accountingPeriodId: accountingPeriodIds){
			userContext.getChecker().checkIdOfAccountingPeriod(accountingPeriodId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
		
	}
	public  AccountSet removeAccountingPeriodList(RetailscmUserContext userContext, String accountSetId, 
			String accountingPeriodIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingPeriodList(userContext, accountSetId,  accountingPeriodIds, tokensExpr);
			
			
			AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
			synchronized(accountSet){ 
				//Will be good when the accountSet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountSetDAO().planToRemoveAccountingPeriodList(accountSet, accountingPeriodIds, allTokens());
				accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
				deleteRelationListInGraph(userContext, accountSet.getAccountingPeriodList());
				return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingPeriod(RetailscmUserContext userContext, String accountSetId, 
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountSet( accountSetId);
		userContext.getChecker().checkIdOfAccountingPeriod(accountingPeriodId);
		userContext.getChecker().checkVersionOfAccountingPeriod(accountingPeriodVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		
		userContext.getChecker().checkIdOfAccountSet( accountSetId);
		userContext.getChecker().checkIdOfAccountingPeriod(accountingPeriodId);
		userContext.getChecker().checkVersionOfAccountingPeriod(accountingPeriodVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		

		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkIdOfAccountingPeriod(accountingPeriodId);
		userContext.getChecker().checkVersionOfAccountingPeriod(accountingPeriodVersion);
		

		if(AccountingPeriod.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingPeriod(parseString(newValueExpr));
		}
		
		if(AccountingPeriod.START_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkStartDateOfAccountingPeriod(parseDate(newValueExpr));
		}
		
		if(AccountingPeriod.END_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkEndDateOfAccountingPeriod(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		
		

		
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);

		
		userContext.getChecker().checkNameOfAccountingDocumentType(name);
		
		userContext.getChecker().checkDescriptionOfAccountingDocumentType(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);

	
	}
	public  AccountSet addAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String name, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocumentType(userContext,accountSetId,name, description,tokensExpr);
		
		AccountingDocumentType accountingDocumentType = createAccountingDocumentType(userContext,name, description);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
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
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkIdOfAccountingDocumentType(id);
		
		userContext.getChecker().checkNameOfAccountingDocumentType( name);
		userContext.getChecker().checkDescriptionOfAccountingDocumentType( description);

		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
		
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
		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		for(String accountingDocumentTypeId: accountingDocumentTypeIds){
			userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
		
	}
	public  AccountSet removeAccountingDocumentTypeList(RetailscmUserContext userContext, String accountSetId, 
			String accountingDocumentTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountingDocumentTypeList(userContext, accountSetId,  accountingDocumentTypeIds, tokensExpr);
			
			
			AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
			synchronized(accountSet){ 
				//Will be good when the accountSet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getAccountSetDAO().planToRemoveAccountingDocumentTypeList(accountSet, accountingDocumentTypeIds, allTokens());
				accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
				deleteRelationListInGraph(userContext, accountSet.getAccountingDocumentTypeList());
				return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, 
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfAccountSet( accountSetId);
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		
		userContext.getChecker().checkIdOfAccountSet( accountSetId);
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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
		

		
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkIdOfAccountingDocumentType(accountingDocumentTypeId);
		userContext.getChecker().checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);
		

		if(AccountingDocumentType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountingDocumentType(parseString(newValueExpr));
		}
		
		if(AccountingDocumentType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfAccountingDocumentType(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(AccountSetManagerException.class);
	
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

}


