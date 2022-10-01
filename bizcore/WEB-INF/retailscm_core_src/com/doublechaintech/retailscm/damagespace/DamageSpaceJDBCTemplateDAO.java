package com.doublechaintech.retailscm.damagespace;

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
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class DamageSpaceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements DamageSpaceDAO {

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

  protected GoodsShelfDAO goodsShelfDAO;

  public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO) {

    if (goodsShelfDAO == null) {
      throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
    }
    this.goodsShelfDAO = goodsShelfDAO;
  }

  public GoodsShelfDAO getGoodsShelfDAO() {
    if (this.goodsShelfDAO == null) {
      throw new IllegalStateException(
          "The goodsShelfDAO is not configured yet, please config it some where.");
    }

    return this.goodsShelfDAO;
  }

  /*
  protected DamageSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalDamageSpace(accessKey, options);
  }
  */

  public SmartList<DamageSpace> loadAll() {
    return this.loadAll(getDamageSpaceMapper());
  }

  public Stream<DamageSpace> loadAllAsStream() {
    return this.loadAllAsStream(getDamageSpaceMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public DamageSpace load(String id, Map<String, Object> options) throws Exception {
    return loadInternalDamageSpace(DamageSpaceTable.withId(id), options);
  }

  public DamageSpace save(DamageSpace damageSpace, Map<String, Object> options) {

    String methodName = "save(DamageSpace damageSpace,Map<String,Object> options)";

    assertMethodArgumentNotNull(damageSpace, methodName, "damageSpace");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalDamageSpace(damageSpace, options);
  }

  public DamageSpace clone(String damageSpaceId, Map<String, Object> options) throws Exception {

    return clone(DamageSpaceTable.withId(damageSpaceId), options);
  }

  protected DamageSpace clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String damageSpaceId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    DamageSpace newDamageSpace = loadInternalDamageSpace(accessKey, options);
    newDamageSpace.setVersion(0);

    if (isSaveGoodsShelfListEnabled(options)) {
      for (GoodsShelf item : newDamageSpace.getGoodsShelfList()) {
        item.setVersion(0);
      }
    }

    saveInternalDamageSpace(newDamageSpace, options);

    return newDamageSpace;
  }

  protected void throwIfHasException(String damageSpaceId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new DamageSpaceVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new DamageSpaceNotFoundException(
          "The " + this.getTableName() + "(" + damageSpaceId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public DamageSpace disconnectFromAll(String damageSpaceId, int version) throws Exception {

    DamageSpace damageSpace =
        loadInternalDamageSpace(DamageSpaceTable.withId(damageSpaceId), emptyOptions());
    damageSpace.clearFromAll();
    this.saveDamageSpace(damageSpace);
    return damageSpace;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return DamageSpaceTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "damage_space";
  }

  @Override
  protected String getBeanName() {

    return "damageSpace";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return DamageSpaceTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractWarehouseEnabled(Map<String, Object> options) {

    return checkOptions(options, DamageSpaceTokens.WAREHOUSE);
  }

  protected boolean isSaveWarehouseEnabled(Map<String, Object> options) {

    return checkOptions(options, DamageSpaceTokens.WAREHOUSE);
  }

  protected boolean isExtractGoodsShelfListEnabled(Map<String, Object> options) {
    return checkOptions(options, DamageSpaceTokens.GOODS_SHELF_LIST);
  }

  protected boolean isAnalyzeGoodsShelfListEnabled(Map<String, Object> options) {
    return DamageSpaceTokens.of(options).analyzeGoodsShelfListEnabled();
  }

  protected boolean isSaveGoodsShelfListEnabled(Map<String, Object> options) {
    return checkOptions(options, DamageSpaceTokens.GOODS_SHELF_LIST);
  }

  protected DamageSpaceMapper getDamageSpaceMapper() {
    return new DamageSpaceMapper();
  }

  protected DamageSpace extractDamageSpace(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      DamageSpace damageSpace = loadSingleObject(accessKey, getDamageSpaceMapper());
      return damageSpace;
    } catch (EmptyResultDataAccessException e) {
      throw new DamageSpaceNotFoundException("DamageSpace(" + accessKey + ") is not found!");
    }
  }

  protected DamageSpace loadInternalDamageSpace(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    DamageSpace damageSpace = extractDamageSpace(accessKey, loadOptions);

    if (isExtractWarehouseEnabled(loadOptions)) {
      extractWarehouse(damageSpace, loadOptions);
    }

    if (isExtractGoodsShelfListEnabled(loadOptions)) {
      extractGoodsShelfList(damageSpace, loadOptions);
    }

    if (isAnalyzeGoodsShelfListEnabled(loadOptions)) {
      analyzeGoodsShelfList(damageSpace, loadOptions);
    }

    return damageSpace;
  }

  protected DamageSpace extractWarehouse(DamageSpace damageSpace, Map<String, Object> options)
      throws Exception {

    if (damageSpace.getWarehouse() == null) {
      return damageSpace;
    }
    String warehouseId = damageSpace.getWarehouse().getId();
    if (warehouseId == null) {
      return damageSpace;
    }
    Warehouse warehouse = getWarehouseDAO().load(warehouseId, options);
    if (warehouse != null) {
      damageSpace.setWarehouse(warehouse);
    }

    return damageSpace;
  }

  protected void enhanceGoodsShelfList(
      SmartList<GoodsShelf> goodsShelfList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected DamageSpace extractGoodsShelfList(
      DamageSpace damageSpace, Map<String, Object> options) {

    if (damageSpace == null) {
      return null;
    }
    if (damageSpace.getId() == null) {
      return damageSpace;
    }

    SmartList<GoodsShelf> goodsShelfList =
        getGoodsShelfDAO().findGoodsShelfByDamageSpace(damageSpace.getId(), options);
    if (goodsShelfList != null) {
      enhanceGoodsShelfList(goodsShelfList, options);
      damageSpace.setGoodsShelfList(goodsShelfList);
    }

    return damageSpace;
  }

  protected DamageSpace analyzeGoodsShelfList(
      DamageSpace damageSpace, Map<String, Object> options) {

    if (damageSpace == null) {
      return null;
    }
    if (damageSpace.getId() == null) {
      return damageSpace;
    }

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    if (goodsShelfList != null) {
      getGoodsShelfDAO()
          .analyzeGoodsShelfByDamageSpace(goodsShelfList, damageSpace.getId(), options);
    }

    return damageSpace;
  }

  public SmartList<DamageSpace> findDamageSpaceByWarehouse(
      String warehouseId, Map<String, Object> options) {

    SmartList<DamageSpace> resultList =
        queryWith(DamageSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getDamageSpaceMapper());
    // analyzeDamageSpaceByWarehouse(resultList, warehouseId, options);
    return resultList;
  }

  public SmartList<DamageSpace> findDamageSpaceByWarehouse(
      String warehouseId, int start, int count, Map<String, Object> options) {

    SmartList<DamageSpace> resultList =
        queryWithRange(
            DamageSpaceTable.COLUMN_WAREHOUSE,
            warehouseId,
            options,
            getDamageSpaceMapper(),
            start,
            count);
    // analyzeDamageSpaceByWarehouse(resultList, warehouseId, options);
    return resultList;
  }

  public void analyzeDamageSpaceByWarehouse(
      SmartList<DamageSpace> resultList, String warehouseId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(DamageSpace.WAREHOUSE_PROPERTY, warehouseId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // DamageSpace.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("残次货物存放区");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(DamageSpace.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(DamageSpace.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countDamageSpaceByWarehouse(String warehouseId, Map<String, Object> options) {

    return countWith(DamageSpaceTable.COLUMN_WAREHOUSE, warehouseId, options);
  }

  @Override
  public Map<String, Integer> countDamageSpaceByWarehouseIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(DamageSpaceTable.COLUMN_WAREHOUSE, ids, options);
  }

  protected DamageSpace saveDamageSpace(DamageSpace damageSpace) {

    if (!damageSpace.isChanged()) {
      return damageSpace;
    }

    Beans.dbUtil().cacheCleanUp(damageSpace);
    String SQL = this.getSaveDamageSpaceSQL(damageSpace);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveDamageSpaceParameters(damageSpace);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    damageSpace.incVersion();
    damageSpace.afterSave();
    return damageSpace;
  }

  public SmartList<DamageSpace> saveDamageSpaceList(
      SmartList<DamageSpace> damageSpaceList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitDamageSpaceList(damageSpaceList);

    batchDamageSpaceCreate((List<DamageSpace>) lists[CREATE_LIST_INDEX]);
    batchDamageSpaceUpdate((List<DamageSpace>) lists[UPDATE_LIST_INDEX]);
    batchDamageSpaceRemove((List<DamageSpace>) lists[REMOVE_LIST_INDEX]);
    batchDamageSpaceRecover((List<DamageSpace>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (DamageSpace damageSpace : damageSpaceList) {
      if (damageSpace.isChanged()) {
        damageSpace.incVersion();
        damageSpace.afterSave();
      }
      if (damageSpace.isToRecover() || damageSpace.isToRemove()) {
        damageSpace.setVersion(-damageSpace.getVersion());
      }
    }

    return damageSpaceList;
  }

  public SmartList<DamageSpace> removeDamageSpaceList(
      SmartList<DamageSpace> damageSpaceList, Map<String, Object> options) {

    super.removeList(damageSpaceList, options);

    return damageSpaceList;
  }

  protected List<Object[]> prepareDamageSpaceBatchCreateArgs(List<DamageSpace> damageSpaceList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (DamageSpace damageSpace : damageSpaceList) {
      Object[] parameters = prepareDamageSpaceCreateParameters(damageSpace);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareDamageSpaceBatchUpdateArgs(List<DamageSpace> damageSpaceList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (DamageSpace damageSpace : damageSpaceList) {
      if (!damageSpace.isChanged()) {
        continue;
      }
      Object[] parameters = prepareDamageSpaceUpdateParameters(damageSpace);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareDamageSpaceBatchRecoverArgs(List<DamageSpace> damageSpaceList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (DamageSpace damageSpace : damageSpaceList) {
      if (!damageSpace.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(damageSpace);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareDamageSpaceBatchRemoveArgs(List<DamageSpace> damageSpaceList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (DamageSpace damageSpace : damageSpaceList) {
      if (!damageSpace.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareDamageSpaceRemoveParameters(damageSpace);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchDamageSpaceCreate(List<DamageSpace> damageSpaceList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareDamageSpaceBatchCreateArgs(damageSpaceList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchDamageSpaceUpdate(List<DamageSpace> damageSpaceList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareDamageSpaceBatchUpdateArgs(damageSpaceList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchDamageSpaceRemove(List<DamageSpace> damageSpaceList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareDamageSpaceBatchRemoveArgs(damageSpaceList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchDamageSpaceRecover(List<DamageSpace> damageSpaceList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareDamageSpaceBatchRecoverArgs(damageSpaceList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitDamageSpaceList(List<DamageSpace> damageSpaceList) {

    List<DamageSpace> damageSpaceCreateList = new ArrayList<DamageSpace>();
    List<DamageSpace> damageSpaceUpdateList = new ArrayList<DamageSpace>();
    List<DamageSpace> damageSpaceRemoveList = new ArrayList<DamageSpace>();
    List<DamageSpace> damageSpaceRecoverList = new ArrayList<DamageSpace>();

    for (DamageSpace damageSpace : damageSpaceList) {
      if (damageSpace.isToRemove()) {
        damageSpaceRemoveList.add(damageSpace);
        continue;
      }
      if (damageSpace.isToRecover()) {
        damageSpaceRecoverList.add(damageSpace);
        continue;
      }
      if (isUpdateRequest(damageSpace)) {
        if (damageSpace.isChanged()) {
          damageSpaceUpdateList.add(damageSpace);
        }
        continue;
      }

      if (damageSpace.isChanged()) {
        damageSpaceCreateList.add(damageSpace);
      }
    }

    return new Object[] {
      damageSpaceCreateList, damageSpaceUpdateList, damageSpaceRemoveList, damageSpaceRecoverList
    };
  }

  protected boolean isUpdateRequest(DamageSpace damageSpace) {
    return damageSpace.getVersion() > 0;
  }

  protected String getSaveDamageSpaceSQL(DamageSpace damageSpace) {
    if (damageSpace.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(damageSpace)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveDamageSpaceParameters(DamageSpace damageSpace) {
    if (damageSpace.isToRemove()) {
      return prepareDamageSpaceRemoveParameters(damageSpace);
    }
    if (damageSpace.isToRecover()) {
      return prepareRecoverParameters(damageSpace);
    }

    if (isUpdateRequest(damageSpace)) {
      return prepareDamageSpaceUpdateParameters(damageSpace);
    }
    return prepareDamageSpaceCreateParameters(damageSpace);
  }

  protected Object[] prepareDamageSpaceRemoveParameters(DamageSpace damageSpace) {
    return super.prepareRemoveParameters(damageSpace);
  }

  protected Object[] prepareDamageSpaceUpdateParameters(DamageSpace damageSpace) {
    Object[] parameters = new Object[10];

    parameters[0] = damageSpace.getLocation();

    parameters[1] = damageSpace.getContactNumber();

    parameters[2] = damageSpace.getTotalArea();

    parameters[3] = damageSpace.getLatitude();

    parameters[4] = damageSpace.getLongitude();

    if (damageSpace.getWarehouse() != null) {
      parameters[5] = damageSpace.getWarehouse().getId();
    }

    parameters[6] = damageSpace.getLastUpdateTime();

    parameters[7] = damageSpace.nextVersion();
    parameters[8] = damageSpace.getId();
    parameters[9] = damageSpace.getVersion();

    return parameters;
  }

  protected Object[] prepareDamageSpaceCreateParameters(DamageSpace damageSpace) {
    Object[] parameters = new Object[8];
    if (damageSpace.getId() == null) {
      String newDamageSpaceId = getNextId();
      damageSpace.setId(newDamageSpaceId);
    }
    parameters[0] = damageSpace.getId();

    parameters[1] = damageSpace.getLocation();

    parameters[2] = damageSpace.getContactNumber();

    parameters[3] = damageSpace.getTotalArea();

    parameters[4] = damageSpace.getLatitude();

    parameters[5] = damageSpace.getLongitude();

    if (damageSpace.getWarehouse() != null) {
      parameters[6] = damageSpace.getWarehouse().getId();
    }

    parameters[7] = damageSpace.getLastUpdateTime();

    return parameters;
  }

  protected DamageSpace saveInternalDamageSpace(
      DamageSpace damageSpace, Map<String, Object> options) {

    if (isSaveWarehouseEnabled(options)) {
      saveWarehouse(damageSpace, options);
    }

    saveDamageSpace(damageSpace);

    if (isSaveGoodsShelfListEnabled(options)) {
      saveGoodsShelfList(damageSpace, options);
      // removeGoodsShelfList(damageSpace, options);
      // Not delete the record

    }

    return damageSpace;
  }

  // ======================================================================================

  protected DamageSpace saveWarehouse(DamageSpace damageSpace, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (damageSpace.getWarehouse() == null) {
      return damageSpace; // do nothing when it is null
    }

    getWarehouseDAO().save(damageSpace.getWarehouse(), options);
    return damageSpace;
  }

  public DamageSpace planToRemoveGoodsShelfList(
      DamageSpace damageSpace, String goodsShelfIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpace.getId());
    key.put(GoodsShelf.ID_PROPERTY, goodsShelfIds);

    SmartList<GoodsShelf> externalGoodsShelfList =
        getGoodsShelfDAO().findGoodsShelfWithKey(key, options);
    if (externalGoodsShelfList == null) {
      return damageSpace;
    }
    if (externalGoodsShelfList.isEmpty()) {
      return damageSpace;
    }

    for (GoodsShelf goodsShelfItem : externalGoodsShelfList) {

      goodsShelfItem.clearFromAll();
    }

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
    return damageSpace;
  }

  // disconnect DamageSpace with storage_space in GoodsShelf
  public DamageSpace planToRemoveGoodsShelfListWithStorageSpace(
      DamageSpace damageSpace, String storageSpaceId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpace.getId());
    key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);

    SmartList<GoodsShelf> externalGoodsShelfList =
        getGoodsShelfDAO().findGoodsShelfWithKey(key, options);
    if (externalGoodsShelfList == null) {
      return damageSpace;
    }
    if (externalGoodsShelfList.isEmpty()) {
      return damageSpace;
    }

    for (GoodsShelf goodsShelfItem : externalGoodsShelfList) {
      goodsShelfItem.clearStorageSpace();
      goodsShelfItem.clearDamageSpace();
    }

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
    return damageSpace;
  }

  public int countGoodsShelfListWithStorageSpace(
      String damageSpaceId, String storageSpaceId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
    key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);

    int count = getGoodsShelfDAO().countGoodsShelfWithKey(key, options);
    return count;
  }

  // disconnect DamageSpace with supplier_space in GoodsShelf
  public DamageSpace planToRemoveGoodsShelfListWithSupplierSpace(
      DamageSpace damageSpace, String supplierSpaceId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpace.getId());
    key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);

    SmartList<GoodsShelf> externalGoodsShelfList =
        getGoodsShelfDAO().findGoodsShelfWithKey(key, options);
    if (externalGoodsShelfList == null) {
      return damageSpace;
    }
    if (externalGoodsShelfList.isEmpty()) {
      return damageSpace;
    }

    for (GoodsShelf goodsShelfItem : externalGoodsShelfList) {
      goodsShelfItem.clearSupplierSpace();
      goodsShelfItem.clearDamageSpace();
    }

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
    return damageSpace;
  }

  public int countGoodsShelfListWithSupplierSpace(
      String damageSpaceId, String supplierSpaceId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
    key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);

    int count = getGoodsShelfDAO().countGoodsShelfWithKey(key, options);
    return count;
  }

  protected DamageSpace saveGoodsShelfList(DamageSpace damageSpace, Map<String, Object> options) {

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    if (goodsShelfList == null) {
      // null list means nothing
      return damageSpace;
    }
    SmartList<GoodsShelf> mergedUpdateGoodsShelfList = new SmartList<GoodsShelf>();

    mergedUpdateGoodsShelfList.addAll(goodsShelfList);
    if (goodsShelfList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateGoodsShelfList.addAll(goodsShelfList.getToRemoveList());
      goodsShelfList.removeAll(goodsShelfList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getGoodsShelfDAO().saveGoodsShelfList(mergedUpdateGoodsShelfList, options);

    if (goodsShelfList.getToRemoveList() != null) {
      goodsShelfList.removeAll(goodsShelfList.getToRemoveList());
    }

    return damageSpace;
  }

  protected DamageSpace removeGoodsShelfList(DamageSpace damageSpace, Map<String, Object> options) {

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    if (goodsShelfList == null) {
      return damageSpace;
    }

    SmartList<GoodsShelf> toRemoveGoodsShelfList = goodsShelfList.getToRemoveList();

    if (toRemoveGoodsShelfList == null) {
      return damageSpace;
    }
    if (toRemoveGoodsShelfList.isEmpty()) {
      return damageSpace; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getGoodsShelfDAO().removeGoodsShelfList(toRemoveGoodsShelfList, options);

    return damageSpace;
  }

  public DamageSpace present(DamageSpace damageSpace, Map<String, Object> options) {

    presentGoodsShelfList(damageSpace, options);

    return damageSpace;
  }

  // Using java8 feature to reduce the code significantly
  protected DamageSpace presentGoodsShelfList(
      DamageSpace damageSpace, Map<String, Object> options) {

    SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
    SmartList<GoodsShelf> newList =
        presentSubList(
            damageSpace.getId(),
            goodsShelfList,
            options,
            getGoodsShelfDAO()::countGoodsShelfByDamageSpace,
            getGoodsShelfDAO()::findGoodsShelfByDamageSpace);

    damageSpace.setGoodsShelfList(newList);

    return damageSpace;
  }

  public SmartList<DamageSpace> requestCandidateDamageSpaceForGoodsShelf(
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
        DamageSpaceTable.COLUMN_LOCATION,
        DamageSpaceTable.COLUMN_WAREHOUSE,
        filterKey,
        pageNo,
        pageSize,
        getDamageSpaceMapper());
  }

  protected String getTableName() {
    return DamageSpaceTable.TABLE_NAME;
  }

  public void enhanceList(List<DamageSpace> damageSpaceList) {
    this.enhanceListInternal(damageSpaceList, this.getDamageSpaceMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<DamageSpace> damageSpaceList = ownerEntity.collectRefsWithType(DamageSpace.INTERNAL_TYPE);
    this.enhanceList(damageSpaceList);
  }

  @Override
  public SmartList<DamageSpace> findDamageSpaceWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getDamageSpaceMapper());
  }

  @Override
  public int countDamageSpaceWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countDamageSpaceWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<DamageSpace> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getDamageSpaceMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<DamageSpace> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getDamageSpaceMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateDamageSpace executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateDamageSpace result = new CandidateDamageSpace();
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
  public List<DamageSpace> search(DamageSpaceRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected DamageSpaceMapper mapper() {
    return getDamageSpaceMapper();
  }

  @Override
  protected DamageSpaceMapper mapperForClazz(Class<?> clazz) {
    return DamageSpaceMapper.mapperForClass(clazz);
  }
}
