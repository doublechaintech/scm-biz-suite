
package com.doublechaintech.retailscm.userapp;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.listaccess.ListAccess;import com.doublechaintech.retailscm.quicklink.QuickLink;import com.doublechaintech.retailscm.secuser.CandidateSecUser;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class UserAppManagerImpl extends CustomRetailscmCheckerManager implements UserAppManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "UserApp";
	@Override
	public UserAppDAO daoOf(RetailscmUserContext userContext) {
		return userAppDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws UserAppManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new UserAppManagerException(message);

	}



 	protected UserApp saveUserApp(RetailscmUserContext userContext, UserApp userApp, String [] tokensExpr) throws Exception{
 		//return getUserAppDAO().save(userApp, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveUserApp(userContext, userApp, tokens);
 	}

 	protected UserApp saveUserAppDetail(RetailscmUserContext userContext, UserApp userApp) throws Exception{


 		return saveUserApp(userContext, userApp, allTokens());
 	}

 	public UserApp loadUserApp(RetailscmUserContext userContext, String userAppId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);

		checkerOf(userContext).throwExceptionIfHasErrors( UserAppManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}


 	 public UserApp searchUserApp(RetailscmUserContext userContext, String userAppId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);

		checkerOf(userContext).throwExceptionIfHasErrors( UserAppManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}



 	protected UserApp present(RetailscmUserContext userContext, UserApp userApp, Map<String, Object> tokens) throws Exception {


		addActions(userContext,userApp,tokens);
    

		UserApp  userAppToPresent = userAppDaoOf(userContext).present(userApp, tokens);

		List<BaseEntity> entityListToNaming = userAppToPresent.collectRefercencesFromLists();
		userAppDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,userApp,tokens);

		return  userAppToPresent;


	}



 	public UserApp loadUserAppDetail(RetailscmUserContext userContext, String userAppId) throws Exception{
 		UserApp userApp = loadUserApp( userContext, userAppId, allTokens());
 		return present(userContext,userApp, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String userAppId) throws Exception{
 		UserApp userApp = loadUserApp( userContext, userAppId, viewTokens());
 		markVisited(userContext, userApp);
 		return present(userContext,userApp, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String userAppId) throws Exception{
		UserApp userApp = loadUserApp( userContext, userAppId, viewTokens());
		userApp.summarySuffix();
		markVisited(userContext, userApp);
 		return present(userContext,userApp, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String userAppId) throws Exception{
		UserApp userApp = loadUserApp( userContext, userAppId, analyzeTokens());
		markVisited(userContext, userApp);
		return present(userContext,userApp, analyzeTokens());

	}
 	protected UserApp saveUserApp(RetailscmUserContext userContext, UserApp userApp, Map<String,Object>tokens) throws Exception{
 	
 		return userAppDaoOf(userContext).save(userApp, tokens);
 	}
 	protected UserApp loadUserApp(RetailscmUserContext userContext, String userAppId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfUserApp(userAppId);

		checkerOf(userContext).throwExceptionIfHasErrors( UserAppManagerException.class);



 		return userAppDaoOf(userContext).load(userAppId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, UserApp userApp, Map<String, Object> tokens){
		super.addActions(userContext, userApp, tokens);

		addAction(userContext, userApp, tokens,"@create","createUserApp","createUserApp/","main","primary");
		addAction(userContext, userApp, tokens,"@update","updateUserApp","updateUserApp/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"@copy","cloneUserApp","cloneUserApp/"+userApp.getId()+"/","main","primary");

		addAction(userContext, userApp, tokens,"user_app.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"user_app.addQuickLink","addQuickLink","addQuickLink/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeQuickLink","removeQuickLink","removeQuickLink/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateQuickLink","updateQuickLink","updateQuickLink/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyQuickLinkFrom","copyQuickLinkFrom","copyQuickLinkFrom/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.addListAccess","addListAccess","addListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeListAccess","removeListAccess","removeListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateListAccess","updateListAccess","updateListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyListAccessFrom","copyListAccessFrom","copyListAccessFrom/"+userApp.getId()+"/","listAccessList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, UserApp userApp, Map<String, Object> tokens){








  @Override
  public List<UserApp> searchUserAppList(RetailscmUserContext ctx, UserAppRequest pRequest){
      pRequest.setUserContext(ctx);
      List<UserApp> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public UserApp searchUserApp(RetailscmUserContext ctx, UserAppRequest pRequest){
    pRequest.limit(0, 1);
    List<UserApp> list = searchUserAppList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public UserApp createUserApp(RetailscmUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String appType,String appId,String ctxType,String ctxId,String location) throws Exception
	{





		checkerOf(userContext).checkTitleOfUserApp(title);
		checkerOf(userContext).checkAppIconOfUserApp(appIcon);
		checkerOf(userContext).checkFullAccessOfUserApp(fullAccess);
		checkerOf(userContext).checkPermissionOfUserApp(permission);
		checkerOf(userContext).checkAppTypeOfUserApp(appType);
		checkerOf(userContext).checkAppIdOfUserApp(appId);
		checkerOf(userContext).checkCtxTypeOfUserApp(ctxType);
		checkerOf(userContext).checkCtxIdOfUserApp(ctxId);
		checkerOf(userContext).checkLocationOfUserApp(location);


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);



		UserApp userApp=createNewUserApp();	

		userApp.setTitle(title);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		userApp.setSecUser(secUser);
		
		
		userApp.setAppIcon(appIcon);
		userApp.setFullAccess(fullAccess);
		userApp.setPermission(permission);
		userApp.setAppType(appType);
		userApp.setAppId(appId);
		userApp.setCtxType(ctxType);
		userApp.setCtxId(ctxId);
		userApp.setLocation(location);

		userApp = saveUserApp(userContext, userApp, emptyOptions());
		
		onNewInstanceCreated(userContext, userApp);
		return userApp;


	}
	protected UserApp createNewUserApp()
	{

		return new UserApp();
	}

	protected void checkParamsForUpdatingUserApp(RetailscmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp( userAppVersion);


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


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);



	}



	public UserApp clone(RetailscmUserContext userContext, String fromUserAppId) throws Exception{

		return userAppDaoOf(userContext).clone(fromUserAppId, this.allTokens());
	}

	public UserApp internalSaveUserApp(RetailscmUserContext userContext, UserApp userApp) throws Exception
	{
		return internalSaveUserApp(userContext, userApp, allTokens());

	}
	public UserApp internalSaveUserApp(RetailscmUserContext userContext, UserApp userApp, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);


		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.
			if (userApp.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixUserApp(userApp);
			userApp = saveUserApp(userContext, userApp, options);
			return userApp;

		}

	}

	public UserApp updateUserApp(RetailscmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);



		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		if(userApp.getVersion() != userAppVersion){
			String message = "The target version("+userApp.getVersion()+") is not equals to version("+userAppVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.
			
			userApp.changeProperty(property, newValueExpr);
			userApp = saveUserApp(userContext, userApp, tokens().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
			//return saveUserApp(userContext, userApp, tokens().done());
		}

	}

	public UserApp updateUserAppProperty(RetailscmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);

		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		if(userApp.getVersion() != userAppVersion){
			String message = "The target version("+userApp.getVersion()+") is not equals to version("+userAppVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.

			userApp.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
			//return saveUserApp(userContext, userApp, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected UserAppTokens tokens(){
		return UserAppTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserAppTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortQuickLinkListWith(QuickLink.ID_PROPERTY,sortDesc())
		.sortListAccessListWith(ListAccess.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAppTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(RetailscmUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}
 	public UserApp transferToAnotherSecUser(RetailscmUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, userAppId,anotherSecUserId);
 
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());
			userApp.updateSecUser(secUser);
			
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(RetailscmUserContext userContext, String userAppId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);

 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}

 	public UserApp transferToAnotherSecUserWithLogin(RetailscmUserContext userContext, String userAppId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, userAppId,anotherLogin);
 		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			userApp.updateSecUser(secUser);
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(RetailscmUserContext userContext, String userAppId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);

 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}

 	public UserApp transferToAnotherSecUserWithEmail(RetailscmUserContext userContext, String userAppId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, userAppId,anotherEmail);
 		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			userApp.updateSecUser(secUser);
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(RetailscmUserContext userContext, String userAppId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);

 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}

 	public UserApp transferToAnotherSecUserWithMobile(RetailscmUserContext userContext, String userAppId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, userAppId,anotherMobile);
 		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			userApp.updateSecUser(secUser);
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

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
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForUserApp(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		//deleteInternal(userContext, userAppId, userAppVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{

		userAppDaoOf(userContext).delete(userAppId, userAppVersion);
	}

	public UserApp forgetByAll(RetailscmUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		return forgetByAllInternal(userContext, userAppId, userAppVersion);
	}
	protected UserApp forgetByAllInternal(RetailscmUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{

		return userAppDaoOf(userContext).disconnectFromAll(userAppId, userAppVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserAppManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userAppDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingQuickLink(RetailscmUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserApp(userAppId);


		checkerOf(userContext).checkNameOfQuickLink(name);

		checkerOf(userContext).checkIconOfQuickLink(icon);

		checkerOf(userContext).checkImagePathOfQuickLink(imagePath);

		checkerOf(userContext).checkLinkTargetOfQuickLink(linkTarget);


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);



	}
	public  UserApp addQuickLink(RetailscmUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingQuickLink(userContext,userAppId,name, icon, imagePath, linkTarget,tokensExpr);

		QuickLink quickLink = createQuickLink(userContext,name, icon, imagePath, linkTarget);

		UserApp userApp = loadUserApp(userContext, userAppId, emptyOptions());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addQuickLink( quickLink );
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			
			quickLinkManagerOf(userContext).onNewInstanceCreated(userContext, quickLink);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingQuickLinkProperties(RetailscmUserContext userContext, String userAppId,String id,String name,String icon,String imagePath,String linkTarget,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfQuickLink(id);

		checkerOf(userContext).checkNameOfQuickLink( name);
		checkerOf(userContext).checkIconOfQuickLink( icon);
		checkerOf(userContext).checkImagePathOfQuickLink( imagePath);
		checkerOf(userContext).checkLinkTargetOfQuickLink( linkTarget);


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp updateQuickLinkProperties(RetailscmUserContext userContext, String userAppId, String id,String name,String icon,String imagePath,String linkTarget, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingQuickLinkProperties(userContext,userAppId,id,name,icon,imagePath,linkTarget,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withQuickLinkListList()
				.searchQuickLinkListWith(QuickLink.ID_PROPERTY, tokens().is(), id).done();

		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);

		if(userAppToUpdate.getQuickLinkList().isEmpty()){
			throw new UserAppManagerException("QuickLink is NOT FOUND with id: '"+id+"'");
		}

		QuickLink item = userAppToUpdate.getQuickLinkList().first();
		beforeUpdateQuickLinkProperties(userContext,item, userAppId,id,name,icon,imagePath,linkTarget,tokensExpr);
		item.updateName( name );
		item.updateIcon( icon );
		item.updateImagePath( imagePath );
		item.updateLinkTarget( linkTarget );


		//checkParamsForAddingQuickLink(userContext,userAppId,name, code, used,tokensExpr);
		UserApp userApp = saveUserApp(userContext, userAppToUpdate, tokens().withQuickLinkList().done());
		synchronized(userApp){
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateQuickLinkProperties(RetailscmUserContext userContext, QuickLink item, String userAppId, String id,String name,String icon,String imagePath,String linkTarget, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected QuickLink createQuickLink(RetailscmUserContext userContext, String name, String icon, String imagePath, String linkTarget) throws Exception{

		QuickLink quickLink = new QuickLink();
		
		
		quickLink.setName(name);		
		quickLink.setIcon(icon);		
		quickLink.setImagePath(imagePath);		
		quickLink.setLinkTarget(linkTarget);		
		quickLink.setCreateTime(userContext.now());
	
		
		return quickLink;


	}

	protected QuickLink createIndexedQuickLink(String id, int version){

		QuickLink quickLink = new QuickLink();
		quickLink.setId(id);
		quickLink.setVersion(version);
		return quickLink;

	}

	protected void checkParamsForRemovingQuickLinkList(RetailscmUserContext userContext, String userAppId,
			String quickLinkIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		for(String quickLinkIdItem: quickLinkIds){
			checkerOf(userContext).checkIdOfQuickLink(quickLinkIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeQuickLinkList(RetailscmUserContext userContext, String userAppId,
			String quickLinkIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingQuickLinkList(userContext, userAppId,  quickLinkIds, tokensExpr);


			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userAppDaoOf(userContext).planToRemoveQuickLinkList(userApp, quickLinkIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
				deleteRelationListInGraph(userContext, userApp.getQuickLinkList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingQuickLink(RetailscmUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink(quickLinkVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp removeQuickLink(RetailscmUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingQuickLink(userContext,userAppId, quickLinkId, quickLinkVersion,tokensExpr);

		QuickLink quickLink = createIndexedQuickLink(quickLinkId, quickLinkVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeQuickLink( quickLink );
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			deleteRelationInGraph(userContext, quickLink);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingQuickLink(RetailscmUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink(quickLinkVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp copyQuickLinkFrom(RetailscmUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingQuickLink(userContext,userAppId, quickLinkId, quickLinkVersion,tokensExpr);

		QuickLink quickLink = createIndexedQuickLink(quickLinkId, quickLinkVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userApp.copyQuickLinkFrom( quickLink );
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			
			quickLinkManagerOf(userContext).onNewInstanceCreated(userContext, (QuickLink)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingQuickLink(RetailscmUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink(quickLinkVersion);


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
		


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}

	public  UserApp updateQuickLink(RetailscmUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingQuickLink(userContext, userAppId, quickLinkId, quickLinkVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withQuickLinkList().searchQuickLinkListWith(QuickLink.ID_PROPERTY, tokens().equals(), quickLinkId).done();



		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);

		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeQuickLink( quickLink );
			//make changes to AcceleraterAccount.
			QuickLink quickLinkIdVersionKey = createIndexedQuickLink(quickLinkId, quickLinkVersion);

			QuickLink quickLink = userApp.findTheQuickLink(quickLinkIdVersionKey);
			if(quickLink == null){
				throw new UserAppManagerException(quickLinkId+" is NOT FOUND" );
			}

			beforeUpdateQuickLink(userContext, quickLink, userAppId, quickLinkId, quickLinkVersion, property, newValueExpr,  tokensExpr);
			quickLink.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			quickLinkManagerOf(userContext).onUpdated(userContext, quickLink, this, "updateQuickLink");
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateQuickLink(RetailscmUserContext userContext, QuickLink existed, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingListAccess(RetailscmUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserApp(userAppId);


		checkerOf(userContext).checkNameOfListAccess(name);

		checkerOf(userContext).checkInternalNameOfListAccess(internalName);

		checkerOf(userContext).checkReadPermissionOfListAccess(readPermission);

		checkerOf(userContext).checkCreatePermissionOfListAccess(createPermission);

		checkerOf(userContext).checkDeletePermissionOfListAccess(deletePermission);

		checkerOf(userContext).checkUpdatePermissionOfListAccess(updatePermission);

		checkerOf(userContext).checkExecutionPermissionOfListAccess(executionPermission);


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);



	}
	public  UserApp addListAccess(RetailscmUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingListAccess(userContext,userAppId,name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission,tokensExpr);

		ListAccess listAccess = createListAccess(userContext,name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission);

		UserApp userApp = loadUserApp(userContext, userAppId, emptyOptions());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addListAccess( listAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			
			listAccessManagerOf(userContext).onNewInstanceCreated(userContext, listAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingListAccessProperties(RetailscmUserContext userContext, String userAppId,String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfListAccess(id);

		checkerOf(userContext).checkNameOfListAccess( name);
		checkerOf(userContext).checkInternalNameOfListAccess( internalName);
		checkerOf(userContext).checkReadPermissionOfListAccess( readPermission);
		checkerOf(userContext).checkCreatePermissionOfListAccess( createPermission);
		checkerOf(userContext).checkDeletePermissionOfListAccess( deletePermission);
		checkerOf(userContext).checkUpdatePermissionOfListAccess( updatePermission);
		checkerOf(userContext).checkExecutionPermissionOfListAccess( executionPermission);


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp updateListAccessProperties(RetailscmUserContext userContext, String userAppId, String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingListAccessProperties(userContext,userAppId,id,name,internalName,readPermission,createPermission,deletePermission,updatePermission,executionPermission,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withListAccessListList()
				.searchListAccessListWith(ListAccess.ID_PROPERTY, tokens().is(), id).done();

		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);

		if(userAppToUpdate.getListAccessList().isEmpty()){
			throw new UserAppManagerException("ListAccess is NOT FOUND with id: '"+id+"'");
		}

		ListAccess item = userAppToUpdate.getListAccessList().first();
		beforeUpdateListAccessProperties(userContext,item, userAppId,id,name,internalName,readPermission,createPermission,deletePermission,updatePermission,executionPermission,tokensExpr);
		item.updateName( name );
		item.updateInternalName( internalName );
		item.updateReadPermission( readPermission );
		item.updateCreatePermission( createPermission );
		item.updateDeletePermission( deletePermission );
		item.updateUpdatePermission( updatePermission );
		item.updateExecutionPermission( executionPermission );


		//checkParamsForAddingListAccess(userContext,userAppId,name, code, used,tokensExpr);
		UserApp userApp = saveUserApp(userContext, userAppToUpdate, tokens().withListAccessList().done());
		synchronized(userApp){
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateListAccessProperties(RetailscmUserContext userContext, ListAccess item, String userAppId, String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected ListAccess createListAccess(RetailscmUserContext userContext, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission) throws Exception{

		ListAccess listAccess = new ListAccess();
		
		
		listAccess.setName(name);		
		listAccess.setInternalName(internalName);		
		listAccess.setReadPermission(readPermission);		
		listAccess.setCreatePermission(createPermission);		
		listAccess.setDeletePermission(deletePermission);		
		listAccess.setUpdatePermission(updatePermission);		
		listAccess.setExecutionPermission(executionPermission);
	
		
		return listAccess;


	}

	protected ListAccess createIndexedListAccess(String id, int version){

		ListAccess listAccess = new ListAccess();
		listAccess.setId(id);
		listAccess.setVersion(version);
		return listAccess;

	}

	protected void checkParamsForRemovingListAccessList(RetailscmUserContext userContext, String userAppId,
			String listAccessIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		for(String listAccessIdItem: listAccessIds){
			checkerOf(userContext).checkIdOfListAccess(listAccessIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeListAccessList(RetailscmUserContext userContext, String userAppId,
			String listAccessIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingListAccessList(userContext, userAppId,  listAccessIds, tokensExpr);


			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userAppDaoOf(userContext).planToRemoveListAccessList(userApp, listAccessIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
				deleteRelationListInGraph(userContext, userApp.getListAccessList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingListAccess(RetailscmUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess(listAccessVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp removeListAccess(RetailscmUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingListAccess(userContext,userAppId, listAccessId, listAccessVersion,tokensExpr);

		ListAccess listAccess = createIndexedListAccess(listAccessId, listAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeListAccess( listAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			deleteRelationInGraph(userContext, listAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingListAccess(RetailscmUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess(listAccessVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp copyListAccessFrom(RetailscmUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingListAccess(userContext,userAppId, listAccessId, listAccessVersion,tokensExpr);

		ListAccess listAccess = createIndexedListAccess(listAccessId, listAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userApp.copyListAccessFrom( listAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			
			listAccessManagerOf(userContext).onNewInstanceCreated(userContext, (ListAccess)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingListAccess(RetailscmUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess(listAccessVersion);


		if(ListAccess.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfListAccess(parseString(newValueExpr));
		}
		
		if(ListAccess.INTERNAL_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkInternalNameOfListAccess(parseString(newValueExpr));
		}
		
		if(ListAccess.READ_PERMISSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkReadPermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.CREATE_PERMISSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkCreatePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.DELETE_PERMISSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDeletePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.UPDATE_PERMISSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkUpdatePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.EXECUTION_PERMISSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkExecutionPermissionOfListAccess(parseBoolean(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}

	public  UserApp updateListAccess(RetailscmUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingListAccess(userContext, userAppId, listAccessId, listAccessVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withListAccessList().searchListAccessListWith(ListAccess.ID_PROPERTY, tokens().equals(), listAccessId).done();



		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);

		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeListAccess( listAccess );
			//make changes to AcceleraterAccount.
			ListAccess listAccessIdVersionKey = createIndexedListAccess(listAccessId, listAccessVersion);

			ListAccess listAccess = userApp.findTheListAccess(listAccessIdVersionKey);
			if(listAccess == null){
				throw new UserAppManagerException(listAccessId+" is NOT FOUND" );
			}

			beforeUpdateListAccess(userContext, listAccess, userAppId, listAccessId, listAccessVersion, property, newValueExpr,  tokensExpr);
			listAccess.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			listAccessManagerOf(userContext).onUpdated(userContext, listAccess, this, "updateListAccess");
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateListAccess(RetailscmUserContext userContext, ListAccess existed, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, UserApp newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    userAppDaoOf(ctx).loadAllAsStream().forEach(
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
		//   UserApp newUserApp = this.createUserApp(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newUserApp
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
    key.put(UserApp.APP_TYPE_PROPERTY, UserApp.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<UserApp> list) throws Exception {
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
		SmartList<UserApp> list = userAppDaoOf(userContext).findUserAppBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(UserApp.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("应用列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String userAppId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		UserApp merchantObj = (UserApp) this.view(userContext, userAppId);
    String merchantObjId = userAppId;
    String linkToUrl =	"userAppManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "应用"+"详情";
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
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "标题")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "系统用户")
				    .put("type", "auto")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

		propList.add(
				MapUtil.put("id", "4-appIcon")
				    .put("fieldName", "appIcon")
				    .put("label", "图标")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("appIcon", merchantObj.getAppIcon());

		propList.add(
				MapUtil.put("id", "5-fullAccess")
				    .put("fieldName", "fullAccess")
				    .put("label", "完全访问")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("fullAccess", merchantObj.getFullAccess());

		propList.add(
				MapUtil.put("id", "6-permission")
				    .put("fieldName", "permission")
				    .put("label", "权限")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("permission", merchantObj.getPermission());

		propList.add(
				MapUtil.put("id", "7-appType")
				    .put("fieldName", "appType")
				    .put("label", "对象类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("appType", merchantObj.getAppType());

		propList.add(
				MapUtil.put("id", "8-appId")
				    .put("fieldName", "appId")
				    .put("label", "对象ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("appId", merchantObj.getAppId());

		propList.add(
				MapUtil.put("id", "9-ctxType")
				    .put("fieldName", "ctxType")
				    .put("label", "上下文类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("ctxType", merchantObj.getCtxType());

		propList.add(
				MapUtil.put("id", "10-ctxId")
				    .put("fieldName", "ctxId")
				    .put("label", "上下文类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("ctxId", merchantObj.getCtxId());

		propList.add(
				MapUtil.put("id", "11-location")
				    .put("fieldName", "location")
				    .put("label", "位置")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("location", merchantObj.getLocation());

		//处理 sectionList

		//处理Section：quickLinkListSection
		Map quickLinkListSection = ListofUtils.buildSection(
		    "quickLinkListSection",
		    "快速链接列表",
		    null,
		    "",
		    "__no_group",
		    "quickLinkManager/listByApp/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(quickLinkListSection);

		result.put("quickLinkListSection", ListofUtils.toShortList(merchantObj.getQuickLinkList(), "quickLink"));

		//处理Section：listAccessListSection
		Map listAccessListSection = ListofUtils.buildSection(
		    "listAccessListSection",
		    "访问列表",
		    null,
		    "",
		    "__no_group",
		    "listAccessManager/listByApp/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(listAccessListSection);

		result.put("listAccessListSection", ListofUtils.toShortList(merchantObj.getListAccessList(), "listAccess"));

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




