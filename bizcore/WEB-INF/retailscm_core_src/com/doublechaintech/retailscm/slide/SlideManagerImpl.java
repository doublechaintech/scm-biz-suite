
package com.doublechaintech.retailscm.slide;

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



import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.CandidatePage;







public class SlideManagerImpl extends CustomRetailscmCheckerManager implements SlideManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "Slide";
	@Override
	public SlideDAO daoOf(RetailscmUserContext userContext) {
		return slideDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SlideManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SlideManagerException(message);

	}



 	protected Slide saveSlide(RetailscmUserContext userContext, Slide slide, String [] tokensExpr) throws Exception{	
 		//return getSlideDAO().save(slide, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSlide(userContext, slide, tokens);
 	}
 	
 	protected Slide saveSlideDetail(RetailscmUserContext userContext, Slide slide) throws Exception{	

 		
 		return saveSlide(userContext, slide, allTokens());
 	}
 	
 	public Slide loadSlide(RetailscmUserContext userContext, String slideId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).throwExceptionIfHasErrors( SlideManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Slide slide = loadSlide( userContext, slideId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,slide, tokens);
 	}
 	
 	
 	 public Slide searchSlide(RetailscmUserContext userContext, String slideId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).throwExceptionIfHasErrors( SlideManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		Slide slide = loadSlide( userContext, slideId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,slide, tokens);
 	}
 	
 	

 	protected Slide present(RetailscmUserContext userContext, Slide slide, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,slide,tokens);
		
		
		Slide  slideToPresent = slideDaoOf(userContext).present(slide, tokens);
		
		List<BaseEntity> entityListToNaming = slideToPresent.collectRefercencesFromLists();
		slideDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,slide,tokens);
		
		return  slideToPresent;
		
		
	}
 
 	
 	
 	public Slide loadSlideDetail(RetailscmUserContext userContext, String slideId) throws Exception{	
 		Slide slide = loadSlide( userContext, slideId, allTokens());
 		return present(userContext,slide, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String slideId) throws Exception{	
 		Slide slide = loadSlide( userContext, slideId, viewTokens());
 		return present(userContext,slide, allTokens());
		
 	}
 	protected Slide saveSlide(RetailscmUserContext userContext, Slide slide, Map<String,Object>tokens) throws Exception{	
 		return slideDaoOf(userContext).save(slide, tokens);
 	}
 	protected Slide loadSlide(RetailscmUserContext userContext, String slideId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).throwExceptionIfHasErrors( SlideManagerException.class);

 
 		return slideDaoOf(userContext).load(slideId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Slide slide, Map<String, Object> tokens){
		super.addActions(userContext, slide, tokens);
		
		addAction(userContext, slide, tokens,"@create","createSlide","createSlide/","main","primary");
		addAction(userContext, slide, tokens,"@update","updateSlide","updateSlide/"+slide.getId()+"/","main","primary");
		addAction(userContext, slide, tokens,"@copy","cloneSlide","cloneSlide/"+slide.getId()+"/","main","primary");
		
		addAction(userContext, slide, tokens,"slide.transfer_to_page","transferToAnotherPage","transferToAnotherPage/"+slide.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Slide slide, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Slide createSlide(RetailscmUserContext userContext, String name,int displayOrder,String imageUrl,String videoUrl,String linkToUrl,String pageId) throws Exception
	//public Slide createSlide(RetailscmUserContext userContext,String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl, String pageId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfSlide(name);
		checkerOf(userContext).checkDisplayOrderOfSlide(displayOrder);
		checkerOf(userContext).checkImageUrlOfSlide(imageUrl);
		checkerOf(userContext).checkVideoUrlOfSlide(videoUrl);
		checkerOf(userContext).checkLinkToUrlOfSlide(linkToUrl);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SlideManagerException.class);


		Slide slide=createNewSlide();	

		slide.setName(name);
		slide.setDisplayOrder(displayOrder);
		slide.setImageUrl(imageUrl);
		slide.setVideoUrl(videoUrl);
		slide.setLinkToUrl(linkToUrl);
			
		Page page = loadPage(userContext, pageId,emptyOptions());
		slide.setPage(page);
		
		

		slide = saveSlide(userContext, slide, emptyOptions());
		
		onNewInstanceCreated(userContext, slide);
		return slide;


	}
	protected Slide createNewSlide()
	{

		return new Slide();
	}

	protected void checkParamsForUpdatingSlide(RetailscmUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).checkVersionOfSlide( slideVersion);
		

		if(Slide.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSlide(parseString(newValueExpr));
		
			
		}
		if(Slide.DISPLAY_ORDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisplayOrderOfSlide(parseInt(newValueExpr));
		
			
		}
		if(Slide.IMAGE_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImageUrlOfSlide(parseString(newValueExpr));
		
			
		}
		if(Slide.VIDEO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVideoUrlOfSlide(parseString(newValueExpr));
		
			
		}
		if(Slide.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfSlide(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SlideManagerException.class);


	}



	public Slide clone(RetailscmUserContext userContext, String fromSlideId) throws Exception{

		return slideDaoOf(userContext).clone(fromSlideId, this.allTokens());
	}

	public Slide internalSaveSlide(RetailscmUserContext userContext, Slide slide) throws Exception
	{
		return internalSaveSlide(userContext, slide, allTokens());

	}
	public Slide internalSaveSlide(RetailscmUserContext userContext, Slide slide, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSlide(userContext, slideId, slideVersion, property, newValueExpr, tokensExpr);


		synchronized(slide){
			//will be good when the slide loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Slide.
			if (slide.isChanged()){
			
			}
			slide = saveSlide(userContext, slide, options);
			return slide;

		}

	}

	public Slide updateSlide(RetailscmUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSlide(userContext, slideId, slideVersion, property, newValueExpr, tokensExpr);



		Slide slide = loadSlide(userContext, slideId, allTokens());
		if(slide.getVersion() != slideVersion){
			String message = "The target version("+slide.getVersion()+") is not equals to version("+slideVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(slide){
			//will be good when the slide loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Slide.
			
			slide.changeProperty(property, newValueExpr);
			slide = saveSlide(userContext, slide, tokens().done());
			return present(userContext,slide, mergedAllTokens(tokensExpr));
			//return saveSlide(userContext, slide, tokens().done());
		}

	}

	public Slide updateSlideProperty(RetailscmUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSlide(userContext, slideId, slideVersion, property, newValueExpr, tokensExpr);

		Slide slide = loadSlide(userContext, slideId, allTokens());
		if(slide.getVersion() != slideVersion){
			String message = "The target version("+slide.getVersion()+") is not equals to version("+slideVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(slide){
			//will be good when the slide loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Slide.

			slide.changeProperty(property, newValueExpr);
			
			slide = saveSlide(userContext, slide, tokens().done());
			return present(userContext,slide, mergedAllTokens(tokensExpr));
			//return saveSlide(userContext, slide, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SlideTokens tokens(){
		return SlideTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SlideTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SlideTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPage(RetailscmUserContext userContext, String slideId, String anotherPageId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSlide(slideId);
 		checkerOf(userContext).checkIdOfPage(anotherPageId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SlideManagerException.class);

 	}
 	public Slide transferToAnotherPage(RetailscmUserContext userContext, String slideId, String anotherPageId) throws Exception
 	{
 		checkParamsForTransferingAnotherPage(userContext, slideId,anotherPageId);
 
		Slide slide = loadSlide(userContext, slideId, allTokens());	
		synchronized(slide){
			//will be good when the slide loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Page page = loadPage(userContext, anotherPageId, emptyOptions());		
			slide.updatePage(page);		
			slide = saveSlide(userContext, slide, emptyOptions());
			
			return present(userContext,slide, allTokens());
			
		}

 	}

	


	public CandidatePage requestCandidatePage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePage result = new CandidatePage();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("pageTitle");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Page> candidateList = pageDaoOf(userContext).requestCandidatePageForSlide(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Page loadPage(RetailscmUserContext userContext, String newPageId, Map<String,Object> options) throws Exception
 	{

 		return pageDaoOf(userContext).load(newPageId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String slideId, int slideVersion) throws Exception {
		//deleteInternal(userContext, slideId, slideVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String slideId, int slideVersion) throws Exception{

		slideDaoOf(userContext).delete(slideId, slideVersion);
	}

	public Slide forgetByAll(RetailscmUserContext userContext, String slideId, int slideVersion) throws Exception {
		return forgetByAllInternal(userContext, slideId, slideVersion);
	}
	protected Slide forgetByAllInternal(RetailscmUserContext userContext,
			String slideId, int slideVersion) throws Exception{

		return slideDaoOf(userContext).disconnectFromAll(slideId, slideVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SlideManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return slideDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, Slide newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    slideDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Slide newSlide = this.createSlide(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSlide
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Slide.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Slide> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Page> pageList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Page.class);
		userContext.getDAOGroup().enhanceList(pageList, Page.class);


    }
	
	public Object listByPage(RetailscmUserContext userContext,String pageId) throws Exception {
		return listPageByPage(userContext, pageId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPage(RetailscmUserContext userContext,String pageId, int start, int count) throws Exception {
		SmartList<Slide> list = slideDaoOf(userContext).findSlideByPage(pageId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Slide.class);
		page.setContainerObject(Page.withId(pageId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("轮播内容列表");
		page.setRequestName("listByPage");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPage/%s/",  getBeanName(), pageId)));

		page.assemblerContent(userContext, "listByPage");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String slideId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getSlideDetailScope().clone();
		Slide merchantObj = (Slide) this.view(userContext, slideId);
    String merchantObjId = slideId;
    String linkToUrl =	"slideManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "轮播内容"+"详情";
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
				MapUtil.put("id", "3-displayOrder")
				    .put("fieldName", "displayOrder")
				    .put("label", "顺序")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("displayOrder", merchantObj.getDisplayOrder());

		propList.add(
				MapUtil.put("id", "4-imageUrl")
				    .put("fieldName", "imageUrl")
				    .put("label", "图片链接")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("imageUrl", merchantObj.getImageUrl());

		propList.add(
				MapUtil.put("id", "5-videoUrl")
				    .put("fieldName", "videoUrl")
				    .put("label", "视频网址")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("videoUrl", merchantObj.getVideoUrl());

		propList.add(
				MapUtil.put("id", "6-linkToUrl")
				    .put("fieldName", "linkToUrl")
				    .put("label", "链接网址")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("linkToUrl", merchantObj.getLinkToUrl());

		propList.add(
				MapUtil.put("id", "7-page")
				    .put("fieldName", "page")
				    .put("label", "页面")
				    .put("type", "auto")
				    .put("linkToUrl", "pageManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"display_order\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"page_title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("page", merchantObj.getPage());

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


