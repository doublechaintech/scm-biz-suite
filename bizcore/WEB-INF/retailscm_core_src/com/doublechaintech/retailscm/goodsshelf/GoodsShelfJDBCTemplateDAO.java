package com.doublechaintech.retailscm.goodsshelf;

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

import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.damagespace.DamageSpaceDAO;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceDAO;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationDAO;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;
import com.doublechaintech.retailscm.storagespace.StorageSpaceDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class GoodsShelfJDBCTemplateDAO extends RetailscmBaseDAOImpl implements GoodsShelfDAO {

  protected StorageSpaceDAO storageSpaceDAO;

  public void setStorageSpaceDAO(StorageSpaceDAO storageSpaceDAO) {

    if (storageSpaceDAO == null) {
      throw new IllegalStateException("Do not try to set storageSpaceDAO to null.");
    }
    this.storageSpaceDAO = storageSpaceDAO;
  }

  public StorageSpaceDAO getStorageSpaceDAO() {
    if (this.storageSpaceDAO == null) {
      throw new IllegalStateException(
          "The storageSpaceDAO is not configured yet, please config it some where.");
    }

    return this.storageSpaceDAO;
  }

  protected SupplierSpaceDAO supplierSpaceDAO;

  public void setSupplierSpaceDAO(SupplierSpaceDAO supplierSpaceDAO) {

    if (supplierSpaceDAO == null) {
      throw new IllegalStateException("Do not try to set supplierSpaceDAO to null.");
    }
    this.supplierSpaceDAO = supplierSpaceDAO;
  }

  public SupplierSpaceDAO getSupplierSpaceDAO() {
    if (this.supplierSpaceDAO == null) {
      throw new IllegalStateException(
          "The supplierSpaceDAO is not configured yet, please config it some where.");
    }

    return this.supplierSpaceDAO;
  }

  protected DamageSpaceDAO damageSpaceDAO;

  public void setDamageSpaceDAO(DamageSpaceDAO damageSpaceDAO) {

    if (damageSpaceDAO == null) {
      throw new IllegalStateException("Do not try to set damageSpaceDAO to null.");
    }
    this.damageSpaceDAO = damageSpaceDAO;
  }

  public DamageSpaceDAO getDamageSpaceDAO() {
    if (this.damageSpaceDAO == null) {
      throw new IllegalStateException(
          "The damageSpaceDAO is not configured yet, please config it some where.");
    }

    return this.damageSpaceDAO;
  }

  protected GoodsShelfStockCountDAO goodsShelfStockCountDAO;

  public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO goodsShelfStockCountDAO) {

    if (goodsShelfStockCountDAO == null) {
      throw new IllegalStateException("Do not try to set goodsShelfStockCountDAO to null.");
    }
    this.goodsShelfStockCountDAO = goodsShelfStockCountDAO;
  }

  public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO() {
    if (this.goodsShelfStockCountDAO == null) {
      throw new IllegalStateException(
          "The goodsShelfStockCountDAO is not configured yet, please config it some where.");
    }

    return this.goodsShelfStockCountDAO;
  }

  protected GoodsAllocationDAO goodsAllocationDAO;

  public void setGoodsAllocationDAO(GoodsAllocationDAO goodsAllocationDAO) {

    if (goodsAllocationDAO == null) {
      throw new IllegalStateException("Do not try to set goodsAllocationDAO to null.");
    }
    this.goodsAllocationDAO = goodsAllocationDAO;
  }

  public GoodsAllocationDAO getGoodsAllocationDAO() {
    if (this.goodsAllocationDAO == null) {
      throw new IllegalStateException(
          "The goodsAllocationDAO is not configured yet, please config it some where.");
    }

    return this.goodsAllocationDAO;
  }

  /*
  protected GoodsShelf load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalGoodsShelf(accessKey, options);
  }
  */

  public SmartList<GoodsShelf> loadAll() {
    return this.loadAll(getGoodsShelfMapper());
  }

  public Stream<GoodsShelf> loadAllAsStream() {
    return this.loadAllAsStream(getGoodsShelfMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public GoodsShelf load(String id, Map<String, Object> options) throws Exception {
    return loadInternalGoodsShelf(GoodsShelfTable.withId(id), options);
  }

  public GoodsShelf save(GoodsShelf goodsShelf, Map<String, Object> options) {

    String methodName = "save(GoodsShelf goodsShelf,Map<String,Object> options)";

    assertMethodArgumentNotNull(goodsShelf, methodName, "goodsShelf");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalGoodsShelf(goodsShelf, options);
  }

  public GoodsShelf clone(String goodsShelfId, Map<String, Object> options) throws Exception {

    return clone(GoodsShelfTable.withId(goodsShelfId), options);
  }

  protected GoodsShelf clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String goodsShelfId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    GoodsShelf newGoodsShelf = loadInternalGoodsShelf(accessKey, options);
    newGoodsShelf.setVersion(0);

    if (isSaveGoodsShelfStockCountListEnabled(options)) {
      for (GoodsShelfStockCount item : newGoodsShelf.getGoodsShelfStockCountList()) {
        item.setVersion(0);
      }
    }

    if (isSaveGoodsAllocationListEnabled(options)) {
      for (GoodsAllocation item : newGoodsShelf.getGoodsAllocationList()) {
        item.setVersion(0);
      }
    }

    saveInternalGoodsShelf(newGoodsShelf, options);

    return newGoodsShelf;
  }

  protected void throwIfHasException(String goodsShelfId, int version, int count) throws Exception {
    if (count == 1) {
      throw new GoodsShelfVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new GoodsShelfNotFoundException(
          "The " + this.getTableName() + "(" + goodsShelfId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public GoodsShelf disconnectFromAll(String goodsShelfId, int version) throws Exception {

    GoodsShelf goodsShelf =
        loadInternalGoodsShelf(GoodsShelfTable.withId(goodsShelfId), emptyOptions());
    goodsShelf.clearFromAll();
    this.saveGoodsShelf(goodsShelf);
    return goodsShelf;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return GoodsShelfTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "goods_shelf";
  }

  @Override
  protected String getBeanName() {

    return "goodsShelf";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return GoodsShelfTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractStorageSpaceEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsShelfTokens.STORAGESPACE);
  }

  protected boolean isSaveStorageSpaceEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsShelfTokens.STORAGESPACE);
  }

  protected boolean isExtractSupplierSpaceEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsShelfTokens.SUPPLIERSPACE);
  }

  protected boolean isSaveSupplierSpaceEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsShelfTokens.SUPPLIERSPACE);
  }

  protected boolean isExtractDamageSpaceEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsShelfTokens.DAMAGESPACE);
  }

  protected boolean isSaveDamageSpaceEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsShelfTokens.DAMAGESPACE);
  }

  protected boolean isExtractGoodsShelfStockCountListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsShelfTokens.GOODS_SHELF_STOCK_COUNT_LIST);
  }

  protected boolean isAnalyzeGoodsShelfStockCountListEnabled(Map<String, Object> options) {
    return GoodsShelfTokens.of(options).analyzeGoodsShelfStockCountListEnabled();
  }

  protected boolean isSaveGoodsShelfStockCountListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsShelfTokens.GOODS_SHELF_STOCK_COUNT_LIST);
  }

  protected boolean isExtractGoodsAllocationListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsShelfTokens.GOODS_ALLOCATION_LIST);
  }

  protected boolean isAnalyzeGoodsAllocationListEnabled(Map<String, Object> options) {
    return GoodsShelfTokens.of(options).analyzeGoodsAllocationListEnabled();
  }

  protected boolean isSaveGoodsAllocationListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsShelfTokens.GOODS_ALLOCATION_LIST);
  }

  protected GoodsShelfMapper getGoodsShelfMapper() {
    return new GoodsShelfMapper();
  }

  protected GoodsShelf extractGoodsShelf(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      GoodsShelf goodsShelf = loadSingleObject(accessKey, getGoodsShelfMapper());
      return goodsShelf;
    } catch (EmptyResultDataAccessException e) {
      throw new GoodsShelfNotFoundException("GoodsShelf(" + accessKey + ") is not found!");
    }
  }

  protected GoodsShelf loadInternalGoodsShelf(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    GoodsShelf goodsShelf = extractGoodsShelf(accessKey, loadOptions);

    if (isExtractStorageSpaceEnabled(loadOptions)) {
      extractStorageSpace(goodsShelf, loadOptions);
    }

    if (isExtractSupplierSpaceEnabled(loadOptions)) {
      extractSupplierSpace(goodsShelf, loadOptions);
    }

    if (isExtractDamageSpaceEnabled(loadOptions)) {
      extractDamageSpace(goodsShelf, loadOptions);
    }

    if (isExtractGoodsShelfStockCountListEnabled(loadOptions)) {
      extractGoodsShelfStockCountList(goodsShelf, loadOptions);
    }

    if (isAnalyzeGoodsShelfStockCountListEnabled(loadOptions)) {
      analyzeGoodsShelfStockCountList(goodsShelf, loadOptions);
    }

    if (isExtractGoodsAllocationListEnabled(loadOptions)) {
      extractGoodsAllocationList(goodsShelf, loadOptions);
    }

    if (isAnalyzeGoodsAllocationListEnabled(loadOptions)) {
      analyzeGoodsAllocationList(goodsShelf, loadOptions);
    }

    return goodsShelf;
  }

  protected GoodsShelf extractStorageSpace(GoodsShelf goodsShelf, Map<String, Object> options)
      throws Exception {

    if (goodsShelf.getStorageSpace() == null) {
      return goodsShelf;
    }
    String storageSpaceId = goodsShelf.getStorageSpace().getId();
    if (storageSpaceId == null) {
      return goodsShelf;
    }
    StorageSpace storageSpace = getStorageSpaceDAO().load(storageSpaceId, options);
    if (storageSpace != null) {
      goodsShelf.setStorageSpace(storageSpace);
    }

    return goodsShelf;
  }

  protected GoodsShelf extractSupplierSpace(GoodsShelf goodsShelf, Map<String, Object> options)
      throws Exception {

    if (goodsShelf.getSupplierSpace() == null) {
      return goodsShelf;
    }
    String supplierSpaceId = goodsShelf.getSupplierSpace().getId();
    if (supplierSpaceId == null) {
      return goodsShelf;
    }
    SupplierSpace supplierSpace = getSupplierSpaceDAO().load(supplierSpaceId, options);
    if (supplierSpace != null) {
      goodsShelf.setSupplierSpace(supplierSpace);
    }

    return goodsShelf;
  }

  protected GoodsShelf extractDamageSpace(GoodsShelf goodsShelf, Map<String, Object> options)
      throws Exception {

    if (goodsShelf.getDamageSpace() == null) {
      return goodsShelf;
    }
    String damageSpaceId = goodsShelf.getDamageSpace().getId();
    if (damageSpaceId == null) {
      return goodsShelf;
    }
    DamageSpace damageSpace = getDamageSpaceDAO().load(damageSpaceId, options);
    if (damageSpace != null) {
      goodsShelf.setDamageSpace(damageSpace);
    }

    return goodsShelf;
  }

  protected void enhanceGoodsShelfStockCountList(
      SmartList<GoodsShelfStockCount> goodsShelfStockCountList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected GoodsShelf extractGoodsShelfStockCountList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    if (goodsShelf == null) {
      return null;
    }
    if (goodsShelf.getId() == null) {
      return goodsShelf;
    }

    SmartList<GoodsShelfStockCount> goodsShelfStockCountList =
        getGoodsShelfStockCountDAO().findGoodsShelfStockCountByShelf(goodsShelf.getId(), options);
    if (goodsShelfStockCountList != null) {
      enhanceGoodsShelfStockCountList(goodsShelfStockCountList, options);
      goodsShelf.setGoodsShelfStockCountList(goodsShelfStockCountList);
    }

    return goodsShelf;
  }

  protected GoodsShelf analyzeGoodsShelfStockCountList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    if (goodsShelf == null) {
      return null;
    }
    if (goodsShelf.getId() == null) {
      return goodsShelf;
    }

    SmartList<GoodsShelfStockCount> goodsShelfStockCountList =
        goodsShelf.getGoodsShelfStockCountList();
    if (goodsShelfStockCountList != null) {
      getGoodsShelfStockCountDAO()
          .analyzeGoodsShelfStockCountByShelf(
              goodsShelfStockCountList, goodsShelf.getId(), options);
    }

    return goodsShelf;
  }

  protected void enhanceGoodsAllocationList(
      SmartList<GoodsAllocation> goodsAllocationList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected GoodsShelf extractGoodsAllocationList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    if (goodsShelf == null) {
      return null;
    }
    if (goodsShelf.getId() == null) {
      return goodsShelf;
    }

    SmartList<GoodsAllocation> goodsAllocationList =
        getGoodsAllocationDAO().findGoodsAllocationByGoodsShelf(goodsShelf.getId(), options);
    if (goodsAllocationList != null) {
      enhanceGoodsAllocationList(goodsAllocationList, options);
      goodsShelf.setGoodsAllocationList(goodsAllocationList);
    }

    return goodsShelf;
  }

  protected GoodsShelf analyzeGoodsAllocationList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    if (goodsShelf == null) {
      return null;
    }
    if (goodsShelf.getId() == null) {
      return goodsShelf;
    }

    SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
    if (goodsAllocationList != null) {
      getGoodsAllocationDAO()
          .analyzeGoodsAllocationByGoodsShelf(goodsAllocationList, goodsShelf.getId(), options);
    }

    return goodsShelf;
  }

  public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(
      String storageSpaceId, Map<String, Object> options) {

    SmartList<GoodsShelf> resultList =
        queryWith(
            GoodsShelfTable.COLUMN_STORAGE_SPACE, storageSpaceId, options, getGoodsShelfMapper());
    // analyzeGoodsShelfByStorageSpace(resultList, storageSpaceId, options);
    return resultList;
  }

  public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(
      String storageSpaceId, int start, int count, Map<String, Object> options) {

    SmartList<GoodsShelf> resultList =
        queryWithRange(
            GoodsShelfTable.COLUMN_STORAGE_SPACE,
            storageSpaceId,
            options,
            getGoodsShelfMapper(),
            start,
            count);
    // analyzeGoodsShelfByStorageSpace(resultList, storageSpaceId, options);
    return resultList;
  }

  public void analyzeGoodsShelfByStorageSpace(
      SmartList<GoodsShelf> resultList, String storageSpaceId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // GoodsShelf.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("货架");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(GoodsShelf.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(GoodsShelf.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countGoodsShelfByStorageSpace(String storageSpaceId, Map<String, Object> options) {

    return countWith(GoodsShelfTable.COLUMN_STORAGE_SPACE, storageSpaceId, options);
  }

  @Override
  public Map<String, Integer> countGoodsShelfByStorageSpaceIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(GoodsShelfTable.COLUMN_STORAGE_SPACE, ids, options);
  }

  public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(
      String supplierSpaceId, Map<String, Object> options) {

    SmartList<GoodsShelf> resultList =
        queryWith(
            GoodsShelfTable.COLUMN_SUPPLIER_SPACE, supplierSpaceId, options, getGoodsShelfMapper());
    // analyzeGoodsShelfBySupplierSpace(resultList, supplierSpaceId, options);
    return resultList;
  }

  public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(
      String supplierSpaceId, int start, int count, Map<String, Object> options) {

    SmartList<GoodsShelf> resultList =
        queryWithRange(
            GoodsShelfTable.COLUMN_SUPPLIER_SPACE,
            supplierSpaceId,
            options,
            getGoodsShelfMapper(),
            start,
            count);
    // analyzeGoodsShelfBySupplierSpace(resultList, supplierSpaceId, options);
    return resultList;
  }

  public void analyzeGoodsShelfBySupplierSpace(
      SmartList<GoodsShelf> resultList, String supplierSpaceId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // GoodsShelf.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("货架");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(GoodsShelf.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(GoodsShelf.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countGoodsShelfBySupplierSpace(String supplierSpaceId, Map<String, Object> options) {

    return countWith(GoodsShelfTable.COLUMN_SUPPLIER_SPACE, supplierSpaceId, options);
  }

  @Override
  public Map<String, Integer> countGoodsShelfBySupplierSpaceIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(GoodsShelfTable.COLUMN_SUPPLIER_SPACE, ids, options);
  }

  public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(
      String damageSpaceId, Map<String, Object> options) {

    SmartList<GoodsShelf> resultList =
        queryWith(
            GoodsShelfTable.COLUMN_DAMAGE_SPACE, damageSpaceId, options, getGoodsShelfMapper());
    // analyzeGoodsShelfByDamageSpace(resultList, damageSpaceId, options);
    return resultList;
  }

  public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(
      String damageSpaceId, int start, int count, Map<String, Object> options) {

    SmartList<GoodsShelf> resultList =
        queryWithRange(
            GoodsShelfTable.COLUMN_DAMAGE_SPACE,
            damageSpaceId,
            options,
            getGoodsShelfMapper(),
            start,
            count);
    // analyzeGoodsShelfByDamageSpace(resultList, damageSpaceId, options);
    return resultList;
  }

  public void analyzeGoodsShelfByDamageSpace(
      SmartList<GoodsShelf> resultList, String damageSpaceId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // GoodsShelf.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("货架");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(GoodsShelf.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(GoodsShelf.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countGoodsShelfByDamageSpace(String damageSpaceId, Map<String, Object> options) {

    return countWith(GoodsShelfTable.COLUMN_DAMAGE_SPACE, damageSpaceId, options);
  }

  @Override
  public Map<String, Integer> countGoodsShelfByDamageSpaceIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(GoodsShelfTable.COLUMN_DAMAGE_SPACE, ids, options);
  }

  protected GoodsShelf saveGoodsShelf(GoodsShelf goodsShelf) {

    if (!goodsShelf.isChanged()) {
      return goodsShelf;
    }

    Beans.dbUtil().cacheCleanUp(goodsShelf);
    String SQL = this.getSaveGoodsShelfSQL(goodsShelf);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveGoodsShelfParameters(goodsShelf);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    goodsShelf.incVersion();
    goodsShelf.afterSave();
    return goodsShelf;
  }

  public SmartList<GoodsShelf> saveGoodsShelfList(
      SmartList<GoodsShelf> goodsShelfList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitGoodsShelfList(goodsShelfList);

    batchGoodsShelfCreate((List<GoodsShelf>) lists[CREATE_LIST_INDEX]);
    batchGoodsShelfUpdate((List<GoodsShelf>) lists[UPDATE_LIST_INDEX]);
    batchGoodsShelfRemove((List<GoodsShelf>) lists[REMOVE_LIST_INDEX]);
    batchGoodsShelfRecover((List<GoodsShelf>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (GoodsShelf goodsShelf : goodsShelfList) {
      if (goodsShelf.isChanged()) {
        goodsShelf.incVersion();
        goodsShelf.afterSave();
      }
      if (goodsShelf.isToRecover() || goodsShelf.isToRemove()) {
        goodsShelf.setVersion(-goodsShelf.getVersion());
      }
    }

    return goodsShelfList;
  }

  public SmartList<GoodsShelf> removeGoodsShelfList(
      SmartList<GoodsShelf> goodsShelfList, Map<String, Object> options) {

    super.removeList(goodsShelfList, options);

    return goodsShelfList;
  }

  protected List<Object[]> prepareGoodsShelfBatchCreateArgs(List<GoodsShelf> goodsShelfList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsShelf goodsShelf : goodsShelfList) {
      Object[] parameters = prepareGoodsShelfCreateParameters(goodsShelf);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareGoodsShelfBatchUpdateArgs(List<GoodsShelf> goodsShelfList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsShelf goodsShelf : goodsShelfList) {
      if (!goodsShelf.isChanged()) {
        continue;
      }
      Object[] parameters = prepareGoodsShelfUpdateParameters(goodsShelf);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareGoodsShelfBatchRecoverArgs(List<GoodsShelf> goodsShelfList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsShelf goodsShelf : goodsShelfList) {
      if (!goodsShelf.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(goodsShelf);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareGoodsShelfBatchRemoveArgs(List<GoodsShelf> goodsShelfList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsShelf goodsShelf : goodsShelfList) {
      if (!goodsShelf.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareGoodsShelfRemoveParameters(goodsShelf);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchGoodsShelfCreate(List<GoodsShelf> goodsShelfList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareGoodsShelfBatchCreateArgs(goodsShelfList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchGoodsShelfUpdate(List<GoodsShelf> goodsShelfList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareGoodsShelfBatchUpdateArgs(goodsShelfList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchGoodsShelfRemove(List<GoodsShelf> goodsShelfList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareGoodsShelfBatchRemoveArgs(goodsShelfList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchGoodsShelfRecover(List<GoodsShelf> goodsShelfList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareGoodsShelfBatchRecoverArgs(goodsShelfList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitGoodsShelfList(List<GoodsShelf> goodsShelfList) {

    List<GoodsShelf> goodsShelfCreateList = new ArrayList<GoodsShelf>();
    List<GoodsShelf> goodsShelfUpdateList = new ArrayList<GoodsShelf>();
    List<GoodsShelf> goodsShelfRemoveList = new ArrayList<GoodsShelf>();
    List<GoodsShelf> goodsShelfRecoverList = new ArrayList<GoodsShelf>();

    for (GoodsShelf goodsShelf : goodsShelfList) {
      if (goodsShelf.isToRemove()) {
        goodsShelfRemoveList.add(goodsShelf);
        continue;
      }
      if (goodsShelf.isToRecover()) {
        goodsShelfRecoverList.add(goodsShelf);
        continue;
      }
      if (isUpdateRequest(goodsShelf)) {
        if (goodsShelf.isChanged()) {
          goodsShelfUpdateList.add(goodsShelf);
        }
        continue;
      }

      if (goodsShelf.isChanged()) {
        goodsShelfCreateList.add(goodsShelf);
      }
    }

    return new Object[] {
      goodsShelfCreateList, goodsShelfUpdateList, goodsShelfRemoveList, goodsShelfRecoverList
    };
  }

  protected boolean isUpdateRequest(GoodsShelf goodsShelf) {
    return goodsShelf.getVersion() > 0;
  }

  protected String getSaveGoodsShelfSQL(GoodsShelf goodsShelf) {
    if (goodsShelf.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(goodsShelf)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveGoodsShelfParameters(GoodsShelf goodsShelf) {
    if (goodsShelf.isToRemove()) {
      return prepareGoodsShelfRemoveParameters(goodsShelf);
    }
    if (goodsShelf.isToRecover()) {
      return prepareRecoverParameters(goodsShelf);
    }

    if (isUpdateRequest(goodsShelf)) {
      return prepareGoodsShelfUpdateParameters(goodsShelf);
    }
    return prepareGoodsShelfCreateParameters(goodsShelf);
  }

  protected Object[] prepareGoodsShelfRemoveParameters(GoodsShelf goodsShelf) {
    return super.prepareRemoveParameters(goodsShelf);
  }

  protected Object[] prepareGoodsShelfUpdateParameters(GoodsShelf goodsShelf) {
    Object[] parameters = new Object[8];

    parameters[0] = goodsShelf.getLocation();

    if (goodsShelf.getStorageSpace() != null) {
      parameters[1] = goodsShelf.getStorageSpace().getId();
    }

    if (goodsShelf.getSupplierSpace() != null) {
      parameters[2] = goodsShelf.getSupplierSpace().getId();
    }

    if (goodsShelf.getDamageSpace() != null) {
      parameters[3] = goodsShelf.getDamageSpace().getId();
    }

    parameters[4] = goodsShelf.getLastUpdateTime();

    parameters[5] = goodsShelf.nextVersion();
    parameters[6] = goodsShelf.getId();
    parameters[7] = goodsShelf.getVersion();

    return parameters;
  }

  protected Object[] prepareGoodsShelfCreateParameters(GoodsShelf goodsShelf) {
    Object[] parameters = new Object[6];
    if (goodsShelf.getId() == null) {
      String newGoodsShelfId = getNextId();
      goodsShelf.setId(newGoodsShelfId);
    }
    parameters[0] = goodsShelf.getId();

    parameters[1] = goodsShelf.getLocation();

    if (goodsShelf.getStorageSpace() != null) {
      parameters[2] = goodsShelf.getStorageSpace().getId();
    }

    if (goodsShelf.getSupplierSpace() != null) {
      parameters[3] = goodsShelf.getSupplierSpace().getId();
    }

    if (goodsShelf.getDamageSpace() != null) {
      parameters[4] = goodsShelf.getDamageSpace().getId();
    }

    parameters[5] = goodsShelf.getLastUpdateTime();

    return parameters;
  }

  protected GoodsShelf saveInternalGoodsShelf(GoodsShelf goodsShelf, Map<String, Object> options) {

    if (isSaveStorageSpaceEnabled(options)) {
      saveStorageSpace(goodsShelf, options);
    }

    if (isSaveSupplierSpaceEnabled(options)) {
      saveSupplierSpace(goodsShelf, options);
    }

    if (isSaveDamageSpaceEnabled(options)) {
      saveDamageSpace(goodsShelf, options);
    }

    saveGoodsShelf(goodsShelf);

    if (isSaveGoodsShelfStockCountListEnabled(options)) {
      saveGoodsShelfStockCountList(goodsShelf, options);
      // removeGoodsShelfStockCountList(goodsShelf, options);
      // Not delete the record

    }

    if (isSaveGoodsAllocationListEnabled(options)) {
      saveGoodsAllocationList(goodsShelf, options);
      // removeGoodsAllocationList(goodsShelf, options);
      // Not delete the record

    }

    return goodsShelf;
  }

  // ======================================================================================

  protected GoodsShelf saveStorageSpace(GoodsShelf goodsShelf, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (goodsShelf.getStorageSpace() == null) {
      return goodsShelf; // do nothing when it is null
    }

    getStorageSpaceDAO().save(goodsShelf.getStorageSpace(), options);
    return goodsShelf;
  }

  protected GoodsShelf saveSupplierSpace(GoodsShelf goodsShelf, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (goodsShelf.getSupplierSpace() == null) {
      return goodsShelf; // do nothing when it is null
    }

    getSupplierSpaceDAO().save(goodsShelf.getSupplierSpace(), options);
    return goodsShelf;
  }

  protected GoodsShelf saveDamageSpace(GoodsShelf goodsShelf, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (goodsShelf.getDamageSpace() == null) {
      return goodsShelf; // do nothing when it is null
    }

    getDamageSpaceDAO().save(goodsShelf.getDamageSpace(), options);
    return goodsShelf;
  }

  public GoodsShelf planToRemoveGoodsShelfStockCountList(
      GoodsShelf goodsShelf, String goodsShelfStockCountIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsShelfStockCount.SHELF_PROPERTY, goodsShelf.getId());
    key.put(GoodsShelfStockCount.ID_PROPERTY, goodsShelfStockCountIds);

    SmartList<GoodsShelfStockCount> externalGoodsShelfStockCountList =
        getGoodsShelfStockCountDAO().findGoodsShelfStockCountWithKey(key, options);
    if (externalGoodsShelfStockCountList == null) {
      return goodsShelf;
    }
    if (externalGoodsShelfStockCountList.isEmpty()) {
      return goodsShelf;
    }

    for (GoodsShelfStockCount goodsShelfStockCountItem : externalGoodsShelfStockCountList) {

      goodsShelfStockCountItem.clearFromAll();
    }

    SmartList<GoodsShelfStockCount> goodsShelfStockCountList =
        goodsShelf.getGoodsShelfStockCountList();
    goodsShelfStockCountList.addAllToRemoveList(externalGoodsShelfStockCountList);
    return goodsShelf;
  }

  public GoodsShelf planToRemoveGoodsAllocationList(
      GoodsShelf goodsShelf, String goodsAllocationIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(GoodsAllocation.GOODS_SHELF_PROPERTY, goodsShelf.getId());
    key.put(GoodsAllocation.ID_PROPERTY, goodsAllocationIds);

    SmartList<GoodsAllocation> externalGoodsAllocationList =
        getGoodsAllocationDAO().findGoodsAllocationWithKey(key, options);
    if (externalGoodsAllocationList == null) {
      return goodsShelf;
    }
    if (externalGoodsAllocationList.isEmpty()) {
      return goodsShelf;
    }

    for (GoodsAllocation goodsAllocationItem : externalGoodsAllocationList) {

      goodsAllocationItem.clearFromAll();
    }

    SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
    goodsAllocationList.addAllToRemoveList(externalGoodsAllocationList);
    return goodsShelf;
  }

  protected GoodsShelf saveGoodsShelfStockCountList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    SmartList<GoodsShelfStockCount> goodsShelfStockCountList =
        goodsShelf.getGoodsShelfStockCountList();
    if (goodsShelfStockCountList == null) {
      // null list means nothing
      return goodsShelf;
    }
    SmartList<GoodsShelfStockCount> mergedUpdateGoodsShelfStockCountList =
        new SmartList<GoodsShelfStockCount>();

    mergedUpdateGoodsShelfStockCountList.addAll(goodsShelfStockCountList);
    if (goodsShelfStockCountList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateGoodsShelfStockCountList.addAll(goodsShelfStockCountList.getToRemoveList());
      goodsShelfStockCountList.removeAll(goodsShelfStockCountList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getGoodsShelfStockCountDAO()
        .saveGoodsShelfStockCountList(mergedUpdateGoodsShelfStockCountList, options);

    if (goodsShelfStockCountList.getToRemoveList() != null) {
      goodsShelfStockCountList.removeAll(goodsShelfStockCountList.getToRemoveList());
    }

    return goodsShelf;
  }

  protected GoodsShelf removeGoodsShelfStockCountList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    SmartList<GoodsShelfStockCount> goodsShelfStockCountList =
        goodsShelf.getGoodsShelfStockCountList();
    if (goodsShelfStockCountList == null) {
      return goodsShelf;
    }

    SmartList<GoodsShelfStockCount> toRemoveGoodsShelfStockCountList =
        goodsShelfStockCountList.getToRemoveList();

    if (toRemoveGoodsShelfStockCountList == null) {
      return goodsShelf;
    }
    if (toRemoveGoodsShelfStockCountList.isEmpty()) {
      return goodsShelf; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getGoodsShelfStockCountDAO()
        .removeGoodsShelfStockCountList(toRemoveGoodsShelfStockCountList, options);

    return goodsShelf;
  }

  protected GoodsShelf saveGoodsAllocationList(GoodsShelf goodsShelf, Map<String, Object> options) {

    SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
    if (goodsAllocationList == null) {
      // null list means nothing
      return goodsShelf;
    }
    SmartList<GoodsAllocation> mergedUpdateGoodsAllocationList = new SmartList<GoodsAllocation>();

    mergedUpdateGoodsAllocationList.addAll(goodsAllocationList);
    if (goodsAllocationList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateGoodsAllocationList.addAll(goodsAllocationList.getToRemoveList());
      goodsAllocationList.removeAll(goodsAllocationList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getGoodsAllocationDAO().saveGoodsAllocationList(mergedUpdateGoodsAllocationList, options);

    if (goodsAllocationList.getToRemoveList() != null) {
      goodsAllocationList.removeAll(goodsAllocationList.getToRemoveList());
    }

    return goodsShelf;
  }

  protected GoodsShelf removeGoodsAllocationList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
    if (goodsAllocationList == null) {
      return goodsShelf;
    }

    SmartList<GoodsAllocation> toRemoveGoodsAllocationList = goodsAllocationList.getToRemoveList();

    if (toRemoveGoodsAllocationList == null) {
      return goodsShelf;
    }
    if (toRemoveGoodsAllocationList.isEmpty()) {
      return goodsShelf; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getGoodsAllocationDAO().removeGoodsAllocationList(toRemoveGoodsAllocationList, options);

    return goodsShelf;
  }

  public GoodsShelf present(GoodsShelf goodsShelf, Map<String, Object> options) {

    presentGoodsShelfStockCountList(goodsShelf, options);
    presentGoodsAllocationList(goodsShelf, options);

    return goodsShelf;
  }

  // Using java8 feature to reduce the code significantly
  protected GoodsShelf presentGoodsShelfStockCountList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    SmartList<GoodsShelfStockCount> goodsShelfStockCountList =
        goodsShelf.getGoodsShelfStockCountList();
    SmartList<GoodsShelfStockCount> newList =
        presentSubList(
            goodsShelf.getId(),
            goodsShelfStockCountList,
            options,
            getGoodsShelfStockCountDAO()::countGoodsShelfStockCountByShelf,
            getGoodsShelfStockCountDAO()::findGoodsShelfStockCountByShelf);

    goodsShelf.setGoodsShelfStockCountList(newList);

    return goodsShelf;
  }

  // Using java8 feature to reduce the code significantly
  protected GoodsShelf presentGoodsAllocationList(
      GoodsShelf goodsShelf, Map<String, Object> options) {

    SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
    SmartList<GoodsAllocation> newList =
        presentSubList(
            goodsShelf.getId(),
            goodsAllocationList,
            options,
            getGoodsAllocationDAO()::countGoodsAllocationByGoodsShelf,
            getGoodsAllocationDAO()::findGoodsAllocationByGoodsShelf);

    goodsShelf.setGoodsAllocationList(newList);

    return goodsShelf;
  }

  public SmartList<GoodsShelf> requestCandidateGoodsShelfForGoodsShelfStockCount(
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
        GoodsShelfTable.COLUMN_LOCATION,
        GoodsShelfTable.COLUMN_STORAGE_SPACE,
        filterKey,
        pageNo,
        pageSize,
        getGoodsShelfMapper());
  }

  public SmartList<GoodsShelf> requestCandidateGoodsShelfForGoodsAllocation(
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
        GoodsShelfTable.COLUMN_LOCATION,
        GoodsShelfTable.COLUMN_STORAGE_SPACE,
        filterKey,
        pageNo,
        pageSize,
        getGoodsShelfMapper());
  }

  protected String getTableName() {
    return GoodsShelfTable.TABLE_NAME;
  }

  public void enhanceList(List<GoodsShelf> goodsShelfList) {
    this.enhanceListInternal(goodsShelfList, this.getGoodsShelfMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<GoodsShelf> goodsShelfList = ownerEntity.collectRefsWithType(GoodsShelf.INTERNAL_TYPE);
    this.enhanceList(goodsShelfList);
  }

  @Override
  public SmartList<GoodsShelf> findGoodsShelfWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getGoodsShelfMapper());
  }

  @Override
  public int countGoodsShelfWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countGoodsShelfWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<GoodsShelf> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getGoodsShelfMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<GoodsShelf> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getGoodsShelfMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateGoodsShelf executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateGoodsShelf result = new CandidateGoodsShelf();
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
  public List<GoodsShelf> search(GoodsShelfRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected GoodsShelfMapper mapper() {
    return getGoodsShelfMapper();
  }

  @Override
  protected GoodsShelfMapper mapperForClazz(Class<?> clazz) {
    return GoodsShelfMapper.mapperForClass(clazz);
  }
}
