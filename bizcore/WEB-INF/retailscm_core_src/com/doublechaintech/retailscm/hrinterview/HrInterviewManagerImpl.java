
package com.doublechaintech.retailscm.hrinterview;

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






public class HrInterviewManagerImpl extends CustomRetailscmCheckerManager implements HrInterviewManager {
	
	private static final String SERVICE_TYPE = "HrInterview";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws HrInterviewManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new HrInterviewManagerException(message);

	}
	
	

 	protected HrInterview saveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview, String [] tokensExpr) throws Exception{	
 		//return getHrInterviewDAO().save(hrInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveHrInterview(userContext, hrInterview, tokens);
 	}
 	
 	protected HrInterview saveHrInterviewDetail(RetailscmUserContext userContext, HrInterview hrInterview) throws Exception{	

 		
 		return saveHrInterview(userContext, hrInterview, allTokens());
 	}
 	
 	public HrInterview loadHrInterview(RetailscmUserContext userContext, String hrInterviewId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( HrInterviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hrInterview, tokens);
 	}
 	
 	
 	 public HrInterview searchHrInterview(RetailscmUserContext userContext, String hrInterviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( HrInterviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hrInterview, tokens);
 	}
 	
 	

 	protected HrInterview present(RetailscmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,hrInterview,tokens);
		
		
		HrInterview  hrInterviewToPresent = userContext.getDAOGroup().getHrInterviewDAO().present(hrInterview, tokens);
		
		List<BaseEntity> entityListToNaming = hrInterviewToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getHrInterviewDAO().alias(entityListToNaming);
		
		return  hrInterviewToPresent;
		
		
	}
 
 	
 	
 	public HrInterview loadHrInterviewDetail(RetailscmUserContext userContext, String hrInterviewId) throws Exception{	
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, allTokens());
 		return present(userContext,hrInterview, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String hrInterviewId) throws Exception{	
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, viewTokens());
 		return present(userContext,hrInterview, allTokens());
		
 	}
 	protected HrInterview saveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getHrInterviewDAO().save(hrInterview, tokens);
 	}
 	protected HrInterview loadHrInterview(RetailscmUserContext userContext, String hrInterviewId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
		userContext.getChecker().throwExceptionIfHasErrors( HrInterviewManagerException.class);

 
 		return userContext.getDAOGroup().getHrInterviewDAO().load(hrInterviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens){
		super.addActions(userContext, hrInterview, tokens);
		
		addAction(userContext, hrInterview, tokens,"@create","createHrInterview","createHrInterview/","main","primary");
		addAction(userContext, hrInterview, tokens,"@update","updateHrInterview","updateHrInterview/"+hrInterview.getId()+"/","main","primary");
		addAction(userContext, hrInterview, tokens,"@copy","cloneHrInterview","cloneHrInterview/"+hrInterview.getId()+"/","main","primary");
		
		addAction(userContext, hrInterview, tokens,"hr_interview.addEmployee","addEmployee","addEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.removeEmployee","removeEmployee","removeEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.updateEmployee","updateEmployee","updateEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+hrInterview.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public HrInterview createHrInterview(RetailscmUserContext userContext,String who, Date interviewTime, String comments) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfHrInterview(who);
		userContext.getChecker().checkInterviewTimeOfHrInterview(interviewTime);
		userContext.getChecker().checkCommentsOfHrInterview(comments);
	
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);


		HrInterview hrInterview=createNewHrInterview();	

		hrInterview.setWho(who);
		hrInterview.setInterviewTime(interviewTime);
		hrInterview.setComments(comments);

		hrInterview = saveHrInterview(userContext, hrInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, hrInterview);
		return hrInterview;

		
	}
	protected HrInterview createNewHrInterview() 
	{
		
		return new HrInterview();		
	}
	
	protected void checkParamsForUpdatingHrInterview(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
		userContext.getChecker().checkVersionOfHrInterview( hrInterviewVersion);
		

		if(HrInterview.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfHrInterview(parseString(newValueExpr));
		}
		if(HrInterview.INTERVIEW_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkInterviewTimeOfHrInterview(parseDate(newValueExpr));
		}
		if(HrInterview.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfHrInterview(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);
	
		
	}
	
	
	
	public HrInterview clone(RetailscmUserContext userContext, String fromHrInterviewId) throws Exception{
		
		return userContext.getDAOGroup().getHrInterviewDAO().clone(fromHrInterviewId, this.allTokens());
	}
	
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview) throws Exception 
	{
		return internalSaveHrInterview(userContext, hrInterview, allTokens());

	}
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(hrInterview){ 
			//will be good when the hrInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.
			
			
			hrInterview = saveHrInterview(userContext, hrInterview, options);
			return hrInterview;
			
		}

	}
	
	public HrInterview updateHrInterview(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);
		
		
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		if(hrInterview.getVersion() != hrInterviewVersion){
			String message = "The target version("+hrInterview.getVersion()+") is not equals to version("+hrInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hrInterview){ 
			//will be good when the hrInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.
			
			hrInterview.changeProperty(property, newValueExpr);
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			//return saveHrInterview(userContext, hrInterview, tokens().done());
		}

	}
	
	public HrInterview updateHrInterviewProperty(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		if(hrInterview.getVersion() != hrInterviewVersion){
			String message = "The target version("+hrInterview.getVersion()+") is not equals to version("+hrInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hrInterview){ 
			//will be good when the hrInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.
			
			hrInterview.changeProperty(property, newValueExpr);
			
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			//return saveHrInterview(userContext, hrInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected HrInterviewTokens tokens(){
		return HrInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return HrInterviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return HrInterviewTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String hrInterviewId, int hrInterviewVersion) throws Exception {
		//deleteInternal(userContext, hrInterviewId, hrInterviewVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String hrInterviewId, int hrInterviewVersion) throws Exception{
			
		userContext.getDAOGroup().getHrInterviewDAO().delete(hrInterviewId, hrInterviewVersion);
	}
	
	public HrInterview forgetByAll(RetailscmUserContext userContext, String hrInterviewId, int hrInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, hrInterviewId, hrInterviewVersion);		
	}
	protected HrInterview forgetByAllInternal(RetailscmUserContext userContext,
			String hrInterviewId, int hrInterviewVersion) throws Exception{
			
		return userContext.getDAOGroup().getHrInterviewDAO().disconnectFromAll(hrInterviewId, hrInterviewVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new HrInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getHrInterviewDAO().deleteAll();
	}


	//disconnect HrInterview with company in Employee
	protected HrInterview breakWithEmployeeByCompany(RetailscmUserContext userContext, String hrInterviewId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getHrInterviewDAO().planToRemoveEmployeeListWithCompany(hrInterview, companyId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with department in Employee
	protected HrInterview breakWithEmployeeByDepartment(RetailscmUserContext userContext, String hrInterviewId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getHrInterviewDAO().planToRemoveEmployeeListWithDepartment(hrInterview, departmentId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with occupation in Employee
	protected HrInterview breakWithEmployeeByOccupation(RetailscmUserContext userContext, String hrInterviewId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getHrInterviewDAO().planToRemoveEmployeeListWithOccupation(hrInterview, occupationId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with responsible_for in Employee
	protected HrInterview breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String hrInterviewId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getHrInterviewDAO().planToRemoveEmployeeListWithResponsibleFor(hrInterview, responsibleForId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with current_salary_grade in Employee
	protected HrInterview breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String hrInterviewId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getHrInterviewDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(hrInterview, currentSalaryGradeId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);

	
	}
	public  HrInterview addEmployee(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,hrInterviewId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.addEmployee( employee );		
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String hrInterviewId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);
		
	}
	public  HrInterview updateEmployeeProperties(RetailscmUserContext userContext, String hrInterviewId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,hrInterviewId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		HrInterview hrInterviewToUpdate = loadHrInterview(userContext, hrInterviewId, options);
		
		if(hrInterviewToUpdate.getEmployeeList().isEmpty()){
			throw new HrInterviewManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = hrInterviewToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,hrInterviewId,name, code, used,tokensExpr);
		HrInterview hrInterview = saveHrInterview(userContext, hrInterviewToUpdate, tokens().withEmployeeList().done());
		synchronized(hrInterview){ 
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String hrInterviewId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);
		
	}
	public  HrInterview removeEmployeeList(RetailscmUserContext userContext, String hrInterviewId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, hrInterviewId,  employeeIds, tokensExpr);
			
			
			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
			synchronized(hrInterview){ 
				//Will be good when the hrInterview loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getHrInterviewDAO().planToRemoveEmployeeList(hrInterview, employeeIds, allTokens());
				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, hrInterview.getEmployeeList());
				return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHrInterview( hrInterviewId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);
	
	}
	public  HrInterview removeEmployee(RetailscmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,hrInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.removeEmployee( employee );		
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHrInterview( hrInterviewId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);
	
	}
	public  HrInterview copyEmployeeFrom(RetailscmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,hrInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			hrInterview.copyEmployeeFrom( employee );		
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)hrInterview.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfHrInterview(hrInterviewId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(HrInterviewManagerException.class);
	
	}
	
	public  HrInterview updateEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, hrInterviewId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, loadTokens);
		
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hrInterview.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = hrInterview.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new HrInterviewManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  HrInterview associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToNewTermination(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}
	*/
	
	public  HrInterview associateEmployeeListToJobApplication(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}	public  HrInterview associateEmployeeListToTermination(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: hrInterview.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveHrInterview(userContext, hrInterview);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, HrInterview newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


