package com.doublechaintech.retailscm.goodssupplier;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.supplierproduct.SupplierProductDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class GoodsSupplierJDBCTemplateDAO extends RetailscmBaseDAOImpl implements GoodsSupplierDAO {

  protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;

  public void setRetailStoreCountryCenterDAO(
      RetailStoreCountryCenterDAO retailStoreCountryCenterDAO) {

    if (retailStoreCountryCenterDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
    }
    this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
  }

  public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO() {
    if (this.retailStoreCountryCenterDAO == null) {
      throw new IllegalStateException(
          "The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreCountryCenterDAO;
  }

  protected SupplierProductDAO supplierProductDAO;

  public void setSupplierProductDAO(SupplierProductDAO supplierProductDAO) {

    if (supplierProductDAO == null) {
      throw new IllegalStateException("Do not try to set supplierProductDAO to null.");
    }
    this.supplierProductDAO = supplierProductDAO;
  }

  public SupplierProductDAO getSupplierProductDAO() {
    if (this.supplierProductDAO == null) {
      throw new IllegalStateException(
          "The supplierProductDAO is not configured yet, please config it some where.");
    }

    return this.supplierProductDAO;
  }

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

  protected AccountSetDAO accountSetDAO;

  public void setAccountSetDAO(AccountSetDAO accountSetDAO) {

    if (accountSetDAO == null) {
      throw new IllegalStateException("Do not try to set accountSetDAO to null.");
    }
    this.accountSetDAO = accountSetDAO;
  }

  public AccountSetDAO getAccountSetDAO() {
    if (this.accountSetDAO == null) {
      throw new IllegalStateException(
          "The accountSetDAO is not configured yet, please config it some where.");
    }

    return this.accountSetDAO;
  }

  /*
  protected GoodsSupplier load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalGoodsSupplier(accessKey, options);
  }
  */

  public SmartList<GoodsSupplier> loadAll() {
    return this.loadAll(getGoodsSupplierMapper());
  }

  public Stream<GoodsSupplier> loadAllAsStream() {
    return this.loadAllAsStream(getGoodsSupplierMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public GoodsSupplier load(String id, Map<String, Object> options) throws Exception {
    return loadInternalGoodsSupplier(GoodsSupplierTable.withId(id), options);
  }

  public GoodsSupplier save(GoodsSupplier goodsSupplier, Map<String, Object> options) {

    String methodName = "save(GoodsSupplier goodsSupplier,Map<String,Object> options)";

    assertMethodArgumentNotNull(goodsSupplier, methodName, "goodsSupplier");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalGoodsSupplier(goodsSupplier, options);
  }

  public GoodsSupplier clone(String goodsSupplierId, Map<String, Object> options) throws Exception {

    return clone(GoodsSupplierTable.withId(goodsSupplierId), options);
  }

  protected GoodsSupplier clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String goodsSupplierId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    GoodsSupplier newGoodsSupplier = loadInternalGoodsSupplier(accessKey, options);
    newGoodsSupplier.setVersion(0);

    if (isSaveSupplierProductListEnabled(options)) {
      for (SupplierProduct item : newGoodsSupplier.getSupplierProductList()) {
        item.setVersion(0);
      }
    }

    if (isSaveSupplyOrderListEnabled(options)) {
      for (SupplyOrder item : newGoodsSupplier.getSupplyOrderList()) {
        item.setVersion(0);
      }
    }

    if (isSaveAccountSetListEnabled(options)) {
      for (AccountSet item : newGoodsSupplier.getAccountSetList()) {
        item.setVersion(0);
      }
    }

    saveInternalGoodsSupplier(newGoodsSupplier, options);

    return newGoodsSupplier;
  }

  protected void throwIfHasException(String goodsSupplierId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new GoodsSupplierVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new GoodsSupplierNotFoundException(
          "The " + this.getTableName() + "(" + goodsSupplierId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public GoodsSupplier disconnectFromAll(String goodsSupplierId, int version) throws Exception {

    GoodsSupplier goodsSupplier =
        loadInternalGoodsSupplier(GoodsSupplierTable.withId(goodsSupplierId), emptyOptions());
    goodsSupplier.clearFromAll();
    this.saveGoodsSupplier(goodsSupplier);
    return goodsSupplier;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return GoodsSupplierTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "goods_supplier";
  }

  @Override
  protected String getBeanName() {

    return "goodsSupplier";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return GoodsSupplierTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractBelongToEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsSupplierTokens.BELONGTO);
  }

  protected boolean isSaveBelongToEnabled(Map<String, Object> options) {

    return checkOptions(options, GoodsSupplierTokens.BELONGTO);
  }

  protected boolean isExtractSupplierProductListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsSupplierTokens.SUPPLIER_PRODUCT_LIST);
  }

  protected boolean isAnalyzeSupplierProductListEnabled(Map<String, Object> options) {
    return GoodsSupplierTokens.of(options).analyzeSupplierProductListEnabled();
  }

  protected boolean isSaveSupplierProductListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsSupplierTokens.SUPPLIER_PRODUCT_LIST);
  }

  protected boolean isExtractSupplyOrderListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsSupplierTokens.SUPPLY_ORDER_LIST);
  }

  protected boolean isAnalyzeSupplyOrderListEnabled(Map<String, Object> options) {
    return GoodsSupplierTokens.of(options).analyzeSupplyOrderListEnabled();
  }

  protected boolean isSaveSupplyOrderListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsSupplierTokens.SUPPLY_ORDER_LIST);
  }

  protected boolean isExtractAccountSetListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsSupplierTokens.ACCOUNT_SET_LIST);
  }

  protected boolean isAnalyzeAccountSetListEnabled(Map<String, Object> options) {
    return GoodsSupplierTokens.of(options).analyzeAccountSetListEnabled();
  }

  protected boolean isSaveAccountSetListEnabled(Map<String, Object> options) {
    return checkOptions(options, GoodsSupplierTokens.ACCOUNT_SET_LIST);
  }

  protected GoodsSupplierMapper getGoodsSupplierMapper() {
    return new GoodsSupplierMapper();
  }

  protected GoodsSupplier extractGoodsSupplier(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      GoodsSupplier goodsSupplier = loadSingleObject(accessKey, getGoodsSupplierMapper());
      return goodsSupplier;
    } catch (EmptyResultDataAccessException e) {
      throw new GoodsSupplierNotFoundException("GoodsSupplier(" + accessKey + ") is not found!");
    }
  }

  protected GoodsSupplier loadInternalGoodsSupplier(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    GoodsSupplier goodsSupplier = extractGoodsSupplier(accessKey, loadOptions);

    if (isExtractBelongToEnabled(loadOptions)) {
      extractBelongTo(goodsSupplier, loadOptions);
    }

    if (isExtractSupplierProductListEnabled(loadOptions)) {
      extractSupplierProductList(goodsSupplier, loadOptions);
    }

    if (isAnalyzeSupplierProductListEnabled(loadOptions)) {
      analyzeSupplierProductList(goodsSupplier, loadOptions);
    }

    if (isExtractSupplyOrderListEnabled(loadOptions)) {
      extractSupplyOrderList(goodsSupplier, loadOptions);
    }

    if (isAnalyzeSupplyOrderListEnabled(loadOptions)) {
      analyzeSupplyOrderList(goodsSupplier, loadOptions);
    }

    if (isExtractAccountSetListEnabled(loadOptions)) {
      extractAccountSetList(goodsSupplier, loadOptions);
    }

    if (isAnalyzeAccountSetListEnabled(loadOptions)) {
      analyzeAccountSetList(goodsSupplier, loadOptions);
    }

    return goodsSupplier;
  }

  protected GoodsSupplier extractBelongTo(GoodsSupplier goodsSupplier, Map<String, Object> options)
      throws Exception {

    if (goodsSupplier.getBelongTo() == null) {
      return goodsSupplier;
    }
    String belongToId = goodsSupplier.getBelongTo().getId();
    if (belongToId == null) {
      return goodsSupplier;
    }
    RetailStoreCountryCenter belongTo = getRetailStoreCountryCenterDAO().load(belongToId, options);
    if (belongTo != null) {
      goodsSupplier.setBelongTo(belongTo);
    }

    return goodsSupplier;
  }

  protected void enhanceSupplierProductList(
      SmartList<SupplierProduct> supplierProductList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected GoodsSupplier extractSupplierProductList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (goodsSupplier == null) {
      return null;
    }
    if (goodsSupplier.getId() == null) {
      return goodsSupplier;
    }

    SmartList<SupplierProduct> supplierProductList =
        getSupplierProductDAO().findSupplierProductBySupplier(goodsSupplier.getId(), options);
    if (supplierProductList != null) {
      enhanceSupplierProductList(supplierProductList, options);
      goodsSupplier.setSupplierProductList(supplierProductList);
    }

    return goodsSupplier;
  }

  protected GoodsSupplier analyzeSupplierProductList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (goodsSupplier == null) {
      return null;
    }
    if (goodsSupplier.getId() == null) {
      return goodsSupplier;
    }

    SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
    if (supplierProductList != null) {
      getSupplierProductDAO()
          .analyzeSupplierProductBySupplier(supplierProductList, goodsSupplier.getId(), options);
    }

    return goodsSupplier;
  }

  protected void enhanceSupplyOrderList(
      SmartList<SupplyOrder> supplyOrderList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected GoodsSupplier extractSupplyOrderList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (goodsSupplier == null) {
      return null;
    }
    if (goodsSupplier.getId() == null) {
      return goodsSupplier;
    }

    SmartList<SupplyOrder> supplyOrderList =
        getSupplyOrderDAO().findSupplyOrderBySeller(goodsSupplier.getId(), options);
    if (supplyOrderList != null) {
      enhanceSupplyOrderList(supplyOrderList, options);
      goodsSupplier.setSupplyOrderList(supplyOrderList);
    }

    return goodsSupplier;
  }

  protected GoodsSupplier analyzeSupplyOrderList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (goodsSupplier == null) {
      return null;
    }
    if (goodsSupplier.getId() == null) {
      return goodsSupplier;
    }

    SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
    if (supplyOrderList != null) {
      getSupplyOrderDAO()
          .analyzeSupplyOrderBySeller(supplyOrderList, goodsSupplier.getId(), options);
    }

    return goodsSupplier;
  }

  protected void enhanceAccountSetList(
      SmartList<AccountSet> accountSetList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected GoodsSupplier extractAccountSetList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (goodsSupplier == null) {
      return null;
    }
    if (goodsSupplier.getId() == null) {
      return goodsSupplier;
    }

    SmartList<AccountSet> accountSetList =
        getAccountSetDAO().findAccountSetByGoodsSupplier(goodsSupplier.getId(), options);
    if (accountSetList != null) {
      enhanceAccountSetList(accountSetList, options);
      goodsSupplier.setAccountSetList(accountSetList);
    }

    return goodsSupplier;
  }

  protected GoodsSupplier analyzeAccountSetList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (goodsSupplier == null) {
      return null;
    }
    if (goodsSupplier.getId() == null) {
      return goodsSupplier;
    }

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    if (accountSetList != null) {
      getAccountSetDAO()
          .analyzeAccountSetByGoodsSupplier(accountSetList, goodsSupplier.getId(), options);
    }

    return goodsSupplier;
  }

  public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<GoodsSupplier> resultList =
        queryWith(
            GoodsSupplierTable.COLUMN_BELONG_TO,
            retailStoreCountryCenterId,
            options,
            getGoodsSupplierMapper());
    // analyzeGoodsSupplierByBelongTo(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<GoodsSupplier> resultList =
        queryWithRange(
            GoodsSupplierTable.COLUMN_BELONG_TO,
            retailStoreCountryCenterId,
            options,
            getGoodsSupplierMapper(),
            start,
            count);
    // analyzeGoodsSupplierByBelongTo(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzeGoodsSupplierByBelongTo(
      SmartList<GoodsSupplier> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(GoodsSupplier.BELONG_TO_PROPERTY, retailStoreCountryCenterId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // GoodsSupplier.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("产品供应商");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countGoodsSupplierByBelongTo(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(GoodsSupplierTable.COLUMN_BELONG_TO, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countGoodsSupplierByBelongToIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(GoodsSupplierTable.COLUMN_BELONG_TO, ids, options);
  }

  protected GoodsSupplier saveGoodsSupplier(GoodsSupplier goodsSupplier) {

    if (!goodsSupplier.isChanged()) {
      return goodsSupplier;
    }

    Beans.dbUtil().cacheCleanUp(goodsSupplier);
    String SQL = this.getSaveGoodsSupplierSQL(goodsSupplier);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveGoodsSupplierParameters(goodsSupplier);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    goodsSupplier.incVersion();
    goodsSupplier.afterSave();
    return goodsSupplier;
  }

  public SmartList<GoodsSupplier> saveGoodsSupplierList(
      SmartList<GoodsSupplier> goodsSupplierList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitGoodsSupplierList(goodsSupplierList);

    batchGoodsSupplierCreate((List<GoodsSupplier>) lists[CREATE_LIST_INDEX]);
    batchGoodsSupplierUpdate((List<GoodsSupplier>) lists[UPDATE_LIST_INDEX]);
    batchGoodsSupplierRemove((List<GoodsSupplier>) lists[REMOVE_LIST_INDEX]);
    batchGoodsSupplierRecover((List<GoodsSupplier>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      if (goodsSupplier.isChanged()) {
        goodsSupplier.incVersion();
        goodsSupplier.afterSave();
      }
      if (goodsSupplier.isToRecover() || goodsSupplier.isToRemove()) {
        goodsSupplier.setVersion(-goodsSupplier.getVersion());
      }
    }

    return goodsSupplierList;
  }

  public SmartList<GoodsSupplier> removeGoodsSupplierList(
      SmartList<GoodsSupplier> goodsSupplierList, Map<String, Object> options) {

    super.removeList(goodsSupplierList, options);

    return goodsSupplierList;
  }

  protected List<Object[]> prepareGoodsSupplierBatchCreateArgs(
      List<GoodsSupplier> goodsSupplierList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      Object[] parameters = prepareGoodsSupplierCreateParameters(goodsSupplier);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareGoodsSupplierBatchUpdateArgs(
      List<GoodsSupplier> goodsSupplierList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      if (!goodsSupplier.isChanged()) {
        continue;
      }
      Object[] parameters = prepareGoodsSupplierUpdateParameters(goodsSupplier);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareGoodsSupplierBatchRecoverArgs(
      List<GoodsSupplier> goodsSupplierList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      if (!goodsSupplier.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(goodsSupplier);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareGoodsSupplierBatchRemoveArgs(
      List<GoodsSupplier> goodsSupplierList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      if (!goodsSupplier.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareGoodsSupplierRemoveParameters(goodsSupplier);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchGoodsSupplierCreate(List<GoodsSupplier> goodsSupplierList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareGoodsSupplierBatchCreateArgs(goodsSupplierList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchGoodsSupplierUpdate(List<GoodsSupplier> goodsSupplierList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareGoodsSupplierBatchUpdateArgs(goodsSupplierList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchGoodsSupplierRemove(List<GoodsSupplier> goodsSupplierList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareGoodsSupplierBatchRemoveArgs(goodsSupplierList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchGoodsSupplierRecover(List<GoodsSupplier> goodsSupplierList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareGoodsSupplierBatchRecoverArgs(goodsSupplierList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitGoodsSupplierList(List<GoodsSupplier> goodsSupplierList) {

    List<GoodsSupplier> goodsSupplierCreateList = new ArrayList<GoodsSupplier>();
    List<GoodsSupplier> goodsSupplierUpdateList = new ArrayList<GoodsSupplier>();
    List<GoodsSupplier> goodsSupplierRemoveList = new ArrayList<GoodsSupplier>();
    List<GoodsSupplier> goodsSupplierRecoverList = new ArrayList<GoodsSupplier>();

    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      if (goodsSupplier.isToRemove()) {
        goodsSupplierRemoveList.add(goodsSupplier);
        continue;
      }
      if (goodsSupplier.isToRecover()) {
        goodsSupplierRecoverList.add(goodsSupplier);
        continue;
      }
      if (isUpdateRequest(goodsSupplier)) {
        if (goodsSupplier.isChanged()) {
          goodsSupplierUpdateList.add(goodsSupplier);
        }
        continue;
      }

      if (goodsSupplier.isChanged()) {
        goodsSupplierCreateList.add(goodsSupplier);
      }
    }

    return new Object[] {
      goodsSupplierCreateList,
      goodsSupplierUpdateList,
      goodsSupplierRemoveList,
      goodsSupplierRecoverList
    };
  }

  protected boolean isUpdateRequest(GoodsSupplier goodsSupplier) {
    return goodsSupplier.getVersion() > 0;
  }

  protected String getSaveGoodsSupplierSQL(GoodsSupplier goodsSupplier) {
    if (goodsSupplier.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(goodsSupplier)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveGoodsSupplierParameters(GoodsSupplier goodsSupplier) {
    if (goodsSupplier.isToRemove()) {
      return prepareGoodsSupplierRemoveParameters(goodsSupplier);
    }
    if (goodsSupplier.isToRecover()) {
      return prepareRecoverParameters(goodsSupplier);
    }

    if (isUpdateRequest(goodsSupplier)) {
      return prepareGoodsSupplierUpdateParameters(goodsSupplier);
    }
    return prepareGoodsSupplierCreateParameters(goodsSupplier);
  }

  protected Object[] prepareGoodsSupplierRemoveParameters(GoodsSupplier goodsSupplier) {
    return super.prepareRemoveParameters(goodsSupplier);
  }

  protected Object[] prepareGoodsSupplierUpdateParameters(GoodsSupplier goodsSupplier) {
    Object[] parameters = new Object[9];

    parameters[0] = goodsSupplier.getName();

    parameters[1] = goodsSupplier.getSupplyProduct();

    if (goodsSupplier.getBelongTo() != null) {
      parameters[2] = goodsSupplier.getBelongTo().getId();
    }

    parameters[3] = goodsSupplier.getContactNumber();

    parameters[4] = goodsSupplier.getDescription();

    parameters[5] = goodsSupplier.getLastUpdateTime();

    parameters[6] = goodsSupplier.nextVersion();
    parameters[7] = goodsSupplier.getId();
    parameters[8] = goodsSupplier.getVersion();

    return parameters;
  }

  protected Object[] prepareGoodsSupplierCreateParameters(GoodsSupplier goodsSupplier) {
    Object[] parameters = new Object[7];
    if (goodsSupplier.getId() == null) {
      String newGoodsSupplierId = getNextId();
      goodsSupplier.setId(newGoodsSupplierId);
    }
    parameters[0] = goodsSupplier.getId();

    parameters[1] = goodsSupplier.getName();

    parameters[2] = goodsSupplier.getSupplyProduct();

    if (goodsSupplier.getBelongTo() != null) {
      parameters[3] = goodsSupplier.getBelongTo().getId();
    }

    parameters[4] = goodsSupplier.getContactNumber();

    parameters[5] = goodsSupplier.getDescription();

    parameters[6] = goodsSupplier.getLastUpdateTime();

    return parameters;
  }

  protected GoodsSupplier saveInternalGoodsSupplier(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    if (isSaveBelongToEnabled(options)) {
      saveBelongTo(goodsSupplier, options);
    }

    saveGoodsSupplier(goodsSupplier);

    if (isSaveSupplierProductListEnabled(options)) {
      saveSupplierProductList(goodsSupplier, options);
      // removeSupplierProductList(goodsSupplier, options);
      // Not delete the record

    }

    if (isSaveSupplyOrderListEnabled(options)) {
      saveSupplyOrderList(goodsSupplier, options);
      // removeSupplyOrderList(goodsSupplier, options);
      // Not delete the record

    }

    if (isSaveAccountSetListEnabled(options)) {
      saveAccountSetList(goodsSupplier, options);
      // removeAccountSetList(goodsSupplier, options);
      // Not delete the record

    }

    return goodsSupplier;
  }

  // ======================================================================================

  protected GoodsSupplier saveBelongTo(GoodsSupplier goodsSupplier, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (goodsSupplier.getBelongTo() == null) {
      return goodsSupplier; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(goodsSupplier.getBelongTo(), options);
    return goodsSupplier;
  }

  public GoodsSupplier planToRemoveSupplierProductList(
      GoodsSupplier goodsSupplier, String supplierProductIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(SupplierProduct.SUPPLIER_PROPERTY, goodsSupplier.getId());
    key.put(SupplierProduct.ID_PROPERTY, supplierProductIds);

    SmartList<SupplierProduct> externalSupplierProductList =
        getSupplierProductDAO().findSupplierProductWithKey(key, options);
    if (externalSupplierProductList == null) {
      return goodsSupplier;
    }
    if (externalSupplierProductList.isEmpty()) {
      return goodsSupplier;
    }

    for (SupplierProduct supplierProductItem : externalSupplierProductList) {

      supplierProductItem.clearFromAll();
    }

    SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
    supplierProductList.addAllToRemoveList(externalSupplierProductList);
    return goodsSupplier;
  }

  public GoodsSupplier planToRemoveSupplyOrderList(
      GoodsSupplier goodsSupplier, String supplyOrderIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(SupplyOrder.SELLER_PROPERTY, goodsSupplier.getId());
    key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);

    SmartList<SupplyOrder> externalSupplyOrderList =
        getSupplyOrderDAO().findSupplyOrderWithKey(key, options);
    if (externalSupplyOrderList == null) {
      return goodsSupplier;
    }
    if (externalSupplyOrderList.isEmpty()) {
      return goodsSupplier;
    }

    for (SupplyOrder supplyOrderItem : externalSupplyOrderList) {

      supplyOrderItem.clearFromAll();
    }

    SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
    supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
    return goodsSupplier;
  }

  // disconnect GoodsSupplier with buyer in SupplyOrder
  public GoodsSupplier planToRemoveSupplyOrderListWithBuyer(
      GoodsSupplier goodsSupplier, String buyerId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(SupplyOrder.SELLER_PROPERTY, goodsSupplier.getId());
    key.put(SupplyOrder.BUYER_PROPERTY, buyerId);

    SmartList<SupplyOrder> externalSupplyOrderList =
        getSupplyOrderDAO().findSupplyOrderWithKey(key, options);
    if (externalSupplyOrderList == null) {
      return goodsSupplier;
    }
    if (externalSupplyOrderList.isEmpty()) {
      return goodsSupplier;
    }

    for (SupplyOrder supplyOrderItem : externalSupplyOrderList) {
      supplyOrderItem.clearBuyer();
      supplyOrderItem.clearSeller();
    }

    SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
    supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
    return goodsSupplier;
  }

  public int countSupplyOrderListWithBuyer(
      String goodsSupplierId, String buyerId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(SupplyOrder.SELLER_PROPERTY, goodsSupplierId);
    key.put(SupplyOrder.BUYER_PROPERTY, buyerId);

    int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
    return count;
  }

  public GoodsSupplier planToRemoveAccountSetList(
      GoodsSupplier goodsSupplier, String accountSetIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplier.getId());
    key.put(AccountSet.ID_PROPERTY, accountSetIds);

    SmartList<AccountSet> externalAccountSetList =
        getAccountSetDAO().findAccountSetWithKey(key, options);
    if (externalAccountSetList == null) {
      return goodsSupplier;
    }
    if (externalAccountSetList.isEmpty()) {
      return goodsSupplier;
    }

    for (AccountSet accountSetItem : externalAccountSetList) {

      accountSetItem.clearFromAll();
    }

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    accountSetList.addAllToRemoveList(externalAccountSetList);
    return goodsSupplier;
  }

  // disconnect GoodsSupplier with country_center in AccountSet
  public GoodsSupplier planToRemoveAccountSetListWithCountryCenter(
      GoodsSupplier goodsSupplier, String countryCenterId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplier.getId());
    key.put(AccountSet.COUNTRY_CENTER_PROPERTY, countryCenterId);

    SmartList<AccountSet> externalAccountSetList =
        getAccountSetDAO().findAccountSetWithKey(key, options);
    if (externalAccountSetList == null) {
      return goodsSupplier;
    }
    if (externalAccountSetList.isEmpty()) {
      return goodsSupplier;
    }

    for (AccountSet accountSetItem : externalAccountSetList) {
      accountSetItem.clearCountryCenter();
      accountSetItem.clearGoodsSupplier();
    }

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    accountSetList.addAllToRemoveList(externalAccountSetList);
    return goodsSupplier;
  }

  public int countAccountSetListWithCountryCenter(
      String goodsSupplierId, String countryCenterId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);
    key.put(AccountSet.COUNTRY_CENTER_PROPERTY, countryCenterId);

    int count = getAccountSetDAO().countAccountSetWithKey(key, options);
    return count;
  }

  // disconnect GoodsSupplier with retail_store in AccountSet
  public GoodsSupplier planToRemoveAccountSetListWithRetailStore(
      GoodsSupplier goodsSupplier, String retailStoreId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplier.getId());
    key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);

    SmartList<AccountSet> externalAccountSetList =
        getAccountSetDAO().findAccountSetWithKey(key, options);
    if (externalAccountSetList == null) {
      return goodsSupplier;
    }
    if (externalAccountSetList.isEmpty()) {
      return goodsSupplier;
    }

    for (AccountSet accountSetItem : externalAccountSetList) {
      accountSetItem.clearRetailStore();
      accountSetItem.clearGoodsSupplier();
    }

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    accountSetList.addAllToRemoveList(externalAccountSetList);
    return goodsSupplier;
  }

  public int countAccountSetListWithRetailStore(
      String goodsSupplierId, String retailStoreId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);
    key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);

    int count = getAccountSetDAO().countAccountSetWithKey(key, options);
    return count;
  }

  protected GoodsSupplier saveSupplierProductList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
    if (supplierProductList == null) {
      // null list means nothing
      return goodsSupplier;
    }
    SmartList<SupplierProduct> mergedUpdateSupplierProductList = new SmartList<SupplierProduct>();

    mergedUpdateSupplierProductList.addAll(supplierProductList);
    if (supplierProductList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateSupplierProductList.addAll(supplierProductList.getToRemoveList());
      supplierProductList.removeAll(supplierProductList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getSupplierProductDAO().saveSupplierProductList(mergedUpdateSupplierProductList, options);

    if (supplierProductList.getToRemoveList() != null) {
      supplierProductList.removeAll(supplierProductList.getToRemoveList());
    }

    return goodsSupplier;
  }

  protected GoodsSupplier removeSupplierProductList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
    if (supplierProductList == null) {
      return goodsSupplier;
    }

    SmartList<SupplierProduct> toRemoveSupplierProductList = supplierProductList.getToRemoveList();

    if (toRemoveSupplierProductList == null) {
      return goodsSupplier;
    }
    if (toRemoveSupplierProductList.isEmpty()) {
      return goodsSupplier; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getSupplierProductDAO().removeSupplierProductList(toRemoveSupplierProductList, options);

    return goodsSupplier;
  }

  protected GoodsSupplier saveSupplyOrderList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
    if (supplyOrderList == null) {
      // null list means nothing
      return goodsSupplier;
    }
    SmartList<SupplyOrder> mergedUpdateSupplyOrderList = new SmartList<SupplyOrder>();

    mergedUpdateSupplyOrderList.addAll(supplyOrderList);
    if (supplyOrderList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateSupplyOrderList.addAll(supplyOrderList.getToRemoveList());
      supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getSupplyOrderDAO().saveSupplyOrderList(mergedUpdateSupplyOrderList, options);

    if (supplyOrderList.getToRemoveList() != null) {
      supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
    }

    return goodsSupplier;
  }

  protected GoodsSupplier removeSupplyOrderList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
    if (supplyOrderList == null) {
      return goodsSupplier;
    }

    SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();

    if (toRemoveSupplyOrderList == null) {
      return goodsSupplier;
    }
    if (toRemoveSupplyOrderList.isEmpty()) {
      return goodsSupplier; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList, options);

    return goodsSupplier;
  }

  protected GoodsSupplier saveAccountSetList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    if (accountSetList == null) {
      // null list means nothing
      return goodsSupplier;
    }
    SmartList<AccountSet> mergedUpdateAccountSetList = new SmartList<AccountSet>();

    mergedUpdateAccountSetList.addAll(accountSetList);
    if (accountSetList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateAccountSetList.addAll(accountSetList.getToRemoveList());
      accountSetList.removeAll(accountSetList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getAccountSetDAO().saveAccountSetList(mergedUpdateAccountSetList, options);

    if (accountSetList.getToRemoveList() != null) {
      accountSetList.removeAll(accountSetList.getToRemoveList());
    }

    return goodsSupplier;
  }

  protected GoodsSupplier removeAccountSetList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    if (accountSetList == null) {
      return goodsSupplier;
    }

    SmartList<AccountSet> toRemoveAccountSetList = accountSetList.getToRemoveList();

    if (toRemoveAccountSetList == null) {
      return goodsSupplier;
    }
    if (toRemoveAccountSetList.isEmpty()) {
      return goodsSupplier; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getAccountSetDAO().removeAccountSetList(toRemoveAccountSetList, options);

    return goodsSupplier;
  }

  public GoodsSupplier present(GoodsSupplier goodsSupplier, Map<String, Object> options) {

    presentSupplierProductList(goodsSupplier, options);
    presentSupplyOrderList(goodsSupplier, options);
    presentAccountSetList(goodsSupplier, options);

    return goodsSupplier;
  }

  // Using java8 feature to reduce the code significantly
  protected GoodsSupplier presentSupplierProductList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
    SmartList<SupplierProduct> newList =
        presentSubList(
            goodsSupplier.getId(),
            supplierProductList,
            options,
            getSupplierProductDAO()::countSupplierProductBySupplier,
            getSupplierProductDAO()::findSupplierProductBySupplier);

    goodsSupplier.setSupplierProductList(newList);

    return goodsSupplier;
  }

  // Using java8 feature to reduce the code significantly
  protected GoodsSupplier presentSupplyOrderList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
    SmartList<SupplyOrder> newList =
        presentSubList(
            goodsSupplier.getId(),
            supplyOrderList,
            options,
            getSupplyOrderDAO()::countSupplyOrderBySeller,
            getSupplyOrderDAO()::findSupplyOrderBySeller);

    goodsSupplier.setSupplyOrderList(newList);

    return goodsSupplier;
  }

  // Using java8 feature to reduce the code significantly
  protected GoodsSupplier presentAccountSetList(
      GoodsSupplier goodsSupplier, Map<String, Object> options) {

    SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
    SmartList<AccountSet> newList =
        presentSubList(
            goodsSupplier.getId(),
            accountSetList,
            options,
            getAccountSetDAO()::countAccountSetByGoodsSupplier,
            getAccountSetDAO()::findAccountSetByGoodsSupplier);

    goodsSupplier.setAccountSetList(newList);

    return goodsSupplier;
  }

  public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForSupplierProduct(
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
        GoodsSupplierTable.COLUMN_NAME,
        GoodsSupplierTable.COLUMN_BELONG_TO,
        filterKey,
        pageNo,
        pageSize,
        getGoodsSupplierMapper());
  }

  public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForSupplyOrder(
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
        GoodsSupplierTable.COLUMN_NAME,
        GoodsSupplierTable.COLUMN_BELONG_TO,
        filterKey,
        pageNo,
        pageSize,
        getGoodsSupplierMapper());
  }

  public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForAccountSet(
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
        GoodsSupplierTable.COLUMN_NAME,
        GoodsSupplierTable.COLUMN_BELONG_TO,
        filterKey,
        pageNo,
        pageSize,
        getGoodsSupplierMapper());
  }

  protected String getTableName() {
    return GoodsSupplierTable.TABLE_NAME;
  }

  public void enhanceList(List<GoodsSupplier> goodsSupplierList) {
    this.enhanceListInternal(goodsSupplierList, this.getGoodsSupplierMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<GoodsSupplier> goodsSupplierList =
        ownerEntity.collectRefsWithType(GoodsSupplier.INTERNAL_TYPE);
    this.enhanceList(goodsSupplierList);
  }

  @Override
  public SmartList<GoodsSupplier> findGoodsSupplierWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getGoodsSupplierMapper());
  }

  @Override
  public int countGoodsSupplierWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countGoodsSupplierWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<GoodsSupplier> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getGoodsSupplierMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<GoodsSupplier> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getGoodsSupplierMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateGoodsSupplier executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateGoodsSupplier result = new CandidateGoodsSupplier();
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
  public List<GoodsSupplier> search(GoodsSupplierRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected GoodsSupplierMapper mapper() {
    return getGoodsSupplierMapper();
  }

  @Override
  protected GoodsSupplierMapper mapperForClazz(Class<?> clazz) {
    return GoodsSupplierMapper.mapperForClass(clazz);
  }
}
