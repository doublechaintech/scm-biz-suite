package com.doublechaintech.retailscm.smartpallet;

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

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class SmartPalletJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SmartPalletDAO {

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

  protected GoodsDAO goodsDAO;

  public void setGoodsDAO(GoodsDAO goodsDAO) {

    if (goodsDAO == null) {
      throw new IllegalStateException("Do not try to set goodsDAO to null.");
    }
    this.goodsDAO = goodsDAO;
  }

  public GoodsDAO getGoodsDAO() {
    if (this.goodsDAO == null) {
      throw new IllegalStateException(
          "The goodsDAO is not configured yet, please config it some where.");
    }

    return this.goodsDAO;
  }

  /*
  protected SmartPallet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalSmartPallet(accessKey, options);
  }
  */

  public SmartList<SmartPallet> loadAll() {
    return this.loadAll(getSmartPalletMapper());
  }

  public Stream<SmartPallet> loadAllAsStream() {
    return this.loadAllAsStream(getSmartPalletMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public SmartPallet load(String id, Map<String, Object> options) throws Exception {
    return loadInternalSmartPallet(SmartPalletTable.withId(id), options);
  }

  public SmartPallet save(SmartPallet smartPallet, Map<String, Object> options) {

    String methodName = "save(SmartPallet smartPallet,Map<String,Object> options)";

    assertMethodArgumentNotNull(smartPallet, methodName, "smartPallet");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalSmartPallet(smartPallet, options);
  }

  public SmartPallet clone(String smartPalletId, Map<String, Object> options) throws Exception {

    return clone(SmartPalletTable.withId(smartPalletId), options);
  }

  protected SmartPallet clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String smartPalletId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    SmartPallet newSmartPallet = loadInternalSmartPallet(accessKey, options);
    newSmartPallet.setVersion(0);

    if (isSaveGoodsListEnabled(options)) {
      for (Goods item : newSmartPallet.getGoodsList()) {
        item.setVersion(0);
      }
    }

    saveInternalSmartPallet(newSmartPallet, options);

    return newSmartPallet;
  }

  protected void throwIfHasException(String smartPalletId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new SmartPalletVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new SmartPalletNotFoundException(
          "The " + this.getTableName() + "(" + smartPalletId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public SmartPallet disconnectFromAll(String smartPalletId, int version) throws Exception {

    SmartPallet smartPallet =
        loadInternalSmartPallet(SmartPalletTable.withId(smartPalletId), emptyOptions());
    smartPallet.clearFromAll();
    this.saveSmartPallet(smartPallet);
    return smartPallet;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return SmartPalletTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "smart_pallet";
  }

  @Override
  protected String getBeanName() {

    return "smartPallet";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return SmartPalletTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractWarehouseEnabled(Map<String, Object> options) {

    return checkOptions(options, SmartPalletTokens.WAREHOUSE);
  }

  protected boolean isSaveWarehouseEnabled(Map<String, Object> options) {

    return checkOptions(options, SmartPalletTokens.WAREHOUSE);
  }

  protected boolean isExtractGoodsListEnabled(Map<String, Object> options) {
    return checkOptions(options, SmartPalletTokens.GOODS_LIST);
  }

  protected boolean isAnalyzeGoodsListEnabled(Map<String, Object> options) {
    return SmartPalletTokens.of(options).analyzeGoodsListEnabled();
  }

  protected boolean isSaveGoodsListEnabled(Map<String, Object> options) {
    return checkOptions(options, SmartPalletTokens.GOODS_LIST);
  }

  protected SmartPalletMapper getSmartPalletMapper() {
    return new SmartPalletMapper();
  }

  protected SmartPallet extractSmartPallet(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      SmartPallet smartPallet = loadSingleObject(accessKey, getSmartPalletMapper());
      return smartPallet;
    } catch (EmptyResultDataAccessException e) {
      throw new SmartPalletNotFoundException("SmartPallet(" + accessKey + ") is not found!");
    }
  }

  protected SmartPallet loadInternalSmartPallet(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    SmartPallet smartPallet = extractSmartPallet(accessKey, loadOptions);

    if (isExtractWarehouseEnabled(loadOptions)) {
      extractWarehouse(smartPallet, loadOptions);
    }

    if (isExtractGoodsListEnabled(loadOptions)) {
      extractGoodsList(smartPallet, loadOptions);
    }

    if (isAnalyzeGoodsListEnabled(loadOptions)) {
      analyzeGoodsList(smartPallet, loadOptions);
    }

    return smartPallet;
  }

  protected SmartPallet extractWarehouse(SmartPallet smartPallet, Map<String, Object> options)
      throws Exception {

    if (smartPallet.getWarehouse() == null) {
      return smartPallet;
    }
    String warehouseId = smartPallet.getWarehouse().getId();
    if (warehouseId == null) {
      return smartPallet;
    }
    Warehouse warehouse = getWarehouseDAO().load(warehouseId, options);
    if (warehouse != null) {
      smartPallet.setWarehouse(warehouse);
    }

    return smartPallet;
  }

  protected void enhanceGoodsList(SmartList<Goods> goodsList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected SmartPallet extractGoodsList(SmartPallet smartPallet, Map<String, Object> options) {

    if (smartPallet == null) {
      return null;
    }
    if (smartPallet.getId() == null) {
      return smartPallet;
    }

    SmartList<Goods> goodsList = getGoodsDAO().findGoodsBySmartPallet(smartPallet.getId(), options);
    if (goodsList != null) {
      enhanceGoodsList(goodsList, options);
      smartPallet.setGoodsList(goodsList);
    }

    return smartPallet;
  }

  protected SmartPallet analyzeGoodsList(SmartPallet smartPallet, Map<String, Object> options) {

    if (smartPallet == null) {
      return null;
    }
    if (smartPallet.getId() == null) {
      return smartPallet;
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    if (goodsList != null) {
      getGoodsDAO().analyzeGoodsBySmartPallet(goodsList, smartPallet.getId(), options);
    }

    return smartPallet;
  }

  public SmartList<SmartPallet> findSmartPalletByWarehouse(
      String warehouseId, Map<String, Object> options) {

    SmartList<SmartPallet> resultList =
        queryWith(SmartPalletTable.COLUMN_WAREHOUSE, warehouseId, options, getSmartPalletMapper());
    // analyzeSmartPalletByWarehouse(resultList, warehouseId, options);
    return resultList;
  }

  public SmartList<SmartPallet> findSmartPalletByWarehouse(
      String warehouseId, int start, int count, Map<String, Object> options) {

    SmartList<SmartPallet> resultList =
        queryWithRange(
            SmartPalletTable.COLUMN_WAREHOUSE,
            warehouseId,
            options,
            getSmartPalletMapper(),
            start,
            count);
    // analyzeSmartPalletByWarehouse(resultList, warehouseId, options);
    return resultList;
  }

  public void analyzeSmartPalletByWarehouse(
      SmartList<SmartPallet> resultList, String warehouseId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(SmartPallet.WAREHOUSE_PROPERTY, warehouseId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // SmartPallet.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("智能托盘");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(SmartPallet.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(SmartPallet.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countSmartPalletByWarehouse(String warehouseId, Map<String, Object> options) {

    return countWith(SmartPalletTable.COLUMN_WAREHOUSE, warehouseId, options);
  }

  @Override
  public Map<String, Integer> countSmartPalletByWarehouseIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(SmartPalletTable.COLUMN_WAREHOUSE, ids, options);
  }

  protected SmartPallet saveSmartPallet(SmartPallet smartPallet) {

    if (!smartPallet.isChanged()) {
      return smartPallet;
    }

    Beans.dbUtil().cacheCleanUp(smartPallet);
    String SQL = this.getSaveSmartPalletSQL(smartPallet);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveSmartPalletParameters(smartPallet);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    smartPallet.incVersion();
    smartPallet.afterSave();
    return smartPallet;
  }

  public SmartList<SmartPallet> saveSmartPalletList(
      SmartList<SmartPallet> smartPalletList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitSmartPalletList(smartPalletList);

    batchSmartPalletCreate((List<SmartPallet>) lists[CREATE_LIST_INDEX]);
    batchSmartPalletUpdate((List<SmartPallet>) lists[UPDATE_LIST_INDEX]);
    batchSmartPalletRemove((List<SmartPallet>) lists[REMOVE_LIST_INDEX]);
    batchSmartPalletRecover((List<SmartPallet>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (SmartPallet smartPallet : smartPalletList) {
      if (smartPallet.isChanged()) {
        smartPallet.incVersion();
        smartPallet.afterSave();
      }
      if (smartPallet.isToRecover() || smartPallet.isToRemove()) {
        smartPallet.setVersion(-smartPallet.getVersion());
      }
    }

    return smartPalletList;
  }

  public SmartList<SmartPallet> removeSmartPalletList(
      SmartList<SmartPallet> smartPalletList, Map<String, Object> options) {

    super.removeList(smartPalletList, options);

    return smartPalletList;
  }

  protected List<Object[]> prepareSmartPalletBatchCreateArgs(List<SmartPallet> smartPalletList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SmartPallet smartPallet : smartPalletList) {
      Object[] parameters = prepareSmartPalletCreateParameters(smartPallet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareSmartPalletBatchUpdateArgs(List<SmartPallet> smartPalletList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SmartPallet smartPallet : smartPalletList) {
      if (!smartPallet.isChanged()) {
        continue;
      }
      Object[] parameters = prepareSmartPalletUpdateParameters(smartPallet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareSmartPalletBatchRecoverArgs(List<SmartPallet> smartPalletList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SmartPallet smartPallet : smartPalletList) {
      if (!smartPallet.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(smartPallet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareSmartPalletBatchRemoveArgs(List<SmartPallet> smartPalletList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (SmartPallet smartPallet : smartPalletList) {
      if (!smartPallet.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareSmartPalletRemoveParameters(smartPallet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchSmartPalletCreate(List<SmartPallet> smartPalletList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareSmartPalletBatchCreateArgs(smartPalletList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchSmartPalletUpdate(List<SmartPallet> smartPalletList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareSmartPalletBatchUpdateArgs(smartPalletList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchSmartPalletRemove(List<SmartPallet> smartPalletList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareSmartPalletBatchRemoveArgs(smartPalletList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchSmartPalletRecover(List<SmartPallet> smartPalletList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareSmartPalletBatchRecoverArgs(smartPalletList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitSmartPalletList(List<SmartPallet> smartPalletList) {

    List<SmartPallet> smartPalletCreateList = new ArrayList<SmartPallet>();
    List<SmartPallet> smartPalletUpdateList = new ArrayList<SmartPallet>();
    List<SmartPallet> smartPalletRemoveList = new ArrayList<SmartPallet>();
    List<SmartPallet> smartPalletRecoverList = new ArrayList<SmartPallet>();

    for (SmartPallet smartPallet : smartPalletList) {
      if (smartPallet.isToRemove()) {
        smartPalletRemoveList.add(smartPallet);
        continue;
      }
      if (smartPallet.isToRecover()) {
        smartPalletRecoverList.add(smartPallet);
        continue;
      }
      if (isUpdateRequest(smartPallet)) {
        if (smartPallet.isChanged()) {
          smartPalletUpdateList.add(smartPallet);
        }
        continue;
      }

      if (smartPallet.isChanged()) {
        smartPalletCreateList.add(smartPallet);
      }
    }

    return new Object[] {
      smartPalletCreateList, smartPalletUpdateList, smartPalletRemoveList, smartPalletRecoverList
    };
  }

  protected boolean isUpdateRequest(SmartPallet smartPallet) {
    return smartPallet.getVersion() > 0;
  }

  protected String getSaveSmartPalletSQL(SmartPallet smartPallet) {
    if (smartPallet.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(smartPallet)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveSmartPalletParameters(SmartPallet smartPallet) {
    if (smartPallet.isToRemove()) {
      return prepareSmartPalletRemoveParameters(smartPallet);
    }
    if (smartPallet.isToRecover()) {
      return prepareRecoverParameters(smartPallet);
    }

    if (isUpdateRequest(smartPallet)) {
      return prepareSmartPalletUpdateParameters(smartPallet);
    }
    return prepareSmartPalletCreateParameters(smartPallet);
  }

  protected Object[] prepareSmartPalletRemoveParameters(SmartPallet smartPallet) {
    return super.prepareRemoveParameters(smartPallet);
  }

  protected Object[] prepareSmartPalletUpdateParameters(SmartPallet smartPallet) {
    Object[] parameters = new Object[10];

    parameters[0] = smartPallet.getLocation();

    parameters[1] = smartPallet.getContactNumber();

    parameters[2] = smartPallet.getTotalArea();

    parameters[3] = smartPallet.getLatitude();

    parameters[4] = smartPallet.getLongitude();

    if (smartPallet.getWarehouse() != null) {
      parameters[5] = smartPallet.getWarehouse().getId();
    }

    parameters[6] = smartPallet.getLastUpdateTime();

    parameters[7] = smartPallet.nextVersion();
    parameters[8] = smartPallet.getId();
    parameters[9] = smartPallet.getVersion();

    return parameters;
  }

  protected Object[] prepareSmartPalletCreateParameters(SmartPallet smartPallet) {
    Object[] parameters = new Object[8];
    if (smartPallet.getId() == null) {
      String newSmartPalletId = getNextId();
      smartPallet.setId(newSmartPalletId);
    }
    parameters[0] = smartPallet.getId();

    parameters[1] = smartPallet.getLocation();

    parameters[2] = smartPallet.getContactNumber();

    parameters[3] = smartPallet.getTotalArea();

    parameters[4] = smartPallet.getLatitude();

    parameters[5] = smartPallet.getLongitude();

    if (smartPallet.getWarehouse() != null) {
      parameters[6] = smartPallet.getWarehouse().getId();
    }

    parameters[7] = smartPallet.getLastUpdateTime();

    return parameters;
  }

  protected SmartPallet saveInternalSmartPallet(
      SmartPallet smartPallet, Map<String, Object> options) {

    if (isSaveWarehouseEnabled(options)) {
      saveWarehouse(smartPallet, options);
    }

    saveSmartPallet(smartPallet);

    if (isSaveGoodsListEnabled(options)) {
      saveGoodsList(smartPallet, options);
      // removeGoodsList(smartPallet, options);
      // Not delete the record

    }

    return smartPallet;
  }

  // ======================================================================================

  protected SmartPallet saveWarehouse(SmartPallet smartPallet, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (smartPallet.getWarehouse() == null) {
      return smartPallet; // do nothing when it is null
    }

    getWarehouseDAO().save(smartPallet.getWarehouse(), options);
    return smartPallet;
  }

  public SmartPallet planToRemoveGoodsList(
      SmartPallet smartPallet, String goodsIds[], Map<String, Object> options) throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.ID_PROPERTY, goodsIds);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {

      goodsItem.clearFromAll();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  // disconnect SmartPallet with sku in Goods
  public SmartPallet planToRemoveGoodsListWithSku(
      SmartPallet smartPallet, String skuId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.SKU_PROPERTY, skuId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearSku();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithSku(String smartPalletId, String skuId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.SKU_PROPERTY, skuId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with receiving_space in Goods
  public SmartPallet planToRemoveGoodsListWithReceivingSpace(
      SmartPallet smartPallet, String receivingSpaceId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearReceivingSpace();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithReceivingSpace(
      String smartPalletId, String receivingSpaceId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with goods_allocation in Goods
  public SmartPallet planToRemoveGoodsListWithGoodsAllocation(
      SmartPallet smartPallet, String goodsAllocationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearGoodsAllocation();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithGoodsAllocation(
      String smartPalletId, String goodsAllocationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with shipping_space in Goods
  public SmartPallet planToRemoveGoodsListWithShippingSpace(
      SmartPallet smartPallet, String shippingSpaceId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearShippingSpace();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithShippingSpace(
      String smartPalletId, String shippingSpaceId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with transport_task in Goods
  public SmartPallet planToRemoveGoodsListWithTransportTask(
      SmartPallet smartPallet, String transportTaskId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearTransportTask();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithTransportTask(
      String smartPalletId, String transportTaskId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with retail_store in Goods
  public SmartPallet planToRemoveGoodsListWithRetailStore(
      SmartPallet smartPallet, String retailStoreId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearRetailStore();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithRetailStore(
      String smartPalletId, String retailStoreId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with biz_order in Goods
  public SmartPallet planToRemoveGoodsListWithBizOrder(
      SmartPallet smartPallet, String bizOrderId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearBizOrder();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithBizOrder(
      String smartPalletId, String bizOrderId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  // disconnect SmartPallet with retail_store_order in Goods
  public SmartPallet planToRemoveGoodsListWithRetailStoreOrder(
      SmartPallet smartPallet, String retailStoreOrderId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPallet.getId());
    key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

    SmartList<Goods> externalGoodsList = getGoodsDAO().findGoodsWithKey(key, options);
    if (externalGoodsList == null) {
      return smartPallet;
    }
    if (externalGoodsList.isEmpty()) {
      return smartPallet;
    }

    for (Goods goodsItem : externalGoodsList) {
      goodsItem.clearRetailStoreOrder();
      goodsItem.clearSmartPallet();
    }

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    goodsList.addAllToRemoveList(externalGoodsList);
    return smartPallet;
  }

  public int countGoodsListWithRetailStoreOrder(
      String smartPalletId, String retailStoreOrderId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
    key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

    int count = getGoodsDAO().countGoodsWithKey(key, options);
    return count;
  }

  protected SmartPallet saveGoodsList(SmartPallet smartPallet, Map<String, Object> options) {

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    if (goodsList == null) {
      // null list means nothing
      return smartPallet;
    }
    SmartList<Goods> mergedUpdateGoodsList = new SmartList<Goods>();

    mergedUpdateGoodsList.addAll(goodsList);
    if (goodsList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateGoodsList.addAll(goodsList.getToRemoveList());
      goodsList.removeAll(goodsList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getGoodsDAO().saveGoodsList(mergedUpdateGoodsList, options);

    if (goodsList.getToRemoveList() != null) {
      goodsList.removeAll(goodsList.getToRemoveList());
    }

    return smartPallet;
  }

  protected SmartPallet removeGoodsList(SmartPallet smartPallet, Map<String, Object> options) {

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    if (goodsList == null) {
      return smartPallet;
    }

    SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

    if (toRemoveGoodsList == null) {
      return smartPallet;
    }
    if (toRemoveGoodsList.isEmpty()) {
      return smartPallet; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getGoodsDAO().removeGoodsList(toRemoveGoodsList, options);

    return smartPallet;
  }

  public SmartPallet present(SmartPallet smartPallet, Map<String, Object> options) {

    presentGoodsList(smartPallet, options);

    return smartPallet;
  }

  // Using java8 feature to reduce the code significantly
  protected SmartPallet presentGoodsList(SmartPallet smartPallet, Map<String, Object> options) {

    SmartList<Goods> goodsList = smartPallet.getGoodsList();
    SmartList<Goods> newList =
        presentSubList(
            smartPallet.getId(),
            goodsList,
            options,
            getGoodsDAO()::countGoodsBySmartPallet,
            getGoodsDAO()::findGoodsBySmartPallet);

    smartPallet.setGoodsList(newList);

    return smartPallet;
  }

  public SmartList<SmartPallet> requestCandidateSmartPalletForGoods(
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
        SmartPalletTable.COLUMN_LOCATION,
        SmartPalletTable.COLUMN_WAREHOUSE,
        filterKey,
        pageNo,
        pageSize,
        getSmartPalletMapper());
  }

  protected String getTableName() {
    return SmartPalletTable.TABLE_NAME;
  }

  public void enhanceList(List<SmartPallet> smartPalletList) {
    this.enhanceListInternal(smartPalletList, this.getSmartPalletMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<SmartPallet> smartPalletList = ownerEntity.collectRefsWithType(SmartPallet.INTERNAL_TYPE);
    this.enhanceList(smartPalletList);
  }

  @Override
  public SmartList<SmartPallet> findSmartPalletWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getSmartPalletMapper());
  }

  @Override
  public int countSmartPalletWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countSmartPalletWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<SmartPallet> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getSmartPalletMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<SmartPallet> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getSmartPalletMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateSmartPallet executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateSmartPallet result = new CandidateSmartPallet();
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
  public List<SmartPallet> search(SmartPalletRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected SmartPalletMapper mapper() {
    return getSmartPalletMapper();
  }

  @Override
  protected SmartPalletMapper mapperForClazz(Class<?> clazz) {
    return SmartPalletMapper.mapperForClass(clazz);
  }
}
