package com.doublechaintech.retailscm.employeeeducation;

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

import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.EmployeeDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class EmployeeEducationJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements EmployeeEducationDAO {

  protected EmployeeDAO employeeDAO;

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {

    if (employeeDAO == null) {
      throw new IllegalStateException("Do not try to set employeeDAO to null.");
    }
    this.employeeDAO = employeeDAO;
  }

  public EmployeeDAO getEmployeeDAO() {
    if (this.employeeDAO == null) {
      throw new IllegalStateException(
          "The employeeDAO is not configured yet, please config it some where.");
    }

    return this.employeeDAO;
  }

  /*
  protected EmployeeEducation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalEmployeeEducation(accessKey, options);
  }
  */

  public SmartList<EmployeeEducation> loadAll() {
    return this.loadAll(getEmployeeEducationMapper());
  }

  public Stream<EmployeeEducation> loadAllAsStream() {
    return this.loadAllAsStream(getEmployeeEducationMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public EmployeeEducation load(String id, Map<String, Object> options) throws Exception {
    return loadInternalEmployeeEducation(EmployeeEducationTable.withId(id), options);
  }

  public EmployeeEducation save(EmployeeEducation employeeEducation, Map<String, Object> options) {

    String methodName = "save(EmployeeEducation employeeEducation,Map<String,Object> options)";

    assertMethodArgumentNotNull(employeeEducation, methodName, "employeeEducation");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalEmployeeEducation(employeeEducation, options);
  }

  public EmployeeEducation clone(String employeeEducationId, Map<String, Object> options)
      throws Exception {

    return clone(EmployeeEducationTable.withId(employeeEducationId), options);
  }

  protected EmployeeEducation clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String employeeEducationId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    EmployeeEducation newEmployeeEducation = loadInternalEmployeeEducation(accessKey, options);
    newEmployeeEducation.setVersion(0);

    saveInternalEmployeeEducation(newEmployeeEducation, options);

    return newEmployeeEducation;
  }

  protected void throwIfHasException(String employeeEducationId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new EmployeeEducationVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new EmployeeEducationNotFoundException(
          "The " + this.getTableName() + "(" + employeeEducationId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public EmployeeEducation disconnectFromAll(String employeeEducationId, int version)
      throws Exception {

    EmployeeEducation employeeEducation =
        loadInternalEmployeeEducation(
            EmployeeEducationTable.withId(employeeEducationId), emptyOptions());
    employeeEducation.clearFromAll();
    this.saveEmployeeEducation(employeeEducation);
    return employeeEducation;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return EmployeeEducationTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "employee_education";
  }

  @Override
  protected String getBeanName() {

    return "employeeEducation";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return EmployeeEducationTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractEmployeeEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeEducationTokens.EMPLOYEE);
  }

  protected boolean isSaveEmployeeEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeEducationTokens.EMPLOYEE);
  }

  protected EmployeeEducationMapper getEmployeeEducationMapper() {
    return new EmployeeEducationMapper();
  }

  protected EmployeeEducation extractEmployeeEducation(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      EmployeeEducation employeeEducation =
          loadSingleObject(accessKey, getEmployeeEducationMapper());
      return employeeEducation;
    } catch (EmptyResultDataAccessException e) {
      throw new EmployeeEducationNotFoundException(
          "EmployeeEducation(" + accessKey + ") is not found!");
    }
  }

  protected EmployeeEducation loadInternalEmployeeEducation(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    EmployeeEducation employeeEducation = extractEmployeeEducation(accessKey, loadOptions);

    if (isExtractEmployeeEnabled(loadOptions)) {
      extractEmployee(employeeEducation, loadOptions);
    }

    return employeeEducation;
  }

  protected EmployeeEducation extractEmployee(
      EmployeeEducation employeeEducation, Map<String, Object> options) throws Exception {

    if (employeeEducation.getEmployee() == null) {
      return employeeEducation;
    }
    String employeeId = employeeEducation.getEmployee().getId();
    if (employeeId == null) {
      return employeeEducation;
    }
    Employee employee = getEmployeeDAO().load(employeeId, options);
    if (employee != null) {
      employeeEducation.setEmployee(employee);
    }

    return employeeEducation;
  }

  public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(
      String employeeId, Map<String, Object> options) {

    SmartList<EmployeeEducation> resultList =
        queryWith(
            EmployeeEducationTable.COLUMN_EMPLOYEE,
            employeeId,
            options,
            getEmployeeEducationMapper());
    // analyzeEmployeeEducationByEmployee(resultList, employeeId, options);
    return resultList;
  }

  public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(
      String employeeId, int start, int count, Map<String, Object> options) {

    SmartList<EmployeeEducation> resultList =
        queryWithRange(
            EmployeeEducationTable.COLUMN_EMPLOYEE,
            employeeId,
            options,
            getEmployeeEducationMapper(),
            start,
            count);
    // analyzeEmployeeEducationByEmployee(resultList, employeeId, options);
    return resultList;
  }

  public void analyzeEmployeeEducationByEmployee(
      SmartList<EmployeeEducation> resultList, String employeeId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countEmployeeEducationByEmployee(String employeeId, Map<String, Object> options) {

    return countWith(EmployeeEducationTable.COLUMN_EMPLOYEE, employeeId, options);
  }

  @Override
  public Map<String, Integer> countEmployeeEducationByEmployeeIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(EmployeeEducationTable.COLUMN_EMPLOYEE, ids, options);
  }

  protected EmployeeEducation saveEmployeeEducation(EmployeeEducation employeeEducation) {

    if (!employeeEducation.isChanged()) {
      return employeeEducation;
    }

    Beans.dbUtil().cacheCleanUp(employeeEducation);
    String SQL = this.getSaveEmployeeEducationSQL(employeeEducation);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveEmployeeEducationParameters(employeeEducation);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    employeeEducation.incVersion();
    employeeEducation.afterSave();
    return employeeEducation;
  }

  public SmartList<EmployeeEducation> saveEmployeeEducationList(
      SmartList<EmployeeEducation> employeeEducationList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitEmployeeEducationList(employeeEducationList);

    batchEmployeeEducationCreate((List<EmployeeEducation>) lists[CREATE_LIST_INDEX]);
    batchEmployeeEducationUpdate((List<EmployeeEducation>) lists[UPDATE_LIST_INDEX]);
    batchEmployeeEducationRemove((List<EmployeeEducation>) lists[REMOVE_LIST_INDEX]);
    batchEmployeeEducationRecover((List<EmployeeEducation>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (EmployeeEducation employeeEducation : employeeEducationList) {
      if (employeeEducation.isChanged()) {
        employeeEducation.incVersion();
        employeeEducation.afterSave();
      }
      if (employeeEducation.isToRecover() || employeeEducation.isToRemove()) {
        employeeEducation.setVersion(-employeeEducation.getVersion());
      }
    }

    return employeeEducationList;
  }

  public SmartList<EmployeeEducation> removeEmployeeEducationList(
      SmartList<EmployeeEducation> employeeEducationList, Map<String, Object> options) {

    super.removeList(employeeEducationList, options);

    return employeeEducationList;
  }

  protected List<Object[]> prepareEmployeeEducationBatchCreateArgs(
      List<EmployeeEducation> employeeEducationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (EmployeeEducation employeeEducation : employeeEducationList) {
      Object[] parameters = prepareEmployeeEducationCreateParameters(employeeEducation);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareEmployeeEducationBatchUpdateArgs(
      List<EmployeeEducation> employeeEducationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (EmployeeEducation employeeEducation : employeeEducationList) {
      if (!employeeEducation.isChanged()) {
        continue;
      }
      Object[] parameters = prepareEmployeeEducationUpdateParameters(employeeEducation);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareEmployeeEducationBatchRecoverArgs(
      List<EmployeeEducation> employeeEducationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (EmployeeEducation employeeEducation : employeeEducationList) {
      if (!employeeEducation.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(employeeEducation);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareEmployeeEducationBatchRemoveArgs(
      List<EmployeeEducation> employeeEducationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (EmployeeEducation employeeEducation : employeeEducationList) {
      if (!employeeEducation.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareEmployeeEducationRemoveParameters(employeeEducation);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchEmployeeEducationCreate(List<EmployeeEducation> employeeEducationList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareEmployeeEducationBatchCreateArgs(employeeEducationList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchEmployeeEducationUpdate(List<EmployeeEducation> employeeEducationList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareEmployeeEducationBatchUpdateArgs(employeeEducationList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchEmployeeEducationRemove(List<EmployeeEducation> employeeEducationList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareEmployeeEducationBatchRemoveArgs(employeeEducationList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchEmployeeEducationRecover(List<EmployeeEducation> employeeEducationList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareEmployeeEducationBatchRecoverArgs(employeeEducationList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitEmployeeEducationList(List<EmployeeEducation> employeeEducationList) {

    List<EmployeeEducation> employeeEducationCreateList = new ArrayList<EmployeeEducation>();
    List<EmployeeEducation> employeeEducationUpdateList = new ArrayList<EmployeeEducation>();
    List<EmployeeEducation> employeeEducationRemoveList = new ArrayList<EmployeeEducation>();
    List<EmployeeEducation> employeeEducationRecoverList = new ArrayList<EmployeeEducation>();

    for (EmployeeEducation employeeEducation : employeeEducationList) {
      if (employeeEducation.isToRemove()) {
        employeeEducationRemoveList.add(employeeEducation);
        continue;
      }
      if (employeeEducation.isToRecover()) {
        employeeEducationRecoverList.add(employeeEducation);
        continue;
      }
      if (isUpdateRequest(employeeEducation)) {
        if (employeeEducation.isChanged()) {
          employeeEducationUpdateList.add(employeeEducation);
        }
        continue;
      }

      if (employeeEducation.isChanged()) {
        employeeEducationCreateList.add(employeeEducation);
      }
    }

    return new Object[] {
      employeeEducationCreateList,
      employeeEducationUpdateList,
      employeeEducationRemoveList,
      employeeEducationRecoverList
    };
  }

  protected boolean isUpdateRequest(EmployeeEducation employeeEducation) {
    return employeeEducation.getVersion() > 0;
  }

  protected String getSaveEmployeeEducationSQL(EmployeeEducation employeeEducation) {
    if (employeeEducation.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(employeeEducation)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveEmployeeEducationParameters(EmployeeEducation employeeEducation) {
    if (employeeEducation.isToRemove()) {
      return prepareEmployeeEducationRemoveParameters(employeeEducation);
    }
    if (employeeEducation.isToRecover()) {
      return prepareRecoverParameters(employeeEducation);
    }

    if (isUpdateRequest(employeeEducation)) {
      return prepareEmployeeEducationUpdateParameters(employeeEducation);
    }
    return prepareEmployeeEducationCreateParameters(employeeEducation);
  }

  protected Object[] prepareEmployeeEducationRemoveParameters(EmployeeEducation employeeEducation) {
    return super.prepareRemoveParameters(employeeEducation);
  }

  protected Object[] prepareEmployeeEducationUpdateParameters(EmployeeEducation employeeEducation) {
    Object[] parameters = new Object[7];

    if (employeeEducation.getEmployee() != null) {
      parameters[0] = employeeEducation.getEmployee().getId();
    }

    parameters[1] = employeeEducation.getCompleteTime();

    parameters[2] = employeeEducation.getType();

    parameters[3] = employeeEducation.getRemark();

    parameters[4] = employeeEducation.nextVersion();
    parameters[5] = employeeEducation.getId();
    parameters[6] = employeeEducation.getVersion();

    return parameters;
  }

  protected Object[] prepareEmployeeEducationCreateParameters(EmployeeEducation employeeEducation) {
    Object[] parameters = new Object[5];
    if (employeeEducation.getId() == null) {
      String newEmployeeEducationId = getNextId();
      employeeEducation.setId(newEmployeeEducationId);
    }
    parameters[0] = employeeEducation.getId();

    if (employeeEducation.getEmployee() != null) {
      parameters[1] = employeeEducation.getEmployee().getId();
    }

    parameters[2] = employeeEducation.getCompleteTime();

    parameters[3] = employeeEducation.getType();

    parameters[4] = employeeEducation.getRemark();

    return parameters;
  }

  protected EmployeeEducation saveInternalEmployeeEducation(
      EmployeeEducation employeeEducation, Map<String, Object> options) {

    if (isSaveEmployeeEnabled(options)) {
      saveEmployee(employeeEducation, options);
    }

    saveEmployeeEducation(employeeEducation);

    return employeeEducation;
  }

  // ======================================================================================

  protected EmployeeEducation saveEmployee(
      EmployeeEducation employeeEducation, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (employeeEducation.getEmployee() == null) {
      return employeeEducation; // do nothing when it is null
    }

    getEmployeeDAO().save(employeeEducation.getEmployee(), options);
    return employeeEducation;
  }

  public EmployeeEducation present(
      EmployeeEducation employeeEducation, Map<String, Object> options) {

    return employeeEducation;
  }

  protected String getTableName() {
    return EmployeeEducationTable.TABLE_NAME;
  }

  public void enhanceList(List<EmployeeEducation> employeeEducationList) {
    this.enhanceListInternal(employeeEducationList, this.getEmployeeEducationMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<EmployeeEducation> employeeEducationList =
        ownerEntity.collectRefsWithType(EmployeeEducation.INTERNAL_TYPE);
    this.enhanceList(employeeEducationList);
  }

  @Override
  public SmartList<EmployeeEducation> findEmployeeEducationWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getEmployeeEducationMapper());
  }

  @Override
  public int countEmployeeEducationWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countEmployeeEducationWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<EmployeeEducation> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getEmployeeEducationMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<EmployeeEducation> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeEducationMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateEmployeeEducation executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateEmployeeEducation result = new CandidateEmployeeEducation();
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
  public List<EmployeeEducation> search(EmployeeEducationRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected EmployeeEducationMapper mapper() {
    return getEmployeeEducationMapper();
  }

  @Override
  protected EmployeeEducationMapper mapperForClazz(Class<?> clazz) {
    return EmployeeEducationMapper.mapperForClass(clazz);
  }
}
