
package com.doublechaintech.retailscm.supplyorderapproval;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderApprovalDAO{

	
	public SupplyOrderApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderApproval> supplyOrderApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderApproval present(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options) throws Exception;
	public SupplyOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderApproval save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> saveSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> removeSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> findSupplyOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderApprovalId, int version) throws Exception;
	public SupplyOrderApproval disconnectFromAll(String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderApproval> requestCandidateSupplyOrderApprovalForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderApproval> requestCandidateSupplyOrderApprovalForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderApproval planToRemoveConsumerOrderList(SupplyOrderApproval supplyOrderApproval, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderApproval with consumer in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithConsumer(SupplyOrderApproval supplyOrderApproval, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderApprovalId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with store in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithStore(SupplyOrderApproval supplyOrderApproval, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderApprovalId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderApproval planToRemoveSupplyOrderList(SupplyOrderApproval supplyOrderApproval, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderApproval with buyer in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithBuyer(SupplyOrderApproval supplyOrderApproval, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderApprovalId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with seller in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithSeller(SupplyOrderApproval supplyOrderApproval, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderApprovalId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderApproval> queryList(String sql, Object ... parmeters);
}


