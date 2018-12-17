
package com.doublechaintech.retailscm.offerapproval;

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






public class OfferApprovalManagerImpl extends CustomRetailscmCheckerManager implements OfferApprovalManager {
	
	private static final String SERVICE_TYPE = "OfferApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OfferApprovalManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OfferApprovalManagerException(message);

	}
	
	

 	protected OfferApproval saveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval, String [] tokensExpr) throws Exception{	
 		//return getOfferApprovalDAO().save(offerApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOfferApproval(userContext, offerApproval, tokens);
 	}
 	
 	protected OfferApproval saveOfferApprovalDetail(RetailscmUserContext userContext, OfferApproval offerApproval) throws Exception{	

 		
 		return saveOfferApproval(userContext, offerApproval, allTokens());
 	}
 	
 	public OfferApproval loadOfferApproval(RetailscmUserContext userContext, String offerApprovalId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( OfferApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerApproval, tokens);
 	}
 	
 	
 	 public OfferApproval searchOfferApproval(RetailscmUserContext userContext, String offerApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( OfferApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerApproval, tokens);
 	}
 	
 	

 	protected OfferApproval present(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,offerApproval,tokens);
		
		
		OfferApproval  offerApprovalToPresent = userContext.getDAOGroup().getOfferApprovalDAO().present(offerApproval, tokens);
		
		List<BaseEntity> entityListToNaming = offerApprovalToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOfferApprovalDAO().alias(entityListToNaming);
		
		return  offerApprovalToPresent;
		
		
	}
 
 	
 	
 	public OfferApproval loadOfferApprovalDetail(RetailscmUserContext userContext, String offerApprovalId) throws Exception{	
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, allTokens());
 		return present(userContext,offerApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String offerApprovalId) throws Exception{	
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, viewTokens());
 		return present(userContext,offerApproval, allTokens());
		
 	}
 	protected OfferApproval saveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOfferApprovalDAO().save(offerApproval, tokens);
 	}
 	protected OfferApproval loadOfferApproval(RetailscmUserContext userContext, String offerApprovalId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( OfferApprovalManagerException.class);

 
 		return userContext.getDAOGroup().getOfferApprovalDAO().load(offerApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens){
		super.addActions(userContext, offerApproval, tokens);
		
		addAction(userContext, offerApproval, tokens,"@create","createOfferApproval","createOfferApproval/","main","primary");
		addAction(userContext, offerApproval, tokens,"@update","updateOfferApproval","updateOfferApproval/"+offerApproval.getId()+"/","main","primary");
		addAction(userContext, offerApproval, tokens,"@copy","cloneOfferApproval","cloneOfferApproval/"+offerApproval.getId()+"/","main","primary");
		
		addAction(userContext, offerApproval, tokens,"offer_approval.addEmployee","addEmployee","addEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.removeEmployee","removeEmployee","removeEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.updateEmployee","updateEmployee","updateEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+offerApproval.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OfferApproval createOfferApproval(RetailscmUserContext userContext,String who, Date approveTime, String comments) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfOfferApproval(who);
		userContext.getChecker().checkApproveTimeOfOfferApproval(approveTime);
		userContext.getChecker().checkCommentsOfOfferApproval(comments);
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);


		OfferApproval offerApproval=createNewOfferApproval();	

		offerApproval.setWho(who);
		offerApproval.setApproveTime(approveTime);
		offerApproval.setComments(comments);

		offerApproval = saveOfferApproval(userContext, offerApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, offerApproval);
		return offerApproval;

		
	}
	protected OfferApproval createNewOfferApproval() 
	{
		
		return new OfferApproval();		
	}
	
	protected void checkParamsForUpdatingOfferApproval(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
		userContext.getChecker().checkVersionOfOfferApproval( offerApprovalVersion);
		

		if(OfferApproval.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfOfferApproval(parseString(newValueExpr));
		}
		if(OfferApproval.APPROVE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkApproveTimeOfOfferApproval(parseDate(newValueExpr));
		}
		if(OfferApproval.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfOfferApproval(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);
	
		
	}
	
	
	
	public OfferApproval clone(RetailscmUserContext userContext, String fromOfferApprovalId) throws Exception{
		
		return userContext.getDAOGroup().getOfferApprovalDAO().clone(fromOfferApprovalId, this.allTokens());
	}
	
	public OfferApproval internalSaveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval) throws Exception 
	{
		return internalSaveOfferApproval(userContext, offerApproval, allTokens());

	}
	public OfferApproval internalSaveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(offerApproval){ 
			//will be good when the offerApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.
			
			
			offerApproval = saveOfferApproval(userContext, offerApproval, options);
			return offerApproval;
			
		}

	}
	
	public OfferApproval updateOfferApproval(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		if(offerApproval.getVersion() != offerApprovalVersion){
			String message = "The target version("+offerApproval.getVersion()+") is not equals to version("+offerApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerApproval){ 
			//will be good when the offerApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.
			
			offerApproval.changeProperty(property, newValueExpr);
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			//return saveOfferApproval(userContext, offerApproval, tokens().done());
		}

	}
	
	public OfferApproval updateOfferApprovalProperty(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		if(offerApproval.getVersion() != offerApprovalVersion){
			String message = "The target version("+offerApproval.getVersion()+") is not equals to version("+offerApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerApproval){ 
			//will be good when the offerApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.
			
			offerApproval.changeProperty(property, newValueExpr);
			
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			//return saveOfferApproval(userContext, offerApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OfferApprovalTokens tokens(){
		return OfferApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OfferApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OfferApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String offerApprovalId, int offerApprovalVersion) throws Exception {
		//deleteInternal(userContext, offerApprovalId, offerApprovalVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String offerApprovalId, int offerApprovalVersion) throws Exception{
			
		userContext.getDAOGroup().getOfferApprovalDAO().delete(offerApprovalId, offerApprovalVersion);
	}
	
	public OfferApproval forgetByAll(RetailscmUserContext userContext, String offerApprovalId, int offerApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, offerApprovalId, offerApprovalVersion);		
	}
	protected OfferApproval forgetByAllInternal(RetailscmUserContext userContext,
			String offerApprovalId, int offerApprovalVersion) throws Exception{
			
		return userContext.getDAOGroup().getOfferApprovalDAO().disconnectFromAll(offerApprovalId, offerApprovalVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OfferApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOfferApprovalDAO().deleteAll();
	}


	//disconnect OfferApproval with company in Employee
	protected OfferApproval breakWithEmployeeByCompany(RetailscmUserContext userContext, String offerApprovalId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferApprovalDAO().planToRemoveEmployeeListWithCompany(offerApproval, companyId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with department in Employee
	protected OfferApproval breakWithEmployeeByDepartment(RetailscmUserContext userContext, String offerApprovalId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferApprovalDAO().planToRemoveEmployeeListWithDepartment(offerApproval, departmentId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with occupation in Employee
	protected OfferApproval breakWithEmployeeByOccupation(RetailscmUserContext userContext, String offerApprovalId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferApprovalDAO().planToRemoveEmployeeListWithOccupation(offerApproval, occupationId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with responsible_for in Employee
	protected OfferApproval breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String offerApprovalId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferApprovalDAO().planToRemoveEmployeeListWithResponsibleFor(offerApproval, responsibleForId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with current_salary_grade in Employee
	protected OfferApproval breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String offerApprovalId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferApprovalDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(offerApproval, currentSalaryGradeId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);

	
	}
	public  OfferApproval addEmployee(RetailscmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,offerApprovalId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.addEmployee( employee );		
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String offerApprovalId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);
		
	}
	public  OfferApproval updateEmployeeProperties(RetailscmUserContext userContext, String offerApprovalId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,offerApprovalId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		OfferApproval offerApprovalToUpdate = loadOfferApproval(userContext, offerApprovalId, options);
		
		if(offerApprovalToUpdate.getEmployeeList().isEmpty()){
			throw new OfferApprovalManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = offerApprovalToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,offerApprovalId,name, code, used,tokensExpr);
		OfferApproval offerApproval = saveOfferApproval(userContext, offerApprovalToUpdate, tokens().withEmployeeList().done());
		synchronized(offerApproval){ 
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String offerApprovalId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);
		
	}
	public  OfferApproval removeEmployeeList(RetailscmUserContext userContext, String offerApprovalId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, offerApprovalId,  employeeIds, tokensExpr);
			
			
			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
			synchronized(offerApproval){ 
				//Will be good when the offerApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getOfferApprovalDAO().planToRemoveEmployeeList(offerApproval, employeeIds, allTokens());
				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, offerApproval.getEmployeeList());
				return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOfferApproval( offerApprovalId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);
	
	}
	public  OfferApproval removeEmployee(RetailscmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,offerApprovalId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.removeEmployee( employee );		
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOfferApproval( offerApprovalId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);
	
	}
	public  OfferApproval copyEmployeeFrom(RetailscmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,offerApprovalId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			offerApproval.copyEmployeeFrom( employee );		
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)offerApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfOfferApproval(offerApprovalId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferApprovalManagerException.class);
	
	}
	
	public  OfferApproval updateEmployee(RetailscmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, offerApprovalId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, loadTokens);
		
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//offerApproval.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = offerApproval.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OfferApprovalManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  OfferApproval associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToNewTermination(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}
	*/
	
	public  OfferApproval associateEmployeeListToJobApplication(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToHrInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}	public  OfferApproval associateEmployeeListToTermination(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: offerApproval.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveOfferApproval(userContext, offerApproval);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, OfferApproval newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


