
package com.doublechaintech.retailscm.goods;

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

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodspackaging.GoodsPackaging;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstore.CandidateRetailStore;
import com.doublechaintech.retailscm.supplyorder.CandidateSupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.CandidateGoodsAllocation;
import com.doublechaintech.retailscm.goodspackaging.CandidateGoodsPackaging;
import com.doublechaintech.retailscm.sku.CandidateSku;
import com.doublechaintech.retailscm.receivingspace.CandidateReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.CandidateSmartPallet;
import com.doublechaintech.retailscm.shippingspace.CandidateShippingSpace;
import com.doublechaintech.retailscm.transporttask.CandidateTransportTask;
import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;

import com.doublechaintech.retailscm.goods.Goods;






public class GoodsManagerImpl extends CustomRetailscmCheckerManager implements GoodsManager {
	
	private static final String SERVICE_TYPE = "Goods";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws GoodsManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new GoodsManagerException(message);

	}
	
	

 	protected Goods saveGoods(RetailscmUserContext userContext, Goods goods, String [] tokensExpr) throws Exception{	
 		//return getGoodsDAO().save(goods, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoods(userContext, goods, tokens);
 	}
 	
 	protected Goods saveGoodsDetail(RetailscmUserContext userContext, Goods goods) throws Exception{	

 		
 		return saveGoods(userContext, goods, allTokens());
 	}
 	
 	public Goods loadGoods(RetailscmUserContext userContext, String goodsId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Goods goods = loadGoods( userContext, goodsId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goods, tokens);
 	}
 	
 	
 	 public Goods searchGoods(RetailscmUserContext userContext, String goodsId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Goods goods = loadGoods( userContext, goodsId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goods, tokens);
 	}
 	
 	

 	protected Goods present(RetailscmUserContext userContext, Goods goods, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goods,tokens);
		
		
		Goods  goodsToPresent = userContext.getDAOGroup().getGoodsDAO().present(goods, tokens);
		
		List<BaseEntity> entityListToNaming = goodsToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getGoodsDAO().alias(entityListToNaming);
		
		return  goodsToPresent;
		
		
	}
 
 	
 	
 	public Goods loadGoodsDetail(RetailscmUserContext userContext, String goodsId) throws Exception{	
 		Goods goods = loadGoods( userContext, goodsId, allTokens());
 		return present(userContext,goods, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String goodsId) throws Exception{	
 		Goods goods = loadGoods( userContext, goodsId, viewTokens());
 		return present(userContext,goods, allTokens());
		
 	}
 	protected Goods saveGoods(RetailscmUserContext userContext, Goods goods, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getGoodsDAO().save(goods, tokens);
 	}
 	protected Goods loadGoods(RetailscmUserContext userContext, String goodsId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsManagerException.class);

 
 		return userContext.getDAOGroup().getGoodsDAO().load(goodsId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Goods goods, Map<String, Object> tokens){
		super.addActions(userContext, goods, tokens);
		
		addAction(userContext, goods, tokens,"@create","createGoods","createGoods/","main","primary");
		addAction(userContext, goods, tokens,"@update","updateGoods","updateGoods/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"@copy","cloneGoods","cloneGoods/"+goods.getId()+"/","main","primary");
		
		addAction(userContext, goods, tokens,"goods.transfer_to_sku","transferToAnotherSku","transferToAnotherSku/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_receiving_space","transferToAnotherReceivingSpace","transferToAnotherReceivingSpace/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_goods_allocation","transferToAnotherGoodsAllocation","transferToAnotherGoodsAllocation/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_smart_pallet","transferToAnotherSmartPallet","transferToAnotherSmartPallet/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_shipping_space","transferToAnotherShippingSpace","transferToAnotherShippingSpace/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_transport_task","transferToAnotherTransportTask","transferToAnotherTransportTask/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_retail_store","transferToAnotherRetailStore","transferToAnotherRetailStore/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_retail_store_order","transferToAnotherRetailStoreOrder","transferToAnotherRetailStoreOrder/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.pack","pack","packActionForm/"+goods.getId()+"/","main","info");
		addAction(userContext, goods, tokens,"goods.addGoodsMovement","addGoodsMovement","addGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.removeGoodsMovement","removeGoodsMovement","removeGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.updateGoodsMovement","updateGoodsMovement","updateGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.copyGoodsMovementFrom","copyGoodsMovementFrom","copyGoodsMovementFrom/"+goods.getId()+"/","goodsMovementList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Goods goods, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Goods createGoods(RetailscmUserContext userContext,String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfGoods(name);
		userContext.getChecker().checkRfidOfGoods(rfid);
		userContext.getChecker().checkUomOfGoods(uom);
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);


		Goods goods=createNewGoods();	

		goods.setName(name);
		goods.setRfid(rfid);
		goods.setUom(uom);
		goods.setMaxPackage(maxPackage);
		goods.setExpireTime(expireTime);
			
		Sku sku = loadSku(userContext, skuId,emptyOptions());
		goods.setSku(sku);
		
		
			
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId,emptyOptions());
		goods.setReceivingSpace(receivingSpace);
		
		
			
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId,emptyOptions());
		goods.setGoodsAllocation(goodsAllocation);
		
		
			
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId,emptyOptions());
		goods.setSmartPallet(smartPallet);
		
		
			
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId,emptyOptions());
		goods.setShippingSpace(shippingSpace);
		
		
			
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId,emptyOptions());
		goods.setTransportTask(transportTask);
		
		
			
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId,emptyOptions());
		goods.setRetailStore(retailStore);
		
		
			
		SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId,emptyOptions());
		goods.setBizOrder(bizOrder);
		
		
			
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId,emptyOptions());
		goods.setRetailStoreOrder(retailStoreOrder);
		
		
		goods.setCurrentStatus("INIT");

		goods = saveGoods(userContext, goods, emptyOptions());
		
		onNewInstanceCreated(userContext, goods);
		return goods;

		
	}
	protected Goods createNewGoods() 
	{
		
		return new Goods();		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods( goodsVersion);
		

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

				

				

				

				

				

				

				

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
	
		
	}
	
	
	
	public Goods clone(RetailscmUserContext userContext, String fromGoodsId) throws Exception{
		
		return userContext.getDAOGroup().getGoodsDAO().clone(fromGoodsId, this.allTokens());
	}
	
	public Goods internalSaveGoods(RetailscmUserContext userContext, Goods goods) throws Exception 
	{
		return internalSaveGoods(userContext, goods, allTokens());

	}
	public Goods internalSaveGoods(RetailscmUserContext userContext, Goods goods, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingGoods(userContext, goodsId, goodsVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(goods){ 
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Goods.
			
			
			goods = saveGoods(userContext, goods, options);
			return goods;
			
		}

	}
	
	public Goods updateGoods(RetailscmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoods(userContext, goodsId, goodsVersion, property, newValueExpr, tokensExpr);
		
		
		
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		if(goods.getVersion() != goodsVersion){
			String message = "The target version("+goods.getVersion()+") is not equals to version("+goodsVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goods){ 
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Goods.
			
			goods.changeProperty(property, newValueExpr);
			goods = saveGoods(userContext, goods, tokens().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
			//return saveGoods(userContext, goods, tokens().done());
		}

	}
	
	public Goods updateGoodsProperty(RetailscmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoods(userContext, goodsId, goodsVersion, property, newValueExpr, tokensExpr);
		
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		if(goods.getVersion() != goodsVersion){
			String message = "The target version("+goods.getVersion()+") is not equals to version("+goodsVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goods){ 
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Goods.
			
			goods.changeProperty(property, newValueExpr);
			
			goods = saveGoods(userContext, goods, tokens().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
			//return saveGoods(userContext, goods, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsTokens tokens(){
		return GoodsTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsMovementListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"PACKED"};
 	protected String[] getNextCandidateStatus(RetailscmUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(RetailscmUserContext userContext, Goods goods, String expectedNextStatus) throws Exception{
		String currentStatus = goods.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherSku(RetailscmUserContext userContext, String goodsId, String anotherSkuId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfSku(anotherSkuId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherSku(RetailscmUserContext userContext, String goodsId, String anotherSkuId) throws Exception
 	{
 		checkParamsForTransferingAnotherSku(userContext, goodsId,anotherSkuId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Sku sku = loadSku(userContext, anotherSkuId, emptyOptions());		
			goods.updateSku(sku);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSku requestCandidateSku(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSku result = new CandidateSku();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Sku> candidateList = userContext.getDAOGroup().getSkuDAO().requestCandidateSkuForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherReceivingSpace(RetailscmUserContext userContext, String goodsId, String anotherReceivingSpaceId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfReceivingSpace(anotherReceivingSpaceId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherReceivingSpace(RetailscmUserContext userContext, String goodsId, String anotherReceivingSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherReceivingSpace(userContext, goodsId,anotherReceivingSpaceId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ReceivingSpace receivingSpace = loadReceivingSpace(userContext, anotherReceivingSpaceId, emptyOptions());		
			goods.updateReceivingSpace(receivingSpace);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateReceivingSpace requestCandidateReceivingSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateReceivingSpace result = new CandidateReceivingSpace();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ReceivingSpace> candidateList = userContext.getDAOGroup().getReceivingSpaceDAO().requestCandidateReceivingSpaceForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherGoodsAllocation(RetailscmUserContext userContext, String goodsId, String anotherGoodsAllocationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfGoodsAllocation(anotherGoodsAllocationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherGoodsAllocation(RetailscmUserContext userContext, String goodsId, String anotherGoodsAllocationId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoodsAllocation(userContext, goodsId,anotherGoodsAllocationId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, anotherGoodsAllocationId, emptyOptions());		
			goods.updateGoodsAllocation(goodsAllocation);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGoodsAllocation requestCandidateGoodsAllocation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsAllocation result = new CandidateGoodsAllocation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsAllocation> candidateList = userContext.getDAOGroup().getGoodsAllocationDAO().requestCandidateGoodsAllocationForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherSmartPallet(RetailscmUserContext userContext, String goodsId, String anotherSmartPalletId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfSmartPallet(anotherSmartPalletId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherSmartPallet(RetailscmUserContext userContext, String goodsId, String anotherSmartPalletId) throws Exception
 	{
 		checkParamsForTransferingAnotherSmartPallet(userContext, goodsId,anotherSmartPalletId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SmartPallet smartPallet = loadSmartPallet(userContext, anotherSmartPalletId, emptyOptions());		
			goods.updateSmartPallet(smartPallet);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSmartPallet requestCandidateSmartPallet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSmartPallet result = new CandidateSmartPallet();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SmartPallet> candidateList = userContext.getDAOGroup().getSmartPalletDAO().requestCandidateSmartPalletForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherShippingSpace(RetailscmUserContext userContext, String goodsId, String anotherShippingSpaceId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfShippingSpace(anotherShippingSpaceId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherShippingSpace(RetailscmUserContext userContext, String goodsId, String anotherShippingSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherShippingSpace(userContext, goodsId,anotherShippingSpaceId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ShippingSpace shippingSpace = loadShippingSpace(userContext, anotherShippingSpaceId, emptyOptions());		
			goods.updateShippingSpace(shippingSpace);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateShippingSpace requestCandidateShippingSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateShippingSpace result = new CandidateShippingSpace();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ShippingSpace> candidateList = userContext.getDAOGroup().getShippingSpaceDAO().requestCandidateShippingSpaceForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherTransportTask(RetailscmUserContext userContext, String goodsId, String anotherTransportTaskId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfTransportTask(anotherTransportTaskId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherTransportTask(RetailscmUserContext userContext, String goodsId, String anotherTransportTaskId) throws Exception
 	{
 		checkParamsForTransferingAnotherTransportTask(userContext, goodsId,anotherTransportTaskId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTask transportTask = loadTransportTask(userContext, anotherTransportTaskId, emptyOptions());		
			goods.updateTransportTask(transportTask);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportTask requestCandidateTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportTask result = new CandidateTransportTask();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportTask> candidateList = userContext.getDAOGroup().getTransportTaskDAO().requestCandidateTransportTaskForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherRetailStore(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfRetailStore(anotherRetailStoreId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherRetailStore(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStore(userContext, goodsId,anotherRetailStoreId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore retailStore = loadRetailStore(userContext, anotherRetailStoreId, emptyOptions());		
			goods.updateRetailStore(retailStore);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStore requestCandidateRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStore result = new CandidateRetailStore();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStore> candidateList = userContext.getDAOGroup().getRetailStoreDAO().requestCandidateRetailStoreForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String goodsId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherBizOrder(RetailscmUserContext userContext, String goodsId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, goodsId,anotherBizOrderId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());		
			goods.updateBizOrder(bizOrder);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrder result = new CandidateSupplyOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrder> candidateList = userContext.getDAOGroup().getSupplyOrderDAO().requestCandidateSupplyOrderForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherRetailStoreOrder(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfRetailStoreOrder(anotherRetailStoreOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherRetailStoreOrder(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStoreOrder(userContext, goodsId,anotherRetailStoreOrderId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, anotherRetailStoreOrderId, emptyOptions());		
			goods.updateRetailStoreOrder(retailStoreOrder);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrder requestCandidateRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrder result = new CandidateRetailStoreOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrder> candidateList = userContext.getDAOGroup().getRetailStoreOrderDAO().requestCandidateRetailStoreOrderForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPackaging(RetailscmUserContext userContext, String goodsId, String anotherPackagingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoods(goodsId);
 		userContext.getChecker().checkIdOfGoodsPackaging(anotherPackagingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
 		
 	}
 	public Goods transferToAnotherPackaging(RetailscmUserContext userContext, String goodsId, String anotherPackagingId) throws Exception
 	{
 		checkParamsForTransferingAnotherPackaging(userContext, goodsId,anotherPackagingId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsPackaging packaging = loadGoodsPackaging(userContext, anotherPackagingId, emptyOptions());		
			goods.updatePackaging(packaging);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGoodsPackaging requestCandidatePackaging(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsPackaging result = new CandidateGoodsPackaging();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("packageName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsPackaging> candidateList = userContext.getDAOGroup().getGoodsPackagingDAO().requestCandidateGoodsPackagingForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PACKED_STATUS = "PACKED";
 	protected void checkParamsForPackaging(RetailscmUserContext userContext, String goodsId, String packageName, String rfid, Date packageTime, String description
) throws Exception
 	{
 				userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkPackageNameOfGoodsPackaging(packageName);
		userContext.getChecker().checkRfidOfGoodsPackaging(rfid);
		userContext.getChecker().checkPackageTimeOfGoodsPackaging(packageTime);
		userContext.getChecker().checkDescriptionOfGoodsPackaging(description);

	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);

 	}
 	public Goods pack(RetailscmUserContext userContext, String goodsId, String packageName, String rfid, Date packageTime, String description
) throws Exception
 	{
		checkParamsForPackaging(userContext, goodsId, packageName, rfid, packageTime, description);
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForPackaging(userContext,goods);
 		

			goods.updateCurrentStatus(PACKED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			GoodsPackaging packaging = createPackaging(userContext, packageName, rfid, packageTime, description);		
			goods.updatePackaging(packaging);		
			
			
			goods = saveGoods(userContext, goods, tokens().withPackaging().done());
			return present(userContext,goods, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public GoodsForm packActionForm(RetailscmUserContext userContext, String goodsId) throws Exception
 	{
		return new GoodsForm()
			.withTitle("pack")
			.goodsIdField(goodsId)
			.packageNameFieldOfGoodsPackaging()
			.rfidFieldOfGoodsPackaging()
			.packageTimeFieldOfGoodsPackaging()
			.descriptionFieldOfGoodsPackaging()
			.packAction();
 	}
	
 	
 	protected GoodsPackaging createPackaging(RetailscmUserContext userContext, String packageName, String rfid, Date packageTime, String description){
 		GoodsPackaging packaging = new GoodsPackaging();
 		//packageName, rfid, packageTime, description
 		
		packaging.setPackageName(packageName);
		packaging.setRfid(rfid);
		packaging.setPackageTime(packageTime);
		packaging.setDescription(description);

 		
 		
 		
 		return userContext.getDAOGroup().getGoodsPackagingDAO().save(packaging,emptyOptions());
 	}
 	protected void checkIfEligibleForPackaging(RetailscmUserContext userContext, Goods goods) throws Exception{
 
 		ensureStatus(userContext,goods, PACKED_STATUS);
 		
 		GoodsPackaging packaging = goods.getPackaging();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = packaging 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( packaging != null){
				throwExceptionWithMessage("The Goods("+goods.getId()+") has already been "+ PACKED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected GoodsAllocation loadGoodsAllocation(RetailscmUserContext userContext, String newGoodsAllocationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsAllocationDAO().load(newGoodsAllocationId, options);
 	}
 	
 	
 	
	
	 	
 	protected ShippingSpace loadShippingSpace(RetailscmUserContext userContext, String newShippingSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getShippingSpaceDAO().load(newShippingSpaceId, options);
 	}
 	
 	
 	
	
	 	
 	protected GoodsPackaging loadGoodsPackaging(RetailscmUserContext userContext, String newPackagingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsPackagingDAO().load(newPackagingId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String newRetailStoreId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreDAO().load(newRetailStoreId, options);
 	}
 	
 	
 	
	
	 	
 	protected Sku loadSku(RetailscmUserContext userContext, String newSkuId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSkuDAO().load(newSkuId, options);
 	}
 	
 	
 	
	
	 	
 	protected TransportTask loadTransportTask(RetailscmUserContext userContext, String newTransportTaskId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportTaskDAO().load(newTransportTaskId, options);
 	}
 	
 	
 	
	
	 	
 	protected SmartPallet loadSmartPallet(RetailscmUserContext userContext, String newSmartPalletId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSmartPalletDAO().load(newSmartPalletId, options);
 	}
 	
 	
 	
	
	 	
 	protected SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderDAO().load(newBizOrderId, options);
 	}
 	
 	
 	
	
	 	
 	protected ReceivingSpace loadReceivingSpace(RetailscmUserContext userContext, String newReceivingSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getReceivingSpaceDAO().load(newReceivingSpaceId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String newRetailStoreOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderDAO().load(newRetailStoreOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsId, int goodsVersion) throws Exception {
		//deleteInternal(userContext, goodsId, goodsVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsId, int goodsVersion) throws Exception{
			
		userContext.getDAOGroup().getGoodsDAO().delete(goodsId, goodsVersion);
	}
	
	public Goods forgetByAll(RetailscmUserContext userContext, String goodsId, int goodsVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsId, goodsVersion);		
	}
	protected Goods forgetByAllInternal(RetailscmUserContext userContext,
			String goodsId, int goodsVersion) throws Exception{
			
		return userContext.getDAOGroup().getGoodsDAO().disconnectFromAll(goodsId, goodsVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getGoodsDAO().deleteAll();
	}


	//disconnect Goods with facility_id in GoodsMovement
	protected Goods breakWithGoodsMovementByFacilityId(RetailscmUserContext userContext, String goodsId, String facilityIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Goods goods = loadGoods(userContext, goodsId, allTokens());

			synchronized(goods){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsDAO().planToRemoveGoodsMovementListWithFacilityId(goods, facilityIdId, this.emptyOptions());

				goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
				return goods;
			}
	}
	//disconnect Goods with session_id in GoodsMovement
	protected Goods breakWithGoodsMovementBySessionId(RetailscmUserContext userContext, String goodsId, String sessionIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Goods goods = loadGoods(userContext, goodsId, allTokens());

			synchronized(goods){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getGoodsDAO().planToRemoveGoodsMovementListWithSessionId(goods, sessionIdId, this.emptyOptions());

				goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
				return goods;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoodsMovement(RetailscmUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGoods(goodsId);

		
		userContext.getChecker().checkMoveTimeOfGoodsMovement(moveTime);
		
		userContext.getChecker().checkFacilityOfGoodsMovement(facility);
		
		userContext.getChecker().checkFacilityIdOfGoodsMovement(facilityId);
		
		userContext.getChecker().checkFromIpOfGoodsMovement(fromIp);
		
		userContext.getChecker().checkUserAgentOfGoodsMovement(userAgent);
		
		userContext.getChecker().checkSessionIdOfGoodsMovement(sessionId);
		
		userContext.getChecker().checkLatitudeOfGoodsMovement(latitude);
		
		userContext.getChecker().checkLongitudeOfGoodsMovement(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);

	
	}
	public  Goods addGoodsMovement(RetailscmUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsMovement(userContext,goodsId,moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude,tokensExpr);
		
		GoodsMovement goodsMovement = createGoodsMovement(userContext,moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude);
		
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goods.addGoodsMovement( goodsMovement );		
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			
			userContext.getManagerGroup().getGoodsMovementManager().onNewInstanceCreated(userContext, goodsMovement);
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsMovementProperties(RetailscmUserContext userContext, String goodsId,String id,DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkIdOfGoodsMovement(id);
		
		userContext.getChecker().checkMoveTimeOfGoodsMovement( moveTime);
		userContext.getChecker().checkFacilityOfGoodsMovement( facility);
		userContext.getChecker().checkFacilityIdOfGoodsMovement( facilityId);
		userContext.getChecker().checkFromIpOfGoodsMovement( fromIp);
		userContext.getChecker().checkUserAgentOfGoodsMovement( userAgent);
		userContext.getChecker().checkSessionIdOfGoodsMovement( sessionId);
		userContext.getChecker().checkLatitudeOfGoodsMovement( latitude);
		userContext.getChecker().checkLongitudeOfGoodsMovement( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
		
	}
	public  Goods updateGoodsMovementProperties(RetailscmUserContext userContext, String goodsId, String id,DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsMovementProperties(userContext,goodsId,id,moveTime,facility,facilityId,fromIp,userAgent,sessionId,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsMovementListList()
				.searchGoodsMovementListWith(GoodsMovement.ID_PROPERTY, "is", id).done();
		
		Goods goodsToUpdate = loadGoods(userContext, goodsId, options);
		
		if(goodsToUpdate.getGoodsMovementList().isEmpty()){
			throw new GoodsManagerException("GoodsMovement is NOT FOUND with id: '"+id+"'");
		}
		
		GoodsMovement item = goodsToUpdate.getGoodsMovementList().first();
		
		item.updateMoveTime( moveTime );
		item.updateFacility( facility );
		item.updateFacilityId( facilityId );
		item.updateFromIp( fromIp );
		item.updateUserAgent( userAgent );
		item.updateSessionId( sessionId );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingGoodsMovement(userContext,goodsId,name, code, used,tokensExpr);
		Goods goods = saveGoods(userContext, goodsToUpdate, tokens().withGoodsMovementList().done());
		synchronized(goods){ 
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected GoodsMovement createGoodsMovement(RetailscmUserContext userContext, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		GoodsMovement goodsMovement = new GoodsMovement();
		
		
		goodsMovement.setMoveTime(moveTime);		
		goodsMovement.setFacility(facility);		
		goodsMovement.setFacilityId(facilityId);		
		goodsMovement.setFromIp(fromIp);		
		goodsMovement.setUserAgent(userAgent);		
		goodsMovement.setSessionId(sessionId);		
		goodsMovement.setLatitude(latitude);		
		goodsMovement.setLongitude(longitude);
	
		
		return goodsMovement;
	
		
	}
	
	protected GoodsMovement createIndexedGoodsMovement(String id, int version){

		GoodsMovement goodsMovement = new GoodsMovement();
		goodsMovement.setId(id);
		goodsMovement.setVersion(version);
		return goodsMovement;			
		
	}
	
	protected void checkParamsForRemovingGoodsMovementList(RetailscmUserContext userContext, String goodsId, 
			String goodsMovementIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfGoods(goodsId);
		for(String goodsMovementId: goodsMovementIds){
			userContext.getChecker().checkIdOfGoodsMovement(goodsMovementId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
		
	}
	public  Goods removeGoodsMovementList(RetailscmUserContext userContext, String goodsId, 
			String goodsMovementIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsMovementList(userContext, goodsId,  goodsMovementIds, tokensExpr);
			
			
			Goods goods = loadGoods(userContext, goodsId, allTokens());
			synchronized(goods){ 
				//Will be good when the goods loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGoodsDAO().planToRemoveGoodsMovementList(goods, goodsMovementIds, allTokens());
				goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
				deleteRelationListInGraph(userContext, goods.getGoodsMovementList());
				return present(userContext,goods, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoodsMovement(RetailscmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoods( goodsId);
		userContext.getChecker().checkIdOfGoodsMovement(goodsMovementId);
		userContext.getChecker().checkVersionOfGoodsMovement(goodsMovementVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
	
	}
	public  Goods removeGoodsMovement(RetailscmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsMovement(userContext,goodsId, goodsMovementId, goodsMovementVersion,tokensExpr);
		
		GoodsMovement goodsMovement = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goods.removeGoodsMovement( goodsMovement );		
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			deleteRelationInGraph(userContext, goodsMovement);
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoodsMovement(RetailscmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoods( goodsId);
		userContext.getChecker().checkIdOfGoodsMovement(goodsMovementId);
		userContext.getChecker().checkVersionOfGoodsMovement(goodsMovementVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
	
	}
	public  Goods copyGoodsMovementFrom(RetailscmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsMovement(userContext,goodsId, goodsMovementId, goodsMovementVersion,tokensExpr);
		
		GoodsMovement goodsMovement = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			goods.copyGoodsMovementFrom( goodsMovement );		
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			
			userContext.getManagerGroup().getGoodsMovementManager().onNewInstanceCreated(userContext, (GoodsMovement)goods.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoodsMovement(RetailscmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkIdOfGoodsMovement(goodsMovementId);
		userContext.getChecker().checkVersionOfGoodsMovement(goodsMovementVersion);
		

		if(GoodsMovement.MOVE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkMoveTimeOfGoodsMovement(parseTimestamp(newValueExpr));
		}
		
		if(GoodsMovement.FACILITY_PROPERTY.equals(property)){
			userContext.getChecker().checkFacilityOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.FACILITY_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkFacilityIdOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.FROM_IP_PROPERTY.equals(property)){
			userContext.getChecker().checkFromIpOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.USER_AGENT_PROPERTY.equals(property)){
			userContext.getChecker().checkUserAgentOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.SESSION_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSessionIdOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfGoodsMovement(parseBigDecimal(newValueExpr));
		}
		
		if(GoodsMovement.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfGoodsMovement(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsManagerException.class);
	
	}
	
	public  Goods updateGoodsMovement(RetailscmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsMovement(userContext, goodsId, goodsMovementId, goodsMovementVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsMovementList().searchGoodsMovementListWith(GoodsMovement.ID_PROPERTY, "eq", goodsMovementId).done();
		
		
		
		Goods goods = loadGoods(userContext, goodsId, loadTokens);
		
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goods.removeGoodsMovement( goodsMovement );	
			//make changes to AcceleraterAccount.
			GoodsMovement goodsMovementIndex = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);
		
			GoodsMovement goodsMovement = goods.findTheGoodsMovement(goodsMovementIndex);
			if(goodsMovement == null){
				throw new GoodsManagerException(goodsMovement+" is NOT FOUND" );
			}
			
			goodsMovement.changeProperty(property, newValueExpr);
			
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Goods newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


