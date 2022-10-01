package com.doublechaintech.retailscm.uiaction;

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

import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class UiActionJDBCTemplateDAO extends RetailscmBaseDAOImpl implements UiActionDAO {

  protected PageDAO pageDAO;

  public void setPageDAO(PageDAO pageDAO) {

    if (pageDAO == null) {
      throw new IllegalStateException("Do not try to set pageDAO to null.");
    }
    this.pageDAO = pageDAO;
  }

  public PageDAO getPageDAO() {
    if (this.pageDAO == null) {
      throw new IllegalStateException(
          "The pageDAO is not configured yet, please config it some where.");
    }

    return this.pageDAO;
  }

  /*
  protected UiAction load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalUiAction(accessKey, options);
  }
  */

  public SmartList<UiAction> loadAll() {
    return this.loadAll(getUiActionMapper());
  }

  public Stream<UiAction> loadAllAsStream() {
    return this.loadAllAsStream(getUiActionMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public UiAction load(String id, Map<String, Object> options) throws Exception {
    return loadInternalUiAction(UiActionTable.withId(id), options);
  }

  public UiAction save(UiAction uiAction, Map<String, Object> options) {

    String methodName = "save(UiAction uiAction,Map<String,Object> options)";

    assertMethodArgumentNotNull(uiAction, methodName, "uiAction");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalUiAction(uiAction, options);
  }

  public UiAction clone(String uiActionId, Map<String, Object> options) throws Exception {

    return clone(UiActionTable.withId(uiActionId), options);
  }

  protected UiAction clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String uiActionId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    UiAction newUiAction = loadInternalUiAction(accessKey, options);
    newUiAction.setVersion(0);

    saveInternalUiAction(newUiAction, options);

    return newUiAction;
  }

  protected void throwIfHasException(String uiActionId, int version, int count) throws Exception {
    if (count == 1) {
      throw new UiActionVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new UiActionNotFoundException(
          "The " + this.getTableName() + "(" + uiActionId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public UiAction disconnectFromAll(String uiActionId, int version) throws Exception {

    UiAction uiAction = loadInternalUiAction(UiActionTable.withId(uiActionId), emptyOptions());
    uiAction.clearFromAll();
    this.saveUiAction(uiAction);
    return uiAction;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return UiActionTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "ui_action";
  }

  @Override
  protected String getBeanName() {

    return "uiAction";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return UiActionTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractPageEnabled(Map<String, Object> options) {

    return checkOptions(options, UiActionTokens.PAGE);
  }

  protected boolean isSavePageEnabled(Map<String, Object> options) {

    return checkOptions(options, UiActionTokens.PAGE);
  }

  protected UiActionMapper getUiActionMapper() {
    return new UiActionMapper();
  }

  protected UiAction extractUiAction(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      UiAction uiAction = loadSingleObject(accessKey, getUiActionMapper());
      return uiAction;
    } catch (EmptyResultDataAccessException e) {
      throw new UiActionNotFoundException("UiAction(" + accessKey + ") is not found!");
    }
  }

  protected UiAction loadInternalUiAction(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    UiAction uiAction = extractUiAction(accessKey, loadOptions);

    if (isExtractPageEnabled(loadOptions)) {
      extractPage(uiAction, loadOptions);
    }

    return uiAction;
  }

  protected UiAction extractPage(UiAction uiAction, Map<String, Object> options) throws Exception {

    if (uiAction.getPage() == null) {
      return uiAction;
    }
    String pageId = uiAction.getPage().getId();
    if (pageId == null) {
      return uiAction;
    }
    Page page = getPageDAO().load(pageId, options);
    if (page != null) {
      uiAction.setPage(page);
    }

    return uiAction;
  }

  public SmartList<UiAction> findUiActionByPage(String pageId, Map<String, Object> options) {

    SmartList<UiAction> resultList =
        queryWith(UiActionTable.COLUMN_PAGE, pageId, options, getUiActionMapper());
    // analyzeUiActionByPage(resultList, pageId, options);
    return resultList;
  }

  public SmartList<UiAction> findUiActionByPage(
      String pageId, int start, int count, Map<String, Object> options) {

    SmartList<UiAction> resultList =
        queryWithRange(
            UiActionTable.COLUMN_PAGE, pageId, options, getUiActionMapper(), start, count);
    // analyzeUiActionByPage(resultList, pageId, options);
    return resultList;
  }

  public void analyzeUiActionByPage(
      SmartList<UiAction> resultList, String pageId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countUiActionByPage(String pageId, Map<String, Object> options) {

    return countWith(UiActionTable.COLUMN_PAGE, pageId, options);
  }

  @Override
  public Map<String, Integer> countUiActionByPageIds(String[] ids, Map<String, Object> options) {
    return countWithIds(UiActionTable.COLUMN_PAGE, ids, options);
  }

  protected UiAction saveUiAction(UiAction uiAction) {

    if (!uiAction.isChanged()) {
      return uiAction;
    }

    Beans.dbUtil().cacheCleanUp(uiAction);
    String SQL = this.getSaveUiActionSQL(uiAction);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveUiActionParameters(uiAction);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    uiAction.incVersion();
    uiAction.afterSave();
    return uiAction;
  }

  public SmartList<UiAction> saveUiActionList(
      SmartList<UiAction> uiActionList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitUiActionList(uiActionList);

    batchUiActionCreate((List<UiAction>) lists[CREATE_LIST_INDEX]);
    batchUiActionUpdate((List<UiAction>) lists[UPDATE_LIST_INDEX]);
    batchUiActionRemove((List<UiAction>) lists[REMOVE_LIST_INDEX]);
    batchUiActionRecover((List<UiAction>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (UiAction uiAction : uiActionList) {
      if (uiAction.isChanged()) {
        uiAction.incVersion();
        uiAction.afterSave();
      }
      if (uiAction.isToRecover() || uiAction.isToRemove()) {
        uiAction.setVersion(-uiAction.getVersion());
      }
    }

    return uiActionList;
  }

  public SmartList<UiAction> removeUiActionList(
      SmartList<UiAction> uiActionList, Map<String, Object> options) {

    super.removeList(uiActionList, options);

    return uiActionList;
  }

  protected List<Object[]> prepareUiActionBatchCreateArgs(List<UiAction> uiActionList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UiAction uiAction : uiActionList) {
      Object[] parameters = prepareUiActionCreateParameters(uiAction);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareUiActionBatchUpdateArgs(List<UiAction> uiActionList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UiAction uiAction : uiActionList) {
      if (!uiAction.isChanged()) {
        continue;
      }
      Object[] parameters = prepareUiActionUpdateParameters(uiAction);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareUiActionBatchRecoverArgs(List<UiAction> uiActionList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UiAction uiAction : uiActionList) {
      if (!uiAction.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(uiAction);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareUiActionBatchRemoveArgs(List<UiAction> uiActionList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UiAction uiAction : uiActionList) {
      if (!uiAction.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareUiActionRemoveParameters(uiAction);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchUiActionCreate(List<UiAction> uiActionList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareUiActionBatchCreateArgs(uiActionList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchUiActionUpdate(List<UiAction> uiActionList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareUiActionBatchUpdateArgs(uiActionList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchUiActionRemove(List<UiAction> uiActionList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareUiActionBatchRemoveArgs(uiActionList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchUiActionRecover(List<UiAction> uiActionList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareUiActionBatchRecoverArgs(uiActionList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitUiActionList(List<UiAction> uiActionList) {

    List<UiAction> uiActionCreateList = new ArrayList<UiAction>();
    List<UiAction> uiActionUpdateList = new ArrayList<UiAction>();
    List<UiAction> uiActionRemoveList = new ArrayList<UiAction>();
    List<UiAction> uiActionRecoverList = new ArrayList<UiAction>();

    for (UiAction uiAction : uiActionList) {
      if (uiAction.isToRemove()) {
        uiActionRemoveList.add(uiAction);
        continue;
      }
      if (uiAction.isToRecover()) {
        uiActionRecoverList.add(uiAction);
        continue;
      }
      if (isUpdateRequest(uiAction)) {
        if (uiAction.isChanged()) {
          uiActionUpdateList.add(uiAction);
        }
        continue;
      }

      if (uiAction.isChanged()) {
        uiActionCreateList.add(uiAction);
      }
    }

    return new Object[] {
      uiActionCreateList, uiActionUpdateList, uiActionRemoveList, uiActionRecoverList
    };
  }

  protected boolean isUpdateRequest(UiAction uiAction) {
    return uiAction.getVersion() > 0;
  }

  protected String getSaveUiActionSQL(UiAction uiAction) {
    if (uiAction.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(uiAction)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveUiActionParameters(UiAction uiAction) {
    if (uiAction.isToRemove()) {
      return prepareUiActionRemoveParameters(uiAction);
    }
    if (uiAction.isToRecover()) {
      return prepareRecoverParameters(uiAction);
    }

    if (isUpdateRequest(uiAction)) {
      return prepareUiActionUpdateParameters(uiAction);
    }
    return prepareUiActionCreateParameters(uiAction);
  }

  protected Object[] prepareUiActionRemoveParameters(UiAction uiAction) {
    return super.prepareRemoveParameters(uiAction);
  }

  protected Object[] prepareUiActionUpdateParameters(UiAction uiAction) {
    Object[] parameters = new Object[12];

    parameters[0] = uiAction.getCode();

    parameters[1] = uiAction.getIcon();

    parameters[2] = uiAction.getTitle();

    parameters[3] = uiAction.getDisplayOrder();

    parameters[4] = uiAction.getBrief();

    parameters[5] = uiAction.getImageUrl();

    parameters[6] = uiAction.getLinkToUrl();

    parameters[7] = uiAction.getExtraData();

    if (uiAction.getPage() != null) {
      parameters[8] = uiAction.getPage().getId();
    }

    parameters[9] = uiAction.nextVersion();
    parameters[10] = uiAction.getId();
    parameters[11] = uiAction.getVersion();

    return parameters;
  }

  protected Object[] prepareUiActionCreateParameters(UiAction uiAction) {
    Object[] parameters = new Object[10];
    if (uiAction.getId() == null) {
      String newUiActionId = getNextId();
      uiAction.setId(newUiActionId);
    }
    parameters[0] = uiAction.getId();

    parameters[1] = uiAction.getCode();

    parameters[2] = uiAction.getIcon();

    parameters[3] = uiAction.getTitle();

    parameters[4] = uiAction.getDisplayOrder();

    parameters[5] = uiAction.getBrief();

    parameters[6] = uiAction.getImageUrl();

    parameters[7] = uiAction.getLinkToUrl();

    parameters[8] = uiAction.getExtraData();

    if (uiAction.getPage() != null) {
      parameters[9] = uiAction.getPage().getId();
    }

    return parameters;
  }

  protected UiAction saveInternalUiAction(UiAction uiAction, Map<String, Object> options) {

    if (isSavePageEnabled(options)) {
      savePage(uiAction, options);
    }

    saveUiAction(uiAction);

    return uiAction;
  }

  // ======================================================================================

  protected UiAction savePage(UiAction uiAction, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (uiAction.getPage() == null) {
      return uiAction; // do nothing when it is null
    }

    getPageDAO().save(uiAction.getPage(), options);
    return uiAction;
  }

  public UiAction present(UiAction uiAction, Map<String, Object> options) {

    return uiAction;
  }

  protected String getTableName() {
    return UiActionTable.TABLE_NAME;
  }

  public void enhanceList(List<UiAction> uiActionList) {
    this.enhanceListInternal(uiActionList, this.getUiActionMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<UiAction> uiActionList = ownerEntity.collectRefsWithType(UiAction.INTERNAL_TYPE);
    this.enhanceList(uiActionList);
  }

  @Override
  public SmartList<UiAction> findUiActionWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getUiActionMapper());
  }

  @Override
  public int countUiActionWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countUiActionWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<UiAction> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getUiActionMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<UiAction> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getUiActionMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateUiAction executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateUiAction result = new CandidateUiAction();
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
  public List<UiAction> search(UiActionRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected UiActionMapper mapper() {
    return getUiActionMapper();
  }

  @Override
  protected UiActionMapper mapperForClazz(Class<?> clazz) {
    return UiActionMapper.mapperForClass(clazz);
  }
}
