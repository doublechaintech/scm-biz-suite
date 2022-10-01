package com.doublechaintech.retailscm.view;

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

public interface ViewDAO extends BaseDAO {

  public SmartList<View> loadAll();

  public Stream<View> loadAllAsStream();

  public View load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<View> viewList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public View present(View view, Map<String, Object> options) throws Exception;

  public View clone(String id, Map<String, Object> options) throws Exception;

  public View save(View view, Map<String, Object> options);

  public SmartList<View> saveViewList(SmartList<View> viewList, Map<String, Object> options);

  public SmartList<View> removeViewList(SmartList<View> viewList, Map<String, Object> options);

  public SmartList<View> findViewWithKey(MultipleAccessKey key, Map<String, Object> options);

  public int countViewWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countViewWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public View disconnectFromAll(String viewId, int version) throws Exception;

  public void resetNextId();

  public SmartList<View> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<View> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateView executeCandidatesQuery(CandidateQuery query, String sql, Object... parmeters)
      throws Exception;

  List<View> search(ViewRequest pRequest);
}
