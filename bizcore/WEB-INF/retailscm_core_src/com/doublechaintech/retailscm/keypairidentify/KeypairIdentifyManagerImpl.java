
package com.doublechaintech.retailscm.keypairidentify;

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


import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

import com.doublechaintech.retailscm.secuser.CandidateSecUser;
import com.doublechaintech.retailscm.publickeytype.CandidatePublicKeyType;







public class KeypairIdentifyManagerImpl extends CustomRetailscmCheckerManager implements KeypairIdentifyManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "KeypairIdentify";
	@Override
	public KeypairIdentifyDAO daoOf(RetailscmUserContext userContext) {
		return keypairIdentifyDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws KeypairIdentifyManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new KeypairIdentifyManagerException(message);

	}



 	protected KeypairIdentify saveKeypairIdentify(RetailscmUserContext userContext, KeypairIdentify keypairIdentify, String [] tokensExpr) throws Exception{	
 		//return getKeypairIdentifyDAO().save(keypairIdentify, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveKeypairIdentify(userContext, keypairIdentify, tokens);
 	}
 	
 	protected KeypairIdentify saveKeypairIdentifyDetail(RetailscmUserContext userContext, KeypairIdentify keypairIdentify) throws Exception{	

 		
 		return saveKeypairIdentify(userContext, keypairIdentify, allTokens());
 	}
 	
 	public KeypairIdentify loadKeypairIdentify(RetailscmUserContext userContext, String keypairIdentifyId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( KeypairIdentifyManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		KeypairIdentify keypairIdentify = loadKeypairIdentify( userContext, keypairIdentifyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,keypairIdentify, tokens);
 	}
 	
 	
 	 public KeypairIdentify searchKeypairIdentify(RetailscmUserContext userContext, String keypairIdentifyId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( KeypairIdentifyManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		KeypairIdentify keypairIdentify = loadKeypairIdentify( userContext, keypairIdentifyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,keypairIdentify, tokens);
 	}
 	
 	

 	protected KeypairIdentify present(RetailscmUserContext userContext, KeypairIdentify keypairIdentify, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,keypairIdentify,tokens);
		
		
		KeypairIdentify  keypairIdentifyToPresent = keypairIdentifyDaoOf(userContext).present(keypairIdentify, tokens);
		
		List<BaseEntity> entityListToNaming = keypairIdentifyToPresent.collectRefercencesFromLists();
		keypairIdentifyDaoOf(userContext).alias(entityListToNaming);
		
		return  keypairIdentifyToPresent;
		
		
	}
 
 	
 	
 	public KeypairIdentify loadKeypairIdentifyDetail(RetailscmUserContext userContext, String keypairIdentifyId) throws Exception{	
 		KeypairIdentify keypairIdentify = loadKeypairIdentify( userContext, keypairIdentifyId, allTokens());
 		return present(userContext,keypairIdentify, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String keypairIdentifyId) throws Exception{	
 		KeypairIdentify keypairIdentify = loadKeypairIdentify( userContext, keypairIdentifyId, viewTokens());
 		return present(userContext,keypairIdentify, allTokens());
		
 	}
 	protected KeypairIdentify saveKeypairIdentify(RetailscmUserContext userContext, KeypairIdentify keypairIdentify, Map<String,Object>tokens) throws Exception{	
 		return keypairIdentifyDaoOf(userContext).save(keypairIdentify, tokens);
 	}
 	protected KeypairIdentify loadKeypairIdentify(RetailscmUserContext userContext, String keypairIdentifyId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( KeypairIdentifyManagerException.class);

 
 		return keypairIdentifyDaoOf(userContext).load(keypairIdentifyId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, KeypairIdentify keypairIdentify, Map<String, Object> tokens){
		super.addActions(userContext, keypairIdentify, tokens);
		
		addAction(userContext, keypairIdentify, tokens,"@create","createKeypairIdentify","createKeypairIdentify/","main","primary");
		addAction(userContext, keypairIdentify, tokens,"@update","updateKeypairIdentify","updateKeypairIdentify/"+keypairIdentify.getId()+"/","main","primary");
		addAction(userContext, keypairIdentify, tokens,"@copy","cloneKeypairIdentify","cloneKeypairIdentify/"+keypairIdentify.getId()+"/","main","primary");
		
		addAction(userContext, keypairIdentify, tokens,"keypair_identify.transfer_to_key_type","transferToAnotherKeyType","transferToAnotherKeyType/"+keypairIdentify.getId()+"/","main","primary");
		addAction(userContext, keypairIdentify, tokens,"keypair_identify.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+keypairIdentify.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, KeypairIdentify keypairIdentify, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public KeypairIdentify createKeypairIdentify(RetailscmUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception
	//public KeypairIdentify createKeypairIdentify(RetailscmUserContext userContext,String publicKey, String keyTypeId, String secUserId) throws Exception
	{

		

		

		checkerOf(userContext).checkPublicKeyOfKeypairIdentify(publicKey);
	
		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);


		KeypairIdentify keypairIdentify=createNewKeypairIdentify();	

		keypairIdentify.setPublicKey(publicKey);
			
		PublicKeyType keyType = loadPublicKeyType(userContext, keyTypeId,emptyOptions());
		keypairIdentify.setKeyType(keyType);
		
		
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		keypairIdentify.setSecUser(secUser);
		
		
		keypairIdentify.setCreateTime(userContext.now());

		keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, emptyOptions());
		
		onNewInstanceCreated(userContext, keypairIdentify);
		return keypairIdentify;


	}
	protected KeypairIdentify createNewKeypairIdentify()
	{

		return new KeypairIdentify();
	}

	protected void checkParamsForUpdatingKeypairIdentify(RetailscmUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify( keypairIdentifyVersion);
		

		if(KeypairIdentify.PUBLIC_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPublicKeyOfKeypairIdentify(parseString(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);


	}



	public KeypairIdentify clone(RetailscmUserContext userContext, String fromKeypairIdentifyId) throws Exception{

		return keypairIdentifyDaoOf(userContext).clone(fromKeypairIdentifyId, this.allTokens());
	}

	public KeypairIdentify internalSaveKeypairIdentify(RetailscmUserContext userContext, KeypairIdentify keypairIdentify) throws Exception
	{
		return internalSaveKeypairIdentify(userContext, keypairIdentify, allTokens());

	}
	public KeypairIdentify internalSaveKeypairIdentify(RetailscmUserContext userContext, KeypairIdentify keypairIdentify, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingKeypairIdentify(userContext, keypairIdentifyId, keypairIdentifyVersion, property, newValueExpr, tokensExpr);


		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to KeypairIdentify.
			if (keypairIdentify.isChanged()){
			
			}
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, options);
			return keypairIdentify;

		}

	}

	public KeypairIdentify updateKeypairIdentify(RetailscmUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeypairIdentify(userContext, keypairIdentifyId, keypairIdentifyVersion, property, newValueExpr, tokensExpr);



		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());
		if(keypairIdentify.getVersion() != keypairIdentifyVersion){
			String message = "The target version("+keypairIdentify.getVersion()+") is not equals to version("+keypairIdentifyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to KeypairIdentify.
			
			keypairIdentify.changeProperty(property, newValueExpr);
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, tokens().done());
			return present(userContext,keypairIdentify, mergedAllTokens(tokensExpr));
			//return saveKeypairIdentify(userContext, keypairIdentify, tokens().done());
		}

	}

	public KeypairIdentify updateKeypairIdentifyProperty(RetailscmUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeypairIdentify(userContext, keypairIdentifyId, keypairIdentifyVersion, property, newValueExpr, tokensExpr);

		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());
		if(keypairIdentify.getVersion() != keypairIdentifyVersion){
			String message = "The target version("+keypairIdentify.getVersion()+") is not equals to version("+keypairIdentifyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to KeypairIdentify.

			keypairIdentify.changeProperty(property, newValueExpr);
			
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, tokens().done());
			return present(userContext,keypairIdentify, mergedAllTokens(tokensExpr));
			//return saveKeypairIdentify(userContext, keypairIdentify, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected KeypairIdentifyTokens tokens(){
		return KeypairIdentifyTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return KeypairIdentifyTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return KeypairIdentifyTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherKeyType(RetailscmUserContext userContext, String keypairIdentifyId, String anotherKeyTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
 		checkerOf(userContext).checkIdOfPublicKeyType(anotherKeyTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);

 	}
 	public KeypairIdentify transferToAnotherKeyType(RetailscmUserContext userContext, String keypairIdentifyId, String anotherKeyTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherKeyType(userContext, keypairIdentifyId,anotherKeyTypeId);
 
		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());	
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PublicKeyType keyType = loadPublicKeyType(userContext, anotherKeyTypeId, emptyOptions());		
			keypairIdentify.updateKeyType(keyType);		
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, emptyOptions());
			
			return present(userContext,keypairIdentify, allTokens());
			
		}

 	}

	


	public CandidatePublicKeyType requestCandidateKeyType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePublicKeyType result = new CandidatePublicKeyType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PublicKeyType> candidateList = publicKeyTypeDaoOf(userContext).requestCandidatePublicKeyTypeForKeypairIdentify(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherSecUser(RetailscmUserContext userContext, String keypairIdentifyId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);

 	}
 	public KeypairIdentify transferToAnotherSecUser(RetailscmUserContext userContext, String keypairIdentifyId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, keypairIdentifyId,anotherSecUserId);
 
		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());	
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			keypairIdentify.updateSecUser(secUser);		
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, emptyOptions());
			
			return present(userContext,keypairIdentify, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(RetailscmUserContext userContext, String keypairIdentifyId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);

 	}

 	public KeypairIdentify transferToAnotherSecUserWithLogin(RetailscmUserContext userContext, String keypairIdentifyId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, keypairIdentifyId,anotherLogin);
 		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			keypairIdentify.updateSecUser(secUser);
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, emptyOptions());

			return present(userContext,keypairIdentify, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(RetailscmUserContext userContext, String keypairIdentifyId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);

 	}

 	public KeypairIdentify transferToAnotherSecUserWithEmail(RetailscmUserContext userContext, String keypairIdentifyId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, keypairIdentifyId,anotherEmail);
 		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			keypairIdentify.updateSecUser(secUser);
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, emptyOptions());

			return present(userContext,keypairIdentify, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(RetailscmUserContext userContext, String keypairIdentifyId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(KeypairIdentifyManagerException.class);

 	}

 	public KeypairIdentify transferToAnotherSecUserWithMobile(RetailscmUserContext userContext, String keypairIdentifyId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, keypairIdentifyId,anotherMobile);
 		KeypairIdentify keypairIdentify = loadKeypairIdentify(userContext, keypairIdentifyId, allTokens());
		synchronized(keypairIdentify){
			//will be good when the keypairIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			keypairIdentify.updateSecUser(secUser);
			keypairIdentify = saveKeypairIdentify(userContext, keypairIdentify, emptyOptions());

			return present(userContext,keypairIdentify, allTokens());

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
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForKeypairIdentify(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected PublicKeyType loadPublicKeyType(RetailscmUserContext userContext, String newKeyTypeId, Map<String,Object> options) throws Exception
 	{

 		return publicKeyTypeDaoOf(userContext).load(newKeyTypeId, options);
 	}
 	


	

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

	public void delete(RetailscmUserContext userContext, String keypairIdentifyId, int keypairIdentifyVersion) throws Exception {
		//deleteInternal(userContext, keypairIdentifyId, keypairIdentifyVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String keypairIdentifyId, int keypairIdentifyVersion) throws Exception{

		keypairIdentifyDaoOf(userContext).delete(keypairIdentifyId, keypairIdentifyVersion);
	}

	public KeypairIdentify forgetByAll(RetailscmUserContext userContext, String keypairIdentifyId, int keypairIdentifyVersion) throws Exception {
		return forgetByAllInternal(userContext, keypairIdentifyId, keypairIdentifyVersion);
	}
	protected KeypairIdentify forgetByAllInternal(RetailscmUserContext userContext,
			String keypairIdentifyId, int keypairIdentifyVersion) throws Exception{

		return keypairIdentifyDaoOf(userContext).disconnectFromAll(keypairIdentifyId, keypairIdentifyVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new KeypairIdentifyManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return keypairIdentifyDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, KeypairIdentify newCreated) throws Exception{
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
		//   KeypairIdentify newKeypairIdentify = this.createKeypairIdentify(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newKeypairIdentify
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, KeypairIdentify.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<KeypairIdentify> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<PublicKeyType> keyTypeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PublicKeyType.class);
		userContext.getDAOGroup().enhanceList(keyTypeList, PublicKeyType.class);
		List<SecUser> secUserList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listByKeyType(RetailscmUserContext userContext,String keyTypeId) throws Exception {
		return listPageByKeyType(userContext, keyTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByKeyType(RetailscmUserContext userContext,String keyTypeId, int start, int count) throws Exception {
		SmartList<KeypairIdentify> list = keypairIdentifyDaoOf(userContext).findKeypairIdentifyByKeyType(keyTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(KeypairIdentify.class);
		page.setContainerObject(PublicKeyType.withId(keyTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("密钥对识别列表");
		page.setRequestName("listByKeyType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByKeyType/%s/",  getBeanName(), keyTypeId)));

		page.assemblerContent(userContext, "listByKeyType");
		return page.doRender(userContext);
	}
  
	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<KeypairIdentify> list = keypairIdentifyDaoOf(userContext).findKeypairIdentifyBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(KeypairIdentify.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("密钥对识别列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String keypairIdentifyId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getKeypairIdentifyDetailScope().clone();
		KeypairIdentify merchantObj = (KeypairIdentify) this.view(userContext, keypairIdentifyId);
    String merchantObjId = keypairIdentifyId;
    String linkToUrl =	"keypairIdentifyManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "密钥对识别"+"详情";
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
				MapUtil.put("id", "2-publicKey")
				    .put("fieldName", "publicKey")
				    .put("label", "公钥")
				    .put("type", "longtext")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("publicKey", merchantObj.getPublicKey());

		propList.add(
				MapUtil.put("id", "3-keyType")
				    .put("fieldName", "keyType")
				    .put("label", "密钥类型")
				    .put("type", "auto")
				    .put("linkToUrl", "publicKeyTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("keyType", merchantObj.getKeyType());

		propList.add(
				MapUtil.put("id", "4-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "SEC的用户")
				    .put("type", "auto")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

		propList.add(
				MapUtil.put("id", "5-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

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


