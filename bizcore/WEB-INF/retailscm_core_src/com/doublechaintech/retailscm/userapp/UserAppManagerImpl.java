
package com.doublechaintech.retailscm.userapp;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.objectaccess.ObjectAccess;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.CandidateSecUser;

import com.doublechaintech.retailscm.userapp.UserApp;






public class UserAppManagerImpl extends CustomRetailscmCheckerManager implements UserAppManager {
	
	private static final String SERVICE_TYPE = "UserApp";
	
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
 
 		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().throwExceptionIfHasErrors( UserAppManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}
 	
 	
 	 public UserApp searchUserApp(RetailscmUserContext userContext, String userAppId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().throwExceptionIfHasErrors( UserAppManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}
 	
 	

 	protected UserApp present(RetailscmUserContext userContext, UserApp userApp, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userApp,tokens);
		
		
		UserApp  userAppToPresent = userContext.getDAOGroup().getUserAppDAO().present(userApp, tokens);
		
		List<BaseEntity> entityListToNaming = userAppToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getUserAppDAO().alias(entityListToNaming);
		
		return  userAppToPresent;
		
		
	}
 
 	
 	
 	public UserApp loadUserAppDetail(RetailscmUserContext userContext, String userAppId) throws Exception{	
 		UserApp userApp = loadUserApp( userContext, userAppId, allTokens());
 		return present(userContext,userApp, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String userAppId) throws Exception{	
 		UserApp userApp = loadUserApp( userContext, userAppId, viewTokens());
 		return present(userContext,userApp, allTokens());
		
 	}
 	protected UserApp saveUserApp(RetailscmUserContext userContext, UserApp userApp, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getUserAppDAO().save(userApp, tokens);
 	}
 	protected UserApp loadUserApp(RetailscmUserContext userContext, String userAppId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().throwExceptionIfHasErrors( UserAppManagerException.class);

 
 		return userContext.getDAOGroup().getUserAppDAO().load(userAppId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, UserApp userApp, Map<String, Object> tokens){
		super.addActions(userContext, userApp, tokens);
		
		addAction(userContext, userApp, tokens,"@create","createUserApp","createUserApp/","main","primary");
		addAction(userContext, userApp, tokens,"@update","updateUserApp","updateUserApp/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"@copy","cloneUserApp","cloneUserApp/"+userApp.getId()+"/","main","primary");
		
		addAction(userContext, userApp, tokens,"user_app.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"user_app.addListAccess","addListAccess","addListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeListAccess","removeListAccess","removeListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateListAccess","updateListAccess","updateListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyListAccessFrom","copyListAccessFrom","copyListAccessFrom/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.addObjectAccess","addObjectAccess","addObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeObjectAccess","removeObjectAccess","removeObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateObjectAccess","updateObjectAccess","updateObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyObjectAccessFrom","copyObjectAccessFrom","copyObjectAccessFrom/"+userApp.getId()+"/","objectAccessList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, UserApp userApp, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserApp createUserApp(RetailscmUserContext userContext,String title, String secUserId, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfUserApp(title);
		userContext.getChecker().checkAppIconOfUserApp(appIcon);
		userContext.getChecker().checkFullAccessOfUserApp(fullAccess);
		userContext.getChecker().checkPermissionOfUserApp(permission);
		userContext.getChecker().checkObjectTypeOfUserApp(objectType);
		userContext.getChecker().checkObjectIdOfUserApp(objectId);
		userContext.getChecker().checkLocationOfUserApp(location);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);


		UserApp userApp=createNewUserApp();	

		userApp.setTitle(title);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		userApp.setSecUser(secUser);
		
		
		userApp.setAppIcon(appIcon);
		userApp.setFullAccess(fullAccess);
		userApp.setPermission(permission);
		userApp.setObjectType(objectType);
		userApp.setObjectId(objectId);
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
		

		
		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().checkVersionOfUserApp( userAppVersion);
		

		if(UserApp.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfUserApp(parseString(newValueExpr));
		}		

		
		if(UserApp.APP_ICON_PROPERTY.equals(property)){
			userContext.getChecker().checkAppIconOfUserApp(parseString(newValueExpr));
		}
		if(UserApp.FULL_ACCESS_PROPERTY.equals(property)){
			userContext.getChecker().checkFullAccessOfUserApp(parseBoolean(newValueExpr));
		}
		if(UserApp.PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkPermissionOfUserApp(parseString(newValueExpr));
		}
		if(UserApp.OBJECT_TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkObjectTypeOfUserApp(parseString(newValueExpr));
		}
		if(UserApp.OBJECT_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkObjectIdOfUserApp(parseString(newValueExpr));
		}
		if(UserApp.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfUserApp(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
		
	}
	
	
	
	public UserApp clone(RetailscmUserContext userContext, String fromUserAppId) throws Exception{
		
		return userContext.getDAOGroup().getUserAppDAO().clone(fromUserAppId, this.allTokens());
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
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortListAccessListWith("id","desc")
		.sortObjectAccessListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAppTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(RetailscmUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserApp(userAppId);
 		userContext.getChecker().checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
 		
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
 		
 		userContext.getChecker().checkIdOfUserApp(userAppId);
 		userContext.getChecker().checkLoginOfSecUser( anotherLogin);
 		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
 		
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
 		
 		userContext.getChecker().checkIdOfUserApp(userAppId);
 		userContext.getChecker().checkEmailOfSecUser( anotherEmail);
 		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
 		
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
 		
 		userContext.getChecker().checkIdOfUserApp(userAppId);
 		userContext.getChecker().checkMobileOfSecUser( anotherMobile);
 		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
 		
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
		SmartList<SecUser> candidateList = userContext.getDAOGroup().getSecUserDAO().requestCandidateSecUserForUserApp(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected SecUser loadSecUser(RetailscmUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(RetailscmUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().loadByLogin(newLogin, options);
 	}
 	
 	
 	protected SecUser loadSecUserWithEmail(RetailscmUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().loadByEmail(newEmail, options);
 	}
 	
 	
 	protected SecUser loadSecUserWithMobile(RetailscmUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().loadByMobile(newMobile, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		//deleteInternal(userContext, userAppId, userAppVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{
			
		userContext.getDAOGroup().getUserAppDAO().delete(userAppId, userAppVersion);
	}
	
	public UserApp forgetByAll(RetailscmUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		return forgetByAllInternal(userContext, userAppId, userAppVersion);		
	}
	protected UserApp forgetByAllInternal(RetailscmUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{
			
		return userContext.getDAOGroup().getUserAppDAO().disconnectFromAll(userAppId, userAppVersion);
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
		return userContext.getDAOGroup().getUserAppDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingListAccess(RetailscmUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserApp(userAppId);

		
		userContext.getChecker().checkNameOfListAccess(name);
		
		userContext.getChecker().checkInternalNameOfListAccess(internalName);
		
		userContext.getChecker().checkReadPermissionOfListAccess(readPermission);
		
		userContext.getChecker().checkCreatePermissionOfListAccess(createPermission);
		
		userContext.getChecker().checkDeletePermissionOfListAccess(deletePermission);
		
		userContext.getChecker().checkUpdatePermissionOfListAccess(updatePermission);
		
		userContext.getChecker().checkExecutionPermissionOfListAccess(executionPermission);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);

	
	}
	public  UserApp addListAccess(RetailscmUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingListAccess(userContext,userAppId,name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission,tokensExpr);
		
		ListAccess listAccess = createListAccess(userContext,name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission);
		
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addListAccess( listAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			
			userContext.getManagerGroup().getListAccessManager().onNewInstanceCreated(userContext, listAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingListAccessProperties(RetailscmUserContext userContext, String userAppId,String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().checkIdOfListAccess(id);
		
		userContext.getChecker().checkNameOfListAccess( name);
		userContext.getChecker().checkInternalNameOfListAccess( internalName);
		userContext.getChecker().checkReadPermissionOfListAccess( readPermission);
		userContext.getChecker().checkCreatePermissionOfListAccess( createPermission);
		userContext.getChecker().checkDeletePermissionOfListAccess( deletePermission);
		userContext.getChecker().checkUpdatePermissionOfListAccess( updatePermission);
		userContext.getChecker().checkExecutionPermissionOfListAccess( executionPermission);

		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
		
	}
	public  UserApp updateListAccessProperties(RetailscmUserContext userContext, String userAppId, String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingListAccessProperties(userContext,userAppId,id,name,internalName,readPermission,createPermission,deletePermission,updatePermission,executionPermission,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withListAccessListList()
				.searchListAccessListWith(ListAccess.ID_PROPERTY, "is", id).done();
		
		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);
		
		if(userAppToUpdate.getListAccessList().isEmpty()){
			throw new UserAppManagerException("ListAccess is NOT FOUND with id: '"+id+"'");
		}
		
		ListAccess item = userAppToUpdate.getListAccessList().first();
		
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
		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		for(String listAccessId: listAccessIds){
			userContext.getChecker().checkIdOfListAccess(listAccessId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
		
	}
	public  UserApp removeListAccessList(RetailscmUserContext userContext, String userAppId, 
			String listAccessIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingListAccessList(userContext, userAppId,  listAccessIds, tokensExpr);
			
			
			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){ 
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserAppDAO().planToRemoveListAccessList(userApp, listAccessIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
				deleteRelationListInGraph(userContext, userApp.getListAccessList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingListAccess(RetailscmUserContext userContext, String userAppId, 
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserApp( userAppId);
		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().checkVersionOfListAccess(listAccessVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
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
		
		userContext.getChecker().checkIdOfUserApp( userAppId);
		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().checkVersionOfListAccess(listAccessVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
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
			
			userContext.getManagerGroup().getListAccessManager().onNewInstanceCreated(userContext, (ListAccess)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingListAccess(RetailscmUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().checkVersionOfListAccess(listAccessVersion);
		

		if(ListAccess.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfListAccess(parseString(newValueExpr));
		}
		
		if(ListAccess.INTERNAL_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalNameOfListAccess(parseString(newValueExpr));
		}
		
		if(ListAccess.READ_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkReadPermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.CREATE_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkCreatePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.DELETE_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkDeletePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.UPDATE_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkUpdatePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
		if(ListAccess.EXECUTION_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkExecutionPermissionOfListAccess(parseBoolean(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
	}
	
	public  UserApp updateListAccess(RetailscmUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingListAccess(userContext, userAppId, listAccessId, listAccessVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withListAccessList().searchListAccessListWith(ListAccess.ID_PROPERTY, "eq", listAccessId).done();
		
		
		
		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);
		
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeListAccess( listAccess );	
			//make changes to AcceleraterAccount.
			ListAccess listAccessIndex = createIndexedListAccess(listAccessId, listAccessVersion);
		
			ListAccess listAccess = userApp.findTheListAccess(listAccessIndex);
			if(listAccess == null){
				throw new UserAppManagerException(listAccess+" is NOT FOUND" );
			}
			
			listAccess.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingObjectAccess(RetailscmUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserApp(userAppId);

		
		userContext.getChecker().checkNameOfObjectAccess(name);
		
		userContext.getChecker().checkObjectTypeOfObjectAccess(objectType);
		
		userContext.getChecker().checkList1OfObjectAccess(list1);
		
		userContext.getChecker().checkList2OfObjectAccess(list2);
		
		userContext.getChecker().checkList3OfObjectAccess(list3);
		
		userContext.getChecker().checkList4OfObjectAccess(list4);
		
		userContext.getChecker().checkList5OfObjectAccess(list5);
		
		userContext.getChecker().checkList6OfObjectAccess(list6);
		
		userContext.getChecker().checkList7OfObjectAccess(list7);
		
		userContext.getChecker().checkList8OfObjectAccess(list8);
		
		userContext.getChecker().checkList9OfObjectAccess(list9);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);

	
	}
	public  UserApp addObjectAccess(RetailscmUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingObjectAccess(userContext,userAppId,name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9,tokensExpr);
		
		ObjectAccess objectAccess = createObjectAccess(userContext,name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9);
		
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addObjectAccess( objectAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			
			userContext.getManagerGroup().getObjectAccessManager().onNewInstanceCreated(userContext, objectAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingObjectAccessProperties(RetailscmUserContext userContext, String userAppId,String id,String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().checkIdOfObjectAccess(id);
		
		userContext.getChecker().checkNameOfObjectAccess( name);
		userContext.getChecker().checkObjectTypeOfObjectAccess( objectType);
		userContext.getChecker().checkList1OfObjectAccess( list1);
		userContext.getChecker().checkList2OfObjectAccess( list2);
		userContext.getChecker().checkList3OfObjectAccess( list3);
		userContext.getChecker().checkList4OfObjectAccess( list4);
		userContext.getChecker().checkList5OfObjectAccess( list5);
		userContext.getChecker().checkList6OfObjectAccess( list6);
		userContext.getChecker().checkList7OfObjectAccess( list7);
		userContext.getChecker().checkList8OfObjectAccess( list8);
		userContext.getChecker().checkList9OfObjectAccess( list9);

		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
		
	}
	public  UserApp updateObjectAccessProperties(RetailscmUserContext userContext, String userAppId, String id,String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingObjectAccessProperties(userContext,userAppId,id,name,objectType,list1,list2,list3,list4,list5,list6,list7,list8,list9,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withObjectAccessListList()
				.searchObjectAccessListWith(ObjectAccess.ID_PROPERTY, "is", id).done();
		
		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);
		
		if(userAppToUpdate.getObjectAccessList().isEmpty()){
			throw new UserAppManagerException("ObjectAccess is NOT FOUND with id: '"+id+"'");
		}
		
		ObjectAccess item = userAppToUpdate.getObjectAccessList().first();
		
		item.updateName( name );
		item.updateObjectType( objectType );
		item.updateList1( list1 );
		item.updateList2( list2 );
		item.updateList3( list3 );
		item.updateList4( list4 );
		item.updateList5( list5 );
		item.updateList6( list6 );
		item.updateList7( list7 );
		item.updateList8( list8 );
		item.updateList9( list9 );

		
		//checkParamsForAddingObjectAccess(userContext,userAppId,name, code, used,tokensExpr);
		UserApp userApp = saveUserApp(userContext, userAppToUpdate, tokens().withObjectAccessList().done());
		synchronized(userApp){ 
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ObjectAccess createObjectAccess(RetailscmUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9) throws Exception{

		ObjectAccess objectAccess = new ObjectAccess();
		
		
		objectAccess.setName(name);		
		objectAccess.setObjectType(objectType);		
		objectAccess.setList1(list1);		
		objectAccess.setList2(list2);		
		objectAccess.setList3(list3);		
		objectAccess.setList4(list4);		
		objectAccess.setList5(list5);		
		objectAccess.setList6(list6);		
		objectAccess.setList7(list7);		
		objectAccess.setList8(list8);		
		objectAccess.setList9(list9);
	
		
		return objectAccess;
	
		
	}
	
	protected ObjectAccess createIndexedObjectAccess(String id, int version){

		ObjectAccess objectAccess = new ObjectAccess();
		objectAccess.setId(id);
		objectAccess.setVersion(version);
		return objectAccess;			
		
	}
	
	protected void checkParamsForRemovingObjectAccessList(RetailscmUserContext userContext, String userAppId, 
			String objectAccessIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		for(String objectAccessId: objectAccessIds){
			userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
		
	}
	public  UserApp removeObjectAccessList(RetailscmUserContext userContext, String userAppId, 
			String objectAccessIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingObjectAccessList(userContext, userAppId,  objectAccessIds, tokensExpr);
			
			
			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){ 
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserAppDAO().planToRemoveObjectAccessList(userApp, objectAccessIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
				deleteRelationListInGraph(userContext, userApp.getObjectAccessList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingObjectAccess(RetailscmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserApp( userAppId);
		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().checkVersionOfObjectAccess(objectAccessVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
	}
	public  UserApp removeObjectAccess(RetailscmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingObjectAccess(userContext,userAppId, objectAccessId, objectAccessVersion,tokensExpr);
		
		ObjectAccess objectAccess = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeObjectAccess( objectAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			deleteRelationInGraph(userContext, objectAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingObjectAccess(RetailscmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserApp( userAppId);
		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().checkVersionOfObjectAccess(objectAccessVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
	}
	public  UserApp copyObjectAccessFrom(RetailscmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingObjectAccess(userContext,userAppId, objectAccessId, objectAccessVersion,tokensExpr);
		
		ObjectAccess objectAccess = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			userApp.copyObjectAccessFrom( objectAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			
			userContext.getManagerGroup().getObjectAccessManager().onNewInstanceCreated(userContext, (ObjectAccess)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingObjectAccess(RetailscmUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserApp(userAppId);
		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().checkVersionOfObjectAccess(objectAccessVersion);
		

		if(ObjectAccess.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.OBJECT_TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkObjectTypeOfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST1_PROPERTY.equals(property)){
			userContext.getChecker().checkList1OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST2_PROPERTY.equals(property)){
			userContext.getChecker().checkList2OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST3_PROPERTY.equals(property)){
			userContext.getChecker().checkList3OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST4_PROPERTY.equals(property)){
			userContext.getChecker().checkList4OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST5_PROPERTY.equals(property)){
			userContext.getChecker().checkList5OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST6_PROPERTY.equals(property)){
			userContext.getChecker().checkList6OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST7_PROPERTY.equals(property)){
			userContext.getChecker().checkList7OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST8_PROPERTY.equals(property)){
			userContext.getChecker().checkList8OfObjectAccess(parseString(newValueExpr));
		}
		
		if(ObjectAccess.LIST9_PROPERTY.equals(property)){
			userContext.getChecker().checkList9OfObjectAccess(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAppManagerException.class);
	
	}
	
	public  UserApp updateObjectAccess(RetailscmUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingObjectAccess(userContext, userAppId, objectAccessId, objectAccessVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withObjectAccessList().searchObjectAccessListWith(ObjectAccess.ID_PROPERTY, "eq", objectAccessId).done();
		
		
		
		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);
		
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeObjectAccess( objectAccess );	
			//make changes to AcceleraterAccount.
			ObjectAccess objectAccessIndex = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		
			ObjectAccess objectAccess = userApp.findTheObjectAccess(objectAccessIndex);
			if(objectAccess == null){
				throw new UserAppManagerException(objectAccess+" is NOT FOUND" );
			}
			
			objectAccess.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, UserApp newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


