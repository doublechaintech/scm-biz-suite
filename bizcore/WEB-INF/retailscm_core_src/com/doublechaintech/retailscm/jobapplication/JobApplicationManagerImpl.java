
package com.doublechaintech.retailscm.jobapplication;

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






public class JobApplicationManagerImpl extends CustomRetailscmCheckerManager implements JobApplicationManager {
	
	private static final String SERVICE_TYPE = "JobApplication";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws JobApplicationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new JobApplicationManagerException(message);

	}
	
	

 	protected JobApplication saveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication, String [] tokensExpr) throws Exception{	
 		//return getJobApplicationDAO().save(jobApplication, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveJobApplication(userContext, jobApplication, tokens);
 	}
 	
 	protected JobApplication saveJobApplicationDetail(RetailscmUserContext userContext, JobApplication jobApplication) throws Exception{	

 		
 		return saveJobApplication(userContext, jobApplication, allTokens());
 	}
 	
 	public JobApplication loadJobApplication(RetailscmUserContext userContext, String jobApplicationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
		userContext.getChecker().throwExceptionIfHasErrors( JobApplicationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,jobApplication, tokens);
 	}
 	
 	
 	 public JobApplication searchJobApplication(RetailscmUserContext userContext, String jobApplicationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
		userContext.getChecker().throwExceptionIfHasErrors( JobApplicationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,jobApplication, tokens);
 	}
 	
 	

 	protected JobApplication present(RetailscmUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,jobApplication,tokens);
		
		
		JobApplication  jobApplicationToPresent = userContext.getDAOGroup().getJobApplicationDAO().present(jobApplication, tokens);
		
		List<BaseEntity> entityListToNaming = jobApplicationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getJobApplicationDAO().alias(entityListToNaming);
		
		return  jobApplicationToPresent;
		
		
	}
 
 	
 	
 	public JobApplication loadJobApplicationDetail(RetailscmUserContext userContext, String jobApplicationId) throws Exception{	
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, allTokens());
 		return present(userContext,jobApplication, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String jobApplicationId) throws Exception{	
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, viewTokens());
 		return present(userContext,jobApplication, allTokens());
		
 	}
 	protected JobApplication saveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getJobApplicationDAO().save(jobApplication, tokens);
 	}
 	protected JobApplication loadJobApplication(RetailscmUserContext userContext, String jobApplicationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
		userContext.getChecker().throwExceptionIfHasErrors( JobApplicationManagerException.class);

 
 		return userContext.getDAOGroup().getJobApplicationDAO().load(jobApplicationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens){
		super.addActions(userContext, jobApplication, tokens);
		
		addAction(userContext, jobApplication, tokens,"@create","createJobApplication","createJobApplication/","main","primary");
		addAction(userContext, jobApplication, tokens,"@update","updateJobApplication","updateJobApplication/"+jobApplication.getId()+"/","main","primary");
		addAction(userContext, jobApplication, tokens,"@copy","cloneJobApplication","cloneJobApplication/"+jobApplication.getId()+"/","main","primary");
		
		addAction(userContext, jobApplication, tokens,"job_application.addEmployee","addEmployee","addEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.removeEmployee","removeEmployee","removeEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.updateEmployee","updateEmployee","updateEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+jobApplication.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public JobApplication createJobApplication(RetailscmUserContext userContext,Date applicationTime, String who, String comments) throws Exception
	{
		
		

		

		userContext.getChecker().checkApplicationTimeOfJobApplication(applicationTime);
		userContext.getChecker().checkWhoOfJobApplication(who);
		userContext.getChecker().checkCommentsOfJobApplication(comments);
	
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);


		JobApplication jobApplication=createNewJobApplication();	

		jobApplication.setApplicationTime(applicationTime);
		jobApplication.setWho(who);
		jobApplication.setComments(comments);

		jobApplication = saveJobApplication(userContext, jobApplication, emptyOptions());
		
		onNewInstanceCreated(userContext, jobApplication);
		return jobApplication;

		
	}
	protected JobApplication createNewJobApplication() 
	{
		
		return new JobApplication();		
	}
	
	protected void checkParamsForUpdatingJobApplication(RetailscmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
		userContext.getChecker().checkVersionOfJobApplication( jobApplicationVersion);
		

		if(JobApplication.APPLICATION_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkApplicationTimeOfJobApplication(parseDate(newValueExpr));
		}
		if(JobApplication.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfJobApplication(parseString(newValueExpr));
		}
		if(JobApplication.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfJobApplication(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);
	
		
	}
	
	
	
	public JobApplication clone(RetailscmUserContext userContext, String fromJobApplicationId) throws Exception{
		
		return userContext.getDAOGroup().getJobApplicationDAO().clone(fromJobApplicationId, this.allTokens());
	}
	
	public JobApplication internalSaveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication) throws Exception 
	{
		return internalSaveJobApplication(userContext, jobApplication, allTokens());

	}
	public JobApplication internalSaveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(jobApplication){ 
			//will be good when the jobApplication loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.
			
			
			jobApplication = saveJobApplication(userContext, jobApplication, options);
			return jobApplication;
			
		}

	}
	
	public JobApplication updateJobApplication(RetailscmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);
		
		
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		if(jobApplication.getVersion() != jobApplicationVersion){
			String message = "The target version("+jobApplication.getVersion()+") is not equals to version("+jobApplicationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(jobApplication){ 
			//will be good when the jobApplication loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.
			
			jobApplication.changeProperty(property, newValueExpr);
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			//return saveJobApplication(userContext, jobApplication, tokens().done());
		}

	}
	
	public JobApplication updateJobApplicationProperty(RetailscmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		if(jobApplication.getVersion() != jobApplicationVersion){
			String message = "The target version("+jobApplication.getVersion()+") is not equals to version("+jobApplicationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(jobApplication){ 
			//will be good when the jobApplication loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.
			
			jobApplication.changeProperty(property, newValueExpr);
			
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			//return saveJobApplication(userContext, jobApplication, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected JobApplicationTokens tokens(){
		return JobApplicationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return JobApplicationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return JobApplicationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String jobApplicationId, int jobApplicationVersion) throws Exception {
		//deleteInternal(userContext, jobApplicationId, jobApplicationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String jobApplicationId, int jobApplicationVersion) throws Exception{
			
		userContext.getDAOGroup().getJobApplicationDAO().delete(jobApplicationId, jobApplicationVersion);
	}
	
	public JobApplication forgetByAll(RetailscmUserContext userContext, String jobApplicationId, int jobApplicationVersion) throws Exception {
		return forgetByAllInternal(userContext, jobApplicationId, jobApplicationVersion);		
	}
	protected JobApplication forgetByAllInternal(RetailscmUserContext userContext,
			String jobApplicationId, int jobApplicationVersion) throws Exception{
			
		return userContext.getDAOGroup().getJobApplicationDAO().disconnectFromAll(jobApplicationId, jobApplicationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new JobApplicationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getJobApplicationDAO().deleteAll();
	}


	//disconnect JobApplication with company in Employee
	protected JobApplication breakWithEmployeeByCompany(RetailscmUserContext userContext, String jobApplicationId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getJobApplicationDAO().planToRemoveEmployeeListWithCompany(jobApplication, companyId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with department in Employee
	protected JobApplication breakWithEmployeeByDepartment(RetailscmUserContext userContext, String jobApplicationId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getJobApplicationDAO().planToRemoveEmployeeListWithDepartment(jobApplication, departmentId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with occupation in Employee
	protected JobApplication breakWithEmployeeByOccupation(RetailscmUserContext userContext, String jobApplicationId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getJobApplicationDAO().planToRemoveEmployeeListWithOccupation(jobApplication, occupationId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with responsible_for in Employee
	protected JobApplication breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String jobApplicationId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getJobApplicationDAO().planToRemoveEmployeeListWithResponsibleFor(jobApplication, responsibleForId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	//disconnect JobApplication with current_salary_grade in Employee
	protected JobApplication breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String jobApplicationId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());

			synchronized(jobApplication){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getJobApplicationDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(jobApplication, currentSalaryGradeId, this.emptyOptions());

				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				return jobApplication;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);

		
		userContext.getChecker().checkCompanyIdOfEmployee(companyId);
		
		userContext.getChecker().checkTitleOfEmployee(title);
		
		userContext.getChecker().checkDepartmentIdOfEmployee(departmentId);
		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);

	
	}
	public  JobApplication addEmployee(RetailscmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,jobApplicationId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.addEmployee( employee );		
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String jobApplicationId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);
		
	}
	public  JobApplication updateEmployeeProperties(RetailscmUserContext userContext, String jobApplicationId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,jobApplicationId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		JobApplication jobApplicationToUpdate = loadJobApplication(userContext, jobApplicationId, options);
		
		if(jobApplicationToUpdate.getEmployeeList().isEmpty()){
			throw new JobApplicationManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = jobApplicationToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,jobApplicationId,name, code, used,tokensExpr);
		JobApplication jobApplication = saveJobApplication(userContext, jobApplicationToUpdate, tokens().withEmployeeList().done());
		synchronized(jobApplication){ 
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String jobApplicationId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);
		
	}
	public  JobApplication removeEmployeeList(RetailscmUserContext userContext, String jobApplicationId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, jobApplicationId,  employeeIds, tokensExpr);
			
			
			JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
			synchronized(jobApplication){ 
				//Will be good when the jobApplication loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getJobApplicationDAO().planToRemoveEmployeeList(jobApplication, employeeIds, allTokens());
				jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, jobApplication.getEmployeeList());
				return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfJobApplication( jobApplicationId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);
	
	}
	public  JobApplication removeEmployee(RetailscmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,jobApplicationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.removeEmployee( employee );		
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfJobApplication( jobApplicationId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);
	
	}
	public  JobApplication copyEmployeeFrom(RetailscmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,jobApplicationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			jobApplication.copyEmployeeFrom( employee );		
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)jobApplication.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfJobApplication(jobApplicationId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(JobApplicationManagerException.class);
	
	}
	
	public  JobApplication updateEmployee(RetailscmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, jobApplicationId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, loadTokens);
		
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//jobApplication.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = jobApplication.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new JobApplicationManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  JobApplication associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToNewTermination(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}
	*/
	
	public  JobApplication associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToHrInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}	public  JobApplication associateEmployeeListToTermination(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: jobApplication.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveJobApplication(userContext, jobApplication);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, JobApplication newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


