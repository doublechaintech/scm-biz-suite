
package com.doublechaintech.retailscm.supplyorderdelivery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderDeliveryDAO{

	
	public SupplyOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderDelivery> supplyOrderDeliveryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderDelivery present(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options) throws Exception;
	public SupplyOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderDelivery save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> saveSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> removeSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> findSupplyOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderDeliveryId, int version) throws Exception;
	public SupplyOrderDelivery disconnectFromAll(String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderDelivery planToRemoveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderDelivery with consumer in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithConsumer(SupplyOrderDelivery supplyOrderDelivery, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderDeliveryId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with store in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithStore(SupplyOrderDelivery supplyOrderDelivery, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderDeliveryId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderDelivery planToRemoveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderDelivery with buyer in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithBuyer(SupplyOrderDelivery supplyOrderDelivery, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderDeliveryId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with seller in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithSeller(SupplyOrderDelivery supplyOrderDelivery, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderDeliveryId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderDelivery> queryList(String sql, Object ... parmeters);
}


