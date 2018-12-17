
package com.doublechaintech.retailscm.sku;

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

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.product.CandidateProduct;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodspackaging.GoodsPackaging;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class SkuManagerImpl extends CustomRetailscmCheckerManager implements SkuManager {
	
	private static final String SERVICE_TYPE = "Sku";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SkuManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SkuManagerException(message);

	}
	
	

 	protected Sku saveSku(RetailscmUserContext userContext, Sku sku, String [] tokensExpr) throws Exception{	
 		//return getSkuDAO().save(sku, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSku(userContext, sku, tokens);
 	}
 	
 	protected Sku saveSkuDetail(RetailscmUserContext userContext, Sku sku) throws Exception{	

 		
 		return saveSku(userContext, sku, allTokens());
 	}
 	
 	public Sku loadSku(RetailscmUserContext userContext, String skuId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	
 	 public Sku searchSku(RetailscmUserContext userContext, String skuId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	

 	protected Sku present(RetailscmUserContext userContext, Sku sku, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,sku,tokens);
		
		
		Sku  skuToPresent = userContext.getDAOGroup().getSkuDAO().present(sku, tokens);
		
		List<BaseEntity> entityListToNaming = skuToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSkuDAO().alias(entityListToNaming);
		
		return  skuToPresent;
		
		
	}
 
 	
 	
 	public Sku loadSkuDetail(RetailscmUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, allTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, viewTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	protected Sku saveSku(RetailscmUserContext userContext, Sku sku, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSkuDAO().save(sku, tokens);
 	}
 	protected Sku loadSku(RetailscmUserContext userContext, String skuId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 
 		return userContext.getDAOGroup().getSkuDAO().load(skuId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Sku sku, Map<String, Object> tokens){
		super.addActions(userContext, sku, tokens);
		
		addAction(userContext, sku, tokens,"@create","createSku","createSku/","main","primary");
		addAction(userContext, sku, tokens,"@update","updateSku","updateSku/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"@copy","cloneSku","cloneSku/"+sku.getId()+"/","main","primary");
		
		addAction(userContext, sku, tokens,"sku.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"sku.addGoods","addGoods","addGoods/"+sku.getId()+"/","goodsList","primary");
		addAction(userContext, sku, tokens,"sku.removeGoods","removeGoods","removeGoods/"+sku.getId()+"/","goodsList","primary");
		addAction(userContext, sku, tokens,"sku.updateGoods","updateGoods","updateGoods/"+sku.getId()+"/","goodsList","primary");
		addAction(userContext, sku, tokens,"sku.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+sku.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Sku sku, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Sku createSku(RetailscmUserContext userContext,String name, String size, String productId, String barcode, String packageType, String netContent, BigDecimal price, String picture) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfSku(name);
		userContext.getChecker().checkSizeOfSku(size);
		userContext.getChecker().checkBarcodeOfSku(barcode);
		userContext.getChecker().checkPackageTypeOfSku(packageType);
		userContext.getChecker().checkNetContentOfSku(netContent);
		userContext.getChecker().checkPriceOfSku(price);
		userContext.getChecker().checkPictureOfSku(picture);
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);


		Sku sku=createNewSku();	

		sku.setName(name);
		sku.setSize(size);
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		sku.setProduct(product);
		
		
		sku.setBarcode(barcode);
		sku.setPackageType(packageType);
		sku.setNetContent(netContent);
		sku.setPrice(price);
		sku.setPicture(picture);

		sku = saveSku(userContext, sku, emptyOptions());
		
		onNewInstanceCreated(userContext, sku);
		return sku;

		
	}
	protected Sku createNewSku() 
	{
		
		return new Sku();		
	}
	
	protected void checkParamsForUpdatingSku(RetailscmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku( skuVersion);
		

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
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
	
		
	}
	
	
	
	public Sku clone(RetailscmUserContext userContext, String fromSkuId) throws Exception{
		
		return userContext.getDAOGroup().getSkuDAO().clone(fromSkuId, this.allTokens());
	}
	
	public Sku internalSaveSku(RetailscmUserContext userContext, Sku sku) throws Exception 
	{
		return internalSaveSku(userContext, sku, allTokens());

	}
	public Sku internalSaveSku(RetailscmUserContext userContext, Sku sku, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			
			sku = saveSku(userContext, sku, options);
			return sku;
			
		}

	}
	
	public Sku updateSku(RetailscmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changeProperty(property, newValueExpr);
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	
	public Sku updateSkuProperty(RetailscmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changeProperty(property, newValueExpr);
			
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SkuTokens tokens(){
		return SkuTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkuTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkuTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(RetailscmUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSku(skuId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
 		
 	}
 	public Sku transferToAnotherProduct(RetailscmUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, skuId,anotherProductId);
 
		Sku sku = loadSku(userContext, skuId, allTokens());	
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			sku.updateProduct(product);		
			sku = saveSku(userContext, sku, emptyOptions());
			
			return present(userContext,sku, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProduct requestCandidateProduct(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForSku(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Product loadProduct(RetailscmUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProductDAO().load(newProductId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String skuId, int skuVersion) throws Exception {
		//deleteInternal(userContext, skuId, skuVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String skuId, int skuVersion) throws Exception{
			
		userContext.getDAOGroup().getSkuDAO().delete(skuId, skuVersion);
	}
	
	public Sku forgetByAll(RetailscmUserContext userContext, String skuId, int skuVersion) throws Exception {
		return forgetByAllInternal(userContext, skuId, skuVersion);		
	}
	protected Sku forgetByAllInternal(RetailscmUserContext userContext,
			String skuId, int skuVersion) throws Exception{
			
		return userContext.getDAOGroup().getSkuDAO().disconnectFromAll(skuId, skuVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkuManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSkuDAO().deleteAll();
	}


	//disconnect Sku with receiving_space in Goods
	protected Sku breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String skuId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithReceivingSpace(sku, receivingSpaceId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with goods_allocation in Goods
	protected Sku breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String skuId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithGoodsAllocation(sku, goodsAllocationId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with smart_pallet in Goods
	protected Sku breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String skuId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithSmartPallet(sku, smartPalletId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with shipping_space in Goods
	protected Sku breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String skuId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithShippingSpace(sku, shippingSpaceId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with transport_task in Goods
	protected Sku breakWithGoodsByTransportTask(RetailscmUserContext userContext, String skuId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithTransportTask(sku, transportTaskId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with retail_store in Goods
	protected Sku breakWithGoodsByRetailStore(RetailscmUserContext userContext, String skuId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithRetailStore(sku, retailStoreId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with biz_order in Goods
	protected Sku breakWithGoodsByBizOrder(RetailscmUserContext userContext, String skuId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithBizOrder(sku, bizOrderId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	//disconnect Sku with retail_store_order in Goods
	protected Sku breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String skuId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsListWithRetailStoreOrder(sku, retailStoreOrderId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSku(skuId);

		
		userContext.getChecker().checkNameOfGoods(name);
		
		userContext.getChecker().checkRfidOfGoods(rfid);
		
		userContext.getChecker().checkUomOfGoods(uom);
		
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
		
		userContext.getChecker().checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		userContext.getChecker().checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		userContext.getChecker().checkSmartPalletIdOfGoods(smartPalletId);
		
		userContext.getChecker().checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		userContext.getChecker().checkTransportTaskIdOfGoods(transportTaskId);
		
		userContext.getChecker().checkRetailStoreIdOfGoods(retailStoreId);
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);

	
	}
	public  Sku addGoods(RetailscmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,skuId,name, rfid, uom, maxPackage, expireTime, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			sku.addGoods( goods );		
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String skuId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
		
	}
	public  Sku updateGoodsProperties(RetailscmUserContext userContext, String skuId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,skuId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		Sku skuToUpdate = loadSku(userContext, skuId, options);
		
		if(skuToUpdate.getGoodsList().isEmpty()){
			throw new SkuManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = skuToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,skuId,name, code, used,tokensExpr);
		Sku sku = saveSku(userContext, skuToUpdate, tokens().withGoodsList().done());
		synchronized(sku){ 
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);		
		goods.setCurrentStatus("INIT");
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String skuId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSku(skuId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
		
	}
	public  Sku removeGoodsList(RetailscmUserContext userContext, String skuId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, skuId,  goodsIds, tokensExpr);
			
			
			Sku sku = loadSku(userContext, skuId, allTokens());
			synchronized(sku){ 
				//Will be good when the sku loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSkuDAO().planToRemoveGoodsList(sku, goodsIds, allTokens());
				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, sku.getGoodsList());
				return present(userContext,sku, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSku( skuId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
	
	}
	public  Sku removeGoods(RetailscmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,skuId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		Sku sku = loadSku(userContext, skuId, allTokens());
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			sku.removeGoods( goods );		
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSku( skuId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
	
	}
	public  Sku copyGoodsFrom(RetailscmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,skuId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		Sku sku = loadSku(userContext, skuId, allTokens());
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			sku.copyGoodsFrom( goods );		
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)sku.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		

		if(Goods.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			userContext.getChecker().checkRfidOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			userContext.getChecker().checkUomOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMaxPackageOfGoods(parseInt(newValueExpr));
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkExpireTimeOfGoods(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
	
	}
	
	public  Sku updateGoods(RetailscmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, skuId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		Sku sku = loadSku(userContext, skuId, loadTokens);
		
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//sku.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = sku.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SkuManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  Sku associateGoodsListToNewPackaging(RetailscmUserContext userContext, String skuId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		Sku sku = loadSku(userContext, skuId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: sku.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveSku(userContext, sku);
	}
	*/
	
	public  Sku associateGoodsListToPackaging(RetailscmUserContext userContext, String skuId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		Sku sku = loadSku(userContext, skuId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: sku.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveSku(userContext, sku);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, Sku newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


