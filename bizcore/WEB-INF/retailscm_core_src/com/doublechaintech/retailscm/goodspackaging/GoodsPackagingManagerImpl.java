
package com.doublechaintech.retailscm.goodspackaging;

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






public class GoodsPackagingManagerImpl extends CustomRetailscmCheckerManager implements GoodsPackagingManager {
	
	private static final String SERVICE_TYPE = "GoodsPackaging";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws GoodsPackagingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new GoodsPackagingManagerException(message);

	}
	
	

 	protected GoodsPackaging saveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, String [] tokensExpr) throws Exception{	
 		//return getGoodsPackagingDAO().save(goodsPackaging, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsPackaging(userContext, goodsPackaging, tokens);
 	}
 	
 	protected GoodsPackaging saveGoodsPackagingDetail(RetailscmUserContext userContext, GoodsPackaging goodsPackaging) throws Exception{	

 		
 		return saveGoodsPackaging(userContext, goodsPackaging, allTokens());
 	}
 	
 	public GoodsPackaging loadGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsPackagingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsPackaging, tokens);
 	}
 	
 	
 	 public GoodsPackaging searchGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsPackagingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsPackaging, tokens);
 	}
 	
 	

 	protected GoodsPackaging present(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsPackaging,tokens);
		
		
		GoodsPackaging  goodsPackagingToPresent = userContext.getDAOGroup().getGoodsPackagingDAO().present(goodsPackaging, tokens);
		
		List<BaseEntity> entityListToNaming = goodsPackagingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getGoodsPackagingDAO().alias(entityListToNaming);
		
		return  goodsPackagingToPresent;
		
		
	}
 
 	
 	
 	public GoodsPackaging loadGoodsPackagingDetail(RetailscmUserContext userContext, String goodsPackagingId) throws Exception{	
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, allTokens());
 		return present(userContext,goodsPackaging, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String goodsPackagingId) throws Exception{	
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, viewTokens());
 		return present(userContext,goodsPackaging, allTokens());
		
 	}
 	protected GoodsPackaging saveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getGoodsPackagingDAO().save(goodsPackaging, tokens);
 	}
 	protected GoodsPackaging loadGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsPackagingManagerException.class);

 
 		return userContext.getDAOGroup().getGoodsPackagingDAO().load(goodsPackagingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens){
		super.addActions(userContext, goodsPackaging, tokens);
		
		addAction(userContext, goodsPackaging, tokens,"@create","createGoodsPackaging","createGoodsPackaging/","main","primary");
		addAction(userContext, goodsPackaging, tokens,"@update","updateGoodsPackaging","updateGoodsPackaging/"+goodsPackaging.getId()+"/","main","primary");
		addAction(userContext, goodsPackaging, tokens,"@copy","cloneGoodsPackaging","cloneGoodsPackaging/"+goodsPackaging.getId()+"/","main","primary");
		
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.addGoods","addGoods","addGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.removeGoods","removeGoods","removeGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.updateGoods","updateGoods","updateGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+goodsPackaging.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsPackaging createGoodsPackaging(RetailscmUserContext userContext,String packageName, String rfid, Date packageTime, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkPackageNameOfGoodsPackaging(packageName);
		userContext.getChecker().checkRfidOfGoodsPackaging(rfid);
		userContext.getChecker().checkPackageTimeOfGoodsPackaging(packageTime);
		userContext.getChecker().checkDescriptionOfGoodsPackaging(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);


		GoodsPackaging goodsPackaging=createNewGoodsPackaging();	

		goodsPackaging.setPackageName(packageName);
		goodsPackaging.setRfid(rfid);
		goodsPackaging.setPackageTime(packageTime);
		goodsPackaging.setDescription(description);

		goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, emptyOptions());
		
		onNewInstanceCreated(userContext, goodsPackaging);
		return goodsPackaging;

		
	}
	protected GoodsPackaging createNewGoodsPackaging() 
	{
		
		return new GoodsPackaging();		
	}
	
	protected void checkParamsForUpdatingGoodsPackaging(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
		userContext.getChecker().checkVersionOfGoodsPackaging( goodsPackagingVersion);
		

		if(GoodsPackaging.PACKAGE_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkPackageNameOfGoodsPackaging(parseString(newValueExpr));
		}
		if(GoodsPackaging.RFID_PROPERTY.equals(property)){
			userContext.getChecker().checkRfidOfGoodsPackaging(parseString(newValueExpr));
		}
		if(GoodsPackaging.PACKAGE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkPackageTimeOfGoodsPackaging(parseDate(newValueExpr));
		}
		if(GoodsPackaging.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfGoodsPackaging(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);
	
		
	}
	
	
	
	public GoodsPackaging clone(RetailscmUserContext userContext, String fromGoodsPackagingId) throws Exception{
		
		return userContext.getDAOGroup().getGoodsPackagingDAO().clone(fromGoodsPackagingId, this.allTokens());
	}
	
	public GoodsPackaging internalSaveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging) throws Exception 
	{
		return internalSaveGoodsPackaging(userContext, goodsPackaging, allTokens());

	}
	public GoodsPackaging internalSaveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(goodsPackaging){ 
			//will be good when the goodsPackaging loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.
			
			
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, options);
			return goodsPackaging;
			
		}

	}
	
	public GoodsPackaging updateGoodsPackaging(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);
		
		
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		if(goodsPackaging.getVersion() != goodsPackagingVersion){
			String message = "The target version("+goodsPackaging.getVersion()+") is not equals to version("+goodsPackagingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsPackaging){ 
			//will be good when the goodsPackaging loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.
			
			goodsPackaging.changeProperty(property, newValueExpr);
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			//return saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
		}

	}
	
	public GoodsPackaging updateGoodsPackagingProperty(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		if(goodsPackaging.getVersion() != goodsPackagingVersion){
			String message = "The target version("+goodsPackaging.getVersion()+") is not equals to version("+goodsPackagingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsPackaging){ 
			//will be good when the goodsPackaging loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.
			
			goodsPackaging.changeProperty(property, newValueExpr);
			
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			//return saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsPackagingTokens tokens(){
		return GoodsPackagingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsPackagingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsPackagingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsPackagingId, int goodsPackagingVersion) throws Exception {
		//deleteInternal(userContext, goodsPackagingId, goodsPackagingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsPackagingId, int goodsPackagingVersion) throws Exception{
			
		userContext.getDAOGroup().getGoodsPackagingDAO().delete(goodsPackagingId, goodsPackagingVersion);
	}
	
	public GoodsPackaging forgetByAll(RetailscmUserContext userContext, String goodsPackagingId, int goodsPackagingVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsPackagingId, goodsPackagingVersion);		
	}
	protected GoodsPackaging forgetByAllInternal(RetailscmUserContext userContext,
			String goodsPackagingId, int goodsPackagingVersion) throws Exception{
			
		return userContext.getDAOGroup().getGoodsPackagingDAO().disconnectFromAll(goodsPackagingId, goodsPackagingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsPackagingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getGoodsPackagingDAO().deleteAll();
	}


	//disconnect GoodsPackaging with sku in Goods
	protected GoodsPackaging breakWithGoodsBySku(RetailscmUserContext userContext, String goodsPackagingId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithSku(goodsPackaging, skuId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with receiving_space in Goods
	protected GoodsPackaging breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String goodsPackagingId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithReceivingSpace(goodsPackaging, receivingSpaceId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with goods_allocation in Goods
	protected GoodsPackaging breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String goodsPackagingId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithGoodsAllocation(goodsPackaging, goodsAllocationId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with smart_pallet in Goods
	protected GoodsPackaging breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String goodsPackagingId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithSmartPallet(goodsPackaging, smartPalletId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with shipping_space in Goods
	protected GoodsPackaging breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String goodsPackagingId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithShippingSpace(goodsPackaging, shippingSpaceId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with transport_task in Goods
	protected GoodsPackaging breakWithGoodsByTransportTask(RetailscmUserContext userContext, String goodsPackagingId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithTransportTask(goodsPackaging, transportTaskId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with retail_store in Goods
	protected GoodsPackaging breakWithGoodsByRetailStore(RetailscmUserContext userContext, String goodsPackagingId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithRetailStore(goodsPackaging, retailStoreId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with biz_order in Goods
	protected GoodsPackaging breakWithGoodsByBizOrder(RetailscmUserContext userContext, String goodsPackagingId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithBizOrder(goodsPackaging, bizOrderId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with retail_store_order in Goods
	protected GoodsPackaging breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String goodsPackagingId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsListWithRetailStoreOrder(goodsPackaging, retailStoreOrderId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);

		
		userContext.getChecker().checkNameOfGoods(name);
		
		userContext.getChecker().checkRfidOfGoods(rfid);
		
		userContext.getChecker().checkUomOfGoods(uom);
		
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
		
		userContext.getChecker().checkSkuIdOfGoods(skuId);
		
		userContext.getChecker().checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		userContext.getChecker().checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		userContext.getChecker().checkSmartPalletIdOfGoods(smartPalletId);
		
		userContext.getChecker().checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		userContext.getChecker().checkTransportTaskIdOfGoods(transportTaskId);
		
		userContext.getChecker().checkRetailStoreIdOfGoods(retailStoreId);
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);

	
	}
	public  GoodsPackaging addGoods(RetailscmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,goodsPackagingId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.addGoods( goods );		
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String goodsPackagingId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);
		
	}
	public  GoodsPackaging updateGoodsProperties(RetailscmUserContext userContext, String goodsPackagingId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,goodsPackagingId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		GoodsPackaging goodsPackagingToUpdate = loadGoodsPackaging(userContext, goodsPackagingId, options);
		
		if(goodsPackagingToUpdate.getGoodsList().isEmpty()){
			throw new GoodsPackagingManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = goodsPackagingToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,goodsPackagingId,name, code, used,tokensExpr);
		GoodsPackaging goodsPackaging = saveGoodsPackaging(userContext, goodsPackagingToUpdate, tokens().withGoodsList().done());
		synchronized(goodsPackaging){ 
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
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
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String goodsPackagingId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);
		
	}
	public  GoodsPackaging removeGoodsList(RetailscmUserContext userContext, String goodsPackagingId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, goodsPackagingId,  goodsIds, tokensExpr);
			
			
			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
			synchronized(goodsPackaging){ 
				//Will be good when the goodsPackaging loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGoodsPackagingDAO().planToRemoveGoodsList(goodsPackaging, goodsIds, allTokens());
				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, goodsPackaging.getGoodsList());
				return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoodsPackaging( goodsPackagingId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);
	
	}
	public  GoodsPackaging removeGoods(RetailscmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,goodsPackagingId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.removeGoods( goods );		
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoodsPackaging( goodsPackagingId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);
	
	}
	public  GoodsPackaging copyGoodsFrom(RetailscmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,goodsPackagingId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			goodsPackaging.copyGoodsFrom( goods );		
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)goodsPackaging.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGoodsPackaging(goodsPackagingId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsPackagingManagerException.class);
	
	}
	
	public  GoodsPackaging updateGoods(RetailscmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, goodsPackagingId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, loadTokens);
		
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsPackaging.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = goodsPackaging.findTheGoods(goodsIndex);
			if(goods == null){
				throw new GoodsPackagingManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsPackaging newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


