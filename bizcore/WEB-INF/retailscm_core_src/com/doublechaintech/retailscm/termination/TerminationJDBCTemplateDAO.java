package com.doublechaintech.retailscm.termination;

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

import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TerminationJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TerminationDAO {

  protected TerminationReasonDAO terminationReasonDAO;

  public void setTerminationReasonDAO(TerminationReasonDAO terminationReasonDAO) {

    if (terminationReasonDAO == null) {
      throw new IllegalStateException("Do not try to set terminationReasonDAO to null.");
    }
    this.terminationReasonDAO = terminationReasonDAO;
  }

  public TerminationReasonDAO getTerminationReasonDAO() {
    if (this.terminationReasonDAO == null) {
      throw new IllegalStateException(
          "The terminationReasonDAO is not configured yet, please config it some where.");
    }

    return this.terminationReasonDAO;
  }

  protected TerminationTypeDAO terminationTypeDAO;

  public void setTerminationTypeDAO(TerminationTypeDAO terminationTypeDAO) {

    if (terminationTypeDAO == null) {
      throw new IllegalStateException("Do not try to set terminationTypeDAO to null.");
    }
    this.terminationTypeDAO = terminationTypeDAO;
  }

  public TerminationTypeDAO getTerminationTypeDAO() {
    if (this.terminationTypeDAO == null) {
      throw new IllegalStateException(
          "The terminationTypeDAO is not configured yet, please config it some where.");
    }

    return this.terminationTypeDAO;
  }

  /*
  protected Termination load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalTermination(accessKey, options);
  }
  */

  public SmartList<Termination> loadAll() {
    return this.loadAll(getTerminationMapper());
  }

  public Stream<Termination> loadAllAsStream() {
    return this.loadAllAsStream(getTerminationMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public Termination load(String id, Map<String, Object> options) throws Exception {
    return loadInternalTermination(TerminationTable.withId(id), options);
  }

  public Termination save(Termination termination, Map<String, Object> options) {

    String methodName = "save(Termination termination,Map<String,Object> options)";

    assertMethodArgumentNotNull(termination, methodName, "termination");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalTermination(termination, options);
  }

  public Termination clone(String terminationId, Map<String, Object> options) throws Exception {

    return clone(TerminationTable.withId(terminationId), options);
  }

  protected Termination clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String terminationId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    Termination newTermination = loadInternalTermination(accessKey, options);
    newTermination.setVersion(0);

    saveInternalTermination(newTermination, options);

    return newTermination;
  }

  protected void throwIfHasException(String terminationId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new TerminationVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new TerminationNotFoundException(
          "The " + this.getTableName() + "(" + terminationId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public Termination disconnectFromAll(String terminationId, int version) throws Exception {

    Termination termination =
        loadInternalTermination(TerminationTable.withId(terminationId), emptyOptions());
    termination.clearFromAll();
    this.saveTermination(termination);
    return termination;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return TerminationTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "termination";
  }

  @Override
  protected String getBeanName() {

    return "termination";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return TerminationTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractReasonEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationTokens.REASON);
  }

  protected boolean isSaveReasonEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationTokens.REASON);
  }

  protected boolean isExtractTypeEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationTokens.TYPE);
  }

  protected boolean isSaveTypeEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationTokens.TYPE);
  }

  protected TerminationMapper getTerminationMapper() {
    return new TerminationMapper();
  }

  protected Termination extractTermination(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      Termination termination = loadSingleObject(accessKey, getTerminationMapper());
      return termination;
    } catch (EmptyResultDataAccessException e) {
      throw new TerminationNotFoundException("Termination(" + accessKey + ") is not found!");
    }
  }

  protected Termination loadInternalTermination(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    Termination termination = extractTermination(accessKey, loadOptions);

    if (isExtractReasonEnabled(loadOptions)) {
      extractReason(termination, loadOptions);
    }

    if (isExtractTypeEnabled(loadOptions)) {
      extractType(termination, loadOptions);
    }

    return termination;
  }

  protected Termination extractReason(Termination termination, Map<String, Object> options)
      throws Exception {

    if (termination.getReason() == null) {
      return termination;
    }
    String reasonId = termination.getReason().getId();
    if (reasonId == null) {
      return termination;
    }
    TerminationReason reason = getTerminationReasonDAO().load(reasonId, options);
    if (reason != null) {
      termination.setReason(reason);
    }

    return termination;
  }

  protected Termination extractType(Termination termination, Map<String, Object> options)
      throws Exception {

    if (termination.getType() == null) {
      return termination;
    }
    String typeId = termination.getType().getId();
    if (typeId == null) {
      return termination;
    }
    TerminationType type = getTerminationTypeDAO().load(typeId, options);
    if (type != null) {
      termination.setType(type);
    }

    return termination;
  }

  public SmartList<Termination> findTerminationByReason(
      String terminationReasonId, Map<String, Object> options) {

    SmartList<Termination> resultList =
        queryWith(
            TerminationTable.COLUMN_REASON, terminationReasonId, options, getTerminationMapper());
    // analyzeTerminationByReason(resultList, terminationReasonId, options);
    return resultList;
  }

  public SmartList<Termination> findTerminationByReason(
      String terminationReasonId, int start, int count, Map<String, Object> options) {

    SmartList<Termination> resultList =
        queryWithRange(
            TerminationTable.COLUMN_REASON,
            terminationReasonId,
            options,
            getTerminationMapper(),
            start,
            count);
    // analyzeTerminationByReason(resultList, terminationReasonId, options);
    return resultList;
  }

  public void analyzeTerminationByReason(
      SmartList<Termination> resultList, String terminationReasonId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Termination.REASON_PROPERTY, terminationReasonId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    resultList.setStatsInfo(info);
  }

  @Override
  public int countTerminationByReason(String terminationReasonId, Map<String, Object> options) {

    return countWith(TerminationTable.COLUMN_REASON, terminationReasonId, options);
  }

  @Override
  public Map<String, Integer> countTerminationByReasonIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(TerminationTable.COLUMN_REASON, ids, options);
  }

  public SmartList<Termination> findTerminationByType(
      String terminationTypeId, Map<String, Object> options) {

    SmartList<Termination> resultList =
        queryWith(TerminationTable.COLUMN_TYPE, terminationTypeId, options, getTerminationMapper());
    // analyzeTerminationByType(resultList, terminationTypeId, options);
    return resultList;
  }

  public SmartList<Termination> findTerminationByType(
      String terminationTypeId, int start, int count, Map<String, Object> options) {

    SmartList<Termination> resultList =
        queryWithRange(
            TerminationTable.COLUMN_TYPE,
            terminationTypeId,
            options,
            getTerminationMapper(),
            start,
            count);
    // analyzeTerminationByType(resultList, terminationTypeId, options);
    return resultList;
  }

  public void analyzeTerminationByType(
      SmartList<Termination> resultList, String terminationTypeId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Termination.TYPE_PROPERTY, terminationTypeId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    resultList.setStatsInfo(info);
  }

  @Override
  public int countTerminationByType(String terminationTypeId, Map<String, Object> options) {

    return countWith(TerminationTable.COLUMN_TYPE, terminationTypeId, options);
  }

  @Override
  public Map<String, Integer> countTerminationByTypeIds(String[] ids, Map<String, Object> options) {
    return countWithIds(TerminationTable.COLUMN_TYPE, ids, options);
  }

  protected Termination saveTermination(Termination termination) {

    if (!termination.isChanged()) {
      return termination;
    }

    Beans.dbUtil().cacheCleanUp(termination);
    String SQL = this.getSaveTerminationSQL(termination);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveTerminationParameters(termination);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    termination.incVersion();
    termination.afterSave();
    return termination;
  }

  public SmartList<Termination> saveTerminationList(
      SmartList<Termination> terminationList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitTerminationList(terminationList);

    batchTerminationCreate((List<Termination>) lists[CREATE_LIST_INDEX]);
    batchTerminationUpdate((List<Termination>) lists[UPDATE_LIST_INDEX]);
    batchTerminationRemove((List<Termination>) lists[REMOVE_LIST_INDEX]);
    batchTerminationRecover((List<Termination>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (Termination termination : terminationList) {
      if (termination.isChanged()) {
        termination.incVersion();
        termination.afterSave();
      }
      if (termination.isToRecover() || termination.isToRemove()) {
        termination.setVersion(-termination.getVersion());
      }
    }

    return terminationList;
  }

  public SmartList<Termination> removeTerminationList(
      SmartList<Termination> terminationList, Map<String, Object> options) {

    super.removeList(terminationList, options);

    return terminationList;
  }

  protected List<Object[]> prepareTerminationBatchCreateArgs(List<Termination> terminationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Termination termination : terminationList) {
      Object[] parameters = prepareTerminationCreateParameters(termination);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationBatchUpdateArgs(List<Termination> terminationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Termination termination : terminationList) {
      if (!termination.isChanged()) {
        continue;
      }
      Object[] parameters = prepareTerminationUpdateParameters(termination);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationBatchRecoverArgs(List<Termination> terminationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Termination termination : terminationList) {
      if (!termination.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(termination);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationBatchRemoveArgs(List<Termination> terminationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Termination termination : terminationList) {
      if (!termination.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareTerminationRemoveParameters(termination);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchTerminationCreate(List<Termination> terminationList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareTerminationBatchCreateArgs(terminationList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchTerminationUpdate(List<Termination> terminationList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareTerminationBatchUpdateArgs(terminationList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchTerminationRemove(List<Termination> terminationList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareTerminationBatchRemoveArgs(terminationList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchTerminationRecover(List<Termination> terminationList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareTerminationBatchRecoverArgs(terminationList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitTerminationList(List<Termination> terminationList) {

    List<Termination> terminationCreateList = new ArrayList<Termination>();
    List<Termination> terminationUpdateList = new ArrayList<Termination>();
    List<Termination> terminationRemoveList = new ArrayList<Termination>();
    List<Termination> terminationRecoverList = new ArrayList<Termination>();

    for (Termination termination : terminationList) {
      if (termination.isToRemove()) {
        terminationRemoveList.add(termination);
        continue;
      }
      if (termination.isToRecover()) {
        terminationRecoverList.add(termination);
        continue;
      }
      if (isUpdateRequest(termination)) {
        if (termination.isChanged()) {
          terminationUpdateList.add(termination);
        }
        continue;
      }

      if (termination.isChanged()) {
        terminationCreateList.add(termination);
      }
    }

    return new Object[] {
      terminationCreateList, terminationUpdateList, terminationRemoveList, terminationRecoverList
    };
  }

  protected boolean isUpdateRequest(Termination termination) {
    return termination.getVersion() > 0;
  }

  protected String getSaveTerminationSQL(Termination termination) {
    if (termination.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(termination)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveTerminationParameters(Termination termination) {
    if (termination.isToRemove()) {
      return prepareTerminationRemoveParameters(termination);
    }
    if (termination.isToRecover()) {
      return prepareRecoverParameters(termination);
    }

    if (isUpdateRequest(termination)) {
      return prepareTerminationUpdateParameters(termination);
    }
    return prepareTerminationCreateParameters(termination);
  }

  protected Object[] prepareTerminationRemoveParameters(Termination termination) {
    return super.prepareRemoveParameters(termination);
  }

  protected Object[] prepareTerminationUpdateParameters(Termination termination) {
    Object[] parameters = new Object[6];

    if (termination.getReason() != null) {
      parameters[0] = termination.getReason().getId();
    }

    if (termination.getType() != null) {
      parameters[1] = termination.getType().getId();
    }

    parameters[2] = termination.getComment();

    parameters[3] = termination.nextVersion();
    parameters[4] = termination.getId();
    parameters[5] = termination.getVersion();

    return parameters;
  }

  protected Object[] prepareTerminationCreateParameters(Termination termination) {
    Object[] parameters = new Object[4];
    if (termination.getId() == null) {
      String newTerminationId = getNextId();
      termination.setId(newTerminationId);
    }
    parameters[0] = termination.getId();

    if (termination.getReason() != null) {
      parameters[1] = termination.getReason().getId();
    }

    if (termination.getType() != null) {
      parameters[2] = termination.getType().getId();
    }

    parameters[3] = termination.getComment();

    return parameters;
  }

  protected Termination saveInternalTermination(
      Termination termination, Map<String, Object> options) {

    if (isSaveReasonEnabled(options)) {
      saveReason(termination, options);
    }

    if (isSaveTypeEnabled(options)) {
      saveType(termination, options);
    }

    saveTermination(termination);

    return termination;
  }

  // ======================================================================================

  protected Termination saveReason(Termination termination, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (termination.getReason() == null) {
      return termination; // do nothing when it is null
    }

    getTerminationReasonDAO().save(termination.getReason(), options);
    return termination;
  }

  protected Termination saveType(Termination termination, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (termination.getType() == null) {
      return termination; // do nothing when it is null
    }

    getTerminationTypeDAO().save(termination.getType(), options);
    return termination;
  }

  public Termination present(Termination termination, Map<String, Object> options) {

    return termination;
  }

  protected String getTableName() {
    return TerminationTable.TABLE_NAME;
  }

  public void enhanceList(List<Termination> terminationList) {
    this.enhanceListInternal(terminationList, this.getTerminationMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<Termination> terminationList = ownerEntity.collectRefsWithType(Termination.INTERNAL_TYPE);
    this.enhanceList(terminationList);
  }

  @Override
  public SmartList<Termination> findTerminationWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getTerminationMapper());
  }

  @Override
  public int countTerminationWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countTerminationWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<Termination> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getTerminationMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<Termination> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTerminationMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateTermination executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateTermination result = new CandidateTermination();
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

  @Override
  public List<Termination> search(TerminationRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected TerminationMapper mapper() {
    return getTerminationMapper();
  }

  @Override
  protected TerminationMapper mapperForClazz(Class<?> clazz) {
    return TerminationMapper.mapperForClass(clazz);
  }
}
