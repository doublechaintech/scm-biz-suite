
package com.doublechaintech.retailscm.supplyorder;

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


import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;

import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApprovalDAO;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipmentDAO;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemDAO;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.supplyorderpicking.SupplyOrderPickingDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderDAO{
 
 	
 	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO supplyOrderApprovalDAO){
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
	 	return this.supplyOrderApprovalDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO supplyOrderDeliveryDAO){
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
	 	return this.supplyOrderDeliveryDAO;
 	}
 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}
 
 	
 	private  SupplyOrderPickingDAO  supplyOrderPickingDAO;
 	public void setSupplyOrderPickingDAO(SupplyOrderPickingDAO supplyOrderPickingDAO){
	 	this.supplyOrderPickingDAO = supplyOrderPickingDAO;
 	}
 	public SupplyOrderPickingDAO getSupplyOrderPickingDAO(){
	 	return this.supplyOrderPickingDAO;
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
 
 	
 	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO supplyOrderProcessingDAO){
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
	 	return this.supplyOrderProcessingDAO;
 	}


			
		
	
  	private  SupplyOrderLineItemDAO  supplyOrderLineItemDAO;
 	public void setSupplyOrderLineItemDAO(SupplyOrderLineItemDAO pSupplyOrderLineItemDAO){
 	
 		if(pSupplyOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderLineItemDAO to null.");
 		}
	 	this.supplyOrderLineItemDAO = pSupplyOrderLineItemDAO;
 	}
 	public SupplyOrderLineItemDAO getSupplyOrderLineItemDAO(){
 		if(this.supplyOrderLineItemDAO == null){
 			throw new IllegalStateException("The supplyOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderLineItemDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderShippingGroupDAO  supplyOrderShippingGroupDAO;
 	public void setSupplyOrderShippingGroupDAO(SupplyOrderShippingGroupDAO pSupplyOrderShippingGroupDAO){
 	
 		if(pSupplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderShippingGroupDAO to null.");
 		}
	 	this.supplyOrderShippingGroupDAO = pSupplyOrderShippingGroupDAO;
 	}
 	public SupplyOrderShippingGroupDAO getSupplyOrderShippingGroupDAO(){
 		if(this.supplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The supplyOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderShippingGroupDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderPaymentGroupDAO  supplyOrderPaymentGroupDAO;
 	public void setSupplyOrderPaymentGroupDAO(SupplyOrderPaymentGroupDAO pSupplyOrderPaymentGroupDAO){
 	
 		if(pSupplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderPaymentGroupDAO to null.");
 		}
	 	this.supplyOrderPaymentGroupDAO = pSupplyOrderPaymentGroupDAO;
 	}
 	public SupplyOrderPaymentGroupDAO getSupplyOrderPaymentGroupDAO(){
 		if(this.supplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The supplyOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderPaymentGroupDAO;
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
	protected SupplyOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrder(accessKey, options);
	}
	*/
	
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
 	

 	
  

 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.CONFIRMATION);
 	}

 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.CONFIRMATION);
 	}
 	

 	
  

 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.APPROVAL);
 	}

 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.APPROVAL);
 	}
 	

 	
  

 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.PROCESSING);
 	}

 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.PROCESSING);
 	}
 	

 	
  

 	protected boolean isExtractPickingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.PICKING);
 	}

 	protected boolean isSavePickingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.PICKING);
 	}
 	

 	
  

 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.SHIPMENT);
 	}

 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.SHIPMENT);
 	}
 	

 	
  

 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.DELIVERY);
 	}

 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.DELIVERY);
 	}
 	

 	
 
		
	
	protected boolean isExtractSupplyOrderLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveSupplyOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSaveSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.GOODS_LIST);
		
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
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractPickingEnabled(loadOptions)){
	 		extractPicking(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(supplyOrder, loadOptions);
 		}
 
		
		if(isExtractSupplyOrderLineItemListEnabled(loadOptions)){
	 		extractSupplyOrderLineItemList(supplyOrder, loadOptions);
 		}		
		
		if(isExtractSupplyOrderShippingGroupListEnabled(loadOptions)){
	 		extractSupplyOrderShippingGroupList(supplyOrder, loadOptions);
 		}		
		
		if(isExtractSupplyOrderPaymentGroupListEnabled(loadOptions)){
	 		extractSupplyOrderPaymentGroupList(supplyOrder, loadOptions);
 		}		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(supplyOrder, loadOptions);
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
 		
  

 	protected SupplyOrder extractConfirmation(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getConfirmation() == null){
			return supplyOrder;
		}
		String confirmationId = supplyOrder.getConfirmation().getId();
		if( confirmationId == null){
			return supplyOrder;
		}
		SupplyOrderConfirmation confirmation = getSupplyOrderConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			supplyOrder.setConfirmation(confirmation);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractApproval(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getApproval() == null){
			return supplyOrder;
		}
		String approvalId = supplyOrder.getApproval().getId();
		if( approvalId == null){
			return supplyOrder;
		}
		SupplyOrderApproval approval = getSupplyOrderApprovalDAO().load(approvalId,options);
		if(approval != null){
			supplyOrder.setApproval(approval);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractProcessing(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getProcessing() == null){
			return supplyOrder;
		}
		String processingId = supplyOrder.getProcessing().getId();
		if( processingId == null){
			return supplyOrder;
		}
		SupplyOrderProcessing processing = getSupplyOrderProcessingDAO().load(processingId,options);
		if(processing != null){
			supplyOrder.setProcessing(processing);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractPicking(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getPicking() == null){
			return supplyOrder;
		}
		String pickingId = supplyOrder.getPicking().getId();
		if( pickingId == null){
			return supplyOrder;
		}
		SupplyOrderPicking picking = getSupplyOrderPickingDAO().load(pickingId,options);
		if(picking != null){
			supplyOrder.setPicking(picking);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractShipment(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getShipment() == null){
			return supplyOrder;
		}
		String shipmentId = supplyOrder.getShipment().getId();
		if( shipmentId == null){
			return supplyOrder;
		}
		SupplyOrderShipment shipment = getSupplyOrderShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			supplyOrder.setShipment(shipment);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractDelivery(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getDelivery() == null){
			return supplyOrder;
		}
		String deliveryId = supplyOrder.getDelivery().getId();
		if( deliveryId == null){
			return supplyOrder;
		}
		SupplyOrderDelivery delivery = getSupplyOrderDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			supplyOrder.setDelivery(delivery);
		}
		
 		
 		return supplyOrder;
 	}
 		
 
		
	protected void enhanceSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
	protected void enhanceSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
	protected void enhanceSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		
		//extract multiple list from difference 
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
		
		
  	
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_BUYER, retailStoreCountryCenterId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByBuyer(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_BUYER, retailStoreCountryCenterId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByBuyer(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByBuyer(SmartList<SupplyOrder> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
	
		
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
		analyzeSupplyOrderBySeller(resultList, goodsSupplierId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_SELLER, goodsSupplierId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderBySeller(resultList, goodsSupplierId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderBySeller(SmartList<SupplyOrder> resultList, String goodsSupplierId, Map<String,Object> options){
	
		
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
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_CONFIRMATION, supplyOrderConfirmationId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByConfirmation(resultList, supplyOrderConfirmationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByConfirmation(String supplyOrderConfirmationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_CONFIRMATION, supplyOrderConfirmationId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByConfirmation(resultList, supplyOrderConfirmationId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByConfirmation(SmartList<SupplyOrder> resultList, String supplyOrderConfirmationId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmationId);
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
 	public int countSupplyOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_CONFIRMATION, supplyOrderConfirmationId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByConfirmationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_CONFIRMATION, ids, options);
	}
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_APPROVAL, supplyOrderApprovalId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByApproval(resultList, supplyOrderApprovalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByApproval(String supplyOrderApprovalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_APPROVAL, supplyOrderApprovalId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByApproval(resultList, supplyOrderApprovalId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByApproval(SmartList<SupplyOrder> resultList, String supplyOrderApprovalId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.APPROVAL_PROPERTY, supplyOrderApprovalId);
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
 	public int countSupplyOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_APPROVAL, supplyOrderApprovalId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByApprovalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_APPROVAL, ids, options);
	}
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_PROCESSING, supplyOrderProcessingId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByProcessing(resultList, supplyOrderProcessingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByProcessing(String supplyOrderProcessingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_PROCESSING, supplyOrderProcessingId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByProcessing(resultList, supplyOrderProcessingId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByProcessing(SmartList<SupplyOrder> resultList, String supplyOrderProcessingId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.PROCESSING_PROPERTY, supplyOrderProcessingId);
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
 	public int countSupplyOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_PROCESSING, supplyOrderProcessingId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByProcessingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_PROCESSING, ids, options);
	}
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByPicking(String supplyOrderPickingId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_PICKING, supplyOrderPickingId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByPicking(resultList, supplyOrderPickingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByPicking(String supplyOrderPickingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_PICKING, supplyOrderPickingId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByPicking(resultList, supplyOrderPickingId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByPicking(SmartList<SupplyOrder> resultList, String supplyOrderPickingId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.PICKING_PROPERTY, supplyOrderPickingId);
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
 	public int countSupplyOrderByPicking(String supplyOrderPickingId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_PICKING, supplyOrderPickingId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByPickingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_PICKING, ids, options);
	}
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_SHIPMENT, supplyOrderShipmentId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByShipment(resultList, supplyOrderShipmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByShipment(String supplyOrderShipmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_SHIPMENT, supplyOrderShipmentId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByShipment(resultList, supplyOrderShipmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByShipment(SmartList<SupplyOrder> resultList, String supplyOrderShipmentId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.SHIPMENT_PROPERTY, supplyOrderShipmentId);
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
 	public int countSupplyOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_SHIPMENT, supplyOrderShipmentId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByShipmentIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_SHIPMENT, ids, options);
	}
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){
 	
  		SmartList<SupplyOrder> resultList = queryWith(SupplyOrderTable.COLUMN_DELIVERY, supplyOrderDeliveryId, options, getSupplyOrderMapper());
		analyzeSupplyOrderByDelivery(resultList, supplyOrderDeliveryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrder> findSupplyOrderByDelivery(String supplyOrderDeliveryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrder> resultList =  queryWithRange(SupplyOrderTable.COLUMN_DELIVERY, supplyOrderDeliveryId, options, getSupplyOrderMapper(), start, count);
 		analyzeSupplyOrderByDelivery(resultList, supplyOrderDeliveryId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderByDelivery(SmartList<SupplyOrder> resultList, String supplyOrderDeliveryId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
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
 	public int countSupplyOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){

 		return countWith(SupplyOrderTable.COLUMN_DELIVERY, supplyOrderDeliveryId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderByDeliveryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderTable.COLUMN_DELIVERY, ids, options);
	}
 	
 	
		
		
		

	

	protected SupplyOrder saveSupplyOrder(SupplyOrder  supplyOrder){
		
		if(!supplyOrder.isChanged()){
			return supplyOrder;
		}
		
		
		String SQL=this.getSaveSupplyOrderSQL(supplyOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderParameters(supplyOrder);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrder.incVersion();
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
 		Object[] parameters = new Object[15];
  	
 		if(supplyOrder.getBuyer() != null){
 			parameters[0] = supplyOrder.getBuyer().getId();
 		}
  	
 		if(supplyOrder.getSeller() != null){
 			parameters[1] = supplyOrder.getSeller().getId();
 		}
 
 		parameters[2] = supplyOrder.getTitle();
 		parameters[3] = supplyOrder.getTotalAmount(); 	
 		if(supplyOrder.getConfirmation() != null){
 			parameters[4] = supplyOrder.getConfirmation().getId();
 		}
  	
 		if(supplyOrder.getApproval() != null){
 			parameters[5] = supplyOrder.getApproval().getId();
 		}
  	
 		if(supplyOrder.getProcessing() != null){
 			parameters[6] = supplyOrder.getProcessing().getId();
 		}
  	
 		if(supplyOrder.getPicking() != null){
 			parameters[7] = supplyOrder.getPicking().getId();
 		}
  	
 		if(supplyOrder.getShipment() != null){
 			parameters[8] = supplyOrder.getShipment().getId();
 		}
  	
 		if(supplyOrder.getDelivery() != null){
 			parameters[9] = supplyOrder.getDelivery().getId();
 		}
 
 		parameters[10] = supplyOrder.getLastUpdateTime();
 		parameters[11] = supplyOrder.getCurrentStatus();		
 		parameters[12] = supplyOrder.nextVersion();
 		parameters[13] = supplyOrder.getId();
 		parameters[14] = supplyOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderCreateParameters(SupplyOrder supplyOrder){
		Object[] parameters = new Object[13];
		String newSupplyOrderId=getNextId();
		supplyOrder.setId(newSupplyOrderId);
		parameters[0] =  supplyOrder.getId();
  	
 		if(supplyOrder.getBuyer() != null){
 			parameters[1] = supplyOrder.getBuyer().getId();
 		
 		}
 		 	
 		if(supplyOrder.getSeller() != null){
 			parameters[2] = supplyOrder.getSeller().getId();
 		
 		}
 		
 		parameters[3] = supplyOrder.getTitle();
 		parameters[4] = supplyOrder.getTotalAmount(); 	
 		if(supplyOrder.getConfirmation() != null){
 			parameters[5] = supplyOrder.getConfirmation().getId();
 		
 		}
 		 	
 		if(supplyOrder.getApproval() != null){
 			parameters[6] = supplyOrder.getApproval().getId();
 		
 		}
 		 	
 		if(supplyOrder.getProcessing() != null){
 			parameters[7] = supplyOrder.getProcessing().getId();
 		
 		}
 		 	
 		if(supplyOrder.getPicking() != null){
 			parameters[8] = supplyOrder.getPicking().getId();
 		
 		}
 		 	
 		if(supplyOrder.getShipment() != null){
 			parameters[9] = supplyOrder.getShipment().getId();
 		
 		}
 		 	
 		if(supplyOrder.getDelivery() != null){
 			parameters[10] = supplyOrder.getDelivery().getId();
 		
 		}
 		
 		parameters[11] = supplyOrder.getLastUpdateTime();
 		parameters[12] = supplyOrder.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrder saveInternalSupplyOrder(SupplyOrder supplyOrder, Map<String,Object> options){
		
		saveSupplyOrder(supplyOrder);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(supplyOrder, options);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(supplyOrder, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(supplyOrder, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(supplyOrder, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(supplyOrder, options);
 		}
  	
 		if(isSavePickingEnabled(options)){
	 		savePicking(supplyOrder, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(supplyOrder, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(supplyOrder, options);
 		}
 
		
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
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveConfirmation(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getConfirmation() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderConfirmationDAO().save(supplyOrder.getConfirmation(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveApproval(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getApproval() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderApprovalDAO().save(supplyOrder.getApproval(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveProcessing(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getProcessing() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderProcessingDAO().save(supplyOrder.getProcessing(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder savePicking(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getPicking() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderPickingDAO().save(supplyOrder.getPicking(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveShipment(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getShipment() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderShipmentDAO().save(supplyOrder.getShipment(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveDelivery(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getDelivery() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderDeliveryDAO().save(supplyOrder.getDelivery(),options);
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
		
		for(SupplyOrderLineItem supplyOrderLineItem: externalSupplyOrderLineItemList){

			supplyOrderLineItem.clearFromAll();
		}
		
		
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();		
		supplyOrderLineItemList.addAllToRemoveList(externalSupplyOrderLineItemList);
		return supplyOrder;	
	
	}


	//disconnect SupplyOrder with sku_id in SupplyOrderLineItem
	public SupplyOrder planToRemoveSupplyOrderLineItemListWithSkuId(SupplyOrder supplyOrder, String skuIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, supplyOrder.getId());
		key.put(SupplyOrderLineItem.SKU_ID_PROPERTY, skuIdId);
		
		SmartList<SupplyOrderLineItem> externalSupplyOrderLineItemList = getSupplyOrderLineItemDAO().
				findSupplyOrderLineItemWithKey(key, options);
		if(externalSupplyOrderLineItemList == null){
			return supplyOrder;
		}
		if(externalSupplyOrderLineItemList.isEmpty()){
			return supplyOrder;
		}
		
		for(SupplyOrderLineItem supplyOrderLineItem: externalSupplyOrderLineItemList){
			supplyOrderLineItem.clearSkuId();
			supplyOrderLineItem.clearBizOrder();
			
		}
		
		
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();		
		supplyOrderLineItemList.addAllToRemoveList(externalSupplyOrderLineItemList);
		return supplyOrder;
	}
	
	public int countSupplyOrderLineItemListWithSkuId(String supplyOrderId, String skuIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, supplyOrderId);
		key.put(SupplyOrderLineItem.SKU_ID_PROPERTY, skuIdId);
		
		int count = getSupplyOrderLineItemDAO().countSupplyOrderLineItemWithKey(key, options);
		return count;
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
		
		for(SupplyOrderShippingGroup supplyOrderShippingGroup: externalSupplyOrderShippingGroupList){

			supplyOrderShippingGroup.clearFromAll();
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
		
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup: externalSupplyOrderPaymentGroupList){

			supplyOrderPaymentGroup.clearFromAll();
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
		
		for(Goods goods: externalGoodsList){

			goods.clearFromAll();
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
		
		for(Goods goods: externalGoodsList){
			goods.clearSku();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearReceivingSpace();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearGoodsAllocation();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearSmartPallet();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearShippingSpace();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearTransportTask();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearRetailStore();
			goods.clearBizOrder();
			
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
		
		for(Goods goods: externalGoodsList){
			goods.clearRetailStoreOrder();
			goods.clearBizOrder();
			
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
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		
    public SmartList<SupplyOrder> requestCandidateSupplyOrderForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderTable.COLUMN_BUYER, filterKey, pageNo, pageSize, getSupplyOrderMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrder> supplyOrderList) {		
		this.enhanceListInternal(supplyOrderList, this.getSupplyOrderMapper());
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
}


