
package com.doublechaintech.retailscm.levelthreedepartment;

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

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.leveltwodepartment.CandidateLevelTwoDepartment;

import com.doublechaintech.retailscm.hrinterview.HrInterview;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.jobapplication.JobApplication;
import com.doublechaintech.retailscm.professioninterview.ProfessionInterview;
import com.doublechaintech.retailscm.offeracceptance.OfferAcceptance;
import com.doublechaintech.retailscm.employeeboarding.EmployeeBoarding;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.offerapproval.OfferApproval;






public class LevelThreeDepartmentManagerImpl extends CustomRetailscmCheckerManager implements LevelThreeDepartmentManager {
	
	private static final String SERVICE_TYPE = "LevelThreeDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelThreeDepartmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelThreeDepartmentManagerException(message);

	}
	
	

 	protected LevelThreeDepartment saveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelThreeDepartmentDAO().save(levelThreeDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens);
 	}
 	
 	protected LevelThreeDepartment saveLevelThreeDepartmentDetail(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception{	

 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());
 	}
 	
 	public LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	
 	 public LevelThreeDepartment searchLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	

 	protected LevelThreeDepartment present(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeDepartment,tokens);
		
		
		LevelThreeDepartment  levelThreeDepartmentToPresent = userContext.getDAOGroup().getLevelThreeDepartmentDAO().present(levelThreeDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = levelThreeDepartmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelThreeDepartmentDAO().alias(entityListToNaming);
		
		return  levelThreeDepartmentToPresent;
		
		
	}
 
 	
 	
 	public LevelThreeDepartment loadLevelThreeDepartmentDetail(RetailscmUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, allTokens());
 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, viewTokens());
 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	protected LevelThreeDepartment saveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelThreeDepartmentDAO().save(levelThreeDepartment, tokens);
 	}
 	protected LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 
 		return userContext.getDAOGroup().getLevelThreeDepartmentDAO().load(levelThreeDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelThreeDepartment, tokens);
		
		addAction(userContext, levelThreeDepartment, tokens,"@create","createLevelThreeDepartment","createLevelThreeDepartment/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@update","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@copy","cloneLevelThreeDepartment","cloneLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.addEmployee","addEmployee","addEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.removeEmployee","removeEmployee","removeEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.updateEmployee","updateEmployee","updateEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+levelThreeDepartment.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext,String belongsToId, String name, String description, Date founded) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelThreeDepartment(name);
		userContext.getChecker().checkDescriptionOfLevelThreeDepartment(description);
		userContext.getChecker().checkFoundedOfLevelThreeDepartment(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


		LevelThreeDepartment levelThreeDepartment=createNewLevelThreeDepartment();	

			
		LevelTwoDepartment belongsTo = loadLevelTwoDepartment(userContext, belongsToId,emptyOptions());
		levelThreeDepartment.setBelongsTo(belongsTo);
		
		
		levelThreeDepartment.setName(name);
		levelThreeDepartment.setDescription(description);
		levelThreeDepartment.setFounded(founded);

		levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, levelThreeDepartment);
		return levelThreeDepartment;

		
	}
	protected LevelThreeDepartment createNewLevelThreeDepartment() 
	{
		
		return new LevelThreeDepartment();		
	}
	
	protected void checkParamsForUpdatingLevelThreeDepartment(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().checkVersionOfLevelThreeDepartment( levelThreeDepartmentVersion);
		
		

		
		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelThreeDepartment(parseString(newValueExpr));
		}
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLevelThreeDepartment(parseString(newValueExpr));
		}
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfLevelThreeDepartment(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
	
		
	}
	
	
	
	public LevelThreeDepartment clone(RetailscmUserContext userContext, String fromLevelThreeDepartmentId) throws Exception{
		
		return userContext.getDAOGroup().getLevelThreeDepartmentDAO().clone(fromLevelThreeDepartmentId, this.allTokens());
	}
	
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception 
	{
		return internalSaveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());

	}
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelThreeDepartment){ 
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			
			
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, options);
			return levelThreeDepartment;
			
		}

	}
	
	public LevelThreeDepartment updateLevelThreeDepartment(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeDepartment){ 
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			
			levelThreeDepartment.changeProperty(property, newValueExpr);
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}
	
	public LevelThreeDepartment updateLevelThreeDepartmentProperty(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeDepartment){ 
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			
			levelThreeDepartment.changeProperty(property, newValueExpr);
			
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelThreeDepartmentTokens tokens(){
		return LevelThreeDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelThreeDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
 		userContext.getChecker().checkIdOfLevelTwoDepartment(anotherBelongsToId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
 		
 	}
 	public LevelThreeDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelThreeDepartmentId,anotherBelongsToId);
 
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());	
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoDepartment belongsTo = loadLevelTwoDepartment(userContext, anotherBelongsToId, emptyOptions());		
			levelThreeDepartment.updateBelongsTo(belongsTo);		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
			
			return present(userContext,levelThreeDepartment, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelTwoDepartment requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelTwoDepartment result = new CandidateLevelTwoDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("belongsTo");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelTwoDepartment> candidateList = userContext.getDAOGroup().getLevelTwoDepartmentDAO().requestCandidateLevelTwoDepartmentForLevelThreeDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelTwoDepartmentDAO().load(newBelongsToId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelThreeDepartmentDAO().delete(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	
	public LevelThreeDepartment forgetByAll(RetailscmUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);		
	}
	protected LevelThreeDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelThreeDepartmentDAO().disconnectFromAll(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelThreeDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelThreeDepartmentDAO().deleteAll();
	}


	//disconnect LevelThreeDepartment with company in Employee
	protected LevelThreeDepartment breakWithEmployeeByCompany(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelThreeDepartmentDAO().planToRemoveEmployeeListWithCompany(levelThreeDepartment, companyId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with occupation in Employee
	protected LevelThreeDepartment breakWithEmployeeByOccupation(RetailscmUserContext userContext, String levelThreeDepartmentId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelThreeDepartmentDAO().planToRemoveEmployeeListWithOccupation(levelThreeDepartment, occupationId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with responsible_for in Employee
	protected LevelThreeDepartment breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String levelThreeDepartmentId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelThreeDepartmentDAO().planToRemoveEmployeeListWithResponsibleFor(levelThreeDepartment, responsibleForId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with current_salary_grade in Employee
	protected LevelThreeDepartment breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String levelThreeDepartmentId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelThreeDepartmentDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(levelThreeDepartment, currentSalaryGradeId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);

		
		userContext.getChecker().checkCompanyIdOfEmployee(companyId);
		
		userContext.getChecker().checkTitleOfEmployee(title);
		
		userContext.getChecker().checkFamilyNameOfEmployee(familyName);
		
		userContext.getChecker().checkGivenNameOfEmployee(givenName);
		
		userContext.getChecker().checkEmailOfEmployee(email);
		
		userContext.getChecker().checkCityOfEmployee(city);
		
		userContext.getChecker().checkAddressOfEmployee(address);
		
		userContext.getChecker().checkCellPhoneOfEmployee(cellPhone);
		
		userContext.getChecker().checkOccupationIdOfEmployee(occupationId);
		
		userContext.getChecker().checkResponsibleForIdOfEmployee(responsibleForId);
		
		userContext.getChecker().checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		userContext.getChecker().checkSalaryAccountOfEmployee(salaryAccount);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	
	}
	public  LevelThreeDepartment addEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.addEmployee( employee );		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String levelThreeDepartmentId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
		
	}
	public  LevelThreeDepartment updateEmployeeProperties(RetailscmUserContext userContext, String levelThreeDepartmentId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,levelThreeDepartmentId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		LevelThreeDepartment levelThreeDepartmentToUpdate = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		if(levelThreeDepartmentToUpdate.getEmployeeList().isEmpty()){
			throw new LevelThreeDepartmentManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = levelThreeDepartmentToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,name, code, used,tokensExpr);
		LevelThreeDepartment levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartmentToUpdate, tokens().withEmployeeList().done());
		synchronized(levelThreeDepartment){ 
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);		
		employee.setLastUpdateTime(userContext.now());		
		employee.setCurrentStatus("INIT");
	
		
		return employee;
	
		
	}
	
	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;			
		
	}
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String levelThreeDepartmentId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
		
	}
	public  LevelThreeDepartment removeEmployeeList(RetailscmUserContext userContext, String levelThreeDepartmentId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, levelThreeDepartmentId,  employeeIds, tokensExpr);
			
			
			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
			synchronized(levelThreeDepartment){ 
				//Will be good when the levelThreeDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelThreeDepartmentDAO().planToRemoveEmployeeList(levelThreeDepartment, employeeIds, allTokens());
				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, levelThreeDepartment.getEmployeeList());
				return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelThreeDepartment( levelThreeDepartmentId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
	
	}
	public  LevelThreeDepartment removeEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.removeEmployee( employee );		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelThreeDepartment( levelThreeDepartmentId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
	
	}
	public  LevelThreeDepartment copyEmployeeFrom(RetailscmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			levelThreeDepartment.copyEmployeeFrom( employee );		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)levelThreeDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkFamilyNameOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkGivenNameOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
			userContext.getChecker().checkEmailOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkCellPhoneOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkSalaryAccountOfEmployee(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);
	
	}
	
	public  LevelThreeDepartment updateEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, levelThreeDepartmentId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, loadTokens);
		
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeDepartment.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = levelThreeDepartment.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new LevelThreeDepartmentManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  LevelThreeDepartment associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToNewTermination(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}
	*/
	
	public  LevelThreeDepartment associateEmployeeListToJobApplication(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToHrInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}	public  LevelThreeDepartment associateEmployeeListToTermination(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: levelThreeDepartment.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveLevelThreeDepartment(userContext, levelThreeDepartment);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


