
package com.doublechaintech.retailscm.supplyorder;

import com.doublechaintech.retailscm.Beans;
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


import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;

import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemDAO;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class SupplyOrderJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SupplyOrderDAO{

	protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;
	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){

 		if(retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
 		}
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
 		if(this.retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreCountryCenterDAO;
 	}

	protected GoodsSupplierDAO goodsSupplierDAO;
	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){

 		if(goodsSupplierDAO == null){
 			throw new IllegalStateException("Do not try to set goodsSupplierDAO to null.");
 		}
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
 		if(this.goodsSupplierDAO == null){
 			throw new IllegalStateException("The goodsSupplierDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsSupplierDAO;
 	}

	protected SupplyOrderLineItemDAO supplyOrderLineItemDAO;
	public void setSupplyOrderLineItemDAO(SupplyOrderLineItemDAO supplyOrderLineItemDAO){

 		if(supplyOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderLineItemDAO to null.");
 		}
	 	this.supplyOrderLineItemDAO = supplyOrderLineItemDAO;
 	}
 	public SupplyOrderLineItemDAO getSupplyOrderLineItemDAO(){
 		if(this.supplyOrderLineItemDAO == null){
 			throw new IllegalStateException("The supplyOrderLineItemDAO is not configured yet, please config it some where.");
 		}

	 	return this.supplyOrderLineItemDAO;
 	}

	protected SupplyOrderShippingGroupDAO supplyOrderShippingGroupDAO;
	public void setSupplyOrderShippingGroupDAO(SupplyOrderShippingGroupDAO supplyOrderShippingGroupDAO){

 		if(supplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderShippingGroupDAO to null.");
 		}
	 	this.supplyOrderShippingGroupDAO = supplyOrderShippingGroupDAO;
 	}
 	public SupplyOrderShippingGroupDAO getSupplyOrderShippingGroupDAO(){
 		if(this.supplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The supplyOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}

	 	return this.supplyOrderShippingGroupDAO;
 	}

	protected SupplyOrderPaymentGroupDAO supplyOrderPaymentGroupDAO;
	public void setSupplyOrderPaymentGroupDAO(SupplyOrderPaymentGroupDAO supplyOrderPaymentGroupDAO){

 		if(supplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderPaymentGroupDAO to null.");
 		}
	 	this.supplyOrderPaymentGroupDAO = supplyOrderPaymentGroupDAO;
 	}
 	public SupplyOrderPaymentGroupDAO getSupplyOrderPaymentGroupDAO(){
 		if(this.supplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The supplyOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}

	 	return this.supplyOrderPaymentGroupDAO;
 	}

	protected GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO){

 		if(goodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsDAO;
 	}



	/*
	protected SupplyOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrder(accessKey, options);
	}
	*/

	public SmartList<SupplyOrder> loadAll() {
	    return this.loadAll(getSupplyOrderMapper());
	}

  public Stream<SupplyOrder> loadAllAsStream() {
      return this.loadAllAsStream(getSupplyOrderMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public SupplyOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrder(SupplyOrderTable.withId(id), options);
	}

	

	public SupplyOrder save(SupplyOrder supplyOrder,Map<String,Object> options){

		String methodName="save(SupplyOrder supplyOrder,Map<String,Object> options)";

		assertMethodArgumentNotNull(supplyOrder, methodName, "supplyOrder");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalSupplyOrder(supplyOrder,options);
	}
	public SupplyOrder clone(String supplyOrderId, Map<String,Object> options) throws Exception{

		return clone(SupplyOrderTable.withId(supplyOrderId),options);
	}

	protected SupplyOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String supplyOrderId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		SupplyOrder newSupplyOrder = loadInternalSupplyOrder(accessKey, options);
		newSupplyOrder.setVersion(0);
		
		

 		if(isSaveSupplyOrderLineItemListEnabled(options)){
 			for(SupplyOrderLineItem item: newSupplyOrder.getSupplyOrderLineItemList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveSupplyOrderShippingGroupListEnabled(options)){
 			for(SupplyOrderShippingGroup item: newSupplyOrder.getSupplyOrderShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveSupplyOrderPaymentGroupListEnabled(options)){
 			for(SupplyOrderPaymentGroup item: newSupplyOrder.getSupplyOrderPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newSupplyOrder.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalSupplyOrder(newSupplyOrder,options);

		return newSupplyOrder;
	}

	



	protected void throwIfHasException(String supplyOrderId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String supplyOrderId, int version) throws Exception{

		String methodName="delete(String supplyOrderId, int version)";
		assertMethodArgumentNotNull(supplyOrderId, methodName, "supplyOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderId,version);
		}


	}






	public SupplyOrder disconnectFromAll(String supplyOrderId, int version) throws Exception{


		SupplyOrder supplyOrder = loadInternalSupplyOrder(SupplyOrderTable.withId(supplyOrderId), emptyOptions());
		supplyOrder.clearFromAll();
		this.saveSupplyOrder(supplyOrder);
		return supplyOrder;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "supply_order";
	}
	@Override
	protected String getBeanName() {

		return "supplyOrder";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return SupplyOrderTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){

	 	return checkOptions(options, SupplyOrderTokens.BUYER);
 	}

 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){

 		return checkOptions(options, SupplyOrderTokens.BUYER);
 	}



 

 	protected boolean isExtractSellerEnabled(Map<String,Object> options){

	 	return checkOptions(options, SupplyOrderTokens.SELLER);
 	}

 	protected boolean isSaveSellerEnabled(Map<String,Object> options){

 		return checkOptions(options, SupplyOrderTokens.SELLER);
 	}



 
		

	protected boolean isExtractSupplyOrderLineItemListEnabled(Map<String,Object> options){
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_LINE_ITEM_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderLineItemListEnabled(Map<String,Object> options){
 		return SupplyOrderTokens.of(options).analyzeSupplyOrderLineItemListEnabled();
 	}

	protected boolean isSaveSupplyOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_LINE_ITEM_LIST);

 	}

		

	protected boolean isExtractSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_SHIPPING_GROUP_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
 		return SupplyOrderTokens.of(options).analyzeSupplyOrderShippingGroupListEnabled();
 	}

	protected boolean isSaveSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_SHIPPING_GROUP_LIST);

 	}

		

	protected boolean isExtractSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_PAYMENT_GROUP_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
 		return SupplyOrderTokens.of(options).analyzeSupplyOrderPaymentGroupListEnabled();
 	}

	protected boolean isSaveSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_PAYMENT_GROUP_LIST);

 	}

		

	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
 		return checkOptions(options,SupplyOrderTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){
 		return SupplyOrderTokens.of(options).analyzeGoodsListEnabled();
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.GOODS_LIST);

 	}

		

	

	protected SupplyOrderMapper getSupplyOrderMapper(){
		return new SupplyOrderMapper();
	}



	protected SupplyOrder extractSupplyOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrder supplyOrder = loadSingleObject(accessKey, getSupplyOrderMapper());
			return supplyOrder;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderNotFoundException("SupplyOrder("+accessKey+") is not found!");
		}

	}




	protected SupplyOrder loadInternalSupplyOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		SupplyOrder supplyOrder = extractSupplyOrder(accessKey, loadOptions);

 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(supplyOrder, loadOptions);
 		}
 
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(supplyOrder, loadOptions);
 		}
 
		
		if(isExtractSupplyOrderLineItemListEnabled(loadOptions)){
	 		extractSupplyOrderLineItemList(supplyOrder, loadOptions);
 		}

 		
 		if(isAnalyzeSupplyOrderLineItemListEnabled(loadOptions)){
	 		analyzeSupplyOrderLineItemList(supplyOrder, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderShippingGroupListEnabled(loadOptions)){
	 		extractSupplyOrderShippingGroupList(supplyOrder, loadOptions);
 		}

 		
 		if(isAnalyzeSupplyOrderShippingGroupListEnabled(loadOptions)){
	 		analyzeSupplyOrderShippingGroupList(supplyOrder, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderPaymentGroupListEnabled(loadOptions)){
	 		extractSupplyOrderPaymentGroupList(supplyOrder, loadOptions);
 		}

 		
 		if(isAnalyzeSupplyOrderPaymentGroupListEnabled(loadOptions)){
	 		analyzeSupplyOrderPaymentGroupList(supplyOrder, loadOptions);
 		}
 		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(supplyOrder, loadOptions);
 		}

 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(supplyOrder, loadOptions);
 		}
 		
		
		return supplyOrder;

	}

	

 	protected SupplyOrder extractBuyer(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{
  

		if(supplyOrder.getBuyer() == null){
			return supplyOrder;
		}
		String buyerId = supplyOrder.getBuyer().getId();
		if( buyerId == null){
			return supplyOrder;
		}
		RetailStoreCountryCenter buyer = getRetailStoreCountryCenterDAO().load(buyerId,options);
		if(buyer != null){
			supplyOrder.setBuyer(buyer);
		}


 		return supplyOrder;
 	}

 

 	protected SupplyOrder extractSeller(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{
  

		if(supplyOrder.getSeller() == null){
			return supplyOrder;
		}
		String sellerId = supplyOrder.getSeller().getId();
		if( sellerId == null){
			return supplyOrder;
		}
		GoodsSupplier seller = getGoodsSupplierDAO().load(sellerId,options);
		if(seller != null){
			supplyOrder.setSeller(seller);
		}


 		return supplyOrder;
 	}

 
		
	protected void enhanceSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected SupplyOrder extractSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){
    

		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = getSupplyOrderLineItemDAO().findSupplyOrderLineItemByBizOrder(supplyOrder.getId(),options);
		if(supplyOrderLineItemList != null){
			enhanceSupplyOrderLineItemList(supplyOrderLineItemList,options);
			supplyOrder.setSupplyOrderLineItemList(supplyOrderLineItemList);
		}

		return supplyOrder;
  
	}

	protected SupplyOrder analyzeSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){
     
		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		if(supplyOrderLineItemList != null){
			getSupplyOrderLineItemDAO().analyzeSupplyOrderLineItemByBizOrder(supplyOrderLineItemList, supplyOrder.getId(), options);

		}

		return supplyOrder;
    
	}

		
	protected void enhanceSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected SupplyOrder extractSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
    

		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = getSupplyOrderShippingGroupDAO().findSupplyOrderShippingGroupByBizOrder(supplyOrder.getId(),options);
		if(supplyOrderShippingGroupList != null){
			enhanceSupplyOrderShippingGroupList(supplyOrderShippingGroupList,options);
			supplyOrder.setSupplyOrderShippingGroupList(supplyOrderShippingGroupList);
		}

		return supplyOrder;
  
	}

	protected SupplyOrder analyzeSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
     
		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		if(supplyOrderShippingGroupList != null){
			getSupplyOrderShippingGroupDAO().analyzeSupplyOrderShippingGroupByBizOrder(supplyOrderShippingGroupList, supplyOrder.getId(), options);

		}

		return supplyOrder;
    
	}

		
	protected void enhanceSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected SupplyOrder extractSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
    

		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = getSupplyOrderPaymentGroupDAO().findSupplyOrderPaymentGroupByBizOrder(supplyOrder.getId(),options);
		if(supplyOrderPaymentGroupList != null){
			enhanceSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList,options);
			supplyOrder.setSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList);
		}

		return supplyOrder;
  
	}

	protected SupplyOrder analyzeSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
     
		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		if(supplyOrderPaymentGroupList != null){
			getSupplyOrderPaymentGroupDAO().analyzeSupplyOrderPaymentGroupByBizOrder(supplyOrderPaymentGroupList, supplyOrder.getId(), options);

		}

		return supplyOrder;
    
	}

		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected SupplyOrder extractGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){
    

		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByBizOrder(supplyOrder.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			supplyOrder.setGoodsList(goodsList);
		}

		return supplyOrder;
  
	}

	protected SupplyOrder analyzeGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){
     
		if(supplyOrder == null){
			return null;
		}
		if(supplyOrder.getId() == null){
			return supplyOrder;
		}



		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByBizOrder(goodsList, supplyOrder.getId(), options);

		}

		return supplyOrder;
    
	}

		

 
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_BUYER, retailStoreCountryCenterId, options, getSupplyOrderMapper());
		// analyzeSupplyOrderByBuyer(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_BUYER, retailStoreCountryCenterId, options, getSupplyOrderMapper(), start, count);
 		//analyzeSupplyOrderByBuyer(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeSupplyOrderByBuyer(SmartList<SupplyOrder> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.BUYER_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//SupplyOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("供应订单");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(SupplyOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(SupplyOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countSupplyOrderByBuyer(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_BUYER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByBuyerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_BUYER, ids, options);
	}

 
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId,Map<String,Object> options){

  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_SELLER, goodsSupplierId, options, getSupplyOrderMapper());
		// analyzeSupplyOrderBySeller(resultList, goodsSupplierId, options);
		return resultList;
 	}
 	

 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, int start, int count,Map<String,Object> options){

 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_SELLER, goodsSupplierId, options, getSupplyOrderMapper(), start, count);
 		//analyzeSupplyOrderBySeller(resultList, goodsSupplierId, options);
 		return resultList;

 	}
 	public void analyzeSupplyOrderBySeller(SmartList<SupplyOrder> resultList, String goodsSupplierId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.SELLER_PROPERTY, goodsSupplierId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//SupplyOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("供应订单");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(SupplyOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(SupplyOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countSupplyOrderBySeller(String goodsSupplierId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_SELLER, goodsSupplierId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderBySellerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_SELLER, ids, options);
	}

 




	

	protected SupplyOrder saveSupplyOrder(SupplyOrder  supplyOrder){
    

		
		if(!supplyOrder.isChanged()){
			return supplyOrder;
		}
		

    Beans.dbUtil().cacheCleanUp(supplyOrder);
		String SQL=this.getSaveSupplyOrderSQL(supplyOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderParameters(supplyOrder);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		supplyOrder.incVersion();
		supplyOrder.afterSave();
		return supplyOrder;

	}
	public SmartList<SupplyOrder> saveSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderList(supplyOrderList);

		batchSupplyOrderCreate((List<SupplyOrder>)lists[CREATE_LIST_INDEX]);

		batchSupplyOrderUpdate((List<SupplyOrder>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(SupplyOrder supplyOrder:supplyOrderList){
			if(supplyOrder.isChanged()){
				supplyOrder.incVersion();
				supplyOrder.afterSave();
			}


		}


		return supplyOrderList;
	}

	public SmartList<SupplyOrder> removeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){


		super.removeList(supplyOrderList, options);

		return supplyOrderList;


	}

	protected List<Object[]> prepareSupplyOrderBatchCreateArgs(List<SupplyOrder> supplyOrderList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrder supplyOrder:supplyOrderList ){
			Object [] parameters = prepareSupplyOrderCreateParameters(supplyOrder);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareSupplyOrderBatchUpdateArgs(List<SupplyOrder> supplyOrderList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrder supplyOrder:supplyOrderList ){
			if(!supplyOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderUpdateParameters(supplyOrder);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchSupplyOrderCreate(List<SupplyOrder> supplyOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderBatchCreateArgs(supplyOrderList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchSupplyOrderUpdate(List<SupplyOrder> supplyOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderBatchUpdateArgs(supplyOrderList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitSupplyOrderList(List<SupplyOrder> supplyOrderList){

		List<SupplyOrder> supplyOrderCreateList=new ArrayList<SupplyOrder>();
		List<SupplyOrder> supplyOrderUpdateList=new ArrayList<SupplyOrder>();

		for(SupplyOrder supplyOrder: supplyOrderList){
			if(isUpdateRequest(supplyOrder)){
				supplyOrderUpdateList.add( supplyOrder);
				continue;
			}
			supplyOrderCreateList.add(supplyOrder);
		}

		return new Object[]{supplyOrderCreateList,supplyOrderUpdateList};
	}

	protected boolean isUpdateRequest(SupplyOrder supplyOrder){
 		return supplyOrder.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderSQL(SupplyOrder supplyOrder){
 		if(isUpdateRequest(supplyOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveSupplyOrderParameters(SupplyOrder supplyOrder){
 		if(isUpdateRequest(supplyOrder) ){
 			return prepareSupplyOrderUpdateParameters(supplyOrder);
 		}
 		return prepareSupplyOrderCreateParameters(supplyOrder);
 	}
 	protected Object[] prepareSupplyOrderUpdateParameters(SupplyOrder supplyOrder){
 		Object[] parameters = new Object[9];
 
 		if(supplyOrder.getBuyer() != null){
 			parameters[0] = supplyOrder.getBuyer().getId();
 		}
    
 		if(supplyOrder.getSeller() != null){
 			parameters[1] = supplyOrder.getSeller().getId();
 		}
    
 		parameters[2] = supplyOrder.getTitle();
 		
 		parameters[3] = supplyOrder.getContract();
 		
 		parameters[4] = supplyOrder.getTotalAmount();
 		
 		parameters[5] = supplyOrder.getLastUpdateTime();
 		
 		parameters[6] = supplyOrder.nextVersion();
 		parameters[7] = supplyOrder.getId();
 		parameters[8] = supplyOrder.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderCreateParameters(SupplyOrder supplyOrder){
		Object[] parameters = new Object[7];
        if(supplyOrder.getId() == null){
          String newSupplyOrderId=getNextId();
          supplyOrder.setId(newSupplyOrderId);
        }
		parameters[0] =  supplyOrder.getId();
 
 		if(supplyOrder.getBuyer() != null){
 			parameters[1] = supplyOrder.getBuyer().getId();
 		}
 		
 		if(supplyOrder.getSeller() != null){
 			parameters[2] = supplyOrder.getSeller().getId();
 		}
 		
 		parameters[3] = supplyOrder.getTitle();
 		
 		parameters[4] = supplyOrder.getContract();
 		
 		parameters[5] = supplyOrder.getTotalAmount();
 		
 		parameters[6] = supplyOrder.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected SupplyOrder saveInternalSupplyOrder(SupplyOrder supplyOrder, Map<String,Object> options){

 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(supplyOrder, options);
 		}
 
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(supplyOrder, options);
 		}
 
   saveSupplyOrder(supplyOrder);
		
		if(isSaveSupplyOrderLineItemListEnabled(options)){
	 		saveSupplyOrderLineItemList(supplyOrder, options);
	 		//removeSupplyOrderLineItemList(supplyOrder, options);
	 		//Not delete the record

 		}
		
		if(isSaveSupplyOrderShippingGroupListEnabled(options)){
	 		saveSupplyOrderShippingGroupList(supplyOrder, options);
	 		//removeSupplyOrderShippingGroupList(supplyOrder, options);
	 		//Not delete the record

 		}
		
		if(isSaveSupplyOrderPaymentGroupListEnabled(options)){
	 		saveSupplyOrderPaymentGroupList(supplyOrder, options);
	 		//removeSupplyOrderPaymentGroupList(supplyOrder, options);
	 		//Not delete the record

 		}
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(supplyOrder, options);
	 		//removeGoodsList(supplyOrder, options);
	 		//Not delete the record

 		}
		
		return supplyOrder;

	}



	//======================================================================================
	

 	protected SupplyOrder saveBuyer(SupplyOrder supplyOrder, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(supplyOrder.getBuyer() == null){
 			return supplyOrder;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(supplyOrder.getBuyer(),options);
 		return supplyOrder;

 	}
 

 	protected SupplyOrder saveSeller(SupplyOrder supplyOrder, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(supplyOrder.getSeller() == null){
 			return supplyOrder;//do nothing when it is null
 		}

 		getGoodsSupplierDAO().save(supplyOrder.getSeller(),options);
 		return supplyOrder;

 	}
 

	
	public SupplyOrder planToRemoveSupplyOrderLineItemList(SupplyOrder supplyOrder, String supplyOrderLineItemIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(SupplyOrderLineItem.ID_PROPERTY, supplyOrderLineItemIds);

		SmartList<SupplyOrderLineItem> externalSupplyOrderLineItemList = getSupplyOrderLineItemDAO().
				findSupplyOrderLineItemWithKey(key, options);
		if(externalSupplyOrderLineItemList == null){
			return supplyOrder;
		}
		if(externalSupplyOrderLineItemList.isEmpty()){
			return supplyOrder;
		}

		for(SupplyOrderLineItem supplyOrderLineItemItem: externalSupplyOrderLineItemList){

			supplyOrderLineItemItem.clearFromAll();
		}


		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		supplyOrderLineItemList.addAllToRemoveList(externalSupplyOrderLineItemList);
		return supplyOrder;

	}


	public SupplyOrder planToRemoveSupplyOrderShippingGroupList(SupplyOrder supplyOrder, String supplyOrderShippingGroupIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(SupplyOrderShippingGroup.ID_PROPERTY, supplyOrderShippingGroupIds);

		SmartList<SupplyOrderShippingGroup> externalSupplyOrderShippingGroupList = getSupplyOrderShippingGroupDAO().
				findSupplyOrderShippingGroupWithKey(key, options);
		if(externalSupplyOrderShippingGroupList == null){
			return supplyOrder;
		}
		if(externalSupplyOrderShippingGroupList.isEmpty()){
			return supplyOrder;
		}

		for(SupplyOrderShippingGroup supplyOrderShippingGroupItem: externalSupplyOrderShippingGroupList){

			supplyOrderShippingGroupItem.clearFromAll();
		}


		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		supplyOrderShippingGroupList.addAllToRemoveList(externalSupplyOrderShippingGroupList);
		return supplyOrder;

	}


	public SupplyOrder planToRemoveSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, String supplyOrderPaymentGroupIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(SupplyOrderPaymentGroup.ID_PROPERTY, supplyOrderPaymentGroupIds);

		SmartList<SupplyOrderPaymentGroup> externalSupplyOrderPaymentGroupList = getSupplyOrderPaymentGroupDAO().
				findSupplyOrderPaymentGroupWithKey(key, options);
		if(externalSupplyOrderPaymentGroupList == null){
			return supplyOrder;
		}
		if(externalSupplyOrderPaymentGroupList.isEmpty()){
			return supplyOrder;
		}

		for(SupplyOrderPaymentGroup supplyOrderPaymentGroupItem: externalSupplyOrderPaymentGroupList){

			supplyOrderPaymentGroupItem.clearFromAll();
		}


		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		supplyOrderPaymentGroupList.addAllToRemoveList(externalSupplyOrderPaymentGroupList);
		return supplyOrder;

	}


	public SupplyOrder planToRemoveGoodsList(SupplyOrder supplyOrder, String goodsIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;

	}


	//disconnect SupplyOrder with sku in Goods
	public SupplyOrder planToRemoveGoodsListWithSku(SupplyOrder supplyOrder, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.SKU_PROPERTY, skuId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithSku(String supplyOrderId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.SKU_PROPERTY, skuId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with receiving_space in Goods
	public SupplyOrder planToRemoveGoodsListWithReceivingSpace(SupplyOrder supplyOrder, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithReceivingSpace(String supplyOrderId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with goods_allocation in Goods
	public SupplyOrder planToRemoveGoodsListWithGoodsAllocation(SupplyOrder supplyOrder, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithGoodsAllocation(String supplyOrderId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with smart_pallet in Goods
	public SupplyOrder planToRemoveGoodsListWithSmartPallet(SupplyOrder supplyOrder, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithSmartPallet(String supplyOrderId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with shipping_space in Goods
	public SupplyOrder planToRemoveGoodsListWithShippingSpace(SupplyOrder supplyOrder, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithShippingSpace(String supplyOrderId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with transport_task in Goods
	public SupplyOrder planToRemoveGoodsListWithTransportTask(SupplyOrder supplyOrder, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithTransportTask(String supplyOrderId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with retail_store in Goods
	public SupplyOrder planToRemoveGoodsListWithRetailStore(SupplyOrder supplyOrder, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithRetailStore(String supplyOrderId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrder with retail_store_order in Goods
	public SupplyOrder planToRemoveGoodsListWithRetailStoreOrder(SupplyOrder supplyOrder, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return supplyOrder;
		}
		if(externalGoodsList.isEmpty()){
			return supplyOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearBizOrder();

		}


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return supplyOrder;
	}

	public int countGoodsListWithRetailStoreOrder(String supplyOrderId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrder saveSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){
    



		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		if(supplyOrderLineItemList == null){
			//null list means nothing
			return supplyOrder;
		}
		SmartList<SupplyOrderLineItem> mergedUpdateSupplyOrderLineItemList = new SmartList<SupplyOrderLineItem>();


		mergedUpdateSupplyOrderLineItemList.addAll(supplyOrderLineItemList);
		if(supplyOrderLineItemList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderLineItemList.addAll(supplyOrderLineItemList.getToRemoveList());
			supplyOrderLineItemList.removeAll(supplyOrderLineItemList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getSupplyOrderLineItemDAO().saveSupplyOrderLineItemList(mergedUpdateSupplyOrderLineItemList,options);

		if(supplyOrderLineItemList.getToRemoveList() != null){
			supplyOrderLineItemList.removeAll(supplyOrderLineItemList.getToRemoveList());
		}


		return supplyOrder;

	}

	protected SupplyOrder removeSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){


		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		if(supplyOrderLineItemList == null){
			return supplyOrder;
		}

		SmartList<SupplyOrderLineItem> toRemoveSupplyOrderLineItemList = supplyOrderLineItemList.getToRemoveList();

		if(toRemoveSupplyOrderLineItemList == null){
			return supplyOrder;
		}
		if(toRemoveSupplyOrderLineItemList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getSupplyOrderLineItemDAO().removeSupplyOrderLineItemList(toRemoveSupplyOrderLineItemList,options);

		return supplyOrder;

	}








		
	protected SupplyOrder saveSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
    



		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		if(supplyOrderShippingGroupList == null){
			//null list means nothing
			return supplyOrder;
		}
		SmartList<SupplyOrderShippingGroup> mergedUpdateSupplyOrderShippingGroupList = new SmartList<SupplyOrderShippingGroup>();


		mergedUpdateSupplyOrderShippingGroupList.addAll(supplyOrderShippingGroupList);
		if(supplyOrderShippingGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderShippingGroupList.addAll(supplyOrderShippingGroupList.getToRemoveList());
			supplyOrderShippingGroupList.removeAll(supplyOrderShippingGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getSupplyOrderShippingGroupDAO().saveSupplyOrderShippingGroupList(mergedUpdateSupplyOrderShippingGroupList,options);

		if(supplyOrderShippingGroupList.getToRemoveList() != null){
			supplyOrderShippingGroupList.removeAll(supplyOrderShippingGroupList.getToRemoveList());
		}


		return supplyOrder;

	}

	protected SupplyOrder removeSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){


		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		if(supplyOrderShippingGroupList == null){
			return supplyOrder;
		}

		SmartList<SupplyOrderShippingGroup> toRemoveSupplyOrderShippingGroupList = supplyOrderShippingGroupList.getToRemoveList();

		if(toRemoveSupplyOrderShippingGroupList == null){
			return supplyOrder;
		}
		if(toRemoveSupplyOrderShippingGroupList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getSupplyOrderShippingGroupDAO().removeSupplyOrderShippingGroupList(toRemoveSupplyOrderShippingGroupList,options);

		return supplyOrder;

	}








		
	protected SupplyOrder saveSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
    



		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		if(supplyOrderPaymentGroupList == null){
			//null list means nothing
			return supplyOrder;
		}
		SmartList<SupplyOrderPaymentGroup> mergedUpdateSupplyOrderPaymentGroupList = new SmartList<SupplyOrderPaymentGroup>();


		mergedUpdateSupplyOrderPaymentGroupList.addAll(supplyOrderPaymentGroupList);
		if(supplyOrderPaymentGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderPaymentGroupList.addAll(supplyOrderPaymentGroupList.getToRemoveList());
			supplyOrderPaymentGroupList.removeAll(supplyOrderPaymentGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getSupplyOrderPaymentGroupDAO().saveSupplyOrderPaymentGroupList(mergedUpdateSupplyOrderPaymentGroupList,options);

		if(supplyOrderPaymentGroupList.getToRemoveList() != null){
			supplyOrderPaymentGroupList.removeAll(supplyOrderPaymentGroupList.getToRemoveList());
		}


		return supplyOrder;

	}

	protected SupplyOrder removeSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){


		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		if(supplyOrderPaymentGroupList == null){
			return supplyOrder;
		}

		SmartList<SupplyOrderPaymentGroup> toRemoveSupplyOrderPaymentGroupList = supplyOrderPaymentGroupList.getToRemoveList();

		if(toRemoveSupplyOrderPaymentGroupList == null){
			return supplyOrder;
		}
		if(toRemoveSupplyOrderPaymentGroupList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getSupplyOrderPaymentGroupDAO().removeSupplyOrderPaymentGroupList(toRemoveSupplyOrderPaymentGroupList,options);

		return supplyOrder;

	}








		
	protected SupplyOrder saveGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){
    



		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return supplyOrder;
		}
		SmartList<Goods> mergedUpdateGoodsList = new SmartList<Goods>();


		mergedUpdateGoodsList.addAll(goodsList);
		if(goodsList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsList.addAll(goodsList.getToRemoveList());
			goodsList.removeAll(goodsList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getGoodsDAO().saveGoodsList(mergedUpdateGoodsList,options);

		if(goodsList.getToRemoveList() != null){
			goodsList.removeAll(goodsList.getToRemoveList());
		}


		return supplyOrder;

	}

	protected SupplyOrder removeGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){


		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		if(goodsList == null){
			return supplyOrder;
		}

		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

		if(toRemoveGoodsList == null){
			return supplyOrder;
		}
		if(toRemoveGoodsList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);

		return supplyOrder;

	}








		

	public SupplyOrder present(SupplyOrder supplyOrder,Map<String, Object> options){

		presentSupplyOrderLineItemList(supplyOrder,options);
		presentSupplyOrderShippingGroupList(supplyOrder,options);
		presentSupplyOrderPaymentGroupList(supplyOrder,options);
		presentGoodsList(supplyOrder,options);

		return supplyOrder;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrder presentSupplyOrderLineItemList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {
    
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
				SmartList<SupplyOrderLineItem> newList= presentSubList(supplyOrder.getId(),
				supplyOrderLineItemList,
				options,
				getSupplyOrderLineItemDAO()::countSupplyOrderLineItemByBizOrder,
				getSupplyOrderLineItemDAO()::findSupplyOrderLineItemByBizOrder
				);


		supplyOrder.setSupplyOrderLineItemList(newList);


		return supplyOrder;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrder presentSupplyOrderShippingGroupList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {
    
		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
				SmartList<SupplyOrderShippingGroup> newList= presentSubList(supplyOrder.getId(),
				supplyOrderShippingGroupList,
				options,
				getSupplyOrderShippingGroupDAO()::countSupplyOrderShippingGroupByBizOrder,
				getSupplyOrderShippingGroupDAO()::findSupplyOrderShippingGroupByBizOrder
				);


		supplyOrder.setSupplyOrderShippingGroupList(newList);


		return supplyOrder;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrder presentSupplyOrderPaymentGroupList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {
    
		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
				SmartList<SupplyOrderPaymentGroup> newList= presentSubList(supplyOrder.getId(),
				supplyOrderPaymentGroupList,
				options,
				getSupplyOrderPaymentGroupDAO()::countSupplyOrderPaymentGroupByBizOrder,
				getSupplyOrderPaymentGroupDAO()::findSupplyOrderPaymentGroupByBizOrder
				);


		supplyOrder.setSupplyOrderPaymentGroupList(newList);


		return supplyOrder;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrder presentGoodsList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {
    
		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
				SmartList<Goods> newList= presentSubList(supplyOrder.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByBizOrder,
				getGoodsDAO()::findGoodsByBizOrder
				);


		supplyOrder.setGoodsList(newList);


		return supplyOrder;
	}
		

	
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderLineItem(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderTable.TABLE_NAME;
	}



	public void enhanceList(List<SupplyOrder> supplyOrderList) {
		this.enhanceListInternal(supplyOrderList, this.getSupplyOrderMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrderLineItem的bizOrder的SupplyOrderLineItemList
	public SmartList<SupplyOrderLineItem> loadOurSupplyOrderLineItemList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SupplyOrderLineItem> loadedObjs = userContext.getDAOGroup().getSupplyOrderLineItemDAO().findSupplyOrderLineItemWithKey(key, options);
		Map<String, List<SupplyOrderLineItem>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SupplyOrderLineItem> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SupplyOrderLineItem> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSupplyOrderLineItemList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrderShippingGroup的bizOrder的SupplyOrderShippingGroupList
	public SmartList<SupplyOrderShippingGroup> loadOurSupplyOrderShippingGroupList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SupplyOrderShippingGroup> loadedObjs = userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().findSupplyOrderShippingGroupWithKey(key, options);
		Map<String, List<SupplyOrderShippingGroup>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SupplyOrderShippingGroup> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SupplyOrderShippingGroup> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSupplyOrderShippingGroupList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrderPaymentGroup的bizOrder的SupplyOrderPaymentGroupList
	public SmartList<SupplyOrderPaymentGroup> loadOurSupplyOrderPaymentGroupList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SupplyOrderPaymentGroup> loadedObjs = userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().findSupplyOrderPaymentGroupWithKey(key, options);
		Map<String, List<SupplyOrderPaymentGroup>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SupplyOrderPaymentGroup> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SupplyOrderPaymentGroup> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSupplyOrderPaymentGroupList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Goods的bizOrder的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Goods> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Goods> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrder> supplyOrderList = ownerEntity.collectRefsWithType(SupplyOrder.INTERNAL_TYPE);
		this.enhanceList(supplyOrderList);

	}

	@Override
	public SmartList<SupplyOrder> findSupplyOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getSupplyOrderMapper());

	}
	@Override
	public int countSupplyOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<SupplyOrder> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<SupplyOrder> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getSupplyOrderMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSupplyOrder executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSupplyOrder result = new CandidateSupplyOrder();
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

	

  @Override
  public List<SupplyOrder> search(SupplyOrderRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected SupplyOrderMapper mapper() {
    return getSupplyOrderMapper();
  }
}


