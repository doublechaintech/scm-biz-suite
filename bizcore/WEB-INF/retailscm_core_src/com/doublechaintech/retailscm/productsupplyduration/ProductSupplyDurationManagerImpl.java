
package com.doublechaintech.retailscm.productsupplyduration;

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

import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

import com.doublechaintech.retailscm.supplierproduct.CandidateSupplierProduct;







public class ProductSupplyDurationManagerImpl extends CustomRetailscmCheckerManager implements ProductSupplyDurationManager {
	
	private static final String SERVICE_TYPE = "ProductSupplyDuration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProductSupplyDurationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProductSupplyDurationManagerException(message);

	}
	
	

 	protected ProductSupplyDuration saveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, String [] tokensExpr) throws Exception{	
 		//return getProductSupplyDurationDAO().save(productSupplyDuration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProductSupplyDuration(userContext, productSupplyDuration, tokens);
 	}
 	
 	protected ProductSupplyDuration saveProductSupplyDurationDetail(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception{	

 		
 		return saveProductSupplyDuration(userContext, productSupplyDuration, allTokens());
 	}
 	
 	public ProductSupplyDuration loadProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductSupplyDurationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productSupplyDuration, tokens);
 	}
 	
 	
 	 public ProductSupplyDuration searchProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductSupplyDurationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productSupplyDuration, tokens);
 	}
 	
 	

 	protected ProductSupplyDuration present(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,productSupplyDuration,tokens);
		
		
		ProductSupplyDuration  productSupplyDurationToPresent = userContext.getDAOGroup().getProductSupplyDurationDAO().present(productSupplyDuration, tokens);
		
		List<BaseEntity> entityListToNaming = productSupplyDurationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProductSupplyDurationDAO().alias(entityListToNaming);
		
		return  productSupplyDurationToPresent;
		
		
	}
 
 	
 	
 	public ProductSupplyDuration loadProductSupplyDurationDetail(RetailscmUserContext userContext, String productSupplyDurationId) throws Exception{	
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, allTokens());
 		return present(userContext,productSupplyDuration, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String productSupplyDurationId) throws Exception{	
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, viewTokens());
 		return present(userContext,productSupplyDuration, allTokens());
		
 	}
 	protected ProductSupplyDuration saveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProductSupplyDurationDAO().save(productSupplyDuration, tokens);
 	}
 	protected ProductSupplyDuration loadProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductSupplyDurationManagerException.class);

 
 		return userContext.getDAOGroup().getProductSupplyDurationDAO().load(productSupplyDurationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){
		super.addActions(userContext, productSupplyDuration, tokens);
		
		addAction(userContext, productSupplyDuration, tokens,"@create","createProductSupplyDuration","createProductSupplyDuration/","main","primary");
		addAction(userContext, productSupplyDuration, tokens,"@update","updateProductSupplyDuration","updateProductSupplyDuration/"+productSupplyDuration.getId()+"/","main","primary");
		addAction(userContext, productSupplyDuration, tokens,"@copy","cloneProductSupplyDuration","cloneProductSupplyDuration/"+productSupplyDuration.getId()+"/","main","primary");
		
		addAction(userContext, productSupplyDuration, tokens,"product_supply_duration.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+productSupplyDuration.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProductSupplyDuration createProductSupplyDuration(RetailscmUserContext userContext,int quantity, String duration, BigDecimal price, String productId) throws Exception
	{
		
		

		

		userContext.getChecker().checkQuantityOfProductSupplyDuration(quantity);
		userContext.getChecker().checkDurationOfProductSupplyDuration(duration);
		userContext.getChecker().checkPriceOfProductSupplyDuration(price);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);


		ProductSupplyDuration productSupplyDuration=createNewProductSupplyDuration();	

		productSupplyDuration.setQuantity(quantity);
		productSupplyDuration.setDuration(duration);
		productSupplyDuration.setPrice(price);
			
		SupplierProduct product = loadSupplierProduct(userContext, productId,emptyOptions());
		productSupplyDuration.setProduct(product);
		
		

		productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());
		
		onNewInstanceCreated(userContext, productSupplyDuration);
		return productSupplyDuration;

		
	}
	protected ProductSupplyDuration createNewProductSupplyDuration() 
	{
		
		return new ProductSupplyDuration();		
	}
	
	protected void checkParamsForUpdatingProductSupplyDuration(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
		userContext.getChecker().checkVersionOfProductSupplyDuration( productSupplyDurationVersion);
		

		if(ProductSupplyDuration.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfProductSupplyDuration(parseInt(newValueExpr));
		}
		if(ProductSupplyDuration.DURATION_PROPERTY.equals(property)){
			userContext.getChecker().checkDurationOfProductSupplyDuration(parseString(newValueExpr));
		}
		if(ProductSupplyDuration.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfProductSupplyDuration(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);
	
		
	}
	
	
	
	public ProductSupplyDuration clone(RetailscmUserContext userContext, String fromProductSupplyDurationId) throws Exception{
		
		return userContext.getDAOGroup().getProductSupplyDurationDAO().clone(fromProductSupplyDurationId, this.allTokens());
	}
	
	public ProductSupplyDuration internalSaveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception 
	{
		return internalSaveProductSupplyDuration(userContext, productSupplyDuration, allTokens());

	}
	public ProductSupplyDuration internalSaveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(productSupplyDuration){ 
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.
			
			
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, options);
			return productSupplyDuration;
			
		}

	}
	
	public ProductSupplyDuration updateProductSupplyDuration(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);
		
		
		
		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
		if(productSupplyDuration.getVersion() != productSupplyDurationVersion){
			String message = "The target version("+productSupplyDuration.getVersion()+") is not equals to version("+productSupplyDurationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(productSupplyDuration){ 
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.
			
			productSupplyDuration.changeProperty(property, newValueExpr);
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
			return present(userContext,productSupplyDuration, mergedAllTokens(tokensExpr));
			//return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
		}

	}
	
	public ProductSupplyDuration updateProductSupplyDurationProperty(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);
		
		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
		if(productSupplyDuration.getVersion() != productSupplyDurationVersion){
			String message = "The target version("+productSupplyDuration.getVersion()+") is not equals to version("+productSupplyDurationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(productSupplyDuration){ 
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.
			
			productSupplyDuration.changeProperty(property, newValueExpr);
			
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
			return present(userContext,productSupplyDuration, mergedAllTokens(tokensExpr));
			//return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductSupplyDurationTokens tokens(){
		return ProductSupplyDurationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductSupplyDurationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductSupplyDurationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProductSupplyDuration(productSupplyDurationId);
 		userContext.getChecker().checkIdOfSupplierProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);
 		
 	}
 	public ProductSupplyDuration transferToAnotherProduct(RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, productSupplyDurationId,anotherProductId);
 
		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());	
		synchronized(productSupplyDuration){
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplierProduct product = loadSupplierProduct(userContext, anotherProductId, emptyOptions());		
			productSupplyDuration.updateProduct(product);		
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());
			
			return present(userContext,productSupplyDuration, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplierProduct requestCandidateProduct(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplierProduct result = new CandidateSupplierProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("productName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplierProduct> candidateList = userContext.getDAOGroup().getSupplierProductDAO().requestCandidateSupplierProductForProductSupplyDuration(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplierProduct loadSupplierProduct(RetailscmUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplierProductDAO().load(newProductId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String productSupplyDurationId, int productSupplyDurationVersion) throws Exception {
		//deleteInternal(userContext, productSupplyDurationId, productSupplyDurationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String productSupplyDurationId, int productSupplyDurationVersion) throws Exception{
			
		userContext.getDAOGroup().getProductSupplyDurationDAO().delete(productSupplyDurationId, productSupplyDurationVersion);
	}
	
	public ProductSupplyDuration forgetByAll(RetailscmUserContext userContext, String productSupplyDurationId, int productSupplyDurationVersion) throws Exception {
		return forgetByAllInternal(userContext, productSupplyDurationId, productSupplyDurationVersion);		
	}
	protected ProductSupplyDuration forgetByAllInternal(RetailscmUserContext userContext,
			String productSupplyDurationId, int productSupplyDurationVersion) throws Exception{
			
		return userContext.getDAOGroup().getProductSupplyDurationDAO().disconnectFromAll(productSupplyDurationId, productSupplyDurationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductSupplyDurationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProductSupplyDurationDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ProductSupplyDuration newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


