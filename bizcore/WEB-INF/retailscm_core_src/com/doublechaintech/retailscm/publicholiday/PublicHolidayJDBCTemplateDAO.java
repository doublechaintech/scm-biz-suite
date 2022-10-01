package com.doublechaintech.retailscm.publicholiday;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PublicHolidayJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PublicHolidayDAO {

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

  /*
  protected PublicHoliday load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalPublicHoliday(accessKey, options);
  }
  */

  public SmartList<PublicHoliday> loadAll() {
    return this.loadAll(getPublicHolidayMapper());
  }

  public Stream<PublicHoliday> loadAllAsStream() {
    return this.loadAllAsStream(getPublicHolidayMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public PublicHoliday load(String id, Map<String, Object> options) throws Exception {
    return loadInternalPublicHoliday(PublicHolidayTable.withId(id), options);
  }

  public PublicHoliday save(PublicHoliday publicHoliday, Map<String, Object> options) {

    String methodName = "save(PublicHoliday publicHoliday,Map<String,Object> options)";

    assertMethodArgumentNotNull(publicHoliday, methodName, "publicHoliday");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalPublicHoliday(publicHoliday, options);
  }

  public PublicHoliday clone(String publicHolidayId, Map<String, Object> options) throws Exception {

    return clone(PublicHolidayTable.withId(publicHolidayId), options);
  }

  protected PublicHoliday clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String publicHolidayId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    PublicHoliday newPublicHoliday = loadInternalPublicHoliday(accessKey, options);
    newPublicHoliday.setVersion(0);

    saveInternalPublicHoliday(newPublicHoliday, options);

    return newPublicHoliday;
  }

  protected void throwIfHasException(String publicHolidayId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new PublicHolidayVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new PublicHolidayNotFoundException(
          "The " + this.getTableName() + "(" + publicHolidayId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public PublicHoliday disconnectFromAll(String publicHolidayId, int version) throws Exception {

    PublicHoliday publicHoliday =
        loadInternalPublicHoliday(PublicHolidayTable.withId(publicHolidayId), emptyOptions());
    publicHoliday.clearFromAll();
    this.savePublicHoliday(publicHoliday);
    return publicHoliday;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return PublicHolidayTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "public_holiday";
  }

  @Override
  protected String getBeanName() {

    return "publicHoliday";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return PublicHolidayTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, PublicHolidayTokens.COMPANY);
  }

  protected boolean isSaveCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, PublicHolidayTokens.COMPANY);
  }

  protected PublicHolidayMapper getPublicHolidayMapper() {
    return new PublicHolidayMapper();
  }

  protected PublicHoliday extractPublicHoliday(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      PublicHoliday publicHoliday = loadSingleObject(accessKey, getPublicHolidayMapper());
      return publicHoliday;
    } catch (EmptyResultDataAccessException e) {
      throw new PublicHolidayNotFoundException("PublicHoliday(" + accessKey + ") is not found!");
    }
  }

  protected PublicHoliday loadInternalPublicHoliday(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    PublicHoliday publicHoliday = extractPublicHoliday(accessKey, loadOptions);

    if (isExtractCompanyEnabled(loadOptions)) {
      extractCompany(publicHoliday, loadOptions);
    }

    return publicHoliday;
  }

  protected PublicHoliday extractCompany(PublicHoliday publicHoliday, Map<String, Object> options)
      throws Exception {

    if (publicHoliday.getCompany() == null) {
      return publicHoliday;
    }
    String companyId = publicHoliday.getCompany().getId();
    if (companyId == null) {
      return publicHoliday;
    }
    RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId, options);
    if (company != null) {
      publicHoliday.setCompany(company);
    }

    return publicHoliday;
  }

  public SmartList<PublicHoliday> findPublicHolidayByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<PublicHoliday> resultList =
        queryWith(
            PublicHolidayTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getPublicHolidayMapper());
    // analyzePublicHolidayByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<PublicHoliday> findPublicHolidayByCompany(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<PublicHoliday> resultList =
        queryWithRange(
            PublicHolidayTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getPublicHolidayMapper(),
            start,
            count);
    // analyzePublicHolidayByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzePublicHolidayByCompany(
      SmartList<PublicHoliday> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countPublicHolidayByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(PublicHolidayTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countPublicHolidayByCompanyIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(PublicHolidayTable.COLUMN_COMPANY, ids, options);
  }

  protected PublicHoliday savePublicHoliday(PublicHoliday publicHoliday) {

    if (!publicHoliday.isChanged()) {
      return publicHoliday;
    }

    Beans.dbUtil().cacheCleanUp(publicHoliday);
    String SQL = this.getSavePublicHolidaySQL(publicHoliday);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSavePublicHolidayParameters(publicHoliday);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    publicHoliday.incVersion();
    publicHoliday.afterSave();
    return publicHoliday;
  }

  public SmartList<PublicHoliday> savePublicHolidayList(
      SmartList<PublicHoliday> publicHolidayList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitPublicHolidayList(publicHolidayList);

    batchPublicHolidayCreate((List<PublicHoliday>) lists[CREATE_LIST_INDEX]);
    batchPublicHolidayUpdate((List<PublicHoliday>) lists[UPDATE_LIST_INDEX]);
    batchPublicHolidayRemove((List<PublicHoliday>) lists[REMOVE_LIST_INDEX]);
    batchPublicHolidayRecover((List<PublicHoliday>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (PublicHoliday publicHoliday : publicHolidayList) {
      if (publicHoliday.isChanged()) {
        publicHoliday.incVersion();
        publicHoliday.afterSave();
      }
      if (publicHoliday.isToRecover() || publicHoliday.isToRemove()) {
        publicHoliday.setVersion(-publicHoliday.getVersion());
      }
    }

    return publicHolidayList;
  }

  public SmartList<PublicHoliday> removePublicHolidayList(
      SmartList<PublicHoliday> publicHolidayList, Map<String, Object> options) {

    super.removeList(publicHolidayList, options);

    return publicHolidayList;
  }

  protected List<Object[]> preparePublicHolidayBatchCreateArgs(
      List<PublicHoliday> publicHolidayList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicHoliday publicHoliday : publicHolidayList) {
      Object[] parameters = preparePublicHolidayCreateParameters(publicHoliday);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePublicHolidayBatchUpdateArgs(
      List<PublicHoliday> publicHolidayList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicHoliday publicHoliday : publicHolidayList) {
      if (!publicHoliday.isChanged()) {
        continue;
      }
      Object[] parameters = preparePublicHolidayUpdateParameters(publicHoliday);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePublicHolidayBatchRecoverArgs(
      List<PublicHoliday> publicHolidayList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicHoliday publicHoliday : publicHolidayList) {
      if (!publicHoliday.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(publicHoliday);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePublicHolidayBatchRemoveArgs(
      List<PublicHoliday> publicHolidayList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicHoliday publicHoliday : publicHolidayList) {
      if (!publicHoliday.isToRemove()) {
        continue;
      }
      Object[] parameters = preparePublicHolidayRemoveParameters(publicHoliday);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchPublicHolidayCreate(List<PublicHoliday> publicHolidayList) {
    String SQL = getCreateSQL();
    List<Object[]> args = preparePublicHolidayBatchCreateArgs(publicHolidayList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchPublicHolidayUpdate(List<PublicHoliday> publicHolidayList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = preparePublicHolidayBatchUpdateArgs(publicHolidayList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPublicHolidayRemove(List<PublicHoliday> publicHolidayList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = preparePublicHolidayBatchRemoveArgs(publicHolidayList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPublicHolidayRecover(List<PublicHoliday> publicHolidayList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = preparePublicHolidayBatchRecoverArgs(publicHolidayList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitPublicHolidayList(List<PublicHoliday> publicHolidayList) {

    List<PublicHoliday> publicHolidayCreateList = new ArrayList<PublicHoliday>();
    List<PublicHoliday> publicHolidayUpdateList = new ArrayList<PublicHoliday>();
    List<PublicHoliday> publicHolidayRemoveList = new ArrayList<PublicHoliday>();
    List<PublicHoliday> publicHolidayRecoverList = new ArrayList<PublicHoliday>();

    for (PublicHoliday publicHoliday : publicHolidayList) {
      if (publicHoliday.isToRemove()) {
        publicHolidayRemoveList.add(publicHoliday);
        continue;
      }
      if (publicHoliday.isToRecover()) {
        publicHolidayRecoverList.add(publicHoliday);
        continue;
      }
      if (isUpdateRequest(publicHoliday)) {
        if (publicHoliday.isChanged()) {
          publicHolidayUpdateList.add(publicHoliday);
        }
        continue;
      }

      if (publicHoliday.isChanged()) {
        publicHolidayCreateList.add(publicHoliday);
      }
    }

    return new Object[] {
      publicHolidayCreateList,
      publicHolidayUpdateList,
      publicHolidayRemoveList,
      publicHolidayRecoverList
    };
  }

  protected boolean isUpdateRequest(PublicHoliday publicHoliday) {
    return publicHoliday.getVersion() > 0;
  }

  protected String getSavePublicHolidaySQL(PublicHoliday publicHoliday) {
    if (publicHoliday.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(publicHoliday)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSavePublicHolidayParameters(PublicHoliday publicHoliday) {
    if (publicHoliday.isToRemove()) {
      return preparePublicHolidayRemoveParameters(publicHoliday);
    }
    if (publicHoliday.isToRecover()) {
      return prepareRecoverParameters(publicHoliday);
    }

    if (isUpdateRequest(publicHoliday)) {
      return preparePublicHolidayUpdateParameters(publicHoliday);
    }
    return preparePublicHolidayCreateParameters(publicHoliday);
  }

  protected Object[] preparePublicHolidayRemoveParameters(PublicHoliday publicHoliday) {
    return super.prepareRemoveParameters(publicHoliday);
  }

  protected Object[] preparePublicHolidayUpdateParameters(PublicHoliday publicHoliday) {
    Object[] parameters = new Object[7];

    parameters[0] = publicHoliday.getCode();

    if (publicHoliday.getCompany() != null) {
      parameters[1] = publicHoliday.getCompany().getId();
    }

    parameters[2] = publicHoliday.getName();

    parameters[3] = publicHoliday.getDescription();

    parameters[4] = publicHoliday.nextVersion();
    parameters[5] = publicHoliday.getId();
    parameters[6] = publicHoliday.getVersion();

    return parameters;
  }

  protected Object[] preparePublicHolidayCreateParameters(PublicHoliday publicHoliday) {
    Object[] parameters = new Object[5];
    if (publicHoliday.getId() == null) {
      String newPublicHolidayId = getNextId();
      publicHoliday.setId(newPublicHolidayId);
    }
    parameters[0] = publicHoliday.getId();

    parameters[1] = publicHoliday.getCode();

    if (publicHoliday.getCompany() != null) {
      parameters[2] = publicHoliday.getCompany().getId();
    }

    parameters[3] = publicHoliday.getName();

    parameters[4] = publicHoliday.getDescription();

    return parameters;
  }

  protected PublicHoliday saveInternalPublicHoliday(
      PublicHoliday publicHoliday, Map<String, Object> options) {

    if (isSaveCompanyEnabled(options)) {
      saveCompany(publicHoliday, options);
    }

    savePublicHoliday(publicHoliday);

    return publicHoliday;
  }

  // ======================================================================================

  protected PublicHoliday saveCompany(PublicHoliday publicHoliday, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (publicHoliday.getCompany() == null) {
      return publicHoliday; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(publicHoliday.getCompany(), options);
    return publicHoliday;
  }

  public PublicHoliday present(PublicHoliday publicHoliday, Map<String, Object> options) {

    return publicHoliday;
  }

  protected String getTableName() {
    return PublicHolidayTable.TABLE_NAME;
  }

  public void enhanceList(List<PublicHoliday> publicHolidayList) {
    this.enhanceListInternal(publicHolidayList, this.getPublicHolidayMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<PublicHoliday> publicHolidayList =
        ownerEntity.collectRefsWithType(PublicHoliday.INTERNAL_TYPE);
    this.enhanceList(publicHolidayList);
  }

  @Override
  public SmartList<PublicHoliday> findPublicHolidayWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getPublicHolidayMapper());
  }

  @Override
  public int countPublicHolidayWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countPublicHolidayWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<PublicHoliday> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getPublicHolidayMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<PublicHoliday> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPublicHolidayMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidatePublicHoliday executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidatePublicHoliday result = new CandidatePublicHoliday();
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
  public List<PublicHoliday> search(PublicHolidayRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected PublicHolidayMapper mapper() {
    return getPublicHolidayMapper();
  }

  @Override
  protected PublicHolidayMapper mapperForClazz(Class<?> clazz) {
    return PublicHolidayMapper.mapperForClass(clazz);
  }
}
