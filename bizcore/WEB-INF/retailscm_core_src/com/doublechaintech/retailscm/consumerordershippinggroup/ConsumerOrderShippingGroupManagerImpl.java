
package com.doublechaintech.retailscm.consumerordershippinggroup;

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


import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;







public class ConsumerOrderShippingGroupManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderShippingGroupManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "ConsumerOrderShippingGroup";
	@Override
	public ConsumerOrderShippingGroupDAO daoOf(RetailscmUserContext userContext) {
		return consumerOrderShippingGroupDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderShippingGroupManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderShippingGroupManagerException(message);

	}



 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderShippingGroupDAO().save(consumerOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens);
 	}
 	
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroupDetail(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception{	

 		
 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());
 	}
 	
 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}
 	
 	
 	 public ConsumerOrderShippingGroup searchConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}
 	
 	

 	protected ConsumerOrderShippingGroup present(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderShippingGroup,tokens);
		
		
		ConsumerOrderShippingGroup  consumerOrderShippingGroupToPresent = consumerOrderShippingGroupDaoOf(userContext).present(consumerOrderShippingGroup, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderShippingGroupToPresent.collectRefercencesFromLists();
		consumerOrderShippingGroupDaoOf(userContext).alias(entityListToNaming);
		
		return  consumerOrderShippingGroupToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroupDetail(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{	
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, allTokens());
 		return present(userContext,consumerOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{	
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, viewTokens());
 		return present(userContext,consumerOrderShippingGroup, allTokens());
		
 	}
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderShippingGroupDaoOf(userContext).save(consumerOrderShippingGroup, tokens);
 	}
 	protected ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);

 
 		return consumerOrderShippingGroupDaoOf(userContext).load(consumerOrderShippingGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShippingGroup, tokens);
		
		addAction(userContext, consumerOrderShippingGroup, tokens,"@create","createConsumerOrderShippingGroup","createConsumerOrderShippingGroup/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@update","updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@copy","cloneConsumerOrderShippingGroup","cloneConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderShippingGroup, tokens,"consumer_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception
	//public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailscmUserContext userContext,String name, String bizOrderId, BigDecimal amount) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(name);
		checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);


		ConsumerOrderShippingGroup consumerOrderShippingGroup=createNewConsumerOrderShippingGroup();	

		consumerOrderShippingGroup.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderShippingGroup.setBizOrder(bizOrder);
		
		
		consumerOrderShippingGroup.setAmount(amount);

		consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderShippingGroup);
		return consumerOrderShippingGroup;


	}
	protected ConsumerOrderShippingGroup createNewConsumerOrderShippingGroup()
	{

		return new ConsumerOrderShippingGroup();
	}

	protected void checkParamsForUpdatingConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderShippingGroup( consumerOrderShippingGroupVersion);
		

		if(ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(parseString(newValueExpr));
		
			
		}		

		
		if(ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(parseBigDecimal(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);


	}



	public ConsumerOrderShippingGroup clone(RetailscmUserContext userContext, String fromConsumerOrderShippingGroupId) throws Exception{

		return consumerOrderShippingGroupDaoOf(userContext).clone(fromConsumerOrderShippingGroupId, this.allTokens());
	}

	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception
	{
		return internalSaveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());

	}
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			if (consumerOrderShippingGroup.isChanged()){
			
			}
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, options);
			return consumerOrderShippingGroup;

		}

	}

	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			
			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}

	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroupProperty(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.

			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderShippingGroupTokens tokens(){
		return ConsumerOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
 		checkerOf(userContext).checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);

 	}
 	public ConsumerOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderShippingGroupId,anotherBizOrderId);
 
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());	
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderShippingGroup.updateBizOrder(bizOrder);		
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
			
			return present(userContext,consumerOrderShippingGroup, allTokens());
			
		}

 	}

	


	public CandidateConsumerOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateConsumerOrder result = new CandidateConsumerOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ConsumerOrder> candidateList = consumerOrderDaoOf(userContext).requestCandidateConsumerOrderForConsumerOrderShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected ConsumerOrder loadConsumerOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{

 		return consumerOrderDaoOf(userContext).load(newBizOrderId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{

		consumerOrderShippingGroupDaoOf(userContext).delete(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}

	public ConsumerOrderShippingGroup forgetByAll(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	protected ConsumerOrderShippingGroup forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{

		return consumerOrderShippingGroupDaoOf(userContext).disconnectFromAll(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return consumerOrderShippingGroupDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderShippingGroup newCreated) throws Exception{
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
		//   ConsumerOrderShippingGroup newConsumerOrderShippingGroup = this.createConsumerOrderShippingGroup(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderShippingGroup
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrderShippingGroup.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ConsumerOrderShippingGroup> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<ConsumerOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ConsumerOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, ConsumerOrder.class);


    }
	
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<ConsumerOrderShippingGroup> list = consumerOrderShippingGroupDaoOf(userContext).findConsumerOrderShippingGroupByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ConsumerOrderShippingGroup.class);
		page.setContainerObject(ConsumerOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费订单送货分组列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getConsumerOrderShippingGroupDetailScope().clone();
		ConsumerOrderShippingGroup merchantObj = (ConsumerOrderShippingGroup) this.view(userContext, consumerOrderShippingGroupId);
    String merchantObjId = consumerOrderShippingGroupId;
    String linkToUrl =	"consumerOrderShippingGroupManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费订单送货分组"+"详情";
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
				    .put("linkToUrl", "consumerOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "4-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

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


