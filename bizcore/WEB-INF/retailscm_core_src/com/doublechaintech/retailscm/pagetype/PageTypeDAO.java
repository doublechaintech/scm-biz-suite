package com.doublechaintech.retailscm.pagetype;

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

import com.doublechaintech.retailscm.mobileapp.MobileApp;

import com.doublechaintech.retailscm.mobileapp.MobileAppDAO;

public interface PageTypeDAO extends BaseDAO {

  public SmartList<PageType> loadAll();

  public Stream<PageType> loadAllAsStream();

  public PageType load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<PageType> pageTypeList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public PageType loadByCode(String code, Map<String, Object> options) throws Exception;

  public PageType present(PageType pageType, Map<String, Object> options) throws Exception;

  public PageType clone(String id, Map<String, Object> options) throws Exception;

  public PageType cloneByCode(String code, Map<String, Object> options) throws Exception;

  public PageType save(PageType pageType, Map<String, Object> options);

  public SmartList<PageType> savePageTypeList(
      SmartList<PageType> pageTypeList, Map<String, Object> options);

  public SmartList<PageType> removePageTypeList(
      SmartList<PageType> pageTypeList, Map<String, Object> options);

  public SmartList<PageType> findPageTypeWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countPageTypeWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countPageTypeWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public PageType disconnectFromAll(String pageTypeId, int version) throws Exception;

  public void resetNextId();

  public SmartList<PageType> requestCandidatePageTypeForPage(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<PageType> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<PageType> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidatePageType executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<PageType> findPageTypeByMobileApp(
      String mobileAppId, Map<String, Object> options);

  public int countPageTypeByMobileApp(String mobileAppId, Map<String, Object> options);

  public Map<String, Integer> countPageTypeByMobileAppIds(
      String[] ids, Map<String, Object> options);

  public SmartList<PageType> findPageTypeByMobileApp(
      String mobileAppId, int start, int count, Map<String, Object> options);

  public void analyzePageTypeByMobileApp(
      SmartList<PageType> resultList, String mobileAppId, Map<String, Object> options);

  List<PageType> search(PageTypeRequest pRequest);
}
