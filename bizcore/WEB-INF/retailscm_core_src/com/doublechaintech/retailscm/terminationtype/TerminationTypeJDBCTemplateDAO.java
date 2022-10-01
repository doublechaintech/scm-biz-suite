package com.doublechaintech.retailscm.terminationtype;

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

public class TerminationTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements TerminationTypeDAO {

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
  protected TerminationType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalTerminationType(accessKey, options);
  }
  */

  public SmartList<TerminationType> loadAll() {
    return this.loadAll(getTerminationTypeMapper());
  }

  public Stream<TerminationType> loadAllAsStream() {
    return this.loadAllAsStream(getTerminationTypeMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public TerminationType load(String id, Map<String, Object> options) throws Exception {
    return loadInternalTerminationType(TerminationTypeTable.withId(id), options);
  }

  public TerminationType save(TerminationType terminationType, Map<String, Object> options) {

    String methodName = "save(TerminationType terminationType,Map<String,Object> options)";

    assertMethodArgumentNotNull(terminationType, methodName, "terminationType");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalTerminationType(terminationType, options);
  }

  public TerminationType clone(String terminationTypeId, Map<String, Object> options)
      throws Exception {

    return clone(TerminationTypeTable.withId(terminationTypeId), options);
  }

  protected TerminationType clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String terminationTypeId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    TerminationType newTerminationType = loadInternalTerminationType(accessKey, options);
    newTerminationType.setVersion(0);

    if (isSaveTerminationListEnabled(options)) {
      for (Termination item : newTerminationType.getTerminationList()) {
        item.setVersion(0);
      }
    }

    saveInternalTerminationType(newTerminationType, options);

    return newTerminationType;
  }

  protected void throwIfHasException(String terminationTypeId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new TerminationTypeVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new TerminationTypeNotFoundException(
          "The " + this.getTableName() + "(" + terminationTypeId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public TerminationType disconnectFromAll(String terminationTypeId, int version) throws Exception {

    TerminationType terminationType =
        loadInternalTerminationType(TerminationTypeTable.withId(terminationTypeId), emptyOptions());
    terminationType.clearFromAll();
    this.saveTerminationType(terminationType);
    return terminationType;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return TerminationTypeTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "termination_type";
  }

  @Override
  protected String getBeanName() {

    return "terminationType";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return TerminationTypeTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationTypeTokens.COMPANY);
  }

  protected boolean isSaveCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, TerminationTypeTokens.COMPANY);
  }

  protected boolean isExtractTerminationListEnabled(Map<String, Object> options) {
    return checkOptions(options, TerminationTypeTokens.TERMINATION_LIST);
  }

  protected boolean isAnalyzeTerminationListEnabled(Map<String, Object> options) {
    return TerminationTypeTokens.of(options).analyzeTerminationListEnabled();
  }

  protected boolean isSaveTerminationListEnabled(Map<String, Object> options) {
    return checkOptions(options, TerminationTypeTokens.TERMINATION_LIST);
  }

  protected TerminationTypeMapper getTerminationTypeMapper() {
    return new TerminationTypeMapper();
  }

  protected TerminationType extractTerminationType(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      TerminationType terminationType = loadSingleObject(accessKey, getTerminationTypeMapper());
      return terminationType;
    } catch (EmptyResultDataAccessException e) {
      throw new TerminationTypeNotFoundException(
          "TerminationType(" + accessKey + ") is not found!");
    }
  }

  protected TerminationType loadInternalTerminationType(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    TerminationType terminationType = extractTerminationType(accessKey, loadOptions);

    if (isExtractCompanyEnabled(loadOptions)) {
      extractCompany(terminationType, loadOptions);
    }

    if (isExtractTerminationListEnabled(loadOptions)) {
      extractTerminationList(terminationType, loadOptions);
    }

    if (isAnalyzeTerminationListEnabled(loadOptions)) {
      analyzeTerminationList(terminationType, loadOptions);
    }

    return terminationType;
  }

  protected TerminationType extractCompany(
      TerminationType terminationType, Map<String, Object> options) throws Exception {

    if (terminationType.getCompany() == null) {
      return terminationType;
    }
    String companyId = terminationType.getCompany().getId();
    if (companyId == null) {
      return terminationType;
    }
    RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId, options);
    if (company != null) {
      terminationType.setCompany(company);
    }

    return terminationType;
  }

  protected void enhanceTerminationList(
      SmartList<Termination> terminationList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected TerminationType extractTerminationList(
      TerminationType terminationType, Map<String, Object> options) {

    if (terminationType == null) {
      return null;
    }
    if (terminationType.getId() == null) {
      return terminationType;
    }

    SmartList<Termination> terminationList =
        getTerminationDAO().findTerminationByType(terminationType.getId(), options);
    if (terminationList != null) {
      enhanceTerminationList(terminationList, options);
      terminationType.setTerminationList(terminationList);
    }

    return terminationType;
  }

  protected TerminationType analyzeTerminationList(
      TerminationType terminationType, Map<String, Object> options) {

    if (terminationType == null) {
      return null;
    }
    if (terminationType.getId() == null) {
      return terminationType;
    }

    SmartList<Termination> terminationList = terminationType.getTerminationList();
    if (terminationList != null) {
      getTerminationDAO()
          .analyzeTerminationByType(terminationList, terminationType.getId(), options);
    }

    return terminationType;
  }

  public SmartList<TerminationType> findTerminationTypeByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<TerminationType> resultList =
        queryWith(
            TerminationTypeTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getTerminationTypeMapper());
    // analyzeTerminationTypeByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<TerminationType> findTerminationTypeByCompany(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<TerminationType> resultList =
        queryWithRange(
            TerminationTypeTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getTerminationTypeMapper(),
            start,
            count);
    // analyzeTerminationTypeByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzeTerminationTypeByCompany(
      SmartList<TerminationType> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countTerminationTypeByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(TerminationTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countTerminationTypeByCompanyIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(TerminationTypeTable.COLUMN_COMPANY, ids, options);
  }

  protected TerminationType saveTerminationType(TerminationType terminationType) {

    if (!terminationType.isChanged()) {
      return terminationType;
    }

    Beans.dbUtil().cacheCleanUp(terminationType);
    String SQL = this.getSaveTerminationTypeSQL(terminationType);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveTerminationTypeParameters(terminationType);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    terminationType.incVersion();
    terminationType.afterSave();
    return terminationType;
  }

  public SmartList<TerminationType> saveTerminationTypeList(
      SmartList<TerminationType> terminationTypeList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitTerminationTypeList(terminationTypeList);

    batchTerminationTypeCreate((List<TerminationType>) lists[CREATE_LIST_INDEX]);
    batchTerminationTypeUpdate((List<TerminationType>) lists[UPDATE_LIST_INDEX]);
    batchTerminationTypeRemove((List<TerminationType>) lists[REMOVE_LIST_INDEX]);
    batchTerminationTypeRecover((List<TerminationType>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (TerminationType terminationType : terminationTypeList) {
      if (terminationType.isChanged()) {
        terminationType.incVersion();
        terminationType.afterSave();
      }
      if (terminationType.isToRecover() || terminationType.isToRemove()) {
        terminationType.setVersion(-terminationType.getVersion());
      }
    }

    return terminationTypeList;
  }

  public SmartList<TerminationType> removeTerminationTypeList(
      SmartList<TerminationType> terminationTypeList, Map<String, Object> options) {

    super.removeList(terminationTypeList, options);

    return terminationTypeList;
  }

  protected List<Object[]> prepareTerminationTypeBatchCreateArgs(
      List<TerminationType> terminationTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationType terminationType : terminationTypeList) {
      Object[] parameters = prepareTerminationTypeCreateParameters(terminationType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationTypeBatchUpdateArgs(
      List<TerminationType> terminationTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationType terminationType : terminationTypeList) {
      if (!terminationType.isChanged()) {
        continue;
      }
      Object[] parameters = prepareTerminationTypeUpdateParameters(terminationType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationTypeBatchRecoverArgs(
      List<TerminationType> terminationTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationType terminationType : terminationTypeList) {
      if (!terminationType.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(terminationType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareTerminationTypeBatchRemoveArgs(
      List<TerminationType> terminationTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (TerminationType terminationType : terminationTypeList) {
      if (!terminationType.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareTerminationTypeRemoveParameters(terminationType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchTerminationTypeCreate(List<TerminationType> terminationTypeList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareTerminationTypeBatchCreateArgs(terminationTypeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchTerminationTypeUpdate(List<TerminationType> terminationTypeList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareTerminationTypeBatchUpdateArgs(terminationTypeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchTerminationTypeRemove(List<TerminationType> terminationTypeList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareTerminationTypeBatchRemoveArgs(terminationTypeList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchTerminationTypeRecover(List<TerminationType> terminationTypeList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareTerminationTypeBatchRecoverArgs(terminationTypeList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitTerminationTypeList(List<TerminationType> terminationTypeList) {

    List<TerminationType> terminationTypeCreateList = new ArrayList<TerminationType>();
    List<TerminationType> terminationTypeUpdateList = new ArrayList<TerminationType>();
    List<TerminationType> terminationTypeRemoveList = new ArrayList<TerminationType>();
    List<TerminationType> terminationTypeRecoverList = new ArrayList<TerminationType>();

    for (TerminationType terminationType : terminationTypeList) {
      if (terminationType.isToRemove()) {
        terminationTypeRemoveList.add(terminationType);
        continue;
      }
      if (terminationType.isToRecover()) {
        terminationTypeRecoverList.add(terminationType);
        continue;
      }
      if (isUpdateRequest(terminationType)) {
        if (terminationType.isChanged()) {
          terminationTypeUpdateList.add(terminationType);
        }
        continue;
      }

      if (terminationType.isChanged()) {
        terminationTypeCreateList.add(terminationType);
      }
    }

    return new Object[] {
      terminationTypeCreateList,
      terminationTypeUpdateList,
      terminationTypeRemoveList,
      terminationTypeRecoverList
    };
  }

  protected boolean isUpdateRequest(TerminationType terminationType) {
    return terminationType.getVersion() > 0;
  }

  protected String getSaveTerminationTypeSQL(TerminationType terminationType) {
    if (terminationType.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(terminationType)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveTerminationTypeParameters(TerminationType terminationType) {
    if (terminationType.isToRemove()) {
      return prepareTerminationTypeRemoveParameters(terminationType);
    }
    if (terminationType.isToRecover()) {
      return prepareRecoverParameters(terminationType);
    }

    if (isUpdateRequest(terminationType)) {
      return prepareTerminationTypeUpdateParameters(terminationType);
    }
    return prepareTerminationTypeCreateParameters(terminationType);
  }

  protected Object[] prepareTerminationTypeRemoveParameters(TerminationType terminationType) {
    return super.prepareRemoveParameters(terminationType);
  }

  protected Object[] prepareTerminationTypeUpdateParameters(TerminationType terminationType) {
    Object[] parameters = new Object[7];

    parameters[0] = terminationType.getCode();

    if (terminationType.getCompany() != null) {
      parameters[1] = terminationType.getCompany().getId();
    }

    parameters[2] = terminationType.getBaseDescription();

    parameters[3] = terminationType.getDetailDescription();

    parameters[4] = terminationType.nextVersion();
    parameters[5] = terminationType.getId();
    parameters[6] = terminationType.getVersion();

    return parameters;
  }

  protected Object[] prepareTerminationTypeCreateParameters(TerminationType terminationType) {
    Object[] parameters = new Object[5];
    if (terminationType.getId() == null) {
      String newTerminationTypeId = getNextId();
      terminationType.setId(newTerminationTypeId);
    }
    parameters[0] = terminationType.getId();

    parameters[1] = terminationType.getCode();

    if (terminationType.getCompany() != null) {
      parameters[2] = terminationType.getCompany().getId();
    }

    parameters[3] = terminationType.getBaseDescription();

    parameters[4] = terminationType.getDetailDescription();

    return parameters;
  }

  protected TerminationType saveInternalTerminationType(
      TerminationType terminationType, Map<String, Object> options) {

    if (isSaveCompanyEnabled(options)) {
      saveCompany(terminationType, options);
    }

    saveTerminationType(terminationType);

    if (isSaveTerminationListEnabled(options)) {
      saveTerminationList(terminationType, options);
      // removeTerminationList(terminationType, options);
      // Not delete the record

    }

    return terminationType;
  }

  // ======================================================================================

  protected TerminationType saveCompany(
      TerminationType terminationType, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (terminationType.getCompany() == null) {
      return terminationType; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(terminationType.getCompany(), options);
    return terminationType;
  }

  public TerminationType planToRemoveTerminationList(
      TerminationType terminationType, String terminationIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Termination.TYPE_PROPERTY, terminationType.getId());
    key.put(Termination.ID_PROPERTY, terminationIds);

    SmartList<Termination> externalTerminationList =
        getTerminationDAO().findTerminationWithKey(key, options);
    if (externalTerminationList == null) {
      return terminationType;
    }
    if (externalTerminationList.isEmpty()) {
      return terminationType;
    }

    for (Termination terminationItem : externalTerminationList) {

      terminationItem.clearFromAll();
    }

    SmartList<Termination> terminationList = terminationType.getTerminationList();
    terminationList.addAllToRemoveList(externalTerminationList);
    return terminationType;
  }

  // disconnect TerminationType with reason in Termination
  public TerminationType planToRemoveTerminationListWithReason(
      TerminationType terminationType, String reasonId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Termination.TYPE_PROPERTY, terminationType.getId());
    key.put(Termination.REASON_PROPERTY, reasonId);

    SmartList<Termination> externalTerminationList =
        getTerminationDAO().findTerminationWithKey(key, options);
    if (externalTerminationList == null) {
      return terminationType;
    }
    if (externalTerminationList.isEmpty()) {
      return terminationType;
    }

    for (Termination terminationItem : externalTerminationList) {
      terminationItem.clearReason();
      terminationItem.clearType();
    }

    SmartList<Termination> terminationList = terminationType.getTerminationList();
    terminationList.addAllToRemoveList(externalTerminationList);
    return terminationType;
  }

  public int countTerminationListWithReason(
      String terminationTypeId, String reasonId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Termination.TYPE_PROPERTY, terminationTypeId);
    key.put(Termination.REASON_PROPERTY, reasonId);

    int count = getTerminationDAO().countTerminationWithKey(key, options);
    return count;
  }

  protected TerminationType saveTerminationList(
      TerminationType terminationType, Map<String, Object> options) {

    SmartList<Termination> terminationList = terminationType.getTerminationList();
    if (terminationList == null) {
      // null list means nothing
      return terminationType;
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

    return terminationType;
  }

  protected TerminationType removeTerminationList(
      TerminationType terminationType, Map<String, Object> options) {

    SmartList<Termination> terminationList = terminationType.getTerminationList();
    if (terminationList == null) {
      return terminationType;
    }

    SmartList<Termination> toRemoveTerminationList = terminationList.getToRemoveList();

    if (toRemoveTerminationList == null) {
      return terminationType;
    }
    if (toRemoveTerminationList.isEmpty()) {
      return terminationType; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getTerminationDAO().removeTerminationList(toRemoveTerminationList, options);

    return terminationType;
  }

  public TerminationType present(TerminationType terminationType, Map<String, Object> options) {

    presentTerminationList(terminationType, options);

    return terminationType;
  }

  // Using java8 feature to reduce the code significantly
  protected TerminationType presentTerminationList(
      TerminationType terminationType, Map<String, Object> options) {

    SmartList<Termination> terminationList = terminationType.getTerminationList();
    SmartList<Termination> newList =
        presentSubList(
            terminationType.getId(),
            terminationList,
            options,
            getTerminationDAO()::countTerminationByType,
            getTerminationDAO()::findTerminationByType);

    terminationType.setTerminationList(newList);

    return terminationType;
  }

  public SmartList<TerminationType> requestCandidateTerminationTypeForTermination(
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
        TerminationTypeTable.COLUMN_CODE,
        TerminationTypeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getTerminationTypeMapper());
  }

  protected String getTableName() {
    return TerminationTypeTable.TABLE_NAME;
  }

  public void enhanceList(List<TerminationType> terminationTypeList) {
    this.enhanceListInternal(terminationTypeList, this.getTerminationTypeMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<TerminationType> terminationTypeList =
        ownerEntity.collectRefsWithType(TerminationType.INTERNAL_TYPE);
    this.enhanceList(terminationTypeList);
  }

  @Override
  public SmartList<TerminationType> findTerminationTypeWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getTerminationTypeMapper());
  }

  @Override
  public int countTerminationTypeWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countTerminationTypeWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<TerminationType> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getTerminationTypeMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<TerminationType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTerminationTypeMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateTerminationType executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateTerminationType result = new CandidateTerminationType();
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
  public List<TerminationType> search(TerminationTypeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected TerminationTypeMapper mapper() {
    return getTerminationTypeMapper();
  }

  @Override
  protected TerminationTypeMapper mapperForClazz(Class<?> clazz) {
    return TerminationTypeMapper.mapperForClass(clazz);
  }
}
