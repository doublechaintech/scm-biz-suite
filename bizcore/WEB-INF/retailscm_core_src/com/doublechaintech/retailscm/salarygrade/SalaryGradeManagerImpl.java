
package com.doublechaintech.retailscm.salarygrade;

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
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.hrinterview.HrInterview;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.professioninterview.ProfessionInterview;
import com.doublechaintech.retailscm.offeracceptance.OfferAcceptance;
import com.doublechaintech.retailscm.employeeboarding.EmployeeBoarding;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.offerapproval.OfferApproval;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.jobapplication.JobApplication;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;






public class SalaryGradeManagerImpl extends CustomRetailscmCheckerManager implements SalaryGradeManager {
	
	private static final String SERVICE_TYPE = "SalaryGrade";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SalaryGradeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SalaryGradeManagerException(message);

	}
	
	

 	protected SalaryGrade saveSalaryGrade(RetailscmUserContext userContext, SalaryGrade salaryGrade, String [] tokensExpr) throws Exception{	
 		//return getSalaryGradeDAO().save(salaryGrade, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSalaryGrade(userContext, salaryGrade, tokens);
 	}
 	
 	protected SalaryGrade saveSalaryGradeDetail(RetailscmUserContext userContext, SalaryGrade salaryGrade) throws Exception{	

 		
 		return saveSalaryGrade(userContext, salaryGrade, allTokens());
 	}
 	
 	public SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String salaryGradeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		userContext.getChecker().throwExceptionIfHasErrors( SalaryGradeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,salaryGrade, tokens);
 	}
 	
 	
 	 public SalaryGrade searchSalaryGrade(RetailscmUserContext userContext, String salaryGradeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		userContext.getChecker().throwExceptionIfHasErrors( SalaryGradeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,salaryGrade, tokens);
 	}
 	
 	

 	protected SalaryGrade present(RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,salaryGrade,tokens);
		
		
		SalaryGrade  salaryGradeToPresent = userContext.getDAOGroup().getSalaryGradeDAO().present(salaryGrade, tokens);
		
		List<BaseEntity> entityListToNaming = salaryGradeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSalaryGradeDAO().alias(entityListToNaming);
		
		return  salaryGradeToPresent;
		
		
	}
 
 	
 	
 	public SalaryGrade loadSalaryGradeDetail(RetailscmUserContext userContext, String salaryGradeId) throws Exception{	
 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, allTokens());
 		return present(userContext,salaryGrade, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String salaryGradeId) throws Exception{	
 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, viewTokens());
 		return present(userContext,salaryGrade, allTokens());
		
 	}
 	protected SalaryGrade saveSalaryGrade(RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSalaryGradeDAO().save(salaryGrade, tokens);
 	}
 	protected SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String salaryGradeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		userContext.getChecker().throwExceptionIfHasErrors( SalaryGradeManagerException.class);

 
 		return userContext.getDAOGroup().getSalaryGradeDAO().load(salaryGradeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens){
		super.addActions(userContext, salaryGrade, tokens);
		
		addAction(userContext, salaryGrade, tokens,"@create","createSalaryGrade","createSalaryGrade/","main","primary");
		addAction(userContext, salaryGrade, tokens,"@update","updateSalaryGrade","updateSalaryGrade/"+salaryGrade.getId()+"/","main","primary");
		addAction(userContext, salaryGrade, tokens,"@copy","cloneSalaryGrade","cloneSalaryGrade/"+salaryGrade.getId()+"/","main","primary");
		
		addAction(userContext, salaryGrade, tokens,"salary_grade.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+salaryGrade.getId()+"/","main","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.addEmployee","addEmployee","addEmployee/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.removeEmployee","removeEmployee","removeEmployee/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.updateEmployee","updateEmployee","updateEmployee/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.addEmployeeSalarySheet","addEmployeeSalarySheet","addEmployeeSalarySheet/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.removeEmployeeSalarySheet","removeEmployeeSalarySheet","removeEmployeeSalarySheet/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.updateEmployeeSalarySheet","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SalaryGrade createSalaryGrade(RetailscmUserContext userContext,String code, String companyId, String name, String detailDescription) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfSalaryGrade(code);
		userContext.getChecker().checkNameOfSalaryGrade(name);
		userContext.getChecker().checkDetailDescriptionOfSalaryGrade(detailDescription);
	
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);


		SalaryGrade salaryGrade=createNewSalaryGrade();	

		salaryGrade.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		salaryGrade.setCompany(company);
		
		
		salaryGrade.setName(name);
		salaryGrade.setDetailDescription(detailDescription);

		salaryGrade = saveSalaryGrade(userContext, salaryGrade, emptyOptions());
		
		onNewInstanceCreated(userContext, salaryGrade);
		return salaryGrade;

		
	}
	protected SalaryGrade createNewSalaryGrade() 
	{
		
		return new SalaryGrade();		
	}
	
	protected void checkParamsForUpdatingSalaryGrade(RetailscmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		userContext.getChecker().checkVersionOfSalaryGrade( salaryGradeVersion);
		

		if(SalaryGrade.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfSalaryGrade(parseString(newValueExpr));
		}		

		
		if(SalaryGrade.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSalaryGrade(parseString(newValueExpr));
		}
		if(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDetailDescriptionOfSalaryGrade(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
		
	}
	
	
	
	public SalaryGrade clone(RetailscmUserContext userContext, String fromSalaryGradeId) throws Exception{
		
		return userContext.getDAOGroup().getSalaryGradeDAO().clone(fromSalaryGradeId, this.allTokens());
	}
	
	public SalaryGrade internalSaveSalaryGrade(RetailscmUserContext userContext, SalaryGrade salaryGrade) throws Exception 
	{
		return internalSaveSalaryGrade(userContext, salaryGrade, allTokens());

	}
	public SalaryGrade internalSaveSalaryGrade(RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSalaryGrade(userContext, salaryGradeId, salaryGradeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(salaryGrade){ 
			//will be good when the salaryGrade loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SalaryGrade.
			
			
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, options);
			return salaryGrade;
			
		}

	}
	
	public SalaryGrade updateSalaryGrade(RetailscmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSalaryGrade(userContext, salaryGradeId, salaryGradeVersion, property, newValueExpr, tokensExpr);
		
		
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		if(salaryGrade.getVersion() != salaryGradeVersion){
			String message = "The target version("+salaryGrade.getVersion()+") is not equals to version("+salaryGradeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(salaryGrade){ 
			//will be good when the salaryGrade loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SalaryGrade.
			
			salaryGrade.changeProperty(property, newValueExpr);
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
			//return saveSalaryGrade(userContext, salaryGrade, tokens().done());
		}

	}
	
	public SalaryGrade updateSalaryGradeProperty(RetailscmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSalaryGrade(userContext, salaryGradeId, salaryGradeVersion, property, newValueExpr, tokensExpr);
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		if(salaryGrade.getVersion() != salaryGradeVersion){
			String message = "The target version("+salaryGrade.getVersion()+") is not equals to version("+salaryGradeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(salaryGrade){ 
			//will be good when the salaryGrade loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SalaryGrade.
			
			salaryGrade.changeProperty(property, newValueExpr);
			
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
			//return saveSalaryGrade(userContext, salaryGrade, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SalaryGradeTokens tokens(){
		return SalaryGradeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SalaryGradeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.sortEmployeeSalarySheetListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SalaryGradeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String salaryGradeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
 		
 	}
 	public SalaryGrade transferToAnotherCompany(RetailscmUserContext userContext, String salaryGradeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, salaryGradeId,anotherCompanyId);
 
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());	
		synchronized(salaryGrade){
			//will be good when the salaryGrade loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			salaryGrade.updateCompany(company);		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, emptyOptions());
			
			return present(userContext,salaryGrade, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForSalaryGrade(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String salaryGradeId, int salaryGradeVersion) throws Exception {
		//deleteInternal(userContext, salaryGradeId, salaryGradeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String salaryGradeId, int salaryGradeVersion) throws Exception{
			
		userContext.getDAOGroup().getSalaryGradeDAO().delete(salaryGradeId, salaryGradeVersion);
	}
	
	public SalaryGrade forgetByAll(RetailscmUserContext userContext, String salaryGradeId, int salaryGradeVersion) throws Exception {
		return forgetByAllInternal(userContext, salaryGradeId, salaryGradeVersion);		
	}
	protected SalaryGrade forgetByAllInternal(RetailscmUserContext userContext,
			String salaryGradeId, int salaryGradeVersion) throws Exception{
			
		return userContext.getDAOGroup().getSalaryGradeDAO().disconnectFromAll(salaryGradeId, salaryGradeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SalaryGradeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSalaryGradeDAO().deleteAll();
	}


	//disconnect SalaryGrade with company in Employee
	protected SalaryGrade breakWithEmployeeByCompany(RetailscmUserContext userContext, String salaryGradeId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());

			synchronized(salaryGrade){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeListWithCompany(salaryGrade, companyId, this.emptyOptions());

				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
				return salaryGrade;
			}
	}
	//disconnect SalaryGrade with department in Employee
	protected SalaryGrade breakWithEmployeeByDepartment(RetailscmUserContext userContext, String salaryGradeId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());

			synchronized(salaryGrade){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeListWithDepartment(salaryGrade, departmentId, this.emptyOptions());

				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
				return salaryGrade;
			}
	}
	//disconnect SalaryGrade with occupation in Employee
	protected SalaryGrade breakWithEmployeeByOccupation(RetailscmUserContext userContext, String salaryGradeId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());

			synchronized(salaryGrade){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeListWithOccupation(salaryGrade, occupationId, this.emptyOptions());

				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
				return salaryGrade;
			}
	}
	//disconnect SalaryGrade with responsible_for in Employee
	protected SalaryGrade breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String salaryGradeId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());

			synchronized(salaryGrade){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeListWithResponsibleFor(salaryGrade, responsibleForId, this.emptyOptions());

				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
				return salaryGrade;
			}
	}
	//disconnect SalaryGrade with employee in EmployeeSalarySheet
	protected SalaryGrade breakWithEmployeeSalarySheetByEmployee(RetailscmUserContext userContext, String salaryGradeId, String employeeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());

			synchronized(salaryGrade){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeSalarySheetListWithEmployee(salaryGrade, employeeId, this.emptyOptions());

				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
				return salaryGrade;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);

		
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
		
		userContext.getChecker().checkSalaryAccountOfEmployee(salaryAccount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);

	
	}
	public  SalaryGrade addEmployee(RetailscmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,salaryGradeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, salaryAccount);
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.addEmployee( employee );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String salaryGradeId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
		
	}
	public  SalaryGrade updateEmployeeProperties(RetailscmUserContext userContext, String salaryGradeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,salaryGradeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		SalaryGrade salaryGradeToUpdate = loadSalaryGrade(userContext, salaryGradeId, options);
		
		if(salaryGradeToUpdate.getEmployeeList().isEmpty()){
			throw new SalaryGradeManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = salaryGradeToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,salaryGradeId,name, code, used,tokensExpr);
		SalaryGrade salaryGrade = saveSalaryGrade(userContext, salaryGradeToUpdate, tokens().withEmployeeList().done());
		synchronized(salaryGrade){ 
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount) throws Exception{

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
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String salaryGradeId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
		
	}
	public  SalaryGrade removeEmployeeList(RetailscmUserContext userContext, String salaryGradeId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, salaryGradeId,  employeeIds, tokensExpr);
			
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
			synchronized(salaryGrade){ 
				//Will be good when the salaryGrade loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeList(salaryGrade, employeeIds, allTokens());
				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, salaryGrade.getEmployeeList());
				return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSalaryGrade( salaryGradeId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
	}
	public  SalaryGrade removeEmployee(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,salaryGradeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.removeEmployee( employee );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSalaryGrade( salaryGradeId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
	}
	public  SalaryGrade copyEmployeeFrom(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,salaryGradeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			salaryGrade.copyEmployeeFrom( employee );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)salaryGrade.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
	}
	
	public  SalaryGrade updateEmployee(RetailscmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, salaryGradeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, loadTokens);
		
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//salaryGrade.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = salaryGrade.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new SalaryGradeManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SalaryGrade associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToNewTermination(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().createTermination(userContext, reasonId, typeId,  comment);
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}
	*/
	
	public  SalaryGrade associateEmployeeListToJobApplication(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToHrInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}	public  SalaryGrade associateEmployeeListToTermination(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String terminationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		Termination termination = userContext.getManagerGroup().getTerminationManager().loadTermination(userContext,terminationId,new String[]{"none"} );
		
		for(Employee employee: salaryGrade.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateTermination(termination);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}


	protected void checkParamsForAddingEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);

		
		userContext.getChecker().checkEmployeeIdOfEmployeeSalarySheet(employeeId);
		
		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
		
		userContext.getChecker().checkBonusOfEmployeeSalarySheet(bonus);
		
		userContext.getChecker().checkRewardOfEmployeeSalarySheet(reward);
		
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet(personalTax);
		
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
		
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet(housingFound);
		
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);
	
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);

	
	}
	public  SalaryGrade addEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSalarySheet(userContext,salaryGradeId,employeeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,employeeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.addEmployeeSalarySheet( employeeSalarySheet );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			
			userContext.getManagerGroup().getEmployeeSalarySheetManager().onNewInstanceCreated(userContext, employeeSalarySheet);
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSalarySheetProperties(RetailscmUserContext userContext, String salaryGradeId,String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(id);
		
		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet( baseSalary);
		userContext.getChecker().checkBonusOfEmployeeSalarySheet( bonus);
		userContext.getChecker().checkRewardOfEmployeeSalarySheet( reward);
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet( personalTax);
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet( socialSecurity);
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet( housingFound);
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet( jobInsurance);

		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
		
	}
	public  SalaryGrade updateEmployeeSalarySheetProperties(RetailscmUserContext userContext, String salaryGradeId, String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeSalarySheetProperties(userContext,salaryGradeId,id,baseSalary,bonus,reward,personalTax,socialSecurity,housingFound,jobInsurance,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSalarySheetListList()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "is", id).done();
		
		SalaryGrade salaryGradeToUpdate = loadSalaryGrade(userContext, salaryGradeId, options);
		
		if(salaryGradeToUpdate.getEmployeeSalarySheetList().isEmpty()){
			throw new SalaryGradeManagerException("EmployeeSalarySheet is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeSalarySheet item = salaryGradeToUpdate.getEmployeeSalarySheetList().first();
		
		item.updateBaseSalary( baseSalary );
		item.updateBonus( bonus );
		item.updateReward( reward );
		item.updatePersonalTax( personalTax );
		item.updateSocialSecurity( socialSecurity );
		item.updateHousingFound( housingFound );
		item.updateJobInsurance( jobInsurance );

		
		//checkParamsForAddingEmployeeSalarySheet(userContext,salaryGradeId,name, code, used,tokensExpr);
		SalaryGrade salaryGrade = saveSalaryGrade(userContext, salaryGradeToUpdate, tokens().withEmployeeSalarySheetList().done());
		synchronized(salaryGrade){ 
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance) throws Exception{

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeSalarySheet.setEmployee(employee);		
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
	
	protected void checkParamsForRemovingEmployeeSalarySheetList(RetailscmUserContext userContext, String salaryGradeId, 
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
		for(String employeeSalarySheetId: employeeSalarySheetIds){
			userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
		
	}
	public  SalaryGrade removeEmployeeSalarySheetList(RetailscmUserContext userContext, String salaryGradeId, 
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeSalarySheetList(userContext, salaryGradeId,  employeeSalarySheetIds, tokensExpr);
			
			
			SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
			synchronized(salaryGrade){ 
				//Will be good when the salaryGrade loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSalaryGradeDAO().planToRemoveEmployeeSalarySheetList(salaryGrade, employeeSalarySheetIds, allTokens());
				salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
				deleteRelationListInGraph(userContext, salaryGrade.getEmployeeSalarySheetList());
				return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSalaryGrade( salaryGradeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
	}
	public  SalaryGrade removeEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSalarySheet(userContext,salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.removeEmployeeSalarySheet( employeeSalarySheet );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			deleteRelationInGraph(userContext, employeeSalarySheet);
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSalaryGrade( salaryGradeId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
	}
	public  SalaryGrade copyEmployeeSalarySheetFrom(RetailscmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSalarySheet(userContext,salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			salaryGrade.copyEmployeeSalarySheetFrom( employeeSalarySheet );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			
			userContext.getManagerGroup().getEmployeeSalarySheetManager().onNewInstanceCreated(userContext, (EmployeeSalarySheet)salaryGrade.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSalaryGrade(salaryGradeId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SalaryGradeManagerException.class);
	
	}
	
	public  SalaryGrade updateEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSalarySheet(userContext, salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeSalarySheetList().searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "eq", employeeSalarySheetId).done();
		
		
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, loadTokens);
		
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//salaryGrade.removeEmployeeSalarySheet( employeeSalarySheet );	
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIndex = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		
			EmployeeSalarySheet employeeSalarySheet = salaryGrade.findTheEmployeeSalarySheet(employeeSalarySheetIndex);
			if(employeeSalarySheet == null){
				throw new SalaryGradeManagerException(employeeSalarySheet+" is NOT FOUND" );
			}
			
			employeeSalarySheet.changeProperty(property, newValueExpr);
			
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SalaryGrade associateEmployeeSalarySheetListToNewPayingOff(RetailscmUserContext userContext, String salaryGradeId, String  employeeSalarySheetIds[], String who, String paidForId, Date paidTime, BigDecimal amount, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "oneof", this.joinArray("|", employeeSalarySheetIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		PayingOff payingOff = userContext.getManagerGroup().getPayingOffManager().createPayingOff(userContext,  who, paidForId,  paidTime,  amount);
		
		for(EmployeeSalarySheet employeeSalarySheet: salaryGrade.getEmployeeSalarySheetList()) {
			//TODO: need to check if already associated
			employeeSalarySheet.updatePayingOff(payingOff);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}
	*/
	
	public  SalaryGrade associateEmployeeSalarySheetListToPayingOff(RetailscmUserContext userContext, String salaryGradeId, String  employeeSalarySheetIds[], String payingOffId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "oneof", this.joinArray("|", employeeSalarySheetIds)).done();
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, options);
		
		PayingOff payingOff = userContext.getManagerGroup().getPayingOffManager().loadPayingOff(userContext,payingOffId,new String[]{"none"} );
		
		for(EmployeeSalarySheet employeeSalarySheet: salaryGrade.getEmployeeSalarySheetList()) {
			//TODO: need to check if already associated
			employeeSalarySheet.updatePayingOff(payingOff);
		}
		return this.internalSaveSalaryGrade(userContext, salaryGrade);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SalaryGrade newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


