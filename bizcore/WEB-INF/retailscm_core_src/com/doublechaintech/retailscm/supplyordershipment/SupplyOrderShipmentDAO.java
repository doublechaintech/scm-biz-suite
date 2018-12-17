
package com.doublechaintech.retailscm.supplyordershipment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderShipmentDAO{

	
	public SupplyOrderShipment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderShipment> supplyOrderShipmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderShipment present(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options) throws Exception;
	public SupplyOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderShipment save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> saveSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> removeSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> findSupplyOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderShipmentId, int version) throws Exception;
	public SupplyOrderShipment disconnectFromAll(String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderShipment> requestCandidateSupplyOrderShipmentForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderShipment> requestCandidateSupplyOrderShipmentForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderShipment planToRemoveConsumerOrderList(SupplyOrderShipment supplyOrderShipment, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderShipment with consumer in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithConsumer(SupplyOrderShipment supplyOrderShipment, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderShipmentId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with store in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithStore(SupplyOrderShipment supplyOrderShipment, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderShipmentId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderShipment planToRemoveSupplyOrderList(SupplyOrderShipment supplyOrderShipment, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderShipment with buyer in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithBuyer(SupplyOrderShipment supplyOrderShipment, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderShipmentId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with seller in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithSeller(SupplyOrderShipment supplyOrderShipment, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderShipmentId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderShipment> queryList(String sql, Object ... parmeters);
}


