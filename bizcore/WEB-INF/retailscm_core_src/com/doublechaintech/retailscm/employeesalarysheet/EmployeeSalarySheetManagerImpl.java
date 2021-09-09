
package com.doublechaintech.retailscm.employeesalarysheet;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.payingoff.CandidatePayingOff;import com.doublechaintech.retailscm.payingoff.PayingOff;import com.doublechaintech.retailscm.salarygrade.CandidateSalaryGrade;import com.doublechaintech.retailscm.salarygrade.SalaryGrade;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class EmployeeSalarySheetManagerImpl extends CustomRetailscmCheckerManager implements EmployeeSalarySheetManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeeSalarySheet";
	@Override
	public EmployeeSalarySheetDAO daoOf(RetailscmUserContext userContext) {
		return employeeSalarySheetDaoOf(userContext);
	}

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

 		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeSalarySheetManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSalarySheet, tokens);
 	}


 	 public EmployeeSalarySheet searchEmployeeSalarySheet(RetailscmUserContext userContext, String employeeSalarySheetId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeSalarySheetManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSalarySheet, tokens);
 	}



 	protected EmployeeSalarySheet present(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens) throws Exception {


		addActions(userContext,employeeSalarySheet,tokens);
    

		EmployeeSalarySheet  employeeSalarySheetToPresent = employeeSalarySheetDaoOf(userContext).present(employeeSalarySheet, tokens);

		List<BaseEntity> entityListToNaming = employeeSalarySheetToPresent.collectRefercencesFromLists();
		employeeSalarySheetDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,employeeSalarySheet,tokens);

		return  employeeSalarySheetToPresent;


	}



 	public EmployeeSalarySheet loadEmployeeSalarySheetDetail(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, allTokens());
 		return present(userContext,employeeSalarySheet, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, viewTokens());
 		markVisited(userContext, employeeSalarySheet);
 		return present(userContext,employeeSalarySheet, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, viewTokens());
		employeeSalarySheet.summarySuffix();
		markVisited(userContext, employeeSalarySheet);
 		return present(userContext,employeeSalarySheet, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, analyzeTokens());
		markVisited(userContext, employeeSalarySheet);
		return present(userContext,employeeSalarySheet, analyzeTokens());

	}
 	protected EmployeeSalarySheet saveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String,Object>tokens) throws Exception{
 	
 		return employeeSalarySheetDaoOf(userContext).save(employeeSalarySheet, tokens);
 	}
 	protected EmployeeSalarySheet loadEmployeeSalarySheet(RetailscmUserContext userContext, String employeeSalarySheetId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeSalarySheetManagerException.class);



 		return employeeSalarySheetDaoOf(userContext).load(employeeSalarySheetId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens){
		super.addActions(userContext, employeeSalarySheet, tokens);

		addAction(userContext, employeeSalarySheet, tokens,"@create","createEmployeeSalarySheet","createEmployeeSalarySheet/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"@update","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"@copy","cloneEmployeeSalarySheet","cloneEmployeeSalarySheet/"+employeeSalarySheet.getId()+"/","main","primary");

		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_current_salary_grade","transferToAnotherCurrentSalaryGrade","transferToAnotherCurrentSalaryGrade/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_paying_off","transferToAnotherPayingOff","transferToAnotherPayingOff/"+employeeSalarySheet.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens){








  @Override
  public List<EmployeeSalarySheet> searchEmployeeSalarySheetList(RetailscmUserContext ctx, EmployeeSalarySheetRequest pRequest){
      pRequest.setUserContext(ctx);
      List<EmployeeSalarySheet> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public EmployeeSalarySheet searchEmployeeSalarySheet(RetailscmUserContext ctx, EmployeeSalarySheetRequest pRequest){
    pRequest.limit(0, 1);
    List<EmployeeSalarySheet> list = searchEmployeeSalarySheetList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId,String currentSalaryGradeId,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance,String payingOffId) throws Exception
	{





		checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
		checkerOf(userContext).checkBonusOfEmployeeSalarySheet(bonus);
		checkerOf(userContext).checkRewardOfEmployeeSalarySheet(reward);
		checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(personalTax);
		checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
		checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(housingFound);
		checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);



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
			
		PayingOff payingOff = loadPayingOff(userContext, payingOffId,emptyOptions());
		employeeSalarySheet.setPayingOff(payingOff);
		
		

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
		



		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet( employeeSalarySheetVersion);



		

		
		if(EmployeeSalarySheet.BASE_SALARY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}
		if(EmployeeSalarySheet.BONUS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBonusOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}
		if(EmployeeSalarySheet.REWARD_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRewardOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}
		if(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}
		if(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}
		if(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}
		if(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);



	}



	public EmployeeSalarySheet clone(RetailscmUserContext userContext, String fromEmployeeSalarySheetId) throws Exception{

		return employeeSalarySheetDaoOf(userContext).clone(fromEmployeeSalarySheetId, this.allTokens());
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
			if (employeeSalarySheet.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixEmployeeSalarySheet(employeeSalarySheet);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeSalarySheetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeSalarySheet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
 		checkerOf(userContext).checkIdOfSalaryGrade(anotherCurrentSalaryGradeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);

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
		SmartList<SalaryGrade> candidateList = salaryGradeDaoOf(userContext).requestCandidateSalaryGradeForEmployeeSalarySheet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPayingOff(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherPayingOffId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
 		checkerOf(userContext).checkIdOfPayingOff(anotherPayingOffId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSalarySheetManagerException.class);

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
		SmartList<PayingOff> candidateList = payingOffDaoOf(userContext).requestCandidatePayingOffForEmployeeSalarySheet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
    
 		return employeeDaoOf(userContext).load(newEmployeeId, options);
 	  
 	}
 	


	

 	protected SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String newCurrentSalaryGradeId, Map<String,Object> options) throws Exception
 	{
    
 		return salaryGradeDaoOf(userContext).load(newCurrentSalaryGradeId, options);
 	  
 	}
 	


	

 	protected PayingOff loadPayingOff(RetailscmUserContext userContext, String newPayingOffId, Map<String,Object> options) throws Exception
 	{
    
 		return payingOffDaoOf(userContext).load(newPayingOffId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception {
		//deleteInternal(userContext, employeeSalarySheetId, employeeSalarySheetVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception{

		employeeSalarySheetDaoOf(userContext).delete(employeeSalarySheetId, employeeSalarySheetVersion);
	}

	public EmployeeSalarySheet forgetByAll(RetailscmUserContext userContext, String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeSalarySheetId, employeeSalarySheetVersion);
	}
	protected EmployeeSalarySheet forgetByAllInternal(RetailscmUserContext userContext,
			String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception{

		return employeeSalarySheetDaoOf(userContext).disconnectFromAll(employeeSalarySheetId, employeeSalarySheetVersion);
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
		return employeeSalarySheetDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSalarySheet newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeeSalarySheetDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
  }

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   EmployeeSalarySheet newEmployeeSalarySheet = this.createEmployeeSalarySheet(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeSalarySheet
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeSalarySheet.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeSalarySheet> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
		List<SalaryGrade> currentSalaryGradeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SalaryGrade.class);
		userContext.getDAOGroup().enhanceList(currentSalaryGradeList, SalaryGrade.class);
		List<PayingOff> payingOffList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PayingOff.class);
		userContext.getDAOGroup().enhanceList(payingOffList, PayingOff.class);


    }
	
	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeSalarySheet> list = employeeSalarySheetDaoOf(userContext).findEmployeeSalarySheetByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeSalarySheet.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("工资单列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
	public Object listByCurrentSalaryGrade(RetailscmUserContext userContext,String currentSalaryGradeId) throws Exception {
		return listPageByCurrentSalaryGrade(userContext, currentSalaryGradeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCurrentSalaryGrade(RetailscmUserContext userContext,String currentSalaryGradeId, int start, int count) throws Exception {
		SmartList<EmployeeSalarySheet> list = employeeSalarySheetDaoOf(userContext).findEmployeeSalarySheetByCurrentSalaryGrade(currentSalaryGradeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeSalarySheet.class);
		page.setContainerObject(SalaryGrade.withId(currentSalaryGradeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("工资单列表");
		page.setRequestName("listByCurrentSalaryGrade");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCurrentSalaryGrade/%s/",  getBeanName(), currentSalaryGradeId)));

		page.assemblerContent(userContext, "listByCurrentSalaryGrade");
		return page.doRender(userContext);
	}
  
	public Object listByPayingOff(RetailscmUserContext userContext,String payingOffId) throws Exception {
		return listPageByPayingOff(userContext, payingOffId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPayingOff(RetailscmUserContext userContext,String payingOffId, int start, int count) throws Exception {
		SmartList<EmployeeSalarySheet> list = employeeSalarySheetDaoOf(userContext).findEmployeeSalarySheetByPayingOff(payingOffId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeSalarySheet.class);
		page.setContainerObject(PayingOff.withId(payingOffId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("工资单列表");
		page.setRequestName("listByPayingOff");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPayingOff/%s/",  getBeanName(), payingOffId)));

		page.assemblerContent(userContext, "listByPayingOff");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String employeeSalarySheetId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		EmployeeSalarySheet merchantObj = (EmployeeSalarySheet) this.view(userContext, employeeSalarySheetId);
    String merchantObjId = employeeSalarySheetId;
    String linkToUrl =	"employeeSalarySheetManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "工资单"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-employee")
				    .put("fieldName", "employee")
				    .put("label", "员工")
				    .put("type", "auto")
				    .put("linkToUrl", "employeeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("employee", merchantObj.getEmployee());

		propList.add(
				MapUtil.put("id", "3-currentSalaryGrade")
				    .put("fieldName", "currentSalaryGrade")
				    .put("label", "目前工资等级")
				    .put("type", "auto")
				    .put("linkToUrl", "salaryGradeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"detail_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("currentSalaryGrade", merchantObj.getCurrentSalaryGrade());

		propList.add(
				MapUtil.put("id", "4-baseSalary")
				    .put("fieldName", "baseSalary")
				    .put("label", "基本工资")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("baseSalary", merchantObj.getBaseSalary());

		propList.add(
				MapUtil.put("id", "5-bonus")
				    .put("fieldName", "bonus")
				    .put("label", "奖金")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("bonus", merchantObj.getBonus());

		propList.add(
				MapUtil.put("id", "6-reward")
				    .put("fieldName", "reward")
				    .put("label", "奖励")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("reward", merchantObj.getReward());

		propList.add(
				MapUtil.put("id", "7-personalTax")
				    .put("fieldName", "personalTax")
				    .put("label", "个人所得税")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("personalTax", merchantObj.getPersonalTax());

		propList.add(
				MapUtil.put("id", "8-socialSecurity")
				    .put("fieldName", "socialSecurity")
				    .put("label", "社会保险")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("socialSecurity", merchantObj.getSocialSecurity());

		propList.add(
				MapUtil.put("id", "9-housingFound")
				    .put("fieldName", "housingFound")
				    .put("label", "住房公积金")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("housingFound", merchantObj.getHousingFound());

		propList.add(
				MapUtil.put("id", "10-jobInsurance")
				    .put("fieldName", "jobInsurance")
				    .put("label", "失业保险")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("jobInsurance", merchantObj.getJobInsurance());

		propList.add(
				MapUtil.put("id", "11-payingOff")
				    .put("fieldName", "payingOff")
				    .put("label", "工资支付")
				    .put("type", "auto")
				    .put("linkToUrl", "payingOffManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("payingOff", merchantObj.getPayingOff());

		//处理 sectionList

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

  










}




