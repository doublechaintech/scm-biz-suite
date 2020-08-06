
package com.doublechaintech.retailscm.shippingspace;

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
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class ShippingSpaceManagerImpl extends CustomRetailscmCheckerManager implements ShippingSpaceManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = ShippingSpaceTokens.start().withTokenFromListName(listName).done();
		ShippingSpace  shippingSpace = (ShippingSpace) this.loadShippingSpace(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = shippingSpace.collectRefercencesFromLists();
		shippingSpaceDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, shippingSpace, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ShippingSpaceGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "ShippingSpace";
	@Override
	public ShippingSpaceDAO daoOf(RetailscmUserContext userContext) {
		return shippingSpaceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ShippingSpaceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ShippingSpaceManagerException(message);

	}



 	protected ShippingSpace saveShippingSpace(RetailscmUserContext userContext, ShippingSpace shippingSpace, String [] tokensExpr) throws Exception{	
 		//return getShippingSpaceDAO().save(shippingSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveShippingSpace(userContext, shippingSpace, tokens);
 	}
 	
 	protected ShippingSpace saveShippingSpaceDetail(RetailscmUserContext userContext, ShippingSpace shippingSpace) throws Exception{	

 		
 		return saveShippingSpace(userContext, shippingSpace, allTokens());
 	}
 	
 	public ShippingSpace loadShippingSpace(RetailscmUserContext userContext, String shippingSpaceId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( ShippingSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingSpace, tokens);
 	}
 	
 	
 	 public ShippingSpace searchShippingSpace(RetailscmUserContext userContext, String shippingSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( ShippingSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingSpace, tokens);
 	}
 	
 	

 	protected ShippingSpace present(RetailscmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,shippingSpace,tokens);
		
		
		ShippingSpace  shippingSpaceToPresent = shippingSpaceDaoOf(userContext).present(shippingSpace, tokens);
		
		List<BaseEntity> entityListToNaming = shippingSpaceToPresent.collectRefercencesFromLists();
		shippingSpaceDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,shippingSpace,tokens);
		
		return  shippingSpaceToPresent;
		
		
	}
 
 	
 	
 	public ShippingSpace loadShippingSpaceDetail(RetailscmUserContext userContext, String shippingSpaceId) throws Exception{	
 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, allTokens());
 		return present(userContext,shippingSpace, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String shippingSpaceId) throws Exception{	
 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, viewTokens());
 		return present(userContext,shippingSpace, allTokens());
		
 	}
 	protected ShippingSpace saveShippingSpace(RetailscmUserContext userContext, ShippingSpace shippingSpace, Map<String,Object>tokens) throws Exception{	
 		return shippingSpaceDaoOf(userContext).save(shippingSpace, tokens);
 	}
 	protected ShippingSpace loadShippingSpace(RetailscmUserContext userContext, String shippingSpaceId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( ShippingSpaceManagerException.class);

 
 		return shippingSpaceDaoOf(userContext).load(shippingSpaceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> tokens){
		super.addActions(userContext, shippingSpace, tokens);
		
		addAction(userContext, shippingSpace, tokens,"@create","createShippingSpace","createShippingSpace/","main","primary");
		addAction(userContext, shippingSpace, tokens,"@update","updateShippingSpace","updateShippingSpace/"+shippingSpace.getId()+"/","main","primary");
		addAction(userContext, shippingSpace, tokens,"@copy","cloneShippingSpace","cloneShippingSpace/"+shippingSpace.getId()+"/","main","primary");
		
		addAction(userContext, shippingSpace, tokens,"shipping_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+shippingSpace.getId()+"/","main","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.addGoods","addGoods","addGoods/"+shippingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.removeGoods","removeGoods","removeGoods/"+shippingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.updateGoods","updateGoods","updateGoods/"+shippingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+shippingSpace.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ShippingSpace createShippingSpace(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude,String description) throws Exception
	//public ShippingSpace createShippingSpace(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, BigDecimal latitude, BigDecimal longitude, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkLocationOfShippingSpace(location);
		checkerOf(userContext).checkContactNumberOfShippingSpace(contactNumber);
		checkerOf(userContext).checkTotalAreaOfShippingSpace(totalArea);
		checkerOf(userContext).checkLatitudeOfShippingSpace(latitude);
		checkerOf(userContext).checkLongitudeOfShippingSpace(longitude);
		checkerOf(userContext).checkDescriptionOfShippingSpace(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);


		ShippingSpace shippingSpace=createNewShippingSpace();	

		shippingSpace.setLocation(location);
		shippingSpace.setContactNumber(contactNumber);
		shippingSpace.setTotalArea(totalArea);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		shippingSpace.setWarehouse(warehouse);
		
		
		shippingSpace.setLatitude(latitude);
		shippingSpace.setLongitude(longitude);
		shippingSpace.setDescription(description);
		shippingSpace.setLastUpdateTime(userContext.now());

		shippingSpace = saveShippingSpace(userContext, shippingSpace, emptyOptions());
		
		onNewInstanceCreated(userContext, shippingSpace);
		return shippingSpace;


	}
	protected ShippingSpace createNewShippingSpace()
	{

		return new ShippingSpace();
	}

	protected void checkParamsForUpdatingShippingSpace(RetailscmUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
		checkerOf(userContext).checkVersionOfShippingSpace( shippingSpaceVersion);
		

		if(ShippingSpace.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfShippingSpace(parseString(newValueExpr));
		
			
		}
		if(ShippingSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfShippingSpace(parseString(newValueExpr));
		
			
		}
		if(ShippingSpace.TOTAL_AREA_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAreaOfShippingSpace(parseString(newValueExpr));
		
			
		}		

		
		if(ShippingSpace.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfShippingSpace(parseBigDecimal(newValueExpr));
		
			
		}
		if(ShippingSpace.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfShippingSpace(parseBigDecimal(newValueExpr));
		
			
		}
		if(ShippingSpace.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfShippingSpace(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);


	}



	public ShippingSpace clone(RetailscmUserContext userContext, String fromShippingSpaceId) throws Exception{

		return shippingSpaceDaoOf(userContext).clone(fromShippingSpaceId, this.allTokens());
	}

	public ShippingSpace internalSaveShippingSpace(RetailscmUserContext userContext, ShippingSpace shippingSpace) throws Exception
	{
		return internalSaveShippingSpace(userContext, shippingSpace, allTokens());

	}
	public ShippingSpace internalSaveShippingSpace(RetailscmUserContext userContext, ShippingSpace shippingSpace, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingShippingSpace(userContext, shippingSpaceId, shippingSpaceVersion, property, newValueExpr, tokensExpr);


		synchronized(shippingSpace){
			//will be good when the shippingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingSpace.
			if (shippingSpace.isChanged()){
			shippingSpace.updateLastUpdateTime(userContext.now());
			}
			shippingSpace = saveShippingSpace(userContext, shippingSpace, options);
			return shippingSpace;

		}

	}

	public ShippingSpace updateShippingSpace(RetailscmUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingShippingSpace(userContext, shippingSpaceId, shippingSpaceVersion, property, newValueExpr, tokensExpr);



		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		if(shippingSpace.getVersion() != shippingSpaceVersion){
			String message = "The target version("+shippingSpace.getVersion()+") is not equals to version("+shippingSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingSpace){
			//will be good when the shippingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingSpace.
			shippingSpace.updateLastUpdateTime(userContext.now());
			shippingSpace.changeProperty(property, newValueExpr);
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
			//return saveShippingSpace(userContext, shippingSpace, tokens().done());
		}

	}

	public ShippingSpace updateShippingSpaceProperty(RetailscmUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingShippingSpace(userContext, shippingSpaceId, shippingSpaceVersion, property, newValueExpr, tokensExpr);

		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		if(shippingSpace.getVersion() != shippingSpaceVersion){
			String message = "The target version("+shippingSpace.getVersion()+") is not equals to version("+shippingSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingSpace){
			//will be good when the shippingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingSpace.

			shippingSpace.changeProperty(property, newValueExpr);
			shippingSpace.updateLastUpdateTime(userContext.now());
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
			//return saveShippingSpace(userContext, shippingSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ShippingSpaceTokens tokens(){
		return ShippingSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ShippingSpaceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ShippingSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String shippingSpaceId, String anotherWarehouseId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
 		checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);

 	}
 	public ShippingSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String shippingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, shippingSpaceId,anotherWarehouseId);
 
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());	
		synchronized(shippingSpace){
			//will be good when the shippingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			shippingSpace.updateWarehouse(warehouse);		
			shippingSpace = saveShippingSpace(userContext, shippingSpace, emptyOptions());
			
			return present(userContext,shippingSpace, allTokens());
			
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
		SmartList<Warehouse> candidateList = warehouseDaoOf(userContext).requestCandidateWarehouseForShippingSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String newWarehouseId, Map<String,Object> options) throws Exception
 	{

 		return warehouseDaoOf(userContext).load(newWarehouseId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String shippingSpaceId, int shippingSpaceVersion) throws Exception {
		//deleteInternal(userContext, shippingSpaceId, shippingSpaceVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String shippingSpaceId, int shippingSpaceVersion) throws Exception{

		shippingSpaceDaoOf(userContext).delete(shippingSpaceId, shippingSpaceVersion);
	}

	public ShippingSpace forgetByAll(RetailscmUserContext userContext, String shippingSpaceId, int shippingSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, shippingSpaceId, shippingSpaceVersion);
	}
	protected ShippingSpace forgetByAllInternal(RetailscmUserContext userContext,
			String shippingSpaceId, int shippingSpaceVersion) throws Exception{

		return shippingSpaceDaoOf(userContext).disconnectFromAll(shippingSpaceId, shippingSpaceVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ShippingSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return shippingSpaceDaoOf(userContext).deleteAll();
	}


	//disconnect ShippingSpace with sku in Goods
	protected ShippingSpace breakWithGoodsBySku(RetailscmUserContext userContext, String shippingSpaceId, String skuId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithSku(shippingSpace, skuId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with receiving_space in Goods
	protected ShippingSpace breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String shippingSpaceId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(shippingSpace, receivingSpaceId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with goods_allocation in Goods
	protected ShippingSpace breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String shippingSpaceId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithGoodsAllocation(shippingSpace, goodsAllocationId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with smart_pallet in Goods
	protected ShippingSpace breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String shippingSpaceId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(shippingSpace, smartPalletId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with transport_task in Goods
	protected ShippingSpace breakWithGoodsByTransportTask(RetailscmUserContext userContext, String shippingSpaceId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithTransportTask(shippingSpace, transportTaskId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with retail_store in Goods
	protected ShippingSpace breakWithGoodsByRetailStore(RetailscmUserContext userContext, String shippingSpaceId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithRetailStore(shippingSpace, retailStoreId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with biz_order in Goods
	protected ShippingSpace breakWithGoodsByBizOrder(RetailscmUserContext userContext, String shippingSpaceId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithBizOrder(shippingSpace, bizOrderId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}
	//disconnect ShippingSpace with retail_store_order in Goods
	protected ShippingSpace breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String shippingSpaceId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());

			synchronized(shippingSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				shippingSpaceDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(shippingSpace, retailStoreOrderId, this.emptyOptions());

				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				return shippingSpace;
			}
	}






	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);

		
		checkerOf(userContext).checkNameOfGoods(name);
		
		checkerOf(userContext).checkRfidOfGoods(rfid);
		
		checkerOf(userContext).checkUomOfGoods(uom);
		
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);
		
		checkerOf(userContext).checkSkuIdOfGoods(skuId);
		
		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);
		
		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);
		
		checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);
		
		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);


	}
	public  ShippingSpace addGoods(RetailscmUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,shippingSpaceId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);

		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, emptyOptions());
		synchronized(shippingSpace){
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			shippingSpace.addGoods( goods );
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, goods);
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String shippingSpaceId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);

	}
	public  ShippingSpace updateGoodsProperties(RetailscmUserContext userContext, String shippingSpaceId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,shippingSpaceId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, tokens().is(), id).done();

		ShippingSpace shippingSpaceToUpdate = loadShippingSpace(userContext, shippingSpaceId, options);

		if(shippingSpaceToUpdate.getGoodsList().isEmpty()){
			throw new ShippingSpaceManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = shippingSpaceToUpdate.getGoodsList().first();
		beforeUpdateGoodsProperties(userContext,item, shippingSpaceId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );


		//checkParamsForAddingGoods(userContext,shippingSpaceId,name, code, used,tokensExpr);
		ShippingSpace shippingSpace = saveShippingSpace(userContext, shippingSpaceToUpdate, tokens().withGoodsList().done());
		synchronized(shippingSpace){
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateGoodsProperties(RetailscmUserContext userContext, Goods item, String shippingSpaceId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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

	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String shippingSpaceId,
			String goodsIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);

	}
	public  ShippingSpace removeGoodsList(RetailscmUserContext userContext, String shippingSpaceId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, shippingSpaceId,  goodsIds, tokensExpr);


			ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
			synchronized(shippingSpace){
				//Will be good when the shippingSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				shippingSpaceDaoOf(userContext).planToRemoveGoodsList(shippingSpace, goodsIds, allTokens());
				shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, shippingSpace.getGoodsList());
				return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String shippingSpaceId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfShippingSpace( shippingSpaceId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);

	}
	public  ShippingSpace removeGoods(RetailscmUserContext userContext, String shippingSpaceId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoods(userContext,shippingSpaceId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		synchronized(shippingSpace){
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			shippingSpace.removeGoods( goods );
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String shippingSpaceId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfShippingSpace( shippingSpaceId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);

	}
	public  ShippingSpace copyGoodsFrom(RetailscmUserContext userContext, String shippingSpaceId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoods(userContext,shippingSpaceId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		synchronized(shippingSpace){
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			shippingSpace.copyGoodsFrom( goods );
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, (Goods)shippingSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfShippingSpace(shippingSpaceId);
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
		

		checkerOf(userContext).throwExceptionIfHasErrors(ShippingSpaceManagerException.class);

	}

	public  ShippingSpace updateGoods(RetailscmUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, shippingSpaceId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, tokens().equals(), goodsId).done();



		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, loadTokens);

		synchronized(shippingSpace){
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//shippingSpace.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIdVersionKey = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = shippingSpace.findTheGoods(goodsIdVersionKey);
			if(goods == null){
				throw new ShippingSpaceManagerException(goodsId+" is NOT FOUND" );
			}

			beforeUpdateGoods(userContext, goods, shippingSpaceId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
			goods.changeProperty(property, newValueExpr);
			
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoods(RetailscmUserContext userContext, Goods existed, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, ShippingSpace newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    shippingSpaceDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ShippingSpace newShippingSpace = this.createShippingSpace(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newShippingSpace
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ShippingSpace.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ShippingSpace> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Warehouse> warehouseList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Warehouse.class);
		userContext.getDAOGroup().enhanceList(warehouseList, Warehouse.class);


    }
	
	public Object listByWarehouse(RetailscmUserContext userContext,String warehouseId) throws Exception {
		return listPageByWarehouse(userContext, warehouseId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByWarehouse(RetailscmUserContext userContext,String warehouseId, int start, int count) throws Exception {
		SmartList<ShippingSpace> list = shippingSpaceDaoOf(userContext).findShippingSpaceByWarehouse(warehouseId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ShippingSpace.class);
		page.setContainerObject(Warehouse.withId(warehouseId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("发货区列表");
		page.setRequestName("listByWarehouse");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByWarehouse/%s/",  getBeanName(), warehouseId)));

		page.assemblerContent(userContext, "listByWarehouse");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String shippingSpaceId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getShippingSpaceDetailScope().clone();
		ShippingSpace merchantObj = (ShippingSpace) this.view(userContext, shippingSpaceId);
    String merchantObjId = shippingSpaceId;
    String linkToUrl =	"shippingSpaceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "发货区"+"详情";
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
				MapUtil.put("id", "3-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

		propList.add(
				MapUtil.put("id", "4-totalArea")
				    .put("fieldName", "totalArea")
				    .put("label", "总面积")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("totalArea", merchantObj.getTotalArea());

		propList.add(
				MapUtil.put("id", "5-warehouse")
				    .put("fieldName", "warehouse")
				    .put("label", "仓库")
				    .put("type", "auto")
				    .put("linkToUrl", "warehouseManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("warehouse", merchantObj.getWarehouse());

		propList.add(
				MapUtil.put("id", "6-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "7-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "8-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "9-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByShippingSpace/"+merchantObjId+"/",
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


