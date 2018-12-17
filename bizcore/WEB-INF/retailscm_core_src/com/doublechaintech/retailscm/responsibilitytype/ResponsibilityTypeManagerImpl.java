
package com.doublechaintech.retailscm.responsibilitytype;

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






public class ResponsibilityTypeManagerImpl extends CustomRetailscmCheckerManager implements ResponsibilityTypeManager {
	
	private static final String SERVICE_TYPE = "ResponsibilityType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ResponsibilityTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ResponsibilityTypeManagerException(message);

	}
	
	

 	protected ResponsibilityType saveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType, String [] tokensExpr) throws Exception{	
 		//return getResponsibilityTypeDAO().save(responsibilityType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveResponsibilityType(userContext, responsibilityType, tokens);
 	}
 	
 	protected ResponsibilityType saveResponsibilityTypeDetail(RetailscmUserContext userContext, ResponsibilityType responsibilityType) throws Exception{	

 		
 		return saveResponsibilityType(userContext, responsibilityType, allTokens());
 	}
 	
 	public ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}
 	
 	
 	 public ResponsibilityType searchResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}
 	
 	

 	protected ResponsibilityType present(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,responsibilityType,tokens);
		
		
		ResponsibilityType  responsibilityTypeToPresent = userContext.getDAOGroup().getResponsibilityTypeDAO().present(responsibilityType, tokens);
		
		List<BaseEntity> entityListToNaming = responsibilityTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getResponsibilityTypeDAO().alias(entityListToNaming);
		
		return  responsibilityTypeToPresent;
		
		
	}
 
 	
 	
 	public ResponsibilityType loadResponsibilityTypeDetail(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{	
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, allTokens());
 		return present(userContext,responsibilityType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{	
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, viewTokens());
 		return present(userContext,responsibilityType, allTokens());
		
 	}
 	protected ResponsibilityType saveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getResponsibilityTypeDAO().save(responsibilityType, tokens);
 	}
 	protected ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);

 
 		return userContext.getDAOGroup().getResponsibilityTypeDAO().load(responsibilityTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens){
		super.addActions(userContext, responsibilityType, tokens);
		
		addAction(userContext, responsibilityType, tokens,"@create","createResponsibilityType","createResponsibilityType/","main","primary");
		addAction(userContext, responsibilityType, tokens,"@update","updateResponsibilityType","updateResponsibilityType/"+responsibilityType.getId()+"/","main","primary");
		addAction(userContext, responsibilityType, tokens,"@copy","cloneResponsibilityType","cloneResponsibilityType/"+responsibilityType.getId()+"/","main","primary");
		
		addAction(userContext, responsibilityType, tokens,"responsibility_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+responsibilityType.getId()+"/","main","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.addEmployee","addEmployee","addEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.removeEmployee","removeEmployee","removeEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.updateEmployee","updateEmployee","updateEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+responsibilityType.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ResponsibilityType createResponsibilityType(RetailscmUserContext userContext,String code, String companyId, String baseDescription, String detailDescription) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfResponsibilityType(code);
		userContext.getChecker().checkBaseDescriptionOfResponsibilityType(baseDescription);
		userContext.getChecker().checkDetailDescriptionOfResponsibilityType(detailDescription);
	
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


		ResponsibilityType responsibilityType=createNewResponsibilityType();	

		responsibilityType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		responsibilityType.setCompany(company);
		
		
		responsibilityType.setBaseDescription(baseDescription);
		responsibilityType.setDetailDescription(detailDescription);

		responsibilityType = saveResponsibilityType(userContext, responsibilityType, emptyOptions());
		
		onNewInstanceCreated(userContext, responsibilityType);
		return responsibilityType;

		
	}
	protected ResponsibilityType createNewResponsibilityType() 
	{
		
		return new ResponsibilityType();		
	}
	
	protected void checkParamsForUpdatingResponsibilityType(RetailscmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
		userContext.getChecker().checkVersionOfResponsibilityType( responsibilityTypeVersion);
		

		if(ResponsibilityType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfResponsibilityType(parseString(newValueExpr));
		}		

		
		if(ResponsibilityType.BASE_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkBaseDescriptionOfResponsibilityType(parseString(newValueExpr));
		}
		if(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDetailDescriptionOfResponsibilityType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
	
		
	}
	
	
	
	public ResponsibilityType clone(RetailscmUserContext userContext, String fromResponsibilityTypeId) throws Exception{
		
		return userContext.getDAOGroup().getResponsibilityTypeDAO().clone(fromResponsibilityTypeId, this.allTokens());
	}
	
	public ResponsibilityType internalSaveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType) throws Exception 
	{
		return internalSaveResponsibilityType(userContext, responsibilityType, allTokens());

	}
	public ResponsibilityType internalSaveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(responsibilityType){ 
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.
			
			
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, options);
			return responsibilityType;
			
		}

	}
	
	public ResponsibilityType updateResponsibilityType(RetailscmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		if(responsibilityType.getVersion() != responsibilityTypeVersion){
			String message = "The target version("+responsibilityType.getVersion()+") is not equals to version("+responsibilityTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(responsibilityType){ 
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.
			
			responsibilityType.changeProperty(property, newValueExpr);
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			//return saveResponsibilityType(userContext, responsibilityType, tokens().done());
		}

	}
	
	public ResponsibilityType updateResponsibilityTypeProperty(RetailscmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		if(responsibilityType.getVersion() != responsibilityTypeVersion){
			String message = "The target version("+responsibilityType.getVersion()+") is not equals to version("+responsibilityTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(responsibilityType){ 
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.
			
			responsibilityType.changeProperty(property, newValueExpr);
			
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			//return saveResponsibilityType(userContext, responsibilityType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ResponsibilityTypeTokens tokens(){
		return ResponsibilityTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ResponsibilityTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ResponsibilityTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
 		
 	}
 	public ResponsibilityType transferToAnotherCompany(RetailscmUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, responsibilityTypeId,anotherCompanyId);
 
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());	
		synchronized(responsibilityType){
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			responsibilityType.updateCompany(company);		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, emptyOptions());
			
			return present(userContext,responsibilityType, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForResponsibilityType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		//deleteInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getResponsibilityTypeDAO().delete(responsibilityTypeId, responsibilityTypeVersion);
	}
	
	public ResponsibilityType forgetByAll(RetailscmUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);		
	}
	protected ResponsibilityType forgetByAllInternal(RetailscmUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getResponsibilityTypeDAO().disconnectFromAll(responsibilityTypeId, responsibilityTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ResponsibilityTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getResponsibilityTypeDAO().deleteAll();
	}


	//disconnect ResponsibilityType with company in Employee
	protected ResponsibilityType breakWithEmployeeByCompany(RetailscmUserContext userContext, String responsibilityTypeId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getResponsibilityTypeDAO().planToRemoveEmployeeListWithCompany(responsibilityType, companyId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with department in Employee
	protected ResponsibilityType breakWithEmployeeByDepartment(RetailscmUserContext userContext, String responsibilityTypeId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getResponsibilityTypeDAO().planToRemoveEmployeeListWithDepartment(responsibilityType, departmentId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with occupation in Employee
	protected ResponsibilityType breakWithEmployeeByOccupation(RetailscmUserContext userContext, String responsibilityTypeId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getResponsibilityTypeDAO().planToRemoveEmployeeListWithOccupation(responsibilityType, occupationId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with current_salary_grade in Employee
	protected ResponsibilityType breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String responsibilityTypeId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getResponsibilityTypeDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(responsibilityType, currentSalaryGradeId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);

		
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
		
		userContext.getChecker().checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		userContext.getChecker().checkSalaryAccountOfEmployee(salaryAccount);
	
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	
	}
	public  ResponsibilityType addEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,responsibilityTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount);
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.addEmployee( employee );		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String responsibilityTypeId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
		
	}
	public  ResponsibilityType updateEmployeeProperties(RetailscmUserContext userContext, String responsibilityTypeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,responsibilityTypeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		ResponsibilityType responsibilityTypeToUpdate = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		if(responsibilityTypeToUpdate.getEmployeeList().isEmpty()){
			throw new ResponsibilityTypeManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = responsibilityTypeToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,responsibilityTypeId,name, code, used,tokensExpr);
		ResponsibilityType responsibilityType = saveResponsibilityType(userContext, responsibilityTypeToUpdate, tokens().withEmployeeList().done());
		synchronized(responsibilityType){ 
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount) throws Exception{

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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String responsibilityTypeId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
		
	}
	public  ResponsibilityType removeEmployeeList(RetailscmUserContext userContext, String responsibilityTypeId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, responsibilityTypeId,  employeeIds, tokensExpr);
			
			
			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
			synchronized(responsibilityType){ 
				//Will be good when the responsibilityType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getResponsibilityTypeDAO().planToRemoveEmployeeList(responsibilityType, employeeIds, allTokens());
				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, responsibilityType.getEmployeeList());
				return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfResponsibilityType( responsibilityTypeId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
	
	}
	public  ResponsibilityType removeEmployee(RetailscmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,responsibilityTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.removeEmployee( employee );		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfResponsibilityType( responsibilityTypeId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
	
	}
	public  ResponsibilityType copyEmployeeFrom(RetailscmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,responsibilityTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			responsibilityType.copyEmployeeFrom( employee );		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)responsibilityType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfResponsibilityType(responsibilityTypeId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);
	
	}
	
	public  ResponsibilityType updateEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, responsibilityTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, loadTokens);
		
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//responsibilityType.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = responsibilityType.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new ResponsibilityTypeManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  ResponsibilityType associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToNewTermination(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}
	*/
	
	public  ResponsibilityType associateEmployeeListToJobApplication(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToHrInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}	public  ResponsibilityType associateEmployeeListToTermination(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: responsibilityType.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveResponsibilityType(userContext, responsibilityType);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, ResponsibilityType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


