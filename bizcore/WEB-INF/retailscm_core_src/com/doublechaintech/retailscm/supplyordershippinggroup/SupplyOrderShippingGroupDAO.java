package com.doublechaintech.retailscm.supplyordershippinggroup;

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

public interface SupplyOrderShippingGroupDAO extends BaseDAO {

  public SmartList<SupplyOrderShippingGroup> loadAll();

  public Stream<SupplyOrderShippingGroup> loadAllAsStream();

  public SupplyOrderShippingGroup load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public SupplyOrderShippingGroup present(
      SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> options)
      throws Exception;

  public SupplyOrderShippingGroup clone(String id, Map<String, Object> options) throws Exception;

  public SupplyOrderShippingGroup save(
      SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> options);

  public SmartList<SupplyOrderShippingGroup> saveSupplyOrderShippingGroupList(
      SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,
      Map<String, Object> options);

  public SmartList<SupplyOrderShippingGroup> removeSupplyOrderShippingGroupList(
      SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,
      Map<String, Object> options);

  public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countSupplyOrderShippingGroupWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countSupplyOrderShippingGroupWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public SupplyOrderShippingGroup disconnectFromAll(String supplyOrderShippingGroupId, int version)
      throws Exception;

  public void resetNextId();

  public SmartList<SupplyOrderShippingGroup> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<SupplyOrderShippingGroup> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateSupplyOrderShippingGroup executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(
      String supplyOrderId, Map<String, Object> options);

  public int countSupplyOrderShippingGroupByBizOrder(
      String supplyOrderId, Map<String, Object> options);

  public Map<String, Integer> countSupplyOrderShippingGroupByBizOrderIds(
      String[] ids, Map<String, Object> options);

  public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(
      String supplyOrderId, int start, int count, Map<String, Object> options);

  public void analyzeSupplyOrderShippingGroupByBizOrder(
      SmartList<SupplyOrderShippingGroup> resultList,
      String supplyOrderId,
      Map<String, Object> options);

  List<SupplyOrderShippingGroup> search(SupplyOrderShippingGroupRequest pRequest);
}
