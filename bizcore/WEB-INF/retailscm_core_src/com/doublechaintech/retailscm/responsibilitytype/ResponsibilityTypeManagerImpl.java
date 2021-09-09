
package com.doublechaintech.retailscm.responsibilitytype;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;import com.doublechaintech.retailscm.occupationtype.OccupationType;import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.salarygrade.SalaryGrade;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class ResponsibilityTypeManagerImpl extends CustomRetailscmCheckerManager implements ResponsibilityTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = ResponsibilityTypeTokens.start().withTokenFromListName(listName).done();
		ResponsibilityType  responsibilityType = (ResponsibilityType) this.loadResponsibilityType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = responsibilityType.collectRefercencesFromLists();
		responsibilityTypeDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, responsibilityType, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ResponsibilityTypeGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "ResponsibilityType";
	@Override
	public ResponsibilityTypeDAO daoOf(RetailscmUserContext userContext) {
		return responsibilityTypeDaoOf(userContext);
	}

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

 		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);

		checkerOf(userContext).throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}


 	 public ResponsibilityType searchResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);

		checkerOf(userContext).throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}



 	protected ResponsibilityType present(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens) throws Exception {


		addActions(userContext,responsibilityType,tokens);
    

		ResponsibilityType  responsibilityTypeToPresent = responsibilityTypeDaoOf(userContext).present(responsibilityType, tokens);

		List<BaseEntity> entityListToNaming = responsibilityTypeToPresent.collectRefercencesFromLists();
		responsibilityTypeDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,responsibilityType,tokens);

		return  responsibilityTypeToPresent;


	}



 	public ResponsibilityType loadResponsibilityTypeDetail(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, allTokens());
 		return present(userContext,responsibilityType, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, viewTokens());
 		markVisited(userContext, responsibilityType);
 		return present(userContext,responsibilityType, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{
		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, viewTokens());
		responsibilityType.summarySuffix();
		markVisited(userContext, responsibilityType);
 		return present(userContext,responsibilityType, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{
		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, analyzeTokens());
		markVisited(userContext, responsibilityType);
		return present(userContext,responsibilityType, analyzeTokens());

	}
 	protected ResponsibilityType saveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType, Map<String,Object>tokens) throws Exception{
 	
 		return responsibilityTypeDaoOf(userContext).save(responsibilityType, tokens);
 	}
 	protected ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);

		checkerOf(userContext).throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);



 		return responsibilityTypeDaoOf(userContext).load(responsibilityTypeId, tokens);
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








  @Override
  public List<ResponsibilityType> searchResponsibilityTypeList(RetailscmUserContext ctx, ResponsibilityTypeRequest pRequest){
      pRequest.setUserContext(ctx);
      List<ResponsibilityType> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public ResponsibilityType searchResponsibilityType(RetailscmUserContext ctx, ResponsibilityTypeRequest pRequest){
    pRequest.limit(0, 1);
    List<ResponsibilityType> list = searchResponsibilityTypeList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public ResponsibilityType createResponsibilityType(RetailscmUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception
	{





		checkerOf(userContext).checkCodeOfResponsibilityType(code);
		checkerOf(userContext).checkBaseDescriptionOfResponsibilityType(baseDescription);
		checkerOf(userContext).checkDetailDescriptionOfResponsibilityType(detailDescription);


		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);



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
		



		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkVersionOfResponsibilityType( responsibilityTypeVersion);


		if(ResponsibilityType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfResponsibilityType(parseString(newValueExpr));
		

		}

		
		if(ResponsibilityType.BASE_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseDescriptionOfResponsibilityType(parseString(newValueExpr));
		

		}
		if(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfResponsibilityType(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);



	}



	public ResponsibilityType clone(RetailscmUserContext userContext, String fromResponsibilityTypeId) throws Exception{

		return responsibilityTypeDaoOf(userContext).clone(fromResponsibilityTypeId, this.allTokens());
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
			if (responsibilityType.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixResponsibilityType(responsibilityType);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith(Employee.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ResponsibilityTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForResponsibilityType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		//deleteInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{

		responsibilityTypeDaoOf(userContext).delete(responsibilityTypeId, responsibilityTypeVersion);
	}

	public ResponsibilityType forgetByAll(RetailscmUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);
	}
	protected ResponsibilityType forgetByAllInternal(RetailscmUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{

		return responsibilityTypeDaoOf(userContext).disconnectFromAll(responsibilityTypeId, responsibilityTypeVersion);
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
		return responsibilityTypeDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);


		checkerOf(userContext).checkCompanyIdOfEmployee(companyId);

		checkerOf(userContext).checkTitleOfEmployee(title);

		checkerOf(userContext).checkDepartmentIdOfEmployee(departmentId);

		checkerOf(userContext).checkFamilyNameOfEmployee(familyName);

		checkerOf(userContext).checkGivenNameOfEmployee(givenName);

		checkerOf(userContext).checkEmailOfEmployee(email);

		checkerOf(userContext).checkCityOfEmployee(city);

		checkerOf(userContext).checkAddressOfEmployee(address);

		checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);

		checkerOf(userContext).checkOccupationIdOfEmployee(occupationId);

		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);

		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);


		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);



	}
	public  ResponsibilityType addEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingEmployee(userContext,responsibilityTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount);

		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, emptyOptions());
		synchronized(responsibilityType){
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.addEmployee( employee );
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			
			employeeManagerOf(userContext).onNewInstanceCreated(userContext, employee);
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String responsibilityTypeId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);


		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


	}
	public  ResponsibilityType updateEmployeeProperties(RetailscmUserContext userContext, String responsibilityTypeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,responsibilityTypeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, tokens().is(), id).done();

		ResponsibilityType responsibilityTypeToUpdate = loadResponsibilityType(userContext, responsibilityTypeId, options);

		if(responsibilityTypeToUpdate.getEmployeeList().isEmpty()){
			throw new ResponsibilityTypeManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = responsibilityTypeToUpdate.getEmployeeList().first();
		beforeUpdateEmployeeProperties(userContext,item, responsibilityTypeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);
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

	protected  void beforeUpdateEmployeeProperties(RetailscmUserContext userContext, Employee item, String responsibilityTypeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	}
	public  ResponsibilityType removeEmployeeList(RetailscmUserContext userContext, String responsibilityTypeId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, responsibilityTypeId,  employeeIds, tokensExpr);


			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
			synchronized(responsibilityType){
				//Will be good when the responsibilityType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeList(responsibilityType, employeeIds, allTokens());
				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, responsibilityType.getEmployeeList());
				return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String responsibilityTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfResponsibilityType( responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


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
		
		checkerOf(userContext).checkIdOfResponsibilityType( responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


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
			
			employeeManagerOf(userContext).onNewInstanceCreated(userContext, (Employee)responsibilityType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);


		if(Employee.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkFamilyNameOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkGivenNameOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
			checkerOf(userContext).checkEmailOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
			checkerOf(userContext).checkCityOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
			checkerOf(userContext).checkAddressOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCellPhoneOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
			checkerOf(userContext).checkSalaryAccountOfEmployee(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


	}

	public  ResponsibilityType updateEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, responsibilityTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, tokens().equals(), employeeId).done();



		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, loadTokens);

		synchronized(responsibilityType){
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//responsibilityType.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIdVersionKey = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = responsibilityType.findTheEmployee(employeeIdVersionKey);
			if(employee == null){
				throw new ResponsibilityTypeManagerException(employeeId+" is NOT FOUND" );
			}

			beforeUpdateEmployee(userContext, employee, responsibilityTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			employeeManagerOf(userContext).onUpdated(userContext, employee, this, "updateEmployee");
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateEmployee(RetailscmUserContext userContext, Employee existed, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, ResponsibilityType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    responsibilityTypeDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ResponsibilityType newResponsibilityType = this.createResponsibilityType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newResponsibilityType
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
    key.put(UserApp.APP_TYPE_PROPERTY, ResponsibilityType.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ResponsibilityType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<ResponsibilityType> list = responsibilityTypeDaoOf(userContext).findResponsibilityTypeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ResponsibilityType.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("责任类型列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String responsibilityTypeId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		ResponsibilityType merchantObj = (ResponsibilityType) this.view(userContext, responsibilityTypeId);
    String merchantObjId = responsibilityTypeId;
    String linkToUrl =	"responsibilityTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "责任类型"+"详情";
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
				MapUtil.put("id", "2-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "3-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "4-baseDescription")
				    .put("fieldName", "baseDescription")
				    .put("label", "基本描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("baseDescription", merchantObj.getBaseDescription());

		propList.add(
				MapUtil.put("id", "5-detailDescription")
				    .put("fieldName", "detailDescription")
				    .put("label", "详细描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("detailDescription", merchantObj.getDetailDescription());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByResponsibleFor/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeListSection);

		result.put("employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));

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




