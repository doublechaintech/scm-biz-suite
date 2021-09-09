
package com.doublechaintech.retailscm.smartpallet;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.goods.Goods;import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.shippingspace.ShippingSpace;import com.doublechaintech.retailscm.sku.Sku;import com.doublechaintech.retailscm.smartpallet.SmartPallet;import com.doublechaintech.retailscm.supplyorder.SupplyOrder;import com.doublechaintech.retailscm.transporttask.TransportTask;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class SmartPalletManagerImpl extends CustomRetailscmCheckerManager implements SmartPalletManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = SmartPalletTokens.start().withTokenFromListName(listName).done();
		SmartPallet  smartPallet = (SmartPallet) this.loadSmartPallet(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = smartPallet.collectRefercencesFromLists();
		smartPalletDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, smartPallet, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SmartPalletGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "SmartPallet";
	@Override
	public SmartPalletDAO daoOf(RetailscmUserContext userContext) {
		return smartPalletDaoOf(userContext);
	}

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

 		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);

		checkerOf(userContext).throwExceptionIfHasErrors( SmartPalletManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,smartPallet, tokens);
 	}


 	 public SmartPallet searchSmartPallet(RetailscmUserContext userContext, String smartPalletId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);

		checkerOf(userContext).throwExceptionIfHasErrors( SmartPalletManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,smartPallet, tokens);
 	}



 	protected SmartPallet present(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens) throws Exception {


		addActions(userContext,smartPallet,tokens);
    

		SmartPallet  smartPalletToPresent = smartPalletDaoOf(userContext).present(smartPallet, tokens);

		List<BaseEntity> entityListToNaming = smartPalletToPresent.collectRefercencesFromLists();
		smartPalletDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,smartPallet,tokens);

		return  smartPalletToPresent;


	}



 	public SmartPallet loadSmartPalletDetail(RetailscmUserContext userContext, String smartPalletId) throws Exception{
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, allTokens());
 		return present(userContext,smartPallet, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String smartPalletId) throws Exception{
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, viewTokens());
 		markVisited(userContext, smartPallet);
 		return present(userContext,smartPallet, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String smartPalletId) throws Exception{
		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, viewTokens());
		smartPallet.summarySuffix();
		markVisited(userContext, smartPallet);
 		return present(userContext,smartPallet, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String smartPalletId) throws Exception{
		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, analyzeTokens());
		markVisited(userContext, smartPallet);
		return present(userContext,smartPallet, analyzeTokens());

	}
 	protected SmartPallet saveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet, Map<String,Object>tokens) throws Exception{
 	
 		return smartPalletDaoOf(userContext).save(smartPallet, tokens);
 	}
 	protected SmartPallet loadSmartPallet(RetailscmUserContext userContext, String smartPalletId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);

		checkerOf(userContext).throwExceptionIfHasErrors( SmartPalletManagerException.class);



 		return smartPalletDaoOf(userContext).load(smartPalletId, tokens);
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








  @Override
  public List<SmartPallet> searchSmartPalletList(RetailscmUserContext ctx, SmartPalletRequest pRequest){
      pRequest.setUserContext(ctx);
      List<SmartPallet> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public SmartPallet searchSmartPallet(RetailscmUserContext ctx, SmartPalletRequest pRequest){
    pRequest.limit(0, 1);
    List<SmartPallet> list = searchSmartPalletList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public SmartPallet createSmartPallet(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String warehouseId) throws Exception
	{





		checkerOf(userContext).checkLocationOfSmartPallet(location);
		checkerOf(userContext).checkContactNumberOfSmartPallet(contactNumber);
		checkerOf(userContext).checkTotalAreaOfSmartPallet(totalArea);
		checkerOf(userContext).checkLatitudeOfSmartPallet(latitude);
		checkerOf(userContext).checkLongitudeOfSmartPallet(longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);



		SmartPallet smartPallet=createNewSmartPallet();	

		smartPallet.setLocation(location);
		smartPallet.setContactNumber(contactNumber);
		smartPallet.setTotalArea(totalArea);
		smartPallet.setLatitude(latitude);
		smartPallet.setLongitude(longitude);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		smartPallet.setWarehouse(warehouse);
		
		
		smartPallet.setLastUpdateTime(userContext.now());

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
		



		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);
		checkerOf(userContext).checkVersionOfSmartPallet( smartPalletVersion);


		if(SmartPallet.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfSmartPallet(parseString(newValueExpr));
		

		}
		if(SmartPallet.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfSmartPallet(parseString(newValueExpr));
		

		}
		if(SmartPallet.TOTAL_AREA_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAreaOfSmartPallet(parseString(newValueExpr));
		

		}
		if(SmartPallet.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfSmartPallet(parseBigDecimal(newValueExpr));
		

		}
		if(SmartPallet.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfSmartPallet(parseBigDecimal(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);



	}



	public SmartPallet clone(RetailscmUserContext userContext, String fromSmartPalletId) throws Exception{

		return smartPalletDaoOf(userContext).clone(fromSmartPalletId, this.allTokens());
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
			if (smartPallet.isChanged()){
			smartPallet.updateLastUpdateTime(userContext.now());
			}

      //checkerOf(userContext).checkAndFixSmartPallet(smartPallet);
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
			smartPallet.updateLastUpdateTime(userContext.now());
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
			smartPallet.updateLastUpdateTime(userContext.now());
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith(Goods.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SmartPalletTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String smartPalletId, String anotherWarehouseId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);
 		checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);

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
			smartPallet.updateLastUpdateTime(userContext.now());
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
		SmartList<Warehouse> candidateList = warehouseDaoOf(userContext).requestCandidateWarehouseForSmartPallet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String smartPalletId, int smartPalletVersion) throws Exception {
		//deleteInternal(userContext, smartPalletId, smartPalletVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String smartPalletId, int smartPalletVersion) throws Exception{

		smartPalletDaoOf(userContext).delete(smartPalletId, smartPalletVersion);
	}

	public SmartPallet forgetByAll(RetailscmUserContext userContext, String smartPalletId, int smartPalletVersion) throws Exception {
		return forgetByAllInternal(userContext, smartPalletId, smartPalletVersion);
	}
	protected SmartPallet forgetByAllInternal(RetailscmUserContext userContext,
			String smartPalletId, int smartPalletVersion) throws Exception{

		return smartPalletDaoOf(userContext).disconnectFromAll(smartPalletId, smartPalletVersion);
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
		return smartPalletDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);


		checkerOf(userContext).checkNameOfGoods(name);

		checkerOf(userContext).checkRfidOfGoods(rfid);

		checkerOf(userContext).checkUomOfGoods(uom);

		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);

		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);

		checkerOf(userContext).checkSkuIdOfGoods(skuId);

		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);

		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);

		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);

		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);

		checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);

		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);

		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);


		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);



	}
	public  SmartPallet addGoods(RetailscmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingGoods(userContext,smartPalletId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);

		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, emptyOptions());
		synchronized(smartPallet){
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			smartPallet.addGoods( goods );
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, goods);
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String smartPalletId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);


		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);


	}
	public  SmartPallet updateGoodsProperties(RetailscmUserContext userContext, String smartPalletId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,smartPalletId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, tokens().is(), id).done();

		SmartPallet smartPalletToUpdate = loadSmartPallet(userContext, smartPalletId, options);

		if(smartPalletToUpdate.getGoodsList().isEmpty()){
			throw new SmartPalletManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = smartPalletToUpdate.getGoodsList().first();
		beforeUpdateGoodsProperties(userContext,item, smartPalletId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);
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

	protected  void beforeUpdateGoodsProperties(RetailscmUserContext userContext, Goods item, String smartPalletId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);

	}
	public  SmartPallet removeGoodsList(RetailscmUserContext userContext, String smartPalletId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, smartPalletId,  goodsIds, tokensExpr);


			SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
			synchronized(smartPallet){
				//Will be good when the smartPallet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				smartPalletDaoOf(userContext).planToRemoveGoodsList(smartPallet, goodsIds, allTokens());
				smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, smartPallet.getGoodsList());
				return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String smartPalletId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSmartPallet( smartPalletId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);


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
		
		checkerOf(userContext).checkIdOfSmartPallet( smartPalletId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);


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
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, (Goods)smartPallet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfSmartPallet(smartPalletId);
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
		


		checkerOf(userContext).throwExceptionIfHasErrors(SmartPalletManagerException.class);


	}

	public  SmartPallet updateGoods(RetailscmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, smartPalletId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, tokens().equals(), goodsId).done();



		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, loadTokens);

		synchronized(smartPallet){
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//smartPallet.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIdVersionKey = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = smartPallet.findTheGoods(goodsIdVersionKey);
			if(goods == null){
				throw new SmartPalletManagerException(goodsId+" is NOT FOUND" );
			}

			beforeUpdateGoods(userContext, goods, smartPalletId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
			goods.changeProperty(property, newValueExpr);
			
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			goodsManagerOf(userContext).onUpdated(userContext, goods, this, "updateGoods");
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoods(RetailscmUserContext userContext, Goods existed, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, SmartPallet newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    smartPalletDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
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
		//   SmartPallet newSmartPallet = this.createSmartPallet(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSmartPallet
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, SmartPallet.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<SmartPallet> list) throws Exception {
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
		SmartList<SmartPallet> list = smartPalletDaoOf(userContext).findSmartPalletByWarehouse(warehouseId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(SmartPallet.class);
		page.setContainerObject(Warehouse.withId(warehouseId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("智能托盘列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String smartPalletId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		SmartPallet merchantObj = (SmartPallet) this.view(userContext, smartPalletId);
    String merchantObjId = smartPalletId;
    String linkToUrl =	"smartPalletManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "智能托盘"+"详情";
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
				MapUtil.put("id", "5-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "6-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "7-warehouse")
				    .put("fieldName", "warehouse")
				    .put("label", "仓库")
				    .put("type", "auto")
				    .put("linkToUrl", "warehouseManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("warehouse", merchantObj.getWarehouse());

		propList.add(
				MapUtil.put("id", "8-lastUpdateTime")
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
		    "goodsManager/listBySmartPallet/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));

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




