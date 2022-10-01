package com.doublechaintech.retailscm.candidatecontainer;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.candidateelement.CandidateElement;

import com.doublechaintech.retailscm.candidateelement.CandidateElementDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class CandidateContainerJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements CandidateContainerDAO {

  protected CandidateElementDAO candidateElementDAO;

  public void setCandidateElementDAO(CandidateElementDAO candidateElementDAO) {

    if (candidateElementDAO == null) {
      throw new IllegalStateException("Do not try to set candidateElementDAO to null.");
    }
    this.candidateElementDAO = candidateElementDAO;
  }

  public CandidateElementDAO getCandidateElementDAO() {
    if (this.candidateElementDAO == null) {
      throw new IllegalStateException(
          "The candidateElementDAO is not configured yet, please config it some where.");
    }

    return this.candidateElementDAO;
  }

  /*
  protected CandidateContainer load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalCandidateContainer(accessKey, options);
  }
  */

  public SmartList<CandidateContainer> loadAll() {
    return this.loadAll(getCandidateContainerMapper());
  }

  public Stream<CandidateContainer> loadAllAsStream() {
    return this.loadAllAsStream(getCandidateContainerMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public CandidateContainer load(String id, Map<String, Object> options) throws Exception {
    return loadInternalCandidateContainer(CandidateContainerTable.withId(id), options);
  }

  public CandidateContainer save(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    String methodName = "save(CandidateContainer candidateContainer,Map<String,Object> options)";

    assertMethodArgumentNotNull(candidateContainer, methodName, "candidateContainer");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalCandidateContainer(candidateContainer, options);
  }

  public CandidateContainer clone(String candidateContainerId, Map<String, Object> options)
      throws Exception {

    return clone(CandidateContainerTable.withId(candidateContainerId), options);
  }

  protected CandidateContainer clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String candidateContainerId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    CandidateContainer newCandidateContainer = loadInternalCandidateContainer(accessKey, options);
    newCandidateContainer.setVersion(0);

    if (isSaveCandidateElementListEnabled(options)) {
      for (CandidateElement item : newCandidateContainer.getCandidateElementList()) {
        item.setVersion(0);
      }
    }

    saveInternalCandidateContainer(newCandidateContainer, options);

    return newCandidateContainer;
  }

  protected void throwIfHasException(String candidateContainerId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new CandidateContainerVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new CandidateContainerNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + candidateContainerId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public CandidateContainer disconnectFromAll(String candidateContainerId, int version)
      throws Exception {

    CandidateContainer candidateContainer =
        loadInternalCandidateContainer(
            CandidateContainerTable.withId(candidateContainerId), emptyOptions());
    candidateContainer.clearFromAll();
    this.saveCandidateContainer(candidateContainer);
    return candidateContainer;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return CandidateContainerTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "candidate_container";
  }

  @Override
  protected String getBeanName() {

    return "candidateContainer";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return CandidateContainerTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCandidateElementListEnabled(Map<String, Object> options) {
    return checkOptions(options, CandidateContainerTokens.CANDIDATE_ELEMENT_LIST);
  }

  protected boolean isAnalyzeCandidateElementListEnabled(Map<String, Object> options) {
    return CandidateContainerTokens.of(options).analyzeCandidateElementListEnabled();
  }

  protected boolean isSaveCandidateElementListEnabled(Map<String, Object> options) {
    return checkOptions(options, CandidateContainerTokens.CANDIDATE_ELEMENT_LIST);
  }

  protected CandidateContainerMapper getCandidateContainerMapper() {
    return new CandidateContainerMapper();
  }

  protected CandidateContainer extractCandidateContainer(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      CandidateContainer candidateContainer =
          loadSingleObject(accessKey, getCandidateContainerMapper());
      return candidateContainer;
    } catch (EmptyResultDataAccessException e) {
      throw new CandidateContainerNotFoundException(
          "CandidateContainer(" + accessKey + ") is not found!");
    }
  }

  protected CandidateContainer loadInternalCandidateContainer(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    CandidateContainer candidateContainer = extractCandidateContainer(accessKey, loadOptions);

    if (isExtractCandidateElementListEnabled(loadOptions)) {
      extractCandidateElementList(candidateContainer, loadOptions);
    }

    if (isAnalyzeCandidateElementListEnabled(loadOptions)) {
      analyzeCandidateElementList(candidateContainer, loadOptions);
    }

    return candidateContainer;
  }

  protected void enhanceCandidateElementList(
      SmartList<CandidateElement> candidateElementList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected CandidateContainer extractCandidateElementList(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    if (candidateContainer == null) {
      return null;
    }
    if (candidateContainer.getId() == null) {
      return candidateContainer;
    }

    SmartList<CandidateElement> candidateElementList =
        getCandidateElementDAO()
            .findCandidateElementByContainer(candidateContainer.getId(), options);
    if (candidateElementList != null) {
      enhanceCandidateElementList(candidateElementList, options);
      candidateContainer.setCandidateElementList(candidateElementList);
    }

    return candidateContainer;
  }

  protected CandidateContainer analyzeCandidateElementList(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    if (candidateContainer == null) {
      return null;
    }
    if (candidateContainer.getId() == null) {
      return candidateContainer;
    }

    SmartList<CandidateElement> candidateElementList = candidateContainer.getCandidateElementList();
    if (candidateElementList != null) {
      getCandidateElementDAO()
          .analyzeCandidateElementByContainer(
              candidateElementList, candidateContainer.getId(), options);
    }

    return candidateContainer;
  }

  protected CandidateContainer saveCandidateContainer(CandidateContainer candidateContainer) {

    if (!candidateContainer.isChanged()) {
      return candidateContainer;
    }

    Beans.dbUtil().cacheCleanUp(candidateContainer);
    String SQL = this.getSaveCandidateContainerSQL(candidateContainer);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveCandidateContainerParameters(candidateContainer);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    candidateContainer.incVersion();
    candidateContainer.afterSave();
    return candidateContainer;
  }

  public SmartList<CandidateContainer> saveCandidateContainerList(
      SmartList<CandidateContainer> candidateContainerList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitCandidateContainerList(candidateContainerList);

    batchCandidateContainerCreate((List<CandidateContainer>) lists[CREATE_LIST_INDEX]);
    batchCandidateContainerUpdate((List<CandidateContainer>) lists[UPDATE_LIST_INDEX]);
    batchCandidateContainerRemove((List<CandidateContainer>) lists[REMOVE_LIST_INDEX]);
    batchCandidateContainerRecover((List<CandidateContainer>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (CandidateContainer candidateContainer : candidateContainerList) {
      if (candidateContainer.isChanged()) {
        candidateContainer.incVersion();
        candidateContainer.afterSave();
      }
      if (candidateContainer.isToRecover() || candidateContainer.isToRemove()) {
        candidateContainer.setVersion(-candidateContainer.getVersion());
      }
    }

    return candidateContainerList;
  }

  public SmartList<CandidateContainer> removeCandidateContainerList(
      SmartList<CandidateContainer> candidateContainerList, Map<String, Object> options) {

    super.removeList(candidateContainerList, options);

    return candidateContainerList;
  }

  protected List<Object[]> prepareCandidateContainerBatchCreateArgs(
      List<CandidateContainer> candidateContainerList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (CandidateContainer candidateContainer : candidateContainerList) {
      Object[] parameters = prepareCandidateContainerCreateParameters(candidateContainer);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareCandidateContainerBatchUpdateArgs(
      List<CandidateContainer> candidateContainerList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (CandidateContainer candidateContainer : candidateContainerList) {
      if (!candidateContainer.isChanged()) {
        continue;
      }
      Object[] parameters = prepareCandidateContainerUpdateParameters(candidateContainer);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareCandidateContainerBatchRecoverArgs(
      List<CandidateContainer> candidateContainerList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (CandidateContainer candidateContainer : candidateContainerList) {
      if (!candidateContainer.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(candidateContainer);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareCandidateContainerBatchRemoveArgs(
      List<CandidateContainer> candidateContainerList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (CandidateContainer candidateContainer : candidateContainerList) {
      if (!candidateContainer.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareCandidateContainerRemoveParameters(candidateContainer);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchCandidateContainerCreate(List<CandidateContainer> candidateContainerList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareCandidateContainerBatchCreateArgs(candidateContainerList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchCandidateContainerUpdate(List<CandidateContainer> candidateContainerList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareCandidateContainerBatchUpdateArgs(candidateContainerList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchCandidateContainerRemove(List<CandidateContainer> candidateContainerList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareCandidateContainerBatchRemoveArgs(candidateContainerList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchCandidateContainerRecover(List<CandidateContainer> candidateContainerList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareCandidateContainerBatchRecoverArgs(candidateContainerList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitCandidateContainerList(List<CandidateContainer> candidateContainerList) {

    List<CandidateContainer> candidateContainerCreateList = new ArrayList<CandidateContainer>();
    List<CandidateContainer> candidateContainerUpdateList = new ArrayList<CandidateContainer>();
    List<CandidateContainer> candidateContainerRemoveList = new ArrayList<CandidateContainer>();
    List<CandidateContainer> candidateContainerRecoverList = new ArrayList<CandidateContainer>();

    for (CandidateContainer candidateContainer : candidateContainerList) {
      if (candidateContainer.isToRemove()) {
        candidateContainerRemoveList.add(candidateContainer);
        continue;
      }
      if (candidateContainer.isToRecover()) {
        candidateContainerRecoverList.add(candidateContainer);
        continue;
      }
      if (isUpdateRequest(candidateContainer)) {
        if (candidateContainer.isChanged()) {
          candidateContainerUpdateList.add(candidateContainer);
        }
        continue;
      }

      if (candidateContainer.isChanged()) {
        candidateContainerCreateList.add(candidateContainer);
      }
    }

    return new Object[] {
      candidateContainerCreateList,
      candidateContainerUpdateList,
      candidateContainerRemoveList,
      candidateContainerRecoverList
    };
  }

  protected boolean isUpdateRequest(CandidateContainer candidateContainer) {
    return candidateContainer.getVersion() > 0;
  }

  protected String getSaveCandidateContainerSQL(CandidateContainer candidateContainer) {
    if (candidateContainer.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(candidateContainer)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveCandidateContainerParameters(CandidateContainer candidateContainer) {
    if (candidateContainer.isToRemove()) {
      return prepareCandidateContainerRemoveParameters(candidateContainer);
    }
    if (candidateContainer.isToRecover()) {
      return prepareRecoverParameters(candidateContainer);
    }

    if (isUpdateRequest(candidateContainer)) {
      return prepareCandidateContainerUpdateParameters(candidateContainer);
    }
    return prepareCandidateContainerCreateParameters(candidateContainer);
  }

  protected Object[] prepareCandidateContainerRemoveParameters(
      CandidateContainer candidateContainer) {
    return super.prepareRemoveParameters(candidateContainer);
  }

  protected Object[] prepareCandidateContainerUpdateParameters(
      CandidateContainer candidateContainer) {
    Object[] parameters = new Object[4];

    parameters[0] = candidateContainer.getName();

    parameters[1] = candidateContainer.nextVersion();
    parameters[2] = candidateContainer.getId();
    parameters[3] = candidateContainer.getVersion();

    return parameters;
  }

  protected Object[] prepareCandidateContainerCreateParameters(
      CandidateContainer candidateContainer) {
    Object[] parameters = new Object[2];
    if (candidateContainer.getId() == null) {
      String newCandidateContainerId = getNextId();
      candidateContainer.setId(newCandidateContainerId);
    }
    parameters[0] = candidateContainer.getId();

    parameters[1] = candidateContainer.getName();

    return parameters;
  }

  protected CandidateContainer saveInternalCandidateContainer(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    saveCandidateContainer(candidateContainer);

    if (isSaveCandidateElementListEnabled(options)) {
      saveCandidateElementList(candidateContainer, options);
      // removeCandidateElementList(candidateContainer, options);
      // Not delete the record

    }

    return candidateContainer;
  }

  // ======================================================================================

  public CandidateContainer planToRemoveCandidateElementList(
      CandidateContainer candidateContainer,
      String candidateElementIds[],
      Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(CandidateElement.CONTAINER_PROPERTY, candidateContainer.getId());
    key.put(CandidateElement.ID_PROPERTY, candidateElementIds);

    SmartList<CandidateElement> externalCandidateElementList =
        getCandidateElementDAO().findCandidateElementWithKey(key, options);
    if (externalCandidateElementList == null) {
      return candidateContainer;
    }
    if (externalCandidateElementList.isEmpty()) {
      return candidateContainer;
    }

    for (CandidateElement candidateElementItem : externalCandidateElementList) {

      candidateElementItem.clearFromAll();
    }

    SmartList<CandidateElement> candidateElementList = candidateContainer.getCandidateElementList();
    candidateElementList.addAllToRemoveList(externalCandidateElementList);
    return candidateContainer;
  }

  protected CandidateContainer saveCandidateElementList(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    SmartList<CandidateElement> candidateElementList = candidateContainer.getCandidateElementList();
    if (candidateElementList == null) {
      // null list means nothing
      return candidateContainer;
    }
    SmartList<CandidateElement> mergedUpdateCandidateElementList =
        new SmartList<CandidateElement>();

    mergedUpdateCandidateElementList.addAll(candidateElementList);
    if (candidateElementList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateCandidateElementList.addAll(candidateElementList.getToRemoveList());
      candidateElementList.removeAll(candidateElementList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getCandidateElementDAO().saveCandidateElementList(mergedUpdateCandidateElementList, options);

    if (candidateElementList.getToRemoveList() != null) {
      candidateElementList.removeAll(candidateElementList.getToRemoveList());
    }

    return candidateContainer;
  }

  protected CandidateContainer removeCandidateElementList(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    SmartList<CandidateElement> candidateElementList = candidateContainer.getCandidateElementList();
    if (candidateElementList == null) {
      return candidateContainer;
    }

    SmartList<CandidateElement> toRemoveCandidateElementList =
        candidateElementList.getToRemoveList();

    if (toRemoveCandidateElementList == null) {
      return candidateContainer;
    }
    if (toRemoveCandidateElementList.isEmpty()) {
      return candidateContainer; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getCandidateElementDAO().removeCandidateElementList(toRemoveCandidateElementList, options);

    return candidateContainer;
  }

  public CandidateContainer present(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    presentCandidateElementList(candidateContainer, options);

    return candidateContainer;
  }

  // Using java8 feature to reduce the code significantly
  protected CandidateContainer presentCandidateElementList(
      CandidateContainer candidateContainer, Map<String, Object> options) {

    SmartList<CandidateElement> candidateElementList = candidateContainer.getCandidateElementList();
    SmartList<CandidateElement> newList =
        presentSubList(
            candidateContainer.getId(),
            candidateElementList,
            options,
            getCandidateElementDAO()::countCandidateElementByContainer,
            getCandidateElementDAO()::findCandidateElementByContainer);

    candidateContainer.setCandidateElementList(newList);

    return candidateContainer;
  }

  public SmartList<CandidateContainer> requestCandidateCandidateContainerForCandidateElement(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        CandidateContainerTable.COLUMN_NAME,
        null,
        filterKey,
        pageNo,
        pageSize,
        getCandidateContainerMapper());
  }

  protected String getTableName() {
    return CandidateContainerTable.TABLE_NAME;
  }

  public void enhanceList(List<CandidateContainer> candidateContainerList) {
    this.enhanceListInternal(candidateContainerList, this.getCandidateContainerMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<CandidateContainer> candidateContainerList =
        ownerEntity.collectRefsWithType(CandidateContainer.INTERNAL_TYPE);
    this.enhanceList(candidateContainerList);
  }

  @Override
  public SmartList<CandidateContainer> findCandidateContainerWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getCandidateContainerMapper());
  }

  @Override
  public int countCandidateContainerWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countCandidateContainerWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<CandidateContainer> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getCandidateContainerMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<CandidateContainer> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getCandidateContainerMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateCandidateContainer executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateCandidateContainer result = new CandidateCandidateContainer();
    int pageNo = Math.max(1, query.getPageNo());
    result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
    result.setOwnerId(query.getOwnerId());
    result.setFilterKey(query.getFilterKey());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
    result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

    SmartList candidateList = queryList(sql, parmeters);
    this.alias(candidateList);
    result.setCandidates(candidateList);
    int offSet = (pageNo - 1) * query.getPageSize();
    if (candidateList.size() > query.getPageSize()) {
      result.setTotalPage(pageNo + 1);
    } else {
      result.setTotalPage(pageNo);
    }
    return result;
  }

  public Map<String, Integer> countBySql(String sql, Object[] params) {
    if (params == null || params.length == 0) {
      return new HashMap<>();
    }
    List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
    if (result == null || result.isEmpty()) {
      return new HashMap<>();
    }
    Map<String, Integer> cntMap = new HashMap<>();
    for (Map<String, Object> data : result) {
      String key = String.valueOf(data.get("id"));
      Number value = (Number) data.get("count");
      cntMap.put(key, value.intValue());
    }
    this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
    return cntMap;
  }

  public Integer singleCountBySql(String sql, Object[] params) {
    Integer cnt = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
    logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
    return cnt;
  }

  public BigDecimal summaryBySql(String sql, Object[] params) {
    BigDecimal cnt = this.getJdbcTemplate().queryForObject(sql, params, BigDecimal.class);
    logSQLAndParameters("summaryBySql", sql, params, cnt + "");
    return cnt == null ? BigDecimal.ZERO : cnt;
  }

  public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
    List<T> result = this.getJdbcTemplate().queryForList(sql, params, claxx);
    logSQLAndParameters("queryForList", sql, params, result.size() + " items");
    return result;
  }

  public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
    Map<String, Object> result = null;
    try {
      result = this.getJdbcTemplate().queryForMap(sql, params);
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
      // 空结果，返回null
    }
    logSQLAndParameters(
        "queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
    return result;
  }

  public <T> T queryForObject(String sql, Object[] params, Class<T> claxx)
      throws DataAccessException {
    T result = null;
    try {
      result = this.getJdbcTemplate().queryForObject(sql, params, claxx);
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
      // 空结果，返回null
    }
    logSQLAndParameters(
        "queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
    return result;
  }

  public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
    List<Map<String, Object>> result = getJdbcTemplate().queryForList(sql, params);
    logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
    return result;
  }

  public synchronized int updateBySql(String sql, Object[] params) {
    int result = getJdbcTemplate().update(sql, params);
    logSQLAndParameters("updateBySql", sql, params, result + " items");
    return result;
  }

  public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
    getJdbcTemplate().query(sql, args, callback);
  }

  public void executeSql(String sql) {
    logSQLAndParameters("executeSql", sql, new Object[] {}, "");
    getJdbcTemplate().execute(sql);
  }

  @Override
  public List<CandidateContainer> search(CandidateContainerRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected CandidateContainerMapper mapper() {
    return getCandidateContainerMapper();
  }

  @Override
  protected CandidateContainerMapper mapperForClazz(Class<?> clazz) {
    return CandidateContainerMapper.mapperForClass(clazz);
  }
}
