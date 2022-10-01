package com.doublechaintech.retailscm.supplyorderlineitem;

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

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class SupplyOrderLineItemJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements SupplyOrderLineItemDAO {

  protected SupplyOrderDAO supplyOrderDAO;

  public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO) {

    if (supplyOrderDAO == null) {
      throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
    }
    this.supplyOrderDAO = supplyOrderDAO;
  }

  public SupplyOrderDAO getSupplyOrderDAO() {
    if (this.supplyOrderDAO == null) {
      throw new IllegalStateException(
          "The supplyOrderDAO is not configured yet, please config it some where.");
    }

    return this.supplyOrderDAO;
  }

  /*
  protected SupplyOrderLineItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalSupplyOrderLineItem(accessKey, options);
  }
  */

  public SmartList<SupplyOrderLineItem> loadAll() {
    return this.loadAll(getSupplyOrderLineItemMapper());
  }

  public Stream<SupplyOrderLineItem> loadAllAsStream() {
    return this.loadAllAsStream(getSupplyOrderLineItemMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public SupplyOrderLineItem load(String id, Map<String, Object> options) throws Exception {
    return loadInternalSupplyOrderLineItem(SupplyOrderLineItemTable.withId(id), options);
  }

  public SupplyOrderLineItem save(
      SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> options) {

    String methodName = "save(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options)";

    assertMethodArgumentNotNull(supplyOrderLineItem, methodName, "supplyOrderLineItem");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalSupplyOrderLineItem(supplyOrderLineItem, options);
  }

  public SupplyOrderLineItem clone(String supplyOrderLineItemId, Map<String, Object> options)
      throws Exception {

    return clone(SupplyOrderLineItemTable.withId(supplyOrderLineItemId), options);
  }

  protected SupplyOrderLineItem clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String supplyOrderLineItemId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    SupplyOrderLineItem newSupplyOrderLineItem =
        loadInternalSupplyOrderLineItem(accessKey, options);
    newSupplyOrderLineItem.setVersion(0);

    saveInternalSupplyOrderLineItem(newSupplyOrderLineItem, options);

    return newSupplyOrderLineItem;
  }

  protected void throwIfHasException(String supplyOrderLineItemId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new SupplyOrderLineItemVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new SupplyOrderLineItemNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + supplyOrderLineItemId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public SupplyOrderLineItem disconnectFromAll(String supplyOrderLineItemId, int version)
      throws Exception {

    SupplyOrderLineItem supplyOrderLineItem =
        loadInternalSupplyOrderLineItem(
            SupplyOrderLineItemTable.withId(supplyOrderLineItemId), emptyOptions());
    supplyOrderLineItem.clearFromAll();
    this.saveSupplyOrderLineItem(supplyOrderLineItem);
    return supplyOrderLineItem;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return SupplyOrderLineItemTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "supply_order_line_item";
  }

  @Override
  protected String getBeanName() {

    return "supplyOrderLineItem";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return SupplyOrderLineItemTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, SupplyOrderLineItemTokens.BIZORDER);
  }

  protected boolean isSaveBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, SupplyOrderLineItemTokens.BIZORDER);
  }

  protected SupplyOrderLineItemMapper getSupplyOrderLineItemMapper() {
    return new SupplyOrderLineItemMapper();
  }

  protected SupplyOrderLineItem extractSupplyOrderLineItem(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      SupplyOrderLineItem supplyOrderLineItem =
          loadSingleObject(accessKey, getSupplyOrderLineItemMapper());
      return supplyOrderLineItem;
    } catch (EmptyResultDataAccessException e) {
      throw new SupplyOrderLineItemNotFoundException(
          "SupplyOrderLineItem(" + accessKey + ") is not found!");
    }
  }

  protected SupplyOrderLineItem loadInternalSupplyOrderLineItem(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    SupplyOrderLineItem supplyOrderLineItem = extractSupplyOrderLineItem(accessKey, loadOptions);

    if (isExtractBizOrderEnabled(loadOptions)) {
      extractBizOrder(supplyOrderLineItem, loadOptions);
    }

    return supplyOrderLineItem;
  }

  protected SupplyOrderLineItem extractBizOrder(
      SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> options) throws Exception {

    if (supplyOrderLineItem.getBizOrder() == null) {
      return supplyOrderLineItem;
    }
    String bizOrderId = supplyOrderLineItem.getBizOrder().getId();
    if (bizOrderId == null) {
      return supplyOrderLineItem;
    }
    SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId, options);
    if (bizOrder != null) {
      supplyOrderLineItem.setBizOrder(bizOrder);
    }

    return supplyOrderLineItem;
  }

  public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(
      String supplyOrderId, Map<String, Object> options) {

    SmartList<SupplyOrderLineItem> resultList =
        queryWith(
            SupplyOrderLineItemTable.COLUMN_BIZ_ORDER,
            supplyOrderId,
            options,
            getSupplyOrderLineItemMapper());
    // analyzeSupplyOrderLineItemByBizOrder(resultList, supplyOrderId, options);
    return resultList;
  }

  public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(
      String supplyOrderId, int start, int count, Map<String, Object> options) {

    SmartList<SupplyOrderLineItem> resultList =
        queryWithRange(
            SupplyOrderLineItemTable.COLUMN_BIZ_ORDER,
            supplyOrderId,
            options,
            getSupplyOrderLineItemMapper(),
            start,
            count);
    // analyzeSupplyOrderLineItemByBizOrder(resultList, supplyOrderId, options);
    return resultList;
  }

  public void analyzeSupplyOrderLineItemByBizOrder(
      SmartList<SupplyOrderLineItem> resultList,
      String supplyOrderId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countSupplyOrderLineItemByBizOrder(String supplyOrderId, Map<String, Object> options) {

    return countWith(SupplyOrderLineItemTable.COLUMN_BIZ_ORDER, supplyOrderId, options);
  }

  @Override
  public Map<String, Integer> countSupplyOrderLineItemByBizOrderIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(SupplyOrderLineItemTable.COLUMN_BIZ_ORDER, ids, options);
  }

  protected SupplyOrderLineItem saveSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem) {

    if (!supplyOrderLineItem.isChanged()) {
      return supplyOrderLineItem;
    }

    Beans.dbUtil().cacheCleanUp(supplyOrderLineItem);
    String SQL = this.getSaveSupplyOrderLineItemSQL(supplyOrderLineItem);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveSupplyOrderLineItemParameters(supplyOrderLineItem);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    supplyOrderLineItem.incVersion();
    supplyOrderLineItem.afterSave();
    return supplyOrderLineItem;
  }

  public SmartList<SupplyOrderLineItem> saveSupplyOrderLineItemList(
      SmartList<SupplyOrderLineItem> supplyOrderLineItemList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitSupplyOrderLineItemList(supplyOrderLineItemList);

    batchSupplyOrderLineItemCreate((List<SupplyOrderLineItem>) lists[CREATE_LIST_INDEX]);
    batchSupplyOrderLineItemUpdate((List<SupplyOrderLineItem>) lists[UPDATE_LIST_INDEX]);
    batchSupplyOrderLineItemRemove((List<SupplyOrderLineItem>) lists[REMOVE_LIST_INDEX]);
    batchSupplyOrderLineItemRecover((List<SupplyOrderLineItem>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (SupplyOrderLineItem supplyOrderLineItem : supplyOrderLineItemList) {
      if (supplyOrderLineItem.isChanged()) {
        supplyOrderLineItem.incVersion();
        supplyOrderLineItem.afterSave();
      }
      if (supplyOrderLineItem.isToRecover() || supplyOrderLineItem.isToRemove()) {
        supplyOrderLineItem.setVersion(-supplyOrderLineItem.getVersion());
      }
    }

    return supplyOrderLineItemList;
  }

  public SmartList<SupplyOrderLineItem> removeSupplyOrderLineItemList(
      SmartList<SupplyOrderLineItem> supplyOrderLineItemList, Map<String, Object> options) {

    super.removeList(supplyOrderLineItemList, options);

    return supplyOrderLineItemList;
  }

  protected List<Object[]> prepareSupplyOrderLineItemBatchCreateArgs(
      List<SupplyOrderLineItem> supplyOrderLineItemList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SupplyOrderLineItem supplyOrderLineItem : supplyOrderLineItemList) {
      Object[] parameters = prepareSupplyOrderLineItemCreateParameters(supplyOrderLineItem);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareSupplyOrderLineItemBatchUpdateArgs(
      List<SupplyOrderLineItem> supplyOrderLineItemList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SupplyOrderLineItem supplyOrderLineItem : supplyOrderLineItemList) {
      if (!supplyOrderLineItem.isChanged()) {
        continue;
      }
      Object[] parameters = prepareSupplyOrderLineItemUpdateParameters(supplyOrderLineItem);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareSupplyOrderLineItemBatchRecoverArgs(
      List<SupplyOrderLineItem> supplyOrderLineItemList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SupplyOrderLineItem supplyOrderLineItem : supplyOrderLineItemList) {
      if (!supplyOrderLineItem.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(supplyOrderLineItem);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareSupplyOrderLineItemBatchRemoveArgs(
      List<SupplyOrderLineItem> supplyOrderLineItemList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SupplyOrderLineItem supplyOrderLineItem : supplyOrderLineItemList) {
      if (!supplyOrderLineItem.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareSupplyOrderLineItemRemoveParameters(supplyOrderLineItem);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchSupplyOrderLineItemCreate(List<SupplyOrderLineItem> supplyOrderLineItemList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareSupplyOrderLineItemBatchCreateArgs(supplyOrderLineItemList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchSupplyOrderLineItemUpdate(List<SupplyOrderLineItem> supplyOrderLineItemList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareSupplyOrderLineItemBatchUpdateArgs(supplyOrderLineItemList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchSupplyOrderLineItemRemove(List<SupplyOrderLineItem> supplyOrderLineItemList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareSupplyOrderLineItemBatchRemoveArgs(supplyOrderLineItemList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchSupplyOrderLineItemRecover(
      List<SupplyOrderLineItem> supplyOrderLineItemList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareSupplyOrderLineItemBatchRecoverArgs(supplyOrderLineItemList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitSupplyOrderLineItemList(
      List<SupplyOrderLineItem> supplyOrderLineItemList) {

    List<SupplyOrderLineItem> supplyOrderLineItemCreateList = new ArrayList<SupplyOrderLineItem>();
    List<SupplyOrderLineItem> supplyOrderLineItemUpdateList = new ArrayList<SupplyOrderLineItem>();
    List<SupplyOrderLineItem> supplyOrderLineItemRemoveList = new ArrayList<SupplyOrderLineItem>();
    List<SupplyOrderLineItem> supplyOrderLineItemRecoverList = new ArrayList<SupplyOrderLineItem>();

    for (SupplyOrderLineItem supplyOrderLineItem : supplyOrderLineItemList) {
      if (supplyOrderLineItem.isToRemove()) {
        supplyOrderLineItemRemoveList.add(supplyOrderLineItem);
        continue;
      }
      if (supplyOrderLineItem.isToRecover()) {
        supplyOrderLineItemRecoverList.add(supplyOrderLineItem);
        continue;
      }
      if (isUpdateRequest(supplyOrderLineItem)) {
        if (supplyOrderLineItem.isChanged()) {
          supplyOrderLineItemUpdateList.add(supplyOrderLineItem);
        }
        continue;
      }

      if (supplyOrderLineItem.isChanged()) {
        supplyOrderLineItemCreateList.add(supplyOrderLineItem);
      }
    }

    return new Object[] {
      supplyOrderLineItemCreateList,
      supplyOrderLineItemUpdateList,
      supplyOrderLineItemRemoveList,
      supplyOrderLineItemRecoverList
    };
  }

  protected boolean isUpdateRequest(SupplyOrderLineItem supplyOrderLineItem) {
    return supplyOrderLineItem.getVersion() > 0;
  }

  protected String getSaveSupplyOrderLineItemSQL(SupplyOrderLineItem supplyOrderLineItem) {
    if (supplyOrderLineItem.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(supplyOrderLineItem)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveSupplyOrderLineItemParameters(SupplyOrderLineItem supplyOrderLineItem) {
    if (supplyOrderLineItem.isToRemove()) {
      return prepareSupplyOrderLineItemRemoveParameters(supplyOrderLineItem);
    }
    if (supplyOrderLineItem.isToRecover()) {
      return prepareRecoverParameters(supplyOrderLineItem);
    }

    if (isUpdateRequest(supplyOrderLineItem)) {
      return prepareSupplyOrderLineItemUpdateParameters(supplyOrderLineItem);
    }
    return prepareSupplyOrderLineItemCreateParameters(supplyOrderLineItem);
  }

  protected Object[] prepareSupplyOrderLineItemRemoveParameters(
      SupplyOrderLineItem supplyOrderLineItem) {
    return super.prepareRemoveParameters(supplyOrderLineItem);
  }

  protected Object[] prepareSupplyOrderLineItemUpdateParameters(
      SupplyOrderLineItem supplyOrderLineItem) {
    Object[] parameters = new Object[9];

    if (supplyOrderLineItem.getBizOrder() != null) {
      parameters[0] = supplyOrderLineItem.getBizOrder().getId();
    }

    parameters[1] = supplyOrderLineItem.getSkuId();

    parameters[2] = supplyOrderLineItem.getSkuName();

    parameters[3] = supplyOrderLineItem.getAmount();

    parameters[4] = supplyOrderLineItem.getQuantity();

    parameters[5] = supplyOrderLineItem.getUnitOfMeasurement();

    parameters[6] = supplyOrderLineItem.nextVersion();
    parameters[7] = supplyOrderLineItem.getId();
    parameters[8] = supplyOrderLineItem.getVersion();

    return parameters;
  }

  protected Object[] prepareSupplyOrderLineItemCreateParameters(
      SupplyOrderLineItem supplyOrderLineItem) {
    Object[] parameters = new Object[7];
    if (supplyOrderLineItem.getId() == null) {
      String newSupplyOrderLineItemId = getNextId();
      supplyOrderLineItem.setId(newSupplyOrderLineItemId);
    }
    parameters[0] = supplyOrderLineItem.getId();

    if (supplyOrderLineItem.getBizOrder() != null) {
      parameters[1] = supplyOrderLineItem.getBizOrder().getId();
    }

    parameters[2] = supplyOrderLineItem.getSkuId();

    parameters[3] = supplyOrderLineItem.getSkuName();

    parameters[4] = supplyOrderLineItem.getAmount();

    parameters[5] = supplyOrderLineItem.getQuantity();

    parameters[6] = supplyOrderLineItem.getUnitOfMeasurement();

    return parameters;
  }

  protected SupplyOrderLineItem saveInternalSupplyOrderLineItem(
      SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> options) {

    if (isSaveBizOrderEnabled(options)) {
      saveBizOrder(supplyOrderLineItem, options);
    }

    saveSupplyOrderLineItem(supplyOrderLineItem);

    return supplyOrderLineItem;
  }

  // ======================================================================================

  protected SupplyOrderLineItem saveBizOrder(
      SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (supplyOrderLineItem.getBizOrder() == null) {
      return supplyOrderLineItem; // do nothing when it is null
    }

    getSupplyOrderDAO().save(supplyOrderLineItem.getBizOrder(), options);
    return supplyOrderLineItem;
  }

  public SupplyOrderLineItem present(
      SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> options) {

    return supplyOrderLineItem;
  }

  protected String getTableName() {
    return SupplyOrderLineItemTable.TABLE_NAME;
  }

  public void enhanceList(List<SupplyOrderLineItem> supplyOrderLineItemList) {
    this.enhanceListInternal(supplyOrderLineItemList, this.getSupplyOrderLineItemMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<SupplyOrderLineItem> supplyOrderLineItemList =
        ownerEntity.collectRefsWithType(SupplyOrderLineItem.INTERNAL_TYPE);
    this.enhanceList(supplyOrderLineItemList);
  }

  @Override
  public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getSupplyOrderLineItemMapper());
  }

  @Override
  public int countSupplyOrderLineItemWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countSupplyOrderLineItemWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<SupplyOrderLineItem> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getSupplyOrderLineItemMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<SupplyOrderLineItem> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getSupplyOrderLineItemMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateSupplyOrderLineItem executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateSupplyOrderLineItem result = new CandidateSupplyOrderLineItem();
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
  public List<SupplyOrderLineItem> search(SupplyOrderLineItemRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected SupplyOrderLineItemMapper mapper() {
    return getSupplyOrderLineItemMapper();
  }

  @Override
  protected SupplyOrderLineItemMapper mapperForClazz(Class<?> clazz) {
    return SupplyOrderLineItemMapper.mapperForClass(clazz);
  }
}
