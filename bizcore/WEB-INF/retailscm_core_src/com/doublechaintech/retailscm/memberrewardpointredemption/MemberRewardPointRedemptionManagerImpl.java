
package com.doublechaintech.retailscm.memberrewardpointredemption;

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


import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;







public class MemberRewardPointRedemptionManagerImpl extends CustomRetailscmCheckerManager implements MemberRewardPointRedemptionManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "MemberRewardPointRedemption";
	@Override
	public MemberRewardPointRedemptionDAO daoOf(RetailscmUserContext userContext) {
		return memberRewardPointRedemptionDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws MemberRewardPointRedemptionManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new MemberRewardPointRedemptionManagerException(message);

	}



 	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, String [] tokensExpr) throws Exception{	
 		//return getMemberRewardPointRedemptionDAO().save(memberRewardPointRedemption, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens);
 	}
 	
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemptionDetail(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception{	

 		
 		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, allTokens());
 	}
 	
 	public MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).throwExceptionIfHasErrors( MemberRewardPointRedemptionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberRewardPointRedemption, tokens);
 	}
 	
 	
 	 public MemberRewardPointRedemption searchMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).throwExceptionIfHasErrors( MemberRewardPointRedemptionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberRewardPointRedemption, tokens);
 	}
 	
 	

 	protected MemberRewardPointRedemption present(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberRewardPointRedemption,tokens);
		
		
		MemberRewardPointRedemption  memberRewardPointRedemptionToPresent = memberRewardPointRedemptionDaoOf(userContext).present(memberRewardPointRedemption, tokens);
		
		List<BaseEntity> entityListToNaming = memberRewardPointRedemptionToPresent.collectRefercencesFromLists();
		memberRewardPointRedemptionDaoOf(userContext).alias(entityListToNaming);
		
		return  memberRewardPointRedemptionToPresent;
		
		
	}
 
 	
 	
 	public MemberRewardPointRedemption loadMemberRewardPointRedemptionDetail(RetailscmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{	
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, allTokens());
 		return present(userContext,memberRewardPointRedemption, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{	
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, viewTokens());
 		return present(userContext,memberRewardPointRedemption, allTokens());
		
 	}
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object>tokens) throws Exception{	
 		return memberRewardPointRedemptionDaoOf(userContext).save(memberRewardPointRedemption, tokens);
 	}
 	protected MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).throwExceptionIfHasErrors( MemberRewardPointRedemptionManagerException.class);

 
 		return memberRewardPointRedemptionDaoOf(userContext).load(memberRewardPointRedemptionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens){
		super.addActions(userContext, memberRewardPointRedemption, tokens);
		
		addAction(userContext, memberRewardPointRedemption, tokens,"@create","createMemberRewardPointRedemption","createMemberRewardPointRedemption/","main","primary");
		addAction(userContext, memberRewardPointRedemption, tokens,"@update","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+memberRewardPointRedemption.getId()+"/","main","primary");
		addAction(userContext, memberRewardPointRedemption, tokens,"@copy","cloneMemberRewardPointRedemption","cloneMemberRewardPointRedemption/"+memberRewardPointRedemption.getId()+"/","main","primary");
		
		addAction(userContext, memberRewardPointRedemption, tokens,"member_reward_point_redemption.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberRewardPointRedemption.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public MemberRewardPointRedemption createMemberRewardPointRedemption(RetailscmUserContext userContext, String name,int point,String ownerId) throws Exception
	//public MemberRewardPointRedemption createMemberRewardPointRedemption(RetailscmUserContext userContext,String name, int point, String ownerId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfMemberRewardPointRedemption(name);
		checkerOf(userContext).checkPointOfMemberRewardPointRedemption(point);
	
		checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointRedemptionManagerException.class);


		MemberRewardPointRedemption memberRewardPointRedemption=createNewMemberRewardPointRedemption();	

		memberRewardPointRedemption.setName(name);
		memberRewardPointRedemption.setPoint(point);
			
		RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId,emptyOptions());
		memberRewardPointRedemption.setOwner(owner);
		
		

		memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, emptyOptions());
		
		onNewInstanceCreated(userContext, memberRewardPointRedemption);
		return memberRewardPointRedemption;


	}
	protected MemberRewardPointRedemption createNewMemberRewardPointRedemption()
	{

		return new MemberRewardPointRedemption();
	}

	protected void checkParamsForUpdatingMemberRewardPointRedemption(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption( memberRewardPointRedemptionVersion);
		

		if(MemberRewardPointRedemption.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfMemberRewardPointRedemption(parseString(newValueExpr));
		
			
		}
		if(MemberRewardPointRedemption.POINT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPointOfMemberRewardPointRedemption(parseInt(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointRedemptionManagerException.class);


	}



	public MemberRewardPointRedemption clone(RetailscmUserContext userContext, String fromMemberRewardPointRedemptionId) throws Exception{

		return memberRewardPointRedemptionDaoOf(userContext).clone(fromMemberRewardPointRedemptionId, this.allTokens());
	}

	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception
	{
		return internalSaveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, allTokens());

	}
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);


		synchronized(memberRewardPointRedemption){
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.
			if (memberRewardPointRedemption.isChanged()){
			
			}
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, options);
			return memberRewardPointRedemption;

		}

	}

	public MemberRewardPointRedemption updateMemberRewardPointRedemption(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);



		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());
		if(memberRewardPointRedemption.getVersion() != memberRewardPointRedemptionVersion){
			String message = "The target version("+memberRewardPointRedemption.getVersion()+") is not equals to version("+memberRewardPointRedemptionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberRewardPointRedemption){
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.
			
			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
			return present(userContext,memberRewardPointRedemption, mergedAllTokens(tokensExpr));
			//return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
		}

	}

	public MemberRewardPointRedemption updateMemberRewardPointRedemptionProperty(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());
		if(memberRewardPointRedemption.getVersion() != memberRewardPointRedemptionVersion){
			String message = "The target version("+memberRewardPointRedemption.getVersion()+") is not equals to version("+memberRewardPointRedemptionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberRewardPointRedemption){
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.

			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
			return present(userContext,memberRewardPointRedemption, mergedAllTokens(tokensExpr));
			//return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected MemberRewardPointRedemptionTokens tokens(){
		return MemberRewardPointRedemptionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberRewardPointRedemptionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberRewardPointRedemptionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
 		checkerOf(userContext).checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointRedemptionManagerException.class);

 	}
 	public MemberRewardPointRedemption transferToAnotherOwner(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberRewardPointRedemptionId,anotherOwnerId);
 
		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());	
		synchronized(memberRewardPointRedemption){
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());		
			memberRewardPointRedemption.updateOwner(owner);		
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, emptyOptions());
			
			return present(userContext,memberRewardPointRedemption, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreMember requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMember> candidateList = retailStoreMemberDaoOf(userContext).requestCandidateRetailStoreMemberForMemberRewardPointRedemption(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreMemberDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception {
		//deleteInternal(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception{

		memberRewardPointRedemptionDaoOf(userContext).delete(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}

	public MemberRewardPointRedemption forgetByAll(RetailscmUserContext userContext, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception {
		return forgetByAllInternal(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}
	protected MemberRewardPointRedemption forgetByAllInternal(RetailscmUserContext userContext,
			String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception{

		return memberRewardPointRedemptionDaoOf(userContext).disconnectFromAll(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberRewardPointRedemptionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return memberRewardPointRedemptionDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberRewardPointRedemption newCreated) throws Exception{
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
		//   MemberRewardPointRedemption newMemberRewardPointRedemption = this.createMemberRewardPointRedemption(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newMemberRewardPointRedemption
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, MemberRewardPointRedemption.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<MemberRewardPointRedemption> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreMember> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreMember.class);
		userContext.getDAOGroup().enhanceList(ownerList, RetailStoreMember.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<MemberRewardPointRedemption> list = memberRewardPointRedemptionDaoOf(userContext).findMemberRewardPointRedemptionByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(MemberRewardPointRedemption.class);
		page.setContainerObject(RetailStoreMember.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会员奖励点赎回列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getMemberRewardPointRedemptionDetailScope().clone();
		MemberRewardPointRedemption merchantObj = (MemberRewardPointRedemption) this.view(userContext, memberRewardPointRedemptionId);
    String merchantObjId = memberRewardPointRedemptionId;
    String linkToUrl =	"memberRewardPointRedemptionManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会员奖励点赎回"+"详情";
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
				MapUtil.put("id", "3-point")
				    .put("fieldName", "point")
				    .put("label", "点")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("point", merchantObj.getPoint());

		propList.add(
				MapUtil.put("id", "4-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

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


