
package com.doublechaintech.retailscm.consumerorderdelivery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


public interface ConsumerOrderDeliveryDAO{

	
	public ConsumerOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderDelivery> consumerOrderDeliveryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderDelivery present(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options) throws Exception;
	public ConsumerOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderDelivery save(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> saveConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> removeConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> findConsumerOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderDeliveryId, int version) throws Exception;
	public ConsumerOrderDelivery disconnectFromAll(String consumerOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderDelivery> queryList(String sql, Object ... parmeters);
}


