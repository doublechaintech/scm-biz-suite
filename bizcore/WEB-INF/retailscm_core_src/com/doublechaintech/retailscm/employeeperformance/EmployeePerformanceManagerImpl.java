
package com.doublechaintech.retailscm.employeeperformance;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class EmployeePerformanceManagerImpl extends CustomRetailscmCheckerManager implements EmployeePerformanceManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeePerformance";
	@Override
	public EmployeePerformanceDAO daoOf(RetailscmUserContext userContext) {
		return employeePerformanceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws EmployeePerformanceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeePerformanceManagerException(message);

	}



 	protected EmployeePerformance saveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance, String [] tokensExpr) throws Exception{
 		//return getEmployeePerformanceDAO().save(employeePerformance, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveEmployeePerformance(userContext, employeePerformance, tokens);
 	}

 	protected EmployeePerformance saveEmployeePerformanceDetail(RetailscmUserContext userContext, EmployeePerformance employeePerformance) throws Exception{


 		return saveEmployeePerformance(userContext, employeePerformance, allTokens());
 	}

 	public EmployeePerformance loadEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeePerformanceManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeePerformance, tokens);
 	}


 	 public EmployeePerformance searchEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeePerformanceManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeePerformance, tokens);
 	}



 	protected EmployeePerformance present(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens) throws Exception {


		addActions(userContext,employeePerformance,tokens);
    

		EmployeePerformance  employeePerformanceToPresent = employeePerformanceDaoOf(userContext).present(employeePerformance, tokens);

		List<BaseEntity> entityListToNaming = employeePerformanceToPresent.collectRefercencesFromLists();
		employeePerformanceDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,employeePerformance,tokens);

		return  employeePerformanceToPresent;


	}



 	public EmployeePerformance loadEmployeePerformanceDetail(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, allTokens());
 		return present(userContext,employeePerformance, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, viewTokens());
 		markVisited(userContext, employeePerformance);
 		return present(userContext,employeePerformance, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{
		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, viewTokens());
		employeePerformance.summarySuffix();
		markVisited(userContext, employeePerformance);
 		return present(userContext,employeePerformance, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{
		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, analyzeTokens());
		markVisited(userContext, employeePerformance);
		return present(userContext,employeePerformance, analyzeTokens());

	}
 	protected EmployeePerformance saveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String,Object>tokens) throws Exception{
 	
 		return employeePerformanceDaoOf(userContext).save(employeePerformance, tokens);
 	}
 	protected EmployeePerformance loadEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeePerformanceManagerException.class);



 		return employeePerformanceDaoOf(userContext).load(employeePerformanceId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens){
		super.addActions(userContext, employeePerformance, tokens);

		addAction(userContext, employeePerformance, tokens,"@create","createEmployeePerformance","createEmployeePerformance/","main","primary");
		addAction(userContext, employeePerformance, tokens,"@update","updateEmployeePerformance","updateEmployeePerformance/"+employeePerformance.getId()+"/","main","primary");
		addAction(userContext, employeePerformance, tokens,"@copy","cloneEmployeePerformance","cloneEmployeePerformance/"+employeePerformance.getId()+"/","main","primary");

		addAction(userContext, employeePerformance, tokens,"employee_performance.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeePerformance.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens){








  @Override
  public List<EmployeePerformance> searchEmployeePerformanceList(RetailscmUserContext ctx, EmployeePerformanceRequest pRequest){
      pRequest.setUserContext(ctx);
      List<EmployeePerformance> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public EmployeePerformance searchEmployeePerformance(RetailscmUserContext ctx, EmployeePerformanceRequest pRequest){
    pRequest.limit(0, 1);
    List<EmployeePerformance> list = searchEmployeePerformanceList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public EmployeePerformance createEmployeePerformance(RetailscmUserContext userContext, String employeeId,String performanceComment) throws Exception
	{





		checkerOf(userContext).checkPerformanceCommentOfEmployeePerformance(performanceComment);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeePerformanceManagerException.class);



		EmployeePerformance employeePerformance=createNewEmployeePerformance();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeePerformance.setEmployee(employee);
		
		
		employeePerformance.setPerformanceComment(performanceComment);

		employeePerformance = saveEmployeePerformance(userContext, employeePerformance, emptyOptions());
		
		onNewInstanceCreated(userContext, employeePerformance);
		return employeePerformance;


	}
	protected EmployeePerformance createNewEmployeePerformance()
	{

		return new EmployeePerformance();
	}

	protected void checkParamsForUpdatingEmployeePerformance(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);
		checkerOf(userContext).checkVersionOfEmployeePerformance( employeePerformanceVersion);



		
		if(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPerformanceCommentOfEmployeePerformance(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeePerformanceManagerException.class);



	}



	public EmployeePerformance clone(RetailscmUserContext userContext, String fromEmployeePerformanceId) throws Exception{

		return employeePerformanceDaoOf(userContext).clone(fromEmployeePerformanceId, this.allTokens());
	}

	public EmployeePerformance internalSaveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance) throws Exception
	{
		return internalSaveEmployeePerformance(userContext, employeePerformance, allTokens());

	}
	public EmployeePerformance internalSaveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);


		synchronized(employeePerformance){
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.
			if (employeePerformance.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixEmployeePerformance(employeePerformance);
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, options);
			return employeePerformance;

		}

	}

	public EmployeePerformance updateEmployeePerformance(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);



		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());
		if(employeePerformance.getVersion() != employeePerformanceVersion){
			String message = "The target version("+employeePerformance.getVersion()+") is not equals to version("+employeePerformanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeePerformance){
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.
			
			employeePerformance.changeProperty(property, newValueExpr);
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, tokens().done());
			return present(userContext,employeePerformance, mergedAllTokens(tokensExpr));
			//return saveEmployeePerformance(userContext, employeePerformance, tokens().done());
		}

	}

	public EmployeePerformance updateEmployeePerformanceProperty(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);

		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());
		if(employeePerformance.getVersion() != employeePerformanceVersion){
			String message = "The target version("+employeePerformance.getVersion()+") is not equals to version("+employeePerformanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeePerformance){
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.

			employeePerformance.changeProperty(property, newValueExpr);
			
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, tokens().done());
			return present(userContext,employeePerformance, mergedAllTokens(tokensExpr));
			//return saveEmployeePerformance(userContext, employeePerformance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeePerformanceTokens tokens(){
		return EmployeePerformanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeePerformanceTokens.all();
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
		return EmployeePerformanceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeePerformanceId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeePerformance(employeePerformanceId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeePerformanceManagerException.class);

 	}
 	public EmployeePerformance transferToAnotherEmployee(RetailscmUserContext userContext, String employeePerformanceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeePerformanceId,anotherEmployeeId);
 
		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());
		synchronized(employeePerformance){
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
			employeePerformance.updateEmployee(employee);
			
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, emptyOptions());

			return present(userContext,employeePerformance, allTokens());

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeePerformance(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String employeePerformanceId, int employeePerformanceVersion) throws Exception {
		//deleteInternal(userContext, employeePerformanceId, employeePerformanceVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeePerformanceId, int employeePerformanceVersion) throws Exception{

		employeePerformanceDaoOf(userContext).delete(employeePerformanceId, employeePerformanceVersion);
	}

	public EmployeePerformance forgetByAll(RetailscmUserContext userContext, String employeePerformanceId, int employeePerformanceVersion) throws Exception {
		return forgetByAllInternal(userContext, employeePerformanceId, employeePerformanceVersion);
	}
	protected EmployeePerformance forgetByAllInternal(RetailscmUserContext userContext,
			String employeePerformanceId, int employeePerformanceVersion) throws Exception{

		return employeePerformanceDaoOf(userContext).disconnectFromAll(employeePerformanceId, employeePerformanceVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeePerformanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeePerformanceDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeePerformance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeePerformanceDaoOf(ctx).loadAllAsStream().forEach(
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
		//   EmployeePerformance newEmployeePerformance = this.createEmployeePerformance(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeePerformance
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
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeePerformance.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeePerformance> list) throws Exception {
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
		SmartList<EmployeePerformance> list = employeePerformanceDaoOf(userContext).findEmployeePerformanceByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeePerformance.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工绩效列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String employeePerformanceId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		EmployeePerformance merchantObj = (EmployeePerformance) this.view(userContext, employeePerformanceId);
    String merchantObjId = employeePerformanceId;
    String linkToUrl =	"employeePerformanceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工绩效"+"详情";
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
				MapUtil.put("id", "3-performanceComment")
				    .put("fieldName", "performanceComment")
				    .put("label", "绩效评价")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("performanceComment", merchantObj.getPerformanceComment());

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




