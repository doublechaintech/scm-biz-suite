package com.doublechaintech.retailscm.retailstoreopening;

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

public class RetailStoreOpeningJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements RetailStoreOpeningDAO {

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
  protected RetailStoreOpening load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalRetailStoreOpening(accessKey, options);
  }
  */

  public SmartList<RetailStoreOpening> loadAll() {
    return this.loadAll(getRetailStoreOpeningMapper());
  }

  public Stream<RetailStoreOpening> loadAllAsStream() {
    return this.loadAllAsStream(getRetailStoreOpeningMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public RetailStoreOpening load(String id, Map<String, Object> options) throws Exception {
    return loadInternalRetailStoreOpening(RetailStoreOpeningTable.withId(id), options);
  }

  public RetailStoreOpening save(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    String methodName = "save(RetailStoreOpening retailStoreOpening,Map<String,Object> options)";

    assertMethodArgumentNotNull(retailStoreOpening, methodName, "retailStoreOpening");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalRetailStoreOpening(retailStoreOpening, options);
  }

  public RetailStoreOpening clone(String retailStoreOpeningId, Map<String, Object> options)
      throws Exception {

    return clone(RetailStoreOpeningTable.withId(retailStoreOpeningId), options);
  }

  protected RetailStoreOpening clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String retailStoreOpeningId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    RetailStoreOpening newRetailStoreOpening = loadInternalRetailStoreOpening(accessKey, options);
    newRetailStoreOpening.setVersion(0);

    if (isSaveRetailStoreListEnabled(options)) {
      for (RetailStore item : newRetailStoreOpening.getRetailStoreList()) {
        item.setVersion(0);
      }
    }

    saveInternalRetailStoreOpening(newRetailStoreOpening, options);

    return newRetailStoreOpening;
  }

  protected void throwIfHasException(String retailStoreOpeningId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new RetailStoreOpeningVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new RetailStoreOpeningNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + retailStoreOpeningId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public RetailStoreOpening disconnectFromAll(String retailStoreOpeningId, int version)
      throws Exception {

    RetailStoreOpening retailStoreOpening =
        loadInternalRetailStoreOpening(
            RetailStoreOpeningTable.withId(retailStoreOpeningId), emptyOptions());
    retailStoreOpening.clearFromAll();
    this.saveRetailStoreOpening(retailStoreOpening);
    return retailStoreOpening;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return RetailStoreOpeningTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "retail_store_opening";
  }

  @Override
  protected String getBeanName() {

    return "retailStoreOpening";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return RetailStoreOpeningTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractRetailStoreListEnabled(Map<String, Object> options) {
    return checkOptions(options, RetailStoreOpeningTokens.RETAIL_STORE_LIST);
  }

  protected boolean isAnalyzeRetailStoreListEnabled(Map<String, Object> options) {
    return RetailStoreOpeningTokens.of(options).analyzeRetailStoreListEnabled();
  }

  protected boolean isSaveRetailStoreListEnabled(Map<String, Object> options) {
    return checkOptions(options, RetailStoreOpeningTokens.RETAIL_STORE_LIST);
  }

  protected RetailStoreOpeningMapper getRetailStoreOpeningMapper() {
    return new RetailStoreOpeningMapper();
  }

  protected RetailStoreOpening extractRetailStoreOpening(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      RetailStoreOpening retailStoreOpening =
          loadSingleObject(accessKey, getRetailStoreOpeningMapper());
      return retailStoreOpening;
    } catch (EmptyResultDataAccessException e) {
      throw new RetailStoreOpeningNotFoundException(
          "RetailStoreOpening(" + accessKey + ") is not found!");
    }
  }

  protected RetailStoreOpening loadInternalRetailStoreOpening(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    RetailStoreOpening retailStoreOpening = extractRetailStoreOpening(accessKey, loadOptions);

    if (isExtractRetailStoreListEnabled(loadOptions)) {
      extractRetailStoreList(retailStoreOpening, loadOptions);
    }

    if (isAnalyzeRetailStoreListEnabled(loadOptions)) {
      analyzeRetailStoreList(retailStoreOpening, loadOptions);
    }

    return retailStoreOpening;
  }

  protected void enhanceRetailStoreList(
      SmartList<RetailStore> retailStoreList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected RetailStoreOpening extractRetailStoreList(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    if (retailStoreOpening == null) {
      return null;
    }
    if (retailStoreOpening.getId() == null) {
      return retailStoreOpening;
    }

    SmartList<RetailStore> retailStoreList =
        getRetailStoreDAO().findRetailStoreByOpening(retailStoreOpening.getId(), options);
    if (retailStoreList != null) {
      enhanceRetailStoreList(retailStoreList, options);
      retailStoreOpening.setRetailStoreList(retailStoreList);
    }

    return retailStoreOpening;
  }

  protected RetailStoreOpening analyzeRetailStoreList(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    if (retailStoreOpening == null) {
      return null;
    }
    if (retailStoreOpening.getId() == null) {
      return retailStoreOpening;
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    if (retailStoreList != null) {
      getRetailStoreDAO()
          .analyzeRetailStoreByOpening(retailStoreList, retailStoreOpening.getId(), options);
    }

    return retailStoreOpening;
  }

  protected RetailStoreOpening saveRetailStoreOpening(RetailStoreOpening retailStoreOpening) {

    if (!retailStoreOpening.isChanged()) {
      return retailStoreOpening;
    }

    Beans.dbUtil().cacheCleanUp(retailStoreOpening);
    String SQL = this.getSaveRetailStoreOpeningSQL(retailStoreOpening);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveRetailStoreOpeningParameters(retailStoreOpening);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    retailStoreOpening.incVersion();
    retailStoreOpening.afterSave();
    return retailStoreOpening;
  }

  public SmartList<RetailStoreOpening> saveRetailStoreOpeningList(
      SmartList<RetailStoreOpening> retailStoreOpeningList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitRetailStoreOpeningList(retailStoreOpeningList);

    batchRetailStoreOpeningCreate((List<RetailStoreOpening>) lists[CREATE_LIST_INDEX]);
    batchRetailStoreOpeningUpdate((List<RetailStoreOpening>) lists[UPDATE_LIST_INDEX]);
    batchRetailStoreOpeningRemove((List<RetailStoreOpening>) lists[REMOVE_LIST_INDEX]);
    batchRetailStoreOpeningRecover((List<RetailStoreOpening>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (RetailStoreOpening retailStoreOpening : retailStoreOpeningList) {
      if (retailStoreOpening.isChanged()) {
        retailStoreOpening.incVersion();
        retailStoreOpening.afterSave();
      }
      if (retailStoreOpening.isToRecover() || retailStoreOpening.isToRemove()) {
        retailStoreOpening.setVersion(-retailStoreOpening.getVersion());
      }
    }

    return retailStoreOpeningList;
  }

  public SmartList<RetailStoreOpening> removeRetailStoreOpeningList(
      SmartList<RetailStoreOpening> retailStoreOpeningList, Map<String, Object> options) {

    super.removeList(retailStoreOpeningList, options);

    return retailStoreOpeningList;
  }

  protected List<Object[]> prepareRetailStoreOpeningBatchCreateArgs(
      List<RetailStoreOpening> retailStoreOpeningList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOpening retailStoreOpening : retailStoreOpeningList) {
      Object[] parameters = prepareRetailStoreOpeningCreateParameters(retailStoreOpening);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreOpeningBatchUpdateArgs(
      List<RetailStoreOpening> retailStoreOpeningList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOpening retailStoreOpening : retailStoreOpeningList) {
      if (!retailStoreOpening.isChanged()) {
        continue;
      }
      Object[] parameters = prepareRetailStoreOpeningUpdateParameters(retailStoreOpening);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreOpeningBatchRecoverArgs(
      List<RetailStoreOpening> retailStoreOpeningList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOpening retailStoreOpening : retailStoreOpeningList) {
      if (!retailStoreOpening.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(retailStoreOpening);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreOpeningBatchRemoveArgs(
      List<RetailStoreOpening> retailStoreOpeningList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreOpening retailStoreOpening : retailStoreOpeningList) {
      if (!retailStoreOpening.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareRetailStoreOpeningRemoveParameters(retailStoreOpening);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchRetailStoreOpeningCreate(List<RetailStoreOpening> retailStoreOpeningList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareRetailStoreOpeningBatchCreateArgs(retailStoreOpeningList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchRetailStoreOpeningUpdate(List<RetailStoreOpening> retailStoreOpeningList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareRetailStoreOpeningBatchUpdateArgs(retailStoreOpeningList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreOpeningRemove(List<RetailStoreOpening> retailStoreOpeningList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareRetailStoreOpeningBatchRemoveArgs(retailStoreOpeningList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreOpeningRecover(List<RetailStoreOpening> retailStoreOpeningList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareRetailStoreOpeningBatchRecoverArgs(retailStoreOpeningList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitRetailStoreOpeningList(List<RetailStoreOpening> retailStoreOpeningList) {

    List<RetailStoreOpening> retailStoreOpeningCreateList = new ArrayList<RetailStoreOpening>();
    List<RetailStoreOpening> retailStoreOpeningUpdateList = new ArrayList<RetailStoreOpening>();
    List<RetailStoreOpening> retailStoreOpeningRemoveList = new ArrayList<RetailStoreOpening>();
    List<RetailStoreOpening> retailStoreOpeningRecoverList = new ArrayList<RetailStoreOpening>();

    for (RetailStoreOpening retailStoreOpening : retailStoreOpeningList) {
      if (retailStoreOpening.isToRemove()) {
        retailStoreOpeningRemoveList.add(retailStoreOpening);
        continue;
      }
      if (retailStoreOpening.isToRecover()) {
        retailStoreOpeningRecoverList.add(retailStoreOpening);
        continue;
      }
      if (isUpdateRequest(retailStoreOpening)) {
        if (retailStoreOpening.isChanged()) {
          retailStoreOpeningUpdateList.add(retailStoreOpening);
        }
        continue;
      }

      if (retailStoreOpening.isChanged()) {
        retailStoreOpeningCreateList.add(retailStoreOpening);
      }
    }

    return new Object[] {
      retailStoreOpeningCreateList,
      retailStoreOpeningUpdateList,
      retailStoreOpeningRemoveList,
      retailStoreOpeningRecoverList
    };
  }

  protected boolean isUpdateRequest(RetailStoreOpening retailStoreOpening) {
    return retailStoreOpening.getVersion() > 0;
  }

  protected String getSaveRetailStoreOpeningSQL(RetailStoreOpening retailStoreOpening) {
    if (retailStoreOpening.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(retailStoreOpening)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveRetailStoreOpeningParameters(RetailStoreOpening retailStoreOpening) {
    if (retailStoreOpening.isToRemove()) {
      return prepareRetailStoreOpeningRemoveParameters(retailStoreOpening);
    }
    if (retailStoreOpening.isToRecover()) {
      return prepareRecoverParameters(retailStoreOpening);
    }

    if (isUpdateRequest(retailStoreOpening)) {
      return prepareRetailStoreOpeningUpdateParameters(retailStoreOpening);
    }
    return prepareRetailStoreOpeningCreateParameters(retailStoreOpening);
  }

  protected Object[] prepareRetailStoreOpeningRemoveParameters(
      RetailStoreOpening retailStoreOpening) {
    return super.prepareRemoveParameters(retailStoreOpening);
  }

  protected Object[] prepareRetailStoreOpeningUpdateParameters(
      RetailStoreOpening retailStoreOpening) {
    Object[] parameters = new Object[4];

    parameters[0] = retailStoreOpening.getComment();

    parameters[1] = retailStoreOpening.nextVersion();
    parameters[2] = retailStoreOpening.getId();
    parameters[3] = retailStoreOpening.getVersion();

    return parameters;
  }

  protected Object[] prepareRetailStoreOpeningCreateParameters(
      RetailStoreOpening retailStoreOpening) {
    Object[] parameters = new Object[2];
    if (retailStoreOpening.getId() == null) {
      String newRetailStoreOpeningId = getNextId();
      retailStoreOpening.setId(newRetailStoreOpeningId);
    }
    parameters[0] = retailStoreOpening.getId();

    parameters[1] = retailStoreOpening.getComment();

    return parameters;
  }

  protected RetailStoreOpening saveInternalRetailStoreOpening(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    saveRetailStoreOpening(retailStoreOpening);

    if (isSaveRetailStoreListEnabled(options)) {
      saveRetailStoreList(retailStoreOpening, options);
      // removeRetailStoreList(retailStoreOpening, options);
      // Not delete the record

    }

    return retailStoreOpening;
  }

  // ======================================================================================

  public RetailStoreOpening planToRemoveRetailStoreList(
      RetailStoreOpening retailStoreOpening, String retailStoreIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.ID_PROPERTY, retailStoreIds);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {

      retailStoreItem.clearFromAll();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  // disconnect RetailStoreOpening with retail_store_country_center in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithRetailStoreCountryCenter(
      RetailStoreOpening retailStoreOpening,
      String retailStoreCountryCenterId,
      Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearRetailStoreCountryCenter();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithRetailStoreCountryCenter(
      String retailStoreOpeningId, String retailStoreCountryCenterId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreOpening with city_service_center in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithCityServiceCenter(
      RetailStoreOpening retailStoreOpening,
      String cityServiceCenterId,
      Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearCityServiceCenter();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithCityServiceCenter(
      String retailStoreOpeningId, String cityServiceCenterId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreOpening with creation in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithCreation(
      RetailStoreOpening retailStoreOpening, String creationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.CREATION_PROPERTY, creationId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearCreation();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithCreation(
      String retailStoreOpeningId, String creationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.CREATION_PROPERTY, creationId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreOpening with investment_invitation in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithInvestmentInvitation(
      RetailStoreOpening retailStoreOpening,
      String investmentInvitationId,
      Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearInvestmentInvitation();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithInvestmentInvitation(
      String retailStoreOpeningId, String investmentInvitationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreOpening with franchising in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithFranchising(
      RetailStoreOpening retailStoreOpening, String franchisingId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearFranchising();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithFranchising(
      String retailStoreOpeningId, String franchisingId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreOpening with decoration in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithDecoration(
      RetailStoreOpening retailStoreOpening, String decorationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.DECORATION_PROPERTY, decorationId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearDecoration();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithDecoration(
      String retailStoreOpeningId, String decorationId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.DECORATION_PROPERTY, decorationId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  // disconnect RetailStoreOpening with closing in RetailStore
  public RetailStoreOpening planToRemoveRetailStoreListWithClosing(
      RetailStoreOpening retailStoreOpening, String closingId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpening.getId());
    key.put(RetailStore.CLOSING_PROPERTY, closingId);

    SmartList<RetailStore> externalRetailStoreList =
        getRetailStoreDAO().findRetailStoreWithKey(key, options);
    if (externalRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (externalRetailStoreList.isEmpty()) {
      return retailStoreOpening;
    }

    for (RetailStore retailStoreItem : externalRetailStoreList) {
      retailStoreItem.clearClosing();
      retailStoreItem.clearOpening();
    }

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    retailStoreList.addAllToRemoveList(externalRetailStoreList);
    return retailStoreOpening;
  }

  public int countRetailStoreListWithClosing(
      String retailStoreOpeningId, String closingId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
    key.put(RetailStore.CLOSING_PROPERTY, closingId);

    int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
    return count;
  }

  protected RetailStoreOpening saveRetailStoreList(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    if (retailStoreList == null) {
      // null list means nothing
      return retailStoreOpening;
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

    return retailStoreOpening;
  }

  protected RetailStoreOpening removeRetailStoreList(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    if (retailStoreList == null) {
      return retailStoreOpening;
    }

    SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();

    if (toRemoveRetailStoreList == null) {
      return retailStoreOpening;
    }
    if (toRemoveRetailStoreList.isEmpty()) {
      return retailStoreOpening; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList, options);

    return retailStoreOpening;
  }

  public RetailStoreOpening present(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    presentRetailStoreList(retailStoreOpening, options);

    return retailStoreOpening;
  }

  // Using java8 feature to reduce the code significantly
  protected RetailStoreOpening presentRetailStoreList(
      RetailStoreOpening retailStoreOpening, Map<String, Object> options) {

    SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
    SmartList<RetailStore> newList =
        presentSubList(
            retailStoreOpening.getId(),
            retailStoreList,
            options,
            getRetailStoreDAO()::countRetailStoreByOpening,
            getRetailStoreDAO()::findRetailStoreByOpening);

    retailStoreOpening.setRetailStoreList(newList);

    return retailStoreOpening;
  }

  public SmartList<RetailStoreOpening> requestCandidateRetailStoreOpeningForRetailStore(
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
        RetailStoreOpeningTable.COLUMN_COMMENT,
        null,
        filterKey,
        pageNo,
        pageSize,
        getRetailStoreOpeningMapper());
  }

  protected String getTableName() {
    return RetailStoreOpeningTable.TABLE_NAME;
  }

  public void enhanceList(List<RetailStoreOpening> retailStoreOpeningList) {
    this.enhanceListInternal(retailStoreOpeningList, this.getRetailStoreOpeningMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<RetailStoreOpening> retailStoreOpeningList =
        ownerEntity.collectRefsWithType(RetailStoreOpening.INTERNAL_TYPE);
    this.enhanceList(retailStoreOpeningList);
  }

  @Override
  public SmartList<RetailStoreOpening> findRetailStoreOpeningWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getRetailStoreOpeningMapper());
  }

  @Override
  public int countRetailStoreOpeningWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countRetailStoreOpeningWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<RetailStoreOpening> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getRetailStoreOpeningMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<RetailStoreOpening> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreOpeningMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateRetailStoreOpening executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateRetailStoreOpening result = new CandidateRetailStoreOpening();
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
  public List<RetailStoreOpening> search(RetailStoreOpeningRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreOpeningMapper mapper() {
    return getRetailStoreOpeningMapper();
  }

  @Override
  protected RetailStoreOpeningMapper mapperForClazz(Class<?> clazz) {
    return RetailStoreOpeningMapper.mapperForClass(clazz);
  }
}
