
package com.doublechaintech.retailscm.supplyordershippinggroup;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderShippingGroupDAO{

	
	public SupplyOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderShippingGroup present(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options) throws Exception;
	public SupplyOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderShippingGroup save(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options);
	public SmartList<SupplyOrderShippingGroup> saveSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options);
	public SmartList<SupplyOrderShippingGroup> removeSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options);
	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderShippingGroupId, int version) throws Exception;
	public SupplyOrderShippingGroup disconnectFromAll(String supplyOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<SupplyOrderShippingGroup> queryList(String sql, Object ... parmeters);
 
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countSupplyOrderShippingGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public Map<String, Integer> countSupplyOrderShippingGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplyOrderShippingGroupByBizOrder(SmartList<SupplyOrderShippingGroup> resultList, String supplyOrderId, Map<String,Object> options);

 
 }


