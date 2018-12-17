
package com.doublechaintech.retailscm.retailstoreorderconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderConfirmationDAO{

	
	public RetailStoreOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderConfirmation present(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options) throws Exception;
	public RetailStoreOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderConfirmation save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> saveRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> removeRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> findRetailStoreOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderConfirmationId, int version) throws Exception;
	public RetailStoreOrderConfirmation disconnectFromAll(String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderConfirmation> requestCandidateRetailStoreOrderConfirmationForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderConfirmation with buyer in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderConfirmationId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with seller in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderConfirmationId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderConfirmation> queryList(String sql, Object ... parmeters);
}


