
package com.doublechaintech.retailscm.eventattendance;

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



import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;

import com.doublechaintech.retailscm.potentialcustomer.CandidatePotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CandidateCityEvent;







public class EventAttendanceManagerImpl extends CustomRetailscmCheckerManager implements EventAttendanceManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EventAttendance";
	@Override
	public EventAttendanceDAO daoOf(RetailscmUserContext userContext) {
		return eventAttendanceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EventAttendanceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EventAttendanceManagerException(message);

	}



 	protected EventAttendance saveEventAttendance(RetailscmUserContext userContext, EventAttendance eventAttendance, String [] tokensExpr) throws Exception{	
 		//return getEventAttendanceDAO().save(eventAttendance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEventAttendance(userContext, eventAttendance, tokens);
 	}
 	
 	protected EventAttendance saveEventAttendanceDetail(RetailscmUserContext userContext, EventAttendance eventAttendance) throws Exception{	

 		
 		return saveEventAttendance(userContext, eventAttendance, allTokens());
 	}
 	
 	public EventAttendance loadEventAttendance(RetailscmUserContext userContext, String eventAttendanceId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( EventAttendanceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,eventAttendance, tokens);
 	}
 	
 	
 	 public EventAttendance searchEventAttendance(RetailscmUserContext userContext, String eventAttendanceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( EventAttendanceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,eventAttendance, tokens);
 	}
 	
 	

 	protected EventAttendance present(RetailscmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,eventAttendance,tokens);
		
		
		EventAttendance  eventAttendanceToPresent = eventAttendanceDaoOf(userContext).present(eventAttendance, tokens);
		
		List<BaseEntity> entityListToNaming = eventAttendanceToPresent.collectRefercencesFromLists();
		eventAttendanceDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,eventAttendance,tokens);
		
		return  eventAttendanceToPresent;
		
		
	}
 
 	
 	
 	public EventAttendance loadEventAttendanceDetail(RetailscmUserContext userContext, String eventAttendanceId) throws Exception{	
 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, allTokens());
 		return present(userContext,eventAttendance, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String eventAttendanceId) throws Exception{	
 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, viewTokens());
 		return present(userContext,eventAttendance, allTokens());
		
 	}
 	protected EventAttendance saveEventAttendance(RetailscmUserContext userContext, EventAttendance eventAttendance, Map<String,Object>tokens) throws Exception{	
 		return eventAttendanceDaoOf(userContext).save(eventAttendance, tokens);
 	}
 	protected EventAttendance loadEventAttendance(RetailscmUserContext userContext, String eventAttendanceId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( EventAttendanceManagerException.class);

 
 		return eventAttendanceDaoOf(userContext).load(eventAttendanceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> tokens){
		super.addActions(userContext, eventAttendance, tokens);
		
		addAction(userContext, eventAttendance, tokens,"@create","createEventAttendance","createEventAttendance/","main","primary");
		addAction(userContext, eventAttendance, tokens,"@update","updateEventAttendance","updateEventAttendance/"+eventAttendance.getId()+"/","main","primary");
		addAction(userContext, eventAttendance, tokens,"@copy","cloneEventAttendance","cloneEventAttendance/"+eventAttendance.getId()+"/","main","primary");
		
		addAction(userContext, eventAttendance, tokens,"event_attendance.transfer_to_potential_customer","transferToAnotherPotentialCustomer","transferToAnotherPotentialCustomer/"+eventAttendance.getId()+"/","main","primary");
		addAction(userContext, eventAttendance, tokens,"event_attendance.transfer_to_city_event","transferToAnotherCityEvent","transferToAnotherCityEvent/"+eventAttendance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EventAttendance createEventAttendance(RetailscmUserContext userContext, String name,String potentialCustomerId,String cityEventId,String description) throws Exception
	//public EventAttendance createEventAttendance(RetailscmUserContext userContext,String name, String potentialCustomerId, String cityEventId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfEventAttendance(name);
		checkerOf(userContext).checkDescriptionOfEventAttendance(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EventAttendanceManagerException.class);


		EventAttendance eventAttendance=createNewEventAttendance();	

		eventAttendance.setName(name);
			
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId,emptyOptions());
		eventAttendance.setPotentialCustomer(potentialCustomer);
		
		
			
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId,emptyOptions());
		eventAttendance.setCityEvent(cityEvent);
		
		
		eventAttendance.setDescription(description);

		eventAttendance = saveEventAttendance(userContext, eventAttendance, emptyOptions());
		
		onNewInstanceCreated(userContext, eventAttendance);
		return eventAttendance;


	}
	protected EventAttendance createNewEventAttendance()
	{

		return new EventAttendance();
	}

	protected void checkParamsForUpdatingEventAttendance(RetailscmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).checkVersionOfEventAttendance( eventAttendanceVersion);
		

		if(EventAttendance.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfEventAttendance(parseString(newValueExpr));
		
			
		}		

				

		
		if(EventAttendance.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfEventAttendance(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EventAttendanceManagerException.class);


	}



	public EventAttendance clone(RetailscmUserContext userContext, String fromEventAttendanceId) throws Exception{

		return eventAttendanceDaoOf(userContext).clone(fromEventAttendanceId, this.allTokens());
	}

	public EventAttendance internalSaveEventAttendance(RetailscmUserContext userContext, EventAttendance eventAttendance) throws Exception
	{
		return internalSaveEventAttendance(userContext, eventAttendance, allTokens());

	}
	public EventAttendance internalSaveEventAttendance(RetailscmUserContext userContext, EventAttendance eventAttendance, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEventAttendance(userContext, eventAttendanceId, eventAttendanceVersion, property, newValueExpr, tokensExpr);


		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EventAttendance.
			if (eventAttendance.isChanged()){
			
			}
			eventAttendance = saveEventAttendance(userContext, eventAttendance, options);
			return eventAttendance;

		}

	}

	public EventAttendance updateEventAttendance(RetailscmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEventAttendance(userContext, eventAttendanceId, eventAttendanceVersion, property, newValueExpr, tokensExpr);



		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());
		if(eventAttendance.getVersion() != eventAttendanceVersion){
			String message = "The target version("+eventAttendance.getVersion()+") is not equals to version("+eventAttendanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EventAttendance.
			
			eventAttendance.changeProperty(property, newValueExpr);
			eventAttendance = saveEventAttendance(userContext, eventAttendance, tokens().done());
			return present(userContext,eventAttendance, mergedAllTokens(tokensExpr));
			//return saveEventAttendance(userContext, eventAttendance, tokens().done());
		}

	}

	public EventAttendance updateEventAttendanceProperty(RetailscmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEventAttendance(userContext, eventAttendanceId, eventAttendanceVersion, property, newValueExpr, tokensExpr);

		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());
		if(eventAttendance.getVersion() != eventAttendanceVersion){
			String message = "The target version("+eventAttendance.getVersion()+") is not equals to version("+eventAttendanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EventAttendance.

			eventAttendance.changeProperty(property, newValueExpr);
			
			eventAttendance = saveEventAttendance(userContext, eventAttendance, tokens().done());
			return present(userContext,eventAttendance, mergedAllTokens(tokensExpr));
			//return saveEventAttendance(userContext, eventAttendance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EventAttendanceTokens tokens(){
		return EventAttendanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EventAttendanceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EventAttendanceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailscmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
 		checkerOf(userContext).checkIdOfPotentialCustomer(anotherPotentialCustomerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EventAttendanceManagerException.class);

 	}
 	public EventAttendance transferToAnotherPotentialCustomer(RetailscmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId) throws Exception
 	{
 		checkParamsForTransferingAnotherPotentialCustomer(userContext, eventAttendanceId,anotherPotentialCustomerId);
 
		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());	
		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, anotherPotentialCustomerId, emptyOptions());		
			eventAttendance.updatePotentialCustomer(potentialCustomer);		
			eventAttendance = saveEventAttendance(userContext, eventAttendance, emptyOptions());
			
			return present(userContext,eventAttendance, allTokens());
			
		}

 	}

	


	public CandidatePotentialCustomer requestCandidatePotentialCustomer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePotentialCustomer result = new CandidatePotentialCustomer();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PotentialCustomer> candidateList = potentialCustomerDaoOf(userContext).requestCandidatePotentialCustomerForEventAttendance(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCityEvent(RetailscmUserContext userContext, String eventAttendanceId, String anotherCityEventId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
 		checkerOf(userContext).checkIdOfCityEvent(anotherCityEventId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EventAttendanceManagerException.class);

 	}
 	public EventAttendance transferToAnotherCityEvent(RetailscmUserContext userContext, String eventAttendanceId, String anotherCityEventId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityEvent(userContext, eventAttendanceId,anotherCityEventId);
 
		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());	
		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CityEvent cityEvent = loadCityEvent(userContext, anotherCityEventId, emptyOptions());		
			eventAttendance.updateCityEvent(cityEvent);		
			eventAttendance = saveEventAttendance(userContext, eventAttendance, emptyOptions());
			
			return present(userContext,eventAttendance, allTokens());
			
		}

 	}

	


	public CandidateCityEvent requestCandidateCityEvent(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCityEvent result = new CandidateCityEvent();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CityEvent> candidateList = cityEventDaoOf(userContext).requestCandidateCityEventForEventAttendance(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected PotentialCustomer loadPotentialCustomer(RetailscmUserContext userContext, String newPotentialCustomerId, Map<String,Object> options) throws Exception
 	{

 		return potentialCustomerDaoOf(userContext).load(newPotentialCustomerId, options);
 	}
 	


	

 	protected CityEvent loadCityEvent(RetailscmUserContext userContext, String newCityEventId, Map<String,Object> options) throws Exception
 	{

 		return cityEventDaoOf(userContext).load(newCityEventId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String eventAttendanceId, int eventAttendanceVersion) throws Exception {
		//deleteInternal(userContext, eventAttendanceId, eventAttendanceVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String eventAttendanceId, int eventAttendanceVersion) throws Exception{

		eventAttendanceDaoOf(userContext).delete(eventAttendanceId, eventAttendanceVersion);
	}

	public EventAttendance forgetByAll(RetailscmUserContext userContext, String eventAttendanceId, int eventAttendanceVersion) throws Exception {
		return forgetByAllInternal(userContext, eventAttendanceId, eventAttendanceVersion);
	}
	protected EventAttendance forgetByAllInternal(RetailscmUserContext userContext,
			String eventAttendanceId, int eventAttendanceVersion) throws Exception{

		return eventAttendanceDaoOf(userContext).disconnectFromAll(eventAttendanceId, eventAttendanceVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EventAttendanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return eventAttendanceDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, EventAttendance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    eventAttendanceDaoOf(ctx).loadAllAsStream().forEach(
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
		//   EventAttendance newEventAttendance = this.createEventAttendance(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEventAttendance
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EventAttendance.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EventAttendance> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<PotentialCustomer> potentialCustomerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PotentialCustomer.class);
		userContext.getDAOGroup().enhanceList(potentialCustomerList, PotentialCustomer.class);
		List<CityEvent> cityEventList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, CityEvent.class);
		userContext.getDAOGroup().enhanceList(cityEventList, CityEvent.class);


    }
	
	public Object listByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId) throws Exception {
		return listPageByPotentialCustomer(userContext, potentialCustomerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId, int start, int count) throws Exception {
		SmartList<EventAttendance> list = eventAttendanceDaoOf(userContext).findEventAttendanceByPotentialCustomer(potentialCustomerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EventAttendance.class);
		page.setContainerObject(PotentialCustomer.withId(potentialCustomerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("活动的参与情况列表");
		page.setRequestName("listByPotentialCustomer");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPotentialCustomer/%s/",  getBeanName(), potentialCustomerId)));

		page.assemblerContent(userContext, "listByPotentialCustomer");
		return page.doRender(userContext);
	}
  
	public Object listByCityEvent(RetailscmUserContext userContext,String cityEventId) throws Exception {
		return listPageByCityEvent(userContext, cityEventId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityEvent(RetailscmUserContext userContext,String cityEventId, int start, int count) throws Exception {
		SmartList<EventAttendance> list = eventAttendanceDaoOf(userContext).findEventAttendanceByCityEvent(cityEventId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EventAttendance.class);
		page.setContainerObject(CityEvent.withId(cityEventId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("活动的参与情况列表");
		page.setRequestName("listByCityEvent");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityEvent/%s/",  getBeanName(), cityEventId)));

		page.assemblerContent(userContext, "listByCityEvent");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String eventAttendanceId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getEventAttendanceDetailScope().clone();
		EventAttendance merchantObj = (EventAttendance) this.view(userContext, eventAttendanceId);
    String merchantObjId = eventAttendanceId;
    String linkToUrl =	"eventAttendanceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "活动的参与情况"+"详情";
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
				MapUtil.put("id", "3-potentialCustomer")
				    .put("fieldName", "potentialCustomer")
				    .put("label", "潜在的客户")
				    .put("type", "auto")
				    .put("linkToUrl", "potentialCustomerManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("potentialCustomer", merchantObj.getPotentialCustomer());

		propList.add(
				MapUtil.put("id", "4-cityEvent")
				    .put("fieldName", "cityEvent")
				    .put("label", "城市活动")
				    .put("type", "auto")
				    .put("linkToUrl", "cityEventManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityEvent", merchantObj.getCityEvent());

		propList.add(
				MapUtil.put("id", "5-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

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


