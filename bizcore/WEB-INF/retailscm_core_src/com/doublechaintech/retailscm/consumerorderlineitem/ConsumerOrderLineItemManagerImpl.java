
package com.doublechaintech.retailscm.consumerorderlineitem;

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



import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;







public class ConsumerOrderLineItemManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderLineItemManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "ConsumerOrderLineItem";
	@Override
	public ConsumerOrderLineItemDAO daoOf(RetailscmUserContext userContext) {
		return consumerOrderLineItemDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderLineItemManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderLineItemManagerException(message);

	}



 	protected ConsumerOrderLineItem saveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderLineItemDAO().save(consumerOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens);
 	}
 	
 	protected ConsumerOrderLineItem saveConsumerOrderLineItemDetail(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception{	

 		
 		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, allTokens());
 	}
 	
 	public ConsumerOrderLineItem loadConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderLineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderLineItem, tokens);
 	}
 	
 	
 	 public ConsumerOrderLineItem searchConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderLineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderLineItem, tokens);
 	}
 	
 	

 	protected ConsumerOrderLineItem present(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderLineItem,tokens);
		
		
		ConsumerOrderLineItem  consumerOrderLineItemToPresent = consumerOrderLineItemDaoOf(userContext).present(consumerOrderLineItem, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderLineItemToPresent.collectRefercencesFromLists();
		consumerOrderLineItemDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,consumerOrderLineItem,tokens);
		
		return  consumerOrderLineItemToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderLineItem loadConsumerOrderLineItemDetail(RetailscmUserContext userContext, String consumerOrderLineItemId) throws Exception{	
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, allTokens());
 		return present(userContext,consumerOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderLineItemId) throws Exception{	
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, viewTokens());
 		return present(userContext,consumerOrderLineItem, allTokens());
		
 	}
 	protected ConsumerOrderLineItem saveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderLineItemDaoOf(userContext).save(consumerOrderLineItem, tokens);
 	}
 	protected ConsumerOrderLineItem loadConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderLineItemManagerException.class);

 
 		return consumerOrderLineItemDaoOf(userContext).load(consumerOrderLineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderLineItem, tokens);
		
		addAction(userContext, consumerOrderLineItem, tokens,"@create","createConsumerOrderLineItem","createConsumerOrderLineItem/","main","primary");
		addAction(userContext, consumerOrderLineItem, tokens,"@update","updateConsumerOrderLineItem","updateConsumerOrderLineItem/"+consumerOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, consumerOrderLineItem, tokens,"@copy","cloneConsumerOrderLineItem","cloneConsumerOrderLineItem/"+consumerOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderLineItem, tokens,"consumer_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrderLineItem createConsumerOrderLineItem(RetailscmUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal price,BigDecimal quantity,BigDecimal amount) throws Exception
	//public ConsumerOrderLineItem createConsumerOrderLineItem(RetailscmUserContext userContext,String bizOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount) throws Exception
	{

		

		

		checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(skuId);
		checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(skuName);
		checkerOf(userContext).checkPriceOfConsumerOrderLineItem(price);
		checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(quantity);
		checkerOf(userContext).checkAmountOfConsumerOrderLineItem(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderLineItemManagerException.class);


		ConsumerOrderLineItem consumerOrderLineItem=createNewConsumerOrderLineItem();	

			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderLineItem.setBizOrder(bizOrder);
		
		
		consumerOrderLineItem.setSkuId(skuId);
		consumerOrderLineItem.setSkuName(skuName);
		consumerOrderLineItem.setPrice(price);
		consumerOrderLineItem.setQuantity(quantity);
		consumerOrderLineItem.setAmount(amount);
		consumerOrderLineItem.setLastUpdateTime(userContext.now());

		consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderLineItem);
		return consumerOrderLineItem;


	}
	protected ConsumerOrderLineItem createNewConsumerOrderLineItem()
	{

		return new ConsumerOrderLineItem();
	}

	protected void checkParamsForUpdatingConsumerOrderLineItem(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).checkVersionOfConsumerOrderLineItem( consumerOrderLineItemVersion);
		
		

		
		if(ConsumerOrderLineItem.SKU_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(parseString(newValueExpr));
		
			
		}
		if(ConsumerOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(parseString(newValueExpr));
		
			
		}
		if(ConsumerOrderLineItem.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		
			
		}
		if(ConsumerOrderLineItem.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		
			
		}
		if(ConsumerOrderLineItem.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderLineItemManagerException.class);


	}



	public ConsumerOrderLineItem clone(RetailscmUserContext userContext, String fromConsumerOrderLineItemId) throws Exception{

		return consumerOrderLineItemDaoOf(userContext).clone(fromConsumerOrderLineItemId, this.allTokens());
	}

	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception
	{
		return internalSaveConsumerOrderLineItem(userContext, consumerOrderLineItem, allTokens());

	}
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderLineItem){
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.
			if (consumerOrderLineItem.isChanged()){
			consumerOrderLineItem.updateLastUpdateTime(userContext.now());
			}
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, options);
			return consumerOrderLineItem;

		}

	}

	public ConsumerOrderLineItem updateConsumerOrderLineItem(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());
		if(consumerOrderLineItem.getVersion() != consumerOrderLineItemVersion){
			String message = "The target version("+consumerOrderLineItem.getVersion()+") is not equals to version("+consumerOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderLineItem){
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.
			consumerOrderLineItem.updateLastUpdateTime(userContext.now());
			consumerOrderLineItem.changeProperty(property, newValueExpr);
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
			return present(userContext,consumerOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
		}

	}

	public ConsumerOrderLineItem updateConsumerOrderLineItemProperty(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());
		if(consumerOrderLineItem.getVersion() != consumerOrderLineItemVersion){
			String message = "The target version("+consumerOrderLineItem.getVersion()+") is not equals to version("+consumerOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderLineItem){
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.

			consumerOrderLineItem.changeProperty(property, newValueExpr);
			consumerOrderLineItem.updateLastUpdateTime(userContext.now());
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
			return present(userContext,consumerOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderLineItemTokens tokens(){
		return ConsumerOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderLineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderLineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
 		checkerOf(userContext).checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderLineItemManagerException.class);

 	}
 	public ConsumerOrderLineItem transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderLineItemId,anotherBizOrderId);
 
		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());	
		synchronized(consumerOrderLineItem){
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderLineItem.updateBizOrder(bizOrder);		
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, emptyOptions());
			
			return present(userContext,consumerOrderLineItem, allTokens());
			
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
		SmartList<ConsumerOrder> candidateList = consumerOrderDaoOf(userContext).requestCandidateConsumerOrderForConsumerOrderLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception{

		consumerOrderLineItemDaoOf(userContext).delete(consumerOrderLineItemId, consumerOrderLineItemVersion);
	}

	public ConsumerOrderLineItem forgetByAll(RetailscmUserContext userContext, String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion);
	}
	protected ConsumerOrderLineItem forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception{

		return consumerOrderLineItemDaoOf(userContext).disconnectFromAll(consumerOrderLineItemId, consumerOrderLineItemVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return consumerOrderLineItemDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderLineItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    consumerOrderLineItemDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ConsumerOrderLineItem newConsumerOrderLineItem = this.createConsumerOrderLineItem(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderLineItem
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrderLineItem.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ConsumerOrderLineItem> list) throws Exception {
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
		SmartList<ConsumerOrderLineItem> list = consumerOrderLineItemDaoOf(userContext).findConsumerOrderLineItemByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ConsumerOrderLineItem.class);
		page.setContainerObject(ConsumerOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单行项目列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String consumerOrderLineItemId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getConsumerOrderLineItemDetailScope().clone();
		ConsumerOrderLineItem merchantObj = (ConsumerOrderLineItem) this.view(userContext, consumerOrderLineItemId);
    String merchantObjId = consumerOrderLineItemId;
    String linkToUrl =	"consumerOrderLineItemManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费者订单行项目"+"详情";
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
				    .put("linkToUrl", "consumerOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
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
				MapUtil.put("id", "5-price")
				    .put("fieldName", "price")
				    .put("label", "价格")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("price", merchantObj.getPrice());

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
				MapUtil.put("id", "7-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		propList.add(
				MapUtil.put("id", "8-lastUpdateTime")
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


