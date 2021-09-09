
package com.doublechaintech.retailscm.supplyorderpaymentgroup;
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

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderPaymentGroupDAO extends BaseDAO{

	public SmartList<SupplyOrderPaymentGroup> loadAll();
	public Stream<SupplyOrderPaymentGroup> loadAllAsStream();
	public SupplyOrderPaymentGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public SupplyOrderPaymentGroup present(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options) throws Exception;
	public SupplyOrderPaymentGroup clone(String id, Map<String,Object> options) throws Exception;

	

	public SupplyOrderPaymentGroup save(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options);
	public SmartList<SupplyOrderPaymentGroup> saveSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<SupplyOrderPaymentGroup> removeSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderPaymentGroupId, int version) throws Exception;
	public SupplyOrderPaymentGroup disconnectFromAll(String supplyOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<SupplyOrderPaymentGroup> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<SupplyOrderPaymentGroup> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateSupplyOrderPaymentGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public Map<String, Integer> countSupplyOrderPaymentGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplyOrderPaymentGroupByBizOrder(SmartList<SupplyOrderPaymentGroup> resultList, String supplyOrderId, Map<String,Object> options);


 

	List<SupplyOrderPaymentGroup> search(SupplyOrderPaymentGroupRequest pRequest);
}


