
package com.doublechaintech.retailscm.employeeperformance;

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







public class EmployeePerformanceManagerImpl extends CustomRetailscmCheckerManager implements EmployeePerformanceManager {
	
	private static final String SERVICE_TYPE = "EmployeePerformance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeePerformanceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeePerformanceManagerException(message);

	}
	
	

 	protected EmployeePerformance saveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance, String [] tokensExpr) throws Exception{	
 		//return getEmployeePerformanceDAO().save(employeePerformance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeePerformance(userContext, employeePerformance, tokens);
 	}
 	
 	protected EmployeePerformance saveEmployeePerformanceDetail(RetailscmUserContext userContext, EmployeePerformance employeePerformance) throws Exception{	

 		
 		return saveEmployeePerformance(userContext, employeePerformance, allTokens());
 	}
 	
 	public EmployeePerformance loadEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeePerformanceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeePerformance, tokens);
 	}
 	
 	
 	 public EmployeePerformance searchEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeePerformanceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeePerformance, tokens);
 	}
 	
 	

 	protected EmployeePerformance present(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeePerformance,tokens);
		
		
		EmployeePerformance  employeePerformanceToPresent = userContext.getDAOGroup().getEmployeePerformanceDAO().present(employeePerformance, tokens);
		
		List<BaseEntity> entityListToNaming = employeePerformanceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeePerformanceDAO().alias(entityListToNaming);
		
		return  employeePerformanceToPresent;
		
		
	}
 
 	
 	
 	public EmployeePerformance loadEmployeePerformanceDetail(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{	
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, allTokens());
 		return present(userContext,employeePerformance, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{	
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, viewTokens());
 		return present(userContext,employeePerformance, allTokens());
		
 	}
 	protected EmployeePerformance saveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeePerformanceDAO().save(employeePerformance, tokens);
 	}
 	protected EmployeePerformance loadEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeePerformanceManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeePerformanceDAO().load(employeePerformanceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens){
		super.addActions(userContext, employeePerformance, tokens);
		
		addAction(userContext, employeePerformance, tokens,"@create","createEmployeePerformance","createEmployeePerformance/","main","primary");
		addAction(userContext, employeePerformance, tokens,"@update","updateEmployeePerformance","updateEmployeePerformance/"+employeePerformance.getId()+"/","main","primary");
		addAction(userContext, employeePerformance, tokens,"@copy","cloneEmployeePerformance","cloneEmployeePerformance/"+employeePerformance.getId()+"/","main","primary");
		
		addAction(userContext, employeePerformance, tokens,"employee_performance.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeePerformance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeePerformance createEmployeePerformance(RetailscmUserContext userContext,String employeeId, String performanceComment) throws Exception
	{
		
		

		

		userContext.getChecker().checkPerformanceCommentOfEmployeePerformance(performanceComment);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeePerformanceManagerException.class);


		EmployeePerformance employeePerformance=createNewEmployeePerformance();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeePerformance.setEmployee(employee);
		
		
		employeePerformance.setPerformanceComment(performanceComment);

		employeePerformance = saveEmployeePerformance(userContext, employeePerformance, emptyOptions());
		
		onNewInstanceCreated(userContext, employeePerformance);
		return employeePerformance;

		
	}
	protected EmployeePerformance createNewEmployeePerformance() 
	{
		
		return new EmployeePerformance();		
	}
	
	protected void checkParamsForUpdatingEmployeePerformance(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().checkVersionOfEmployeePerformance( employeePerformanceVersion);
		
		

		
		if(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkPerformanceCommentOfEmployeePerformance(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeePerformanceManagerException.class);
	
		
	}
	
	
	
	public EmployeePerformance clone(RetailscmUserContext userContext, String fromEmployeePerformanceId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeePerformanceDAO().clone(fromEmployeePerformanceId, this.allTokens());
	}
	
	public EmployeePerformance internalSaveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance) throws Exception 
	{
		return internalSaveEmployeePerformance(userContext, employeePerformance, allTokens());

	}
	public EmployeePerformance internalSaveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeePerformance){ 
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.
			
			
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, options);
			return employeePerformance;
			
		}

	}
	
	public EmployeePerformance updateEmployeePerformance(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());
		if(employeePerformance.getVersion() != employeePerformanceVersion){
			String message = "The target version("+employeePerformance.getVersion()+") is not equals to version("+employeePerformanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeePerformance){ 
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.
			
			employeePerformance.changeProperty(property, newValueExpr);
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, tokens().done());
			return present(userContext,employeePerformance, mergedAllTokens(tokensExpr));
			//return saveEmployeePerformance(userContext, employeePerformance, tokens().done());
		}

	}
	
	public EmployeePerformance updateEmployeePerformanceProperty(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);
		
		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());
		if(employeePerformance.getVersion() != employeePerformanceVersion){
			String message = "The target version("+employeePerformance.getVersion()+") is not equals to version("+employeePerformanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeePerformance){ 
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.
			
			employeePerformance.changeProperty(property, newValueExpr);
			
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, tokens().done());
			return present(userContext,employeePerformance, mergedAllTokens(tokensExpr));
			//return saveEmployeePerformance(userContext, employeePerformance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeePerformanceTokens tokens(){
		return EmployeePerformanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeePerformanceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeePerformanceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeePerformanceId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeePerformanceManagerException.class);
 		
 	}
 	public EmployeePerformance transferToAnotherEmployee(RetailscmUserContext userContext, String employeePerformanceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeePerformanceId,anotherEmployeeId);
 
		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());	
		synchronized(employeePerformance){
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeePerformance.updateEmployee(employee);		
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, emptyOptions());
			
			return present(userContext,employeePerformance, allTokens());
			
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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeePerformance(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String employeePerformanceId, int employeePerformanceVersion) throws Exception {
		//deleteInternal(userContext, employeePerformanceId, employeePerformanceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeePerformanceId, int employeePerformanceVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeePerformanceDAO().delete(employeePerformanceId, employeePerformanceVersion);
	}
	
	public EmployeePerformance forgetByAll(RetailscmUserContext userContext, String employeePerformanceId, int employeePerformanceVersion) throws Exception {
		return forgetByAllInternal(userContext, employeePerformanceId, employeePerformanceVersion);		
	}
	protected EmployeePerformance forgetByAllInternal(RetailscmUserContext userContext,
			String employeePerformanceId, int employeePerformanceVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeePerformanceDAO().disconnectFromAll(employeePerformanceId, employeePerformanceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeePerformanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeePerformanceDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeePerformance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


