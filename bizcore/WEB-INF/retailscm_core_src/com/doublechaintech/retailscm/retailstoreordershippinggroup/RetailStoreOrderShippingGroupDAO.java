
package com.doublechaintech.retailscm.retailstoreordershippinggroup;
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


public interface RetailStoreOrderShippingGroupDAO extends BaseDAO{

	public SmartList<RetailStoreOrderShippingGroup> loadAll();
	public Stream<RetailStoreOrderShippingGroup> loadAllAsStream();
	public RetailStoreOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStoreOrderShippingGroup present(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options) throws Exception;
	public RetailStoreOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStoreOrderShippingGroup save(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> saveRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> removeRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderShippingGroupId, int version) throws Exception;
	public RetailStoreOrderShippingGroup disconnectFromAll(String retailStoreOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<RetailStoreOrderShippingGroup> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<RetailStoreOrderShippingGroup> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateRetailStoreOrderShippingGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderShippingGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderShippingGroupByBizOrder(SmartList<RetailStoreOrderShippingGroup> resultList, String retailStoreOrderId, Map<String,Object> options);


 

	List<RetailStoreOrderShippingGroup> search(RetailStoreOrderShippingGroupRequest pRequest);
}


