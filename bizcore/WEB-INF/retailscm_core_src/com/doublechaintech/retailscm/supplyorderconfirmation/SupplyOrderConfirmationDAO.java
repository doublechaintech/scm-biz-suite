
package com.doublechaintech.retailscm.supplyorderconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderConfirmationDAO{

	
	public SupplyOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderConfirmation> supplyOrderConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderConfirmation present(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options) throws Exception;
	public SupplyOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderConfirmation save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> saveSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> removeSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> findSupplyOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderConfirmationId, int version) throws Exception;
	public SupplyOrderConfirmation disconnectFromAll(String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderConfirmation> requestCandidateSupplyOrderConfirmationForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderConfirmation> requestCandidateSupplyOrderConfirmationForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderConfirmation planToRemoveConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderConfirmation with consumer in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithConsumer(SupplyOrderConfirmation supplyOrderConfirmation, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderConfirmationId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with store in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithStore(SupplyOrderConfirmation supplyOrderConfirmation, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderConfirmationId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderConfirmation planToRemoveSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderConfirmation with buyer in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithBuyer(SupplyOrderConfirmation supplyOrderConfirmation, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderConfirmationId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with seller in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithSeller(SupplyOrderConfirmation supplyOrderConfirmation, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderConfirmationId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderConfirmation> queryList(String sql, Object ... parmeters);
}


