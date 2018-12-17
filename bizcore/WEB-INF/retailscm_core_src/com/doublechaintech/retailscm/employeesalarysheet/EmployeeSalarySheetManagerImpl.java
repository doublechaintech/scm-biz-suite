
package com.doublechaintech.retailscm.employeesalarysheet;

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
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.payingoff.CandidatePayingOff;
import com.doublechaintech.retailscm.salarygrade.CandidateSalaryGrade;


import com.doublechaintech.retailscm.employee.Employee;





public class EmployeeSalarySheetManagerImpl extends CustomRetailscmCheckerManager implements EmployeeSalarySheetManager {
	
	private static final String SERVICE_TYPE = "EmployeeSalarySheet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeSalarySheetManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeSalarySheetManagerException(message);

	}
	
	

 	protected EmployeeSalarySheet saveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, String [] tokensExpr) throws Exception{	
 		//return getEmployeeSalarySheetDAO().save(employeeSalarySheet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens);
 	}
 	
 	protected EmployeeSalarySheet saveEmployeeSalarySheetDetail(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception{	

 		
 		return saveEmployeeSalarySheet(userContext, employeeSalarySheet, allTokens());
 	}
 	
 	public EmployeeSalarySheet loadEmployeeSalarySheet(RetailscmUserContext userContext, String employeeSalarySheetId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeSalarySheetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSalarySheet, tokens);
 	}
 	
 	
 	 public EmployeeSalarySheet searchEmployeeSalarySheet(RetailscmUserContext userContext, String employeeSalarySheetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeSalarySheetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSalarySheet, tokens);
 	}
 	
 	

 	protected EmployeeSalarySheet present(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeSalarySheet,tokens);
		
		
		EmployeeSalarySheet  employeeSalarySheetToPresent = userContext.getDAOGroup().getEmployeeSalarySheetDAO().present(employeeSalarySheet, tokens);
		
		List<BaseEntity> entityListToNaming = employeeSalarySheetToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeSalarySheetDAO().alias(entityListToNaming);
		
		return  employeeSalarySheetToPresent;
		
		
	}
 
 	
 	
 	public EmployeeSalarySheet loadEmployeeSalarySheetDetail(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{	
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, allTokens());
 		return present(userContext,employeeSalarySheet, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{	
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, viewTokens());
 		return present(userContext,employeeSalarySheet, allTokens());
		
 	}
 	protected EmployeeSalarySheet saveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeSalarySheetDAO().save(employeeSalarySheet, tokens);
 	}
 	protected EmployeeSalarySheet loadEmployeeSalarySheet(RetailscmUserContext userContext, String employeeSalarySheetId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeSalarySheetManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeSalarySheetDAO().load(employeeSalarySheetId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens){
		super.addActions(userContext, employeeSalarySheet, tokens);
		
		addAction(userContext, employeeSalarySheet, tokens,"@create","createEmployeeSalarySheet","createEmployeeSalarySheet/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"@update","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"@copy","cloneEmployeeSalarySheet","cloneEmployeeSalarySheet/"+employeeSalarySheet.getId()+"/","main","primary");
		
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_current_salary_grade","transferToAnotherCurrentSalaryGrade","transferToAnotherCurrentSalaryGrade/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.payOff","payOff","payOffActionForm/"+employeeSalarySheet.getId()+"/","main","success");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext,String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance) throws Exception
	{
		
		

		

		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
		userContext.getChecker().checkBonusOfEmployeeSalarySheet(bonus);
		userContext.getChecker().checkRewardOfEmployeeSalarySheet(reward);
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet(personalTax);
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet(housingFound);
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);


		EmployeeSalarySheet employeeSalarySheet=createNewEmployeeSalarySheet();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeSalarySheet.setEmployee(employee);
		
		
			
		SalaryGrade currentSalaryGrade = loadSalaryGrade(userContext, currentSalaryGradeId,emptyOptions());
		employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);
		
		
		employeeSalarySheet.setBaseSalary(baseSalary);
		employeeSalarySheet.setBonus(bonus);
		employeeSalarySheet.setReward(reward);
		employeeSalarySheet.setPersonalTax(personalTax);
		employeeSalarySheet.setSocialSecurity(socialSecurity);
		employeeSalarySheet.setHousingFound(housingFound);
		employeeSalarySheet.setJobInsurance(jobInsurance);
		employeeSalarySheet.setCurrentStatus("INIT");

		employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeSalarySheet);
		return employeeSalarySheet;

		
	}
	protected EmployeeSalarySheet createNewEmployeeSalarySheet() 
	{
		
		return new EmployeeSalarySheet();		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailscmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet( employeeSalarySheetVersion);
		
		

				

		
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
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);
	
		
	}
	
	
	
	public EmployeeSalarySheet clone(RetailscmUserContext userContext, String fromEmployeeSalarySheetId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeSalarySheetDAO().clone(fromEmployeeSalarySheetId, this.allTokens());
	}
	
	public EmployeeSalarySheet internalSaveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception 
	{
		return internalSaveEmployeeSalarySheet(userContext, employeeSalarySheet, allTokens());

	}
	public EmployeeSalarySheet internalSaveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeSalarySheet(userContext, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeSalarySheet){ 
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSalarySheet.
			
			
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, options);
			return employeeSalarySheet;
			
		}

	}
	
	public EmployeeSalarySheet updateEmployeeSalarySheet(RetailscmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeSalarySheet(userContext, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());
		if(employeeSalarySheet.getVersion() != employeeSalarySheetVersion){
			String message = "The target version("+employeeSalarySheet.getVersion()+") is not equals to version("+employeeSalarySheetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeSalarySheet){ 
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSalarySheet.
			
			employeeSalarySheet.changeProperty(property, newValueExpr);
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().done());
			return present(userContext,employeeSalarySheet, mergedAllTokens(tokensExpr));
			//return saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().done());
		}

	}
	
	public EmployeeSalarySheet updateEmployeeSalarySheetProperty(RetailscmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeSalarySheet(userContext, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr, tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());
		if(employeeSalarySheet.getVersion() != employeeSalarySheetVersion){
			String message = "The target version("+employeeSalarySheet.getVersion()+") is not equals to version("+employeeSalarySheetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeSalarySheet){ 
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSalarySheet.
			
			employeeSalarySheet.changeProperty(property, newValueExpr);
			
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().done());
			return present(userContext,employeeSalarySheet, mergedAllTokens(tokensExpr));
			//return saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeSalarySheetTokens tokens(){
		return EmployeeSalarySheetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeSalarySheetTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeSalarySheetTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"PAID_OFF"};
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
 	protected void ensureStatus(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, String expectedNextStatus) throws Exception{
		String currentStatus = employeeSalarySheet.getCurrentStatus();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);
 		
 	}
 	public EmployeeSalarySheet transferToAnotherEmployee(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeSalarySheetId,anotherEmployeeId);
 
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeSalarySheet.updateEmployee(employee);		
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
			
			return present(userContext,employeeSalarySheet, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateEmployee requestCandidateEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateEmployee result = new CandidateEmployee();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("company");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeSalarySheet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
 		userContext.getChecker().checkIdOfSalaryGrade(anotherCurrentSalaryGradeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);
 		
 	}
 	public EmployeeSalarySheet transferToAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		checkParamsForTransferingAnotherCurrentSalaryGrade(userContext, employeeSalarySheetId,anotherCurrentSalaryGradeId);
 
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SalaryGrade currentSalaryGrade = loadSalaryGrade(userContext, anotherCurrentSalaryGradeId, emptyOptions());		
			employeeSalarySheet.updateCurrentSalaryGrade(currentSalaryGrade);		
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
			
			return present(userContext,employeeSalarySheet, allTokens());
			
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
		SmartList<SalaryGrade> candidateList = userContext.getDAOGroup().getSalaryGradeDAO().requestCandidateSalaryGradeForEmployeeSalarySheet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPayingOff(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherPayingOffId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
 		userContext.getChecker().checkIdOfPayingOff(anotherPayingOffId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);
 		
 	}
 	public EmployeeSalarySheet transferToAnotherPayingOff(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherPayingOffId) throws Exception
 	{
 		checkParamsForTransferingAnotherPayingOff(userContext, employeeSalarySheetId,anotherPayingOffId);
 
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PayingOff payingOff = loadPayingOff(userContext, anotherPayingOffId, emptyOptions());		
			employeeSalarySheet.updatePayingOff(payingOff);		
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
			
			return present(userContext,employeeSalarySheet, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePayingOff requestCandidatePayingOff(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePayingOff result = new CandidatePayingOff();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PayingOff> candidateList = userContext.getDAOGroup().getPayingOffDAO().requestCandidatePayingOffForEmployeeSalarySheet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PAID_OFF_STATUS = "PAID_OFF";
 	protected void checkParamsForPayingOff(RetailscmUserContext userContext, String employeeSalarySheetId, String who, String paidForId, Date paidTime, BigDecimal amount
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkWhoOfPayingOff(who);
		userContext.getChecker().checkIdOfEmployee(paidForId);
		userContext.getChecker().checkPaidTimeOfPayingOff(paidTime);
		userContext.getChecker().checkAmountOfPayingOff(amount);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);

 	}
 	public EmployeeSalarySheet payOff(RetailscmUserContext userContext, String employeeSalarySheetId, String who, String paidForId, Date paidTime, BigDecimal amount
) throws Exception
 	{
		checkParamsForPayingOff(userContext, employeeSalarySheetId, who, paidForId, paidTime, amount);
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForPayingOff(userContext,employeeSalarySheet);
 		

			employeeSalarySheet.updateCurrentStatus(PAID_OFF_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively
			Employee paidFor = loadEmployee(userContext, paidForId, emptyOptions());


			PayingOff payingOff = createPayingOff(userContext, who, paidFor, paidTime, amount);		
			employeeSalarySheet.updatePayingOff(payingOff);		
			
			
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().withPayingOff().done());
			return present(userContext,employeeSalarySheet, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeSalarySheetForm payOffActionForm(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception
 	{
		return new EmployeeSalarySheetForm()
			.withTitle("payOff")
			.employeeSalarySheetIdField(employeeSalarySheetId)
			.whoFieldOfPayingOff()
			.paidForIdFieldOfPayingOff()
			.paidTimeFieldOfPayingOff()
			.amountFieldOfPayingOff()
			.payOffAction();
 	}
	
 	
 	protected PayingOff createPayingOff(RetailscmUserContext userContext, String who, Employee paidFor, Date paidTime, BigDecimal amount){
 		PayingOff payingOff = new PayingOff();
 		//who, paidFor, paidTime, amount
 		
		payingOff.setWho(who);
		payingOff.setPaidFor(paidFor);
		payingOff.setPaidTime(paidTime);
		payingOff.setAmount(amount);

 		
 		
 		
 		return userContext.getDAOGroup().getPayingOffDAO().save(payingOff,emptyOptions());
 	}
 	protected void checkIfEligibleForPayingOff(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception{
 
 		ensureStatus(userContext,employeeSalarySheet, PAID_OFF_STATUS);
 		
 		PayingOff payingOff = employeeSalarySheet.getPayingOff();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = payingOff 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( payingOff != null){
				throwExceptionWithMessage("The EmployeeSalarySheet("+employeeSalarySheet.getId()+") has already been "+ PAID_OFF_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String newCurrentSalaryGradeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSalaryGradeDAO().load(newCurrentSalaryGradeId, options);
 	}
 	
 	
 	
	
	 	
 	protected PayingOff loadPayingOff(RetailscmUserContext userContext, String newPayingOffId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPayingOffDAO().load(newPayingOffId, options);
 	}
 	
 	
 	
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newEmployeeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception {
		//deleteInternal(userContext, employeeSalarySheetId, employeeSalarySheetVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeSalarySheetDAO().delete(employeeSalarySheetId, employeeSalarySheetVersion);
	}
	
	public EmployeeSalarySheet forgetByAll(RetailscmUserContext userContext, String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeSalarySheetId, employeeSalarySheetVersion);		
	}
	protected EmployeeSalarySheet forgetByAllInternal(RetailscmUserContext userContext,
			String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeSalarySheetDAO().disconnectFromAll(employeeSalarySheetId, employeeSalarySheetVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeSalarySheetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeSalarySheetDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSalarySheet newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


