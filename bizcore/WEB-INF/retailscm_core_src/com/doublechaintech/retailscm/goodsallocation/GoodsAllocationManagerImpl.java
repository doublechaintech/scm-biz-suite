
package com.doublechaintech.retailscm.goodsallocation;

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


import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.goodsshelf.CandidateGoodsShelf;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class GoodsAllocationManagerImpl extends CustomRetailscmCheckerManager implements GoodsAllocationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = GoodsAllocationTokens.start().withTokenFromListName(listName).done();
		GoodsAllocation  goodsAllocation = (GoodsAllocation) this.loadGoodsAllocation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = goodsAllocation.collectRefercencesFromLists();
		goodsAllocationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, goodsAllocation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new GoodsAllocationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "GoodsAllocation";
	@Override
	public GoodsAllocationDAO daoOf(RetailscmUserContext userContext) {
		return goodsAllocationDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsAllocationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsAllocation, tokens);
 	}
 	
 	
 	 public GoodsAllocation searchGoodsAllocation(RetailscmUserContext userContext, String goodsAllocationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsAllocationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsAllocation, tokens);
 	}
 	
 	

 	protected GoodsAllocation present(RetailscmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsAllocation,tokens);
		
		
		GoodsAllocation  goodsAllocationToPresent = goodsAllocationDaoOf(userContext).present(goodsAllocation, tokens);
		
		List<BaseEntity> entityListToNaming = goodsAllocationToPresent.collectRefercencesFromLists();
		goodsAllocationDaoOf(userContext).alias(entityListToNaming);
		
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
 		return goodsAllocationDaoOf(userContext).save(goodsAllocation, tokens);
 	}
 	protected GoodsAllocation loadGoodsAllocation(RetailscmUserContext userContext, String goodsAllocationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsAllocationManagerException.class);

 
 		return goodsAllocationDaoOf(userContext).load(goodsAllocationId, tokens);
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
	
 	
 	
 
 	
 	

	public GoodsAllocation createGoodsAllocation(RetailscmUserContext userContext, String location,BigDecimal latitude,BigDecimal longitude,String goodsShelfId) throws Exception
	//public GoodsAllocation createGoodsAllocation(RetailscmUserContext userContext,String location, BigDecimal latitude, BigDecimal longitude, String goodsShelfId) throws Exception
	{

		

		

		checkerOf(userContext).checkLocationOfGoodsAllocation(location);
		checkerOf(userContext).checkLatitudeOfGoodsAllocation(latitude);
		checkerOf(userContext).checkLongitudeOfGoodsAllocation(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
		checkerOf(userContext).checkVersionOfGoodsAllocation( goodsAllocationVersion);
		

		if(GoodsAllocation.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfGoodsAllocation(parseString(newValueExpr));
		
			
		}
		if(GoodsAllocation.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfGoodsAllocation(parseBigDecimal(newValueExpr));
		
			
		}
		if(GoodsAllocation.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfGoodsAllocation(parseBigDecimal(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);


	}



	public GoodsAllocation clone(RetailscmUserContext userContext, String fromGoodsAllocationId) throws Exception{

		return goodsAllocationDaoOf(userContext).clone(fromGoodsAllocationId, this.allTokens());
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
			if (goodsAllocation.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsAllocationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherGoodsShelf(RetailscmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
 		checkerOf(userContext).checkIdOfGoodsShelf(anotherGoodsShelfId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

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
		SmartList<GoodsShelf> candidateList = goodsShelfDaoOf(userContext).requestCandidateGoodsShelfForGoodsAllocation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GoodsShelf loadGoodsShelf(RetailscmUserContext userContext, String newGoodsShelfId, Map<String,Object> options) throws Exception
 	{

 		return goodsShelfDaoOf(userContext).load(newGoodsShelfId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsAllocationId, int goodsAllocationVersion) throws Exception {
		//deleteInternal(userContext, goodsAllocationId, goodsAllocationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsAllocationId, int goodsAllocationVersion) throws Exception{

		goodsAllocationDaoOf(userContext).delete(goodsAllocationId, goodsAllocationVersion);
	}

	public GoodsAllocation forgetByAll(RetailscmUserContext userContext, String goodsAllocationId, int goodsAllocationVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsAllocationId, goodsAllocationVersion);
	}
	protected GoodsAllocation forgetByAllInternal(RetailscmUserContext userContext,
			String goodsAllocationId, int goodsAllocationVersion) throws Exception{

		return goodsAllocationDaoOf(userContext).disconnectFromAll(goodsAllocationId, goodsAllocationVersion);
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
		return goodsAllocationDaoOf(userContext).deleteAll();
	}


	//disconnect GoodsAllocation with sku in Goods
	protected GoodsAllocation breakWithGoodsBySku(RetailscmUserContext userContext, String goodsAllocationId, String skuId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());

			synchronized(goodsAllocation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithSku(goodsAllocation, skuId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(goodsAllocation, receivingSpaceId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(goodsAllocation, smartPalletId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithShippingSpace(goodsAllocation, shippingSpaceId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithTransportTask(goodsAllocation, transportTaskId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithRetailStore(goodsAllocation, retailStoreId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithBizOrder(goodsAllocation, bizOrderId, this.emptyOptions());

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

				goodsAllocationDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(goodsAllocation, retailStoreOrderId, this.emptyOptions());

				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				return goodsAllocation;
			}
	}






	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);

		
		checkerOf(userContext).checkNameOfGoods(name);
		
		checkerOf(userContext).checkRfidOfGoods(rfid);
		
		checkerOf(userContext).checkUomOfGoods(uom);
		
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);
		
		checkerOf(userContext).checkSkuIdOfGoods(skuId);
		
		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);
		
		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);
		
		checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);
		
		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);


	}
	public  GoodsAllocation addGoods(RetailscmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,goodsAllocationId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);

		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, emptyOptions());
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

		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

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

		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

	}
	public  GoodsAllocation removeGoodsList(RetailscmUserContext userContext, String goodsAllocationId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, goodsAllocationId,  goodsIds, tokensExpr);


			GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
			synchronized(goodsAllocation){
				//Will be good when the goodsAllocation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsAllocationDaoOf(userContext).planToRemoveGoodsList(goodsAllocation, goodsIds, allTokens());
				goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, goodsAllocation.getGoodsList());
				return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String goodsAllocationId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsAllocation( goodsAllocationId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

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
		
		checkerOf(userContext).checkIdOfGoodsAllocation( goodsAllocationId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsAllocationManagerException.class);

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

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsAllocation newCreated) throws Exception{
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
		//   GoodsAllocation newGoodsAllocation = this.createGoodsAllocation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newGoodsAllocation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, GoodsAllocation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<GoodsAllocation> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GoodsShelf> goodsShelfList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsShelf.class);
		userContext.getDAOGroup().enhanceList(goodsShelfList, GoodsShelf.class);


    }
	
	public Object listByGoodsShelf(RetailscmUserContext userContext,String goodsShelfId) throws Exception {
		return listPageByGoodsShelf(userContext, goodsShelfId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByGoodsShelf(RetailscmUserContext userContext,String goodsShelfId, int start, int count) throws Exception {
		SmartList<GoodsAllocation> list = goodsAllocationDaoOf(userContext).findGoodsAllocationByGoodsShelf(goodsShelfId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(GoodsAllocation.class);
		page.setContainerObject(GoodsShelf.withId(goodsShelfId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货位列表");
		page.setRequestName("listByGoodsShelf");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByGoodsShelf/%s/",  getBeanName(), goodsShelfId)));

		page.assemblerContent(userContext, "listByGoodsShelf");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String goodsAllocationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getGoodsAllocationDetailScope().clone();
		GoodsAllocation merchantObj = (GoodsAllocation) this.view(userContext, goodsAllocationId);
    String merchantObjId = goodsAllocationId;
    String linkToUrl =	"goodsAllocationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货位"+"详情";
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
				MapUtil.put("id", "2-location")
				    .put("fieldName", "location")
				    .put("label", "位置")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("location", merchantObj.getLocation());

		propList.add(
				MapUtil.put("id", "3-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "4-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "5-goodsShelf")
				    .put("fieldName", "goodsShelf")
				    .put("label", "货架")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsShelfManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("goodsShelf", merchantObj.getGoodsShelf());

		//处理 sectionList

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByGoodsAllocation/"+merchantObjId+"/",
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


