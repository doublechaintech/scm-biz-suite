
package com.doublechaintech.retailscm.goodsallocation;

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
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.goodsshelf.CandidateGoodsShelf;

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






public class GoodsAllocationManagerImpl extends CustomRetailscmCheckerManager implements GoodsAllocationManager {
	
	private static final String SERVICE_TYPE = "GoodsAllocation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws GoodsAllocationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new GoodsAllocationManagerException(message);

	}
	
	

 	protected GoodsAllocation saveGoodsAllocation(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, String [] tokensExpr) throws Exception{	
 		//return getGoodsAllocationDAO().save(goodsAllocation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsAllocation(userContext, goodsAllocation, tokens);
 	}
 	
 	protected GoodsAllocation saveGoodsAllocationDetail(RetailscmUserContext userContext, GoodsAllocation goodsAllocation) throws Exception{	

 		
 		return saveGoodsAllocation(userContext, goodsAllocation, allTokens());
 	}
 	
 	public GoodsAllocation loadGoodsAllocation(RetailscmUserContext userContext, String goodsAllocationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsAllocationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsAllocation, tokens);
 	}
 	
 	
 	 public GoodsAllocation searchGoodsAllocation(RetailscmUserContext userContext, String goodsAllocationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsAllocationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsAllocation, tokens);
 	}
 	
 	

 	protected GoodsAllocation present(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsAllocation,tokens);
		
		
		GoodsAllocation  goodsAllocationToPresent = userContext.getDAOGroup().getGoodsAllocationDAO().present(goodsAllocation, tokens);
		
		List<BaseEntity> entityListToNaming = goodsAllocationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getGoodsAllocationDAO().alias(entityListToNaming);
		
		return  goodsAllocationToPresent;
		
		
	}
 
 	
 	
 	public GoodsAllocation loadGoodsAllocationDetail(RetailscmUserContext userContext, String goodsAllocationId) throws Exception{	
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, allTokens());
 		return present(userContext,goodsAllocation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String goodsAllocationId) throws Exception{	
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, viewTokens());
 		return present(userContext,goodsAllocation, allTokens());
		
 	}
 	protected GoodsAllocation saveGoodsAllocation(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getGoodsAllocationDAO().save(goodsAllocation, tokens);
 	}
 	protected GoodsAllocation loadGoodsAllocation(RetailscmUserContext userContext, String goodsAllocationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsAllocationManagerException.class);

 
 		return userContext.getDAOGroup().getGoodsAllocationDAO().load(goodsAllocationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens){
		super.addActions(userContext, goodsAllocation, tokens);
		
		addAction(userContext, goodsAllocation, tokens,"@create","createGoodsAllocation","createGoodsAllocation/","main","primary");
		addAction(userContext, goodsAllocation, tokens,"@update","updateGoodsAllocation","updateGoodsAllocation/"+goodsAllocation.getId()+"/","main","primary");
		addAction(userContext, goodsAllocation, tokens,"@copy","cloneGoodsAllocation","cloneGoodsAllocation/"+goodsAllocation.getId()+"/","main","primary");
		
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.transfer_to_goods_shelf","transferToAnotherGoodsShelf","transferToAnotherGoodsShelf/"+goodsAllocation.getId()+"/","main","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.addGoods","addGoods","addGoods/"+goodsAllocation.getId()+"/","goodsList","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.removeGoods","removeGoods","removeGoods/"+goodsAllocation.getId()+"/","goodsList","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.updateGoods","updateGoods","updateGoods/"+goodsAllocation.getId()+"/","goodsList","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+goodsAllocation.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsAllocation createGoodsAllocation(RetailscmUserContext userContext,String location, BigDecimal latitude, BigDecimal longitude, String goodsShelfId) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfGoodsAllocation(location);
		userContext.getChecker().checkLatitudeOfGoodsAllocation(latitude);
		userContext.getChecker().checkLongitudeOfGoodsAllocation(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);


		GoodsAllocation goodsAllocation=createNewGoodsAllocation();	

		goodsAllocation.setLocation(location);
		goodsAllocation.setLatitude(latitude);
		goodsAllocation.setLongitude(longitude);
			
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId,emptyOptions());
		goodsAllocation.setGoodsShelf(goodsShelf);
		
		

		goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, emptyOptions());
		
		onNewInstanceCreated(userContext, goodsAllocation);
		return goodsAllocation;

		
	}
	protected GoodsAllocation createNewGoodsAllocation() 
	{
		
		return new GoodsAllocation();		
	}
	
	protected void checkParamsForUpdatingGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
		userContext.getChecker().checkVersionOfGoodsAllocation( goodsAllocationVersion);
		

		if(GoodsAllocation.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfGoodsAllocation(parseString(newValueExpr));
		}
		if(GoodsAllocation.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfGoodsAllocation(parseBigDecimal(newValueExpr));
		}
		if(GoodsAllocation.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfGoodsAllocation(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
	
		
	}
	
	
	
	public GoodsAllocation clone(RetailscmUserContext userContext, String fromGoodsAllocationId) throws Exception{
		
		return userContext.getDAOGroup().getGoodsAllocationDAO().clone(fromGoodsAllocationId, this.allTokens());
	}
	
	public GoodsAllocation internalSaveGoodsAllocation(RetailscmUserContext userContext, GoodsAllocation goodsAllocation) throws Exception 
	{
		return internalSaveGoodsAllocation(userContext, goodsAllocation, allTokens());

	}
	public GoodsAllocation internalSaveGoodsAllocation(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingGoodsAllocation(userContext, goodsAllocationId, goodsAllocationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(goodsAllocation){ 
			//will be good when the goodsAllocation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsAllocation.
			
			
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, options);
			return goodsAllocation;
			
		}

	}
	
	public GoodsAllocation updateGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsAllocation(userContext, goodsAllocationId, goodsAllocationVersion, property, newValueExpr, tokensExpr);
		
		
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		if(goodsAllocation.getVersion() != goodsAllocationVersion){
			String message = "The target version("+goodsAllocation.getVersion()+") is not equals to version("+goodsAllocationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsAllocation){ 
			//will be good when the goodsAllocation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsAllocation.
			
			goodsAllocation.changeProperty(property, newValueExpr);
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
			//return saveGoodsAllocation(userContext, goodsAllocation, tokens().done());
		}

	}
	
	public GoodsAllocation updateGoodsAllocationProperty(RetailscmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsAllocation(userContext, goodsAllocationId, goodsAllocationVersion, property, newValueExpr, tokensExpr);
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		if(goodsAllocation.getVersion() != goodsAllocationVersion){
			String message = "The target version("+goodsAllocation.getVersion()+") is not equals to version("+goodsAllocationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsAllocation){ 
			//will be good when the goodsAllocation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsAllocation.
			
			goodsAllocation.changeProperty(property, newValueExpr);
			
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
			//return saveGoodsAllocation(userContext, goodsAllocation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsAllocationTokens tokens(){
		return GoodsAllocationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsAllocationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsAllocationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherGoodsShelf(RetailscmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
 		userContext.getChecker().checkIdOfGoodsShelf(anotherGoodsShelfId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
 		
 	}
 	public GoodsAllocation transferToAnotherGoodsShelf(RetailscmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoodsShelf(userContext, goodsAllocationId,anotherGoodsShelfId);
 
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());	
		synchronized(goodsAllocation){
			//will be good when the goodsAllocation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelf goodsShelf = loadGoodsShelf(userContext, anotherGoodsShelfId, emptyOptions());		
			goodsAllocation.updateGoodsShelf(goodsShelf);		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, emptyOptions());
			
			return present(userContext,goodsAllocation, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGoodsShelf requestCandidateGoodsShelf(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsShelf result = new CandidateGoodsShelf();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsShelf> candidateList = userContext.getDAOGroup().getGoodsShelfDAO().requestCandidateGoodsShelfForGoodsAllocation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsShelf loadGoodsShelf(RetailscmUserContext userContext, String newGoodsShelfId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsShelfDAO().load(newGoodsShelfId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsAllocationId, int goodsAllocationVersion) throws Exception {
		//deleteInternal(userContext, goodsAllocationId, goodsAllocationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsAllocationId, int goodsAllocationVersion) throws Exception{
			
		userContext.getDAOGroup().getGoodsAllocationDAO().delete(goodsAllocationId, goodsAllocationVersion);
	}
	
	public GoodsAllocation forgetByAll(RetailscmUserContext userContext, String goodsAllocationId, int goodsAllocationVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsAllocationId, goodsAllocationVersion);		
	}
	protected GoodsAllocation forgetByAllInternal(RetailscmUserContext userContext,
			String goodsAllocationId, int goodsAllocationVersion) throws Exception{
			
		return userContext.getDAOGroup().getGoodsAllocationDAO().disconnectFromAll(goodsAllocationId, goodsAllocationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsAllocationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getGoodsAllocationDAO().deleteAll();
	}


	//disconnect GoodsAllocation with sku in Goods
	protected GoodsAllocation breakWithGoodsBySku(RetailscmUserContext userContext, String goodsAllocationId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithSku(goodsAllocation, skuId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with receiving_space in Goods
	protected GoodsAllocation breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String goodsAllocationId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithReceivingSpace(goodsAllocation, receivingSpaceId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with smart_pallet in Goods
	protected GoodsAllocation breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String goodsAllocationId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithSmartPallet(goodsAllocation, smartPalletId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with shipping_space in Goods
	protected GoodsAllocation breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String goodsAllocationId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithShippingSpace(goodsAllocation, shippingSpaceId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with transport_task in Goods
	protected GoodsAllocation breakWithGoodsByTransportTask(RetailscmUserContext userContext, String goodsAllocationId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithTransportTask(goodsAllocation, transportTaskId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with retail_store in Goods
	protected GoodsAllocation breakWithGoodsByRetailStore(RetailscmUserContext userContext, String goodsAllocationId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithRetailStore(goodsAllocation, retailStoreId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with biz_order in Goods
	protected GoodsAllocation breakWithGoodsByBizOrder(RetailscmUserContext userContext, String goodsAllocationId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithBizOrder(goodsAllocation, bizOrderId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	//disconnect GoodsAllocation with retail_store_order in Goods
	protected GoodsAllocation breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String goodsAllocationId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsListWithRetailStoreOrder(goodsAllocation, retailStoreOrderId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);

		
		userContext.getChecker().checkNameOfGoods(name);
		
		userContext.getChecker().checkRfidOfGoods(rfid);
		
		userContext.getChecker().checkUomOfGoods(uom);
		
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
		
		userContext.getChecker().checkSkuIdOfGoods(skuId);
		
		userContext.getChecker().checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		userContext.getChecker().checkSmartPalletIdOfGoods(smartPalletId);
		
		userContext.getChecker().checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		userContext.getChecker().checkTransportTaskIdOfGoods(transportTaskId);
		
		userContext.getChecker().checkRetailStoreIdOfGoods(retailStoreId);
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

	
	}
	public  GoodsAllocation addGoods(RetailscmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,goodsAllocationId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsAllocation.addGoods( goods );		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String goodsAllocationId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
		
	}
	public  GoodsAllocation updateGoodsProperties(RetailscmUserContext userContext, String goodsAllocationId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,goodsAllocationId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		GoodsAllocation goodsAllocationToUpdate = loadGoodsAllocation(userContext, goodsAllocationId, options);
		
		if(goodsAllocationToUpdate.getGoodsList().isEmpty()){
			throw new GoodsAllocationManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = goodsAllocationToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,goodsAllocationId,name, code, used,tokensExpr);
		GoodsAllocation goodsAllocation = saveGoodsAllocation(userContext, goodsAllocationToUpdate, tokens().withGoodsList().done());
		synchronized(goodsAllocation){ 
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String goodsAllocationId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
		
	}
	public  GoodsAllocation removeGoodsList(RetailscmUserContext userContext, String goodsAllocationId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, goodsAllocationId,  goodsIds, tokensExpr);
			
			
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
			synchronized(goodsAllocation){ 
				//Will be good when the goodsAllocation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGoodsAllocationDAO().planToRemoveGoodsList(goodsAllocation, goodsIds, allTokens());
				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, goodsAllocation.getGoodsList());
				return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoodsAllocation( goodsAllocationId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
	
	}
	public  GoodsAllocation removeGoods(RetailscmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,goodsAllocationId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsAllocation.removeGoods( goods );		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoodsAllocation( goodsAllocationId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
	
	}
	public  GoodsAllocation copyGoodsFrom(RetailscmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,goodsAllocationId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			goodsAllocation.copyGoodsFrom( goods );		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)goodsAllocation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGoodsAllocation(goodsAllocationId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsAllocationManagerException.class);
	
	}
	
	public  GoodsAllocation updateGoods(RetailscmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, goodsAllocationId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, loadTokens);
		
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsAllocation.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = goodsAllocation.findTheGoods(goodsIndex);
			if(goods == null){
				throw new GoodsAllocationManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  GoodsAllocation associateGoodsListToNewPackaging(RetailscmUserContext userContext, String goodsAllocationId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: goodsAllocation.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveGoodsAllocation(userContext, goodsAllocation);
	}
	*/
	
	public  GoodsAllocation associateGoodsListToPackaging(RetailscmUserContext userContext, String goodsAllocationId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: goodsAllocation.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveGoodsAllocation(userContext, goodsAllocation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsAllocation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


