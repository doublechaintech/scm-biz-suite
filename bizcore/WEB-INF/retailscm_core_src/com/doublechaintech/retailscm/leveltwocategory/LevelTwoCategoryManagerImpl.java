
package com.doublechaintech.retailscm.leveltwocategory;

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

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.levelonecategory.CandidateLevelOneCategory;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;






public class LevelTwoCategoryManagerImpl extends CustomRetailscmCheckerManager implements LevelTwoCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelTwoCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelTwoCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelTwoCategoryManagerException(message);

	}
	
	

 	protected LevelTwoCategory saveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelTwoCategory(userContext, levelTwoCategory, tokens);
 	}
 	
 	protected LevelTwoCategory saveLevelTwoCategoryDetail(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception{	

 		
 		return saveLevelTwoCategory(userContext, levelTwoCategory, allTokens());
 	}
 	
 	public LevelTwoCategory loadLevelTwoCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}
 	
 	
 	 public LevelTwoCategory searchLevelTwoCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}
 	
 	

 	protected LevelTwoCategory present(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelTwoCategory,tokens);
		
		
		LevelTwoCategory  levelTwoCategoryToPresent = userContext.getDAOGroup().getLevelTwoCategoryDAO().present(levelTwoCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelTwoCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelTwoCategoryDAO().alias(entityListToNaming);
		
		return  levelTwoCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelTwoCategory loadLevelTwoCategoryDetail(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{	
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, allTokens());
 		return present(userContext,levelTwoCategory, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{	
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, viewTokens());
 		return present(userContext,levelTwoCategory, allTokens());
		
 	}
 	protected LevelTwoCategory saveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);
 	}
 	protected LevelTwoCategory loadLevelTwoCategory(RetailscmUserContext userContext, String levelTwoCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().load(levelTwoCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoCategory, tokens);
		
		addAction(userContext, levelTwoCategory, tokens,"@create","createLevelTwoCategory","createLevelTwoCategory/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@update","updateLevelTwoCategory","updateLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@copy","cloneLevelTwoCategory","cloneLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.addLevelThreeCategory","addLevelThreeCategory","addLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.removeLevelThreeCategory","removeLevelThreeCategory","removeLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.updateLevelThreeCategory","updateLevelThreeCategory","updateLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.copyLevelThreeCategoryFrom","copyLevelThreeCategoryFrom","copyLevelThreeCategoryFrom/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelTwoCategory createLevelTwoCategory(RetailscmUserContext userContext,String parentCategoryId, String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelTwoCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);


		LevelTwoCategory levelTwoCategory=createNewLevelTwoCategory();	

			
		LevelOneCategory parentCategory = loadLevelOneCategory(userContext, parentCategoryId,emptyOptions());
		levelTwoCategory.setParentCategory(parentCategory);
		
		
		levelTwoCategory.setName(name);

		levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelTwoCategory);
		return levelTwoCategory;

		
	}
	protected LevelTwoCategory createNewLevelTwoCategory() 
	{
		
		return new LevelTwoCategory();		
	}
	
	protected void checkParamsForUpdatingLevelTwoCategory(RetailscmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory( levelTwoCategoryVersion);
		
		

		
		if(LevelTwoCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelTwoCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelTwoCategory clone(RetailscmUserContext userContext, String fromLevelTwoCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelTwoCategoryDAO().clone(fromLevelTwoCategoryId, this.allTokens());
	}
	
	public LevelTwoCategory internalSaveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception 
	{
		return internalSaveLevelTwoCategory(userContext, levelTwoCategory, allTokens());

	}
	public LevelTwoCategory internalSaveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelTwoCategory){ 
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, options);
			return levelTwoCategory;
			
		}

	}
	
	public LevelTwoCategory updateLevelTwoCategory(RetailscmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoCategory){ 
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}
	
	public LevelTwoCategory updateLevelTwoCategoryProperty(RetailscmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoCategory){ 
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelTwoCategoryTokens tokens(){
		return LevelTwoCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelThreeCategoryListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
 		userContext.getChecker().checkIdOfLevelOneCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
 		
 	}
 	public LevelTwoCategory transferToAnotherParentCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelTwoCategoryId,anotherParentCategoryId);
 
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());	
		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneCategory parentCategory = loadLevelOneCategory(userContext, anotherParentCategoryId, emptyOptions());		
			levelTwoCategory.updateParentCategory(parentCategory);		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
			
			return present(userContext,levelTwoCategory, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelOneCategory requestCandidateParentCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelOneCategory result = new CandidateLevelOneCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("catalog");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelOneCategory> candidateList = userContext.getDAOGroup().getLevelOneCategoryDAO().requestCandidateLevelOneCategoryForLevelTwoCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelOneCategory loadLevelOneCategory(RetailscmUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelOneCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelTwoCategoryDAO().delete(levelTwoCategoryId, levelTwoCategoryVersion);
	}
	
	public LevelTwoCategory forgetByAll(RetailscmUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);		
	}
	protected LevelTwoCategory forgetByAllInternal(RetailscmUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelTwoCategoryDAO().disconnectFromAll(levelTwoCategoryId, levelTwoCategoryVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelTwoCategoryDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);

		
		userContext.getChecker().checkNameOfLevelThreeCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);

	
	}
	public  LevelTwoCategory addLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelThreeCategory(userContext,levelTwoCategoryId,name,tokensExpr);
		
		LevelThreeCategory levelThreeCategory = createLevelThreeCategory(userContext,name);
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.addLevelThreeCategory( levelThreeCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			
			userContext.getManagerGroup().getLevelThreeCategoryManager().onNewInstanceCreated(userContext, levelThreeCategory);
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelThreeCategoryProperties(RetailscmUserContext userContext, String levelTwoCategoryId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelThreeCategory(id);
		
		userContext.getChecker().checkNameOfLevelThreeCategory( name);

		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
		
	}
	public  LevelTwoCategory updateLevelThreeCategoryProperties(RetailscmUserContext userContext, String levelTwoCategoryId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelThreeCategoryProperties(userContext,levelTwoCategoryId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelThreeCategoryListList()
				.searchLevelThreeCategoryListWith(LevelThreeCategory.ID_PROPERTY, "is", id).done();
		
		LevelTwoCategory levelTwoCategoryToUpdate = loadLevelTwoCategory(userContext, levelTwoCategoryId, options);
		
		if(levelTwoCategoryToUpdate.getLevelThreeCategoryList().isEmpty()){
			throw new LevelTwoCategoryManagerException("LevelThreeCategory is NOT FOUND with id: '"+id+"'");
		}
		
		LevelThreeCategory item = levelTwoCategoryToUpdate.getLevelThreeCategoryList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingLevelThreeCategory(userContext,levelTwoCategoryId,name, code, used,tokensExpr);
		LevelTwoCategory levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategoryToUpdate, tokens().withLevelThreeCategoryList().done());
		synchronized(levelTwoCategory){ 
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelThreeCategory createLevelThreeCategory(RetailscmUserContext userContext, String name) throws Exception{

		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		
		
		levelThreeCategory.setName(name);
	
		
		return levelThreeCategory;
	
		
	}
	
	protected LevelThreeCategory createIndexedLevelThreeCategory(String id, int version){

		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		levelThreeCategory.setId(id);
		levelThreeCategory.setVersion(version);
		return levelThreeCategory;			
		
	}
	
	protected void checkParamsForRemovingLevelThreeCategoryList(RetailscmUserContext userContext, String levelTwoCategoryId, 
			String levelThreeCategoryIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		for(String levelThreeCategoryId: levelThreeCategoryIds){
			userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
		
	}
	public  LevelTwoCategory removeLevelThreeCategoryList(RetailscmUserContext userContext, String levelTwoCategoryId, 
			String levelThreeCategoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelThreeCategoryList(userContext, levelTwoCategoryId,  levelThreeCategoryIds, tokensExpr);
			
			
			LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
			synchronized(levelTwoCategory){ 
				//Will be good when the levelTwoCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelTwoCategoryDAO().planToRemoveLevelThreeCategoryList(levelTwoCategory, levelThreeCategoryIds, allTokens());
				levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
				deleteRelationListInGraph(userContext, levelTwoCategory.getLevelThreeCategoryList());
				return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelTwoCategory( levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().checkVersionOfLevelThreeCategory(levelThreeCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
	}
	public  LevelTwoCategory removeLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelThreeCategory(userContext,levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion,tokensExpr);
		
		LevelThreeCategory levelThreeCategory = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.removeLevelThreeCategory( levelThreeCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			deleteRelationInGraph(userContext, levelThreeCategory);
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelTwoCategory( levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().checkVersionOfLevelThreeCategory(levelThreeCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
	}
	public  LevelTwoCategory copyLevelThreeCategoryFrom(RetailscmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelThreeCategory(userContext,levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion,tokensExpr);
		
		LevelThreeCategory levelThreeCategory = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelTwoCategory.copyLevelThreeCategoryFrom( levelThreeCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			
			userContext.getManagerGroup().getLevelThreeCategoryManager().onNewInstanceCreated(userContext, (LevelThreeCategory)levelTwoCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().checkVersionOfLevelThreeCategory(levelThreeCategoryVersion);
		

		if(LevelThreeCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelThreeCategory(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
	}
	
	public  LevelTwoCategory updateLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelThreeCategory(userContext, levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelThreeCategoryList().searchLevelThreeCategoryListWith(LevelThreeCategory.ID_PROPERTY, "eq", levelThreeCategoryId).done();
		
		
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, loadTokens);
		
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoCategory.removeLevelThreeCategory( levelThreeCategory );	
			//make changes to AcceleraterAccount.
			LevelThreeCategory levelThreeCategoryIndex = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		
			LevelThreeCategory levelThreeCategory = levelTwoCategory.findTheLevelThreeCategory(levelThreeCategoryIndex);
			if(levelThreeCategory == null){
				throw new LevelTwoCategoryManagerException(levelThreeCategory+" is NOT FOUND" );
			}
			
			levelThreeCategory.changeProperty(property, newValueExpr);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelTwoCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


