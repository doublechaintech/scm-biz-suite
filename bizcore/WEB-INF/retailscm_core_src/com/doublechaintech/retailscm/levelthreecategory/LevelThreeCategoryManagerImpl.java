
package com.doublechaintech.retailscm.levelthreecategory;

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

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.leveltwocategory.CandidateLevelTwoCategory;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;






public class LevelThreeCategoryManagerImpl extends CustomRetailscmCheckerManager implements LevelThreeCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelThreeCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelThreeCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelThreeCategoryManagerException(message);

	}
	
	

 	protected LevelThreeCategory saveLevelThreeCategory(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelThreeCategoryDAO().save(levelThreeCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelThreeCategory(userContext, levelThreeCategory, tokens);
 	}
 	
 	protected LevelThreeCategory saveLevelThreeCategoryDetail(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory) throws Exception{	

 		
 		return saveLevelThreeCategory(userContext, levelThreeCategory, allTokens());
 	}
 	
 	public LevelThreeCategory loadLevelThreeCategory(RetailscmUserContext userContext, String levelThreeCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelThreeCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeCategory, tokens);
 	}
 	
 	
 	 public LevelThreeCategory searchLevelThreeCategory(RetailscmUserContext userContext, String levelThreeCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelThreeCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeCategory, tokens);
 	}
 	
 	

 	protected LevelThreeCategory present(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeCategory,tokens);
		
		
		LevelThreeCategory  levelThreeCategoryToPresent = userContext.getDAOGroup().getLevelThreeCategoryDAO().present(levelThreeCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelThreeCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelThreeCategoryDAO().alias(entityListToNaming);
		
		return  levelThreeCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelThreeCategory loadLevelThreeCategoryDetail(RetailscmUserContext userContext, String levelThreeCategoryId) throws Exception{	
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, allTokens());
 		return present(userContext,levelThreeCategory, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelThreeCategoryId) throws Exception{	
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, viewTokens());
 		return present(userContext,levelThreeCategory, allTokens());
		
 	}
 	protected LevelThreeCategory saveLevelThreeCategory(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelThreeCategoryDAO().save(levelThreeCategory, tokens);
 	}
 	protected LevelThreeCategory loadLevelThreeCategory(RetailscmUserContext userContext, String levelThreeCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelThreeCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelThreeCategoryDAO().load(levelThreeCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelThreeCategory, tokens);
		
		addAction(userContext, levelThreeCategory, tokens,"@create","createLevelThreeCategory","createLevelThreeCategory/","main","primary");
		addAction(userContext, levelThreeCategory, tokens,"@update","updateLevelThreeCategory","updateLevelThreeCategory/"+levelThreeCategory.getId()+"/","main","primary");
		addAction(userContext, levelThreeCategory, tokens,"@copy","cloneLevelThreeCategory","cloneLevelThreeCategory/"+levelThreeCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelThreeCategory.getId()+"/","main","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.addProduct","addProduct","addProduct/"+levelThreeCategory.getId()+"/","productList","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.removeProduct","removeProduct","removeProduct/"+levelThreeCategory.getId()+"/","productList","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.updateProduct","updateProduct","updateProduct/"+levelThreeCategory.getId()+"/","productList","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.copyProductFrom","copyProductFrom","copyProductFrom/"+levelThreeCategory.getId()+"/","productList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelThreeCategory createLevelThreeCategory(RetailscmUserContext userContext,String parentCategoryId, String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelThreeCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);


		LevelThreeCategory levelThreeCategory=createNewLevelThreeCategory();	

			
		LevelTwoCategory parentCategory = loadLevelTwoCategory(userContext, parentCategoryId,emptyOptions());
		levelThreeCategory.setParentCategory(parentCategory);
		
		
		levelThreeCategory.setName(name);

		levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelThreeCategory);
		return levelThreeCategory;

		
	}
	protected LevelThreeCategory createNewLevelThreeCategory() 
	{
		
		return new LevelThreeCategory();		
	}
	
	protected void checkParamsForUpdatingLevelThreeCategory(RetailscmUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().checkVersionOfLevelThreeCategory( levelThreeCategoryVersion);
		
		

		
		if(LevelThreeCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelThreeCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelThreeCategory clone(RetailscmUserContext userContext, String fromLevelThreeCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelThreeCategoryDAO().clone(fromLevelThreeCategoryId, this.allTokens());
	}
	
	public LevelThreeCategory internalSaveLevelThreeCategory(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory) throws Exception 
	{
		return internalSaveLevelThreeCategory(userContext, levelThreeCategory, allTokens());

	}
	public LevelThreeCategory internalSaveLevelThreeCategory(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelThreeCategory(userContext, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelThreeCategory){ 
			//will be good when the levelThreeCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeCategory.
			
			
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, options);
			return levelThreeCategory;
			
		}

	}
	
	public LevelThreeCategory updateLevelThreeCategory(RetailscmUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelThreeCategory(userContext, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		if(levelThreeCategory.getVersion() != levelThreeCategoryVersion){
			String message = "The target version("+levelThreeCategory.getVersion()+") is not equals to version("+levelThreeCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeCategory){ 
			//will be good when the levelThreeCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeCategory.
			
			levelThreeCategory.changeProperty(property, newValueExpr);
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
			//return saveLevelThreeCategory(userContext, levelThreeCategory, tokens().done());
		}

	}
	
	public LevelThreeCategory updateLevelThreeCategoryProperty(RetailscmUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelThreeCategory(userContext, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		if(levelThreeCategory.getVersion() != levelThreeCategoryVersion){
			String message = "The target version("+levelThreeCategory.getVersion()+") is not equals to version("+levelThreeCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeCategory){ 
			//will be good when the levelThreeCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeCategory.
			
			levelThreeCategory.changeProperty(property, newValueExpr);
			
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
			//return saveLevelThreeCategory(userContext, levelThreeCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelThreeCategoryTokens tokens(){
		return LevelThreeCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelThreeCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailscmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
 		userContext.getChecker().checkIdOfLevelTwoCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
 		
 	}
 	public LevelThreeCategory transferToAnotherParentCategory(RetailscmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelThreeCategoryId,anotherParentCategoryId);
 
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());	
		synchronized(levelThreeCategory){
			//will be good when the levelThreeCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoCategory parentCategory = loadLevelTwoCategory(userContext, anotherParentCategoryId, emptyOptions());		
			levelThreeCategory.updateParentCategory(parentCategory);		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, emptyOptions());
			
			return present(userContext,levelThreeCategory, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelTwoCategory requestCandidateParentCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelTwoCategory result = new CandidateLevelTwoCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelTwoCategory> candidateList = userContext.getDAOGroup().getLevelTwoCategoryDAO().requestCandidateLevelTwoCategoryForLevelThreeCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelTwoCategory loadLevelTwoCategory(RetailscmUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelThreeCategoryId, levelThreeCategoryVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelThreeCategoryDAO().delete(levelThreeCategoryId, levelThreeCategoryVersion);
	}
	
	public LevelThreeCategory forgetByAll(RetailscmUserContext userContext, String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelThreeCategoryId, levelThreeCategoryVersion);		
	}
	protected LevelThreeCategory forgetByAllInternal(RetailscmUserContext userContext,
			String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelThreeCategoryDAO().disconnectFromAll(levelThreeCategoryId, levelThreeCategoryVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelThreeCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelThreeCategoryDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkBrandOfProduct(brand);
		
		userContext.getChecker().checkPictureOfProduct(picture);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

	
	}
	public  LevelThreeCategory addProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,levelThreeCategoryId,name, origin, remark, brand, picture,tokensExpr);
		
		Product product = createProduct(userContext,name, origin, remark, brand, picture);
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeCategory.addProduct( product );		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(RetailscmUserContext userContext, String levelThreeCategoryId,String id,String name,String origin,String remark,String brand,String picture,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);
		userContext.getChecker().checkBrandOfProduct( brand);
		userContext.getChecker().checkPictureOfProduct( picture);

		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
		
	}
	public  LevelThreeCategory updateProductProperties(RetailscmUserContext userContext, String levelThreeCategoryId, String id,String name,String origin,String remark,String brand,String picture, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,levelThreeCategoryId,id,name,origin,remark,brand,picture,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		LevelThreeCategory levelThreeCategoryToUpdate = loadLevelThreeCategory(userContext, levelThreeCategoryId, options);
		
		if(levelThreeCategoryToUpdate.getProductList().isEmpty()){
			throw new LevelThreeCategoryManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = levelThreeCategoryToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateOrigin( origin );
		item.updateRemark( remark );
		item.updateBrand( brand );
		item.updatePicture( picture );

		
		//checkParamsForAddingProduct(userContext,levelThreeCategoryId,name, code, used,tokensExpr);
		LevelThreeCategory levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategoryToUpdate, tokens().withProductList().done());
		synchronized(levelThreeCategory){ 
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(RetailscmUserContext userContext, String name, String origin, String remark, String brand, String picture) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		product.setOrigin(origin);		
		product.setRemark(remark);		
		product.setBrand(brand);		
		product.setPicture(picture);		
		product.setLastUpdateTime(userContext.now());
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(RetailscmUserContext userContext, String levelThreeCategoryId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
		
	}
	public  LevelThreeCategory removeProductList(RetailscmUserContext userContext, String levelThreeCategoryId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, levelThreeCategoryId,  productIds, tokensExpr);
			
			
			LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
			synchronized(levelThreeCategory){ 
				//Will be good when the levelThreeCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelThreeCategoryDAO().planToRemoveProductList(levelThreeCategory, productIds, allTokens());
				levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, levelThreeCategory.getProductList());
				return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(RetailscmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelThreeCategory( levelThreeCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
	
	}
	public  LevelThreeCategory removeProduct(RetailscmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,levelThreeCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeCategory.removeProduct( product );		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(RetailscmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelThreeCategory( levelThreeCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
	
	}
	public  LevelThreeCategory copyProductFrom(RetailscmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,levelThreeCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			levelThreeCategory.copyProductFrom( product );		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)levelThreeCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelThreeCategory(levelThreeCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
		}
		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProduct(parseString(newValueExpr));
		}
		
		if(Product.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProduct(parseString(newValueExpr));
		}
		
		if(Product.BRAND_PROPERTY.equals(property)){
			userContext.getChecker().checkBrandOfProduct(parseString(newValueExpr));
		}
		
		if(Product.PICTURE_PROPERTY.equals(property)){
			userContext.getChecker().checkPictureOfProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);
	
	}
	
	public  LevelThreeCategory updateProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, levelThreeCategoryId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, loadTokens);
		
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeCategory.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = levelThreeCategory.findTheProduct(productIndex);
			if(product == null){
				throw new LevelThreeCategoryManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


