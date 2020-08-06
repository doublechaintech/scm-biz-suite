
package com.doublechaintech.retailscm.wechatworkappidentity;

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



import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.CandidateSecUser;







public class WechatWorkappIdentityManagerImpl extends CustomRetailscmCheckerManager implements WechatWorkappIdentityManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "WechatWorkappIdentity";
	@Override
	public WechatWorkappIdentityDAO daoOf(RetailscmUserContext userContext) {
		return wechatWorkappIdentityDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws WechatWorkappIdentityManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new WechatWorkappIdentityManagerException(message);

	}



 	protected WechatWorkappIdentity saveWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity, String [] tokensExpr) throws Exception{	
 		//return getWechatWorkappIdentityDAO().save(wechatWorkappIdentity, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens);
 	}
 	
 	protected WechatWorkappIdentity saveWechatWorkappIdentityDetail(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity) throws Exception{	

 		
 		return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, allTokens());
 	}
 	
 	public WechatWorkappIdentity loadWechatWorkappIdentity(RetailscmUserContext userContext, String wechatWorkappIdentityId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatWorkappIdentityManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity( userContext, wechatWorkappIdentityId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatWorkappIdentity, tokens);
 	}
 	
 	
 	 public WechatWorkappIdentity searchWechatWorkappIdentity(RetailscmUserContext userContext, String wechatWorkappIdentityId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatWorkappIdentityManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity( userContext, wechatWorkappIdentityId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatWorkappIdentity, tokens);
 	}
 	
 	

 	protected WechatWorkappIdentity present(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,wechatWorkappIdentity,tokens);
		
		
		WechatWorkappIdentity  wechatWorkappIdentityToPresent = wechatWorkappIdentityDaoOf(userContext).present(wechatWorkappIdentity, tokens);
		
		List<BaseEntity> entityListToNaming = wechatWorkappIdentityToPresent.collectRefercencesFromLists();
		wechatWorkappIdentityDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,wechatWorkappIdentity,tokens);
		
		return  wechatWorkappIdentityToPresent;
		
		
	}
 
 	
 	
 	public WechatWorkappIdentity loadWechatWorkappIdentityDetail(RetailscmUserContext userContext, String wechatWorkappIdentityId) throws Exception{	
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity( userContext, wechatWorkappIdentityId, allTokens());
 		return present(userContext,wechatWorkappIdentity, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String wechatWorkappIdentityId) throws Exception{	
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity( userContext, wechatWorkappIdentityId, viewTokens());
 		return present(userContext,wechatWorkappIdentity, allTokens());
		
 	}
 	protected WechatWorkappIdentity saveWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity, Map<String,Object>tokens) throws Exception{	
 		return wechatWorkappIdentityDaoOf(userContext).save(wechatWorkappIdentity, tokens);
 	}
 	protected WechatWorkappIdentity loadWechatWorkappIdentity(RetailscmUserContext userContext, String wechatWorkappIdentityId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatWorkappIdentityManagerException.class);

 
 		return wechatWorkappIdentityDaoOf(userContext).load(wechatWorkappIdentityId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity, Map<String, Object> tokens){
		super.addActions(userContext, wechatWorkappIdentity, tokens);
		
		addAction(userContext, wechatWorkappIdentity, tokens,"@create","createWechatWorkappIdentity","createWechatWorkappIdentity/","main","primary");
		addAction(userContext, wechatWorkappIdentity, tokens,"@update","updateWechatWorkappIdentity","updateWechatWorkappIdentity/"+wechatWorkappIdentity.getId()+"/","main","primary");
		addAction(userContext, wechatWorkappIdentity, tokens,"@copy","cloneWechatWorkappIdentity","cloneWechatWorkappIdentity/"+wechatWorkappIdentity.getId()+"/","main","primary");
		
		addAction(userContext, wechatWorkappIdentity, tokens,"wechat_workapp_identity.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+wechatWorkappIdentity.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public WechatWorkappIdentity createWechatWorkappIdentity(RetailscmUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception
	//public WechatWorkappIdentity createWechatWorkappIdentity(RetailscmUserContext userContext,String corpId, String userId, String secUserId, DateTime lastLoginTime) throws Exception
	{

		

		

		checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity(corpId);
		checkerOf(userContext).checkUserIdOfWechatWorkappIdentity(userId);
		checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentity(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);


		WechatWorkappIdentity wechatWorkappIdentity=createNewWechatWorkappIdentity();	

		wechatWorkappIdentity.setCorpId(corpId);
		wechatWorkappIdentity.setUserId(userId);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		wechatWorkappIdentity.setSecUser(secUser);
		
		
		wechatWorkappIdentity.setCreateTime(userContext.now());
		wechatWorkappIdentity.setLastLoginTime(lastLoginTime);

		wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());
		
		onNewInstanceCreated(userContext, wechatWorkappIdentity);
		return wechatWorkappIdentity;


	}
	protected WechatWorkappIdentity createNewWechatWorkappIdentity()
	{

		return new WechatWorkappIdentity();
	}

	protected void checkParamsForUpdatingWechatWorkappIdentity(RetailscmUserContext userContext,String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentity( wechatWorkappIdentityVersion);
		

		if(WechatWorkappIdentity.CORP_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity(parseString(newValueExpr));
		
			
		}
		if(WechatWorkappIdentity.USER_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUserIdOfWechatWorkappIdentity(parseString(newValueExpr));
		
			
		}		

		
		if(WechatWorkappIdentity.LAST_LOGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentity(parseTimestamp(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);


	}



	public WechatWorkappIdentity clone(RetailscmUserContext userContext, String fromWechatWorkappIdentityId) throws Exception{

		return wechatWorkappIdentityDaoOf(userContext).clone(fromWechatWorkappIdentityId, this.allTokens());
	}

	public WechatWorkappIdentity internalSaveWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity) throws Exception
	{
		return internalSaveWechatWorkappIdentity(userContext, wechatWorkappIdentity, allTokens());

	}
	public WechatWorkappIdentity internalSaveWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingWechatWorkappIdentity(userContext, wechatWorkappIdentityId, wechatWorkappIdentityVersion, property, newValueExpr, tokensExpr);


		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatWorkappIdentity.
			if (wechatWorkappIdentity.isChanged()){
			
			}
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, options);
			return wechatWorkappIdentity;

		}

	}

	public WechatWorkappIdentity updateWechatWorkappIdentity(RetailscmUserContext userContext,String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatWorkappIdentity(userContext, wechatWorkappIdentityId, wechatWorkappIdentityVersion, property, newValueExpr, tokensExpr);



		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
		if(wechatWorkappIdentity.getVersion() != wechatWorkappIdentityVersion){
			String message = "The target version("+wechatWorkappIdentity.getVersion()+") is not equals to version("+wechatWorkappIdentityVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatWorkappIdentity.
			
			wechatWorkappIdentity.changeProperty(property, newValueExpr);
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
			return present(userContext,wechatWorkappIdentity, mergedAllTokens(tokensExpr));
			//return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
		}

	}

	public WechatWorkappIdentity updateWechatWorkappIdentityProperty(RetailscmUserContext userContext,String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatWorkappIdentity(userContext, wechatWorkappIdentityId, wechatWorkappIdentityVersion, property, newValueExpr, tokensExpr);

		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
		if(wechatWorkappIdentity.getVersion() != wechatWorkappIdentityVersion){
			String message = "The target version("+wechatWorkappIdentity.getVersion()+") is not equals to version("+wechatWorkappIdentityVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatWorkappIdentity.

			wechatWorkappIdentity.changeProperty(property, newValueExpr);
			
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
			return present(userContext,wechatWorkappIdentity, mergedAllTokens(tokensExpr));
			//return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected WechatWorkappIdentityTokens tokens(){
		return WechatWorkappIdentityTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WechatWorkappIdentityTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WechatWorkappIdentityTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

 	}
 	public WechatWorkappIdentity transferToAnotherSecUser(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, wechatWorkappIdentityId,anotherSecUserId);
 
		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());	
		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			wechatWorkappIdentity.updateSecUser(secUser);		
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());
			
			return present(userContext,wechatWorkappIdentity, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

 	}

 	public WechatWorkappIdentity transferToAnotherSecUserWithLogin(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, wechatWorkappIdentityId,anotherLogin);
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			wechatWorkappIdentity.updateSecUser(secUser);
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

			return present(userContext,wechatWorkappIdentity, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

 	}

 	public WechatWorkappIdentity transferToAnotherSecUserWithEmail(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, wechatWorkappIdentityId,anotherEmail);
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			wechatWorkappIdentity.updateSecUser(secUser);
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

			return present(userContext,wechatWorkappIdentity, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

 	}

 	public WechatWorkappIdentity transferToAnotherSecUserWithMobile(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, wechatWorkappIdentityId,anotherMobile);
 		WechatWorkappIdentity wechatWorkappIdentity = loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
		synchronized(wechatWorkappIdentity){
			//will be good when the wechatWorkappIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			wechatWorkappIdentity.updateSecUser(secUser);
			wechatWorkappIdentity = saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

			return present(userContext,wechatWorkappIdentity, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForWechatWorkappIdentity(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SecUser loadSecUser(RetailscmUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(RetailscmUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(RetailscmUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(RetailscmUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion) throws Exception {
		//deleteInternal(userContext, wechatWorkappIdentityId, wechatWorkappIdentityVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String wechatWorkappIdentityId, int wechatWorkappIdentityVersion) throws Exception{

		wechatWorkappIdentityDaoOf(userContext).delete(wechatWorkappIdentityId, wechatWorkappIdentityVersion);
	}

	public WechatWorkappIdentity forgetByAll(RetailscmUserContext userContext, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion) throws Exception {
		return forgetByAllInternal(userContext, wechatWorkappIdentityId, wechatWorkappIdentityVersion);
	}
	protected WechatWorkappIdentity forgetByAllInternal(RetailscmUserContext userContext,
			String wechatWorkappIdentityId, int wechatWorkappIdentityVersion) throws Exception{

		return wechatWorkappIdentityDaoOf(userContext).disconnectFromAll(wechatWorkappIdentityId, wechatWorkappIdentityVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WechatWorkappIdentityManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return wechatWorkappIdentityDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, WechatWorkappIdentity newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    wechatWorkappIdentityDaoOf(ctx).loadAllAsStream().forEach(
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
		//   WechatWorkappIdentity newWechatWorkappIdentity = this.createWechatWorkappIdentity(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newWechatWorkappIdentity
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, WechatWorkappIdentity.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<WechatWorkappIdentity> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SecUser> secUserList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<WechatWorkappIdentity> list = wechatWorkappIdentityDaoOf(userContext).findWechatWorkappIdentityBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(WechatWorkappIdentity.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("微信企业号认证列表");
		page.setRequestName("listBySecUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/",  getBeanName(), secUserId)));

		page.assemblerContent(userContext, "listBySecUser");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String wechatWorkappIdentityId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getWechatWorkappIdentityDetailScope().clone();
		WechatWorkappIdentity merchantObj = (WechatWorkappIdentity) this.view(userContext, wechatWorkappIdentityId);
    String merchantObjId = wechatWorkappIdentityId;
    String linkToUrl =	"wechatWorkappIdentityManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "微信企业号认证"+"详情";
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
				MapUtil.put("id", "2-corpId")
				    .put("fieldName", "corpId")
				    .put("label", "公司标识")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("corpId", merchantObj.getCorpId());

		propList.add(
				MapUtil.put("id", "3-userId")
				    .put("fieldName", "userId")
				    .put("label", "用户Id")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("userId", merchantObj.getUserId());

		propList.add(
				MapUtil.put("id", "4-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "安全用户")
				    .put("type", "auto")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

		propList.add(
				MapUtil.put("id", "5-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

		propList.add(
				MapUtil.put("id", "6-lastLoginTime")
				    .put("fieldName", "lastLoginTime")
				    .put("label", "最后登录时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastLoginTime", merchantObj.getLastLoginTime());

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


