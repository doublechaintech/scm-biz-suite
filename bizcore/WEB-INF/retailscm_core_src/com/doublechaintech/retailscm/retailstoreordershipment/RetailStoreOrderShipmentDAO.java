
package com.doublechaintech.retailscm.retailstoreordershipment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderShipmentDAO{

	
	public RetailStoreOrderShipment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderShipment> retailStoreOrderShipmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderShipment present(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options) throws Exception;
	public RetailStoreOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderShipment save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> saveRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> removeRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> findRetailStoreOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderShipmentId, int version) throws Exception;
	public RetailStoreOrderShipment disconnectFromAll(String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderShipment> requestCandidateRetailStoreOrderShipmentForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderShipment with buyer in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderShipment retailStoreOrderShipment, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderShipmentId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with seller in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderShipment retailStoreOrderShipment, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderShipmentId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderShipment> queryList(String sql, Object ... parmeters);
}


