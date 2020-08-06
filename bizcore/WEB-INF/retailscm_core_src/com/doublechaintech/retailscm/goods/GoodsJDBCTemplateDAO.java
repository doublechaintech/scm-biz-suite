
package com.doublechaintech.retailscm.goods;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.smartpallet.SmartPalletDAO;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationDAO;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;
import com.doublechaintech.retailscm.sku.SkuDAO;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class GoodsJDBCTemplateDAO extends RetailscmBaseDAOImpl implements GoodsDAO{

	protected SkuDAO skuDAO;
	public void setSkuDAO(SkuDAO skuDAO){
 	
 		if(skuDAO == null){
 			throw new IllegalStateException("Do not try to set skuDAO to null.");
 		}
	 	this.skuDAO = skuDAO;
 	}
 	public SkuDAO getSkuDAO(){
 		if(this.skuDAO == null){
 			throw new IllegalStateException("The skuDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skuDAO;
 	}	

	protected ReceivingSpaceDAO receivingSpaceDAO;
	public void setReceivingSpaceDAO(ReceivingSpaceDAO receivingSpaceDAO){
 	
 		if(receivingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set receivingSpaceDAO to null.");
 		}
	 	this.receivingSpaceDAO = receivingSpaceDAO;
 	}
 	public ReceivingSpaceDAO getReceivingSpaceDAO(){
 		if(this.receivingSpaceDAO == null){
 			throw new IllegalStateException("The receivingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.receivingSpaceDAO;
 	}	

	protected GoodsAllocationDAO goodsAllocationDAO;
	public void setGoodsAllocationDAO(GoodsAllocationDAO goodsAllocationDAO){
 	
 		if(goodsAllocationDAO == null){
 			throw new IllegalStateException("Do not try to set goodsAllocationDAO to null.");
 		}
	 	this.goodsAllocationDAO = goodsAllocationDAO;
 	}
 	public GoodsAllocationDAO getGoodsAllocationDAO(){
 		if(this.goodsAllocationDAO == null){
 			throw new IllegalStateException("The goodsAllocationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsAllocationDAO;
 	}	

	protected SmartPalletDAO smartPalletDAO;
	public void setSmartPalletDAO(SmartPalletDAO smartPalletDAO){
 	
 		if(smartPalletDAO == null){
 			throw new IllegalStateException("Do not try to set smartPalletDAO to null.");
 		}
	 	this.smartPalletDAO = smartPalletDAO;
 	}
 	public SmartPalletDAO getSmartPalletDAO(){
 		if(this.smartPalletDAO == null){
 			throw new IllegalStateException("The smartPalletDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.smartPalletDAO;
 	}	

	protected ShippingSpaceDAO shippingSpaceDAO;
	public void setShippingSpaceDAO(ShippingSpaceDAO shippingSpaceDAO){
 	
 		if(shippingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set shippingSpaceDAO to null.");
 		}
	 	this.shippingSpaceDAO = shippingSpaceDAO;
 	}
 	public ShippingSpaceDAO getShippingSpaceDAO(){
 		if(this.shippingSpaceDAO == null){
 			throw new IllegalStateException("The shippingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingSpaceDAO;
 	}	

	protected TransportTaskDAO transportTaskDAO;
	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
 	
 		if(transportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The transportTaskDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskDAO;
 	}	

	protected RetailStoreDAO retailStoreDAO;
	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
 	
 		if(retailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	

	protected SupplyOrderDAO supplyOrderDAO;
	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
 	
 		if(supplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	

	protected RetailStoreOrderDAO retailStoreOrderDAO;
	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
 	
 		if(retailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	

	protected GoodsMovementDAO goodsMovementDAO;
	public void setGoodsMovementDAO(GoodsMovementDAO goodsMovementDAO){
 	
 		if(goodsMovementDAO == null){
 			throw new IllegalStateException("Do not try to set goodsMovementDAO to null.");
 		}
	 	this.goodsMovementDAO = goodsMovementDAO;
 	}
 	public GoodsMovementDAO getGoodsMovementDAO(){
 		if(this.goodsMovementDAO == null){
 			throw new IllegalStateException("The goodsMovementDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsMovementDAO;
 	}	


	/*
	protected Goods load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoods(accessKey, options);
	}
	*/

	public SmartList<Goods> loadAll() {
	    return this.loadAll(getGoodsMapper());
	}

  public Stream<Goods> loadAllAsStream() {
      return this.loadAllAsStream(getGoodsMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public Goods load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoods(GoodsTable.withId(id), options);
	}

	

	public Goods save(Goods goods,Map<String,Object> options){

		String methodName="save(Goods goods,Map<String,Object> options)";

		assertMethodArgumentNotNull(goods, methodName, "goods");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalGoods(goods,options);
	}
	public Goods clone(String goodsId, Map<String,Object> options) throws Exception{

		return clone(GoodsTable.withId(goodsId),options);
	}

	protected Goods clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String goodsId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		Goods newGoods = loadInternalGoods(accessKey, options);
		newGoods.setVersion(0);
		
		
 		
 		if(isSaveGoodsMovementListEnabled(options)){
 			for(GoodsMovement item: newGoods.getGoodsMovementList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalGoods(newGoods,options);

		return newGoods;
	}

	



	protected void throwIfHasException(String goodsId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GoodsVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsNotFoundException(
					"The " + this.getTableName() + "(" + goodsId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String goodsId, int version) throws Exception{

		String methodName="delete(String goodsId, int version)";
		assertMethodArgumentNotNull(goodsId, methodName, "goodsId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsId,version);
		}


	}






	public Goods disconnectFromAll(String goodsId, int version) throws Exception{


		Goods goods = loadInternalGoods(GoodsTable.withId(goodsId), emptyOptions());
		goods.clearFromAll();
		this.saveGoods(goods);
		return goods;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return GoodsTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "goods";
	}
	@Override
	protected String getBeanName() {

		return "goods";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSkuEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.SKU);
 	}

 	protected boolean isSaveSkuEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.SKU);
 	}
 	

 	
  

 	protected boolean isExtractReceivingSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.RECEIVINGSPACE);
 	}

 	protected boolean isSaveReceivingSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.RECEIVINGSPACE);
 	}
 	

 	
  

 	protected boolean isExtractGoodsAllocationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.GOODSALLOCATION);
 	}

 	protected boolean isSaveGoodsAllocationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.GOODSALLOCATION);
 	}
 	

 	
  

 	protected boolean isExtractSmartPalletEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.SMARTPALLET);
 	}

 	protected boolean isSaveSmartPalletEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.SMARTPALLET);
 	}
 	

 	
  

 	protected boolean isExtractShippingSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.SHIPPINGSPACE);
 	}

 	protected boolean isSaveShippingSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.SHIPPINGSPACE);
 	}
 	

 	
  

 	protected boolean isExtractTransportTaskEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.TRANSPORTTASK);
 	}

 	protected boolean isSaveTransportTaskEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.TRANSPORTTASK);
 	}
 	

 	
  

 	protected boolean isExtractRetailStoreEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.RETAILSTORE);
 	}

 	protected boolean isSaveRetailStoreEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.RETAILSTORE);
 	}
 	

 	
  

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.BIZORDER);
 	}
 	

 	
  

 	protected boolean isExtractRetailStoreOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.RETAILSTOREORDER);
 	}

 	protected boolean isSaveRetailStoreOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.RETAILSTOREORDER);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsMovementListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GoodsTokens.GOODS_MOVEMENT_LIST);
 	}
 	protected boolean isAnalyzeGoodsMovementListEnabled(Map<String,Object> options){		 		
 		return GoodsTokens.of(options).analyzeGoodsMovementListEnabled();
 	}
	
	protected boolean isSaveGoodsMovementListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsTokens.GOODS_MOVEMENT_LIST);
		
 	}
 	
		

	

	protected GoodsMapper getGoodsMapper(){
		return new GoodsMapper();
	}

	
	
	protected Goods extractGoods(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Goods goods = loadSingleObject(accessKey, getGoodsMapper());
			return goods;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsNotFoundException("Goods("+accessKey+") is not found!");
		}

	}

	
	

	protected Goods loadInternalGoods(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Goods goods = extractGoods(accessKey, loadOptions);
 	
 		if(isExtractSkuEnabled(loadOptions)){
	 		extractSku(goods, loadOptions);
 		}
  	
 		if(isExtractReceivingSpaceEnabled(loadOptions)){
	 		extractReceivingSpace(goods, loadOptions);
 		}
  	
 		if(isExtractGoodsAllocationEnabled(loadOptions)){
	 		extractGoodsAllocation(goods, loadOptions);
 		}
  	
 		if(isExtractSmartPalletEnabled(loadOptions)){
	 		extractSmartPallet(goods, loadOptions);
 		}
  	
 		if(isExtractShippingSpaceEnabled(loadOptions)){
	 		extractShippingSpace(goods, loadOptions);
 		}
  	
 		if(isExtractTransportTaskEnabled(loadOptions)){
	 		extractTransportTask(goods, loadOptions);
 		}
  	
 		if(isExtractRetailStoreEnabled(loadOptions)){
	 		extractRetailStore(goods, loadOptions);
 		}
  	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(goods, loadOptions);
 		}
  	
 		if(isExtractRetailStoreOrderEnabled(loadOptions)){
	 		extractRetailStoreOrder(goods, loadOptions);
 		}
 
		
		if(isExtractGoodsMovementListEnabled(loadOptions)){
	 		extractGoodsMovementList(goods, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsMovementListEnabled(loadOptions)){
	 		analyzeGoodsMovementList(goods, loadOptions);
 		}
 		
		
		return goods;
		
	}

	 

 	protected Goods extractSku(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getSku() == null){
			return goods;
		}
		String skuId = goods.getSku().getId();
		if( skuId == null){
			return goods;
		}
		Sku sku = getSkuDAO().load(skuId,options);
		if(sku != null){
			goods.setSku(sku);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractReceivingSpace(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getReceivingSpace() == null){
			return goods;
		}
		String receivingSpaceId = goods.getReceivingSpace().getId();
		if( receivingSpaceId == null){
			return goods;
		}
		ReceivingSpace receivingSpace = getReceivingSpaceDAO().load(receivingSpaceId,options);
		if(receivingSpace != null){
			goods.setReceivingSpace(receivingSpace);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractGoodsAllocation(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getGoodsAllocation() == null){
			return goods;
		}
		String goodsAllocationId = goods.getGoodsAllocation().getId();
		if( goodsAllocationId == null){
			return goods;
		}
		GoodsAllocation goodsAllocation = getGoodsAllocationDAO().load(goodsAllocationId,options);
		if(goodsAllocation != null){
			goods.setGoodsAllocation(goodsAllocation);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractSmartPallet(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getSmartPallet() == null){
			return goods;
		}
		String smartPalletId = goods.getSmartPallet().getId();
		if( smartPalletId == null){
			return goods;
		}
		SmartPallet smartPallet = getSmartPalletDAO().load(smartPalletId,options);
		if(smartPallet != null){
			goods.setSmartPallet(smartPallet);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractShippingSpace(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getShippingSpace() == null){
			return goods;
		}
		String shippingSpaceId = goods.getShippingSpace().getId();
		if( shippingSpaceId == null){
			return goods;
		}
		ShippingSpace shippingSpace = getShippingSpaceDAO().load(shippingSpaceId,options);
		if(shippingSpace != null){
			goods.setShippingSpace(shippingSpace);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractTransportTask(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getTransportTask() == null){
			return goods;
		}
		String transportTaskId = goods.getTransportTask().getId();
		if( transportTaskId == null){
			return goods;
		}
		TransportTask transportTask = getTransportTaskDAO().load(transportTaskId,options);
		if(transportTask != null){
			goods.setTransportTask(transportTask);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractRetailStore(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getRetailStore() == null){
			return goods;
		}
		String retailStoreId = goods.getRetailStore().getId();
		if( retailStoreId == null){
			return goods;
		}
		RetailStore retailStore = getRetailStoreDAO().load(retailStoreId,options);
		if(retailStore != null){
			goods.setRetailStore(retailStore);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractBizOrder(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getBizOrder() == null){
			return goods;
		}
		String bizOrderId = goods.getBizOrder().getId();
		if( bizOrderId == null){
			return goods;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			goods.setBizOrder(bizOrder);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractRetailStoreOrder(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getRetailStoreOrder() == null){
			return goods;
		}
		String retailStoreOrderId = goods.getRetailStoreOrder().getId();
		if( retailStoreOrderId == null){
			return goods;
		}
		RetailStoreOrder retailStoreOrder = getRetailStoreOrderDAO().load(retailStoreOrderId,options);
		if(retailStoreOrder != null){
			goods.setRetailStoreOrder(retailStoreOrder);
		}
		
 		
 		return goods;
 	}
 		
 
		
	protected void enhanceGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Goods extractGoodsMovementList(Goods goods, Map<String,Object> options){
		
		
		if(goods == null){
			return null;
		}
		if(goods.getId() == null){
			return goods;
		}

		
		
		SmartList<GoodsMovement> goodsMovementList = getGoodsMovementDAO().findGoodsMovementByGoods(goods.getId(),options);
		if(goodsMovementList != null){
			enhanceGoodsMovementList(goodsMovementList,options);
			goods.setGoodsMovementList(goodsMovementList);
		}
		
		return goods;
	
	}	
	
	protected Goods analyzeGoodsMovementList(Goods goods, Map<String,Object> options){
		
		
		if(goods == null){
			return null;
		}
		if(goods.getId() == null){
			return goods;
		}

		
		
		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		if(goodsMovementList != null){
			getGoodsMovementDAO().analyzeGoodsMovementByGoods(goodsMovementList, goods.getId(), options);
			
		}
		
		return goods;
	
	}	
	
		
		
  	
 	public SmartList<Goods> findGoodsBySku(String skuId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_SKU, skuId, options, getGoodsMapper());
		// analyzeGoodsBySku(resultList, skuId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsBySku(String skuId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_SKU, skuId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsBySku(resultList, skuId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsBySku(SmartList<Goods> resultList, String skuId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.SKU_PROPERTY, skuId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsBySku(String skuId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_SKU, skuId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsBySkuIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_SKU, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_RECEIVING_SPACE, receivingSpaceId, options, getGoodsMapper());
		// analyzeGoodsByReceivingSpace(resultList, receivingSpaceId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_RECEIVING_SPACE, receivingSpaceId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByReceivingSpace(resultList, receivingSpaceId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByReceivingSpace(SmartList<Goods> resultList, String receivingSpaceId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByReceivingSpace(String receivingSpaceId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_RECEIVING_SPACE, receivingSpaceId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByReceivingSpaceIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_RECEIVING_SPACE, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_GOODS_ALLOCATION, goodsAllocationId, options, getGoodsMapper());
		// analyzeGoodsByGoodsAllocation(resultList, goodsAllocationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_GOODS_ALLOCATION, goodsAllocationId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByGoodsAllocation(resultList, goodsAllocationId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByGoodsAllocation(SmartList<Goods> resultList, String goodsAllocationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByGoodsAllocation(String goodsAllocationId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_GOODS_ALLOCATION, goodsAllocationId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByGoodsAllocationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_GOODS_ALLOCATION, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_SMART_PALLET, smartPalletId, options, getGoodsMapper());
		// analyzeGoodsBySmartPallet(resultList, smartPalletId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_SMART_PALLET, smartPalletId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsBySmartPallet(resultList, smartPalletId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsBySmartPallet(SmartList<Goods> resultList, String smartPalletId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsBySmartPallet(String smartPalletId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_SMART_PALLET, smartPalletId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsBySmartPalletIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_SMART_PALLET, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_SHIPPING_SPACE, shippingSpaceId, options, getGoodsMapper());
		// analyzeGoodsByShippingSpace(resultList, shippingSpaceId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_SHIPPING_SPACE, shippingSpaceId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByShippingSpace(resultList, shippingSpaceId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByShippingSpace(SmartList<Goods> resultList, String shippingSpaceId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByShippingSpace(String shippingSpaceId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_SHIPPING_SPACE, shippingSpaceId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByShippingSpaceIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_SHIPPING_SPACE, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_TRANSPORT_TASK, transportTaskId, options, getGoodsMapper());
		// analyzeGoodsByTransportTask(resultList, transportTaskId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_TRANSPORT_TASK, transportTaskId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByTransportTask(resultList, transportTaskId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByTransportTask(SmartList<Goods> resultList, String transportTaskId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByTransportTask(String transportTaskId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_TRANSPORT_TASK, transportTaskId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByTransportTaskIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_TRANSPORT_TASK, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_RETAIL_STORE, retailStoreId, options, getGoodsMapper());
		// analyzeGoodsByRetailStore(resultList, retailStoreId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_RETAIL_STORE, retailStoreId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByRetailStore(resultList, retailStoreId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByRetailStore(SmartList<Goods> resultList, String retailStoreId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByRetailStore(String retailStoreId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_RETAIL_STORE, retailStoreId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByRetailStoreIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_RETAIL_STORE, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_BIZ_ORDER, supplyOrderId, options, getGoodsMapper());
		// analyzeGoodsByBizOrder(resultList, supplyOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_BIZ_ORDER, supplyOrderId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByBizOrder(resultList, supplyOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByBizOrder(SmartList<Goods> resultList, String supplyOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByBizOrder(String supplyOrderId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_BIZ_ORDER, supplyOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
  	
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId,Map<String,Object> options){
 	
  		SmartList<Goods> resultList = queryWith(GoodsTable.COLUMN_RETAIL_STORE_ORDER, retailStoreOrderId, options, getGoodsMapper());
		// analyzeGoodsByRetailStoreOrder(resultList, retailStoreOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Goods> resultList =  queryWithRange(GoodsTable.COLUMN_RETAIL_STORE_ORDER, retailStoreOrderId, options, getGoodsMapper(), start, count);
 		//analyzeGoodsByRetailStoreOrder(resultList, retailStoreOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsByRetailStoreOrder(SmartList<Goods> resultList, String retailStoreOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countGoodsByRetailStoreOrder(String retailStoreOrderId,Map<String,Object> options){

 		return countWith(GoodsTable.COLUMN_RETAIL_STORE_ORDER, retailStoreOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsByRetailStoreOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsTable.COLUMN_RETAIL_STORE_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected Goods saveGoods(Goods  goods){
		
		if(!goods.isChanged()){
			return goods;
		}
		

		String SQL=this.getSaveGoodsSQL(goods);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsParameters(goods);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		goods.incVersion();
		return goods;

	}
	public SmartList<Goods> saveGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsList(goodsList);

		batchGoodsCreate((List<Goods>)lists[CREATE_LIST_INDEX]);

		batchGoodsUpdate((List<Goods>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(Goods goods:goodsList){
			if(goods.isChanged()){
				goods.incVersion();
			}


		}


		return goodsList;
	}

	public SmartList<Goods> removeGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){


		super.removeList(goodsList, options);

		return goodsList;


	}

	protected List<Object[]> prepareGoodsBatchCreateArgs(List<Goods> goodsList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Goods goods:goodsList ){
			Object [] parameters = prepareGoodsCreateParameters(goods);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareGoodsBatchUpdateArgs(List<Goods> goodsList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Goods goods:goodsList ){
			if(!goods.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsUpdateParameters(goods);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchGoodsCreate(List<Goods> goodsList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsBatchCreateArgs(goodsList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchGoodsUpdate(List<Goods> goodsList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsBatchUpdateArgs(goodsList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitGoodsList(List<Goods> goodsList){

		List<Goods> goodsCreateList=new ArrayList<Goods>();
		List<Goods> goodsUpdateList=new ArrayList<Goods>();

		for(Goods goods: goodsList){
			if(isUpdateRequest(goods)){
				goodsUpdateList.add( goods);
				continue;
			}
			goodsCreateList.add(goods);
		}

		return new Object[]{goodsCreateList,goodsUpdateList};
	}

	protected boolean isUpdateRequest(Goods goods){
 		return goods.getVersion() > 0;
 	}
 	protected String getSaveGoodsSQL(Goods goods){
 		if(isUpdateRequest(goods)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveGoodsParameters(Goods goods){
 		if(isUpdateRequest(goods) ){
 			return prepareGoodsUpdateParameters(goods);
 		}
 		return prepareGoodsCreateParameters(goods);
 	}
 	protected Object[] prepareGoodsUpdateParameters(Goods goods){
 		Object[] parameters = new Object[17];
 
 		
 		parameters[0] = goods.getName();
 		
 		
 		parameters[1] = goods.getRfid();
 		
 		
 		parameters[2] = goods.getUom();
 		
 		
 		parameters[3] = goods.getMaxPackage();
 		
 		
 		parameters[4] = goods.getExpireTime();
 		
 		if(goods.getSku() != null){
 			parameters[5] = goods.getSku().getId();
 		}
 
 		if(goods.getReceivingSpace() != null){
 			parameters[6] = goods.getReceivingSpace().getId();
 		}
 
 		if(goods.getGoodsAllocation() != null){
 			parameters[7] = goods.getGoodsAllocation().getId();
 		}
 
 		if(goods.getSmartPallet() != null){
 			parameters[8] = goods.getSmartPallet().getId();
 		}
 
 		if(goods.getShippingSpace() != null){
 			parameters[9] = goods.getShippingSpace().getId();
 		}
 
 		if(goods.getTransportTask() != null){
 			parameters[10] = goods.getTransportTask().getId();
 		}
 
 		if(goods.getRetailStore() != null){
 			parameters[11] = goods.getRetailStore().getId();
 		}
 
 		if(goods.getBizOrder() != null){
 			parameters[12] = goods.getBizOrder().getId();
 		}
 
 		if(goods.getRetailStoreOrder() != null){
 			parameters[13] = goods.getRetailStoreOrder().getId();
 		}
 
 		parameters[14] = goods.nextVersion();
 		parameters[15] = goods.getId();
 		parameters[16] = goods.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareGoodsCreateParameters(Goods goods){
		Object[] parameters = new Object[15];
        if(goods.getId() == null){
          String newGoodsId=getNextId();
          goods.setId(newGoodsId);
        }
		parameters[0] =  goods.getId();
 
 		
 		parameters[1] = goods.getName();
 		
 		
 		parameters[2] = goods.getRfid();
 		
 		
 		parameters[3] = goods.getUom();
 		
 		
 		parameters[4] = goods.getMaxPackage();
 		
 		
 		parameters[5] = goods.getExpireTime();
 		
 		if(goods.getSku() != null){
 			parameters[6] = goods.getSku().getId();

 		}
 		
 		if(goods.getReceivingSpace() != null){
 			parameters[7] = goods.getReceivingSpace().getId();

 		}
 		
 		if(goods.getGoodsAllocation() != null){
 			parameters[8] = goods.getGoodsAllocation().getId();

 		}
 		
 		if(goods.getSmartPallet() != null){
 			parameters[9] = goods.getSmartPallet().getId();

 		}
 		
 		if(goods.getShippingSpace() != null){
 			parameters[10] = goods.getShippingSpace().getId();

 		}
 		
 		if(goods.getTransportTask() != null){
 			parameters[11] = goods.getTransportTask().getId();

 		}
 		
 		if(goods.getRetailStore() != null){
 			parameters[12] = goods.getRetailStore().getId();

 		}
 		
 		if(goods.getBizOrder() != null){
 			parameters[13] = goods.getBizOrder().getId();

 		}
 		
 		if(goods.getRetailStoreOrder() != null){
 			parameters[14] = goods.getRetailStoreOrder().getId();

 		}
 		

 		return parameters;
 	}

	protected Goods saveInternalGoods(Goods goods, Map<String,Object> options){

		saveGoods(goods);

 		if(isSaveSkuEnabled(options)){
	 		saveSku(goods, options);
 		}
 
 		if(isSaveReceivingSpaceEnabled(options)){
	 		saveReceivingSpace(goods, options);
 		}
 
 		if(isSaveGoodsAllocationEnabled(options)){
	 		saveGoodsAllocation(goods, options);
 		}
 
 		if(isSaveSmartPalletEnabled(options)){
	 		saveSmartPallet(goods, options);
 		}
 
 		if(isSaveShippingSpaceEnabled(options)){
	 		saveShippingSpace(goods, options);
 		}
 
 		if(isSaveTransportTaskEnabled(options)){
	 		saveTransportTask(goods, options);
 		}
 
 		if(isSaveRetailStoreEnabled(options)){
	 		saveRetailStore(goods, options);
 		}
 
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(goods, options);
 		}
 
 		if(isSaveRetailStoreOrderEnabled(options)){
	 		saveRetailStoreOrder(goods, options);
 		}
 
		
		if(isSaveGoodsMovementListEnabled(options)){
	 		saveGoodsMovementList(goods, options);
	 		//removeGoodsMovementList(goods, options);
	 		//Not delete the record

 		}
		
		return goods;

	}



	//======================================================================================
	

 	protected Goods saveSku(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getSku() == null){
 			return goods;//do nothing when it is null
 		}

 		getSkuDAO().save(goods.getSku(),options);
 		return goods;

 	}





 

 	protected Goods saveReceivingSpace(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getReceivingSpace() == null){
 			return goods;//do nothing when it is null
 		}

 		getReceivingSpaceDAO().save(goods.getReceivingSpace(),options);
 		return goods;

 	}





 

 	protected Goods saveGoodsAllocation(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getGoodsAllocation() == null){
 			return goods;//do nothing when it is null
 		}

 		getGoodsAllocationDAO().save(goods.getGoodsAllocation(),options);
 		return goods;

 	}





 

 	protected Goods saveSmartPallet(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getSmartPallet() == null){
 			return goods;//do nothing when it is null
 		}

 		getSmartPalletDAO().save(goods.getSmartPallet(),options);
 		return goods;

 	}





 

 	protected Goods saveShippingSpace(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getShippingSpace() == null){
 			return goods;//do nothing when it is null
 		}

 		getShippingSpaceDAO().save(goods.getShippingSpace(),options);
 		return goods;

 	}





 

 	protected Goods saveTransportTask(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getTransportTask() == null){
 			return goods;//do nothing when it is null
 		}

 		getTransportTaskDAO().save(goods.getTransportTask(),options);
 		return goods;

 	}





 

 	protected Goods saveRetailStore(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getRetailStore() == null){
 			return goods;//do nothing when it is null
 		}

 		getRetailStoreDAO().save(goods.getRetailStore(),options);
 		return goods;

 	}





 

 	protected Goods saveBizOrder(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getBizOrder() == null){
 			return goods;//do nothing when it is null
 		}

 		getSupplyOrderDAO().save(goods.getBizOrder(),options);
 		return goods;

 	}





 

 	protected Goods saveRetailStoreOrder(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getRetailStoreOrder() == null){
 			return goods;//do nothing when it is null
 		}

 		getRetailStoreOrderDAO().save(goods.getRetailStoreOrder(),options);
 		return goods;

 	}





 

	
	public Goods planToRemoveGoodsMovementList(Goods goods, String goodsMovementIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsMovement.GOODS_PROPERTY, goods.getId());
		key.put(GoodsMovement.ID_PROPERTY, goodsMovementIds);

		SmartList<GoodsMovement> externalGoodsMovementList = getGoodsMovementDAO().
				findGoodsMovementWithKey(key, options);
		if(externalGoodsMovementList == null){
			return goods;
		}
		if(externalGoodsMovementList.isEmpty()){
			return goods;
		}

		for(GoodsMovement goodsMovementItem: externalGoodsMovementList){

			goodsMovementItem.clearFromAll();
		}


		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		goodsMovementList.addAllToRemoveList(externalGoodsMovementList);
		return goods;

	}



		
	protected Goods saveGoodsMovementList(Goods goods, Map<String,Object> options){




		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		if(goodsMovementList == null){
			//null list means nothing
			return goods;
		}
		SmartList<GoodsMovement> mergedUpdateGoodsMovementList = new SmartList<GoodsMovement>();


		mergedUpdateGoodsMovementList.addAll(goodsMovementList);
		if(goodsMovementList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsMovementList.addAll(goodsMovementList.getToRemoveList());
			goodsMovementList.removeAll(goodsMovementList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getGoodsMovementDAO().saveGoodsMovementList(mergedUpdateGoodsMovementList,options);

		if(goodsMovementList.getToRemoveList() != null){
			goodsMovementList.removeAll(goodsMovementList.getToRemoveList());
		}


		return goods;

	}

	protected Goods removeGoodsMovementList(Goods goods, Map<String,Object> options){


		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		if(goodsMovementList == null){
			return goods;
		}

		SmartList<GoodsMovement> toRemoveGoodsMovementList = goodsMovementList.getToRemoveList();

		if(toRemoveGoodsMovementList == null){
			return goods;
		}
		if(toRemoveGoodsMovementList.isEmpty()){
			return goods;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsMovementDAO().removeGoodsMovementList(toRemoveGoodsMovementList,options);

		return goods;

	}








		

	public Goods present(Goods goods,Map<String, Object> options){
	
		presentGoodsMovementList(goods,options);

		return goods;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Goods presentGoodsMovementList(
			Goods goods,
			Map<String, Object> options) {

		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();		
				SmartList<GoodsMovement> newList= presentSubList(goods.getId(),
				goodsMovementList,
				options,
				getGoodsMovementDAO()::countGoodsMovementByGoods,
				getGoodsMovementDAO()::findGoodsMovementByGoods
				);

		
		goods.setGoodsMovementList(newList);
		

		return goods;
	}			
		

	
    public SmartList<Goods> requestCandidateGoodsForGoodsMovement(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GoodsTable.COLUMN_NAME, GoodsTable.COLUMN_SKU, filterKey, pageNo, pageSize, getGoodsMapper());
    }
		

	protected String getTableName(){
		return GoodsTable.TABLE_NAME;
	}



	public void enhanceList(List<Goods> goodsList) {
		this.enhanceListInternal(goodsList, this.getGoodsMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:GoodsMovement的goods的GoodsMovementList
	public SmartList<GoodsMovement> loadOurGoodsMovementList(RetailscmUserContext userContext, List<Goods> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsMovement.GOODS_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<GoodsMovement> loadedObjs = userContext.getDAOGroup().getGoodsMovementDAO().findGoodsMovementWithKey(key, options);
		Map<String, List<GoodsMovement>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getGoods().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<GoodsMovement> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<GoodsMovement> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsMovementList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Goods> goodsList = ownerEntity.collectRefsWithType(Goods.INTERNAL_TYPE);
		this.enhanceList(goodsList);

	}

	@Override
	public SmartList<Goods> findGoodsWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getGoodsMapper());

	}
	@Override
	public int countGoodsWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countGoodsWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<Goods> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGoodsMapper());
	}

  @Override
  public Stream<Goods> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getGoodsMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateGoods executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateGoods result = new CandidateGoods();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	

}


