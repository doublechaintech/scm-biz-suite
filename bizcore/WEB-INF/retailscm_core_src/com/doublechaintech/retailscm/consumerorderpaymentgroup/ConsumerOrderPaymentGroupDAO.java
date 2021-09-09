
package com.doublechaintech.retailscm.consumerorderpaymentgroup;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;


public interface ConsumerOrderPaymentGroupDAO extends BaseDAO{

	public SmartList<ConsumerOrderPaymentGroup> loadAll();
	public Stream<ConsumerOrderPaymentGroup> loadAllAsStream();
	public ConsumerOrderPaymentGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public ConsumerOrderPaymentGroup present(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options) throws Exception;
	public ConsumerOrderPaymentGroup clone(String id, Map<String,Object> options) throws Exception;

	

	public ConsumerOrderPaymentGroup save(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options);
	public SmartList<ConsumerOrderPaymentGroup> saveConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<ConsumerOrderPaymentGroup> removeConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderPaymentGroupId, int version) throws Exception;
	public ConsumerOrderPaymentGroup disconnectFromAll(String consumerOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<ConsumerOrderPaymentGroup> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<ConsumerOrderPaymentGroup> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateConsumerOrderPaymentGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderPaymentGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderPaymentGroupByBizOrder(SmartList<ConsumerOrderPaymentGroup> resultList, String consumerOrderId, Map<String,Object> options);


 

	List<ConsumerOrderPaymentGroup> search(ConsumerOrderPaymentGroupRequest pRequest);
}


