
package com.doublechaintech.retailscm.supplyorderprocessing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderProcessingDAO{

	
	public SupplyOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderProcessing> supplyOrderProcessingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderProcessing present(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options) throws Exception;
	public SupplyOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderProcessing save(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options);
	public SmartList<SupplyOrderProcessing> saveSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options);
	public SmartList<SupplyOrderProcessing> removeSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options);
	public SmartList<SupplyOrderProcessing> findSupplyOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderProcessingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderProcessingId, int version) throws Exception;
	public SupplyOrderProcessing disconnectFromAll(String supplyOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderProcessing> requestCandidateSupplyOrderProcessingForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderProcessing> requestCandidateSupplyOrderProcessingForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderProcessing planToRemoveConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderProcessing with consumer in ConsumerOrder
	public SupplyOrderProcessing planToRemoveConsumerOrderListWithConsumer(SupplyOrderProcessing supplyOrderProcessing, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderProcessingId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderProcessing with store in ConsumerOrder
	public SupplyOrderProcessing planToRemoveConsumerOrderListWithStore(SupplyOrderProcessing supplyOrderProcessing, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderProcessingId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderProcessing planToRemoveSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderProcessing with buyer in SupplyOrder
	public SupplyOrderProcessing planToRemoveSupplyOrderListWithBuyer(SupplyOrderProcessing supplyOrderProcessing, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderProcessingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderProcessing with seller in SupplyOrder
	public SupplyOrderProcessing planToRemoveSupplyOrderListWithSeller(SupplyOrderProcessing supplyOrderProcessing, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderProcessingId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderProcessing> queryList(String sql, Object ... parmeters);
}


