
package com.doublechaintech.retailscm.supplierproduct;

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


import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

import com.doublechaintech.retailscm.goodssupplier.CandidateGoodsSupplier;

import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;






public class SupplierProductManagerImpl extends CustomRetailscmCheckerManager implements SupplierProductManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = SupplierProductTokens.start().withTokenFromListName(listName).done();
		SupplierProduct  supplierProduct = (SupplierProduct) this.loadSupplierProduct(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplierProduct.collectRefercencesFromLists();
		supplierProductDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, supplierProduct, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplierProductGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "SupplierProduct";
	@Override
	public SupplierProductDAO daoOf(RetailscmUserContext userContext) {
		return supplierProductDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplierProductManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplierProductManagerException(message);

	}



 	protected SupplierProduct saveSupplierProduct(RetailscmUserContext userContext, SupplierProduct supplierProduct, String [] tokensExpr) throws Exception{	
 		//return getSupplierProductDAO().save(supplierProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplierProduct(userContext, supplierProduct, tokens);
 	}
 	
 	protected SupplierProduct saveSupplierProductDetail(RetailscmUserContext userContext, SupplierProduct supplierProduct) throws Exception{	

 		
 		return saveSupplierProduct(userContext, supplierProduct, allTokens());
 	}
 	
 	public SupplierProduct loadSupplierProduct(RetailscmUserContext userContext, String supplierProductId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplierProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierProduct, tokens);
 	}
 	
 	
 	 public SupplierProduct searchSupplierProduct(RetailscmUserContext userContext, String supplierProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplierProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierProduct, tokens);
 	}
 	
 	

 	protected SupplierProduct present(RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplierProduct,tokens);
		
		
		SupplierProduct  supplierProductToPresent = supplierProductDaoOf(userContext).present(supplierProduct, tokens);
		
		List<BaseEntity> entityListToNaming = supplierProductToPresent.collectRefercencesFromLists();
		supplierProductDaoOf(userContext).alias(entityListToNaming);
		
		return  supplierProductToPresent;
		
		
	}
 
 	
 	
 	public SupplierProduct loadSupplierProductDetail(RetailscmUserContext userContext, String supplierProductId) throws Exception{	
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, allTokens());
 		return present(userContext,supplierProduct, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplierProductId) throws Exception{	
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, viewTokens());
 		return present(userContext,supplierProduct, allTokens());
		
 	}
 	protected SupplierProduct saveSupplierProduct(RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String,Object>tokens) throws Exception{	
 		return supplierProductDaoOf(userContext).save(supplierProduct, tokens);
 	}
 	protected SupplierProduct loadSupplierProduct(RetailscmUserContext userContext, String supplierProductId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplierProductManagerException.class);

 
 		return supplierProductDaoOf(userContext).load(supplierProductId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens){
		super.addActions(userContext, supplierProduct, tokens);
		
		addAction(userContext, supplierProduct, tokens,"@create","createSupplierProduct","createSupplierProduct/","main","primary");
		addAction(userContext, supplierProduct, tokens,"@update","updateSupplierProduct","updateSupplierProduct/"+supplierProduct.getId()+"/","main","primary");
		addAction(userContext, supplierProduct, tokens,"@copy","cloneSupplierProduct","cloneSupplierProduct/"+supplierProduct.getId()+"/","main","primary");
		
		addAction(userContext, supplierProduct, tokens,"supplier_product.transfer_to_supplier","transferToAnotherSupplier","transferToAnotherSupplier/"+supplierProduct.getId()+"/","main","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.addProductSupplyDuration","addProductSupplyDuration","addProductSupplyDuration/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.removeProductSupplyDuration","removeProductSupplyDuration","removeProductSupplyDuration/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.updateProductSupplyDuration","updateProductSupplyDuration","updateProductSupplyDuration/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.copyProductSupplyDurationFrom","copyProductSupplyDurationFrom","copyProductSupplyDurationFrom/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplierProduct createSupplierProduct(RetailscmUserContext userContext, String productName,String productDescription,String productUnit,String supplierId) throws Exception
	//public SupplierProduct createSupplierProduct(RetailscmUserContext userContext,String productName, String productDescription, String productUnit, String supplierId) throws Exception
	{

		

		

		checkerOf(userContext).checkProductNameOfSupplierProduct(productName);
		checkerOf(userContext).checkProductDescriptionOfSupplierProduct(productDescription);
		checkerOf(userContext).checkProductUnitOfSupplierProduct(productUnit);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);


		SupplierProduct supplierProduct=createNewSupplierProduct();	

		supplierProduct.setProductName(productName);
		supplierProduct.setProductDescription(productDescription);
		supplierProduct.setProductUnit(productUnit);
			
		GoodsSupplier supplier = loadGoodsSupplier(userContext, supplierId,emptyOptions());
		supplierProduct.setSupplier(supplier);
		
		

		supplierProduct = saveSupplierProduct(userContext, supplierProduct, emptyOptions());
		
		onNewInstanceCreated(userContext, supplierProduct);
		return supplierProduct;


	}
	protected SupplierProduct createNewSupplierProduct()
	{

		return new SupplierProduct();
	}

	protected void checkParamsForUpdatingSupplierProduct(RetailscmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).checkVersionOfSupplierProduct( supplierProductVersion);
		

		if(SupplierProduct.PRODUCT_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProductNameOfSupplierProduct(parseString(newValueExpr));
		
			
		}
		if(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProductDescriptionOfSupplierProduct(parseString(newValueExpr));
		
			
		}
		if(SupplierProduct.PRODUCT_UNIT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProductUnitOfSupplierProduct(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);


	}



	public SupplierProduct clone(RetailscmUserContext userContext, String fromSupplierProductId) throws Exception{

		return supplierProductDaoOf(userContext).clone(fromSupplierProductId, this.allTokens());
	}

	public SupplierProduct internalSaveSupplierProduct(RetailscmUserContext userContext, SupplierProduct supplierProduct) throws Exception
	{
		return internalSaveSupplierProduct(userContext, supplierProduct, allTokens());

	}
	public SupplierProduct internalSaveSupplierProduct(RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplierProduct(userContext, supplierProductId, supplierProductVersion, property, newValueExpr, tokensExpr);


		synchronized(supplierProduct){
			//will be good when the supplierProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierProduct.
			if (supplierProduct.isChanged()){
			
			}
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, options);
			return supplierProduct;

		}

	}

	public SupplierProduct updateSupplierProduct(RetailscmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplierProduct(userContext, supplierProductId, supplierProductVersion, property, newValueExpr, tokensExpr);



		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		if(supplierProduct.getVersion() != supplierProductVersion){
			String message = "The target version("+supplierProduct.getVersion()+") is not equals to version("+supplierProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplierProduct){
			//will be good when the supplierProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierProduct.
			
			supplierProduct.changeProperty(property, newValueExpr);
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
			//return saveSupplierProduct(userContext, supplierProduct, tokens().done());
		}

	}

	public SupplierProduct updateSupplierProductProperty(RetailscmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplierProduct(userContext, supplierProductId, supplierProductVersion, property, newValueExpr, tokensExpr);

		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		if(supplierProduct.getVersion() != supplierProductVersion){
			String message = "The target version("+supplierProduct.getVersion()+") is not equals to version("+supplierProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplierProduct){
			//will be good when the supplierProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierProduct.

			supplierProduct.changeProperty(property, newValueExpr);
			
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
			//return saveSupplierProduct(userContext, supplierProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplierProductTokens tokens(){
		return SupplierProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplierProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductSupplyDurationListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplierProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSupplier(RetailscmUserContext userContext, String supplierProductId, String anotherSupplierId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
 		checkerOf(userContext).checkIdOfGoodsSupplier(anotherSupplierId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

 	}
 	public SupplierProduct transferToAnotherSupplier(RetailscmUserContext userContext, String supplierProductId, String anotherSupplierId) throws Exception
 	{
 		checkParamsForTransferingAnotherSupplier(userContext, supplierProductId,anotherSupplierId);
 
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());	
		synchronized(supplierProduct){
			//will be good when the supplierProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier supplier = loadGoodsSupplier(userContext, anotherSupplierId, emptyOptions());		
			supplierProduct.updateSupplier(supplier);		
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, emptyOptions());
			
			return present(userContext,supplierProduct, allTokens());
			
		}

 	}

	


	public CandidateGoodsSupplier requestCandidateSupplier(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsSupplier result = new CandidateGoodsSupplier();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsSupplier> candidateList = goodsSupplierDaoOf(userContext).requestCandidateGoodsSupplierForSupplierProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String newSupplierId, Map<String,Object> options) throws Exception
 	{

 		return goodsSupplierDaoOf(userContext).load(newSupplierId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplierProductId, int supplierProductVersion) throws Exception {
		//deleteInternal(userContext, supplierProductId, supplierProductVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplierProductId, int supplierProductVersion) throws Exception{

		supplierProductDaoOf(userContext).delete(supplierProductId, supplierProductVersion);
	}

	public SupplierProduct forgetByAll(RetailscmUserContext userContext, String supplierProductId, int supplierProductVersion) throws Exception {
		return forgetByAllInternal(userContext, supplierProductId, supplierProductVersion);
	}
	protected SupplierProduct forgetByAllInternal(RetailscmUserContext userContext,
			String supplierProductId, int supplierProductVersion) throws Exception{

		return supplierProductDaoOf(userContext).disconnectFromAll(supplierProductId, supplierProductVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplierProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return supplierProductDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);

		
		checkerOf(userContext).checkQuantityOfProductSupplyDuration(quantity);
		
		checkerOf(userContext).checkDurationOfProductSupplyDuration(duration);
		
		checkerOf(userContext).checkPriceOfProductSupplyDuration(price);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);


	}
	public  SupplierProduct addProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingProductSupplyDuration(userContext,supplierProductId,quantity, duration, price,tokensExpr);

		ProductSupplyDuration productSupplyDuration = createProductSupplyDuration(userContext,quantity, duration, price);

		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, emptyOptions());
		synchronized(supplierProduct){
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierProduct.addProductSupplyDuration( productSupplyDuration );
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			
			userContext.getManagerGroup().getProductSupplyDurationManager().onNewInstanceCreated(userContext, productSupplyDuration);
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductSupplyDurationProperties(RetailscmUserContext userContext, String supplierProductId,String id,int quantity,String duration,BigDecimal price,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).checkIdOfProductSupplyDuration(id);

		checkerOf(userContext).checkQuantityOfProductSupplyDuration( quantity);
		checkerOf(userContext).checkDurationOfProductSupplyDuration( duration);
		checkerOf(userContext).checkPriceOfProductSupplyDuration( price);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

	}
	public  SupplierProduct updateProductSupplyDurationProperties(RetailscmUserContext userContext, String supplierProductId, String id,int quantity,String duration,BigDecimal price, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProductSupplyDurationProperties(userContext,supplierProductId,id,quantity,duration,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductSupplyDurationListList()
				.searchProductSupplyDurationListWith(ProductSupplyDuration.ID_PROPERTY, "is", id).done();

		SupplierProduct supplierProductToUpdate = loadSupplierProduct(userContext, supplierProductId, options);

		if(supplierProductToUpdate.getProductSupplyDurationList().isEmpty()){
			throw new SupplierProductManagerException("ProductSupplyDuration is NOT FOUND with id: '"+id+"'");
		}

		ProductSupplyDuration item = supplierProductToUpdate.getProductSupplyDurationList().first();

		item.updateQuantity( quantity );
		item.updateDuration( duration );
		item.updatePrice( price );


		//checkParamsForAddingProductSupplyDuration(userContext,supplierProductId,name, code, used,tokensExpr);
		SupplierProduct supplierProduct = saveSupplierProduct(userContext, supplierProductToUpdate, tokens().withProductSupplyDurationList().done());
		synchronized(supplierProduct){
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}
	}


	protected ProductSupplyDuration createProductSupplyDuration(RetailscmUserContext userContext, int quantity, String duration, BigDecimal price) throws Exception{

		ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
		
		
		productSupplyDuration.setQuantity(quantity);		
		productSupplyDuration.setDuration(duration);		
		productSupplyDuration.setPrice(price);
	
		
		return productSupplyDuration;


	}

	protected ProductSupplyDuration createIndexedProductSupplyDuration(String id, int version){

		ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
		productSupplyDuration.setId(id);
		productSupplyDuration.setVersion(version);
		return productSupplyDuration;

	}

	protected void checkParamsForRemovingProductSupplyDurationList(RetailscmUserContext userContext, String supplierProductId,
			String productSupplyDurationIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		for(String productSupplyDurationIdItem: productSupplyDurationIds){
			checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

	}
	public  SupplierProduct removeProductSupplyDurationList(RetailscmUserContext userContext, String supplierProductId,
			String productSupplyDurationIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingProductSupplyDurationList(userContext, supplierProductId,  productSupplyDurationIds, tokensExpr);


			SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
			synchronized(supplierProduct){
				//Will be good when the supplierProduct loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplierProductDaoOf(userContext).planToRemoveProductSupplyDurationList(supplierProduct, productSupplyDurationIds, allTokens());
				supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
				deleteRelationListInGraph(userContext, supplierProduct.getProductSupplyDurationList());
				return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId,
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplierProduct( supplierProductId);
		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).checkVersionOfProductSupplyDuration(productSupplyDurationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

	}
	public  SupplierProduct removeProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId,
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingProductSupplyDuration(userContext,supplierProductId, productSupplyDurationId, productSupplyDurationVersion,tokensExpr);

		ProductSupplyDuration productSupplyDuration = createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		synchronized(supplierProduct){
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierProduct.removeProductSupplyDuration( productSupplyDuration );
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			deleteRelationInGraph(userContext, productSupplyDuration);
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId,
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplierProduct( supplierProductId);
		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).checkVersionOfProductSupplyDuration(productSupplyDurationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

	}
	public  SupplierProduct copyProductSupplyDurationFrom(RetailscmUserContext userContext, String supplierProductId,
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingProductSupplyDuration(userContext,supplierProductId, productSupplyDurationId, productSupplyDurationVersion,tokensExpr);

		ProductSupplyDuration productSupplyDuration = createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		synchronized(supplierProduct){
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			supplierProduct.copyProductSupplyDurationFrom( productSupplyDuration );
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			
			userContext.getManagerGroup().getProductSupplyDurationManager().onNewInstanceCreated(userContext, (ProductSupplyDuration)supplierProduct.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
		checkerOf(userContext).checkVersionOfProductSupplyDuration(productSupplyDurationVersion);
		

		if(ProductSupplyDuration.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfProductSupplyDuration(parseInt(newValueExpr));
		
		}
		
		if(ProductSupplyDuration.DURATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationOfProductSupplyDuration(parseString(newValueExpr));
		
		}
		
		if(ProductSupplyDuration.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfProductSupplyDuration(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

	}

	public  SupplierProduct updateProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingProductSupplyDuration(userContext, supplierProductId, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withProductSupplyDurationList().searchProductSupplyDurationListWith(ProductSupplyDuration.ID_PROPERTY, "eq", productSupplyDurationId).done();



		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, loadTokens);

		synchronized(supplierProduct){
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplierProduct.removeProductSupplyDuration( productSupplyDuration );
			//make changes to AcceleraterAccount.
			ProductSupplyDuration productSupplyDurationIndex = createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);

			ProductSupplyDuration productSupplyDuration = supplierProduct.findTheProductSupplyDuration(productSupplyDurationIndex);
			if(productSupplyDuration == null){
				throw new SupplierProductManagerException(productSupplyDuration+" is NOT FOUND" );
			}

			productSupplyDuration.changeProperty(property, newValueExpr);
			
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplierProduct newCreated) throws Exception{
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
		//   SupplierProduct newSupplierProduct = this.createSupplierProduct(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplierProduct
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplierProduct.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<SupplierProduct> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GoodsSupplier> supplierList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsSupplier.class);
		userContext.getDAOGroup().enhanceList(supplierList, GoodsSupplier.class);


    }
	
	public Object listBySupplier(RetailscmUserContext userContext,String supplierId) throws Exception {
		return listPageBySupplier(userContext, supplierId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySupplier(RetailscmUserContext userContext,String supplierId, int start, int count) throws Exception {
		SmartList<SupplierProduct> list = supplierProductDaoOf(userContext).findSupplierProductBySupplier(supplierId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(SupplierProduct.class);
		page.setContainerObject(GoodsSupplier.withId(supplierId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应商的产品列表");
		page.setRequestName("listBySupplier");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySupplier/%s/",  getBeanName(), supplierId)));

		page.assemblerContent(userContext, "listBySupplier");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String supplierProductId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getSupplierProductDetailScope().clone();
		SupplierProduct merchantObj = (SupplierProduct) this.view(userContext, supplierProductId);
    String merchantObjId = supplierProductId;
    String linkToUrl =	"supplierProductManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应商的产品"+"详情";
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
				MapUtil.put("id", "2-productName")
				    .put("fieldName", "productName")
				    .put("label", "品名")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("productName", merchantObj.getProductName());

		propList.add(
				MapUtil.put("id", "3-productDescription")
				    .put("fieldName", "productDescription")
				    .put("label", "产品描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("productDescription", merchantObj.getProductDescription());

		propList.add(
				MapUtil.put("id", "4-productUnit")
				    .put("fieldName", "productUnit")
				    .put("label", "产品单元")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("productUnit", merchantObj.getProductUnit());

		propList.add(
				MapUtil.put("id", "5-supplier")
				    .put("fieldName", "supplier")
				    .put("label", "供应商")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsSupplierManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("supplier", merchantObj.getSupplier());

		//处理 sectionList

		//处理Section：productSupplyDurationListSection
		Map productSupplyDurationListSection = ListofUtils.buildSection(
		    "productSupplyDurationListSection",
		    "产品供货期限清单",
		    null,
		    "",
		    "__no_group",
		    "productSupplyDurationManager/listByProduct/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(productSupplyDurationListSection);

		result.put("productSupplyDurationListSection", ListofUtils.toShortList(merchantObj.getProductSupplyDurationList(), "productSupplyDuration"));
		vscope.field("productSupplyDurationListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( ProductSupplyDuration.class.getName(), null));

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


