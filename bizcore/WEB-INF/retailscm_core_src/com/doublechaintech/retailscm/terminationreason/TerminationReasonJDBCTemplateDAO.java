package com.doublechaintech.retailscm.terminationreason;

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

import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.termination.TerminationDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TerminationReasonJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements TerminationReasonDAO {

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

  protected TerminationDAO terminationDAO;

  public void setTerminationDAO(TerminationDAO terminationDAO) {

    if (terminationDAO == null) {
      throw new IllegalStateException("Do not try to set terminationDAO to null.");
    }
    this.terminationDAO = terminationDAO;
  }

  public TerminationDAO getTerminationDAO() {
    if (this.terminationDAO == null) {
      throw new IllegalStateException(
          "The terminationDAO is not configured yet, please config it some where.");
    }

    return this.terminationDAO;
  }

  /*
  protected TerminationReason load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalTerminationReason(accessKey, options);
  }
  */

  public SmartList<TerminationReason> loadAll() {
    return this.loadAll(getTerminationReasonMapper());
  }

  public Stream<TerminationReason> loadAllAsStream() {
    return this.loadAllAsStream(getTerminationReasonMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public TerminationReason load(String id, Map<String, Object> options) throws Exception {
    return loadInternalTerminationReason(TerminationReasonTable.withId(id), options);
  }

  public TerminationReason save(TerminationReason terminationReason, Map<String, Object> options) {

    String methodName = "save(TerminationReason terminationReason,Map<String,Object> options)";

    assertMethodArgumentNotNull(terminationReason, methodName, "terminationReason");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalTerminationReason(terminationReason, options);
  }

  public TerminationReason clone(String terminationReasonId, Map<String, Object> options)
      throws Exception {

    return clone(TerminationReasonTable.withId(terminationReasonId), options);
  }

  protected TerminationReason clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String terminationReasonId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    TerminationReason newTerminationReason = loadInternalTerminationReason(accessKey, options);
    newTerminationReason.setVersion(0);

    if (isSaveTerminationListEnabled(options)) {
      for (Termination item : newTerminationReason.getTerminationList()) {
        item.setVersion(0);
      }
    }

    saveInternalTerminationReason(newTerminationReason, options);

    return newTerminationReason;
  }

  protected void throwIfHasException(String terminationReasonId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new TerminationReasonVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new TerminationReasonNotFoundException(
          "The " + this.getTableName() + "(" + terminationReasonId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public TerminationReason disconnectFromAll(String terminationReasonId, int version)
      throws Exception {

    TerminationReason terminationReason =
        loadInternalTerminationReason(
            TerminationReasonTable.withId(terminationReasonId), emptyOptions());
    terminationReason.clearFromAll();
    this.saveTerminationReason(terminationReason);
    return terminationReason;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return TerminationReasonTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "termination_reason";
  }

  @Override
  protected String getBeanName() {

    return "terminationReason";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return TerminationReasonTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationReasonTokens.COMPANY);
  }

  protected boolean isSaveCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationReasonTokens.COMPANY);
  }

  protected boolean isExtractTerminationListEnabled(Map<String, Object> options) {
    return checkOptions(options, TerminationReasonTokens.TERMINATION_LIST);
  }

  protected boolean isAnalyzeTerminationListEnabled(Map<String, Object> options) {
    return TerminationReasonTokens.of(options).analyzeTerminationListEnabled();
  }

  protected boolean isSaveTerminationListEnabled(Map<String, Object> options) {
    return checkOptions(options, TerminationReasonTokens.TERMINATION_LIST);
  }

  protected TerminationReasonMapper getTerminationReasonMapper() {
    return new TerminationReasonMapper();
  }

  protected TerminationReason extractTerminationReason(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      TerminationReason terminationReason =
          loadSingleObject(accessKey, getTerminationReasonMapper());
      return terminationReason;
    } catch (EmptyResultDataAccessException e) {
      throw new TerminationReasonNotFoundException(
          "TerminationReason(" + accessKey + ") is not found!");
    }
  }

  protected TerminationReason loadInternalTerminationReason(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    TerminationReason terminationReason = extractTerminationReason(accessKey, loadOptions);

    if (isExtractCompanyEnabled(loadOptions)) {
      extractCompany(terminationReason, loadOptions);
    }

    if (isExtractTerminationListEnabled(loadOptions)) {
      extractTerminationList(terminationReason, loadOptions);
    }

    if (isAnalyzeTerminationListEnabled(loadOptions)) {
      analyzeTerminationList(terminationReason, loadOptions);
    }

    return terminationReason;
  }

  protected TerminationReason extractCompany(
      TerminationReason terminationReason, Map<String, Object> options) throws Exception {

    if (terminationReason.getCompany() == null) {
      return terminationReason;
    }
    String companyId = terminationReason.getCompany().getId();
    if (companyId == null) {
      return terminationReason;
    }
    RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId, options);
    if (company != null) {
      terminationReason.setCompany(company);
    }

    return terminationReason;
  }

  protected void enhanceTerminationList(
      SmartList<Termination> terminationList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected TerminationReason extractTerminationList(
      TerminationReason terminationReason, Map<String, Object> options) {

    if (terminationReason == null) {
      return null;
    }
    if (terminationReason.getId() == null) {
      return terminationReason;
    }

    SmartList<Termination> terminationList =
        getTerminationDAO().findTerminationByReason(terminationReason.getId(), options);
    if (terminationList != null) {
      enhanceTerminationList(terminationList, options);
      terminationReason.setTerminationList(terminationList);
    }

    return terminationReason;
  }

  protected TerminationReason analyzeTerminationList(
      TerminationReason terminationReason, Map<String, Object> options) {

    if (terminationReason == null) {
      return null;
    }
    if (terminationReason.getId() == null) {
      return terminationReason;
    }

    SmartList<Termination> terminationList = terminationReason.getTerminationList();
    if (terminationList != null) {
      getTerminationDAO()
          .analyzeTerminationByReason(terminationList, terminationReason.getId(), options);
    }

    return terminationReason;
  }

  public SmartList<TerminationReason> findTerminationReasonByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<TerminationReason> resultList =
        queryWith(
            TerminationReasonTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getTerminationReasonMapper());
    // analyzeTerminationReasonByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<TerminationReason> findTerminationReasonByCompany(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<TerminationReason> resultList =
        queryWithRange(
            TerminationReasonTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getTerminationReasonMapper(),
            start,
            count);
    // analyzeTerminationReasonByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzeTerminationReasonByCompany(
      SmartList<TerminationReason> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countTerminationReasonByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(TerminationReasonTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countTerminationReasonByCompanyIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(TerminationReasonTable.COLUMN_COMPANY, ids, options);
  }

  protected TerminationReason saveTerminationReason(TerminationReason terminationReason) {

    if (!terminationReason.isChanged()) {
      return terminationReason;
    }

    Beans.dbUtil().cacheCleanUp(terminationReason);
    String SQL = this.getSaveTerminationReasonSQL(terminationReason);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveTerminationReasonParameters(terminationReason);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    terminationReason.incVersion();
    terminationReason.afterSave();
    return terminationReason;
  }

  public SmartList<TerminationReason> saveTerminationReasonList(
      SmartList<TerminationReason> terminationReasonList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitTerminationReasonList(terminationReasonList);

    batchTerminationReasonCreate((List<TerminationReason>) lists[CREATE_LIST_INDEX]);
    batchTerminationReasonUpdate((List<TerminationReason>) lists[UPDATE_LIST_INDEX]);
    batchTerminationReasonRemove((List<TerminationReason>) lists[REMOVE_LIST_INDEX]);
    batchTerminationReasonRecover((List<TerminationReason>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (TerminationReason terminationReason : terminationReasonList) {
      if (terminationReason.isChanged()) {
        terminationReason.incVersion();
        terminationReason.afterSave();
      }
      if (terminationReason.isToRecover() || terminationReason.isToRemove()) {
        terminationReason.setVersion(-terminationReason.getVersion());
      }
    }

    return terminationReasonList;
  }

  public SmartList<TerminationReason> removeTerminationReasonList(
      SmartList<TerminationReason> terminationReasonList, Map<String, Object> options) {

    super.removeList(terminationReasonList, options);

    return terminationReasonList;
  }

  protected List<Object[]> prepareTerminationReasonBatchCreateArgs(
      List<TerminationReason> terminationReasonList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationReason terminationReason : terminationReasonList) {
      Object[] parameters = prepareTerminationReasonCreateParameters(terminationReason);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationReasonBatchUpdateArgs(
      List<TerminationReason> terminationReasonList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationReason terminationReason : terminationReasonList) {
      if (!terminationReason.isChanged()) {
        continue;
      }
      Object[] parameters = prepareTerminationReasonUpdateParameters(terminationReason);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationReasonBatchRecoverArgs(
      List<TerminationReason> terminationReasonList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationReason terminationReason : terminationReasonList) {
      if (!terminationReason.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(terminationReason);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationReasonBatchRemoveArgs(
      List<TerminationReason> terminationReasonList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationReason terminationReason : terminationReasonList) {
      if (!terminationReason.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareTerminationReasonRemoveParameters(terminationReason);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchTerminationReasonCreate(List<TerminationReason> terminationReasonList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareTerminationReasonBatchCreateArgs(terminationReasonList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchTerminationReasonUpdate(List<TerminationReason> terminationReasonList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareTerminationReasonBatchUpdateArgs(terminationReasonList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchTerminationReasonRemove(List<TerminationReason> terminationReasonList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareTerminationReasonBatchRemoveArgs(terminationReasonList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchTerminationReasonRecover(List<TerminationReason> terminationReasonList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareTerminationReasonBatchRecoverArgs(terminationReasonList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitTerminationReasonList(List<TerminationReason> terminationReasonList) {

    List<TerminationReason> terminationReasonCreateList = new ArrayList<TerminationReason>();
    List<TerminationReason> terminationReasonUpdateList = new ArrayList<TerminationReason>();
    List<TerminationReason> terminationReasonRemoveList = new ArrayList<TerminationReason>();
    List<TerminationReason> terminationReasonRecoverList = new ArrayList<TerminationReason>();

    for (TerminationReason terminationReason : terminationReasonList) {
      if (terminationReason.isToRemove()) {
        terminationReasonRemoveList.add(terminationReason);
        continue;
      }
      if (terminationReason.isToRecover()) {
        terminationReasonRecoverList.add(terminationReason);
        continue;
      }
      if (isUpdateRequest(terminationReason)) {
        if (terminationReason.isChanged()) {
          terminationReasonUpdateList.add(terminationReason);
        }
        continue;
      }

      if (terminationReason.isChanged()) {
        terminationReasonCreateList.add(terminationReason);
      }
    }

    return new Object[] {
      terminationReasonCreateList,
      terminationReasonUpdateList,
      terminationReasonRemoveList,
      terminationReasonRecoverList
    };
  }

  protected boolean isUpdateRequest(TerminationReason terminationReason) {
    return terminationReason.getVersion() > 0;
  }

  protected String getSaveTerminationReasonSQL(TerminationReason terminationReason) {
    if (terminationReason.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(terminationReason)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveTerminationReasonParameters(TerminationReason terminationReason) {
    if (terminationReason.isToRemove()) {
      return prepareTerminationReasonRemoveParameters(terminationReason);
    }
    if (terminationReason.isToRecover()) {
      return prepareRecoverParameters(terminationReason);
    }

    if (isUpdateRequest(terminationReason)) {
      return prepareTerminationReasonUpdateParameters(terminationReason);
    }
    return prepareTerminationReasonCreateParameters(terminationReason);
  }

  protected Object[] prepareTerminationReasonRemoveParameters(TerminationReason terminationReason) {
    return super.prepareRemoveParameters(terminationReason);
  }

  protected Object[] prepareTerminationReasonUpdateParameters(TerminationReason terminationReason) {
    Object[] parameters = new Object[6];

    parameters[0] = terminationReason.getCode();

    if (terminationReason.getCompany() != null) {
      parameters[1] = terminationReason.getCompany().getId();
    }

    parameters[2] = terminationReason.getDescription();

    parameters[3] = terminationReason.nextVersion();
    parameters[4] = terminationReason.getId();
    parameters[5] = terminationReason.getVersion();

    return parameters;
  }

  protected Object[] prepareTerminationReasonCreateParameters(TerminationReason terminationReason) {
    Object[] parameters = new Object[4];
    if (terminationReason.getId() == null) {
      String newTerminationReasonId = getNextId();
      terminationReason.setId(newTerminationReasonId);
    }
    parameters[0] = terminationReason.getId();

    parameters[1] = terminationReason.getCode();

    if (terminationReason.getCompany() != null) {
      parameters[2] = terminationReason.getCompany().getId();
    }

    parameters[3] = terminationReason.getDescription();

    return parameters;
  }

  protected TerminationReason saveInternalTerminationReason(
      TerminationReason terminationReason, Map<String, Object> options) {

    if (isSaveCompanyEnabled(options)) {
      saveCompany(terminationReason, options);
    }

    saveTerminationReason(terminationReason);

    if (isSaveTerminationListEnabled(options)) {
      saveTerminationList(terminationReason, options);
      // removeTerminationList(terminationReason, options);
      // Not delete the record

    }

    return terminationReason;
  }

  // ======================================================================================

  protected TerminationReason saveCompany(
      TerminationReason terminationReason, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (terminationReason.getCompany() == null) {
      return terminationReason; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(terminationReason.getCompany(), options);
    return terminationReason;
  }

  public TerminationReason planToRemoveTerminationList(
      TerminationReason terminationReason, String terminationIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Termination.REASON_PROPERTY, terminationReason.getId());
    key.put(Termination.ID_PROPERTY, terminationIds);

    SmartList<Termination> externalTerminationList =
        getTerminationDAO().findTerminationWithKey(key, options);
    if (externalTerminationList == null) {
      return terminationReason;
    }
    if (externalTerminationList.isEmpty()) {
      return terminationReason;
    }

    for (Termination terminationItem : externalTerminationList) {

      terminationItem.clearFromAll();
    }

    SmartList<Termination> terminationList = terminationReason.getTerminationList();
    terminationList.addAllToRemoveList(externalTerminationList);
    return terminationReason;
  }

  // disconnect TerminationReason with type in Termination
  public TerminationReason planToRemoveTerminationListWithType(
      TerminationReason terminationReason, String typeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Termination.REASON_PROPERTY, terminationReason.getId());
    key.put(Termination.TYPE_PROPERTY, typeId);

    SmartList<Termination> externalTerminationList =
        getTerminationDAO().findTerminationWithKey(key, options);
    if (externalTerminationList == null) {
      return terminationReason;
    }
    if (externalTerminationList.isEmpty()) {
      return terminationReason;
    }

    for (Termination terminationItem : externalTerminationList) {
      terminationItem.clearType();
      terminationItem.clearReason();
    }

    SmartList<Termination> terminationList = terminationReason.getTerminationList();
    terminationList.addAllToRemoveList(externalTerminationList);
    return terminationReason;
  }

  public int countTerminationListWithType(
      String terminationReasonId, String typeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Termination.REASON_PROPERTY, terminationReasonId);
    key.put(Termination.TYPE_PROPERTY, typeId);

    int count = getTerminationDAO().countTerminationWithKey(key, options);
    return count;
  }

  protected TerminationReason saveTerminationList(
      TerminationReason terminationReason, Map<String, Object> options) {

    SmartList<Termination> terminationList = terminationReason.getTerminationList();
    if (terminationList == null) {
      // null list means nothing
      return terminationReason;
    }
    SmartList<Termination> mergedUpdateTerminationList = new SmartList<Termination>();

    mergedUpdateTerminationList.addAll(terminationList);
    if (terminationList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateTerminationList.addAll(terminationList.getToRemoveList());
      terminationList.removeAll(terminationList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getTerminationDAO().saveTerminationList(mergedUpdateTerminationList, options);

    if (terminationList.getToRemoveList() != null) {
      terminationList.removeAll(terminationList.getToRemoveList());
    }

    return terminationReason;
  }

  protected TerminationReason removeTerminationList(
      TerminationReason terminationReason, Map<String, Object> options) {

    SmartList<Termination> terminationList = terminationReason.getTerminationList();
    if (terminationList == null) {
      return terminationReason;
    }

    SmartList<Termination> toRemoveTerminationList = terminationList.getToRemoveList();

    if (toRemoveTerminationList == null) {
      return terminationReason;
    }
    if (toRemoveTerminationList.isEmpty()) {
      return terminationReason; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getTerminationDAO().removeTerminationList(toRemoveTerminationList, options);

    return terminationReason;
  }

  public TerminationReason present(
      TerminationReason terminationReason, Map<String, Object> options) {

    presentTerminationList(terminationReason, options);

    return terminationReason;
  }

  // Using java8 feature to reduce the code significantly
  protected TerminationReason presentTerminationList(
      TerminationReason terminationReason, Map<String, Object> options) {

    SmartList<Termination> terminationList = terminationReason.getTerminationList();
    SmartList<Termination> newList =
        presentSubList(
            terminationReason.getId(),
            terminationList,
            options,
            getTerminationDAO()::countTerminationByReason,
            getTerminationDAO()::findTerminationByReason);

    terminationReason.setTerminationList(newList);

    return terminationReason;
  }

  public SmartList<TerminationReason> requestCandidateTerminationReasonForTermination(
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
        TerminationReasonTable.COLUMN_CODE,
        TerminationReasonTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getTerminationReasonMapper());
  }

  protected String getTableName() {
    return TerminationReasonTable.TABLE_NAME;
  }

  public void enhanceList(List<TerminationReason> terminationReasonList) {
    this.enhanceListInternal(terminationReasonList, this.getTerminationReasonMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<TerminationReason> terminationReasonList =
        ownerEntity.collectRefsWithType(TerminationReason.INTERNAL_TYPE);
    this.enhanceList(terminationReasonList);
  }

  @Override
  public SmartList<TerminationReason> findTerminationReasonWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getTerminationReasonMapper());
  }

  @Override
  public int countTerminationReasonWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countTerminationReasonWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<TerminationReason> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getTerminationReasonMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<TerminationReason> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTerminationReasonMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateTerminationReason executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateTerminationReason result = new CandidateTerminationReason();
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
  public List<TerminationReason> search(TerminationReasonRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected TerminationReasonMapper mapper() {
    return getTerminationReasonMapper();
  }

  @Override
  protected TerminationReasonMapper mapperForClazz(Class<?> clazz) {
    return TerminationReasonMapper.mapperForClass(clazz);
  }
}
