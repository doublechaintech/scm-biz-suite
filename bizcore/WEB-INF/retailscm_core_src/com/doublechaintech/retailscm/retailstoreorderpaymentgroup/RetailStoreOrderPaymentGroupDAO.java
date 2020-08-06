
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;
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

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderPaymentGroupDAO extends BaseDAO{

	public SmartList<RetailStoreOrderPaymentGroup> loadAll();
	public Stream<RetailStoreOrderPaymentGroup> loadAllAsStream();
	public RetailStoreOrderPaymentGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStoreOrderPaymentGroup present(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options) throws Exception;
	public RetailStoreOrderPaymentGroup clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStoreOrderPaymentGroup save(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options);
	public SmartList<RetailStoreOrderPaymentGroup> saveRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPaymentGroup> removeRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderPaymentGroupId, int version) throws Exception;
	public RetailStoreOrderPaymentGroup disconnectFromAll(String retailStoreOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	

	public SmartList<RetailStoreOrderPaymentGroup> queryList(String sql, Object ... parmeters);
	public Stream<RetailStoreOrderPaymentGroup> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderPaymentGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderPaymentGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderPaymentGroupByBizOrder(SmartList<RetailStoreOrderPaymentGroup> resultList, String retailStoreOrderId, Map<String,Object> options);


 
}


