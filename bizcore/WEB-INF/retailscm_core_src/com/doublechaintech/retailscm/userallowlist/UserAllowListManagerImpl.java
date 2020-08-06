
package com.doublechaintech.retailscm.userallowlist;

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



import com.doublechaintech.retailscm.userdomain.UserDomain;

import com.doublechaintech.retailscm.userdomain.CandidateUserDomain;







public class UserAllowListManagerImpl extends CustomRetailscmCheckerManager implements UserAllowListManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "UserAllowList";
	@Override
	public UserAllowListDAO daoOf(RetailscmUserContext userContext) {
		return userAllowListDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws UserAllowListManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new UserAllowListManagerException(message);

	}



 	protected UserAllowList saveUserAllowList(RetailscmUserContext userContext, UserAllowList userAllowList, String [] tokensExpr) throws Exception{	
 		//return getUserAllowListDAO().save(userAllowList, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserAllowList(userContext, userAllowList, tokens);
 	}
 	
 	protected UserAllowList saveUserAllowListDetail(RetailscmUserContext userContext, UserAllowList userAllowList) throws Exception{	

 		
 		return saveUserAllowList(userContext, userAllowList, allTokens());
 	}
 	
 	public UserAllowList loadUserAllowList(RetailscmUserContext userContext, String userAllowListId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAllowListManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserAllowList userAllowList = loadUserAllowList( userContext, userAllowListId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userAllowList, tokens);
 	}
 	
 	
 	 public UserAllowList searchUserAllowList(RetailscmUserContext userContext, String userAllowListId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAllowListManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		UserAllowList userAllowList = loadUserAllowList( userContext, userAllowListId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userAllowList, tokens);
 	}
 	
 	

 	protected UserAllowList present(RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userAllowList,tokens);
		
		
		UserAllowList  userAllowListToPresent = userAllowListDaoOf(userContext).present(userAllowList, tokens);
		
		List<BaseEntity> entityListToNaming = userAllowListToPresent.collectRefercencesFromLists();
		userAllowListDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,userAllowList,tokens);
		
		return  userAllowListToPresent;
		
		
	}
 
 	
 	
 	public UserAllowList loadUserAllowListDetail(RetailscmUserContext userContext, String userAllowListId) throws Exception{	
 		UserAllowList userAllowList = loadUserAllowList( userContext, userAllowListId, allTokens());
 		return present(userContext,userAllowList, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String userAllowListId) throws Exception{	
 		UserAllowList userAllowList = loadUserAllowList( userContext, userAllowListId, viewTokens());
 		return present(userContext,userAllowList, allTokens());
		
 	}
 	protected UserAllowList saveUserAllowList(RetailscmUserContext userContext, UserAllowList userAllowList, Map<String,Object>tokens) throws Exception{	
 		return userAllowListDaoOf(userContext).save(userAllowList, tokens);
 	}
 	protected UserAllowList loadUserAllowList(RetailscmUserContext userContext, String userAllowListId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAllowListManagerException.class);

 
 		return userAllowListDaoOf(userContext).load(userAllowListId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> tokens){
		super.addActions(userContext, userAllowList, tokens);
		
		addAction(userContext, userAllowList, tokens,"@create","createUserAllowList","createUserAllowList/","main","primary");
		addAction(userContext, userAllowList, tokens,"@update","updateUserAllowList","updateUserAllowList/"+userAllowList.getId()+"/","main","primary");
		addAction(userContext, userAllowList, tokens,"@copy","cloneUserAllowList","cloneUserAllowList/"+userAllowList.getId()+"/","main","primary");
		
		addAction(userContext, userAllowList, tokens,"user_allow_list.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+userAllowList.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public UserAllowList createUserAllowList(RetailscmUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception
	//public UserAllowList createUserAllowList(RetailscmUserContext userContext,String userIdentity, String userSpecialFunctions, String domainId) throws Exception
	{

		

		

		checkerOf(userContext).checkUserIdentityOfUserAllowList(userIdentity);
		checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList(userSpecialFunctions);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);


		UserAllowList userAllowList=createNewUserAllowList();	

		userAllowList.setUserIdentity(userIdentity);
		userAllowList.setUserSpecialFunctions(userSpecialFunctions);
			
		UserDomain domain = loadUserDomain(userContext, domainId,emptyOptions());
		userAllowList.setDomain(domain);
		
		

		userAllowList = saveUserAllowList(userContext, userAllowList, emptyOptions());
		
		onNewInstanceCreated(userContext, userAllowList);
		return userAllowList;


	}
	protected UserAllowList createNewUserAllowList()
	{

		return new UserAllowList();
	}

	protected void checkParamsForUpdatingUserAllowList(RetailscmUserContext userContext,String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).checkVersionOfUserAllowList( userAllowListVersion);
		

		if(UserAllowList.USER_IDENTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUserIdentityOfUserAllowList(parseString(newValueExpr));
		
			
		}
		if(UserAllowList.USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);


	}



	public UserAllowList clone(RetailscmUserContext userContext, String fromUserAllowListId) throws Exception{

		return userAllowListDaoOf(userContext).clone(fromUserAllowListId, this.allTokens());
	}

	public UserAllowList internalSaveUserAllowList(RetailscmUserContext userContext, UserAllowList userAllowList) throws Exception
	{
		return internalSaveUserAllowList(userContext, userAllowList, allTokens());

	}
	public UserAllowList internalSaveUserAllowList(RetailscmUserContext userContext, UserAllowList userAllowList, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingUserAllowList(userContext, userAllowListId, userAllowListVersion, property, newValueExpr, tokensExpr);


		synchronized(userAllowList){
			//will be good when the userAllowList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAllowList.
			if (userAllowList.isChanged()){
			
			}
			userAllowList = saveUserAllowList(userContext, userAllowList, options);
			return userAllowList;

		}

	}

	public UserAllowList updateUserAllowList(RetailscmUserContext userContext,String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserAllowList(userContext, userAllowListId, userAllowListVersion, property, newValueExpr, tokensExpr);



		UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());
		if(userAllowList.getVersion() != userAllowListVersion){
			String message = "The target version("+userAllowList.getVersion()+") is not equals to version("+userAllowListVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userAllowList){
			//will be good when the userAllowList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAllowList.
			
			userAllowList.changeProperty(property, newValueExpr);
			userAllowList = saveUserAllowList(userContext, userAllowList, tokens().done());
			return present(userContext,userAllowList, mergedAllTokens(tokensExpr));
			//return saveUserAllowList(userContext, userAllowList, tokens().done());
		}

	}

	public UserAllowList updateUserAllowListProperty(RetailscmUserContext userContext,String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserAllowList(userContext, userAllowListId, userAllowListVersion, property, newValueExpr, tokensExpr);

		UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());
		if(userAllowList.getVersion() != userAllowListVersion){
			String message = "The target version("+userAllowList.getVersion()+") is not equals to version("+userAllowListVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userAllowList){
			//will be good when the userAllowList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAllowList.

			userAllowList.changeProperty(property, newValueExpr);
			
			userAllowList = saveUserAllowList(userContext, userAllowList, tokens().done());
			return present(userContext,userAllowList, mergedAllTokens(tokensExpr));
			//return saveUserAllowList(userContext, userAllowList, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected UserAllowListTokens tokens(){
		return UserAllowListTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserAllowListTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAllowListTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDomain(RetailscmUserContext userContext, String userAllowListId, String anotherDomainId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
 		checkerOf(userContext).checkIdOfUserDomain(anotherDomainId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);

 	}
 	public UserAllowList transferToAnotherDomain(RetailscmUserContext userContext, String userAllowListId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, userAllowListId,anotherDomainId);
 
		UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());	
		synchronized(userAllowList){
			//will be good when the userAllowList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());		
			userAllowList.updateDomain(domain);		
			userAllowList = saveUserAllowList(userContext, userAllowList, emptyOptions());
			
			return present(userContext,userAllowList, allTokens());
			
		}

 	}

	


	public CandidateUserDomain requestCandidateDomain(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserDomain result = new CandidateUserDomain();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserDomain> candidateList = userDomainDaoOf(userContext).requestCandidateUserDomainForUserAllowList(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected UserDomain loadUserDomain(RetailscmUserContext userContext, String newDomainId, Map<String,Object> options) throws Exception
 	{

 		return userDomainDaoOf(userContext).load(newDomainId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String userAllowListId, int userAllowListVersion) throws Exception {
		//deleteInternal(userContext, userAllowListId, userAllowListVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String userAllowListId, int userAllowListVersion) throws Exception{

		userAllowListDaoOf(userContext).delete(userAllowListId, userAllowListVersion);
	}

	public UserAllowList forgetByAll(RetailscmUserContext userContext, String userAllowListId, int userAllowListVersion) throws Exception {
		return forgetByAllInternal(userContext, userAllowListId, userAllowListVersion);
	}
	protected UserAllowList forgetByAllInternal(RetailscmUserContext userContext,
			String userAllowListId, int userAllowListVersion) throws Exception{

		return userAllowListDaoOf(userContext).disconnectFromAll(userAllowListId, userAllowListVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserAllowListManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userAllowListDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, UserAllowList newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    userAllowListDaoOf(ctx).loadAllAsStream().forEach(
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
		//   UserAllowList newUserAllowList = this.createUserAllowList(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newUserAllowList
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, UserAllowList.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<UserAllowList> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<UserDomain> domainList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, UserDomain.class);
		userContext.getDAOGroup().enhanceList(domainList, UserDomain.class);


    }
	
	public Object listByDomain(RetailscmUserContext userContext,String domainId) throws Exception {
		return listPageByDomain(userContext, domainId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDomain(RetailscmUserContext userContext,String domainId, int start, int count) throws Exception {
		SmartList<UserAllowList> list = userAllowListDaoOf(userContext).findUserAllowListByDomain(domainId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(UserAllowList.class);
		page.setContainerObject(UserDomain.withId(domainId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("用户允许列表列表");
		page.setRequestName("listByDomain");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDomain/%s/",  getBeanName(), domainId)));

		page.assemblerContent(userContext, "listByDomain");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String userAllowListId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getUserAllowListDetailScope().clone();
		UserAllowList merchantObj = (UserAllowList) this.view(userContext, userAllowListId);
    String merchantObjId = userAllowListId;
    String linkToUrl =	"userAllowListManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "用户允许列表"+"详情";
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
				MapUtil.put("id", "2-userIdentity")
				    .put("fieldName", "userIdentity")
				    .put("label", "用户身份")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("userIdentity", merchantObj.getUserIdentity());

		propList.add(
				MapUtil.put("id", "3-userSpecialFunctions")
				    .put("fieldName", "userSpecialFunctions")
				    .put("label", "用户特殊功能")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("userSpecialFunctions", merchantObj.getUserSpecialFunctions());

		propList.add(
				MapUtil.put("id", "4-domain")
				    .put("fieldName", "domain")
				    .put("label", "域")
				    .put("type", "auto")
				    .put("linkToUrl", "userDomainManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("domain", merchantObj.getDomain());

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


