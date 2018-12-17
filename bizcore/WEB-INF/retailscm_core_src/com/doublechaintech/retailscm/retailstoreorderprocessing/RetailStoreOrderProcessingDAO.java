
package com.doublechaintech.retailscm.retailstoreorderprocessing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderProcessingDAO{

	
	public RetailStoreOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderProcessing present(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options) throws Exception;
	public RetailStoreOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderProcessing save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> saveRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> removeRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> findRetailStoreOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderProcessingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderProcessingId, int version) throws Exception;
	public RetailStoreOrderProcessing disconnectFromAll(String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderProcessing> requestCandidateRetailStoreOrderProcessingForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderProcessing with buyer in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderProcessing retailStoreOrderProcessing, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderProcessingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with seller in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderProcessing retailStoreOrderProcessing, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderProcessingId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderProcessing> queryList(String sql, Object ... parmeters);
}


