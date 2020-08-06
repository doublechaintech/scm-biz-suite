
package com.doublechaintech.retailscm.levelthreecategory;

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
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.leveltwocategory.CandidateLevelTwoCategory;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;






public class LevelThreeCategoryManagerImpl extends CustomRetailscmCheckerManager implements LevelThreeCategoryManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = LevelThreeCategoryTokens.start().withTokenFromListName(listName).done();
		LevelThreeCategory  levelThreeCategory = (LevelThreeCategory) this.loadLevelThreeCategory(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelThreeCategory.collectRefercencesFromLists();
		levelThreeCategoryDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, levelThreeCategory, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelThreeCategoryGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "LevelThreeCategory";
	@Override
	public LevelThreeCategoryDAO daoOf(RetailscmUserContext userContext) {
		return levelThreeCategoryDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeCategory, tokens);
 	}
 	
 	
 	 public LevelThreeCategory searchLevelThreeCategory(RetailscmUserContext userContext, String levelThreeCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeCategory, tokens);
 	}
 	
 	

 	protected LevelThreeCategory present(RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeCategory,tokens);
		
		
		LevelThreeCategory  levelThreeCategoryToPresent = levelThreeCategoryDaoOf(userContext).present(levelThreeCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelThreeCategoryToPresent.collectRefercencesFromLists();
		levelThreeCategoryDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,levelThreeCategory,tokens);
		
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
 		return levelThreeCategoryDaoOf(userContext).save(levelThreeCategory, tokens);
 	}
 	protected LevelThreeCategory loadLevelThreeCategory(RetailscmUserContext userContext, String levelThreeCategoryId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeCategoryManagerException.class);

 
 		return levelThreeCategoryDaoOf(userContext).load(levelThreeCategoryId, tokens);
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
	
 	
 	
 
 	
 	

	public LevelThreeCategory createLevelThreeCategory(RetailscmUserContext userContext, String parentCategoryId,String name) throws Exception
	//public LevelThreeCategory createLevelThreeCategory(RetailscmUserContext userContext,String parentCategoryId, String name) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfLevelThreeCategory(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).checkVersionOfLevelThreeCategory( levelThreeCategoryVersion);
		
		

		
		if(LevelThreeCategory.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelThreeCategory(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);


	}



	public LevelThreeCategory clone(RetailscmUserContext userContext, String fromLevelThreeCategoryId) throws Exception{

		return levelThreeCategoryDaoOf(userContext).clone(fromLevelThreeCategoryId, this.allTokens());
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
			if (levelThreeCategory.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailscmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
 		checkerOf(userContext).checkIdOfLevelTwoCategory(anotherParentCategoryId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

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
		SmartList<LevelTwoCategory> candidateList = levelTwoCategoryDaoOf(userContext).requestCandidateLevelTwoCategoryForLevelThreeCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LevelTwoCategory loadLevelTwoCategory(RetailscmUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{

 		return levelTwoCategoryDaoOf(userContext).load(newParentCategoryId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelThreeCategoryId, levelThreeCategoryVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception{

		levelThreeCategoryDaoOf(userContext).delete(levelThreeCategoryId, levelThreeCategoryVersion);
	}

	public LevelThreeCategory forgetByAll(RetailscmUserContext userContext, String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelThreeCategoryId, levelThreeCategoryVersion);
	}
	protected LevelThreeCategory forgetByAllInternal(RetailscmUserContext userContext,
			String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception{

		return levelThreeCategoryDaoOf(userContext).disconnectFromAll(levelThreeCategoryId, levelThreeCategoryVersion);
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
		return levelThreeCategoryDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);

		
		checkerOf(userContext).checkNameOfProduct(name);
		
		checkerOf(userContext).checkOriginOfProduct(origin);
		
		checkerOf(userContext).checkRemarkOfProduct(remark);
		
		checkerOf(userContext).checkBrandOfProduct(brand);
		
		checkerOf(userContext).checkPictureOfProduct(picture);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);


	}
	public  LevelThreeCategory addProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingProduct(userContext,levelThreeCategoryId,name, origin, remark, brand, picture,tokensExpr);

		Product product = createProduct(userContext,name, origin, remark, brand, picture);

		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, emptyOptions());
		synchronized(levelThreeCategory){
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeCategory.addProduct( product );
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			
			productManagerOf(userContext).onNewInstanceCreated(userContext, product);
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(RetailscmUserContext userContext, String levelThreeCategoryId,String id,String name,String origin,String remark,String brand,String picture,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).checkIdOfProduct(id);

		checkerOf(userContext).checkNameOfProduct( name);
		checkerOf(userContext).checkOriginOfProduct( origin);
		checkerOf(userContext).checkRemarkOfProduct( remark);
		checkerOf(userContext).checkBrandOfProduct( brand);
		checkerOf(userContext).checkPictureOfProduct( picture);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

	}
	public  LevelThreeCategory updateProductProperties(RetailscmUserContext userContext, String levelThreeCategoryId, String id,String name,String origin,String remark,String brand,String picture, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProductProperties(userContext,levelThreeCategoryId,id,name,origin,remark,brand,picture,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, tokens().is(), id).done();

		LevelThreeCategory levelThreeCategoryToUpdate = loadLevelThreeCategory(userContext, levelThreeCategoryId, options);

		if(levelThreeCategoryToUpdate.getProductList().isEmpty()){
			throw new LevelThreeCategoryManagerException("Product is NOT FOUND with id: '"+id+"'");
		}

		Product item = levelThreeCategoryToUpdate.getProductList().first();
		beforeUpdateProductProperties(userContext,item, levelThreeCategoryId,id,name,origin,remark,brand,picture,tokensExpr);
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

	protected  void beforeUpdateProductProperties(RetailscmUserContext userContext, Product item, String levelThreeCategoryId, String id,String name,String origin,String remark,String brand,String picture, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		for(String productIdItem: productIds){
			checkerOf(userContext).checkIdOfProduct(productIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

	}
	public  LevelThreeCategory removeProductList(RetailscmUserContext userContext, String levelThreeCategoryId,
			String productIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingProductList(userContext, levelThreeCategoryId,  productIds, tokensExpr);


			LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
			synchronized(levelThreeCategory){
				//Will be good when the levelThreeCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelThreeCategoryDaoOf(userContext).planToRemoveProductList(levelThreeCategory, productIds, allTokens());
				levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, levelThreeCategory.getProductList());
				return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingProduct(RetailscmUserContext userContext, String levelThreeCategoryId,
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelThreeCategory( levelThreeCategoryId);
		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).checkVersionOfProduct(productVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

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
		
		checkerOf(userContext).checkIdOfLevelThreeCategory( levelThreeCategoryId);
		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).checkVersionOfProduct(productVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

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
			
			productManagerOf(userContext).onNewInstanceCreated(userContext, (Product)levelThreeCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).checkVersionOfProduct(productVersion);


		if(Product.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfProduct(parseString(newValueExpr));
		}
		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			checkerOf(userContext).checkOriginOfProduct(parseString(newValueExpr));
		}
		
		if(Product.REMARK_PROPERTY.equals(property)){
			checkerOf(userContext).checkRemarkOfProduct(parseString(newValueExpr));
		}
		
		if(Product.BRAND_PROPERTY.equals(property)){
			checkerOf(userContext).checkBrandOfProduct(parseString(newValueExpr));
		}
		
		if(Product.PICTURE_PROPERTY.equals(property)){
			checkerOf(userContext).checkPictureOfProduct(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeCategoryManagerException.class);

	}

	public  LevelThreeCategory updateProduct(RetailscmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingProduct(userContext, levelThreeCategoryId, productId, productVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, tokens().equals(), productId).done();



		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, loadTokens);

		synchronized(levelThreeCategory){
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeCategory.removeProduct( product );
			//make changes to AcceleraterAccount.
			Product productIdVersionKey = createIndexedProduct(productId, productVersion);

			Product product = levelThreeCategory.findTheProduct(productIdVersionKey);
			if(product == null){
				throw new LevelThreeCategoryManagerException(productId+" is NOT FOUND" );
			}

			beforeUpdateProduct(userContext, product, levelThreeCategoryId, productId, productVersion, property, newValueExpr,  tokensExpr);
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateProduct(RetailscmUserContext userContext, Product existed, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    levelThreeCategoryDaoOf(ctx).loadAllAsStream().forEach(
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
		//   LevelThreeCategory newLevelThreeCategory = this.createLevelThreeCategory(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelThreeCategory
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LevelThreeCategory.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LevelThreeCategory> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LevelTwoCategory> parentCategoryList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LevelTwoCategory.class);
		userContext.getDAOGroup().enhanceList(parentCategoryList, LevelTwoCategory.class);


    }
	
	public Object listByParentCategory(RetailscmUserContext userContext,String parentCategoryId) throws Exception {
		return listPageByParentCategory(userContext, parentCategoryId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByParentCategory(RetailscmUserContext userContext,String parentCategoryId, int start, int count) throws Exception {
		SmartList<LevelThreeCategory> list = levelThreeCategoryDaoOf(userContext).findLevelThreeCategoryByParentCategory(parentCategoryId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LevelThreeCategory.class);
		page.setContainerObject(LevelTwoCategory.withId(parentCategoryId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("三级分类列表");
		page.setRequestName("listByParentCategory");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByParentCategory/%s/",  getBeanName(), parentCategoryId)));

		page.assemblerContent(userContext, "listByParentCategory");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String levelThreeCategoryId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getLevelThreeCategoryDetailScope().clone();
		LevelThreeCategory merchantObj = (LevelThreeCategory) this.view(userContext, levelThreeCategoryId);
    String merchantObjId = levelThreeCategoryId;
    String linkToUrl =	"levelThreeCategoryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "三级分类"+"详情";
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
				MapUtil.put("id", "2-parentCategory")
				    .put("fieldName", "parentCategory")
				    .put("label", "父类")
				    .put("type", "auto")
				    .put("linkToUrl", "levelTwoCategoryManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("parentCategory", merchantObj.getParentCategory());

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

		//处理Section：productListSection
		Map productListSection = ListofUtils.buildSection(
		    "productListSection",
		    "产品列表",
		    null,
		    "",
		    "__no_group",
		    "productManager/listByParentCategory/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(productListSection);

		result.put("productListSection", ListofUtils.toShortList(merchantObj.getProductList(), "product"));
		vscope.field("productListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Product.class.getName(), null));

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


