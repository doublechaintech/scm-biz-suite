
package com.doublechaintech.retailscm.retailstoremembercoupon;

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



import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;







public class RetailStoreMemberCouponManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberCouponManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "RetailStoreMemberCoupon";
	@Override
	public RetailStoreMemberCouponDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreMemberCouponDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberCouponManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberCouponManagerException(message);

	}



 	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberCouponDAO().save(retailStoreMemberCoupon, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens);
 	}
 	
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCouponDetail(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception{	

 		
 		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, allTokens());
 	}
 	
 	public RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberCouponManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberCoupon, tokens);
 	}
 	
 	
 	 public RetailStoreMemberCoupon searchRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberCouponManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberCoupon, tokens);
 	}
 	
 	

 	protected RetailStoreMemberCoupon present(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberCoupon,tokens);
		
		
		RetailStoreMemberCoupon  retailStoreMemberCouponToPresent = retailStoreMemberCouponDaoOf(userContext).present(retailStoreMemberCoupon, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberCouponToPresent.collectRefercencesFromLists();
		retailStoreMemberCouponDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,retailStoreMemberCoupon,tokens);
		
		return  retailStoreMemberCouponToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreMemberCoupon loadRetailStoreMemberCouponDetail(RetailscmUserContext userContext, String retailStoreMemberCouponId) throws Exception{	
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, allTokens());
 		return present(userContext,retailStoreMemberCoupon, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreMemberCouponId) throws Exception{	
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, viewTokens());
 		return present(userContext,retailStoreMemberCoupon, allTokens());
		
 	}
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object>tokens) throws Exception{	
 		return retailStoreMemberCouponDaoOf(userContext).save(retailStoreMemberCoupon, tokens);
 	}
 	protected RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberCouponManagerException.class);

 
 		return retailStoreMemberCouponDaoOf(userContext).load(retailStoreMemberCouponId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberCoupon, tokens);
		
		addAction(userContext, retailStoreMemberCoupon, tokens,"@create","createRetailStoreMemberCoupon","createRetailStoreMemberCoupon/","main","primary");
		addAction(userContext, retailStoreMemberCoupon, tokens,"@update","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMemberCoupon.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberCoupon, tokens,"@copy","cloneRetailStoreMemberCoupon","cloneRetailStoreMemberCoupon/"+retailStoreMemberCoupon.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberCoupon, tokens,"retail_store_member_coupon.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberCoupon.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailscmUserContext userContext, String name,String ownerId,String number) throws Exception
	//public RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailscmUserContext userContext,String name, String ownerId, String number) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStoreMemberCoupon(name);
		checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon(number);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberCouponManagerException.class);


		RetailStoreMemberCoupon retailStoreMemberCoupon=createNewRetailStoreMemberCoupon();	

		retailStoreMemberCoupon.setName(name);
			
		RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId,emptyOptions());
		retailStoreMemberCoupon.setOwner(owner);
		
		
		retailStoreMemberCoupon.setNumber(number);
		retailStoreMemberCoupon.setLastUpdateTime(userContext.now());

		retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMemberCoupon);
		return retailStoreMemberCoupon;


	}
	protected RetailStoreMemberCoupon createNewRetailStoreMemberCoupon()
	{

		return new RetailStoreMemberCoupon();
	}

	protected void checkParamsForUpdatingRetailStoreMemberCoupon(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon( retailStoreMemberCouponVersion);
		

		if(RetailStoreMemberCoupon.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMemberCoupon(parseString(newValueExpr));
		
			
		}		

		
		if(RetailStoreMemberCoupon.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberCouponManagerException.class);


	}



	public RetailStoreMemberCoupon clone(RetailscmUserContext userContext, String fromRetailStoreMemberCouponId) throws Exception{

		return retailStoreMemberCouponDaoOf(userContext).clone(fromRetailStoreMemberCouponId, this.allTokens());
	}

	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception
	{
		return internalSaveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, allTokens());

	}
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreMemberCoupon){
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.
			if (retailStoreMemberCoupon.isChanged()){
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			}
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, options);
			return retailStoreMemberCoupon;

		}

	}

	public RetailStoreMemberCoupon updateRetailStoreMemberCoupon(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);



		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());
		if(retailStoreMemberCoupon.getVersion() != retailStoreMemberCouponVersion){
			String message = "The target version("+retailStoreMemberCoupon.getVersion()+") is not equals to version("+retailStoreMemberCouponVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberCoupon){
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
			return present(userContext,retailStoreMemberCoupon, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
		}

	}

	public RetailStoreMemberCoupon updateRetailStoreMemberCouponProperty(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());
		if(retailStoreMemberCoupon.getVersion() != retailStoreMemberCouponVersion){
			String message = "The target version("+retailStoreMemberCoupon.getVersion()+") is not equals to version("+retailStoreMemberCouponVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberCoupon){
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.

			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
			return present(userContext,retailStoreMemberCoupon, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreMemberCouponTokens tokens(){
		return RetailStoreMemberCouponTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberCouponTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberCouponTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
 		checkerOf(userContext).checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberCouponManagerException.class);

 	}
 	public RetailStoreMemberCoupon transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberCouponId,anotherOwnerId);
 
		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());	
		synchronized(retailStoreMemberCoupon){
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());		
			retailStoreMemberCoupon.updateOwner(owner);		
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, emptyOptions());
			
			return present(userContext,retailStoreMemberCoupon, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreMember requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMember> candidateList = retailStoreMemberDaoOf(userContext).requestCandidateRetailStoreMemberForRetailStoreMemberCoupon(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreMemberDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception{

		retailStoreMemberCouponDaoOf(userContext).delete(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}

	public RetailStoreMemberCoupon forgetByAll(RetailscmUserContext userContext, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}
	protected RetailStoreMemberCoupon forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception{

		return retailStoreMemberCouponDaoOf(userContext).disconnectFromAll(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberCouponManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreMemberCouponDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberCoupon newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreMemberCouponDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreMemberCoupon newRetailStoreMemberCoupon = this.createRetailStoreMemberCoupon(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreMemberCoupon
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreMemberCoupon.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreMemberCoupon> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreMember> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreMember.class);
		userContext.getDAOGroup().enhanceList(ownerList, RetailStoreMember.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<RetailStoreMemberCoupon> list = retailStoreMemberCouponDaoOf(userContext).findRetailStoreMemberCouponByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreMemberCoupon.class);
		page.setContainerObject(RetailStoreMember.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("生超会员优惠券列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreMemberCouponId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreMemberCouponDetailScope().clone();
		RetailStoreMemberCoupon merchantObj = (RetailStoreMemberCoupon) this.view(userContext, retailStoreMemberCouponId);
    String merchantObjId = retailStoreMemberCouponId;
    String linkToUrl =	"retailStoreMemberCouponManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超会员优惠券"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "4-number")
				    .put("fieldName", "number")
				    .put("label", "数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("number", merchantObj.getNumber());

		propList.add(
				MapUtil.put("id", "5-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

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


