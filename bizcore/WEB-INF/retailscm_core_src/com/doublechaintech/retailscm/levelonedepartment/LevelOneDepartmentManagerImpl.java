
package com.doublechaintech.retailscm.levelonedepartment;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;






public class LevelOneDepartmentManagerImpl extends CustomRetailscmCheckerManager implements LevelOneDepartmentManager {
	
	private static final String SERVICE_TYPE = "LevelOneDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelOneDepartmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelOneDepartmentManagerException(message);

	}
	
	

 	protected LevelOneDepartment saveLevelOneDepartment(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelOneDepartmentDAO().save(levelOneDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelOneDepartment(userContext, levelOneDepartment, tokens);
 	}
 	
 	protected LevelOneDepartment saveLevelOneDepartmentDetail(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment) throws Exception{	

 		
 		return saveLevelOneDepartment(userContext, levelOneDepartment, allTokens());
 	}
 	
 	public LevelOneDepartment loadLevelOneDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneDepartment, tokens);
 	}
 	
 	
 	 public LevelOneDepartment searchLevelOneDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneDepartment, tokens);
 	}
 	
 	

 	protected LevelOneDepartment present(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneDepartment,tokens);
		
		
		LevelOneDepartment  levelOneDepartmentToPresent = userContext.getDAOGroup().getLevelOneDepartmentDAO().present(levelOneDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = levelOneDepartmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelOneDepartmentDAO().alias(entityListToNaming);
		
		return  levelOneDepartmentToPresent;
		
		
	}
 
 	
 	
 	public LevelOneDepartment loadLevelOneDepartmentDetail(RetailscmUserContext userContext, String levelOneDepartmentId) throws Exception{	
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, allTokens());
 		return present(userContext,levelOneDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelOneDepartmentId) throws Exception{	
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, viewTokens());
 		return present(userContext,levelOneDepartment, allTokens());
		
 	}
 	protected LevelOneDepartment saveLevelOneDepartment(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelOneDepartmentDAO().save(levelOneDepartment, tokens);
 	}
 	protected LevelOneDepartment loadLevelOneDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneDepartmentManagerException.class);

 
 		return userContext.getDAOGroup().getLevelOneDepartmentDAO().load(levelOneDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelOneDepartment, tokens);
		
		addAction(userContext, levelOneDepartment, tokens,"@create","createLevelOneDepartment","createLevelOneDepartment/","main","primary");
		addAction(userContext, levelOneDepartment, tokens,"@update","updateLevelOneDepartment","updateLevelOneDepartment/"+levelOneDepartment.getId()+"/","main","primary");
		addAction(userContext, levelOneDepartment, tokens,"@copy","cloneLevelOneDepartment","cloneLevelOneDepartment/"+levelOneDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelOneDepartment.getId()+"/","main","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.addLevelTwoDepartment","addLevelTwoDepartment","addLevelTwoDepartment/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.removeLevelTwoDepartment","removeLevelTwoDepartment","removeLevelTwoDepartment/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.updateLevelTwoDepartment","updateLevelTwoDepartment","updateLevelTwoDepartment/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.copyLevelTwoDepartmentFrom","copyLevelTwoDepartmentFrom","copyLevelTwoDepartmentFrom/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelOneDepartment createLevelOneDepartment(RetailscmUserContext userContext,String belongsToId, String name, String description, String manager, Date founded) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelOneDepartment(name);
		userContext.getChecker().checkDescriptionOfLevelOneDepartment(description);
		userContext.getChecker().checkManagerOfLevelOneDepartment(manager);
		userContext.getChecker().checkFoundedOfLevelOneDepartment(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);


		LevelOneDepartment levelOneDepartment=createNewLevelOneDepartment();	

			
		RetailStoreCountryCenter belongsTo = loadRetailStoreCountryCenter(userContext, belongsToId,emptyOptions());
		levelOneDepartment.setBelongsTo(belongsTo);
		
		
		levelOneDepartment.setName(name);
		levelOneDepartment.setDescription(description);
		levelOneDepartment.setManager(manager);
		levelOneDepartment.setFounded(founded);

		levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, levelOneDepartment);
		return levelOneDepartment;

		
	}
	protected LevelOneDepartment createNewLevelOneDepartment() 
	{
		
		return new LevelOneDepartment();		
	}
	
	protected void checkParamsForUpdatingLevelOneDepartment(RetailscmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		userContext.getChecker().checkVersionOfLevelOneDepartment( levelOneDepartmentVersion);
		
		

		
		if(LevelOneDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelOneDepartment(parseString(newValueExpr));
		}
		if(LevelOneDepartment.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLevelOneDepartment(parseString(newValueExpr));
		}
		if(LevelOneDepartment.MANAGER_PROPERTY.equals(property)){
			userContext.getChecker().checkManagerOfLevelOneDepartment(parseString(newValueExpr));
		}
		if(LevelOneDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfLevelOneDepartment(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
	
		
	}
	
	
	
	public LevelOneDepartment clone(RetailscmUserContext userContext, String fromLevelOneDepartmentId) throws Exception{
		
		return userContext.getDAOGroup().getLevelOneDepartmentDAO().clone(fromLevelOneDepartmentId, this.allTokens());
	}
	
	public LevelOneDepartment internalSaveLevelOneDepartment(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment) throws Exception 
	{
		return internalSaveLevelOneDepartment(userContext, levelOneDepartment, allTokens());

	}
	public LevelOneDepartment internalSaveLevelOneDepartment(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelOneDepartment(userContext, levelOneDepartmentId, levelOneDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelOneDepartment){ 
			//will be good when the levelOneDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneDepartment.
			
			
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, options);
			return levelOneDepartment;
			
		}

	}
	
	public LevelOneDepartment updateLevelOneDepartment(RetailscmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneDepartment(userContext, levelOneDepartmentId, levelOneDepartmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		if(levelOneDepartment.getVersion() != levelOneDepartmentVersion){
			String message = "The target version("+levelOneDepartment.getVersion()+") is not equals to version("+levelOneDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneDepartment){ 
			//will be good when the levelOneDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneDepartment.
			
			levelOneDepartment.changeProperty(property, newValueExpr);
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelOneDepartment(userContext, levelOneDepartment, tokens().done());
		}

	}
	
	public LevelOneDepartment updateLevelOneDepartmentProperty(RetailscmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneDepartment(userContext, levelOneDepartmentId, levelOneDepartmentVersion, property, newValueExpr, tokensExpr);
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		if(levelOneDepartment.getVersion() != levelOneDepartmentVersion){
			String message = "The target version("+levelOneDepartment.getVersion()+") is not equals to version("+levelOneDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneDepartment){ 
			//will be good when the levelOneDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneDepartment.
			
			levelOneDepartment.changeProperty(property, newValueExpr);
			
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelOneDepartment(userContext, levelOneDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelOneDepartmentTokens tokens(){
		return LevelOneDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelOneDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelTwoDepartmentListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherBelongsToId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
 		
 	}
 	public LevelOneDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelOneDepartmentId,anotherBelongsToId);
 
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());	
		synchronized(levelOneDepartment){
			//will be good when the levelOneDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter belongsTo = loadRetailStoreCountryCenter(userContext, anotherBelongsToId, emptyOptions());		
			levelOneDepartment.updateBelongsTo(belongsTo);		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, emptyOptions());
			
			return present(userContext,levelOneDepartment, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForLevelOneDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newBelongsToId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelOneDepartmentId, levelOneDepartmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelOneDepartmentDAO().delete(levelOneDepartmentId, levelOneDepartmentVersion);
	}
	
	public LevelOneDepartment forgetByAll(RetailscmUserContext userContext, String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelOneDepartmentId, levelOneDepartmentVersion);		
	}
	protected LevelOneDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelOneDepartmentDAO().disconnectFromAll(levelOneDepartmentId, levelOneDepartmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelOneDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelOneDepartmentDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);

		
		userContext.getChecker().checkNameOfLevelTwoDepartment(name);
		
		userContext.getChecker().checkDescriptionOfLevelTwoDepartment(description);
		
		userContext.getChecker().checkFoundedOfLevelTwoDepartment(founded);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

	
	}
	public  LevelOneDepartment addLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelTwoDepartment(userContext,levelOneDepartmentId,name, description, founded,tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = createLevelTwoDepartment(userContext,name, description, founded);
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneDepartment.addLevelTwoDepartment( levelTwoDepartment );		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			
			userContext.getManagerGroup().getLevelTwoDepartmentManager().onNewInstanceCreated(userContext, levelTwoDepartment);
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelTwoDepartmentProperties(RetailscmUserContext userContext, String levelOneDepartmentId,String id,String name,String description,Date founded,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		userContext.getChecker().checkIdOfLevelTwoDepartment(id);
		
		userContext.getChecker().checkNameOfLevelTwoDepartment( name);
		userContext.getChecker().checkDescriptionOfLevelTwoDepartment( description);
		userContext.getChecker().checkFoundedOfLevelTwoDepartment( founded);

		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
		
	}
	public  LevelOneDepartment updateLevelTwoDepartmentProperties(RetailscmUserContext userContext, String levelOneDepartmentId, String id,String name,String description,Date founded, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelTwoDepartmentProperties(userContext,levelOneDepartmentId,id,name,description,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelTwoDepartmentListList()
				.searchLevelTwoDepartmentListWith(LevelTwoDepartment.ID_PROPERTY, "is", id).done();
		
		LevelOneDepartment levelOneDepartmentToUpdate = loadLevelOneDepartment(userContext, levelOneDepartmentId, options);
		
		if(levelOneDepartmentToUpdate.getLevelTwoDepartmentList().isEmpty()){
			throw new LevelOneDepartmentManagerException("LevelTwoDepartment is NOT FOUND with id: '"+id+"'");
		}
		
		LevelTwoDepartment item = levelOneDepartmentToUpdate.getLevelTwoDepartmentList().first();
		
		item.updateName( name );
		item.updateDescription( description );
		item.updateFounded( founded );

		
		//checkParamsForAddingLevelTwoDepartment(userContext,levelOneDepartmentId,name, code, used,tokensExpr);
		LevelOneDepartment levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartmentToUpdate, tokens().withLevelTwoDepartmentList().done());
		synchronized(levelOneDepartment){ 
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelTwoDepartment createLevelTwoDepartment(RetailscmUserContext userContext, String name, String description, Date founded) throws Exception{

		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
		
		
		levelTwoDepartment.setName(name);		
		levelTwoDepartment.setDescription(description);		
		levelTwoDepartment.setFounded(founded);
	
		
		return levelTwoDepartment;
	
		
	}
	
	protected LevelTwoDepartment createIndexedLevelTwoDepartment(String id, int version){

		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
		levelTwoDepartment.setId(id);
		levelTwoDepartment.setVersion(version);
		return levelTwoDepartment;			
		
	}
	
	protected void checkParamsForRemovingLevelTwoDepartmentList(RetailscmUserContext userContext, String levelOneDepartmentId, 
			String levelTwoDepartmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		for(String levelTwoDepartmentId: levelTwoDepartmentIds){
			userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
		
	}
	public  LevelOneDepartment removeLevelTwoDepartmentList(RetailscmUserContext userContext, String levelOneDepartmentId, 
			String levelTwoDepartmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelTwoDepartmentList(userContext, levelOneDepartmentId,  levelTwoDepartmentIds, tokensExpr);
			
			
			LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
			synchronized(levelOneDepartment){ 
				//Will be good when the levelOneDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelOneDepartmentDAO().planToRemoveLevelTwoDepartmentList(levelOneDepartment, levelTwoDepartmentIds, allTokens());
				levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
				deleteRelationListInGraph(userContext, levelOneDepartment.getLevelTwoDepartmentList());
				return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelOneDepartment( levelOneDepartmentId);
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().checkVersionOfLevelTwoDepartment(levelTwoDepartmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
	
	}
	public  LevelOneDepartment removeLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelTwoDepartment(userContext,levelOneDepartmentId, levelTwoDepartmentId, levelTwoDepartmentVersion,tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = createIndexedLevelTwoDepartment(levelTwoDepartmentId, levelTwoDepartmentVersion);
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneDepartment.removeLevelTwoDepartment( levelTwoDepartment );		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			deleteRelationInGraph(userContext, levelTwoDepartment);
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelOneDepartment( levelOneDepartmentId);
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().checkVersionOfLevelTwoDepartment(levelTwoDepartmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
	
	}
	public  LevelOneDepartment copyLevelTwoDepartmentFrom(RetailscmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelTwoDepartment(userContext,levelOneDepartmentId, levelTwoDepartmentId, levelTwoDepartmentVersion,tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = createIndexedLevelTwoDepartment(levelTwoDepartmentId, levelTwoDepartmentVersion);
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelOneDepartment.copyLevelTwoDepartmentFrom( levelTwoDepartment );		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			
			userContext.getManagerGroup().getLevelTwoDepartmentManager().onNewInstanceCreated(userContext, (LevelTwoDepartment)levelOneDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelOneDepartment(levelOneDepartmentId);
		userContext.getChecker().checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		userContext.getChecker().checkVersionOfLevelTwoDepartment(levelTwoDepartmentVersion);
		

		if(LevelTwoDepartment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelTwoDepartment(parseString(newValueExpr));
		}
		
		if(LevelTwoDepartment.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLevelTwoDepartment(parseString(newValueExpr));
		}
		
		if(LevelTwoDepartment.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfLevelTwoDepartment(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);
	
	}
	
	public  LevelOneDepartment updateLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelOneDepartmentId, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelTwoDepartmentList().searchLevelTwoDepartmentListWith(LevelTwoDepartment.ID_PROPERTY, "eq", levelTwoDepartmentId).done();
		
		
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, loadTokens);
		
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelOneDepartment.removeLevelTwoDepartment( levelTwoDepartment );	
			//make changes to AcceleraterAccount.
			LevelTwoDepartment levelTwoDepartmentIndex = createIndexedLevelTwoDepartment(levelTwoDepartmentId, levelTwoDepartmentVersion);
		
			LevelTwoDepartment levelTwoDepartment = levelOneDepartment.findTheLevelTwoDepartment(levelTwoDepartmentIndex);
			if(levelTwoDepartment == null){
				throw new LevelOneDepartmentManagerException(levelTwoDepartment+" is NOT FOUND" );
			}
			
			levelTwoDepartment.changeProperty(property, newValueExpr);
			
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelOneDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


