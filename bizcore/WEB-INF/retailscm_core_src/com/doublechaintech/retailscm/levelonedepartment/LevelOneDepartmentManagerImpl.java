
package com.doublechaintech.retailscm.levelonedepartment;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;






public class LevelOneDepartmentManagerImpl extends CustomRetailscmCheckerManager implements LevelOneDepartmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = LevelOneDepartmentTokens.start().withTokenFromListName(listName).done();
		LevelOneDepartment  levelOneDepartment = (LevelOneDepartment) this.loadLevelOneDepartment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelOneDepartment.collectRefercencesFromLists();
		levelOneDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, levelOneDepartment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelOneDepartmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "LevelOneDepartment";
	@Override
	public LevelOneDepartmentDAO daoOf(RetailscmUserContext userContext) {
		return levelOneDepartmentDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelOneDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneDepartment, tokens);
 	}
 	
 	
 	 public LevelOneDepartment searchLevelOneDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelOneDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneDepartment, tokens);
 	}
 	
 	

 	protected LevelOneDepartment present(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneDepartment,tokens);
		
		
		LevelOneDepartment  levelOneDepartmentToPresent = levelOneDepartmentDaoOf(userContext).present(levelOneDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = levelOneDepartmentToPresent.collectRefercencesFromLists();
		levelOneDepartmentDaoOf(userContext).alias(entityListToNaming);
		
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
 		return levelOneDepartmentDaoOf(userContext).save(levelOneDepartment, tokens);
 	}
 	protected LevelOneDepartment loadLevelOneDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelOneDepartmentManagerException.class);

 
 		return levelOneDepartmentDaoOf(userContext).load(levelOneDepartmentId, tokens);
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
	
 	
 	
 
 	
 	

	public LevelOneDepartment createLevelOneDepartment(RetailscmUserContext userContext, String belongsToId,String name,String description,String manager,Date founded) throws Exception
	//public LevelOneDepartment createLevelOneDepartment(RetailscmUserContext userContext,String belongsToId, String name, String description, String manager, Date founded) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfLevelOneDepartment(name);
		checkerOf(userContext).checkDescriptionOfLevelOneDepartment(description);
		checkerOf(userContext).checkManagerOfLevelOneDepartment(manager);
		checkerOf(userContext).checkFoundedOfLevelOneDepartment(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).checkVersionOfLevelOneDepartment( levelOneDepartmentVersion);
		
		

		
		if(LevelOneDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelOneDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelOneDepartment.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLevelOneDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelOneDepartment.MANAGER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkManagerOfLevelOneDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelOneDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfLevelOneDepartment(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);


	}



	public LevelOneDepartment clone(RetailscmUserContext userContext, String fromLevelOneDepartmentId) throws Exception{

		return levelOneDepartmentDaoOf(userContext).clone(fromLevelOneDepartmentId, this.allTokens());
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
			if (levelOneDepartment.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForLevelOneDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelOneDepartmentId, levelOneDepartmentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception{

		levelOneDepartmentDaoOf(userContext).delete(levelOneDepartmentId, levelOneDepartmentVersion);
	}

	public LevelOneDepartment forgetByAll(RetailscmUserContext userContext, String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelOneDepartmentId, levelOneDepartmentVersion);
	}
	protected LevelOneDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception{

		return levelOneDepartmentDaoOf(userContext).disconnectFromAll(levelOneDepartmentId, levelOneDepartmentVersion);
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
		return levelOneDepartmentDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);

		
		checkerOf(userContext).checkNameOfLevelTwoDepartment(name);
		
		checkerOf(userContext).checkDescriptionOfLevelTwoDepartment(description);
		
		checkerOf(userContext).checkFoundedOfLevelTwoDepartment(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);


	}
	public  LevelOneDepartment addLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLevelTwoDepartment(userContext,levelOneDepartmentId,name, description, founded,tokensExpr);

		LevelTwoDepartment levelTwoDepartment = createLevelTwoDepartment(userContext,name, description, founded);

		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, emptyOptions());
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

		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).checkIdOfLevelTwoDepartment(id);

		checkerOf(userContext).checkNameOfLevelTwoDepartment( name);
		checkerOf(userContext).checkDescriptionOfLevelTwoDepartment( description);
		checkerOf(userContext).checkFoundedOfLevelTwoDepartment( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

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

		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		for(String levelTwoDepartmentIdItem: levelTwoDepartmentIds){
			checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

	}
	public  LevelOneDepartment removeLevelTwoDepartmentList(RetailscmUserContext userContext, String levelOneDepartmentId,
			String levelTwoDepartmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLevelTwoDepartmentList(userContext, levelOneDepartmentId,  levelTwoDepartmentIds, tokensExpr);


			LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
			synchronized(levelOneDepartment){
				//Will be good when the levelOneDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelOneDepartmentDaoOf(userContext).planToRemoveLevelTwoDepartmentList(levelOneDepartment, levelTwoDepartmentIds, allTokens());
				levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
				deleteRelationListInGraph(userContext, levelOneDepartment.getLevelTwoDepartmentList());
				return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId,
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelOneDepartment( levelOneDepartmentId);
		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		checkerOf(userContext).checkVersionOfLevelTwoDepartment(levelTwoDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

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
		
		checkerOf(userContext).checkIdOfLevelOneDepartment( levelOneDepartmentId);
		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		checkerOf(userContext).checkVersionOfLevelTwoDepartment(levelTwoDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		checkerOf(userContext).checkVersionOfLevelTwoDepartment(levelTwoDepartmentVersion);
		

		if(LevelTwoDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelTwoDepartment(parseString(newValueExpr));
		
		}
		
		if(LevelTwoDepartment.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLevelTwoDepartment(parseString(newValueExpr));
		
		}
		
		if(LevelTwoDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfLevelTwoDepartment(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneDepartmentManagerException.class);

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
		//   LevelOneDepartment newLevelOneDepartment = this.createLevelOneDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelOneDepartment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LevelOneDepartment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LevelOneDepartment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> belongsToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(belongsToList, RetailStoreCountryCenter.class);


    }
	
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<LevelOneDepartment> list = levelOneDepartmentDaoOf(userContext).findLevelOneDepartmentByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LevelOneDepartment.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("一级部门列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String levelOneDepartmentId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getLevelOneDepartmentDetailScope().clone();
		LevelOneDepartment merchantObj = (LevelOneDepartment) this.view(userContext, levelOneDepartmentId);
    String merchantObjId = levelOneDepartmentId;
    String linkToUrl =	"levelOneDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "一级部门"+"详情";
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
				MapUtil.put("id", "2-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "3-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "5-manager")
				    .put("fieldName", "manager")
				    .put("label", "经理")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("manager", merchantObj.getManager());

		propList.add(
				MapUtil.put("id", "6-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		//处理 sectionList

		//处理Section：levelTwoDepartmentListSection
		Map levelTwoDepartmentListSection = ListofUtils.buildSection(
		    "levelTwoDepartmentListSection",
		    "二级部门名单",
		    null,
		    "",
		    "__no_group",
		    "levelTwoDepartmentManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(levelTwoDepartmentListSection);

		result.put("levelTwoDepartmentListSection", ListofUtils.toShortList(merchantObj.getLevelTwoDepartmentList(), "levelTwoDepartment"));
		vscope.field("levelTwoDepartmentListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( LevelTwoDepartment.class.getName(), null));

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


