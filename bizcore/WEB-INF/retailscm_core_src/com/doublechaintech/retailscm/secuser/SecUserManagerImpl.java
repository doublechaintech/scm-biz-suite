
package com.doublechaintech.retailscm.secuser;

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


import com.doublechaintech.retailscm.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentify;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

import com.doublechaintech.retailscm.userdomain.CandidateUserDomain;

import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;






public class SecUserManagerImpl extends CustomRetailscmCheckerManager implements SecUserManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "SecUser";
	@Override
	public SecUserDAO daoOf(RetailscmUserContext userContext) {
		return secUserDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SecUserManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SecUserManagerException(message);

	}



 	protected SecUser saveSecUser(RetailscmUserContext userContext, SecUser secUser, String [] tokensExpr) throws Exception{	
 		//return getSecUserDAO().save(secUser, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSecUser(userContext, secUser, tokens);
 	}
 	
 	protected SecUser saveSecUserDetail(RetailscmUserContext userContext, SecUser secUser) throws Exception{	

 		
 		return saveSecUser(userContext, secUser, allTokens());
 	}
 	
 	public SecUser loadSecUser(RetailscmUserContext userContext, String secUserId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SecUser secUser = loadSecUser( userContext, secUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUser, tokens);
 	}
 	
 	
 	 public SecUser searchSecUser(RetailscmUserContext userContext, String secUserId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SecUser secUser = loadSecUser( userContext, secUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUser, tokens);
 	}
 	
 	

 	protected SecUser present(RetailscmUserContext userContext, SecUser secUser, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,secUser,tokens);
		
		
		SecUser  secUserToPresent = secUserDaoOf(userContext).present(secUser, tokens);
		
		List<BaseEntity> entityListToNaming = secUserToPresent.collectRefercencesFromLists();
		secUserDaoOf(userContext).alias(entityListToNaming);
		
		return  secUserToPresent;
		
		
	}
 
 	
 	
 	public SecUser loadSecUserDetail(RetailscmUserContext userContext, String secUserId) throws Exception{	
 		SecUser secUser = loadSecUser( userContext, secUserId, allTokens());
 		return present(userContext,secUser, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String secUserId) throws Exception{	
 		SecUser secUser = loadSecUser( userContext, secUserId, viewTokens());
 		return present(userContext,secUser, allTokens());
		
 	}
 	protected SecUser saveSecUser(RetailscmUserContext userContext, SecUser secUser, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).save(secUser, tokens);
 	}
 	protected SecUser loadSecUser(RetailscmUserContext userContext, String secUserId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserManagerException.class);

 
 		return secUserDaoOf(userContext).load(secUserId, tokens);
 	}

	
	

	public SecUser loadSecUserWithLogin(RetailscmUserContext userContext, String login, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).loadByLogin(login, tokens);
 	}

	 
	

	public SecUser loadSecUserWithEmail(RetailscmUserContext userContext, String email, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).loadByEmail(email, tokens);
 	}

	 
	

	public SecUser loadSecUserWithMobile(RetailscmUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).loadByMobile(mobile, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SecUser secUser, Map<String, Object> tokens){
		super.addActions(userContext, secUser, tokens);
		
		addAction(userContext, secUser, tokens,"@create","createSecUser","createSecUser/","main","primary");
		addAction(userContext, secUser, tokens,"@update","updateSecUser","updateSecUser/"+secUser.getId()+"/","main","primary");
		addAction(userContext, secUser, tokens,"@copy","cloneSecUser","cloneSecUser/"+secUser.getId()+"/","main","primary");
		
		addAction(userContext, secUser, tokens,"sec_user.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+secUser.getId()+"/","main","primary");
		addAction(userContext, secUser, tokens,"sec_user.addUserApp","addUserApp","addUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeUserApp","removeUserApp","removeUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateUserApp","updateUserApp","updateUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyUserAppFrom","copyUserAppFrom","copyUserAppFrom/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addLoginHistory","addLoginHistory","addLoginHistory/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeLoginHistory","removeLoginHistory","removeLoginHistory/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateLoginHistory","updateLoginHistory","updateLoginHistory/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyLoginHistoryFrom","copyLoginHistoryFrom","copyLoginHistoryFrom/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addWechatWorkappIdentify","addWechatWorkappIdentify","addWechatWorkappIdentify/"+secUser.getId()+"/","wechatWorkappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeWechatWorkappIdentify","removeWechatWorkappIdentify","removeWechatWorkappIdentify/"+secUser.getId()+"/","wechatWorkappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateWechatWorkappIdentify","updateWechatWorkappIdentify","updateWechatWorkappIdentify/"+secUser.getId()+"/","wechatWorkappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyWechatWorkappIdentifyFrom","copyWechatWorkappIdentifyFrom","copyWechatWorkappIdentifyFrom/"+secUser.getId()+"/","wechatWorkappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addWechatMiniappIdentify","addWechatMiniappIdentify","addWechatMiniappIdentify/"+secUser.getId()+"/","wechatMiniappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeWechatMiniappIdentify","removeWechatMiniappIdentify","removeWechatMiniappIdentify/"+secUser.getId()+"/","wechatMiniappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateWechatMiniappIdentify","updateWechatMiniappIdentify","updateWechatMiniappIdentify/"+secUser.getId()+"/","wechatMiniappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyWechatMiniappIdentifyFrom","copyWechatMiniappIdentifyFrom","copyWechatMiniappIdentifyFrom/"+secUser.getId()+"/","wechatMiniappIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addKeypairIdentify","addKeypairIdentify","addKeypairIdentify/"+secUser.getId()+"/","keypairIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeKeypairIdentify","removeKeypairIdentify","removeKeypairIdentify/"+secUser.getId()+"/","keypairIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateKeypairIdentify","updateKeypairIdentify","updateKeypairIdentify/"+secUser.getId()+"/","keypairIdentifyList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyKeypairIdentifyFrom","copyKeypairIdentifyFrom","copyKeypairIdentifyFrom/"+secUser.getId()+"/","keypairIdentifyList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SecUser secUser, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SecUser createSecUser(RetailscmUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception
	//public SecUser createSecUser(RetailscmUserContext userContext,String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId) throws Exception
	{

		

		

		checkerOf(userContext).checkLoginOfSecUser(login);
		checkerOf(userContext).checkMobileOfSecUser(mobile);
		checkerOf(userContext).checkEmailOfSecUser(email);
		checkerOf(userContext).checkPwdOfSecUser(pwd);
		checkerOf(userContext).checkWeixinOpenidOfSecUser(weixinOpenid);
		checkerOf(userContext).checkWeixinAppidOfSecUser(weixinAppid);
		checkerOf(userContext).checkAccessTokenOfSecUser(accessToken);
		checkerOf(userContext).checkVerificationCodeOfSecUser(verificationCode);
		checkerOf(userContext).checkVerificationCodeExpireOfSecUser(verificationCodeExpire);
		checkerOf(userContext).checkLastLoginTimeOfSecUser(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


		SecUser secUser=createNewSecUser();	

		secUser.setLogin(login);
		secUser.setMobile(mobile);
		secUser.setEmail(email);
		secUser.setClearTextOfPwd(pwd);
		secUser.setWeixinOpenid(weixinOpenid);
		secUser.setWeixinAppid(weixinAppid);
		secUser.setAccessToken(accessToken);
		secUser.setVerificationCode(verificationCode);
		secUser.setVerificationCodeExpire(verificationCodeExpire);
		secUser.setLastLoginTime(lastLoginTime);
			
		UserDomain domain = loadUserDomain(userContext, domainId,emptyOptions());
		secUser.setDomain(domain);
		
		

		secUser = saveSecUser(userContext, secUser, emptyOptions());
		
		onNewInstanceCreated(userContext, secUser);
		return secUser;


	}
	protected SecUser createNewSecUser()
	{

		return new SecUser();
	}

	protected void checkParamsForUpdatingSecUser(RetailscmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser( secUserVersion);
		

		if(SecUser.LOGIN_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLoginOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.PWD_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPwdOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.WEIXIN_OPENID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWeixinOpenidOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.WEIXIN_APPID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWeixinAppidOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.ACCESS_TOKEN_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccessTokenOfSecUser(parseString(newValueExpr));
		
			
		}
		if(SecUser.VERIFICATION_CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVerificationCodeOfSecUser(parseInt(newValueExpr));
		
			
		}
		if(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVerificationCodeExpireOfSecUser(parseTimestamp(newValueExpr));
		
			
		}
		if(SecUser.LAST_LOGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLastLoginTimeOfSecUser(parseTimestamp(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}



	public SecUser clone(RetailscmUserContext userContext, String fromSecUserId) throws Exception{

		return secUserDaoOf(userContext).clone(fromSecUserId, this.allTokens());
	}

	public SecUser internalSaveSecUser(RetailscmUserContext userContext, SecUser secUser) throws Exception
	{
		return internalSaveSecUser(userContext, secUser, allTokens());

	}
	public SecUser internalSaveSecUser(RetailscmUserContext userContext, SecUser secUser, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);


		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.
			if (secUser.isChanged()){
			
			}
			secUser = saveSecUser(userContext, secUser, options);
			return secUser;

		}

	}

	public SecUser updateSecUser(RetailscmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);



		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		if(secUser.getVersion() != secUserVersion){
			String message = "The target version("+secUser.getVersion()+") is not equals to version("+secUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.
			
			secUser.changeProperty(property, newValueExpr);
			secUser = saveSecUser(userContext, secUser, tokens().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
			//return saveSecUser(userContext, secUser, tokens().done());
		}

	}

	public SecUser updateSecUserProperty(RetailscmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);

		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		if(secUser.getVersion() != secUserVersion){
			String message = "The target version("+secUser.getVersion()+") is not equals to version("+secUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.

			secUser.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
			//return saveSecUser(userContext, secUser, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SecUserTokens tokens(){
		return SecUserTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SecUserTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserAppListWith("id","desc")
		.sortLoginHistoryListWith("id","desc")
		.sortWechatWorkappIdentifyListWith("id","desc")
		.sortWechatMiniappIdentifyListWith("id","desc")
		.sortKeypairIdentifyListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SecUserTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDomain(RetailscmUserContext userContext, String secUserId, String anotherDomainId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSecUser(secUserId);
 		checkerOf(userContext).checkIdOfUserDomain(anotherDomainId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

 	}
 	public SecUser transferToAnotherDomain(RetailscmUserContext userContext, String secUserId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, secUserId,anotherDomainId);
 
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());	
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());		
			secUser.updateDomain(domain);		
			secUser = saveSecUser(userContext, secUser, emptyOptions());
			
			return present(userContext,secUser, allTokens());
			
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
		SmartList<UserDomain> candidateList = userDomainDaoOf(userContext).requestCandidateUserDomainForSecUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String secUserId, int secUserVersion) throws Exception {
		//deleteInternal(userContext, secUserId, secUserVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String secUserId, int secUserVersion) throws Exception{

		secUserDaoOf(userContext).delete(secUserId, secUserVersion);
	}

	public SecUser forgetByAll(RetailscmUserContext userContext, String secUserId, int secUserVersion) throws Exception {
		return forgetByAllInternal(userContext, secUserId, secUserVersion);
	}
	protected SecUser forgetByAllInternal(RetailscmUserContext userContext,
			String secUserId, int secUserVersion) throws Exception{

		return secUserDaoOf(userContext).disconnectFromAll(secUserId, secUserVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SecUserManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return secUserDaoOf(userContext).deleteAll();
	}


	//disconnect SecUser with object_id in UserApp
	protected SecUser breakWithUserAppByObjectId(RetailscmUserContext userContext, String secUserId, String objectIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				secUserDaoOf(userContext).planToRemoveUserAppListWithObjectId(secUser, objectIdId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
				return secUser;
			}
	}
	//disconnect SecUser with corp_id in WechatWorkappIdentify
	protected SecUser breakWithWechatWorkappIdentifyByCorpId(RetailscmUserContext userContext, String secUserId, String corpIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				secUserDaoOf(userContext).planToRemoveWechatWorkappIdentifyListWithCorpId(secUser, corpIdId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
				return secUser;
			}
	}
	//disconnect SecUser with user_id in WechatWorkappIdentify
	protected SecUser breakWithWechatWorkappIdentifyByUserId(RetailscmUserContext userContext, String secUserId, String userIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				secUserDaoOf(userContext).planToRemoveWechatWorkappIdentifyListWithUserId(secUser, userIdId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
				return secUser;
			}
	}
	//disconnect SecUser with open_id in WechatMiniappIdentify
	protected SecUser breakWithWechatMiniappIdentifyByOpenId(RetailscmUserContext userContext, String secUserId, String openIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				secUserDaoOf(userContext).planToRemoveWechatMiniappIdentifyListWithOpenId(secUser, openIdId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
				return secUser;
			}
	}
	//disconnect SecUser with app_id in WechatMiniappIdentify
	protected SecUser breakWithWechatMiniappIdentifyByAppId(RetailscmUserContext userContext, String secUserId, String appIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				secUserDaoOf(userContext).planToRemoveWechatMiniappIdentifyListWithAppId(secUser, appIdId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
				return secUser;
			}
	}
	//disconnect SecUser with key_type in KeypairIdentify
	protected SecUser breakWithKeypairIdentifyByKeyType(RetailscmUserContext userContext, String secUserId, String keyTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				secUserDaoOf(userContext).planToRemoveKeypairIdentifyListWithKeyType(secUser, keyTypeId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withKeypairIdentifyList().done());
				return secUser;
			}
	}






	protected void checkParamsForAddingUserApp(RetailscmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkTitleOfUserApp(title);
		
		checkerOf(userContext).checkAppIconOfUserApp(appIcon);
		
		checkerOf(userContext).checkFullAccessOfUserApp(fullAccess);
		
		checkerOf(userContext).checkPermissionOfUserApp(permission);
		
		checkerOf(userContext).checkObjectTypeOfUserApp(objectType);
		
		checkerOf(userContext).checkObjectIdOfUserApp(objectId);
		
		checkerOf(userContext).checkLocationOfUserApp(location);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser addUserApp(RetailscmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingUserApp(userContext,secUserId,title, appIcon, fullAccess, permission, objectType, objectId, location,tokensExpr);

		UserApp userApp = createUserApp(userContext,title, appIcon, fullAccess, permission, objectType, objectId, location);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addUserApp( userApp );
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			
			userContext.getManagerGroup().getUserAppManager().onNewInstanceCreated(userContext, userApp);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAppProperties(RetailscmUserContext userContext, String secUserId,String id,String title,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfUserApp(id);

		checkerOf(userContext).checkTitleOfUserApp( title);
		checkerOf(userContext).checkAppIconOfUserApp( appIcon);
		checkerOf(userContext).checkFullAccessOfUserApp( fullAccess);
		checkerOf(userContext).checkPermissionOfUserApp( permission);
		checkerOf(userContext).checkObjectTypeOfUserApp( objectType);
		checkerOf(userContext).checkObjectIdOfUserApp( objectId);
		checkerOf(userContext).checkLocationOfUserApp( location);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser updateUserAppProperties(RetailscmUserContext userContext, String secUserId, String id,String title,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserAppProperties(userContext,secUserId,id,title,appIcon,fullAccess,permission,objectType,objectId,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAppListList()
				.searchUserAppListWith(UserApp.ID_PROPERTY, "is", id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getUserAppList().isEmpty()){
			throw new SecUserManagerException("UserApp is NOT FOUND with id: '"+id+"'");
		}

		UserApp item = secUserToUpdate.getUserAppList().first();

		item.updateTitle( title );
		item.updateAppIcon( appIcon );
		item.updateFullAccess( fullAccess );
		item.updatePermission( permission );
		item.updateObjectType( objectType );
		item.updateObjectId( objectId );
		item.updateLocation( location );


		//checkParamsForAddingUserApp(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withUserAppList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}


	protected UserApp createUserApp(RetailscmUserContext userContext, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location) throws Exception{

		UserApp userApp = new UserApp();
		
		
		userApp.setTitle(title);		
		userApp.setAppIcon(appIcon);		
		userApp.setFullAccess(fullAccess);		
		userApp.setPermission(permission);		
		userApp.setObjectType(objectType);		
		userApp.setObjectId(objectId);		
		userApp.setLocation(location);
	
		
		return userApp;


	}

	protected UserApp createIndexedUserApp(String id, int version){

		UserApp userApp = new UserApp();
		userApp.setId(id);
		userApp.setVersion(version);
		return userApp;

	}

	protected void checkParamsForRemovingUserAppList(RetailscmUserContext userContext, String secUserId,
			String userAppIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String userAppIdItem: userAppIds){
			checkerOf(userContext).checkIdOfUserApp(userAppIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeUserAppList(RetailscmUserContext userContext, String secUserId,
			String userAppIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingUserAppList(userContext, secUserId,  userAppIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveUserAppList(secUser, userAppIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
				deleteRelationListInGraph(userContext, secUser.getUserAppList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingUserApp(RetailscmUserContext userContext, String secUserId,
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp(userAppVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeUserApp(RetailscmUserContext userContext, String secUserId,
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingUserApp(userContext,secUserId, userAppId, userAppVersion,tokensExpr);

		UserApp userApp = createIndexedUserApp(userAppId, userAppVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeUserApp( userApp );
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			deleteRelationInGraph(userContext, userApp);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingUserApp(RetailscmUserContext userContext, String secUserId,
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp(userAppVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser copyUserAppFrom(RetailscmUserContext userContext, String secUserId,
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingUserApp(userContext,secUserId, userAppId, userAppVersion,tokensExpr);

		UserApp userApp = createIndexedUserApp(userAppId, userAppVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyUserAppFrom( userApp );
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			
			userContext.getManagerGroup().getUserAppManager().onNewInstanceCreated(userContext, (UserApp)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingUserApp(RetailscmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp(userAppVersion);
		

		if(UserApp.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfUserApp(parseString(newValueExpr));
		
		}
		
		if(UserApp.APP_ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAppIconOfUserApp(parseString(newValueExpr));
		
		}
		
		if(UserApp.FULL_ACCESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFullAccessOfUserApp(parseBoolean(newValueExpr));
		
		}
		
		if(UserApp.PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPermissionOfUserApp(parseString(newValueExpr));
		
		}
		
		if(UserApp.OBJECT_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkObjectTypeOfUserApp(parseString(newValueExpr));
		
		}
		
		if(UserApp.OBJECT_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkObjectIdOfUserApp(parseString(newValueExpr));
		
		}
		
		if(UserApp.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfUserApp(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}

	public  SecUser updateUserApp(RetailscmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingUserApp(userContext, secUserId, userAppId, userAppVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withUserAppList().searchUserAppListWith(UserApp.ID_PROPERTY, "eq", userAppId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeUserApp( userApp );
			//make changes to AcceleraterAccount.
			UserApp userAppIndex = createIndexedUserApp(userAppId, userAppVersion);

			UserApp userApp = secUser.findTheUserApp(userAppIndex);
			if(userApp == null){
				throw new SecUserManagerException(userApp+" is NOT FOUND" );
			}

			userApp.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingLoginHistory(RetailscmUserContext userContext, String secUserId, String fromIp, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkFromIpOfLoginHistory(fromIp);
		
		checkerOf(userContext).checkDescriptionOfLoginHistory(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser addLoginHistory(RetailscmUserContext userContext, String secUserId, String fromIp, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLoginHistory(userContext,secUserId,fromIp, description,tokensExpr);

		LoginHistory loginHistory = createLoginHistory(userContext,fromIp, description);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addLoginHistory( loginHistory );
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			
			userContext.getManagerGroup().getLoginHistoryManager().onNewInstanceCreated(userContext, loginHistory);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLoginHistoryProperties(RetailscmUserContext userContext, String secUserId,String id,String fromIp,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(id);

		checkerOf(userContext).checkFromIpOfLoginHistory( fromIp);
		checkerOf(userContext).checkDescriptionOfLoginHistory( description);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser updateLoginHistoryProperties(RetailscmUserContext userContext, String secUserId, String id,String fromIp,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLoginHistoryProperties(userContext,secUserId,id,fromIp,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLoginHistoryListList()
				.searchLoginHistoryListWith(LoginHistory.ID_PROPERTY, "is", id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getLoginHistoryList().isEmpty()){
			throw new SecUserManagerException("LoginHistory is NOT FOUND with id: '"+id+"'");
		}

		LoginHistory item = secUserToUpdate.getLoginHistoryList().first();

		item.updateFromIp( fromIp );
		item.updateDescription( description );


		//checkParamsForAddingLoginHistory(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withLoginHistoryList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}


	protected LoginHistory createLoginHistory(RetailscmUserContext userContext, String fromIp, String description) throws Exception{

		LoginHistory loginHistory = new LoginHistory();
		
		
		loginHistory.setLoginTime(userContext.now());		
		loginHistory.setFromIp(fromIp);		
		loginHistory.setDescription(description);
	
		
		return loginHistory;


	}

	protected LoginHistory createIndexedLoginHistory(String id, int version){

		LoginHistory loginHistory = new LoginHistory();
		loginHistory.setId(id);
		loginHistory.setVersion(version);
		return loginHistory;

	}

	protected void checkParamsForRemovingLoginHistoryList(RetailscmUserContext userContext, String secUserId,
			String loginHistoryIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String loginHistoryIdItem: loginHistoryIds){
			checkerOf(userContext).checkIdOfLoginHistory(loginHistoryIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeLoginHistoryList(RetailscmUserContext userContext, String secUserId,
			String loginHistoryIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLoginHistoryList(userContext, secUserId,  loginHistoryIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveLoginHistoryList(secUser, loginHistoryIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
				deleteRelationListInGraph(userContext, secUser.getLoginHistoryList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLoginHistory(RetailscmUserContext userContext, String secUserId,
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory(loginHistoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeLoginHistory(RetailscmUserContext userContext, String secUserId,
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLoginHistory(userContext,secUserId, loginHistoryId, loginHistoryVersion,tokensExpr);

		LoginHistory loginHistory = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeLoginHistory( loginHistory );
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			deleteRelationInGraph(userContext, loginHistory);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLoginHistory(RetailscmUserContext userContext, String secUserId,
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory(loginHistoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser copyLoginHistoryFrom(RetailscmUserContext userContext, String secUserId,
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLoginHistory(userContext,secUserId, loginHistoryId, loginHistoryVersion,tokensExpr);

		LoginHistory loginHistory = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyLoginHistoryFrom( loginHistory );
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			
			userContext.getManagerGroup().getLoginHistoryManager().onNewInstanceCreated(userContext, (LoginHistory)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLoginHistory(RetailscmUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory(loginHistoryVersion);
		

		if(LoginHistory.FROM_IP_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromIpOfLoginHistory(parseString(newValueExpr));
		
		}
		
		if(LoginHistory.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLoginHistory(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}

	public  SecUser updateLoginHistory(RetailscmUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLoginHistory(userContext, secUserId, loginHistoryId, loginHistoryVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLoginHistoryList().searchLoginHistoryListWith(LoginHistory.ID_PROPERTY, "eq", loginHistoryId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeLoginHistory( loginHistory );
			//make changes to AcceleraterAccount.
			LoginHistory loginHistoryIndex = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);

			LoginHistory loginHistory = secUser.findTheLoginHistory(loginHistoryIndex);
			if(loginHistory == null){
				throw new SecUserManagerException(loginHistory+" is NOT FOUND" );
			}

			loginHistory.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkCorpIdOfWechatWorkappIdentify(corpId);
		
		checkerOf(userContext).checkUserIdOfWechatWorkappIdentify(userId);
		
		checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentify(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser addWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingWechatWorkappIdentify(userContext,secUserId,corpId, userId, lastLoginTime,tokensExpr);

		WechatWorkappIdentify wechatWorkappIdentify = createWechatWorkappIdentify(userContext,corpId, userId, lastLoginTime);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addWechatWorkappIdentify( wechatWorkappIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
			
			userContext.getManagerGroup().getWechatWorkappIdentifyManager().onNewInstanceCreated(userContext, wechatWorkappIdentify);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWechatWorkappIdentifyProperties(RetailscmUserContext userContext, String secUserId,String id,String corpId,String userId,DateTime lastLoginTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentify(id);

		checkerOf(userContext).checkCorpIdOfWechatWorkappIdentify( corpId);
		checkerOf(userContext).checkUserIdOfWechatWorkappIdentify( userId);
		checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentify( lastLoginTime);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser updateWechatWorkappIdentifyProperties(RetailscmUserContext userContext, String secUserId, String id,String corpId,String userId,DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatWorkappIdentifyProperties(userContext,secUserId,id,corpId,userId,lastLoginTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWechatWorkappIdentifyListList()
				.searchWechatWorkappIdentifyListWith(WechatWorkappIdentify.ID_PROPERTY, "is", id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getWechatWorkappIdentifyList().isEmpty()){
			throw new SecUserManagerException("WechatWorkappIdentify is NOT FOUND with id: '"+id+"'");
		}

		WechatWorkappIdentify item = secUserToUpdate.getWechatWorkappIdentifyList().first();

		item.updateCorpId( corpId );
		item.updateUserId( userId );
		item.updateLastLoginTime( lastLoginTime );


		//checkParamsForAddingWechatWorkappIdentify(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withWechatWorkappIdentifyList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}


	protected WechatWorkappIdentify createWechatWorkappIdentify(RetailscmUserContext userContext, String corpId, String userId, DateTime lastLoginTime) throws Exception{

		WechatWorkappIdentify wechatWorkappIdentify = new WechatWorkappIdentify();
		
		
		wechatWorkappIdentify.setCorpId(corpId);		
		wechatWorkappIdentify.setUserId(userId);		
		wechatWorkappIdentify.setCreateTime(userContext.now());		
		wechatWorkappIdentify.setLastLoginTime(lastLoginTime);
	
		
		return wechatWorkappIdentify;


	}

	protected WechatWorkappIdentify createIndexedWechatWorkappIdentify(String id, int version){

		WechatWorkappIdentify wechatWorkappIdentify = new WechatWorkappIdentify();
		wechatWorkappIdentify.setId(id);
		wechatWorkappIdentify.setVersion(version);
		return wechatWorkappIdentify;

	}

	protected void checkParamsForRemovingWechatWorkappIdentifyList(RetailscmUserContext userContext, String secUserId,
			String wechatWorkappIdentifyIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String wechatWorkappIdentifyIdItem: wechatWorkappIdentifyIds){
			checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeWechatWorkappIdentifyList(RetailscmUserContext userContext, String secUserId,
			String wechatWorkappIdentifyIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingWechatWorkappIdentifyList(userContext, secUserId,  wechatWorkappIdentifyIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveWechatWorkappIdentifyList(secUser, wechatWorkappIdentifyIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
				deleteRelationListInGraph(userContext, secUser.getWechatWorkappIdentifyList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentify(wechatWorkappIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingWechatWorkappIdentify(userContext,secUserId, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion,tokensExpr);

		WechatWorkappIdentify wechatWorkappIdentify = createIndexedWechatWorkappIdentify(wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeWechatWorkappIdentify( wechatWorkappIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
			deleteRelationInGraph(userContext, wechatWorkappIdentify);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentify(wechatWorkappIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser copyWechatWorkappIdentifyFrom(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingWechatWorkappIdentify(userContext,secUserId, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion,tokensExpr);

		WechatWorkappIdentify wechatWorkappIdentify = createIndexedWechatWorkappIdentify(wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyWechatWorkappIdentifyFrom( wechatWorkappIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
			
			userContext.getManagerGroup().getWechatWorkappIdentifyManager().onNewInstanceCreated(userContext, (WechatWorkappIdentify)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentify(wechatWorkappIdentifyVersion);
		

		if(WechatWorkappIdentify.CORP_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCorpIdOfWechatWorkappIdentify(parseString(newValueExpr));
		
		}
		
		if(WechatWorkappIdentify.USER_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUserIdOfWechatWorkappIdentify(parseString(newValueExpr));
		
		}
		
		if(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentify(parseTimestamp(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}

	public  SecUser updateWechatWorkappIdentify(RetailscmUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingWechatWorkappIdentify(userContext, secUserId, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withWechatWorkappIdentifyList().searchWechatWorkappIdentifyListWith(WechatWorkappIdentify.ID_PROPERTY, "eq", wechatWorkappIdentifyId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeWechatWorkappIdentify( wechatWorkappIdentify );
			//make changes to AcceleraterAccount.
			WechatWorkappIdentify wechatWorkappIdentifyIndex = createIndexedWechatWorkappIdentify(wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);

			WechatWorkappIdentify wechatWorkappIdentify = secUser.findTheWechatWorkappIdentify(wechatWorkappIdentifyIndex);
			if(wechatWorkappIdentify == null){
				throw new SecUserManagerException(wechatWorkappIdentify+" is NOT FOUND" );
			}

			wechatWorkappIdentify.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentifyList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkOpenIdOfWechatMiniappIdentify(openId);
		
		checkerOf(userContext).checkAppIdOfWechatMiniappIdentify(appId);
		
		checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentify(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser addWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingWechatMiniappIdentify(userContext,secUserId,openId, appId, lastLoginTime,tokensExpr);

		WechatMiniappIdentify wechatMiniappIdentify = createWechatMiniappIdentify(userContext,openId, appId, lastLoginTime);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addWechatMiniappIdentify( wechatMiniappIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
			
			userContext.getManagerGroup().getWechatMiniappIdentifyManager().onNewInstanceCreated(userContext, wechatMiniappIdentify);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWechatMiniappIdentifyProperties(RetailscmUserContext userContext, String secUserId,String id,String openId,String appId,DateTime lastLoginTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentify(id);

		checkerOf(userContext).checkOpenIdOfWechatMiniappIdentify( openId);
		checkerOf(userContext).checkAppIdOfWechatMiniappIdentify( appId);
		checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentify( lastLoginTime);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser updateWechatMiniappIdentifyProperties(RetailscmUserContext userContext, String secUserId, String id,String openId,String appId,DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatMiniappIdentifyProperties(userContext,secUserId,id,openId,appId,lastLoginTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWechatMiniappIdentifyListList()
				.searchWechatMiniappIdentifyListWith(WechatMiniappIdentify.ID_PROPERTY, "is", id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getWechatMiniappIdentifyList().isEmpty()){
			throw new SecUserManagerException("WechatMiniappIdentify is NOT FOUND with id: '"+id+"'");
		}

		WechatMiniappIdentify item = secUserToUpdate.getWechatMiniappIdentifyList().first();

		item.updateOpenId( openId );
		item.updateAppId( appId );
		item.updateLastLoginTime( lastLoginTime );


		//checkParamsForAddingWechatMiniappIdentify(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withWechatMiniappIdentifyList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}


	protected WechatMiniappIdentify createWechatMiniappIdentify(RetailscmUserContext userContext, String openId, String appId, DateTime lastLoginTime) throws Exception{

		WechatMiniappIdentify wechatMiniappIdentify = new WechatMiniappIdentify();
		
		
		wechatMiniappIdentify.setOpenId(openId);		
		wechatMiniappIdentify.setAppId(appId);		
		wechatMiniappIdentify.setCreateTime(userContext.now());		
		wechatMiniappIdentify.setLastLoginTime(lastLoginTime);
	
		
		return wechatMiniappIdentify;


	}

	protected WechatMiniappIdentify createIndexedWechatMiniappIdentify(String id, int version){

		WechatMiniappIdentify wechatMiniappIdentify = new WechatMiniappIdentify();
		wechatMiniappIdentify.setId(id);
		wechatMiniappIdentify.setVersion(version);
		return wechatMiniappIdentify;

	}

	protected void checkParamsForRemovingWechatMiniappIdentifyList(RetailscmUserContext userContext, String secUserId,
			String wechatMiniappIdentifyIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String wechatMiniappIdentifyIdItem: wechatMiniappIdentifyIds){
			checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeWechatMiniappIdentifyList(RetailscmUserContext userContext, String secUserId,
			String wechatMiniappIdentifyIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingWechatMiniappIdentifyList(userContext, secUserId,  wechatMiniappIdentifyIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveWechatMiniappIdentifyList(secUser, wechatMiniappIdentifyIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
				deleteRelationListInGraph(userContext, secUser.getWechatMiniappIdentifyList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentify(wechatMiniappIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingWechatMiniappIdentify(userContext,secUserId, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion,tokensExpr);

		WechatMiniappIdentify wechatMiniappIdentify = createIndexedWechatMiniappIdentify(wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeWechatMiniappIdentify( wechatMiniappIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
			deleteRelationInGraph(userContext, wechatMiniappIdentify);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentify(wechatMiniappIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser copyWechatMiniappIdentifyFrom(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingWechatMiniappIdentify(userContext,secUserId, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion,tokensExpr);

		WechatMiniappIdentify wechatMiniappIdentify = createIndexedWechatMiniappIdentify(wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyWechatMiniappIdentifyFrom( wechatMiniappIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
			
			userContext.getManagerGroup().getWechatMiniappIdentifyManager().onNewInstanceCreated(userContext, (WechatMiniappIdentify)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentify(wechatMiniappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentify(wechatMiniappIdentifyVersion);
		

		if(WechatMiniappIdentify.OPEN_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOpenIdOfWechatMiniappIdentify(parseString(newValueExpr));
		
		}
		
		if(WechatMiniappIdentify.APP_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAppIdOfWechatMiniappIdentify(parseString(newValueExpr));
		
		}
		
		if(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentify(parseTimestamp(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}

	public  SecUser updateWechatMiniappIdentify(RetailscmUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingWechatMiniappIdentify(userContext, secUserId, wechatMiniappIdentifyId, wechatMiniappIdentifyVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withWechatMiniappIdentifyList().searchWechatMiniappIdentifyListWith(WechatMiniappIdentify.ID_PROPERTY, "eq", wechatMiniappIdentifyId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeWechatMiniappIdentify( wechatMiniappIdentify );
			//make changes to AcceleraterAccount.
			WechatMiniappIdentify wechatMiniappIdentifyIndex = createIndexedWechatMiniappIdentify(wechatMiniappIdentifyId, wechatMiniappIdentifyVersion);

			WechatMiniappIdentify wechatMiniappIdentify = secUser.findTheWechatMiniappIdentify(wechatMiniappIdentifyIndex);
			if(wechatMiniappIdentify == null){
				throw new SecUserManagerException(wechatMiniappIdentify+" is NOT FOUND" );
			}

			wechatMiniappIdentify.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentifyList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingKeypairIdentify(RetailscmUserContext userContext, String secUserId, String publicKey, String keyTypeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkPublicKeyOfKeypairIdentify(publicKey);
		
		checkerOf(userContext).checkKeyTypeIdOfKeypairIdentify(keyTypeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser addKeypairIdentify(RetailscmUserContext userContext, String secUserId, String publicKey, String keyTypeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingKeypairIdentify(userContext,secUserId,publicKey, keyTypeId,tokensExpr);

		KeypairIdentify keypairIdentify = createKeypairIdentify(userContext,publicKey, keyTypeId);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addKeypairIdentify( keypairIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withKeypairIdentifyList().done());
			
			userContext.getManagerGroup().getKeypairIdentifyManager().onNewInstanceCreated(userContext, keypairIdentify);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingKeypairIdentifyProperties(RetailscmUserContext userContext, String secUserId,String id,String publicKey,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfKeypairIdentify(id);

		checkerOf(userContext).checkPublicKeyOfKeypairIdentify( publicKey);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser updateKeypairIdentifyProperties(RetailscmUserContext userContext, String secUserId, String id,String publicKey, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeypairIdentifyProperties(userContext,secUserId,id,publicKey,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withKeypairIdentifyListList()
				.searchKeypairIdentifyListWith(KeypairIdentify.ID_PROPERTY, "is", id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getKeypairIdentifyList().isEmpty()){
			throw new SecUserManagerException("KeypairIdentify is NOT FOUND with id: '"+id+"'");
		}

		KeypairIdentify item = secUserToUpdate.getKeypairIdentifyList().first();

		item.updatePublicKey( publicKey );


		//checkParamsForAddingKeypairIdentify(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withKeypairIdentifyList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}


	protected KeypairIdentify createKeypairIdentify(RetailscmUserContext userContext, String publicKey, String keyTypeId) throws Exception{

		KeypairIdentify keypairIdentify = new KeypairIdentify();
		
		
		keypairIdentify.setPublicKey(publicKey);		
		PublicKeyType  keyType = new PublicKeyType();
		keyType.setId(keyTypeId);		
		keypairIdentify.setKeyType(keyType);		
		keypairIdentify.setCreateTime(userContext.now());
	
		
		return keypairIdentify;


	}

	protected KeypairIdentify createIndexedKeypairIdentify(String id, int version){

		KeypairIdentify keypairIdentify = new KeypairIdentify();
		keypairIdentify.setId(id);
		keypairIdentify.setVersion(version);
		return keypairIdentify;

	}

	protected void checkParamsForRemovingKeypairIdentifyList(RetailscmUserContext userContext, String secUserId,
			String keypairIdentifyIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String keypairIdentifyIdItem: keypairIdentifyIds){
			checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeKeypairIdentifyList(RetailscmUserContext userContext, String secUserId,
			String keypairIdentifyIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingKeypairIdentifyList(userContext, secUserId,  keypairIdentifyIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveKeypairIdentifyList(secUser, keypairIdentifyIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withKeypairIdentifyList().done());
				deleteRelationListInGraph(userContext, secUser.getKeypairIdentifyList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingKeypairIdentify(RetailscmUserContext userContext, String secUserId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify(keypairIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeKeypairIdentify(RetailscmUserContext userContext, String secUserId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingKeypairIdentify(userContext,secUserId, keypairIdentifyId, keypairIdentifyVersion,tokensExpr);

		KeypairIdentify keypairIdentify = createIndexedKeypairIdentify(keypairIdentifyId, keypairIdentifyVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeKeypairIdentify( keypairIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withKeypairIdentifyList().done());
			deleteRelationInGraph(userContext, keypairIdentify);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingKeypairIdentify(RetailscmUserContext userContext, String secUserId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify(keypairIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser copyKeypairIdentifyFrom(RetailscmUserContext userContext, String secUserId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingKeypairIdentify(userContext,secUserId, keypairIdentifyId, keypairIdentifyVersion,tokensExpr);

		KeypairIdentify keypairIdentify = createIndexedKeypairIdentify(keypairIdentifyId, keypairIdentifyVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyKeypairIdentifyFrom( keypairIdentify );
			secUser = saveSecUser(userContext, secUser, tokens().withKeypairIdentifyList().done());
			
			userContext.getManagerGroup().getKeypairIdentifyManager().onNewInstanceCreated(userContext, (KeypairIdentify)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingKeypairIdentify(RetailscmUserContext userContext, String secUserId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify(keypairIdentifyVersion);
		

		if(KeypairIdentify.PUBLIC_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPublicKeyOfKeypairIdentify(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}

	public  SecUser updateKeypairIdentify(RetailscmUserContext userContext, String secUserId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingKeypairIdentify(userContext, secUserId, keypairIdentifyId, keypairIdentifyVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withKeypairIdentifyList().searchKeypairIdentifyListWith(KeypairIdentify.ID_PROPERTY, "eq", keypairIdentifyId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeKeypairIdentify( keypairIdentify );
			//make changes to AcceleraterAccount.
			KeypairIdentify keypairIdentifyIndex = createIndexedKeypairIdentify(keypairIdentifyId, keypairIdentifyVersion);

			KeypairIdentify keypairIdentify = secUser.findTheKeypairIdentify(keypairIdentifyIndex);
			if(keypairIdentify == null){
				throw new SecUserManagerException(keypairIdentify+" is NOT FOUND" );
			}

			keypairIdentify.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withKeypairIdentifyList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, SecUser newCreated) throws Exception{
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
		//   SecUser newSecUser = this.createSecUser(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSecUser
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SecUser.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<SecUser> list) throws Exception {
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
		SmartList<SecUser> list = secUserDaoOf(userContext).findSecUserByDomain(domainId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(SecUser.class);
		page.setContainerObject(UserDomain.withId(domainId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("SEC的用户列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String secUserId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getSecUserDetailScope().clone();
		SecUser merchantObj = (SecUser) this.view(userContext, secUserId);
    String merchantObjId = secUserId;
    String linkToUrl =	"secUserManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "SEC的用户"+"详情";
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
				MapUtil.put("id", "2-login")
				    .put("fieldName", "login")
				    .put("label", "登录")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("login", merchantObj.getLogin());

		propList.add(
				MapUtil.put("id", "3-mobile")
				    .put("fieldName", "mobile")
				    .put("label", "手机")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobile", merchantObj.getMobile());

		propList.add(
				MapUtil.put("id", "4-email")
				    .put("fieldName", "email")
				    .put("label", "电子邮件")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("email", merchantObj.getEmail());

		propList.add(
				MapUtil.put("id", "5-pwd")
				    .put("fieldName", "pwd")
				    .put("label", "PWD")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("pwd", merchantObj.getPwd());

		propList.add(
				MapUtil.put("id", "6-weixinOpenid")
				    .put("fieldName", "weixinOpenid")
				    .put("label", "微信openid")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("weixinOpenid", merchantObj.getWeixinOpenid());

		propList.add(
				MapUtil.put("id", "7-weixinAppid")
				    .put("fieldName", "weixinAppid")
				    .put("label", "微信Appid")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("weixinAppid", merchantObj.getWeixinAppid());

		propList.add(
				MapUtil.put("id", "8-accessToken")
				    .put("fieldName", "accessToken")
				    .put("label", "访问令牌")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accessToken", merchantObj.getAccessToken());

		propList.add(
				MapUtil.put("id", "9-verificationCode")
				    .put("fieldName", "verificationCode")
				    .put("label", "验证码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("verificationCode", merchantObj.getVerificationCode());

		propList.add(
				MapUtil.put("id", "10-verificationCodeExpire")
				    .put("fieldName", "verificationCodeExpire")
				    .put("label", "验证码过期")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("verificationCodeExpire", merchantObj.getVerificationCodeExpire());

		propList.add(
				MapUtil.put("id", "11-lastLoginTime")
				    .put("fieldName", "lastLoginTime")
				    .put("label", "最后登录时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastLoginTime", merchantObj.getLastLoginTime());

		propList.add(
				MapUtil.put("id", "12-domain")
				    .put("fieldName", "domain")
				    .put("label", "域")
				    .put("type", "auto")
				    .put("linkToUrl", "userDomainManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("domain", merchantObj.getDomain());

		//处理 sectionList

		//处理Section：userAppListSection
		Map userAppListSection = ListofUtils.buildSection(
		    "userAppListSection",
		    "用户应用程序列表",
		    null,
		    "",
		    "__no_group",
		    "userAppManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(userAppListSection);

		result.put("userAppListSection", ListofUtils.toShortList(merchantObj.getUserAppList(), "userApp"));
		vscope.field("userAppListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( UserApp.class.getName(), null));

		//处理Section：loginHistoryListSection
		Map loginHistoryListSection = ListofUtils.buildSection(
		    "loginHistoryListSection",
		    "登录历史列表",
		    null,
		    "",
		    "__no_group",
		    "loginHistoryManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(loginHistoryListSection);

		result.put("loginHistoryListSection", ListofUtils.toShortList(merchantObj.getLoginHistoryList(), "loginHistory"));
		vscope.field("loginHistoryListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( LoginHistory.class.getName(), null));

		//处理Section：wechatWorkappIdentifyListSection
		Map wechatWorkappIdentifyListSection = ListofUtils.buildSection(
		    "wechatWorkappIdentifyListSection",
		    "微信工作程序识别列表",
		    null,
		    "",
		    "__no_group",
		    "wechatWorkappIdentifyManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(wechatWorkappIdentifyListSection);

		result.put("wechatWorkappIdentifyListSection", ListofUtils.toShortList(merchantObj.getWechatWorkappIdentifyList(), "wechatWorkappIdentify"));
		vscope.field("wechatWorkappIdentifyListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( WechatWorkappIdentify.class.getName(), null));

		//处理Section：wechatMiniappIdentifyListSection
		Map wechatMiniappIdentifyListSection = ListofUtils.buildSection(
		    "wechatMiniappIdentifyListSection",
		    "微信迷你应用识别列表",
		    null,
		    "",
		    "__no_group",
		    "wechatMiniappIdentifyManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(wechatMiniappIdentifyListSection);

		result.put("wechatMiniappIdentifyListSection", ListofUtils.toShortList(merchantObj.getWechatMiniappIdentifyList(), "wechatMiniappIdentify"));
		vscope.field("wechatMiniappIdentifyListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( WechatMiniappIdentify.class.getName(), null));

		//处理Section：keypairIdentifyListSection
		Map keypairIdentifyListSection = ListofUtils.buildSection(
		    "keypairIdentifyListSection",
		    "密钥对识别列表",
		    null,
		    "",
		    "__no_group",
		    "keypairIdentifyManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(keypairIdentifyListSection);

		result.put("keypairIdentifyListSection", ListofUtils.toShortList(merchantObj.getKeypairIdentifyList(), "keypairIdentify"));
		vscope.field("keypairIdentifyListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( KeypairIdentify.class.getName(), null));

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


