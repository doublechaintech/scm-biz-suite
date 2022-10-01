package com.doublechaintech.retailscm.warehouseasset;

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

import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class WarehouseAssetJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements WarehouseAssetDAO {

  protected WarehouseDAO warehouseDAO;

  public void setWarehouseDAO(WarehouseDAO warehouseDAO) {

    if (warehouseDAO == null) {
      throw new IllegalStateException("Do not try to set warehouseDAO to null.");
    }
    this.warehouseDAO = warehouseDAO;
  }

  public WarehouseDAO getWarehouseDAO() {
    if (this.warehouseDAO == null) {
      throw new IllegalStateException(
          "The warehouseDAO is not configured yet, please config it some where.");
    }

    return this.warehouseDAO;
  }

  /*
  protected WarehouseAsset load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalWarehouseAsset(accessKey, options);
  }
  */

  public SmartList<WarehouseAsset> loadAll() {
    return this.loadAll(getWarehouseAssetMapper());
  }

  public Stream<WarehouseAsset> loadAllAsStream() {
    return this.loadAllAsStream(getWarehouseAssetMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public WarehouseAsset load(String id, Map<String, Object> options) throws Exception {
    return loadInternalWarehouseAsset(WarehouseAssetTable.withId(id), options);
  }

  public WarehouseAsset save(WarehouseAsset warehouseAsset, Map<String, Object> options) {

    String methodName = "save(WarehouseAsset warehouseAsset,Map<String,Object> options)";

    assertMethodArgumentNotNull(warehouseAsset, methodName, "warehouseAsset");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalWarehouseAsset(warehouseAsset, options);
  }

  public WarehouseAsset clone(String warehouseAssetId, Map<String, Object> options)
      throws Exception {

    return clone(WarehouseAssetTable.withId(warehouseAssetId), options);
  }

  protected WarehouseAsset clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String warehouseAssetId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    WarehouseAsset newWarehouseAsset = loadInternalWarehouseAsset(accessKey, options);
    newWarehouseAsset.setVersion(0);

    saveInternalWarehouseAsset(newWarehouseAsset, options);

    return newWarehouseAsset;
  }

  protected void throwIfHasException(String warehouseAssetId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new WarehouseAssetVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new WarehouseAssetNotFoundException(
          "The " + this.getTableName() + "(" + warehouseAssetId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public WarehouseAsset disconnectFromAll(String warehouseAssetId, int version) throws Exception {

    WarehouseAsset warehouseAsset =
        loadInternalWarehouseAsset(WarehouseAssetTable.withId(warehouseAssetId), emptyOptions());
    warehouseAsset.clearFromAll();
    this.saveWarehouseAsset(warehouseAsset);
    return warehouseAsset;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return WarehouseAssetTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "warehouse_asset";
  }

  @Override
  protected String getBeanName() {

    return "warehouseAsset";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return WarehouseAssetTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, WarehouseAssetTokens.OWNER);
  }

  protected boolean isSaveOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, WarehouseAssetTokens.OWNER);
  }

  protected WarehouseAssetMapper getWarehouseAssetMapper() {
    return new WarehouseAssetMapper();
  }

  protected WarehouseAsset extractWarehouseAsset(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      WarehouseAsset warehouseAsset = loadSingleObject(accessKey, getWarehouseAssetMapper());
      return warehouseAsset;
    } catch (EmptyResultDataAccessException e) {
      throw new WarehouseAssetNotFoundException("WarehouseAsset(" + accessKey + ") is not found!");
    }
  }

  protected WarehouseAsset loadInternalWarehouseAsset(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    WarehouseAsset warehouseAsset = extractWarehouseAsset(accessKey, loadOptions);

    if (isExtractOwnerEnabled(loadOptions)) {
      extractOwner(warehouseAsset, loadOptions);
    }

    return warehouseAsset;
  }

  protected WarehouseAsset extractOwner(WarehouseAsset warehouseAsset, Map<String, Object> options)
      throws Exception {

    if (warehouseAsset.getOwner() == null) {
      return warehouseAsset;
    }
    String ownerId = warehouseAsset.getOwner().getId();
    if (ownerId == null) {
      return warehouseAsset;
    }
    Warehouse owner = getWarehouseDAO().load(ownerId, options);
    if (owner != null) {
      warehouseAsset.setOwner(owner);
    }

    return warehouseAsset;
  }

  public SmartList<WarehouseAsset> findWarehouseAssetByOwner(
      String warehouseId, Map<String, Object> options) {

    SmartList<WarehouseAsset> resultList =
        queryWith(
            WarehouseAssetTable.COLUMN_OWNER, warehouseId, options, getWarehouseAssetMapper());
    // analyzeWarehouseAssetByOwner(resultList, warehouseId, options);
    return resultList;
  }

  public SmartList<WarehouseAsset> findWarehouseAssetByOwner(
      String warehouseId, int start, int count, Map<String, Object> options) {

    SmartList<WarehouseAsset> resultList =
        queryWithRange(
            WarehouseAssetTable.COLUMN_OWNER,
            warehouseId,
            options,
            getWarehouseAssetMapper(),
            start,
            count);
    // analyzeWarehouseAssetByOwner(resultList, warehouseId, options);
    return resultList;
  }

  public void analyzeWarehouseAssetByOwner(
      SmartList<WarehouseAsset> resultList, String warehouseId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(WarehouseAsset.OWNER_PROPERTY, warehouseId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // WarehouseAsset.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("仓库资产");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countWarehouseAssetByOwner(String warehouseId, Map<String, Object> options) {

    return countWith(WarehouseAssetTable.COLUMN_OWNER, warehouseId, options);
  }

  @Override
  public Map<String, Integer> countWarehouseAssetByOwnerIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(WarehouseAssetTable.COLUMN_OWNER, ids, options);
  }

  protected WarehouseAsset saveWarehouseAsset(WarehouseAsset warehouseAsset) {

    if (!warehouseAsset.isChanged()) {
      return warehouseAsset;
    }

    Beans.dbUtil().cacheCleanUp(warehouseAsset);
    String SQL = this.getSaveWarehouseAssetSQL(warehouseAsset);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveWarehouseAssetParameters(warehouseAsset);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    warehouseAsset.incVersion();
    warehouseAsset.afterSave();
    return warehouseAsset;
  }

  public SmartList<WarehouseAsset> saveWarehouseAssetList(
      SmartList<WarehouseAsset> warehouseAssetList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitWarehouseAssetList(warehouseAssetList);

    batchWarehouseAssetCreate((List<WarehouseAsset>) lists[CREATE_LIST_INDEX]);
    batchWarehouseAssetUpdate((List<WarehouseAsset>) lists[UPDATE_LIST_INDEX]);
    batchWarehouseAssetRemove((List<WarehouseAsset>) lists[REMOVE_LIST_INDEX]);
    batchWarehouseAssetRecover((List<WarehouseAsset>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (WarehouseAsset warehouseAsset : warehouseAssetList) {
      if (warehouseAsset.isChanged()) {
        warehouseAsset.incVersion();
        warehouseAsset.afterSave();
      }
      if (warehouseAsset.isToRecover() || warehouseAsset.isToRemove()) {
        warehouseAsset.setVersion(-warehouseAsset.getVersion());
      }
    }

    return warehouseAssetList;
  }

  public SmartList<WarehouseAsset> removeWarehouseAssetList(
      SmartList<WarehouseAsset> warehouseAssetList, Map<String, Object> options) {

    super.removeList(warehouseAssetList, options);

    return warehouseAssetList;
  }

  protected List<Object[]> prepareWarehouseAssetBatchCreateArgs(
      List<WarehouseAsset> warehouseAssetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (WarehouseAsset warehouseAsset : warehouseAssetList) {
      Object[] parameters = prepareWarehouseAssetCreateParameters(warehouseAsset);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareWarehouseAssetBatchUpdateArgs(
      List<WarehouseAsset> warehouseAssetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (WarehouseAsset warehouseAsset : warehouseAssetList) {
      if (!warehouseAsset.isChanged()) {
        continue;
      }
      Object[] parameters = prepareWarehouseAssetUpdateParameters(warehouseAsset);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareWarehouseAssetBatchRecoverArgs(
      List<WarehouseAsset> warehouseAssetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (WarehouseAsset warehouseAsset : warehouseAssetList) {
      if (!warehouseAsset.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(warehouseAsset);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareWarehouseAssetBatchRemoveArgs(
      List<WarehouseAsset> warehouseAssetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (WarehouseAsset warehouseAsset : warehouseAssetList) {
      if (!warehouseAsset.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareWarehouseAssetRemoveParameters(warehouseAsset);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchWarehouseAssetCreate(List<WarehouseAsset> warehouseAssetList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareWarehouseAssetBatchCreateArgs(warehouseAssetList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchWarehouseAssetUpdate(List<WarehouseAsset> warehouseAssetList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareWarehouseAssetBatchUpdateArgs(warehouseAssetList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchWarehouseAssetRemove(List<WarehouseAsset> warehouseAssetList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareWarehouseAssetBatchRemoveArgs(warehouseAssetList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchWarehouseAssetRecover(List<WarehouseAsset> warehouseAssetList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareWarehouseAssetBatchRecoverArgs(warehouseAssetList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitWarehouseAssetList(List<WarehouseAsset> warehouseAssetList) {

    List<WarehouseAsset> warehouseAssetCreateList = new ArrayList<WarehouseAsset>();
    List<WarehouseAsset> warehouseAssetUpdateList = new ArrayList<WarehouseAsset>();
    List<WarehouseAsset> warehouseAssetRemoveList = new ArrayList<WarehouseAsset>();
    List<WarehouseAsset> warehouseAssetRecoverList = new ArrayList<WarehouseAsset>();

    for (WarehouseAsset warehouseAsset : warehouseAssetList) {
      if (warehouseAsset.isToRemove()) {
        warehouseAssetRemoveList.add(warehouseAsset);
        continue;
      }
      if (warehouseAsset.isToRecover()) {
        warehouseAssetRecoverList.add(warehouseAsset);
        continue;
      }
      if (isUpdateRequest(warehouseAsset)) {
        if (warehouseAsset.isChanged()) {
          warehouseAssetUpdateList.add(warehouseAsset);
        }
        continue;
      }

      if (warehouseAsset.isChanged()) {
        warehouseAssetCreateList.add(warehouseAsset);
      }
    }

    return new Object[] {
      warehouseAssetCreateList,
      warehouseAssetUpdateList,
      warehouseAssetRemoveList,
      warehouseAssetRecoverList
    };
  }

  protected boolean isUpdateRequest(WarehouseAsset warehouseAsset) {
    return warehouseAsset.getVersion() > 0;
  }

  protected String getSaveWarehouseAssetSQL(WarehouseAsset warehouseAsset) {
    if (warehouseAsset.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(warehouseAsset)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveWarehouseAssetParameters(WarehouseAsset warehouseAsset) {
    if (warehouseAsset.isToRemove()) {
      return prepareWarehouseAssetRemoveParameters(warehouseAsset);
    }
    if (warehouseAsset.isToRecover()) {
      return prepareRecoverParameters(warehouseAsset);
    }

    if (isUpdateRequest(warehouseAsset)) {
      return prepareWarehouseAssetUpdateParameters(warehouseAsset);
    }
    return prepareWarehouseAssetCreateParameters(warehouseAsset);
  }

  protected Object[] prepareWarehouseAssetRemoveParameters(WarehouseAsset warehouseAsset) {
    return super.prepareRemoveParameters(warehouseAsset);
  }

  protected Object[] prepareWarehouseAssetUpdateParameters(WarehouseAsset warehouseAsset) {
    Object[] parameters = new Object[7];

    parameters[0] = warehouseAsset.getName();

    parameters[1] = warehouseAsset.getPosition();

    if (warehouseAsset.getOwner() != null) {
      parameters[2] = warehouseAsset.getOwner().getId();
    }

    parameters[3] = warehouseAsset.getLastUpdateTime();

    parameters[4] = warehouseAsset.nextVersion();
    parameters[5] = warehouseAsset.getId();
    parameters[6] = warehouseAsset.getVersion();

    return parameters;
  }

  protected Object[] prepareWarehouseAssetCreateParameters(WarehouseAsset warehouseAsset) {
    Object[] parameters = new Object[5];
    if (warehouseAsset.getId() == null) {
      String newWarehouseAssetId = getNextId();
      warehouseAsset.setId(newWarehouseAssetId);
    }
    parameters[0] = warehouseAsset.getId();

    parameters[1] = warehouseAsset.getName();

    parameters[2] = warehouseAsset.getPosition();

    if (warehouseAsset.getOwner() != null) {
      parameters[3] = warehouseAsset.getOwner().getId();
    }

    parameters[4] = warehouseAsset.getLastUpdateTime();

    return parameters;
  }

  protected WarehouseAsset saveInternalWarehouseAsset(
      WarehouseAsset warehouseAsset, Map<String, Object> options) {

    if (isSaveOwnerEnabled(options)) {
      saveOwner(warehouseAsset, options);
    }

    saveWarehouseAsset(warehouseAsset);

    return warehouseAsset;
  }

  // ======================================================================================

  protected WarehouseAsset saveOwner(WarehouseAsset warehouseAsset, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (warehouseAsset.getOwner() == null) {
      return warehouseAsset; // do nothing when it is null
    }

    getWarehouseDAO().save(warehouseAsset.getOwner(), options);
    return warehouseAsset;
  }

  public WarehouseAsset present(WarehouseAsset warehouseAsset, Map<String, Object> options) {

    return warehouseAsset;
  }

  protected String getTableName() {
    return WarehouseAssetTable.TABLE_NAME;
  }

  public void enhanceList(List<WarehouseAsset> warehouseAssetList) {
    this.enhanceListInternal(warehouseAssetList, this.getWarehouseAssetMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<WarehouseAsset> warehouseAssetList =
        ownerEntity.collectRefsWithType(WarehouseAsset.INTERNAL_TYPE);
    this.enhanceList(warehouseAssetList);
  }

  @Override
  public SmartList<WarehouseAsset> findWarehouseAssetWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getWarehouseAssetMapper());
  }

  @Override
  public int countWarehouseAssetWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countWarehouseAssetWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<WarehouseAsset> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getWarehouseAssetMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<WarehouseAsset> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getWarehouseAssetMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateWarehouseAsset executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateWarehouseAsset result = new CandidateWarehouseAsset();
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
  public List<WarehouseAsset> search(WarehouseAssetRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected WarehouseAssetMapper mapper() {
    return getWarehouseAssetMapper();
  }

  @Override
  protected WarehouseAssetMapper mapperForClazz(Class<?> clazz) {
    return WarehouseAssetMapper.mapperForClass(clazz);
  }
}
