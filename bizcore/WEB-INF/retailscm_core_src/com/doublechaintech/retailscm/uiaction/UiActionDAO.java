package com.doublechaintech.retailscm.uiaction;

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

import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;

public interface UiActionDAO extends BaseDAO {

  public SmartList<UiAction> loadAll();

  public Stream<UiAction> loadAllAsStream();

  public UiAction load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<UiAction> uiActionList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public UiAction present(UiAction uiAction, Map<String, Object> options) throws Exception;

  public UiAction clone(String id, Map<String, Object> options) throws Exception;

  public UiAction save(UiAction uiAction, Map<String, Object> options);

  public SmartList<UiAction> saveUiActionList(
      SmartList<UiAction> uiActionList, Map<String, Object> options);

  public SmartList<UiAction> removeUiActionList(
      SmartList<UiAction> uiActionList, Map<String, Object> options);

  public SmartList<UiAction> findUiActionWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countUiActionWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countUiActionWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public UiAction disconnectFromAll(String uiActionId, int version) throws Exception;

  public void resetNextId();

  public SmartList<UiAction> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<UiAction> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateUiAction executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<UiAction> findUiActionByPage(String pageId, Map<String, Object> options);

  public int countUiActionByPage(String pageId, Map<String, Object> options);

  public Map<String, Integer> countUiActionByPageIds(String[] ids, Map<String, Object> options);

  public SmartList<UiAction> findUiActionByPage(
      String pageId, int start, int count, Map<String, Object> options);

  public void analyzeUiActionByPage(
      SmartList<UiAction> resultList, String pageId, Map<String, Object> options);

  List<UiAction> search(UiActionRequest pRequest);
}
