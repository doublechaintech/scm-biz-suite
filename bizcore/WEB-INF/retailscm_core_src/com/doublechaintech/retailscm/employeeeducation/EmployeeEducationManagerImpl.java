
package com.doublechaintech.retailscm.employeeeducation;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.CandidateEmployee;







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
 	
 	public Object view(RetailscmUserContext userContext, String employeeEducationId) throws Exception{	
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, viewTokens());
 		return present(userContext,employeeEducation, allTokens());
		
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
	
 	
 	
 
 	
 	

	public EmployeeEducation createEmployeeEducation(RetailscmUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception
	//public EmployeeEducation createEmployeeEducation(RetailscmUserContext userContext,String employeeId, Date completeTime, String type, String remark) throws Exception
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
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

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
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}

		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
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
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeEducation.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
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
	  SerializeScope vscope = RetailscmViewScope.getInstance().getEmployeeEducationDetailScope().clone();
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


