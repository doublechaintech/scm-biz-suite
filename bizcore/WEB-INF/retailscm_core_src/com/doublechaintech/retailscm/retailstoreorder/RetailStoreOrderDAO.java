
package com.doublechaintech.retailscm.retailstoreorder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
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


public interface RetailStoreOrderDAO{

	
	public RetailStoreOrder load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrder> retailStoreOrderList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrder present(RetailStoreOrder retailStoreOrder,Map<String,Object> options) throws Exception;
	public RetailStoreOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrder save(RetailStoreOrder retailStoreOrder,Map<String,Object> options);
	public SmartList<RetailStoreOrder> saveRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options);
	public SmartList<RetailStoreOrder> removeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options);
	public SmartList<RetailStoreOrder> findRetailStoreOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderId, int version) throws Exception;
	public RetailStoreOrder disconnectFromAll(String retailStoreOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO();
		
	public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO();
		
	public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO();
		
	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderLineItem(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrder planToRemoveRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, String retailStoreOrderLineItemIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrder with sku_id in RetailStoreOrderLineItem
	public RetailStoreOrder planToRemoveRetailStoreOrderLineItemListWithSkuId(RetailStoreOrder retailStoreOrder, String skuIdId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderLineItemListWithSkuId(String retailStoreOrderId, String skuIdId, Map<String,Object> options)throws Exception;
	
	public RetailStoreOrder planToRemoveRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, String retailStoreOrderShippingGroupIds[], Map<String,Object> options)throws Exception;


	public RetailStoreOrder planToRemoveRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, String retailStoreOrderPaymentGroupIds[], Map<String,Object> options)throws Exception;


	public RetailStoreOrder planToRemoveGoodsList(RetailStoreOrder retailStoreOrder, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrder with sku in Goods
	public RetailStoreOrder planToRemoveGoodsListWithSku(RetailStoreOrder retailStoreOrder, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String retailStoreOrderId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with receiving_space in Goods
	public RetailStoreOrder planToRemoveGoodsListWithReceivingSpace(RetailStoreOrder retailStoreOrder, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String retailStoreOrderId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with goods_allocation in Goods
	public RetailStoreOrder planToRemoveGoodsListWithGoodsAllocation(RetailStoreOrder retailStoreOrder, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String retailStoreOrderId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with smart_pallet in Goods
	public RetailStoreOrder planToRemoveGoodsListWithSmartPallet(RetailStoreOrder retailStoreOrder, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String retailStoreOrderId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with shipping_space in Goods
	public RetailStoreOrder planToRemoveGoodsListWithShippingSpace(RetailStoreOrder retailStoreOrder, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String retailStoreOrderId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with transport_task in Goods
	public RetailStoreOrder planToRemoveGoodsListWithTransportTask(RetailStoreOrder retailStoreOrder, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String retailStoreOrderId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with retail_store in Goods
	public RetailStoreOrder planToRemoveGoodsListWithRetailStore(RetailStoreOrder retailStoreOrder, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String retailStoreOrderId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrder with biz_order in Goods
	public RetailStoreOrder planToRemoveGoodsListWithBizOrder(RetailStoreOrder retailStoreOrder, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String retailStoreOrderId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrder> queryList(String sql, Object ... parmeters);
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, Map<String,Object> options);
 	public int countRetailStoreOrderByBuyer(String retailStoreId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByBuyerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByBuyer(SmartList<RetailStoreOrder> resultList, String retailStoreId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreOrderBySeller(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderBySellerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderBySeller(SmartList<RetailStoreOrder> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, Map<String,Object> options);
 	public int countRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByConfirmationIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByConfirmation(SmartList<RetailStoreOrder> resultList, String retailStoreOrderConfirmationId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId, Map<String,Object> options);
 	public int countRetailStoreOrderByApproval(String retailStoreOrderApprovalId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByApprovalIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByApproval(SmartList<RetailStoreOrder> resultList, String retailStoreOrderApprovalId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, Map<String,Object> options);
 	public int countRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByProcessingIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByProcessing(SmartList<RetailStoreOrder> resultList, String retailStoreOrderProcessingId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId, Map<String,Object> options);
 	public int countRetailStoreOrderByPicking(String retailStoreOrderPickingId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByPickingIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByPicking(SmartList<RetailStoreOrder> resultList, String retailStoreOrderPickingId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId, Map<String,Object> options);
 	public int countRetailStoreOrderByShipment(String retailStoreOrderShipmentId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByShipmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByShipment(SmartList<RetailStoreOrder> resultList, String retailStoreOrderShipmentId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, Map<String,Object> options);
 	public int countRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderByDeliveryIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderByDelivery(SmartList<RetailStoreOrder> resultList, String retailStoreOrderDeliveryId, Map<String,Object> options);

 
 }


