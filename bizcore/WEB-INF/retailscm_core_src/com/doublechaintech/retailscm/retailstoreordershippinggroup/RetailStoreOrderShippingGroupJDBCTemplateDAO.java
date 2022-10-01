package com.doublechaintech.retailscm.retailstoreordershippinggroup;

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

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreOrderShippingGroupJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements RetailStoreOrderShippingGroupDAO {

  protected RetailStoreOrderDAO retailStoreOrderDAO;

  public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO) {

    if (retailStoreOrderDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
    }
    this.retailStoreOrderDAO = retailStoreOrderDAO;
  }

  public RetailStoreOrderDAO getRetailStoreOrderDAO() {
    if (this.retailStoreOrderDAO == null) {
      throw new IllegalStateException(
          "The retailStoreOrderDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreOrderDAO;
  }

  /*
  protected RetailStoreOrderShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalRetailStoreOrderShippingGroup(accessKey, options);
  }
  */

  public SmartList<RetailStoreOrderShippingGroup> loadAll() {
    return this.loadAll(getRetailStoreOrderShippingGroupMapper());
  }

  public Stream<RetailStoreOrderShippingGroup> loadAllAsStream() {
    return this.loadAllAsStream(getRetailStoreOrderShippingGroupMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public RetailStoreOrderShippingGroup load(String id, Map<String, Object> options)
      throws Exception {
    return loadInternalRetailStoreOrderShippingGroup(
        RetailStoreOrderShippingGroupTable.withId(id), options);
  }

  public RetailStoreOrderShippingGroup save(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> options) {

    String methodName =
        "save(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options)";

    assertMethodArgumentNotNull(
        retailStoreOrderShippingGroup, methodName, "retailStoreOrderShippingGroup");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup, options);
  }

  public RetailStoreOrderShippingGroup clone(
      String retailStoreOrderShippingGroupId, Map<String, Object> options) throws Exception {

    return clone(
        RetailStoreOrderShippingGroupTable.withId(retailStoreOrderShippingGroupId), options);
  }

  protected RetailStoreOrderShippingGroup clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String retailStoreOrderShippingGroupId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    RetailStoreOrderShippingGroup newRetailStoreOrderShippingGroup =
        loadInternalRetailStoreOrderShippingGroup(accessKey, options);
    newRetailStoreOrderShippingGroup.setVersion(0);

    saveInternalRetailStoreOrderShippingGroup(newRetailStoreOrderShippingGroup, options);

    return newRetailStoreOrderShippingGroup;
  }

  protected void throwIfHasException(String retailStoreOrderShippingGroupId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new RetailStoreOrderShippingGroupVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new RetailStoreOrderShippingGroupNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + retailStoreOrderShippingGroupId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public RetailStoreOrderShippingGroup disconnectFromAll(
      String retailStoreOrderShippingGroupId, int version) throws Exception {

    RetailStoreOrderShippingGroup retailStoreOrderShippingGroup =
        loadInternalRetailStoreOrderShippingGroup(
            RetailStoreOrderShippingGroupTable.withId(retailStoreOrderShippingGroupId),
            emptyOptions());
    retailStoreOrderShippingGroup.clearFromAll();
    this.saveRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup);
    return retailStoreOrderShippingGroup;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return RetailStoreOrderShippingGroupTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "retail_store_order_shipping_group";
  }

  @Override
  protected String getBeanName() {

    return "retailStoreOrderShippingGroup";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return RetailStoreOrderShippingGroupTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreOrderShippingGroupTokens.BIZORDER);
  }

  protected boolean isSaveBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreOrderShippingGroupTokens.BIZORDER);
  }

  protected RetailStoreOrderShippingGroupMapper getRetailStoreOrderShippingGroupMapper() {
    return new RetailStoreOrderShippingGroupMapper();
  }

  protected RetailStoreOrderShippingGroup extractRetailStoreOrderShippingGroup(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup =
          loadSingleObject(accessKey, getRetailStoreOrderShippingGroupMapper());
      return retailStoreOrderShippingGroup;
    } catch (EmptyResultDataAccessException e) {
      throw new RetailStoreOrderShippingGroupNotFoundException(
          "RetailStoreOrderShippingGroup(" + accessKey + ") is not found!");
    }
  }

  protected RetailStoreOrderShippingGroup loadInternalRetailStoreOrderShippingGroup(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    RetailStoreOrderShippingGroup retailStoreOrderShippingGroup =
        extractRetailStoreOrderShippingGroup(accessKey, loadOptions);

    if (isExtractBizOrderEnabled(loadOptions)) {
      extractBizOrder(retailStoreOrderShippingGroup, loadOptions);
    }

    return retailStoreOrderShippingGroup;
  }

  protected RetailStoreOrderShippingGroup extractBizOrder(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> options)
      throws Exception {

    if (retailStoreOrderShippingGroup.getBizOrder() == null) {
      return retailStoreOrderShippingGroup;
    }
    String bizOrderId = retailStoreOrderShippingGroup.getBizOrder().getId();
    if (bizOrderId == null) {
      return retailStoreOrderShippingGroup;
    }
    RetailStoreOrder bizOrder = getRetailStoreOrderDAO().load(bizOrderId, options);
    if (bizOrder != null) {
      retailStoreOrderShippingGroup.setBizOrder(bizOrder);
    }

    return retailStoreOrderShippingGroup;
  }

  public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(
      String retailStoreOrderId, Map<String, Object> options) {

    SmartList<RetailStoreOrderShippingGroup> resultList =
        queryWith(
            RetailStoreOrderShippingGroupTable.COLUMN_BIZ_ORDER,
            retailStoreOrderId,
            options,
            getRetailStoreOrderShippingGroupMapper());
    // analyzeRetailStoreOrderShippingGroupByBizOrder(resultList, retailStoreOrderId, options);
    return resultList;
  }

  public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(
      String retailStoreOrderId, int start, int count, Map<String, Object> options) {

    SmartList<RetailStoreOrderShippingGroup> resultList =
        queryWithRange(
            RetailStoreOrderShippingGroupTable.COLUMN_BIZ_ORDER,
            retailStoreOrderId,
            options,
            getRetailStoreOrderShippingGroupMapper(),
            start,
            count);
    // analyzeRetailStoreOrderShippingGroupByBizOrder(resultList, retailStoreOrderId, options);
    return resultList;
  }

  public void analyzeRetailStoreOrderShippingGroupByBizOrder(
      SmartList<RetailStoreOrderShippingGroup> resultList,
      String retailStoreOrderId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countRetailStoreOrderShippingGroupByBizOrder(
      String retailStoreOrderId, Map<String, Object> options) {

    return countWith(
        RetailStoreOrderShippingGroupTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options);
  }

  @Override
  public Map<String, Integer> countRetailStoreOrderShippingGroupByBizOrderIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(RetailStoreOrderShippingGroupTable.COLUMN_BIZ_ORDER, ids, options);
  }

  protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {

    if (!retailStoreOrderShippingGroup.isChanged()) {
      return retailStoreOrderShippingGroup;
    }

    Beans.dbUtil().cacheCleanUp(retailStoreOrderShippingGroup);
    String SQL = this.getSaveRetailStoreOrderShippingGroupSQL(retailStoreOrderShippingGroup);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters =
        getSaveRetailStoreOrderShippingGroupParameters(retailStoreOrderShippingGroup);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    retailStoreOrderShippingGroup.incVersion();
    retailStoreOrderShippingGroup.afterSave();
    return retailStoreOrderShippingGroup;
  }

  public SmartList<RetailStoreOrderShippingGroup> saveRetailStoreOrderShippingGroupList(
      SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,
      Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList);

    batchRetailStoreOrderShippingGroupCreate(
        (List<RetailStoreOrderShippingGroup>) lists[CREATE_LIST_INDEX]);
    batchRetailStoreOrderShippingGroupUpdate(
        (List<RetailStoreOrderShippingGroup>) lists[UPDATE_LIST_INDEX]);
    batchRetailStoreOrderShippingGroupRemove(
        (List<RetailStoreOrderShippingGroup>) lists[REMOVE_LIST_INDEX]);
    batchRetailStoreOrderShippingGroupRecover(
        (List<RetailStoreOrderShippingGroup>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (RetailStoreOrderShippingGroup retailStoreOrderShippingGroup :
        retailStoreOrderShippingGroupList) {
      if (retailStoreOrderShippingGroup.isChanged()) {
        retailStoreOrderShippingGroup.incVersion();
        retailStoreOrderShippingGroup.afterSave();
      }
      if (retailStoreOrderShippingGroup.isToRecover()
          || retailStoreOrderShippingGroup.isToRemove()) {
        retailStoreOrderShippingGroup.setVersion(-retailStoreOrderShippingGroup.getVersion());
      }
    }

    return retailStoreOrderShippingGroupList;
  }

  public SmartList<RetailStoreOrderShippingGroup> removeRetailStoreOrderShippingGroupList(
      SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,
      Map<String, Object> options) {

    super.removeList(retailStoreOrderShippingGroupList, options);

    return retailStoreOrderShippingGroupList;
  }

  protected List<Object[]> prepareRetailStoreOrderShippingGroupBatchCreateArgs(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOrderShippingGroup retailStoreOrderShippingGroup :
        retailStoreOrderShippingGroupList) {
      Object[] parameters =
          prepareRetailStoreOrderShippingGroupCreateParameters(retailStoreOrderShippingGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreOrderShippingGroupBatchUpdateArgs(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOrderShippingGroup retailStoreOrderShippingGroup :
        retailStoreOrderShippingGroupList) {
      if (!retailStoreOrderShippingGroup.isChanged()) {
        continue;
      }
      Object[] parameters =
          prepareRetailStoreOrderShippingGroupUpdateParameters(retailStoreOrderShippingGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreOrderShippingGroupBatchRecoverArgs(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOrderShippingGroup retailStoreOrderShippingGroup :
        retailStoreOrderShippingGroupList) {
      if (!retailStoreOrderShippingGroup.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(retailStoreOrderShippingGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreOrderShippingGroupBatchRemoveArgs(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOrderShippingGroup retailStoreOrderShippingGroup :
        retailStoreOrderShippingGroupList) {
      if (!retailStoreOrderShippingGroup.isToRemove()) {
        continue;
      }
      Object[] parameters =
          prepareRetailStoreOrderShippingGroupRemoveParameters(retailStoreOrderShippingGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchRetailStoreOrderShippingGroupCreate(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {
    String SQL = getCreateSQL();
    List<Object[]> args =
        prepareRetailStoreOrderShippingGroupBatchCreateArgs(retailStoreOrderShippingGroupList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchRetailStoreOrderShippingGroupUpdate(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {
    String SQL = getUpdateSQL();
    List<Object[]> args =
        prepareRetailStoreOrderShippingGroupBatchUpdateArgs(retailStoreOrderShippingGroupList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreOrderShippingGroupRemove(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {
    String SQL = getRemoveSQL();
    List<Object[]> args =
        prepareRetailStoreOrderShippingGroupBatchRemoveArgs(retailStoreOrderShippingGroupList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreOrderShippingGroupRecover(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {
    String SQL = getRecoverSQL();
    List<Object[]> args =
        prepareRetailStoreOrderShippingGroupBatchRecoverArgs(retailStoreOrderShippingGroupList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitRetailStoreOrderShippingGroupList(
      List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {

    List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupCreateList =
        new ArrayList<RetailStoreOrderShippingGroup>();
    List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupUpdateList =
        new ArrayList<RetailStoreOrderShippingGroup>();
    List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupRemoveList =
        new ArrayList<RetailStoreOrderShippingGroup>();
    List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupRecoverList =
        new ArrayList<RetailStoreOrderShippingGroup>();

    for (RetailStoreOrderShippingGroup retailStoreOrderShippingGroup :
        retailStoreOrderShippingGroupList) {
      if (retailStoreOrderShippingGroup.isToRemove()) {
        retailStoreOrderShippingGroupRemoveList.add(retailStoreOrderShippingGroup);
        continue;
      }
      if (retailStoreOrderShippingGroup.isToRecover()) {
        retailStoreOrderShippingGroupRecoverList.add(retailStoreOrderShippingGroup);
        continue;
      }
      if (isUpdateRequest(retailStoreOrderShippingGroup)) {
        if (retailStoreOrderShippingGroup.isChanged()) {
          retailStoreOrderShippingGroupUpdateList.add(retailStoreOrderShippingGroup);
        }
        continue;
      }

      if (retailStoreOrderShippingGroup.isChanged()) {
        retailStoreOrderShippingGroupCreateList.add(retailStoreOrderShippingGroup);
      }
    }

    return new Object[] {
      retailStoreOrderShippingGroupCreateList,
      retailStoreOrderShippingGroupUpdateList,
      retailStoreOrderShippingGroupRemoveList,
      retailStoreOrderShippingGroupRecoverList
    };
  }

  protected boolean isUpdateRequest(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
    return retailStoreOrderShippingGroup.getVersion() > 0;
  }

  protected String getSaveRetailStoreOrderShippingGroupSQL(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
    if (retailStoreOrderShippingGroup.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(retailStoreOrderShippingGroup)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveRetailStoreOrderShippingGroupParameters(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
    if (retailStoreOrderShippingGroup.isToRemove()) {
      return prepareRetailStoreOrderShippingGroupRemoveParameters(retailStoreOrderShippingGroup);
    }
    if (retailStoreOrderShippingGroup.isToRecover()) {
      return prepareRecoverParameters(retailStoreOrderShippingGroup);
    }

    if (isUpdateRequest(retailStoreOrderShippingGroup)) {
      return prepareRetailStoreOrderShippingGroupUpdateParameters(retailStoreOrderShippingGroup);
    }
    return prepareRetailStoreOrderShippingGroupCreateParameters(retailStoreOrderShippingGroup);
  }

  protected Object[] prepareRetailStoreOrderShippingGroupRemoveParameters(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
    return super.prepareRemoveParameters(retailStoreOrderShippingGroup);
  }

  protected Object[] prepareRetailStoreOrderShippingGroupUpdateParameters(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
    Object[] parameters = new Object[6];

    parameters[0] = retailStoreOrderShippingGroup.getName();

    if (retailStoreOrderShippingGroup.getBizOrder() != null) {
      parameters[1] = retailStoreOrderShippingGroup.getBizOrder().getId();
    }

    parameters[2] = retailStoreOrderShippingGroup.getAmount();

    parameters[3] = retailStoreOrderShippingGroup.nextVersion();
    parameters[4] = retailStoreOrderShippingGroup.getId();
    parameters[5] = retailStoreOrderShippingGroup.getVersion();

    return parameters;
  }

  protected Object[] prepareRetailStoreOrderShippingGroupCreateParameters(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
    Object[] parameters = new Object[4];
    if (retailStoreOrderShippingGroup.getId() == null) {
      String newRetailStoreOrderShippingGroupId = getNextId();
      retailStoreOrderShippingGroup.setId(newRetailStoreOrderShippingGroupId);
    }
    parameters[0] = retailStoreOrderShippingGroup.getId();

    parameters[1] = retailStoreOrderShippingGroup.getName();

    if (retailStoreOrderShippingGroup.getBizOrder() != null) {
      parameters[2] = retailStoreOrderShippingGroup.getBizOrder().getId();
    }

    parameters[3] = retailStoreOrderShippingGroup.getAmount();

    return parameters;
  }

  protected RetailStoreOrderShippingGroup saveInternalRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> options) {

    if (isSaveBizOrderEnabled(options)) {
      saveBizOrder(retailStoreOrderShippingGroup, options);
    }

    saveRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup);

    return retailStoreOrderShippingGroup;
  }

  // ======================================================================================

  protected RetailStoreOrderShippingGroup saveBizOrder(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (retailStoreOrderShippingGroup.getBizOrder() == null) {
      return retailStoreOrderShippingGroup; // do nothing when it is null
    }

    getRetailStoreOrderDAO().save(retailStoreOrderShippingGroup.getBizOrder(), options);
    return retailStoreOrderShippingGroup;
  }

  public RetailStoreOrderShippingGroup present(
      RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> options) {

    return retailStoreOrderShippingGroup;
  }

  protected String getTableName() {
    return RetailStoreOrderShippingGroupTable.TABLE_NAME;
  }

  public void enhanceList(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList) {
    this.enhanceListInternal(
        retailStoreOrderShippingGroupList, this.getRetailStoreOrderShippingGroupMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList =
        ownerEntity.collectRefsWithType(RetailStoreOrderShippingGroup.INTERNAL_TYPE);
    this.enhanceList(retailStoreOrderShippingGroupList);
  }

  @Override
  public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getRetailStoreOrderShippingGroupMapper());
  }

  @Override
  public int countRetailStoreOrderShippingGroupWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countRetailStoreOrderShippingGroupWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<RetailStoreOrderShippingGroup> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getRetailStoreOrderShippingGroupMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<RetailStoreOrderShippingGroup> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreOrderShippingGroupMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateRetailStoreOrderShippingGroup executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateRetailStoreOrderShippingGroup result = new CandidateRetailStoreOrderShippingGroup();
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
  public List<RetailStoreOrderShippingGroup> search(RetailStoreOrderShippingGroupRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreOrderShippingGroupMapper mapper() {
    return getRetailStoreOrderShippingGroupMapper();
  }

  @Override
  protected RetailStoreOrderShippingGroupMapper mapperForClazz(Class<?> clazz) {
    return RetailStoreOrderShippingGroupMapper.mapperForClass(clazz);
  }
}
