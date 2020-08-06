
package com.doublechaintech.retailscm.loginhistory;

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



import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.CandidateSecUser;







public class LoginHistoryManagerImpl extends CustomRetailscmCheckerManager implements LoginHistoryManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "LoginHistory";
	@Override
	public LoginHistoryDAO daoOf(RetailscmUserContext userContext) {
		return loginHistoryDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws LoginHistoryManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LoginHistoryManagerException(message);

	}



 	protected LoginHistory saveLoginHistory(RetailscmUserContext userContext, LoginHistory loginHistory, String [] tokensExpr) throws Exception{	
 		//return getLoginHistoryDAO().save(loginHistory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLoginHistory(userContext, loginHistory, tokens);
 	}
 	
 	protected LoginHistory saveLoginHistoryDetail(RetailscmUserContext userContext, LoginHistory loginHistory) throws Exception{	

 		
 		return saveLoginHistory(userContext, loginHistory, allTokens());
 	}
 	
 	public LoginHistory loadLoginHistory(RetailscmUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}
 	
 	
 	 public LoginHistory searchLoginHistory(RetailscmUserContext userContext, String loginHistoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}
 	
 	

 	protected LoginHistory present(RetailscmUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,loginHistory,tokens);
		
		
		LoginHistory  loginHistoryToPresent = loginHistoryDaoOf(userContext).present(loginHistory, tokens);
		
		List<BaseEntity> entityListToNaming = loginHistoryToPresent.collectRefercencesFromLists();
		loginHistoryDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,loginHistory,tokens);
		
		return  loginHistoryToPresent;
		
		
	}
 
 	
 	
 	public LoginHistory loadLoginHistoryDetail(RetailscmUserContext userContext, String loginHistoryId) throws Exception{	
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, allTokens());
 		return present(userContext,loginHistory, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String loginHistoryId) throws Exception{	
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, viewTokens());
 		return present(userContext,loginHistory, allTokens());
		
 	}
 	protected LoginHistory saveLoginHistory(RetailscmUserContext userContext, LoginHistory loginHistory, Map<String,Object>tokens) throws Exception{	
 		return loginHistoryDaoOf(userContext).save(loginHistory, tokens);
 	}
 	protected LoginHistory loadLoginHistory(RetailscmUserContext userContext, String loginHistoryId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 
 		return loginHistoryDaoOf(userContext).load(loginHistoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
		super.addActions(userContext, loginHistory, tokens);
		
		addAction(userContext, loginHistory, tokens,"@create","createLoginHistory","createLoginHistory/","main","primary");
		addAction(userContext, loginHistory, tokens,"@update","updateLoginHistory","updateLoginHistory/"+loginHistory.getId()+"/","main","primary");
		addAction(userContext, loginHistory, tokens,"@copy","cloneLoginHistory","cloneLoginHistory/"+loginHistory.getId()+"/","main","primary");
		
		addAction(userContext, loginHistory, tokens,"login_history.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+loginHistory.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public LoginHistory createLoginHistory(RetailscmUserContext userContext, String fromIp,String description,String secUserId) throws Exception
	//public LoginHistory createLoginHistory(RetailscmUserContext userContext,String fromIp, String description, String secUserId) throws Exception
	{

		

		

		checkerOf(userContext).checkFromIpOfLoginHistory(fromIp);
		checkerOf(userContext).checkDescriptionOfLoginHistory(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);


		LoginHistory loginHistory=createNewLoginHistory();	

		loginHistory.setLoginTime(userContext.now());
		loginHistory.setFromIp(fromIp);
		loginHistory.setDescription(description);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		loginHistory.setSecUser(secUser);
		
		

		loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
		
		onNewInstanceCreated(userContext, loginHistory);
		return loginHistory;


	}
	protected LoginHistory createNewLoginHistory()
	{

		return new LoginHistory();
	}

	protected void checkParamsForUpdatingLoginHistory(RetailscmUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory( loginHistoryVersion);
		

		if(LoginHistory.FROM_IP_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromIpOfLoginHistory(parseString(newValueExpr));
		
			
		}
		if(LoginHistory.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLoginHistory(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);


	}



	public LoginHistory clone(RetailscmUserContext userContext, String fromLoginHistoryId) throws Exception{

		return loginHistoryDaoOf(userContext).clone(fromLoginHistoryId, this.allTokens());
	}

	public LoginHistory internalSaveLoginHistory(RetailscmUserContext userContext, LoginHistory loginHistory) throws Exception
	{
		return internalSaveLoginHistory(userContext, loginHistory, allTokens());

	}
	public LoginHistory internalSaveLoginHistory(RetailscmUserContext userContext, LoginHistory loginHistory, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);


		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			if (loginHistory.isChanged()){
			
			}
			loginHistory = saveLoginHistory(userContext, loginHistory, options);
			return loginHistory;

		}

	}

	public LoginHistory updateLoginHistory(RetailscmUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);



		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			loginHistory.changeProperty(property, newValueExpr);
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}

	public LoginHistory updateLoginHistoryProperty(RetailscmUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);

		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.

			loginHistory.changeProperty(property, newValueExpr);
			
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LoginHistoryTokens tokens(){
		return LoginHistoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LoginHistoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LoginHistoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(RetailscmUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}
 	public LoginHistory transferToAnotherSecUser(RetailscmUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, loginHistoryId,anotherSecUserId);
 
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(RetailscmUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}

 	public LoginHistory transferToAnotherSecUserWithLogin(RetailscmUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, loginHistoryId,anotherLogin);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			loginHistory.updateSecUser(secUser);
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(RetailscmUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}

 	public LoginHistory transferToAnotherSecUserWithEmail(RetailscmUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, loginHistoryId,anotherEmail);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			loginHistory.updateSecUser(secUser);
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(RetailscmUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}

 	public LoginHistory transferToAnotherSecUserWithMobile(RetailscmUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, loginHistoryId,anotherMobile);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			loginHistory.updateSecUser(secUser);
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForLoginHistory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SecUser loadSecUser(RetailscmUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(RetailscmUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(RetailscmUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(RetailscmUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		//deleteInternal(userContext, loginHistoryId, loginHistoryVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{

		loginHistoryDaoOf(userContext).delete(loginHistoryId, loginHistoryVersion);
	}

	public LoginHistory forgetByAll(RetailscmUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		return forgetByAllInternal(userContext, loginHistoryId, loginHistoryVersion);
	}
	protected LoginHistory forgetByAllInternal(RetailscmUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{

		return loginHistoryDaoOf(userContext).disconnectFromAll(loginHistoryId, loginHistoryVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LoginHistoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return loginHistoryDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, LoginHistory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    loginHistoryDaoOf(ctx).loadAllAsStream().forEach(
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
		//   LoginHistory newLoginHistory = this.createLoginHistory(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLoginHistory
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LoginHistory.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LoginHistory> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SecUser> secUserList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<LoginHistory> list = loginHistoryDaoOf(userContext).findLoginHistoryBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LoginHistory.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("登录历史列表");
		page.setRequestName("listBySecUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/",  getBeanName(), secUserId)));

		page.assemblerContent(userContext, "listBySecUser");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String loginHistoryId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getLoginHistoryDetailScope().clone();
		LoginHistory merchantObj = (LoginHistory) this.view(userContext, loginHistoryId);
    String merchantObjId = loginHistoryId;
    String linkToUrl =	"loginHistoryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "登录历史"+"详情";
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
				MapUtil.put("id", "2-loginTime")
				    .put("fieldName", "loginTime")
				    .put("label", "登录时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("loginTime", merchantObj.getLoginTime());

		propList.add(
				MapUtil.put("id", "3-fromIp")
				    .put("fieldName", "fromIp")
				    .put("label", "从IP")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("fromIp", merchantObj.getFromIp());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "5-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "安全用户")
				    .put("type", "auto")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

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


