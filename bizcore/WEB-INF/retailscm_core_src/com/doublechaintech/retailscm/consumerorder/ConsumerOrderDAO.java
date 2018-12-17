
package com.doublechaintech.retailscm.consumerorder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
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


public interface ConsumerOrderDAO{

	
	public ConsumerOrder load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrder> consumerOrderList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrder present(ConsumerOrder consumerOrder,Map<String,Object> options) throws Exception;
	public ConsumerOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrder save(ConsumerOrder consumerOrder,Map<String,Object> options);
	public SmartList<ConsumerOrder> saveConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options);
	public SmartList<ConsumerOrder> removeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options);
	public SmartList<ConsumerOrder> findConsumerOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderId, int version) throws Exception;
	public ConsumerOrder disconnectFromAll(String consumerOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO();
		
	public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO();
		
	public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO();
		
	public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO();
		
	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO();
		
	
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderLineItem(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ConsumerOrder planToRemoveConsumerOrderLineItemList(ConsumerOrder consumerOrder, String consumerOrderLineItemIds[], Map<String,Object> options)throws Exception;


	//disconnect ConsumerOrder with sku_id in ConsumerOrderLineItem
	public ConsumerOrder planToRemoveConsumerOrderLineItemListWithSkuId(ConsumerOrder consumerOrder, String skuIdId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderLineItemListWithSkuId(String consumerOrderId, String skuIdId, Map<String,Object> options)throws Exception;
	
	public ConsumerOrder planToRemoveConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, String consumerOrderShippingGroupIds[], Map<String,Object> options)throws Exception;


	public ConsumerOrder planToRemoveConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, String consumerOrderPaymentGroupIds[], Map<String,Object> options)throws Exception;


	public ConsumerOrder planToRemoveConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, String consumerOrderPriceAdjustmentIds[], Map<String,Object> options)throws Exception;


	public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, String retailStoreMemberGiftCardConsumeRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect ConsumerOrder with owner in RetailStoreMemberGiftCardConsumeRecord
	public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithOwner(ConsumerOrder consumerOrder, String ownerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreMemberGiftCardConsumeRecordListWithOwner(String consumerOrderId, String ownerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ConsumerOrder> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, Map<String,Object> options);
 	public int countConsumerOrderByConsumer(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByConsumerIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByConsumer(SmartList<ConsumerOrder> resultList, String retailStoreMemberId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public int countConsumerOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByConfirmationIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByConfirmation(SmartList<ConsumerOrder> resultList, String supplyOrderConfirmationId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public int countConsumerOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByApprovalIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByApproval(SmartList<ConsumerOrder> resultList, String supplyOrderApprovalId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public int countConsumerOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByProcessingIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByProcessing(SmartList<ConsumerOrder> resultList, String supplyOrderProcessingId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public int countConsumerOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByShipmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByShipment(SmartList<ConsumerOrder> resultList, String supplyOrderShipmentId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public int countConsumerOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByDeliveryIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByDelivery(SmartList<ConsumerOrder> resultList, String supplyOrderDeliveryId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, Map<String,Object> options);
 	public int countConsumerOrderByStore(String retailStoreId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByStoreIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByStore(SmartList<ConsumerOrder> resultList, String retailStoreId, Map<String,Object> options);

 
 }


