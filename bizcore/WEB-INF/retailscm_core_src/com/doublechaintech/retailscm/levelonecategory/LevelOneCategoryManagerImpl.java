
package com.doublechaintech.retailscm.levelonecategory;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.Catalog;

import com.doublechaintech.retailscm.catalog.CandidateCatalog;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;






public class LevelOneCategoryManagerImpl extends CustomRetailscmCheckerManager implements LevelOneCategoryManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = LevelOneCategoryTokens.start().withTokenFromListName(listName).done();
		LevelOneCategory  levelOneCategory = (LevelOneCategory) this.loadLevelOneCategory(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelOneCategory.collectRefercencesFromLists();
		levelOneCategoryDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, levelOneCategory, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelOneCategoryGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "LevelOneCategory";
	@Override
	public LevelOneCategoryDAO daoOf(RetailscmUserContext userContext) {
		return levelOneCategoryDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws LevelOneCategoryManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LevelOneCategoryManagerException(message);

	}



 	protected LevelOneCategory saveLevelOneCategory(RetailscmUserContext userContext, LevelOneCategory levelOneCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelOneCategory(userContext, levelOneCategory, tokens);
 	}
 	
 	protected LevelOneCategory saveLevelOneCategoryDetail(RetailscmUserContext userContext, LevelOneCategory levelOneCategory) throws Exception{	

 		
 		return saveLevelOneCategory(userContext, levelOneCategory, allTokens());
 	}
 	
 	public LevelOneCategory loadLevelOneCategory(RetailscmUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	
 	 public LevelOneCategory searchLevelOneCategory(RetailscmUserContext userContext, String levelOneCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	

 	protected LevelOneCategory present(RetailscmUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneCategory,tokens);
		
		
		LevelOneCategory  levelOneCategoryToPresent = levelOneCategoryDaoOf(userContext).present(levelOneCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelOneCategoryToPresent.collectRefercencesFromLists();
		levelOneCategoryDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,levelOneCategory,tokens);
		
		return  levelOneCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelOneCategory loadLevelOneCategoryDetail(RetailscmUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, allTokens());
 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, viewTokens());
 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	protected LevelOneCategory saveLevelOneCategory(RetailscmUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object>tokens) throws Exception{	
 		return levelOneCategoryDaoOf(userContext).save(levelOneCategory, tokens);
 	}
 	protected LevelOneCategory loadLevelOneCategory(RetailscmUserContext userContext, String levelOneCategoryId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 
 		return levelOneCategoryDaoOf(userContext).load(levelOneCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelOneCategory, tokens);
		
		addAction(userContext, levelOneCategory, tokens,"@create","createLevelOneCategory","createLevelOneCategory/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@update","updateLevelOneCategory","updateLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@copy","cloneLevelOneCategory","cloneLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelOneCategory, tokens,"level_one_category.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.addLevelTwoCategory","addLevelTwoCategory","addLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.removeLevelTwoCategory","removeLevelTwoCategory","removeLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.updateLevelTwoCategory","updateLevelTwoCategory","updateLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public LevelOneCategory createLevelOneCategory(RetailscmUserContext userContext, String catalogId,String name) throws Exception
	//public LevelOneCategory createLevelOneCategory(RetailscmUserContext userContext,String catalogId, String name) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfLevelOneCategory(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);


		LevelOneCategory levelOneCategory=createNewLevelOneCategory();	

			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		levelOneCategory.setCatalog(catalog);
		
		
		levelOneCategory.setName(name);

		levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelOneCategory);
		return levelOneCategory;


	}
	protected LevelOneCategory createNewLevelOneCategory()
	{

		return new LevelOneCategory();
	}

	protected void checkParamsForUpdatingLevelOneCategory(RetailscmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).checkVersionOfLevelOneCategory( levelOneCategoryVersion);
		
		

		
		if(LevelOneCategory.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelOneCategory(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);


	}



	public LevelOneCategory clone(RetailscmUserContext userContext, String fromLevelOneCategoryId) throws Exception{

		return levelOneCategoryDaoOf(userContext).clone(fromLevelOneCategoryId, this.allTokens());
	}

	public LevelOneCategory internalSaveLevelOneCategory(RetailscmUserContext userContext, LevelOneCategory levelOneCategory) throws Exception
	{
		return internalSaveLevelOneCategory(userContext, levelOneCategory, allTokens());

	}
	public LevelOneCategory internalSaveLevelOneCategory(RetailscmUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);


		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			if (levelOneCategory.isChanged()){
			
			}
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, options);
			return levelOneCategory;

		}

	}

	public LevelOneCategory updateLevelOneCategory(RetailscmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);



		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			levelOneCategory.changeProperty(property, newValueExpr);
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}

	public LevelOneCategory updateLevelOneCategoryProperty(RetailscmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);

		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.

			levelOneCategory.changeProperty(property, newValueExpr);
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LevelOneCategoryTokens tokens(){
		return LevelOneCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelOneCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelTwoCategoryListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCatalog(RetailscmUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
 		checkerOf(userContext).checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

 	}
 	public LevelOneCategory transferToAnotherCatalog(RetailscmUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, levelOneCategoryId,anotherCatalogId);
 
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());	
		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			levelOneCategory.updateCatalog(catalog);		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
			
			return present(userContext,levelOneCategory, allTokens());
			
		}

 	}

	


	public CandidateCatalog requestCandidateCatalog(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCatalog result = new CandidateCatalog();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Catalog> candidateList = catalogDaoOf(userContext).requestCandidateCatalogForLevelOneCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Catalog loadCatalog(RetailscmUserContext userContext, String newCatalogId, Map<String,Object> options) throws Exception
 	{

 		return catalogDaoOf(userContext).load(newCatalogId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{

		levelOneCategoryDaoOf(userContext).delete(levelOneCategoryId, levelOneCategoryVersion);
	}

	public LevelOneCategory forgetByAll(RetailscmUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);
	}
	protected LevelOneCategory forgetByAllInternal(RetailscmUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{

		return levelOneCategoryDaoOf(userContext).disconnectFromAll(levelOneCategoryId, levelOneCategoryVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelOneCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return levelOneCategoryDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);

		
		checkerOf(userContext).checkNameOfLevelTwoCategory(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);


	}
	public  LevelOneCategory addLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String name, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,name,tokensExpr);

		LevelTwoCategory levelTwoCategory = createLevelTwoCategory(userContext,name);

		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, emptyOptions());
		synchronized(levelOneCategory){
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.addLevelTwoCategory( levelTwoCategory );
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			
			levelTwoCategoryManagerOf(userContext).onNewInstanceCreated(userContext, levelTwoCategory);
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelTwoCategoryProperties(RetailscmUserContext userContext, String levelOneCategoryId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).checkIdOfLevelTwoCategory(id);

		checkerOf(userContext).checkNameOfLevelTwoCategory( name);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	}
	public  LevelOneCategory updateLevelTwoCategoryProperties(RetailscmUserContext userContext, String levelOneCategoryId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelTwoCategoryProperties(userContext,levelOneCategoryId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelTwoCategoryListList()
				.searchLevelTwoCategoryListWith(LevelTwoCategory.ID_PROPERTY, tokens().is(), id).done();

		LevelOneCategory levelOneCategoryToUpdate = loadLevelOneCategory(userContext, levelOneCategoryId, options);

		if(levelOneCategoryToUpdate.getLevelTwoCategoryList().isEmpty()){
			throw new LevelOneCategoryManagerException("LevelTwoCategory is NOT FOUND with id: '"+id+"'");
		}

		LevelTwoCategory item = levelOneCategoryToUpdate.getLevelTwoCategoryList().first();
		beforeUpdateLevelTwoCategoryProperties(userContext,item, levelOneCategoryId,id,name,tokensExpr);
		item.updateName( name );


		//checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,name, code, used,tokensExpr);
		LevelOneCategory levelOneCategory = saveLevelOneCategory(userContext, levelOneCategoryToUpdate, tokens().withLevelTwoCategoryList().done());
		synchronized(levelOneCategory){
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateLevelTwoCategoryProperties(RetailscmUserContext userContext, LevelTwoCategory item, String levelOneCategoryId, String id,String name, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected LevelTwoCategory createLevelTwoCategory(RetailscmUserContext userContext, String name) throws Exception{

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		
		
		levelTwoCategory.setName(name);
	
		
		return levelTwoCategory;


	}

	protected LevelTwoCategory createIndexedLevelTwoCategory(String id, int version){

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		levelTwoCategory.setId(id);
		levelTwoCategory.setVersion(version);
		return levelTwoCategory;

	}

	protected void checkParamsForRemovingLevelTwoCategoryList(RetailscmUserContext userContext, String levelOneCategoryId,
			String levelTwoCategoryIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		for(String levelTwoCategoryIdItem: levelTwoCategoryIds){
			checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	}
	public  LevelOneCategory removeLevelTwoCategoryList(RetailscmUserContext userContext, String levelOneCategoryId,
			String levelTwoCategoryIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLevelTwoCategoryList(userContext, levelOneCategoryId,  levelTwoCategoryIds, tokensExpr);


			LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
			synchronized(levelOneCategory){
				//Will be good when the levelOneCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelOneCategoryDaoOf(userContext).planToRemoveLevelTwoCategoryList(levelOneCategory, levelTwoCategoryIds, allTokens());
				levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
				deleteRelationListInGraph(userContext, levelOneCategory.getLevelTwoCategoryList());
				return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId,
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelOneCategory( levelOneCategoryId);
		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		checkerOf(userContext).checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	}
	public  LevelOneCategory removeLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId,
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);

		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.removeLevelTwoCategory( levelTwoCategory );
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			deleteRelationInGraph(userContext, levelTwoCategory);
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId,
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelOneCategory( levelOneCategoryId);
		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		checkerOf(userContext).checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	}
	public  LevelOneCategory copyLevelTwoCategoryFrom(RetailscmUserContext userContext, String levelOneCategoryId,
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);

		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			levelOneCategory.copyLevelTwoCategoryFrom( levelTwoCategory );
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			
			levelTwoCategoryManagerOf(userContext).onNewInstanceCreated(userContext, (LevelTwoCategory)levelOneCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		checkerOf(userContext).checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);


		if(LevelTwoCategory.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfLevelTwoCategory(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	}

	public  LevelOneCategory updateLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLevelTwoCategory(userContext, levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLevelTwoCategoryList().searchLevelTwoCategoryListWith(LevelTwoCategory.ID_PROPERTY, tokens().equals(), levelTwoCategoryId).done();



		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, loadTokens);

		synchronized(levelOneCategory){
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelOneCategory.removeLevelTwoCategory( levelTwoCategory );
			//make changes to AcceleraterAccount.
			LevelTwoCategory levelTwoCategoryIdVersionKey = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);

			LevelTwoCategory levelTwoCategory = levelOneCategory.findTheLevelTwoCategory(levelTwoCategoryIdVersionKey);
			if(levelTwoCategory == null){
				throw new LevelOneCategoryManagerException(levelTwoCategoryId+" is NOT FOUND" );
			}

			beforeUpdateLevelTwoCategory(userContext, levelTwoCategory, levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr,  tokensExpr);
			levelTwoCategory.changeProperty(property, newValueExpr);
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory existed, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelOneCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    levelOneCategoryDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
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
		//   LevelOneCategory newLevelOneCategory = this.createLevelOneCategory(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelOneCategory
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LevelOneCategory.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LevelOneCategory> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Catalog> catalogList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Catalog.class);
		userContext.getDAOGroup().enhanceList(catalogList, Catalog.class);


    }
	
	public Object listByCatalog(RetailscmUserContext userContext,String catalogId) throws Exception {
		return listPageByCatalog(userContext, catalogId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCatalog(RetailscmUserContext userContext,String catalogId, int start, int count) throws Exception {
		SmartList<LevelOneCategory> list = levelOneCategoryDaoOf(userContext).findLevelOneCategoryByCatalog(catalogId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LevelOneCategory.class);
		page.setContainerObject(Catalog.withId(catalogId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("一级分类列表");
		page.setRequestName("listByCatalog");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCatalog/%s/",  getBeanName(), catalogId)));

		page.assemblerContent(userContext, "listByCatalog");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String levelOneCategoryId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getLevelOneCategoryDetailScope().clone();
		LevelOneCategory merchantObj = (LevelOneCategory) this.view(userContext, levelOneCategoryId);
    String merchantObjId = levelOneCategoryId;
    String linkToUrl =	"levelOneCategoryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "一级分类"+"详情";
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
				MapUtil.put("id", "2-catalog")
				    .put("fieldName", "catalog")
				    .put("label", "目录")
				    .put("type", "auto")
				    .put("linkToUrl", "catalogManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("catalog", merchantObj.getCatalog());

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

		//处理 sectionList

		//处理Section：levelTwoCategoryListSection
		Map levelTwoCategoryListSection = ListofUtils.buildSection(
		    "levelTwoCategoryListSection",
		    "二级类别列表",
		    null,
		    "",
		    "__no_group",
		    "levelTwoCategoryManager/listByParentCategory/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(levelTwoCategoryListSection);

		result.put("levelTwoCategoryListSection", ListofUtils.toShortList(merchantObj.getLevelTwoCategoryList(), "levelTwoCategory"));
		vscope.field("levelTwoCategoryListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( LevelTwoCategory.class.getName(), null));

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


