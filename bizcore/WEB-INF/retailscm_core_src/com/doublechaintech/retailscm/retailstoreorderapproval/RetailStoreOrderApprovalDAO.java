
package com.doublechaintech.retailscm.retailstoreorderapproval;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderApprovalDAO{

	
	public RetailStoreOrderApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderApproval> retailStoreOrderApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderApproval present(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options) throws Exception;
	public RetailStoreOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderApproval save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> saveRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> removeRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> findRetailStoreOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderApprovalId, int version) throws Exception;
	public RetailStoreOrderApproval disconnectFromAll(String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderApproval> requestCandidateRetailStoreOrderApprovalForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderApproval with buyer in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderApproval retailStoreOrderApproval, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderApprovalId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with seller in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderApproval retailStoreOrderApproval, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderApprovalId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderApproval> queryList(String sql, Object ... parmeters);
}


