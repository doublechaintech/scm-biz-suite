
package com.doublechaintech.retailscm.provincecenterdepartment;

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

import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.doublechaintech.retailscm.retailstoreprovincecenter.CandidateRetailStoreProvinceCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;






public class ProvinceCenterDepartmentManagerImpl extends CustomRetailscmCheckerManager implements ProvinceCenterDepartmentManager {
	
	private static final String SERVICE_TYPE = "ProvinceCenterDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProvinceCenterDepartmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProvinceCenterDepartmentManagerException(message);

	}
	
	

 	protected ProvinceCenterDepartment saveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, String [] tokensExpr) throws Exception{	
 		//return getProvinceCenterDepartmentDAO().save(provinceCenterDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens);
 	}
 	
 	protected ProvinceCenterDepartment saveProvinceCenterDepartmentDetail(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception{	

 		
 		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());
 	}
 	
 	public ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ProvinceCenterDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterDepartment, tokens);
 	}
 	
 	
 	 public ProvinceCenterDepartment searchProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ProvinceCenterDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterDepartment, tokens);
 	}
 	
 	

 	protected ProvinceCenterDepartment present(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,provinceCenterDepartment,tokens);
		
		
		ProvinceCenterDepartment  provinceCenterDepartmentToPresent = userContext.getDAOGroup().getProvinceCenterDepartmentDAO().present(provinceCenterDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = provinceCenterDepartmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProvinceCenterDepartmentDAO().alias(entityListToNaming);
		
		return  provinceCenterDepartmentToPresent;
		
		
	}
 
 	
 	
 	public ProvinceCenterDepartment loadProvinceCenterDepartmentDetail(RetailscmUserContext userContext, String provinceCenterDepartmentId) throws Exception{	
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, allTokens());
 		return present(userContext,provinceCenterDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String provinceCenterDepartmentId) throws Exception{	
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, viewTokens());
 		return present(userContext,provinceCenterDepartment, allTokens());
		
 	}
 	protected ProvinceCenterDepartment saveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().save(provinceCenterDepartment, tokens);
 	}
 	protected ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ProvinceCenterDepartmentManagerException.class);

 
 		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().load(provinceCenterDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){
		super.addActions(userContext, provinceCenterDepartment, tokens);
		
		addAction(userContext, provinceCenterDepartment, tokens,"@create","createProvinceCenterDepartment","createProvinceCenterDepartment/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"@update","updateProvinceCenterDepartment","updateProvinceCenterDepartment/"+provinceCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"@copy","cloneProvinceCenterDepartment","cloneProvinceCenterDepartment/"+provinceCenterDepartment.getId()+"/","main","primary");
		
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.transfer_to_province_center","transferToAnotherProvinceCenter","transferToAnotherProvinceCenter/"+provinceCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.addProvinceCenterEmployee","addProvinceCenterEmployee","addProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.removeProvinceCenterEmployee","removeProvinceCenterEmployee","removeProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.updateProvinceCenterEmployee","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProvinceCenterDepartment createProvinceCenterDepartment(RetailscmUserContext userContext,String name, Date founded, String provinceCenterId, String manager) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProvinceCenterDepartment(name);
		userContext.getChecker().checkFoundedOfProvinceCenterDepartment(founded);
		userContext.getChecker().checkManagerOfProvinceCenterDepartment(manager);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);


		ProvinceCenterDepartment provinceCenterDepartment=createNewProvinceCenterDepartment();	

		provinceCenterDepartment.setName(name);
		provinceCenterDepartment.setFounded(founded);
			
		RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, provinceCenterId,emptyOptions());
		provinceCenterDepartment.setProvinceCenter(provinceCenter);
		
		
		provinceCenterDepartment.setManager(manager);

		provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, provinceCenterDepartment);
		return provinceCenterDepartment;

		
	}
	protected ProvinceCenterDepartment createNewProvinceCenterDepartment() 
	{
		
		return new ProvinceCenterDepartment();		
	}
	
	protected void checkParamsForUpdatingProvinceCenterDepartment(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().checkVersionOfProvinceCenterDepartment( provinceCenterDepartmentVersion);
		

		if(ProvinceCenterDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProvinceCenterDepartment(parseString(newValueExpr));
		}
		if(ProvinceCenterDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfProvinceCenterDepartment(parseDate(newValueExpr));
		}		

		
		if(ProvinceCenterDepartment.MANAGER_PROPERTY.equals(property)){
			userContext.getChecker().checkManagerOfProvinceCenterDepartment(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
	
		
	}
	
	
	
	public ProvinceCenterDepartment clone(RetailscmUserContext userContext, String fromProvinceCenterDepartmentId) throws Exception{
		
		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().clone(fromProvinceCenterDepartmentId, this.allTokens());
	}
	
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception 
	{
		return internalSaveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());

	}
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(provinceCenterDepartment){ 
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.
			
			
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, options);
			return provinceCenterDepartment;
			
		}

	}
	
	public ProvinceCenterDepartment updateProvinceCenterDepartment(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		if(provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion){
			String message = "The target version("+provinceCenterDepartment.getVersion()+") is not equals to version("+provinceCenterDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterDepartment){ 
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.
			
			provinceCenterDepartment.changeProperty(property, newValueExpr);
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
		}

	}
	
	public ProvinceCenterDepartment updateProvinceCenterDepartmentProperty(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		if(provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion){
			String message = "The target version("+provinceCenterDepartment.getVersion()+") is not equals to version("+provinceCenterDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterDepartment){ 
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.
			
			provinceCenterDepartment.changeProperty(property, newValueExpr);
			
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProvinceCenterDepartmentTokens tokens(){
		return ProvinceCenterDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProvinceCenterDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProvinceCenterEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProvinceCenterDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
 		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(anotherProvinceCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
 		
 	}
 	public ProvinceCenterDepartment transferToAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvinceCenter(userContext, provinceCenterDepartmentId,anotherProvinceCenterId);
 
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());	
		synchronized(provinceCenterDepartment){
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, anotherProvinceCenterId, emptyOptions());		
			provinceCenterDepartment.updateProvinceCenter(provinceCenter);		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());
			
			return present(userContext,provinceCenterDepartment, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreProvinceCenter requestCandidateProvinceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreProvinceCenter result = new CandidateRetailStoreProvinceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreProvinceCenter> candidateList = userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().requestCandidateRetailStoreProvinceCenterForProvinceCenterDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailscmUserContext userContext, String newProvinceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().load(newProvinceCenterId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception {
		//deleteInternal(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception{
			
		userContext.getDAOGroup().getProvinceCenterDepartmentDAO().delete(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}
	
	public ProvinceCenterDepartment forgetByAll(RetailscmUserContext userContext, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion);		
	}
	protected ProvinceCenterDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().disconnectFromAll(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProvinceCenterDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().deleteAll();
	}


	//disconnect ProvinceCenterDepartment with province_center in ProvinceCenterEmployee
	protected ProvinceCenterDepartment breakWithProvinceCenterEmployeeByProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());

			synchronized(provinceCenterDepartment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProvinceCenterDepartmentDAO().planToRemoveProvinceCenterEmployeeListWithProvinceCenter(provinceCenterDepartment, provinceCenterId, this.emptyOptions());

				provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
				return provinceCenterDepartment;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);

		
		userContext.getChecker().checkNameOfProvinceCenterEmployee(name);
		
		userContext.getChecker().checkMobileOfProvinceCenterEmployee(mobile);
		
		userContext.getChecker().checkEmailOfProvinceCenterEmployee(email);
		
		userContext.getChecker().checkFoundedOfProvinceCenterEmployee(founded);
		
		userContext.getChecker().checkProvinceCenterIdOfProvinceCenterEmployee(provinceCenterId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

	
	}
	public  ProvinceCenterDepartment addProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProvinceCenterEmployee(userContext,provinceCenterDepartmentId,name, mobile, email, founded, provinceCenterId,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createProvinceCenterEmployee(userContext,name, mobile, email, founded, provinceCenterId);
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.addProvinceCenterEmployee( provinceCenterEmployee );		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, provinceCenterEmployee);
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceCenterEmployeeProperties(RetailscmUserContext userContext, String provinceCenterDepartmentId,String id,String name,String mobile,String email,Date founded,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(id);
		
		userContext.getChecker().checkNameOfProvinceCenterEmployee( name);
		userContext.getChecker().checkMobileOfProvinceCenterEmployee( mobile);
		userContext.getChecker().checkEmailOfProvinceCenterEmployee( email);
		userContext.getChecker().checkFoundedOfProvinceCenterEmployee( founded);

		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
		
	}
	public  ProvinceCenterDepartment updateProvinceCenterEmployeeProperties(RetailscmUserContext userContext, String provinceCenterDepartmentId, String id,String name,String mobile,String email,Date founded, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProvinceCenterEmployeeProperties(userContext,provinceCenterDepartmentId,id,name,mobile,email,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceCenterEmployeeListList()
				.searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "is", id).done();
		
		ProvinceCenterDepartment provinceCenterDepartmentToUpdate = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, options);
		
		if(provinceCenterDepartmentToUpdate.getProvinceCenterEmployeeList().isEmpty()){
			throw new ProvinceCenterDepartmentManagerException("ProvinceCenterEmployee is NOT FOUND with id: '"+id+"'");
		}
		
		ProvinceCenterEmployee item = provinceCenterDepartmentToUpdate.getProvinceCenterEmployeeList().first();
		
		item.updateName( name );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updateFounded( founded );

		
		//checkParamsForAddingProvinceCenterEmployee(userContext,provinceCenterDepartmentId,name, code, used,tokensExpr);
		ProvinceCenterDepartment provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartmentToUpdate, tokens().withProvinceCenterEmployeeList().done());
		synchronized(provinceCenterDepartment){ 
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext, String name, String mobile, String email, Date founded, String provinceCenterId) throws Exception{

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		
		
		provinceCenterEmployee.setName(name);		
		provinceCenterEmployee.setMobile(mobile);		
		provinceCenterEmployee.setEmail(email);		
		provinceCenterEmployee.setFounded(founded);		
		RetailStoreProvinceCenter  provinceCenter = new RetailStoreProvinceCenter();
		provinceCenter.setId(provinceCenterId);		
		provinceCenterEmployee.setProvinceCenter(provinceCenter);
	
		
		return provinceCenterEmployee;
	
		
	}
	
	protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version){

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(version);
		return provinceCenterEmployee;			
		
	}
	
	protected void checkParamsForRemovingProvinceCenterEmployeeList(RetailscmUserContext userContext, String provinceCenterDepartmentId, 
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		for(String provinceCenterEmployeeId: provinceCenterEmployeeIds){
			userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
		
	}
	public  ProvinceCenterDepartment removeProvinceCenterEmployeeList(RetailscmUserContext userContext, String provinceCenterDepartmentId, 
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProvinceCenterEmployeeList(userContext, provinceCenterDepartmentId,  provinceCenterEmployeeIds, tokensExpr);
			
			
			ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
			synchronized(provinceCenterDepartment){ 
				//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProvinceCenterDepartmentDAO().planToRemoveProvinceCenterEmployeeList(provinceCenterDepartment, provinceCenterEmployeeIds, allTokens());
				provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
				deleteRelationListInGraph(userContext, provinceCenterDepartment.getProvinceCenterEmployeeList());
				return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProvinceCenterDepartment( provinceCenterDepartmentId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
	
	}
	public  ProvinceCenterDepartment removeProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProvinceCenterEmployee(userContext,provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			deleteRelationInGraph(userContext, provinceCenterEmployee);
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProvinceCenterDepartment( provinceCenterDepartmentId);
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
	
	}
	public  ProvinceCenterDepartment copyProvinceCenterEmployeeFrom(RetailscmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProvinceCenterEmployee(userContext,provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			provinceCenterDepartment.copyProvinceCenterEmployeeFrom( provinceCenterEmployee );		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, (ProvinceCenterEmployee)provinceCenterDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
	
	}
	
	public  ProvinceCenterDepartment updateProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProvinceCenterEmployeeList().searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "eq", provinceCenterEmployeeId).done();
		
		
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, loadTokens);
		
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );	
			//make changes to AcceleraterAccount.
			ProvinceCenterEmployee provinceCenterEmployeeIndex = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		
			ProvinceCenterEmployee provinceCenterEmployee = provinceCenterDepartment.findTheProvinceCenterEmployee(provinceCenterEmployeeIndex);
			if(provinceCenterEmployee == null){
				throw new ProvinceCenterDepartmentManagerException(provinceCenterEmployee+" is NOT FOUND" );
			}
			
			provinceCenterEmployee.changeProperty(property, newValueExpr);
			
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, ProvinceCenterDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


