
package com.doublechaintech.retailscm.professioninterview;

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






public class ProfessionInterviewManagerImpl extends CustomRetailscmCheckerManager implements ProfessionInterviewManager {
	
	private static final String SERVICE_TYPE = "ProfessionInterview";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfessionInterviewManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfessionInterviewManagerException(message);

	}
	
	

 	protected ProfessionInterview saveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview, String [] tokensExpr) throws Exception{	
 		//return getProfessionInterviewDAO().save(professionInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfessionInterview(userContext, professionInterview, tokens);
 	}
 	
 	protected ProfessionInterview saveProfessionInterviewDetail(RetailscmUserContext userContext, ProfessionInterview professionInterview) throws Exception{	

 		
 		return saveProfessionInterview(userContext, professionInterview, allTokens());
 	}
 	
 	public ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfessionInterviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,professionInterview, tokens);
 	}
 	
 	
 	 public ProfessionInterview searchProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfessionInterviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,professionInterview, tokens);
 	}
 	
 	

 	protected ProfessionInterview present(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,professionInterview,tokens);
		
		
		ProfessionInterview  professionInterviewToPresent = userContext.getDAOGroup().getProfessionInterviewDAO().present(professionInterview, tokens);
		
		List<BaseEntity> entityListToNaming = professionInterviewToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfessionInterviewDAO().alias(entityListToNaming);
		
		return  professionInterviewToPresent;
		
		
	}
 
 	
 	
 	public ProfessionInterview loadProfessionInterviewDetail(RetailscmUserContext userContext, String professionInterviewId) throws Exception{	
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, allTokens());
 		return present(userContext,professionInterview, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String professionInterviewId) throws Exception{	
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, viewTokens());
 		return present(userContext,professionInterview, allTokens());
		
 	}
 	protected ProfessionInterview saveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfessionInterviewDAO().save(professionInterview, tokens);
 	}
 	protected ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfessionInterviewManagerException.class);

 
 		return userContext.getDAOGroup().getProfessionInterviewDAO().load(professionInterviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens){
		super.addActions(userContext, professionInterview, tokens);
		
		addAction(userContext, professionInterview, tokens,"@create","createProfessionInterview","createProfessionInterview/","main","primary");
		addAction(userContext, professionInterview, tokens,"@update","updateProfessionInterview","updateProfessionInterview/"+professionInterview.getId()+"/","main","primary");
		addAction(userContext, professionInterview, tokens,"@copy","cloneProfessionInterview","cloneProfessionInterview/"+professionInterview.getId()+"/","main","primary");
		
		addAction(userContext, professionInterview, tokens,"profession_interview.addEmployee","addEmployee","addEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.removeEmployee","removeEmployee","removeEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.updateEmployee","updateEmployee","updateEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+professionInterview.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProfessionInterview createProfessionInterview(RetailscmUserContext userContext,String who, Date interviewTime, String comments) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfProfessionInterview(who);
		userContext.getChecker().checkInterviewTimeOfProfessionInterview(interviewTime);
		userContext.getChecker().checkCommentsOfProfessionInterview(comments);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);


		ProfessionInterview professionInterview=createNewProfessionInterview();	

		professionInterview.setWho(who);
		professionInterview.setInterviewTime(interviewTime);
		professionInterview.setComments(comments);

		professionInterview = saveProfessionInterview(userContext, professionInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, professionInterview);
		return professionInterview;

		
	}
	protected ProfessionInterview createNewProfessionInterview() 
	{
		
		return new ProfessionInterview();		
	}
	
	protected void checkParamsForUpdatingProfessionInterview(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
		userContext.getChecker().checkVersionOfProfessionInterview( professionInterviewVersion);
		

		if(ProfessionInterview.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfProfessionInterview(parseString(newValueExpr));
		}
		if(ProfessionInterview.INTERVIEW_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkInterviewTimeOfProfessionInterview(parseDate(newValueExpr));
		}
		if(ProfessionInterview.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfProfessionInterview(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);
	
		
	}
	
	
	
	public ProfessionInterview clone(RetailscmUserContext userContext, String fromProfessionInterviewId) throws Exception{
		
		return userContext.getDAOGroup().getProfessionInterviewDAO().clone(fromProfessionInterviewId, this.allTokens());
	}
	
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview) throws Exception 
	{
		return internalSaveProfessionInterview(userContext, professionInterview, allTokens());

	}
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(professionInterview){ 
			//will be good when the professionInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.
			
			
			professionInterview = saveProfessionInterview(userContext, professionInterview, options);
			return professionInterview;
			
		}

	}
	
	public ProfessionInterview updateProfessionInterview(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);
		
		
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		if(professionInterview.getVersion() != professionInterviewVersion){
			String message = "The target version("+professionInterview.getVersion()+") is not equals to version("+professionInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(professionInterview){ 
			//will be good when the professionInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.
			
			professionInterview.changeProperty(property, newValueExpr);
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			//return saveProfessionInterview(userContext, professionInterview, tokens().done());
		}

	}
	
	public ProfessionInterview updateProfessionInterviewProperty(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		if(professionInterview.getVersion() != professionInterviewVersion){
			String message = "The target version("+professionInterview.getVersion()+") is not equals to version("+professionInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(professionInterview){ 
			//will be good when the professionInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.
			
			professionInterview.changeProperty(property, newValueExpr);
			
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			//return saveProfessionInterview(userContext, professionInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfessionInterviewTokens tokens(){
		return ProfessionInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfessionInterviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfessionInterviewTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String professionInterviewId, int professionInterviewVersion) throws Exception {
		//deleteInternal(userContext, professionInterviewId, professionInterviewVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String professionInterviewId, int professionInterviewVersion) throws Exception{
			
		userContext.getDAOGroup().getProfessionInterviewDAO().delete(professionInterviewId, professionInterviewVersion);
	}
	
	public ProfessionInterview forgetByAll(RetailscmUserContext userContext, String professionInterviewId, int professionInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, professionInterviewId, professionInterviewVersion);		
	}
	protected ProfessionInterview forgetByAllInternal(RetailscmUserContext userContext,
			String professionInterviewId, int professionInterviewVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfessionInterviewDAO().disconnectFromAll(professionInterviewId, professionInterviewVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfessionInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfessionInterviewDAO().deleteAll();
	}


	//disconnect ProfessionInterview with company in Employee
	protected ProfessionInterview breakWithEmployeeByCompany(RetailscmUserContext userContext, String professionInterviewId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfessionInterviewDAO().planToRemoveEmployeeListWithCompany(professionInterview, companyId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with department in Employee
	protected ProfessionInterview breakWithEmployeeByDepartment(RetailscmUserContext userContext, String professionInterviewId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfessionInterviewDAO().planToRemoveEmployeeListWithDepartment(professionInterview, departmentId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with occupation in Employee
	protected ProfessionInterview breakWithEmployeeByOccupation(RetailscmUserContext userContext, String professionInterviewId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfessionInterviewDAO().planToRemoveEmployeeListWithOccupation(professionInterview, occupationId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with responsible_for in Employee
	protected ProfessionInterview breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String professionInterviewId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfessionInterviewDAO().planToRemoveEmployeeListWithResponsibleFor(professionInterview, responsibleForId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with current_salary_grade in Employee
	protected ProfessionInterview breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String professionInterviewId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfessionInterviewDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(professionInterview, currentSalaryGradeId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);

	
	}
	public  ProfessionInterview addEmployee(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,professionInterviewId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.addEmployee( employee );		
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String professionInterviewId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);
		
	}
	public  ProfessionInterview updateEmployeeProperties(RetailscmUserContext userContext, String professionInterviewId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,professionInterviewId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		ProfessionInterview professionInterviewToUpdate = loadProfessionInterview(userContext, professionInterviewId, options);
		
		if(professionInterviewToUpdate.getEmployeeList().isEmpty()){
			throw new ProfessionInterviewManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = professionInterviewToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,professionInterviewId,name, code, used,tokensExpr);
		ProfessionInterview professionInterview = saveProfessionInterview(userContext, professionInterviewToUpdate, tokens().withEmployeeList().done());
		synchronized(professionInterview){ 
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String professionInterviewId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);
		
	}
	public  ProfessionInterview removeEmployeeList(RetailscmUserContext userContext, String professionInterviewId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, professionInterviewId,  employeeIds, tokensExpr);
			
			
			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
			synchronized(professionInterview){ 
				//Will be good when the professionInterview loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfessionInterviewDAO().planToRemoveEmployeeList(professionInterview, employeeIds, allTokens());
				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, professionInterview.getEmployeeList());
				return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfessionInterview( professionInterviewId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);
	
	}
	public  ProfessionInterview removeEmployee(RetailscmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,professionInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.removeEmployee( employee );		
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfessionInterview( professionInterviewId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);
	
	}
	public  ProfessionInterview copyEmployeeFrom(RetailscmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,professionInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			professionInterview.copyEmployeeFrom( employee );		
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)professionInterview.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfessionInterview(professionInterviewId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);
	
	}
	
	public  ProfessionInterview updateEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, professionInterviewId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, loadTokens);
		
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//professionInterview.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = professionInterview.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new ProfessionInterviewManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  ProfessionInterview associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToNewTermination(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}
	*/
	
	public  ProfessionInterview associateEmployeeListToJobApplication(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToHrInterview(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}	public  ProfessionInterview associateEmployeeListToTermination(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: professionInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveProfessionInterview(userContext, professionInterview);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, ProfessionInterview newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


