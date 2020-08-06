
package com.doublechaintech.retailscm.sku;

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



import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.product.CandidateProduct;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class SkuManagerImpl extends CustomRetailscmCheckerManager implements SkuManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = SkuTokens.start().withTokenFromListName(listName).done();
		Sku  sku = (Sku) this.loadSku(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = sku.collectRefercencesFromLists();
		skuDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, sku, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SkuGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "Sku";
	@Override
	public SkuDAO daoOf(RetailscmUserContext userContext) {
		return skuDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkuManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	
 	 public Sku searchSku(RetailscmUserContext userContext, String skuId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkuManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	

 	protected Sku present(RetailscmUserContext userContext, Sku sku, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,sku,tokens);
		
		
		Sku  skuToPresent = skuDaoOf(userContext).present(sku, tokens);
		
		List<BaseEntity> entityListToNaming = skuToPresent.collectRefercencesFromLists();
		skuDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,sku,tokens);
		
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
 		return skuDaoOf(userContext).save(sku, tokens);
 	}
 	protected Sku loadSku(RetailscmUserContext userContext, String skuId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkuManagerException.class);

 
 		return skuDaoOf(userContext).load(skuId, tokens);
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
	
 	
 	
 
 	
 	

	public Sku createSku(RetailscmUserContext userContext, String name,String size,String productId,String barcode,String packageType,String netContent,BigDecimal price,String picture) throws Exception
	//public Sku createSku(RetailscmUserContext userContext,String name, String size, String productId, String barcode, String packageType, String netContent, BigDecimal price, String picture) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfSku(name);
		checkerOf(userContext).checkSizeOfSku(size);
		checkerOf(userContext).checkBarcodeOfSku(barcode);
		checkerOf(userContext).checkPackageTypeOfSku(packageType);
		checkerOf(userContext).checkNetContentOfSku(netContent);
		checkerOf(userContext).checkPriceOfSku(price);
		checkerOf(userContext).checkPictureOfSku(picture);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkVersionOfSku( skuVersion);
		

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
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);


	}



	public Sku clone(RetailscmUserContext userContext, String fromSkuId) throws Exception{

		return skuDaoOf(userContext).clone(fromSkuId, this.allTokens());
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
			if (sku.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkuTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(RetailscmUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSku(skuId);
 		checkerOf(userContext).checkIdOfProduct(anotherProductId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

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
		SmartList<Product> candidateList = productDaoOf(userContext).requestCandidateProductForSku(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Product loadProduct(RetailscmUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{

 		return productDaoOf(userContext).load(newProductId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String skuId, int skuVersion) throws Exception {
		//deleteInternal(userContext, skuId, skuVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String skuId, int skuVersion) throws Exception{

		skuDaoOf(userContext).delete(skuId, skuVersion);
	}

	public Sku forgetByAll(RetailscmUserContext userContext, String skuId, int skuVersion) throws Exception {
		return forgetByAllInternal(userContext, skuId, skuVersion);
	}
	protected Sku forgetByAllInternal(RetailscmUserContext userContext,
			String skuId, int skuVersion) throws Exception{

		return skuDaoOf(userContext).disconnectFromAll(skuId, skuVersion);
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
		return skuDaoOf(userContext).deleteAll();
	}


	//disconnect Sku with receiving_space in Goods
	protected Sku breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String skuId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Sku sku = loadSku(userContext, skuId, allTokens());

			synchronized(sku){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				skuDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(sku, receivingSpaceId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithGoodsAllocation(sku, goodsAllocationId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(sku, smartPalletId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithShippingSpace(sku, shippingSpaceId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithTransportTask(sku, transportTaskId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithRetailStore(sku, retailStoreId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithBizOrder(sku, bizOrderId, this.emptyOptions());

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

				skuDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(sku, retailStoreOrderId, this.emptyOptions());

				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				return sku;
			}
	}






	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSku(skuId);

		
		checkerOf(userContext).checkNameOfGoods(name);
		
		checkerOf(userContext).checkRfidOfGoods(rfid);
		
		checkerOf(userContext).checkUomOfGoods(uom);
		
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);
		
		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);
		
		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);
		
		checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);
		
		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);


	}
	public  Sku addGoods(RetailscmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,skuId,name, rfid, uom, maxPackage, expireTime, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);

		Sku sku = loadSku(userContext, skuId, emptyOptions());
		synchronized(sku){
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			sku.addGoods( goods );
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, goods);
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String skuId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

	}
	public  Sku updateGoodsProperties(RetailscmUserContext userContext, String skuId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,skuId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, tokens().is(), id).done();

		Sku skuToUpdate = loadSku(userContext, skuId, options);

		if(skuToUpdate.getGoodsList().isEmpty()){
			throw new SkuManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = skuToUpdate.getGoodsList().first();
		beforeUpdateGoodsProperties(userContext,item, skuId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);
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

	protected  void beforeUpdateGoodsProperties(RetailscmUserContext userContext, Goods item, String skuId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfSku(skuId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

	}
	public  Sku removeGoodsList(RetailscmUserContext userContext, String skuId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, skuId,  goodsIds, tokensExpr);


			Sku sku = loadSku(userContext, skuId, allTokens());
			synchronized(sku){
				//Will be good when the sku loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				skuDaoOf(userContext).planToRemoveGoodsList(sku, goodsIds, allTokens());
				sku = saveSku(userContext, sku, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, sku.getGoodsList());
				return present(userContext,sku, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String skuId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSku( skuId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

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
		
		checkerOf(userContext).checkIdOfSku( skuId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

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
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, (Goods)sku.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);


		if(Goods.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			checkerOf(userContext).checkRfidOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			checkerOf(userContext).checkUomOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMaxPackageOfGoods(parseInt(newValueExpr));
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkExpireTimeOfGoods(parseDate(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

	}

	public  Sku updateGoods(RetailscmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, skuId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, tokens().equals(), goodsId).done();



		Sku sku = loadSku(userContext, skuId, loadTokens);

		synchronized(sku){
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//sku.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIdVersionKey = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = sku.findTheGoods(goodsIdVersionKey);
			if(goods == null){
				throw new SkuManagerException(goodsId+" is NOT FOUND" );
			}

			beforeUpdateGoods(userContext, goods, skuId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
			goods.changeProperty(property, newValueExpr);
			
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoods(RetailscmUserContext userContext, Goods existed, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Sku newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    skuDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Sku newSku = this.createSku(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSku
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Sku.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Sku> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Product> productList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Product.class);
		userContext.getDAOGroup().enhanceList(productList, Product.class);


    }
	
	public Object listByProduct(RetailscmUserContext userContext,String productId) throws Exception {
		return listPageByProduct(userContext, productId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProduct(RetailscmUserContext userContext,String productId, int start, int count) throws Exception {
		SmartList<Sku> list = skuDaoOf(userContext).findSkuByProduct(productId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Sku.class);
		page.setContainerObject(Product.withId(productId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("SKU列表");
		page.setRequestName("listByProduct");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("product");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProduct/%s/",  getBeanName(), productId)));

		page.assemblerContent(userContext, "listByProduct");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String skuId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getSkuDetailScope().clone();
		Sku merchantObj = (Sku) this.view(userContext, skuId);
    String merchantObjId = skuId;
    String linkToUrl =	"skuManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "SKU"+"详情";
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
				MapUtil.put("id", "3-size")
				    .put("fieldName", "size")
				    .put("label", "大小")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("size", merchantObj.getSize());

		propList.add(
				MapUtil.put("id", "4-product")
				    .put("fieldName", "product")
				    .put("label", "产品")
				    .put("type", "auto")
				    .put("linkToUrl", "productManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"origin\",\"imageUrl\":\"picture\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("product", merchantObj.getProduct());

		propList.add(
				MapUtil.put("id", "5-barcode")
				    .put("fieldName", "barcode")
				    .put("label", "条码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("barcode", merchantObj.getBarcode());

		propList.add(
				MapUtil.put("id", "6-packageType")
				    .put("fieldName", "packageType")
				    .put("label", "包装类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("packageType", merchantObj.getPackageType());

		propList.add(
				MapUtil.put("id", "7-netContent")
				    .put("fieldName", "netContent")
				    .put("label", "净含量")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("netContent", merchantObj.getNetContent());

		propList.add(
				MapUtil.put("id", "8-price")
				    .put("fieldName", "price")
				    .put("label", "价格")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("price", merchantObj.getPrice());

		propList.add(
				MapUtil.put("id", "9-picture")
				    .put("fieldName", "picture")
				    .put("label", "图片")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("picture", merchantObj.getPicture());

		//处理 sectionList

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listBySku/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));
		vscope.field("goodsListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Goods.class.getName(), null));

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


