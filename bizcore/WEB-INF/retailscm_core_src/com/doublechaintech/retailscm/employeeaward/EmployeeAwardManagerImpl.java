
package com.doublechaintech.retailscm.employeeaward;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class EmployeeAwardManagerImpl extends CustomRetailscmCheckerManager implements EmployeeAwardManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeeAward";
	@Override
	public EmployeeAwardDAO daoOf(RetailscmUserContext userContext) {
		return employeeAwardDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws EmployeeAwardManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeAwardManagerException(message);

	}



 	protected EmployeeAward saveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward, String [] tokensExpr) throws Exception{
 		//return getEmployeeAwardDAO().save(employeeAward, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveEmployeeAward(userContext, employeeAward, tokens);
 	}

 	protected EmployeeAward saveEmployeeAwardDetail(RetailscmUserContext userContext, EmployeeAward employeeAward) throws Exception{


 		return saveEmployeeAward(userContext, employeeAward, allTokens());
 	}

 	public EmployeeAward loadEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeAwardManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAward, tokens);
 	}


 	 public EmployeeAward searchEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeAwardManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAward, tokens);
 	}



 	protected EmployeeAward present(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens) throws Exception {


		addActions(userContext,employeeAward,tokens);
    

		EmployeeAward  employeeAwardToPresent = employeeAwardDaoOf(userContext).present(employeeAward, tokens);

		List<BaseEntity> entityListToNaming = employeeAwardToPresent.collectRefercencesFromLists();
		employeeAwardDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,employeeAward,tokens);

		return  employeeAwardToPresent;


	}



 	public EmployeeAward loadEmployeeAwardDetail(RetailscmUserContext userContext, String employeeAwardId) throws Exception{
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, allTokens());
 		return present(userContext,employeeAward, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String employeeAwardId) throws Exception{
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, viewTokens());
 		markVisited(userContext, employeeAward);
 		return present(userContext,employeeAward, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String employeeAwardId) throws Exception{
		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, viewTokens());
		employeeAward.summarySuffix();
		markVisited(userContext, employeeAward);
 		return present(userContext,employeeAward, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String employeeAwardId) throws Exception{
		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, analyzeTokens());
		markVisited(userContext, employeeAward);
		return present(userContext,employeeAward, analyzeTokens());

	}
 	protected EmployeeAward saveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String,Object>tokens) throws Exception{
 	
 		return employeeAwardDaoOf(userContext).save(employeeAward, tokens);
 	}
 	protected EmployeeAward loadEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeAwardManagerException.class);



 		return employeeAwardDaoOf(userContext).load(employeeAwardId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens){
		super.addActions(userContext, employeeAward, tokens);

		addAction(userContext, employeeAward, tokens,"@create","createEmployeeAward","createEmployeeAward/","main","primary");
		addAction(userContext, employeeAward, tokens,"@update","updateEmployeeAward","updateEmployeeAward/"+employeeAward.getId()+"/","main","primary");
		addAction(userContext, employeeAward, tokens,"@copy","cloneEmployeeAward","cloneEmployeeAward/"+employeeAward.getId()+"/","main","primary");

		addAction(userContext, employeeAward, tokens,"employee_award.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeAward.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens){








  @Override
  public List<EmployeeAward> searchEmployeeAwardList(RetailscmUserContext ctx, EmployeeAwardRequest pRequest){
      pRequest.setUserContext(ctx);
      List<EmployeeAward> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public EmployeeAward searchEmployeeAward(RetailscmUserContext ctx, EmployeeAwardRequest pRequest){
    pRequest.limit(0, 1);
    List<EmployeeAward> list = searchEmployeeAwardList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public EmployeeAward createEmployeeAward(RetailscmUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception
	{





		checkerOf(userContext).checkCompleteTimeOfEmployeeAward(completeTime);
		checkerOf(userContext).checkTypeOfEmployeeAward(type);
		checkerOf(userContext).checkRemarkOfEmployeeAward(remark);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeAwardManagerException.class);



		EmployeeAward employeeAward=createNewEmployeeAward();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeAward.setEmployee(employee);
		
		
		employeeAward.setCompleteTime(completeTime);
		employeeAward.setType(type);
		employeeAward.setRemark(remark);

		employeeAward = saveEmployeeAward(userContext, employeeAward, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeAward);
		return employeeAward;


	}
	protected EmployeeAward createNewEmployeeAward()
	{

		return new EmployeeAward();
	}

	protected void checkParamsForUpdatingEmployeeAward(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);
		checkerOf(userContext).checkVersionOfEmployeeAward( employeeAwardVersion);



		
		if(EmployeeAward.COMPLETE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCompleteTimeOfEmployeeAward(parseDate(newValueExpr));
		

		}
		if(EmployeeAward.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfEmployeeAward(parseString(newValueExpr));
		

		}
		if(EmployeeAward.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeAward(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeAwardManagerException.class);



	}



	public EmployeeAward clone(RetailscmUserContext userContext, String fromEmployeeAwardId) throws Exception{

		return employeeAwardDaoOf(userContext).clone(fromEmployeeAwardId, this.allTokens());
	}

	public EmployeeAward internalSaveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward) throws Exception
	{
		return internalSaveEmployeeAward(userContext, employeeAward, allTokens());

	}
	public EmployeeAward internalSaveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeAward){
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.
			if (employeeAward.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixEmployeeAward(employeeAward);
			employeeAward = saveEmployeeAward(userContext, employeeAward, options);
			return employeeAward;

		}

	}

	public EmployeeAward updateEmployeeAward(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);



		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());
		if(employeeAward.getVersion() != employeeAwardVersion){
			String message = "The target version("+employeeAward.getVersion()+") is not equals to version("+employeeAwardVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAward){
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.
			
			employeeAward.changeProperty(property, newValueExpr);
			employeeAward = saveEmployeeAward(userContext, employeeAward, tokens().done());
			return present(userContext,employeeAward, mergedAllTokens(tokensExpr));
			//return saveEmployeeAward(userContext, employeeAward, tokens().done());
		}

	}

	public EmployeeAward updateEmployeeAwardProperty(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);

		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());
		if(employeeAward.getVersion() != employeeAwardVersion){
			String message = "The target version("+employeeAward.getVersion()+") is not equals to version("+employeeAwardVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAward){
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.

			employeeAward.changeProperty(property, newValueExpr);
			
			employeeAward = saveEmployeeAward(userContext, employeeAward, tokens().done());
			return present(userContext,employeeAward, mergedAllTokens(tokensExpr));
			//return saveEmployeeAward(userContext, employeeAward, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeAwardTokens tokens(){
		return EmployeeAwardTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeAwardTokens.all();
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
		return EmployeeAwardTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeAwardId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeAward(employeeAwardId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeAwardManagerException.class);

 	}
 	public EmployeeAward transferToAnotherEmployee(RetailscmUserContext userContext, String employeeAwardId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeAwardId,anotherEmployeeId);
 
		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());
		synchronized(employeeAward){
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
			employeeAward.updateEmployee(employee);
			
			employeeAward = saveEmployeeAward(userContext, employeeAward, emptyOptions());

			return present(userContext,employeeAward, allTokens());

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeAward(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String employeeAwardId, int employeeAwardVersion) throws Exception {
		//deleteInternal(userContext, employeeAwardId, employeeAwardVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeAwardId, int employeeAwardVersion) throws Exception{

		employeeAwardDaoOf(userContext).delete(employeeAwardId, employeeAwardVersion);
	}

	public EmployeeAward forgetByAll(RetailscmUserContext userContext, String employeeAwardId, int employeeAwardVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeAwardId, employeeAwardVersion);
	}
	protected EmployeeAward forgetByAllInternal(RetailscmUserContext userContext,
			String employeeAwardId, int employeeAwardVersion) throws Exception{

		return employeeAwardDaoOf(userContext).disconnectFromAll(employeeAwardId, employeeAwardVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeAwardManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeAwardDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeAward newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeeAwardDaoOf(ctx).loadAllAsStream().forEach(
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
		//   EmployeeAward newEmployeeAward = this.createEmployeeAward(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeAward
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
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeAward.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeAward> list) throws Exception {
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
		SmartList<EmployeeAward> list = employeeAwardDaoOf(userContext).findEmployeeAwardByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeAward.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工嘉奖列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String employeeAwardId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		EmployeeAward merchantObj = (EmployeeAward) this.view(userContext, employeeAwardId);
    String merchantObjId = employeeAwardId;
    String linkToUrl =	"employeeAwardManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工嘉奖"+"详情";
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




