
package com.doublechaintech.retailscm.secuser;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;import com.doublechaintech.retailscm.loginhistory.LoginHistory;import com.doublechaintech.retailscm.publickeytype.PublicKeyType;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.userdomain.CandidateUserDomain;import com.doublechaintech.retailscm.userdomain.UserDomain;import com.doublechaintech.retailscm.utils.ModelAssurance;import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


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



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		SecUser secUser = loadSecUser( userContext, secUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUser, tokens);
 	}



 	protected SecUser present(RetailscmUserContext userContext, SecUser secUser, Map<String, Object> tokens) throws Exception {


		addActions(userContext,secUser,tokens);
    

		SecUser  secUserToPresent = secUserDaoOf(userContext).present(secUser, tokens);

		List<BaseEntity> entityListToNaming = secUserToPresent.collectRefercencesFromLists();
		secUserDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,secUser,tokens);

		return  secUserToPresent;


	}



 	public SecUser loadSecUserDetail(RetailscmUserContext userContext, String secUserId) throws Exception{
 		SecUser secUser = loadSecUser( userContext, secUserId, allTokens());
 		return present(userContext,secUser, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String secUserId) throws Exception{
 		SecUser secUser = loadSecUser( userContext, secUserId, viewTokens());
 		markVisited(userContext, secUser);
 		return present(userContext,secUser, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String secUserId) throws Exception{
		SecUser secUser = loadSecUser( userContext, secUserId, viewTokens());
		secUser.summarySuffix();
		markVisited(userContext, secUser);
 		return present(userContext,secUser, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String secUserId) throws Exception{
		SecUser secUser = loadSecUser( userContext, secUserId, analyzeTokens());
		markVisited(userContext, secUser);
		return present(userContext,secUser, analyzeTokens());

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
		addAction(userContext, secUser, tokens,"sec_user.addWechatWorkappIdentity","addWechatWorkappIdentity","addWechatWorkappIdentity/"+secUser.getId()+"/","wechatWorkappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeWechatWorkappIdentity","removeWechatWorkappIdentity","removeWechatWorkappIdentity/"+secUser.getId()+"/","wechatWorkappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateWechatWorkappIdentity","updateWechatWorkappIdentity","updateWechatWorkappIdentity/"+secUser.getId()+"/","wechatWorkappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyWechatWorkappIdentityFrom","copyWechatWorkappIdentityFrom","copyWechatWorkappIdentityFrom/"+secUser.getId()+"/","wechatWorkappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addWechatMiniappIdentity","addWechatMiniappIdentity","addWechatMiniappIdentity/"+secUser.getId()+"/","wechatMiniappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeWechatMiniappIdentity","removeWechatMiniappIdentity","removeWechatMiniappIdentity/"+secUser.getId()+"/","wechatMiniappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateWechatMiniappIdentity","updateWechatMiniappIdentity","updateWechatMiniappIdentity/"+secUser.getId()+"/","wechatMiniappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyWechatMiniappIdentityFrom","copyWechatMiniappIdentityFrom","copyWechatMiniappIdentityFrom/"+secUser.getId()+"/","wechatMiniappIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addKeyPairIdentity","addKeyPairIdentity","addKeyPairIdentity/"+secUser.getId()+"/","keyPairIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeKeyPairIdentity","removeKeyPairIdentity","removeKeyPairIdentity/"+secUser.getId()+"/","keyPairIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateKeyPairIdentity","updateKeyPairIdentity","updateKeyPairIdentity/"+secUser.getId()+"/","keyPairIdentityList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyKeyPairIdentityFrom","copyKeyPairIdentityFrom","copyKeyPairIdentityFrom/"+secUser.getId()+"/","keyPairIdentityList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SecUser secUser, Map<String, Object> tokens){








  @Override
  public List<SecUser> searchSecUserList(RetailscmUserContext ctx, SecUserRequest pRequest){
      pRequest.setUserContext(ctx);
      List<SecUser> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public SecUser searchSecUser(RetailscmUserContext ctx, SecUserRequest pRequest){
    pRequest.limit(0, 1);
    List<SecUser> list = searchSecUserList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public SecUser createSecUser(RetailscmUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception
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

      //checkerOf(userContext).checkAndFixSecUser(secUser);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserAppListWith(UserApp.ID_PROPERTY,sortDesc())
		.sortLoginHistoryListWith(LoginHistory.ID_PROPERTY,sortDesc())
		.sortWechatWorkappIdentityListWith(WechatWorkappIdentity.ID_PROPERTY,sortDesc())
		.sortWechatMiniappIdentityListWith(WechatMiniappIdentity.ID_PROPERTY,sortDesc())
		.sortKeyPairIdentityListWith(KeyPairIdentity.ID_PROPERTY,sortDesc())
		.done();

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





	protected void checkParamsForAddingUserApp(RetailscmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String appType, String appId, String ctxType, String ctxId, String location,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);


		checkerOf(userContext).checkTitleOfUserApp(title);

		checkerOf(userContext).checkAppIconOfUserApp(appIcon);

		checkerOf(userContext).checkFullAccessOfUserApp(fullAccess);

		checkerOf(userContext).checkPermissionOfUserApp(permission);

		checkerOf(userContext).checkAppTypeOfUserApp(appType);

		checkerOf(userContext).checkAppIdOfUserApp(appId);

		checkerOf(userContext).checkCtxTypeOfUserApp(ctxType);

		checkerOf(userContext).checkCtxIdOfUserApp(ctxId);

		checkerOf(userContext).checkLocationOfUserApp(location);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);



	}
	public  SecUser addUserApp(RetailscmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String appType, String appId, String ctxType, String ctxId, String location, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingUserApp(userContext,secUserId,title, appIcon, fullAccess, permission, appType, appId, ctxType, ctxId, location,tokensExpr);

		UserApp userApp = createUserApp(userContext,title, appIcon, fullAccess, permission, appType, appId, ctxType, ctxId, location);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addUserApp( userApp );
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			
			userAppManagerOf(userContext).onNewInstanceCreated(userContext, userApp);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAppProperties(RetailscmUserContext userContext, String secUserId,String id,String title,String appIcon,boolean fullAccess,String permission,String appType,String appId,String ctxType,String ctxId,String location,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfUserApp(id);

		checkerOf(userContext).checkTitleOfUserApp( title);
		checkerOf(userContext).checkAppIconOfUserApp( appIcon);
		checkerOf(userContext).checkFullAccessOfUserApp( fullAccess);
		checkerOf(userContext).checkPermissionOfUserApp( permission);
		checkerOf(userContext).checkAppTypeOfUserApp( appType);
		checkerOf(userContext).checkAppIdOfUserApp( appId);
		checkerOf(userContext).checkCtxTypeOfUserApp( ctxType);
		checkerOf(userContext).checkCtxIdOfUserApp( ctxId);
		checkerOf(userContext).checkLocationOfUserApp( location);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser updateUserAppProperties(RetailscmUserContext userContext, String secUserId, String id,String title,String appIcon,boolean fullAccess,String permission,String appType,String appId,String ctxType,String ctxId,String location, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserAppProperties(userContext,secUserId,id,title,appIcon,fullAccess,permission,appType,appId,ctxType,ctxId,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAppListList()
				.searchUserAppListWith(UserApp.ID_PROPERTY, tokens().is(), id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getUserAppList().isEmpty()){
			throw new SecUserManagerException("UserApp is NOT FOUND with id: '"+id+"'");
		}

		UserApp item = secUserToUpdate.getUserAppList().first();
		beforeUpdateUserAppProperties(userContext,item, secUserId,id,title,appIcon,fullAccess,permission,appType,appId,ctxType,ctxId,location,tokensExpr);
		item.updateTitle( title );
		item.updateAppIcon( appIcon );
		item.updateFullAccess( fullAccess );
		item.updatePermission( permission );
		item.updateAppType( appType );
		item.updateAppId( appId );
		item.updateCtxType( ctxType );
		item.updateCtxId( ctxId );
		item.updateLocation( location );


		//checkParamsForAddingUserApp(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withUserAppList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateUserAppProperties(RetailscmUserContext userContext, UserApp item, String secUserId, String id,String title,String appIcon,boolean fullAccess,String permission,String appType,String appId,String ctxType,String ctxId,String location, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected UserApp createUserApp(RetailscmUserContext userContext, String title, String appIcon, boolean fullAccess, String permission, String appType, String appId, String ctxType, String ctxId, String location) throws Exception{

		UserApp userApp = new UserApp();
		
		
		userApp.setTitle(title);		
		userApp.setAppIcon(appIcon);		
		userApp.setFullAccess(fullAccess);		
		userApp.setPermission(permission);		
		userApp.setAppType(appType);		
		userApp.setAppId(appId);		
		userApp.setCtxType(ctxType);		
		userApp.setCtxId(ctxId);		
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
			
			userAppManagerOf(userContext).onNewInstanceCreated(userContext, (UserApp)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
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
		
		if(UserApp.APP_TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkAppTypeOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.APP_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkAppIdOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.CTX_TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCtxTypeOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.CTX_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkCtxIdOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.LOCATION_PROPERTY.equals(property)){
			checkerOf(userContext).checkLocationOfUserApp(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}

	public  SecUser updateUserApp(RetailscmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingUserApp(userContext, secUserId, userAppId, userAppVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withUserAppList().searchUserAppListWith(UserApp.ID_PROPERTY, tokens().equals(), userAppId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeUserApp( userApp );
			//make changes to AcceleraterAccount.
			UserApp userAppIdVersionKey = createIndexedUserApp(userAppId, userAppVersion);

			UserApp userApp = secUser.findTheUserApp(userAppIdVersionKey);
			if(userApp == null){
				throw new SecUserManagerException(userAppId+" is NOT FOUND" );
			}

			beforeUpdateUserApp(userContext, userApp, secUserId, userAppId, userAppVersion, property, newValueExpr,  tokensExpr);
			userApp.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			userAppManagerOf(userContext).onUpdated(userContext, userApp, this, "updateUserApp");
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateUserApp(RetailscmUserContext userContext, UserApp existed, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
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
			
			loginHistoryManagerOf(userContext).onNewInstanceCreated(userContext, loginHistory);
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
				.searchLoginHistoryListWith(LoginHistory.ID_PROPERTY, tokens().is(), id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getLoginHistoryList().isEmpty()){
			throw new SecUserManagerException("LoginHistory is NOT FOUND with id: '"+id+"'");
		}

		LoginHistory item = secUserToUpdate.getLoginHistoryList().first();
		beforeUpdateLoginHistoryProperties(userContext,item, secUserId,id,fromIp,description,tokensExpr);
		item.updateFromIp( fromIp );
		item.updateDescription( description );


		//checkParamsForAddingLoginHistory(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withLoginHistoryList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateLoginHistoryProperties(RetailscmUserContext userContext, LoginHistory item, String secUserId, String id,String fromIp,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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
			
			loginHistoryManagerOf(userContext).onNewInstanceCreated(userContext, (LoginHistory)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
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

		Map<String,Object> loadTokens = this.tokens().withLoginHistoryList().searchLoginHistoryListWith(LoginHistory.ID_PROPERTY, tokens().equals(), loginHistoryId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeLoginHistory( loginHistory );
			//make changes to AcceleraterAccount.
			LoginHistory loginHistoryIdVersionKey = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);

			LoginHistory loginHistory = secUser.findTheLoginHistory(loginHistoryIdVersionKey);
			if(loginHistory == null){
				throw new SecUserManagerException(loginHistoryId+" is NOT FOUND" );
			}

			beforeUpdateLoginHistory(userContext, loginHistory, secUserId, loginHistoryId, loginHistoryVersion, property, newValueExpr,  tokensExpr);
			loginHistory.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			loginHistoryManagerOf(userContext).onUpdated(userContext, loginHistory, this, "updateLoginHistory");
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateLoginHistory(RetailscmUserContext userContext, LoginHistory existed, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);


		checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity(corpId);

		checkerOf(userContext).checkUserIdOfWechatWorkappIdentity(userId);

		checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentity(lastLoginTime);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);



	}
	public  SecUser addWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingWechatWorkappIdentity(userContext,secUserId,corpId, userId, lastLoginTime,tokensExpr);

		WechatWorkappIdentity wechatWorkappIdentity = createWechatWorkappIdentity(userContext,corpId, userId, lastLoginTime);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addWechatWorkappIdentity( wechatWorkappIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentityList().done());
			
			wechatWorkappIdentityManagerOf(userContext).onNewInstanceCreated(userContext, wechatWorkappIdentity);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWechatWorkappIdentityProperties(RetailscmUserContext userContext, String secUserId,String id,String corpId,String userId,DateTime lastLoginTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentity(id);

		checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity( corpId);
		checkerOf(userContext).checkUserIdOfWechatWorkappIdentity( userId);
		checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentity( lastLoginTime);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser updateWechatWorkappIdentityProperties(RetailscmUserContext userContext, String secUserId, String id,String corpId,String userId,DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatWorkappIdentityProperties(userContext,secUserId,id,corpId,userId,lastLoginTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWechatWorkappIdentityListList()
				.searchWechatWorkappIdentityListWith(WechatWorkappIdentity.ID_PROPERTY, tokens().is(), id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getWechatWorkappIdentityList().isEmpty()){
			throw new SecUserManagerException("WechatWorkappIdentity is NOT FOUND with id: '"+id+"'");
		}

		WechatWorkappIdentity item = secUserToUpdate.getWechatWorkappIdentityList().first();
		beforeUpdateWechatWorkappIdentityProperties(userContext,item, secUserId,id,corpId,userId,lastLoginTime,tokensExpr);
		item.updateCorpId( corpId );
		item.updateUserId( userId );
		item.updateLastLoginTime( lastLoginTime );


		//checkParamsForAddingWechatWorkappIdentity(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withWechatWorkappIdentityList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateWechatWorkappIdentityProperties(RetailscmUserContext userContext, WechatWorkappIdentity item, String secUserId, String id,String corpId,String userId,DateTime lastLoginTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected WechatWorkappIdentity createWechatWorkappIdentity(RetailscmUserContext userContext, String corpId, String userId, DateTime lastLoginTime) throws Exception{

		WechatWorkappIdentity wechatWorkappIdentity = new WechatWorkappIdentity();
		
		
		wechatWorkappIdentity.setCorpId(corpId);		
		wechatWorkappIdentity.setUserId(userId);		
		wechatWorkappIdentity.setCreateTime(userContext.now());		
		wechatWorkappIdentity.setLastLoginTime(lastLoginTime);
	
		
		return wechatWorkappIdentity;


	}

	protected WechatWorkappIdentity createIndexedWechatWorkappIdentity(String id, int version){

		WechatWorkappIdentity wechatWorkappIdentity = new WechatWorkappIdentity();
		wechatWorkappIdentity.setId(id);
		wechatWorkappIdentity.setVersion(version);
		return wechatWorkappIdentity;

	}

	protected void checkParamsForRemovingWechatWorkappIdentityList(RetailscmUserContext userContext, String secUserId,
			String wechatWorkappIdentityIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String wechatWorkappIdentityIdItem: wechatWorkappIdentityIds){
			checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeWechatWorkappIdentityList(RetailscmUserContext userContext, String secUserId,
			String wechatWorkappIdentityIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingWechatWorkappIdentityList(userContext, secUserId,  wechatWorkappIdentityIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveWechatWorkappIdentityList(secUser, wechatWorkappIdentityIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentityList().done());
				deleteRelationListInGraph(userContext, secUser.getWechatWorkappIdentityList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentityId, int wechatWorkappIdentityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentity(wechatWorkappIdentityVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser removeWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentityId, int wechatWorkappIdentityVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingWechatWorkappIdentity(userContext,secUserId, wechatWorkappIdentityId, wechatWorkappIdentityVersion,tokensExpr);

		WechatWorkappIdentity wechatWorkappIdentity = createIndexedWechatWorkappIdentity(wechatWorkappIdentityId, wechatWorkappIdentityVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeWechatWorkappIdentity( wechatWorkappIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentityList().done());
			deleteRelationInGraph(userContext, wechatWorkappIdentity);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentityId, int wechatWorkappIdentityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentity(wechatWorkappIdentityVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser copyWechatWorkappIdentityFrom(RetailscmUserContext userContext, String secUserId,
		String wechatWorkappIdentityId, int wechatWorkappIdentityVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingWechatWorkappIdentity(userContext,secUserId, wechatWorkappIdentityId, wechatWorkappIdentityVersion,tokensExpr);

		WechatWorkappIdentity wechatWorkappIdentity = createIndexedWechatWorkappIdentity(wechatWorkappIdentityId, wechatWorkappIdentityVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyWechatWorkappIdentityFrom( wechatWorkappIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentityList().done());
			
			wechatWorkappIdentityManagerOf(userContext).onNewInstanceCreated(userContext, (WechatWorkappIdentity)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentity(wechatWorkappIdentityVersion);


		if(WechatWorkappIdentity.CORP_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity(parseString(newValueExpr));
		}
		
		if(WechatWorkappIdentity.USER_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserIdOfWechatWorkappIdentity(parseString(newValueExpr));
		}
		
		if(WechatWorkappIdentity.LAST_LOGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentity(parseTimestamp(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}

	public  SecUser updateWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingWechatWorkappIdentity(userContext, secUserId, wechatWorkappIdentityId, wechatWorkappIdentityVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withWechatWorkappIdentityList().searchWechatWorkappIdentityListWith(WechatWorkappIdentity.ID_PROPERTY, tokens().equals(), wechatWorkappIdentityId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeWechatWorkappIdentity( wechatWorkappIdentity );
			//make changes to AcceleraterAccount.
			WechatWorkappIdentity wechatWorkappIdentityIdVersionKey = createIndexedWechatWorkappIdentity(wechatWorkappIdentityId, wechatWorkappIdentityVersion);

			WechatWorkappIdentity wechatWorkappIdentity = secUser.findTheWechatWorkappIdentity(wechatWorkappIdentityIdVersionKey);
			if(wechatWorkappIdentity == null){
				throw new SecUserManagerException(wechatWorkappIdentityId+" is NOT FOUND" );
			}

			beforeUpdateWechatWorkappIdentity(userContext, wechatWorkappIdentity, secUserId, wechatWorkappIdentityId, wechatWorkappIdentityVersion, property, newValueExpr,  tokensExpr);
			wechatWorkappIdentity.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withWechatWorkappIdentityList().done());
			wechatWorkappIdentityManagerOf(userContext).onUpdated(userContext, wechatWorkappIdentity, this, "updateWechatWorkappIdentity");
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity existed, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String openId, String appId, String unionId, DateTime lastLoginTime,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);


		checkerOf(userContext).checkOpenIdOfWechatMiniappIdentity(openId);

		checkerOf(userContext).checkAppIdOfWechatMiniappIdentity(appId);

		checkerOf(userContext).checkUnionIdOfWechatMiniappIdentity(unionId);

		checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentity(lastLoginTime);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);



	}
	public  SecUser addWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String openId, String appId, String unionId, DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingWechatMiniappIdentity(userContext,secUserId,openId, appId, unionId, lastLoginTime,tokensExpr);

		WechatMiniappIdentity wechatMiniappIdentity = createWechatMiniappIdentity(userContext,openId, appId, unionId, lastLoginTime);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addWechatMiniappIdentity( wechatMiniappIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentityList().done());
			
			wechatMiniappIdentityManagerOf(userContext).onNewInstanceCreated(userContext, wechatMiniappIdentity);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWechatMiniappIdentityProperties(RetailscmUserContext userContext, String secUserId,String id,String openId,String appId,String unionId,DateTime lastLoginTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentity(id);

		checkerOf(userContext).checkOpenIdOfWechatMiniappIdentity( openId);
		checkerOf(userContext).checkAppIdOfWechatMiniappIdentity( appId);
		checkerOf(userContext).checkUnionIdOfWechatMiniappIdentity( unionId);
		checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentity( lastLoginTime);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser updateWechatMiniappIdentityProperties(RetailscmUserContext userContext, String secUserId, String id,String openId,String appId,String unionId,DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatMiniappIdentityProperties(userContext,secUserId,id,openId,appId,unionId,lastLoginTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWechatMiniappIdentityListList()
				.searchWechatMiniappIdentityListWith(WechatMiniappIdentity.ID_PROPERTY, tokens().is(), id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getWechatMiniappIdentityList().isEmpty()){
			throw new SecUserManagerException("WechatMiniappIdentity is NOT FOUND with id: '"+id+"'");
		}

		WechatMiniappIdentity item = secUserToUpdate.getWechatMiniappIdentityList().first();
		beforeUpdateWechatMiniappIdentityProperties(userContext,item, secUserId,id,openId,appId,unionId,lastLoginTime,tokensExpr);
		item.updateOpenId( openId );
		item.updateAppId( appId );
		item.updateUnionId( unionId );
		item.updateLastLoginTime( lastLoginTime );


		//checkParamsForAddingWechatMiniappIdentity(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withWechatMiniappIdentityList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateWechatMiniappIdentityProperties(RetailscmUserContext userContext, WechatMiniappIdentity item, String secUserId, String id,String openId,String appId,String unionId,DateTime lastLoginTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected WechatMiniappIdentity createWechatMiniappIdentity(RetailscmUserContext userContext, String openId, String appId, String unionId, DateTime lastLoginTime) throws Exception{

		WechatMiniappIdentity wechatMiniappIdentity = new WechatMiniappIdentity();
		
		
		wechatMiniappIdentity.setOpenId(openId);		
		wechatMiniappIdentity.setAppId(appId);		
		wechatMiniappIdentity.setUnionId(unionId);		
		wechatMiniappIdentity.setCreateTime(userContext.now());		
		wechatMiniappIdentity.setLastLoginTime(lastLoginTime);
	
		
		return wechatMiniappIdentity;


	}

	protected WechatMiniappIdentity createIndexedWechatMiniappIdentity(String id, int version){

		WechatMiniappIdentity wechatMiniappIdentity = new WechatMiniappIdentity();
		wechatMiniappIdentity.setId(id);
		wechatMiniappIdentity.setVersion(version);
		return wechatMiniappIdentity;

	}

	protected void checkParamsForRemovingWechatMiniappIdentityList(RetailscmUserContext userContext, String secUserId,
			String wechatMiniappIdentityIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String wechatMiniappIdentityIdItem: wechatMiniappIdentityIds){
			checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeWechatMiniappIdentityList(RetailscmUserContext userContext, String secUserId,
			String wechatMiniappIdentityIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingWechatMiniappIdentityList(userContext, secUserId,  wechatMiniappIdentityIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveWechatMiniappIdentityList(secUser, wechatMiniappIdentityIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentityList().done());
				deleteRelationListInGraph(userContext, secUser.getWechatMiniappIdentityList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentityId, int wechatMiniappIdentityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentity(wechatMiniappIdentityVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser removeWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentityId, int wechatMiniappIdentityVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingWechatMiniappIdentity(userContext,secUserId, wechatMiniappIdentityId, wechatMiniappIdentityVersion,tokensExpr);

		WechatMiniappIdentity wechatMiniappIdentity = createIndexedWechatMiniappIdentity(wechatMiniappIdentityId, wechatMiniappIdentityVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeWechatMiniappIdentity( wechatMiniappIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentityList().done());
			deleteRelationInGraph(userContext, wechatMiniappIdentity);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentityId, int wechatMiniappIdentityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentity(wechatMiniappIdentityVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser copyWechatMiniappIdentityFrom(RetailscmUserContext userContext, String secUserId,
		String wechatMiniappIdentityId, int wechatMiniappIdentityVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingWechatMiniappIdentity(userContext,secUserId, wechatMiniappIdentityId, wechatMiniappIdentityVersion,tokensExpr);

		WechatMiniappIdentity wechatMiniappIdentity = createIndexedWechatMiniappIdentity(wechatMiniappIdentityId, wechatMiniappIdentityVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyWechatMiniappIdentityFrom( wechatMiniappIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentityList().done());
			
			wechatMiniappIdentityManagerOf(userContext).onNewInstanceCreated(userContext, (WechatMiniappIdentity)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
		checkerOf(userContext).checkVersionOfWechatMiniappIdentity(wechatMiniappIdentityVersion);


		if(WechatMiniappIdentity.OPEN_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkOpenIdOfWechatMiniappIdentity(parseString(newValueExpr));
		}
		
		if(WechatMiniappIdentity.APP_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkAppIdOfWechatMiniappIdentity(parseString(newValueExpr));
		}
		
		if(WechatMiniappIdentity.UNION_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkUnionIdOfWechatMiniappIdentity(parseString(newValueExpr));
		}
		
		if(WechatMiniappIdentity.LAST_LOGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentity(parseTimestamp(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}

	public  SecUser updateWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingWechatMiniappIdentity(userContext, secUserId, wechatMiniappIdentityId, wechatMiniappIdentityVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withWechatMiniappIdentityList().searchWechatMiniappIdentityListWith(WechatMiniappIdentity.ID_PROPERTY, tokens().equals(), wechatMiniappIdentityId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeWechatMiniappIdentity( wechatMiniappIdentity );
			//make changes to AcceleraterAccount.
			WechatMiniappIdentity wechatMiniappIdentityIdVersionKey = createIndexedWechatMiniappIdentity(wechatMiniappIdentityId, wechatMiniappIdentityVersion);

			WechatMiniappIdentity wechatMiniappIdentity = secUser.findTheWechatMiniappIdentity(wechatMiniappIdentityIdVersionKey);
			if(wechatMiniappIdentity == null){
				throw new SecUserManagerException(wechatMiniappIdentityId+" is NOT FOUND" );
			}

			beforeUpdateWechatMiniappIdentity(userContext, wechatMiniappIdentity, secUserId, wechatMiniappIdentityId, wechatMiniappIdentityVersion, property, newValueExpr,  tokensExpr);
			wechatMiniappIdentity.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withWechatMiniappIdentityList().done());
			wechatMiniappIdentityManagerOf(userContext).onUpdated(userContext, wechatMiniappIdentity, this, "updateWechatMiniappIdentity");
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateWechatMiniappIdentity(RetailscmUserContext userContext, WechatMiniappIdentity existed, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingKeyPairIdentity(RetailscmUserContext userContext, String secUserId, String publicKey, String keyTypeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSecUser(secUserId);


		checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(publicKey);

		checkerOf(userContext).checkKeyTypeIdOfKeyPairIdentity(keyTypeId);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);



	}
	public  SecUser addKeyPairIdentity(RetailscmUserContext userContext, String secUserId, String publicKey, String keyTypeId, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingKeyPairIdentity(userContext,secUserId,publicKey, keyTypeId,tokensExpr);

		KeyPairIdentity keyPairIdentity = createKeyPairIdentity(userContext,publicKey, keyTypeId);

		SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addKeyPairIdentity( keyPairIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withKeyPairIdentityList().done());
			
			keyPairIdentityManagerOf(userContext).onNewInstanceCreated(userContext, keyPairIdentity);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingKeyPairIdentityProperties(RetailscmUserContext userContext, String secUserId,String id,String publicKey,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfKeyPairIdentity(id);

		checkerOf(userContext).checkPublicKeyOfKeyPairIdentity( publicKey);


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser updateKeyPairIdentityProperties(RetailscmUserContext userContext, String secUserId, String id,String publicKey, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeyPairIdentityProperties(userContext,secUserId,id,publicKey,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withKeyPairIdentityListList()
				.searchKeyPairIdentityListWith(KeyPairIdentity.ID_PROPERTY, tokens().is(), id).done();

		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);

		if(secUserToUpdate.getKeyPairIdentityList().isEmpty()){
			throw new SecUserManagerException("KeyPairIdentity is NOT FOUND with id: '"+id+"'");
		}

		KeyPairIdentity item = secUserToUpdate.getKeyPairIdentityList().first();
		beforeUpdateKeyPairIdentityProperties(userContext,item, secUserId,id,publicKey,tokensExpr);
		item.updatePublicKey( publicKey );


		//checkParamsForAddingKeyPairIdentity(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withKeyPairIdentityList().done());
		synchronized(secUser){
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateKeyPairIdentityProperties(RetailscmUserContext userContext, KeyPairIdentity item, String secUserId, String id,String publicKey, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected KeyPairIdentity createKeyPairIdentity(RetailscmUserContext userContext, String publicKey, String keyTypeId) throws Exception{

		KeyPairIdentity keyPairIdentity = new KeyPairIdentity();
		
		
		keyPairIdentity.setPublicKey(publicKey);		
		PublicKeyType  keyType = new PublicKeyType();
		keyType.setId(keyTypeId);		
		keyPairIdentity.setKeyType(keyType);		
		keyPairIdentity.setCreateTime(userContext.now());
	
		
		return keyPairIdentity;


	}

	protected KeyPairIdentity createIndexedKeyPairIdentity(String id, int version){

		KeyPairIdentity keyPairIdentity = new KeyPairIdentity();
		keyPairIdentity.setId(id);
		keyPairIdentity.setVersion(version);
		return keyPairIdentity;

	}

	protected void checkParamsForRemovingKeyPairIdentityList(RetailscmUserContext userContext, String secUserId,
			String keyPairIdentityIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String keyPairIdentityIdItem: keyPairIdentityIds){
			checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	}
	public  SecUser removeKeyPairIdentityList(RetailscmUserContext userContext, String secUserId,
			String keyPairIdentityIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingKeyPairIdentityList(userContext, secUserId,  keyPairIdentityIds, tokensExpr);


			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveKeyPairIdentityList(secUser, keyPairIdentityIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withKeyPairIdentityList().done());
				deleteRelationListInGraph(userContext, secUser.getKeyPairIdentityList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingKeyPairIdentity(RetailscmUserContext userContext, String secUserId,
		String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
		checkerOf(userContext).checkVersionOfKeyPairIdentity(keyPairIdentityVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser removeKeyPairIdentity(RetailscmUserContext userContext, String secUserId,
		String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingKeyPairIdentity(userContext,secUserId, keyPairIdentityId, keyPairIdentityVersion,tokensExpr);

		KeyPairIdentity keyPairIdentity = createIndexedKeyPairIdentity(keyPairIdentityId, keyPairIdentityVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeKeyPairIdentity( keyPairIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withKeyPairIdentityList().done());
			deleteRelationInGraph(userContext, keyPairIdentity);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingKeyPairIdentity(RetailscmUserContext userContext, String secUserId,
		String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
		checkerOf(userContext).checkVersionOfKeyPairIdentity(keyPairIdentityVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}
	public  SecUser copyKeyPairIdentityFrom(RetailscmUserContext userContext, String secUserId,
		String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingKeyPairIdentity(userContext,secUserId, keyPairIdentityId, keyPairIdentityVersion,tokensExpr);

		KeyPairIdentity keyPairIdentity = createIndexedKeyPairIdentity(keyPairIdentityId, keyPairIdentityVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			secUser.copyKeyPairIdentityFrom( keyPairIdentity );
			secUser = saveSecUser(userContext, secUser, tokens().withKeyPairIdentityList().done());
			
			keyPairIdentityManagerOf(userContext).onNewInstanceCreated(userContext, (KeyPairIdentity)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingKeyPairIdentity(RetailscmUserContext userContext, String secUserId, String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
		checkerOf(userContext).checkVersionOfKeyPairIdentity(keyPairIdentityVersion);


		if(KeyPairIdentity.PUBLIC_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


	}

	public  SecUser updateKeyPairIdentity(RetailscmUserContext userContext, String secUserId, String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingKeyPairIdentity(userContext, secUserId, keyPairIdentityId, keyPairIdentityVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withKeyPairIdentityList().searchKeyPairIdentityListWith(KeyPairIdentity.ID_PROPERTY, tokens().equals(), keyPairIdentityId).done();



		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);

		synchronized(secUser){
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeKeyPairIdentity( keyPairIdentity );
			//make changes to AcceleraterAccount.
			KeyPairIdentity keyPairIdentityIdVersionKey = createIndexedKeyPairIdentity(keyPairIdentityId, keyPairIdentityVersion);

			KeyPairIdentity keyPairIdentity = secUser.findTheKeyPairIdentity(keyPairIdentityIdVersionKey);
			if(keyPairIdentity == null){
				throw new SecUserManagerException(keyPairIdentityId+" is NOT FOUND" );
			}

			beforeUpdateKeyPairIdentity(userContext, keyPairIdentity, secUserId, keyPairIdentityId, keyPairIdentityVersion, property, newValueExpr,  tokensExpr);
			keyPairIdentity.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withKeyPairIdentityList().done());
			keyPairIdentityManagerOf(userContext).onUpdated(userContext, keyPairIdentity, this, "updateKeyPairIdentity");
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateKeyPairIdentity(RetailscmUserContext userContext, KeyPairIdentity existed, String secUserId, String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, SecUser newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    secUserDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
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
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, SecUser.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
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
		page.setPageTitle("安全用户列表");
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
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		SecUser merchantObj = (SecUser) this.view(userContext, secUserId);
    String merchantObjId = secUserId;
    String linkToUrl =	"secUserManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "安全用户"+"详情";
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
				MapUtil.put("id", "2-login")
				    .put("fieldName", "login")
				    .put("label", "登录名")
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
				    .put("label", "邮箱")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("email", merchantObj.getEmail());

		propList.add(
				MapUtil.put("id", "5-pwd")
				    .put("fieldName", "pwd")
				    .put("label", "密码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("pwd", merchantObj.getPwd());

		propList.add(
				MapUtil.put("id", "6-weixinOpenid")
				    .put("fieldName", "weixinOpenid")
				    .put("label", "微信openId")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("weixinOpenid", merchantObj.getWeixinOpenid());

		propList.add(
				MapUtil.put("id", "7-weixinAppid")
				    .put("fieldName", "weixinAppid")
				    .put("label", "微信应用ID")
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
				    .put("label", "验证码有效期")
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

		//处理Section：wechatWorkappIdentityListSection
		Map wechatWorkappIdentityListSection = ListofUtils.buildSection(
		    "wechatWorkappIdentityListSection",
		    "微信企业号认证列表",
		    null,
		    "",
		    "__no_group",
		    "wechatWorkappIdentityManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(wechatWorkappIdentityListSection);

		result.put("wechatWorkappIdentityListSection", ListofUtils.toShortList(merchantObj.getWechatWorkappIdentityList(), "wechatWorkappIdentity"));

		//处理Section：wechatMiniappIdentityListSection
		Map wechatMiniappIdentityListSection = ListofUtils.buildSection(
		    "wechatMiniappIdentityListSection",
		    "微信小程序认证列表",
		    null,
		    "",
		    "__no_group",
		    "wechatMiniappIdentityManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(wechatMiniappIdentityListSection);

		result.put("wechatMiniappIdentityListSection", ListofUtils.toShortList(merchantObj.getWechatMiniappIdentityList(), "wechatMiniappIdentity"));

		//处理Section：keyPairIdentityListSection
		Map keyPairIdentityListSection = ListofUtils.buildSection(
		    "keyPairIdentityListSection",
		    "密钥对身份列表",
		    null,
		    "",
		    "__no_group",
		    "keyPairIdentityManager/listBySecUser/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(keyPairIdentityListSection);

		result.put("keyPairIdentityListSection", ListofUtils.toShortList(merchantObj.getKeyPairIdentityList(), "keyPairIdentity"));

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




