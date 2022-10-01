package com.doublechaintech.retailscm.userallowlist;

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

import com.doublechaintech.retailscm.userdomain.UserDomain;

import com.doublechaintech.retailscm.userdomain.UserDomainDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class UserAllowListJDBCTemplateDAO extends RetailscmBaseDAOImpl implements UserAllowListDAO {

  protected UserDomainDAO userDomainDAO;

  public void setUserDomainDAO(UserDomainDAO userDomainDAO) {

    if (userDomainDAO == null) {
      throw new IllegalStateException("Do not try to set userDomainDAO to null.");
    }
    this.userDomainDAO = userDomainDAO;
  }

  public UserDomainDAO getUserDomainDAO() {
    if (this.userDomainDAO == null) {
      throw new IllegalStateException(
          "The userDomainDAO is not configured yet, please config it some where.");
    }

    return this.userDomainDAO;
  }

  /*
  protected UserAllowList load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalUserAllowList(accessKey, options);
  }
  */

  public SmartList<UserAllowList> loadAll() {
    return this.loadAll(getUserAllowListMapper());
  }

  public Stream<UserAllowList> loadAllAsStream() {
    return this.loadAllAsStream(getUserAllowListMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public UserAllowList load(String id, Map<String, Object> options) throws Exception {
    return loadInternalUserAllowList(UserAllowListTable.withId(id), options);
  }

  public UserAllowList save(UserAllowList userAllowList, Map<String, Object> options) {

    String methodName = "save(UserAllowList userAllowList,Map<String,Object> options)";

    assertMethodArgumentNotNull(userAllowList, methodName, "userAllowList");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalUserAllowList(userAllowList, options);
  }

  public UserAllowList clone(String userAllowListId, Map<String, Object> options) throws Exception {

    return clone(UserAllowListTable.withId(userAllowListId), options);
  }

  protected UserAllowList clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String userAllowListId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    UserAllowList newUserAllowList = loadInternalUserAllowList(accessKey, options);
    newUserAllowList.setVersion(0);

    saveInternalUserAllowList(newUserAllowList, options);

    return newUserAllowList;
  }

  protected void throwIfHasException(String userAllowListId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new UserAllowListVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new UserAllowListNotFoundException(
          "The " + this.getTableName() + "(" + userAllowListId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public UserAllowList disconnectFromAll(String userAllowListId, int version) throws Exception {

    UserAllowList userAllowList =
        loadInternalUserAllowList(UserAllowListTable.withId(userAllowListId), emptyOptions());
    userAllowList.clearFromAll();
    this.saveUserAllowList(userAllowList);
    return userAllowList;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return UserAllowListTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "user_allow_list";
  }

  @Override
  protected String getBeanName() {

    return "userAllowList";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return UserAllowListTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractDomainEnabled(Map<String, Object> options) {

    return checkOptions(options, UserAllowListTokens.DOMAIN);
  }

  protected boolean isSaveDomainEnabled(Map<String, Object> options) {

    return checkOptions(options, UserAllowListTokens.DOMAIN);
  }

  protected UserAllowListMapper getUserAllowListMapper() {
    return new UserAllowListMapper();
  }

  protected UserAllowList extractUserAllowList(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      UserAllowList userAllowList = loadSingleObject(accessKey, getUserAllowListMapper());
      return userAllowList;
    } catch (EmptyResultDataAccessException e) {
      throw new UserAllowListNotFoundException("UserAllowList(" + accessKey + ") is not found!");
    }
  }

  protected UserAllowList loadInternalUserAllowList(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    UserAllowList userAllowList = extractUserAllowList(accessKey, loadOptions);

    if (isExtractDomainEnabled(loadOptions)) {
      extractDomain(userAllowList, loadOptions);
    }

    return userAllowList;
  }

  protected UserAllowList extractDomain(UserAllowList userAllowList, Map<String, Object> options)
      throws Exception {

    if (userAllowList.getDomain() == null) {
      return userAllowList;
    }
    String domainId = userAllowList.getDomain().getId();
    if (domainId == null) {
      return userAllowList;
    }
    UserDomain domain = getUserDomainDAO().load(domainId, options);
    if (domain != null) {
      userAllowList.setDomain(domain);
    }

    return userAllowList;
  }

  public SmartList<UserAllowList> findUserAllowListByDomain(
      String userDomainId, Map<String, Object> options) {

    SmartList<UserAllowList> resultList =
        queryWith(
            UserAllowListTable.COLUMN_DOMAIN, userDomainId, options, getUserAllowListMapper());
    // analyzeUserAllowListByDomain(resultList, userDomainId, options);
    return resultList;
  }

  public SmartList<UserAllowList> findUserAllowListByDomain(
      String userDomainId, int start, int count, Map<String, Object> options) {

    SmartList<UserAllowList> resultList =
        queryWithRange(
            UserAllowListTable.COLUMN_DOMAIN,
            userDomainId,
            options,
            getUserAllowListMapper(),
            start,
            count);
    // analyzeUserAllowListByDomain(resultList, userDomainId, options);
    return resultList;
  }

  public void analyzeUserAllowListByDomain(
      SmartList<UserAllowList> resultList, String userDomainId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countUserAllowListByDomain(String userDomainId, Map<String, Object> options) {

    return countWith(UserAllowListTable.COLUMN_DOMAIN, userDomainId, options);
  }

  @Override
  public Map<String, Integer> countUserAllowListByDomainIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(UserAllowListTable.COLUMN_DOMAIN, ids, options);
  }

  protected UserAllowList saveUserAllowList(UserAllowList userAllowList) {

    if (!userAllowList.isChanged()) {
      return userAllowList;
    }

    Beans.dbUtil().cacheCleanUp(userAllowList);
    String SQL = this.getSaveUserAllowListSQL(userAllowList);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveUserAllowListParameters(userAllowList);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    userAllowList.incVersion();
    userAllowList.afterSave();
    return userAllowList;
  }

  public SmartList<UserAllowList> saveUserAllowListList(
      SmartList<UserAllowList> userAllowListList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitUserAllowListList(userAllowListList);

    batchUserAllowListCreate((List<UserAllowList>) lists[CREATE_LIST_INDEX]);
    batchUserAllowListUpdate((List<UserAllowList>) lists[UPDATE_LIST_INDEX]);
    batchUserAllowListRemove((List<UserAllowList>) lists[REMOVE_LIST_INDEX]);
    batchUserAllowListRecover((List<UserAllowList>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (UserAllowList userAllowList : userAllowListList) {
      if (userAllowList.isChanged()) {
        userAllowList.incVersion();
        userAllowList.afterSave();
      }
      if (userAllowList.isToRecover() || userAllowList.isToRemove()) {
        userAllowList.setVersion(-userAllowList.getVersion());
      }
    }

    return userAllowListList;
  }

  public SmartList<UserAllowList> removeUserAllowListList(
      SmartList<UserAllowList> userAllowListList, Map<String, Object> options) {

    super.removeList(userAllowListList, options);

    return userAllowListList;
  }

  protected List<Object[]> prepareUserAllowListBatchCreateArgs(
      List<UserAllowList> userAllowListList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UserAllowList userAllowList : userAllowListList) {
      Object[] parameters = prepareUserAllowListCreateParameters(userAllowList);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareUserAllowListBatchUpdateArgs(
      List<UserAllowList> userAllowListList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UserAllowList userAllowList : userAllowListList) {
      if (!userAllowList.isChanged()) {
        continue;
      }
      Object[] parameters = prepareUserAllowListUpdateParameters(userAllowList);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareUserAllowListBatchRecoverArgs(
      List<UserAllowList> userAllowListList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UserAllowList userAllowList : userAllowListList) {
      if (!userAllowList.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(userAllowList);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareUserAllowListBatchRemoveArgs(
      List<UserAllowList> userAllowListList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (UserAllowList userAllowList : userAllowListList) {
      if (!userAllowList.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareUserAllowListRemoveParameters(userAllowList);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchUserAllowListCreate(List<UserAllowList> userAllowListList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareUserAllowListBatchCreateArgs(userAllowListList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchUserAllowListUpdate(List<UserAllowList> userAllowListList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareUserAllowListBatchUpdateArgs(userAllowListList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchUserAllowListRemove(List<UserAllowList> userAllowListList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareUserAllowListBatchRemoveArgs(userAllowListList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchUserAllowListRecover(List<UserAllowList> userAllowListList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareUserAllowListBatchRecoverArgs(userAllowListList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitUserAllowListList(List<UserAllowList> userAllowListList) {

    List<UserAllowList> userAllowListCreateList = new ArrayList<UserAllowList>();
    List<UserAllowList> userAllowListUpdateList = new ArrayList<UserAllowList>();
    List<UserAllowList> userAllowListRemoveList = new ArrayList<UserAllowList>();
    List<UserAllowList> userAllowListRecoverList = new ArrayList<UserAllowList>();

    for (UserAllowList userAllowList : userAllowListList) {
      if (userAllowList.isToRemove()) {
        userAllowListRemoveList.add(userAllowList);
        continue;
      }
      if (userAllowList.isToRecover()) {
        userAllowListRecoverList.add(userAllowList);
        continue;
      }
      if (isUpdateRequest(userAllowList)) {
        if (userAllowList.isChanged()) {
          userAllowListUpdateList.add(userAllowList);
        }
        continue;
      }

      if (userAllowList.isChanged()) {
        userAllowListCreateList.add(userAllowList);
      }
    }

    return new Object[] {
      userAllowListCreateList,
      userAllowListUpdateList,
      userAllowListRemoveList,
      userAllowListRecoverList
    };
  }

  protected boolean isUpdateRequest(UserAllowList userAllowList) {
    return userAllowList.getVersion() > 0;
  }

  protected String getSaveUserAllowListSQL(UserAllowList userAllowList) {
    if (userAllowList.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(userAllowList)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveUserAllowListParameters(UserAllowList userAllowList) {
    if (userAllowList.isToRemove()) {
      return prepareUserAllowListRemoveParameters(userAllowList);
    }
    if (userAllowList.isToRecover()) {
      return prepareRecoverParameters(userAllowList);
    }

    if (isUpdateRequest(userAllowList)) {
      return prepareUserAllowListUpdateParameters(userAllowList);
    }
    return prepareUserAllowListCreateParameters(userAllowList);
  }

  protected Object[] prepareUserAllowListRemoveParameters(UserAllowList userAllowList) {
    return super.prepareRemoveParameters(userAllowList);
  }

  protected Object[] prepareUserAllowListUpdateParameters(UserAllowList userAllowList) {
    Object[] parameters = new Object[6];

    parameters[0] = userAllowList.getUserIdentity();

    parameters[1] = userAllowList.getUserSpecialFunctions();

    if (userAllowList.getDomain() != null) {
      parameters[2] = userAllowList.getDomain().getId();
    }

    parameters[3] = userAllowList.nextVersion();
    parameters[4] = userAllowList.getId();
    parameters[5] = userAllowList.getVersion();

    return parameters;
  }

  protected Object[] prepareUserAllowListCreateParameters(UserAllowList userAllowList) {
    Object[] parameters = new Object[4];
    if (userAllowList.getId() == null) {
      String newUserAllowListId = getNextId();
      userAllowList.setId(newUserAllowListId);
    }
    parameters[0] = userAllowList.getId();

    parameters[1] = userAllowList.getUserIdentity();

    parameters[2] = userAllowList.getUserSpecialFunctions();

    if (userAllowList.getDomain() != null) {
      parameters[3] = userAllowList.getDomain().getId();
    }

    return parameters;
  }

  protected UserAllowList saveInternalUserAllowList(
      UserAllowList userAllowList, Map<String, Object> options) {

    if (isSaveDomainEnabled(options)) {
      saveDomain(userAllowList, options);
    }

    saveUserAllowList(userAllowList);

    return userAllowList;
  }

  // ======================================================================================

  protected UserAllowList saveDomain(UserAllowList userAllowList, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (userAllowList.getDomain() == null) {
      return userAllowList; // do nothing when it is null
    }

    getUserDomainDAO().save(userAllowList.getDomain(), options);
    return userAllowList;
  }

  public UserAllowList present(UserAllowList userAllowList, Map<String, Object> options) {

    return userAllowList;
  }

  protected String getTableName() {
    return UserAllowListTable.TABLE_NAME;
  }

  public void enhanceList(List<UserAllowList> userAllowListList) {
    this.enhanceListInternal(userAllowListList, this.getUserAllowListMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<UserAllowList> userAllowListList =
        ownerEntity.collectRefsWithType(UserAllowList.INTERNAL_TYPE);
    this.enhanceList(userAllowListList);
  }

  @Override
  public SmartList<UserAllowList> findUserAllowListWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getUserAllowListMapper());
  }

  @Override
  public int countUserAllowListWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countUserAllowListWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<UserAllowList> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getUserAllowListMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<UserAllowList> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getUserAllowListMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateUserAllowList executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateUserAllowList result = new CandidateUserAllowList();
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
  public List<UserAllowList> search(UserAllowListRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected UserAllowListMapper mapper() {
    return getUserAllowListMapper();
  }

  @Override
  protected UserAllowListMapper mapperForClazz(Class<?> clazz) {
    return UserAllowListMapper.mapperForClass(clazz);
  }
}
