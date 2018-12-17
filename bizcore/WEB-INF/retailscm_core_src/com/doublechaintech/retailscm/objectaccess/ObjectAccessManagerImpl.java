
package com.doublechaintech.retailscm.objectaccess;

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

import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.userapp.CandidateUserApp;







public class ObjectAccessManagerImpl extends CustomRetailscmCheckerManager implements ObjectAccessManager {
	
	private static final String SERVICE_TYPE = "ObjectAccess";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ObjectAccessManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ObjectAccessManagerException(message);

	}
	
	

 	protected ObjectAccess saveObjectAccess(RetailscmUserContext userContext, ObjectAccess objectAccess, String [] tokensExpr) throws Exception{	
 		//return getObjectAccessDAO().save(objectAccess, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveObjectAccess(userContext, objectAccess, tokens);
 	}
 	
 	protected ObjectAccess saveObjectAccessDetail(RetailscmUserContext userContext, ObjectAccess objectAccess) throws Exception{	

 		
 		return saveObjectAccess(userContext, objectAccess, allTokens());
 	}
 	
 	public ObjectAccess loadObjectAccess(RetailscmUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	
 	 public ObjectAccess searchObjectAccess(RetailscmUserContext userContext, String objectAccessId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	

 	protected ObjectAccess present(RetailscmUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,objectAccess,tokens);
		
		
		ObjectAccess  objectAccessToPresent = userContext.getDAOGroup().getObjectAccessDAO().present(objectAccess, tokens);
		
		List<BaseEntity> entityListToNaming = objectAccessToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getObjectAccessDAO().alias(entityListToNaming);
		
		return  objectAccessToPresent;
		
		
	}
 
 	
 	
 	public ObjectAccess loadObjectAccessDetail(RetailscmUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, allTokens());
 		return present(userContext,objectAccess, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, viewTokens());
 		return present(userContext,objectAccess, allTokens());
		
 	}
 	protected ObjectAccess saveObjectAccess(RetailscmUserContext userContext, ObjectAccess objectAccess, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getObjectAccessDAO().save(objectAccess, tokens);
 	}
 	protected ObjectAccess loadObjectAccess(RetailscmUserContext userContext, String objectAccessId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 
 		return userContext.getDAOGroup().getObjectAccessDAO().load(objectAccessId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
		super.addActions(userContext, objectAccess, tokens);
		
		addAction(userContext, objectAccess, tokens,"@create","createObjectAccess","createObjectAccess/","main","primary");
		addAction(userContext, objectAccess, tokens,"@update","updateObjectAccess","updateObjectAccess/"+objectAccess.getId()+"/","main","primary");
		addAction(userContext, objectAccess, tokens,"@copy","cloneObjectAccess","cloneObjectAccess/"+objectAccess.getId()+"/","main","primary");
		
		addAction(userContext, objectAccess, tokens,"object_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+objectAccess.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ObjectAccess createObjectAccess(RetailscmUserContext userContext,String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception
	{
		
		

		

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
	
		userContext.getChecker().throwExceptionIfHasErrors(ObjectAccessManagerException.class);


		ObjectAccess objectAccess=createNewObjectAccess();	

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
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		objectAccess.setApp(app);
		
		

		objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
		
		onNewInstanceCreated(userContext, objectAccess);
		return objectAccess;

		
	}
	protected ObjectAccess createNewObjectAccess() 
	{
		
		return new ObjectAccess();		
	}
	
	protected void checkParamsForUpdatingObjectAccess(RetailscmUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
		userContext.getChecker().checkVersionOfObjectAccess( objectAccessVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ObjectAccessManagerException.class);
	
		
	}
	
	
	
	public ObjectAccess clone(RetailscmUserContext userContext, String fromObjectAccessId) throws Exception{
		
		return userContext.getDAOGroup().getObjectAccessDAO().clone(fromObjectAccessId, this.allTokens());
	}
	
	public ObjectAccess internalSaveObjectAccess(RetailscmUserContext userContext, ObjectAccess objectAccess) throws Exception 
	{
		return internalSaveObjectAccess(userContext, objectAccess, allTokens());

	}
	public ObjectAccess internalSaveObjectAccess(RetailscmUserContext userContext, ObjectAccess objectAccess, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(objectAccess){ 
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			
			objectAccess = saveObjectAccess(userContext, objectAccess, options);
			return objectAccess;
			
		}

	}
	
	public ObjectAccess updateObjectAccess(RetailscmUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		
		
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(objectAccess){ 
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			objectAccess.changeProperty(property, newValueExpr);
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}
	
	public ObjectAccess updateObjectAccessProperty(RetailscmUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(objectAccess){ 
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			objectAccess.changeProperty(property, newValueExpr);
			
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ObjectAccessTokens tokens(){
		return ObjectAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ObjectAccessTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ObjectAccessTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(RetailscmUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfObjectAccess(objectAccessId);
 		userContext.getChecker().checkIdOfUserApp(anotherAppId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ObjectAccessManagerException.class);
 		
 	}
 	public ObjectAccess transferToAnotherApp(RetailscmUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, objectAccessId,anotherAppId);
 
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());	
		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			objectAccess.updateApp(app);		
			objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
			
			return present(userContext,objectAccess, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserApp requestCandidateApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userContext.getDAOGroup().getUserAppDAO().requestCandidateUserAppForObjectAccess(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserApp loadUserApp(RetailscmUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserAppDAO().load(newAppId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		//deleteInternal(userContext, objectAccessId, objectAccessVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{
			
		userContext.getDAOGroup().getObjectAccessDAO().delete(objectAccessId, objectAccessVersion);
	}
	
	public ObjectAccess forgetByAll(RetailscmUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		return forgetByAllInternal(userContext, objectAccessId, objectAccessVersion);		
	}
	protected ObjectAccess forgetByAllInternal(RetailscmUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{
			
		return userContext.getDAOGroup().getObjectAccessDAO().disconnectFromAll(objectAccessId, objectAccessVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ObjectAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getObjectAccessDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ObjectAccess newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


