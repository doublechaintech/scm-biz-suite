
package com.doublechaintech.retailscm.retailstoreorderpicking;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderPickingDAO{

	
	public RetailStoreOrderPicking load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderPicking> retailStoreOrderPickingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderPicking present(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options) throws Exception;
	public RetailStoreOrderPicking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderPicking save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> saveRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> removeRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> findRetailStoreOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderPickingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderPickingId, int version) throws Exception;
	public RetailStoreOrderPicking disconnectFromAll(String retailStoreOrderPickingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderPicking> requestCandidateRetailStoreOrderPickingForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderPicking with buyer in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderPicking retailStoreOrderPicking, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderPickingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with seller in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderPicking retailStoreOrderPicking, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderPickingId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderPicking> queryList(String sql, Object ... parmeters);
}


