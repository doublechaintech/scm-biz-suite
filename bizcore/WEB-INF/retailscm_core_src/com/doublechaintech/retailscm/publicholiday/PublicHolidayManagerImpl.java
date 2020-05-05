
package com.doublechaintech.retailscm.publicholiday;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;







public class PublicHolidayManagerImpl extends CustomRetailscmCheckerManager implements PublicHolidayManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "PublicHoliday";
	@Override
	public PublicHolidayDAO daoOf(RetailscmUserContext userContext) {
		return publicHolidayDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PublicHolidayManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PublicHolidayManagerException(message);

	}



 	protected PublicHoliday savePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday, String [] tokensExpr) throws Exception{	
 		//return getPublicHolidayDAO().save(publicHoliday, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePublicHoliday(userContext, publicHoliday, tokens);
 	}
 	
 	protected PublicHoliday savePublicHolidayDetail(RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception{	

 		
 		return savePublicHoliday(userContext, publicHoliday, allTokens());
 	}
 	
 	public PublicHoliday loadPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).throwExceptionIfHasErrors( PublicHolidayManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicHoliday, tokens);
 	}
 	
 	
 	 public PublicHoliday searchPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).throwExceptionIfHasErrors( PublicHolidayManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicHoliday, tokens);
 	}
 	
 	

 	protected PublicHoliday present(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,publicHoliday,tokens);
		
		
		PublicHoliday  publicHolidayToPresent = publicHolidayDaoOf(userContext).present(publicHoliday, tokens);
		
		List<BaseEntity> entityListToNaming = publicHolidayToPresent.collectRefercencesFromLists();
		publicHolidayDaoOf(userContext).alias(entityListToNaming);
		
		return  publicHolidayToPresent;
		
		
	}
 
 	
 	
 	public PublicHoliday loadPublicHolidayDetail(RetailscmUserContext userContext, String publicHolidayId) throws Exception{	
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, allTokens());
 		return present(userContext,publicHoliday, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String publicHolidayId) throws Exception{	
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, viewTokens());
 		return present(userContext,publicHoliday, allTokens());
		
 	}
 	protected PublicHoliday savePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String,Object>tokens) throws Exception{	
 		return publicHolidayDaoOf(userContext).save(publicHoliday, tokens);
 	}
 	protected PublicHoliday loadPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).throwExceptionIfHasErrors( PublicHolidayManagerException.class);

 
 		return publicHolidayDaoOf(userContext).load(publicHolidayId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){
		super.addActions(userContext, publicHoliday, tokens);
		
		addAction(userContext, publicHoliday, tokens,"@create","createPublicHoliday","createPublicHoliday/","main","primary");
		addAction(userContext, publicHoliday, tokens,"@update","updatePublicHoliday","updatePublicHoliday/"+publicHoliday.getId()+"/","main","primary");
		addAction(userContext, publicHoliday, tokens,"@copy","clonePublicHoliday","clonePublicHoliday/"+publicHoliday.getId()+"/","main","primary");
		
		addAction(userContext, publicHoliday, tokens,"public_holiday.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+publicHoliday.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public PublicHoliday createPublicHoliday(RetailscmUserContext userContext, String code,String companyId,String name,String description) throws Exception
	//public PublicHoliday createPublicHoliday(RetailscmUserContext userContext,String code, String companyId, String name, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkCodeOfPublicHoliday(code);
		checkerOf(userContext).checkNameOfPublicHoliday(name);
		checkerOf(userContext).checkDescriptionOfPublicHoliday(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);


		PublicHoliday publicHoliday=createNewPublicHoliday();	

		publicHoliday.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		publicHoliday.setCompany(company);
		
		
		publicHoliday.setName(name);
		publicHoliday.setDescription(description);

		publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());
		
		onNewInstanceCreated(userContext, publicHoliday);
		return publicHoliday;


	}
	protected PublicHoliday createNewPublicHoliday()
	{

		return new PublicHoliday();
	}

	protected void checkParamsForUpdatingPublicHoliday(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).checkVersionOfPublicHoliday( publicHolidayVersion);
		

		if(PublicHoliday.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPublicHoliday(parseString(newValueExpr));
		
			
		}		

		
		if(PublicHoliday.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPublicHoliday(parseString(newValueExpr));
		
			
		}
		if(PublicHoliday.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfPublicHoliday(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);


	}



	public PublicHoliday clone(RetailscmUserContext userContext, String fromPublicHolidayId) throws Exception{

		return publicHolidayDaoOf(userContext).clone(fromPublicHolidayId, this.allTokens());
	}

	public PublicHoliday internalSavePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception
	{
		return internalSavePublicHoliday(userContext, publicHoliday, allTokens());

	}
	public PublicHoliday internalSavePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);


		synchronized(publicHoliday){
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.
			if (publicHoliday.isChanged()){
			
			}
			publicHoliday = savePublicHoliday(userContext, publicHoliday, options);
			return publicHoliday;

		}

	}

	public PublicHoliday updatePublicHoliday(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);



		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
		if(publicHoliday.getVersion() != publicHolidayVersion){
			String message = "The target version("+publicHoliday.getVersion()+") is not equals to version("+publicHolidayVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(publicHoliday){
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.
			
			publicHoliday.changeProperty(property, newValueExpr);
			publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
			return present(userContext,publicHoliday, mergedAllTokens(tokensExpr));
			//return savePublicHoliday(userContext, publicHoliday, tokens().done());
		}

	}

	public PublicHoliday updatePublicHolidayProperty(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);

		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
		if(publicHoliday.getVersion() != publicHolidayVersion){
			String message = "The target version("+publicHoliday.getVersion()+") is not equals to version("+publicHolidayVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(publicHoliday){
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.

			publicHoliday.changeProperty(property, newValueExpr);
			
			publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
			return present(userContext,publicHoliday, mergedAllTokens(tokensExpr));
			//return savePublicHoliday(userContext, publicHoliday, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PublicHolidayTokens tokens(){
		return PublicHolidayTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PublicHolidayTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PublicHolidayTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);

 	}
 	public PublicHoliday transferToAnotherCompany(RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, publicHolidayId,anotherCompanyId);
 
		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());	
		synchronized(publicHoliday){
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			publicHoliday.updateCompany(company);		
			publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());
			
			return present(userContext,publicHoliday, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateCompany(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForPublicHoliday(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String publicHolidayId, int publicHolidayVersion) throws Exception {
		//deleteInternal(userContext, publicHolidayId, publicHolidayVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String publicHolidayId, int publicHolidayVersion) throws Exception{

		publicHolidayDaoOf(userContext).delete(publicHolidayId, publicHolidayVersion);
	}

	public PublicHoliday forgetByAll(RetailscmUserContext userContext, String publicHolidayId, int publicHolidayVersion) throws Exception {
		return forgetByAllInternal(userContext, publicHolidayId, publicHolidayVersion);
	}
	protected PublicHoliday forgetByAllInternal(RetailscmUserContext userContext,
			String publicHolidayId, int publicHolidayVersion) throws Exception{

		return publicHolidayDaoOf(userContext).disconnectFromAll(publicHolidayId, publicHolidayVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PublicHolidayManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return publicHolidayDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, PublicHoliday newCreated) throws Exception{
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
		//   PublicHoliday newPublicHoliday = this.createPublicHoliday(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPublicHoliday
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, PublicHoliday.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<PublicHoliday> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<PublicHoliday> list = publicHolidayDaoOf(userContext).findPublicHolidayByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PublicHoliday.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("公共假日列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String publicHolidayId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getPublicHolidayDetailScope().clone();
		PublicHoliday merchantObj = (PublicHoliday) this.view(userContext, publicHolidayId);
    String merchantObjId = publicHolidayId;
    String linkToUrl =	"publicHolidayManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "公共假日"+"详情";
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
				MapUtil.put("id", "2-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "3-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "4-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

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


