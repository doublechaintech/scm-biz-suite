package com.doublechaintech.retailscm.consumerorderpaymentgroup;

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

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ConsumerOrderPaymentGroupJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements ConsumerOrderPaymentGroupDAO {

  protected ConsumerOrderDAO consumerOrderDAO;

  public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO) {

    if (consumerOrderDAO == null) {
      throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
    }
    this.consumerOrderDAO = consumerOrderDAO;
  }

  public ConsumerOrderDAO getConsumerOrderDAO() {
    if (this.consumerOrderDAO == null) {
      throw new IllegalStateException(
          "The consumerOrderDAO is not configured yet, please config it some where.");
    }

    return this.consumerOrderDAO;
  }

  /*
  protected ConsumerOrderPaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalConsumerOrderPaymentGroup(accessKey, options);
  }
  */

  public SmartList<ConsumerOrderPaymentGroup> loadAll() {
    return this.loadAll(getConsumerOrderPaymentGroupMapper());
  }

  public Stream<ConsumerOrderPaymentGroup> loadAllAsStream() {
    return this.loadAllAsStream(getConsumerOrderPaymentGroupMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public ConsumerOrderPaymentGroup load(String id, Map<String, Object> options) throws Exception {
    return loadInternalConsumerOrderPaymentGroup(
        ConsumerOrderPaymentGroupTable.withId(id), options);
  }

  public ConsumerOrderPaymentGroup save(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> options) {

    String methodName =
        "save(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options)";

    assertMethodArgumentNotNull(consumerOrderPaymentGroup, methodName, "consumerOrderPaymentGroup");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalConsumerOrderPaymentGroup(consumerOrderPaymentGroup, options);
  }

  public ConsumerOrderPaymentGroup clone(
      String consumerOrderPaymentGroupId, Map<String, Object> options) throws Exception {

    return clone(ConsumerOrderPaymentGroupTable.withId(consumerOrderPaymentGroupId), options);
  }

  protected ConsumerOrderPaymentGroup clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String consumerOrderPaymentGroupId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    ConsumerOrderPaymentGroup newConsumerOrderPaymentGroup =
        loadInternalConsumerOrderPaymentGroup(accessKey, options);
    newConsumerOrderPaymentGroup.setVersion(0);

    saveInternalConsumerOrderPaymentGroup(newConsumerOrderPaymentGroup, options);

    return newConsumerOrderPaymentGroup;
  }

  protected void throwIfHasException(String consumerOrderPaymentGroupId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new ConsumerOrderPaymentGroupVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new ConsumerOrderPaymentGroupNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + consumerOrderPaymentGroupId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public ConsumerOrderPaymentGroup disconnectFromAll(
      String consumerOrderPaymentGroupId, int version) throws Exception {

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
        loadInternalConsumerOrderPaymentGroup(
            ConsumerOrderPaymentGroupTable.withId(consumerOrderPaymentGroupId), emptyOptions());
    consumerOrderPaymentGroup.clearFromAll();
    this.saveConsumerOrderPaymentGroup(consumerOrderPaymentGroup);
    return consumerOrderPaymentGroup;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return ConsumerOrderPaymentGroupTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "consumer_order_payment_group";
  }

  @Override
  protected String getBeanName() {

    return "consumerOrderPaymentGroup";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return ConsumerOrderPaymentGroupTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, ConsumerOrderPaymentGroupTokens.BIZORDER);
  }

  protected boolean isSaveBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, ConsumerOrderPaymentGroupTokens.BIZORDER);
  }

  protected ConsumerOrderPaymentGroupMapper getConsumerOrderPaymentGroupMapper() {
    return new ConsumerOrderPaymentGroupMapper();
  }

  protected ConsumerOrderPaymentGroup extractConsumerOrderPaymentGroup(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
          loadSingleObject(accessKey, getConsumerOrderPaymentGroupMapper());
      return consumerOrderPaymentGroup;
    } catch (EmptyResultDataAccessException e) {
      throw new ConsumerOrderPaymentGroupNotFoundException(
          "ConsumerOrderPaymentGroup(" + accessKey + ") is not found!");
    }
  }

  protected ConsumerOrderPaymentGroup loadInternalConsumerOrderPaymentGroup(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
        extractConsumerOrderPaymentGroup(accessKey, loadOptions);

    if (isExtractBizOrderEnabled(loadOptions)) {
      extractBizOrder(consumerOrderPaymentGroup, loadOptions);
    }

    return consumerOrderPaymentGroup;
  }

  protected ConsumerOrderPaymentGroup extractBizOrder(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> options)
      throws Exception {

    if (consumerOrderPaymentGroup.getBizOrder() == null) {
      return consumerOrderPaymentGroup;
    }
    String bizOrderId = consumerOrderPaymentGroup.getBizOrder().getId();
    if (bizOrderId == null) {
      return consumerOrderPaymentGroup;
    }
    ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId, options);
    if (bizOrder != null) {
      consumerOrderPaymentGroup.setBizOrder(bizOrder);
    }

    return consumerOrderPaymentGroup;
  }

  public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(
      String consumerOrderId, Map<String, Object> options) {

    SmartList<ConsumerOrderPaymentGroup> resultList =
        queryWith(
            ConsumerOrderPaymentGroupTable.COLUMN_BIZ_ORDER,
            consumerOrderId,
            options,
            getConsumerOrderPaymentGroupMapper());
    // analyzeConsumerOrderPaymentGroupByBizOrder(resultList, consumerOrderId, options);
    return resultList;
  }

  public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(
      String consumerOrderId, int start, int count, Map<String, Object> options) {

    SmartList<ConsumerOrderPaymentGroup> resultList =
        queryWithRange(
            ConsumerOrderPaymentGroupTable.COLUMN_BIZ_ORDER,
            consumerOrderId,
            options,
            getConsumerOrderPaymentGroupMapper(),
            start,
            count);
    // analyzeConsumerOrderPaymentGroupByBizOrder(resultList, consumerOrderId, options);
    return resultList;
  }

  public void analyzeConsumerOrderPaymentGroupByBizOrder(
      SmartList<ConsumerOrderPaymentGroup> resultList,
      String consumerOrderId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countConsumerOrderPaymentGroupByBizOrder(
      String consumerOrderId, Map<String, Object> options) {

    return countWith(ConsumerOrderPaymentGroupTable.COLUMN_BIZ_ORDER, consumerOrderId, options);
  }

  @Override
  public Map<String, Integer> countConsumerOrderPaymentGroupByBizOrderIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(ConsumerOrderPaymentGroupTable.COLUMN_BIZ_ORDER, ids, options);
  }

  protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {

    if (!consumerOrderPaymentGroup.isChanged()) {
      return consumerOrderPaymentGroup;
    }

    Beans.dbUtil().cacheCleanUp(consumerOrderPaymentGroup);
    String SQL = this.getSaveConsumerOrderPaymentGroupSQL(consumerOrderPaymentGroup);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveConsumerOrderPaymentGroupParameters(consumerOrderPaymentGroup);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    consumerOrderPaymentGroup.incVersion();
    consumerOrderPaymentGroup.afterSave();
    return consumerOrderPaymentGroup;
  }

  public SmartList<ConsumerOrderPaymentGroup> saveConsumerOrderPaymentGroupList(
      SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,
      Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList);

    batchConsumerOrderPaymentGroupCreate(
        (List<ConsumerOrderPaymentGroup>) lists[CREATE_LIST_INDEX]);
    batchConsumerOrderPaymentGroupUpdate(
        (List<ConsumerOrderPaymentGroup>) lists[UPDATE_LIST_INDEX]);
    batchConsumerOrderPaymentGroupRemove(
        (List<ConsumerOrderPaymentGroup>) lists[REMOVE_LIST_INDEX]);
    batchConsumerOrderPaymentGroupRecover(
        (List<ConsumerOrderPaymentGroup>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (ConsumerOrderPaymentGroup consumerOrderPaymentGroup : consumerOrderPaymentGroupList) {
      if (consumerOrderPaymentGroup.isChanged()) {
        consumerOrderPaymentGroup.incVersion();
        consumerOrderPaymentGroup.afterSave();
      }
      if (consumerOrderPaymentGroup.isToRecover() || consumerOrderPaymentGroup.isToRemove()) {
        consumerOrderPaymentGroup.setVersion(-consumerOrderPaymentGroup.getVersion());
      }
    }

    return consumerOrderPaymentGroupList;
  }

  public SmartList<ConsumerOrderPaymentGroup> removeConsumerOrderPaymentGroupList(
      SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,
      Map<String, Object> options) {

    super.removeList(consumerOrderPaymentGroupList, options);

    return consumerOrderPaymentGroupList;
  }

  protected List<Object[]> prepareConsumerOrderPaymentGroupBatchCreateArgs(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ConsumerOrderPaymentGroup consumerOrderPaymentGroup : consumerOrderPaymentGroupList) {
      Object[] parameters =
          prepareConsumerOrderPaymentGroupCreateParameters(consumerOrderPaymentGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareConsumerOrderPaymentGroupBatchUpdateArgs(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ConsumerOrderPaymentGroup consumerOrderPaymentGroup : consumerOrderPaymentGroupList) {
      if (!consumerOrderPaymentGroup.isChanged()) {
        continue;
      }
      Object[] parameters =
          prepareConsumerOrderPaymentGroupUpdateParameters(consumerOrderPaymentGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareConsumerOrderPaymentGroupBatchRecoverArgs(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ConsumerOrderPaymentGroup consumerOrderPaymentGroup : consumerOrderPaymentGroupList) {
      if (!consumerOrderPaymentGroup.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(consumerOrderPaymentGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareConsumerOrderPaymentGroupBatchRemoveArgs(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ConsumerOrderPaymentGroup consumerOrderPaymentGroup : consumerOrderPaymentGroupList) {
      if (!consumerOrderPaymentGroup.isToRemove()) {
        continue;
      }
      Object[] parameters =
          prepareConsumerOrderPaymentGroupRemoveParameters(consumerOrderPaymentGroup);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchConsumerOrderPaymentGroupCreate(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {
    String SQL = getCreateSQL();
    List<Object[]> args =
        prepareConsumerOrderPaymentGroupBatchCreateArgs(consumerOrderPaymentGroupList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchConsumerOrderPaymentGroupUpdate(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {
    String SQL = getUpdateSQL();
    List<Object[]> args =
        prepareConsumerOrderPaymentGroupBatchUpdateArgs(consumerOrderPaymentGroupList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchConsumerOrderPaymentGroupRemove(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {
    String SQL = getRemoveSQL();
    List<Object[]> args =
        prepareConsumerOrderPaymentGroupBatchRemoveArgs(consumerOrderPaymentGroupList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchConsumerOrderPaymentGroupRecover(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {
    String SQL = getRecoverSQL();
    List<Object[]> args =
        prepareConsumerOrderPaymentGroupBatchRecoverArgs(consumerOrderPaymentGroupList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitConsumerOrderPaymentGroupList(
      List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {

    List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupCreateList =
        new ArrayList<ConsumerOrderPaymentGroup>();
    List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupUpdateList =
        new ArrayList<ConsumerOrderPaymentGroup>();
    List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupRemoveList =
        new ArrayList<ConsumerOrderPaymentGroup>();
    List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupRecoverList =
        new ArrayList<ConsumerOrderPaymentGroup>();

    for (ConsumerOrderPaymentGroup consumerOrderPaymentGroup : consumerOrderPaymentGroupList) {
      if (consumerOrderPaymentGroup.isToRemove()) {
        consumerOrderPaymentGroupRemoveList.add(consumerOrderPaymentGroup);
        continue;
      }
      if (consumerOrderPaymentGroup.isToRecover()) {
        consumerOrderPaymentGroupRecoverList.add(consumerOrderPaymentGroup);
        continue;
      }
      if (isUpdateRequest(consumerOrderPaymentGroup)) {
        if (consumerOrderPaymentGroup.isChanged()) {
          consumerOrderPaymentGroupUpdateList.add(consumerOrderPaymentGroup);
        }
        continue;
      }

      if (consumerOrderPaymentGroup.isChanged()) {
        consumerOrderPaymentGroupCreateList.add(consumerOrderPaymentGroup);
      }
    }

    return new Object[] {
      consumerOrderPaymentGroupCreateList,
      consumerOrderPaymentGroupUpdateList,
      consumerOrderPaymentGroupRemoveList,
      consumerOrderPaymentGroupRecoverList
    };
  }

  protected boolean isUpdateRequest(ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
    return consumerOrderPaymentGroup.getVersion() > 0;
  }

  protected String getSaveConsumerOrderPaymentGroupSQL(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
    if (consumerOrderPaymentGroup.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(consumerOrderPaymentGroup)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveConsumerOrderPaymentGroupParameters(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
    if (consumerOrderPaymentGroup.isToRemove()) {
      return prepareConsumerOrderPaymentGroupRemoveParameters(consumerOrderPaymentGroup);
    }
    if (consumerOrderPaymentGroup.isToRecover()) {
      return prepareRecoverParameters(consumerOrderPaymentGroup);
    }

    if (isUpdateRequest(consumerOrderPaymentGroup)) {
      return prepareConsumerOrderPaymentGroupUpdateParameters(consumerOrderPaymentGroup);
    }
    return prepareConsumerOrderPaymentGroupCreateParameters(consumerOrderPaymentGroup);
  }

  protected Object[] prepareConsumerOrderPaymentGroupRemoveParameters(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
    return super.prepareRemoveParameters(consumerOrderPaymentGroup);
  }

  protected Object[] prepareConsumerOrderPaymentGroupUpdateParameters(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
    Object[] parameters = new Object[6];

    parameters[0] = consumerOrderPaymentGroup.getName();

    if (consumerOrderPaymentGroup.getBizOrder() != null) {
      parameters[1] = consumerOrderPaymentGroup.getBizOrder().getId();
    }

    parameters[2] = consumerOrderPaymentGroup.getCardNumber();

    parameters[3] = consumerOrderPaymentGroup.nextVersion();
    parameters[4] = consumerOrderPaymentGroup.getId();
    parameters[5] = consumerOrderPaymentGroup.getVersion();

    return parameters;
  }

  protected Object[] prepareConsumerOrderPaymentGroupCreateParameters(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
    Object[] parameters = new Object[4];
    if (consumerOrderPaymentGroup.getId() == null) {
      String newConsumerOrderPaymentGroupId = getNextId();
      consumerOrderPaymentGroup.setId(newConsumerOrderPaymentGroupId);
    }
    parameters[0] = consumerOrderPaymentGroup.getId();

    parameters[1] = consumerOrderPaymentGroup.getName();

    if (consumerOrderPaymentGroup.getBizOrder() != null) {
      parameters[2] = consumerOrderPaymentGroup.getBizOrder().getId();
    }

    parameters[3] = consumerOrderPaymentGroup.getCardNumber();

    return parameters;
  }

  protected ConsumerOrderPaymentGroup saveInternalConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> options) {

    if (isSaveBizOrderEnabled(options)) {
      saveBizOrder(consumerOrderPaymentGroup, options);
    }

    saveConsumerOrderPaymentGroup(consumerOrderPaymentGroup);

    return consumerOrderPaymentGroup;
  }

  // ======================================================================================

  protected ConsumerOrderPaymentGroup saveBizOrder(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (consumerOrderPaymentGroup.getBizOrder() == null) {
      return consumerOrderPaymentGroup; // do nothing when it is null
    }

    getConsumerOrderDAO().save(consumerOrderPaymentGroup.getBizOrder(), options);
    return consumerOrderPaymentGroup;
  }

  public ConsumerOrderPaymentGroup present(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> options) {

    return consumerOrderPaymentGroup;
  }

  protected String getTableName() {
    return ConsumerOrderPaymentGroupTable.TABLE_NAME;
  }

  public void enhanceList(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList) {
    this.enhanceListInternal(
        consumerOrderPaymentGroupList, this.getConsumerOrderPaymentGroupMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList =
        ownerEntity.collectRefsWithType(ConsumerOrderPaymentGroup.INTERNAL_TYPE);
    this.enhanceList(consumerOrderPaymentGroupList);
  }

  @Override
  public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getConsumerOrderPaymentGroupMapper());
  }

  @Override
  public int countConsumerOrderPaymentGroupWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countConsumerOrderPaymentGroupWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<ConsumerOrderPaymentGroup> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getConsumerOrderPaymentGroupMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<ConsumerOrderPaymentGroup> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getConsumerOrderPaymentGroupMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateConsumerOrderPaymentGroup executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateConsumerOrderPaymentGroup result = new CandidateConsumerOrderPaymentGroup();
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
  public List<ConsumerOrderPaymentGroup> search(ConsumerOrderPaymentGroupRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected ConsumerOrderPaymentGroupMapper mapper() {
    return getConsumerOrderPaymentGroupMapper();
  }

  @Override
  protected ConsumerOrderPaymentGroupMapper mapperForClazz(Class<?> clazz) {
    return ConsumerOrderPaymentGroupMapper.mapperForClass(clazz);
  }
}
