
package com.doublechaintech.retailscm.employeeskill;

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

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.skilltype.CandidateSkillType;
import com.doublechaintech.retailscm.employee.CandidateEmployee;







public class EmployeeSkillManagerImpl extends CustomRetailscmCheckerManager implements EmployeeSkillManager {
	
	private static final String SERVICE_TYPE = "EmployeeSkill";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeSkillManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeSkillManagerException(message);

	}
	
	

 	protected EmployeeSkill saveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill, String [] tokensExpr) throws Exception{	
 		//return getEmployeeSkillDAO().save(employeeSkill, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeSkill(userContext, employeeSkill, tokens);
 	}
 	
 	protected EmployeeSkill saveEmployeeSkillDetail(RetailscmUserContext userContext, EmployeeSkill employeeSkill) throws Exception{	

 		
 		return saveEmployeeSkill(userContext, employeeSkill, allTokens());
 	}
 	
 	public EmployeeSkill loadEmployeeSkill(RetailscmUserContext userContext, String employeeSkillId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeSkillManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSkill, tokens);
 	}
 	
 	
 	 public EmployeeSkill searchEmployeeSkill(RetailscmUserContext userContext, String employeeSkillId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeSkillManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSkill, tokens);
 	}
 	
 	

 	protected EmployeeSkill present(RetailscmUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeSkill,tokens);
		
		
		EmployeeSkill  employeeSkillToPresent = userContext.getDAOGroup().getEmployeeSkillDAO().present(employeeSkill, tokens);
		
		List<BaseEntity> entityListToNaming = employeeSkillToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeSkillDAO().alias(entityListToNaming);
		
		return  employeeSkillToPresent;
		
		
	}
 
 	
 	
 	public EmployeeSkill loadEmployeeSkillDetail(RetailscmUserContext userContext, String employeeSkillId) throws Exception{	
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, allTokens());
 		return present(userContext,employeeSkill, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeSkillId) throws Exception{	
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, viewTokens());
 		return present(userContext,employeeSkill, allTokens());
		
 	}
 	protected EmployeeSkill saveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeSkillDAO().save(employeeSkill, tokens);
 	}
 	protected EmployeeSkill loadEmployeeSkill(RetailscmUserContext userContext, String employeeSkillId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeSkillManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeSkillDAO().load(employeeSkillId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens){
		super.addActions(userContext, employeeSkill, tokens);
		
		addAction(userContext, employeeSkill, tokens,"@create","createEmployeeSkill","createEmployeeSkill/","main","primary");
		addAction(userContext, employeeSkill, tokens,"@update","updateEmployeeSkill","updateEmployeeSkill/"+employeeSkill.getId()+"/","main","primary");
		addAction(userContext, employeeSkill, tokens,"@copy","cloneEmployeeSkill","cloneEmployeeSkill/"+employeeSkill.getId()+"/","main","primary");
		
		addAction(userContext, employeeSkill, tokens,"employee_skill.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeSkill.getId()+"/","main","primary");
		addAction(userContext, employeeSkill, tokens,"employee_skill.transfer_to_skill_type","transferToAnotherSkillType","transferToAnotherSkillType/"+employeeSkill.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeSkill createEmployeeSkill(RetailscmUserContext userContext,String employeeId, String skillTypeId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkDescriptionOfEmployeeSkill(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSkillManagerException.class);


		EmployeeSkill employeeSkill=createNewEmployeeSkill();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeSkill.setEmployee(employee);
		
		
			
		SkillType skillType = loadSkillType(userContext, skillTypeId,emptyOptions());
		employeeSkill.setSkillType(skillType);
		
		
		employeeSkill.setDescription(description);

		employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeSkill);
		return employeeSkill;

		
	}
	protected EmployeeSkill createNewEmployeeSkill() 
	{
		
		return new EmployeeSkill();		
	}
	
	protected void checkParamsForUpdatingEmployeeSkill(RetailscmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill( employeeSkillVersion);
		
		

				

		
		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfEmployeeSkill(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSkillManagerException.class);
	
		
	}
	
	
	
	public EmployeeSkill clone(RetailscmUserContext userContext, String fromEmployeeSkillId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeSkillDAO().clone(fromEmployeeSkillId, this.allTokens());
	}
	
	public EmployeeSkill internalSaveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill) throws Exception 
	{
		return internalSaveEmployeeSkill(userContext, employeeSkill, allTokens());

	}
	public EmployeeSkill internalSaveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeSkill){ 
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.
			
			
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, options);
			return employeeSkill;
			
		}

	}
	
	public EmployeeSkill updateEmployeeSkill(RetailscmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());
		if(employeeSkill.getVersion() != employeeSkillVersion){
			String message = "The target version("+employeeSkill.getVersion()+") is not equals to version("+employeeSkillVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeSkill){ 
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.
			
			employeeSkill.changeProperty(property, newValueExpr);
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, tokens().done());
			return present(userContext,employeeSkill, mergedAllTokens(tokensExpr));
			//return saveEmployeeSkill(userContext, employeeSkill, tokens().done());
		}

	}
	
	public EmployeeSkill updateEmployeeSkillProperty(RetailscmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);
		
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());
		if(employeeSkill.getVersion() != employeeSkillVersion){
			String message = "The target version("+employeeSkill.getVersion()+") is not equals to version("+employeeSkillVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeSkill){ 
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.
			
			employeeSkill.changeProperty(property, newValueExpr);
			
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, tokens().done());
			return present(userContext,employeeSkill, mergedAllTokens(tokensExpr));
			//return saveEmployeeSkill(userContext, employeeSkill, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeSkillTokens tokens(){
		return EmployeeSkillTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeSkillTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeSkillTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeSkillId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSkillManagerException.class);
 		
 	}
 	public EmployeeSkill transferToAnotherEmployee(RetailscmUserContext userContext, String employeeSkillId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeSkillId,anotherEmployeeId);
 
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());	
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeSkill.updateEmployee(employee);		
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
			
			return present(userContext,employeeSkill, allTokens());
			
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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeSkill(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherSkillType(RetailscmUserContext userContext, String employeeSkillId, String anotherSkillTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
 		userContext.getChecker().checkIdOfSkillType(anotherSkillTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSkillManagerException.class);
 		
 	}
 	public EmployeeSkill transferToAnotherSkillType(RetailscmUserContext userContext, String employeeSkillId, String anotherSkillTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherSkillType(userContext, employeeSkillId,anotherSkillTypeId);
 
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());	
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SkillType skillType = loadSkillType(userContext, anotherSkillTypeId, emptyOptions());		
			employeeSkill.updateSkillType(skillType);		
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
			
			return present(userContext,employeeSkill, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSkillType requestCandidateSkillType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSkillType result = new CandidateSkillType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SkillType> candidateList = userContext.getDAOGroup().getSkillTypeDAO().requestCandidateSkillTypeForEmployeeSkill(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected SkillType loadSkillType(RetailscmUserContext userContext, String newSkillTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSkillTypeDAO().load(newSkillTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newEmployeeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeSkillId, int employeeSkillVersion) throws Exception {
		//deleteInternal(userContext, employeeSkillId, employeeSkillVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeSkillId, int employeeSkillVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeSkillDAO().delete(employeeSkillId, employeeSkillVersion);
	}
	
	public EmployeeSkill forgetByAll(RetailscmUserContext userContext, String employeeSkillId, int employeeSkillVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeSkillId, employeeSkillVersion);		
	}
	protected EmployeeSkill forgetByAllInternal(RetailscmUserContext userContext,
			String employeeSkillId, int employeeSkillVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeSkillDAO().disconnectFromAll(employeeSkillId, employeeSkillVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeSkillManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeSkillDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSkill newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


