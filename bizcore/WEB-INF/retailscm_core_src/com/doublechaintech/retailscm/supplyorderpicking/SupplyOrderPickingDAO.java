
package com.doublechaintech.retailscm.supplyorderpicking;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderPickingDAO{

	
	public SupplyOrderPicking load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderPicking> supplyOrderPickingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderPicking present(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options) throws Exception;
	public SupplyOrderPicking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderPicking save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> saveSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> removeSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> findSupplyOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderPickingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderPickingId, int version) throws Exception;
	public SupplyOrderPicking disconnectFromAll(String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderPicking> requestCandidateSupplyOrderPickingForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderPicking planToRemoveSupplyOrderList(SupplyOrderPicking supplyOrderPicking, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderPicking with buyer in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithBuyer(SupplyOrderPicking supplyOrderPicking, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderPickingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with seller in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithSeller(SupplyOrderPicking supplyOrderPicking, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderPickingId, String sellerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderPicking> queryList(String sql, Object ... parmeters);
}


