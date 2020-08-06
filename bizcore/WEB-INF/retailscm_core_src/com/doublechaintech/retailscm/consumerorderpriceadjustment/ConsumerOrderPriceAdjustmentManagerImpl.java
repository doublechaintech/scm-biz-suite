
package com.doublechaintech.retailscm.consumerorderpriceadjustment;

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







public class ConsumerOrderPriceAdjustmentManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderPriceAdjustmentManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "ConsumerOrderPriceAdjustment";
	@Override
	public ConsumerOrderPriceAdjustmentDAO daoOf(RetailscmUserContext userContext) {
		return consumerOrderPriceAdjustmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderPriceAdjustmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderPriceAdjustmentManagerException(message);

	}



 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderPriceAdjustmentDAO().save(consumerOrderPriceAdjustment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens);
 	}
 	
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustmentDetail(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception{	

 		
 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());
 	}
 	
 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}
 	
 	
 	 public ConsumerOrderPriceAdjustment searchConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}
 	
 	

 	protected ConsumerOrderPriceAdjustment present(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderPriceAdjustment,tokens);
		
		
		ConsumerOrderPriceAdjustment  consumerOrderPriceAdjustmentToPresent = consumerOrderPriceAdjustmentDaoOf(userContext).present(consumerOrderPriceAdjustment, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderPriceAdjustmentToPresent.collectRefercencesFromLists();
		consumerOrderPriceAdjustmentDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,consumerOrderPriceAdjustment,tokens);
		
		return  consumerOrderPriceAdjustmentToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustmentDetail(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{	
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, allTokens());
 		return present(userContext,consumerOrderPriceAdjustment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{	
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, viewTokens());
 		return present(userContext,consumerOrderPriceAdjustment, allTokens());
		
 	}
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderPriceAdjustmentDaoOf(userContext).save(consumerOrderPriceAdjustment, tokens);
 	}
 	protected ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);

 
 		return consumerOrderPriceAdjustmentDaoOf(userContext).load(consumerOrderPriceAdjustmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderPriceAdjustment, tokens);
		
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@create","createConsumerOrderPriceAdjustment","createConsumerOrderPriceAdjustment/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@update","updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@copy","cloneConsumerOrderPriceAdjustment","cloneConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"consumer_order_price_adjustment.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount,String provider) throws Exception
	//public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String name, String bizOrderId, BigDecimal amount, String provider) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(name);
		checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(amount);
		checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(provider);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);


		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment=createNewConsumerOrderPriceAdjustment();	

		consumerOrderPriceAdjustment.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderPriceAdjustment.setBizOrder(bizOrder);
		
		
		consumerOrderPriceAdjustment.setAmount(amount);
		consumerOrderPriceAdjustment.setProvider(provider);

		consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderPriceAdjustment);
		return consumerOrderPriceAdjustment;


	}
	protected ConsumerOrderPriceAdjustment createNewConsumerOrderPriceAdjustment()
	{

		return new ConsumerOrderPriceAdjustment();
	}

	protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).checkVersionOfConsumerOrderPriceAdjustment( consumerOrderPriceAdjustmentVersion);
		

		if(ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		
			
		}		

		
		if(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(parseBigDecimal(newValueExpr));
		
			
		}
		if(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);


	}



	public ConsumerOrderPriceAdjustment clone(RetailscmUserContext userContext, String fromConsumerOrderPriceAdjustmentId) throws Exception{

		return consumerOrderPriceAdjustmentDaoOf(userContext).clone(fromConsumerOrderPriceAdjustmentId, this.allTokens());
	}

	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception
	{
		return internalSaveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());

	}
	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			if (consumerOrderPriceAdjustment.isChanged()){
			
			}
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, options);
			return consumerOrderPriceAdjustment;

		}

	}

	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			
			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}

	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustmentProperty(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.

			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderPriceAdjustmentTokens tokens(){
		return ConsumerOrderPriceAdjustmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderPriceAdjustmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderPriceAdjustmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
 		checkerOf(userContext).checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);

 	}
 	public ConsumerOrderPriceAdjustment transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderPriceAdjustmentId,anotherBizOrderId);
 
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());	
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderPriceAdjustment.updateBizOrder(bizOrder);		
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
			
			return present(userContext,consumerOrderPriceAdjustment, allTokens());
			
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
		SmartList<ConsumerOrder> candidateList = consumerOrderDaoOf(userContext).requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{

		consumerOrderPriceAdjustmentDaoOf(userContext).delete(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}

	public ConsumerOrderPriceAdjustment forgetByAll(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	protected ConsumerOrderPriceAdjustment forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{

		return consumerOrderPriceAdjustmentDaoOf(userContext).disconnectFromAll(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderPriceAdjustmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return consumerOrderPriceAdjustmentDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    consumerOrderPriceAdjustmentDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ConsumerOrderPriceAdjustment newConsumerOrderPriceAdjustment = this.createConsumerOrderPriceAdjustment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderPriceAdjustment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrderPriceAdjustment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ConsumerOrderPriceAdjustment> list) throws Exception {
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
		SmartList<ConsumerOrderPriceAdjustment> list = consumerOrderPriceAdjustmentDaoOf(userContext).findConsumerOrderPriceAdjustmentByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ConsumerOrderPriceAdjustment.class);
		page.setContainerObject(ConsumerOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费品价格调整列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getConsumerOrderPriceAdjustmentDetailScope().clone();
		ConsumerOrderPriceAdjustment merchantObj = (ConsumerOrderPriceAdjustment) this.view(userContext, consumerOrderPriceAdjustmentId);
    String merchantObjId = consumerOrderPriceAdjustmentId;
    String linkToUrl =	"consumerOrderPriceAdjustmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费品价格调整"+"详情";
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

		propList.add(
				MapUtil.put("id", "5-provider")
				    .put("fieldName", "provider")
				    .put("label", "供应商")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("provider", merchantObj.getProvider());

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


