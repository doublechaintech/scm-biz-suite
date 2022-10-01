package com.doublechaintech.retailscm.scoring;

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

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ScoringJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ScoringDAO {

  protected EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO;

  public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO) {

    if (employeeCompanyTrainingDAO == null) {
      throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
    }
    this.employeeCompanyTrainingDAO = employeeCompanyTrainingDAO;
  }

  public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO() {
    if (this.employeeCompanyTrainingDAO == null) {
      throw new IllegalStateException(
          "The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
    }

    return this.employeeCompanyTrainingDAO;
  }

  /*
  protected Scoring load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalScoring(accessKey, options);
  }
  */

  public SmartList<Scoring> loadAll() {
    return this.loadAll(getScoringMapper());
  }

  public Stream<Scoring> loadAllAsStream() {
    return this.loadAllAsStream(getScoringMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public Scoring load(String id, Map<String, Object> options) throws Exception {
    return loadInternalScoring(ScoringTable.withId(id), options);
  }

  public Scoring save(Scoring scoring, Map<String, Object> options) {

    String methodName = "save(Scoring scoring,Map<String,Object> options)";

    assertMethodArgumentNotNull(scoring, methodName, "scoring");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalScoring(scoring, options);
  }

  public Scoring clone(String scoringId, Map<String, Object> options) throws Exception {

    return clone(ScoringTable.withId(scoringId), options);
  }

  protected Scoring clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String scoringId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    Scoring newScoring = loadInternalScoring(accessKey, options);
    newScoring.setVersion(0);

    if (isSaveEmployeeCompanyTrainingListEnabled(options)) {
      for (EmployeeCompanyTraining item : newScoring.getEmployeeCompanyTrainingList()) {
        item.setVersion(0);
      }
    }

    saveInternalScoring(newScoring, options);

    return newScoring;
  }

  protected void throwIfHasException(String scoringId, int version, int count) throws Exception {
    if (count == 1) {
      throw new ScoringVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new ScoringNotFoundException(
          "The " + this.getTableName() + "(" + scoringId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public Scoring disconnectFromAll(String scoringId, int version) throws Exception {

    Scoring scoring = loadInternalScoring(ScoringTable.withId(scoringId), emptyOptions());
    scoring.clearFromAll();
    this.saveScoring(scoring);
    return scoring;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return ScoringTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "scoring";
  }

  @Override
  protected String getBeanName() {

    return "scoring";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return ScoringTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String, Object> options) {
    return checkOptions(options, ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
  }

  protected boolean isAnalyzeEmployeeCompanyTrainingListEnabled(Map<String, Object> options) {
    return ScoringTokens.of(options).analyzeEmployeeCompanyTrainingListEnabled();
  }

  protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String, Object> options) {
    return checkOptions(options, ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
  }

  protected ScoringMapper getScoringMapper() {
    return new ScoringMapper();
  }

  protected Scoring extractScoring(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      Scoring scoring = loadSingleObject(accessKey, getScoringMapper());
      return scoring;
    } catch (EmptyResultDataAccessException e) {
      throw new ScoringNotFoundException("Scoring(" + accessKey + ") is not found!");
    }
  }

  protected Scoring loadInternalScoring(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    Scoring scoring = extractScoring(accessKey, loadOptions);

    if (isExtractEmployeeCompanyTrainingListEnabled(loadOptions)) {
      extractEmployeeCompanyTrainingList(scoring, loadOptions);
    }

    if (isAnalyzeEmployeeCompanyTrainingListEnabled(loadOptions)) {
      analyzeEmployeeCompanyTrainingList(scoring, loadOptions);
    }

    return scoring;
  }

  protected void enhanceEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Scoring extractEmployeeCompanyTrainingList(
      Scoring scoring, Map<String, Object> options) {

    if (scoring == null) {
      return null;
    }
    if (scoring.getId() == null) {
      return scoring;
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO()
            .findEmployeeCompanyTrainingByScoring(scoring.getId(), options);
    if (employeeCompanyTrainingList != null) {
      enhanceEmployeeCompanyTrainingList(employeeCompanyTrainingList, options);
      scoring.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
    }

    return scoring;
  }

  protected Scoring analyzeEmployeeCompanyTrainingList(
      Scoring scoring, Map<String, Object> options) {

    if (scoring == null) {
      return null;
    }
    if (scoring.getId() == null) {
      return scoring;
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    if (employeeCompanyTrainingList != null) {
      getEmployeeCompanyTrainingDAO()
          .analyzeEmployeeCompanyTrainingByScoring(
              employeeCompanyTrainingList, scoring.getId(), options);
    }

    return scoring;
  }

  protected Scoring saveScoring(Scoring scoring) {

    if (!scoring.isChanged()) {
      return scoring;
    }

    Beans.dbUtil().cacheCleanUp(scoring);
    String SQL = this.getSaveScoringSQL(scoring);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveScoringParameters(scoring);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    scoring.incVersion();
    scoring.afterSave();
    return scoring;
  }

  public SmartList<Scoring> saveScoringList(
      SmartList<Scoring> scoringList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitScoringList(scoringList);

    batchScoringCreate((List<Scoring>) lists[CREATE_LIST_INDEX]);
    batchScoringUpdate((List<Scoring>) lists[UPDATE_LIST_INDEX]);
    batchScoringRemove((List<Scoring>) lists[REMOVE_LIST_INDEX]);
    batchScoringRecover((List<Scoring>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (Scoring scoring : scoringList) {
      if (scoring.isChanged()) {
        scoring.incVersion();
        scoring.afterSave();
      }
      if (scoring.isToRecover() || scoring.isToRemove()) {
        scoring.setVersion(-scoring.getVersion());
      }
    }

    return scoringList;
  }

  public SmartList<Scoring> removeScoringList(
      SmartList<Scoring> scoringList, Map<String, Object> options) {

    super.removeList(scoringList, options);

    return scoringList;
  }

  protected List<Object[]> prepareScoringBatchCreateArgs(List<Scoring> scoringList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Scoring scoring : scoringList) {
      Object[] parameters = prepareScoringCreateParameters(scoring);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareScoringBatchUpdateArgs(List<Scoring> scoringList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Scoring scoring : scoringList) {
      if (!scoring.isChanged()) {
        continue;
      }
      Object[] parameters = prepareScoringUpdateParameters(scoring);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareScoringBatchRecoverArgs(List<Scoring> scoringList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Scoring scoring : scoringList) {
      if (!scoring.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(scoring);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareScoringBatchRemoveArgs(List<Scoring> scoringList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Scoring scoring : scoringList) {
      if (!scoring.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareScoringRemoveParameters(scoring);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchScoringCreate(List<Scoring> scoringList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareScoringBatchCreateArgs(scoringList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchScoringUpdate(List<Scoring> scoringList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareScoringBatchUpdateArgs(scoringList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchScoringRemove(List<Scoring> scoringList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareScoringBatchRemoveArgs(scoringList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchScoringRecover(List<Scoring> scoringList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareScoringBatchRecoverArgs(scoringList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitScoringList(List<Scoring> scoringList) {

    List<Scoring> scoringCreateList = new ArrayList<Scoring>();
    List<Scoring> scoringUpdateList = new ArrayList<Scoring>();
    List<Scoring> scoringRemoveList = new ArrayList<Scoring>();
    List<Scoring> scoringRecoverList = new ArrayList<Scoring>();

    for (Scoring scoring : scoringList) {
      if (scoring.isToRemove()) {
        scoringRemoveList.add(scoring);
        continue;
      }
      if (scoring.isToRecover()) {
        scoringRecoverList.add(scoring);
        continue;
      }
      if (isUpdateRequest(scoring)) {
        if (scoring.isChanged()) {
          scoringUpdateList.add(scoring);
        }
        continue;
      }

      if (scoring.isChanged()) {
        scoringCreateList.add(scoring);
      }
    }

    return new Object[] {
      scoringCreateList, scoringUpdateList, scoringRemoveList, scoringRecoverList
    };
  }

  protected boolean isUpdateRequest(Scoring scoring) {
    return scoring.getVersion() > 0;
  }

  protected String getSaveScoringSQL(Scoring scoring) {
    if (scoring.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(scoring)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveScoringParameters(Scoring scoring) {
    if (scoring.isToRemove()) {
      return prepareScoringRemoveParameters(scoring);
    }
    if (scoring.isToRecover()) {
      return prepareRecoverParameters(scoring);
    }

    if (isUpdateRequest(scoring)) {
      return prepareScoringUpdateParameters(scoring);
    }
    return prepareScoringCreateParameters(scoring);
  }

  protected Object[] prepareScoringRemoveParameters(Scoring scoring) {
    return super.prepareRemoveParameters(scoring);
  }

  protected Object[] prepareScoringUpdateParameters(Scoring scoring) {
    Object[] parameters = new Object[6];

    parameters[0] = scoring.getScoredBy();

    parameters[1] = scoring.getScore();

    parameters[2] = scoring.getComment();

    parameters[3] = scoring.nextVersion();
    parameters[4] = scoring.getId();
    parameters[5] = scoring.getVersion();

    return parameters;
  }

  protected Object[] prepareScoringCreateParameters(Scoring scoring) {
    Object[] parameters = new Object[4];
    if (scoring.getId() == null) {
      String newScoringId = getNextId();
      scoring.setId(newScoringId);
    }
    parameters[0] = scoring.getId();

    parameters[1] = scoring.getScoredBy();

    parameters[2] = scoring.getScore();

    parameters[3] = scoring.getComment();

    return parameters;
  }

  protected Scoring saveInternalScoring(Scoring scoring, Map<String, Object> options) {

    saveScoring(scoring);

    if (isSaveEmployeeCompanyTrainingListEnabled(options)) {
      saveEmployeeCompanyTrainingList(scoring, options);
      // removeEmployeeCompanyTrainingList(scoring, options);
      // Not delete the record

    }

    return scoring;
  }

  // ======================================================================================

  public Scoring planToRemoveEmployeeCompanyTrainingList(
      Scoring scoring, String employeeCompanyTrainingIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoring.getId());
    key.put(EmployeeCompanyTraining.ID_PROPERTY, employeeCompanyTrainingIds);

    SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
    if (externalEmployeeCompanyTrainingList == null) {
      return scoring;
    }
    if (externalEmployeeCompanyTrainingList.isEmpty()) {
      return scoring;
    }

    for (EmployeeCompanyTraining employeeCompanyTrainingItem :
        externalEmployeeCompanyTrainingList) {

      employeeCompanyTrainingItem.clearFromAll();
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
    return scoring;
  }

  // disconnect Scoring with employee in EmployeeCompanyTraining
  public Scoring planToRemoveEmployeeCompanyTrainingListWithEmployee(
      Scoring scoring, String employeeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoring.getId());
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);

    SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
    if (externalEmployeeCompanyTrainingList == null) {
      return scoring;
    }
    if (externalEmployeeCompanyTrainingList.isEmpty()) {
      return scoring;
    }

    for (EmployeeCompanyTraining employeeCompanyTrainingItem :
        externalEmployeeCompanyTrainingList) {
      employeeCompanyTrainingItem.clearEmployee();
      employeeCompanyTrainingItem.clearScoring();
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
    return scoring;
  }

  public int countEmployeeCompanyTrainingListWithEmployee(
      String scoringId, String employeeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);

    int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
    return count;
  }

  // disconnect Scoring with training in EmployeeCompanyTraining
  public Scoring planToRemoveEmployeeCompanyTrainingListWithTraining(
      Scoring scoring, String trainingId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoring.getId());
    key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, trainingId);

    SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
    if (externalEmployeeCompanyTrainingList == null) {
      return scoring;
    }
    if (externalEmployeeCompanyTrainingList.isEmpty()) {
      return scoring;
    }

    for (EmployeeCompanyTraining employeeCompanyTrainingItem :
        externalEmployeeCompanyTrainingList) {
      employeeCompanyTrainingItem.clearTraining();
      employeeCompanyTrainingItem.clearScoring();
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
    return scoring;
  }

  public int countEmployeeCompanyTrainingListWithTraining(
      String scoringId, String trainingId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
    key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, trainingId);

    int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
    return count;
  }

  protected Scoring saveEmployeeCompanyTrainingList(Scoring scoring, Map<String, Object> options) {

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    if (employeeCompanyTrainingList == null) {
      // null list means nothing
      return scoring;
    }
    SmartList<EmployeeCompanyTraining> mergedUpdateEmployeeCompanyTrainingList =
        new SmartList<EmployeeCompanyTraining>();

    mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList);
    if (employeeCompanyTrainingList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList.getToRemoveList());
      employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeCompanyTrainingDAO()
        .saveEmployeeCompanyTrainingList(mergedUpdateEmployeeCompanyTrainingList, options);

    if (employeeCompanyTrainingList.getToRemoveList() != null) {
      employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
    }

    return scoring;
  }

  protected Scoring removeEmployeeCompanyTrainingList(
      Scoring scoring, Map<String, Object> options) {

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    if (employeeCompanyTrainingList == null) {
      return scoring;
    }

    SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList =
        employeeCompanyTrainingList.getToRemoveList();

    if (toRemoveEmployeeCompanyTrainingList == null) {
      return scoring;
    }
    if (toRemoveEmployeeCompanyTrainingList.isEmpty()) {
      return scoring; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeCompanyTrainingDAO()
        .removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList, options);

    return scoring;
  }

  public Scoring present(Scoring scoring, Map<String, Object> options) {

    presentEmployeeCompanyTrainingList(scoring, options);

    return scoring;
  }

  // Using java8 feature to reduce the code significantly
  protected Scoring presentEmployeeCompanyTrainingList(
      Scoring scoring, Map<String, Object> options) {

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        scoring.getEmployeeCompanyTrainingList();
    SmartList<EmployeeCompanyTraining> newList =
        presentSubList(
            scoring.getId(),
            employeeCompanyTrainingList,
            options,
            getEmployeeCompanyTrainingDAO()::countEmployeeCompanyTrainingByScoring,
            getEmployeeCompanyTrainingDAO()::findEmployeeCompanyTrainingByScoring);

    scoring.setEmployeeCompanyTrainingList(newList);

    return scoring;
  }

  public SmartList<Scoring> requestCandidateScoringForEmployeeCompanyTraining(
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
        ScoringTable.COLUMN_SCORED_BY, null, filterKey, pageNo, pageSize, getScoringMapper());
  }

  protected String getTableName() {
    return ScoringTable.TABLE_NAME;
  }

  public void enhanceList(List<Scoring> scoringList) {
    this.enhanceListInternal(scoringList, this.getScoringMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<Scoring> scoringList = ownerEntity.collectRefsWithType(Scoring.INTERNAL_TYPE);
    this.enhanceList(scoringList);
  }

  @Override
  public SmartList<Scoring> findScoringWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getScoringMapper());
  }

  @Override
  public int countScoringWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countScoringWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<Scoring> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getScoringMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<Scoring> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getScoringMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateScoring executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateScoring result = new CandidateScoring();
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
  public List<Scoring> search(ScoringRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected ScoringMapper mapper() {
    return getScoringMapper();
  }

  @Override
  protected ScoringMapper mapperForClazz(Class<?> clazz) {
    return ScoringMapper.mapperForClass(clazz);
  }
}
