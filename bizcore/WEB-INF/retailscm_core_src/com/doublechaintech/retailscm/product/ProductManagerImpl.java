
package com.doublechaintech.retailscm.product;

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



import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.sku.Sku;

import com.doublechaintech.retailscm.levelthreecategory.CandidateLevelThreeCategory;

import com.doublechaintech.retailscm.product.Product;






public class ProductManagerImpl extends CustomRetailscmCheckerManager implements ProductManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = ProductTokens.start().withTokenFromListName(listName).done();
		Product  product = (Product) this.loadProduct(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = product.collectRefercencesFromLists();
		productDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, product, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ProductGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "Product";
	@Override
	public ProductDAO daoOf(RetailscmUserContext userContext) {
		return productDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	
 	 public Product searchProduct(RetailscmUserContext userContext, String productId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	

 	protected Product present(RetailscmUserContext userContext, Product product, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,product,tokens);
		
		
		Product  productToPresent = productDaoOf(userContext).present(product, tokens);
		
		List<BaseEntity> entityListToNaming = productToPresent.collectRefercencesFromLists();
		productDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,product,tokens);
		
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
 		return productDaoOf(userContext).save(product, tokens);
 	}
 	protected Product loadProduct(RetailscmUserContext userContext, String productId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProductManagerException.class);

 
 		return productDaoOf(userContext).load(productId, tokens);
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
	
 	
 	
 
 	
 	

	public Product createProduct(RetailscmUserContext userContext, String name,String parentCategoryId,String origin,String remark,String brand,String picture) throws Exception
	//public Product createProduct(RetailscmUserContext userContext,String name, String parentCategoryId, String origin, String remark, String brand, String picture) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfProduct(name);
		checkerOf(userContext).checkOriginOfProduct(origin);
		checkerOf(userContext).checkRemarkOfProduct(remark);
		checkerOf(userContext).checkBrandOfProduct(brand);
		checkerOf(userContext).checkPictureOfProduct(picture);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).checkVersionOfProduct( productVersion);
		

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
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);


	}



	public Product clone(RetailscmUserContext userContext, String fromProductId) throws Exception{

		return productDaoOf(userContext).clone(fromProductId, this.allTokens());
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
			if (product.isChanged()){
			product.updateLastUpdateTime(userContext.now());
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailscmUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfProduct(productId);
 		checkerOf(userContext).checkIdOfLevelThreeCategory(anotherParentCategoryId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);

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
		SmartList<LevelThreeCategory> candidateList = levelThreeCategoryDaoOf(userContext).requestCandidateLevelThreeCategoryForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LevelThreeCategory loadLevelThreeCategory(RetailscmUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{

 		return levelThreeCategoryDaoOf(userContext).load(newParentCategoryId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String productId, int productVersion) throws Exception {
		//deleteInternal(userContext, productId, productVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String productId, int productVersion) throws Exception{

		productDaoOf(userContext).delete(productId, productVersion);
	}

	public Product forgetByAll(RetailscmUserContext userContext, String productId, int productVersion) throws Exception {
		return forgetByAllInternal(userContext, productId, productVersion);
	}
	protected Product forgetByAllInternal(RetailscmUserContext userContext,
			String productId, int productVersion) throws Exception{

		return productDaoOf(userContext).disconnectFromAll(productId, productVersion);
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
		return productDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingSku(RetailscmUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfProduct(productId);

		
		checkerOf(userContext).checkNameOfSku(name);
		
		checkerOf(userContext).checkSizeOfSku(size);
		
		checkerOf(userContext).checkBarcodeOfSku(barcode);
		
		checkerOf(userContext).checkPackageTypeOfSku(packageType);
		
		checkerOf(userContext).checkNetContentOfSku(netContent);
		
		checkerOf(userContext).checkPriceOfSku(price);
		
		checkerOf(userContext).checkPictureOfSku(picture);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);


	}
	public  Product addSku(RetailscmUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSku(userContext,productId,name, size, barcode, packageType, netContent, price, picture,tokensExpr);

		Sku sku = createSku(userContext,name, size, barcode, packageType, netContent, price, picture);

		Product product = loadProduct(userContext, productId, emptyOptions());
		synchronized(product){
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addSku( sku );
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			skuManagerOf(userContext).onNewInstanceCreated(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSkuProperties(RetailscmUserContext userContext, String productId,String id,String name,String size,String barcode,String packageType,String netContent,BigDecimal price,String picture,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).checkIdOfSku(id);

		checkerOf(userContext).checkNameOfSku( name);
		checkerOf(userContext).checkSizeOfSku( size);
		checkerOf(userContext).checkBarcodeOfSku( barcode);
		checkerOf(userContext).checkPackageTypeOfSku( packageType);
		checkerOf(userContext).checkNetContentOfSku( netContent);
		checkerOf(userContext).checkPriceOfSku( price);
		checkerOf(userContext).checkPictureOfSku( picture);

		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);

	}
	public  Product updateSkuProperties(RetailscmUserContext userContext, String productId, String id,String name,String size,String barcode,String packageType,String netContent,BigDecimal price,String picture, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSkuProperties(userContext,productId,id,name,size,barcode,packageType,netContent,price,picture,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSkuListList()
				.searchSkuListWith(Sku.ID_PROPERTY, tokens().is(), id).done();

		Product productToUpdate = loadProduct(userContext, productId, options);

		if(productToUpdate.getSkuList().isEmpty()){
			throw new ProductManagerException("Sku is NOT FOUND with id: '"+id+"'");
		}

		Sku item = productToUpdate.getSkuList().first();
		beforeUpdateSkuProperties(userContext,item, productId,id,name,size,barcode,packageType,netContent,price,picture,tokensExpr);
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

	protected  void beforeUpdateSkuProperties(RetailscmUserContext userContext, Sku item, String productId, String id,String name,String size,String barcode,String packageType,String netContent,BigDecimal price,String picture, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfProduct(productId);
		for(String skuIdItem: skuIds){
			checkerOf(userContext).checkIdOfSku(skuIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);

	}
	public  Product removeSkuList(RetailscmUserContext userContext, String productId,
			String skuIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSkuList(userContext, productId,  skuIds, tokensExpr);


			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				productDaoOf(userContext).planToRemoveSkuList(product, skuIds, allTokens());
				product = saveProduct(userContext, product, tokens().withSkuList().done());
				deleteRelationListInGraph(userContext, product.getSkuList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSku(RetailscmUserContext userContext, String productId,
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfProduct( productId);
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkVersionOfSku(skuVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);

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
		
		checkerOf(userContext).checkIdOfProduct( productId);
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkVersionOfSku(skuVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);

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
			
			skuManagerOf(userContext).onNewInstanceCreated(userContext, (Sku)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSku(RetailscmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfProduct(productId);
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkVersionOfSku(skuVersion);


		if(Sku.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfSku(parseString(newValueExpr));
		}
		
		if(Sku.SIZE_PROPERTY.equals(property)){
			checkerOf(userContext).checkSizeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.BARCODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkBarcodeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.PACKAGE_TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkPackageTypeOfSku(parseString(newValueExpr));
		}
		
		if(Sku.NET_CONTENT_PROPERTY.equals(property)){
			checkerOf(userContext).checkNetContentOfSku(parseString(newValueExpr));
		}
		
		if(Sku.PRICE_PROPERTY.equals(property)){
			checkerOf(userContext).checkPriceOfSku(parseBigDecimal(newValueExpr));
		}
		
		if(Sku.PICTURE_PROPERTY.equals(property)){
			checkerOf(userContext).checkPictureOfSku(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(ProductManagerException.class);

	}

	public  Product updateSku(RetailscmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSku(userContext, productId, skuId, skuVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSkuList().searchSkuListWith(Sku.ID_PROPERTY, tokens().equals(), skuId).done();



		Product product = loadProduct(userContext, productId, loadTokens);

		synchronized(product){
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeSku( sku );
			//make changes to AcceleraterAccount.
			Sku skuIdVersionKey = createIndexedSku(skuId, skuVersion);

			Sku sku = product.findTheSku(skuIdVersionKey);
			if(sku == null){
				throw new ProductManagerException(skuId+" is NOT FOUND" );
			}

			beforeUpdateSku(userContext, sku, productId, skuId, skuVersion, property, newValueExpr,  tokensExpr);
			sku.changeProperty(property, newValueExpr);
			
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateSku(RetailscmUserContext userContext, Sku existed, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Product newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    productDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Product newProduct = this.createProduct(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newProduct
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Product.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Product> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LevelThreeCategory> parentCategoryList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LevelThreeCategory.class);
		userContext.getDAOGroup().enhanceList(parentCategoryList, LevelThreeCategory.class);


    }
	
	public Object listByParentCategory(RetailscmUserContext userContext,String parentCategoryId) throws Exception {
		return listPageByParentCategory(userContext, parentCategoryId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByParentCategory(RetailscmUserContext userContext,String parentCategoryId, int start, int count) throws Exception {
		SmartList<Product> list = productDaoOf(userContext).findProductByParentCategory(parentCategoryId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Product.class);
		page.setContainerObject(LevelThreeCategory.withId(parentCategoryId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("产品列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String productId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getProductDetailScope().clone();
		Product merchantObj = (Product) this.view(userContext, productId);
    String merchantObjId = productId;
    String linkToUrl =	"productManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "产品"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-parentCategory")
				    .put("fieldName", "parentCategory")
				    .put("label", "父类")
				    .put("type", "auto")
				    .put("linkToUrl", "levelThreeCategoryManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("parentCategory", merchantObj.getParentCategory());

		propList.add(
				MapUtil.put("id", "4-origin")
				    .put("fieldName", "origin")
				    .put("label", "产地")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("origin", merchantObj.getOrigin());

		propList.add(
				MapUtil.put("id", "5-remark")
				    .put("fieldName", "remark")
				    .put("label", "备注")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("remark", merchantObj.getRemark());

		propList.add(
				MapUtil.put("id", "6-brand")
				    .put("fieldName", "brand")
				    .put("label", "品牌")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("brand", merchantObj.getBrand());

		propList.add(
				MapUtil.put("id", "7-picture")
				    .put("fieldName", "picture")
				    .put("label", "图片")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("picture", merchantObj.getPicture());

		propList.add(
				MapUtil.put("id", "8-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：skuListSection
		Map skuListSection = ListofUtils.buildSection(
		    "skuListSection",
		    "Sku列表",
		    null,
		    "",
		    "__no_group",
		    "skuManager/listByProduct/"+merchantObjId+"/",
		    "product"
		);
		sections.add(skuListSection);

		result.put("skuListSection", ListofUtils.toShortList(merchantObj.getSkuList(), "sku"));
		vscope.field("skuListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Sku.class.getName(), null));

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


