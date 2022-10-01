package com.doublechaintech.retailscm.leveltwodepartment;

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

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentDAO;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;

public interface LevelTwoDepartmentDAO extends BaseDAO {

  public SmartList<LevelTwoDepartment> loadAll();

  public Stream<LevelTwoDepartment> loadAllAsStream();

  public LevelTwoDepartment load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<LevelTwoDepartment> levelTwoDepartmentList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public LevelTwoDepartment present(
      LevelTwoDepartment levelTwoDepartment, Map<String, Object> options) throws Exception;

  public LevelTwoDepartment clone(String id, Map<String, Object> options) throws Exception;

  public LevelTwoDepartment save(
      LevelTwoDepartment levelTwoDepartment, Map<String, Object> options);

  public SmartList<LevelTwoDepartment> saveLevelTwoDepartmentList(
      SmartList<LevelTwoDepartment> levelTwoDepartmentList, Map<String, Object> options);

  public SmartList<LevelTwoDepartment> removeLevelTwoDepartmentList(
      SmartList<LevelTwoDepartment> levelTwoDepartmentList, Map<String, Object> options);

  public SmartList<LevelTwoDepartment> findLevelTwoDepartmentWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countLevelTwoDepartmentWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countLevelTwoDepartmentWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public LevelTwoDepartment disconnectFromAll(String levelTwoDepartmentId, int version)
      throws Exception;

  public void resetNextId();

  public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO();

  public SmartList<LevelTwoDepartment> requestCandidateLevelTwoDepartmentForLevelThreeDepartment(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public LevelTwoDepartment planToRemoveLevelThreeDepartmentList(
      LevelTwoDepartment levelTwoDepartment,
      String levelThreeDepartmentIds[],
      Map<String, Object> options)
      throws Exception;

  public SmartList<LevelTwoDepartment> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<LevelTwoDepartment> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateLevelTwoDepartment executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(
      String levelOneDepartmentId, Map<String, Object> options);

  public int countLevelTwoDepartmentByBelongsTo(
      String levelOneDepartmentId, Map<String, Object> options);

  public Map<String, Integer> countLevelTwoDepartmentByBelongsToIds(
      String[] ids, Map<String, Object> options);

  public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(
      String levelOneDepartmentId, int start, int count, Map<String, Object> options);

  public void analyzeLevelTwoDepartmentByBelongsTo(
      SmartList<LevelTwoDepartment> resultList,
      String levelOneDepartmentId,
      Map<String, Object> options);

  List<LevelTwoDepartment> search(LevelTwoDepartmentRequest pRequest);
}
