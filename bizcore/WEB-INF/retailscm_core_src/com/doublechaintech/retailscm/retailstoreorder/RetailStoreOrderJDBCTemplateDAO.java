
package com.doublechaintech.retailscm.retailstoreorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.RetailscmNamingServiceDAO;
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
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;

import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipmentDAO;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemDAO;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPickingDAO;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDeliveryDAO;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmationDAO;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessingDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApprovalDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreOrderJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderDAO{
 
 	
 	private  RetailStoreOrderApprovalDAO  retailStoreOrderApprovalDAO;
 	public void setRetailStoreOrderApprovalDAO(RetailStoreOrderApprovalDAO retailStoreOrderApprovalDAO){
	 	this.retailStoreOrderApprovalDAO = retailStoreOrderApprovalDAO;
 	}
 	public RetailStoreOrderApprovalDAO getRetailStoreOrderApprovalDAO(){
	 	return this.retailStoreOrderApprovalDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  RetailStoreOrderDeliveryDAO  retailStoreOrderDeliveryDAO;
 	public void setRetailStoreOrderDeliveryDAO(RetailStoreOrderDeliveryDAO retailStoreOrderDeliveryDAO){
	 	this.retailStoreOrderDeliveryDAO = retailStoreOrderDeliveryDAO;
 	}
 	public RetailStoreOrderDeliveryDAO getRetailStoreOrderDeliveryDAO(){
	 	return this.retailStoreOrderDeliveryDAO;
 	}
 
 	
 	private  RetailStoreOrderPickingDAO  retailStoreOrderPickingDAO;
 	public void setRetailStoreOrderPickingDAO(RetailStoreOrderPickingDAO retailStoreOrderPickingDAO){
	 	this.retailStoreOrderPickingDAO = retailStoreOrderPickingDAO;
 	}
 	public RetailStoreOrderPickingDAO getRetailStoreOrderPickingDAO(){
	 	return this.retailStoreOrderPickingDAO;
 	}
 
 	
 	private  RetailStoreOrderShipmentDAO  retailStoreOrderShipmentDAO;
 	public void setRetailStoreOrderShipmentDAO(RetailStoreOrderShipmentDAO retailStoreOrderShipmentDAO){
	 	this.retailStoreOrderShipmentDAO = retailStoreOrderShipmentDAO;
 	}
 	public RetailStoreOrderShipmentDAO getRetailStoreOrderShipmentDAO(){
	 	return this.retailStoreOrderShipmentDAO;
 	}
 
 	
 	private  RetailStoreOrderConfirmationDAO  retailStoreOrderConfirmationDAO;
 	public void setRetailStoreOrderConfirmationDAO(RetailStoreOrderConfirmationDAO retailStoreOrderConfirmationDAO){
	 	this.retailStoreOrderConfirmationDAO = retailStoreOrderConfirmationDAO;
 	}
 	public RetailStoreOrderConfirmationDAO getRetailStoreOrderConfirmationDAO(){
	 	return this.retailStoreOrderConfirmationDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  RetailStoreOrderProcessingDAO  retailStoreOrderProcessingDAO;
 	public void setRetailStoreOrderProcessingDAO(RetailStoreOrderProcessingDAO retailStoreOrderProcessingDAO){
	 	this.retailStoreOrderProcessingDAO = retailStoreOrderProcessingDAO;
 	}
 	public RetailStoreOrderProcessingDAO getRetailStoreOrderProcessingDAO(){
	 	return this.retailStoreOrderProcessingDAO;
 	}


			
		
	
  	private  RetailStoreOrderLineItemDAO  retailStoreOrderLineItemDAO;
 	public void setRetailStoreOrderLineItemDAO(RetailStoreOrderLineItemDAO pRetailStoreOrderLineItemDAO){
 	
 		if(pRetailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderLineItemDAO to null.");
 		}
	 	this.retailStoreOrderLineItemDAO = pRetailStoreOrderLineItemDAO;
 	}
 	public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO(){
 		if(this.retailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("The retailStoreOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderLineItemDAO;
 	}	
 	
			
		
	
  	private  RetailStoreOrderShippingGroupDAO  retailStoreOrderShippingGroupDAO;
 	public void setRetailStoreOrderShippingGroupDAO(RetailStoreOrderShippingGroupDAO pRetailStoreOrderShippingGroupDAO){
 	
 		if(pRetailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderShippingGroupDAO to null.");
 		}
	 	this.retailStoreOrderShippingGroupDAO = pRetailStoreOrderShippingGroupDAO;
 	}
 	public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO(){
 		if(this.retailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The retailStoreOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderShippingGroupDAO;
 	}	
 	
			
		
	
  	private  RetailStoreOrderPaymentGroupDAO  retailStoreOrderPaymentGroupDAO;
 	public void setRetailStoreOrderPaymentGroupDAO(RetailStoreOrderPaymentGroupDAO pRetailStoreOrderPaymentGroupDAO){
 	
 		if(pRetailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderPaymentGroupDAO to null.");
 		}
	 	this.retailStoreOrderPaymentGroupDAO = pRetailStoreOrderPaymentGroupDAO;
 	}
 	public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO(){
 		if(this.retailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The retailStoreOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderPaymentGroupDAO;
 	}	
 	
			
		
	
  	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO pGoodsDAO){
 	
 		if(pGoodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = pGoodsDAO;
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
 	

 	
  

 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.CONFIRMATION);
 	}

 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.CONFIRMATION);
 	}
 	

 	
  

 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.APPROVAL);
 	}

 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.APPROVAL);
 	}
 	

 	
  

 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.PROCESSING);
 	}

 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.PROCESSING);
 	}
 	

 	
  

 	protected boolean isExtractPickingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.PICKING);
 	}

 	protected boolean isSavePickingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.PICKING);
 	}
 	

 	
  

 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.SHIPMENT);
 	}

 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.SHIPMENT);
 	}
 	

 	
  

 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.DELIVERY);
 	}

 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.DELIVERY);
 	}
 	

 	
 
		
	
	protected boolean isExtractRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.GOODS_LIST);
		
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
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractPickingEnabled(loadOptions)){
	 		extractPicking(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(retailStoreOrder, loadOptions);
 		}
 
		
		if(isExtractRetailStoreOrderLineItemListEnabled(loadOptions)){
	 		extractRetailStoreOrderLineItemList(retailStoreOrder, loadOptions);
 		}		
		
		if(isExtractRetailStoreOrderShippingGroupListEnabled(loadOptions)){
	 		extractRetailStoreOrderShippingGroupList(retailStoreOrder, loadOptions);
 		}		
		
		if(isExtractRetailStoreOrderPaymentGroupListEnabled(loadOptions)){
	 		extractRetailStoreOrderPaymentGroupList(retailStoreOrder, loadOptions);
 		}		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(retailStoreOrder, loadOptions);
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
 		
  

 	protected RetailStoreOrder extractConfirmation(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getConfirmation() == null){
			return retailStoreOrder;
		}
		String confirmationId = retailStoreOrder.getConfirmation().getId();
		if( confirmationId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderConfirmation confirmation = getRetailStoreOrderConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			retailStoreOrder.setConfirmation(confirmation);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractApproval(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getApproval() == null){
			return retailStoreOrder;
		}
		String approvalId = retailStoreOrder.getApproval().getId();
		if( approvalId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderApproval approval = getRetailStoreOrderApprovalDAO().load(approvalId,options);
		if(approval != null){
			retailStoreOrder.setApproval(approval);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractProcessing(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getProcessing() == null){
			return retailStoreOrder;
		}
		String processingId = retailStoreOrder.getProcessing().getId();
		if( processingId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderProcessing processing = getRetailStoreOrderProcessingDAO().load(processingId,options);
		if(processing != null){
			retailStoreOrder.setProcessing(processing);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractPicking(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getPicking() == null){
			return retailStoreOrder;
		}
		String pickingId = retailStoreOrder.getPicking().getId();
		if( pickingId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderPicking picking = getRetailStoreOrderPickingDAO().load(pickingId,options);
		if(picking != null){
			retailStoreOrder.setPicking(picking);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractShipment(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getShipment() == null){
			return retailStoreOrder;
		}
		String shipmentId = retailStoreOrder.getShipment().getId();
		if( shipmentId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderShipment shipment = getRetailStoreOrderShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			retailStoreOrder.setShipment(shipment);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractDelivery(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getDelivery() == null){
			return retailStoreOrder;
		}
		String deliveryId = retailStoreOrder.getDelivery().getId();
		if( deliveryId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderDelivery delivery = getRetailStoreOrderDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			retailStoreOrder.setDelivery(delivery);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
 
		
	protected void enhanceRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
	protected void enhanceRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
	protected void enhanceRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
		
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_BUYER, retailStoreId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByBuyer(resultList, retailStoreId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_BUYER, retailStoreId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByBuyer(resultList, retailStoreId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByBuyer(SmartList<RetailStoreOrder> resultList, String retailStoreId, Map<String,Object> options){
	
		
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
		analyzeRetailStoreOrderBySeller(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_SELLER, retailStoreCountryCenterId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderBySeller(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderBySeller(SmartList<RetailStoreOrder> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
	
		
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
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_CONFIRMATION, retailStoreOrderConfirmationId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByConfirmation(resultList, retailStoreOrderConfirmationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_CONFIRMATION, retailStoreOrderConfirmationId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByConfirmation(resultList, retailStoreOrderConfirmationId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByConfirmation(SmartList<RetailStoreOrder> resultList, String retailStoreOrderConfirmationId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.CONFIRMATION_PROPERTY, retailStoreOrderConfirmationId);
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
 	public int countRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_CONFIRMATION, retailStoreOrderConfirmationId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByConfirmationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_CONFIRMATION, ids, options);
	}
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_APPROVAL, retailStoreOrderApprovalId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByApproval(resultList, retailStoreOrderApprovalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_APPROVAL, retailStoreOrderApprovalId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByApproval(resultList, retailStoreOrderApprovalId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByApproval(SmartList<RetailStoreOrder> resultList, String retailStoreOrderApprovalId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.APPROVAL_PROPERTY, retailStoreOrderApprovalId);
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
 	public int countRetailStoreOrderByApproval(String retailStoreOrderApprovalId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_APPROVAL, retailStoreOrderApprovalId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByApprovalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_APPROVAL, ids, options);
	}
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_PROCESSING, retailStoreOrderProcessingId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByProcessing(resultList, retailStoreOrderProcessingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_PROCESSING, retailStoreOrderProcessingId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByProcessing(resultList, retailStoreOrderProcessingId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByProcessing(SmartList<RetailStoreOrder> resultList, String retailStoreOrderProcessingId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.PROCESSING_PROPERTY, retailStoreOrderProcessingId);
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
 	public int countRetailStoreOrderByProcessing(String retailStoreOrderProcessingId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_PROCESSING, retailStoreOrderProcessingId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByProcessingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_PROCESSING, ids, options);
	}
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_PICKING, retailStoreOrderPickingId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByPicking(resultList, retailStoreOrderPickingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_PICKING, retailStoreOrderPickingId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByPicking(resultList, retailStoreOrderPickingId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByPicking(SmartList<RetailStoreOrder> resultList, String retailStoreOrderPickingId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.PICKING_PROPERTY, retailStoreOrderPickingId);
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
 	public int countRetailStoreOrderByPicking(String retailStoreOrderPickingId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_PICKING, retailStoreOrderPickingId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByPickingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_PICKING, ids, options);
	}
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_SHIPMENT, retailStoreOrderShipmentId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByShipment(resultList, retailStoreOrderShipmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_SHIPMENT, retailStoreOrderShipmentId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByShipment(resultList, retailStoreOrderShipmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByShipment(SmartList<RetailStoreOrder> resultList, String retailStoreOrderShipmentId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.SHIPMENT_PROPERTY, retailStoreOrderShipmentId);
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
 	public int countRetailStoreOrderByShipment(String retailStoreOrderShipmentId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_SHIPMENT, retailStoreOrderShipmentId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByShipmentIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_SHIPMENT, ids, options);
	}
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrder> resultList = queryWith(RetailStoreOrderTable.COLUMN_DELIVERY, retailStoreOrderDeliveryId, options, getRetailStoreOrderMapper());
		analyzeRetailStoreOrderByDelivery(resultList, retailStoreOrderDeliveryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrder> resultList =  queryWithRange(RetailStoreOrderTable.COLUMN_DELIVERY, retailStoreOrderDeliveryId, options, getRetailStoreOrderMapper(), start, count);
 		analyzeRetailStoreOrderByDelivery(resultList, retailStoreOrderDeliveryId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderByDelivery(SmartList<RetailStoreOrder> resultList, String retailStoreOrderDeliveryId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreOrder.DELIVERY_PROPERTY, retailStoreOrderDeliveryId);
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
 	public int countRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId,Map<String,Object> options){

 		return countWith(RetailStoreOrderTable.COLUMN_DELIVERY, retailStoreOrderDeliveryId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderByDeliveryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderTable.COLUMN_DELIVERY, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreOrder saveRetailStoreOrder(RetailStoreOrder  retailStoreOrder){
		
		if(!retailStoreOrder.isChanged()){
			return retailStoreOrder;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderSQL(retailStoreOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderParameters(retailStoreOrder);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrder.incVersion();
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
 		Object[] parameters = new Object[15];
  	
 		if(retailStoreOrder.getBuyer() != null){
 			parameters[0] = retailStoreOrder.getBuyer().getId();
 		}
  	
 		if(retailStoreOrder.getSeller() != null){
 			parameters[1] = retailStoreOrder.getSeller().getId();
 		}
 
 		parameters[2] = retailStoreOrder.getTitle();
 		parameters[3] = retailStoreOrder.getTotalAmount(); 	
 		if(retailStoreOrder.getConfirmation() != null){
 			parameters[4] = retailStoreOrder.getConfirmation().getId();
 		}
  	
 		if(retailStoreOrder.getApproval() != null){
 			parameters[5] = retailStoreOrder.getApproval().getId();
 		}
  	
 		if(retailStoreOrder.getProcessing() != null){
 			parameters[6] = retailStoreOrder.getProcessing().getId();
 		}
  	
 		if(retailStoreOrder.getPicking() != null){
 			parameters[7] = retailStoreOrder.getPicking().getId();
 		}
  	
 		if(retailStoreOrder.getShipment() != null){
 			parameters[8] = retailStoreOrder.getShipment().getId();
 		}
  	
 		if(retailStoreOrder.getDelivery() != null){
 			parameters[9] = retailStoreOrder.getDelivery().getId();
 		}
 
 		parameters[10] = retailStoreOrder.getLastUpdateTime();
 		parameters[11] = retailStoreOrder.getCurrentStatus();		
 		parameters[12] = retailStoreOrder.nextVersion();
 		parameters[13] = retailStoreOrder.getId();
 		parameters[14] = retailStoreOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderCreateParameters(RetailStoreOrder retailStoreOrder){
		Object[] parameters = new Object[13];
		String newRetailStoreOrderId=getNextId();
		retailStoreOrder.setId(newRetailStoreOrderId);
		parameters[0] =  retailStoreOrder.getId();
  	
 		if(retailStoreOrder.getBuyer() != null){
 			parameters[1] = retailStoreOrder.getBuyer().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getSeller() != null){
 			parameters[2] = retailStoreOrder.getSeller().getId();
 		
 		}
 		
 		parameters[3] = retailStoreOrder.getTitle();
 		parameters[4] = retailStoreOrder.getTotalAmount(); 	
 		if(retailStoreOrder.getConfirmation() != null){
 			parameters[5] = retailStoreOrder.getConfirmation().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getApproval() != null){
 			parameters[6] = retailStoreOrder.getApproval().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getProcessing() != null){
 			parameters[7] = retailStoreOrder.getProcessing().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getPicking() != null){
 			parameters[8] = retailStoreOrder.getPicking().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getShipment() != null){
 			parameters[9] = retailStoreOrder.getShipment().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getDelivery() != null){
 			parameters[10] = retailStoreOrder.getDelivery().getId();
 		
 		}
 		
 		parameters[11] = retailStoreOrder.getLastUpdateTime();
 		parameters[12] = retailStoreOrder.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrder saveInternalRetailStoreOrder(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		
		saveRetailStoreOrder(retailStoreOrder);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(retailStoreOrder, options);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(retailStoreOrder, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(retailStoreOrder, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(retailStoreOrder, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(retailStoreOrder, options);
 		}
  	
 		if(isSavePickingEnabled(options)){
	 		savePicking(retailStoreOrder, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(retailStoreOrder, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(retailStoreOrder, options);
 		}
 
		
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
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveConfirmation(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getConfirmation() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderConfirmationDAO().save(retailStoreOrder.getConfirmation(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveApproval(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getApproval() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderApprovalDAO().save(retailStoreOrder.getApproval(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveProcessing(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getProcessing() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderProcessingDAO().save(retailStoreOrder.getProcessing(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder savePicking(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getPicking() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderPickingDAO().save(retailStoreOrder.getPicking(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveShipment(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getShipment() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderShipmentDAO().save(retailStoreOrder.getShipment(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveDelivery(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getDelivery() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDeliveryDAO().save(retailStoreOrder.getDelivery(),options);
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
		
		for(RetailStoreOrderLineItem retailStoreOrderLineItem: externalRetailStoreOrderLineItemList){

			retailStoreOrderLineItem.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();		
		retailStoreOrderLineItemList.addAllToRemoveList(externalRetailStoreOrderLineItemList);
		return retailStoreOrder;	
	
	}


	//disconnect RetailStoreOrder with sku_id in RetailStoreOrderLineItem
	public RetailStoreOrder planToRemoveRetailStoreOrderLineItemListWithSkuId(RetailStoreOrder retailStoreOrder, String skuIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, retailStoreOrder.getId());
		key.put(RetailStoreOrderLineItem.SKU_ID_PROPERTY, skuIdId);
		
		SmartList<RetailStoreOrderLineItem> externalRetailStoreOrderLineItemList = getRetailStoreOrderLineItemDAO().
				findRetailStoreOrderLineItemWithKey(key, options);
		if(externalRetailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}
		if(externalRetailStoreOrderLineItemList.isEmpty()){
			return retailStoreOrder;
		}
		
		for(RetailStoreOrderLineItem retailStoreOrderLineItem: externalRetailStoreOrderLineItemList){
			retailStoreOrderLineItem.clearSkuId();
			retailStoreOrderLineItem.clearBizOrder();
			
		}
		
		
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();		
		retailStoreOrderLineItemList.addAllToRemoveList(externalRetailStoreOrderLineItemList);
		return retailStoreOrder;
	}
	
	public int countRetailStoreOrderLineItemListWithSkuId(String retailStoreOrderId, String skuIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, retailStoreOrderId);
		key.put(RetailStoreOrderLineItem.SKU_ID_PROPERTY, skuIdId);
		
		int count = getRetailStoreOrderLineItemDAO().countRetailStoreOrderLineItemWithKey(key, options);
		return count;
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
		
		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup: externalRetailStoreOrderShippingGroupList){

			retailStoreOrderShippingGroup.clearFromAll();
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
		
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup: externalRetailStoreOrderPaymentGroupList){

			retailStoreOrderPaymentGroup.clearFromAll();
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
		
		for(Goods goods: externalGoodsList){

			goods.clearFromAll();
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
		
		for(Goods goods: externalGoodsList){
			goods.clearSku();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearReceivingSpace();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearGoodsAllocation();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearSmartPallet();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearShippingSpace();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearTransportTask();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearRetailStore();
			goods.clearRetailStoreOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearBizOrder();
			goods.clearRetailStoreOrder();
			
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
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		
    public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getRetailStoreOrderMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrder> retailStoreOrderList) {		
		this.enhanceListInternal(retailStoreOrderList, this.getRetailStoreOrderMapper());
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
}


