
package com.doublechaintech.retailscm.employeeeducation;

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

import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.CandidateEmployee;







public class EmployeeEducationManagerImpl extends CustomRetailscmCheckerManager implements EmployeeEducationManager {
	
	private static final String SERVICE_TYPE = "EmployeeEducation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeEducationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeEducationManagerException(message);

	}
	
	

 	protected EmployeeEducation saveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation, String [] tokensExpr) throws Exception{	
 		//return getEmployeeEducationDAO().save(employeeEducation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeEducation(userContext, employeeEducation, tokens);
 	}
 	
 	protected EmployeeEducation saveEmployeeEducationDetail(RetailscmUserContext userContext, EmployeeEducation employeeEducation) throws Exception{	

 		
 		return saveEmployeeEducation(userContext, employeeEducation, allTokens());
 	}
 	
 	public EmployeeEducation loadEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeEducationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeEducation, tokens);
 	}
 	
 	
 	 public EmployeeEducation searchEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeEducationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeEducation, tokens);
 	}
 	
 	

 	protected EmployeeEducation present(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeEducation,tokens);
		
		
		EmployeeEducation  employeeEducationToPresent = userContext.getDAOGroup().getEmployeeEducationDAO().present(employeeEducation, tokens);
		
		List<BaseEntity> entityListToNaming = employeeEducationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeEducationDAO().alias(entityListToNaming);
		
		return  employeeEducationToPresent;
		
		
	}
 
 	
 	
 	public EmployeeEducation loadEmployeeEducationDetail(RetailscmUserContext userContext, String employeeEducationId) throws Exception{	
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, allTokens());
 		return present(userContext,employeeEducation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeEducationId) throws Exception{	
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, viewTokens());
 		return present(userContext,employeeEducation, allTokens());
		
 	}
 	protected EmployeeEducation saveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeEducationDAO().save(employeeEducation, tokens);
 	}
 	protected EmployeeEducation loadEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeEducationManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeEducationDAO().load(employeeEducationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens){
		super.addActions(userContext, employeeEducation, tokens);
		
		addAction(userContext, employeeEducation, tokens,"@create","createEmployeeEducation","createEmployeeEducation/","main","primary");
		addAction(userContext, employeeEducation, tokens,"@update","updateEmployeeEducation","updateEmployeeEducation/"+employeeEducation.getId()+"/","main","primary");
		addAction(userContext, employeeEducation, tokens,"@copy","cloneEmployeeEducation","cloneEmployeeEducation/"+employeeEducation.getId()+"/","main","primary");
		
		addAction(userContext, employeeEducation, tokens,"employee_education.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeEducation.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeEducation createEmployeeEducation(RetailscmUserContext userContext,String employeeId, Date completeTime, String type, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkCompleteTimeOfEmployeeEducation(completeTime);
		userContext.getChecker().checkTypeOfEmployeeEducation(type);
		userContext.getChecker().checkRemarkOfEmployeeEducation(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeEducationManagerException.class);


		EmployeeEducation employeeEducation=createNewEmployeeEducation();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeEducation.setEmployee(employee);
		
		
		employeeEducation.setCompleteTime(completeTime);
		employeeEducation.setType(type);
		employeeEducation.setRemark(remark);

		employeeEducation = saveEmployeeEducation(userContext, employeeEducation, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeEducation);
		return employeeEducation;

		
	}
	protected EmployeeEducation createNewEmployeeEducation() 
	{
		
		return new EmployeeEducation();		
	}
	
	protected void checkParamsForUpdatingEmployeeEducation(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().checkVersionOfEmployeeEducation( employeeEducationVersion);
		
		

		
		if(EmployeeEducation.COMPLETE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCompleteTimeOfEmployeeEducation(parseDate(newValueExpr));
		}
		if(EmployeeEducation.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfEmployeeEducation(parseString(newValueExpr));
		}
		if(EmployeeEducation.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeEducation(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeEducationManagerException.class);
	
		
	}
	
	
	
	public EmployeeEducation clone(RetailscmUserContext userContext, String fromEmployeeEducationId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeEducationDAO().clone(fromEmployeeEducationId, this.allTokens());
	}
	
	public EmployeeEducation internalSaveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation) throws Exception 
	{
		return internalSaveEmployeeEducation(userContext, employeeEducation, allTokens());

	}
	public EmployeeEducation internalSaveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeEducation){ 
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.
			
			
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, options);
			return employeeEducation;
			
		}

	}
	
	public EmployeeEducation updateEmployeeEducation(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());
		if(employeeEducation.getVersion() != employeeEducationVersion){
			String message = "The target version("+employeeEducation.getVersion()+") is not equals to version("+employeeEducationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeEducation){ 
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.
			
			employeeEducation.changeProperty(property, newValueExpr);
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, tokens().done());
			return present(userContext,employeeEducation, mergedAllTokens(tokensExpr));
			//return saveEmployeeEducation(userContext, employeeEducation, tokens().done());
		}

	}
	
	public EmployeeEducation updateEmployeeEducationProperty(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);
		
		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());
		if(employeeEducation.getVersion() != employeeEducationVersion){
			String message = "The target version("+employeeEducation.getVersion()+") is not equals to version("+employeeEducationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeEducation){ 
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.
			
			employeeEducation.changeProperty(property, newValueExpr);
			
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, tokens().done());
			return present(userContext,employeeEducation, mergedAllTokens(tokensExpr));
			//return saveEmployeeEducation(userContext, employeeEducation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeEducationTokens tokens(){
		return EmployeeEducationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeEducationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeEducationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeEducationId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeEducationManagerException.class);
 		
 	}
 	public EmployeeEducation transferToAnotherEmployee(RetailscmUserContext userContext, String employeeEducationId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeEducationId,anotherEmployeeId);
 
		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());	
		synchronized(employeeEducation){
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeEducation.updateEmployee(employee);		
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, emptyOptions());
			
			return present(userContext,employeeEducation, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateEmployee requestCandidateEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateEmployee result = new CandidateEmployee();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("company");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeEducation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newEmployeeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeEducationId, int employeeEducationVersion) throws Exception {
		//deleteInternal(userContext, employeeEducationId, employeeEducationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeEducationId, int employeeEducationVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeEducationDAO().delete(employeeEducationId, employeeEducationVersion);
	}
	
	public EmployeeEducation forgetByAll(RetailscmUserContext userContext, String employeeEducationId, int employeeEducationVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeEducationId, employeeEducationVersion);		
	}
	protected EmployeeEducation forgetByAllInternal(RetailscmUserContext userContext,
			String employeeEducationId, int employeeEducationVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeEducationDAO().disconnectFromAll(employeeEducationId, employeeEducationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeEducationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeEducationDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeEducation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


