package com.doublechaintech.retailscm.accountset;

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
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class AccountSetJDBCTemplateDAO extends RetailscmBaseDAOImpl implements AccountSetDAO {

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

  protected RetailStoreDAO retailStoreDAO;

  public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO) {

    if (retailStoreDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
    }
    this.retailStoreDAO = retailStoreDAO;
  }

  public RetailStoreDAO getRetailStoreDAO() {
    if (this.retailStoreDAO == null) {
      throw new IllegalStateException(
          "The retailStoreDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreDAO;
  }

  protected GoodsSupplierDAO goodsSupplierDAO;

  public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO) {

    if (goodsSupplierDAO == null) {
      throw new IllegalStateException("Do not try to set goodsSupplierDAO to null.");
    }
    this.goodsSupplierDAO = goodsSupplierDAO;
  }

  public GoodsSupplierDAO getGoodsSupplierDAO() {
    if (this.goodsSupplierDAO == null) {
      throw new IllegalStateException(
          "The goodsSupplierDAO is not configured yet, please config it some where.");
    }

    return this.goodsSupplierDAO;
  }

  protected AccountingSubjectDAO accountingSubjectDAO;

  public void setAccountingSubjectDAO(AccountingSubjectDAO accountingSubjectDAO) {

    if (accountingSubjectDAO == null) {
      throw new IllegalStateException("Do not try to set accountingSubjectDAO to null.");
    }
    this.accountingSubjectDAO = accountingSubjectDAO;
  }

  public AccountingSubjectDAO getAccountingSubjectDAO() {
    if (this.accountingSubjectDAO == null) {
      throw new IllegalStateException(
          "The accountingSubjectDAO is not configured yet, please config it some where.");
    }

    return this.accountingSubjectDAO;
  }

  protected AccountingPeriodDAO accountingPeriodDAO;

  public void setAccountingPeriodDAO(AccountingPeriodDAO accountingPeriodDAO) {

    if (accountingPeriodDAO == null) {
      throw new IllegalStateException("Do not try to set accountingPeriodDAO to null.");
    }
    this.accountingPeriodDAO = accountingPeriodDAO;
  }

  public AccountingPeriodDAO getAccountingPeriodDAO() {
    if (this.accountingPeriodDAO == null) {
      throw new IllegalStateException(
          "The accountingPeriodDAO is not configured yet, please config it some where.");
    }

    return this.accountingPeriodDAO;
  }

  protected AccountingDocumentTypeDAO accountingDocumentTypeDAO;

  public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO accountingDocumentTypeDAO) {

    if (accountingDocumentTypeDAO == null) {
      throw new IllegalStateException("Do not try to set accountingDocumentTypeDAO to null.");
    }
    this.accountingDocumentTypeDAO = accountingDocumentTypeDAO;
  }

  public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO() {
    if (this.accountingDocumentTypeDAO == null) {
      throw new IllegalStateException(
          "The accountingDocumentTypeDAO is not configured yet, please config it some where.");
    }

    return this.accountingDocumentTypeDAO;
  }

  /*
  protected AccountSet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalAccountSet(accessKey, options);
  }
  */

  public SmartList<AccountSet> loadAll() {
    return this.loadAll(getAccountSetMapper());
  }

  public Stream<AccountSet> loadAllAsStream() {
    return this.loadAllAsStream(getAccountSetMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public AccountSet load(String id, Map<String, Object> options) throws Exception {
    return loadInternalAccountSet(AccountSetTable.withId(id), options);
  }

  public AccountSet save(AccountSet accountSet, Map<String, Object> options) {

    String methodName = "save(AccountSet accountSet,Map<String,Object> options)";

    assertMethodArgumentNotNull(accountSet, methodName, "accountSet");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalAccountSet(accountSet, options);
  }

  public AccountSet clone(String accountSetId, Map<String, Object> options) throws Exception {

    return clone(AccountSetTable.withId(accountSetId), options);
  }

  protected AccountSet clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String accountSetId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    AccountSet newAccountSet = loadInternalAccountSet(accessKey, options);
    newAccountSet.setVersion(0);

    if (isSaveAccountingSubjectListEnabled(options)) {
      for (AccountingSubject item : newAccountSet.getAccountingSubjectList()) {
        item.setVersion(0);
      }
    }

    if (isSaveAccountingPeriodListEnabled(options)) {
      for (AccountingPeriod item : newAccountSet.getAccountingPeriodList()) {
        item.setVersion(0);
      }
    }

    if (isSaveAccountingDocumentTypeListEnabled(options)) {
      for (AccountingDocumentType item : newAccountSet.getAccountingDocumentTypeList()) {
        item.setVersion(0);
      }
    }

    saveInternalAccountSet(newAccountSet, options);

    return newAccountSet;
  }

  protected void throwIfHasException(String accountSetId, int version, int count) throws Exception {
    if (count == 1) {
      throw new AccountSetVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new AccountSetNotFoundException(
          "The " + this.getTableName() + "(" + accountSetId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public AccountSet disconnectFromAll(String accountSetId, int version) throws Exception {

    AccountSet accountSet =
        loadInternalAccountSet(AccountSetTable.withId(accountSetId), emptyOptions());
    accountSet.clearFromAll();
    this.saveAccountSet(accountSet);
    return accountSet;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return AccountSetTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "account_set";
  }

  @Override
  protected String getBeanName() {

    return "accountSet";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return AccountSetTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCountryCenterEnabled(Map<String, Object> options) {

    return checkOptions(options, AccountSetTokens.COUNTRYCENTER);
  }

  protected boolean isSaveCountryCenterEnabled(Map<String, Object> options) {

    return checkOptions(options, AccountSetTokens.COUNTRYCENTER);
  }

  protected boolean isExtractRetailStoreEnabled(Map<String, Object> options) {

    return checkOptions(options, AccountSetTokens.RETAILSTORE);
  }

  protected boolean isSaveRetailStoreEnabled(Map<String, Object> options) {

    return checkOptions(options, AccountSetTokens.RETAILSTORE);
  }

  protected boolean isExtractGoodsSupplierEnabled(Map<String, Object> options) {

    return checkOptions(options, AccountSetTokens.GOODSSUPPLIER);
  }

  protected boolean isSaveGoodsSupplierEnabled(Map<String, Object> options) {

    return checkOptions(options, AccountSetTokens.GOODSSUPPLIER);
  }

  protected boolean isExtractAccountingSubjectListEnabled(Map<String, Object> options) {
    return checkOptions(options, AccountSetTokens.ACCOUNTING_SUBJECT_LIST);
  }

  protected boolean isAnalyzeAccountingSubjectListEnabled(Map<String, Object> options) {
    return AccountSetTokens.of(options).analyzeAccountingSubjectListEnabled();
  }

  protected boolean isSaveAccountingSubjectListEnabled(Map<String, Object> options) {
    return checkOptions(options, AccountSetTokens.ACCOUNTING_SUBJECT_LIST);
  }

  protected boolean isExtractAccountingPeriodListEnabled(Map<String, Object> options) {
    return checkOptions(options, AccountSetTokens.ACCOUNTING_PERIOD_LIST);
  }

  protected boolean isAnalyzeAccountingPeriodListEnabled(Map<String, Object> options) {
    return AccountSetTokens.of(options).analyzeAccountingPeriodListEnabled();
  }

  protected boolean isSaveAccountingPeriodListEnabled(Map<String, Object> options) {
    return checkOptions(options, AccountSetTokens.ACCOUNTING_PERIOD_LIST);
  }

  protected boolean isExtractAccountingDocumentTypeListEnabled(Map<String, Object> options) {
    return checkOptions(options, AccountSetTokens.ACCOUNTING_DOCUMENT_TYPE_LIST);
  }

  protected boolean isAnalyzeAccountingDocumentTypeListEnabled(Map<String, Object> options) {
    return AccountSetTokens.of(options).analyzeAccountingDocumentTypeListEnabled();
  }

  protected boolean isSaveAccountingDocumentTypeListEnabled(Map<String, Object> options) {
    return checkOptions(options, AccountSetTokens.ACCOUNTING_DOCUMENT_TYPE_LIST);
  }

  protected AccountSetMapper getAccountSetMapper() {
    return new AccountSetMapper();
  }

  protected AccountSet extractAccountSet(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      AccountSet accountSet = loadSingleObject(accessKey, getAccountSetMapper());
      return accountSet;
    } catch (EmptyResultDataAccessException e) {
      throw new AccountSetNotFoundException("AccountSet(" + accessKey + ") is not found!");
    }
  }

  protected AccountSet loadInternalAccountSet(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    AccountSet accountSet = extractAccountSet(accessKey, loadOptions);

    if (isExtractCountryCenterEnabled(loadOptions)) {
      extractCountryCenter(accountSet, loadOptions);
    }

    if (isExtractRetailStoreEnabled(loadOptions)) {
      extractRetailStore(accountSet, loadOptions);
    }

    if (isExtractGoodsSupplierEnabled(loadOptions)) {
      extractGoodsSupplier(accountSet, loadOptions);
    }

    if (isExtractAccountingSubjectListEnabled(loadOptions)) {
      extractAccountingSubjectList(accountSet, loadOptions);
    }

    if (isAnalyzeAccountingSubjectListEnabled(loadOptions)) {
      analyzeAccountingSubjectList(accountSet, loadOptions);
    }

    if (isExtractAccountingPeriodListEnabled(loadOptions)) {
      extractAccountingPeriodList(accountSet, loadOptions);
    }

    if (isAnalyzeAccountingPeriodListEnabled(loadOptions)) {
      analyzeAccountingPeriodList(accountSet, loadOptions);
    }

    if (isExtractAccountingDocumentTypeListEnabled(loadOptions)) {
      extractAccountingDocumentTypeList(accountSet, loadOptions);
    }

    if (isAnalyzeAccountingDocumentTypeListEnabled(loadOptions)) {
      analyzeAccountingDocumentTypeList(accountSet, loadOptions);
    }

    return accountSet;
  }

  protected AccountSet extractCountryCenter(AccountSet accountSet, Map<String, Object> options)
      throws Exception {

    if (accountSet.getCountryCenter() == null) {
      return accountSet;
    }
    String countryCenterId = accountSet.getCountryCenter().getId();
    if (countryCenterId == null) {
      return accountSet;
    }
    RetailStoreCountryCenter countryCenter =
        getRetailStoreCountryCenterDAO().load(countryCenterId, options);
    if (countryCenter != null) {
      accountSet.setCountryCenter(countryCenter);
    }

    return accountSet;
  }

  protected AccountSet extractRetailStore(AccountSet accountSet, Map<String, Object> options)
      throws Exception {

    if (accountSet.getRetailStore() == null) {
      return accountSet;
    }
    String retailStoreId = accountSet.getRetailStore().getId();
    if (retailStoreId == null) {
      return accountSet;
    }
    RetailStore retailStore = getRetailStoreDAO().load(retailStoreId, options);
    if (retailStore != null) {
      accountSet.setRetailStore(retailStore);
    }

    return accountSet;
  }

  protected AccountSet extractGoodsSupplier(AccountSet accountSet, Map<String, Object> options)
      throws Exception {

    if (accountSet.getGoodsSupplier() == null) {
      return accountSet;
    }
    String goodsSupplierId = accountSet.getGoodsSupplier().getId();
    if (goodsSupplierId == null) {
      return accountSet;
    }
    GoodsSupplier goodsSupplier = getGoodsSupplierDAO().load(goodsSupplierId, options);
    if (goodsSupplier != null) {
      accountSet.setGoodsSupplier(goodsSupplier);
    }

    return accountSet;
  }

  protected void enhanceAccountingSubjectList(
      SmartList<AccountingSubject> accountingSubjectList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected AccountSet extractAccountingSubjectList(
      AccountSet accountSet, Map<String, Object> options) {

    if (accountSet == null) {
      return null;
    }
    if (accountSet.getId() == null) {
      return accountSet;
    }

    SmartList<AccountingSubject> accountingSubjectList =
        getAccountingSubjectDAO().findAccountingSubjectByAccountSet(accountSet.getId(), options);
    if (accountingSubjectList != null) {
      enhanceAccountingSubjectList(accountingSubjectList, options);
      accountSet.setAccountingSubjectList(accountingSubjectList);
    }

    return accountSet;
  }

  protected AccountSet analyzeAccountingSubjectList(
      AccountSet accountSet, Map<String, Object> options) {

    if (accountSet == null) {
      return null;
    }
    if (accountSet.getId() == null) {
      return accountSet;
    }

    SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
    if (accountingSubjectList != null) {
      getAccountingSubjectDAO()
          .analyzeAccountingSubjectByAccountSet(accountingSubjectList, accountSet.getId(), options);
    }

    return accountSet;
  }

  protected void enhanceAccountingPeriodList(
      SmartList<AccountingPeriod> accountingPeriodList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected AccountSet extractAccountingPeriodList(
      AccountSet accountSet, Map<String, Object> options) {

    if (accountSet == null) {
      return null;
    }
    if (accountSet.getId() == null) {
      return accountSet;
    }

    SmartList<AccountingPeriod> accountingPeriodList =
        getAccountingPeriodDAO().findAccountingPeriodByAccountSet(accountSet.getId(), options);
    if (accountingPeriodList != null) {
      enhanceAccountingPeriodList(accountingPeriodList, options);
      accountSet.setAccountingPeriodList(accountingPeriodList);
    }

    return accountSet;
  }

  protected AccountSet analyzeAccountingPeriodList(
      AccountSet accountSet, Map<String, Object> options) {

    if (accountSet == null) {
      return null;
    }
    if (accountSet.getId() == null) {
      return accountSet;
    }

    SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
    if (accountingPeriodList != null) {
      getAccountingPeriodDAO()
          .analyzeAccountingPeriodByAccountSet(accountingPeriodList, accountSet.getId(), options);
    }

    return accountSet;
  }

  protected void enhanceAccountingDocumentTypeList(
      SmartList<AccountingDocumentType> accountingDocumentTypeList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected AccountSet extractAccountingDocumentTypeList(
      AccountSet accountSet, Map<String, Object> options) {

    if (accountSet == null) {
      return null;
    }
    if (accountSet.getId() == null) {
      return accountSet;
    }

    SmartList<AccountingDocumentType> accountingDocumentTypeList =
        getAccountingDocumentTypeDAO()
            .findAccountingDocumentTypeByAccountingPeriod(accountSet.getId(), options);
    if (accountingDocumentTypeList != null) {
      enhanceAccountingDocumentTypeList(accountingDocumentTypeList, options);
      accountSet.setAccountingDocumentTypeList(accountingDocumentTypeList);
    }

    return accountSet;
  }

  protected AccountSet analyzeAccountingDocumentTypeList(
      AccountSet accountSet, Map<String, Object> options) {

    if (accountSet == null) {
      return null;
    }
    if (accountSet.getId() == null) {
      return accountSet;
    }

    SmartList<AccountingDocumentType> accountingDocumentTypeList =
        accountSet.getAccountingDocumentTypeList();
    if (accountingDocumentTypeList != null) {
      getAccountingDocumentTypeDAO()
          .analyzeAccountingDocumentTypeByAccountingPeriod(
              accountingDocumentTypeList, accountSet.getId(), options);
    }

    return accountSet;
  }

  public SmartList<AccountSet> findAccountSetByCountryCenter(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<AccountSet> resultList =
        queryWith(
            AccountSetTable.COLUMN_COUNTRY_CENTER,
            retailStoreCountryCenterId,
            options,
            getAccountSetMapper());
    // analyzeAccountSetByCountryCenter(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<AccountSet> findAccountSetByCountryCenter(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<AccountSet> resultList =
        queryWithRange(
            AccountSetTable.COLUMN_COUNTRY_CENTER,
            retailStoreCountryCenterId,
            options,
            getAccountSetMapper(),
            start,
            count);
    // analyzeAccountSetByCountryCenter(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzeAccountSetByCountryCenter(
      SmartList<AccountSet> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(AccountSet.COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // AccountSet.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("账套");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(AccountSet.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(AccountSet.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countAccountSetByCountryCenter(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(AccountSetTable.COLUMN_COUNTRY_CENTER, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countAccountSetByCountryCenterIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(AccountSetTable.COLUMN_COUNTRY_CENTER, ids, options);
  }

  public SmartList<AccountSet> findAccountSetByRetailStore(
      String retailStoreId, Map<String, Object> options) {

    SmartList<AccountSet> resultList =
        queryWith(
            AccountSetTable.COLUMN_RETAIL_STORE, retailStoreId, options, getAccountSetMapper());
    // analyzeAccountSetByRetailStore(resultList, retailStoreId, options);
    return resultList;
  }

  public SmartList<AccountSet> findAccountSetByRetailStore(
      String retailStoreId, int start, int count, Map<String, Object> options) {

    SmartList<AccountSet> resultList =
        queryWithRange(
            AccountSetTable.COLUMN_RETAIL_STORE,
            retailStoreId,
            options,
            getAccountSetMapper(),
            start,
            count);
    // analyzeAccountSetByRetailStore(resultList, retailStoreId, options);
    return resultList;
  }

  public void analyzeAccountSetByRetailStore(
      SmartList<AccountSet> resultList, String retailStoreId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // AccountSet.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("账套");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(AccountSet.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(AccountSet.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countAccountSetByRetailStore(String retailStoreId, Map<String, Object> options) {

    return countWith(AccountSetTable.COLUMN_RETAIL_STORE, retailStoreId, options);
  }

  @Override
  public Map<String, Integer> countAccountSetByRetailStoreIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(AccountSetTable.COLUMN_RETAIL_STORE, ids, options);
  }

  public SmartList<AccountSet> findAccountSetByGoodsSupplier(
      String goodsSupplierId, Map<String, Object> options) {

    SmartList<AccountSet> resultList =
        queryWith(
            AccountSetTable.COLUMN_GOODS_SUPPLIER, goodsSupplierId, options, getAccountSetMapper());
    // analyzeAccountSetByGoodsSupplier(resultList, goodsSupplierId, options);
    return resultList;
  }

  public SmartList<AccountSet> findAccountSetByGoodsSupplier(
      String goodsSupplierId, int start, int count, Map<String, Object> options) {

    SmartList<AccountSet> resultList =
        queryWithRange(
            AccountSetTable.COLUMN_GOODS_SUPPLIER,
            goodsSupplierId,
            options,
            getAccountSetMapper(),
            start,
            count);
    // analyzeAccountSetByGoodsSupplier(resultList, goodsSupplierId, options);
    return resultList;
  }

  public void analyzeAccountSetByGoodsSupplier(
      SmartList<AccountSet> resultList, String goodsSupplierId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // AccountSet.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("账套");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(AccountSet.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(AccountSet.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countAccountSetByGoodsSupplier(String goodsSupplierId, Map<String, Object> options) {

    return countWith(AccountSetTable.COLUMN_GOODS_SUPPLIER, goodsSupplierId, options);
  }

  @Override
  public Map<String, Integer> countAccountSetByGoodsSupplierIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(AccountSetTable.COLUMN_GOODS_SUPPLIER, ids, options);
  }

  protected AccountSet saveAccountSet(AccountSet accountSet) {

    if (!accountSet.isChanged()) {
      return accountSet;
    }

    Beans.dbUtil().cacheCleanUp(accountSet);
    String SQL = this.getSaveAccountSetSQL(accountSet);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveAccountSetParameters(accountSet);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    accountSet.incVersion();
    accountSet.afterSave();
    return accountSet;
  }

  public SmartList<AccountSet> saveAccountSetList(
      SmartList<AccountSet> accountSetList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitAccountSetList(accountSetList);

    batchAccountSetCreate((List<AccountSet>) lists[CREATE_LIST_INDEX]);
    batchAccountSetUpdate((List<AccountSet>) lists[UPDATE_LIST_INDEX]);
    batchAccountSetRemove((List<AccountSet>) lists[REMOVE_LIST_INDEX]);
    batchAccountSetRecover((List<AccountSet>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (AccountSet accountSet : accountSetList) {
      if (accountSet.isChanged()) {
        accountSet.incVersion();
        accountSet.afterSave();
      }
      if (accountSet.isToRecover() || accountSet.isToRemove()) {
        accountSet.setVersion(-accountSet.getVersion());
      }
    }

    return accountSetList;
  }

  public SmartList<AccountSet> removeAccountSetList(
      SmartList<AccountSet> accountSetList, Map<String, Object> options) {

    super.removeList(accountSetList, options);

    return accountSetList;
  }

  protected List<Object[]> prepareAccountSetBatchCreateArgs(List<AccountSet> accountSetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (AccountSet accountSet : accountSetList) {
      Object[] parameters = prepareAccountSetCreateParameters(accountSet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareAccountSetBatchUpdateArgs(List<AccountSet> accountSetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (AccountSet accountSet : accountSetList) {
      if (!accountSet.isChanged()) {
        continue;
      }
      Object[] parameters = prepareAccountSetUpdateParameters(accountSet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareAccountSetBatchRecoverArgs(List<AccountSet> accountSetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (AccountSet accountSet : accountSetList) {
      if (!accountSet.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(accountSet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareAccountSetBatchRemoveArgs(List<AccountSet> accountSetList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (AccountSet accountSet : accountSetList) {
      if (!accountSet.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareAccountSetRemoveParameters(accountSet);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchAccountSetCreate(List<AccountSet> accountSetList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareAccountSetBatchCreateArgs(accountSetList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchAccountSetUpdate(List<AccountSet> accountSetList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareAccountSetBatchUpdateArgs(accountSetList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchAccountSetRemove(List<AccountSet> accountSetList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareAccountSetBatchRemoveArgs(accountSetList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchAccountSetRecover(List<AccountSet> accountSetList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareAccountSetBatchRecoverArgs(accountSetList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitAccountSetList(List<AccountSet> accountSetList) {

    List<AccountSet> accountSetCreateList = new ArrayList<AccountSet>();
    List<AccountSet> accountSetUpdateList = new ArrayList<AccountSet>();
    List<AccountSet> accountSetRemoveList = new ArrayList<AccountSet>();
    List<AccountSet> accountSetRecoverList = new ArrayList<AccountSet>();

    for (AccountSet accountSet : accountSetList) {
      if (accountSet.isToRemove()) {
        accountSetRemoveList.add(accountSet);
        continue;
      }
      if (accountSet.isToRecover()) {
        accountSetRecoverList.add(accountSet);
        continue;
      }
      if (isUpdateRequest(accountSet)) {
        if (accountSet.isChanged()) {
          accountSetUpdateList.add(accountSet);
        }
        continue;
      }

      if (accountSet.isChanged()) {
        accountSetCreateList.add(accountSet);
      }
    }

    return new Object[] {
      accountSetCreateList, accountSetUpdateList, accountSetRemoveList, accountSetRecoverList
    };
  }

  protected boolean isUpdateRequest(AccountSet accountSet) {
    return accountSet.getVersion() > 0;
  }

  protected String getSaveAccountSetSQL(AccountSet accountSet) {
    if (accountSet.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(accountSet)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveAccountSetParameters(AccountSet accountSet) {
    if (accountSet.isToRemove()) {
      return prepareAccountSetRemoveParameters(accountSet);
    }
    if (accountSet.isToRecover()) {
      return prepareRecoverParameters(accountSet);
    }

    if (isUpdateRequest(accountSet)) {
      return prepareAccountSetUpdateParameters(accountSet);
    }
    return prepareAccountSetCreateParameters(accountSet);
  }

  protected Object[] prepareAccountSetRemoveParameters(AccountSet accountSet) {
    return super.prepareRemoveParameters(accountSet);
  }

  protected Object[] prepareAccountSetUpdateParameters(AccountSet accountSet) {
    Object[] parameters = new Object[15];

    parameters[0] = accountSet.getName();

    parameters[1] = accountSet.getYearSet();

    parameters[2] = accountSet.getEffectiveDate();

    parameters[3] = accountSet.getAccountingSystem();

    parameters[4] = accountSet.getDomesticCurrencyCode();

    parameters[5] = accountSet.getDomesticCurrencyName();

    parameters[6] = accountSet.getOpeningBank();

    parameters[7] = accountSet.getAccountNumber();

    if (accountSet.getCountryCenter() != null) {
      parameters[8] = accountSet.getCountryCenter().getId();
    }

    if (accountSet.getRetailStore() != null) {
      parameters[9] = accountSet.getRetailStore().getId();
    }

    if (accountSet.getGoodsSupplier() != null) {
      parameters[10] = accountSet.getGoodsSupplier().getId();
    }

    parameters[11] = accountSet.getLastUpdateTime();

    parameters[12] = accountSet.nextVersion();
    parameters[13] = accountSet.getId();
    parameters[14] = accountSet.getVersion();

    return parameters;
  }

  protected Object[] prepareAccountSetCreateParameters(AccountSet accountSet) {
    Object[] parameters = new Object[13];
    if (accountSet.getId() == null) {
      String newAccountSetId = getNextId();
      accountSet.setId(newAccountSetId);
    }
    parameters[0] = accountSet.getId();

    parameters[1] = accountSet.getName();

    parameters[2] = accountSet.getYearSet();

    parameters[3] = accountSet.getEffectiveDate();

    parameters[4] = accountSet.getAccountingSystem();

    parameters[5] = accountSet.getDomesticCurrencyCode();

    parameters[6] = accountSet.getDomesticCurrencyName();

    parameters[7] = accountSet.getOpeningBank();

    parameters[8] = accountSet.getAccountNumber();

    if (accountSet.getCountryCenter() != null) {
      parameters[9] = accountSet.getCountryCenter().getId();
    }

    if (accountSet.getRetailStore() != null) {
      parameters[10] = accountSet.getRetailStore().getId();
    }

    if (accountSet.getGoodsSupplier() != null) {
      parameters[11] = accountSet.getGoodsSupplier().getId();
    }

    parameters[12] = accountSet.getLastUpdateTime();

    return parameters;
  }

  protected AccountSet saveInternalAccountSet(AccountSet accountSet, Map<String, Object> options) {

    if (isSaveCountryCenterEnabled(options)) {
      saveCountryCenter(accountSet, options);
    }

    if (isSaveRetailStoreEnabled(options)) {
      saveRetailStore(accountSet, options);
    }

    if (isSaveGoodsSupplierEnabled(options)) {
      saveGoodsSupplier(accountSet, options);
    }

    saveAccountSet(accountSet);

    if (isSaveAccountingSubjectListEnabled(options)) {
      saveAccountingSubjectList(accountSet, options);
      // removeAccountingSubjectList(accountSet, options);
      // Not delete the record

    }

    if (isSaveAccountingPeriodListEnabled(options)) {
      saveAccountingPeriodList(accountSet, options);
      // removeAccountingPeriodList(accountSet, options);
      // Not delete the record

    }

    if (isSaveAccountingDocumentTypeListEnabled(options)) {
      saveAccountingDocumentTypeList(accountSet, options);
      // removeAccountingDocumentTypeList(accountSet, options);
      // Not delete the record

    }

    return accountSet;
  }

  // ======================================================================================

  protected AccountSet saveCountryCenter(AccountSet accountSet, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (accountSet.getCountryCenter() == null) {
      return accountSet; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(accountSet.getCountryCenter(), options);
    return accountSet;
  }

  protected AccountSet saveRetailStore(AccountSet accountSet, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (accountSet.getRetailStore() == null) {
      return accountSet; // do nothing when it is null
    }

    getRetailStoreDAO().save(accountSet.getRetailStore(), options);
    return accountSet;
  }

  protected AccountSet saveGoodsSupplier(AccountSet accountSet, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (accountSet.getGoodsSupplier() == null) {
      return accountSet; // do nothing when it is null
    }

    getGoodsSupplierDAO().save(accountSet.getGoodsSupplier(), options);
    return accountSet;
  }

  public AccountSet planToRemoveAccountingSubjectList(
      AccountSet accountSet, String accountingSubjectIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountingSubject.ACCOUNT_SET_PROPERTY, accountSet.getId());
    key.put(AccountingSubject.ID_PROPERTY, accountingSubjectIds);

    SmartList<AccountingSubject> externalAccountingSubjectList =
        getAccountingSubjectDAO().findAccountingSubjectWithKey(key, options);
    if (externalAccountingSubjectList == null) {
      return accountSet;
    }
    if (externalAccountingSubjectList.isEmpty()) {
      return accountSet;
    }

    for (AccountingSubject accountingSubjectItem : externalAccountingSubjectList) {

      accountingSubjectItem.clearFromAll();
    }

    SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
    accountingSubjectList.addAllToRemoveList(externalAccountingSubjectList);
    return accountSet;
  }

  public AccountSet planToRemoveAccountingPeriodList(
      AccountSet accountSet, String accountingPeriodIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountingPeriod.ACCOUNT_SET_PROPERTY, accountSet.getId());
    key.put(AccountingPeriod.ID_PROPERTY, accountingPeriodIds);

    SmartList<AccountingPeriod> externalAccountingPeriodList =
        getAccountingPeriodDAO().findAccountingPeriodWithKey(key, options);
    if (externalAccountingPeriodList == null) {
      return accountSet;
    }
    if (externalAccountingPeriodList.isEmpty()) {
      return accountSet;
    }

    for (AccountingPeriod accountingPeriodItem : externalAccountingPeriodList) {

      accountingPeriodItem.clearFromAll();
    }

    SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
    accountingPeriodList.addAllToRemoveList(externalAccountingPeriodList);
    return accountSet;
  }

  public AccountSet planToRemoveAccountingDocumentTypeList(
      AccountSet accountSet, String accountingDocumentTypeIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, accountSet.getId());
    key.put(AccountingDocumentType.ID_PROPERTY, accountingDocumentTypeIds);

    SmartList<AccountingDocumentType> externalAccountingDocumentTypeList =
        getAccountingDocumentTypeDAO().findAccountingDocumentTypeWithKey(key, options);
    if (externalAccountingDocumentTypeList == null) {
      return accountSet;
    }
    if (externalAccountingDocumentTypeList.isEmpty()) {
      return accountSet;
    }

    for (AccountingDocumentType accountingDocumentTypeItem : externalAccountingDocumentTypeList) {

      accountingDocumentTypeItem.clearFromAll();
    }

    SmartList<AccountingDocumentType> accountingDocumentTypeList =
        accountSet.getAccountingDocumentTypeList();
    accountingDocumentTypeList.addAllToRemoveList(externalAccountingDocumentTypeList);
    return accountSet;
  }

  protected AccountSet saveAccountingSubjectList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
    if (accountingSubjectList == null) {
      // null list means nothing
      return accountSet;
    }
    SmartList<AccountingSubject> mergedUpdateAccountingSubjectList =
        new SmartList<AccountingSubject>();

    mergedUpdateAccountingSubjectList.addAll(accountingSubjectList);
    if (accountingSubjectList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateAccountingSubjectList.addAll(accountingSubjectList.getToRemoveList());
      accountingSubjectList.removeAll(accountingSubjectList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getAccountingSubjectDAO().saveAccountingSubjectList(mergedUpdateAccountingSubjectList, options);

    if (accountingSubjectList.getToRemoveList() != null) {
      accountingSubjectList.removeAll(accountingSubjectList.getToRemoveList());
    }

    return accountSet;
  }

  protected AccountSet removeAccountingSubjectList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
    if (accountingSubjectList == null) {
      return accountSet;
    }

    SmartList<AccountingSubject> toRemoveAccountingSubjectList =
        accountingSubjectList.getToRemoveList();

    if (toRemoveAccountingSubjectList == null) {
      return accountSet;
    }
    if (toRemoveAccountingSubjectList.isEmpty()) {
      return accountSet; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getAccountingSubjectDAO().removeAccountingSubjectList(toRemoveAccountingSubjectList, options);

    return accountSet;
  }

  protected AccountSet saveAccountingPeriodList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
    if (accountingPeriodList == null) {
      // null list means nothing
      return accountSet;
    }
    SmartList<AccountingPeriod> mergedUpdateAccountingPeriodList =
        new SmartList<AccountingPeriod>();

    mergedUpdateAccountingPeriodList.addAll(accountingPeriodList);
    if (accountingPeriodList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateAccountingPeriodList.addAll(accountingPeriodList.getToRemoveList());
      accountingPeriodList.removeAll(accountingPeriodList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getAccountingPeriodDAO().saveAccountingPeriodList(mergedUpdateAccountingPeriodList, options);

    if (accountingPeriodList.getToRemoveList() != null) {
      accountingPeriodList.removeAll(accountingPeriodList.getToRemoveList());
    }

    return accountSet;
  }

  protected AccountSet removeAccountingPeriodList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
    if (accountingPeriodList == null) {
      return accountSet;
    }

    SmartList<AccountingPeriod> toRemoveAccountingPeriodList =
        accountingPeriodList.getToRemoveList();

    if (toRemoveAccountingPeriodList == null) {
      return accountSet;
    }
    if (toRemoveAccountingPeriodList.isEmpty()) {
      return accountSet; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getAccountingPeriodDAO().removeAccountingPeriodList(toRemoveAccountingPeriodList, options);

    return accountSet;
  }

  protected AccountSet saveAccountingDocumentTypeList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingDocumentType> accountingDocumentTypeList =
        accountSet.getAccountingDocumentTypeList();
    if (accountingDocumentTypeList == null) {
      // null list means nothing
      return accountSet;
    }
    SmartList<AccountingDocumentType> mergedUpdateAccountingDocumentTypeList =
        new SmartList<AccountingDocumentType>();

    mergedUpdateAccountingDocumentTypeList.addAll(accountingDocumentTypeList);
    if (accountingDocumentTypeList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateAccountingDocumentTypeList.addAll(accountingDocumentTypeList.getToRemoveList());
      accountingDocumentTypeList.removeAll(accountingDocumentTypeList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getAccountingDocumentTypeDAO()
        .saveAccountingDocumentTypeList(mergedUpdateAccountingDocumentTypeList, options);

    if (accountingDocumentTypeList.getToRemoveList() != null) {
      accountingDocumentTypeList.removeAll(accountingDocumentTypeList.getToRemoveList());
    }

    return accountSet;
  }

  protected AccountSet removeAccountingDocumentTypeList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingDocumentType> accountingDocumentTypeList =
        accountSet.getAccountingDocumentTypeList();
    if (accountingDocumentTypeList == null) {
      return accountSet;
    }

    SmartList<AccountingDocumentType> toRemoveAccountingDocumentTypeList =
        accountingDocumentTypeList.getToRemoveList();

    if (toRemoveAccountingDocumentTypeList == null) {
      return accountSet;
    }
    if (toRemoveAccountingDocumentTypeList.isEmpty()) {
      return accountSet; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getAccountingDocumentTypeDAO()
        .removeAccountingDocumentTypeList(toRemoveAccountingDocumentTypeList, options);

    return accountSet;
  }

  public AccountSet present(AccountSet accountSet, Map<String, Object> options) {

    presentAccountingSubjectList(accountSet, options);
    presentAccountingPeriodList(accountSet, options);
    presentAccountingDocumentTypeList(accountSet, options);

    return accountSet;
  }

  // Using java8 feature to reduce the code significantly
  protected AccountSet presentAccountingSubjectList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
    SmartList<AccountingSubject> newList =
        presentSubList(
            accountSet.getId(),
            accountingSubjectList,
            options,
            getAccountingSubjectDAO()::countAccountingSubjectByAccountSet,
            getAccountingSubjectDAO()::findAccountingSubjectByAccountSet);

    accountSet.setAccountingSubjectList(newList);

    return accountSet;
  }

  // Using java8 feature to reduce the code significantly
  protected AccountSet presentAccountingPeriodList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
    SmartList<AccountingPeriod> newList =
        presentSubList(
            accountSet.getId(),
            accountingPeriodList,
            options,
            getAccountingPeriodDAO()::countAccountingPeriodByAccountSet,
            getAccountingPeriodDAO()::findAccountingPeriodByAccountSet);

    accountSet.setAccountingPeriodList(newList);

    return accountSet;
  }

  // Using java8 feature to reduce the code significantly
  protected AccountSet presentAccountingDocumentTypeList(
      AccountSet accountSet, Map<String, Object> options) {

    SmartList<AccountingDocumentType> accountingDocumentTypeList =
        accountSet.getAccountingDocumentTypeList();
    SmartList<AccountingDocumentType> newList =
        presentSubList(
            accountSet.getId(),
            accountingDocumentTypeList,
            options,
            getAccountingDocumentTypeDAO()::countAccountingDocumentTypeByAccountingPeriod,
            getAccountingDocumentTypeDAO()::findAccountingDocumentTypeByAccountingPeriod);

    accountSet.setAccountingDocumentTypeList(newList);

    return accountSet;
  }

  public SmartList<AccountSet> requestCandidateAccountSetForAccountingSubject(
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
        AccountSetTable.COLUMN_NAME,
        AccountSetTable.COLUMN_COUNTRY_CENTER,
        filterKey,
        pageNo,
        pageSize,
        getAccountSetMapper());
  }

  public SmartList<AccountSet> requestCandidateAccountSetForAccountingPeriod(
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
        AccountSetTable.COLUMN_NAME,
        AccountSetTable.COLUMN_COUNTRY_CENTER,
        filterKey,
        pageNo,
        pageSize,
        getAccountSetMapper());
  }

  public SmartList<AccountSet> requestCandidateAccountSetForAccountingDocumentType(
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
        AccountSetTable.COLUMN_NAME,
        AccountSetTable.COLUMN_COUNTRY_CENTER,
        filterKey,
        pageNo,
        pageSize,
        getAccountSetMapper());
  }

  protected String getTableName() {
    return AccountSetTable.TABLE_NAME;
  }

  public void enhanceList(List<AccountSet> accountSetList) {
    this.enhanceListInternal(accountSetList, this.getAccountSetMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<AccountSet> accountSetList = ownerEntity.collectRefsWithType(AccountSet.INTERNAL_TYPE);
    this.enhanceList(accountSetList);
  }

  @Override
  public SmartList<AccountSet> findAccountSetWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getAccountSetMapper());
  }

  @Override
  public int countAccountSetWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countAccountSetWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<AccountSet> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getAccountSetMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<AccountSet> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getAccountSetMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateAccountSet executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateAccountSet result = new CandidateAccountSet();
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
  public List<AccountSet> search(AccountSetRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected AccountSetMapper mapper() {
    return getAccountSetMapper();
  }

  @Override
  protected AccountSetMapper mapperForClazz(Class<?> clazz) {
    return AccountSetMapper.mapperForClass(clazz);
  }
}
