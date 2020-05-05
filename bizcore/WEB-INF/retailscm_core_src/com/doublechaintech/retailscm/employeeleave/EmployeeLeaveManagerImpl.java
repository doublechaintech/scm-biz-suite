
package com.doublechaintech.retailscm.employeeleave;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
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
import com.doublechaintech.retailscm.leavetype.LeaveType;

import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.leavetype.CandidateLeaveType;







public class EmployeeLeaveManagerImpl extends CustomRetailscmCheckerManager implements EmployeeLeaveManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "EmployeeLeave";
	@Override
	public EmployeeLeaveDAO daoOf(RetailscmUserContext userContext) {
		return employeeLeaveDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeLeaveManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeLeaveManagerException(message);

	}



 	protected EmployeeLeave saveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave, String [] tokensExpr) throws Exception{	
 		//return getEmployeeLeaveDAO().save(employeeLeave, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeLeave(userContext, employeeLeave, tokens);
 	}
 	
 	protected EmployeeLeave saveEmployeeLeaveDetail(RetailscmUserContext userContext, EmployeeLeave employeeLeave) throws Exception{	

 		
 		return saveEmployeeLeave(userContext, employeeLeave, allTokens());
 	}
 	
 	public EmployeeLeave loadEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeLeaveManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeLeave, tokens);
 	}
 	
 	
 	 public EmployeeLeave searchEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeLeaveManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeLeave, tokens);
 	}
 	
 	

 	protected EmployeeLeave present(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeLeave,tokens);
		
		
		EmployeeLeave  employeeLeaveToPresent = employeeLeaveDaoOf(userContext).present(employeeLeave, tokens);
		
		List<BaseEntity> entityListToNaming = employeeLeaveToPresent.collectRefercencesFromLists();
		employeeLeaveDaoOf(userContext).alias(entityListToNaming);
		
		return  employeeLeaveToPresent;
		
		
	}
 
 	
 	
 	public EmployeeLeave loadEmployeeLeaveDetail(RetailscmUserContext userContext, String employeeLeaveId) throws Exception{	
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, allTokens());
 		return present(userContext,employeeLeave, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeLeaveId) throws Exception{	
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, viewTokens());
 		return present(userContext,employeeLeave, allTokens());
		
 	}
 	protected EmployeeLeave saveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String,Object>tokens) throws Exception{	
 		return employeeLeaveDaoOf(userContext).save(employeeLeave, tokens);
 	}
 	protected EmployeeLeave loadEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeLeaveManagerException.class);

 
 		return employeeLeaveDaoOf(userContext).load(employeeLeaveId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens){
		super.addActions(userContext, employeeLeave, tokens);
		
		addAction(userContext, employeeLeave, tokens,"@create","createEmployeeLeave","createEmployeeLeave/","main","primary");
		addAction(userContext, employeeLeave, tokens,"@update","updateEmployeeLeave","updateEmployeeLeave/"+employeeLeave.getId()+"/","main","primary");
		addAction(userContext, employeeLeave, tokens,"@copy","cloneEmployeeLeave","cloneEmployeeLeave/"+employeeLeave.getId()+"/","main","primary");
		
		addAction(userContext, employeeLeave, tokens,"employee_leave.transfer_to_who","transferToAnotherWho","transferToAnotherWho/"+employeeLeave.getId()+"/","main","primary");
		addAction(userContext, employeeLeave, tokens,"employee_leave.transfer_to_type","transferToAnotherType","transferToAnotherType/"+employeeLeave.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeLeave createEmployeeLeave(RetailscmUserContext userContext, String whoId,String typeId,int leaveDurationHour,String remark) throws Exception
	//public EmployeeLeave createEmployeeLeave(RetailscmUserContext userContext,String whoId, String typeId, int leaveDurationHour, String remark) throws Exception
	{

		

		

		checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);
		checkerOf(userContext).checkRemarkOfEmployeeLeave(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);


		EmployeeLeave employeeLeave=createNewEmployeeLeave();	

			
		Employee who = loadEmployee(userContext, whoId,emptyOptions());
		employeeLeave.setWho(who);
		
		
			
		LeaveType type = loadLeaveType(userContext, typeId,emptyOptions());
		employeeLeave.setType(type);
		
		
		employeeLeave.setLeaveDurationHour(leaveDurationHour);
		employeeLeave.setRemark(remark);

		employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeLeave);
		return employeeLeave;


	}
	protected EmployeeLeave createNewEmployeeLeave()
	{

		return new EmployeeLeave();
	}

	protected void checkParamsForUpdatingEmployeeLeave(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
		checkerOf(userContext).checkVersionOfEmployeeLeave( employeeLeaveVersion);
		
		

				

		
		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(parseInt(newValueExpr));
		
			
		}
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeLeave(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);


	}



	public EmployeeLeave clone(RetailscmUserContext userContext, String fromEmployeeLeaveId) throws Exception{

		return employeeLeaveDaoOf(userContext).clone(fromEmployeeLeaveId, this.allTokens());
	}

	public EmployeeLeave internalSaveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave) throws Exception
	{
		return internalSaveEmployeeLeave(userContext, employeeLeave, allTokens());

	}
	public EmployeeLeave internalSaveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.
			if (employeeLeave.isChanged()){
			
			}
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, options);
			return employeeLeave;

		}

	}

	public EmployeeLeave updateEmployeeLeave(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);



		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());
		if(employeeLeave.getVersion() != employeeLeaveVersion){
			String message = "The target version("+employeeLeave.getVersion()+") is not equals to version("+employeeLeaveVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.
			
			employeeLeave.changeProperty(property, newValueExpr);
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, tokens().done());
			return present(userContext,employeeLeave, mergedAllTokens(tokensExpr));
			//return saveEmployeeLeave(userContext, employeeLeave, tokens().done());
		}

	}

	public EmployeeLeave updateEmployeeLeaveProperty(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);

		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());
		if(employeeLeave.getVersion() != employeeLeaveVersion){
			String message = "The target version("+employeeLeave.getVersion()+") is not equals to version("+employeeLeaveVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.

			employeeLeave.changeProperty(property, newValueExpr);
			
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, tokens().done());
			return present(userContext,employeeLeave, mergedAllTokens(tokensExpr));
			//return saveEmployeeLeave(userContext, employeeLeave, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeLeaveTokens tokens(){
		return EmployeeLeaveTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeLeaveTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeLeaveTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWho(RetailscmUserContext userContext, String employeeLeaveId, String anotherWhoId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
 		checkerOf(userContext).checkIdOfEmployee(anotherWhoId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);

 	}
 	public EmployeeLeave transferToAnotherWho(RetailscmUserContext userContext, String employeeLeaveId, String anotherWhoId) throws Exception
 	{
 		checkParamsForTransferingAnotherWho(userContext, employeeLeaveId,anotherWhoId);
 
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());	
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee who = loadEmployee(userContext, anotherWhoId, emptyOptions());		
			employeeLeave.updateWho(who);		
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
			
			return present(userContext,employeeLeave, allTokens());
			
		}

 	}

	


	public CandidateEmployee requestCandidateWho(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeLeave(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherType(RetailscmUserContext userContext, String employeeLeaveId, String anotherTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
 		checkerOf(userContext).checkIdOfLeaveType(anotherTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeLeaveManagerException.class);

 	}
 	public EmployeeLeave transferToAnotherType(RetailscmUserContext userContext, String employeeLeaveId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, employeeLeaveId,anotherTypeId);
 
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());	
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveType type = loadLeaveType(userContext, anotherTypeId, emptyOptions());		
			employeeLeave.updateType(type);		
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
			
			return present(userContext,employeeLeave, allTokens());
			
		}

 	}

	


	public CandidateLeaveType requestCandidateType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLeaveType result = new CandidateLeaveType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LeaveType> candidateList = leaveTypeDaoOf(userContext).requestCandidateLeaveTypeForEmployeeLeave(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LeaveType loadLeaveType(RetailscmUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{

 		return leaveTypeDaoOf(userContext).load(newTypeId, options);
 	}
 	


	

 	protected Employee loadEmployee(RetailscmUserContext userContext, String newWhoId, Map<String,Object> options) throws Exception
 	{

 		return employeeDaoOf(userContext).load(newWhoId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeLeaveId, int employeeLeaveVersion) throws Exception {
		//deleteInternal(userContext, employeeLeaveId, employeeLeaveVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeLeaveId, int employeeLeaveVersion) throws Exception{

		employeeLeaveDaoOf(userContext).delete(employeeLeaveId, employeeLeaveVersion);
	}

	public EmployeeLeave forgetByAll(RetailscmUserContext userContext, String employeeLeaveId, int employeeLeaveVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeLeaveId, employeeLeaveVersion);
	}
	protected EmployeeLeave forgetByAllInternal(RetailscmUserContext userContext,
			String employeeLeaveId, int employeeLeaveVersion) throws Exception{

		return employeeLeaveDaoOf(userContext).disconnectFromAll(employeeLeaveId, employeeLeaveVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeLeaveManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeLeaveDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeLeave newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
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
		//   EmployeeLeave newEmployeeLeave = this.createEmployeeLeave(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeLeave
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeLeave.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeLeave> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> whoList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(whoList, Employee.class);
		List<LeaveType> typeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LeaveType.class);
		userContext.getDAOGroup().enhanceList(typeList, LeaveType.class);


    }
	
	public Object listByWho(RetailscmUserContext userContext,String whoId) throws Exception {
		return listPageByWho(userContext, whoId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByWho(RetailscmUserContext userContext,String whoId, int start, int count) throws Exception {
		SmartList<EmployeeLeave> list = employeeLeaveDaoOf(userContext).findEmployeeLeaveByWho(whoId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeLeave.class);
		page.setContainerObject(Employee.withId(whoId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("请假记录列表");
		page.setRequestName("listByWho");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByWho/%s/",  getBeanName(), whoId)));

		page.assemblerContent(userContext, "listByWho");
		return page.doRender(userContext);
	}
  
	public Object listByType(RetailscmUserContext userContext,String typeId) throws Exception {
		return listPageByType(userContext, typeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByType(RetailscmUserContext userContext,String typeId, int start, int count) throws Exception {
		SmartList<EmployeeLeave> list = employeeLeaveDaoOf(userContext).findEmployeeLeaveByType(typeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeLeave.class);
		page.setContainerObject(LeaveType.withId(typeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("请假记录列表");
		page.setRequestName("listByType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByType/%s/",  getBeanName(), typeId)));

		page.assemblerContent(userContext, "listByType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String employeeLeaveId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getEmployeeLeaveDetailScope().clone();
		EmployeeLeave merchantObj = (EmployeeLeave) this.view(userContext, employeeLeaveId);
    String merchantObjId = employeeLeaveId;
    String linkToUrl =	"employeeLeaveManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "请假记录"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
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
				    .put("type", "auto")
				    .put("linkToUrl", "employeeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("who", merchantObj.getWho());

		propList.add(
				MapUtil.put("id", "3-type")
				    .put("fieldName", "type")
				    .put("label", "类型")
				    .put("type", "auto")
				    .put("linkToUrl", "leaveTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("type", merchantObj.getType());

		propList.add(
				MapUtil.put("id", "4-leaveDurationHour")
				    .put("fieldName", "leaveDurationHour")
				    .put("label", "请假时长")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("leaveDurationHour", merchantObj.getLeaveDurationHour());

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


