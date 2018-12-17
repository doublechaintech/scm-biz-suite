
package com.doublechaintech.retailscm.employeeinterview;

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
import com.doublechaintech.retailscm.interviewtype.InterviewType;

import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.interviewtype.CandidateInterviewType;







public class EmployeeInterviewManagerImpl extends CustomRetailscmCheckerManager implements EmployeeInterviewManager {
	
	private static final String SERVICE_TYPE = "EmployeeInterview";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeInterviewManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeInterviewManagerException(message);

	}
	
	

 	protected EmployeeInterview saveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview, String [] tokensExpr) throws Exception{	
 		//return getEmployeeInterviewDAO().save(employeeInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeInterview(userContext, employeeInterview, tokens);
 	}
 	
 	protected EmployeeInterview saveEmployeeInterviewDetail(RetailscmUserContext userContext, EmployeeInterview employeeInterview) throws Exception{	

 		
 		return saveEmployeeInterview(userContext, employeeInterview, allTokens());
 	}
 	
 	public EmployeeInterview loadEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}
 	
 	
 	 public EmployeeInterview searchEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}
 	
 	

 	protected EmployeeInterview present(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeInterview,tokens);
		
		
		EmployeeInterview  employeeInterviewToPresent = userContext.getDAOGroup().getEmployeeInterviewDAO().present(employeeInterview, tokens);
		
		List<BaseEntity> entityListToNaming = employeeInterviewToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeInterviewDAO().alias(entityListToNaming);
		
		return  employeeInterviewToPresent;
		
		
	}
 
 	
 	
 	public EmployeeInterview loadEmployeeInterviewDetail(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{	
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, allTokens());
 		return present(userContext,employeeInterview, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{	
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, viewTokens());
 		return present(userContext,employeeInterview, allTokens());
		
 	}
 	protected EmployeeInterview saveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeInterviewDAO().save(employeeInterview, tokens);
 	}
 	protected EmployeeInterview loadEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeInterviewDAO().load(employeeInterviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
		super.addActions(userContext, employeeInterview, tokens);
		
		addAction(userContext, employeeInterview, tokens,"@create","createEmployeeInterview","createEmployeeInterview/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@update","updateEmployeeInterview","updateEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@copy","cloneEmployeeInterview","cloneEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_interview_type","transferToAnotherInterviewType","transferToAnotherInterviewType/"+employeeInterview.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeInterview createEmployeeInterview(RetailscmUserContext userContext,String employeeId, String interviewTypeId, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkRemarkOfEmployeeInterview(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);


		EmployeeInterview employeeInterview=createNewEmployeeInterview();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeInterview.setEmployee(employee);
		
		
			
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId,emptyOptions());
		employeeInterview.setInterviewType(interviewType);
		
		
		employeeInterview.setRemark(remark);

		employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeInterview);
		return employeeInterview;

		
	}
	protected EmployeeInterview createNewEmployeeInterview() 
	{
		
		return new EmployeeInterview();		
	}
	
	protected void checkParamsForUpdatingEmployeeInterview(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview( employeeInterviewVersion);
		
		

				

		
		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeInterview(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);
	
		
	}
	
	
	
	public EmployeeInterview clone(RetailscmUserContext userContext, String fromEmployeeInterviewId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeInterviewDAO().clone(fromEmployeeInterviewId, this.allTokens());
	}
	
	public EmployeeInterview internalSaveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview) throws Exception 
	{
		return internalSaveEmployeeInterview(userContext, employeeInterview, allTokens());

	}
	public EmployeeInterview internalSaveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeInterview){ 
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			
			
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, options);
			return employeeInterview;
			
		}

	}
	
	public EmployeeInterview updateEmployeeInterview(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeInterview){ 
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			
			employeeInterview.changeProperty(property, newValueExpr);
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}
	
	public EmployeeInterview updateEmployeeInterviewProperty(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);
		
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeInterview){ 
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			
			employeeInterview.changeProperty(property, newValueExpr);
			
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeInterviewTokens tokens(){
		return EmployeeInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeInterviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeInterviewTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);
 		
 	}
 	public EmployeeInterview transferToAnotherEmployee(RetailscmUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeInterviewId,anotherEmployeeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());	
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeInterview.updateEmployee(employee);		
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
			
			return present(userContext,employeeInterview, allTokens());
			
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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeInterview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherInterviewType(RetailscmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
 		userContext.getChecker().checkIdOfInterviewType(anotherInterviewTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);
 		
 	}
 	public EmployeeInterview transferToAnotherInterviewType(RetailscmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherInterviewType(userContext, employeeInterviewId,anotherInterviewTypeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());	
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			InterviewType interviewType = loadInterviewType(userContext, anotherInterviewTypeId, emptyOptions());		
			employeeInterview.updateInterviewType(interviewType);		
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
			
			return present(userContext,employeeInterview, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateInterviewType requestCandidateInterviewType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateInterviewType result = new CandidateInterviewType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<InterviewType> candidateList = userContext.getDAOGroup().getInterviewTypeDAO().requestCandidateInterviewTypeForEmployeeInterview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected InterviewType loadInterviewType(RetailscmUserContext userContext, String newInterviewTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getInterviewTypeDAO().load(newInterviewTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newEmployeeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		//deleteInternal(userContext, employeeInterviewId, employeeInterviewVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeInterviewDAO().delete(employeeInterviewId, employeeInterviewVersion);
	}
	
	public EmployeeInterview forgetByAll(RetailscmUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeInterviewId, employeeInterviewVersion);		
	}
	protected EmployeeInterview forgetByAllInternal(RetailscmUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeInterviewDAO().disconnectFromAll(employeeInterviewId, employeeInterviewVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeInterviewDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeInterview newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


