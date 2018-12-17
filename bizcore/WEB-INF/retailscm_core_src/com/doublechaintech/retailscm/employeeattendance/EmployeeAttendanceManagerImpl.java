
package com.doublechaintech.retailscm.employeeattendance;

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







public class EmployeeAttendanceManagerImpl extends CustomRetailscmCheckerManager implements EmployeeAttendanceManager {
	
	private static final String SERVICE_TYPE = "EmployeeAttendance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeAttendanceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeAttendanceManagerException(message);

	}
	
	

 	protected EmployeeAttendance saveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, String [] tokensExpr) throws Exception{	
 		//return getEmployeeAttendanceDAO().save(employeeAttendance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeAttendance(userContext, employeeAttendance, tokens);
 	}
 	
 	protected EmployeeAttendance saveEmployeeAttendanceDetail(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance) throws Exception{	

 		
 		return saveEmployeeAttendance(userContext, employeeAttendance, allTokens());
 	}
 	
 	public EmployeeAttendance loadEmployeeAttendance(RetailscmUserContext userContext, String employeeAttendanceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeAttendanceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAttendance, tokens);
 	}
 	
 	
 	 public EmployeeAttendance searchEmployeeAttendance(RetailscmUserContext userContext, String employeeAttendanceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeAttendanceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAttendance, tokens);
 	}
 	
 	

 	protected EmployeeAttendance present(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeAttendance,tokens);
		
		
		EmployeeAttendance  employeeAttendanceToPresent = userContext.getDAOGroup().getEmployeeAttendanceDAO().present(employeeAttendance, tokens);
		
		List<BaseEntity> entityListToNaming = employeeAttendanceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeAttendanceDAO().alias(entityListToNaming);
		
		return  employeeAttendanceToPresent;
		
		
	}
 
 	
 	
 	public EmployeeAttendance loadEmployeeAttendanceDetail(RetailscmUserContext userContext, String employeeAttendanceId) throws Exception{	
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, allTokens());
 		return present(userContext,employeeAttendance, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeAttendanceId) throws Exception{	
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, viewTokens());
 		return present(userContext,employeeAttendance, allTokens());
		
 	}
 	protected EmployeeAttendance saveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeAttendanceDAO().save(employeeAttendance, tokens);
 	}
 	protected EmployeeAttendance loadEmployeeAttendance(RetailscmUserContext userContext, String employeeAttendanceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeAttendanceManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeAttendanceDAO().load(employeeAttendanceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens){
		super.addActions(userContext, employeeAttendance, tokens);
		
		addAction(userContext, employeeAttendance, tokens,"@create","createEmployeeAttendance","createEmployeeAttendance/","main","primary");
		addAction(userContext, employeeAttendance, tokens,"@update","updateEmployeeAttendance","updateEmployeeAttendance/"+employeeAttendance.getId()+"/","main","primary");
		addAction(userContext, employeeAttendance, tokens,"@copy","cloneEmployeeAttendance","cloneEmployeeAttendance/"+employeeAttendance.getId()+"/","main","primary");
		
		addAction(userContext, employeeAttendance, tokens,"employee_attendance.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeAttendance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeAttendance createEmployeeAttendance(RetailscmUserContext userContext,String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkEnterTimeOfEmployeeAttendance(enterTime);
		userContext.getChecker().checkLeaveTimeOfEmployeeAttendance(leaveTime);
		userContext.getChecker().checkDurationHoursOfEmployeeAttendance(durationHours);
		userContext.getChecker().checkRemarkOfEmployeeAttendance(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeAttendanceManagerException.class);


		EmployeeAttendance employeeAttendance=createNewEmployeeAttendance();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeAttendance.setEmployee(employee);
		
		
		employeeAttendance.setEnterTime(enterTime);
		employeeAttendance.setLeaveTime(leaveTime);
		employeeAttendance.setDurationHours(durationHours);
		employeeAttendance.setRemark(remark);

		employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeAttendance);
		return employeeAttendance;

		
	}
	protected EmployeeAttendance createNewEmployeeAttendance() 
	{
		
		return new EmployeeAttendance();		
	}
	
	protected void checkParamsForUpdatingEmployeeAttendance(RetailscmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().checkVersionOfEmployeeAttendance( employeeAttendanceVersion);
		
		

		
		if(EmployeeAttendance.ENTER_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkEnterTimeOfEmployeeAttendance(parseDate(newValueExpr));
		}
		if(EmployeeAttendance.LEAVE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLeaveTimeOfEmployeeAttendance(parseDate(newValueExpr));
		}
		if(EmployeeAttendance.DURATION_HOURS_PROPERTY.equals(property)){
			userContext.getChecker().checkDurationHoursOfEmployeeAttendance(parseInt(newValueExpr));
		}
		if(EmployeeAttendance.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeAttendance(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeAttendanceManagerException.class);
	
		
	}
	
	
	
	public EmployeeAttendance clone(RetailscmUserContext userContext, String fromEmployeeAttendanceId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeAttendanceDAO().clone(fromEmployeeAttendanceId, this.allTokens());
	}
	
	public EmployeeAttendance internalSaveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance) throws Exception 
	{
		return internalSaveEmployeeAttendance(userContext, employeeAttendance, allTokens());

	}
	public EmployeeAttendance internalSaveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeAttendance){ 
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.
			
			
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, options);
			return employeeAttendance;
			
		}

	}
	
	public EmployeeAttendance updateEmployeeAttendance(RetailscmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());
		if(employeeAttendance.getVersion() != employeeAttendanceVersion){
			String message = "The target version("+employeeAttendance.getVersion()+") is not equals to version("+employeeAttendanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAttendance){ 
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.
			
			employeeAttendance.changeProperty(property, newValueExpr);
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
			return present(userContext,employeeAttendance, mergedAllTokens(tokensExpr));
			//return saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
		}

	}
	
	public EmployeeAttendance updateEmployeeAttendanceProperty(RetailscmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);
		
		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());
		if(employeeAttendance.getVersion() != employeeAttendanceVersion){
			String message = "The target version("+employeeAttendance.getVersion()+") is not equals to version("+employeeAttendanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAttendance){ 
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.
			
			employeeAttendance.changeProperty(property, newValueExpr);
			
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
			return present(userContext,employeeAttendance, mergedAllTokens(tokensExpr));
			//return saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeAttendanceTokens tokens(){
		return EmployeeAttendanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeAttendanceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeAttendanceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeAttendanceManagerException.class);
 		
 	}
 	public EmployeeAttendance transferToAnotherEmployee(RetailscmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeAttendanceId,anotherEmployeeId);
 
		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());	
		synchronized(employeeAttendance){
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeAttendance.updateEmployee(employee);		
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, emptyOptions());
			
			return present(userContext,employeeAttendance, allTokens());
			
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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeAttendance(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String employeeAttendanceId, int employeeAttendanceVersion) throws Exception {
		//deleteInternal(userContext, employeeAttendanceId, employeeAttendanceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeAttendanceId, int employeeAttendanceVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeAttendanceDAO().delete(employeeAttendanceId, employeeAttendanceVersion);
	}
	
	public EmployeeAttendance forgetByAll(RetailscmUserContext userContext, String employeeAttendanceId, int employeeAttendanceVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeAttendanceId, employeeAttendanceVersion);		
	}
	protected EmployeeAttendance forgetByAllInternal(RetailscmUserContext userContext,
			String employeeAttendanceId, int employeeAttendanceVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeAttendanceDAO().disconnectFromAll(employeeAttendanceId, employeeAttendanceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeAttendanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeAttendanceDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeAttendance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


