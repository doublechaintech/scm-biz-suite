
package com.doublechaintech.retailscm.employee;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelthreedepartment.CandidateLevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.CandidateResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.CandidateOccupationType;
import com.doublechaintech.retailscm.salarygrade.CandidateSalaryGrade;

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.leavetype.LeaveType;






public class EmployeeManagerImpl extends CustomRetailscmCheckerManager implements EmployeeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = EmployeeTokens.start().withTokenFromListName(listName).done();
		Employee  employee = (Employee) this.loadEmployee(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = employee.collectRefercencesFromLists();
		employeeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, employee, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new EmployeeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "Employee";
	@Override
	public EmployeeDAO daoOf(RetailscmUserContext userContext) {
		return employeeDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Employee employee = loadEmployee( userContext, employeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employee, tokens);
 	}
 	
 	
 	 public Employee searchEmployee(RetailscmUserContext userContext, String employeeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Employee employee = loadEmployee( userContext, employeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employee, tokens);
 	}
 	
 	

 	protected Employee present(RetailscmUserContext userContext, Employee employee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employee,tokens);
		
		
		Employee  employeeToPresent = employeeDaoOf(userContext).present(employee, tokens);
		
		List<BaseEntity> entityListToNaming = employeeToPresent.collectRefercencesFromLists();
		employeeDaoOf(userContext).alias(entityListToNaming);
		
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
 		return employeeDaoOf(userContext).save(employee, tokens);
 	}
 	protected Employee loadEmployee(RetailscmUserContext userContext, String employeeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeManagerException.class);

 
 		return employeeDaoOf(userContext).load(employeeId, tokens);
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
	
 	
 	
 
 	
 	

	public Employee createEmployee(RetailscmUserContext userContext, String companyId,String title,String departmentId,String familyName,String givenName,String email,String city,String address,String cellPhone,String occupationId,String responsibleForId,String currentSalaryGradeId,String salaryAccount) throws Exception
	//public Employee createEmployee(RetailscmUserContext userContext,String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfEmployee(title);
		checkerOf(userContext).checkFamilyNameOfEmployee(familyName);
		checkerOf(userContext).checkGivenNameOfEmployee(givenName);
		checkerOf(userContext).checkEmailOfEmployee(email);
		checkerOf(userContext).checkCityOfEmployee(city);
		checkerOf(userContext).checkAddressOfEmployee(address);
		checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee( employeeVersion);
		
		

		
		if(Employee.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfEmployee(parseString(newValueExpr));
		
			
		}		

		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFamilyNameOfEmployee(parseString(newValueExpr));
		
			
		}
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkGivenNameOfEmployee(parseString(newValueExpr));
		
			
		}
		if(Employee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfEmployee(parseString(newValueExpr));
		
			
		}
		if(Employee.CITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCityOfEmployee(parseString(newValueExpr));
		
			
		}
		if(Employee.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfEmployee(parseString(newValueExpr));
		
			
		}
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCellPhoneOfEmployee(parseString(newValueExpr));
		
			
		}		

				

				

		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSalaryAccountOfEmployee(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}



	public Employee clone(RetailscmUserContext userContext, String fromEmployeeId) throws Exception{

		return employeeDaoOf(userContext).clone(fromEmployeeId, this.allTokens());
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
			if (employee.isChanged()){
			employee.updateLastUpdateTime(userContext.now());
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String employeeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployee(employeeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDepartment(RetailscmUserContext userContext, String employeeId, String anotherDepartmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployee(employeeId);
 		checkerOf(userContext).checkIdOfLevelThreeDepartment(anotherDepartmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		SmartList<LevelThreeDepartment> candidateList = levelThreeDepartmentDaoOf(userContext).requestCandidateLevelThreeDepartmentForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherOccupation(RetailscmUserContext userContext, String employeeId, String anotherOccupationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployee(employeeId);
 		checkerOf(userContext).checkIdOfOccupationType(anotherOccupationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		SmartList<OccupationType> candidateList = occupationTypeDaoOf(userContext).requestCandidateOccupationTypeForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherResponsibleFor(RetailscmUserContext userContext, String employeeId, String anotherResponsibleForId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployee(employeeId);
 		checkerOf(userContext).checkIdOfResponsibilityType(anotherResponsibleForId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		SmartList<ResponsibilityType> candidateList = responsibilityTypeDaoOf(userContext).requestCandidateResponsibilityTypeForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployee(employeeId);
 		checkerOf(userContext).checkIdOfSalaryGrade(anotherCurrentSalaryGradeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		SmartList<SalaryGrade> candidateList = salaryGradeDaoOf(userContext).requestCandidateSalaryGradeForEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String newCurrentSalaryGradeId, Map<String,Object> options) throws Exception
 	{

 		return salaryGradeDaoOf(userContext).load(newCurrentSalaryGradeId, options);
 	}
 	


	

 	protected LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{

 		return levelThreeDepartmentDaoOf(userContext).load(newDepartmentId, options);
 	}
 	


	

 	protected OccupationType loadOccupationType(RetailscmUserContext userContext, String newOccupationId, Map<String,Object> options) throws Exception
 	{

 		return occupationTypeDaoOf(userContext).load(newOccupationId, options);
 	}
 	


	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	

 	protected ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String newResponsibleForId, Map<String,Object> options) throws Exception
 	{

 		return responsibilityTypeDaoOf(userContext).load(newResponsibleForId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeId, int employeeVersion) throws Exception {
		//deleteInternal(userContext, employeeId, employeeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeId, int employeeVersion) throws Exception{

		employeeDaoOf(userContext).delete(employeeId, employeeVersion);
	}

	public Employee forgetByAll(RetailscmUserContext userContext, String employeeId, int employeeVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeId, employeeVersion);
	}
	protected Employee forgetByAllInternal(RetailscmUserContext userContext,
			String employeeId, int employeeVersion) throws Exception{

		return employeeDaoOf(userContext).disconnectFromAll(employeeId, employeeVersion);
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
		return employeeDaoOf(userContext).deleteAll();
	}


	//disconnect Employee with training in EmployeeCompanyTraining
	protected Employee breakWithEmployeeCompanyTrainingByTraining(RetailscmUserContext userContext, String employeeId, String trainingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithTraining(employee, trainingId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
				return employee;
			}
	}
	//disconnect Employee with scoring in EmployeeCompanyTraining
	protected Employee breakWithEmployeeCompanyTrainingByScoring(RetailscmUserContext userContext, String employeeId, String scoringId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithScoring(employee, scoringId, this.emptyOptions());

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

				employeeDaoOf(userContext).planToRemoveEmployeeSkillListWithSkillType(employee, skillTypeId, this.emptyOptions());

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

				employeeDaoOf(userContext).planToRemoveEmployeeLeaveListWithType(employee, typeId, this.emptyOptions());

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

				employeeDaoOf(userContext).planToRemoveEmployeeInterviewListWithInterviewType(employee, interviewTypeId, this.emptyOptions());

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

				employeeDaoOf(userContext).planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(employee, currentSalaryGradeId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
				return employee;
			}
	}
	//disconnect Employee with paying_off in EmployeeSalarySheet
	protected Employee breakWithEmployeeSalarySheetByPayingOff(RetailscmUserContext userContext, String employeeId, String payingOffId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Employee employee = loadEmployee(userContext, employeeId, allTokens());

			synchronized(employee){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeDaoOf(userContext).planToRemoveEmployeeSalarySheetListWithPayingOff(employee, payingOffId, this.emptyOptions());

				employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
				return employee;
			}
	}






	protected void checkParamsForAddingEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId, String scoringId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkTrainingIdOfEmployeeCompanyTraining(trainingId);
		
		checkerOf(userContext).checkScoringIdOfEmployeeCompanyTraining(scoringId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId, String scoringId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeCompanyTraining(userContext,employeeId,trainingId, scoringId,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,trainingId, scoringId);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(id);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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


	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String trainingId, String scoringId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);		
		Scoring  scoring = new Scoring();
		scoring.setId(scoringId);		
		employeeCompanyTraining.setScoring(scoring);
	
		
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeCompanyTrainingIdItem: employeeCompanyTrainingIds){
			checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeCompanyTrainingList(RetailscmUserContext userContext, String employeeId,
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, employeeId,  employeeCompanyTrainingIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeCompanyTrainingList(employee, employeeCompanyTrainingIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeCompanyTrainingList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		

	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

	*/




	protected void checkParamsForAddingEmployeeSkill(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkSkillTypeIdOfEmployeeSkill(skillTypeId);
		
		checkerOf(userContext).checkDescriptionOfEmployeeSkill(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeSkill(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeSkill(userContext,employeeId,skillTypeId, description,tokensExpr);

		EmployeeSkill employeeSkill = createEmployeeSkill(userContext,skillTypeId, description);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(id);

		checkerOf(userContext).checkDescriptionOfEmployeeSkill( description);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeSkillIdItem: employeeSkillIds){
			checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeSkillList(RetailscmUserContext userContext, String employeeId,
			String employeeSkillIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeSkillList(userContext, employeeId,  employeeSkillIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeSkillList(employee, employeeSkillIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeSkillList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeSkill(RetailscmUserContext userContext, String employeeId,
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill(employeeSkillVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill(employeeSkillVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill(employeeSkillVersion);
		

		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfEmployeeSkill(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkPerformanceCommentOfEmployeePerformance(performanceComment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeePerformance(RetailscmUserContext userContext, String employeeId, String performanceComment, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeePerformance(userContext,employeeId,performanceComment,tokensExpr);

		EmployeePerformance employeePerformance = createEmployeePerformance(userContext,performanceComment);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeePerformance(id);

		checkerOf(userContext).checkPerformanceCommentOfEmployeePerformance( performanceComment);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeePerformanceIdItem: employeePerformanceIds){
			checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeePerformanceList(RetailscmUserContext userContext, String employeeId,
			String employeePerformanceIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeePerformanceList(userContext, employeeId,  employeePerformanceIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeePerformanceList(employee, employeePerformanceIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeePerformanceList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeePerformance(RetailscmUserContext userContext, String employeeId,
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);
		checkerOf(userContext).checkVersionOfEmployeePerformance(employeePerformanceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);
		checkerOf(userContext).checkVersionOfEmployeePerformance(employeePerformanceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);
		checkerOf(userContext).checkVersionOfEmployeePerformance(employeePerformanceVersion);
		

		if(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPerformanceCommentOfEmployeePerformance(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkStartOfEmployeeWorkExperience(start);
		
		checkerOf(userContext).checkEndOfEmployeeWorkExperience(end);
		
		checkerOf(userContext).checkCompanyOfEmployeeWorkExperience(company);
		
		checkerOf(userContext).checkDescriptionOfEmployeeWorkExperience(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, Date start, Date end, String company, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeWorkExperience(userContext,employeeId,start, end, company, description,tokensExpr);

		EmployeeWorkExperience employeeWorkExperience = createEmployeeWorkExperience(userContext,start, end, company, description);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeWorkExperience(id);

		checkerOf(userContext).checkStartOfEmployeeWorkExperience( start);
		checkerOf(userContext).checkEndOfEmployeeWorkExperience( end);
		checkerOf(userContext).checkCompanyOfEmployeeWorkExperience( company);
		checkerOf(userContext).checkDescriptionOfEmployeeWorkExperience( description);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeWorkExperienceIdItem: employeeWorkExperienceIds){
			checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeWorkExperienceList(RetailscmUserContext userContext, String employeeId,
			String employeeWorkExperienceIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeWorkExperienceList(userContext, employeeId,  employeeWorkExperienceIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeWorkExperienceList(employee, employeeWorkExperienceIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeWorkExperienceList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId,
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		checkerOf(userContext).checkVersionOfEmployeeWorkExperience(employeeWorkExperienceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		checkerOf(userContext).checkVersionOfEmployeeWorkExperience(employeeWorkExperienceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		checkerOf(userContext).checkVersionOfEmployeeWorkExperience(employeeWorkExperienceVersion);
		

		if(EmployeeWorkExperience.START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStartOfEmployeeWorkExperience(parseDate(newValueExpr));
		
		}
		
		if(EmployeeWorkExperience.END_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEndOfEmployeeWorkExperience(parseDate(newValueExpr));
		
		}
		
		if(EmployeeWorkExperience.COMPANY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCompanyOfEmployeeWorkExperience(parseString(newValueExpr));
		
		}
		
		if(EmployeeWorkExperience.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfEmployeeWorkExperience(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkTypeIdOfEmployeeLeave(typeId);
		
		checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);
		
		checkerOf(userContext).checkRemarkOfEmployeeLeave(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeLeave(RetailscmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeLeave(userContext,employeeId,typeId, leaveDurationHour, remark,tokensExpr);

		EmployeeLeave employeeLeave = createEmployeeLeave(userContext,typeId, leaveDurationHour, remark);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeLeave(id);

		checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave( leaveDurationHour);
		checkerOf(userContext).checkRemarkOfEmployeeLeave( remark);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeLeaveIdItem: employeeLeaveIds){
			checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeLeaveList(RetailscmUserContext userContext, String employeeId,
			String employeeLeaveIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeLeaveList(userContext, employeeId,  employeeLeaveIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeLeaveList(employee, employeeLeaveIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeLeaveList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeLeave(RetailscmUserContext userContext, String employeeId,
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).checkVersionOfEmployeeLeave(employeeLeaveVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).checkVersionOfEmployeeLeave(employeeLeaveVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).checkVersionOfEmployeeLeave(employeeLeaveVersion);
		

		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(parseInt(newValueExpr));
		
		}
		
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeLeave(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkInterviewTypeIdOfEmployeeInterview(interviewTypeId);
		
		checkerOf(userContext).checkRemarkOfEmployeeInterview(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeInterview(RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeInterview(userContext,employeeId,interviewTypeId, remark,tokensExpr);

		EmployeeInterview employeeInterview = createEmployeeInterview(userContext,interviewTypeId, remark);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeInterview(id);

		checkerOf(userContext).checkRemarkOfEmployeeInterview( remark);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeInterviewIdItem: employeeInterviewIds){
			checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeInterviewList(RetailscmUserContext userContext, String employeeId,
			String employeeInterviewIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeInterviewList(userContext, employeeId,  employeeInterviewIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeInterviewList(employee, employeeInterviewIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeInterviewList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeInterview(RetailscmUserContext userContext, String employeeId,
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).checkVersionOfEmployeeInterview(employeeInterviewVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).checkVersionOfEmployeeInterview(employeeInterviewVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).checkVersionOfEmployeeInterview(employeeInterviewVersion);
		

		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeInterview(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkEnterTimeOfEmployeeAttendance(enterTime);
		
		checkerOf(userContext).checkLeaveTimeOfEmployeeAttendance(leaveTime);
		
		checkerOf(userContext).checkDurationHoursOfEmployeeAttendance(durationHours);
		
		checkerOf(userContext).checkRemarkOfEmployeeAttendance(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeAttendance(RetailscmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeAttendance(userContext,employeeId,enterTime, leaveTime, durationHours, remark,tokensExpr);

		EmployeeAttendance employeeAttendance = createEmployeeAttendance(userContext,enterTime, leaveTime, durationHours, remark);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeAttendance(id);

		checkerOf(userContext).checkEnterTimeOfEmployeeAttendance( enterTime);
		checkerOf(userContext).checkLeaveTimeOfEmployeeAttendance( leaveTime);
		checkerOf(userContext).checkDurationHoursOfEmployeeAttendance( durationHours);
		checkerOf(userContext).checkRemarkOfEmployeeAttendance( remark);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeAttendanceIdItem: employeeAttendanceIds){
			checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeAttendanceList(RetailscmUserContext userContext, String employeeId,
			String employeeAttendanceIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeAttendanceList(userContext, employeeId,  employeeAttendanceIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeAttendanceList(employee, employeeAttendanceIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeAttendanceList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeAttendance(RetailscmUserContext userContext, String employeeId,
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).checkVersionOfEmployeeAttendance(employeeAttendanceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).checkVersionOfEmployeeAttendance(employeeAttendanceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).checkVersionOfEmployeeAttendance(employeeAttendanceVersion);
		

		if(EmployeeAttendance.ENTER_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEnterTimeOfEmployeeAttendance(parseDate(newValueExpr));
		
		}
		
		if(EmployeeAttendance.LEAVE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeaveTimeOfEmployeeAttendance(parseDate(newValueExpr));
		
		}
		
		if(EmployeeAttendance.DURATION_HOURS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationHoursOfEmployeeAttendance(parseInt(newValueExpr));
		
		}
		
		if(EmployeeAttendance.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeAttendance(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier(qualifiedTime);
		
		checkerOf(userContext).checkTypeOfEmployeeQualifier(type);
		
		checkerOf(userContext).checkLevelOfEmployeeQualifier(level);
		
		checkerOf(userContext).checkRemarkOfEmployeeQualifier(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeQualifier(RetailscmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeQualifier(userContext,employeeId,qualifiedTime, type, level, remark,tokensExpr);

		EmployeeQualifier employeeQualifier = createEmployeeQualifier(userContext,qualifiedTime, type, level, remark);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeQualifier(id);

		checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier( qualifiedTime);
		checkerOf(userContext).checkTypeOfEmployeeQualifier( type);
		checkerOf(userContext).checkLevelOfEmployeeQualifier( level);
		checkerOf(userContext).checkRemarkOfEmployeeQualifier( remark);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeQualifierIdItem: employeeQualifierIds){
			checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeQualifierList(RetailscmUserContext userContext, String employeeId,
			String employeeQualifierIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeQualifierList(userContext, employeeId,  employeeQualifierIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeQualifierList(employee, employeeQualifierIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeQualifierList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeQualifier(RetailscmUserContext userContext, String employeeId,
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).checkVersionOfEmployeeQualifier(employeeQualifierVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).checkVersionOfEmployeeQualifier(employeeQualifierVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).checkVersionOfEmployeeQualifier(employeeQualifierVersion);
		

		if(EmployeeQualifier.QUALIFIED_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier(parseDate(newValueExpr));
		
		}
		
		if(EmployeeQualifier.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfEmployeeQualifier(parseString(newValueExpr));
		
		}
		
		if(EmployeeQualifier.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfEmployeeQualifier(parseString(newValueExpr));
		
		}
		
		if(EmployeeQualifier.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeQualifier(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkCompleteTimeOfEmployeeEducation(completeTime);
		
		checkerOf(userContext).checkTypeOfEmployeeEducation(type);
		
		checkerOf(userContext).checkRemarkOfEmployeeEducation(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeEducation(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeEducation(userContext,employeeId,completeTime, type, remark,tokensExpr);

		EmployeeEducation employeeEducation = createEmployeeEducation(userContext,completeTime, type, remark);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeEducation(id);

		checkerOf(userContext).checkCompleteTimeOfEmployeeEducation( completeTime);
		checkerOf(userContext).checkTypeOfEmployeeEducation( type);
		checkerOf(userContext).checkRemarkOfEmployeeEducation( remark);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeEducationIdItem: employeeEducationIds){
			checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeEducationList(RetailscmUserContext userContext, String employeeId,
			String employeeEducationIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeEducationList(userContext, employeeId,  employeeEducationIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeEducationList(employee, employeeEducationIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeEducationList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeEducation(RetailscmUserContext userContext, String employeeId,
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);
		checkerOf(userContext).checkVersionOfEmployeeEducation(employeeEducationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);
		checkerOf(userContext).checkVersionOfEmployeeEducation(employeeEducationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);
		checkerOf(userContext).checkVersionOfEmployeeEducation(employeeEducationVersion);
		

		if(EmployeeEducation.COMPLETE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCompleteTimeOfEmployeeEducation(parseDate(newValueExpr));
		
		}
		
		if(EmployeeEducation.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfEmployeeEducation(parseString(newValueExpr));
		
		}
		
		if(EmployeeEducation.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeEducation(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkCompleteTimeOfEmployeeAward(completeTime);
		
		checkerOf(userContext).checkTypeOfEmployeeAward(type);
		
		checkerOf(userContext).checkRemarkOfEmployeeAward(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeAward(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeAward(userContext,employeeId,completeTime, type, remark,tokensExpr);

		EmployeeAward employeeAward = createEmployeeAward(userContext,completeTime, type, remark);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeAward(id);

		checkerOf(userContext).checkCompleteTimeOfEmployeeAward( completeTime);
		checkerOf(userContext).checkTypeOfEmployeeAward( type);
		checkerOf(userContext).checkRemarkOfEmployeeAward( remark);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeAwardIdItem: employeeAwardIds){
			checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeAwardList(RetailscmUserContext userContext, String employeeId,
			String employeeAwardIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeAwardList(userContext, employeeId,  employeeAwardIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeAwardList(employee, employeeAwardIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeAwardList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeAward(RetailscmUserContext userContext, String employeeId,
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);
		checkerOf(userContext).checkVersionOfEmployeeAward(employeeAwardVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);
		checkerOf(userContext).checkVersionOfEmployeeAward(employeeAwardVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);
		checkerOf(userContext).checkVersionOfEmployeeAward(employeeAwardVersion);
		

		if(EmployeeAward.COMPLETE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCompleteTimeOfEmployeeAward(parseDate(newValueExpr));
		
		}
		
		if(EmployeeAward.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfEmployeeAward(parseString(newValueExpr));
		
		}
		
		if(EmployeeAward.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeAward(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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




	protected void checkParamsForAddingEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployeeSalarySheet(currentSalaryGradeId);
		
		checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
		
		checkerOf(userContext).checkBonusOfEmployeeSalarySheet(bonus);
		
		checkerOf(userContext).checkRewardOfEmployeeSalarySheet(reward);
		
		checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(personalTax);
		
		checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
		
		checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(housingFound);
		
		checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);
		
		checkerOf(userContext).checkPayingOffIdOfEmployeeSalarySheet(payingOffId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeSalarySheet(userContext,employeeId,currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, payingOffId,tokensExpr);

		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, payingOffId);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(id);

		checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet( baseSalary);
		checkerOf(userContext).checkBonusOfEmployeeSalarySheet( bonus);
		checkerOf(userContext).checkRewardOfEmployeeSalarySheet( reward);
		checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet( personalTax);
		checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet( socialSecurity);
		checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet( housingFound);
		checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet( jobInsurance);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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


	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId) throws Exception{

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
		PayingOff  payingOff = new PayingOff();
		payingOff.setId(payingOffId);		
		employeeSalarySheet.setPayingOff(payingOff);
	
		
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String employeeSalarySheetIdItem: employeeSalarySheetIds){
			checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removeEmployeeSalarySheetList(RetailscmUserContext userContext, String employeeId,
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeSalarySheetList(userContext, employeeId,  employeeSalarySheetIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemoveEmployeeSalarySheetList(employee, employeeSalarySheetIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
				deleteRelationListInGraph(userContext, employee.getEmployeeSalarySheetList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId,
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		

		if(EmployeeSalarySheet.BASE_SALARY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
		if(EmployeeSalarySheet.BONUS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBonusOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
		if(EmployeeSalarySheet.REWARD_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRewardOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
		if(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
		if(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
		if(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
		if(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

	*/




	protected void checkParamsForAddingPayingOff(RetailscmUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfEmployee(employeeId);

		
		checkerOf(userContext).checkWhoOfPayingOff(who);
		
		checkerOf(userContext).checkPaidTimeOfPayingOff(paidTime);
		
		checkerOf(userContext).checkAmountOfPayingOff(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);


	}
	public  Employee addPayingOff(RetailscmUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPayingOff(userContext,employeeId,who, paidTime, amount,tokensExpr);

		PayingOff payingOff = createPayingOff(userContext,who, paidTime, amount);

		Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfPayingOff(id);

		checkerOf(userContext).checkWhoOfPayingOff( who);
		checkerOf(userContext).checkPaidTimeOfPayingOff( paidTime);
		checkerOf(userContext).checkAmountOfPayingOff( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

		checkerOf(userContext).checkIdOfEmployee(employeeId);
		for(String payingOffIdItem: payingOffIds){
			checkerOf(userContext).checkIdOfPayingOff(payingOffIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

	}
	public  Employee removePayingOffList(RetailscmUserContext userContext, String employeeId,
			String payingOffIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPayingOffList(userContext, employeeId,  payingOffIds, tokensExpr);


			Employee employee = loadEmployee(userContext, employeeId, allTokens());
			synchronized(employee){
				//Will be good when the employee loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeDaoOf(userContext).planToRemovePayingOffList(employee, payingOffIds, allTokens());
				employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
				deleteRelationListInGraph(userContext, employee.getPayingOffList());
				return present(userContext,employee, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPayingOff(RetailscmUserContext userContext, String employeeId,
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		checkerOf(userContext).checkVersionOfPayingOff(payingOffVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfEmployee( employeeId);
		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		checkerOf(userContext).checkVersionOfPayingOff(payingOffVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		checkerOf(userContext).checkVersionOfPayingOff(payingOffVersion);
		

		if(PayingOff.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfPayingOff(parseString(newValueExpr));
		
		}
		
		if(PayingOff.PAID_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPaidTimeOfPayingOff(parseDate(newValueExpr));
		
		}
		
		if(PayingOff.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfPayingOff(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeManagerException.class);

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

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   Employee newEmployee = this.createEmployee(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployee
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Employee.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Employee> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);
		List<LevelThreeDepartment> departmentList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LevelThreeDepartment.class);
		userContext.getDAOGroup().enhanceList(departmentList, LevelThreeDepartment.class);
		List<OccupationType> occupationList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, OccupationType.class);
		userContext.getDAOGroup().enhanceList(occupationList, OccupationType.class);
		List<ResponsibilityType> responsibleForList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ResponsibilityType.class);
		userContext.getDAOGroup().enhanceList(responsibleForList, ResponsibilityType.class);
		List<SalaryGrade> currentSalaryGradeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SalaryGrade.class);
		userContext.getDAOGroup().enhanceList(currentSalaryGradeList, SalaryGrade.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<Employee> list = employeeDaoOf(userContext).findEmployeeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Employee.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
	public Object listByDepartment(RetailscmUserContext userContext,String departmentId) throws Exception {
		return listPageByDepartment(userContext, departmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDepartment(RetailscmUserContext userContext,String departmentId, int start, int count) throws Exception {
		SmartList<Employee> list = employeeDaoOf(userContext).findEmployeeByDepartment(departmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Employee.class);
		page.setContainerObject(LevelThreeDepartment.withId(departmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工列表");
		page.setRequestName("listByDepartment");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDepartment/%s/",  getBeanName(), departmentId)));

		page.assemblerContent(userContext, "listByDepartment");
		return page.doRender(userContext);
	}
  
	public Object listByOccupation(RetailscmUserContext userContext,String occupationId) throws Exception {
		return listPageByOccupation(userContext, occupationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOccupation(RetailscmUserContext userContext,String occupationId, int start, int count) throws Exception {
		SmartList<Employee> list = employeeDaoOf(userContext).findEmployeeByOccupation(occupationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Employee.class);
		page.setContainerObject(OccupationType.withId(occupationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工列表");
		page.setRequestName("listByOccupation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOccupation/%s/",  getBeanName(), occupationId)));

		page.assemblerContent(userContext, "listByOccupation");
		return page.doRender(userContext);
	}
  
	public Object listByResponsibleFor(RetailscmUserContext userContext,String responsibleForId) throws Exception {
		return listPageByResponsibleFor(userContext, responsibleForId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByResponsibleFor(RetailscmUserContext userContext,String responsibleForId, int start, int count) throws Exception {
		SmartList<Employee> list = employeeDaoOf(userContext).findEmployeeByResponsibleFor(responsibleForId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Employee.class);
		page.setContainerObject(ResponsibilityType.withId(responsibleForId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工列表");
		page.setRequestName("listByResponsibleFor");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByResponsibleFor/%s/",  getBeanName(), responsibleForId)));

		page.assemblerContent(userContext, "listByResponsibleFor");
		return page.doRender(userContext);
	}
  
	public Object listByCurrentSalaryGrade(RetailscmUserContext userContext,String currentSalaryGradeId) throws Exception {
		return listPageByCurrentSalaryGrade(userContext, currentSalaryGradeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCurrentSalaryGrade(RetailscmUserContext userContext,String currentSalaryGradeId, int start, int count) throws Exception {
		SmartList<Employee> list = employeeDaoOf(userContext).findEmployeeByCurrentSalaryGrade(currentSalaryGradeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Employee.class);
		page.setContainerObject(SalaryGrade.withId(currentSalaryGradeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工列表");
		page.setRequestName("listByCurrentSalaryGrade");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCurrentSalaryGrade/%s/",  getBeanName(), currentSalaryGradeId)));

		page.assemblerContent(userContext, "listByCurrentSalaryGrade");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String employeeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getEmployeeDetailScope().clone();
		Employee merchantObj = (Employee) this.view(userContext, employeeId);
    String merchantObjId = employeeId;
    String linkToUrl =	"employeeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "3-title")
				    .put("fieldName", "title")
				    .put("label", "头衔")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "4-department")
				    .put("fieldName", "department")
				    .put("label", "部门")
				    .put("type", "auto")
				    .put("linkToUrl", "levelThreeDepartmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("department", merchantObj.getDepartment());

		propList.add(
				MapUtil.put("id", "5-familyName")
				    .put("fieldName", "familyName")
				    .put("label", "姓")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("familyName", merchantObj.getFamilyName());

		propList.add(
				MapUtil.put("id", "6-givenName")
				    .put("fieldName", "givenName")
				    .put("label", "名")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("givenName", merchantObj.getGivenName());

		propList.add(
				MapUtil.put("id", "7-email")
				    .put("fieldName", "email")
				    .put("label", "电子邮件")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("email", merchantObj.getEmail());

		propList.add(
				MapUtil.put("id", "8-city")
				    .put("fieldName", "city")
				    .put("label", "城市")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("city", merchantObj.getCity());

		propList.add(
				MapUtil.put("id", "9-address")
				    .put("fieldName", "address")
				    .put("label", "地址")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("address", merchantObj.getAddress());

		propList.add(
				MapUtil.put("id", "10-cellPhone")
				    .put("fieldName", "cellPhone")
				    .put("label", "手机")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("cellPhone", merchantObj.getCellPhone());

		propList.add(
				MapUtil.put("id", "11-occupation")
				    .put("fieldName", "occupation")
				    .put("label", "职业")
				    .put("type", "auto")
				    .put("linkToUrl", "occupationTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("occupation", merchantObj.getOccupation());

		propList.add(
				MapUtil.put("id", "12-responsibleFor")
				    .put("fieldName", "responsibleFor")
				    .put("label", "负责")
				    .put("type", "auto")
				    .put("linkToUrl", "responsibilityTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"base_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("responsibleFor", merchantObj.getResponsibleFor());

		propList.add(
				MapUtil.put("id", "13-currentSalaryGrade")
				    .put("fieldName", "currentSalaryGrade")
				    .put("label", "目前工资等级")
				    .put("type", "auto")
				    .put("linkToUrl", "salaryGradeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"detail_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("currentSalaryGrade", merchantObj.getCurrentSalaryGrade());

		propList.add(
				MapUtil.put("id", "14-salaryAccount")
				    .put("fieldName", "salaryAccount")
				    .put("label", "工资账户")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("salaryAccount", merchantObj.getSalaryAccount());

		propList.add(
				MapUtil.put("id", "15-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：employeeCompanyTrainingListSection
		Map employeeCompanyTrainingListSection = ListofUtils.buildSection(
		    "employeeCompanyTrainingListSection",
		    "员工公司培训名单",
		    null,
		    "",
		    "__no_group",
		    "employeeCompanyTrainingManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeCompanyTrainingListSection);

		result.put("employeeCompanyTrainingListSection", ListofUtils.toShortList(merchantObj.getEmployeeCompanyTrainingList(), "employeeCompanyTraining"));
		vscope.field("employeeCompanyTrainingListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeCompanyTraining.class.getName(), null));

		//处理Section：employeeSkillListSection
		Map employeeSkillListSection = ListofUtils.buildSection(
		    "employeeSkillListSection",
		    "员工技能列表",
		    null,
		    "",
		    "__no_group",
		    "employeeSkillManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeSkillListSection);

		result.put("employeeSkillListSection", ListofUtils.toShortList(merchantObj.getEmployeeSkillList(), "employeeSkill"));
		vscope.field("employeeSkillListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeSkill.class.getName(), null));

		//处理Section：employeePerformanceListSection
		Map employeePerformanceListSection = ListofUtils.buildSection(
		    "employeePerformanceListSection",
		    "员工绩效表",
		    null,
		    "",
		    "__no_group",
		    "employeePerformanceManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeePerformanceListSection);

		result.put("employeePerformanceListSection", ListofUtils.toShortList(merchantObj.getEmployeePerformanceList(), "employeePerformance"));
		vscope.field("employeePerformanceListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeePerformance.class.getName(), null));

		//处理Section：employeeWorkExperienceListSection
		Map employeeWorkExperienceListSection = ListofUtils.buildSection(
		    "employeeWorkExperienceListSection",
		    "员工工作经历",
		    null,
		    "",
		    "__no_group",
		    "employeeWorkExperienceManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeWorkExperienceListSection);

		result.put("employeeWorkExperienceListSection", ListofUtils.toShortList(merchantObj.getEmployeeWorkExperienceList(), "employeeWorkExperience"));
		vscope.field("employeeWorkExperienceListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeWorkExperience.class.getName(), null));

		//处理Section：employeeLeaveListSection
		Map employeeLeaveListSection = ListofUtils.buildSection(
		    "employeeLeaveListSection",
		    "员工离开列表",
		    null,
		    "",
		    "__no_group",
		    "employeeLeaveManager/listByWho/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeLeaveListSection);

		result.put("employeeLeaveListSection", ListofUtils.toShortList(merchantObj.getEmployeeLeaveList(), "employeeLeave"));
		vscope.field("employeeLeaveListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeLeave.class.getName(), null));

		//处理Section：employeeInterviewListSection
		Map employeeInterviewListSection = ListofUtils.buildSection(
		    "employeeInterviewListSection",
		    "员工面试名单",
		    null,
		    "",
		    "__no_group",
		    "employeeInterviewManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeInterviewListSection);

		result.put("employeeInterviewListSection", ListofUtils.toShortList(merchantObj.getEmployeeInterviewList(), "employeeInterview"));
		vscope.field("employeeInterviewListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeInterview.class.getName(), null));

		//处理Section：employeeAttendanceListSection
		Map employeeAttendanceListSection = ListofUtils.buildSection(
		    "employeeAttendanceListSection",
		    "员工出勤表",
		    null,
		    "",
		    "__no_group",
		    "employeeAttendanceManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeAttendanceListSection);

		result.put("employeeAttendanceListSection", ListofUtils.toShortList(merchantObj.getEmployeeAttendanceList(), "employeeAttendance"));
		vscope.field("employeeAttendanceListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeAttendance.class.getName(), null));

		//处理Section：employeeQualifierListSection
		Map employeeQualifierListSection = ListofUtils.buildSection(
		    "employeeQualifierListSection",
		    "员工限定符列表",
		    null,
		    "",
		    "__no_group",
		    "employeeQualifierManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeQualifierListSection);

		result.put("employeeQualifierListSection", ListofUtils.toShortList(merchantObj.getEmployeeQualifierList(), "employeeQualifier"));
		vscope.field("employeeQualifierListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeQualifier.class.getName(), null));

		//处理Section：employeeEducationListSection
		Map employeeEducationListSection = ListofUtils.buildSection(
		    "employeeEducationListSection",
		    "教育员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeEducationManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeEducationListSection);

		result.put("employeeEducationListSection", ListofUtils.toShortList(merchantObj.getEmployeeEducationList(), "employeeEducation"));
		vscope.field("employeeEducationListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeEducation.class.getName(), null));

		//处理Section：employeeAwardListSection
		Map employeeAwardListSection = ListofUtils.buildSection(
		    "employeeAwardListSection",
		    "员工奖名单",
		    null,
		    "",
		    "__no_group",
		    "employeeAwardManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeAwardListSection);

		result.put("employeeAwardListSection", ListofUtils.toShortList(merchantObj.getEmployeeAwardList(), "employeeAward"));
		vscope.field("employeeAwardListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeAward.class.getName(), null));

		//处理Section：employeeSalarySheetListSection
		Map employeeSalarySheetListSection = ListofUtils.buildSection(
		    "employeeSalarySheetListSection",
		    "员工工资表",
		    null,
		    "",
		    "__no_group",
		    "employeeSalarySheetManager/listByEmployee/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeSalarySheetListSection);

		result.put("employeeSalarySheetListSection", ListofUtils.toShortList(merchantObj.getEmployeeSalarySheetList(), "employeeSalarySheet"));
		vscope.field("employeeSalarySheetListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeSalarySheet.class.getName(), null));

		//处理Section：payingOffListSection
		Map payingOffListSection = ListofUtils.buildSection(
		    "payingOffListSection",
		    "偿还列表",
		    null,
		    "",
		    "__no_group",
		    "payingOffManager/listByPaidFor/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(payingOffListSection);

		result.put("payingOffListSection", ListofUtils.toShortList(merchantObj.getPayingOffList(), "payingOff"));
		vscope.field("payingOffListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( PayingOff.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


