
package com.doublechaintech.retailscm.consumerorder;

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


import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;

import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupDAO;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApprovalDAO;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipmentDAO;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderJDBCTemplateDAO extends RetailscmNamingServiceDAO implements ConsumerOrderDAO{
 
 	
 	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO supplyOrderApprovalDAO){
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
	 	return this.supplyOrderApprovalDAO;
 	}
 
 	
 	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO supplyOrderDeliveryDAO){
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
	 	return this.supplyOrderDeliveryDAO;
 	}
 
 	
 	private  SupplyOrderShipmentDAO  supplyOrderShipmentDAO;
 	public void setSupplyOrderShipmentDAO(SupplyOrderShipmentDAO supplyOrderShipmentDAO){
	 	this.supplyOrderShipmentDAO = supplyOrderShipmentDAO;
 	}
 	public SupplyOrderShipmentDAO getSupplyOrderShipmentDAO(){
	 	return this.supplyOrderShipmentDAO;
 	}
 
 	
 	private  SupplyOrderConfirmationDAO  supplyOrderConfirmationDAO;
 	public void setSupplyOrderConfirmationDAO(SupplyOrderConfirmationDAO supplyOrderConfirmationDAO){
	 	this.supplyOrderConfirmationDAO = supplyOrderConfirmationDAO;
 	}
 	public SupplyOrderConfirmationDAO getSupplyOrderConfirmationDAO(){
	 	return this.supplyOrderConfirmationDAO;
 	}
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO supplyOrderProcessingDAO){
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
	 	return this.supplyOrderProcessingDAO;
 	}


			
		
	
  	private  ConsumerOrderLineItemDAO  consumerOrderLineItemDAO;
 	public void setConsumerOrderLineItemDAO(ConsumerOrderLineItemDAO pConsumerOrderLineItemDAO){
 	
 		if(pConsumerOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderLineItemDAO to null.");
 		}
	 	this.consumerOrderLineItemDAO = pConsumerOrderLineItemDAO;
 	}
 	public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO(){
 		if(this.consumerOrderLineItemDAO == null){
 			throw new IllegalStateException("The consumerOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderLineItemDAO;
 	}	
 	
			
		
	
  	private  ConsumerOrderShippingGroupDAO  consumerOrderShippingGroupDAO;
 	public void setConsumerOrderShippingGroupDAO(ConsumerOrderShippingGroupDAO pConsumerOrderShippingGroupDAO){
 	
 		if(pConsumerOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderShippingGroupDAO to null.");
 		}
	 	this.consumerOrderShippingGroupDAO = pConsumerOrderShippingGroupDAO;
 	}
 	public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO(){
 		if(this.consumerOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The consumerOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderShippingGroupDAO;
 	}	
 	
			
		
	
  	private  ConsumerOrderPaymentGroupDAO  consumerOrderPaymentGroupDAO;
 	public void setConsumerOrderPaymentGroupDAO(ConsumerOrderPaymentGroupDAO pConsumerOrderPaymentGroupDAO){
 	
 		if(pConsumerOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderPaymentGroupDAO to null.");
 		}
	 	this.consumerOrderPaymentGroupDAO = pConsumerOrderPaymentGroupDAO;
 	}
 	public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO(){
 		if(this.consumerOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The consumerOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderPaymentGroupDAO;
 	}	
 	
			
		
	
  	private  ConsumerOrderPriceAdjustmentDAO  consumerOrderPriceAdjustmentDAO;
 	public void setConsumerOrderPriceAdjustmentDAO(ConsumerOrderPriceAdjustmentDAO pConsumerOrderPriceAdjustmentDAO){
 	
 		if(pConsumerOrderPriceAdjustmentDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderPriceAdjustmentDAO to null.");
 		}
	 	this.consumerOrderPriceAdjustmentDAO = pConsumerOrderPriceAdjustmentDAO;
 	}
 	public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO(){
 		if(this.consumerOrderPriceAdjustmentDAO == null){
 			throw new IllegalStateException("The consumerOrderPriceAdjustmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderPriceAdjustmentDAO;
 	}	
 	
			
		
	
  	private  RetailStoreMemberGiftCardConsumeRecordDAO  retailStoreMemberGiftCardConsumeRecordDAO;
 	public void setRetailStoreMemberGiftCardConsumeRecordDAO(RetailStoreMemberGiftCardConsumeRecordDAO pRetailStoreMemberGiftCardConsumeRecordDAO){
 	
 		if(pRetailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardConsumeRecordDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardConsumeRecordDAO = pRetailStoreMemberGiftCardConsumeRecordDAO;
 	}
 	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO(){
 		if(this.retailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("The retailStoreMemberGiftCardConsumeRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberGiftCardConsumeRecordDAO;
 	}	
 	
			
		

	
	/*
	protected ConsumerOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrder(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ConsumerOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrder(ConsumerOrderTable.withId(id), options);
	}
	
	
	
	public ConsumerOrder save(ConsumerOrder consumerOrder,Map<String,Object> options){
		
		String methodName="save(ConsumerOrder consumerOrder,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrder, methodName, "consumerOrder");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrder(consumerOrder,options);
	}
	public ConsumerOrder clone(String consumerOrderId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderTable.withId(consumerOrderId),options);
	}
	
	protected ConsumerOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrder newConsumerOrder = loadInternalConsumerOrder(accessKey, options);
		newConsumerOrder.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderLineItemListEnabled(options)){
 			for(ConsumerOrderLineItem item: newConsumerOrder.getConsumerOrderLineItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveConsumerOrderShippingGroupListEnabled(options)){
 			for(ConsumerOrderShippingGroup item: newConsumerOrder.getConsumerOrderShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveConsumerOrderPaymentGroupListEnabled(options)){
 			for(ConsumerOrderPaymentGroup item: newConsumerOrder.getConsumerOrderPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveConsumerOrderPriceAdjustmentListEnabled(options)){
 			for(ConsumerOrderPriceAdjustment item: newConsumerOrder.getConsumerOrderPriceAdjustmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)){
 			for(RetailStoreMemberGiftCardConsumeRecord item: newConsumerOrder.getRetailStoreMemberGiftCardConsumeRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalConsumerOrder(newConsumerOrder,options);
		
		return newConsumerOrder;
	}
	
	
	
	

	protected void throwIfHasException(String consumerOrderId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String consumerOrderId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderId, int version)";
		assertMethodArgumentNotNull(consumerOrderId, methodName, "consumerOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderId,version);
		}
		
	
	}
	
	
	
	
	

	public ConsumerOrder disconnectFromAll(String consumerOrderId, int version) throws Exception{
	
		
		ConsumerOrder consumerOrder = loadInternalConsumerOrder(ConsumerOrderTable.withId(consumerOrderId), emptyOptions());
		consumerOrder.clearFromAll();
		this.saveConsumerOrder(consumerOrder);
		return consumerOrder;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order";
	}
	@Override
	protected String getBeanName() {
		
		return "consumerOrder";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractConsumerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.CONSUMER);
 	}

 	protected boolean isSaveConsumerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.CONSUMER);
 	}
 	

 	
  

 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.CONFIRMATION);
 	}

 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.CONFIRMATION);
 	}
 	

 	
  

 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.APPROVAL);
 	}

 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.APPROVAL);
 	}
 	

 	
  

 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.PROCESSING);
 	}

 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.PROCESSING);
 	}
 	

 	
  

 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.SHIPMENT);
 	}

 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.SHIPMENT);
 	}
 	

 	
  

 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.DELIVERY);
 	}

 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.DELIVERY);
 	}
 	

 	
  

 	protected boolean isExtractStoreEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.STORE);
 	}

 	protected boolean isSaveStoreEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.STORE);
 	}
 	

 	
 
		
	
	protected boolean isExtractConsumerOrderLineItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_LINE_ITEM_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderLineItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_LINE_ITEM_LIST+".analyze");
 	}

	protected boolean isSaveConsumerOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_LINE_ITEM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractConsumerOrderShippingGroupListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_SHIPPING_GROUP_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderShippingGroupListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_SHIPPING_GROUP_LIST+".analyze");
 	}

	protected boolean isSaveConsumerOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_SHIPPING_GROUP_LIST);
		
 	}
 	
		
	
	protected boolean isExtractConsumerOrderPaymentGroupListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_PAYMENT_GROUP_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderPaymentGroupListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_PAYMENT_GROUP_LIST+".analyze");
 	}

	protected boolean isSaveConsumerOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_PAYMENT_GROUP_LIST);
		
 	}
 	
		
	
	protected boolean isExtractConsumerOrderPriceAdjustmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderPriceAdjustmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST+".analyze");
 	}

	protected boolean isSaveConsumerOrderPriceAdjustmentListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ConsumerOrderTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+".analyze");
 	}

	protected boolean isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		
 	}
 	
		

	

	protected ConsumerOrderMapper getConsumerOrderMapper(){
		return new ConsumerOrderMapper();
	}

	
	
	protected ConsumerOrder extractConsumerOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrder consumerOrder = loadSingleObject(accessKey, getConsumerOrderMapper());
			return consumerOrder;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderNotFoundException("ConsumerOrder("+accessKey+") is not found!");
		}

	}

	
	

	protected ConsumerOrder loadInternalConsumerOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrder consumerOrder = extractConsumerOrder(accessKey, loadOptions);
 	
 		if(isExtractConsumerEnabled(loadOptions)){
	 		extractConsumer(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractStoreEnabled(loadOptions)){
	 		extractStore(consumerOrder, loadOptions);
 		}
 
		
		if(isExtractConsumerOrderLineItemListEnabled(loadOptions)){
	 		extractConsumerOrderLineItemList(consumerOrder, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderLineItemListEnabled(loadOptions)){
	 		// analyzeConsumerOrderLineItemList(consumerOrder, loadOptions);
 		}
 		
		
		if(isExtractConsumerOrderShippingGroupListEnabled(loadOptions)){
	 		extractConsumerOrderShippingGroupList(consumerOrder, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderShippingGroupListEnabled(loadOptions)){
	 		// analyzeConsumerOrderShippingGroupList(consumerOrder, loadOptions);
 		}
 		
		
		if(isExtractConsumerOrderPaymentGroupListEnabled(loadOptions)){
	 		extractConsumerOrderPaymentGroupList(consumerOrder, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderPaymentGroupListEnabled(loadOptions)){
	 		// analyzeConsumerOrderPaymentGroupList(consumerOrder, loadOptions);
 		}
 		
		
		if(isExtractConsumerOrderPriceAdjustmentListEnabled(loadOptions)){
	 		extractConsumerOrderPriceAdjustmentList(consumerOrder, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderPriceAdjustmentListEnabled(loadOptions)){
	 		// analyzeConsumerOrderPriceAdjustmentList(consumerOrder, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(loadOptions)){
	 		extractRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, loadOptions);
 		}	
 		if(isAnalyzeRetailStoreMemberGiftCardConsumeRecordListEnabled(loadOptions)){
	 		// analyzeRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, loadOptions);
 		}
 		
		
		return consumerOrder;
		
	}

	 

 	protected ConsumerOrder extractConsumer(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getConsumer() == null){
			return consumerOrder;
		}
		String consumerId = consumerOrder.getConsumer().getId();
		if( consumerId == null){
			return consumerOrder;
		}
		RetailStoreMember consumer = getRetailStoreMemberDAO().load(consumerId,options);
		if(consumer != null){
			consumerOrder.setConsumer(consumer);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractConfirmation(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getConfirmation() == null){
			return consumerOrder;
		}
		String confirmationId = consumerOrder.getConfirmation().getId();
		if( confirmationId == null){
			return consumerOrder;
		}
		SupplyOrderConfirmation confirmation = getSupplyOrderConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			consumerOrder.setConfirmation(confirmation);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractApproval(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getApproval() == null){
			return consumerOrder;
		}
		String approvalId = consumerOrder.getApproval().getId();
		if( approvalId == null){
			return consumerOrder;
		}
		SupplyOrderApproval approval = getSupplyOrderApprovalDAO().load(approvalId,options);
		if(approval != null){
			consumerOrder.setApproval(approval);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractProcessing(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getProcessing() == null){
			return consumerOrder;
		}
		String processingId = consumerOrder.getProcessing().getId();
		if( processingId == null){
			return consumerOrder;
		}
		SupplyOrderProcessing processing = getSupplyOrderProcessingDAO().load(processingId,options);
		if(processing != null){
			consumerOrder.setProcessing(processing);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractShipment(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getShipment() == null){
			return consumerOrder;
		}
		String shipmentId = consumerOrder.getShipment().getId();
		if( shipmentId == null){
			return consumerOrder;
		}
		SupplyOrderShipment shipment = getSupplyOrderShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			consumerOrder.setShipment(shipment);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractDelivery(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getDelivery() == null){
			return consumerOrder;
		}
		String deliveryId = consumerOrder.getDelivery().getId();
		if( deliveryId == null){
			return consumerOrder;
		}
		SupplyOrderDelivery delivery = getSupplyOrderDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			consumerOrder.setDelivery(delivery);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractStore(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getStore() == null){
			return consumerOrder;
		}
		String storeId = consumerOrder.getStore().getId();
		if( storeId == null){
			return consumerOrder;
		}
		RetailStore store = getRetailStoreDAO().load(storeId,options);
		if(store != null){
			consumerOrder.setStore(store);
		}
		
 		
 		return consumerOrder;
 	}
 		
 
		
	protected void enhanceConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ConsumerOrder extractConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = getConsumerOrderLineItemDAO().findConsumerOrderLineItemByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderLineItemList != null){
			enhanceConsumerOrderLineItemList(consumerOrderLineItemList,options);
			consumerOrder.setConsumerOrderLineItemList(consumerOrderLineItemList);
		}
		
		return consumerOrder;
	
	}	
	
	protected ConsumerOrder analyzeConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();
		if(consumerOrderLineItemList != null){
			getConsumerOrderLineItemDAO().analyzeConsumerOrderLineItemByBizOrder(consumerOrderLineItemList, consumerOrder.getId(), options);
			
		}
		
		return consumerOrder;
	
	}	
	
		
	protected void enhanceConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ConsumerOrder extractConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = getConsumerOrderShippingGroupDAO().findConsumerOrderShippingGroupByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderShippingGroupList != null){
			enhanceConsumerOrderShippingGroupList(consumerOrderShippingGroupList,options);
			consumerOrder.setConsumerOrderShippingGroupList(consumerOrderShippingGroupList);
		}
		
		return consumerOrder;
	
	}	
	
	protected ConsumerOrder analyzeConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();
		if(consumerOrderShippingGroupList != null){
			getConsumerOrderShippingGroupDAO().analyzeConsumerOrderShippingGroupByBizOrder(consumerOrderShippingGroupList, consumerOrder.getId(), options);
			
		}
		
		return consumerOrder;
	
	}	
	
		
	protected void enhanceConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ConsumerOrder extractConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = getConsumerOrderPaymentGroupDAO().findConsumerOrderPaymentGroupByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderPaymentGroupList != null){
			enhanceConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList,options);
			consumerOrder.setConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList);
		}
		
		return consumerOrder;
	
	}	
	
	protected ConsumerOrder analyzeConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();
		if(consumerOrderPaymentGroupList != null){
			getConsumerOrderPaymentGroupDAO().analyzeConsumerOrderPaymentGroupByBizOrder(consumerOrderPaymentGroupList, consumerOrder.getId(), options);
			
		}
		
		return consumerOrder;
	
	}	
	
		
	protected void enhanceConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ConsumerOrder extractConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = getConsumerOrderPriceAdjustmentDAO().findConsumerOrderPriceAdjustmentByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderPriceAdjustmentList != null){
			enhanceConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList,options);
			consumerOrder.setConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList);
		}
		
		return consumerOrder;
	
	}	
	
	protected ConsumerOrder analyzeConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();
		if(consumerOrderPriceAdjustmentList != null){
			getConsumerOrderPriceAdjustmentDAO().analyzeConsumerOrderPriceAdjustmentByBizOrder(consumerOrderPriceAdjustmentList, consumerOrder.getId(), options);
			
		}
		
		return consumerOrder;
	
	}	
	
		
	protected void enhanceRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ConsumerOrder extractRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = getRetailStoreMemberGiftCardConsumeRecordDAO().findRetailStoreMemberGiftCardConsumeRecordByBizOrder(consumerOrder.getId(),options);
		if(retailStoreMemberGiftCardConsumeRecordList != null){
			enhanceRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList,options);
			consumerOrder.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);
		}
		
		return consumerOrder;
	
	}	
	
	protected ConsumerOrder analyzeRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		if(consumerOrder == null){
			return null;
		}
		if(consumerOrder.getId() == null){
			return consumerOrder;
		}

		
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList != null){
			getRetailStoreMemberGiftCardConsumeRecordDAO().analyzeRetailStoreMemberGiftCardConsumeRecordByBizOrder(retailStoreMemberGiftCardConsumeRecordList, consumerOrder.getId(), options);
			
		}
		
		return consumerOrder;
	
	}	
	
		
		
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_CONSUMER, retailStoreMemberId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByConsumer(resultList, retailStoreMemberId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_CONSUMER, retailStoreMemberId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByConsumer(resultList, retailStoreMemberId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByConsumer(SmartList<ConsumerOrder> resultList, String retailStoreMemberId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.CONSUMER_PROPERTY, retailStoreMemberId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByConsumer(String retailStoreMemberId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_CONSUMER, retailStoreMemberId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByConsumerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_CONSUMER, ids, options);
	}
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_CONFIRMATION, supplyOrderConfirmationId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByConfirmation(resultList, supplyOrderConfirmationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_CONFIRMATION, supplyOrderConfirmationId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByConfirmation(resultList, supplyOrderConfirmationId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByConfirmation(SmartList<ConsumerOrder> resultList, String supplyOrderConfirmationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_CONFIRMATION, supplyOrderConfirmationId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByConfirmationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_CONFIRMATION, ids, options);
	}
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_APPROVAL, supplyOrderApprovalId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByApproval(resultList, supplyOrderApprovalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_APPROVAL, supplyOrderApprovalId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByApproval(resultList, supplyOrderApprovalId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByApproval(SmartList<ConsumerOrder> resultList, String supplyOrderApprovalId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.APPROVAL_PROPERTY, supplyOrderApprovalId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_APPROVAL, supplyOrderApprovalId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByApprovalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_APPROVAL, ids, options);
	}
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_PROCESSING, supplyOrderProcessingId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByProcessing(resultList, supplyOrderProcessingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_PROCESSING, supplyOrderProcessingId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByProcessing(resultList, supplyOrderProcessingId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByProcessing(SmartList<ConsumerOrder> resultList, String supplyOrderProcessingId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.PROCESSING_PROPERTY, supplyOrderProcessingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_PROCESSING, supplyOrderProcessingId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByProcessingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_PROCESSING, ids, options);
	}
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_SHIPMENT, supplyOrderShipmentId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByShipment(resultList, supplyOrderShipmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_SHIPMENT, supplyOrderShipmentId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByShipment(resultList, supplyOrderShipmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByShipment(SmartList<ConsumerOrder> resultList, String supplyOrderShipmentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.SHIPMENT_PROPERTY, supplyOrderShipmentId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_SHIPMENT, supplyOrderShipmentId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByShipmentIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_SHIPMENT, ids, options);
	}
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_DELIVERY, supplyOrderDeliveryId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByDelivery(resultList, supplyOrderDeliveryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_DELIVERY, supplyOrderDeliveryId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByDelivery(resultList, supplyOrderDeliveryId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByDelivery(SmartList<ConsumerOrder> resultList, String supplyOrderDeliveryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_DELIVERY, supplyOrderDeliveryId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByDeliveryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_DELIVERY, ids, options);
	}
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrder> resultList = queryWith(ConsumerOrderTable.COLUMN_STORE, retailStoreId, options, getConsumerOrderMapper());
		// analyzeConsumerOrderByStore(resultList, retailStoreId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrder> resultList =  queryWithRange(ConsumerOrderTable.COLUMN_STORE, retailStoreId, options, getConsumerOrderMapper(), start, count);
 		//analyzeConsumerOrderByStore(resultList, retailStoreId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderByStore(SmartList<ConsumerOrder> resultList, String retailStoreId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrder.STORE_PROPERTY, retailStoreId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Consumer Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderByStore(String retailStoreId,Map<String,Object> options){

 		return countWith(ConsumerOrderTable.COLUMN_STORE, retailStoreId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderByStoreIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderTable.COLUMN_STORE, ids, options);
	}
 	
 	
		
		
		

	

	protected ConsumerOrder saveConsumerOrder(ConsumerOrder  consumerOrder){
		
		if(!consumerOrder.isChanged()){
			return consumerOrder;
		}
		
		
		String SQL=this.getSaveConsumerOrderSQL(consumerOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderParameters(consumerOrder);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrder.incVersion();
		return consumerOrder;
	
	}
	public SmartList<ConsumerOrder> saveConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderList(consumerOrderList);
		
		batchConsumerOrderCreate((List<ConsumerOrder>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderUpdate((List<ConsumerOrder>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrder consumerOrder:consumerOrderList){
			if(consumerOrder.isChanged()){
				consumerOrder.incVersion();
			}
			
		
		}
		
		
		return consumerOrderList;
	}

	public SmartList<ConsumerOrder> removeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderList, options);
		
		return consumerOrderList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderBatchCreateArgs(List<ConsumerOrder> consumerOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrder consumerOrder:consumerOrderList ){
			Object [] parameters = prepareConsumerOrderCreateParameters(consumerOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderBatchUpdateArgs(List<ConsumerOrder> consumerOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrder consumerOrder:consumerOrderList ){
			if(!consumerOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderUpdateParameters(consumerOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderCreate(List<ConsumerOrder> consumerOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderBatchCreateArgs(consumerOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderUpdate(List<ConsumerOrder> consumerOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderBatchUpdateArgs(consumerOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderList(List<ConsumerOrder> consumerOrderList){
		
		List<ConsumerOrder> consumerOrderCreateList=new ArrayList<ConsumerOrder>();
		List<ConsumerOrder> consumerOrderUpdateList=new ArrayList<ConsumerOrder>();
		
		for(ConsumerOrder consumerOrder: consumerOrderList){
			if(isUpdateRequest(consumerOrder)){
				consumerOrderUpdateList.add( consumerOrder);
				continue;
			}
			consumerOrderCreateList.add(consumerOrder);
		}
		
		return new Object[]{consumerOrderCreateList,consumerOrderUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrder consumerOrder){
 		return consumerOrder.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderSQL(ConsumerOrder consumerOrder){
 		if(isUpdateRequest(consumerOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderParameters(ConsumerOrder consumerOrder){
 		if(isUpdateRequest(consumerOrder) ){
 			return prepareConsumerOrderUpdateParameters(consumerOrder);
 		}
 		return prepareConsumerOrderCreateParameters(consumerOrder);
 	}
 	protected Object[] prepareConsumerOrderUpdateParameters(ConsumerOrder consumerOrder){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = consumerOrder.getTitle(); 	
 		if(consumerOrder.getConsumer() != null){
 			parameters[1] = consumerOrder.getConsumer().getId();
 		}
  	
 		if(consumerOrder.getConfirmation() != null){
 			parameters[2] = consumerOrder.getConfirmation().getId();
 		}
  	
 		if(consumerOrder.getApproval() != null){
 			parameters[3] = consumerOrder.getApproval().getId();
 		}
  	
 		if(consumerOrder.getProcessing() != null){
 			parameters[4] = consumerOrder.getProcessing().getId();
 		}
  	
 		if(consumerOrder.getShipment() != null){
 			parameters[5] = consumerOrder.getShipment().getId();
 		}
  	
 		if(consumerOrder.getDelivery() != null){
 			parameters[6] = consumerOrder.getDelivery().getId();
 		}
  	
 		if(consumerOrder.getStore() != null){
 			parameters[7] = consumerOrder.getStore().getId();
 		}
 
 		parameters[8] = consumerOrder.getLastUpdateTime();
 		parameters[9] = consumerOrder.getCurrentStatus();		
 		parameters[10] = consumerOrder.nextVersion();
 		parameters[11] = consumerOrder.getId();
 		parameters[12] = consumerOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderCreateParameters(ConsumerOrder consumerOrder){
		Object[] parameters = new Object[11];
		String newConsumerOrderId=getNextId();
		consumerOrder.setId(newConsumerOrderId);
		parameters[0] =  consumerOrder.getId();
 
 		parameters[1] = consumerOrder.getTitle(); 	
 		if(consumerOrder.getConsumer() != null){
 			parameters[2] = consumerOrder.getConsumer().getId();
 		
 		}
 		 	
 		if(consumerOrder.getConfirmation() != null){
 			parameters[3] = consumerOrder.getConfirmation().getId();
 		
 		}
 		 	
 		if(consumerOrder.getApproval() != null){
 			parameters[4] = consumerOrder.getApproval().getId();
 		
 		}
 		 	
 		if(consumerOrder.getProcessing() != null){
 			parameters[5] = consumerOrder.getProcessing().getId();
 		
 		}
 		 	
 		if(consumerOrder.getShipment() != null){
 			parameters[6] = consumerOrder.getShipment().getId();
 		
 		}
 		 	
 		if(consumerOrder.getDelivery() != null){
 			parameters[7] = consumerOrder.getDelivery().getId();
 		
 		}
 		 	
 		if(consumerOrder.getStore() != null){
 			parameters[8] = consumerOrder.getStore().getId();
 		
 		}
 		
 		parameters[9] = consumerOrder.getLastUpdateTime();
 		parameters[10] = consumerOrder.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrder saveInternalConsumerOrder(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		saveConsumerOrder(consumerOrder);
 	
 		if(isSaveConsumerEnabled(options)){
	 		saveConsumer(consumerOrder, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(consumerOrder, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(consumerOrder, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(consumerOrder, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(consumerOrder, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(consumerOrder, options);
 		}
  	
 		if(isSaveStoreEnabled(options)){
	 		saveStore(consumerOrder, options);
 		}
 
		
		if(isSaveConsumerOrderLineItemListEnabled(options)){
	 		saveConsumerOrderLineItemList(consumerOrder, options);
	 		//removeConsumerOrderLineItemList(consumerOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveConsumerOrderShippingGroupListEnabled(options)){
	 		saveConsumerOrderShippingGroupList(consumerOrder, options);
	 		//removeConsumerOrderShippingGroupList(consumerOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveConsumerOrderPaymentGroupListEnabled(options)){
	 		saveConsumerOrderPaymentGroupList(consumerOrder, options);
	 		//removeConsumerOrderPaymentGroupList(consumerOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveConsumerOrderPriceAdjustmentListEnabled(options)){
	 		saveConsumerOrderPriceAdjustmentList(consumerOrder, options);
	 		//removeConsumerOrderPriceAdjustmentList(consumerOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)){
	 		saveRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, options);
	 		//removeRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		return consumerOrder;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ConsumerOrder saveConsumer(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getConsumer() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(consumerOrder.getConsumer(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveConfirmation(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getConfirmation() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderConfirmationDAO().save(consumerOrder.getConfirmation(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveApproval(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getApproval() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderApprovalDAO().save(consumerOrder.getApproval(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveProcessing(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getProcessing() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderProcessingDAO().save(consumerOrder.getProcessing(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveShipment(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getShipment() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderShipmentDAO().save(consumerOrder.getShipment(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveDelivery(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getDelivery() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderDeliveryDAO().save(consumerOrder.getDelivery(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveStore(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getStore() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreDAO().save(consumerOrder.getStore(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ConsumerOrder planToRemoveConsumerOrderLineItemList(ConsumerOrder consumerOrder, String consumerOrderLineItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(ConsumerOrderLineItem.ID_PROPERTY, consumerOrderLineItemIds);
		
		SmartList<ConsumerOrderLineItem> externalConsumerOrderLineItemList = getConsumerOrderLineItemDAO().
				findConsumerOrderLineItemWithKey(key, options);
		if(externalConsumerOrderLineItemList == null){
			return consumerOrder;
		}
		if(externalConsumerOrderLineItemList.isEmpty()){
			return consumerOrder;
		}
		
		for(ConsumerOrderLineItem consumerOrderLineItem: externalConsumerOrderLineItemList){

			consumerOrderLineItem.clearFromAll();
		}
		
		
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();		
		consumerOrderLineItemList.addAllToRemoveList(externalConsumerOrderLineItemList);
		return consumerOrder;	
	
	}


	//disconnect ConsumerOrder with sku_id in ConsumerOrderLineItem
	public ConsumerOrder planToRemoveConsumerOrderLineItemListWithSkuId(ConsumerOrder consumerOrder, String skuIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(ConsumerOrderLineItem.SKU_ID_PROPERTY, skuIdId);
		
		SmartList<ConsumerOrderLineItem> externalConsumerOrderLineItemList = getConsumerOrderLineItemDAO().
				findConsumerOrderLineItemWithKey(key, options);
		if(externalConsumerOrderLineItemList == null){
			return consumerOrder;
		}
		if(externalConsumerOrderLineItemList.isEmpty()){
			return consumerOrder;
		}
		
		for(ConsumerOrderLineItem consumerOrderLineItem: externalConsumerOrderLineItemList){
			consumerOrderLineItem.clearSkuId();
			consumerOrderLineItem.clearBizOrder();
			
		}
		
		
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();		
		consumerOrderLineItemList.addAllToRemoveList(externalConsumerOrderLineItemList);
		return consumerOrder;
	}
	
	public int countConsumerOrderLineItemListWithSkuId(String consumerOrderId, String skuIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrderId);
		key.put(ConsumerOrderLineItem.SKU_ID_PROPERTY, skuIdId);
		
		int count = getConsumerOrderLineItemDAO().countConsumerOrderLineItemWithKey(key, options);
		return count;
	}
	
	public ConsumerOrder planToRemoveConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, String consumerOrderShippingGroupIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(ConsumerOrderShippingGroup.ID_PROPERTY, consumerOrderShippingGroupIds);
		
		SmartList<ConsumerOrderShippingGroup> externalConsumerOrderShippingGroupList = getConsumerOrderShippingGroupDAO().
				findConsumerOrderShippingGroupWithKey(key, options);
		if(externalConsumerOrderShippingGroupList == null){
			return consumerOrder;
		}
		if(externalConsumerOrderShippingGroupList.isEmpty()){
			return consumerOrder;
		}
		
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup: externalConsumerOrderShippingGroupList){

			consumerOrderShippingGroup.clearFromAll();
		}
		
		
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();		
		consumerOrderShippingGroupList.addAllToRemoveList(externalConsumerOrderShippingGroupList);
		return consumerOrder;	
	
	}


	public ConsumerOrder planToRemoveConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, String consumerOrderPaymentGroupIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(ConsumerOrderPaymentGroup.ID_PROPERTY, consumerOrderPaymentGroupIds);
		
		SmartList<ConsumerOrderPaymentGroup> externalConsumerOrderPaymentGroupList = getConsumerOrderPaymentGroupDAO().
				findConsumerOrderPaymentGroupWithKey(key, options);
		if(externalConsumerOrderPaymentGroupList == null){
			return consumerOrder;
		}
		if(externalConsumerOrderPaymentGroupList.isEmpty()){
			return consumerOrder;
		}
		
		for(ConsumerOrderPaymentGroup consumerOrderPaymentGroup: externalConsumerOrderPaymentGroupList){

			consumerOrderPaymentGroup.clearFromAll();
		}
		
		
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();		
		consumerOrderPaymentGroupList.addAllToRemoveList(externalConsumerOrderPaymentGroupList);
		return consumerOrder;	
	
	}


	public ConsumerOrder planToRemoveConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, String consumerOrderPriceAdjustmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(ConsumerOrderPriceAdjustment.ID_PROPERTY, consumerOrderPriceAdjustmentIds);
		
		SmartList<ConsumerOrderPriceAdjustment> externalConsumerOrderPriceAdjustmentList = getConsumerOrderPriceAdjustmentDAO().
				findConsumerOrderPriceAdjustmentWithKey(key, options);
		if(externalConsumerOrderPriceAdjustmentList == null){
			return consumerOrder;
		}
		if(externalConsumerOrderPriceAdjustmentList.isEmpty()){
			return consumerOrder;
		}
		
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment: externalConsumerOrderPriceAdjustmentList){

			consumerOrderPriceAdjustment.clearFromAll();
		}
		
		
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();		
		consumerOrderPriceAdjustmentList.addAllToRemoveList(externalConsumerOrderPriceAdjustmentList);
		return consumerOrder;	
	
	}


	public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, String retailStoreMemberGiftCardConsumeRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, retailStoreMemberGiftCardConsumeRecordIds);
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> externalRetailStoreMemberGiftCardConsumeRecordList = getRetailStoreMemberGiftCardConsumeRecordDAO().
				findRetailStoreMemberGiftCardConsumeRecordWithKey(key, options);
		if(externalRetailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}
		if(externalRetailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return consumerOrder;
		}
		
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord: externalRetailStoreMemberGiftCardConsumeRecordList){

			retailStoreMemberGiftCardConsumeRecord.clearFromAll();
		}
		
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();		
		retailStoreMemberGiftCardConsumeRecordList.addAllToRemoveList(externalRetailStoreMemberGiftCardConsumeRecordList);
		return consumerOrder;	
	
	}


	//disconnect ConsumerOrder with owner in RetailStoreMemberGiftCardConsumeRecord
	public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithOwner(ConsumerOrder consumerOrder, String ownerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, consumerOrder.getId());
		key.put(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, ownerId);
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> externalRetailStoreMemberGiftCardConsumeRecordList = getRetailStoreMemberGiftCardConsumeRecordDAO().
				findRetailStoreMemberGiftCardConsumeRecordWithKey(key, options);
		if(externalRetailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}
		if(externalRetailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return consumerOrder;
		}
		
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord: externalRetailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.clearOwner();
			retailStoreMemberGiftCardConsumeRecord.clearBizOrder();
			
		}
		
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();		
		retailStoreMemberGiftCardConsumeRecordList.addAllToRemoveList(externalRetailStoreMemberGiftCardConsumeRecordList);
		return consumerOrder;
	}
	
	public int countRetailStoreMemberGiftCardConsumeRecordListWithOwner(String consumerOrderId, String ownerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, consumerOrderId);
		key.put(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, ownerId);
		
		int count = getRetailStoreMemberGiftCardConsumeRecordDAO().countRetailStoreMemberGiftCardConsumeRecordWithKey(key, options);
		return count;
	}
	

		
	protected ConsumerOrder saveConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();
		if(consumerOrderLineItemList == null){
			//null list means nothing
			return consumerOrder;
		}
		SmartList<ConsumerOrderLineItem> mergedUpdateConsumerOrderLineItemList = new SmartList<ConsumerOrderLineItem>();
		
		
		mergedUpdateConsumerOrderLineItemList.addAll(consumerOrderLineItemList); 
		if(consumerOrderLineItemList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderLineItemList.addAll(consumerOrderLineItemList.getToRemoveList());
			consumerOrderLineItemList.removeAll(consumerOrderLineItemList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderLineItemDAO().saveConsumerOrderLineItemList(mergedUpdateConsumerOrderLineItemList,options);
		
		if(consumerOrderLineItemList.getToRemoveList() != null){
			consumerOrderLineItemList.removeAll(consumerOrderLineItemList.getToRemoveList());
		}
		
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();
		if(consumerOrderLineItemList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderLineItem> toRemoveConsumerOrderLineItemList = consumerOrderLineItemList.getToRemoveList();
		
		if(toRemoveConsumerOrderLineItemList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderLineItemList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderLineItemDAO().removeConsumerOrderLineItemList(toRemoveConsumerOrderLineItemList,options);
		
		return consumerOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected ConsumerOrder saveConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();
		if(consumerOrderShippingGroupList == null){
			//null list means nothing
			return consumerOrder;
		}
		SmartList<ConsumerOrderShippingGroup> mergedUpdateConsumerOrderShippingGroupList = new SmartList<ConsumerOrderShippingGroup>();
		
		
		mergedUpdateConsumerOrderShippingGroupList.addAll(consumerOrderShippingGroupList); 
		if(consumerOrderShippingGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderShippingGroupList.addAll(consumerOrderShippingGroupList.getToRemoveList());
			consumerOrderShippingGroupList.removeAll(consumerOrderShippingGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderShippingGroupDAO().saveConsumerOrderShippingGroupList(mergedUpdateConsumerOrderShippingGroupList,options);
		
		if(consumerOrderShippingGroupList.getToRemoveList() != null){
			consumerOrderShippingGroupList.removeAll(consumerOrderShippingGroupList.getToRemoveList());
		}
		
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();
		if(consumerOrderShippingGroupList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderShippingGroup> toRemoveConsumerOrderShippingGroupList = consumerOrderShippingGroupList.getToRemoveList();
		
		if(toRemoveConsumerOrderShippingGroupList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderShippingGroupList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderShippingGroupDAO().removeConsumerOrderShippingGroupList(toRemoveConsumerOrderShippingGroupList,options);
		
		return consumerOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected ConsumerOrder saveConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();
		if(consumerOrderPaymentGroupList == null){
			//null list means nothing
			return consumerOrder;
		}
		SmartList<ConsumerOrderPaymentGroup> mergedUpdateConsumerOrderPaymentGroupList = new SmartList<ConsumerOrderPaymentGroup>();
		
		
		mergedUpdateConsumerOrderPaymentGroupList.addAll(consumerOrderPaymentGroupList); 
		if(consumerOrderPaymentGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderPaymentGroupList.addAll(consumerOrderPaymentGroupList.getToRemoveList());
			consumerOrderPaymentGroupList.removeAll(consumerOrderPaymentGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderPaymentGroupDAO().saveConsumerOrderPaymentGroupList(mergedUpdateConsumerOrderPaymentGroupList,options);
		
		if(consumerOrderPaymentGroupList.getToRemoveList() != null){
			consumerOrderPaymentGroupList.removeAll(consumerOrderPaymentGroupList.getToRemoveList());
		}
		
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();
		if(consumerOrderPaymentGroupList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderPaymentGroup> toRemoveConsumerOrderPaymentGroupList = consumerOrderPaymentGroupList.getToRemoveList();
		
		if(toRemoveConsumerOrderPaymentGroupList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderPaymentGroupList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderPaymentGroupDAO().removeConsumerOrderPaymentGroupList(toRemoveConsumerOrderPaymentGroupList,options);
		
		return consumerOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected ConsumerOrder saveConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();
		if(consumerOrderPriceAdjustmentList == null){
			//null list means nothing
			return consumerOrder;
		}
		SmartList<ConsumerOrderPriceAdjustment> mergedUpdateConsumerOrderPriceAdjustmentList = new SmartList<ConsumerOrderPriceAdjustment>();
		
		
		mergedUpdateConsumerOrderPriceAdjustmentList.addAll(consumerOrderPriceAdjustmentList); 
		if(consumerOrderPriceAdjustmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderPriceAdjustmentList.addAll(consumerOrderPriceAdjustmentList.getToRemoveList());
			consumerOrderPriceAdjustmentList.removeAll(consumerOrderPriceAdjustmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderPriceAdjustmentDAO().saveConsumerOrderPriceAdjustmentList(mergedUpdateConsumerOrderPriceAdjustmentList,options);
		
		if(consumerOrderPriceAdjustmentList.getToRemoveList() != null){
			consumerOrderPriceAdjustmentList.removeAll(consumerOrderPriceAdjustmentList.getToRemoveList());
		}
		
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();
		if(consumerOrderPriceAdjustmentList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderPriceAdjustment> toRemoveConsumerOrderPriceAdjustmentList = consumerOrderPriceAdjustmentList.getToRemoveList();
		
		if(toRemoveConsumerOrderPriceAdjustmentList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderPriceAdjustmentList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderPriceAdjustmentDAO().removeConsumerOrderPriceAdjustmentList(toRemoveConsumerOrderPriceAdjustmentList,options);
		
		return consumerOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected ConsumerOrder saveRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			//null list means nothing
			return consumerOrder;
		}
		SmartList<RetailStoreMemberGiftCardConsumeRecord> mergedUpdateRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();
		
		
		mergedUpdateRetailStoreMemberGiftCardConsumeRecordList.addAll(retailStoreMemberGiftCardConsumeRecordList); 
		if(retailStoreMemberGiftCardConsumeRecordList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreMemberGiftCardConsumeRecordList.addAll(retailStoreMemberGiftCardConsumeRecordList.getToRemoveList());
			retailStoreMemberGiftCardConsumeRecordList.removeAll(retailStoreMemberGiftCardConsumeRecordList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRetailStoreMemberGiftCardConsumeRecordDAO().saveRetailStoreMemberGiftCardConsumeRecordList(mergedUpdateRetailStoreMemberGiftCardConsumeRecordList,options);
		
		if(retailStoreMemberGiftCardConsumeRecordList.getToRemoveList() != null){
			retailStoreMemberGiftCardConsumeRecordList.removeAll(retailStoreMemberGiftCardConsumeRecordList.getToRemoveList());
		}
		
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}	
	
		SmartList<RetailStoreMemberGiftCardConsumeRecord> toRemoveRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}
		if(toRemoveRetailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberGiftCardConsumeRecordDAO().removeRetailStoreMemberGiftCardConsumeRecordList(toRemoveRetailStoreMemberGiftCardConsumeRecordList,options);
		
		return consumerOrder;
	
	}
	
	

 	
 	
	
	
	
		

	public ConsumerOrder present(ConsumerOrder consumerOrder,Map<String, Object> options){
	
		presentConsumerOrderLineItemList(consumerOrder,options);
		presentConsumerOrderShippingGroupList(consumerOrder,options);
		presentConsumerOrderPaymentGroupList(consumerOrder,options);
		presentConsumerOrderPriceAdjustmentList(consumerOrder,options);
		presentRetailStoreMemberGiftCardConsumeRecordList(consumerOrder,options);

		return consumerOrder;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ConsumerOrder presentConsumerOrderLineItemList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();		
				SmartList<ConsumerOrderLineItem> newList= presentSubList(consumerOrder.getId(),
				consumerOrderLineItemList,
				options,
				getConsumerOrderLineItemDAO()::countConsumerOrderLineItemByBizOrder,
				getConsumerOrderLineItemDAO()::findConsumerOrderLineItemByBizOrder
				);

		
		consumerOrder.setConsumerOrderLineItemList(newList);
		

		return consumerOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ConsumerOrder presentConsumerOrderShippingGroupList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();		
				SmartList<ConsumerOrderShippingGroup> newList= presentSubList(consumerOrder.getId(),
				consumerOrderShippingGroupList,
				options,
				getConsumerOrderShippingGroupDAO()::countConsumerOrderShippingGroupByBizOrder,
				getConsumerOrderShippingGroupDAO()::findConsumerOrderShippingGroupByBizOrder
				);

		
		consumerOrder.setConsumerOrderShippingGroupList(newList);
		

		return consumerOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ConsumerOrder presentConsumerOrderPaymentGroupList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();		
				SmartList<ConsumerOrderPaymentGroup> newList= presentSubList(consumerOrder.getId(),
				consumerOrderPaymentGroupList,
				options,
				getConsumerOrderPaymentGroupDAO()::countConsumerOrderPaymentGroupByBizOrder,
				getConsumerOrderPaymentGroupDAO()::findConsumerOrderPaymentGroupByBizOrder
				);

		
		consumerOrder.setConsumerOrderPaymentGroupList(newList);
		

		return consumerOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ConsumerOrder presentConsumerOrderPriceAdjustmentList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();		
				SmartList<ConsumerOrderPriceAdjustment> newList= presentSubList(consumerOrder.getId(),
				consumerOrderPriceAdjustmentList,
				options,
				getConsumerOrderPriceAdjustmentDAO()::countConsumerOrderPriceAdjustmentByBizOrder,
				getConsumerOrderPriceAdjustmentDAO()::findConsumerOrderPriceAdjustmentByBizOrder
				);

		
		consumerOrder.setConsumerOrderPriceAdjustmentList(newList);
		

		return consumerOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ConsumerOrder presentRetailStoreMemberGiftCardConsumeRecordList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();		
				SmartList<RetailStoreMemberGiftCardConsumeRecord> newList= presentSubList(consumerOrder.getId(),
				retailStoreMemberGiftCardConsumeRecordList,
				options,
				getRetailStoreMemberGiftCardConsumeRecordDAO()::countRetailStoreMemberGiftCardConsumeRecordByBizOrder,
				getRetailStoreMemberGiftCardConsumeRecordDAO()::findRetailStoreMemberGiftCardConsumeRecordByBizOrder
				);

		
		consumerOrder.setRetailStoreMemberGiftCardConsumeRecordList(newList);
		

		return consumerOrder;
	}			
		

	
    public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderLineItem(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ConsumerOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getConsumerOrderMapper());
    }
		
    public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ConsumerOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getConsumerOrderMapper());
    }
		
    public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ConsumerOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getConsumerOrderMapper());
    }
		
    public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ConsumerOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getConsumerOrderMapper());
    }
		
    public SmartList<ConsumerOrder> requestCandidateConsumerOrderForRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ConsumerOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getConsumerOrderMapper());
    }
		

	protected String getTableName(){
		return ConsumerOrderTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ConsumerOrder> consumerOrderList) {		
		this.enhanceListInternal(consumerOrderList, this.getConsumerOrderMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrder> consumerOrderList = ownerEntity.collectRefsWithType(ConsumerOrder.INTERNAL_TYPE);
		this.enhanceList(consumerOrderList);
		
	}
	
	@Override
	public SmartList<ConsumerOrder> findConsumerOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getConsumerOrderMapper());

	}
	@Override
	public int countConsumerOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ConsumerOrder> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderMapper());
	}
}


