
package com.doublechaintech.retailscm.retailstoreorderlineitem;

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



import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;







public class RetailStoreOrderLineItemManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderLineItemManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "RetailStoreOrderLineItem";
	@Override
	public RetailStoreOrderLineItemDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderLineItemDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderLineItemManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderLineItemManagerException(message);

	}



 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderLineItemDAO().save(retailStoreOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens);
 	}
 	
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItemDetail(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem) throws Exception{	

 		
 		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, allTokens());
 	}
 	
 	public RetailStoreOrderLineItem loadRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderLineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderLineItem, tokens);
 	}
 	
 	
 	 public RetailStoreOrderLineItem searchRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderLineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderLineItem, tokens);
 	}
 	
 	

 	protected RetailStoreOrderLineItem present(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderLineItem,tokens);
		
		
		RetailStoreOrderLineItem  retailStoreOrderLineItemToPresent = retailStoreOrderLineItemDaoOf(userContext).present(retailStoreOrderLineItem, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderLineItemToPresent.collectRefercencesFromLists();
		retailStoreOrderLineItemDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,retailStoreOrderLineItem,tokens);
		
		return  retailStoreOrderLineItemToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderLineItem loadRetailStoreOrderLineItemDetail(RetailscmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{	
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, allTokens());
 		return present(userContext,retailStoreOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{	
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, viewTokens());
 		return present(userContext,retailStoreOrderLineItem, allTokens());
		
 	}
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOrderLineItemDaoOf(userContext).save(retailStoreOrderLineItem, tokens);
 	}
 	protected RetailStoreOrderLineItem loadRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderLineItemId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderLineItemManagerException.class);

 
 		return retailStoreOrderLineItemDaoOf(userContext).load(retailStoreOrderLineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderLineItem, tokens);
		
		addAction(userContext, retailStoreOrderLineItem, tokens,"@create","createRetailStoreOrderLineItem","createRetailStoreOrderLineItem/","main","primary");
		addAction(userContext, retailStoreOrderLineItem, tokens,"@update","updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem/"+retailStoreOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderLineItem, tokens,"@copy","cloneRetailStoreOrderLineItem","cloneRetailStoreOrderLineItem/"+retailStoreOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderLineItem, tokens,"retail_store_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailscmUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement) throws Exception
	//public RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailscmUserContext userContext,String bizOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception
	{

		

		

		checkerOf(userContext).checkSkuIdOfRetailStoreOrderLineItem(skuId);
		checkerOf(userContext).checkSkuNameOfRetailStoreOrderLineItem(skuName);
		checkerOf(userContext).checkAmountOfRetailStoreOrderLineItem(amount);
		checkerOf(userContext).checkQuantityOfRetailStoreOrderLineItem(quantity);
		checkerOf(userContext).checkUnitOfMeasurementOfRetailStoreOrderLineItem(unitOfMeasurement);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderLineItemManagerException.class);


		RetailStoreOrderLineItem retailStoreOrderLineItem=createNewRetailStoreOrderLineItem();	

			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderLineItem.setBizOrder(bizOrder);
		
		
		retailStoreOrderLineItem.setSkuId(skuId);
		retailStoreOrderLineItem.setSkuName(skuName);
		retailStoreOrderLineItem.setAmount(amount);
		retailStoreOrderLineItem.setQuantity(quantity);
		retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

		retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderLineItem);
		return retailStoreOrderLineItem;


	}
	protected RetailStoreOrderLineItem createNewRetailStoreOrderLineItem()
	{

		return new RetailStoreOrderLineItem();
	}

	protected void checkParamsForUpdatingRetailStoreOrderLineItem(RetailscmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderLineItem( retailStoreOrderLineItemVersion);
		
		

		
		if(RetailStoreOrderLineItem.SKU_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuIdOfRetailStoreOrderLineItem(parseString(newValueExpr));
		
			
		}
		if(RetailStoreOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuNameOfRetailStoreOrderLineItem(parseString(newValueExpr));
		
			
		}
		if(RetailStoreOrderLineItem.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfRetailStoreOrderLineItem(parseBigDecimal(newValueExpr));
		
			
		}
		if(RetailStoreOrderLineItem.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfRetailStoreOrderLineItem(parseInt(newValueExpr));
		
			
		}
		if(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUnitOfMeasurementOfRetailStoreOrderLineItem(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderLineItemManagerException.class);


	}



	public RetailStoreOrderLineItem clone(RetailscmUserContext userContext, String fromRetailStoreOrderLineItemId) throws Exception{

		return retailStoreOrderLineItemDaoOf(userContext).clone(fromRetailStoreOrderLineItemId, this.allTokens());
	}

	public RetailStoreOrderLineItem internalSaveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem) throws Exception
	{
		return internalSaveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, allTokens());

	}
	public RetailStoreOrderLineItem internalSaveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderLineItem){
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.
			if (retailStoreOrderLineItem.isChanged()){
			
			}
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, options);
			return retailStoreOrderLineItem;

		}

	}

	public RetailStoreOrderLineItem updateRetailStoreOrderLineItem(RetailscmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());
		if(retailStoreOrderLineItem.getVersion() != retailStoreOrderLineItemVersion){
			String message = "The target version("+retailStoreOrderLineItem.getVersion()+") is not equals to version("+retailStoreOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderLineItem){
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.
			
			retailStoreOrderLineItem.changeProperty(property, newValueExpr);
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
			return present(userContext,retailStoreOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
		}

	}

	public RetailStoreOrderLineItem updateRetailStoreOrderLineItemProperty(RetailscmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());
		if(retailStoreOrderLineItem.getVersion() != retailStoreOrderLineItemVersion){
			String message = "The target version("+retailStoreOrderLineItem.getVersion()+") is not equals to version("+retailStoreOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderLineItem){
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.

			retailStoreOrderLineItem.changeProperty(property, newValueExpr);
			
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
			return present(userContext,retailStoreOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderLineItemTokens tokens(){
		return RetailStoreOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderLineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderLineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
 		checkerOf(userContext).checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderLineItemManagerException.class);

 	}
 	public RetailStoreOrderLineItem transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderLineItemId,anotherBizOrderId);
 
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());	
		synchronized(retailStoreOrderLineItem){
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());		
			retailStoreOrderLineItem.updateBizOrder(bizOrder);		
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, emptyOptions());
			
			return present(userContext,retailStoreOrderLineItem, allTokens());
			
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
		SmartList<RetailStoreOrder> candidateList = retailStoreOrderDaoOf(userContext).requestCandidateRetailStoreOrderForRetailStoreOrderLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception{

		retailStoreOrderLineItemDaoOf(userContext).delete(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}

	public RetailStoreOrderLineItem forgetByAll(RetailscmUserContext userContext, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}
	protected RetailStoreOrderLineItem forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception{

		return retailStoreOrderLineItemDaoOf(userContext).disconnectFromAll(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderLineItemDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderLineItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreOrderLineItemDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreOrderLineItem newRetailStoreOrderLineItem = this.createRetailStoreOrderLineItem(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderLineItem
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOrderLineItem.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderLineItem> list) throws Exception {
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
		SmartList<RetailStoreOrderLineItem> list = retailStoreOrderLineItemDaoOf(userContext).findRetailStoreOrderLineItemByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreOrderLineItem.class);
		page.setContainerObject(RetailStoreOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超订单行项目列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreOrderLineItemDetailScope().clone();
		RetailStoreOrderLineItem merchantObj = (RetailStoreOrderLineItem) this.view(userContext, retailStoreOrderLineItemId);
    String merchantObjId = retailStoreOrderLineItemId;
    String linkToUrl =	"retailStoreOrderLineItemManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超订单行项目"+"详情";
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
				MapUtil.put("id", "2-bizOrder")
				    .put("fieldName", "bizOrder")
				    .put("label", "订单")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "3-skuId")
				    .put("fieldName", "skuId")
				    .put("label", "产品ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("skuId", merchantObj.getSkuId());

		propList.add(
				MapUtil.put("id", "4-skuName")
				    .put("fieldName", "skuName")
				    .put("label", "产品名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("skuName", merchantObj.getSkuName());

		propList.add(
				MapUtil.put("id", "5-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		propList.add(
				MapUtil.put("id", "6-quantity")
				    .put("fieldName", "quantity")
				    .put("label", "数量")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("quantity", merchantObj.getQuantity());

		propList.add(
				MapUtil.put("id", "7-unitOfMeasurement")
				    .put("fieldName", "unitOfMeasurement")
				    .put("label", "测量单位")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("unitOfMeasurement", merchantObj.getUnitOfMeasurement());

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


