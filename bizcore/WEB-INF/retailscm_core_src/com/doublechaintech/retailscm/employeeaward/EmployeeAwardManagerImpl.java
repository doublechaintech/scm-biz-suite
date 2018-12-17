
package com.doublechaintech.retailscm.employeeaward;

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







public class EmployeeAwardManagerImpl extends CustomRetailscmCheckerManager implements EmployeeAwardManager {
	
	private static final String SERVICE_TYPE = "EmployeeAward";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeAwardManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeAwardManagerException(message);

	}
	
	

 	protected EmployeeAward saveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward, String [] tokensExpr) throws Exception{	
 		//return getEmployeeAwardDAO().save(employeeAward, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeAward(userContext, employeeAward, tokens);
 	}
 	
 	protected EmployeeAward saveEmployeeAwardDetail(RetailscmUserContext userContext, EmployeeAward employeeAward) throws Exception{	

 		
 		return saveEmployeeAward(userContext, employeeAward, allTokens());
 	}
 	
 	public EmployeeAward loadEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeAwardManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAward, tokens);
 	}
 	
 	
 	 public EmployeeAward searchEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeAwardManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAward, tokens);
 	}
 	
 	

 	protected EmployeeAward present(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeAward,tokens);
		
		
		EmployeeAward  employeeAwardToPresent = userContext.getDAOGroup().getEmployeeAwardDAO().present(employeeAward, tokens);
		
		List<BaseEntity> entityListToNaming = employeeAwardToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeAwardDAO().alias(entityListToNaming);
		
		return  employeeAwardToPresent;
		
		
	}
 
 	
 	
 	public EmployeeAward loadEmployeeAwardDetail(RetailscmUserContext userContext, String employeeAwardId) throws Exception{	
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, allTokens());
 		return present(userContext,employeeAward, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeAwardId) throws Exception{	
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, viewTokens());
 		return present(userContext,employeeAward, allTokens());
		
 	}
 	protected EmployeeAward saveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeAwardDAO().save(employeeAward, tokens);
 	}
 	protected EmployeeAward loadEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeAwardManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeAwardDAO().load(employeeAwardId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens){
		super.addActions(userContext, employeeAward, tokens);
		
		addAction(userContext, employeeAward, tokens,"@create","createEmployeeAward","createEmployeeAward/","main","primary");
		addAction(userContext, employeeAward, tokens,"@update","updateEmployeeAward","updateEmployeeAward/"+employeeAward.getId()+"/","main","primary");
		addAction(userContext, employeeAward, tokens,"@copy","cloneEmployeeAward","cloneEmployeeAward/"+employeeAward.getId()+"/","main","primary");
		
		addAction(userContext, employeeAward, tokens,"employee_award.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeAward.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeAward createEmployeeAward(RetailscmUserContext userContext,String employeeId, Date completeTime, String type, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkCompleteTimeOfEmployeeAward(completeTime);
		userContext.getChecker().checkTypeOfEmployeeAward(type);
		userContext.getChecker().checkRemarkOfEmployeeAward(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeAwardManagerException.class);


		EmployeeAward employeeAward=createNewEmployeeAward();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeAward.setEmployee(employee);
		
		
		employeeAward.setCompleteTime(completeTime);
		employeeAward.setType(type);
		employeeAward.setRemark(remark);

		employeeAward = saveEmployeeAward(userContext, employeeAward, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeAward);
		return employeeAward;

		
	}
	protected EmployeeAward createNewEmployeeAward() 
	{
		
		return new EmployeeAward();		
	}
	
	protected void checkParamsForUpdatingEmployeeAward(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().checkVersionOfEmployeeAward( employeeAwardVersion);
		
		

		
		if(EmployeeAward.COMPLETE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCompleteTimeOfEmployeeAward(parseDate(newValueExpr));
		}
		if(EmployeeAward.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfEmployeeAward(parseString(newValueExpr));
		}
		if(EmployeeAward.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeAward(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeAwardManagerException.class);
	
		
	}
	
	
	
	public EmployeeAward clone(RetailscmUserContext userContext, String fromEmployeeAwardId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeAwardDAO().clone(fromEmployeeAwardId, this.allTokens());
	}
	
	public EmployeeAward internalSaveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward) throws Exception 
	{
		return internalSaveEmployeeAward(userContext, employeeAward, allTokens());

	}
	public EmployeeAward internalSaveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeAward){ 
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.
			
			
			employeeAward = saveEmployeeAward(userContext, employeeAward, options);
			return employeeAward;
			
		}

	}
	
	public EmployeeAward updateEmployeeAward(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());
		if(employeeAward.getVersion() != employeeAwardVersion){
			String message = "The target version("+employeeAward.getVersion()+") is not equals to version("+employeeAwardVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAward){ 
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.
			
			employeeAward.changeProperty(property, newValueExpr);
			employeeAward = saveEmployeeAward(userContext, employeeAward, tokens().done());
			return present(userContext,employeeAward, mergedAllTokens(tokensExpr));
			//return saveEmployeeAward(userContext, employeeAward, tokens().done());
		}

	}
	
	public EmployeeAward updateEmployeeAwardProperty(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);
		
		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());
		if(employeeAward.getVersion() != employeeAwardVersion){
			String message = "The target version("+employeeAward.getVersion()+") is not equals to version("+employeeAwardVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAward){ 
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.
			
			employeeAward.changeProperty(property, newValueExpr);
			
			employeeAward = saveEmployeeAward(userContext, employeeAward, tokens().done());
			return present(userContext,employeeAward, mergedAllTokens(tokensExpr));
			//return saveEmployeeAward(userContext, employeeAward, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeAwardTokens tokens(){
		return EmployeeAwardTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeAwardTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeAwardTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeAwardId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeAwardManagerException.class);
 		
 	}
 	public EmployeeAward transferToAnotherEmployee(RetailscmUserContext userContext, String employeeAwardId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeAwardId,anotherEmployeeId);
 
		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());	
		synchronized(employeeAward){
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeAward.updateEmployee(employee);		
			employeeAward = saveEmployeeAward(userContext, employeeAward, emptyOptions());
			
			return present(userContext,employeeAward, allTokens());
			
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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeAward(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String employeeAwardId, int employeeAwardVersion) throws Exception {
		//deleteInternal(userContext, employeeAwardId, employeeAwardVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeAwardId, int employeeAwardVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeAwardDAO().delete(employeeAwardId, employeeAwardVersion);
	}
	
	public EmployeeAward forgetByAll(RetailscmUserContext userContext, String employeeAwardId, int employeeAwardVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeAwardId, employeeAwardVersion);		
	}
	protected EmployeeAward forgetByAllInternal(RetailscmUserContext userContext,
			String employeeAwardId, int employeeAwardVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeAwardDAO().disconnectFromAll(employeeAwardId, employeeAwardVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeAwardManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeAwardDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeAward newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


