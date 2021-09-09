
package com.doublechaintech.retailscm.employeeeducation;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class EmployeeEducationManagerImpl extends CustomRetailscmCheckerManager implements EmployeeEducationManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeeEducation";
	@Override
	public EmployeeEducationDAO daoOf(RetailscmUserContext userContext) {
		return employeeEducationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws EmployeeEducationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeEducationManagerException(message);

	}



 	protected EmployeeEducation saveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation, String [] tokensExpr) throws Exception{
 		//return getEmployeeEducationDAO().save(employeeEducation, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveEmployeeEducation(userContext, employeeEducation, tokens);
 	}

 	protected EmployeeEducation saveEmployeeEducationDetail(RetailscmUserContext userContext, EmployeeEducation employeeEducation) throws Exception{


 		return saveEmployeeEducation(userContext, employeeEducation, allTokens());
 	}

 	public EmployeeEducation loadEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeEducationManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeEducation, tokens);
 	}


 	 public EmployeeEducation searchEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeEducationManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeEducation, tokens);
 	}



 	protected EmployeeEducation present(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens) throws Exception {


		addActions(userContext,employeeEducation,tokens);
    

		EmployeeEducation  employeeEducationToPresent = employeeEducationDaoOf(userContext).present(employeeEducation, tokens);

		List<BaseEntity> entityListToNaming = employeeEducationToPresent.collectRefercencesFromLists();
		employeeEducationDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,employeeEducation,tokens);

		return  employeeEducationToPresent;


	}



 	public EmployeeEducation loadEmployeeEducationDetail(RetailscmUserContext userContext, String employeeEducationId) throws Exception{
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, allTokens());
 		return present(userContext,employeeEducation, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String employeeEducationId) throws Exception{
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, viewTokens());
 		markVisited(userContext, employeeEducation);
 		return present(userContext,employeeEducation, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String employeeEducationId) throws Exception{
		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, viewTokens());
		employeeEducation.summarySuffix();
		markVisited(userContext, employeeEducation);
 		return present(userContext,employeeEducation, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String employeeEducationId) throws Exception{
		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, analyzeTokens());
		markVisited(userContext, employeeEducation);
		return present(userContext,employeeEducation, analyzeTokens());

	}
 	protected EmployeeEducation saveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String,Object>tokens) throws Exception{
 	
 		return employeeEducationDaoOf(userContext).save(employeeEducation, tokens);
 	}
 	protected EmployeeEducation loadEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeEducationManagerException.class);



 		return employeeEducationDaoOf(userContext).load(employeeEducationId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens){
		super.addActions(userContext, employeeEducation, tokens);

		addAction(userContext, employeeEducation, tokens,"@create","createEmployeeEducation","createEmployeeEducation/","main","primary");
		addAction(userContext, employeeEducation, tokens,"@update","updateEmployeeEducation","updateEmployeeEducation/"+employeeEducation.getId()+"/","main","primary");
		addAction(userContext, employeeEducation, tokens,"@copy","cloneEmployeeEducation","cloneEmployeeEducation/"+employeeEducation.getId()+"/","main","primary");

		addAction(userContext, employeeEducation, tokens,"employee_education.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeEducation.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens){








  @Override
  public List<EmployeeEducation> searchEmployeeEducationList(RetailscmUserContext ctx, EmployeeEducationRequest pRequest){
      pRequest.setUserContext(ctx);
      List<EmployeeEducation> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public EmployeeEducation searchEmployeeEducation(RetailscmUserContext ctx, EmployeeEducationRequest pRequest){
    pRequest.limit(0, 1);
    List<EmployeeEducation> list = searchEmployeeEducationList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public EmployeeEducation createEmployeeEducation(RetailscmUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception
	{





		checkerOf(userContext).checkCompleteTimeOfEmployeeEducation(completeTime);
		checkerOf(userContext).checkTypeOfEmployeeEducation(type);
		checkerOf(userContext).checkRemarkOfEmployeeEducation(remark);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeEducationManagerException.class);



		EmployeeEducation employeeEducation=createNewEmployeeEducation();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeEducation.setEmployee(employee);
		
		
		employeeEducation.setCompleteTime(completeTime);
		employeeEducation.setType(type);
		employeeEducation.setRemark(remark);

		employeeEducation = saveEmployeeEducation(userContext, employeeEducation, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeEducation);
		return employeeEducation;


	}
	protected EmployeeEducation createNewEmployeeEducation()
	{

		return new EmployeeEducation();
	}

	protected void checkParamsForUpdatingEmployeeEducation(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);
		checkerOf(userContext).checkVersionOfEmployeeEducation( employeeEducationVersion);



		
		if(EmployeeEducation.COMPLETE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCompleteTimeOfEmployeeEducation(parseDate(newValueExpr));
		

		}
		if(EmployeeEducation.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfEmployeeEducation(parseString(newValueExpr));
		

		}
		if(EmployeeEducation.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeEducation(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeEducationManagerException.class);



	}



	public EmployeeEducation clone(RetailscmUserContext userContext, String fromEmployeeEducationId) throws Exception{

		return employeeEducationDaoOf(userContext).clone(fromEmployeeEducationId, this.allTokens());
	}

	public EmployeeEducation internalSaveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation) throws Exception
	{
		return internalSaveEmployeeEducation(userContext, employeeEducation, allTokens());

	}
	public EmployeeEducation internalSaveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeEducation){
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.
			if (employeeEducation.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixEmployeeEducation(employeeEducation);
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, options);
			return employeeEducation;

		}

	}

	public EmployeeEducation updateEmployeeEducation(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);



		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());
		if(employeeEducation.getVersion() != employeeEducationVersion){
			String message = "The target version("+employeeEducation.getVersion()+") is not equals to version("+employeeEducationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeEducation){
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.
			
			employeeEducation.changeProperty(property, newValueExpr);
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, tokens().done());
			return present(userContext,employeeEducation, mergedAllTokens(tokensExpr));
			//return saveEmployeeEducation(userContext, employeeEducation, tokens().done());
		}

	}

	public EmployeeEducation updateEmployeeEducationProperty(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);

		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());
		if(employeeEducation.getVersion() != employeeEducationVersion){
			String message = "The target version("+employeeEducation.getVersion()+") is not equals to version("+employeeEducationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeEducation){
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.

			employeeEducation.changeProperty(property, newValueExpr);
			
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, tokens().done());
			return present(userContext,employeeEducation, mergedAllTokens(tokensExpr));
			//return saveEmployeeEducation(userContext, employeeEducation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeEducationTokens tokens(){
		return EmployeeEducationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeEducationTokens.all();
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
		return EmployeeEducationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeEducationId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeEducation(employeeEducationId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeEducationManagerException.class);

 	}
 	public EmployeeEducation transferToAnotherEmployee(RetailscmUserContext userContext, String employeeEducationId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeEducationId,anotherEmployeeId);
 
		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());
		synchronized(employeeEducation){
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
			employeeEducation.updateEmployee(employee);
			
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, emptyOptions());

			return present(userContext,employeeEducation, allTokens());

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeEducation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeEducationId, int employeeEducationVersion) throws Exception {
		//deleteInternal(userContext, employeeEducationId, employeeEducationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeEducationId, int employeeEducationVersion) throws Exception{

		employeeEducationDaoOf(userContext).delete(employeeEducationId, employeeEducationVersion);
	}

	public EmployeeEducation forgetByAll(RetailscmUserContext userContext, String employeeEducationId, int employeeEducationVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeEducationId, employeeEducationVersion);
	}
	protected EmployeeEducation forgetByAllInternal(RetailscmUserContext userContext,
			String employeeEducationId, int employeeEducationVersion) throws Exception{

		return employeeEducationDaoOf(userContext).disconnectFromAll(employeeEducationId, employeeEducationVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeEducationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeEducationDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeEducation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeeEducationDaoOf(ctx).loadAllAsStream().forEach(
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
		//   EmployeeEducation newEmployeeEducation = this.createEmployeeEducation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeEducation
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
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeEducation.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeEducation> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);


    }
	
	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeEducation> list = employeeEducationDaoOf(userContext).findEmployeeEducationByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeEducation.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工教育列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String employeeEducationId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		EmployeeEducation merchantObj = (EmployeeEducation) this.view(userContext, employeeEducationId);
    String merchantObjId = employeeEducationId;
    String linkToUrl =	"employeeEducationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工教育"+"详情";
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
				MapUtil.put("id", "3-completeTime")
				    .put("fieldName", "completeTime")
				    .put("label", "完成时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("completeTime", merchantObj.getCompleteTime());

		propList.add(
				MapUtil.put("id", "4-type")
				    .put("fieldName", "type")
				    .put("label", "类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("type", merchantObj.getType());

		propList.add(
				MapUtil.put("id", "5-remark")
				    .put("fieldName", "remark")
				    .put("label", "备注")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("remark", merchantObj.getRemark());

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




