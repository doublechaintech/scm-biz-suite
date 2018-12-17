
package com.doublechaintech.retailscm.leveltwodepartment;

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

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;

import com.doublechaintech.retailscm.levelonedepartment.CandidateLevelOneDepartment;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;






public class LevelTwoDepartmentManagerImpl extends CustomRetailscmCheckerManager implements LevelTwoDepartmentManager {
	
	private static final String SERVICE_TYPE = "LevelTwoDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelTwoDepartmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelTwoDepartmentManagerException(message);

	}
	
	

 	protected LevelTwoDepartment saveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelTwoDepartmentDAO().save(levelTwoDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens);
 	}
 	
 	protected LevelTwoDepartment saveLevelTwoDepartmentDetail(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception{	

 		
 		return saveLevelTwoDepartment(userContext, levelTwoDepartment, allTokens());
 	}
 	
 	public LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoDepartment, tokens);
 	}
 	
 	
 	 public LevelTwoDepartment searchLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoDepartment, tokens);
 	}
 	
 	

 	protected LevelTwoDepartment present(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelTwoDepartment,tokens);
		
		
		LevelTwoDepartment  levelTwoDepartmentToPresent = userContext.getDAOGroup().getLevelTwoDepartmentDAO().present(levelTwoDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = levelTwoDepartmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelTwoDepartmentDAO().alias(entityListToNaming);
		
		return  levelTwoDepartmentToPresent;
		
		
	}
 
 	
 	
 	public LevelTwoDepartment loadLevelTwoDepartmentDetail(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{	
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, allTokens());
 		return present(userContext,levelTwoDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{	
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, viewTokens());
 		return present(userContext,levelTwoDepartment, allTokens());
		
 	}
 	protected LevelTwoDepartment saveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelTwoDepartmentDAO().save(levelTwoDepartment, tokens);
 	}
 	protected LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoDepartmentManagerException.class);

 
 		return userContext.getDAOGroup().getLevelTwoDepartmentDAO().load(levelTwoDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoDepartment, tokens);
		
		addAction(userContext, levelTwoDepartment, tokens,"@create","createLevelTwoDepartment","createLevelTwoDepartment/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"@update","updateLevelTwoDepartment","updateLevelTwoDepartment/"+levelTwoDepartment.getId()+"/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"@copy","cloneLevelTwoDepartment","cloneLevelTwoDepartment/"+levelTwoDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelTwoDepartment.getId()+"/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.addLevelThreeDepartment","addLevelThreeDepartment","addLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.removeLevelThreeDepartment","removeLevelThreeDepartment","removeLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.updateLevelThreeDepartment","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.copyLevelThreeDepartmentFrom","copyLevelThreeDepartmentFrom","copyLevelThreeDepartmentFrom/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelTwoDepartment createLevelTwoDepartment(RetailscmUserContext userContext,String belongsToId, String name, String description, Date founded) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelTwoDepartment(name);
		userContext.getChecker().checkDescriptionOfLevelTwoDepartment(description);
		userContext.getChecker().checkFoundedOfLevelTwoDepartment(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);


		LevelTwoDepartment levelTwoDepartment=createNewLevelTwoDepartment();	

			
		LevelOneDepartment belongsTo = loadLevelOneDepartment(userContext, belongsToId,emptyOptions());
		levelTwoDepartment.setBelongsTo(belongsTo);
		
		
		levelTwoDepartment.setName(name);
		levelTwoDepartment.setDescription(description);
		levelTwoDepartment.setFounded(founded);

		levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, levelTwoDepartment);
		return levelTwoDepartment;

		
	}
	protected LevelTwoDepartment createNewLevelTwoDepartment() 
	{
		
		return new LevelTwoDepartment();		
	}
	
	protected void checkParamsForUpdatingLevelTwoDepartment(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().checkVersionOfLevelTwoDepartment( levelTwoDepartmentVersion);
		
		

		
		if(LevelTwoDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelTwoDepartment(parseString(newValueExpr));
		}
		if(LevelTwoDepartment.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLevelTwoDepartment(parseString(newValueExpr));
		}
		if(LevelTwoDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfLevelTwoDepartment(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
	
		
	}
	
	
	
	public LevelTwoDepartment clone(RetailscmUserContext userContext, String fromLevelTwoDepartmentId) throws Exception{
		
		return userContext.getDAOGroup().getLevelTwoDepartmentDAO().clone(fromLevelTwoDepartmentId, this.allTokens());
	}
	
	public LevelTwoDepartment internalSaveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception 
	{
		return internalSaveLevelTwoDepartment(userContext, levelTwoDepartment, allTokens());

	}
	public LevelTwoDepartment internalSaveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelTwoDepartment){ 
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.
			
			
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, options);
			return levelTwoDepartment;
			
		}

	}
	
	public LevelTwoDepartment updateLevelTwoDepartment(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		if(levelTwoDepartment.getVersion() != levelTwoDepartmentVersion){
			String message = "The target version("+levelTwoDepartment.getVersion()+") is not equals to version("+levelTwoDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoDepartment){ 
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.
			
			levelTwoDepartment.changeProperty(property, newValueExpr);
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
		}

	}
	
	public LevelTwoDepartment updateLevelTwoDepartmentProperty(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		if(levelTwoDepartment.getVersion() != levelTwoDepartmentVersion){
			String message = "The target version("+levelTwoDepartment.getVersion()+") is not equals to version("+levelTwoDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoDepartment){ 
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.
			
			levelTwoDepartment.changeProperty(property, newValueExpr);
			
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelTwoDepartmentTokens tokens(){
		return LevelTwoDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelThreeDepartmentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
 		userContext.getChecker().checkIdOfLevelOneDepartment(anotherBelongsToId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
 		
 	}
 	public LevelTwoDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelTwoDepartmentId,anotherBelongsToId);
 
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());	
		synchronized(levelTwoDepartment){
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneDepartment belongsTo = loadLevelOneDepartment(userContext, anotherBelongsToId, emptyOptions());		
			levelTwoDepartment.updateBelongsTo(belongsTo);		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, emptyOptions());
			
			return present(userContext,levelTwoDepartment, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelOneDepartment requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelOneDepartment result = new CandidateLevelOneDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("belongsTo");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelOneDepartment> candidateList = userContext.getDAOGroup().getLevelOneDepartmentDAO().requestCandidateLevelOneDepartmentForLevelTwoDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelOneDepartment loadLevelOneDepartment(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelOneDepartmentDAO().load(newBelongsToId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelTwoDepartmentDAO().delete(levelTwoDepartmentId, levelTwoDepartmentVersion);
	}
	
	public LevelTwoDepartment forgetByAll(RetailscmUserContext userContext, String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion);		
	}
	protected LevelTwoDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelTwoDepartmentDAO().disconnectFromAll(levelTwoDepartmentId, levelTwoDepartmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelTwoDepartmentDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);

		
		userContext.getChecker().checkNameOfLevelThreeDepartment(name);
		
		userContext.getChecker().checkDescriptionOfLevelThreeDepartment(description);
		
		userContext.getChecker().checkFoundedOfLevelThreeDepartment(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);

	
	}
	public  LevelTwoDepartment addLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelThreeDepartment(userContext,levelTwoDepartmentId,name, description, founded,tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = createLevelThreeDepartment(userContext,name, description, founded);
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.addLevelThreeDepartment( levelThreeDepartment );		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			
			userContext.getManagerGroup().getLevelThreeDepartmentManager().onNewInstanceCreated(userContext, levelThreeDepartment);
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelThreeDepartmentProperties(RetailscmUserContext userContext, String levelTwoDepartmentId,String id,String name,String description,Date founded,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().checkIdOfLevelThreeDepartment(id);
		
		userContext.getChecker().checkNameOfLevelThreeDepartment( name);
		userContext.getChecker().checkDescriptionOfLevelThreeDepartment( description);
		userContext.getChecker().checkFoundedOfLevelThreeDepartment( founded);

		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
		
	}
	public  LevelTwoDepartment updateLevelThreeDepartmentProperties(RetailscmUserContext userContext, String levelTwoDepartmentId, String id,String name,String description,Date founded, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelThreeDepartmentProperties(userContext,levelTwoDepartmentId,id,name,description,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelThreeDepartmentListList()
				.searchLevelThreeDepartmentListWith(LevelThreeDepartment.ID_PROPERTY, "is", id).done();
		
		LevelTwoDepartment levelTwoDepartmentToUpdate = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, options);
		
		if(levelTwoDepartmentToUpdate.getLevelThreeDepartmentList().isEmpty()){
			throw new LevelTwoDepartmentManagerException("LevelThreeDepartment is NOT FOUND with id: '"+id+"'");
		}
		
		LevelThreeDepartment item = levelTwoDepartmentToUpdate.getLevelThreeDepartmentList().first();
		
		item.updateName( name );
		item.updateDescription( description );
		item.updateFounded( founded );

		
		//checkParamsForAddingLevelThreeDepartment(userContext,levelTwoDepartmentId,name, code, used,tokensExpr);
		LevelTwoDepartment levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartmentToUpdate, tokens().withLevelThreeDepartmentList().done());
		synchronized(levelTwoDepartment){ 
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext, String name, String description, Date founded) throws Exception{

		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		
		
		levelThreeDepartment.setName(name);		
		levelThreeDepartment.setDescription(description);		
		levelThreeDepartment.setFounded(founded);
	
		
		return levelThreeDepartment;
	
		
	}
	
	protected LevelThreeDepartment createIndexedLevelThreeDepartment(String id, int version){

		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		levelThreeDepartment.setId(id);
		levelThreeDepartment.setVersion(version);
		return levelThreeDepartment;			
		
	}
	
	protected void checkParamsForRemovingLevelThreeDepartmentList(RetailscmUserContext userContext, String levelTwoDepartmentId, 
			String levelThreeDepartmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		for(String levelThreeDepartmentId: levelThreeDepartmentIds){
			userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
		
	}
	public  LevelTwoDepartment removeLevelThreeDepartmentList(RetailscmUserContext userContext, String levelTwoDepartmentId, 
			String levelThreeDepartmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelThreeDepartmentList(userContext, levelTwoDepartmentId,  levelThreeDepartmentIds, tokensExpr);
			
			
			LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
			synchronized(levelTwoDepartment){ 
				//Will be good when the levelTwoDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelTwoDepartmentDAO().planToRemoveLevelThreeDepartmentList(levelTwoDepartment, levelThreeDepartmentIds, allTokens());
				levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
				deleteRelationListInGraph(userContext, levelTwoDepartment.getLevelThreeDepartmentList());
				return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelTwoDepartment( levelTwoDepartmentId);
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().checkVersionOfLevelThreeDepartment(levelThreeDepartmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
	
	}
	public  LevelTwoDepartment removeLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelThreeDepartment(userContext,levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion,tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.removeLevelThreeDepartment( levelThreeDepartment );		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			deleteRelationInGraph(userContext, levelThreeDepartment);
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelTwoDepartment( levelTwoDepartmentId);
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().checkVersionOfLevelThreeDepartment(levelThreeDepartmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
	
	}
	public  LevelTwoDepartment copyLevelThreeDepartmentFrom(RetailscmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelThreeDepartment(userContext,levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion,tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelTwoDepartment.copyLevelThreeDepartmentFrom( levelThreeDepartment );		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			
			userContext.getManagerGroup().getLevelThreeDepartmentManager().onNewInstanceCreated(userContext, (LevelThreeDepartment)levelTwoDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		userContext.getChecker().checkVersionOfLevelThreeDepartment(levelThreeDepartmentVersion);
		

		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelThreeDepartment(parseString(newValueExpr));
		}
		
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLevelThreeDepartment(parseString(newValueExpr));
		}
		
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfLevelThreeDepartment(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);
	
	}
	
	public  LevelTwoDepartment updateLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelThreeDepartmentList().searchLevelThreeDepartmentListWith(LevelThreeDepartment.ID_PROPERTY, "eq", levelThreeDepartmentId).done();
		
		
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, loadTokens);
		
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoDepartment.removeLevelThreeDepartment( levelThreeDepartment );	
			//make changes to AcceleraterAccount.
			LevelThreeDepartment levelThreeDepartmentIndex = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		
			LevelThreeDepartment levelThreeDepartment = levelTwoDepartment.findTheLevelThreeDepartment(levelThreeDepartmentIndex);
			if(levelThreeDepartment == null){
				throw new LevelTwoDepartmentManagerException(levelThreeDepartment+" is NOT FOUND" );
			}
			
			levelThreeDepartment.changeProperty(property, newValueExpr);
			
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelTwoDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


