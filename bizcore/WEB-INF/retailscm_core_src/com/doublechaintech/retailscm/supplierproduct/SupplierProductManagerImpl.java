
package com.doublechaintech.retailscm.supplierproduct;

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

import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

import com.doublechaintech.retailscm.goodssupplier.CandidateGoodsSupplier;

import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;






public class SupplierProductManagerImpl extends CustomRetailscmCheckerManager implements SupplierProductManager {
	
	private static final String SERVICE_TYPE = "SupplierProduct";
	
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
 
 		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplierProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierProduct, tokens);
 	}
 	
 	
 	 public SupplierProduct searchSupplierProduct(RetailscmUserContext userContext, String supplierProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplierProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierProduct, tokens);
 	}
 	
 	

 	protected SupplierProduct present(RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplierProduct,tokens);
		
		
		SupplierProduct  supplierProductToPresent = userContext.getDAOGroup().getSupplierProductDAO().present(supplierProduct, tokens);
		
		List<BaseEntity> entityListToNaming = supplierProductToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplierProductDAO().alias(entityListToNaming);
		
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
 		return userContext.getDAOGroup().getSupplierProductDAO().save(supplierProduct, tokens);
 	}
 	protected SupplierProduct loadSupplierProduct(RetailscmUserContext userContext, String supplierProductId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplierProductManagerException.class);

 
 		return userContext.getDAOGroup().getSupplierProductDAO().load(supplierProductId, tokens);
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
	
 	
 	
 
 	
 	


	public SupplierProduct createSupplierProduct(RetailscmUserContext userContext,String productName, String productDescription, String productUnit, String supplierId) throws Exception
	{
		
		

		

		userContext.getChecker().checkProductNameOfSupplierProduct(productName);
		userContext.getChecker().checkProductDescriptionOfSupplierProduct(productDescription);
		userContext.getChecker().checkProductUnitOfSupplierProduct(productUnit);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);


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
		

		
		
		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		userContext.getChecker().checkVersionOfSupplierProduct( supplierProductVersion);
		

		if(SupplierProduct.PRODUCT_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkProductNameOfSupplierProduct(parseString(newValueExpr));
		}
		if(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkProductDescriptionOfSupplierProduct(parseString(newValueExpr));
		}
		if(SupplierProduct.PRODUCT_UNIT_PROPERTY.equals(property)){
			userContext.getChecker().checkProductUnitOfSupplierProduct(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
	
		
	}
	
	
	
	public SupplierProduct clone(RetailscmUserContext userContext, String fromSupplierProductId) throws Exception{
		
		return userContext.getDAOGroup().getSupplierProductDAO().clone(fromSupplierProductId, this.allTokens());
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
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplierProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSupplier(RetailscmUserContext userContext, String supplierProductId, String anotherSupplierId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
 		userContext.getChecker().checkIdOfGoodsSupplier(anotherSupplierId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
 		
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
		SmartList<GoodsSupplier> candidateList = userContext.getDAOGroup().getGoodsSupplierDAO().requestCandidateGoodsSupplierForSupplierProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String newSupplierId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsSupplierDAO().load(newSupplierId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplierProductId, int supplierProductVersion) throws Exception {
		//deleteInternal(userContext, supplierProductId, supplierProductVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplierProductId, int supplierProductVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplierProductDAO().delete(supplierProductId, supplierProductVersion);
	}
	
	public SupplierProduct forgetByAll(RetailscmUserContext userContext, String supplierProductId, int supplierProductVersion) throws Exception {
		return forgetByAllInternal(userContext, supplierProductId, supplierProductVersion);		
	}
	protected SupplierProduct forgetByAllInternal(RetailscmUserContext userContext,
			String supplierProductId, int supplierProductVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplierProductDAO().disconnectFromAll(supplierProductId, supplierProductVersion);
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
		return userContext.getDAOGroup().getSupplierProductDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);

		
		userContext.getChecker().checkQuantityOfProductSupplyDuration(quantity);
		
		userContext.getChecker().checkDurationOfProductSupplyDuration(duration);
		
		userContext.getChecker().checkPriceOfProductSupplyDuration(price);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);

	
	}
	public  SupplierProduct addProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProductSupplyDuration(userContext,supplierProductId,quantity, duration, price,tokensExpr);
		
		ProductSupplyDuration productSupplyDuration = createProductSupplyDuration(userContext,quantity, duration, price);
		
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
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
		
		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		userContext.getChecker().checkIdOfProductSupplyDuration(id);
		
		userContext.getChecker().checkQuantityOfProductSupplyDuration( quantity);
		userContext.getChecker().checkDurationOfProductSupplyDuration( duration);
		userContext.getChecker().checkPriceOfProductSupplyDuration( price);

		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
		
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
		
		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		for(String productSupplyDurationId: productSupplyDurationIds){
			userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
		
	}
	public  SupplierProduct removeProductSupplyDurationList(RetailscmUserContext userContext, String supplierProductId, 
			String productSupplyDurationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductSupplyDurationList(userContext, supplierProductId,  productSupplyDurationIds, tokensExpr);
			
			
			SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
			synchronized(supplierProduct){ 
				//Will be good when the supplierProduct loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplierProductDAO().planToRemoveProductSupplyDurationList(supplierProduct, productSupplyDurationIds, allTokens());
				supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
				deleteRelationListInGraph(userContext, supplierProduct.getProductSupplyDurationList());
				return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, 
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplierProduct( supplierProductId);
		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().checkVersionOfProductSupplyDuration(productSupplyDurationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
	
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
		
		userContext.getChecker().checkIdOfSupplierProduct( supplierProductId);
		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().checkVersionOfProductSupplyDuration(productSupplyDurationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
	
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
		

		
		userContext.getChecker().checkIdOfSupplierProduct(supplierProductId);
		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().checkVersionOfProductSupplyDuration(productSupplyDurationVersion);
		

		if(ProductSupplyDuration.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfProductSupplyDuration(parseInt(newValueExpr));
		}
		
		if(ProductSupplyDuration.DURATION_PROPERTY.equals(property)){
			userContext.getChecker().checkDurationOfProductSupplyDuration(parseString(newValueExpr));
		}
		
		if(ProductSupplyDuration.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfProductSupplyDuration(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierProductManagerException.class);
	
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

}


