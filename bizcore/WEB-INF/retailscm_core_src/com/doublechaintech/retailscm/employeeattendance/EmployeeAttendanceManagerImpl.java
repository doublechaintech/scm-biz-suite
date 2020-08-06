
package com.doublechaintech.retailscm.employeeattendance;

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







public class EmployeeAttendanceManagerImpl extends CustomRetailscmCheckerManager implements EmployeeAttendanceManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeeAttendance";
	@Override
	public EmployeeAttendanceDAO daoOf(RetailscmUserContext userContext) {
		return employeeAttendanceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeAttendanceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeAttendanceManagerException(message);

	}



 	protected EmployeeAttendance saveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, String [] tokensExpr) throws Exception{	
 		//return getEmployeeAttendanceDAO().save(employeeAttendance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeAttendance(userContext, employeeAttendance, tokens);
 	}
 	
 	protected EmployeeAttendance saveEmployeeAttendanceDetail(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance) throws Exception{	

 		
 		return saveEmployeeAttendance(userContext, employeeAttendance, allTokens());
 	}
 	
 	public EmployeeAttendance loadEmployeeAttendance(RetailscmUserContext userContext, String employeeAttendanceId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeAttendanceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAttendance, tokens);
 	}
 	
 	
 	 public EmployeeAttendance searchEmployeeAttendance(RetailscmUserContext userContext, String employeeAttendanceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeAttendanceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAttendance, tokens);
 	}
 	
 	

 	protected EmployeeAttendance present(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeAttendance,tokens);
		
		
		EmployeeAttendance  employeeAttendanceToPresent = employeeAttendanceDaoOf(userContext).present(employeeAttendance, tokens);
		
		List<BaseEntity> entityListToNaming = employeeAttendanceToPresent.collectRefercencesFromLists();
		employeeAttendanceDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,employeeAttendance,tokens);
		
		return  employeeAttendanceToPresent;
		
		
	}
 
 	
 	
 	public EmployeeAttendance loadEmployeeAttendanceDetail(RetailscmUserContext userContext, String employeeAttendanceId) throws Exception{	
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, allTokens());
 		return present(userContext,employeeAttendance, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeAttendanceId) throws Exception{	
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, viewTokens());
 		return present(userContext,employeeAttendance, allTokens());
		
 	}
 	protected EmployeeAttendance saveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String,Object>tokens) throws Exception{	
 		return employeeAttendanceDaoOf(userContext).save(employeeAttendance, tokens);
 	}
 	protected EmployeeAttendance loadEmployeeAttendance(RetailscmUserContext userContext, String employeeAttendanceId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeAttendanceManagerException.class);

 
 		return employeeAttendanceDaoOf(userContext).load(employeeAttendanceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens){
		super.addActions(userContext, employeeAttendance, tokens);
		
		addAction(userContext, employeeAttendance, tokens,"@create","createEmployeeAttendance","createEmployeeAttendance/","main","primary");
		addAction(userContext, employeeAttendance, tokens,"@update","updateEmployeeAttendance","updateEmployeeAttendance/"+employeeAttendance.getId()+"/","main","primary");
		addAction(userContext, employeeAttendance, tokens,"@copy","cloneEmployeeAttendance","cloneEmployeeAttendance/"+employeeAttendance.getId()+"/","main","primary");
		
		addAction(userContext, employeeAttendance, tokens,"employee_attendance.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeAttendance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeAttendance createEmployeeAttendance(RetailscmUserContext userContext, String employeeId,Date enterTime,Date leaveTime,int durationHours,String remark) throws Exception
	//public EmployeeAttendance createEmployeeAttendance(RetailscmUserContext userContext,String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark) throws Exception
	{

		

		

		checkerOf(userContext).checkEnterTimeOfEmployeeAttendance(enterTime);
		checkerOf(userContext).checkLeaveTimeOfEmployeeAttendance(leaveTime);
		checkerOf(userContext).checkDurationHoursOfEmployeeAttendance(durationHours);
		checkerOf(userContext).checkRemarkOfEmployeeAttendance(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeAttendanceManagerException.class);


		EmployeeAttendance employeeAttendance=createNewEmployeeAttendance();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeAttendance.setEmployee(employee);
		
		
		employeeAttendance.setEnterTime(enterTime);
		employeeAttendance.setLeaveTime(leaveTime);
		employeeAttendance.setDurationHours(durationHours);
		employeeAttendance.setRemark(remark);

		employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeAttendance);
		return employeeAttendance;


	}
	protected EmployeeAttendance createNewEmployeeAttendance()
	{

		return new EmployeeAttendance();
	}

	protected void checkParamsForUpdatingEmployeeAttendance(RetailscmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
		checkerOf(userContext).checkVersionOfEmployeeAttendance( employeeAttendanceVersion);
		
		

		
		if(EmployeeAttendance.ENTER_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEnterTimeOfEmployeeAttendance(parseDate(newValueExpr));
		
			
		}
		if(EmployeeAttendance.LEAVE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeaveTimeOfEmployeeAttendance(parseDate(newValueExpr));
		
			
		}
		if(EmployeeAttendance.DURATION_HOURS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationHoursOfEmployeeAttendance(parseInt(newValueExpr));
		
			
		}
		if(EmployeeAttendance.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeAttendance(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeAttendanceManagerException.class);


	}



	public EmployeeAttendance clone(RetailscmUserContext userContext, String fromEmployeeAttendanceId) throws Exception{

		return employeeAttendanceDaoOf(userContext).clone(fromEmployeeAttendanceId, this.allTokens());
	}

	public EmployeeAttendance internalSaveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance) throws Exception
	{
		return internalSaveEmployeeAttendance(userContext, employeeAttendance, allTokens());

	}
	public EmployeeAttendance internalSaveEmployeeAttendance(RetailscmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeAttendance){
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.
			if (employeeAttendance.isChanged()){
			
			}
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, options);
			return employeeAttendance;

		}

	}

	public EmployeeAttendance updateEmployeeAttendance(RetailscmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);



		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());
		if(employeeAttendance.getVersion() != employeeAttendanceVersion){
			String message = "The target version("+employeeAttendance.getVersion()+") is not equals to version("+employeeAttendanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAttendance){
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.
			
			employeeAttendance.changeProperty(property, newValueExpr);
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
			return present(userContext,employeeAttendance, mergedAllTokens(tokensExpr));
			//return saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
		}

	}

	public EmployeeAttendance updateEmployeeAttendanceProperty(RetailscmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);

		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());
		if(employeeAttendance.getVersion() != employeeAttendanceVersion){
			String message = "The target version("+employeeAttendance.getVersion()+") is not equals to version("+employeeAttendanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeAttendance){
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.

			employeeAttendance.changeProperty(property, newValueExpr);
			
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
			return present(userContext,employeeAttendance, mergedAllTokens(tokensExpr));
			//return saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeAttendanceTokens tokens(){
		return EmployeeAttendanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeAttendanceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeAttendanceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeAttendance(employeeAttendanceId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeAttendanceManagerException.class);

 	}
 	public EmployeeAttendance transferToAnotherEmployee(RetailscmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeAttendanceId,anotherEmployeeId);
 
		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());	
		synchronized(employeeAttendance){
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeAttendance.updateEmployee(employee);		
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, emptyOptions());
			
			return present(userContext,employeeAttendance, allTokens());
			
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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeAttendance(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String employeeAttendanceId, int employeeAttendanceVersion) throws Exception {
		//deleteInternal(userContext, employeeAttendanceId, employeeAttendanceVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeAttendanceId, int employeeAttendanceVersion) throws Exception{

		employeeAttendanceDaoOf(userContext).delete(employeeAttendanceId, employeeAttendanceVersion);
	}

	public EmployeeAttendance forgetByAll(RetailscmUserContext userContext, String employeeAttendanceId, int employeeAttendanceVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeAttendanceId, employeeAttendanceVersion);
	}
	protected EmployeeAttendance forgetByAllInternal(RetailscmUserContext userContext,
			String employeeAttendanceId, int employeeAttendanceVersion) throws Exception{

		return employeeAttendanceDaoOf(userContext).disconnectFromAll(employeeAttendanceId, employeeAttendanceVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeAttendanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeAttendanceDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeAttendance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeeAttendanceDaoOf(ctx).loadAllAsStream().forEach(
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
		//   EmployeeAttendance newEmployeeAttendance = this.createEmployeeAttendance(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeAttendance
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeAttendance.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeAttendance> list) throws Exception {
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
		SmartList<EmployeeAttendance> list = employeeAttendanceDaoOf(userContext).findEmployeeAttendanceByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeAttendance.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工考勤列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String employeeAttendanceId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getEmployeeAttendanceDetailScope().clone();
		EmployeeAttendance merchantObj = (EmployeeAttendance) this.view(userContext, employeeAttendanceId);
    String merchantObjId = employeeAttendanceId;
    String linkToUrl =	"employeeAttendanceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工考勤"+"详情";
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
				MapUtil.put("id", "3-enterTime")
				    .put("fieldName", "enterTime")
				    .put("label", "进入时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("enterTime", merchantObj.getEnterTime());

		propList.add(
				MapUtil.put("id", "4-leaveTime")
				    .put("fieldName", "leaveTime")
				    .put("label", "离开的时候")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("leaveTime", merchantObj.getLeaveTime());

		propList.add(
				MapUtil.put("id", "5-durationHours")
				    .put("fieldName", "durationHours")
				    .put("label", "持续时间")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("durationHours", merchantObj.getDurationHours());

		propList.add(
				MapUtil.put("id", "6-remark")
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


