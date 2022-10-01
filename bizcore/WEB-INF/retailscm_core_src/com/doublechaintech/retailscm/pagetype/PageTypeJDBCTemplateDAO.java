package com.doublechaintech.retailscm.pagetype;

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

import com.doublechaintech.retailscm.mobileapp.MobileApp;

import com.doublechaintech.retailscm.mobileapp.MobileAppDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PageTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PageTypeDAO {

  protected MobileAppDAO mobileAppDAO;

  public void setMobileAppDAO(MobileAppDAO mobileAppDAO) {

    if (mobileAppDAO == null) {
      throw new IllegalStateException("Do not try to set mobileAppDAO to null.");
    }
    this.mobileAppDAO = mobileAppDAO;
  }

  public MobileAppDAO getMobileAppDAO() {
    if (this.mobileAppDAO == null) {
      throw new IllegalStateException(
          "The mobileAppDAO is not configured yet, please config it some where.");
    }

    return this.mobileAppDAO;
  }

  /*
  protected PageType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalPageType(accessKey, options);
  }
  */

  public SmartList<PageType> loadAll() {
    return this.loadAll(getPageTypeMapper());
  }

  public Stream<PageType> loadAllAsStream() {
    return this.loadAllAsStream(getPageTypeMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public PageType load(String id, Map<String, Object> options) throws Exception {
    return loadInternalPageType(PageTypeTable.withId(id), options);
  }

  public PageType loadByCode(String code, Map<String, Object> options) throws Exception {
    return loadInternalPageType(PageTypeTable.withCode(code), options);
  }

  public PageType save(PageType pageType, Map<String, Object> options) {

    String methodName = "save(PageType pageType,Map<String,Object> options)";

    assertMethodArgumentNotNull(pageType, methodName, "pageType");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalPageType(pageType, options);
  }

  public PageType clone(String pageTypeId, Map<String, Object> options) throws Exception {

    return clone(PageTypeTable.withId(pageTypeId), options);
  }

  protected PageType clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String pageTypeId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    PageType newPageType = loadInternalPageType(accessKey, options);
    newPageType.setVersion(0);

    saveInternalPageType(newPageType, options);

    return newPageType;
  }

  public PageType cloneByCode(String code, Map<String, Object> options) throws Exception {
    return clone(PageTypeTable.withCode(code), options);
  }

  protected void throwIfHasException(String pageTypeId, int version, int count) throws Exception {
    if (count == 1) {
      throw new PageTypeVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new PageTypeNotFoundException(
          "The " + this.getTableName() + "(" + pageTypeId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public PageType disconnectFromAll(String pageTypeId, int version) throws Exception {

    PageType pageType = loadInternalPageType(PageTypeTable.withId(pageTypeId), emptyOptions());
    pageType.clearFromAll();
    this.savePageType(pageType);
    return pageType;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return PageTypeTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "page_type";
  }

  @Override
  protected String getBeanName() {

    return "pageType";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return PageTypeTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractMobileAppEnabled(Map<String, Object> options) {

    return checkOptions(options, PageTypeTokens.MOBILEAPP);
  }

  protected boolean isSaveMobileAppEnabled(Map<String, Object> options) {

    return checkOptions(options, PageTypeTokens.MOBILEAPP);
  }

  protected PageTypeMapper getPageTypeMapper() {
    return new PageTypeMapper();
  }

  protected PageType extractPageType(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      PageType pageType = loadSingleObject(accessKey, getPageTypeMapper());
      return pageType;
    } catch (EmptyResultDataAccessException e) {
      throw new PageTypeNotFoundException("PageType(" + accessKey + ") is not found!");
    }
  }

  protected PageType loadInternalPageType(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    PageType pageType = extractPageType(accessKey, loadOptions);

    if (isExtractMobileAppEnabled(loadOptions)) {
      extractMobileApp(pageType, loadOptions);
    }

    return pageType;
  }

  protected PageType extractMobileApp(PageType pageType, Map<String, Object> options)
      throws Exception {

    if (pageType.getMobileApp() == null) {
      return pageType;
    }
    String mobileAppId = pageType.getMobileApp().getId();
    if (mobileAppId == null) {
      return pageType;
    }
    MobileApp mobileApp = getMobileAppDAO().load(mobileAppId, options);
    if (mobileApp != null) {
      pageType.setMobileApp(mobileApp);
    }

    return pageType;
  }

  public SmartList<PageType> findPageTypeByMobileApp(
      String mobileAppId, Map<String, Object> options) {

    SmartList<PageType> resultList =
        queryWith(PageTypeTable.COLUMN_MOBILE_APP, mobileAppId, options, getPageTypeMapper());
    // analyzePageTypeByMobileApp(resultList, mobileAppId, options);
    return resultList;
  }

  public SmartList<PageType> findPageTypeByMobileApp(
      String mobileAppId, int start, int count, Map<String, Object> options) {

    SmartList<PageType> resultList =
        queryWithRange(
            PageTypeTable.COLUMN_MOBILE_APP,
            mobileAppId,
            options,
            getPageTypeMapper(),
            start,
            count);
    // analyzePageTypeByMobileApp(resultList, mobileAppId, options);
    return resultList;
  }

  public void analyzePageTypeByMobileApp(
      SmartList<PageType> resultList, String mobileAppId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countPageTypeByMobileApp(String mobileAppId, Map<String, Object> options) {

    return countWith(PageTypeTable.COLUMN_MOBILE_APP, mobileAppId, options);
  }

  @Override
  public Map<String, Integer> countPageTypeByMobileAppIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(PageTypeTable.COLUMN_MOBILE_APP, ids, options);
  }

  protected PageType savePageType(PageType pageType) {

    if (!pageType.isChanged()) {
      return pageType;
    }

    Beans.dbUtil().cacheCleanUp(pageType);
    String SQL = this.getSavePageTypeSQL(pageType);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSavePageTypeParameters(pageType);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    pageType.incVersion();
    pageType.afterSave();
    return pageType;
  }

  public SmartList<PageType> savePageTypeList(
      SmartList<PageType> pageTypeList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitPageTypeList(pageTypeList);

    batchPageTypeCreate((List<PageType>) lists[CREATE_LIST_INDEX]);
    batchPageTypeUpdate((List<PageType>) lists[UPDATE_LIST_INDEX]);
    batchPageTypeRemove((List<PageType>) lists[REMOVE_LIST_INDEX]);
    batchPageTypeRecover((List<PageType>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (PageType pageType : pageTypeList) {
      if (pageType.isChanged()) {
        pageType.incVersion();
        pageType.afterSave();
      }
      if (pageType.isToRecover() || pageType.isToRemove()) {
        pageType.setVersion(-pageType.getVersion());
      }
    }

    return pageTypeList;
  }

  public SmartList<PageType> removePageTypeList(
      SmartList<PageType> pageTypeList, Map<String, Object> options) {

    super.removeList(pageTypeList, options);

    return pageTypeList;
  }

  protected List<Object[]> preparePageTypeBatchCreateArgs(List<PageType> pageTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PageType pageType : pageTypeList) {
      Object[] parameters = preparePageTypeCreateParameters(pageType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePageTypeBatchUpdateArgs(List<PageType> pageTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PageType pageType : pageTypeList) {
      if (!pageType.isChanged()) {
        continue;
      }
      Object[] parameters = preparePageTypeUpdateParameters(pageType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePageTypeBatchRecoverArgs(List<PageType> pageTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PageType pageType : pageTypeList) {
      if (!pageType.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(pageType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePageTypeBatchRemoveArgs(List<PageType> pageTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PageType pageType : pageTypeList) {
      if (!pageType.isToRemove()) {
        continue;
      }
      Object[] parameters = preparePageTypeRemoveParameters(pageType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchPageTypeCreate(List<PageType> pageTypeList) {
    String SQL = getCreateSQL();
    List<Object[]> args = preparePageTypeBatchCreateArgs(pageTypeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchPageTypeUpdate(List<PageType> pageTypeList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = preparePageTypeBatchUpdateArgs(pageTypeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPageTypeRemove(List<PageType> pageTypeList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = preparePageTypeBatchRemoveArgs(pageTypeList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPageTypeRecover(List<PageType> pageTypeList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = preparePageTypeBatchRecoverArgs(pageTypeList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitPageTypeList(List<PageType> pageTypeList) {

    List<PageType> pageTypeCreateList = new ArrayList<PageType>();
    List<PageType> pageTypeUpdateList = new ArrayList<PageType>();
    List<PageType> pageTypeRemoveList = new ArrayList<PageType>();
    List<PageType> pageTypeRecoverList = new ArrayList<PageType>();

    for (PageType pageType : pageTypeList) {
      if (pageType.isToRemove()) {
        pageTypeRemoveList.add(pageType);
        continue;
      }
      if (pageType.isToRecover()) {
        pageTypeRecoverList.add(pageType);
        continue;
      }
      if (isUpdateRequest(pageType)) {
        if (pageType.isChanged()) {
          pageTypeUpdateList.add(pageType);
        }
        continue;
      }

      if (pageType.isChanged()) {
        pageTypeCreateList.add(pageType);
      }
    }

    return new Object[] {
      pageTypeCreateList, pageTypeUpdateList, pageTypeRemoveList, pageTypeRecoverList
    };
  }

  protected boolean isUpdateRequest(PageType pageType) {
    return pageType.getVersion() > 0;
  }

  protected String getSavePageTypeSQL(PageType pageType) {
    if (pageType.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(pageType)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSavePageTypeParameters(PageType pageType) {
    if (pageType.isToRemove()) {
      return preparePageTypeRemoveParameters(pageType);
    }
    if (pageType.isToRecover()) {
      return prepareRecoverParameters(pageType);
    }

    if (isUpdateRequest(pageType)) {
      return preparePageTypeUpdateParameters(pageType);
    }
    return preparePageTypeCreateParameters(pageType);
  }

  protected Object[] preparePageTypeRemoveParameters(PageType pageType) {
    return super.prepareRemoveParameters(pageType);
  }

  protected Object[] preparePageTypeUpdateParameters(PageType pageType) {
    Object[] parameters = new Object[7];

    parameters[0] = pageType.getName();

    parameters[1] = pageType.getCode();

    if (pageType.getMobileApp() != null) {
      parameters[2] = pageType.getMobileApp().getId();
    }

    parameters[3] = pageType.getFooterTab();

    parameters[4] = pageType.nextVersion();
    parameters[5] = pageType.getId();
    parameters[6] = pageType.getVersion();

    return parameters;
  }

  protected Object[] preparePageTypeCreateParameters(PageType pageType) {
    Object[] parameters = new Object[5];
    if (pageType.getId() == null) {
      String newPageTypeId = getNextId();
      pageType.setId(newPageTypeId);
    }
    parameters[0] = pageType.getId();

    parameters[1] = pageType.getName();

    parameters[2] = pageType.getCode();

    if (pageType.getMobileApp() != null) {
      parameters[3] = pageType.getMobileApp().getId();
    }

    parameters[4] = pageType.getFooterTab();

    return parameters;
  }

  protected PageType saveInternalPageType(PageType pageType, Map<String, Object> options) {

    if (isSaveMobileAppEnabled(options)) {
      saveMobileApp(pageType, options);
    }

    savePageType(pageType);

    return pageType;
  }

  // ======================================================================================

  protected PageType saveMobileApp(PageType pageType, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (pageType.getMobileApp() == null) {
      return pageType; // do nothing when it is null
    }

    getMobileAppDAO().save(pageType.getMobileApp(), options);
    return pageType;
  }

  public PageType present(PageType pageType, Map<String, Object> options) {

    return pageType;
  }

  public SmartList<PageType> requestCandidatePageTypeForPage(
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
        PageTypeTable.COLUMN_NAME,
        PageTypeTable.COLUMN_MOBILE_APP,
        filterKey,
        pageNo,
        pageSize,
        getPageTypeMapper());
  }

  protected String getTableName() {
    return PageTypeTable.TABLE_NAME;
  }

  public void enhanceList(List<PageType> pageTypeList) {
    this.enhanceListInternal(pageTypeList, this.getPageTypeMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<PageType> pageTypeList = ownerEntity.collectRefsWithType(PageType.INTERNAL_TYPE);
    this.enhanceList(pageTypeList);
  }

  @Override
  public SmartList<PageType> findPageTypeWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getPageTypeMapper());
  }

  @Override
  public int countPageTypeWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countPageTypeWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<PageType> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getPageTypeMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<PageType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPageTypeMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidatePageType executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidatePageType result = new CandidatePageType();
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
  public List<PageType> search(PageTypeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected PageTypeMapper mapper() {
    return getPageTypeMapper();
  }

  @Override
  protected PageTypeMapper mapperForClazz(Class<?> clazz) {
    return PageTypeMapper.mapperForClass(clazz);
  }
}
