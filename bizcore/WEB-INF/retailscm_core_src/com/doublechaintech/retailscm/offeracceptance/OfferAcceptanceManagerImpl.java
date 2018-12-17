
package com.doublechaintech.retailscm.offeracceptance;

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






public class OfferAcceptanceManagerImpl extends CustomRetailscmCheckerManager implements OfferAcceptanceManager {
	
	private static final String SERVICE_TYPE = "OfferAcceptance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OfferAcceptanceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OfferAcceptanceManagerException(message);

	}
	
	

 	protected OfferAcceptance saveOfferAcceptance(RetailscmUserContext userContext, OfferAcceptance offerAcceptance, String [] tokensExpr) throws Exception{	
 		//return getOfferAcceptanceDAO().save(offerAcceptance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOfferAcceptance(userContext, offerAcceptance, tokens);
 	}
 	
 	protected OfferAcceptance saveOfferAcceptanceDetail(RetailscmUserContext userContext, OfferAcceptance offerAcceptance) throws Exception{	

 		
 		return saveOfferAcceptance(userContext, offerAcceptance, allTokens());
 	}
 	
 	public OfferAcceptance loadOfferAcceptance(RetailscmUserContext userContext, String offerAcceptanceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
		userContext.getChecker().throwExceptionIfHasErrors( OfferAcceptanceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerAcceptance, tokens);
 	}
 	
 	
 	 public OfferAcceptance searchOfferAcceptance(RetailscmUserContext userContext, String offerAcceptanceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
		userContext.getChecker().throwExceptionIfHasErrors( OfferAcceptanceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerAcceptance, tokens);
 	}
 	
 	

 	protected OfferAcceptance present(RetailscmUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,offerAcceptance,tokens);
		
		
		OfferAcceptance  offerAcceptanceToPresent = userContext.getDAOGroup().getOfferAcceptanceDAO().present(offerAcceptance, tokens);
		
		List<BaseEntity> entityListToNaming = offerAcceptanceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOfferAcceptanceDAO().alias(entityListToNaming);
		
		return  offerAcceptanceToPresent;
		
		
	}
 
 	
 	
 	public OfferAcceptance loadOfferAcceptanceDetail(RetailscmUserContext userContext, String offerAcceptanceId) throws Exception{	
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, allTokens());
 		return present(userContext,offerAcceptance, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String offerAcceptanceId) throws Exception{	
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, viewTokens());
 		return present(userContext,offerAcceptance, allTokens());
		
 	}
 	protected OfferAcceptance saveOfferAcceptance(RetailscmUserContext userContext, OfferAcceptance offerAcceptance, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOfferAcceptanceDAO().save(offerAcceptance, tokens);
 	}
 	protected OfferAcceptance loadOfferAcceptance(RetailscmUserContext userContext, String offerAcceptanceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
		userContext.getChecker().throwExceptionIfHasErrors( OfferAcceptanceManagerException.class);

 
 		return userContext.getDAOGroup().getOfferAcceptanceDAO().load(offerAcceptanceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens){
		super.addActions(userContext, offerAcceptance, tokens);
		
		addAction(userContext, offerAcceptance, tokens,"@create","createOfferAcceptance","createOfferAcceptance/","main","primary");
		addAction(userContext, offerAcceptance, tokens,"@update","updateOfferAcceptance","updateOfferAcceptance/"+offerAcceptance.getId()+"/","main","primary");
		addAction(userContext, offerAcceptance, tokens,"@copy","cloneOfferAcceptance","cloneOfferAcceptance/"+offerAcceptance.getId()+"/","main","primary");
		
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.addEmployee","addEmployee","addEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.removeEmployee","removeEmployee","removeEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.updateEmployee","updateEmployee","updateEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+offerAcceptance.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OfferAcceptance createOfferAcceptance(RetailscmUserContext userContext,String who, Date acceptTime, String comments) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfOfferAcceptance(who);
		userContext.getChecker().checkAcceptTimeOfOfferAcceptance(acceptTime);
		userContext.getChecker().checkCommentsOfOfferAcceptance(comments);
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);


		OfferAcceptance offerAcceptance=createNewOfferAcceptance();	

		offerAcceptance.setWho(who);
		offerAcceptance.setAcceptTime(acceptTime);
		offerAcceptance.setComments(comments);

		offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, emptyOptions());
		
		onNewInstanceCreated(userContext, offerAcceptance);
		return offerAcceptance;

		
	}
	protected OfferAcceptance createNewOfferAcceptance() 
	{
		
		return new OfferAcceptance();		
	}
	
	protected void checkParamsForUpdatingOfferAcceptance(RetailscmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
		userContext.getChecker().checkVersionOfOfferAcceptance( offerAcceptanceVersion);
		

		if(OfferAcceptance.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfOfferAcceptance(parseString(newValueExpr));
		}
		if(OfferAcceptance.ACCEPT_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkAcceptTimeOfOfferAcceptance(parseDate(newValueExpr));
		}
		if(OfferAcceptance.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfOfferAcceptance(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);
	
		
	}
	
	
	
	public OfferAcceptance clone(RetailscmUserContext userContext, String fromOfferAcceptanceId) throws Exception{
		
		return userContext.getDAOGroup().getOfferAcceptanceDAO().clone(fromOfferAcceptanceId, this.allTokens());
	}
	
	public OfferAcceptance internalSaveOfferAcceptance(RetailscmUserContext userContext, OfferAcceptance offerAcceptance) throws Exception 
	{
		return internalSaveOfferAcceptance(userContext, offerAcceptance, allTokens());

	}
	public OfferAcceptance internalSaveOfferAcceptance(RetailscmUserContext userContext, OfferAcceptance offerAcceptance, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(offerAcceptance){ 
			//will be good when the offerAcceptance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.
			
			
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, options);
			return offerAcceptance;
			
		}

	}
	
	public OfferAcceptance updateOfferAcceptance(RetailscmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);
		
		
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		if(offerAcceptance.getVersion() != offerAcceptanceVersion){
			String message = "The target version("+offerAcceptance.getVersion()+") is not equals to version("+offerAcceptanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerAcceptance){ 
			//will be good when the offerAcceptance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.
			
			offerAcceptance.changeProperty(property, newValueExpr);
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			//return saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
		}

	}
	
	public OfferAcceptance updateOfferAcceptanceProperty(RetailscmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		if(offerAcceptance.getVersion() != offerAcceptanceVersion){
			String message = "The target version("+offerAcceptance.getVersion()+") is not equals to version("+offerAcceptanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerAcceptance){ 
			//will be good when the offerAcceptance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.
			
			offerAcceptance.changeProperty(property, newValueExpr);
			
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			//return saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OfferAcceptanceTokens tokens(){
		return OfferAcceptanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OfferAcceptanceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OfferAcceptanceTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String offerAcceptanceId, int offerAcceptanceVersion) throws Exception {
		//deleteInternal(userContext, offerAcceptanceId, offerAcceptanceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String offerAcceptanceId, int offerAcceptanceVersion) throws Exception{
			
		userContext.getDAOGroup().getOfferAcceptanceDAO().delete(offerAcceptanceId, offerAcceptanceVersion);
	}
	
	public OfferAcceptance forgetByAll(RetailscmUserContext userContext, String offerAcceptanceId, int offerAcceptanceVersion) throws Exception {
		return forgetByAllInternal(userContext, offerAcceptanceId, offerAcceptanceVersion);		
	}
	protected OfferAcceptance forgetByAllInternal(RetailscmUserContext userContext,
			String offerAcceptanceId, int offerAcceptanceVersion) throws Exception{
			
		return userContext.getDAOGroup().getOfferAcceptanceDAO().disconnectFromAll(offerAcceptanceId, offerAcceptanceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OfferAcceptanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOfferAcceptanceDAO().deleteAll();
	}


	//disconnect OfferAcceptance with company in Employee
	protected OfferAcceptance breakWithEmployeeByCompany(RetailscmUserContext userContext, String offerAcceptanceId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferAcceptanceDAO().planToRemoveEmployeeListWithCompany(offerAcceptance, companyId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with department in Employee
	protected OfferAcceptance breakWithEmployeeByDepartment(RetailscmUserContext userContext, String offerAcceptanceId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferAcceptanceDAO().planToRemoveEmployeeListWithDepartment(offerAcceptance, departmentId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with occupation in Employee
	protected OfferAcceptance breakWithEmployeeByOccupation(RetailscmUserContext userContext, String offerAcceptanceId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferAcceptanceDAO().planToRemoveEmployeeListWithOccupation(offerAcceptance, occupationId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with responsible_for in Employee
	protected OfferAcceptance breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String offerAcceptanceId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferAcceptanceDAO().planToRemoveEmployeeListWithResponsibleFor(offerAcceptance, responsibleForId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with current_salary_grade in Employee
	protected OfferAcceptance breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String offerAcceptanceId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOfferAcceptanceDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(offerAcceptance, currentSalaryGradeId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);

	
	}
	public  OfferAcceptance addEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,offerAcceptanceId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.addEmployee( employee );		
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String offerAcceptanceId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);
		
	}
	public  OfferAcceptance updateEmployeeProperties(RetailscmUserContext userContext, String offerAcceptanceId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,offerAcceptanceId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		OfferAcceptance offerAcceptanceToUpdate = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		if(offerAcceptanceToUpdate.getEmployeeList().isEmpty()){
			throw new OfferAcceptanceManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = offerAcceptanceToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,offerAcceptanceId,name, code, used,tokensExpr);
		OfferAcceptance offerAcceptance = saveOfferAcceptance(userContext, offerAcceptanceToUpdate, tokens().withEmployeeList().done());
		synchronized(offerAcceptance){ 
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String offerAcceptanceId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);
		
	}
	public  OfferAcceptance removeEmployeeList(RetailscmUserContext userContext, String offerAcceptanceId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, offerAcceptanceId,  employeeIds, tokensExpr);
			
			
			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
			synchronized(offerAcceptance){ 
				//Will be good when the offerAcceptance loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getOfferAcceptanceDAO().planToRemoveEmployeeList(offerAcceptance, employeeIds, allTokens());
				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, offerAcceptance.getEmployeeList());
				return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOfferAcceptance( offerAcceptanceId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);
	
	}
	public  OfferAcceptance removeEmployee(RetailscmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,offerAcceptanceId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.removeEmployee( employee );		
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOfferAcceptance( offerAcceptanceId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);
	
	}
	public  OfferAcceptance copyEmployeeFrom(RetailscmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,offerAcceptanceId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			offerAcceptance.copyEmployeeFrom( employee );		
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)offerAcceptance.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfOfferAcceptance(offerAcceptanceId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);
	
	}
	
	public  OfferAcceptance updateEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, offerAcceptanceId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, loadTokens);
		
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//offerAcceptance.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = offerAcceptance.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OfferAcceptanceManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  OfferAcceptance associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToNewTermination(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}
	*/
	
	public  OfferAcceptance associateEmployeeListToJobApplication(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToHrInterview(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}	public  OfferAcceptance associateEmployeeListToTermination(RetailscmUserContext userContext, String offerAcceptanceId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: offerAcceptance.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveOfferAcceptance(userContext, offerAcceptance);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, OfferAcceptance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


