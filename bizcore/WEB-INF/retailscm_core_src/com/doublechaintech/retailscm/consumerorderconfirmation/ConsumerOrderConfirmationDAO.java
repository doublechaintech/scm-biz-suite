
package com.doublechaintech.retailscm.consumerorderconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


public interface ConsumerOrderConfirmationDAO{

	
	public ConsumerOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderConfirmation> consumerOrderConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderConfirmation present(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options) throws Exception;
	public ConsumerOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderConfirmation save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> saveConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> removeConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> findConsumerOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderConfirmationId, int version) throws Exception;
	public ConsumerOrderConfirmation disconnectFromAll(String consumerOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderConfirmation> queryList(String sql, Object ... parmeters);
}


