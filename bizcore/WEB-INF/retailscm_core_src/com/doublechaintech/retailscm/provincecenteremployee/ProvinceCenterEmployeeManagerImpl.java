
package com.doublechaintech.retailscm.provincecenteremployee;

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

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.CandidateProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.CandidateRetailStoreProvinceCenter;







public class ProvinceCenterEmployeeManagerImpl extends CustomRetailscmCheckerManager implements ProvinceCenterEmployeeManager {
	
	private static final String SERVICE_TYPE = "ProvinceCenterEmployee";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProvinceCenterEmployeeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProvinceCenterEmployeeManagerException(message);

	}
	
	

 	protected ProvinceCenterEmployee saveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, String [] tokensExpr) throws Exception{	
 		//return getProvinceCenterEmployeeDAO().save(provinceCenterEmployee, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens);
 	}
 	
 	protected ProvinceCenterEmployee saveProvinceCenterEmployeeDetail(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception{	

 		
 		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());
 	}
 	
 	public ProvinceCenterEmployee loadProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().throwExceptionIfHasErrors( ProvinceCenterEmployeeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterEmployee, tokens);
 	}
 	
 	
 	 public ProvinceCenterEmployee searchProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().throwExceptionIfHasErrors( ProvinceCenterEmployeeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterEmployee, tokens);
 	}
 	
 	

 	protected ProvinceCenterEmployee present(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,provinceCenterEmployee,tokens);
		
		
		ProvinceCenterEmployee  provinceCenterEmployeeToPresent = userContext.getDAOGroup().getProvinceCenterEmployeeDAO().present(provinceCenterEmployee, tokens);
		
		List<BaseEntity> entityListToNaming = provinceCenterEmployeeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProvinceCenterEmployeeDAO().alias(entityListToNaming);
		
		return  provinceCenterEmployeeToPresent;
		
		
	}
 
 	
 	
 	public ProvinceCenterEmployee loadProvinceCenterEmployeeDetail(RetailscmUserContext userContext, String provinceCenterEmployeeId) throws Exception{	
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, allTokens());
 		return present(userContext,provinceCenterEmployee, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String provinceCenterEmployeeId) throws Exception{	
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, viewTokens());
 		return present(userContext,provinceCenterEmployee, allTokens());
		
 	}
 	protected ProvinceCenterEmployee saveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO().save(provinceCenterEmployee, tokens);
 	}
 	protected ProvinceCenterEmployee loadProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().throwExceptionIfHasErrors( ProvinceCenterEmployeeManagerException.class);

 
 		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO().load(provinceCenterEmployeeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){
		super.addActions(userContext, provinceCenterEmployee, tokens);
		
		addAction(userContext, provinceCenterEmployee, tokens,"@create","createProvinceCenterEmployee","createProvinceCenterEmployee/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"@update","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+provinceCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"@copy","cloneProvinceCenterEmployee","cloneProvinceCenterEmployee/"+provinceCenterEmployee.getId()+"/","main","primary");
		
		addAction(userContext, provinceCenterEmployee, tokens,"province_center_employee.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+provinceCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"province_center_employee.transfer_to_province_center","transferToAnotherProvinceCenter","transferToAnotherProvinceCenter/"+provinceCenterEmployee.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext,String name, String mobile, String email, Date founded, String departmentId, String provinceCenterId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProvinceCenterEmployee(name);
		userContext.getChecker().checkMobileOfProvinceCenterEmployee(mobile);
		userContext.getChecker().checkEmailOfProvinceCenterEmployee(email);
		userContext.getChecker().checkFoundedOfProvinceCenterEmployee(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);


		ProvinceCenterEmployee provinceCenterEmployee=createNewProvinceCenterEmployee();	

		provinceCenterEmployee.setName(name);
		provinceCenterEmployee.setMobile(mobile);
		provinceCenterEmployee.setEmail(email);
		provinceCenterEmployee.setFounded(founded);
			
		ProvinceCenterDepartment department = loadProvinceCenterDepartment(userContext, departmentId,emptyOptions());
		provinceCenterEmployee.setDepartment(department);
		
		
			
		RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, provinceCenterId,emptyOptions());
		provinceCenterEmployee.setProvinceCenter(provinceCenter);
		
		

		provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
		
		onNewInstanceCreated(userContext, provinceCenterEmployee);
		return provinceCenterEmployee;

		
	}
	protected ProvinceCenterEmployee createNewProvinceCenterEmployee() 
	{
		
		return new ProvinceCenterEmployee();		
	}
	
	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		userContext.getChecker().checkVersionOfProvinceCenterEmployee( provinceCenterEmployeeVersion);
		

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

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);
	
		
	}
	
	
	
	public ProvinceCenterEmployee clone(RetailscmUserContext userContext, String fromProvinceCenterEmployeeId) throws Exception{
		
		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO().clone(fromProvinceCenterEmployeeId, this.allTokens());
	}
	
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception 
	{
		return internalSaveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());

	}
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(provinceCenterEmployee){ 
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.
			
			
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, options);
			return provinceCenterEmployee;
			
		}

	}
	
	public ProvinceCenterEmployee updateProvinceCenterEmployee(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);
		
		
		
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
		if(provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion){
			String message = "The target version("+provinceCenterEmployee.getVersion()+") is not equals to version("+provinceCenterEmployeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterEmployee){ 
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.
			
			provinceCenterEmployee.changeProperty(property, newValueExpr);
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
			return present(userContext,provinceCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
		}

	}
	
	public ProvinceCenterEmployee updateProvinceCenterEmployeeProperty(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
		if(provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion){
			String message = "The target version("+provinceCenterEmployee.getVersion()+") is not equals to version("+provinceCenterEmployeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterEmployee){ 
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.
			
			provinceCenterEmployee.changeProperty(property, newValueExpr);
			
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
			return present(userContext,provinceCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProvinceCenterEmployeeTokens tokens(){
		return ProvinceCenterEmployeeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProvinceCenterEmployeeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProvinceCenterEmployeeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDepartment(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
 		userContext.getChecker().checkIdOfProvinceCenterDepartment(anotherDepartmentId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);
 		
 	}
 	public ProvinceCenterEmployee transferToAnotherDepartment(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, provinceCenterEmployeeId,anotherDepartmentId);
 
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());	
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ProvinceCenterDepartment department = loadProvinceCenterDepartment(userContext, anotherDepartmentId, emptyOptions());		
			provinceCenterEmployee.updateDepartment(department);		
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
			
			return present(userContext,provinceCenterEmployee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProvinceCenterDepartment requestCandidateDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProvinceCenterDepartment result = new CandidateProvinceCenterDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ProvinceCenterDepartment> candidateList = userContext.getDAOGroup().getProvinceCenterDepartmentDAO().requestCandidateProvinceCenterDepartmentForProvinceCenterEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
 		userContext.getChecker().checkIdOfRetailStoreProvinceCenter(anotherProvinceCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);
 		
 	}
 	public ProvinceCenterEmployee transferToAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvinceCenter(userContext, provinceCenterEmployeeId,anotherProvinceCenterId);
 
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());	
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, anotherProvinceCenterId, emptyOptions());		
			provinceCenterEmployee.updateProvinceCenter(provinceCenter);		
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
			
			return present(userContext,provinceCenterEmployee, allTokens());
			
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
		SmartList<RetailStoreProvinceCenter> candidateList = userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().requestCandidateRetailStoreProvinceCenterForProvinceCenterEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().load(newDepartmentId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception {
		//deleteInternal(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception{
			
		userContext.getDAOGroup().getProvinceCenterEmployeeDAO().delete(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}
	
	public ProvinceCenterEmployee forgetByAll(RetailscmUserContext userContext, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception {
		return forgetByAllInternal(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion);		
	}
	protected ProvinceCenterEmployee forgetByAllInternal(RetailscmUserContext userContext,
			String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception{
			
		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO().disconnectFromAll(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProvinceCenterEmployeeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ProvinceCenterEmployee newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


