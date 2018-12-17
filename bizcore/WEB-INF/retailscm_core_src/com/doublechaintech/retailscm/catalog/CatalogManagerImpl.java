
package com.doublechaintech.retailscm.catalog;

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
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.catalog.Catalog;






public class CatalogManagerImpl extends CustomRetailscmCheckerManager implements CatalogManager {
	
	private static final String SERVICE_TYPE = "Catalog";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CatalogManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CatalogManagerException(message);

	}
	
	

 	protected Catalog saveCatalog(RetailscmUserContext userContext, Catalog catalog, String [] tokensExpr) throws Exception{	
 		//return getCatalogDAO().save(catalog, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCatalog(userContext, catalog, tokens);
 	}
 	
 	protected Catalog saveCatalogDetail(RetailscmUserContext userContext, Catalog catalog) throws Exception{	

 		
 		return saveCatalog(userContext, catalog, allTokens());
 	}
 	
 	public Catalog loadCatalog(RetailscmUserContext userContext, String catalogId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().throwExceptionIfHasErrors( CatalogManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	
 	 public Catalog searchCatalog(RetailscmUserContext userContext, String catalogId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().throwExceptionIfHasErrors( CatalogManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	

 	protected Catalog present(RetailscmUserContext userContext, Catalog catalog, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,catalog,tokens);
		
		
		Catalog  catalogToPresent = userContext.getDAOGroup().getCatalogDAO().present(catalog, tokens);
		
		List<BaseEntity> entityListToNaming = catalogToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCatalogDAO().alias(entityListToNaming);
		
		return  catalogToPresent;
		
		
	}
 
 	
 	
 	public Catalog loadCatalogDetail(RetailscmUserContext userContext, String catalogId) throws Exception{	
 		Catalog catalog = loadCatalog( userContext, catalogId, allTokens());
 		return present(userContext,catalog, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String catalogId) throws Exception{	
 		Catalog catalog = loadCatalog( userContext, catalogId, viewTokens());
 		return present(userContext,catalog, allTokens());
		
 	}
 	protected Catalog saveCatalog(RetailscmUserContext userContext, Catalog catalog, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCatalogDAO().save(catalog, tokens);
 	}
 	protected Catalog loadCatalog(RetailscmUserContext userContext, String catalogId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().throwExceptionIfHasErrors( CatalogManagerException.class);

 
 		return userContext.getDAOGroup().getCatalogDAO().load(catalogId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Catalog catalog, Map<String, Object> tokens){
		super.addActions(userContext, catalog, tokens);
		
		addAction(userContext, catalog, tokens,"@create","createCatalog","createCatalog/","main","primary");
		addAction(userContext, catalog, tokens,"@update","updateCatalog","updateCatalog/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"@copy","cloneCatalog","cloneCatalog/"+catalog.getId()+"/","main","primary");
		
		addAction(userContext, catalog, tokens,"catalog.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"catalog.addLevelOneCategory","addLevelOneCategory","addLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeLevelOneCategory","removeLevelOneCategory","removeLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateLevelOneCategory","updateLevelOneCategory","updateLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyLevelOneCategoryFrom","copyLevelOneCategoryFrom","copyLevelOneCategoryFrom/"+catalog.getId()+"/","levelOneCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Catalog catalog, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Catalog createCatalog(RetailscmUserContext userContext,String name, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfCatalog(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);


		Catalog catalog=createNewCatalog();	

		catalog.setName(name);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		catalog.setOwner(owner);
		
		

		catalog = saveCatalog(userContext, catalog, emptyOptions());
		
		onNewInstanceCreated(userContext, catalog);
		return catalog;

		
	}
	protected Catalog createNewCatalog() 
	{
		
		return new Catalog();		
	}
	
	protected void checkParamsForUpdatingCatalog(RetailscmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog( catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCatalog(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
		
	}
	
	
	
	public Catalog clone(RetailscmUserContext userContext, String fromCatalogId) throws Exception{
		
		return userContext.getDAOGroup().getCatalogDAO().clone(fromCatalogId, this.allTokens());
	}
	
	public Catalog internalSaveCatalog(RetailscmUserContext userContext, Catalog catalog) throws Exception 
	{
		return internalSaveCatalog(userContext, catalog, allTokens());

	}
	public Catalog internalSaveCatalog(RetailscmUserContext userContext, Catalog catalog, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(catalog){ 
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			
			catalog = saveCatalog(userContext, catalog, options);
			return catalog;
			
		}

	}
	
	public Catalog updateCatalog(RetailscmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(catalog){ 
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			catalog.changeProperty(property, newValueExpr);
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}
	
	public Catalog updateCatalogProperty(RetailscmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(catalog){ 
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			catalog.changeProperty(property, newValueExpr);
			
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CatalogTokens tokens(){
		return CatalogTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CatalogTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelOneCategoryListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CatalogTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String catalogId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCatalog(catalogId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
 		
 	}
 	public Catalog transferToAnotherOwner(RetailscmUserContext userContext, String catalogId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, catalogId,anotherOwnerId);
 
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());	
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());		
			catalog.updateOwner(owner);		
			catalog = saveCatalog(userContext, catalog, emptyOptions());
			
			return present(userContext,catalog, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForCatalog(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		//deleteInternal(userContext, catalogId, catalogVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{
			
		userContext.getDAOGroup().getCatalogDAO().delete(catalogId, catalogVersion);
	}
	
	public Catalog forgetByAll(RetailscmUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		return forgetByAllInternal(userContext, catalogId, catalogVersion);		
	}
	protected Catalog forgetByAllInternal(RetailscmUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{
			
		return userContext.getDAOGroup().getCatalogDAO().disconnectFromAll(catalogId, catalogVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CatalogManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCatalogDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelOneCategory(RetailscmUserContext userContext, String catalogId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCatalog(catalogId);

		
		userContext.getChecker().checkNameOfLevelOneCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);

	
	}
	public  Catalog addLevelOneCategory(RetailscmUserContext userContext, String catalogId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelOneCategory(userContext,catalogId,name,tokensExpr);
		
		LevelOneCategory levelOneCategory = createLevelOneCategory(userContext,name);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addLevelOneCategory( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			
			userContext.getManagerGroup().getLevelOneCategoryManager().onNewInstanceCreated(userContext, levelOneCategory);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelOneCategoryProperties(RetailscmUserContext userContext, String catalogId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(id);
		
		userContext.getChecker().checkNameOfLevelOneCategory( name);

		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog updateLevelOneCategoryProperties(RetailscmUserContext userContext, String catalogId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelOneCategoryProperties(userContext,catalogId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelOneCategoryListList()
				.searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, "is", id).done();
		
		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);
		
		if(catalogToUpdate.getLevelOneCategoryList().isEmpty()){
			throw new CatalogManagerException("LevelOneCategory is NOT FOUND with id: '"+id+"'");
		}
		
		LevelOneCategory item = catalogToUpdate.getLevelOneCategoryList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingLevelOneCategory(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withLevelOneCategoryList().done());
		synchronized(catalog){ 
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelOneCategory createLevelOneCategory(RetailscmUserContext userContext, String name) throws Exception{

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		
		
		levelOneCategory.setName(name);
	
		
		return levelOneCategory;
	
		
	}
	
	protected LevelOneCategory createIndexedLevelOneCategory(String id, int version){

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		levelOneCategory.setId(id);
		levelOneCategory.setVersion(version);
		return levelOneCategory;			
		
	}
	
	protected void checkParamsForRemovingLevelOneCategoryList(RetailscmUserContext userContext, String catalogId, 
			String levelOneCategoryIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		for(String levelOneCategoryId: levelOneCategoryIds){
			userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
		
	}
	public  Catalog removeLevelOneCategoryList(RetailscmUserContext userContext, String catalogId, 
			String levelOneCategoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelOneCategoryList(userContext, catalogId,  levelOneCategoryIds, tokensExpr);
			
			
			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){ 
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCatalogDAO().planToRemoveLevelOneCategoryList(catalog, levelOneCategoryIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
				deleteRelationListInGraph(userContext, catalog.getLevelOneCategoryList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelOneCategory(RetailscmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog removeLevelOneCategory(RetailscmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);
		
		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeLevelOneCategory( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			deleteRelationInGraph(userContext, levelOneCategory);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelOneCategory(RetailscmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCatalog( catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	public  Catalog copyLevelOneCategoryFrom(RetailscmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);
		
		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			catalog.copyLevelOneCategoryFrom( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			
			userContext.getManagerGroup().getLevelOneCategoryManager().onNewInstanceCreated(userContext, (LevelOneCategory)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelOneCategory(RetailscmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		

		if(LevelOneCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelOneCategory(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CatalogManagerException.class);
	
	}
	
	public  Catalog updateLevelOneCategory(RetailscmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelOneCategory(userContext, catalogId, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelOneCategoryList().searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, "eq", levelOneCategoryId).done();
		
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeLevelOneCategory( levelOneCategory );	
			//make changes to AcceleraterAccount.
			LevelOneCategory levelOneCategoryIndex = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		
			LevelOneCategory levelOneCategory = catalog.findTheLevelOneCategory(levelOneCategoryIndex);
			if(levelOneCategory == null){
				throw new CatalogManagerException(levelOneCategory+" is NOT FOUND" );
			}
			
			levelOneCategory.changeProperty(property, newValueExpr);
			
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Catalog newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


