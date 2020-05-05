
package com.doublechaintech.retailscm.transporttasktrack;

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


import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transporttask.CandidateTransportTask;







public class TransportTaskTrackManagerImpl extends CustomRetailscmCheckerManager implements TransportTaskTrackManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "TransportTaskTrack";
	@Override
	public TransportTaskTrackDAO daoOf(RetailscmUserContext userContext) {
		return transportTaskTrackDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws TransportTaskTrackManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TransportTaskTrackManagerException(message);

	}



 	protected TransportTaskTrack saveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, tokens);
 	}
 	
 	protected TransportTaskTrack saveTransportTaskTrackDetail(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception{	

 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, allTokens());
 	}
 	
 	public TransportTaskTrack loadTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	
 	 public TransportTaskTrack searchTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	

 	protected TransportTaskTrack present(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTaskTrack,tokens);
		
		
		TransportTaskTrack  transportTaskTrackToPresent = transportTaskTrackDaoOf(userContext).present(transportTaskTrack, tokens);
		
		List<BaseEntity> entityListToNaming = transportTaskTrackToPresent.collectRefercencesFromLists();
		transportTaskTrackDaoOf(userContext).alias(entityListToNaming);
		
		return  transportTaskTrackToPresent;
		
		
	}
 
 	
 	
 	public TransportTaskTrack loadTransportTaskTrackDetail(RetailscmUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, allTokens());
 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, viewTokens());
 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	protected TransportTaskTrack saveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object>tokens) throws Exception{	
 		return transportTaskTrackDaoOf(userContext).save(transportTaskTrack, tokens);
 	}
 	protected TransportTaskTrack loadTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 
 		return transportTaskTrackDaoOf(userContext).load(transportTaskTrackId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
		super.addActions(userContext, transportTaskTrack, tokens);
		
		addAction(userContext, transportTaskTrack, tokens,"@create","createTransportTaskTrack","createTransportTaskTrack/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@update","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@copy","cloneTransportTaskTrack","cloneTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		
		addAction(userContext, transportTaskTrack, tokens,"transport_task_track.transfer_to_movement","transferToAnotherMovement","transferToAnotherMovement/"+transportTaskTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TransportTaskTrack createTransportTaskTrack(RetailscmUserContext userContext, Date trackTime,BigDecimal latitude,BigDecimal longitude,String movementId) throws Exception
	//public TransportTaskTrack createTransportTaskTrack(RetailscmUserContext userContext,Date trackTime, BigDecimal latitude, BigDecimal longitude, String movementId) throws Exception
	{

		

		

		checkerOf(userContext).checkTrackTimeOfTransportTaskTrack(trackTime);
		checkerOf(userContext).checkLatitudeOfTransportTaskTrack(latitude);
		checkerOf(userContext).checkLongitudeOfTransportTaskTrack(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);


		TransportTaskTrack transportTaskTrack=createNewTransportTaskTrack();	

		transportTaskTrack.setTrackTime(trackTime);
		transportTaskTrack.setLatitude(latitude);
		transportTaskTrack.setLongitude(longitude);
			
		TransportTask movement = loadTransportTask(userContext, movementId,emptyOptions());
		transportTaskTrack.setMovement(movement);
		
		

		transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTaskTrack);
		return transportTaskTrack;


	}
	protected TransportTaskTrack createNewTransportTaskTrack()
	{

		return new TransportTaskTrack();
	}

	protected void checkParamsForUpdatingTransportTaskTrack(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).checkVersionOfTransportTaskTrack( transportTaskTrackVersion);
		

		if(TransportTaskTrack.TRACK_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTrackTimeOfTransportTaskTrack(parseDate(newValueExpr));
		
			
		}
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		
			
		}
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);


	}



	public TransportTaskTrack clone(RetailscmUserContext userContext, String fromTransportTaskTrackId) throws Exception{

		return transportTaskTrackDaoOf(userContext).clone(fromTransportTaskTrackId, this.allTokens());
	}

	public TransportTaskTrack internalSaveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception
	{
		return internalSaveTransportTaskTrack(userContext, transportTaskTrack, allTokens());

	}
	public TransportTaskTrack internalSaveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);


		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			if (transportTaskTrack.isChanged()){
			
			}
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, options);
			return transportTaskTrack;

		}

	}

	public TransportTaskTrack updateTransportTaskTrack(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);



		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			transportTaskTrack.changeProperty(property, newValueExpr);
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}

	public TransportTaskTrack updateTransportTaskTrackProperty(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);

		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.

			transportTaskTrack.changeProperty(property, newValueExpr);
			
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TransportTaskTrackTokens tokens(){
		return TransportTaskTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTrackTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTrackTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherMovement(RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
 		checkerOf(userContext).checkIdOfTransportTask(anotherMovementId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);

 	}
 	public TransportTaskTrack transferToAnotherMovement(RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId) throws Exception
 	{
 		checkParamsForTransferingAnotherMovement(userContext, transportTaskTrackId,anotherMovementId);
 
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());	
		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTask movement = loadTransportTask(userContext, anotherMovementId, emptyOptions());		
			transportTaskTrack.updateMovement(movement);		
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
			
			return present(userContext,transportTaskTrack, allTokens());
			
		}

 	}

	


	public CandidateTransportTask requestCandidateMovement(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportTask result = new CandidateTransportTask();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportTask> candidateList = transportTaskDaoOf(userContext).requestCandidateTransportTaskForTransportTaskTrack(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected TransportTask loadTransportTask(RetailscmUserContext userContext, String newMovementId, Map<String,Object> options) throws Exception
 	{

 		return transportTaskDaoOf(userContext).load(newMovementId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		//deleteInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{

		transportTaskTrackDaoOf(userContext).delete(transportTaskTrackId, transportTaskTrackVersion);
	}

	public TransportTaskTrack forgetByAll(RetailscmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);
	}
	protected TransportTaskTrack forgetByAllInternal(RetailscmUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{

		return transportTaskTrackDaoOf(userContext).disconnectFromAll(transportTaskTrackId, transportTaskTrackVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return transportTaskTrackDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTaskTrack newCreated) throws Exception{
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
		//   TransportTaskTrack newTransportTaskTrack = this.createTransportTaskTrack(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTransportTaskTrack
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TransportTaskTrack.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TransportTaskTrack> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<TransportTask> movementList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportTask.class);
		userContext.getDAOGroup().enhanceList(movementList, TransportTask.class);


    }
	
	public Object listByMovement(RetailscmUserContext userContext,String movementId) throws Exception {
		return listPageByMovement(userContext, movementId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByMovement(RetailscmUserContext userContext,String movementId, int start, int count) throws Exception {
		SmartList<TransportTaskTrack> list = transportTaskTrackDaoOf(userContext).findTransportTaskTrackByMovement(movementId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportTaskTrack.class);
		page.setContainerObject(TransportTask.withId(movementId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输任务跟踪列表");
		page.setRequestName("listByMovement");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByMovement/%s/",  getBeanName(), movementId)));

		page.assemblerContent(userContext, "listByMovement");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String transportTaskTrackId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getTransportTaskTrackDetailScope().clone();
		TransportTaskTrack merchantObj = (TransportTaskTrack) this.view(userContext, transportTaskTrackId);
    String merchantObjId = transportTaskTrackId;
    String linkToUrl =	"transportTaskTrackManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "运输任务跟踪"+"详情";
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
				MapUtil.put("id", "2-trackTime")
				    .put("fieldName", "trackTime")
				    .put("label", "跟踪时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("trackTime", merchantObj.getTrackTime());

		propList.add(
				MapUtil.put("id", "3-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "4-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "5-movement")
				    .put("fieldName", "movement")
				    .put("label", "运动")
				    .put("type", "auto")
				    .put("linkToUrl", "transportTaskManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"start\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("movement", merchantObj.getMovement());

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


