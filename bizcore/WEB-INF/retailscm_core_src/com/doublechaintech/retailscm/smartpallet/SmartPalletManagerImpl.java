
package com.doublechaintech.retailscm.smartpallet;

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






public class SmartPalletManagerImpl extends CustomRetailscmCheckerManager implements SmartPalletManager {
	
	private static final String SERVICE_TYPE = "SmartPallet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SmartPalletManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SmartPalletManagerException(message);

	}
	
	

 	protected SmartPallet saveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet, String [] tokensExpr) throws Exception{	
 		//return getSmartPalletDAO().save(smartPallet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSmartPallet(userContext, smartPallet, tokens);
 	}
 	
 	protected SmartPallet saveSmartPalletDetail(RetailscmUserContext userContext, SmartPallet smartPallet) throws Exception{	

 		
 		return saveSmartPallet(userContext, smartPallet, allTokens());
 	}
 	
 	public SmartPallet loadSmartPallet(RetailscmUserContext userContext, String smartPalletId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().throwExceptionIfHasErrors( SmartPalletManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,smartPallet, tokens);
 	}
 	
 	
 	 public SmartPallet searchSmartPallet(RetailscmUserContext userContext, String smartPalletId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().throwExceptionIfHasErrors( SmartPalletManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,smartPallet, tokens);
 	}
 	
 	

 	protected SmartPallet present(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,smartPallet,tokens);
		
		
		SmartPallet  smartPalletToPresent = userContext.getDAOGroup().getSmartPalletDAO().present(smartPallet, tokens);
		
		List<BaseEntity> entityListToNaming = smartPalletToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSmartPalletDAO().alias(entityListToNaming);
		
		return  smartPalletToPresent;
		
		
	}
 
 	
 	
 	public SmartPallet loadSmartPalletDetail(RetailscmUserContext userContext, String smartPalletId) throws Exception{	
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, allTokens());
 		return present(userContext,smartPallet, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String smartPalletId) throws Exception{	
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, viewTokens());
 		return present(userContext,smartPallet, allTokens());
		
 	}
 	protected SmartPallet saveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSmartPalletDAO().save(smartPallet, tokens);
 	}
 	protected SmartPallet loadSmartPallet(RetailscmUserContext userContext, String smartPalletId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().throwExceptionIfHasErrors( SmartPalletManagerException.class);

 
 		return userContext.getDAOGroup().getSmartPalletDAO().load(smartPalletId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens){
		super.addActions(userContext, smartPallet, tokens);
		
		addAction(userContext, smartPallet, tokens,"@create","createSmartPallet","createSmartPallet/","main","primary");
		addAction(userContext, smartPallet, tokens,"@update","updateSmartPallet","updateSmartPallet/"+smartPallet.getId()+"/","main","primary");
		addAction(userContext, smartPallet, tokens,"@copy","cloneSmartPallet","cloneSmartPallet/"+smartPallet.getId()+"/","main","primary");
		
		addAction(userContext, smartPallet, tokens,"smart_pallet.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+smartPallet.getId()+"/","main","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.addGoods","addGoods","addGoods/"+smartPallet.getId()+"/","goodsList","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.removeGoods","removeGoods","removeGoods/"+smartPallet.getId()+"/","goodsList","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.updateGoods","updateGoods","updateGoods/"+smartPallet.getId()+"/","goodsList","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+smartPallet.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SmartPallet createSmartPallet(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String warehouseId) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfSmartPallet(location);
		userContext.getChecker().checkContactNumberOfSmartPallet(contactNumber);
		userContext.getChecker().checkTotalAreaOfSmartPallet(totalArea);
		userContext.getChecker().checkLatitudeOfSmartPallet(latitude);
		userContext.getChecker().checkLongitudeOfSmartPallet(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);


		SmartPallet smartPallet=createNewSmartPallet();	

		smartPallet.setLocation(location);
		smartPallet.setContactNumber(contactNumber);
		smartPallet.setTotalArea(totalArea);
		smartPallet.setLatitude(latitude);
		smartPallet.setLongitude(longitude);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		smartPallet.setWarehouse(warehouse);
		
		

		smartPallet = saveSmartPallet(userContext, smartPallet, emptyOptions());
		
		onNewInstanceCreated(userContext, smartPallet);
		return smartPallet;

		
	}
	protected SmartPallet createNewSmartPallet() 
	{
		
		return new SmartPallet();		
	}
	
	protected void checkParamsForUpdatingSmartPallet(RetailscmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().checkVersionOfSmartPallet( smartPalletVersion);
		

		if(SmartPallet.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfSmartPallet(parseString(newValueExpr));
		}
		if(SmartPallet.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfSmartPallet(parseString(newValueExpr));
		}
		if(SmartPallet.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfSmartPallet(parseString(newValueExpr));
		}
		if(SmartPallet.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfSmartPallet(parseBigDecimal(newValueExpr));
		}
		if(SmartPallet.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfSmartPallet(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
	
		
	}
	
	
	
	public SmartPallet clone(RetailscmUserContext userContext, String fromSmartPalletId) throws Exception{
		
		return userContext.getDAOGroup().getSmartPalletDAO().clone(fromSmartPalletId, this.allTokens());
	}
	
	public SmartPallet internalSaveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet) throws Exception 
	{
		return internalSaveSmartPallet(userContext, smartPallet, allTokens());

	}
	public SmartPallet internalSaveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSmartPallet(userContext, smartPalletId, smartPalletVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(smartPallet){ 
			//will be good when the smartPallet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SmartPallet.
			
			
			smartPallet = saveSmartPallet(userContext, smartPallet, options);
			return smartPallet;
			
		}

	}
	
	public SmartPallet updateSmartPallet(RetailscmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSmartPallet(userContext, smartPalletId, smartPalletVersion, property, newValueExpr, tokensExpr);
		
		
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		if(smartPallet.getVersion() != smartPalletVersion){
			String message = "The target version("+smartPallet.getVersion()+") is not equals to version("+smartPalletVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(smartPallet){ 
			//will be good when the smartPallet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SmartPallet.
			
			smartPallet.changeProperty(property, newValueExpr);
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
			//return saveSmartPallet(userContext, smartPallet, tokens().done());
		}

	}
	
	public SmartPallet updateSmartPalletProperty(RetailscmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSmartPallet(userContext, smartPalletId, smartPalletVersion, property, newValueExpr, tokensExpr);
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		if(smartPallet.getVersion() != smartPalletVersion){
			String message = "The target version("+smartPallet.getVersion()+") is not equals to version("+smartPalletVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(smartPallet){ 
			//will be good when the smartPallet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SmartPallet.
			
			smartPallet.changeProperty(property, newValueExpr);
			
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
			//return saveSmartPallet(userContext, smartPallet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SmartPalletTokens tokens(){
		return SmartPalletTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SmartPalletTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SmartPalletTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String smartPalletId, String anotherWarehouseId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
 		userContext.getChecker().checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
 		
 	}
 	public SmartPallet transferToAnotherWarehouse(RetailscmUserContext userContext, String smartPalletId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, smartPalletId,anotherWarehouseId);
 
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());	
		synchronized(smartPallet){
			//will be good when the smartPallet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			smartPallet.updateWarehouse(warehouse);		
			smartPallet = saveSmartPallet(userContext, smartPallet, emptyOptions());
			
			return present(userContext,smartPallet, allTokens());
			
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
		SmartList<Warehouse> candidateList = userContext.getDAOGroup().getWarehouseDAO().requestCandidateWarehouseForSmartPallet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String smartPalletId, int smartPalletVersion) throws Exception {
		//deleteInternal(userContext, smartPalletId, smartPalletVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String smartPalletId, int smartPalletVersion) throws Exception{
			
		userContext.getDAOGroup().getSmartPalletDAO().delete(smartPalletId, smartPalletVersion);
	}
	
	public SmartPallet forgetByAll(RetailscmUserContext userContext, String smartPalletId, int smartPalletVersion) throws Exception {
		return forgetByAllInternal(userContext, smartPalletId, smartPalletVersion);		
	}
	protected SmartPallet forgetByAllInternal(RetailscmUserContext userContext,
			String smartPalletId, int smartPalletVersion) throws Exception{
			
		return userContext.getDAOGroup().getSmartPalletDAO().disconnectFromAll(smartPalletId, smartPalletVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SmartPalletManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSmartPalletDAO().deleteAll();
	}


	//disconnect SmartPallet with sku in Goods
	protected SmartPallet breakWithGoodsBySku(RetailscmUserContext userContext, String smartPalletId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithSku(smartPallet, skuId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with receiving_space in Goods
	protected SmartPallet breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String smartPalletId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithReceivingSpace(smartPallet, receivingSpaceId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with goods_allocation in Goods
	protected SmartPallet breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String smartPalletId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithGoodsAllocation(smartPallet, goodsAllocationId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with shipping_space in Goods
	protected SmartPallet breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String smartPalletId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithShippingSpace(smartPallet, shippingSpaceId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with transport_task in Goods
	protected SmartPallet breakWithGoodsByTransportTask(RetailscmUserContext userContext, String smartPalletId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithTransportTask(smartPallet, transportTaskId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with retail_store in Goods
	protected SmartPallet breakWithGoodsByRetailStore(RetailscmUserContext userContext, String smartPalletId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithRetailStore(smartPallet, retailStoreId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with biz_order in Goods
	protected SmartPallet breakWithGoodsByBizOrder(RetailscmUserContext userContext, String smartPalletId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithBizOrder(smartPallet, bizOrderId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	//disconnect SmartPallet with retail_store_order in Goods
	protected SmartPallet breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String smartPalletId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());

			synchronized(smartPallet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsListWithRetailStoreOrder(smartPallet, retailStoreOrderId, this.emptyOptions());

				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				return smartPallet;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);

		
		userContext.getChecker().checkNameOfGoods(name);
		
		userContext.getChecker().checkRfidOfGoods(rfid);
		
		userContext.getChecker().checkUomOfGoods(uom);
		
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
		
		userContext.getChecker().checkSkuIdOfGoods(skuId);
		
		userContext.getChecker().checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		userContext.getChecker().checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		userContext.getChecker().checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		userContext.getChecker().checkTransportTaskIdOfGoods(transportTaskId);
		
		userContext.getChecker().checkRetailStoreIdOfGoods(retailStoreId);
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);

	
	}
	public  SmartPallet addGoods(RetailscmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,smartPalletId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			smartPallet.addGoods( goods );		
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String smartPalletId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
		
	}
	public  SmartPallet updateGoodsProperties(RetailscmUserContext userContext, String smartPalletId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,smartPalletId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		SmartPallet smartPalletToUpdate = loadSmartPallet(userContext, smartPalletId, options);
		
		if(smartPalletToUpdate.getGoodsList().isEmpty()){
			throw new SmartPalletManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = smartPalletToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,smartPalletId,name, code, used,tokensExpr);
		SmartPallet smartPallet = saveSmartPallet(userContext, smartPalletToUpdate, tokens().withGoodsList().done());
		synchronized(smartPallet){ 
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String smartPalletId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
		
	}
	public  SmartPallet removeGoodsList(RetailscmUserContext userContext, String smartPalletId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, smartPalletId,  goodsIds, tokensExpr);
			
			
			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
			synchronized(smartPallet){ 
				//Will be good when the smartPallet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSmartPalletDAO().planToRemoveGoodsList(smartPallet, goodsIds, allTokens());
				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, smartPallet.getGoodsList());
				return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSmartPallet( smartPalletId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
	
	}
	public  SmartPallet removeGoods(RetailscmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,smartPalletId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			smartPallet.removeGoods( goods );		
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSmartPallet( smartPalletId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
	
	}
	public  SmartPallet copyGoodsFrom(RetailscmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,smartPalletId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			smartPallet.copyGoodsFrom( goods );		
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)smartPallet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SmartPalletManagerException.class);
	
	}
	
	public  SmartPallet updateGoods(RetailscmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, smartPalletId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, loadTokens);
		
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//smartPallet.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = smartPallet.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SmartPalletManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SmartPallet associateGoodsListToNewPackaging(RetailscmUserContext userContext, String smartPalletId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: smartPallet.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveSmartPallet(userContext, smartPallet);
	}
	*/
	
	public  SmartPallet associateGoodsListToPackaging(RetailscmUserContext userContext, String smartPalletId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: smartPallet.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveSmartPallet(userContext, smartPallet);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SmartPallet newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


