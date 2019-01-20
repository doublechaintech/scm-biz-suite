
package com.doublechaintech.retailscm.receivingspace;

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
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;

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






public class ReceivingSpaceManagerImpl extends CustomRetailscmCheckerManager implements ReceivingSpaceManager {
	
	private static final String SERVICE_TYPE = "ReceivingSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ReceivingSpaceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ReceivingSpaceManagerException(message);

	}
	
	

 	protected ReceivingSpace saveReceivingSpace(RetailscmUserContext userContext, ReceivingSpace receivingSpace, String [] tokensExpr) throws Exception{	
 		//return getReceivingSpaceDAO().save(receivingSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveReceivingSpace(userContext, receivingSpace, tokens);
 	}
 	
 	protected ReceivingSpace saveReceivingSpaceDetail(RetailscmUserContext userContext, ReceivingSpace receivingSpace) throws Exception{	

 		
 		return saveReceivingSpace(userContext, receivingSpace, allTokens());
 	}
 	
 	public ReceivingSpace loadReceivingSpace(RetailscmUserContext userContext, String receivingSpaceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( ReceivingSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,receivingSpace, tokens);
 	}
 	
 	
 	 public ReceivingSpace searchReceivingSpace(RetailscmUserContext userContext, String receivingSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( ReceivingSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,receivingSpace, tokens);
 	}
 	
 	

 	protected ReceivingSpace present(RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,receivingSpace,tokens);
		
		
		ReceivingSpace  receivingSpaceToPresent = userContext.getDAOGroup().getReceivingSpaceDAO().present(receivingSpace, tokens);
		
		List<BaseEntity> entityListToNaming = receivingSpaceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getReceivingSpaceDAO().alias(entityListToNaming);
		
		return  receivingSpaceToPresent;
		
		
	}
 
 	
 	
 	public ReceivingSpace loadReceivingSpaceDetail(RetailscmUserContext userContext, String receivingSpaceId) throws Exception{	
 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, allTokens());
 		return present(userContext,receivingSpace, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String receivingSpaceId) throws Exception{	
 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, viewTokens());
 		return present(userContext,receivingSpace, allTokens());
		
 	}
 	protected ReceivingSpace saveReceivingSpace(RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getReceivingSpaceDAO().save(receivingSpace, tokens);
 	}
 	protected ReceivingSpace loadReceivingSpace(RetailscmUserContext userContext, String receivingSpaceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( ReceivingSpaceManagerException.class);

 
 		return userContext.getDAOGroup().getReceivingSpaceDAO().load(receivingSpaceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens){
		super.addActions(userContext, receivingSpace, tokens);
		
		addAction(userContext, receivingSpace, tokens,"@create","createReceivingSpace","createReceivingSpace/","main","primary");
		addAction(userContext, receivingSpace, tokens,"@update","updateReceivingSpace","updateReceivingSpace/"+receivingSpace.getId()+"/","main","primary");
		addAction(userContext, receivingSpace, tokens,"@copy","cloneReceivingSpace","cloneReceivingSpace/"+receivingSpace.getId()+"/","main","primary");
		
		addAction(userContext, receivingSpace, tokens,"receiving_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+receivingSpace.getId()+"/","main","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.addGoods","addGoods","addGoods/"+receivingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.removeGoods","removeGoods","removeGoods/"+receivingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.updateGoods","updateGoods","updateGoods/"+receivingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+receivingSpace.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ReceivingSpace createReceivingSpace(RetailscmUserContext userContext,String location, String contactNumber, String description, String totalArea, String warehouseId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfReceivingSpace(location);
		userContext.getChecker().checkContactNumberOfReceivingSpace(contactNumber);
		userContext.getChecker().checkDescriptionOfReceivingSpace(description);
		userContext.getChecker().checkTotalAreaOfReceivingSpace(totalArea);
		userContext.getChecker().checkLatitudeOfReceivingSpace(latitude);
		userContext.getChecker().checkLongitudeOfReceivingSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);


		ReceivingSpace receivingSpace=createNewReceivingSpace();	

		receivingSpace.setLocation(location);
		receivingSpace.setContactNumber(contactNumber);
		receivingSpace.setDescription(description);
		receivingSpace.setTotalArea(totalArea);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		receivingSpace.setWarehouse(warehouse);
		
		
		receivingSpace.setLatitude(latitude);
		receivingSpace.setLongitude(longitude);
		receivingSpace.setLastUpdateTime(userContext.now());

		receivingSpace = saveReceivingSpace(userContext, receivingSpace, emptyOptions());
		
		onNewInstanceCreated(userContext, receivingSpace);
		return receivingSpace;

		
	}
	protected ReceivingSpace createNewReceivingSpace() 
	{
		
		return new ReceivingSpace();		
	}
	
	protected void checkParamsForUpdatingReceivingSpace(RetailscmUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().checkVersionOfReceivingSpace( receivingSpaceVersion);
		

		if(ReceivingSpace.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfReceivingSpace(parseString(newValueExpr));
		}
		if(ReceivingSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfReceivingSpace(parseString(newValueExpr));
		}
		if(ReceivingSpace.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfReceivingSpace(parseString(newValueExpr));
		}
		if(ReceivingSpace.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfReceivingSpace(parseString(newValueExpr));
		}		

		
		if(ReceivingSpace.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfReceivingSpace(parseBigDecimal(newValueExpr));
		}
		if(ReceivingSpace.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfReceivingSpace(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
	
		
	}
	
	
	
	public ReceivingSpace clone(RetailscmUserContext userContext, String fromReceivingSpaceId) throws Exception{
		
		return userContext.getDAOGroup().getReceivingSpaceDAO().clone(fromReceivingSpaceId, this.allTokens());
	}
	
	public ReceivingSpace internalSaveReceivingSpace(RetailscmUserContext userContext, ReceivingSpace receivingSpace) throws Exception 
	{
		return internalSaveReceivingSpace(userContext, receivingSpace, allTokens());

	}
	public ReceivingSpace internalSaveReceivingSpace(RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingReceivingSpace(userContext, receivingSpaceId, receivingSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(receivingSpace){ 
			//will be good when the receivingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ReceivingSpace.
			
			
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, options);
			return receivingSpace;
			
		}

	}
	
	public ReceivingSpace updateReceivingSpace(RetailscmUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReceivingSpace(userContext, receivingSpaceId, receivingSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		if(receivingSpace.getVersion() != receivingSpaceVersion){
			String message = "The target version("+receivingSpace.getVersion()+") is not equals to version("+receivingSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(receivingSpace){ 
			//will be good when the receivingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ReceivingSpace.
			receivingSpace.updateLastUpdateTime(userContext.now());
			receivingSpace.changeProperty(property, newValueExpr);
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
			//return saveReceivingSpace(userContext, receivingSpace, tokens().done());
		}

	}
	
	public ReceivingSpace updateReceivingSpaceProperty(RetailscmUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReceivingSpace(userContext, receivingSpaceId, receivingSpaceVersion, property, newValueExpr, tokensExpr);
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		if(receivingSpace.getVersion() != receivingSpaceVersion){
			String message = "The target version("+receivingSpace.getVersion()+") is not equals to version("+receivingSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(receivingSpace){ 
			//will be good when the receivingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ReceivingSpace.
			
			receivingSpace.changeProperty(property, newValueExpr);
			receivingSpace.updateLastUpdateTime(userContext.now());
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
			//return saveReceivingSpace(userContext, receivingSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ReceivingSpaceTokens tokens(){
		return ReceivingSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ReceivingSpaceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ReceivingSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String receivingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
 		userContext.getChecker().checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
 		
 	}
 	public ReceivingSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String receivingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, receivingSpaceId,anotherWarehouseId);
 
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());	
		synchronized(receivingSpace){
			//will be good when the receivingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			receivingSpace.updateWarehouse(warehouse);		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, emptyOptions());
			
			return present(userContext,receivingSpace, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateWarehouse requestCandidateWarehouse(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateWarehouse result = new CandidateWarehouse();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Warehouse> candidateList = userContext.getDAOGroup().getWarehouseDAO().requestCandidateWarehouseForReceivingSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getWarehouseDAO().load(newWarehouseId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String receivingSpaceId, int receivingSpaceVersion) throws Exception {
		//deleteInternal(userContext, receivingSpaceId, receivingSpaceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String receivingSpaceId, int receivingSpaceVersion) throws Exception{
			
		userContext.getDAOGroup().getReceivingSpaceDAO().delete(receivingSpaceId, receivingSpaceVersion);
	}
	
	public ReceivingSpace forgetByAll(RetailscmUserContext userContext, String receivingSpaceId, int receivingSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, receivingSpaceId, receivingSpaceVersion);		
	}
	protected ReceivingSpace forgetByAllInternal(RetailscmUserContext userContext,
			String receivingSpaceId, int receivingSpaceVersion) throws Exception{
			
		return userContext.getDAOGroup().getReceivingSpaceDAO().disconnectFromAll(receivingSpaceId, receivingSpaceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ReceivingSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getReceivingSpaceDAO().deleteAll();
	}


	//disconnect ReceivingSpace with sku in Goods
	protected ReceivingSpace breakWithGoodsBySku(RetailscmUserContext userContext, String receivingSpaceId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithSku(receivingSpace, skuId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with goods_allocation in Goods
	protected ReceivingSpace breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String receivingSpaceId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithGoodsAllocation(receivingSpace, goodsAllocationId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with smart_pallet in Goods
	protected ReceivingSpace breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String receivingSpaceId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithSmartPallet(receivingSpace, smartPalletId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with shipping_space in Goods
	protected ReceivingSpace breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String receivingSpaceId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithShippingSpace(receivingSpace, shippingSpaceId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with transport_task in Goods
	protected ReceivingSpace breakWithGoodsByTransportTask(RetailscmUserContext userContext, String receivingSpaceId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithTransportTask(receivingSpace, transportTaskId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with retail_store in Goods
	protected ReceivingSpace breakWithGoodsByRetailStore(RetailscmUserContext userContext, String receivingSpaceId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithRetailStore(receivingSpace, retailStoreId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with biz_order in Goods
	protected ReceivingSpace breakWithGoodsByBizOrder(RetailscmUserContext userContext, String receivingSpaceId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithBizOrder(receivingSpace, bizOrderId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	//disconnect ReceivingSpace with retail_store_order in Goods
	protected ReceivingSpace breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String receivingSpaceId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());

			synchronized(receivingSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsListWithRetailStoreOrder(receivingSpace, retailStoreOrderId, this.emptyOptions());

				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				return receivingSpace;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);

		
		userContext.getChecker().checkNameOfGoods(name);
		
		userContext.getChecker().checkRfidOfGoods(rfid);
		
		userContext.getChecker().checkUomOfGoods(uom);
		
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
		
		userContext.getChecker().checkSkuIdOfGoods(skuId);
		
		userContext.getChecker().checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		userContext.getChecker().checkSmartPalletIdOfGoods(smartPalletId);
		
		userContext.getChecker().checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		userContext.getChecker().checkTransportTaskIdOfGoods(transportTaskId);
		
		userContext.getChecker().checkRetailStoreIdOfGoods(retailStoreId);
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);

	
	}
	public  ReceivingSpace addGoods(RetailscmUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,receivingSpaceId,name, rfid, uom, maxPackage, expireTime, skuId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			receivingSpace.addGoods( goods );		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String receivingSpaceId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
		
	}
	public  ReceivingSpace updateGoodsProperties(RetailscmUserContext userContext, String receivingSpaceId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,receivingSpaceId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		ReceivingSpace receivingSpaceToUpdate = loadReceivingSpace(userContext, receivingSpaceId, options);
		
		if(receivingSpaceToUpdate.getGoodsList().isEmpty()){
			throw new ReceivingSpaceManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = receivingSpaceToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,receivingSpaceId,name, code, used,tokensExpr);
		ReceivingSpace receivingSpace = saveReceivingSpace(userContext, receivingSpaceToUpdate, tokens().withGoodsList().done());
		synchronized(receivingSpace){ 
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
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
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String receivingSpaceId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
		
	}
	public  ReceivingSpace removeGoodsList(RetailscmUserContext userContext, String receivingSpaceId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, receivingSpaceId,  goodsIds, tokensExpr);
			
			
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
			synchronized(receivingSpace){ 
				//Will be good when the receivingSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getReceivingSpaceDAO().planToRemoveGoodsList(receivingSpace, goodsIds, allTokens());
				receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, receivingSpace.getGoodsList());
				return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfReceivingSpace( receivingSpaceId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
	
	}
	public  ReceivingSpace removeGoods(RetailscmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,receivingSpaceId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			receivingSpace.removeGoods( goods );		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfReceivingSpace( receivingSpaceId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
	
	}
	public  ReceivingSpace copyGoodsFrom(RetailscmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,receivingSpaceId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			receivingSpace.copyGoodsFrom( goods );		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)receivingSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
	
	}
	
	public  ReceivingSpace updateGoods(RetailscmUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, receivingSpaceId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, loadTokens);
		
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//receivingSpace.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = receivingSpace.findTheGoods(goodsIndex);
			if(goods == null){
				throw new ReceivingSpaceManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  ReceivingSpace associateGoodsListToNewPackaging(RetailscmUserContext userContext, String receivingSpaceId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: receivingSpace.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveReceivingSpace(userContext, receivingSpace);
	}
	*/
	
	public  ReceivingSpace associateGoodsListToPackaging(RetailscmUserContext userContext, String receivingSpaceId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: receivingSpace.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveReceivingSpace(userContext, receivingSpace);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, ReceivingSpace newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


