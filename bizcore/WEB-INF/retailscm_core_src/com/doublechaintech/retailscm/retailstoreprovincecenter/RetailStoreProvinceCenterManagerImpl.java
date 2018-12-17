
package com.doublechaintech.retailscm.retailstoreprovincecenter;

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
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;






public class RetailStoreProvinceCenterManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreProvinceCenterManager {
	
	private static final String SERVICE_TYPE = "RetailStoreProvinceCenter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreProvinceCenterManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreProvinceCenterManagerException(message);

	}
	
	

 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreProvinceCenterDAO().save(retailStoreProvinceCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens);
 	}
 	
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenterDetail(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception{	

 		
 		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, allTokens());
 	}
 	
 	public RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreProvinceCenterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreProvinceCenter, tokens);
 	}
 	
 	
 	 public RetailStoreProvinceCenter searchRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreProvinceCenterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreProvinceCenter, tokens);
 	}
 	
 	

 	protected RetailStoreProvinceCenter present(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreProvinceCenter,tokens);
		
		
		RetailStoreProvinceCenter  retailStoreProvinceCenterToPresent = userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().present(retailStoreProvinceCenter, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreProvinceCenterToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().alias(entityListToNaming);
		
		return  retailStoreProvinceCenterToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreProvinceCenter loadRetailStoreProvinceCenterDetail(RetailscmUserContext userContext, String retailStoreProvinceCenterId) throws Exception{	
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, allTokens());
 		return present(userContext,retailStoreProvinceCenter, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreProvinceCenterId) throws Exception{	
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, viewTokens());
 		return present(userContext,retailStoreProvinceCenter, allTokens());
		
 	}
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().save(retailStoreProvinceCenter, tokens);
 	}
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreProvinceCenterManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().load(retailStoreProvinceCenterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreProvinceCenter, tokens);
		
		addAction(userContext, retailStoreProvinceCenter, tokens,"@create","createRetailStoreProvinceCenter","createRetailStoreProvinceCenter/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"@update","updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"@copy","cloneRetailStoreProvinceCenter","cloneRetailStoreProvinceCenter/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.transfer_to_country","transferToAnotherCountry","transferToAnotherCountry/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addProvinceCenterDepartment","addProvinceCenterDepartment","addProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeProvinceCenterDepartment","removeProvinceCenterDepartment","removeProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateProvinceCenterDepartment","updateProvinceCenterDepartment","updateProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyProvinceCenterDepartmentFrom","copyProvinceCenterDepartmentFrom","copyProvinceCenterDepartmentFrom/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addProvinceCenterEmployee","addProvinceCenterEmployee","addProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeProvinceCenterEmployee","removeProvinceCenterEmployee","removeProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateProvinceCenterEmployee","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addRetailStoreCityServiceCenter","addRetailStoreCityServiceCenter","addRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeRetailStoreCityServiceCenter","removeRetailStoreCityServiceCenter","removeRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyRetailStoreCityServiceCenterFrom","copyRetailStoreCityServiceCenterFrom","copyRetailStoreCityServiceCenterFrom/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(RetailscmUserContext userContext,String name, Date founded, String countryId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStoreProvinceCenter(name);
		userContext.getChecker().checkFoundedOfRetailStoreProvinceCenter(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);


		RetailStoreProvinceCenter retailStoreProvinceCenter=createNewRetailStoreProvinceCenter();	

		retailStoreProvinceCenter.setName(name);
		retailStoreProvinceCenter.setFounded(founded);
			
		RetailStoreCountryCenter country = loadRetailStoreCountryCenter(userContext, countryId,emptyOptions());
		retailStoreProvinceCenter.setCountry(country);
		
		
		retailStoreProvinceCenter.setLastUpdateTime(userContext.now());

		retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreProvinceCenter);
		return retailStoreProvinceCenter;

		
	}
	protected RetailStoreProvinceCenter createNewRetailStoreProvinceCenter() 
	{
		
		return new RetailStoreProvinceCenter();		
	}
	
	protected void checkParamsForUpdatingRetailStoreProvinceCenter(RetailscmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkVersionOfRetailStoreProvinceCenter( retailStoreProvinceCenterVersion);
		

		if(RetailStoreProvinceCenter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreProvinceCenter(parseString(newValueExpr));
		}
		if(RetailStoreProvinceCenter.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfRetailStoreProvinceCenter(parseDate(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
		
	}
	
	
	
	public RetailStoreProvinceCenter clone(RetailscmUserContext userContext, String fromRetailStoreProvinceCenterId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().clone(fromRetailStoreProvinceCenterId, this.allTokens());
	}
	
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception 
	{
		return internalSaveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, allTokens());

	}
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreProvinceCenter){ 
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.
			
			
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, options);
			return retailStoreProvinceCenter;
			
		}

	}
	
	public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(RetailscmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		if(retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion){
			String message = "The target version("+retailStoreProvinceCenter.getVersion()+") is not equals to version("+retailStoreProvinceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreProvinceCenter){ 
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.
			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
			retailStoreProvinceCenter.changeProperty(property, newValueExpr);
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
		}

	}
	
	public RetailStoreProvinceCenter updateRetailStoreProvinceCenterProperty(RetailscmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		if(retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion){
			String message = "The target version("+retailStoreProvinceCenter.getVersion()+") is not equals to version("+retailStoreProvinceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreProvinceCenter){ 
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.
			
			retailStoreProvinceCenter.changeProperty(property, newValueExpr);
			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreProvinceCenterTokens tokens(){
		return RetailStoreProvinceCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreProvinceCenterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProvinceCenterDepartmentListWith("id","desc")
		.sortProvinceCenterEmployeeListWith("id","desc")
		.sortRetailStoreCityServiceCenterListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreProvinceCenterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCountry(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCountryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
 		
 	}
 	public RetailStoreProvinceCenter transferToAnotherCountry(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId) throws Exception
 	{
 		checkParamsForTransferingAnotherCountry(userContext, retailStoreProvinceCenterId,anotherCountryId);
 
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());	
		synchronized(retailStoreProvinceCenter){
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter country = loadRetailStoreCountryCenter(userContext, anotherCountryId, emptyOptions());		
			retailStoreProvinceCenter.updateCountry(country);		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());
			
			return present(userContext,retailStoreProvinceCenter, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateCountry(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForRetailStoreProvinceCenter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCountryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCountryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception {
		//deleteInternal(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().delete(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}
	
	public RetailStoreProvinceCenter forgetByAll(RetailscmUserContext userContext, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);		
	}
	protected RetailStoreProvinceCenter forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().disconnectFromAll(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreProvinceCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().deleteAll();
	}


	//disconnect RetailStoreProvinceCenter with department in ProvinceCenterEmployee
	protected RetailStoreProvinceCenter breakWithProvinceCenterEmployeeByDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());

			synchronized(retailStoreProvinceCenter){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().planToRemoveProvinceCenterEmployeeListWithDepartment(retailStoreProvinceCenter, departmentId, this.emptyOptions());

				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
				return retailStoreProvinceCenter;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

		
		userContext.getChecker().checkNameOfProvinceCenterDepartment(name);
		
		userContext.getChecker().checkFoundedOfProvinceCenterDepartment(founded);
		
		userContext.getChecker().checkManagerOfProvinceCenterDepartment(manager);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	
	}
	public  RetailStoreProvinceCenter addProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId,name, founded, manager,tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = createProvinceCenterDepartment(userContext,name, founded, manager);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addProvinceCenterDepartment( provinceCenterDepartment );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			
			userContext.getManagerGroup().getProvinceCenterDepartmentManager().onNewInstanceCreated(userContext, provinceCenterDepartment);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceCenterDepartmentProperties(RetailscmUserContext userContext, String retailStoreProvinceCenterId,String id,String name,Date founded,String manager,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterDepartment(id);
		
		userContext.getChecker().checkNameOfProvinceCenterDepartment( name);
		userContext.getChecker().checkFoundedOfProvinceCenterDepartment( founded);
		userContext.getChecker().checkManagerOfProvinceCenterDepartment( manager);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
		
	}
	public  RetailStoreProvinceCenter updateProvinceCenterDepartmentProperties(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String id,String name,Date founded,String manager, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProvinceCenterDepartmentProperties(userContext,retailStoreProvinceCenterId,id,name,founded,manager,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceCenterDepartmentListList()
				.searchProvinceCenterDepartmentListWith(ProvinceCenterDepartment.ID_PROPERTY, "is", id).done();
		
		RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);
		
		if(retailStoreProvinceCenterToUpdate.getProvinceCenterDepartmentList().isEmpty()){
			throw new RetailStoreProvinceCenterManagerException("ProvinceCenterDepartment is NOT FOUND with id: '"+id+"'");
		}
		
		ProvinceCenterDepartment item = retailStoreProvinceCenterToUpdate.getProvinceCenterDepartmentList().first();
		
		item.updateName( name );
		item.updateFounded( founded );
		item.updateManager( manager );

		
		//checkParamsForAddingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
		RetailStoreProvinceCenter retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterToUpdate, tokens().withProvinceCenterDepartmentList().done());
		synchronized(retailStoreProvinceCenter){ 
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ProvinceCenterDepartment createProvinceCenterDepartment(RetailscmUserContext userContext, String name, Date founded, String manager) throws Exception{

		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		
		
		provinceCenterDepartment.setName(name);		
		provinceCenterDepartment.setFounded(founded);		
		provinceCenterDepartment.setManager(manager);
	
		
		return provinceCenterDepartment;
	
		
	}
	
	protected ProvinceCenterDepartment createIndexedProvinceCenterDepartment(String id, int version){

		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		provinceCenterDepartment.setId(id);
		provinceCenterDepartment.setVersion(version);
		return provinceCenterDepartment;			
		
	}
	
	protected void checkParamsForRemovingProvinceCenterDepartmentList(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
			String provinceCenterDepartmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		for(String provinceCenterDepartmentId: provinceCenterDepartmentIds){
			userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
		
	}
	public  RetailStoreProvinceCenter removeProvinceCenterDepartmentList(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
			String provinceCenterDepartmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProvinceCenterDepartmentList(userContext, retailStoreProvinceCenterId,  provinceCenterDepartmentIds, tokensExpr);
			
			
			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
			synchronized(retailStoreProvinceCenter){ 
				//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().planToRemoveProvinceCenterDepartmentList(retailStoreProvinceCenter, provinceCenterDepartmentIds, allTokens());
				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
				deleteRelationListInGraph(userContext, retailStoreProvinceCenter.getProvinceCenterDepartmentList());
				return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	public  RetailStoreProvinceCenter removeProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion,tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			deleteRelationInGraph(userContext, provinceCenterDepartment);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	public  RetailStoreProvinceCenter copyProvinceCenterDepartmentFrom(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion,tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreProvinceCenter.copyProvinceCenterDepartmentFrom( provinceCenterDepartment );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			
			userContext.getManagerGroup().getProvinceCenterDepartmentManager().onNewInstanceCreated(userContext, (ProvinceCenterDepartment)retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);
		

		if(ProvinceCenterDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProvinceCenterDepartment(parseString(newValueExpr));
		}
		
		if(ProvinceCenterDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfProvinceCenterDepartment(parseDate(newValueExpr));
		}
		
		if(ProvinceCenterDepartment.MANAGER_PROPERTY.equals(property)){
			userContext.getChecker().checkManagerOfProvinceCenterDepartment(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	
	public  RetailStoreProvinceCenter updateProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProvinceCenterDepartment(userContext, retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProvinceCenterDepartmentList().searchProvinceCenterDepartmentListWith(ProvinceCenterDepartment.ID_PROPERTY, "eq", provinceCenterDepartmentId).done();
		
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);
		
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );	
			//make changes to AcceleraterAccount.
			ProvinceCenterDepartment provinceCenterDepartmentIndex = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		
			ProvinceCenterDepartment provinceCenterDepartment = retailStoreProvinceCenter.findTheProvinceCenterDepartment(provinceCenterDepartmentIndex);
			if(provinceCenterDepartment == null){
				throw new RetailStoreProvinceCenterManagerException(provinceCenterDepartment+" is NOT FOUND" );
			}
			
			provinceCenterDepartment.changeProperty(property, newValueExpr);
			
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

		
		userContext.getChecker().checkNameOfProvinceCenterEmployee(name);
		
		userContext.getChecker().checkMobileOfProvinceCenterEmployee(mobile);
		
		userContext.getChecker().checkEmailOfProvinceCenterEmployee(email);
		
		userContext.getChecker().checkFoundedOfProvinceCenterEmployee(founded);
		
		userContext.getChecker().checkDepartmentIdOfProvinceCenterEmployee(departmentId);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	
	}
	public  RetailStoreProvinceCenter addProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId,name, mobile, email, founded, departmentId,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createProvinceCenterEmployee(userContext,name, mobile, email, founded, departmentId);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addProvinceCenterEmployee( provinceCenterEmployee );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, provinceCenterEmployee);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceCenterEmployeeProperties(RetailscmUserContext userContext, String retailStoreProvinceCenterId,String id,String name,String mobile,String email,Date founded,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(id);
		
		userContext.getChecker().checkNameOfProvinceCenterEmployee( name);
		userContext.getChecker().checkMobileOfProvinceCenterEmployee( mobile);
		userContext.getChecker().checkEmailOfProvinceCenterEmployee( email);
		userContext.getChecker().checkFoundedOfProvinceCenterEmployee( founded);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
		
	}
	public  RetailStoreProvinceCenter updateProvinceCenterEmployeeProperties(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String id,String name,String mobile,String email,Date founded, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProvinceCenterEmployeeProperties(userContext,retailStoreProvinceCenterId,id,name,mobile,email,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceCenterEmployeeListList()
				.searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "is", id).done();
		
		RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);
		
		if(retailStoreProvinceCenterToUpdate.getProvinceCenterEmployeeList().isEmpty()){
			throw new RetailStoreProvinceCenterManagerException("ProvinceCenterEmployee is NOT FOUND with id: '"+id+"'");
		}
		
		ProvinceCenterEmployee item = retailStoreProvinceCenterToUpdate.getProvinceCenterEmployeeList().first();
		
		item.updateName( name );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updateFounded( founded );

		
		//checkParamsForAddingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
		RetailStoreProvinceCenter retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterToUpdate, tokens().withProvinceCenterEmployeeList().done());
		synchronized(retailStoreProvinceCenter){ 
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext, String name, String mobile, String email, Date founded, String departmentId) throws Exception{

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		
		
		provinceCenterEmployee.setName(name);		
		provinceCenterEmployee.setMobile(mobile);		
		provinceCenterEmployee.setEmail(email);		
		provinceCenterEmployee.setFounded(founded);		
		ProvinceCenterDepartment  department = new ProvinceCenterDepartment();
		department.setId(departmentId);		
		provinceCenterEmployee.setDepartment(department);
	
		
		return provinceCenterEmployee;
	
		
	}
	
	protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version){

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(version);
		return provinceCenterEmployee;			
		
	}
	
	protected void checkParamsForRemovingProvinceCenterEmployeeList(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		for(String provinceCenterEmployeeId: provinceCenterEmployeeIds){
			userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
		
	}
	public  RetailStoreProvinceCenter removeProvinceCenterEmployeeList(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProvinceCenterEmployeeList(userContext, retailStoreProvinceCenterId,  provinceCenterEmployeeIds, tokensExpr);
			
			
			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
			synchronized(retailStoreProvinceCenter){ 
				//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().planToRemoveProvinceCenterEmployeeList(retailStoreProvinceCenter, provinceCenterEmployeeIds, allTokens());
				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
				deleteRelationListInGraph(userContext, retailStoreProvinceCenter.getProvinceCenterEmployeeList());
				return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	public  RetailStoreProvinceCenter removeProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			deleteRelationInGraph(userContext, provinceCenterEmployee);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	public  RetailStoreProvinceCenter copyProvinceCenterEmployeeFrom(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreProvinceCenter.copyProvinceCenterEmployeeFrom( provinceCenterEmployee );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, (ProvinceCenterEmployee)retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		

		if(ProvinceCenterEmployee.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProvinceCenterEmployee(parseString(newValueExpr));
		}
		
		if(ProvinceCenterEmployee.MOBILE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobileOfProvinceCenterEmployee(parseString(newValueExpr));
		}
		
		if(ProvinceCenterEmployee.EMAIL_PROPERTY.equals(property)){
			userContext.getChecker().checkEmailOfProvinceCenterEmployee(parseString(newValueExpr));
		}
		
		if(ProvinceCenterEmployee.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfProvinceCenterEmployee(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	
	public  RetailStoreProvinceCenter updateProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProvinceCenterEmployee(userContext, retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProvinceCenterEmployeeList().searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "eq", provinceCenterEmployeeId).done();
		
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);
		
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );	
			//make changes to AcceleraterAccount.
			ProvinceCenterEmployee provinceCenterEmployeeIndex = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		
			ProvinceCenterEmployee provinceCenterEmployee = retailStoreProvinceCenter.findTheProvinceCenterEmployee(provinceCenterEmployeeIndex);
			if(provinceCenterEmployee == null){
				throw new RetailStoreProvinceCenterManagerException(provinceCenterEmployee+" is NOT FOUND" );
			}
			
			provinceCenterEmployee.changeProperty(property, newValueExpr);
			
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

		
		userContext.getChecker().checkNameOfRetailStoreCityServiceCenter(name);
		
		userContext.getChecker().checkFoundedOfRetailStoreCityServiceCenter(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	
	}
	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId,name, founded,tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createRetailStoreCityServiceCenter(userContext,name, founded);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addRetailStoreCityServiceCenter( retailStoreCityServiceCenter );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			
			userContext.getManagerGroup().getRetailStoreCityServiceCenterManager().onNewInstanceCreated(userContext, retailStoreCityServiceCenter);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreCityServiceCenterProperties(RetailscmUserContext userContext, String retailStoreProvinceCenterId,String id,String name,Date founded,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(id);
		
		userContext.getChecker().checkNameOfRetailStoreCityServiceCenter( name);
		userContext.getChecker().checkFoundedOfRetailStoreCityServiceCenter( founded);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
		
	}
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenterProperties(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String id,String name,Date founded, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreCityServiceCenterProperties(userContext,retailStoreProvinceCenterId,id,name,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreCityServiceCenterListList()
				.searchRetailStoreCityServiceCenterListWith(RetailStoreCityServiceCenter.ID_PROPERTY, "is", id).done();
		
		RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);
		
		if(retailStoreProvinceCenterToUpdate.getRetailStoreCityServiceCenterList().isEmpty()){
			throw new RetailStoreProvinceCenterManagerException("RetailStoreCityServiceCenter is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreCityServiceCenter item = retailStoreProvinceCenterToUpdate.getRetailStoreCityServiceCenterList().first();
		
		item.updateName( name );
		item.updateFounded( founded );

		
		//checkParamsForAddingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
		RetailStoreProvinceCenter retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterToUpdate, tokens().withRetailStoreCityServiceCenterList().done());
		synchronized(retailStoreProvinceCenter){ 
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(RetailscmUserContext userContext, String name, Date founded) throws Exception{

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		
		
		retailStoreCityServiceCenter.setName(name);		
		retailStoreCityServiceCenter.setFounded(founded);		
		retailStoreCityServiceCenter.setLastUpdateTime(userContext.now());
	
		
		return retailStoreCityServiceCenter;
	
		
	}
	
	protected RetailStoreCityServiceCenter createIndexedRetailStoreCityServiceCenter(String id, int version){

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		retailStoreCityServiceCenter.setId(id);
		retailStoreCityServiceCenter.setVersion(version);
		return retailStoreCityServiceCenter;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreCityServiceCenterList(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
			String retailStoreCityServiceCenterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		for(String retailStoreCityServiceCenterId: retailStoreCityServiceCenterIds){
			userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
		
	}
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenterList(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
			String retailStoreCityServiceCenterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreCityServiceCenterList(userContext, retailStoreProvinceCenterId,  retailStoreCityServiceCenterIds, tokensExpr);
			
			
			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
			synchronized(retailStoreProvinceCenter){ 
				//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().planToRemoveRetailStoreCityServiceCenterList(retailStoreProvinceCenter, retailStoreCityServiceCenterIds, allTokens());
				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
				deleteRelationListInGraph(userContext, retailStoreProvinceCenter.getRetailStoreCityServiceCenterList());
				return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		userContext.getChecker().checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion,tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			deleteRelationInGraph(userContext, retailStoreCityServiceCenter);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		userContext.getChecker().checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	public  RetailStoreProvinceCenter copyRetailStoreCityServiceCenterFrom(RetailscmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion,tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
			
			retailStoreProvinceCenter.copyRetailStoreCityServiceCenterFrom( retailStoreCityServiceCenter );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			
			userContext.getManagerGroup().getRetailStoreCityServiceCenterManager().onNewInstanceCreated(userContext, (RetailStoreCityServiceCenter)retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		userContext.getChecker().checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);
		

		if(RetailStoreCityServiceCenter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreCityServiceCenter(parseString(newValueExpr));
		}
		
		if(RetailStoreCityServiceCenter.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfRetailStoreCityServiceCenter(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
	
	}
	
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreCityServiceCenter(userContext, retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreCityServiceCenterList().searchRetailStoreCityServiceCenterListWith(RetailStoreCityServiceCenter.ID_PROPERTY, "eq", retailStoreCityServiceCenterId).done();
		
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);
		
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter );	
			//make changes to AcceleraterAccount.
			RetailStoreCityServiceCenter retailStoreCityServiceCenterIndex = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		
			RetailStoreCityServiceCenter retailStoreCityServiceCenter = retailStoreProvinceCenter.findTheRetailStoreCityServiceCenter(retailStoreCityServiceCenterIndex);
			if(retailStoreCityServiceCenter == null){
				throw new RetailStoreProvinceCenterManagerException(retailStoreCityServiceCenter+" is NOT FOUND" );
			}
			
			retailStoreCityServiceCenter.changeProperty(property, newValueExpr);
			retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreProvinceCenter newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


