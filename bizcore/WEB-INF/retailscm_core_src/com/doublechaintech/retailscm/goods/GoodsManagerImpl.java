
package com.doublechaintech.retailscm.goods;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.goods.Goods;import com.doublechaintech.retailscm.goodsallocation.CandidateGoodsAllocation;import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.receivingspace.CandidateReceivingSpace;import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;import com.doublechaintech.retailscm.retailstore.CandidateRetailStore;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.shippingspace.CandidateShippingSpace;import com.doublechaintech.retailscm.shippingspace.ShippingSpace;import com.doublechaintech.retailscm.sku.CandidateSku;import com.doublechaintech.retailscm.sku.Sku;import com.doublechaintech.retailscm.smartpallet.CandidateSmartPallet;import com.doublechaintech.retailscm.smartpallet.SmartPallet;import com.doublechaintech.retailscm.supplyorder.CandidateSupplyOrder;import com.doublechaintech.retailscm.supplyorder.SupplyOrder;import com.doublechaintech.retailscm.transporttask.CandidateTransportTask;import com.doublechaintech.retailscm.transporttask.TransportTask;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class GoodsManagerImpl extends CustomRetailscmCheckerManager implements GoodsManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = GoodsTokens.start().withTokenFromListName(listName).done();
		Goods  goods = (Goods) this.loadGoods(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = goods.collectRefercencesFromLists();
		goodsDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, goods, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new GoodsGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "Goods";
	@Override
	public GoodsDAO daoOf(RetailscmUserContext userContext) {
		return goodsDaoOf(userContext);
	}

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

 		checkerOf(userContext).checkIdOfGoods(goodsId);

		checkerOf(userContext).throwExceptionIfHasErrors( GoodsManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		Goods goods = loadGoods( userContext, goodsId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goods, tokens);
 	}


 	 public Goods searchGoods(RetailscmUserContext userContext, String goodsId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfGoods(goodsId);

		checkerOf(userContext).throwExceptionIfHasErrors( GoodsManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		Goods goods = loadGoods( userContext, goodsId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goods, tokens);
 	}



 	protected Goods present(RetailscmUserContext userContext, Goods goods, Map<String, Object> tokens) throws Exception {


		addActions(userContext,goods,tokens);
    

		Goods  goodsToPresent = goodsDaoOf(userContext).present(goods, tokens);

		List<BaseEntity> entityListToNaming = goodsToPresent.collectRefercencesFromLists();
		goodsDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,goods,tokens);

		return  goodsToPresent;


	}



 	public Goods loadGoodsDetail(RetailscmUserContext userContext, String goodsId) throws Exception{
 		Goods goods = loadGoods( userContext, goodsId, allTokens());
 		return present(userContext,goods, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String goodsId) throws Exception{
 		Goods goods = loadGoods( userContext, goodsId, viewTokens());
 		markVisited(userContext, goods);
 		return present(userContext,goods, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String goodsId) throws Exception{
		Goods goods = loadGoods( userContext, goodsId, viewTokens());
		goods.summarySuffix();
		markVisited(userContext, goods);
 		return present(userContext,goods, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String goodsId) throws Exception{
		Goods goods = loadGoods( userContext, goodsId, analyzeTokens());
		markVisited(userContext, goods);
		return present(userContext,goods, analyzeTokens());

	}
 	protected Goods saveGoods(RetailscmUserContext userContext, Goods goods, Map<String,Object>tokens) throws Exception{
 	
 		return goodsDaoOf(userContext).save(goods, tokens);
 	}
 	protected Goods loadGoods(RetailscmUserContext userContext, String goodsId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfGoods(goodsId);

		checkerOf(userContext).throwExceptionIfHasErrors( GoodsManagerException.class);



 		return goodsDaoOf(userContext).load(goodsId, tokens);
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
		addAction(userContext, goods, tokens,"goods.addGoodsMovement","addGoodsMovement","addGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.removeGoodsMovement","removeGoodsMovement","removeGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.updateGoodsMovement","updateGoodsMovement","updateGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.copyGoodsMovementFrom","copyGoodsMovementFrom","copyGoodsMovementFrom/"+goods.getId()+"/","goodsMovementList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Goods goods, Map<String, Object> tokens){








  @Override
  public List<Goods> searchGoodsList(RetailscmUserContext ctx, GoodsRequest pRequest){
      pRequest.setUserContext(ctx);
      List<Goods> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public Goods searchGoods(RetailscmUserContext ctx, GoodsRequest pRequest){
    pRequest.limit(0, 1);
    List<Goods> list = searchGoodsList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public Goods createGoods(RetailscmUserContext userContext, String name,String rfid,String uom,int maxPackage,Date expireTime,String skuId,String receivingSpaceId,String goodsAllocationId,String smartPalletId,String shippingSpaceId,String transportTaskId,String retailStoreId,String bizOrderId,String retailStoreOrderId) throws Exception
	{





		checkerOf(userContext).checkNameOfGoods(name);
		checkerOf(userContext).checkRfidOfGoods(rfid);
		checkerOf(userContext).checkUomOfGoods(uom);
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);


		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);



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
		



		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods( goodsVersion);


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

		

		

		

		

		

		

		

		

		


		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);



	}



	public Goods clone(RetailscmUserContext userContext, String fromGoodsId) throws Exception{

		return goodsDaoOf(userContext).clone(fromGoodsId, this.allTokens());
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
			if (goods.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixGoods(goods);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsMovementListWith(GoodsMovement.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSku(RetailscmUserContext userContext, String goodsId, String anotherSkuId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfSku(anotherSkuId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<Sku> candidateList = skuDaoOf(userContext).requestCandidateSkuForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherReceivingSpace(RetailscmUserContext userContext, String goodsId, String anotherReceivingSpaceId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfReceivingSpace(anotherReceivingSpaceId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<ReceivingSpace> candidateList = receivingSpaceDaoOf(userContext).requestCandidateReceivingSpaceForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherGoodsAllocation(RetailscmUserContext userContext, String goodsId, String anotherGoodsAllocationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfGoodsAllocation(anotherGoodsAllocationId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<GoodsAllocation> candidateList = goodsAllocationDaoOf(userContext).requestCandidateGoodsAllocationForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherSmartPallet(RetailscmUserContext userContext, String goodsId, String anotherSmartPalletId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfSmartPallet(anotherSmartPalletId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<SmartPallet> candidateList = smartPalletDaoOf(userContext).requestCandidateSmartPalletForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherShippingSpace(RetailscmUserContext userContext, String goodsId, String anotherShippingSpaceId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfShippingSpace(anotherShippingSpaceId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<ShippingSpace> candidateList = shippingSpaceDaoOf(userContext).requestCandidateShippingSpaceForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherTransportTask(RetailscmUserContext userContext, String goodsId, String anotherTransportTaskId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfTransportTask(anotherTransportTaskId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<TransportTask> candidateList = transportTaskDaoOf(userContext).requestCandidateTransportTaskForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherRetailStore(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfRetailStore(anotherRetailStoreId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<RetailStore> candidateList = retailStoreDaoOf(userContext).requestCandidateRetailStoreForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String goodsId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<SupplyOrder> candidateList = supplyOrderDaoOf(userContext).requestCandidateSupplyOrderForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherRetailStoreOrder(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoods(goodsId);
 		checkerOf(userContext).checkIdOfRetailStoreOrder(anotherRetailStoreOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

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
		SmartList<RetailStoreOrder> candidateList = retailStoreOrderDaoOf(userContext).requestCandidateRetailStoreOrderForGoods(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected ReceivingSpace loadReceivingSpace(RetailscmUserContext userContext, String newReceivingSpaceId, Map<String,Object> options) throws Exception
 	{
    
 		return receivingSpaceDaoOf(userContext).load(newReceivingSpaceId, options);
 	  
 	}
 	


	

 	protected GoodsAllocation loadGoodsAllocation(RetailscmUserContext userContext, String newGoodsAllocationId, Map<String,Object> options) throws Exception
 	{
    
 		return goodsAllocationDaoOf(userContext).load(newGoodsAllocationId, options);
 	  
 	}
 	


	

 	protected SmartPallet loadSmartPallet(RetailscmUserContext userContext, String newSmartPalletId, Map<String,Object> options) throws Exception
 	{
    
 		return smartPalletDaoOf(userContext).load(newSmartPalletId, options);
 	  
 	}
 	


	

 	protected SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
    
 		return supplyOrderDaoOf(userContext).load(newBizOrderId, options);
 	  
 	}
 	


	

 	protected TransportTask loadTransportTask(RetailscmUserContext userContext, String newTransportTaskId, Map<String,Object> options) throws Exception
 	{
    
 		return transportTaskDaoOf(userContext).load(newTransportTaskId, options);
 	  
 	}
 	


	

 	protected ShippingSpace loadShippingSpace(RetailscmUserContext userContext, String newShippingSpaceId, Map<String,Object> options) throws Exception
 	{
    
 		return shippingSpaceDaoOf(userContext).load(newShippingSpaceId, options);
 	  
 	}
 	


	

 	protected Sku loadSku(RetailscmUserContext userContext, String newSkuId, Map<String,Object> options) throws Exception
 	{
    
 		return skuDaoOf(userContext).load(newSkuId, options);
 	  
 	}
 	


	

 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String newRetailStoreOrderId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreOrderDaoOf(userContext).load(newRetailStoreOrderId, options);
 	  
 	}
 	


	

 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String newRetailStoreId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreDaoOf(userContext).load(newRetailStoreId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsId, int goodsVersion) throws Exception {
		//deleteInternal(userContext, goodsId, goodsVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsId, int goodsVersion) throws Exception{

		goodsDaoOf(userContext).delete(goodsId, goodsVersion);
	}

	public Goods forgetByAll(RetailscmUserContext userContext, String goodsId, int goodsVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsId, goodsVersion);
	}
	protected Goods forgetByAllInternal(RetailscmUserContext userContext,
			String goodsId, int goodsVersion) throws Exception{

		return goodsDaoOf(userContext).disconnectFromAll(goodsId, goodsVersion);
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
		return goodsDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingGoodsMovement(RetailscmUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoods(goodsId);


		checkerOf(userContext).checkMoveTimeOfGoodsMovement(moveTime);

		checkerOf(userContext).checkFacilityOfGoodsMovement(facility);

		checkerOf(userContext).checkFacilityIdOfGoodsMovement(facilityId);

		checkerOf(userContext).checkFromIpOfGoodsMovement(fromIp);

		checkerOf(userContext).checkUserAgentOfGoodsMovement(userAgent);

		checkerOf(userContext).checkSessionIdOfGoodsMovement(sessionId);

		checkerOf(userContext).checkLatitudeOfGoodsMovement(latitude);

		checkerOf(userContext).checkLongitudeOfGoodsMovement(longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);



	}
	public  Goods addGoodsMovement(RetailscmUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingGoodsMovement(userContext,goodsId,moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude,tokensExpr);

		GoodsMovement goodsMovement = createGoodsMovement(userContext,moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude);

		Goods goods = loadGoods(userContext, goodsId, emptyOptions());
		synchronized(goods){
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goods.addGoodsMovement( goodsMovement );
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			
			goodsMovementManagerOf(userContext).onNewInstanceCreated(userContext, goodsMovement);
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsMovementProperties(RetailscmUserContext userContext, String goodsId,String id,DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkIdOfGoodsMovement(id);

		checkerOf(userContext).checkMoveTimeOfGoodsMovement( moveTime);
		checkerOf(userContext).checkFacilityOfGoodsMovement( facility);
		checkerOf(userContext).checkFacilityIdOfGoodsMovement( facilityId);
		checkerOf(userContext).checkFromIpOfGoodsMovement( fromIp);
		checkerOf(userContext).checkUserAgentOfGoodsMovement( userAgent);
		checkerOf(userContext).checkSessionIdOfGoodsMovement( sessionId);
		checkerOf(userContext).checkLatitudeOfGoodsMovement( latitude);
		checkerOf(userContext).checkLongitudeOfGoodsMovement( longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);


	}
	public  Goods updateGoodsMovementProperties(RetailscmUserContext userContext, String goodsId, String id,DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsMovementProperties(userContext,goodsId,id,moveTime,facility,facilityId,fromIp,userAgent,sessionId,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsMovementListList()
				.searchGoodsMovementListWith(GoodsMovement.ID_PROPERTY, tokens().is(), id).done();

		Goods goodsToUpdate = loadGoods(userContext, goodsId, options);

		if(goodsToUpdate.getGoodsMovementList().isEmpty()){
			throw new GoodsManagerException("GoodsMovement is NOT FOUND with id: '"+id+"'");
		}

		GoodsMovement item = goodsToUpdate.getGoodsMovementList().first();
		beforeUpdateGoodsMovementProperties(userContext,item, goodsId,id,moveTime,facility,facilityId,fromIp,userAgent,sessionId,latitude,longitude,tokensExpr);
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

	protected  void beforeUpdateGoodsMovementProperties(RetailscmUserContext userContext, GoodsMovement item, String goodsId, String id,DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfGoods(goodsId);
		for(String goodsMovementIdItem: goodsMovementIds){
			checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);

	}
	public  Goods removeGoodsMovementList(RetailscmUserContext userContext, String goodsId,
			String goodsMovementIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsMovementList(userContext, goodsId,  goodsMovementIds, tokensExpr);


			Goods goods = loadGoods(userContext, goodsId, allTokens());
			synchronized(goods){
				//Will be good when the goods loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsDaoOf(userContext).planToRemoveGoodsMovementList(goods, goodsMovementIds, allTokens());
				goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
				deleteRelationListInGraph(userContext, goods.getGoodsMovementList());
				return present(userContext,goods, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoodsMovement(RetailscmUserContext userContext, String goodsId,
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoods( goodsId);
		checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);
		checkerOf(userContext).checkVersionOfGoodsMovement(goodsMovementVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);


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
		
		checkerOf(userContext).checkIdOfGoods( goodsId);
		checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);
		checkerOf(userContext).checkVersionOfGoodsMovement(goodsMovementVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);


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
			
			goodsMovementManagerOf(userContext).onNewInstanceCreated(userContext, (GoodsMovement)goods.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoodsMovement(RetailscmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);
		checkerOf(userContext).checkVersionOfGoodsMovement(goodsMovementVersion);


		if(GoodsMovement.MOVE_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkMoveTimeOfGoodsMovement(parseTimestamp(newValueExpr));
		}
		
		if(GoodsMovement.FACILITY_PROPERTY.equals(property)){
			checkerOf(userContext).checkFacilityOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.FACILITY_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkFacilityIdOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.FROM_IP_PROPERTY.equals(property)){
			checkerOf(userContext).checkFromIpOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.USER_AGENT_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserAgentOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.SESSION_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkSessionIdOfGoodsMovement(parseString(newValueExpr));
		}
		
		if(GoodsMovement.LATITUDE_PROPERTY.equals(property)){
			checkerOf(userContext).checkLatitudeOfGoodsMovement(parseBigDecimal(newValueExpr));
		}
		
		if(GoodsMovement.LONGITUDE_PROPERTY.equals(property)){
			checkerOf(userContext).checkLongitudeOfGoodsMovement(parseBigDecimal(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(GoodsManagerException.class);


	}

	public  Goods updateGoodsMovement(RetailscmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoodsMovement(userContext, goodsId, goodsMovementId, goodsMovementVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsMovementList().searchGoodsMovementListWith(GoodsMovement.ID_PROPERTY, tokens().equals(), goodsMovementId).done();



		Goods goods = loadGoods(userContext, goodsId, loadTokens);

		synchronized(goods){
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goods.removeGoodsMovement( goodsMovement );
			//make changes to AcceleraterAccount.
			GoodsMovement goodsMovementIdVersionKey = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);

			GoodsMovement goodsMovement = goods.findTheGoodsMovement(goodsMovementIdVersionKey);
			if(goodsMovement == null){
				throw new GoodsManagerException(goodsMovementId+" is NOT FOUND" );
			}

			beforeUpdateGoodsMovement(userContext, goodsMovement, goodsId, goodsMovementId, goodsMovementVersion, property, newValueExpr,  tokensExpr);
			goodsMovement.changeProperty(property, newValueExpr);
			
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			goodsMovementManagerOf(userContext).onUpdated(userContext, goodsMovement, this, "updateGoodsMovement");
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoodsMovement(RetailscmUserContext userContext, GoodsMovement existed, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Goods newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    goodsDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Goods newGoods = this.createGoods(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newGoods
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
    key.put(UserApp.APP_TYPE_PROPERTY, Goods.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Goods> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Sku> skuList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Sku.class);
		userContext.getDAOGroup().enhanceList(skuList, Sku.class);
		List<ReceivingSpace> receivingSpaceList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ReceivingSpace.class);
		userContext.getDAOGroup().enhanceList(receivingSpaceList, ReceivingSpace.class);
		List<GoodsAllocation> goodsAllocationList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsAllocation.class);
		userContext.getDAOGroup().enhanceList(goodsAllocationList, GoodsAllocation.class);
		List<SmartPallet> smartPalletList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SmartPallet.class);
		userContext.getDAOGroup().enhanceList(smartPalletList, SmartPallet.class);
		List<ShippingSpace> shippingSpaceList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ShippingSpace.class);
		userContext.getDAOGroup().enhanceList(shippingSpaceList, ShippingSpace.class);
		List<TransportTask> transportTaskList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportTask.class);
		userContext.getDAOGroup().enhanceList(transportTaskList, TransportTask.class);
		List<RetailStore> retailStoreList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStore.class);
		userContext.getDAOGroup().enhanceList(retailStoreList, RetailStore.class);
		List<SupplyOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, SupplyOrder.class);
		List<RetailStoreOrder> retailStoreOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreOrder.class);
		userContext.getDAOGroup().enhanceList(retailStoreOrderList, RetailStoreOrder.class);


    }
	
	public Object listBySku(RetailscmUserContext userContext,String skuId) throws Exception {
		return listPageBySku(userContext, skuId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySku(RetailscmUserContext userContext,String skuId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsBySku(skuId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(Sku.withId(skuId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listBySku");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySku/%s/",  getBeanName(), skuId)));

		page.assemblerContent(userContext, "listBySku");
		return page.doRender(userContext);
	}
  
	public Object listByReceivingSpace(RetailscmUserContext userContext,String receivingSpaceId) throws Exception {
		return listPageByReceivingSpace(userContext, receivingSpaceId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByReceivingSpace(RetailscmUserContext userContext,String receivingSpaceId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByReceivingSpace(receivingSpaceId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(ReceivingSpace.withId(receivingSpaceId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByReceivingSpace");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByReceivingSpace/%s/",  getBeanName(), receivingSpaceId)));

		page.assemblerContent(userContext, "listByReceivingSpace");
		return page.doRender(userContext);
	}
  
	public Object listByGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId) throws Exception {
		return listPageByGoodsAllocation(userContext, goodsAllocationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByGoodsAllocation(goodsAllocationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(GoodsAllocation.withId(goodsAllocationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByGoodsAllocation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByGoodsAllocation/%s/",  getBeanName(), goodsAllocationId)));

		page.assemblerContent(userContext, "listByGoodsAllocation");
		return page.doRender(userContext);
	}
  
	public Object listBySmartPallet(RetailscmUserContext userContext,String smartPalletId) throws Exception {
		return listPageBySmartPallet(userContext, smartPalletId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySmartPallet(RetailscmUserContext userContext,String smartPalletId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsBySmartPallet(smartPalletId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(SmartPallet.withId(smartPalletId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listBySmartPallet");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySmartPallet/%s/",  getBeanName(), smartPalletId)));

		page.assemblerContent(userContext, "listBySmartPallet");
		return page.doRender(userContext);
	}
  
	public Object listByShippingSpace(RetailscmUserContext userContext,String shippingSpaceId) throws Exception {
		return listPageByShippingSpace(userContext, shippingSpaceId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByShippingSpace(RetailscmUserContext userContext,String shippingSpaceId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByShippingSpace(shippingSpaceId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(ShippingSpace.withId(shippingSpaceId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByShippingSpace");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByShippingSpace/%s/",  getBeanName(), shippingSpaceId)));

		page.assemblerContent(userContext, "listByShippingSpace");
		return page.doRender(userContext);
	}
  
	public Object listByTransportTask(RetailscmUserContext userContext,String transportTaskId) throws Exception {
		return listPageByTransportTask(userContext, transportTaskId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByTransportTask(RetailscmUserContext userContext,String transportTaskId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByTransportTask(transportTaskId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(TransportTask.withId(transportTaskId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByTransportTask");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByTransportTask/%s/",  getBeanName(), transportTaskId)));

		page.assemblerContent(userContext, "listByTransportTask");
		return page.doRender(userContext);
	}
  
	public Object listByRetailStore(RetailscmUserContext userContext,String retailStoreId) throws Exception {
		return listPageByRetailStore(userContext, retailStoreId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByRetailStore(RetailscmUserContext userContext,String retailStoreId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByRetailStore(retailStoreId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(RetailStore.withId(retailStoreId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByRetailStore");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByRetailStore/%s/",  getBeanName(), retailStoreId)));

		page.assemblerContent(userContext, "listByRetailStore");
		return page.doRender(userContext);
	}
  
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(SupplyOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByBizOrder");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBizOrder/%s/",  getBeanName(), bizOrderId)));

		page.assemblerContent(userContext, "listByBizOrder");
		return page.doRender(userContext);
	}
  
	public Object listByRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId) throws Exception {
		return listPageByRetailStoreOrder(userContext, retailStoreOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId, int start, int count) throws Exception {
		SmartList<Goods> list = goodsDaoOf(userContext).findGoodsByRetailStoreOrder(retailStoreOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Goods.class);
		page.setContainerObject(RetailStoreOrder.withId(retailStoreOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货物列表");
		page.setRequestName("listByRetailStoreOrder");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByRetailStoreOrder/%s/",  getBeanName(), retailStoreOrderId)));

		page.assemblerContent(userContext, "listByRetailStoreOrder");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String goodsId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		Goods merchantObj = (Goods) this.view(userContext, goodsId);
    String merchantObjId = goodsId;
    String linkToUrl =	"goodsManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货物"+"详情";
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
				MapUtil.put("id", "3-rfid")
				    .put("fieldName", "rfid")
				    .put("label", "RFID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("rfid", merchantObj.getRfid());

		propList.add(
				MapUtil.put("id", "4-uom")
				    .put("fieldName", "uom")
				    .put("label", "计量单位")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("uom", merchantObj.getUom());

		propList.add(
				MapUtil.put("id", "5-maxPackage")
				    .put("fieldName", "maxPackage")
				    .put("label", "最大包装")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("maxPackage", merchantObj.getMaxPackage());

		propList.add(
				MapUtil.put("id", "6-expireTime")
				    .put("fieldName", "expireTime")
				    .put("label", "到期时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("expireTime", merchantObj.getExpireTime());

		propList.add(
				MapUtil.put("id", "7-sku")
				    .put("fieldName", "sku")
				    .put("label", "SKU")
				    .put("type", "product")
				    .put("linkToUrl", "skuManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"net_content\",\"imageUrl\":\"picture\",\"name\":\"product\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("sku", merchantObj.getSku());

		propList.add(
				MapUtil.put("id", "8-receivingSpace")
				    .put("fieldName", "receivingSpace")
				    .put("label", "收货区")
				    .put("type", "auto")
				    .put("linkToUrl", "receivingSpaceManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("receivingSpace", merchantObj.getReceivingSpace());

		propList.add(
				MapUtil.put("id", "9-goodsAllocation")
				    .put("fieldName", "goodsAllocation")
				    .put("label", "货位")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsAllocationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"latitude\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("goodsAllocation", merchantObj.getGoodsAllocation());

		propList.add(
				MapUtil.put("id", "10-smartPallet")
				    .put("fieldName", "smartPallet")
				    .put("label", "智能托盘")
				    .put("type", "auto")
				    .put("linkToUrl", "smartPalletManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("smartPallet", merchantObj.getSmartPallet());

		propList.add(
				MapUtil.put("id", "11-shippingSpace")
				    .put("fieldName", "shippingSpace")
				    .put("label", "发货区")
				    .put("type", "auto")
				    .put("linkToUrl", "shippingSpaceManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("shippingSpace", merchantObj.getShippingSpace());

		propList.add(
				MapUtil.put("id", "12-transportTask")
				    .put("fieldName", "transportTask")
				    .put("label", "运输任务")
				    .put("type", "auto")
				    .put("linkToUrl", "transportTaskManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"start\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("transportTask", merchantObj.getTransportTask());

		propList.add(
				MapUtil.put("id", "13-retailStore")
				    .put("fieldName", "retailStore")
				    .put("label", "双链小超")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("retailStore", merchantObj.getRetailStore());

		propList.add(
				MapUtil.put("id", "14-bizOrder")
				    .put("fieldName", "bizOrder")
				    .put("label", "订单")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "15-retailStoreOrder")
				    .put("fieldName", "retailStoreOrder")
				    .put("label", "生超的订单")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("retailStoreOrder", merchantObj.getRetailStoreOrder());

		//处理 sectionList

		//处理Section：goodsMovementListSection
		Map goodsMovementListSection = ListofUtils.buildSection(
		    "goodsMovementListSection",
		    "运动商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsMovementManager/listByGoods/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsMovementListSection);

		result.put("goodsMovementListSection", ListofUtils.toShortList(merchantObj.getGoodsMovementList(), "goodsMovement"));

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




