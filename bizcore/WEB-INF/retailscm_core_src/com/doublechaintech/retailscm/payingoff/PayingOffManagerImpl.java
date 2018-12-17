
package com.doublechaintech.retailscm.payingoff;

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
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.employee.CandidateEmployee;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;






public class PayingOffManagerImpl extends CustomRetailscmCheckerManager implements PayingOffManager {
	
	private static final String SERVICE_TYPE = "PayingOff";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PayingOffManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PayingOffManagerException(message);

	}
	
	

 	protected PayingOff savePayingOff(RetailscmUserContext userContext, PayingOff payingOff, String [] tokensExpr) throws Exception{	
 		//return getPayingOffDAO().save(payingOff, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePayingOff(userContext, payingOff, tokens);
 	}
 	
 	protected PayingOff savePayingOffDetail(RetailscmUserContext userContext, PayingOff payingOff) throws Exception{	

 		
 		return savePayingOff(userContext, payingOff, allTokens());
 	}
 	
 	public PayingOff loadPayingOff(RetailscmUserContext userContext, String payingOffId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().throwExceptionIfHasErrors( PayingOffManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,payingOff, tokens);
 	}
 	
 	
 	 public PayingOff searchPayingOff(RetailscmUserContext userContext, String payingOffId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().throwExceptionIfHasErrors( PayingOffManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,payingOff, tokens);
 	}
 	
 	

 	protected PayingOff present(RetailscmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,payingOff,tokens);
		
		
		PayingOff  payingOffToPresent = userContext.getDAOGroup().getPayingOffDAO().present(payingOff, tokens);
		
		List<BaseEntity> entityListToNaming = payingOffToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPayingOffDAO().alias(entityListToNaming);
		
		return  payingOffToPresent;
		
		
	}
 
 	
 	
 	public PayingOff loadPayingOffDetail(RetailscmUserContext userContext, String payingOffId) throws Exception{	
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, allTokens());
 		return present(userContext,payingOff, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String payingOffId) throws Exception{	
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, viewTokens());
 		return present(userContext,payingOff, allTokens());
		
 	}
 	protected PayingOff savePayingOff(RetailscmUserContext userContext, PayingOff payingOff, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPayingOffDAO().save(payingOff, tokens);
 	}
 	protected PayingOff loadPayingOff(RetailscmUserContext userContext, String payingOffId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().throwExceptionIfHasErrors( PayingOffManagerException.class);

 
 		return userContext.getDAOGroup().getPayingOffDAO().load(payingOffId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens){
		super.addActions(userContext, payingOff, tokens);
		
		addAction(userContext, payingOff, tokens,"@create","createPayingOff","createPayingOff/","main","primary");
		addAction(userContext, payingOff, tokens,"@update","updatePayingOff","updatePayingOff/"+payingOff.getId()+"/","main","primary");
		addAction(userContext, payingOff, tokens,"@copy","clonePayingOff","clonePayingOff/"+payingOff.getId()+"/","main","primary");
		
		addAction(userContext, payingOff, tokens,"paying_off.transfer_to_paid_for","transferToAnotherPaidFor","transferToAnotherPaidFor/"+payingOff.getId()+"/","main","primary");
		addAction(userContext, payingOff, tokens,"paying_off.addEmployeeSalarySheet","addEmployeeSalarySheet","addEmployeeSalarySheet/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, payingOff, tokens,"paying_off.removeEmployeeSalarySheet","removeEmployeeSalarySheet","removeEmployeeSalarySheet/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, payingOff, tokens,"paying_off.updateEmployeeSalarySheet","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, payingOff, tokens,"paying_off.copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PayingOff createPayingOff(RetailscmUserContext userContext,String who, String paidForId, Date paidTime, BigDecimal amount) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfPayingOff(who);
		userContext.getChecker().checkPaidTimeOfPayingOff(paidTime);
		userContext.getChecker().checkAmountOfPayingOff(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);


		PayingOff payingOff=createNewPayingOff();	

		payingOff.setWho(who);
			
		Employee paidFor = loadEmployee(userContext, paidForId,emptyOptions());
		payingOff.setPaidFor(paidFor);
		
		
		payingOff.setPaidTime(paidTime);
		payingOff.setAmount(amount);

		payingOff = savePayingOff(userContext, payingOff, emptyOptions());
		
		onNewInstanceCreated(userContext, payingOff);
		return payingOff;

		
	}
	protected PayingOff createNewPayingOff() 
	{
		
		return new PayingOff();		
	}
	
	protected void checkParamsForUpdatingPayingOff(RetailscmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().checkVersionOfPayingOff( payingOffVersion);
		

		if(PayingOff.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfPayingOff(parseString(newValueExpr));
		}		

		
		if(PayingOff.PAID_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkPaidTimeOfPayingOff(parseDate(newValueExpr));
		}
		if(PayingOff.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfPayingOff(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
	
		
	}
	
	
	
	public PayingOff clone(RetailscmUserContext userContext, String fromPayingOffId) throws Exception{
		
		return userContext.getDAOGroup().getPayingOffDAO().clone(fromPayingOffId, this.allTokens());
	}
	
	public PayingOff internalSavePayingOff(RetailscmUserContext userContext, PayingOff payingOff) throws Exception 
	{
		return internalSavePayingOff(userContext, payingOff, allTokens());

	}
	public PayingOff internalSavePayingOff(RetailscmUserContext userContext, PayingOff payingOff, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPayingOff(userContext, payingOffId, payingOffVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(payingOff){ 
			//will be good when the payingOff loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PayingOff.
			
			
			payingOff = savePayingOff(userContext, payingOff, options);
			return payingOff;
			
		}

	}
	
	public PayingOff updatePayingOff(RetailscmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPayingOff(userContext, payingOffId, payingOffVersion, property, newValueExpr, tokensExpr);
		
		
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		if(payingOff.getVersion() != payingOffVersion){
			String message = "The target version("+payingOff.getVersion()+") is not equals to version("+payingOffVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(payingOff){ 
			//will be good when the payingOff loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PayingOff.
			
			payingOff.changeProperty(property, newValueExpr);
			payingOff = savePayingOff(userContext, payingOff, tokens().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
			//return savePayingOff(userContext, payingOff, tokens().done());
		}

	}
	
	public PayingOff updatePayingOffProperty(RetailscmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPayingOff(userContext, payingOffId, payingOffVersion, property, newValueExpr, tokensExpr);
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		if(payingOff.getVersion() != payingOffVersion){
			String message = "The target version("+payingOff.getVersion()+") is not equals to version("+payingOffVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(payingOff){ 
			//will be good when the payingOff loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PayingOff.
			
			payingOff.changeProperty(property, newValueExpr);
			
			payingOff = savePayingOff(userContext, payingOff, tokens().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
			//return savePayingOff(userContext, payingOff, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PayingOffTokens tokens(){
		return PayingOffTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PayingOffTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeSalarySheetListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PayingOffTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPaidFor(RetailscmUserContext userContext, String payingOffId, String anotherPaidForId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfPayingOff(payingOffId);
 		userContext.getChecker().checkIdOfEmployee(anotherPaidForId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
 		
 	}
 	public PayingOff transferToAnotherPaidFor(RetailscmUserContext userContext, String payingOffId, String anotherPaidForId) throws Exception
 	{
 		checkParamsForTransferingAnotherPaidFor(userContext, payingOffId,anotherPaidForId);
 
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());	
		synchronized(payingOff){
			//will be good when the payingOff loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee paidFor = loadEmployee(userContext, anotherPaidForId, emptyOptions());		
			payingOff.updatePaidFor(paidFor);		
			payingOff = savePayingOff(userContext, payingOff, emptyOptions());
			
			return present(userContext,payingOff, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateEmployee requestCandidatePaidFor(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForPayingOff(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newPaidForId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newPaidForId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String payingOffId, int payingOffVersion) throws Exception {
		//deleteInternal(userContext, payingOffId, payingOffVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String payingOffId, int payingOffVersion) throws Exception{
			
		userContext.getDAOGroup().getPayingOffDAO().delete(payingOffId, payingOffVersion);
	}
	
	public PayingOff forgetByAll(RetailscmUserContext userContext, String payingOffId, int payingOffVersion) throws Exception {
		return forgetByAllInternal(userContext, payingOffId, payingOffVersion);		
	}
	protected PayingOff forgetByAllInternal(RetailscmUserContext userContext,
			String payingOffId, int payingOffVersion) throws Exception{
			
		return userContext.getDAOGroup().getPayingOffDAO().disconnectFromAll(payingOffId, payingOffVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PayingOffManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPayingOffDAO().deleteAll();
	}


	//disconnect PayingOff with employee in EmployeeSalarySheet
	protected PayingOff breakWithEmployeeSalarySheetByEmployee(RetailscmUserContext userContext, String payingOffId, String employeeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());

			synchronized(payingOff){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPayingOffDAO().planToRemoveEmployeeSalarySheetListWithEmployee(payingOff, employeeId, this.emptyOptions());

				payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
				return payingOff;
			}
	}
	//disconnect PayingOff with current_salary_grade in EmployeeSalarySheet
	protected PayingOff breakWithEmployeeSalarySheetByCurrentSalaryGrade(RetailscmUserContext userContext, String payingOffId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());

			synchronized(payingOff){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPayingOffDAO().planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(payingOff, currentSalaryGradeId, this.emptyOptions());

				payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
				return payingOff;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPayingOff(payingOffId);

		
		userContext.getChecker().checkEmployeeIdOfEmployeeSalarySheet(employeeId);
		
		userContext.getChecker().checkCurrentSalaryGradeIdOfEmployeeSalarySheet(currentSalaryGradeId);
		
		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
		
		userContext.getChecker().checkBonusOfEmployeeSalarySheet(bonus);
		
		userContext.getChecker().checkRewardOfEmployeeSalarySheet(reward);
		
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet(personalTax);
		
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
		
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet(housingFound);
		
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);
	
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);

	
	}
	public  PayingOff addEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSalarySheet(userContext,payingOffId,employeeId, currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,employeeId, currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			payingOff.addEmployeeSalarySheet( employeeSalarySheet );		
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			
			userContext.getManagerGroup().getEmployeeSalarySheetManager().onNewInstanceCreated(userContext, employeeSalarySheet);
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSalarySheetProperties(RetailscmUserContext userContext, String payingOffId,String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(id);
		
		userContext.getChecker().checkBaseSalaryOfEmployeeSalarySheet( baseSalary);
		userContext.getChecker().checkBonusOfEmployeeSalarySheet( bonus);
		userContext.getChecker().checkRewardOfEmployeeSalarySheet( reward);
		userContext.getChecker().checkPersonalTaxOfEmployeeSalarySheet( personalTax);
		userContext.getChecker().checkSocialSecurityOfEmployeeSalarySheet( socialSecurity);
		userContext.getChecker().checkHousingFoundOfEmployeeSalarySheet( housingFound);
		userContext.getChecker().checkJobInsuranceOfEmployeeSalarySheet( jobInsurance);

		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
		
	}
	public  PayingOff updateEmployeeSalarySheetProperties(RetailscmUserContext userContext, String payingOffId, String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeSalarySheetProperties(userContext,payingOffId,id,baseSalary,bonus,reward,personalTax,socialSecurity,housingFound,jobInsurance,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSalarySheetListList()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "is", id).done();
		
		PayingOff payingOffToUpdate = loadPayingOff(userContext, payingOffId, options);
		
		if(payingOffToUpdate.getEmployeeSalarySheetList().isEmpty()){
			throw new PayingOffManagerException("EmployeeSalarySheet is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeSalarySheet item = payingOffToUpdate.getEmployeeSalarySheetList().first();
		
		item.updateBaseSalary( baseSalary );
		item.updateBonus( bonus );
		item.updateReward( reward );
		item.updatePersonalTax( personalTax );
		item.updateSocialSecurity( socialSecurity );
		item.updateHousingFound( housingFound );
		item.updateJobInsurance( jobInsurance );

		
		//checkParamsForAddingEmployeeSalarySheet(userContext,payingOffId,name, code, used,tokensExpr);
		PayingOff payingOff = savePayingOff(userContext, payingOffToUpdate, tokens().withEmployeeSalarySheetList().done());
		synchronized(payingOff){ 
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance) throws Exception{

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeSalarySheet.setEmployee(employee);		
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
		employeeSalarySheet.setCurrentStatus("INIT");
	
		
		return employeeSalarySheet;
	
		
	}
	
	protected EmployeeSalarySheet createIndexedEmployeeSalarySheet(String id, int version){

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheet.setId(id);
		employeeSalarySheet.setVersion(version);
		return employeeSalarySheet;			
		
	}
	
	protected void checkParamsForRemovingEmployeeSalarySheetList(RetailscmUserContext userContext, String payingOffId, 
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
		for(String employeeSalarySheetId: employeeSalarySheetIds){
			userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
		
	}
	public  PayingOff removeEmployeeSalarySheetList(RetailscmUserContext userContext, String payingOffId, 
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeSalarySheetList(userContext, payingOffId,  employeeSalarySheetIds, tokensExpr);
			
			
			PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
			synchronized(payingOff){ 
				//Will be good when the payingOff loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPayingOffDAO().planToRemoveEmployeeSalarySheetList(payingOff, employeeSalarySheetIds, allTokens());
				payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
				deleteRelationListInGraph(userContext, payingOff.getEmployeeSalarySheetList());
				return present(userContext,payingOff, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPayingOff( payingOffId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
	
	}
	public  PayingOff removeEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSalarySheet(userContext,payingOffId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			payingOff.removeEmployeeSalarySheet( employeeSalarySheet );		
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			deleteRelationInGraph(userContext, employeeSalarySheet);
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPayingOff( payingOffId);
		userContext.getChecker().checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		userContext.getChecker().checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
	
	}
	public  PayingOff copyEmployeeSalarySheetFrom(RetailscmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSalarySheet(userContext,payingOffId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			payingOff.copyEmployeeSalarySheetFrom( employeeSalarySheet );		
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			
			userContext.getManagerGroup().getEmployeeSalarySheetManager().onNewInstanceCreated(userContext, (EmployeeSalarySheet)payingOff.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPayingOff(payingOffId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PayingOffManagerException.class);
	
	}
	
	public  PayingOff updateEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSalarySheet(userContext, payingOffId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeSalarySheetList().searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, "eq", employeeSalarySheetId).done();
		
		
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, loadTokens);
		
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//payingOff.removeEmployeeSalarySheet( employeeSalarySheet );	
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIndex = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		
			EmployeeSalarySheet employeeSalarySheet = payingOff.findTheEmployeeSalarySheet(employeeSalarySheetIndex);
			if(employeeSalarySheet == null){
				throw new PayingOffManagerException(employeeSalarySheet+" is NOT FOUND" );
			}
			
			employeeSalarySheet.changeProperty(property, newValueExpr);
			
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, PayingOff newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


