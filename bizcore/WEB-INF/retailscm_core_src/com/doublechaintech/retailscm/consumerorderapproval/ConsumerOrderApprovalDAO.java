
package com.doublechaintech.retailscm.consumerorderapproval;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


public interface ConsumerOrderApprovalDAO{

	
	public ConsumerOrderApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderApproval> consumerOrderApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderApproval present(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options) throws Exception;
	public ConsumerOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderApproval save(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> saveConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> removeConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> findConsumerOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderApprovalId, int version) throws Exception;
	public ConsumerOrderApproval disconnectFromAll(String consumerOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderApproval> queryList(String sql, Object ... parmeters);
}


