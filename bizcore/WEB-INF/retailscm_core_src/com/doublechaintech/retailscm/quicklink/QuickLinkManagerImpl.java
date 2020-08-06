
package com.doublechaintech.retailscm.quicklink;

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



import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.userapp.CandidateUserApp;







public class QuickLinkManagerImpl extends CustomRetailscmCheckerManager implements QuickLinkManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "QuickLink";
	@Override
	public QuickLinkDAO daoOf(RetailscmUserContext userContext) {
		return quickLinkDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws QuickLinkManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new QuickLinkManagerException(message);

	}



 	protected QuickLink saveQuickLink(RetailscmUserContext userContext, QuickLink quickLink, String [] tokensExpr) throws Exception{	
 		//return getQuickLinkDAO().save(quickLink, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveQuickLink(userContext, quickLink, tokens);
 	}
 	
 	protected QuickLink saveQuickLinkDetail(RetailscmUserContext userContext, QuickLink quickLink) throws Exception{	

 		
 		return saveQuickLink(userContext, quickLink, allTokens());
 	}
 	
 	public QuickLink loadQuickLink(RetailscmUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}
 	
 	
 	 public QuickLink searchQuickLink(RetailscmUserContext userContext, String quickLinkId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}
 	
 	

 	protected QuickLink present(RetailscmUserContext userContext, QuickLink quickLink, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,quickLink,tokens);
		
		
		QuickLink  quickLinkToPresent = quickLinkDaoOf(userContext).present(quickLink, tokens);
		
		List<BaseEntity> entityListToNaming = quickLinkToPresent.collectRefercencesFromLists();
		quickLinkDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,quickLink,tokens);
		
		return  quickLinkToPresent;
		
		
	}
 
 	
 	
 	public QuickLink loadQuickLinkDetail(RetailscmUserContext userContext, String quickLinkId) throws Exception{	
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, allTokens());
 		return present(userContext,quickLink, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String quickLinkId) throws Exception{	
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, viewTokens());
 		return present(userContext,quickLink, allTokens());
		
 	}
 	protected QuickLink saveQuickLink(RetailscmUserContext userContext, QuickLink quickLink, Map<String,Object>tokens) throws Exception{	
 		return quickLinkDaoOf(userContext).save(quickLink, tokens);
 	}
 	protected QuickLink loadQuickLink(RetailscmUserContext userContext, String quickLinkId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);

 
 		return quickLinkDaoOf(userContext).load(quickLinkId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
		super.addActions(userContext, quickLink, tokens);
		
		addAction(userContext, quickLink, tokens,"@create","createQuickLink","createQuickLink/","main","primary");
		addAction(userContext, quickLink, tokens,"@update","updateQuickLink","updateQuickLink/"+quickLink.getId()+"/","main","primary");
		addAction(userContext, quickLink, tokens,"@copy","cloneQuickLink","cloneQuickLink/"+quickLink.getId()+"/","main","primary");
		
		addAction(userContext, quickLink, tokens,"quick_link.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+quickLink.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public QuickLink createQuickLink(RetailscmUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception
	//public QuickLink createQuickLink(RetailscmUserContext userContext,String name, String icon, String imagePath, String linkTarget, String appId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfQuickLink(name);
		checkerOf(userContext).checkIconOfQuickLink(icon);
		checkerOf(userContext).checkImagePathOfQuickLink(imagePath);
		checkerOf(userContext).checkLinkTargetOfQuickLink(linkTarget);
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);


		QuickLink quickLink=createNewQuickLink();	

		quickLink.setName(name);
		quickLink.setIcon(icon);
		quickLink.setImagePath(imagePath);
		quickLink.setLinkTarget(linkTarget);
		quickLink.setCreateTime(userContext.now());
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		quickLink.setApp(app);
		
		

		quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
		
		onNewInstanceCreated(userContext, quickLink);
		return quickLink;


	}
	protected QuickLink createNewQuickLink()
	{

		return new QuickLink();
	}

	protected void checkParamsForUpdatingQuickLink(RetailscmUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink( quickLinkVersion);
		

		if(QuickLink.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfQuickLink(parseString(newValueExpr));
		
			
		}
		if(QuickLink.ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIconOfQuickLink(parseString(newValueExpr));
		
			
		}
		if(QuickLink.IMAGE_PATH_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImagePathOfQuickLink(parseString(newValueExpr));
		
			
		}
		if(QuickLink.LINK_TARGET_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkTargetOfQuickLink(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);


	}



	public QuickLink clone(RetailscmUserContext userContext, String fromQuickLinkId) throws Exception{

		return quickLinkDaoOf(userContext).clone(fromQuickLinkId, this.allTokens());
	}

	public QuickLink internalSaveQuickLink(RetailscmUserContext userContext, QuickLink quickLink) throws Exception
	{
		return internalSaveQuickLink(userContext, quickLink, allTokens());

	}
	public QuickLink internalSaveQuickLink(RetailscmUserContext userContext, QuickLink quickLink, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);


		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			if (quickLink.isChanged()){
			
			}
			quickLink = saveQuickLink(userContext, quickLink, options);
			return quickLink;

		}

	}

	public QuickLink updateQuickLink(RetailscmUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);



		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			
			quickLink.changeProperty(property, newValueExpr);
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}

	public QuickLink updateQuickLinkProperty(RetailscmUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);

		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.

			quickLink.changeProperty(property, newValueExpr);
			
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected QuickLinkTokens tokens(){
		return QuickLinkTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return QuickLinkTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return QuickLinkTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(RetailscmUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);

 	}
 	public QuickLink transferToAnotherApp(RetailscmUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, quickLinkId,anotherAppId);
 
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());	
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			quickLink.updateApp(app);		
			quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
			
			return present(userContext,quickLink, allTokens());
			
		}

 	}

	


	public CandidateUserApp requestCandidateApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForQuickLink(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected UserApp loadUserApp(RetailscmUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{

 		return userAppDaoOf(userContext).load(newAppId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		//deleteInternal(userContext, quickLinkId, quickLinkVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{

		quickLinkDaoOf(userContext).delete(quickLinkId, quickLinkVersion);
	}

	public QuickLink forgetByAll(RetailscmUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		return forgetByAllInternal(userContext, quickLinkId, quickLinkVersion);
	}
	protected QuickLink forgetByAllInternal(RetailscmUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{

		return quickLinkDaoOf(userContext).disconnectFromAll(quickLinkId, quickLinkVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new QuickLinkManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return quickLinkDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, QuickLink newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    quickLinkDaoOf(ctx).loadAllAsStream().forEach(
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
		//   QuickLink newQuickLink = this.createQuickLink(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newQuickLink
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, QuickLink.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<QuickLink> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<UserApp> appList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, UserApp.class);
		userContext.getDAOGroup().enhanceList(appList, UserApp.class);


    }
	
	public Object listByApp(RetailscmUserContext userContext,String appId) throws Exception {
		return listPageByApp(userContext, appId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByApp(RetailscmUserContext userContext,String appId, int start, int count) throws Exception {
		SmartList<QuickLink> list = quickLinkDaoOf(userContext).findQuickLinkByApp(appId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(QuickLink.class);
		page.setContainerObject(UserApp.withId(appId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("快速链接列表");
		page.setRequestName("listByApp");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByApp/%s/",  getBeanName(), appId)));

		page.assemblerContent(userContext, "listByApp");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String quickLinkId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getQuickLinkDetailScope().clone();
		QuickLink merchantObj = (QuickLink) this.view(userContext, quickLinkId);
    String merchantObjId = quickLinkId;
    String linkToUrl =	"quickLinkManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "快速链接"+"详情";
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
				MapUtil.put("id", "3-icon")
				    .put("fieldName", "icon")
				    .put("label", "图标")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("icon", merchantObj.getIcon());

		propList.add(
				MapUtil.put("id", "4-imagePath")
				    .put("fieldName", "imagePath")
				    .put("label", "图片路径")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("imagePath", merchantObj.getImagePath());

		propList.add(
				MapUtil.put("id", "5-linkTarget")
				    .put("fieldName", "linkTarget")
				    .put("label", "链接的目标")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("linkTarget", merchantObj.getLinkTarget());

		propList.add(
				MapUtil.put("id", "6-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

		propList.add(
				MapUtil.put("id", "7-app")
				    .put("fieldName", "app")
				    .put("label", "应用程序")
				    .put("type", "auto")
				    .put("linkToUrl", "userAppManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"app_icon\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("app", merchantObj.getApp());

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


