
package com.doublechaintech.retailscm.consumerorderpriceadjustment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;


public interface ConsumerOrderPriceAdjustmentDAO{

	
	public ConsumerOrderPriceAdjustment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderPriceAdjustment present(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options) throws Exception;
	public ConsumerOrderPriceAdjustment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderPriceAdjustment save(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options);
	public SmartList<ConsumerOrderPriceAdjustment> saveConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderPriceAdjustment> removeConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderPriceAdjustmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderPriceAdjustmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderPriceAdjustmentId, int version) throws Exception;
	public ConsumerOrderPriceAdjustment disconnectFromAll(String consumerOrderPriceAdjustmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderPriceAdjustment> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderPriceAdjustmentByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderPriceAdjustmentByBizOrder(SmartList<ConsumerOrderPriceAdjustment> resultList, String consumerOrderId, Map<String,Object> options);

 
 }


