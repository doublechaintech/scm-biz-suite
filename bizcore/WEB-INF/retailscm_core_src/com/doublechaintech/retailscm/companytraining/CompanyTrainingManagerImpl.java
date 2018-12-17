
package com.doublechaintech.retailscm.companytraining;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.CandidateInstructor;
import com.doublechaintech.retailscm.trainingcoursetype.CandidateTrainingCourseType;

import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;






public class CompanyTrainingManagerImpl extends CustomRetailscmCheckerManager implements CompanyTrainingManager {
	
	private static final String SERVICE_TYPE = "CompanyTraining";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CompanyTrainingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CompanyTrainingManagerException(message);

	}
	
	

 	protected CompanyTraining saveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining, String [] tokensExpr) throws Exception{	
 		//return getCompanyTrainingDAO().save(companyTraining, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCompanyTraining(userContext, companyTraining, tokens);
 	}
 	
 	protected CompanyTraining saveCompanyTrainingDetail(RetailscmUserContext userContext, CompanyTraining companyTraining) throws Exception{	

 		
 		return saveCompanyTraining(userContext, companyTraining, allTokens());
 	}
 	
 	public CompanyTraining loadCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().throwExceptionIfHasErrors( CompanyTrainingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,companyTraining, tokens);
 	}
 	
 	
 	 public CompanyTraining searchCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().throwExceptionIfHasErrors( CompanyTrainingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,companyTraining, tokens);
 	}
 	
 	

 	protected CompanyTraining present(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,companyTraining,tokens);
		
		
		CompanyTraining  companyTrainingToPresent = userContext.getDAOGroup().getCompanyTrainingDAO().present(companyTraining, tokens);
		
		List<BaseEntity> entityListToNaming = companyTrainingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCompanyTrainingDAO().alias(entityListToNaming);
		
		return  companyTrainingToPresent;
		
		
	}
 
 	
 	
 	public CompanyTraining loadCompanyTrainingDetail(RetailscmUserContext userContext, String companyTrainingId) throws Exception{	
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, allTokens());
 		return present(userContext,companyTraining, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String companyTrainingId) throws Exception{	
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, viewTokens());
 		return present(userContext,companyTraining, allTokens());
		
 	}
 	protected CompanyTraining saveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCompanyTrainingDAO().save(companyTraining, tokens);
 	}
 	protected CompanyTraining loadCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().throwExceptionIfHasErrors( CompanyTrainingManagerException.class);

 
 		return userContext.getDAOGroup().getCompanyTrainingDAO().load(companyTrainingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens){
		super.addActions(userContext, companyTraining, tokens);
		
		addAction(userContext, companyTraining, tokens,"@create","createCompanyTraining","createCompanyTraining/","main","primary");
		addAction(userContext, companyTraining, tokens,"@update","updateCompanyTraining","updateCompanyTraining/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"@copy","cloneCompanyTraining","cloneCompanyTraining/"+companyTraining.getId()+"/","main","primary");
		
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_instructor","transferToAnotherInstructor","transferToAnotherInstructor/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_training_course_type","transferToAnotherTrainingCourseType","transferToAnotherTrainingCourseType/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CompanyTraining createCompanyTraining(RetailscmUserContext userContext,String title, String companyId, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfCompanyTraining(title);
		userContext.getChecker().checkTimeStartOfCompanyTraining(timeStart);
		userContext.getChecker().checkDurationHoursOfCompanyTraining(durationHours);
	
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);


		CompanyTraining companyTraining=createNewCompanyTraining();	

		companyTraining.setTitle(title);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		companyTraining.setCompany(company);
		
		
			
		Instructor instructor = loadInstructor(userContext, instructorId,emptyOptions());
		companyTraining.setInstructor(instructor);
		
		
			
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId,emptyOptions());
		companyTraining.setTrainingCourseType(trainingCourseType);
		
		
		companyTraining.setTimeStart(timeStart);
		companyTraining.setDurationHours(durationHours);
		companyTraining.setLastUpdateTime(userContext.now());

		companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
		
		onNewInstanceCreated(userContext, companyTraining);
		return companyTraining;

		
	}
	protected CompanyTraining createNewCompanyTraining() 
	{
		
		return new CompanyTraining();		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkVersionOfCompanyTraining( companyTrainingVersion);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfCompanyTraining(parseString(newValueExpr));
		}		

				

				

		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
			userContext.getChecker().checkTimeStartOfCompanyTraining(parseDate(newValueExpr));
		}
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
			userContext.getChecker().checkDurationHoursOfCompanyTraining(parseInt(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
	
		
	}
	
	
	
	public CompanyTraining clone(RetailscmUserContext userContext, String fromCompanyTrainingId) throws Exception{
		
		return userContext.getDAOGroup().getCompanyTrainingDAO().clone(fromCompanyTrainingId, this.allTokens());
	}
	
	public CompanyTraining internalSaveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining) throws Exception 
	{
		return internalSaveCompanyTraining(userContext, companyTraining, allTokens());

	}
	public CompanyTraining internalSaveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(companyTraining){ 
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.
			
			
			companyTraining = saveCompanyTraining(userContext, companyTraining, options);
			return companyTraining;
			
		}

	}
	
	public CompanyTraining updateCompanyTraining(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);
		
		
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		if(companyTraining.getVersion() != companyTrainingVersion){
			String message = "The target version("+companyTraining.getVersion()+") is not equals to version("+companyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(companyTraining){ 
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.
			companyTraining.updateLastUpdateTime(userContext.now());
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			//return saveCompanyTraining(userContext, companyTraining, tokens().done());
		}

	}
	
	public CompanyTraining updateCompanyTrainingProperty(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		if(companyTraining.getVersion() != companyTrainingVersion){
			String message = "The target version("+companyTraining.getVersion()+") is not equals to version("+companyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(companyTraining){ 
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.
			
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			//return saveCompanyTraining(userContext, companyTraining, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CompanyTrainingTokens tokens(){
		return CompanyTrainingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CompanyTrainingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeCompanyTrainingListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CompanyTrainingTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String companyTrainingId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
 		
 	}
 	public CompanyTraining transferToAnotherCompany(RetailscmUserContext userContext, String companyTrainingId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, companyTrainingId,anotherCompanyId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			companyTraining.updateCompany(company);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateCompany(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherInstructor(RetailscmUserContext userContext, String companyTrainingId, String anotherInstructorId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
 		userContext.getChecker().checkIdOfInstructor(anotherInstructorId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
 		
 	}
 	public CompanyTraining transferToAnotherInstructor(RetailscmUserContext userContext, String companyTrainingId, String anotherInstructorId) throws Exception
 	{
 		checkParamsForTransferingAnotherInstructor(userContext, companyTrainingId,anotherInstructorId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Instructor instructor = loadInstructor(userContext, anotherInstructorId, emptyOptions());		
			companyTraining.updateInstructor(instructor);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateInstructor requestCandidateInstructor(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateInstructor result = new CandidateInstructor();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Instructor> candidateList = userContext.getDAOGroup().getInstructorDAO().requestCandidateInstructorForCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherTrainingCourseType(RetailscmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
 		userContext.getChecker().checkIdOfTrainingCourseType(anotherTrainingCourseTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
 		
 	}
 	public CompanyTraining transferToAnotherTrainingCourseType(RetailscmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherTrainingCourseType(userContext, companyTrainingId,anotherTrainingCourseTypeId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, anotherTrainingCourseTypeId, emptyOptions());		
			companyTraining.updateTrainingCourseType(trainingCourseType);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTrainingCourseType requestCandidateTrainingCourseType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTrainingCourseType result = new CandidateTrainingCourseType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TrainingCourseType> candidateList = userContext.getDAOGroup().getTrainingCourseTypeDAO().requestCandidateTrainingCourseTypeForCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
 	
 	
 	
	
	 	
 	protected Instructor loadInstructor(RetailscmUserContext userContext, String newInstructorId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getInstructorDAO().load(newInstructorId, options);
 	}
 	
 	
 	
	
	 	
 	protected TrainingCourseType loadTrainingCourseType(RetailscmUserContext userContext, String newTrainingCourseTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTrainingCourseTypeDAO().load(newTrainingCourseTypeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String companyTrainingId, int companyTrainingVersion) throws Exception {
		//deleteInternal(userContext, companyTrainingId, companyTrainingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String companyTrainingId, int companyTrainingVersion) throws Exception{
			
		userContext.getDAOGroup().getCompanyTrainingDAO().delete(companyTrainingId, companyTrainingVersion);
	}
	
	public CompanyTraining forgetByAll(RetailscmUserContext userContext, String companyTrainingId, int companyTrainingVersion) throws Exception {
		return forgetByAllInternal(userContext, companyTrainingId, companyTrainingVersion);		
	}
	protected CompanyTraining forgetByAllInternal(RetailscmUserContext userContext,
			String companyTrainingId, int companyTrainingVersion) throws Exception{
			
		return userContext.getDAOGroup().getCompanyTrainingDAO().disconnectFromAll(companyTrainingId, companyTrainingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CompanyTrainingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCompanyTrainingDAO().deleteAll();
	}


	//disconnect CompanyTraining with employee in EmployeeCompanyTraining
	protected CompanyTraining breakWithEmployeeCompanyTrainingByEmployee(RetailscmUserContext userContext, String companyTrainingId, String employeeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());

			synchronized(companyTraining){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCompanyTrainingDAO().planToRemoveEmployeeCompanyTrainingListWithEmployee(companyTraining, employeeId, this.emptyOptions());

				companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
				return companyTraining;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);

		
		userContext.getChecker().checkEmployeeIdOfEmployeeCompanyTraining(employeeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

	
	}
	public  CompanyTraining addEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeCompanyTraining(userContext,companyTrainingId,employeeId,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId);
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.addEmployeeCompanyTraining( employeeCompanyTraining );		
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, employeeCompanyTraining);
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String companyTrainingId,String id,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(id);
		

		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
		
	}
	public  CompanyTraining updateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String companyTrainingId, String id, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext,companyTrainingId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeCompanyTrainingListList()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "is", id).done();
		
		CompanyTraining companyTrainingToUpdate = loadCompanyTraining(userContext, companyTrainingId, options);
		
		if(companyTrainingToUpdate.getEmployeeCompanyTrainingList().isEmpty()){
			throw new CompanyTrainingManagerException("EmployeeCompanyTraining is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeCompanyTraining item = companyTrainingToUpdate.getEmployeeCompanyTrainingList().first();
		

		
		//checkParamsForAddingEmployeeCompanyTraining(userContext,companyTrainingId,name, code, used,tokensExpr);
		CompanyTraining companyTraining = saveCompanyTraining(userContext, companyTrainingToUpdate, tokens().withEmployeeCompanyTrainingList().done());
		synchronized(companyTraining){ 
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);		
		employeeCompanyTraining.setCurrentStatus("INIT");
	
		
		return employeeCompanyTraining;
	
		
	}
	
	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;			
		
	}
	
	protected void checkParamsForRemovingEmployeeCompanyTrainingList(RetailscmUserContext userContext, String companyTrainingId, 
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		for(String employeeCompanyTrainingId: employeeCompanyTrainingIds){
			userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
		
	}
	public  CompanyTraining removeEmployeeCompanyTrainingList(RetailscmUserContext userContext, String companyTrainingId, 
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, companyTrainingId,  employeeCompanyTrainingIds, tokensExpr);
			
			
			CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
			synchronized(companyTraining){ 
				//Will be good when the companyTraining loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCompanyTrainingDAO().planToRemoveEmployeeCompanyTrainingList(companyTraining, employeeCompanyTrainingIds, allTokens());
				companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, companyTraining.getEmployeeCompanyTrainingList());
				return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCompanyTraining( companyTrainingId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
	
	}
	public  CompanyTraining removeEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeCompanyTraining(userContext,companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.removeEmployeeCompanyTraining( employeeCompanyTraining );		
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			deleteRelationInGraph(userContext, employeeCompanyTraining);
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCompanyTraining( companyTrainingId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
	
	}
	public  CompanyTraining copyEmployeeCompanyTrainingFrom(RetailscmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeCompanyTraining(userContext,companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			companyTraining.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );		
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, (EmployeeCompanyTraining)companyTraining.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		

	
		userContext.getChecker().throwExceptionIfHasErrors(CompanyTrainingManagerException.class);
	
	}
	
	public  CompanyTraining updateEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeCompanyTrainingList().searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "eq", employeeCompanyTrainingId).done();
		
		
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, loadTokens);
		
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//companyTraining.removeEmployeeCompanyTraining( employeeCompanyTraining );	
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		
			EmployeeCompanyTraining employeeCompanyTraining = companyTraining.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new CompanyTrainingManagerException(employeeCompanyTraining+" is NOT FOUND" );
			}
			
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  CompanyTraining associateEmployeeCompanyTrainingListToNewScoring(RetailscmUserContext userContext, String companyTrainingId, String  employeeCompanyTrainingIds[], String scoredBy, int score, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "oneof", this.joinArray("|", employeeCompanyTrainingIds)).done();
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, options);
		
		Scoring scoring = userContext.getManagerGroup().getScoringManager().createScoring(userContext,  scoredBy,  score,  comment);
		
		for(EmployeeCompanyTraining employeeCompanyTraining: companyTraining.getEmployeeCompanyTrainingList()) {
			//TODO: need to check if already associated
			employeeCompanyTraining.updateScoring(scoring);
		}
		return this.internalSaveCompanyTraining(userContext, companyTraining);
	}
	*/
	
	public  CompanyTraining associateEmployeeCompanyTrainingListToScoring(RetailscmUserContext userContext, String companyTrainingId, String  employeeCompanyTrainingIds[], String scoringId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "oneof", this.joinArray("|", employeeCompanyTrainingIds)).done();
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, options);
		
		Scoring scoring = userContext.getManagerGroup().getScoringManager().loadScoring(userContext,scoringId,new String[]{"none"} );
		
		for(EmployeeCompanyTraining employeeCompanyTraining: companyTraining.getEmployeeCompanyTrainingList()) {
			//TODO: need to check if already associated
			employeeCompanyTraining.updateScoring(scoring);
		}
		return this.internalSaveCompanyTraining(userContext, companyTraining);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, CompanyTraining newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


