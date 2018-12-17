
package com.doublechaintech.retailscm.occupationtype;

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
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

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






public class OccupationTypeManagerImpl extends CustomRetailscmCheckerManager implements OccupationTypeManager {
	
	private static final String SERVICE_TYPE = "OccupationType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OccupationTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OccupationTypeManagerException(message);

	}
	
	

 	protected OccupationType saveOccupationType(RetailscmUserContext userContext, OccupationType occupationType, String [] tokensExpr) throws Exception{	
 		//return getOccupationTypeDAO().save(occupationType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOccupationType(userContext, occupationType, tokens);
 	}
 	
 	protected OccupationType saveOccupationTypeDetail(RetailscmUserContext userContext, OccupationType occupationType) throws Exception{	

 		
 		return saveOccupationType(userContext, occupationType, allTokens());
 	}
 	
 	public OccupationType loadOccupationType(RetailscmUserContext userContext, String occupationTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( OccupationTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,occupationType, tokens);
 	}
 	
 	
 	 public OccupationType searchOccupationType(RetailscmUserContext userContext, String occupationTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( OccupationTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,occupationType, tokens);
 	}
 	
 	

 	protected OccupationType present(RetailscmUserContext userContext, OccupationType occupationType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,occupationType,tokens);
		
		
		OccupationType  occupationTypeToPresent = userContext.getDAOGroup().getOccupationTypeDAO().present(occupationType, tokens);
		
		List<BaseEntity> entityListToNaming = occupationTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOccupationTypeDAO().alias(entityListToNaming);
		
		return  occupationTypeToPresent;
		
		
	}
 
 	
 	
 	public OccupationType loadOccupationTypeDetail(RetailscmUserContext userContext, String occupationTypeId) throws Exception{	
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, allTokens());
 		return present(userContext,occupationType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String occupationTypeId) throws Exception{	
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, viewTokens());
 		return present(userContext,occupationType, allTokens());
		
 	}
 	protected OccupationType saveOccupationType(RetailscmUserContext userContext, OccupationType occupationType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOccupationTypeDAO().save(occupationType, tokens);
 	}
 	protected OccupationType loadOccupationType(RetailscmUserContext userContext, String occupationTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( OccupationTypeManagerException.class);

 
 		return userContext.getDAOGroup().getOccupationTypeDAO().load(occupationTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OccupationType occupationType, Map<String, Object> tokens){
		super.addActions(userContext, occupationType, tokens);
		
		addAction(userContext, occupationType, tokens,"@create","createOccupationType","createOccupationType/","main","primary");
		addAction(userContext, occupationType, tokens,"@update","updateOccupationType","updateOccupationType/"+occupationType.getId()+"/","main","primary");
		addAction(userContext, occupationType, tokens,"@copy","cloneOccupationType","cloneOccupationType/"+occupationType.getId()+"/","main","primary");
		
		addAction(userContext, occupationType, tokens,"occupation_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+occupationType.getId()+"/","main","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.addEmployee","addEmployee","addEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.removeEmployee","removeEmployee","removeEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.updateEmployee","updateEmployee","updateEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+occupationType.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OccupationType occupationType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OccupationType createOccupationType(RetailscmUserContext userContext,String code, String companyId, String description, String detailDescription) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfOccupationType(code);
		userContext.getChecker().checkDescriptionOfOccupationType(description);
		userContext.getChecker().checkDetailDescriptionOfOccupationType(detailDescription);
	
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);


		OccupationType occupationType=createNewOccupationType();	

		occupationType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		occupationType.setCompany(company);
		
		
		occupationType.setDescription(description);
		occupationType.setDetailDescription(detailDescription);

		occupationType = saveOccupationType(userContext, occupationType, emptyOptions());
		
		onNewInstanceCreated(userContext, occupationType);
		return occupationType;

		
	}
	protected OccupationType createNewOccupationType() 
	{
		
		return new OccupationType();		
	}
	
	protected void checkParamsForUpdatingOccupationType(RetailscmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
		userContext.getChecker().checkVersionOfOccupationType( occupationTypeVersion);
		

		if(OccupationType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfOccupationType(parseString(newValueExpr));
		}		

		
		if(OccupationType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfOccupationType(parseString(newValueExpr));
		}
		if(OccupationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDetailDescriptionOfOccupationType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
	
		
	}
	
	
	
	public OccupationType clone(RetailscmUserContext userContext, String fromOccupationTypeId) throws Exception{
		
		return userContext.getDAOGroup().getOccupationTypeDAO().clone(fromOccupationTypeId, this.allTokens());
	}
	
	public OccupationType internalSaveOccupationType(RetailscmUserContext userContext, OccupationType occupationType) throws Exception 
	{
		return internalSaveOccupationType(userContext, occupationType, allTokens());

	}
	public OccupationType internalSaveOccupationType(RetailscmUserContext userContext, OccupationType occupationType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(occupationType){ 
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.
			
			
			occupationType = saveOccupationType(userContext, occupationType, options);
			return occupationType;
			
		}

	}
	
	public OccupationType updateOccupationType(RetailscmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		if(occupationType.getVersion() != occupationTypeVersion){
			String message = "The target version("+occupationType.getVersion()+") is not equals to version("+occupationTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(occupationType){ 
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.
			
			occupationType.changeProperty(property, newValueExpr);
			occupationType = saveOccupationType(userContext, occupationType, tokens().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			//return saveOccupationType(userContext, occupationType, tokens().done());
		}

	}
	
	public OccupationType updateOccupationTypeProperty(RetailscmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		if(occupationType.getVersion() != occupationTypeVersion){
			String message = "The target version("+occupationType.getVersion()+") is not equals to version("+occupationTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(occupationType){ 
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.
			
			occupationType.changeProperty(property, newValueExpr);
			
			occupationType = saveOccupationType(userContext, occupationType, tokens().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			//return saveOccupationType(userContext, occupationType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OccupationTypeTokens tokens(){
		return OccupationTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OccupationTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OccupationTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String occupationTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
 		
 	}
 	public OccupationType transferToAnotherCompany(RetailscmUserContext userContext, String occupationTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, occupationTypeId,anotherCompanyId);
 
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());	
		synchronized(occupationType){
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			occupationType.updateCompany(company);		
			occupationType = saveOccupationType(userContext, occupationType, emptyOptions());
			
			return present(userContext,occupationType, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForOccupationType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String occupationTypeId, int occupationTypeVersion) throws Exception {
		//deleteInternal(userContext, occupationTypeId, occupationTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String occupationTypeId, int occupationTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getOccupationTypeDAO().delete(occupationTypeId, occupationTypeVersion);
	}
	
	public OccupationType forgetByAll(RetailscmUserContext userContext, String occupationTypeId, int occupationTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, occupationTypeId, occupationTypeVersion);		
	}
	protected OccupationType forgetByAllInternal(RetailscmUserContext userContext,
			String occupationTypeId, int occupationTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getOccupationTypeDAO().disconnectFromAll(occupationTypeId, occupationTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OccupationTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOccupationTypeDAO().deleteAll();
	}


	//disconnect OccupationType with company in Employee
	protected OccupationType breakWithEmployeeByCompany(RetailscmUserContext userContext, String occupationTypeId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOccupationTypeDAO().planToRemoveEmployeeListWithCompany(occupationType, companyId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with department in Employee
	protected OccupationType breakWithEmployeeByDepartment(RetailscmUserContext userContext, String occupationTypeId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOccupationTypeDAO().planToRemoveEmployeeListWithDepartment(occupationType, departmentId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with responsible_for in Employee
	protected OccupationType breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String occupationTypeId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOccupationTypeDAO().planToRemoveEmployeeListWithResponsibleFor(occupationType, responsibleForId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with current_salary_grade in Employee
	protected OccupationType breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String occupationTypeId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOccupationTypeDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(occupationType, currentSalaryGradeId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);

		
		userContext.getChecker().checkCompanyIdOfEmployee(companyId);
		
		userContext.getChecker().checkTitleOfEmployee(title);
		
		userContext.getChecker().checkDepartmentIdOfEmployee(departmentId);
		
		userContext.getChecker().checkFamilyNameOfEmployee(familyName);
		
		userContext.getChecker().checkGivenNameOfEmployee(givenName);
		
		userContext.getChecker().checkEmailOfEmployee(email);
		
		userContext.getChecker().checkCityOfEmployee(city);
		
		userContext.getChecker().checkAddressOfEmployee(address);
		
		userContext.getChecker().checkCellPhoneOfEmployee(cellPhone);
		
		userContext.getChecker().checkResponsibleForIdOfEmployee(responsibleForId);
		
		userContext.getChecker().checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		userContext.getChecker().checkSalaryAccountOfEmployee(salaryAccount);
	
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);

	
	}
	public  OccupationType addEmployee(RetailscmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,occupationTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.addEmployee( employee );		
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String occupationTypeId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
		
	}
	public  OccupationType updateEmployeeProperties(RetailscmUserContext userContext, String occupationTypeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,occupationTypeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		OccupationType occupationTypeToUpdate = loadOccupationType(userContext, occupationTypeId, options);
		
		if(occupationTypeToUpdate.getEmployeeList().isEmpty()){
			throw new OccupationTypeManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = occupationTypeToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,occupationTypeId,name, code, used,tokensExpr);
		OccupationType occupationType = saveOccupationType(userContext, occupationTypeToUpdate, tokens().withEmployeeList().done());
		synchronized(occupationType){ 
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String occupationTypeId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
		
	}
	public  OccupationType removeEmployeeList(RetailscmUserContext userContext, String occupationTypeId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, occupationTypeId,  employeeIds, tokensExpr);
			
			
			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
			synchronized(occupationType){ 
				//Will be good when the occupationType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getOccupationTypeDAO().planToRemoveEmployeeList(occupationType, employeeIds, allTokens());
				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, occupationType.getEmployeeList());
				return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOccupationType( occupationTypeId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
	
	}
	public  OccupationType removeEmployee(RetailscmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,occupationTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.removeEmployee( employee );		
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOccupationType( occupationTypeId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
	
	}
	public  OccupationType copyEmployeeFrom(RetailscmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,occupationTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			occupationType.copyEmployeeFrom( employee );		
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)occupationType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfOccupationType(occupationTypeId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(OccupationTypeManagerException.class);
	
	}
	
	public  OccupationType updateEmployee(RetailscmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, occupationTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, loadTokens);
		
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//occupationType.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = occupationType.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OccupationTypeManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  OccupationType associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToNewTermination(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}
	*/
	
	public  OccupationType associateEmployeeListToJobApplication(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToHrInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}	public  OccupationType associateEmployeeListToTermination(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: occupationType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveOccupationType(userContext, occupationType);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, OccupationType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


