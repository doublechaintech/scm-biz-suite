
package com.doublechaintech.retailscm.productsupplyduration;

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


import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

import com.doublechaintech.retailscm.supplierproduct.CandidateSupplierProduct;







public class ProductSupplyDurationManagerImpl extends CustomRetailscmCheckerManager implements ProductSupplyDurationManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "ProductSupplyDuration";
	@Override
	public ProductSupplyDurationDAO daoOf(RetailscmUserContext userContext) {
		return productSupplyDurationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ProductSupplyDurationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ProductSupplyDurationManagerException(message);

	}



 	protected ProductSupplyDuration saveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, String [] tokensExpr) throws Exception{	
 		//return getProductSupplyDurationDAO().save(productSupplyDuration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProductSupplyDuration(userContext, productSupplyDuration, tokens);
 	}
 	
 	protected ProductSupplyDuration saveProductSupplyDurationDetail(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception{	

 		
 		return saveProductSupplyDuration(userContext, productSupplyDuration, allTokens());
 	}
 	
 	public ProductSupplyDuration loadProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProductSupplyDurationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productSupplyDuration, tokens);
 	}
 	
 	
 	 public ProductSupplyDuration searchProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProductSupplyDurationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productSupplyDuration, tokens);
 	}
 	
 	

 	protected ProductSupplyDuration present(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,productSupplyDuration,tokens);
		
		
		ProductSupplyDuration  productSupplyDurationToPresent = productSupplyDurationDaoOf(userContext).present(productSupplyDuration, tokens);
		
		List<BaseEntity> entityListToNaming = productSupplyDurationToPresent.collectRefercencesFromLists();
		productSupplyDurationDaoOf(userContext).alias(entityListToNaming);
		
		return  productSupplyDurationToPresent;
		
		
	}
 
 	
 	
 	public ProductSupplyDuration loadProductSupplyDurationDetail(RetailscmUserContext userContext, String productSupplyDurationId) throws Exception{	
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, allTokens());
 		return present(userContext,productSupplyDuration, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String productSupplyDurationId) throws Exception{	
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, viewTokens());
 		return present(userContext,productSupplyDuration, allTokens());
		
 	}
 	protected ProductSupplyDuration saveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String,Object>tokens) throws Exception{	
 		return productSupplyDurationDaoOf(userContext).save(productSupplyDuration, tokens);
 	}
 	protected ProductSupplyDuration loadProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProductSupplyDurationManagerException.class);

 
 		return productSupplyDurationDaoOf(userContext).load(productSupplyDurationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){
		super.addActions(userContext, productSupplyDuration, tokens);
		
		addAction(userContext, productSupplyDuration, tokens,"@create","createProductSupplyDuration","createProductSupplyDuration/","main","primary");
		addAction(userContext, productSupplyDuration, tokens,"@update","updateProductSupplyDuration","updateProductSupplyDuration/"+productSupplyDuration.getId()+"/","main","primary");
		addAction(userContext, productSupplyDuration, tokens,"@copy","cloneProductSupplyDuration","cloneProductSupplyDuration/"+productSupplyDuration.getId()+"/","main","primary");
		
		addAction(userContext, productSupplyDuration, tokens,"product_supply_duration.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+productSupplyDuration.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ProductSupplyDuration createProductSupplyDuration(RetailscmUserContext userContext, int quantity,String duration,BigDecimal price,String productId) throws Exception
	//public ProductSupplyDuration createProductSupplyDuration(RetailscmUserContext userContext,int quantity, String duration, BigDecimal price, String productId) throws Exception
	{

		

		

		checkerOf(userContext).checkQuantityOfProductSupplyDuration(quantity);
		checkerOf(userContext).checkDurationOfProductSupplyDuration(duration);
		checkerOf(userContext).checkPriceOfProductSupplyDuration(price);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);


		ProductSupplyDuration productSupplyDuration=createNewProductSupplyDuration();	

		productSupplyDuration.setQuantity(quantity);
		productSupplyDuration.setDuration(duration);
		productSupplyDuration.setPrice(price);
			
		SupplierProduct product = loadSupplierProduct(userContext, productId,emptyOptions());
		productSupplyDuration.setProduct(product);
		
		

		productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());
		
		onNewInstanceCreated(userContext, productSupplyDuration);
		return productSupplyDuration;


	}
	protected ProductSupplyDuration createNewProductSupplyDuration()
	{

		return new ProductSupplyDuration();
	}

	protected void checkParamsForUpdatingProductSupplyDuration(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).checkVersionOfProductSupplyDuration( productSupplyDurationVersion);
		

		if(ProductSupplyDuration.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfProductSupplyDuration(parseInt(newValueExpr));
		
			
		}
		if(ProductSupplyDuration.DURATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationOfProductSupplyDuration(parseString(newValueExpr));
		
			
		}
		if(ProductSupplyDuration.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfProductSupplyDuration(parseBigDecimal(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);


	}



	public ProductSupplyDuration clone(RetailscmUserContext userContext, String fromProductSupplyDurationId) throws Exception{

		return productSupplyDurationDaoOf(userContext).clone(fromProductSupplyDurationId, this.allTokens());
	}

	public ProductSupplyDuration internalSaveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception
	{
		return internalSaveProductSupplyDuration(userContext, productSupplyDuration, allTokens());

	}
	public ProductSupplyDuration internalSaveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);


		synchronized(productSupplyDuration){
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.
			if (productSupplyDuration.isChanged()){
			
			}
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, options);
			return productSupplyDuration;

		}

	}

	public ProductSupplyDuration updateProductSupplyDuration(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);



		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
		if(productSupplyDuration.getVersion() != productSupplyDurationVersion){
			String message = "The target version("+productSupplyDuration.getVersion()+") is not equals to version("+productSupplyDurationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(productSupplyDuration){
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.
			
			productSupplyDuration.changeProperty(property, newValueExpr);
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
			return present(userContext,productSupplyDuration, mergedAllTokens(tokensExpr));
			//return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
		}

	}

	public ProductSupplyDuration updateProductSupplyDurationProperty(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);

		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
		if(productSupplyDuration.getVersion() != productSupplyDurationVersion){
			String message = "The target version("+productSupplyDuration.getVersion()+") is not equals to version("+productSupplyDurationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(productSupplyDuration){
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.

			productSupplyDuration.changeProperty(property, newValueExpr);
			
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
			return present(userContext,productSupplyDuration, mergedAllTokens(tokensExpr));
			//return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ProductSupplyDurationTokens tokens(){
		return ProductSupplyDurationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductSupplyDurationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductSupplyDurationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
 		checkerOf(userContext).checkIdOfSupplierProduct(anotherProductId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);

 	}
 	public ProductSupplyDuration transferToAnotherProduct(RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, productSupplyDurationId,anotherProductId);
 
		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());	
		synchronized(productSupplyDuration){
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplierProduct product = loadSupplierProduct(userContext, anotherProductId, emptyOptions());		
			productSupplyDuration.updateProduct(product);		
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());
			
			return present(userContext,productSupplyDuration, allTokens());
			
		}

 	}

	


	public CandidateSupplierProduct requestCandidateProduct(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplierProduct result = new CandidateSupplierProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("productName");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplierProduct> candidateList = supplierProductDaoOf(userContext).requestCandidateSupplierProductForProductSupplyDuration(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SupplierProduct loadSupplierProduct(RetailscmUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{

 		return supplierProductDaoOf(userContext).load(newProductId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String productSupplyDurationId, int productSupplyDurationVersion) throws Exception {
		//deleteInternal(userContext, productSupplyDurationId, productSupplyDurationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String productSupplyDurationId, int productSupplyDurationVersion) throws Exception{

		productSupplyDurationDaoOf(userContext).delete(productSupplyDurationId, productSupplyDurationVersion);
	}

	public ProductSupplyDuration forgetByAll(RetailscmUserContext userContext, String productSupplyDurationId, int productSupplyDurationVersion) throws Exception {
		return forgetByAllInternal(userContext, productSupplyDurationId, productSupplyDurationVersion);
	}
	protected ProductSupplyDuration forgetByAllInternal(RetailscmUserContext userContext,
			String productSupplyDurationId, int productSupplyDurationVersion) throws Exception{

		return productSupplyDurationDaoOf(userContext).disconnectFromAll(productSupplyDurationId, productSupplyDurationVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductSupplyDurationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return productSupplyDurationDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, ProductSupplyDuration newCreated) throws Exception{
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
		//   ProductSupplyDuration newProductSupplyDuration = this.createProductSupplyDuration(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newProductSupplyDuration
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ProductSupplyDuration.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ProductSupplyDuration> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SupplierProduct> productList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SupplierProduct.class);
		userContext.getDAOGroup().enhanceList(productList, SupplierProduct.class);


    }
	
	public Object listByProduct(RetailscmUserContext userContext,String productId) throws Exception {
		return listPageByProduct(userContext, productId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProduct(RetailscmUserContext userContext,String productId, int start, int count) throws Exception {
		SmartList<ProductSupplyDuration> list = productSupplyDurationDaoOf(userContext).findProductSupplyDurationByProduct(productId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ProductSupplyDuration.class);
		page.setContainerObject(SupplierProduct.withId(productId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("产品供应时间列表");
		page.setRequestName("listByProduct");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProduct/%s/",  getBeanName(), productId)));

		page.assemblerContent(userContext, "listByProduct");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String productSupplyDurationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getProductSupplyDurationDetailScope().clone();
		ProductSupplyDuration merchantObj = (ProductSupplyDuration) this.view(userContext, productSupplyDurationId);
    String merchantObjId = productSupplyDurationId;
    String linkToUrl =	"productSupplyDurationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "产品供应时间"+"详情";
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
				MapUtil.put("id", "2-quantity")
				    .put("fieldName", "quantity")
				    .put("label", "数量")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("quantity", merchantObj.getQuantity());

		propList.add(
				MapUtil.put("id", "3-duration")
				    .put("fieldName", "duration")
				    .put("label", "持续时间")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("duration", merchantObj.getDuration());

		propList.add(
				MapUtil.put("id", "4-price")
				    .put("fieldName", "price")
				    .put("label", "价格")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("price", merchantObj.getPrice());

		propList.add(
				MapUtil.put("id", "5-product")
				    .put("fieldName", "product")
				    .put("label", "产品")
				    .put("type", "auto")
				    .put("linkToUrl", "supplierProductManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"product_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"product_name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("product", merchantObj.getProduct());

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


