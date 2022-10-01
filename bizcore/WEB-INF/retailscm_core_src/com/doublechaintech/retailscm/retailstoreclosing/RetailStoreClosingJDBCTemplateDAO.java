package com.doublechaintech.retailscm.retailstoreclosing;

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

import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreClosingJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements RetailStoreClosingDAO {

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

  /*
  protected RetailStoreClosing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalRetailStoreClosing(accessKey, options);
  }
  */

  public SmartList<RetailStoreClosing> loadAll() {
    return this.loadAll(getRetailStoreClosingMapper());
  }

  public Stream<RetailStoreClosing> loadAllAsStream() {
    return this.loadAllAsStream(getRetailStoreClosingMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public RetailStoreClosing load(String id, Map<String, Object> options) throws Exception {
    return loadInternalRetailStoreClosing(RetailStoreClosingTable.withId(id), options);
  }

  public RetailStoreClosing save(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    String methodName = "save(RetailStoreClosing retailStoreClosing,Map<String,Object> options)";

    assertMethodArgumentNotNull(retailStoreClosing, methodName, "retailStoreClosing");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalRetailStoreClosing(retailStoreClosing, options);
  }

  public RetailStoreClosing clone(String retailStoreClosingId, Map<String, Object> options)
      throws Exception {

    return clone(RetailStoreClosingTable.withId(retailStoreClosingId), options);
  }

  protected RetailStoreClosing clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String retailStoreClosingId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    RetailStoreClosing newRetailStoreClosing = loadInternalRetailStoreClosing(accessKey, options);
    newRetailStoreClosing.setVersion(0);

    if (isSaveRetailStoreListEnabled(options)) {
      for (RetailStore item : newRetailStoreClosing.getRetailStoreList()) {
        item.setVersion(0);
      }
    }

    saveInternalRetailStoreClosing(newRetailStoreClosing, options);

    return newRetailStoreClosing;
  }

  protected void throwIfHasException(String retailStoreClosingId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new RetailStoreClosingVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new RetailStoreClosingNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + retailStoreClosingId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public RetailStoreClosing disconnectFromAll(String retailStoreClosingId, int version)
      throws Exception {

    RetailStoreClosing retailStoreClosing =
        loadInternalRetailStoreClosing(
            RetailStoreClosingTable.withId(retailStoreClosingId), emptyOptions());
    retailStoreClosing.clearFromAll();
    this.saveRetailStoreClosing(retailStoreClosing);
    return retailStoreClosing;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return RetailStoreClosingTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "retail_store_closing";
  }

  @Override
  protected String getBeanName() {

    return "retailStoreClosing";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return RetailStoreClosingTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractRetailStoreListEnabled(Map<String, Object> options) {
    return checkOptions(options, RetailStoreClosingTokens.RETAIL_STORE_LIST);
  }

  protected boolean isAnalyzeRetailStoreListEnabled(Map<String, Object> options) {
    return RetailStoreClosingTokens.of(options).analyzeRetailStoreListEnabled();
  }

  protected boolean isSaveRetailStoreListEnabled(Map<String, Object> options) {
    return checkOptions(options, RetailStoreClosingTokens.RETAIL_STORE_LIST);
  }

  protected RetailStoreClosingMapper getRetailStoreClosingMapper() {
    return new RetailStoreClosingMapper();
  }

  protected RetailStoreClosing extractRetailStoreClosing(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      RetailStoreClosing retailStoreClosing =
          loadSingleObject(accessKey, getRetailStoreClosingMapper());
      return retailStoreClosing;
    } catch (EmptyResultDataAccessException e) {
      throw new RetailStoreClosingNotFoundException(
          "RetailStoreClosing(" + accessKey + ") is not found!");
    }
  }

  protected RetailStoreClosing loadInternalRetailStoreClosing(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    RetailStoreClosing retailStoreClosing = extractRetailStoreClosing(accessKey, loadOptions);

    if (isExtractRetailStoreListEnabled(loadOptions)) {
      extractRetailStoreList(retailStoreClosing, loadOptions);
    }

    if (isAnalyzeRetailStoreListEnabled(loadOptions)) {
      analyzeRetailStoreList(retailStoreClosing, loadOptions);
    }

    return retailStoreClosing;
  }

  protected void enhanceRetailStoreList(
      SmartList<RetailStore> retailStoreList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected RetailStoreClosing extractRetailStoreList(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    if (retailStoreClosing == null) {
      return null;
    }
    if (retailStoreClosing.getId() == null) {
      return retailStoreClosing;
    }

    SmartList<RetailStore> retailStoreList =
        getRetailStoreDAO().findRetailStoreByClosing(retailStoreClosing.getId(), options);
    if (retailStoreList != null) {
      enhanceRetailStoreList(retailStoreList, options);
      retailStoreClosing.setRetailStoreList(retailStoreList);
    }

    return retailStoreClosing;
  }

  protected RetailStoreClosing analyzeRetailStoreList(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    if (retailStoreClosing == null) {
      return null;
    }
    if (retailStoreClosing.getId() == null) {
      return retailStoreClosing;
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    if (retailStoreList != null) {
      getRetailStoreDAO()
          .analyzeRetailStoreByClosing(retailStoreList, retailStoreClosing.getId(), options);
    }

    return retailStoreClosing;
  }

  protected RetailStoreClosing saveRetailStoreClosing(RetailStoreClosing retailStoreClosing) {

    if (!retailStoreClosing.isChanged()) {
      return retailStoreClosing;
    }

    Beans.dbUtil().cacheCleanUp(retailStoreClosing);
    String SQL = this.getSaveRetailStoreClosingSQL(retailStoreClosing);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveRetailStoreClosingParameters(retailStoreClosing);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    retailStoreClosing.incVersion();
    retailStoreClosing.afterSave();
    return retailStoreClosing;
  }

  public SmartList<RetailStoreClosing> saveRetailStoreClosingList(
      SmartList<RetailStoreClosing> retailStoreClosingList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitRetailStoreClosingList(retailStoreClosingList);

    batchRetailStoreClosingCreate((List<RetailStoreClosing>) lists[CREATE_LIST_INDEX]);
    batchRetailStoreClosingUpdate((List<RetailStoreClosing>) lists[UPDATE_LIST_INDEX]);
    batchRetailStoreClosingRemove((List<RetailStoreClosing>) lists[REMOVE_LIST_INDEX]);
    batchRetailStoreClosingRecover((List<RetailStoreClosing>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (RetailStoreClosing retailStoreClosing : retailStoreClosingList) {
      if (retailStoreClosing.isChanged()) {
        retailStoreClosing.incVersion();
        retailStoreClosing.afterSave();
      }
      if (retailStoreClosing.isToRecover() || retailStoreClosing.isToRemove()) {
        retailStoreClosing.setVersion(-retailStoreClosing.getVersion());
      }
    }

    return retailStoreClosingList;
  }

  public SmartList<RetailStoreClosing> removeRetailStoreClosingList(
      SmartList<RetailStoreClosing> retailStoreClosingList, Map<String, Object> options) {

    super.removeList(retailStoreClosingList, options);

    return retailStoreClosingList;
  }

  protected List<Object[]> prepareRetailStoreClosingBatchCreateArgs(
      List<RetailStoreClosing> retailStoreClosingList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreClosing retailStoreClosing : retailStoreClosingList) {
      Object[] parameters = prepareRetailStoreClosingCreateParameters(retailStoreClosing);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreClosingBatchUpdateArgs(
      List<RetailStoreClosing> retailStoreClosingList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreClosing retailStoreClosing : retailStoreClosingList) {
      if (!retailStoreClosing.isChanged()) {
        continue;
      }
      Object[] parameters = prepareRetailStoreClosingUpdateParameters(retailStoreClosing);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreClosingBatchRecoverArgs(
      List<RetailStoreClosing> retailStoreClosingList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreClosing retailStoreClosing : retailStoreClosingList) {
      if (!retailStoreClosing.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(retailStoreClosing);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreClosingBatchRemoveArgs(
      List<RetailStoreClosing> retailStoreClosingList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreClosing retailStoreClosing : retailStoreClosingList) {
      if (!retailStoreClosing.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareRetailStoreClosingRemoveParameters(retailStoreClosing);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchRetailStoreClosingCreate(List<RetailStoreClosing> retailStoreClosingList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareRetailStoreClosingBatchCreateArgs(retailStoreClosingList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchRetailStoreClosingUpdate(List<RetailStoreClosing> retailStoreClosingList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareRetailStoreClosingBatchUpdateArgs(retailStoreClosingList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreClosingRemove(List<RetailStoreClosing> retailStoreClosingList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareRetailStoreClosingBatchRemoveArgs(retailStoreClosingList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreClosingRecover(List<RetailStoreClosing> retailStoreClosingList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareRetailStoreClosingBatchRecoverArgs(retailStoreClosingList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitRetailStoreClosingList(List<RetailStoreClosing> retailStoreClosingList) {

    List<RetailStoreClosing> retailStoreClosingCreateList = new ArrayList<RetailStoreClosing>();
    List<RetailStoreClosing> retailStoreClosingUpdateList = new ArrayList<RetailStoreClosing>();
    List<RetailStoreClosing> retailStoreClosingRemoveList = new ArrayList<RetailStoreClosing>();
    List<RetailStoreClosing> retailStoreClosingRecoverList = new ArrayList<RetailStoreClosing>();

    for (RetailStoreClosing retailStoreClosing : retailStoreClosingList) {
      if (retailStoreClosing.isToRemove()) {
        retailStoreClosingRemoveList.add(retailStoreClosing);
        continue;
      }
      if (retailStoreClosing.isToRecover()) {
        retailStoreClosingRecoverList.add(retailStoreClosing);
        continue;
      }
      if (isUpdateRequest(retailStoreClosing)) {
        if (retailStoreClosing.isChanged()) {
          retailStoreClosingUpdateList.add(retailStoreClosing);
        }
        continue;
      }

      if (retailStoreClosing.isChanged()) {
        retailStoreClosingCreateList.add(retailStoreClosing);
      }
    }

    return new Object[] {
      retailStoreClosingCreateList,
      retailStoreClosingUpdateList,
      retailStoreClosingRemoveList,
      retailStoreClosingRecoverList
    };
  }

  protected boolean isUpdateRequest(RetailStoreClosing retailStoreClosing) {
    return retailStoreClosing.getVersion() > 0;
  }

  protected String getSaveRetailStoreClosingSQL(RetailStoreClosing retailStoreClosing) {
    if (retailStoreClosing.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(retailStoreClosing)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveRetailStoreClosingParameters(RetailStoreClosing retailStoreClosing) {
    if (retailStoreClosing.isToRemove()) {
      return prepareRetailStoreClosingRemoveParameters(retailStoreClosing);
    }
    if (retailStoreClosing.isToRecover()) {
      return prepareRecoverParameters(retailStoreClosing);
    }

    if (isUpdateRequest(retailStoreClosing)) {
      return prepareRetailStoreClosingUpdateParameters(retailStoreClosing);
    }
    return prepareRetailStoreClosingCreateParameters(retailStoreClosing);
  }

  protected Object[] prepareRetailStoreClosingRemoveParameters(
      RetailStoreClosing retailStoreClosing) {
    return super.prepareRemoveParameters(retailStoreClosing);
  }

  protected Object[] prepareRetailStoreClosingUpdateParameters(
      RetailStoreClosing retailStoreClosing) {
    Object[] parameters = new Object[4];

    parameters[0] = retailStoreClosing.getComment();

    parameters[1] = retailStoreClosing.nextVersion();
    parameters[2] = retailStoreClosing.getId();
    parameters[3] = retailStoreClosing.getVersion();

    return parameters;
  }

  protected Object[] prepareRetailStoreClosingCreateParameters(
      RetailStoreClosing retailStoreClosing) {
    Object[] parameters = new Object[2];
    if (retailStoreClosing.getId() == null) {
      String newRetailStoreClosingId = getNextId();
      retailStoreClosing.setId(newRetailStoreClosingId);
    }
    parameters[0] = retailStoreClosing.getId();

    parameters[1] = retailStoreClosing.getComment();

    return parameters;
  }

  protected RetailStoreClosing saveInternalRetailStoreClosing(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    saveRetailStoreClosing(retailStoreClosing);

    if (isSaveRetailStoreListEnabled(options)) {
      saveRetailStoreList(retailStoreClosing, options);
      // removeRetailStoreList(retailStoreClosing, options);
      // Not delete the record

    }

    return retailStoreClosing;
  }

  // ======================================================================================

  public RetailStoreClosing planToRemoveRetailStoreList(
      RetailStoreClosing retailStoreClosing, String retailStoreIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.ID_PROPERTY, retailStoreIds);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {

      retailStoreItem.clearFromAll();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  // disconnect RetailStoreClosing with retail_store_country_center in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithRetailStoreCountryCenter(
      RetailStoreClosing retailStoreClosing,
      String retailStoreCountryCenterId,
      Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearRetailStoreCountryCenter();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithRetailStoreCountryCenter(
      String retailStoreClosingId, String retailStoreCountryCenterId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreClosing with city_service_center in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithCityServiceCenter(
      RetailStoreClosing retailStoreClosing,
      String cityServiceCenterId,
      Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearCityServiceCenter();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithCityServiceCenter(
      String retailStoreClosingId, String cityServiceCenterId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreClosing with creation in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithCreation(
      RetailStoreClosing retailStoreClosing, String creationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.CREATION_PROPERTY, creationId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearCreation();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithCreation(
      String retailStoreClosingId, String creationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.CREATION_PROPERTY, creationId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreClosing with investment_invitation in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithInvestmentInvitation(
      RetailStoreClosing retailStoreClosing,
      String investmentInvitationId,
      Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearInvestmentInvitation();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithInvestmentInvitation(
      String retailStoreClosingId, String investmentInvitationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreClosing with franchising in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithFranchising(
      RetailStoreClosing retailStoreClosing, String franchisingId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearFranchising();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithFranchising(
      String retailStoreClosingId, String franchisingId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreClosing with decoration in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithDecoration(
      RetailStoreClosing retailStoreClosing, String decorationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.DECORATION_PROPERTY, decorationId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearDecoration();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithDecoration(
      String retailStoreClosingId, String decorationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.DECORATION_PROPERTY, decorationId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreClosing with opening in RetailStore
  public RetailStoreClosing planToRemoveRetailStoreListWithOpening(
      RetailStoreClosing retailStoreClosing, String openingId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosing.getId());
    key.put(RetailStore.OPENING_PROPERTY, openingId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreClosing;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearOpening();
      retailStoreItem.clearClosing();
    }

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreClosing;
  }

  public int countRetailStoreListWithOpening(
      String retailStoreClosingId, String openingId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
    key.put(RetailStore.OPENING_PROPERTY, openingId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  protected RetailStoreClosing saveRetailStoreList(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    if (retailStoreList == null) {
      // null list means nothing
      return retailStoreClosing;
    }
    SmartList<RetailStore> mergedUpdateRetailStoreList = new SmartList<RetailStore>();

    mergedUpdateRetailStoreList.addAll(retailStoreList);
    if (retailStoreList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateRetailStoreList.addAll(retailStoreList.getToRemoveList());
      retailStoreList.removeAll(retailStoreList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getRetailStoreDAO().saveRetailStoreList(mergedUpdateRetailStoreList, options);

    if (retailStoreList.getToRemoveList() != null) {
      retailStoreList.removeAll(retailStoreList.getToRemoveList());
    }

    return retailStoreClosing;
  }

  protected RetailStoreClosing removeRetailStoreList(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    if (retailStoreList == null) {
      return retailStoreClosing;
    }

    SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();

    if (toRemoveRetailStoreList == null) {
      return retailStoreClosing;
    }
    if (toRemoveRetailStoreList.isEmpty()) {
      return retailStoreClosing; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList, options);

    return retailStoreClosing;
  }

  public RetailStoreClosing present(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    presentRetailStoreList(retailStoreClosing, options);

    return retailStoreClosing;
  }

  // Using java8 feature to reduce the code significantly
  protected RetailStoreClosing presentRetailStoreList(
      RetailStoreClosing retailStoreClosing, Map<String, Object> options) {

    SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
    SmartList<RetailStore> newList =
        presentSubList(
            retailStoreClosing.getId(),
            retailStoreList,
            options,
            getRetailStoreDAO()::countRetailStoreByClosing,
            getRetailStoreDAO()::findRetailStoreByClosing);

    retailStoreClosing.setRetailStoreList(newList);

    return retailStoreClosing;
  }

  public SmartList<RetailStoreClosing> requestCandidateRetailStoreClosingForRetailStore(
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
        RetailStoreClosingTable.COLUMN_COMMENT,
        null,
        filterKey,
        pageNo,
        pageSize,
        getRetailStoreClosingMapper());
  }

  protected String getTableName() {
    return RetailStoreClosingTable.TABLE_NAME;
  }

  public void enhanceList(List<RetailStoreClosing> retailStoreClosingList) {
    this.enhanceListInternal(retailStoreClosingList, this.getRetailStoreClosingMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<RetailStoreClosing> retailStoreClosingList =
        ownerEntity.collectRefsWithType(RetailStoreClosing.INTERNAL_TYPE);
    this.enhanceList(retailStoreClosingList);
  }

  @Override
  public SmartList<RetailStoreClosing> findRetailStoreClosingWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getRetailStoreClosingMapper());
  }

  @Override
  public int countRetailStoreClosingWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countRetailStoreClosingWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<RetailStoreClosing> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getRetailStoreClosingMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<RetailStoreClosing> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreClosingMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateRetailStoreClosing executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateRetailStoreClosing result = new CandidateRetailStoreClosing();
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

  public Map<String, Integer> countBySql(String sql, Object[] params) {
    if (params == null || params.length == 0) {
      return new HashMap<>();
    }
    List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
    if (result == null || result.isEmpty()) {
      return new HashMap<>();
    }
    Map<String, Integer> cntMap = new HashMap<>();
    for (Map<String, Object> data : result) {
      String key = String.valueOf(data.get("id"));
      Number value = (Number) data.get("count");
      cntMap.put(key, value.intValue());
    }
    this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
    return cntMap;
  }

  public Integer singleCountBySql(String sql, Object[] params) {
    Integer cnt = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
    logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
    return cnt;
  }

  public BigDecimal summaryBySql(String sql, Object[] params) {
    BigDecimal cnt = this.getJdbcTemplate().queryForObject(sql, params, BigDecimal.class);
    logSQLAndParameters("summaryBySql", sql, params, cnt + "");
    return cnt == null ? BigDecimal.ZERO : cnt;
  }

  public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
    List<T> result = this.getJdbcTemplate().queryForList(sql, params, claxx);
    logSQLAndParameters("queryForList", sql, params, result.size() + " items");
    return result;
  }

  public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
    Map<String, Object> result = null;
    try {
      result = this.getJdbcTemplate().queryForMap(sql, params);
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
      // 空结果，返回null
    }
    logSQLAndParameters(
        "queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
    return result;
  }

  public <T> T queryForObject(String sql, Object[] params, Class<T> claxx)
      throws DataAccessException {
    T result = null;
    try {
      result = this.getJdbcTemplate().queryForObject(sql, params, claxx);
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
      // 空结果，返回null
    }
    logSQLAndParameters(
        "queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
    return result;
  }

  public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
    List<Map<String, Object>> result = getJdbcTemplate().queryForList(sql, params);
    logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
    return result;
  }

  public synchronized int updateBySql(String sql, Object[] params) {
    int result = getJdbcTemplate().update(sql, params);
    logSQLAndParameters("updateBySql", sql, params, result + " items");
    return result;
  }

  public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
    getJdbcTemplate().query(sql, args, callback);
  }

  public void executeSql(String sql) {
    logSQLAndParameters("executeSql", sql, new Object[] {}, "");
    getJdbcTemplate().execute(sql);
  }

  @Override
  public List<RetailStoreClosing> search(RetailStoreClosingRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreClosingMapper mapper() {
    return getRetailStoreClosingMapper();
  }

  @Override
  protected RetailStoreClosingMapper mapperForClazz(Class<?> clazz) {
    return RetailStoreClosingMapper.mapperForClass(clazz);
  }
}
