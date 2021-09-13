
package com.doublechaintech.retailscm.retailstoreorder;

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


import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;

import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemDAO;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreOrderJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreOrderDAO{

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

	protected RetailStoreOrderLineItemDAO retailStoreOrderLineItemDAO;
	public void setRetailStoreOrderLineItemDAO(RetailStoreOrderLineItemDAO retailStoreOrderLineItemDAO){

 		if(retailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderLineItemDAO to null.");
 		}
	 	this.retailStoreOrderLineItemDAO = retailStoreOrderLineItemDAO;
 	}
 	public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO(){
 		if(this.retailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("The retailStoreOrderLineItemDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreOrderLineItemDAO;
 	}

	protected RetailStoreOrderShippingGroupDAO retailStoreOrderShippingGroupDAO;
	public void setRetailStoreOrderShippingGroupDAO(RetailStoreOrderShippingGroupDAO retailStoreOrderShippingGroupDAO){

 		if(retailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderShippingGroupDAO to null.");
 		}
	 	this.retailStoreOrderShippingGroupDAO = retailStoreOrderShippingGroupDAO;
 	}
 	public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO(){
 		if(this.retailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The retailStoreOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreOrderShippingGroupDAO;
 	}

	protected RetailStoreOrderPaymentGroupDAO retailStoreOrderPaymentGroupDAO;
	public void setRetailStoreOrderPaymentGroupDAO(RetailStoreOrderPaymentGroupDAO retailStoreOrderPaymentGroupDAO){

 		if(retailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderPaymentGroupDAO to null.");
 		}
	 	this.retailStoreOrderPaymentGroupDAO = retailStoreOrderPaymentGroupDAO;
 	}
 	public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO(){
 		if(this.retailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The retailStoreOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreOrderPaymentGroupDAO;
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
	protected RetailStoreOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrder(accessKey, options);
	}
	*/

	public SmartList<RetailStoreOrder> loadAll() {
	    return this.loadAll(getRetailStoreOrderMapper());
	}

  public Stream<RetailStoreOrder> loadAllAsStream() {
      return this.loadAllAsStream(getRetailStoreOrderMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public RetailStoreOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrder(RetailStoreOrderTable.withId(id), options);
	}

	

	public RetailStoreOrder save(RetailStoreOrder retailStoreOrder,Map<String,Object> options){

		String methodName="save(RetailStoreOrder retailStoreOrder,Map<String,Object> options)";

		assertMethodArgumentNotNull(retailStoreOrder, methodName, "retailStoreOrder");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalRetailStoreOrder(retailStoreOrder,options);
	}
	public RetailStoreOrder clone(String retailStoreOrderId, Map<String,Object> options) throws Exception{

		return clone(RetailStoreOrderTable.withId(retailStoreOrderId),options);
	}

	protected RetailStoreOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String retailStoreOrderId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		RetailStoreOrder newRetailStoreOrder = loadInternalRetailStoreOrder(accessKey, options);
		newRetailStoreOrder.setVersion(0);
		
		

 		if(isSaveRetailStoreOrderLineItemListEnabled(options)){
 			for(RetailStoreOrderLineItem item: newRetailStoreOrder.getRetailStoreOrderLineItemList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreOrderShippingGroupListEnabled(options)){
 			for(RetailStoreOrderShippingGroup item: newRetailStoreOrder.getRetailStoreOrderShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreOrderPaymentGroupListEnabled(options)){
 			for(RetailStoreOrderPaymentGroup item: newRetailStoreOrder.getRetailStoreOrderPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newRetailStoreOrder.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalRetailStoreOrder(newRetailStoreOrder,options);

		return newRetailStoreOrder;
	}

	



	protected void throwIfHasException(String retailStoreOrderId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String retailStoreOrderId, int version) throws Exception{

		String methodName="delete(String retailStoreOrderId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderId, methodName, "retailStoreOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderId,version);
		}


	}






	public RetailStoreOrder disconnectFromAll(String retailStoreOrderId, int version) throws Exception{


		RetailStoreOrder retailStoreOrder = loadInternalRetailStoreOrder(RetailStoreOrderTable.withId(retailStoreOrderId), emptyOptions());
		retailStoreOrder.clearFromAll();
		this.saveRetailStoreOrder(retailStoreOrder);
		return retailStoreOrder;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "retail_store_order";
	}
	@Override
	protected String getBeanName() {

		return "retailStoreOrder";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return RetailStoreOrderTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){

	 	return checkOptions(options, RetailStoreOrderTokens.BUYER);
 	}

 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){

 		return checkOptions(options, RetailStoreOrderTokens.BUYER);
 	}



 

 	protected boolean isExtractSellerEnabled(Map<String,Object> options){

	 	return checkOptions(options, RetailStoreOrderTokens.SELLER);
 	}

 	protected boolean isSaveSellerEnabled(Map<String,Object> options){

 		return checkOptions(options, RetailStoreOrderTokens.SELLER);
 	}



 
		

	protected boolean isExtractRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_LINE_ITEM_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
 		return RetailStoreOrderTokens.of(options).analyzeRetailStoreOrderLineItemListEnabled();
 	}

	protected boolean isSaveRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_LINE_ITEM_LIST);

 	}

		

	protected boolean isExtractRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
 		return RetailStoreOrderTokens.of(options).analyzeRetailStoreOrderShippingGroupListEnabled();
 	}

	protected boolean isSaveRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);

 	}

		

	protected boolean isExtractRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
 		return RetailStoreOrderTokens.of(options).analyzeRetailStoreOrderPaymentGroupListEnabled();
 	}

	protected boolean isSaveRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);

 	}

		

	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreOrderTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){
 		return RetailStoreOrderTokens.of(options).analyzeGoodsListEnabled();
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.GOODS_LIST);

 	}

		

	

	protected RetailStoreOrderMapper getRetailStoreOrderMapper(){
		return new RetailStoreOrderMapper();
	}



	protected RetailStoreOrder extractRetailStoreOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrder retailStoreOrder = loadSingleObject(accessKey, getRetailStoreOrderMapper());
			return retailStoreOrder;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderNotFoundException("RetailStoreOrder("+accessKey+") is not found!");
		}

	}




	protected RetailStoreOrder loadInternalRetailStoreOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		RetailStoreOrder retailStoreOrder = extractRetailStoreOrder(accessKey, loadOptions);

 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(retailStoreOrder, loadOptions);
 		}
 
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(retailStoreOrder, loadOptions);
 		}
 
		
		if(isExtractRetailStoreOrderLineItemListEnabled(loadOptions)){
	 		extractRetailStoreOrderLineItemList(retailStoreOrder, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreOrderLineItemListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderLineItemList(retailStoreOrder, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreOrderShippingGroupListEnabled(loadOptions)){
	 		extractRetailStoreOrderShippingGroupList(retailStoreOrder, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreOrderShippingGroupListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderShippingGroupList(retailStoreOrder, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreOrderPaymentGroupListEnabled(loadOptions)){
	 		extractRetailStoreOrderPaymentGroupList(retailStoreOrder, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreOrderPaymentGroupListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderPaymentGroupList(retailStoreOrder, loadOptions);
 		}
 		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(retailStoreOrder, loadOptions);
 		}

 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(retailStoreOrder, loadOptions);
 		}
 		
		
		return retailStoreOrder;

	}

	

 	protected RetailStoreOrder extractBuyer(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{
  

		if(retailStoreOrder.getBuyer() == null){
			return retailStoreOrder;
		}
		String buyerId = retailStoreOrder.getBuyer().getId();
		if( buyerId == null){
			return retailStoreOrder;
		}
		RetailStore buyer = getRetailStoreDAO().load(buyerId,options);
		if(buyer != null){
			retailStoreOrder.setBuyer(buyer);
		}


 		return retailStoreOrder;
 	}

 

 	protected RetailStoreOrder extractSeller(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{
  

		if(retailStoreOrder.getSeller() == null){
			return retailStoreOrder;
		}
		String sellerId = retailStoreOrder.getSeller().getId();
		if( sellerId == null){
			return retailStoreOrder;
		}
		RetailStoreCountryCenter seller = getRetailStoreCountryCenterDAO().load(sellerId,options);
		if(seller != null){
			retailStoreOrder.setSeller(seller);
		}


 		return retailStoreOrder;
 	}

 
		
	protected void enhanceRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreOrder extractRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    

		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = getRetailStoreOrderLineItemDAO().findRetailStoreOrderLineItemByBizOrder(retailStoreOrder.getId(),options);
		if(retailStoreOrderLineItemList != null){
			enhanceRetailStoreOrderLineItemList(retailStoreOrderLineItemList,options);
			retailStoreOrder.setRetailStoreOrderLineItemList(retailStoreOrderLineItemList);
		}

		return retailStoreOrder;
  
	}

	protected RetailStoreOrder analyzeRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
     
		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		if(retailStoreOrderLineItemList != null){
			getRetailStoreOrderLineItemDAO().analyzeRetailStoreOrderLineItemByBizOrder(retailStoreOrderLineItemList, retailStoreOrder.getId(), options);

		}

		return retailStoreOrder;
    
	}

		
	protected void enhanceRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreOrder extractRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    

		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = getRetailStoreOrderShippingGroupDAO().findRetailStoreOrderShippingGroupByBizOrder(retailStoreOrder.getId(),options);
		if(retailStoreOrderShippingGroupList != null){
			enhanceRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList,options);
			retailStoreOrder.setRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList);
		}

		return retailStoreOrder;
  
	}

	protected RetailStoreOrder analyzeRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
     
		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		if(retailStoreOrderShippingGroupList != null){
			getRetailStoreOrderShippingGroupDAO().analyzeRetailStoreOrderShippingGroupByBizOrder(retailStoreOrderShippingGroupList, retailStoreOrder.getId(), options);

		}

		return retailStoreOrder;
    
	}

		
	protected void enhanceRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreOrder extractRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    

		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = getRetailStoreOrderPaymentGroupDAO().findRetailStoreOrderPaymentGroupByBizOrder(retailStoreOrder.getId(),options);
		if(retailStoreOrderPaymentGroupList != null){
			enhanceRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList,options);
			retailStoreOrder.setRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList);
		}

		return retailStoreOrder;
  
	}

	protected RetailStoreOrder analyzeRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
     
		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		if(retailStoreOrderPaymentGroupList != null){
			getRetailStoreOrderPaymentGroupDAO().analyzeRetailStoreOrderPaymentGroupByBizOrder(retailStoreOrderPaymentGroupList, retailStoreOrder.getId(), options);

		}

		return retailStoreOrder;
    
	}

		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreOrder extractGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    

		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByRetailStoreOrder(retailStoreOrder.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			retailStoreOrder.setGoodsList(goodsList);
		}

		return retailStoreOrder;
  
	}

	protected RetailStoreOrder analyzeGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
     
		if(retailStoreOrder == null){
			return null;
		}
		if(retailStoreOrder.getId() == null){
			return retailStoreOrder;
		}



		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByRetailStoreOrder(goodsList, retailStoreOrder.getId(), options);

		}

		return retailStoreOrder;
    
	}

		

 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId,Map<String,Object> options){

  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_BUYER, retailStoreId, options, getRetailStoreOrderMapper());
		// analyzeRetailStoreOrderByBuyer(resultList, retailStoreId, options);
		return resultList;
 	}
 	

 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, int start, int count,Map<String,Object> options){

 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_BUYER, retailStoreId, options, getRetailStoreOrderMapper(), start, count);
 		//analyzeRetailStoreOrderByBuyer(resultList, retailStoreId, options);
 		return resultList;

 	}
 	public void analyzeRetailStoreOrderByBuyer(SmartList<RetailStoreOrder> resultList, String retailStoreId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.BUYER_PROPERTY, retailStoreId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("生超的订单");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countRetailStoreOrderByBuyer(String retailStoreId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_BUYER, retailStoreId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByBuyerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_BUYER, ids, options);
	}

 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_SELLER, retailStoreCountryCenterId, options, getRetailStoreOrderMapper());
		// analyzeRetailStoreOrderBySeller(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_SELLER, retailStoreCountryCenterId, options, getRetailStoreOrderMapper(), start, count);
 		//analyzeRetailStoreOrderBySeller(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeRetailStoreOrderBySeller(SmartList<RetailStoreOrder> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.SELLER_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("生超的订单");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countRetailStoreOrderBySeller(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_SELLER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderBySellerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_SELLER, ids, options);
	}

 




	

	protected RetailStoreOrder saveRetailStoreOrder(RetailStoreOrder  retailStoreOrder){
    

		
		if(!retailStoreOrder.isChanged()){
			return retailStoreOrder;
		}
		

    Beans.dbUtil().cacheCleanUp(retailStoreOrder);
		String SQL=this.getSaveRetailStoreOrderSQL(retailStoreOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderParameters(retailStoreOrder);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		retailStoreOrder.incVersion();
		retailStoreOrder.afterSave();
		return retailStoreOrder;

	}
	public SmartList<RetailStoreOrder> saveRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderList(retailStoreOrderList);

		batchRetailStoreOrderCreate((List<RetailStoreOrder>)lists[CREATE_LIST_INDEX]);

		batchRetailStoreOrderUpdate((List<RetailStoreOrder>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			if(retailStoreOrder.isChanged()){
				retailStoreOrder.incVersion();
				retailStoreOrder.afterSave();
			}


		}


		return retailStoreOrderList;
	}

	public SmartList<RetailStoreOrder> removeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){


		super.removeList(retailStoreOrderList, options);

		return retailStoreOrderList;


	}

	protected List<Object[]> prepareRetailStoreOrderBatchCreateArgs(List<RetailStoreOrder> retailStoreOrderList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrder retailStoreOrder:retailStoreOrderList ){
			Object [] parameters = prepareRetailStoreOrderCreateParameters(retailStoreOrder);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareRetailStoreOrderBatchUpdateArgs(List<RetailStoreOrder> retailStoreOrderList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrder retailStoreOrder:retailStoreOrderList ){
			if(!retailStoreOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderUpdateParameters(retailStoreOrder);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchRetailStoreOrderCreate(List<RetailStoreOrder> retailStoreOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderBatchCreateArgs(retailStoreOrderList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchRetailStoreOrderUpdate(List<RetailStoreOrder> retailStoreOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderBatchUpdateArgs(retailStoreOrderList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitRetailStoreOrderList(List<RetailStoreOrder> retailStoreOrderList){

		List<RetailStoreOrder> retailStoreOrderCreateList=new ArrayList<RetailStoreOrder>();
		List<RetailStoreOrder> retailStoreOrderUpdateList=new ArrayList<RetailStoreOrder>();

		for(RetailStoreOrder retailStoreOrder: retailStoreOrderList){
			if(isUpdateRequest(retailStoreOrder)){
				retailStoreOrderUpdateList.add( retailStoreOrder);
				continue;
			}
			retailStoreOrderCreateList.add(retailStoreOrder);
		}

		return new Object[]{retailStoreOrderCreateList,retailStoreOrderUpdateList};
	}

	protected boolean isUpdateRequest(RetailStoreOrder retailStoreOrder){
 		return retailStoreOrder.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderSQL(RetailStoreOrder retailStoreOrder){
 		if(isUpdateRequest(retailStoreOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveRetailStoreOrderParameters(RetailStoreOrder retailStoreOrder){
 		if(isUpdateRequest(retailStoreOrder) ){
 			return prepareRetailStoreOrderUpdateParameters(retailStoreOrder);
 		}
 		return prepareRetailStoreOrderCreateParameters(retailStoreOrder);
 	}
 	protected Object[] prepareRetailStoreOrderUpdateParameters(RetailStoreOrder retailStoreOrder){
 		Object[] parameters = new Object[9];
 
 		if(retailStoreOrder.getBuyer() != null){
 			parameters[0] = retailStoreOrder.getBuyer().getId();
 		}
    
 		if(retailStoreOrder.getSeller() != null){
 			parameters[1] = retailStoreOrder.getSeller().getId();
 		}
    
 		parameters[2] = retailStoreOrder.getTitle();
 		
 		parameters[3] = retailStoreOrder.getTotalAmount();
 		
 		parameters[4] = retailStoreOrder.getContract();
 		
 		parameters[5] = retailStoreOrder.getLastUpdateTime();
 		
 		parameters[6] = retailStoreOrder.nextVersion();
 		parameters[7] = retailStoreOrder.getId();
 		parameters[8] = retailStoreOrder.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderCreateParameters(RetailStoreOrder retailStoreOrder){
		Object[] parameters = new Object[7];
        if(retailStoreOrder.getId() == null){
          String newRetailStoreOrderId=getNextId();
          retailStoreOrder.setId(newRetailStoreOrderId);
        }
		parameters[0] =  retailStoreOrder.getId();
 
 		if(retailStoreOrder.getBuyer() != null){
 			parameters[1] = retailStoreOrder.getBuyer().getId();
 		}
 		
 		if(retailStoreOrder.getSeller() != null){
 			parameters[2] = retailStoreOrder.getSeller().getId();
 		}
 		
 		parameters[3] = retailStoreOrder.getTitle();
 		
 		parameters[4] = retailStoreOrder.getTotalAmount();
 		
 		parameters[5] = retailStoreOrder.getContract();
 		
 		parameters[6] = retailStoreOrder.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected RetailStoreOrder saveInternalRetailStoreOrder(RetailStoreOrder retailStoreOrder, Map<String,Object> options){

 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(retailStoreOrder, options);
 		}
 
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(retailStoreOrder, options);
 		}
 
   saveRetailStoreOrder(retailStoreOrder);
		
		if(isSaveRetailStoreOrderLineItemListEnabled(options)){
	 		saveRetailStoreOrderLineItemList(retailStoreOrder, options);
	 		//removeRetailStoreOrderLineItemList(retailStoreOrder, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreOrderShippingGroupListEnabled(options)){
	 		saveRetailStoreOrderShippingGroupList(retailStoreOrder, options);
	 		//removeRetailStoreOrderShippingGroupList(retailStoreOrder, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreOrderPaymentGroupListEnabled(options)){
	 		saveRetailStoreOrderPaymentGroupList(retailStoreOrder, options);
	 		//removeRetailStoreOrderPaymentGroupList(retailStoreOrder, options);
	 		//Not delete the record

 		}
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(retailStoreOrder, options);
	 		//removeGoodsList(retailStoreOrder, options);
	 		//Not delete the record

 		}
		
		return retailStoreOrder;

	}



	//======================================================================================
	

 	protected RetailStoreOrder saveBuyer(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getBuyer() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}

 		getRetailStoreDAO().save(retailStoreOrder.getBuyer(),options);
 		return retailStoreOrder;

 	}
 

 	protected RetailStoreOrder saveSeller(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getSeller() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(retailStoreOrder.getSeller(),options);
 		return retailStoreOrder;

 	}
 

	
	public RetailStoreOrder planToRemoveRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, String retailStoreOrderLineItemIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(RetailStoreOrderLineItem.ID_PROPERTY, retailStoreOrderLineItemIds);

		SmartList<RetailStoreOrderLineItem> externalRetailStoreOrderLineItemList = getRetailStoreOrderLineItemDAO().
				findRetailStoreOrderLineItemWithKey(key, options);
		if(externalRetailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}
		if(externalRetailStoreOrderLineItemList.isEmpty()){
			return retailStoreOrder;
		}

		for(RetailStoreOrderLineItem retailStoreOrderLineItemItem: externalRetailStoreOrderLineItemList){

			retailStoreOrderLineItemItem.clearFromAll();
		}


		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		retailStoreOrderLineItemList.addAllToRemoveList(externalRetailStoreOrderLineItemList);
		return retailStoreOrder;

	}


	public RetailStoreOrder planToRemoveRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, String retailStoreOrderShippingGroupIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(RetailStoreOrderShippingGroup.ID_PROPERTY, retailStoreOrderShippingGroupIds);

		SmartList<RetailStoreOrderShippingGroup> externalRetailStoreOrderShippingGroupList = getRetailStoreOrderShippingGroupDAO().
				findRetailStoreOrderShippingGroupWithKey(key, options);
		if(externalRetailStoreOrderShippingGroupList == null){
			return retailStoreOrder;
		}
		if(externalRetailStoreOrderShippingGroupList.isEmpty()){
			return retailStoreOrder;
		}

		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroupItem: externalRetailStoreOrderShippingGroupList){

			retailStoreOrderShippingGroupItem.clearFromAll();
		}


		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		retailStoreOrderShippingGroupList.addAllToRemoveList(externalRetailStoreOrderShippingGroupList);
		return retailStoreOrder;

	}


	public RetailStoreOrder planToRemoveRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, String retailStoreOrderPaymentGroupIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(RetailStoreOrderPaymentGroup.ID_PROPERTY, retailStoreOrderPaymentGroupIds);

		SmartList<RetailStoreOrderPaymentGroup> externalRetailStoreOrderPaymentGroupList = getRetailStoreOrderPaymentGroupDAO().
				findRetailStoreOrderPaymentGroupWithKey(key, options);
		if(externalRetailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;
		}
		if(externalRetailStoreOrderPaymentGroupList.isEmpty()){
			return retailStoreOrder;
		}

		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroupItem: externalRetailStoreOrderPaymentGroupList){

			retailStoreOrderPaymentGroupItem.clearFromAll();
		}


		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		retailStoreOrderPaymentGroupList.addAllToRemoveList(externalRetailStoreOrderPaymentGroupList);
		return retailStoreOrder;

	}


	public RetailStoreOrder planToRemoveGoodsList(RetailStoreOrder retailStoreOrder, String goodsIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;

	}


	//disconnect RetailStoreOrder with sku in Goods
	public RetailStoreOrder planToRemoveGoodsListWithSku(RetailStoreOrder retailStoreOrder, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.SKU_PROPERTY, skuId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithSku(String retailStoreOrderId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.SKU_PROPERTY, skuId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with receiving_space in Goods
	public RetailStoreOrder planToRemoveGoodsListWithReceivingSpace(RetailStoreOrder retailStoreOrder, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithReceivingSpace(String retailStoreOrderId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with goods_allocation in Goods
	public RetailStoreOrder planToRemoveGoodsListWithGoodsAllocation(RetailStoreOrder retailStoreOrder, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithGoodsAllocation(String retailStoreOrderId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with smart_pallet in Goods
	public RetailStoreOrder planToRemoveGoodsListWithSmartPallet(RetailStoreOrder retailStoreOrder, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithSmartPallet(String retailStoreOrderId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with shipping_space in Goods
	public RetailStoreOrder planToRemoveGoodsListWithShippingSpace(RetailStoreOrder retailStoreOrder, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithShippingSpace(String retailStoreOrderId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with transport_task in Goods
	public RetailStoreOrder planToRemoveGoodsListWithTransportTask(RetailStoreOrder retailStoreOrder, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithTransportTask(String retailStoreOrderId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with retail_store in Goods
	public RetailStoreOrder planToRemoveGoodsListWithRetailStore(RetailStoreOrder retailStoreOrder, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithRetailStore(String retailStoreOrderId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrder with biz_order in Goods
	public RetailStoreOrder planToRemoveGoodsListWithBizOrder(RetailStoreOrder retailStoreOrder, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStoreOrder;
		}
		if(externalGoodsList.isEmpty()){
			return retailStoreOrder;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearRetailStoreOrder();

		}


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStoreOrder;
	}

	public int countGoodsListWithBizOrder(String retailStoreOrderId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrder saveRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    



		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		if(retailStoreOrderLineItemList == null){
			//null list means nothing
			return retailStoreOrder;
		}
		SmartList<RetailStoreOrderLineItem> mergedUpdateRetailStoreOrderLineItemList = new SmartList<RetailStoreOrderLineItem>();


		mergedUpdateRetailStoreOrderLineItemList.addAll(retailStoreOrderLineItemList);
		if(retailStoreOrderLineItemList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreOrderLineItemList.addAll(retailStoreOrderLineItemList.getToRemoveList());
			retailStoreOrderLineItemList.removeAll(retailStoreOrderLineItemList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreOrderLineItemDAO().saveRetailStoreOrderLineItemList(mergedUpdateRetailStoreOrderLineItemList,options);

		if(retailStoreOrderLineItemList.getToRemoveList() != null){
			retailStoreOrderLineItemList.removeAll(retailStoreOrderLineItemList.getToRemoveList());
		}


		return retailStoreOrder;

	}

	protected RetailStoreOrder removeRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){


		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		if(retailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}

		SmartList<RetailStoreOrderLineItem> toRemoveRetailStoreOrderLineItemList = retailStoreOrderLineItemList.getToRemoveList();

		if(toRemoveRetailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}
		if(toRemoveRetailStoreOrderLineItemList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreOrderLineItemDAO().removeRetailStoreOrderLineItemList(toRemoveRetailStoreOrderLineItemList,options);

		return retailStoreOrder;

	}








		
	protected RetailStoreOrder saveRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    



		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		if(retailStoreOrderShippingGroupList == null){
			//null list means nothing
			return retailStoreOrder;
		}
		SmartList<RetailStoreOrderShippingGroup> mergedUpdateRetailStoreOrderShippingGroupList = new SmartList<RetailStoreOrderShippingGroup>();


		mergedUpdateRetailStoreOrderShippingGroupList.addAll(retailStoreOrderShippingGroupList);
		if(retailStoreOrderShippingGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreOrderShippingGroupList.addAll(retailStoreOrderShippingGroupList.getToRemoveList());
			retailStoreOrderShippingGroupList.removeAll(retailStoreOrderShippingGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreOrderShippingGroupDAO().saveRetailStoreOrderShippingGroupList(mergedUpdateRetailStoreOrderShippingGroupList,options);

		if(retailStoreOrderShippingGroupList.getToRemoveList() != null){
			retailStoreOrderShippingGroupList.removeAll(retailStoreOrderShippingGroupList.getToRemoveList());
		}


		return retailStoreOrder;

	}

	protected RetailStoreOrder removeRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){


		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		if(retailStoreOrderShippingGroupList == null){
			return retailStoreOrder;
		}

		SmartList<RetailStoreOrderShippingGroup> toRemoveRetailStoreOrderShippingGroupList = retailStoreOrderShippingGroupList.getToRemoveList();

		if(toRemoveRetailStoreOrderShippingGroupList == null){
			return retailStoreOrder;
		}
		if(toRemoveRetailStoreOrderShippingGroupList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreOrderShippingGroupDAO().removeRetailStoreOrderShippingGroupList(toRemoveRetailStoreOrderShippingGroupList,options);

		return retailStoreOrder;

	}








		
	protected RetailStoreOrder saveRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    



		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		if(retailStoreOrderPaymentGroupList == null){
			//null list means nothing
			return retailStoreOrder;
		}
		SmartList<RetailStoreOrderPaymentGroup> mergedUpdateRetailStoreOrderPaymentGroupList = new SmartList<RetailStoreOrderPaymentGroup>();


		mergedUpdateRetailStoreOrderPaymentGroupList.addAll(retailStoreOrderPaymentGroupList);
		if(retailStoreOrderPaymentGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreOrderPaymentGroupList.addAll(retailStoreOrderPaymentGroupList.getToRemoveList());
			retailStoreOrderPaymentGroupList.removeAll(retailStoreOrderPaymentGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreOrderPaymentGroupDAO().saveRetailStoreOrderPaymentGroupList(mergedUpdateRetailStoreOrderPaymentGroupList,options);

		if(retailStoreOrderPaymentGroupList.getToRemoveList() != null){
			retailStoreOrderPaymentGroupList.removeAll(retailStoreOrderPaymentGroupList.getToRemoveList());
		}


		return retailStoreOrder;

	}

	protected RetailStoreOrder removeRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){


		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		if(retailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;
		}

		SmartList<RetailStoreOrderPaymentGroup> toRemoveRetailStoreOrderPaymentGroupList = retailStoreOrderPaymentGroupList.getToRemoveList();

		if(toRemoveRetailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;
		}
		if(toRemoveRetailStoreOrderPaymentGroupList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreOrderPaymentGroupDAO().removeRetailStoreOrderPaymentGroupList(toRemoveRetailStoreOrderPaymentGroupList,options);

		return retailStoreOrder;

	}








		
	protected RetailStoreOrder saveGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
    



		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return retailStoreOrder;
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


		return retailStoreOrder;

	}

	protected RetailStoreOrder removeGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){


		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		if(goodsList == null){
			return retailStoreOrder;
		}

		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

		if(toRemoveGoodsList == null){
			return retailStoreOrder;
		}
		if(toRemoveGoodsList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);

		return retailStoreOrder;

	}








		

	public RetailStoreOrder present(RetailStoreOrder retailStoreOrder,Map<String, Object> options){

		presentRetailStoreOrderLineItemList(retailStoreOrder,options);
		presentRetailStoreOrderShippingGroupList(retailStoreOrder,options);
		presentRetailStoreOrderPaymentGroupList(retailStoreOrder,options);
		presentGoodsList(retailStoreOrder,options);

		return retailStoreOrder;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrder presentRetailStoreOrderLineItemList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {
    
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
				SmartList<RetailStoreOrderLineItem> newList= presentSubList(retailStoreOrder.getId(),
				retailStoreOrderLineItemList,
				options,
				getRetailStoreOrderLineItemDAO()::countRetailStoreOrderLineItemByBizOrder,
				getRetailStoreOrderLineItemDAO()::findRetailStoreOrderLineItemByBizOrder
				);


		retailStoreOrder.setRetailStoreOrderLineItemList(newList);


		return retailStoreOrder;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrder presentRetailStoreOrderShippingGroupList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {
    
		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
				SmartList<RetailStoreOrderShippingGroup> newList= presentSubList(retailStoreOrder.getId(),
				retailStoreOrderShippingGroupList,
				options,
				getRetailStoreOrderShippingGroupDAO()::countRetailStoreOrderShippingGroupByBizOrder,
				getRetailStoreOrderShippingGroupDAO()::findRetailStoreOrderShippingGroupByBizOrder
				);


		retailStoreOrder.setRetailStoreOrderShippingGroupList(newList);


		return retailStoreOrder;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrder presentRetailStoreOrderPaymentGroupList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {
    
		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
				SmartList<RetailStoreOrderPaymentGroup> newList= presentSubList(retailStoreOrder.getId(),
				retailStoreOrderPaymentGroupList,
				options,
				getRetailStoreOrderPaymentGroupDAO()::countRetailStoreOrderPaymentGroupByBizOrder,
				getRetailStoreOrderPaymentGroupDAO()::findRetailStoreOrderPaymentGroupByBizOrder
				);


		retailStoreOrder.setRetailStoreOrderPaymentGroupList(newList);


		return retailStoreOrder;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrder presentGoodsList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {
    
		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
				SmartList<Goods> newList= presentSubList(retailStoreOrder.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByRetailStoreOrder,
				getGoodsDAO()::findGoodsByRetailStoreOrder
				);


		retailStoreOrder.setGoodsList(newList);


		return retailStoreOrder;
	}
		

	
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderLineItem(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderTable.TABLE_NAME;
	}



	public void enhanceList(List<RetailStoreOrder> retailStoreOrderList) {
		this.enhanceListInternal(retailStoreOrderList, this.getRetailStoreOrderMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrderLineItem的bizOrder的RetailStoreOrderLineItemList
	public SmartList<RetailStoreOrderLineItem> loadOurRetailStoreOrderLineItemList(RetailscmUserContext userContext, List<RetailStoreOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreOrderLineItem> loadedObjs = userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().findRetailStoreOrderLineItemWithKey(key, options);
		Map<String, List<RetailStoreOrderLineItem>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreOrderLineItem> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreOrderLineItem> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreOrderLineItemList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrderShippingGroup的bizOrder的RetailStoreOrderShippingGroupList
	public SmartList<RetailStoreOrderShippingGroup> loadOurRetailStoreOrderShippingGroupList(RetailscmUserContext userContext, List<RetailStoreOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreOrderShippingGroup> loadedObjs = userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().findRetailStoreOrderShippingGroupWithKey(key, options);
		Map<String, List<RetailStoreOrderShippingGroup>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreOrderShippingGroup> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreOrderShippingGroup> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreOrderShippingGroupList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrderPaymentGroup的bizOrder的RetailStoreOrderPaymentGroupList
	public SmartList<RetailStoreOrderPaymentGroup> loadOurRetailStoreOrderPaymentGroupList(RetailscmUserContext userContext, List<RetailStoreOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreOrderPaymentGroup> loadedObjs = userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().findRetailStoreOrderPaymentGroupWithKey(key, options);
		Map<String, List<RetailStoreOrderPaymentGroup>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBizOrder().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreOrderPaymentGroup> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreOrderPaymentGroup> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreOrderPaymentGroupList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Goods的retailStoreOrder的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<RetailStoreOrder> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getRetailStoreOrder().getId()));
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
		List<RetailStoreOrder> retailStoreOrderList = ownerEntity.collectRefsWithType(RetailStoreOrder.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderList);

	}

	@Override
	public SmartList<RetailStoreOrder> findRetailStoreOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getRetailStoreOrderMapper());

	}
	@Override
	public int countRetailStoreOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<RetailStoreOrder> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<RetailStoreOrder> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreOrderMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreOrder executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreOrder result = new CandidateRetailStoreOrder();
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
  public List<RetailStoreOrder> search(RetailStoreOrderRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreOrderMapper mapper() {
    return getRetailStoreOrderMapper();
  }
}


