
package com.doublechaintech.retailscm.employeeleave;

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
import com.doublechaintech.retailscm.leavetype.LeaveType;

import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.leavetype.CandidateLeaveType;







public class EmployeeLeaveManagerImpl extends CustomRetailscmCheckerManager implements EmployeeLeaveManager {
	
	private static final String SERVICE_TYPE = "EmployeeLeave";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeLeaveManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeLeaveManagerException(message);

	}
	
	

 	protected EmployeeLeave saveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave, String [] tokensExpr) throws Exception{	
 		//return getEmployeeLeaveDAO().save(employeeLeave, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeLeave(userContext, employeeLeave, tokens);
 	}
 	
 	protected EmployeeLeave saveEmployeeLeaveDetail(RetailscmUserContext userContext, EmployeeLeave employeeLeave) throws Exception{	

 		
 		return saveEmployeeLeave(userContext, employeeLeave, allTokens());
 	}
 	
 	public EmployeeLeave loadEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeLeaveManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeLeave, tokens);
 	}
 	
 	
 	 public EmployeeLeave searchEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeLeaveManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeLeave, tokens);
 	}
 	
 	

 	protected EmployeeLeave present(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeLeave,tokens);
		
		
		EmployeeLeave  employeeLeaveToPresent = userContext.getDAOGroup().getEmployeeLeaveDAO().present(employeeLeave, tokens);
		
		List<BaseEntity> entityListToNaming = employeeLeaveToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeLeaveDAO().alias(entityListToNaming);
		
		return  employeeLeaveToPresent;
		
		
	}
 
 	
 	
 	public EmployeeLeave loadEmployeeLeaveDetail(RetailscmUserContext userContext, String employeeLeaveId) throws Exception{	
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, allTokens());
 		return present(userContext,employeeLeave, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeLeaveId) throws Exception{	
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, viewTokens());
 		return present(userContext,employeeLeave, allTokens());
		
 	}
 	protected EmployeeLeave saveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeLeaveDAO().save(employeeLeave, tokens);
 	}
 	protected EmployeeLeave loadEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeLeaveManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeLeaveDAO().load(employeeLeaveId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens){
		super.addActions(userContext, employeeLeave, tokens);
		
		addAction(userContext, employeeLeave, tokens,"@create","createEmployeeLeave","createEmployeeLeave/","main","primary");
		addAction(userContext, employeeLeave, tokens,"@update","updateEmployeeLeave","updateEmployeeLeave/"+employeeLeave.getId()+"/","main","primary");
		addAction(userContext, employeeLeave, tokens,"@copy","cloneEmployeeLeave","cloneEmployeeLeave/"+employeeLeave.getId()+"/","main","primary");
		
		addAction(userContext, employeeLeave, tokens,"employee_leave.transfer_to_who","transferToAnotherWho","transferToAnotherWho/"+employeeLeave.getId()+"/","main","primary");
		addAction(userContext, employeeLeave, tokens,"employee_leave.transfer_to_type","transferToAnotherType","transferToAnotherType/"+employeeLeave.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeLeave createEmployeeLeave(RetailscmUserContext userContext,String whoId, String typeId, int leaveDurationHour, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);
		userContext.getChecker().checkRemarkOfEmployeeLeave(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);


		EmployeeLeave employeeLeave=createNewEmployeeLeave();	

			
		Employee who = loadEmployee(userContext, whoId,emptyOptions());
		employeeLeave.setWho(who);
		
		
			
		LeaveType type = loadLeaveType(userContext, typeId,emptyOptions());
		employeeLeave.setType(type);
		
		
		employeeLeave.setLeaveDurationHour(leaveDurationHour);
		employeeLeave.setRemark(remark);

		employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeLeave);
		return employeeLeave;

		
	}
	protected EmployeeLeave createNewEmployeeLeave() 
	{
		
		return new EmployeeLeave();		
	}
	
	protected void checkParamsForUpdatingEmployeeLeave(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave( employeeLeaveVersion);
		
		

				

		
		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave(parseInt(newValueExpr));
		}
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeLeave(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);
	
		
	}
	
	
	
	public EmployeeLeave clone(RetailscmUserContext userContext, String fromEmployeeLeaveId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeLeaveDAO().clone(fromEmployeeLeaveId, this.allTokens());
	}
	
	public EmployeeLeave internalSaveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave) throws Exception 
	{
		return internalSaveEmployeeLeave(userContext, employeeLeave, allTokens());

	}
	public EmployeeLeave internalSaveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeLeave){ 
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.
			
			
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, options);
			return employeeLeave;
			
		}

	}
	
	public EmployeeLeave updateEmployeeLeave(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());
		if(employeeLeave.getVersion() != employeeLeaveVersion){
			String message = "The target version("+employeeLeave.getVersion()+") is not equals to version("+employeeLeaveVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeLeave){ 
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.
			
			employeeLeave.changeProperty(property, newValueExpr);
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, tokens().done());
			return present(userContext,employeeLeave, mergedAllTokens(tokensExpr));
			//return saveEmployeeLeave(userContext, employeeLeave, tokens().done());
		}

	}
	
	public EmployeeLeave updateEmployeeLeaveProperty(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);
		
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());
		if(employeeLeave.getVersion() != employeeLeaveVersion){
			String message = "The target version("+employeeLeave.getVersion()+") is not equals to version("+employeeLeaveVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeLeave){ 
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.
			
			employeeLeave.changeProperty(property, newValueExpr);
			
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, tokens().done());
			return present(userContext,employeeLeave, mergedAllTokens(tokensExpr));
			//return saveEmployeeLeave(userContext, employeeLeave, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeLeaveTokens tokens(){
		return EmployeeLeaveTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeLeaveTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeLeaveTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWho(RetailscmUserContext userContext, String employeeLeaveId, String anotherWhoId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
 		userContext.getChecker().checkIdOfEmployee(anotherWhoId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);
 		
 	}
 	public EmployeeLeave transferToAnotherWho(RetailscmUserContext userContext, String employeeLeaveId, String anotherWhoId) throws Exception
 	{
 		checkParamsForTransferingAnotherWho(userContext, employeeLeaveId,anotherWhoId);
 
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());	
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee who = loadEmployee(userContext, anotherWhoId, emptyOptions());		
			employeeLeave.updateWho(who);		
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
			
			return present(userContext,employeeLeave, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateEmployee requestCandidateWho(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeLeave(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherType(RetailscmUserContext userContext, String employeeLeaveId, String anotherTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
 		userContext.getChecker().checkIdOfLeaveType(anotherTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);
 		
 	}
 	public EmployeeLeave transferToAnotherType(RetailscmUserContext userContext, String employeeLeaveId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, employeeLeaveId,anotherTypeId);
 
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());	
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveType type = loadLeaveType(userContext, anotherTypeId, emptyOptions());		
			employeeLeave.updateType(type);		
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
			
			return present(userContext,employeeLeave, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLeaveType requestCandidateType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLeaveType result = new CandidateLeaveType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LeaveType> candidateList = userContext.getDAOGroup().getLeaveTypeDAO().requestCandidateLeaveTypeForEmployeeLeave(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LeaveType loadLeaveType(RetailscmUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLeaveTypeDAO().load(newTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newWhoId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newWhoId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeLeaveId, int employeeLeaveVersion) throws Exception {
		//deleteInternal(userContext, employeeLeaveId, employeeLeaveVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeLeaveId, int employeeLeaveVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeLeaveDAO().delete(employeeLeaveId, employeeLeaveVersion);
	}
	
	public EmployeeLeave forgetByAll(RetailscmUserContext userContext, String employeeLeaveId, int employeeLeaveVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeLeaveId, employeeLeaveVersion);		
	}
	protected EmployeeLeave forgetByAllInternal(RetailscmUserContext userContext,
			String employeeLeaveId, int employeeLeaveVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeLeaveDAO().disconnectFromAll(employeeLeaveId, employeeLeaveVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeLeaveManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeLeaveDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeLeave newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


