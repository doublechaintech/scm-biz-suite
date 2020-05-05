
package com.doublechaintech.retailscm.stockcountissuetrack;

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


import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.doublechaintech.retailscm.goodsshelfstockcount.CandidateGoodsShelfStockCount;







public class StockCountIssueTrackManagerImpl extends CustomRetailscmCheckerManager implements StockCountIssueTrackManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "StockCountIssueTrack";
	@Override
	public StockCountIssueTrackDAO daoOf(RetailscmUserContext userContext) {
		return stockCountIssueTrackDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws StockCountIssueTrackManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new StockCountIssueTrackManagerException(message);

	}



 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, String [] tokensExpr) throws Exception{	
 		//return getStockCountIssueTrackDAO().save(stockCountIssueTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens);
 	}
 	
 	protected StockCountIssueTrack saveStockCountIssueTrackDetail(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception{	

 		
 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());
 	}
 	
 	public StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}
 	
 	
 	 public StockCountIssueTrack searchStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}
 	
 	

 	protected StockCountIssueTrack present(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,stockCountIssueTrack,tokens);
		
		
		StockCountIssueTrack  stockCountIssueTrackToPresent = stockCountIssueTrackDaoOf(userContext).present(stockCountIssueTrack, tokens);
		
		List<BaseEntity> entityListToNaming = stockCountIssueTrackToPresent.collectRefercencesFromLists();
		stockCountIssueTrackDaoOf(userContext).alias(entityListToNaming);
		
		return  stockCountIssueTrackToPresent;
		
		
	}
 
 	
 	
 	public StockCountIssueTrack loadStockCountIssueTrackDetail(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{	
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, allTokens());
 		return present(userContext,stockCountIssueTrack, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{	
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, viewTokens());
 		return present(userContext,stockCountIssueTrack, allTokens());
		
 	}
 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object>tokens) throws Exception{	
 		return stockCountIssueTrackDaoOf(userContext).save(stockCountIssueTrack, tokens);
 	}
 	protected StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);

 
 		return stockCountIssueTrackDaoOf(userContext).load(stockCountIssueTrackId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
		super.addActions(userContext, stockCountIssueTrack, tokens);
		
		addAction(userContext, stockCountIssueTrack, tokens,"@create","createStockCountIssueTrack","createStockCountIssueTrack/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@update","updateStockCountIssueTrack","updateStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@copy","cloneStockCountIssueTrack","cloneStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		
		addAction(userContext, stockCountIssueTrack, tokens,"stock_count_issue_track.transfer_to_stock_count","transferToAnotherStockCount","transferToAnotherStockCount/"+stockCountIssueTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext, String title,Date countTime,String summary,String stockCountId) throws Exception
	//public StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext,String title, Date countTime, String summary, String stockCountId) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfStockCountIssueTrack(title);
		checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(countTime);
		checkerOf(userContext).checkSummaryOfStockCountIssueTrack(summary);
	
		checkerOf(userContext).throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);


		StockCountIssueTrack stockCountIssueTrack=createNewStockCountIssueTrack();	

		stockCountIssueTrack.setTitle(title);
		stockCountIssueTrack.setCountTime(countTime);
		stockCountIssueTrack.setSummary(summary);
			
		GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(userContext, stockCountId,emptyOptions());
		stockCountIssueTrack.setStockCount(stockCount);
		
		

		stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
		
		onNewInstanceCreated(userContext, stockCountIssueTrack);
		return stockCountIssueTrack;


	}
	protected StockCountIssueTrack createNewStockCountIssueTrack()
	{

		return new StockCountIssueTrack();
	}

	protected void checkParamsForUpdatingStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).checkVersionOfStockCountIssueTrack( stockCountIssueTrackVersion);
		

		if(StockCountIssueTrack.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfStockCountIssueTrack(parseString(newValueExpr));
		
			
		}
		if(StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(parseDate(newValueExpr));
		
			
		}
		if(StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSummaryOfStockCountIssueTrack(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);


	}



	public StockCountIssueTrack clone(RetailscmUserContext userContext, String fromStockCountIssueTrackId) throws Exception{

		return stockCountIssueTrackDaoOf(userContext).clone(fromStockCountIssueTrackId, this.allTokens());
	}

	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception
	{
		return internalSaveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());

	}
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);


		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			if (stockCountIssueTrack.isChanged()){
			
			}
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, options);
			return stockCountIssueTrack;

		}

	}

	public StockCountIssueTrack updateStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);



		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			
			stockCountIssueTrack.changeProperty(property, newValueExpr);
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}

	public StockCountIssueTrack updateStockCountIssueTrackProperty(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);

		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.

			stockCountIssueTrack.changeProperty(property, newValueExpr);
			
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected StockCountIssueTrackTokens tokens(){
		return StockCountIssueTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StockCountIssueTrackTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StockCountIssueTrackTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
 		checkerOf(userContext).checkIdOfGoodsShelfStockCount(anotherStockCountId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);

 	}
 	public StockCountIssueTrack transferToAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{
 		checkParamsForTransferingAnotherStockCount(userContext, stockCountIssueTrackId,anotherStockCountId);
 
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());	
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(userContext, anotherStockCountId, emptyOptions());		
			stockCountIssueTrack.updateStockCount(stockCount);		
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
			
			return present(userContext,stockCountIssueTrack, allTokens());
			
		}

 	}

	


	public CandidateGoodsShelfStockCount requestCandidateStockCount(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsShelfStockCount result = new CandidateGoodsShelfStockCount();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsShelfStockCount> candidateList = goodsShelfStockCountDaoOf(userContext).requestCandidateGoodsShelfStockCountForStockCountIssueTrack(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GoodsShelfStockCount loadGoodsShelfStockCount(RetailscmUserContext userContext, String newStockCountId, Map<String,Object> options) throws Exception
 	{

 		return goodsShelfStockCountDaoOf(userContext).load(newStockCountId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		//deleteInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{

		stockCountIssueTrackDaoOf(userContext).delete(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}

	public StockCountIssueTrack forgetByAll(RetailscmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		return forgetByAllInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	protected StockCountIssueTrack forgetByAllInternal(RetailscmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{

		return stockCountIssueTrackDaoOf(userContext).disconnectFromAll(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StockCountIssueTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return stockCountIssueTrackDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, StockCountIssueTrack newCreated) throws Exception{
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
		//   StockCountIssueTrack newStockCountIssueTrack = this.createStockCountIssueTrack(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newStockCountIssueTrack
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, StockCountIssueTrack.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<StockCountIssueTrack> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GoodsShelfStockCount> stockCountList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsShelfStockCount.class);
		userContext.getDAOGroup().enhanceList(stockCountList, GoodsShelfStockCount.class);


    }
	
	public Object listByStockCount(RetailscmUserContext userContext,String stockCountId) throws Exception {
		return listPageByStockCount(userContext, stockCountId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByStockCount(RetailscmUserContext userContext,String stockCountId, int start, int count) throws Exception {
		SmartList<StockCountIssueTrack> list = stockCountIssueTrackDaoOf(userContext).findStockCountIssueTrackByStockCount(stockCountId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(StockCountIssueTrack.class);
		page.setContainerObject(GoodsShelfStockCount.withId(stockCountId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("库存计数问题跟踪列表");
		page.setRequestName("listByStockCount");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByStockCount/%s/",  getBeanName(), stockCountId)));

		page.assemblerContent(userContext, "listByStockCount");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getStockCountIssueTrackDetailScope().clone();
		StockCountIssueTrack merchantObj = (StockCountIssueTrack) this.view(userContext, stockCountIssueTrackId);
    String merchantObjId = stockCountIssueTrackId;
    String linkToUrl =	"stockCountIssueTrackManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "库存计数问题跟踪"+"详情";
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
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "头衔")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-countTime")
				    .put("fieldName", "countTime")
				    .put("label", "计数时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("countTime", merchantObj.getCountTime());

		propList.add(
				MapUtil.put("id", "4-summary")
				    .put("fieldName", "summary")
				    .put("label", "概览")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("summary", merchantObj.getSummary());

		propList.add(
				MapUtil.put("id", "5-stockCount")
				    .put("fieldName", "stockCount")
				    .put("label", "盘点")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsShelfStockCountManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"summary\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("stockCount", merchantObj.getStockCount());

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


