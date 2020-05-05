
package com.doublechaintech.retailscm.warehouseasset;

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


import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;







public class WarehouseAssetManagerImpl extends CustomRetailscmCheckerManager implements WarehouseAssetManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "WarehouseAsset";
	@Override
	public WarehouseAssetDAO daoOf(RetailscmUserContext userContext) {
		return warehouseAssetDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws WarehouseAssetManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new WarehouseAssetManagerException(message);

	}



 	protected WarehouseAsset saveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, String [] tokensExpr) throws Exception{	
 		//return getWarehouseAssetDAO().save(warehouseAsset, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWarehouseAsset(userContext, warehouseAsset, tokens);
 	}
 	
 	protected WarehouseAsset saveWarehouseAssetDetail(RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception{	

 		
 		return saveWarehouseAsset(userContext, warehouseAsset, allTokens());
 	}
 	
 	public WarehouseAsset loadWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
		checkerOf(userContext).throwExceptionIfHasErrors( WarehouseAssetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouseAsset, tokens);
 	}
 	
 	
 	 public WarehouseAsset searchWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
		checkerOf(userContext).throwExceptionIfHasErrors( WarehouseAssetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouseAsset, tokens);
 	}
 	
 	

 	protected WarehouseAsset present(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,warehouseAsset,tokens);
		
		
		WarehouseAsset  warehouseAssetToPresent = warehouseAssetDaoOf(userContext).present(warehouseAsset, tokens);
		
		List<BaseEntity> entityListToNaming = warehouseAssetToPresent.collectRefercencesFromLists();
		warehouseAssetDaoOf(userContext).alias(entityListToNaming);
		
		return  warehouseAssetToPresent;
		
		
	}
 
 	
 	
 	public WarehouseAsset loadWarehouseAssetDetail(RetailscmUserContext userContext, String warehouseAssetId) throws Exception{	
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, allTokens());
 		return present(userContext,warehouseAsset, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String warehouseAssetId) throws Exception{	
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, viewTokens());
 		return present(userContext,warehouseAsset, allTokens());
		
 	}
 	protected WarehouseAsset saveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String,Object>tokens) throws Exception{	
 		return warehouseAssetDaoOf(userContext).save(warehouseAsset, tokens);
 	}
 	protected WarehouseAsset loadWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
		checkerOf(userContext).throwExceptionIfHasErrors( WarehouseAssetManagerException.class);

 
 		return warehouseAssetDaoOf(userContext).load(warehouseAssetId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){
		super.addActions(userContext, warehouseAsset, tokens);
		
		addAction(userContext, warehouseAsset, tokens,"@create","createWarehouseAsset","createWarehouseAsset/","main","primary");
		addAction(userContext, warehouseAsset, tokens,"@update","updateWarehouseAsset","updateWarehouseAsset/"+warehouseAsset.getId()+"/","main","primary");
		addAction(userContext, warehouseAsset, tokens,"@copy","cloneWarehouseAsset","cloneWarehouseAsset/"+warehouseAsset.getId()+"/","main","primary");
		
		addAction(userContext, warehouseAsset, tokens,"warehouse_asset.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+warehouseAsset.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public WarehouseAsset createWarehouseAsset(RetailscmUserContext userContext, String name,String position,String ownerId) throws Exception
	//public WarehouseAsset createWarehouseAsset(RetailscmUserContext userContext,String name, String position, String ownerId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfWarehouseAsset(name);
		checkerOf(userContext).checkPositionOfWarehouseAsset(position);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);


		WarehouseAsset warehouseAsset=createNewWarehouseAsset();	

		warehouseAsset.setName(name);
		warehouseAsset.setPosition(position);
			
		Warehouse owner = loadWarehouse(userContext, ownerId,emptyOptions());
		warehouseAsset.setOwner(owner);
		
		
		warehouseAsset.setLastUpdateTime(userContext.now());

		warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());
		
		onNewInstanceCreated(userContext, warehouseAsset);
		return warehouseAsset;


	}
	protected WarehouseAsset createNewWarehouseAsset()
	{

		return new WarehouseAsset();
	}

	protected void checkParamsForUpdatingWarehouseAsset(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
		checkerOf(userContext).checkVersionOfWarehouseAsset( warehouseAssetVersion);
		

		if(WarehouseAsset.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfWarehouseAsset(parseString(newValueExpr));
		
			
		}
		if(WarehouseAsset.POSITION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPositionOfWarehouseAsset(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);


	}



	public WarehouseAsset clone(RetailscmUserContext userContext, String fromWarehouseAssetId) throws Exception{

		return warehouseAssetDaoOf(userContext).clone(fromWarehouseAssetId, this.allTokens());
	}

	public WarehouseAsset internalSaveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception
	{
		return internalSaveWarehouseAsset(userContext, warehouseAsset, allTokens());

	}
	public WarehouseAsset internalSaveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);


		synchronized(warehouseAsset){
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.
			if (warehouseAsset.isChanged()){
			warehouseAsset.updateLastUpdateTime(userContext.now());
			}
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, options);
			return warehouseAsset;

		}

	}

	public WarehouseAsset updateWarehouseAsset(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);



		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
		if(warehouseAsset.getVersion() != warehouseAssetVersion){
			String message = "The target version("+warehouseAsset.getVersion()+") is not equals to version("+warehouseAssetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(warehouseAsset){
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.
			warehouseAsset.updateLastUpdateTime(userContext.now());
			warehouseAsset.changeProperty(property, newValueExpr);
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
			return present(userContext,warehouseAsset, mergedAllTokens(tokensExpr));
			//return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
		}

	}

	public WarehouseAsset updateWarehouseAssetProperty(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);

		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
		if(warehouseAsset.getVersion() != warehouseAssetVersion){
			String message = "The target version("+warehouseAsset.getVersion()+") is not equals to version("+warehouseAssetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(warehouseAsset){
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.

			warehouseAsset.changeProperty(property, newValueExpr);
			warehouseAsset.updateLastUpdateTime(userContext.now());
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
			return present(userContext,warehouseAsset, mergedAllTokens(tokensExpr));
			//return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected WarehouseAssetTokens tokens(){
		return WarehouseAssetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WarehouseAssetTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WarehouseAssetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
 		checkerOf(userContext).checkIdOfWarehouse(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);

 	}
 	public WarehouseAsset transferToAnotherOwner(RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, warehouseAssetId,anotherOwnerId);
 
		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());	
		synchronized(warehouseAsset){
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse owner = loadWarehouse(userContext, anotherOwnerId, emptyOptions());		
			warehouseAsset.updateOwner(owner);		
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());
			
			return present(userContext,warehouseAsset, allTokens());
			
		}

 	}

	


	public CandidateWarehouse requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateWarehouse result = new CandidateWarehouse();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Warehouse> candidateList = warehouseDaoOf(userContext).requestCandidateWarehouseForWarehouseAsset(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return warehouseDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion) throws Exception {
		//deleteInternal(userContext, warehouseAssetId, warehouseAssetVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String warehouseAssetId, int warehouseAssetVersion) throws Exception{

		warehouseAssetDaoOf(userContext).delete(warehouseAssetId, warehouseAssetVersion);
	}

	public WarehouseAsset forgetByAll(RetailscmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion) throws Exception {
		return forgetByAllInternal(userContext, warehouseAssetId, warehouseAssetVersion);
	}
	protected WarehouseAsset forgetByAllInternal(RetailscmUserContext userContext,
			String warehouseAssetId, int warehouseAssetVersion) throws Exception{

		return warehouseAssetDaoOf(userContext).disconnectFromAll(warehouseAssetId, warehouseAssetVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WarehouseAssetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return warehouseAssetDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, WarehouseAsset newCreated) throws Exception{
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
		//   WarehouseAsset newWarehouseAsset = this.createWarehouseAsset(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newWarehouseAsset
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, WarehouseAsset.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<WarehouseAsset> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Warehouse> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Warehouse.class);
		userContext.getDAOGroup().enhanceList(ownerList, Warehouse.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<WarehouseAsset> list = warehouseAssetDaoOf(userContext).findWarehouseAssetByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(WarehouseAsset.class);
		page.setContainerObject(Warehouse.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("仓库资产列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String warehouseAssetId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getWarehouseAssetDetailScope().clone();
		WarehouseAsset merchantObj = (WarehouseAsset) this.view(userContext, warehouseAssetId);
    String merchantObjId = warehouseAssetId;
    String linkToUrl =	"warehouseAssetManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "仓库资产"+"详情";
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
				MapUtil.put("id", "3-position")
				    .put("fieldName", "position")
				    .put("label", "位置")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("position", merchantObj.getPosition());

		propList.add(
				MapUtil.put("id", "4-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "warehouseManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "5-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
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


