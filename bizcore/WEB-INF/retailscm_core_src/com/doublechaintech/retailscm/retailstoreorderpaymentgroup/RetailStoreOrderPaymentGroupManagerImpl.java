
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

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


import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;







public class RetailStoreOrderPaymentGroupManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderPaymentGroupManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreOrderPaymentGroup";
	@Override
	public RetailStoreOrderPaymentGroupDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderPaymentGroupDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderPaymentGroupManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderPaymentGroupManagerException(message);

	}



 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderPaymentGroupDAO().save(retailStoreOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroupDetail(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception{	

 		
 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());
 	}
 	
 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	
 	 public RetailStoreOrderPaymentGroup searchRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	

 	protected RetailStoreOrderPaymentGroup present(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderPaymentGroup,tokens);
		
		
		RetailStoreOrderPaymentGroup  retailStoreOrderPaymentGroupToPresent = retailStoreOrderPaymentGroupDaoOf(userContext).present(retailStoreOrderPaymentGroup, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderPaymentGroupToPresent.collectRefercencesFromLists();
		retailStoreOrderPaymentGroupDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreOrderPaymentGroupToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroupDetail(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{	
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, allTokens());
 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{	
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, viewTokens());
 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());
		
 	}
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOrderPaymentGroupDaoOf(userContext).save(retailStoreOrderPaymentGroup, tokens);
 	}
 	protected RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);

 
 		return retailStoreOrderPaymentGroupDaoOf(userContext).load(retailStoreOrderPaymentGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPaymentGroup, tokens);
		
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@create","createRetailStoreOrderPaymentGroup","createRetailStoreOrderPaymentGroup/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@update","updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@copy","cloneRetailStoreOrderPaymentGroup","cloneRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"retail_store_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception
	//public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String name, String bizOrderId, String cardNumber) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStoreOrderPaymentGroup(name);
		checkerOf(userContext).checkCardNumberOfRetailStoreOrderPaymentGroup(cardNumber);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);


		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup=createNewRetailStoreOrderPaymentGroup();	

		retailStoreOrderPaymentGroup.setName(name);
			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderPaymentGroup.setBizOrder(bizOrder);
		
		
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);

		retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderPaymentGroup);
		return retailStoreOrderPaymentGroup;


	}
	protected RetailStoreOrderPaymentGroup createNewRetailStoreOrderPaymentGroup()
	{

		return new RetailStoreOrderPaymentGroup();
	}

	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroupVersion);
		

		if(RetailStoreOrderPaymentGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		
			
		}		

		
		if(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCardNumberOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);


	}



	public RetailStoreOrderPaymentGroup clone(RetailscmUserContext userContext, String fromRetailStoreOrderPaymentGroupId) throws Exception{

		return retailStoreOrderPaymentGroupDaoOf(userContext).clone(fromRetailStoreOrderPaymentGroupId, this.allTokens());
	}

	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception
	{
		return internalSaveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());

	}
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			if (retailStoreOrderPaymentGroup.isChanged()){
			
			}
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, options);
			return retailStoreOrderPaymentGroup;

		}

	}

	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			
			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}

	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroupProperty(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.

			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderPaymentGroupTokens tokens(){
		return RetailStoreOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderPaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
 		checkerOf(userContext).checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);

 	}
 	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderPaymentGroupId,anotherBizOrderId);
 
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());	
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());		
			retailStoreOrderPaymentGroup.updateBizOrder(bizOrder);		
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
			
			return present(userContext,retailStoreOrderPaymentGroup, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrder result = new CandidateRetailStoreOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrder> candidateList = retailStoreOrderDaoOf(userContext).requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreOrderDaoOf(userContext).load(newBizOrderId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{

		retailStoreOrderPaymentGroupDaoOf(userContext).delete(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}

	public RetailStoreOrderPaymentGroup forgetByAll(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	protected RetailStoreOrderPaymentGroup forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{

		return retailStoreOrderPaymentGroupDaoOf(userContext).disconnectFromAll(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderPaymentGroupDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup newCreated) throws Exception{
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
		//   RetailStoreOrderPaymentGroup newRetailStoreOrderPaymentGroup = this.createRetailStoreOrderPaymentGroup(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderPaymentGroup
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOrderPaymentGroup.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderPaymentGroup> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, RetailStoreOrder.class);


    }
	
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<RetailStoreOrderPaymentGroup> list = retailStoreOrderPaymentGroupDaoOf(userContext).findRetailStoreOrderPaymentGroupByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreOrderPaymentGroup.class);
		page.setContainerObject(RetailStoreOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("生超订单付款组列表");
		page.setRequestName("listByBizOrder");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBizOrder/%s/",  getBeanName(), bizOrderId)));

		page.assemblerContent(userContext, "listByBizOrder");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreOrderPaymentGroupDetailScope().clone();
		RetailStoreOrderPaymentGroup merchantObj = (RetailStoreOrderPaymentGroup) this.view(userContext, retailStoreOrderPaymentGroupId);
    String merchantObjId = retailStoreOrderPaymentGroupId;
    String linkToUrl =	"retailStoreOrderPaymentGroupManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单付款组"+"详情";
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
				MapUtil.put("id", "3-bizOrder")
				    .put("fieldName", "bizOrder")
				    .put("label", "订单")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "4-cardNumber")
				    .put("fieldName", "cardNumber")
				    .put("label", "卡号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("cardNumber", merchantObj.getCardNumber());

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


