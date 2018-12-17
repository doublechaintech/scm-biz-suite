
package com.doublechaintech.retailscm.consumerordershippinggroup;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;


public interface ConsumerOrderShippingGroupDAO{

	
	public ConsumerOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderShippingGroup present(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options) throws Exception;
	public ConsumerOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderShippingGroup save(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options);
	public SmartList<ConsumerOrderShippingGroup> saveConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options);
	public SmartList<ConsumerOrderShippingGroup> removeConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options);
	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderShippingGroupId, int version) throws Exception;
	public ConsumerOrderShippingGroup disconnectFromAll(String consumerOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderShippingGroup> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderShippingGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderShippingGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderShippingGroupByBizOrder(SmartList<ConsumerOrderShippingGroup> resultList, String consumerOrderId, Map<String,Object> options);

 
 }


