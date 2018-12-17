
package com.doublechaintech.retailscm.employee;

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

import com.doublechaintech.retailscm.hrinterview.HrInterview;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.professioninterview.ProfessionInterview;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.offeracceptance.OfferAcceptance;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.employeeboarding.EmployeeBoarding;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.offerapproval.OfferApproval;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.jobapplication.JobApplication;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;

import com.doublechaintech.retailscm.hrinterview.CandidateHrInterview;
import com.doublechaintech.retailscm.termination.CandidateTermination;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.jobapplication.CandidateJobApplication;
import com.doublechaintech.retailscm.professioninterview.CandidateProfessionInterview;
import com.doublechaintech.retailscm.offeracceptance.CandidateOfferAcceptance;
import com.doublechaintech.retailscm.employeeboarding.CandidateEmployeeBoarding;
import com.doublechaintech.retailscm.levelthreedepartment.CandidateLevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.CandidateResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.CandidateOccupationType;
import com.doublechaintech.retailscm.salarygrade.CandidateSalaryGrade;
import com.doublechaintech.retailscm.offerapproval.CandidateOfferApproval;

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.leavetype.LeaveType;

import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;





public class EmployeeManagerImpl extends CustomRetailscmCheckerManager implements EmployeeManager {
	
	private static final String SERVICE_TYPE = "Employee";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeManagerException(message);

	}
	
	

 	protected Employee saveEmployee(RetailscmUserContext userContext, Employee employee, String [] tokensExpr) throws Exception{	
 		//return getEmployeeDAO().save(employee, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployee(userContext, employee, tokens);
 	}
 	
 	protected Employee saveEmployeeDetail(RetailscmUserContext userContext, Employee employee) throws Exception{	

 		
 		return saveEmployee(userContext, employee, allTokens());
 	}
 	
 	public Employee loadEmployee(RetailscmUserContext userContext, String employeeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Employee employee = loadEmployee( userContext, employeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employee, tokens);
 	}
 	
 	
 	 public Employee searchEmployee(RetailscmUserContext userContext, String employeeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Employee employee = loadEmployee( userContext, employeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employee, tokens);
 	}
 	
 	

 	protected Employee present(RetailscmUserContext userContext, Employee employee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employee,tokens);
		
		
		Employee  employeeToPresent = userContext.getDAOGroup().getEmployeeDAO().present(employee, tokens);
		
		List<BaseEntity> entityListToNaming = employeeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeDAO().alias(entityListToNaming);
		
		return  employeeToPresent;
		
		
	}
 
 	
 	
 	public Employee loadEmployeeDetail(RetailscmUserContext userContext, String employeeId) throws Exception{	
 		Employee employee = loadEmployee( userContext, employeeId, allTokens());
 		return present(userContext,employee, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeId) throws Exception{	
 		Employee employee = loadEmployee( userContext, employeeId, viewTokens());
 		return present(userContext,employee, allTokens());
		
 	}
 	protected Employee saveEmployee(RetailscmUserContext userContext, Employee employee, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeDAO().save(employee, tokens);
 	}
 	protected Employee loadEmployee(RetailscmUserContext userContext, String employeeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeDAO().load(employeeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Employee employee, Map<String, Object> tokens){
		super.addActions(userContext, employee, tokens);
		
		addAction(userContext, employee, tokens,"@create","createEmployee","createEmployee/","main","primary");
		addAction(userContext, employee, tokens,"@update","updateEmployee","updateEmployee/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"@copy","cloneEmployee","cloneEmployee/"+employee.getId()+"/","main","primary");
		
		addAction(userContext, employee, tokens,"employee.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_occupation","transferToAnotherOccupation","transferToAnotherOccupation/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_responsible_for","transferToAnotherResponsibleFor","transferToAnotherResponsibleFor/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_current_salary_grade","transferToAnotherCurrentSalaryGrade","transferToAnotherCurrentSalaryGrade/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.applyJob","applyJob","applyJobActionForm/"+employee.getId()+"/","main","info");
		addAction(userContext, employee, tokens,"employee.interviewWithProfession","interviewWithProfession","interviewWithProfessionActionForm/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.interviewByHr","interviewByHr","interviewByHrActionForm/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.approveOffer","approveOffer","approveOfferActionForm/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.acceptOffer","acceptOffer","acceptOfferActionForm/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.boardEmployee","boardEmployee","boardEmployeeActionForm/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.terminate","terminate","terminateActionForm/"+employee.getId()+"/","main","danger");
		addAction(userContext, employee, tokens,"employee.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeSkill","addEmployeeSkill","addEmployeeSkill/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeSkill","removeEmployeeSkill","removeEmployeeSkill/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeSkill","updateEmployeeSkill","updateEmployeeSkill/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeSkillFrom","copyEmployeeSkillFrom","copyEmployeeSkillFrom/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeePerformance","addEmployeePerformance","addEmployeePerformance/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeePerformance","removeEmployeePerformance","removeEmployeePerformance/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeePerformance","updateEmployeePerformance","updateEmployeePerformance/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeePerformanceFrom","copyEmployeePerformanceFrom","copyEmployeePerformanceFrom/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeWorkExperience","addEmployeeWorkExperience","addEmployeeWorkExperience/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeWorkExperience","removeEmployeeWorkExperience","removeEmployeeWorkExperience/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeWorkExperience","updateEmployeeWorkExperience","updateEmployeeWorkExperience/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeWorkExperienceFrom","copyEmployeeWorkExperienceFrom","copyEmployeeWorkExperienceFrom/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeLeave","addEmployeeLeave","addEmployeeLeave/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeLeave","removeEmployeeLeave","removeEmployeeLeave/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeLeave","updateEmployeeLeave","updateEmployeeLeave/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeLeaveFrom","copyEmployeeLeaveFrom","copyEmployeeLeaveFrom/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeInterview","addEmployeeInterview","addEmployeeInterview/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeInterview","removeEmployeeInterview","removeEmployeeInterview/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeInterview","updateEmployeeInterview","updateEmployeeInterview/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeInterviewFrom","copyEmployeeInterviewFrom","copyEmployeeInterviewFrom/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeAttendance","addEmployeeAttendance","addEmployeeAttendance/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeAttendance","removeEmployeeAttendance","removeEmployeeAttendance/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeAttendance","updateEmployeeAttendance","updateEmployeeAttendance/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeAttendanceFrom","copyEmployeeAttendanceFrom","copyEmployeeAttendanceFrom/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeQualifier","addEmployeeQualifier","addEmployeeQualifier/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeQualifier","removeEmployeeQualifier","removeEmployeeQualifier/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeQualifier","updateEmployeeQualifier","updateEmployeeQualifier/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeQualifierFrom","copyEmployeeQualifierFrom","copyEmployeeQualifierFrom/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeEducation","addEmployeeEducation","addEmployeeEducation/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeEducation","removeEmployeeEducation","removeEmployeeEducation/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeEducation","updateEmployeeEducation","updateEmployeeEducation/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeEducationFrom","copyEmployeeEducationFrom","copyEmployeeEducationFrom/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeAward","addEmployeeAward","addEmployeeAward/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeAward","removeEmployeeAward","removeEmployeeAward/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeAward","updateEmployeeAward","updateEmployeeAward/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeAwardFrom","copyEmployeeAwardFrom","copyEmployeeAwardFrom/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeSalarySheet","addEmployeeSalarySheet","addEmployeeSalarySheet/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeSalarySheet","removeEmployeeSalarySheet","removeEmployeeSalarySheet/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeSalarySheet","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.addPayingOff","addPayingOff","addPayingOff/"+employee.getId()+"/","payingOffList","primary");
		addAction(userContext, employee, tokens,"employee.removePayingOff","removePayingOff","removePayingOff/"+employee.getId()+"/","payingOffList","primary");
		addAction(userContext, employee, tokens,"employee.updatePayingOff","updatePayingOff","updatePayingOff/"+employee.getId()+"/","payingOffList","primary");
		addAction(userContext, employee, tokens,"employee.copyPayingOffFrom","copyPayingOffFrom","copyPayingOffFrom/"+employee.getId()+"/","payingOffList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Employee employee, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Employee createEmployee(RetailscmUserContext userContext,String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfEmployee(title);
		userContext.getChecker().checkFamilyNameOfEmployee(familyName);
		userContext.getChecker().checkGivenNameOfEmployee(givenName);
		userContext.getChecker().checkEmailOfEmployee(email);
		userContext.getChecker().checkCityOfEmployee(city);
		userContext.getChecker().checkAddressOfEmployee(address);
		userContext.getChecker().checkCellPhoneOfEmployee(cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee(salaryAccount);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);


		Employee employee=createNewEmployee();	

			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		employee.setCompany(company);
		
		
		employee.setTitle(title);
			
		LevelThreeDepartment department = loadLevelThreeDepartment(userContext, departmentId,emptyOptions());
		employee.setDepartment(department);
		
		
		employee.setFamilyName(familyName);
		employee.setGivenName(givenName);
		employee.setEmail(email);
		employee.setCity(city);
		employee.setAddress(address);
		employee.setCellPhone(cellPhone);
			
		OccupationType occupation = loadOccupationType(userContext, occupationId,emptyOptions());
		employee.setOccupation(occupation);
		
		
			
		ResponsibilityType responsibleFor = loadResponsibilityType(userContext, responsibleForId,emptyOptions());
		employee.setResponsibleFor(responsibleFor);
		
		
			
		SalaryGrade currentSalaryGrade = loadSalaryGrade(userContext, currentSalaryGradeId,emptyOptions());
		employee.setCurrentSalaryGrade(currentSalaryGrade);
		
		
		employee.setSalaryAccount(salaryAccount);
		employee.setLastUpdateTime(userContext.now());
		employee.setCurrentStatus("INIT");

		employee = saveEmployee(userContext, employee, emptyOptions());
		
		onNewInstanceCreated(userContext, employee);
		return employee;

		
	}
	protected Employee createNewEmployee() 
	{
		
		return new Employee();		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee( employeeVersion);
		
		

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
		
	}
	
	
	
	public Employee clone(RetailscmUserContext userContext, String fromEmployeeId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeDAO().clone(fromEmployeeId, this.allTokens());
	}
	
	public Employee internalSaveEmployee(RetailscmUserContext userContext, Employee employee) throws Exception 
	{
		return internalSaveEmployee(userContext, employee, allTokens());

	}
	public Employee internalSaveEmployee(RetailscmUserContext userContext, Employee employee, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployee(userContext, employeeId, employeeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employee){ 
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Employee.
			
			
			employee = saveEmployee(userContext, employee, options);
			return employee;
			
		}

	}
	
	public Employee updateEmployee(RetailscmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployee(userContext, employeeId, employeeVersion, property, newValueExpr, tokensExpr);
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		if(employee.getVersion() != employeeVersion){
			String message = "The target version("+employee.getVersion()+") is not equals to version("+employeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employee){ 
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Employee.
			employee.updateLastUpdateTime(userContext.now());
			employee.changeProperty(property, newValueExpr);
			employee = saveEmployee(userContext, employee, tokens().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
			//return saveEmployee(userContext, employee, tokens().done());
		}

	}
	
	public Employee updateEmployeeProperty(RetailscmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployee(userContext, employeeId, employeeVersion, property, newValueExpr, tokensExpr);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		if(employee.getVersion() != employeeVersion){
			String message = "The target version("+employee.getVersion()+") is not equals to version("+employeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employee){ 
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Employee.
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			employee = saveEmployee(userContext, employee, tokens().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
			//return saveEmployee(userContext, employee, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeTokens tokens(){
		return EmployeeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeCompanyTrainingListWith("id","desc")
		.sortEmployeeSkillListWith("id","desc")
		.sortEmployeePerformanceListWith("id","desc")
		.sortEmployeeWorkExperienceListWith("id","desc")
		.sortEmployeeLeaveListWith("id","desc")
		.sortEmployeeInterviewListWith("id","desc")
		.sortEmployeeAttendanceListWith("id","desc")
		.sortEmployeeQualifierListWith("id","desc")
		.sortEmployeeEducationListWith("id","desc")
		.sortEmployeeAwardListWith("id","desc")
		.sortEmployeeSalarySheetListWith("id","desc")
		.sortPayingOffListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"JOB_APPLIED","PASSED_WITH_PROFESSION","PASSED_BY_HR","OFFER_APPROVED","OFFER_ACCEPTED","EMPLOYEE_BOARDED","TERMINATED"};
 	protected String[] getNextCandidateStatus(RetailscmUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(RetailscmUserContext userContext, Employee employee, String expectedNextStatus) throws Exception{
		String currentStatus = employee.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String employeeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherCompany(RetailscmUserContext userContext, String employeeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, employeeId,anotherCompanyId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			employee.updateCompany(company);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherDepartment(RetailscmUserContext userContext, String employeeId, String anotherDepartmentId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfLevelThreeDepartment(anotherDepartmentId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherDepartment(RetailscmUserContext userContext, String employeeId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, employeeId,anotherDepartmentId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelThreeDepartment department = loadLevelThreeDepartment(userContext, anotherDepartmentId, emptyOptions());		
			employee.updateDepartment(department);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelThreeDepartment requestCandidateDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelThreeDepartment result = new CandidateLevelThreeDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("belongsTo");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelThreeDepartment> candidateList = userContext.getDAOGroup().getLevelThreeDepartmentDAO().requestCandidateLevelThreeDepartmentForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherOccupation(RetailscmUserContext userContext, String employeeId, String anotherOccupationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfOccupationType(anotherOccupationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherOccupation(RetailscmUserContext userContext, String employeeId, String anotherOccupationId) throws Exception
 	{
 		checkParamsForTransferingAnotherOccupation(userContext, employeeId,anotherOccupationId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OccupationType occupation = loadOccupationType(userContext, anotherOccupationId, emptyOptions());		
			employee.updateOccupation(occupation);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOccupationType requestCandidateOccupation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOccupationType result = new CandidateOccupationType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OccupationType> candidateList = userContext.getDAOGroup().getOccupationTypeDAO().requestCandidateOccupationTypeForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherResponsibleFor(RetailscmUserContext userContext, String employeeId, String anotherResponsibleForId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfResponsibilityType(anotherResponsibleForId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherResponsibleFor(RetailscmUserContext userContext, String employeeId, String anotherResponsibleForId) throws Exception
 	{
 		checkParamsForTransferingAnotherResponsibleFor(userContext, employeeId,anotherResponsibleForId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ResponsibilityType responsibleFor = loadResponsibilityType(userContext, anotherResponsibleForId, emptyOptions());		
			employee.updateResponsibleFor(responsibleFor);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateResponsibilityType requestCandidateResponsibleFor(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateResponsibilityType result = new CandidateResponsibilityType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ResponsibilityType> candidateList = userContext.getDAOGroup().getResponsibilityTypeDAO().requestCandidateResponsibilityTypeForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfSalaryGrade(anotherCurrentSalaryGradeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		checkParamsForTransferingAnotherCurrentSalaryGrade(userContext, employeeId,anotherCurrentSalaryGradeId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SalaryGrade currentSalaryGrade = loadSalaryGrade(userContext, anotherCurrentSalaryGradeId, emptyOptions());		
			employee.updateCurrentSalaryGrade(currentSalaryGrade);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSalaryGrade requestCandidateCurrentSalaryGrade(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSalaryGrade result = new CandidateSalaryGrade();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SalaryGrade> candidateList = userContext.getDAOGroup().getSalaryGradeDAO().requestCandidateSalaryGradeForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherJobApplication(RetailscmUserContext userContext, String employeeId, String anotherJobApplicationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfJobApplication(anotherJobApplicationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherJobApplication(RetailscmUserContext userContext, String employeeId, String anotherJobApplicationId) throws Exception
 	{
 		checkParamsForTransferingAnotherJobApplication(userContext, employeeId,anotherJobApplicationId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			JobApplication jobApplication = loadJobApplication(userContext, anotherJobApplicationId, emptyOptions());		
			employee.updateJobApplication(jobApplication);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateJobApplication requestCandidateJobApplication(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateJobApplication result = new CandidateJobApplication();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("applicationTime");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<JobApplication> candidateList = userContext.getDAOGroup().getJobApplicationDAO().requestCandidateJobApplicationForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String JOB_APPLIED_STATUS = "JOB_APPLIED";
 	protected void checkParamsForJobApplication(RetailscmUserContext userContext, String employeeId, Date applicationTime, String who, String comments
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkApplicationTimeOfJobApplication(applicationTime);
		userContext.getChecker().checkWhoOfJobApplication(who);
		userContext.getChecker().checkCommentsOfJobApplication(comments);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee applyJob(RetailscmUserContext userContext, String employeeId, Date applicationTime, String who, String comments
) throws Exception
 	{
		checkParamsForJobApplication(userContext, employeeId, applicationTime, who, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForJobApplication(userContext,employee);
 		

			employee.updateCurrentStatus(JOB_APPLIED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			JobApplication jobApplication = createJobApplication(userContext, applicationTime, who, comments);		
			employee.updateJobApplication(jobApplication);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withJobApplication().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm applyJobActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("applyJob")
			.employeeIdField(employeeId)
			.applicationTimeFieldOfJobApplication()
			.whoFieldOfJobApplication()
			.commentsFieldOfJobApplication()
			.applyJobAction();
 	}
	
 	
 	protected JobApplication createJobApplication(RetailscmUserContext userContext, Date applicationTime, String who, String comments){
 		JobApplication jobApplication = new JobApplication();
 		//applicationTime, who, comments
 		
		jobApplication.setApplicationTime(applicationTime);
		jobApplication.setWho(who);
		jobApplication.setComments(comments);

 		
 		
 		
 		return userContext.getDAOGroup().getJobApplicationDAO().save(jobApplication,emptyOptions());
 	}
 	protected void checkIfEligibleForJobApplication(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, JOB_APPLIED_STATUS);
 		
 		JobApplication jobApplication = employee.getJobApplication();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = jobApplication 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( jobApplication != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ JOB_APPLIED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherProfessionInterview(RetailscmUserContext userContext, String employeeId, String anotherProfessionInterviewId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfProfessionInterview(anotherProfessionInterviewId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherProfessionInterview(RetailscmUserContext userContext, String employeeId, String anotherProfessionInterviewId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfessionInterview(userContext, employeeId,anotherProfessionInterviewId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, anotherProfessionInterviewId, emptyOptions());		
			employee.updateProfessionInterview(professionInterview);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfessionInterview requestCandidateProfessionInterview(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfessionInterview result = new CandidateProfessionInterview();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ProfessionInterview> candidateList = userContext.getDAOGroup().getProfessionInterviewDAO().requestCandidateProfessionInterviewForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PASSED_WITH_PROFESSION_STATUS = "PASSED_WITH_PROFESSION";
 	protected void checkParamsForProfessionInterview(RetailscmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkWhoOfProfessionInterview(who);
		userContext.getChecker().checkInterviewTimeOfProfessionInterview(interviewTime);
		userContext.getChecker().checkCommentsOfProfessionInterview(comments);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee interviewWithProfession(RetailscmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
		checkParamsForProfessionInterview(userContext, employeeId, who, interviewTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForProfessionInterview(userContext,employee);
 		

			employee.updateCurrentStatus(PASSED_WITH_PROFESSION_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			ProfessionInterview professionInterview = createProfessionInterview(userContext, who, interviewTime, comments);		
			employee.updateProfessionInterview(professionInterview);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withProfessionInterview().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm interviewWithProfessionActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("interviewWithProfession")
			.employeeIdField(employeeId)
			.whoFieldOfProfessionInterview()
			.interviewTimeFieldOfProfessionInterview()
			.commentsFieldOfProfessionInterview()
			.interviewWithProfessionAction();
 	}
	
 	
 	protected ProfessionInterview createProfessionInterview(RetailscmUserContext userContext, String who, Date interviewTime, String comments){
 		ProfessionInterview professionInterview = new ProfessionInterview();
 		//who, interviewTime, comments
 		
		professionInterview.setWho(who);
		professionInterview.setInterviewTime(interviewTime);
		professionInterview.setComments(comments);

 		
 		
 		
 		return userContext.getDAOGroup().getProfessionInterviewDAO().save(professionInterview,emptyOptions());
 	}
 	protected void checkIfEligibleForProfessionInterview(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, PASSED_WITH_PROFESSION_STATUS);
 		
 		ProfessionInterview professionInterview = employee.getProfessionInterview();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = professionInterview 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( professionInterview != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ PASSED_WITH_PROFESSION_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherHrInterview(RetailscmUserContext userContext, String employeeId, String anotherHrInterviewId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfHrInterview(anotherHrInterviewId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherHrInterview(RetailscmUserContext userContext, String employeeId, String anotherHrInterviewId) throws Exception
 	{
 		checkParamsForTransferingAnotherHrInterview(userContext, employeeId,anotherHrInterviewId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HrInterview hrInterview = loadHrInterview(userContext, anotherHrInterviewId, emptyOptions());		
			employee.updateHrInterview(hrInterview);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateHrInterview requestCandidateHrInterview(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateHrInterview result = new CandidateHrInterview();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<HrInterview> candidateList = userContext.getDAOGroup().getHrInterviewDAO().requestCandidateHrInterviewForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PASSED_BY_HR_STATUS = "PASSED_BY_HR";
 	protected void checkParamsForHrInterview(RetailscmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkWhoOfHrInterview(who);
		userContext.getChecker().checkInterviewTimeOfHrInterview(interviewTime);
		userContext.getChecker().checkCommentsOfHrInterview(comments);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee interviewByHr(RetailscmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
		checkParamsForHrInterview(userContext, employeeId, who, interviewTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForHrInterview(userContext,employee);
 		

			employee.updateCurrentStatus(PASSED_BY_HR_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			HrInterview hrInterview = createHrInterview(userContext, who, interviewTime, comments);		
			employee.updateHrInterview(hrInterview);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withHrInterview().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm interviewByHrActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("interviewByHr")
			.employeeIdField(employeeId)
			.whoFieldOfHrInterview()
			.interviewTimeFieldOfHrInterview()
			.commentsFieldOfHrInterview()
			.interviewByHrAction();
 	}
	
 	
 	protected HrInterview createHrInterview(RetailscmUserContext userContext, String who, Date interviewTime, String comments){
 		HrInterview hrInterview = new HrInterview();
 		//who, interviewTime, comments
 		
		hrInterview.setWho(who);
		hrInterview.setInterviewTime(interviewTime);
		hrInterview.setComments(comments);

 		
 		
 		
 		return userContext.getDAOGroup().getHrInterviewDAO().save(hrInterview,emptyOptions());
 	}
 	protected void checkIfEligibleForHrInterview(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, PASSED_BY_HR_STATUS);
 		
 		HrInterview hrInterview = employee.getHrInterview();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = hrInterview 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( hrInterview != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ PASSED_BY_HR_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherOfferApproval(RetailscmUserContext userContext, String employeeId, String anotherOfferApprovalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfOfferApproval(anotherOfferApprovalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherOfferApproval(RetailscmUserContext userContext, String employeeId, String anotherOfferApprovalId) throws Exception
 	{
 		checkParamsForTransferingAnotherOfferApproval(userContext, employeeId,anotherOfferApprovalId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OfferApproval offerApproval = loadOfferApproval(userContext, anotherOfferApprovalId, emptyOptions());		
			employee.updateOfferApproval(offerApproval);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOfferApproval requestCandidateOfferApproval(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOfferApproval result = new CandidateOfferApproval();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OfferApproval> candidateList = userContext.getDAOGroup().getOfferApprovalDAO().requestCandidateOfferApprovalForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String OFFER_APPROVED_STATUS = "OFFER_APPROVED";
 	protected void checkParamsForOfferApproval(RetailscmUserContext userContext, String employeeId, String who, Date approveTime, String comments
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkWhoOfOfferApproval(who);
		userContext.getChecker().checkApproveTimeOfOfferApproval(approveTime);
		userContext.getChecker().checkCommentsOfOfferApproval(comments);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee approveOffer(RetailscmUserContext userContext, String employeeId, String who, Date approveTime, String comments
) throws Exception
 	{
		checkParamsForOfferApproval(userContext, employeeId, who, approveTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOfferApproval(userContext,employee);
 		

			employee.updateCurrentStatus(OFFER_APPROVED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OfferApproval offerApproval = createOfferApproval(userContext, who, approveTime, comments);		
			employee.updateOfferApproval(offerApproval);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withOfferApproval().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm approveOfferActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("approveOffer")
			.employeeIdField(employeeId)
			.whoFieldOfOfferApproval()
			.approveTimeFieldOfOfferApproval()
			.commentsFieldOfOfferApproval()
			.approveOfferAction();
 	}
	
 	
 	protected OfferApproval createOfferApproval(RetailscmUserContext userContext, String who, Date approveTime, String comments){
 		OfferApproval offerApproval = new OfferApproval();
 		//who, approveTime, comments
 		
		offerApproval.setWho(who);
		offerApproval.setApproveTime(approveTime);
		offerApproval.setComments(comments);

 		
 		
 		
 		return userContext.getDAOGroup().getOfferApprovalDAO().save(offerApproval,emptyOptions());
 	}
 	protected void checkIfEligibleForOfferApproval(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, OFFER_APPROVED_STATUS);
 		
 		OfferApproval offerApproval = employee.getOfferApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = offerApproval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( offerApproval != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ OFFER_APPROVED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherOfferAcceptance(RetailscmUserContext userContext, String employeeId, String anotherOfferAcceptanceId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfOfferAcceptance(anotherOfferAcceptanceId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherOfferAcceptance(RetailscmUserContext userContext, String employeeId, String anotherOfferAcceptanceId) throws Exception
 	{
 		checkParamsForTransferingAnotherOfferAcceptance(userContext, employeeId,anotherOfferAcceptanceId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, anotherOfferAcceptanceId, emptyOptions());		
			employee.updateOfferAcceptance(offerAcceptance);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOfferAcceptance requestCandidateOfferAcceptance(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOfferAcceptance result = new CandidateOfferAcceptance();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OfferAcceptance> candidateList = userContext.getDAOGroup().getOfferAcceptanceDAO().requestCandidateOfferAcceptanceForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String OFFER_ACCEPTED_STATUS = "OFFER_ACCEPTED";
 	protected void checkParamsForOfferAcceptance(RetailscmUserContext userContext, String employeeId, String who, Date acceptTime, String comments
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkWhoOfOfferAcceptance(who);
		userContext.getChecker().checkAcceptTimeOfOfferAcceptance(acceptTime);
		userContext.getChecker().checkCommentsOfOfferAcceptance(comments);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee acceptOffer(RetailscmUserContext userContext, String employeeId, String who, Date acceptTime, String comments
) throws Exception
 	{
		checkParamsForOfferAcceptance(userContext, employeeId, who, acceptTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOfferAcceptance(userContext,employee);
 		

			employee.updateCurrentStatus(OFFER_ACCEPTED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OfferAcceptance offerAcceptance = createOfferAcceptance(userContext, who, acceptTime, comments);		
			employee.updateOfferAcceptance(offerAcceptance);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withOfferAcceptance().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm acceptOfferActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("acceptOffer")
			.employeeIdField(employeeId)
			.whoFieldOfOfferAcceptance()
			.acceptTimeFieldOfOfferAcceptance()
			.commentsFieldOfOfferAcceptance()
			.acceptOfferAction();
 	}
	
 	
 	protected OfferAcceptance createOfferAcceptance(RetailscmUserContext userContext, String who, Date acceptTime, String comments){
 		OfferAcceptance offerAcceptance = new OfferAcceptance();
 		//who, acceptTime, comments
 		
		offerAcceptance.setWho(who);
		offerAcceptance.setAcceptTime(acceptTime);
		offerAcceptance.setComments(comments);

 		
 		
 		
 		return userContext.getDAOGroup().getOfferAcceptanceDAO().save(offerAcceptance,emptyOptions());
 	}
 	protected void checkIfEligibleForOfferAcceptance(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, OFFER_ACCEPTED_STATUS);
 		
 		OfferAcceptance offerAcceptance = employee.getOfferAcceptance();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = offerAcceptance 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( offerAcceptance != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ OFFER_ACCEPTED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherEmployeeBoarding(RetailscmUserContext userContext, String employeeId, String anotherEmployeeBoardingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfEmployeeBoarding(anotherEmployeeBoardingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherEmployeeBoarding(RetailscmUserContext userContext, String employeeId, String anotherEmployeeBoardingId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployeeBoarding(userContext, employeeId,anotherEmployeeBoardingId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, anotherEmployeeBoardingId, emptyOptions());		
			employee.updateEmployeeBoarding(employeeBoarding);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateEmployeeBoarding requestCandidateEmployeeBoarding(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateEmployeeBoarding result = new CandidateEmployeeBoarding();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<EmployeeBoarding> candidateList = userContext.getDAOGroup().getEmployeeBoardingDAO().requestCandidateEmployeeBoardingForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String EMPLOYEE_BOARDED_STATUS = "EMPLOYEE_BOARDED";
 	protected void checkParamsForEmployeeBoarding(RetailscmUserContext userContext, String employeeId, String who, Date employTime, String comments
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkWhoOfEmployeeBoarding(who);
		userContext.getChecker().checkEmployTimeOfEmployeeBoarding(employTime);
		userContext.getChecker().checkCommentsOfEmployeeBoarding(comments);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee boardEmployee(RetailscmUserContext userContext, String employeeId, String who, Date employTime, String comments
) throws Exception
 	{
		checkParamsForEmployeeBoarding(userContext, employeeId, who, employTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForEmployeeBoarding(userContext,employee);
 		

			employee.updateCurrentStatus(EMPLOYEE_BOARDED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			EmployeeBoarding employeeBoarding = createEmployeeBoarding(userContext, who, employTime, comments);		
			employee.updateEmployeeBoarding(employeeBoarding);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeBoarding().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm boardEmployeeActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("boardEmployee")
			.employeeIdField(employeeId)
			.whoFieldOfEmployeeBoarding()
			.employTimeFieldOfEmployeeBoarding()
			.commentsFieldOfEmployeeBoarding()
			.boardEmployeeAction();
 	}
	
 	
 	protected EmployeeBoarding createEmployeeBoarding(RetailscmUserContext userContext, String who, Date employTime, String comments){
 		EmployeeBoarding employeeBoarding = new EmployeeBoarding();
 		//who, employTime, comments
 		
		employeeBoarding.setWho(who);
		employeeBoarding.setEmployTime(employTime);
		employeeBoarding.setComments(comments);

 		
 		
 		
 		return userContext.getDAOGroup().getEmployeeBoardingDAO().save(employeeBoarding,emptyOptions());
 	}
 	protected void checkIfEligibleForEmployeeBoarding(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, EMPLOYEE_BOARDED_STATUS);
 		
 		EmployeeBoarding employeeBoarding = employee.getEmployeeBoarding();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = employeeBoarding 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( employeeBoarding != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ EMPLOYEE_BOARDED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherTermination(RetailscmUserContext userContext, String employeeId, String anotherTerminationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployee(employeeId);
 		userContext.getChecker().checkIdOfTermination(anotherTerminationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
 		
 	}
 	public Employee transferToAnotherTermination(RetailscmUserContext userContext, String employeeId, String anotherTerminationId) throws Exception
 	{
 		checkParamsForTransferingAnotherTermination(userContext, employeeId,anotherTerminationId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Termination termination = loadTermination(userContext, anotherTerminationId, emptyOptions());		
			employee.updateTermination(termination);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTermination requestCandidateTermination(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTermination result = new CandidateTermination();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("reason");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Termination> candidateList = userContext.getDAOGroup().getTerminationDAO().requestCandidateTerminationForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String TERMINATED_STATUS = "TERMINATED";
 	protected void checkParamsForTermination(RetailscmUserContext userContext, String employeeId, String reasonId, String typeId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfTerminationReason(reasonId);
		userContext.getChecker().checkIdOfTerminationType(typeId);
		userContext.getChecker().checkCommentOfTermination(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

 	}
 	public Employee terminate(RetailscmUserContext userContext, String employeeId, String reasonId, String typeId, String comment
) throws Exception
 	{
		checkParamsForTermination(userContext, employeeId, reasonId, typeId, comment);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForTermination(userContext,employee);
 		

			employee.updateCurrentStatus(TERMINATED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively
			TerminationReason reason = loadTerminationReason(userContext, reasonId, emptyOptions());
			TerminationType type = loadTerminationType(userContext, typeId, emptyOptions());


			Termination termination = createTermination(userContext, reason, type, comment);		
			employee.updateTermination(termination);		
			
			
			employee = saveEmployee(userContext, employee, tokens().withTermination().done());
			return present(userContext,employee, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeForm terminateActionForm(RetailscmUserContext userContext, String employeeId) throws Exception
 	{
		return new EmployeeForm()
			.withTitle("terminate")
			.employeeIdField(employeeId)
			.reasonIdFieldOfTermination()
			.typeIdFieldOfTermination()
			.commentFieldOfTermination()
			.terminateAction();
 	}
	
 	
 	protected Termination createTermination(RetailscmUserContext userContext, TerminationReason reason, TerminationType type, String comment){
 		Termination termination = new Termination();
 		//reason, type, comment
 		
		termination.setReason(reason);
		termination.setType(type);
		termination.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getTerminationDAO().save(termination,emptyOptions());
 	}
 	protected void checkIfEligibleForTermination(RetailscmUserContext userContext, Employee employee) throws Exception{
 
 		ensureStatus(userContext,employee, TERMINATED_STATUS);
 		
 		Termination termination = employee.getTermination();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = termination 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( termination != null){
				throwExceptionWithMessage("The Employee("+employee.getId()+") has already been "+ TERMINATED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected Termination loadTermination(RetailscmUserContext userContext, String newTerminationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTerminationDAO().load(newTerminationId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
 	
 	
 	
	
	 	
 	protected OfferAcceptance loadOfferAcceptance(RetailscmUserContext userContext, String newOfferAcceptanceId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getOfferAcceptanceDAO().load(newOfferAcceptanceId, options);
 	}
 	
 	
 	
	
	 	
 	protected OfferApproval loadOfferApproval(RetailscmUserContext userContext, String newOfferApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getOfferApprovalDAO().load(newOfferApprovalId, options);
 	}
 	
 	
 	
	
	 	
 	protected TerminationReason loadTerminationReason(RetailscmUserContext userContext, String newReasonId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTerminationReasonDAO().load(newReasonId, options);
 	}
 	
 	
 	
	
	 	
 	protected HrInterview loadHrInterview(RetailscmUserContext userContext, String newHrInterviewId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getHrInterviewDAO().load(newHrInterviewId, options);
 	}
 	
 	
 	
	
	 	
 	protected ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String newResponsibleForId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getResponsibilityTypeDAO().load(newResponsibleForId, options);
 	}
 	
 	
 	
	
	 	
 	protected SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String newCurrentSalaryGradeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSalaryGradeDAO().load(newCurrentSalaryGradeId, options);
 	}
 	
 	
 	
	
	 	
 	protected TerminationType loadTerminationType(RetailscmUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTerminationTypeDAO().load(newTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelThreeDepartmentDAO().load(newDepartmentId, options);
 	}
 	
 	
 	
	
	 	
 	protected OccupationType loadOccupationType(RetailscmUserContext userContext, String newOccupationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getOccupationTypeDAO().load(newOccupationId, options);
 	}
 	
 	
 	
	
	 	
 	protected JobApplication loadJobApplication(RetailscmUserContext userContext, String newJobApplicationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getJobApplicationDAO().load(newJobApplicationId, options);
 	}
 	
 	
 	
	
	 	
 	protected ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String newProfessionInterviewId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfessionInterviewDAO().load(newProfessionInterviewId, options);
 	}
 	
 	
 	
	
	 	
 	protected EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String newEmployeeBoardingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeBoardingDAO().load(newEmployeeBoardingId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeId, int employeeVersion) throws Exception {
		//deleteInternal(userContext, employeeId, employeeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeId, int employeeVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeDAO().delete(employeeId, employeeVersion);
	}
	
	public Employee forgetByAll(RetailscmUserContext userContext, String employeeId, int employeeVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeId, employeeVersion);		
	}
	protected Employee forgetByAllInternal(RetailscmUserContext userContext,
			String employeeId, int employeeVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeDAO().disconnectFromAll(employeeId, employeeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeDAO().deleteAll();
	}


	//disconnect Employee with training in EmployeeCompanyTraining
	protected Employee breakWithEmployeeCompanyTrainingByTraining(RetailscmUserContext userContext, String employeeId, String trainingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeCompanyTrainingListWithTraining(employee, trainingId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
				return employee;
			}
	}
	//disconnect Employee with skill_type in EmployeeSkill
	protected Employee breakWithEmployeeSkillBySkillType(RetailscmUserContext userContext, String employeeId, String skillTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeSkillListWithSkillType(employee, skillTypeId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
				return employee;
			}
	}
	//disconnect Employee with type in EmployeeLeave
	protected Employee breakWithEmployeeLeaveByType(RetailscmUserContext userContext, String employeeId, String typeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeLeaveListWithType(employee, typeId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
				return employee;
			}
	}
	//disconnect Employee with interview_type in EmployeeInterview
	protected Employee breakWithEmployeeInterviewByInterviewType(RetailscmUserContext userContext, String employeeId, String interviewTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeInterviewListWithInterviewType(employee, interviewTypeId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
				return employee;
			}
	}
	//disconnect Employee with current_salary_grade in EmployeeSalarySheet
	protected Employee breakWithEmployeeSalarySheetByCurrentSalaryGrade(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(employee, currentSalaryGradeId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
				return employee;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkTrainingIdOfEmployeeCompanyTraining(trainingId);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeCompanyTraining(userContext,employeeId,trainingId,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,trainingId);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeCompanyTraining( employeeCompanyTraining );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, employeeCompanyTraining);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String employeeId,String id,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(id);
		

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String employeeId, String id, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext,employeeId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeCompanyTrainingListList()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeCompanyTrainingList().isEmpty()){
			throw new EmployeeManagerException("EmployeeCompanyTraining is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeCompanyTraining item = employeeToUpdate.getEmployeeCompanyTrainingList().first();
		

		
		//checkParamsForAddingEmployeeCompanyTraining(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeCompanyTrainingList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String trainingId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);		
		employeeCompanyTraining.setCurrentStatus("INIT");
	
		
		return employeeCompanyTraining;
	
		
	}
	
	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;			
		
	}
	
	protected void checkParamsForRemovingEmployeeCompanyTrainingList(RetailscmUserContext userContext, String employeeId, 
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeCompanyTrainingId: employeeCompanyTrainingIds){
			userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeCompanyTrainingList(RetailscmUserContext userContext, String employeeId, 
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, employeeId,  employeeCompanyTrainingIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeCompanyTrainingList(employee, employeeCompanyTrainingIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeCompanyTrainingList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeCompanyTraining(userContext,employeeId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeCompanyTraining( employeeCompanyTraining );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			deleteRelationInGraph(userContext, employeeCompanyTraining);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeCompanyTrainingFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeCompanyTraining(userContext,employeeId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, (EmployeeCompanyTraining)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeCompanyTrainingList().searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "eq", employeeCompanyTrainingId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeCompanyTraining( employeeCompanyTraining );	
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		
			EmployeeCompanyTraining employeeCompanyTraining = employee.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new EmployeeManagerException(employeeCompanyTraining+" is NOT FOUND" );
			}
			
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  Employee associateEmployeeCompanyTrainingListToNewScoring(RetailscmUserContext userContext, String employeeId, String  employeeCompanyTrainingIds[], String scoredBy, int score, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "oneof", this.joinArray("|", employeeCompanyTrainingIds)).done();
		
		Employee employee = loadEmployee(userContext, employeeId, options);
		
		Scoring scoring = userContext.getManagerGroup().getScoringManager().createScoring(userContext,  scoredBy,  score,  comment);
		
		for(EmployeeCompanyTraining employeeCompanyTraining: employee.getEmployeeCompanyTrainingList()) {
			//TODO: need to check if already associated
			employeeCompanyTraining.updateScoring(scoring);
		}
		return this.internalSaveEmployee(userContext, employee);
	}
	*/
	
	public  Employee associateEmployeeCompanyTrainingListToScoring(RetailscmUserContext userContext, String employeeId, String  employeeCompanyTrainingIds[], String scoringId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "oneof", this.joinArray("|", employeeCompanyTrainingIds)).done();
		
		Employee employee = loadEmployee(userContext, employeeId, options);
		
		Scoring scoring = userContext.getManagerGroup().getScoringManager().loadScoring(userContext,scoringId,new String[]{"none"} );
		
		for(EmployeeCompanyTraining employeeCompanyTraining: employee.getEmployeeCompanyTrainingList()) {
			//TODO: need to check if already associated
			employeeCompanyTraining.updateScoring(scoring);
		}
		return this.internalSaveEmployee(userContext, employee);
	}


	protected void checkParamsForAddingEmployeeSkill(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkSkillTypeIdOfEmployeeSkill(skillTypeId);
		
		userContext.getChecker().checkDescriptionOfEmployeeSkill(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeSkill(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSkill(userContext,employeeId,skillTypeId, description,tokensExpr);
		
		EmployeeSkill employeeSkill = createEmployeeSkill(userContext,skillTypeId, description);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeSkill( employeeSkill );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			
			userContext.getManagerGroup().getEmployeeSkillManager().onNewInstanceCreated(userContext, employeeSkill);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSkillProperties(RetailscmUserContext userContext, String employeeId,String id,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeSkill(id);
		
		userContext.getChecker().checkDescriptionOfEmployeeSkill( description);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeSkillProperties(RetailscmUserContext userContext, String employeeId, String id,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeSkillProperties(userContext,employeeId,id,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSkillListList()
				.searchEmployeeSkillListWith(EmployeeSkill.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeSkillList().isEmpty()){
			throw new EmployeeManagerException("EmployeeSkill is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeSkill item = employeeToUpdate.getEmployeeSkillList().first();
		
		item.updateDescription( description );

		
		//checkParamsForAddingEmployeeSkill(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeSkillList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeSkill createEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String description) throws Exception{

		EmployeeSkill employeeSkill = new EmployeeSkill();
		
		
		SkillType  skillType = new SkillType();
		skillType.setId(skillTypeId);		
		employeeSkill.setSkillType(skillType);		
		employeeSkill.setDescription(description);
	
		
		return employeeSkill;
	
		
	}
	
	protected EmployeeSkill createIndexedEmployeeSkill(String id, int version){

		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setId(id);
		employeeSkill.setVersion(version);
		return employeeSkill;			
		
	}
	
	protected void checkParamsForRemovingEmployeeSkillList(RetailscmUserContext userContext, String employeeId, 
			String employeeSkillIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeSkillId: employeeSkillIds){
			userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeSkillList(RetailscmUserContext userContext, String employeeId, 
			String employeeSkillIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeSkillList(userContext, employeeId,  employeeSkillIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeSkillList(employee, employeeSkillIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeSkillList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeSkill(RetailscmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill(employeeSkillVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeSkill(RetailscmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSkill(userContext,employeeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeSkill( employeeSkill );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			deleteRelationInGraph(userContext, employeeSkill);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeSkill(RetailscmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill(employeeSkillVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeSkillFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSkill(userContext,employeeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeSkillFrom( employeeSkill );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			
			userContext.getManagerGroup().getEmployeeSkillManager().onNewInstanceCreated(userContext, (EmployeeSkill)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeSkill(RetailscmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill(employeeSkillVersion);
		

		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfEmployeeSkill(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeSkill(RetailscmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSkill(userContext, employeeId, employeeSkillId, employeeSkillVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeSkillList().searchEmployeeSkillListWith(EmployeeSkill.ID_PROPERTY, "eq", employeeSkillId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeSkill( employeeSkill );	
			//make changes to AcceleraterAccount.
			EmployeeSkill employeeSkillIndex = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		
			EmployeeSkill employeeSkill = employee.findTheEmployeeSkill(employeeSkillIndex);
			if(employeeSkill == null){
				throw new EmployeeManagerException(employeeSkill+" is NOT FOUND" );
			}
			
			employeeSkill.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeePerformance(RetailscmUserContext userContext, String employeeId, String performanceComment,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkPerformanceCommentOfEmployeePerformance(performanceComment);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeePerformance(RetailscmUserContext userContext, String employeeId, String performanceComment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeePerformance(userContext,employeeId,performanceComment,tokensExpr);
		
		EmployeePerformance employeePerformance = createEmployeePerformance(userContext,performanceComment);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeePerformance( employeePerformance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			
			userContext.getManagerGroup().getEmployeePerformanceManager().onNewInstanceCreated(userContext, employeePerformance);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeePerformanceProperties(RetailscmUserContext userContext, String employeeId,String id,String performanceComment,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeePerformance(id);
		
		userContext.getChecker().checkPerformanceCommentOfEmployeePerformance( performanceComment);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeePerformanceProperties(RetailscmUserContext userContext, String employeeId, String id,String performanceComment, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeePerformanceProperties(userContext,employeeId,id,performanceComment,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeePerformanceListList()
				.searchEmployeePerformanceListWith(EmployeePerformance.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeePerformanceList().isEmpty()){
			throw new EmployeeManagerException("EmployeePerformance is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeePerformance item = employeeToUpdate.getEmployeePerformanceList().first();
		
		item.updatePerformanceComment( performanceComment );

		
		//checkParamsForAddingEmployeePerformance(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeePerformanceList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeePerformance createEmployeePerformance(RetailscmUserContext userContext, String performanceComment) throws Exception{

		EmployeePerformance employeePerformance = new EmployeePerformance();
		
		
		employeePerformance.setPerformanceComment(performanceComment);
	
		
		return employeePerformance;
	
		
	}
	
	protected EmployeePerformance createIndexedEmployeePerformance(String id, int version){

		EmployeePerformance employeePerformance = new EmployeePerformance();
		employeePerformance.setId(id);
		employeePerformance.setVersion(version);
		return employeePerformance;			
		
	}
	
	protected void checkParamsForRemovingEmployeePerformanceList(RetailscmUserContext userContext, String employeeId, 
			String employeePerformanceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeePerformanceId: employeePerformanceIds){
			userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeePerformanceList(RetailscmUserContext userContext, String employeeId, 
			String employeePerformanceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeePerformanceList(userContext, employeeId,  employeePerformanceIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeePerformanceList(employee, employeePerformanceIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeePerformanceList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeePerformance(RetailscmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().checkVersionOfEmployeePerformance(employeePerformanceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeePerformance(RetailscmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeePerformance(userContext,employeeId, employeePerformanceId, employeePerformanceVersion,tokensExpr);
		
		EmployeePerformance employeePerformance = createIndexedEmployeePerformance(employeePerformanceId, employeePerformanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeePerformance( employeePerformance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			deleteRelationInGraph(userContext, employeePerformance);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeePerformance(RetailscmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().checkVersionOfEmployeePerformance(employeePerformanceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeePerformanceFrom(RetailscmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeePerformance(userContext,employeeId, employeePerformanceId, employeePerformanceVersion,tokensExpr);
		
		EmployeePerformance employeePerformance = createIndexedEmployeePerformance(employeePerformanceId, employeePerformanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeePerformanceFrom( employeePerformance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			
			userContext.getManagerGroup().getEmployeePerformanceManager().onNewInstanceCreated(userContext, (EmployeePerformance)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeePerformance(RetailscmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeePerformance(employeePerformanceId);
		userContext.getChecker().checkVersionOfEmployeePerformance(employeePerformanceVersion);
		

		if(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkPerformanceCommentOfEmployeePerformance(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeePerformance(RetailscmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeePerformance(userContext, employeeId, employeePerformanceId, employeePerformanceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeePerformanceList().searchEmployeePerformanceListWith(EmployeePerformance.ID_PROPERTY, "eq", employeePerformanceId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeePerformance( employeePerformance );	
			//make changes to AcceleraterAccount.
			EmployeePerformance employeePerformanceIndex = createIndexedEmployeePerformance(employeePerformanceId, employeePerformanceVersion);
		
			EmployeePerformance employeePerformance = employee.findTheEmployeePerformance(employeePerformanceIndex);
			if(employeePerformance == null){
				throw new EmployeeManagerException(employeePerformance+" is NOT FOUND" );
			}
			
			employeePerformance.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, Date start, Date end, String company, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkStartOfEmployeeWorkExperience(start);
		
		userContext.getChecker().checkEndOfEmployeeWorkExperience(end);
		
		userContext.getChecker().checkCompanyOfEmployeeWorkExperience(company);
		
		userContext.getChecker().checkDescriptionOfEmployeeWorkExperience(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, Date start, Date end, String company, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeWorkExperience(userContext,employeeId,start, end, company, description,tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = createEmployeeWorkExperience(userContext,start, end, company, description);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeWorkExperience( employeeWorkExperience );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			
			userContext.getManagerGroup().getEmployeeWorkExperienceManager().onNewInstanceCreated(userContext, employeeWorkExperience);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeWorkExperienceProperties(RetailscmUserContext userContext, String employeeId,String id,Date start,Date end,String company,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeWorkExperience(id);
		
		userContext.getChecker().checkStartOfEmployeeWorkExperience( start);
		userContext.getChecker().checkEndOfEmployeeWorkExperience( end);
		userContext.getChecker().checkCompanyOfEmployeeWorkExperience( company);
		userContext.getChecker().checkDescriptionOfEmployeeWorkExperience( description);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeWorkExperienceProperties(RetailscmUserContext userContext, String employeeId, String id,Date start,Date end,String company,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeWorkExperienceProperties(userContext,employeeId,id,start,end,company,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeWorkExperienceListList()
				.searchEmployeeWorkExperienceListWith(EmployeeWorkExperience.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeWorkExperienceList().isEmpty()){
			throw new EmployeeManagerException("EmployeeWorkExperience is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeWorkExperience item = employeeToUpdate.getEmployeeWorkExperienceList().first();
		
		item.updateStart( start );
		item.updateEnd( end );
		item.updateCompany( company );
		item.updateDescription( description );

		
		//checkParamsForAddingEmployeeWorkExperience(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeWorkExperienceList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeWorkExperience createEmployeeWorkExperience(RetailscmUserContext userContext, Date start, Date end, String company, String description) throws Exception{

		EmployeeWorkExperience employeeWorkExperience = new EmployeeWorkExperience();
		
		
		employeeWorkExperience.setStart(start);		
		employeeWorkExperience.setEnd(end);		
		employeeWorkExperience.setCompany(company);		
		employeeWorkExperience.setDescription(description);
	
		
		return employeeWorkExperience;
	
		
	}
	
	protected EmployeeWorkExperience createIndexedEmployeeWorkExperience(String id, int version){

		EmployeeWorkExperience employeeWorkExperience = new EmployeeWorkExperience();
		employeeWorkExperience.setId(id);
		employeeWorkExperience.setVersion(version);
		return employeeWorkExperience;			
		
	}
	
	protected void checkParamsForRemovingEmployeeWorkExperienceList(RetailscmUserContext userContext, String employeeId, 
			String employeeWorkExperienceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeWorkExperienceId: employeeWorkExperienceIds){
			userContext.getChecker().checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeWorkExperienceList(RetailscmUserContext userContext, String employeeId, 
			String employeeWorkExperienceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeWorkExperienceList(userContext, employeeId,  employeeWorkExperienceIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeWorkExperienceList(employee, employeeWorkExperienceIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeWorkExperienceList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		userContext.getChecker().checkVersionOfEmployeeWorkExperience(employeeWorkExperienceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeWorkExperience(userContext,employeeId, employeeWorkExperienceId, employeeWorkExperienceVersion,tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = createIndexedEmployeeWorkExperience(employeeWorkExperienceId, employeeWorkExperienceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeWorkExperience( employeeWorkExperience );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			deleteRelationInGraph(userContext, employeeWorkExperience);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		userContext.getChecker().checkVersionOfEmployeeWorkExperience(employeeWorkExperienceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeWorkExperienceFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeWorkExperience(userContext,employeeId, employeeWorkExperienceId, employeeWorkExperienceVersion,tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = createIndexedEmployeeWorkExperience(employeeWorkExperienceId, employeeWorkExperienceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeWorkExperienceFrom( employeeWorkExperience );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			
			userContext.getManagerGroup().getEmployeeWorkExperienceManager().onNewInstanceCreated(userContext, (EmployeeWorkExperience)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		userContext.getChecker().checkVersionOfEmployeeWorkExperience(employeeWorkExperienceVersion);
		

		if(EmployeeWorkExperience.START_PROPERTY.equals(property)){
			userContext.getChecker().checkStartOfEmployeeWorkExperience(parseDate(newValueExpr));
		}
		
		if(EmployeeWorkExperience.END_PROPERTY.equals(property)){
			userContext.getChecker().checkEndOfEmployeeWorkExperience(parseDate(newValueExpr));
		}
		
		if(EmployeeWorkExperience.COMPANY_PROPERTY.equals(property)){
			userContext.getChecker().checkCompanyOfEmployeeWorkExperience(parseString(newValueExpr));
		}
		
		if(EmployeeWorkExperience.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfEmployeeWorkExperience(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeWorkExperience(userContext, employeeId, employeeWorkExperienceId, employeeWorkExperienceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeWorkExperienceList().searchEmployeeWorkExperienceListWith(EmployeeWorkExperience.ID_PROPERTY, "eq", employeeWorkExperienceId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeWorkExperience( employeeWorkExperience );	
			//make changes to AcceleraterAccount.
			EmployeeWorkExperience employeeWorkExperienceIndex = createIndexedEmployeeWorkExperience(employeeWorkExperienceId, employeeWorkExperienceVersion);
		
			EmployeeWorkExperience employeeWorkExperience = employee.findTheEmployeeWorkExperience(employeeWorkExperienceIndex);
			if(employeeWorkExperience == null){
				throw new EmployeeManagerException(employeeWorkExperience+" is NOT FOUND" );
			}
			
			employeeWorkExperience.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeLeave(RetailscmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkTypeIdOfEmployeeLeave(typeId);
		
		userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);
		
		userContext.getChecker().checkRemarkOfEmployeeLeave(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeLeave(RetailscmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeLeave(userContext,employeeId,typeId, leaveDurationHour, remark,tokensExpr);
		
		EmployeeLeave employeeLeave = createEmployeeLeave(userContext,typeId, leaveDurationHour, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeLeave( employeeLeave );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			
			userContext.getManagerGroup().getEmployeeLeaveManager().onNewInstanceCreated(userContext, employeeLeave);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeLeaveProperties(RetailscmUserContext userContext, String employeeId,String id,int leaveDurationHour,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeLeave(id);
		
		userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave( leaveDurationHour);
		userContext.getChecker().checkRemarkOfEmployeeLeave( remark);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeLeaveProperties(RetailscmUserContext userContext, String employeeId, String id,int leaveDurationHour,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeLeaveProperties(userContext,employeeId,id,leaveDurationHour,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeLeaveListList()
				.searchEmployeeLeaveListWith(EmployeeLeave.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeLeaveList().isEmpty()){
			throw new EmployeeManagerException("EmployeeLeave is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeLeave item = employeeToUpdate.getEmployeeLeaveList().first();
		
		item.updateLeaveDurationHour( leaveDurationHour );
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeLeave(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeLeaveList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeLeave createEmployeeLeave(RetailscmUserContext userContext, String typeId, int leaveDurationHour, String remark) throws Exception{

		EmployeeLeave employeeLeave = new EmployeeLeave();
		
		
		LeaveType  type = new LeaveType();
		type.setId(typeId);		
		employeeLeave.setType(type);		
		employeeLeave.setLeaveDurationHour(leaveDurationHour);		
		employeeLeave.setRemark(remark);
	
		
		return employeeLeave;
	
		
	}
	
	protected EmployeeLeave createIndexedEmployeeLeave(String id, int version){

		EmployeeLeave employeeLeave = new EmployeeLeave();
		employeeLeave.setId(id);
		employeeLeave.setVersion(version);
		return employeeLeave;			
		
	}
	
	protected void checkParamsForRemovingEmployeeLeaveList(RetailscmUserContext userContext, String employeeId, 
			String employeeLeaveIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeLeaveId: employeeLeaveIds){
			userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeLeaveList(RetailscmUserContext userContext, String employeeId, 
			String employeeLeaveIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeLeaveList(userContext, employeeId,  employeeLeaveIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeLeaveList(employee, employeeLeaveIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeLeaveList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeLeave(RetailscmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave(employeeLeaveVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeLeave(RetailscmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeLeave(userContext,employeeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeLeave( employeeLeave );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			deleteRelationInGraph(userContext, employeeLeave);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeLeave(RetailscmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave(employeeLeaveVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeLeaveFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeLeave(userContext,employeeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeLeaveFrom( employeeLeave );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			
			userContext.getManagerGroup().getEmployeeLeaveManager().onNewInstanceCreated(userContext, (EmployeeLeave)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeLeave(RetailscmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave(employeeLeaveVersion);
		

		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave(parseInt(newValueExpr));
		}
		
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeLeave(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeLeave(RetailscmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeLeave(userContext, employeeId, employeeLeaveId, employeeLeaveVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeLeaveList().searchEmployeeLeaveListWith(EmployeeLeave.ID_PROPERTY, "eq", employeeLeaveId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeLeave( employeeLeave );	
			//make changes to AcceleraterAccount.
			EmployeeLeave employeeLeaveIndex = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		
			EmployeeLeave employeeLeave = employee.findTheEmployeeLeave(employeeLeaveIndex);
			if(employeeLeave == null){
				throw new EmployeeManagerException(employeeLeave+" is NOT FOUND" );
			}
			
			employeeLeave.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeInterview(RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkInterviewTypeIdOfEmployeeInterview(interviewTypeId);
		
		userContext.getChecker().checkRemarkOfEmployeeInterview(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeInterview(RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeInterview(userContext,employeeId,interviewTypeId, remark,tokensExpr);
		
		EmployeeInterview employeeInterview = createEmployeeInterview(userContext,interviewTypeId, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeInterview( employeeInterview );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			
			userContext.getManagerGroup().getEmployeeInterviewManager().onNewInstanceCreated(userContext, employeeInterview);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeInterviewProperties(RetailscmUserContext userContext, String employeeId,String id,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeInterview(id);
		
		userContext.getChecker().checkRemarkOfEmployeeInterview( remark);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeInterviewProperties(RetailscmUserContext userContext, String employeeId, String id,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeInterviewProperties(userContext,employeeId,id,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeInterviewListList()
				.searchEmployeeInterviewListWith(EmployeeInterview.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeInterviewList().isEmpty()){
			throw new EmployeeManagerException("EmployeeInterview is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeInterview item = employeeToUpdate.getEmployeeInterviewList().first();
		
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeInterview(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeInterviewList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeInterview createEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String remark) throws Exception{

		EmployeeInterview employeeInterview = new EmployeeInterview();
		
		
		InterviewType  interviewType = new InterviewType();
		interviewType.setId(interviewTypeId);		
		employeeInterview.setInterviewType(interviewType);		
		employeeInterview.setRemark(remark);
	
		
		return employeeInterview;
	
		
	}
	
	protected EmployeeInterview createIndexedEmployeeInterview(String id, int version){

		EmployeeInterview employeeInterview = new EmployeeInterview();
		employeeInterview.setId(id);
		employeeInterview.setVersion(version);
		return employeeInterview;			
		
	}
	
	protected void checkParamsForRemovingEmployeeInterviewList(RetailscmUserContext userContext, String employeeId, 
			String employeeInterviewIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeInterviewId: employeeInterviewIds){
			userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeInterviewList(RetailscmUserContext userContext, String employeeId, 
			String employeeInterviewIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeInterviewList(userContext, employeeId,  employeeInterviewIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeInterviewList(employee, employeeInterviewIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeInterviewList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeInterview(RetailscmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview(employeeInterviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeInterview(RetailscmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeInterview(userContext,employeeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeInterview( employeeInterview );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			deleteRelationInGraph(userContext, employeeInterview);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeInterview(RetailscmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview(employeeInterviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeInterviewFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeInterview(userContext,employeeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeInterviewFrom( employeeInterview );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			
			userContext.getManagerGroup().getEmployeeInterviewManager().onNewInstanceCreated(userContext, (EmployeeInterview)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeInterview(RetailscmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview(employeeInterviewVersion);
		

		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeInterview(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeInterview(RetailscmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeInterview(userContext, employeeId, employeeInterviewId, employeeInterviewVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeInterviewList().searchEmployeeInterviewListWith(EmployeeInterview.ID_PROPERTY, "eq", employeeInterviewId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeInterview( employeeInterview );	
			//make changes to AcceleraterAccount.
			EmployeeInterview employeeInterviewIndex = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		
			EmployeeInterview employeeInterview = employee.findTheEmployeeInterview(employeeInterviewIndex);
			if(employeeInterview == null){
				throw new EmployeeManagerException(employeeInterview+" is NOT FOUND" );
			}
			
			employeeInterview.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeAttendance(RetailscmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkEnterTimeOfEmployeeAttendance(enterTime);
		
		userContext.getChecker().checkLeaveTimeOfEmployeeAttendance(leaveTime);
		
		userContext.getChecker().checkDurationHoursOfEmployeeAttendance(durationHours);
		
		userContext.getChecker().checkRemarkOfEmployeeAttendance(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeAttendance(RetailscmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeAttendance(userContext,employeeId,enterTime, leaveTime, durationHours, remark,tokensExpr);
		
		EmployeeAttendance employeeAttendance = createEmployeeAttendance(userContext,enterTime, leaveTime, durationHours, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeAttendance( employeeAttendance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			
			userContext.getManagerGroup().getEmployeeAttendanceManager().onNewInstanceCreated(userContext, employeeAttendance);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeAttendanceProperties(RetailscmUserContext userContext, String employeeId,String id,Date enterTime,Date leaveTime,int durationHours,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeAttendance(id);
		
		userContext.getChecker().checkEnterTimeOfEmployeeAttendance( enterTime);
		userContext.getChecker().checkLeaveTimeOfEmployeeAttendance( leaveTime);
		userContext.getChecker().checkDurationHoursOfEmployeeAttendance( durationHours);
		userContext.getChecker().checkRemarkOfEmployeeAttendance( remark);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeAttendanceProperties(RetailscmUserContext userContext, String employeeId, String id,Date enterTime,Date leaveTime,int durationHours,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeAttendanceProperties(userContext,employeeId,id,enterTime,leaveTime,durationHours,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeAttendanceListList()
				.searchEmployeeAttendanceListWith(EmployeeAttendance.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeAttendanceList().isEmpty()){
			throw new EmployeeManagerException("EmployeeAttendance is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeAttendance item = employeeToUpdate.getEmployeeAttendanceList().first();
		
		item.updateEnterTime( enterTime );
		item.updateLeaveTime( leaveTime );
		item.updateDurationHours( durationHours );
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeAttendance(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeAttendanceList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeAttendance createEmployeeAttendance(RetailscmUserContext userContext, Date enterTime, Date leaveTime, int durationHours, String remark) throws Exception{

		EmployeeAttendance employeeAttendance = new EmployeeAttendance();
		
		
		employeeAttendance.setEnterTime(enterTime);		
		employeeAttendance.setLeaveTime(leaveTime);		
		employeeAttendance.setDurationHours(durationHours);		
		employeeAttendance.setRemark(remark);
	
		
		return employeeAttendance;
	
		
	}
	
	protected EmployeeAttendance createIndexedEmployeeAttendance(String id, int version){

		EmployeeAttendance employeeAttendance = new EmployeeAttendance();
		employeeAttendance.setId(id);
		employeeAttendance.setVersion(version);
		return employeeAttendance;			
		
	}
	
	protected void checkParamsForRemovingEmployeeAttendanceList(RetailscmUserContext userContext, String employeeId, 
			String employeeAttendanceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeAttendanceId: employeeAttendanceIds){
			userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeAttendanceList(RetailscmUserContext userContext, String employeeId, 
			String employeeAttendanceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeAttendanceList(userContext, employeeId,  employeeAttendanceIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeAttendanceList(employee, employeeAttendanceIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeAttendanceList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeAttendance(RetailscmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().checkVersionOfEmployeeAttendance(employeeAttendanceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeAttendance(RetailscmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeAttendance(userContext,employeeId, employeeAttendanceId, employeeAttendanceVersion,tokensExpr);
		
		EmployeeAttendance employeeAttendance = createIndexedEmployeeAttendance(employeeAttendanceId, employeeAttendanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeAttendance( employeeAttendance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			deleteRelationInGraph(userContext, employeeAttendance);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeAttendance(RetailscmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().checkVersionOfEmployeeAttendance(employeeAttendanceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeAttendanceFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeAttendance(userContext,employeeId, employeeAttendanceId, employeeAttendanceVersion,tokensExpr);
		
		EmployeeAttendance employeeAttendance = createIndexedEmployeeAttendance(employeeAttendanceId, employeeAttendanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeAttendanceFrom( employeeAttendance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			
			userContext.getManagerGroup().getEmployeeAttendanceManager().onNewInstanceCreated(userContext, (EmployeeAttendance)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeAttendance(RetailscmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeAttendance(employeeAttendanceId);
		userContext.getChecker().checkVersionOfEmployeeAttendance(employeeAttendanceVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeAttendance(RetailscmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeId, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeAttendanceList().searchEmployeeAttendanceListWith(EmployeeAttendance.ID_PROPERTY, "eq", employeeAttendanceId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeAttendance( employeeAttendance );	
			//make changes to AcceleraterAccount.
			EmployeeAttendance employeeAttendanceIndex = createIndexedEmployeeAttendance(employeeAttendanceId, employeeAttendanceVersion);
		
			EmployeeAttendance employeeAttendance = employee.findTheEmployeeAttendance(employeeAttendanceIndex);
			if(employeeAttendance == null){
				throw new EmployeeManagerException(employeeAttendance+" is NOT FOUND" );
			}
			
			employeeAttendance.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeQualifier(RetailscmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkQualifiedTimeOfEmployeeQualifier(qualifiedTime);
		
		userContext.getChecker().checkTypeOfEmployeeQualifier(type);
		
		userContext.getChecker().checkLevelOfEmployeeQualifier(level);
		
		userContext.getChecker().checkRemarkOfEmployeeQualifier(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeQualifier(RetailscmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeQualifier(userContext,employeeId,qualifiedTime, type, level, remark,tokensExpr);
		
		EmployeeQualifier employeeQualifier = createEmployeeQualifier(userContext,qualifiedTime, type, level, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeQualifier( employeeQualifier );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			
			userContext.getManagerGroup().getEmployeeQualifierManager().onNewInstanceCreated(userContext, employeeQualifier);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeQualifierProperties(RetailscmUserContext userContext, String employeeId,String id,Date qualifiedTime,String type,String level,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeQualifier(id);
		
		userContext.getChecker().checkQualifiedTimeOfEmployeeQualifier( qualifiedTime);
		userContext.getChecker().checkTypeOfEmployeeQualifier( type);
		userContext.getChecker().checkLevelOfEmployeeQualifier( level);
		userContext.getChecker().checkRemarkOfEmployeeQualifier( remark);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeQualifierProperties(RetailscmUserContext userContext, String employeeId, String id,Date qualifiedTime,String type,String level,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeQualifierProperties(userContext,employeeId,id,qualifiedTime,type,level,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeQualifierListList()
				.searchEmployeeQualifierListWith(EmployeeQualifier.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeQualifierList().isEmpty()){
			throw new EmployeeManagerException("EmployeeQualifier is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeQualifier item = employeeToUpdate.getEmployeeQualifierList().first();
		
		item.updateQualifiedTime( qualifiedTime );
		item.updateType( type );
		item.updateLevel( level );
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeQualifier(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeQualifierList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeQualifier createEmployeeQualifier(RetailscmUserContext userContext, Date qualifiedTime, String type, String level, String remark) throws Exception{

		EmployeeQualifier employeeQualifier = new EmployeeQualifier();
		
		
		employeeQualifier.setQualifiedTime(qualifiedTime);		
		employeeQualifier.setType(type);		
		employeeQualifier.setLevel(level);		
		employeeQualifier.setRemark(remark);
	
		
		return employeeQualifier;
	
		
	}
	
	protected EmployeeQualifier createIndexedEmployeeQualifier(String id, int version){

		EmployeeQualifier employeeQualifier = new EmployeeQualifier();
		employeeQualifier.setId(id);
		employeeQualifier.setVersion(version);
		return employeeQualifier;			
		
	}
	
	protected void checkParamsForRemovingEmployeeQualifierList(RetailscmUserContext userContext, String employeeId, 
			String employeeQualifierIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeQualifierId: employeeQualifierIds){
			userContext.getChecker().checkIdOfEmployeeQualifier(employeeQualifierId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeQualifierList(RetailscmUserContext userContext, String employeeId, 
			String employeeQualifierIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeQualifierList(userContext, employeeId,  employeeQualifierIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeQualifierList(employee, employeeQualifierIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeQualifierList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeQualifier(RetailscmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeQualifier(employeeQualifierId);
		userContext.getChecker().checkVersionOfEmployeeQualifier(employeeQualifierVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeQualifier(RetailscmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeQualifier(userContext,employeeId, employeeQualifierId, employeeQualifierVersion,tokensExpr);
		
		EmployeeQualifier employeeQualifier = createIndexedEmployeeQualifier(employeeQualifierId, employeeQualifierVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeQualifier( employeeQualifier );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			deleteRelationInGraph(userContext, employeeQualifier);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeQualifier(RetailscmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeQualifier(employeeQualifierId);
		userContext.getChecker().checkVersionOfEmployeeQualifier(employeeQualifierVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeQualifierFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeQualifier(userContext,employeeId, employeeQualifierId, employeeQualifierVersion,tokensExpr);
		
		EmployeeQualifier employeeQualifier = createIndexedEmployeeQualifier(employeeQualifierId, employeeQualifierVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeQualifierFrom( employeeQualifier );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			
			userContext.getManagerGroup().getEmployeeQualifierManager().onNewInstanceCreated(userContext, (EmployeeQualifier)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeQualifier(RetailscmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeQualifier(employeeQualifierId);
		userContext.getChecker().checkVersionOfEmployeeQualifier(employeeQualifierVersion);
		

		if(EmployeeQualifier.QUALIFIED_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkQualifiedTimeOfEmployeeQualifier(parseDate(newValueExpr));
		}
		
		if(EmployeeQualifier.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfEmployeeQualifier(parseString(newValueExpr));
		}
		
		if(EmployeeQualifier.LEVEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLevelOfEmployeeQualifier(parseString(newValueExpr));
		}
		
		if(EmployeeQualifier.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeQualifier(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeQualifier(RetailscmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeQualifier(userContext, employeeId, employeeQualifierId, employeeQualifierVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeQualifierList().searchEmployeeQualifierListWith(EmployeeQualifier.ID_PROPERTY, "eq", employeeQualifierId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeQualifier( employeeQualifier );	
			//make changes to AcceleraterAccount.
			EmployeeQualifier employeeQualifierIndex = createIndexedEmployeeQualifier(employeeQualifierId, employeeQualifierVersion);
		
			EmployeeQualifier employeeQualifier = employee.findTheEmployeeQualifier(employeeQualifierIndex);
			if(employeeQualifier == null){
				throw new EmployeeManagerException(employeeQualifier+" is NOT FOUND" );
			}
			
			employeeQualifier.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeEducation(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkCompleteTimeOfEmployeeEducation(completeTime);
		
		userContext.getChecker().checkTypeOfEmployeeEducation(type);
		
		userContext.getChecker().checkRemarkOfEmployeeEducation(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeEducation(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeEducation(userContext,employeeId,completeTime, type, remark,tokensExpr);
		
		EmployeeEducation employeeEducation = createEmployeeEducation(userContext,completeTime, type, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeEducation( employeeEducation );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			
			userContext.getManagerGroup().getEmployeeEducationManager().onNewInstanceCreated(userContext, employeeEducation);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeEducationProperties(RetailscmUserContext userContext, String employeeId,String id,Date completeTime,String type,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeEducation(id);
		
		userContext.getChecker().checkCompleteTimeOfEmployeeEducation( completeTime);
		userContext.getChecker().checkTypeOfEmployeeEducation( type);
		userContext.getChecker().checkRemarkOfEmployeeEducation( remark);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeEducationProperties(RetailscmUserContext userContext, String employeeId, String id,Date completeTime,String type,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeEducationProperties(userContext,employeeId,id,completeTime,type,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeEducationListList()
				.searchEmployeeEducationListWith(EmployeeEducation.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeEducationList().isEmpty()){
			throw new EmployeeManagerException("EmployeeEducation is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeEducation item = employeeToUpdate.getEmployeeEducationList().first();
		
		item.updateCompleteTime( completeTime );
		item.updateType( type );
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeEducation(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeEducationList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeEducation createEmployeeEducation(RetailscmUserContext userContext, Date completeTime, String type, String remark) throws Exception{

		EmployeeEducation employeeEducation = new EmployeeEducation();
		
		
		employeeEducation.setCompleteTime(completeTime);		
		employeeEducation.setType(type);		
		employeeEducation.setRemark(remark);
	
		
		return employeeEducation;
	
		
	}
	
	protected EmployeeEducation createIndexedEmployeeEducation(String id, int version){

		EmployeeEducation employeeEducation = new EmployeeEducation();
		employeeEducation.setId(id);
		employeeEducation.setVersion(version);
		return employeeEducation;			
		
	}
	
	protected void checkParamsForRemovingEmployeeEducationList(RetailscmUserContext userContext, String employeeId, 
			String employeeEducationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeEducationId: employeeEducationIds){
			userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeEducationList(RetailscmUserContext userContext, String employeeId, 
			String employeeEducationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeEducationList(userContext, employeeId,  employeeEducationIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeEducationList(employee, employeeEducationIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeEducationList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeEducation(RetailscmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().checkVersionOfEmployeeEducation(employeeEducationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeEducation(RetailscmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeEducation(userContext,employeeId, employeeEducationId, employeeEducationVersion,tokensExpr);
		
		EmployeeEducation employeeEducation = createIndexedEmployeeEducation(employeeEducationId, employeeEducationVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeEducation( employeeEducation );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			deleteRelationInGraph(userContext, employeeEducation);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeEducation(RetailscmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().checkVersionOfEmployeeEducation(employeeEducationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeEducationFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeEducation(userContext,employeeId, employeeEducationId, employeeEducationVersion,tokensExpr);
		
		EmployeeEducation employeeEducation = createIndexedEmployeeEducation(employeeEducationId, employeeEducationVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeEducationFrom( employeeEducation );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			
			userContext.getManagerGroup().getEmployeeEducationManager().onNewInstanceCreated(userContext, (EmployeeEducation)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeEducation(RetailscmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeEducation(employeeEducationId);
		userContext.getChecker().checkVersionOfEmployeeEducation(employeeEducationVersion);
		

		if(EmployeeEducation.COMPLETE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCompleteTimeOfEmployeeEducation(parseDate(newValueExpr));
		}
		
		if(EmployeeEducation.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfEmployeeEducation(parseString(newValueExpr));
		}
		
		if(EmployeeEducation.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeEducation(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeEducation(RetailscmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeEducation(userContext, employeeId, employeeEducationId, employeeEducationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeEducationList().searchEmployeeEducationListWith(EmployeeEducation.ID_PROPERTY, "eq", employeeEducationId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeEducation( employeeEducation );	
			//make changes to AcceleraterAccount.
			EmployeeEducation employeeEducationIndex = createIndexedEmployeeEducation(employeeEducationId, employeeEducationVersion);
		
			EmployeeEducation employeeEducation = employee.findTheEmployeeEducation(employeeEducationIndex);
			if(employeeEducation == null){
				throw new EmployeeManagerException(employeeEducation+" is NOT FOUND" );
			}
			
			employeeEducation.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeAward(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkCompleteTimeOfEmployeeAward(completeTime);
		
		userContext.getChecker().checkTypeOfEmployeeAward(type);
		
		userContext.getChecker().checkRemarkOfEmployeeAward(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeAward(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeAward(userContext,employeeId,completeTime, type, remark,tokensExpr);
		
		EmployeeAward employeeAward = createEmployeeAward(userContext,completeTime, type, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeAward( employeeAward );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			
			userContext.getManagerGroup().getEmployeeAwardManager().onNewInstanceCreated(userContext, employeeAward);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeAwardProperties(RetailscmUserContext userContext, String employeeId,String id,Date completeTime,String type,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeAward(id);
		
		userContext.getChecker().checkCompleteTimeOfEmployeeAward( completeTime);
		userContext.getChecker().checkTypeOfEmployeeAward( type);
		userContext.getChecker().checkRemarkOfEmployeeAward( remark);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeAwardProperties(RetailscmUserContext userContext, String employeeId, String id,Date completeTime,String type,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeAwardProperties(userContext,employeeId,id,completeTime,type,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeAwardListList()
				.searchEmployeeAwardListWith(EmployeeAward.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeAwardList().isEmpty()){
			throw new EmployeeManagerException("EmployeeAward is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeAward item = employeeToUpdate.getEmployeeAwardList().first();
		
		item.updateCompleteTime( completeTime );
		item.updateType( type );
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeAward(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeAwardList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeAward createEmployeeAward(RetailscmUserContext userContext, Date completeTime, String type, String remark) throws Exception{

		EmployeeAward employeeAward = new EmployeeAward();
		
		
		employeeAward.setCompleteTime(completeTime);		
		employeeAward.setType(type);		
		employeeAward.setRemark(remark);
	
		
		return employeeAward;
	
		
	}
	
	protected EmployeeAward createIndexedEmployeeAward(String id, int version){

		EmployeeAward employeeAward = new EmployeeAward();
		employeeAward.setId(id);
		employeeAward.setVersion(version);
		return employeeAward;			
		
	}
	
	protected void checkParamsForRemovingEmployeeAwardList(RetailscmUserContext userContext, String employeeId, 
			String employeeAwardIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeAwardId: employeeAwardIds){
			userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeAwardList(RetailscmUserContext userContext, String employeeId, 
			String employeeAwardIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeAwardList(userContext, employeeId,  employeeAwardIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeAwardList(employee, employeeAwardIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeAwardList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeAward(RetailscmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().checkVersionOfEmployeeAward(employeeAwardVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeAward(RetailscmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeAward(userContext,employeeId, employeeAwardId, employeeAwardVersion,tokensExpr);
		
		EmployeeAward employeeAward = createIndexedEmployeeAward(employeeAwardId, employeeAwardVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeAward( employeeAward );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			deleteRelationInGraph(userContext, employeeAward);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeAward(RetailscmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().checkVersionOfEmployeeAward(employeeAwardVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeAwardFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeAward(userContext,employeeId, employeeAwardId, employeeAwardVersion,tokensExpr);
		
		EmployeeAward employeeAward = createIndexedEmployeeAward(employeeAwardId, employeeAwardVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeAwardFrom( employeeAward );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			
			userContext.getManagerGroup().getEmployeeAwardManager().onNewInstanceCreated(userContext, (EmployeeAward)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeAward(RetailscmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeAward(employeeAwardId);
		userContext.getChecker().checkVersionOfEmployeeAward(employeeAwardVersion);
		

		if(EmployeeAward.COMPLETE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCompleteTimeOfEmployeeAward(parseDate(newValueExpr));
		}
		
		if(EmployeeAward.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfEmployeeAward(parseString(newValueExpr));
		}
		
		if(EmployeeAward.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeAward(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeAward(RetailscmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeAward(userContext, employeeId, employeeAwardId, employeeAwardVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeAwardList().searchEmployeeAwardListWith(EmployeeAward.ID_PROPERTY, "eq", employeeAwardId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeAward( employeeAward );	
			//make changes to AcceleraterAccount.
			EmployeeAward employeeAwardIndex = createIndexedEmployeeAward(employeeAwardId, employeeAwardVersion);
		
			EmployeeAward employeeAward = employee.findTheEmployeeAward(employeeAwardIndex);
			if(employeeAward == null){
				throw new EmployeeManagerException(employeeAward+" is NOT FOUND" );
			}
			
			employeeAward.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkCurrentSalaryGradeIdOfEmployeeSalarySheet(currentSalaryGradeId);
		
		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
		
		userContext.getChecker().checkBonusOfEmployeeSalarySheet(bonus);
		
		userContext.getChecker().checkRewardOfEmployeeSalarySheet(reward);
		
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet(personalTax);
		
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
		
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet(housingFound);
		
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSalarySheet(userContext,employeeId,currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeSalarySheet( employeeSalarySheet );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			
			userContext.getManagerGroup().getEmployeeSalarySheetManager().onNewInstanceCreated(userContext, employeeSalarySheet);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSalarySheetProperties(RetailscmUserContext userContext, String employeeId,String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(id);
		
		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet( baseSalary);
		userContext.getChecker().checkBonusOfEmployeeSalarySheet( bonus);
		userContext.getChecker().checkRewardOfEmployeeSalarySheet( reward);
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet( personalTax);
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet( socialSecurity);
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet( housingFound);
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet( jobInsurance);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updateEmployeeSalarySheetProperties(RetailscmUserContext userContext, String employeeId, String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeSalarySheetProperties(userContext,employeeId,id,baseSalary,bonus,reward,personalTax,socialSecurity,housingFound,jobInsurance,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSalarySheetListList()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getEmployeeSalarySheetList().isEmpty()){
			throw new EmployeeManagerException("EmployeeSalarySheet is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeSalarySheet item = employeeToUpdate.getEmployeeSalarySheetList().first();
		
		item.updateBaseSalary( baseSalary );
		item.updateBonus( bonus );
		item.updateReward( reward );
		item.updatePersonalTax( personalTax );
		item.updateSocialSecurity( socialSecurity );
		item.updateHousingFound( housingFound );
		item.updateJobInsurance( jobInsurance );

		
		//checkParamsForAddingEmployeeSalarySheet(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withEmployeeSalarySheetList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance) throws Exception{

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		
		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);		
		employeeSalarySheet.setBaseSalary(baseSalary);		
		employeeSalarySheet.setBonus(bonus);		
		employeeSalarySheet.setReward(reward);		
		employeeSalarySheet.setPersonalTax(personalTax);		
		employeeSalarySheet.setSocialSecurity(socialSecurity);		
		employeeSalarySheet.setHousingFound(housingFound);		
		employeeSalarySheet.setJobInsurance(jobInsurance);		
		employeeSalarySheet.setCurrentStatus("INIT");
	
		
		return employeeSalarySheet;
	
		
	}
	
	protected EmployeeSalarySheet createIndexedEmployeeSalarySheet(String id, int version){

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheet.setId(id);
		employeeSalarySheet.setVersion(version);
		return employeeSalarySheet;			
		
	}
	
	protected void checkParamsForRemovingEmployeeSalarySheetList(RetailscmUserContext userContext, String employeeId, 
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String employeeSalarySheetId: employeeSalarySheetIds){
			userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removeEmployeeSalarySheetList(RetailscmUserContext userContext, String employeeId, 
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeSalarySheetList(userContext, employeeId,  employeeSalarySheetIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemoveEmployeeSalarySheetList(employee, employeeSalarySheetIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeSalarySheetList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removeEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSalarySheet(userContext,employeeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeSalarySheet( employeeSalarySheet );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			deleteRelationInGraph(userContext, employeeSalarySheet);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyEmployeeSalarySheetFrom(RetailscmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSalarySheet(userContext,employeeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyEmployeeSalarySheetFrom( employeeSalarySheet );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			
			userContext.getManagerGroup().getEmployeeSalarySheetManager().onNewInstanceCreated(userContext, (EmployeeSalarySheet)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		

		if(EmployeeSalarySheet.BASE_SALARY_PROPERTY.equals(property)){
			userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
		if(EmployeeSalarySheet.BONUS_PROPERTY.equals(property)){
			userContext.getChecker().checkBonusOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
		if(EmployeeSalarySheet.REWARD_PROPERTY.equals(property)){
			userContext.getChecker().checkRewardOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
		if(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY.equals(property)){
			userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
		if(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY.equals(property)){
			userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
		if(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY.equals(property)){
			userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
		if(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY.equals(property)){
			userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updateEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSalarySheet(userContext, employeeId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeSalarySheetList().searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "eq", employeeSalarySheetId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeSalarySheet( employeeSalarySheet );	
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIndex = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		
			EmployeeSalarySheet employeeSalarySheet = employee.findTheEmployeeSalarySheet(employeeSalarySheetIndex);
			if(employeeSalarySheet == null){
				throw new EmployeeManagerException(employeeSalarySheet+" is NOT FOUND" );
			}
			
			employeeSalarySheet.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  Employee associateEmployeeSalarySheetListToNewPayingOff(RetailscmUserContext userContext, String employeeId, String  employeeSalarySheetIds[], String who, String paidForId, Date paidTime, BigDecimal amount, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "oneof", this.joinArray("|", employeeSalarySheetIds)).done();
		
		Employee employee = loadEmployee(userContext, employeeId, options);
		
		PayingOff payingOff = userContext.getManagerGroup().getPayingOffManager().createPayingOff(userContext,  who, paidForId,  paidTime,  amount);
		
		for(EmployeeSalarySheet employeeSalarySheet: employee.getEmployeeSalarySheetList()) {
			//TODO: need to check if already associated
			employeeSalarySheet.updatePayingOff(payingOff);
		}
		return this.internalSaveEmployee(userContext, employee);
	}
	*/
	
	public  Employee associateEmployeeSalarySheetListToPayingOff(RetailscmUserContext userContext, String employeeId, String  employeeSalarySheetIds[], String payingOffId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "oneof", this.joinArray("|", employeeSalarySheetIds)).done();
		
		Employee employee = loadEmployee(userContext, employeeId, options);
		
		PayingOff payingOff = userContext.getManagerGroup().getPayingOffManager().loadPayingOff(userContext,payingOffId,new String[]{"none"} );
		
		for(EmployeeSalarySheet employeeSalarySheet: employee.getEmployeeSalarySheetList()) {
			//TODO: need to check if already associated
			employeeSalarySheet.updatePayingOff(payingOff);
		}
		return this.internalSaveEmployee(userContext, employee);
	}


	protected void checkParamsForAddingPayingOff(RetailscmUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployee(employeeId);

		
		userContext.getChecker().checkWhoOfPayingOff(who);
		
		userContext.getChecker().checkPaidTimeOfPayingOff(paidTime);
		
		userContext.getChecker().checkAmountOfPayingOff(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);

	
	}
	public  Employee addPayingOff(RetailscmUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPayingOff(userContext,employeeId,who, paidTime, amount,tokensExpr);
		
		PayingOff payingOff = createPayingOff(userContext,who, paidTime, amount);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addPayingOff( payingOff );		
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			
			userContext.getManagerGroup().getPayingOffManager().onNewInstanceCreated(userContext, payingOff);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPayingOffProperties(RetailscmUserContext userContext, String employeeId,String id,String who,Date paidTime,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfPayingOff(id);
		
		userContext.getChecker().checkWhoOfPayingOff( who);
		userContext.getChecker().checkPaidTimeOfPayingOff( paidTime);
		userContext.getChecker().checkAmountOfPayingOff( amount);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee updatePayingOffProperties(RetailscmUserContext userContext, String employeeId, String id,String who,Date paidTime,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPayingOffProperties(userContext,employeeId,id,who,paidTime,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPayingOffListList()
				.searchPayingOffListWith(PayingOff.ID_PROPERTY, "is", id).done();
		
		Employee employeeToUpdate = loadEmployee(userContext, employeeId, options);
		
		if(employeeToUpdate.getPayingOffList().isEmpty()){
			throw new EmployeeManagerException("PayingOff is NOT FOUND with id: '"+id+"'");
		}
		
		PayingOff item = employeeToUpdate.getPayingOffList().first();
		
		item.updateWho( who );
		item.updatePaidTime( paidTime );
		item.updateAmount( amount );

		
		//checkParamsForAddingPayingOff(userContext,employeeId,name, code, used,tokensExpr);
		Employee employee = saveEmployee(userContext, employeeToUpdate, tokens().withPayingOffList().done());
		synchronized(employee){ 
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PayingOff createPayingOff(RetailscmUserContext userContext, String who, Date paidTime, BigDecimal amount) throws Exception{

		PayingOff payingOff = new PayingOff();
		
		
		payingOff.setWho(who);		
		payingOff.setPaidTime(paidTime);		
		payingOff.setAmount(amount);
	
		
		return payingOff;
	
		
	}
	
	protected PayingOff createIndexedPayingOff(String id, int version){

		PayingOff payingOff = new PayingOff();
		payingOff.setId(id);
		payingOff.setVersion(version);
		return payingOff;			
		
	}
	
	protected void checkParamsForRemovingPayingOffList(RetailscmUserContext userContext, String employeeId, 
			String payingOffIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		for(String payingOffId: payingOffIds){
			userContext.getChecker().checkIdOfPayingOff(payingOffId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
		
	}
	public  Employee removePayingOffList(RetailscmUserContext userContext, String employeeId, 
			String payingOffIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPayingOffList(userContext, employeeId,  payingOffIds, tokensExpr);
			
			
			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){ 
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeDAO().planToRemovePayingOffList(employee, payingOffIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
				deleteRelationListInGraph(userContext, employee.getPayingOffList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPayingOff(RetailscmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().checkVersionOfPayingOff(payingOffVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee removePayingOff(RetailscmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPayingOff(userContext,employeeId, payingOffId, payingOffVersion,tokensExpr);
		
		PayingOff payingOff = createIndexedPayingOff(payingOffId, payingOffVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removePayingOff( payingOff );		
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			deleteRelationInGraph(userContext, payingOff);
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPayingOff(RetailscmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployee( employeeId);
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().checkVersionOfPayingOff(payingOffVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	public  Employee copyPayingOffFrom(RetailscmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPayingOff(userContext,employeeId, payingOffId, payingOffVersion,tokensExpr);
		
		PayingOff payingOff = createIndexedPayingOff(payingOffId, payingOffVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			employee.copyPayingOffFrom( payingOff );		
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			
			userContext.getManagerGroup().getPayingOffManager().onNewInstanceCreated(userContext, (PayingOff)employee.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPayingOff(RetailscmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().checkVersionOfPayingOff(payingOffVersion);
		

		if(PayingOff.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfPayingOff(parseString(newValueExpr));
		}
		
		if(PayingOff.PAID_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkPaidTimeOfPayingOff(parseDate(newValueExpr));
		}
		
		if(PayingOff.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfPayingOff(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeManagerException.class);
	
	}
	
	public  Employee updatePayingOff(RetailscmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPayingOff(userContext, employeeId, payingOffId, payingOffVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPayingOffList().searchPayingOffListWith(PayingOff.ID_PROPERTY, "eq", payingOffId).done();
		
		
		
		Employee employee = loadEmployee(userContext, employeeId, loadTokens);
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removePayingOff( payingOff );	
			//make changes to AcceleraterAccount.
			PayingOff payingOffIndex = createIndexedPayingOff(payingOffId, payingOffVersion);
		
			PayingOff payingOff = employee.findThePayingOff(payingOffIndex);
			if(payingOff == null){
				throw new EmployeeManagerException(payingOff+" is NOT FOUND" );
			}
			
			payingOff.changeProperty(property, newValueExpr);
			
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Employee newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


