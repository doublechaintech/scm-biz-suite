
package com.doublechaintech.retailscm.product;

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
import com.doublechaintech.retailscm.sku.Sku;

import com.doublechaintech.retailscm.levelthreecategory.CandidateLevelThreeCategory;

import com.doublechaintech.retailscm.product.Product;






public class ProductManagerImpl extends CustomRetailscmCheckerManager implements ProductManager {
	
	private static final String SERVICE_TYPE = "Product";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProductManagerException(message);

	}
	
	

 	protected Product saveProduct(RetailscmUserContext userContext, Product product, String [] tokensExpr) throws Exception{	
 		//return getProductDAO().save(product, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProduct(userContext, product, tokens);
 	}
 	
 	protected Product saveProductDetail(RetailscmUserContext userContext, Product product) throws Exception{	

 		
 		return saveProduct(userContext, product, allTokens());
 	}
 	
 	public Product loadProduct(RetailscmUserContext userContext, String productId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	
 	 public Product searchProduct(RetailscmUserContext userContext, String productId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	

 	protected Product present(RetailscmUserContext userContext, Product product, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,product,tokens);
		
		
		Product  productToPresent = userContext.getDAOGroup().getProductDAO().present(product, tokens);
		
		List<BaseEntity> entityListToNaming = productToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProductDAO().alias(entityListToNaming);
		
		return  productToPresent;
		
		
	}
 
 	
 	
 	public Product loadProductDetail(RetailscmUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, allTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, viewTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	protected Product saveProduct(RetailscmUserContext userContext, Product product, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProductDAO().save(product, tokens);
 	}
 	protected Product loadProduct(RetailscmUserContext userContext, String productId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 
 		return userContext.getDAOGroup().getProductDAO().load(productId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Product product, Map<String, Object> tokens){
		super.addActions(userContext, product, tokens);
		
		addAction(userContext, product, tokens,"@create","createProduct","createProduct/","main","primary");
		addAction(userContext, product, tokens,"@update","updateProduct","updateProduct/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"@copy","cloneProduct","cloneProduct/"+product.getId()+"/","main","primary");
		
		addAction(userContext, product, tokens,"product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.addSku","addSku","addSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.removeSku","removeSku","removeSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.updateSku","updateSku","updateSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.copySkuFrom","copySkuFrom","copySkuFrom/"+product.getId()+"/","skuList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Product product, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Product createProduct(RetailscmUserContext userContext,String name, String parentCategoryId, String origin, String remark, String brand, String picture) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProduct(name);
		userContext.getChecker().checkOriginOfProduct(origin);
		userContext.getChecker().checkRemarkOfProduct(remark);
		userContext.getChecker().checkBrandOfProduct(brand);
		userContext.getChecker().checkPictureOfProduct(picture);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);


		Product product=createNewProduct();	

		product.setName(name);
			
		LevelThreeCategory parentCategory = loadLevelThreeCategory(userContext, parentCategoryId,emptyOptions());
		product.setParentCategory(parentCategory);
		
		
		product.setOrigin(origin);
		product.setRemark(remark);
		product.setBrand(brand);
		product.setPicture(picture);
		product.setLastUpdateTime(userContext.now());

		product = saveProduct(userContext, product, emptyOptions());
		
		onNewInstanceCreated(userContext, product);
		return product;

		
	}
	protected Product createNewProduct() 
	{
		
		return new Product();		
	}
	
	protected void checkParamsForUpdatingProduct(RetailscmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct( productVersion);
		

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
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
		
	}
	
	
	
	public Product clone(RetailscmUserContext userContext, String fromProductId) throws Exception{
		
		return userContext.getDAOGroup().getProductDAO().clone(fromProductId, this.allTokens());
	}
	
	public Product internalSaveProduct(RetailscmUserContext userContext, Product product) throws Exception 
	{
		return internalSaveProduct(userContext, product, allTokens());

	}
	public Product internalSaveProduct(RetailscmUserContext userContext, Product product, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			
			product = saveProduct(userContext, product, options);
			return product;
			
		}

	}
	
	public Product updateProduct(RetailscmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			product.updateLastUpdateTime(userContext.now());
			product.changeProperty(property, newValueExpr);
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	
	public Product updateProductProperty(RetailscmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductTokens tokens(){
		return ProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSkuListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailscmUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfLevelThreeCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherParentCategory(RetailscmUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, productId,anotherParentCategoryId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelThreeCategory parentCategory = loadLevelThreeCategory(userContext, anotherParentCategoryId, emptyOptions());		
			product.updateParentCategory(parentCategory);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelThreeCategory requestCandidateParentCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelThreeCategory result = new CandidateLevelThreeCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelThreeCategory> candidateList = userContext.getDAOGroup().getLevelThreeCategoryDAO().requestCandidateLevelThreeCategoryForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelThreeCategory loadLevelThreeCategory(RetailscmUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelThreeCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String productId, int productVersion) throws Exception {
		//deleteInternal(userContext, productId, productVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		userContext.getDAOGroup().getProductDAO().delete(productId, productVersion);
	}
	
	public Product forgetByAll(RetailscmUserContext userContext, String productId, int productVersion) throws Exception {
		return forgetByAllInternal(userContext, productId, productVersion);		
	}
	protected Product forgetByAllInternal(RetailscmUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		return userContext.getDAOGroup().getProductDAO().disconnectFromAll(productId, productVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProductDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingSku(RetailscmUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkNameOfSku(name);
		
		userContext.getChecker().checkSizeOfSku(size);
		
		userContext.getChecker().checkBarcodeOfSku(barcode);
		
		userContext.getChecker().checkPackageTypeOfSku(packageType);
		
		userContext.getChecker().checkNetContentOfSku(netContent);
		
		userContext.getChecker().checkPriceOfSku(price);
		
		userContext.getChecker().checkPictureOfSku(picture);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addSku(RetailscmUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSku(userContext,productId,name, size, barcode, packageType, netContent, price, picture,tokensExpr);
		
		Sku sku = createSku(userContext,name, size, barcode, packageType, netContent, price, picture);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			userContext.getManagerGroup().getSkuManager().onNewInstanceCreated(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSkuProperties(RetailscmUserContext userContext, String productId,String id,String name,String size,String barcode,String packageType,String netContent,BigDecimal price,String picture,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfSku(id);
		
		userContext.getChecker().checkNameOfSku( name);
		userContext.getChecker().checkSizeOfSku( size);
		userContext.getChecker().checkBarcodeOfSku( barcode);
		userContext.getChecker().checkPackageTypeOfSku( packageType);
		userContext.getChecker().checkNetContentOfSku( netContent);
		userContext.getChecker().checkPriceOfSku( price);
		userContext.getChecker().checkPictureOfSku( picture);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateSkuProperties(RetailscmUserContext userContext, String productId, String id,String name,String size,String barcode,String packageType,String netContent,BigDecimal price,String picture, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSkuProperties(userContext,productId,id,name,size,barcode,packageType,netContent,price,picture,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSkuListList()
				.searchSkuListWith(Sku.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getSkuList().isEmpty()){
			throw new ProductManagerException("Sku is NOT FOUND with id: '"+id+"'");
		}
		
		Sku item = productToUpdate.getSkuList().first();
		
		item.updateName( name );
		item.updateSize( size );
		item.updateBarcode( barcode );
		item.updatePackageType( packageType );
		item.updateNetContent( netContent );
		item.updatePrice( price );
		item.updatePicture( picture );

		
		//checkParamsForAddingSku(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withSkuList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Sku createSku(RetailscmUserContext userContext, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture) throws Exception{

		Sku sku = new Sku();
		
		
		sku.setName(name);		
		sku.setSize(size);		
		sku.setBarcode(barcode);		
		sku.setPackageType(packageType);		
		sku.setNetContent(netContent);		
		sku.setPrice(price);		
		sku.setPicture(picture);
	
		
		return sku;
	
		
	}
	
	protected Sku createIndexedSku(String id, int version){

		Sku sku = new Sku();
		sku.setId(id);
		sku.setVersion(version);
		return sku;			
		
	}
	
	protected void checkParamsForRemovingSkuList(RetailscmUserContext userContext, String productId, 
			String skuIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String skuId: skuIds){
			userContext.getChecker().checkIdOfSku(skuId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeSkuList(RetailscmUserContext userContext, String productId, 
			String skuIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSkuList(userContext, productId,  skuIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveSkuList(product, skuIds, allTokens());
				product = saveProduct(userContext, product, tokens().withSkuList().done());
				deleteRelationListInGraph(userContext, product.getSkuList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSku(RetailscmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeSku(RetailscmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			deleteRelationInGraph(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSku(RetailscmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copySkuFrom(RetailscmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			product.copySkuFrom( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			userContext.getManagerGroup().getSkuManager().onNewInstanceCreated(userContext, (Sku)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSku(RetailscmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		

		if(Sku.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSku(parseString(newValueExpr));
		}
		
		if(Sku.SIZE_PROPERTY.equals(property)){
			userContext.getChecker().checkSizeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.BARCODE_PROPERTY.equals(property)){
			userContext.getChecker().checkBarcodeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.PACKAGE_TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkPackageTypeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.NET_CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkNetContentOfSku(parseString(newValueExpr));
		}
		
		if(Sku.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfSku(parseBigDecimal(newValueExpr));
		}
		
		if(Sku.PICTURE_PROPERTY.equals(property)){
			userContext.getChecker().checkPictureOfSku(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateSku(RetailscmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSku(userContext, productId, skuId, skuVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSkuList().searchSkuListWith(Sku.ID_PROPERTY, "eq", skuId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeSku( sku );	
			//make changes to AcceleraterAccount.
			Sku skuIndex = createIndexedSku(skuId, skuVersion);
		
			Sku sku = product.findTheSku(skuIndex);
			if(sku == null){
				throw new ProductManagerException(sku+" is NOT FOUND" );
			}
			
			sku.changeProperty(property, newValueExpr);
			
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Product newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


