
package com.doublechaintech.retailscm.employeeboarding;

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






public class EmployeeBoardingManagerImpl extends CustomRetailscmCheckerManager implements EmployeeBoardingManager {
	
	private static final String SERVICE_TYPE = "EmployeeBoarding";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeBoardingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeBoardingManagerException(message);

	}
	
	

 	protected EmployeeBoarding saveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, String [] tokensExpr) throws Exception{	
 		//return getEmployeeBoardingDAO().save(employeeBoarding, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeBoarding(userContext, employeeBoarding, tokens);
 	}
 	
 	protected EmployeeBoarding saveEmployeeBoardingDetail(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception{	

 		
 		return saveEmployeeBoarding(userContext, employeeBoarding, allTokens());
 	}
 	
 	public EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeBoardingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeBoarding, tokens);
 	}
 	
 	
 	 public EmployeeBoarding searchEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeBoardingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeBoarding, tokens);
 	}
 	
 	

 	protected EmployeeBoarding present(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeBoarding,tokens);
		
		
		EmployeeBoarding  employeeBoardingToPresent = userContext.getDAOGroup().getEmployeeBoardingDAO().present(employeeBoarding, tokens);
		
		List<BaseEntity> entityListToNaming = employeeBoardingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeBoardingDAO().alias(entityListToNaming);
		
		return  employeeBoardingToPresent;
		
		
	}
 
 	
 	
 	public EmployeeBoarding loadEmployeeBoardingDetail(RetailscmUserContext userContext, String employeeBoardingId) throws Exception{	
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, allTokens());
 		return present(userContext,employeeBoarding, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeBoardingId) throws Exception{	
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, viewTokens());
 		return present(userContext,employeeBoarding, allTokens());
		
 	}
 	protected EmployeeBoarding saveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeBoardingDAO().save(employeeBoarding, tokens);
 	}
 	protected EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeBoardingManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeBoardingDAO().load(employeeBoardingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens){
		super.addActions(userContext, employeeBoarding, tokens);
		
		addAction(userContext, employeeBoarding, tokens,"@create","createEmployeeBoarding","createEmployeeBoarding/","main","primary");
		addAction(userContext, employeeBoarding, tokens,"@update","updateEmployeeBoarding","updateEmployeeBoarding/"+employeeBoarding.getId()+"/","main","primary");
		addAction(userContext, employeeBoarding, tokens,"@copy","cloneEmployeeBoarding","cloneEmployeeBoarding/"+employeeBoarding.getId()+"/","main","primary");
		
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.addEmployee","addEmployee","addEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.removeEmployee","removeEmployee","removeEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.updateEmployee","updateEmployee","updateEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+employeeBoarding.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeBoarding createEmployeeBoarding(RetailscmUserContext userContext,String who, Date employTime, String comments) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfEmployeeBoarding(who);
		userContext.getChecker().checkEmployTimeOfEmployeeBoarding(employTime);
		userContext.getChecker().checkCommentsOfEmployeeBoarding(comments);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);


		EmployeeBoarding employeeBoarding=createNewEmployeeBoarding();	

		employeeBoarding.setWho(who);
		employeeBoarding.setEmployTime(employTime);
		employeeBoarding.setComments(comments);

		employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeBoarding);
		return employeeBoarding;

		
	}
	protected EmployeeBoarding createNewEmployeeBoarding() 
	{
		
		return new EmployeeBoarding();		
	}
	
	protected void checkParamsForUpdatingEmployeeBoarding(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
		userContext.getChecker().checkVersionOfEmployeeBoarding( employeeBoardingVersion);
		

		if(EmployeeBoarding.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfEmployeeBoarding(parseString(newValueExpr));
		}
		if(EmployeeBoarding.EMPLOY_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkEmployTimeOfEmployeeBoarding(parseDate(newValueExpr));
		}
		if(EmployeeBoarding.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfEmployeeBoarding(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);
	
		
	}
	
	
	
	public EmployeeBoarding clone(RetailscmUserContext userContext, String fromEmployeeBoardingId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeBoardingDAO().clone(fromEmployeeBoardingId, this.allTokens());
	}
	
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception 
	{
		return internalSaveEmployeeBoarding(userContext, employeeBoarding, allTokens());

	}
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeBoarding){ 
			//will be good when the employeeBoarding loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.
			
			
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, options);
			return employeeBoarding;
			
		}

	}
	
	public EmployeeBoarding updateEmployeeBoarding(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		if(employeeBoarding.getVersion() != employeeBoardingVersion){
			String message = "The target version("+employeeBoarding.getVersion()+") is not equals to version("+employeeBoardingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeBoarding){ 
			//will be good when the employeeBoarding loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.
			
			employeeBoarding.changeProperty(property, newValueExpr);
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			//return saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
		}

	}
	
	public EmployeeBoarding updateEmployeeBoardingProperty(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		if(employeeBoarding.getVersion() != employeeBoardingVersion){
			String message = "The target version("+employeeBoarding.getVersion()+") is not equals to version("+employeeBoardingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeBoarding){ 
			//will be good when the employeeBoarding loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.
			
			employeeBoarding.changeProperty(property, newValueExpr);
			
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			//return saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeBoardingTokens tokens(){
		return EmployeeBoardingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeBoardingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeBoardingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeBoardingId, int employeeBoardingVersion) throws Exception {
		//deleteInternal(userContext, employeeBoardingId, employeeBoardingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeBoardingId, int employeeBoardingVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeBoardingDAO().delete(employeeBoardingId, employeeBoardingVersion);
	}
	
	public EmployeeBoarding forgetByAll(RetailscmUserContext userContext, String employeeBoardingId, int employeeBoardingVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeBoardingId, employeeBoardingVersion);		
	}
	protected EmployeeBoarding forgetByAllInternal(RetailscmUserContext userContext,
			String employeeBoardingId, int employeeBoardingVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeBoardingDAO().disconnectFromAll(employeeBoardingId, employeeBoardingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeBoardingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeBoardingDAO().deleteAll();
	}


	//disconnect EmployeeBoarding with company in Employee
	protected EmployeeBoarding breakWithEmployeeByCompany(RetailscmUserContext userContext, String employeeBoardingId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeBoardingDAO().planToRemoveEmployeeListWithCompany(employeeBoarding, companyId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with department in Employee
	protected EmployeeBoarding breakWithEmployeeByDepartment(RetailscmUserContext userContext, String employeeBoardingId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeBoardingDAO().planToRemoveEmployeeListWithDepartment(employeeBoarding, departmentId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with occupation in Employee
	protected EmployeeBoarding breakWithEmployeeByOccupation(RetailscmUserContext userContext, String employeeBoardingId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeBoardingDAO().planToRemoveEmployeeListWithOccupation(employeeBoarding, occupationId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with responsible_for in Employee
	protected EmployeeBoarding breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String employeeBoardingId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeBoardingDAO().planToRemoveEmployeeListWithResponsibleFor(employeeBoarding, responsibleForId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with current_salary_grade in Employee
	protected EmployeeBoarding breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String employeeBoardingId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getEmployeeBoardingDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(employeeBoarding, currentSalaryGradeId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);

	
	}
	public  EmployeeBoarding addEmployee(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,employeeBoardingId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.addEmployee( employee );		
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String employeeBoardingId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);
		
	}
	public  EmployeeBoarding updateEmployeeProperties(RetailscmUserContext userContext, String employeeBoardingId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,employeeBoardingId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		EmployeeBoarding employeeBoardingToUpdate = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		if(employeeBoardingToUpdate.getEmployeeList().isEmpty()){
			throw new EmployeeBoardingManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = employeeBoardingToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,employeeBoardingId,name, code, used,tokensExpr);
		EmployeeBoarding employeeBoarding = saveEmployeeBoarding(userContext, employeeBoardingToUpdate, tokens().withEmployeeList().done());
		synchronized(employeeBoarding){ 
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String employeeBoardingId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);
		
	}
	public  EmployeeBoarding removeEmployeeList(RetailscmUserContext userContext, String employeeBoardingId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, employeeBoardingId,  employeeIds, tokensExpr);
			
			
			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
			synchronized(employeeBoarding){ 
				//Will be good when the employeeBoarding loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getEmployeeBoardingDAO().planToRemoveEmployeeList(employeeBoarding, employeeIds, allTokens());
				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, employeeBoarding.getEmployeeList());
				return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployeeBoarding( employeeBoardingId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);
	
	}
	public  EmployeeBoarding removeEmployee(RetailscmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,employeeBoardingId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.removeEmployee( employee );		
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfEmployeeBoarding( employeeBoardingId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);
	
	}
	public  EmployeeBoarding copyEmployeeFrom(RetailscmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,employeeBoardingId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			employeeBoarding.copyEmployeeFrom( employee );		
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)employeeBoarding.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfEmployeeBoarding(employeeBoardingId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);
	
	}
	
	public  EmployeeBoarding updateEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, employeeBoardingId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, loadTokens);
		
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employeeBoarding.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = employeeBoarding.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new EmployeeBoardingManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  EmployeeBoarding associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToNewTermination(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}
	*/
	
	public  EmployeeBoarding associateEmployeeListToJobApplication(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToHrInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}	public  EmployeeBoarding associateEmployeeListToTermination(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: employeeBoarding.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveEmployeeBoarding(userContext, employeeBoarding);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeBoarding newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


