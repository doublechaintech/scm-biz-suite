
package com.doublechaintech.retailscm.payingoff;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.payingoff.PayingOff;import com.doublechaintech.retailscm.salarygrade.SalaryGrade;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class PayingOffManagerImpl extends CustomRetailscmCheckerManager implements PayingOffManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = PayingOffTokens.start().withTokenFromListName(listName).done();
		PayingOff  payingOff = (PayingOff) this.loadPayingOff(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = payingOff.collectRefercencesFromLists();
		payingOffDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, payingOff, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new PayingOffGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "PayingOff";
	@Override
	public PayingOffDAO daoOf(RetailscmUserContext userContext) {
		return payingOffDaoOf(userContext);
	}

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

 		checkerOf(userContext).checkIdOfPayingOff(payingOffId);

		checkerOf(userContext).throwExceptionIfHasErrors( PayingOffManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,payingOff, tokens);
 	}


 	 public PayingOff searchPayingOff(RetailscmUserContext userContext, String payingOffId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfPayingOff(payingOffId);

		checkerOf(userContext).throwExceptionIfHasErrors( PayingOffManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,payingOff, tokens);
 	}



 	protected PayingOff present(RetailscmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens) throws Exception {


		addActions(userContext,payingOff,tokens);
    

		PayingOff  payingOffToPresent = payingOffDaoOf(userContext).present(payingOff, tokens);

		List<BaseEntity> entityListToNaming = payingOffToPresent.collectRefercencesFromLists();
		payingOffDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,payingOff,tokens);

		return  payingOffToPresent;


	}



 	public PayingOff loadPayingOffDetail(RetailscmUserContext userContext, String payingOffId) throws Exception{
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, allTokens());
 		return present(userContext,payingOff, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String payingOffId) throws Exception{
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, viewTokens());
 		markVisited(userContext, payingOff);
 		return present(userContext,payingOff, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String payingOffId) throws Exception{
		PayingOff payingOff = loadPayingOff( userContext, payingOffId, viewTokens());
		payingOff.summarySuffix();
		markVisited(userContext, payingOff);
 		return present(userContext,payingOff, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String payingOffId) throws Exception{
		PayingOff payingOff = loadPayingOff( userContext, payingOffId, analyzeTokens());
		markVisited(userContext, payingOff);
		return present(userContext,payingOff, analyzeTokens());

	}
 	protected PayingOff savePayingOff(RetailscmUserContext userContext, PayingOff payingOff, Map<String,Object>tokens) throws Exception{
 	
 		return payingOffDaoOf(userContext).save(payingOff, tokens);
 	}
 	protected PayingOff loadPayingOff(RetailscmUserContext userContext, String payingOffId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfPayingOff(payingOffId);

		checkerOf(userContext).throwExceptionIfHasErrors( PayingOffManagerException.class);



 		return payingOffDaoOf(userContext).load(payingOffId, tokens);
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








  @Override
  public List<PayingOff> searchPayingOffList(RetailscmUserContext ctx, PayingOffRequest pRequest){
      pRequest.setUserContext(ctx);
      List<PayingOff> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public PayingOff searchPayingOff(RetailscmUserContext ctx, PayingOffRequest pRequest){
    pRequest.limit(0, 1);
    List<PayingOff> list = searchPayingOffList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public PayingOff createPayingOff(RetailscmUserContext userContext, String who,String paidForId,Date paidTime,BigDecimal amount) throws Exception
	{





		checkerOf(userContext).checkWhoOfPayingOff(who);
		checkerOf(userContext).checkPaidTimeOfPayingOff(paidTime);
		checkerOf(userContext).checkAmountOfPayingOff(amount);


		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);



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
		



		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		checkerOf(userContext).checkVersionOfPayingOff( payingOffVersion);


		if(PayingOff.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfPayingOff(parseString(newValueExpr));
		

		}

		
		if(PayingOff.PAID_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPaidTimeOfPayingOff(parseDate(newValueExpr));
		

		}
		if(PayingOff.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfPayingOff(parseBigDecimal(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);



	}



	public PayingOff clone(RetailscmUserContext userContext, String fromPayingOffId) throws Exception{

		return payingOffDaoOf(userContext).clone(fromPayingOffId, this.allTokens());
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
			if (payingOff.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixPayingOff(payingOff);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PayingOffTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPaidFor(RetailscmUserContext userContext, String payingOffId, String anotherPaidForId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
 		checkerOf(userContext).checkIdOfEmployee(anotherPaidForId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForPayingOff(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Employee loadEmployee(RetailscmUserContext userContext, String newPaidForId, Map<String,Object> options) throws Exception
 	{
    
 		return employeeDaoOf(userContext).load(newPaidForId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String payingOffId, int payingOffVersion) throws Exception {
		//deleteInternal(userContext, payingOffId, payingOffVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String payingOffId, int payingOffVersion) throws Exception{

		payingOffDaoOf(userContext).delete(payingOffId, payingOffVersion);
	}

	public PayingOff forgetByAll(RetailscmUserContext userContext, String payingOffId, int payingOffVersion) throws Exception {
		return forgetByAllInternal(userContext, payingOffId, payingOffVersion);
	}
	protected PayingOff forgetByAllInternal(RetailscmUserContext userContext,
			String payingOffId, int payingOffVersion) throws Exception{

		return payingOffDaoOf(userContext).disconnectFromAll(payingOffId, payingOffVersion);
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
		return payingOffDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPayingOff(payingOffId);


		checkerOf(userContext).checkEmployeeIdOfEmployeeSalarySheet(employeeId);

		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployeeSalarySheet(currentSalaryGradeId);

		checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(baseSalary);

		checkerOf(userContext).checkBonusOfEmployeeSalarySheet(bonus);

		checkerOf(userContext).checkRewardOfEmployeeSalarySheet(reward);

		checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(personalTax);

		checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);

		checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(housingFound);

		checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);


		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);



	}
	public  PayingOff addEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingEmployeeSalarySheet(userContext,payingOffId,employeeId, currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);

		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,employeeId, currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);

		PayingOff payingOff = loadPayingOff(userContext, payingOffId, emptyOptions());
		synchronized(payingOff){
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			payingOff.addEmployeeSalarySheet( employeeSalarySheet );
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			
			employeeSalarySheetManagerOf(userContext).onNewInstanceCreated(userContext, employeeSalarySheet);
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSalarySheetProperties(RetailscmUserContext userContext, String payingOffId,String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(id);

		checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet( baseSalary);
		checkerOf(userContext).checkBonusOfEmployeeSalarySheet( bonus);
		checkerOf(userContext).checkRewardOfEmployeeSalarySheet( reward);
		checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet( personalTax);
		checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet( socialSecurity);
		checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet( housingFound);
		checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet( jobInsurance);


		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);


	}
	public  PayingOff updateEmployeeSalarySheetProperties(RetailscmUserContext userContext, String payingOffId, String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeSalarySheetProperties(userContext,payingOffId,id,baseSalary,bonus,reward,personalTax,socialSecurity,housingFound,jobInsurance,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSalarySheetListList()
				.searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, tokens().is(), id).done();

		PayingOff payingOffToUpdate = loadPayingOff(userContext, payingOffId, options);

		if(payingOffToUpdate.getEmployeeSalarySheetList().isEmpty()){
			throw new PayingOffManagerException("EmployeeSalarySheet is NOT FOUND with id: '"+id+"'");
		}

		EmployeeSalarySheet item = payingOffToUpdate.getEmployeeSalarySheetList().first();
		beforeUpdateEmployeeSalarySheetProperties(userContext,item, payingOffId,id,baseSalary,bonus,reward,personalTax,socialSecurity,housingFound,jobInsurance,tokensExpr);
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

	protected  void beforeUpdateEmployeeSalarySheetProperties(RetailscmUserContext userContext, EmployeeSalarySheet item, String payingOffId, String id,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		for(String employeeSalarySheetIdItem: employeeSalarySheetIds){
			checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);

	}
	public  PayingOff removeEmployeeSalarySheetList(RetailscmUserContext userContext, String payingOffId,
			String employeeSalarySheetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeSalarySheetList(userContext, payingOffId,  employeeSalarySheetIds, tokensExpr);


			PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
			synchronized(payingOff){
				//Will be good when the payingOff loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				payingOffDaoOf(userContext).planToRemoveEmployeeSalarySheetList(payingOff, employeeSalarySheetIds, allTokens());
				payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
				deleteRelationListInGraph(userContext, payingOff.getEmployeeSalarySheetList());
				return present(userContext,payingOff, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId,
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPayingOff( payingOffId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);


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
		
		checkerOf(userContext).checkIdOfPayingOff( payingOffId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);


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
			
			employeeSalarySheetManagerOf(userContext).onNewInstanceCreated(userContext, (EmployeeSalarySheet)payingOff.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfPayingOff(payingOffId);
		checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
		checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);


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
		


		checkerOf(userContext).throwExceptionIfHasErrors(PayingOffManagerException.class);


	}

	public  PayingOff updateEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployeeSalarySheet(userContext, payingOffId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeSalarySheetList().searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, tokens().equals(), employeeSalarySheetId).done();



		PayingOff payingOff = loadPayingOff(userContext, payingOffId, loadTokens);

		synchronized(payingOff){
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//payingOff.removeEmployeeSalarySheet( employeeSalarySheet );
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIdVersionKey = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);

			EmployeeSalarySheet employeeSalarySheet = payingOff.findTheEmployeeSalarySheet(employeeSalarySheetIdVersionKey);
			if(employeeSalarySheet == null){
				throw new PayingOffManagerException(employeeSalarySheetId+" is NOT FOUND" );
			}

			beforeUpdateEmployeeSalarySheet(userContext, employeeSalarySheet, payingOffId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
			employeeSalarySheet.changeProperty(property, newValueExpr);
			
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			employeeSalarySheetManagerOf(userContext).onUpdated(userContext, employeeSalarySheet, this, "updateEmployeeSalarySheet");
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet existed, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, PayingOff newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    payingOffDaoOf(ctx).loadAllAsStream().forEach(
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
		//   PayingOff newPayingOff = this.createPayingOff(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPayingOff
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
    key.put(UserApp.APP_TYPE_PROPERTY, PayingOff.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<PayingOff> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> paidForList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(paidForList, Employee.class);


    }
	
	public Object listByPaidFor(RetailscmUserContext userContext,String paidForId) throws Exception {
		return listPageByPaidFor(userContext, paidForId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPaidFor(RetailscmUserContext userContext,String paidForId, int start, int count) throws Exception {
		SmartList<PayingOff> list = payingOffDaoOf(userContext).findPayingOffByPaidFor(paidForId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PayingOff.class);
		page.setContainerObject(Employee.withId(paidForId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("工资支付列表");
		page.setRequestName("listByPaidFor");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPaidFor/%s/",  getBeanName(), paidForId)));

		page.assemblerContent(userContext, "listByPaidFor");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String payingOffId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		PayingOff merchantObj = (PayingOff) this.view(userContext, payingOffId);
    String merchantObjId = payingOffId;
    String linkToUrl =	"payingOffManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "工资支付"+"详情";
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
				MapUtil.put("id", "2-who")
				    .put("fieldName", "who")
				    .put("label", "谁")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("who", merchantObj.getWho());

		propList.add(
				MapUtil.put("id", "3-paidFor")
				    .put("fieldName", "paidFor")
				    .put("label", "支付")
				    .put("type", "auto")
				    .put("linkToUrl", "employeeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("paidFor", merchantObj.getPaidFor());

		propList.add(
				MapUtil.put("id", "4-paidTime")
				    .put("fieldName", "paidTime")
				    .put("label", "支付时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("paidTime", merchantObj.getPaidTime());

		propList.add(
				MapUtil.put("id", "5-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		//处理 sectionList

		//处理Section：employeeSalarySheetListSection
		Map employeeSalarySheetListSection = ListofUtils.buildSection(
		    "employeeSalarySheetListSection",
		    "员工工资表",
		    null,
		    "",
		    "__no_group",
		    "employeeSalarySheetManager/listByPayingOff/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeSalarySheetListSection);

		result.put("employeeSalarySheetListSection", ListofUtils.toShortList(merchantObj.getEmployeeSalarySheetList(), "employeeSalarySheet"));

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




