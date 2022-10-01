package com.doublechaintech.retailscm.memberrewardpoint;

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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class MemberRewardPointJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements MemberRewardPointDAO {

  protected RetailStoreMemberDAO retailStoreMemberDAO;

  public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO) {

    if (retailStoreMemberDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreMemberDAO to null.");
    }
    this.retailStoreMemberDAO = retailStoreMemberDAO;
  }

  public RetailStoreMemberDAO getRetailStoreMemberDAO() {
    if (this.retailStoreMemberDAO == null) {
      throw new IllegalStateException(
          "The retailStoreMemberDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreMemberDAO;
  }

  /*
  protected MemberRewardPoint load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalMemberRewardPoint(accessKey, options);
  }
  */

  public SmartList<MemberRewardPoint> loadAll() {
    return this.loadAll(getMemberRewardPointMapper());
  }

  public Stream<MemberRewardPoint> loadAllAsStream() {
    return this.loadAllAsStream(getMemberRewardPointMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public MemberRewardPoint load(String id, Map<String, Object> options) throws Exception {
    return loadInternalMemberRewardPoint(MemberRewardPointTable.withId(id), options);
  }

  public MemberRewardPoint save(MemberRewardPoint memberRewardPoint, Map<String, Object> options) {

    String methodName = "save(MemberRewardPoint memberRewardPoint,Map<String,Object> options)";

    assertMethodArgumentNotNull(memberRewardPoint, methodName, "memberRewardPoint");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalMemberRewardPoint(memberRewardPoint, options);
  }

  public MemberRewardPoint clone(String memberRewardPointId, Map<String, Object> options)
      throws Exception {

    return clone(MemberRewardPointTable.withId(memberRewardPointId), options);
  }

  protected MemberRewardPoint clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String memberRewardPointId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    MemberRewardPoint newMemberRewardPoint = loadInternalMemberRewardPoint(accessKey, options);
    newMemberRewardPoint.setVersion(0);

    saveInternalMemberRewardPoint(newMemberRewardPoint, options);

    return newMemberRewardPoint;
  }

  protected void throwIfHasException(String memberRewardPointId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new MemberRewardPointVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new MemberRewardPointNotFoundException(
          "The " + this.getTableName() + "(" + memberRewardPointId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public MemberRewardPoint disconnectFromAll(String memberRewardPointId, int version)
      throws Exception {

    MemberRewardPoint memberRewardPoint =
        loadInternalMemberRewardPoint(
            MemberRewardPointTable.withId(memberRewardPointId), emptyOptions());
    memberRewardPoint.clearFromAll();
    this.saveMemberRewardPoint(memberRewardPoint);
    return memberRewardPoint;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return MemberRewardPointTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "member_reward_point";
  }

  @Override
  protected String getBeanName() {

    return "memberRewardPoint";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return MemberRewardPointTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, MemberRewardPointTokens.OWNER);
  }

  protected boolean isSaveOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, MemberRewardPointTokens.OWNER);
  }

  protected MemberRewardPointMapper getMemberRewardPointMapper() {
    return new MemberRewardPointMapper();
  }

  protected MemberRewardPoint extractMemberRewardPoint(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      MemberRewardPoint memberRewardPoint =
          loadSingleObject(accessKey, getMemberRewardPointMapper());
      return memberRewardPoint;
    } catch (EmptyResultDataAccessException e) {
      throw new MemberRewardPointNotFoundException(
          "MemberRewardPoint(" + accessKey + ") is not found!");
    }
  }

  protected MemberRewardPoint loadInternalMemberRewardPoint(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    MemberRewardPoint memberRewardPoint = extractMemberRewardPoint(accessKey, loadOptions);

    if (isExtractOwnerEnabled(loadOptions)) {
      extractOwner(memberRewardPoint, loadOptions);
    }

    return memberRewardPoint;
  }

  protected MemberRewardPoint extractOwner(
      MemberRewardPoint memberRewardPoint, Map<String, Object> options) throws Exception {

    if (memberRewardPoint.getOwner() == null) {
      return memberRewardPoint;
    }
    String ownerId = memberRewardPoint.getOwner().getId();
    if (ownerId == null) {
      return memberRewardPoint;
    }
    RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId, options);
    if (owner != null) {
      memberRewardPoint.setOwner(owner);
    }

    return memberRewardPoint;
  }

  public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(
      String retailStoreMemberId, Map<String, Object> options) {

    SmartList<MemberRewardPoint> resultList =
        queryWith(
            MemberRewardPointTable.COLUMN_OWNER,
            retailStoreMemberId,
            options,
            getMemberRewardPointMapper());
    // analyzeMemberRewardPointByOwner(resultList, retailStoreMemberId, options);
    return resultList;
  }

  public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(
      String retailStoreMemberId, int start, int count, Map<String, Object> options) {

    SmartList<MemberRewardPoint> resultList =
        queryWithRange(
            MemberRewardPointTable.COLUMN_OWNER,
            retailStoreMemberId,
            options,
            getMemberRewardPointMapper(),
            start,
            count);
    // analyzeMemberRewardPointByOwner(resultList, retailStoreMemberId, options);
    return resultList;
  }

  public void analyzeMemberRewardPointByOwner(
      SmartList<MemberRewardPoint> resultList,
      String retailStoreMemberId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countMemberRewardPointByOwner(
      String retailStoreMemberId, Map<String, Object> options) {

    return countWith(MemberRewardPointTable.COLUMN_OWNER, retailStoreMemberId, options);
  }

  @Override
  public Map<String, Integer> countMemberRewardPointByOwnerIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(MemberRewardPointTable.COLUMN_OWNER, ids, options);
  }

  protected MemberRewardPoint saveMemberRewardPoint(MemberRewardPoint memberRewardPoint) {

    if (!memberRewardPoint.isChanged()) {
      return memberRewardPoint;
    }

    Beans.dbUtil().cacheCleanUp(memberRewardPoint);
    String SQL = this.getSaveMemberRewardPointSQL(memberRewardPoint);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveMemberRewardPointParameters(memberRewardPoint);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    memberRewardPoint.incVersion();
    memberRewardPoint.afterSave();
    return memberRewardPoint;
  }

  public SmartList<MemberRewardPoint> saveMemberRewardPointList(
      SmartList<MemberRewardPoint> memberRewardPointList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitMemberRewardPointList(memberRewardPointList);

    batchMemberRewardPointCreate((List<MemberRewardPoint>) lists[CREATE_LIST_INDEX]);
    batchMemberRewardPointUpdate((List<MemberRewardPoint>) lists[UPDATE_LIST_INDEX]);
    batchMemberRewardPointRemove((List<MemberRewardPoint>) lists[REMOVE_LIST_INDEX]);
    batchMemberRewardPointRecover((List<MemberRewardPoint>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (MemberRewardPoint memberRewardPoint : memberRewardPointList) {
      if (memberRewardPoint.isChanged()) {
        memberRewardPoint.incVersion();
        memberRewardPoint.afterSave();
      }
      if (memberRewardPoint.isToRecover() || memberRewardPoint.isToRemove()) {
        memberRewardPoint.setVersion(-memberRewardPoint.getVersion());
      }
    }

    return memberRewardPointList;
  }

  public SmartList<MemberRewardPoint> removeMemberRewardPointList(
      SmartList<MemberRewardPoint> memberRewardPointList, Map<String, Object> options) {

    super.removeList(memberRewardPointList, options);

    return memberRewardPointList;
  }

  protected List<Object[]> prepareMemberRewardPointBatchCreateArgs(
      List<MemberRewardPoint> memberRewardPointList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberRewardPoint memberRewardPoint : memberRewardPointList) {
      Object[] parameters = prepareMemberRewardPointCreateParameters(memberRewardPoint);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberRewardPointBatchUpdateArgs(
      List<MemberRewardPoint> memberRewardPointList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberRewardPoint memberRewardPoint : memberRewardPointList) {
      if (!memberRewardPoint.isChanged()) {
        continue;
      }
      Object[] parameters = prepareMemberRewardPointUpdateParameters(memberRewardPoint);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberRewardPointBatchRecoverArgs(
      List<MemberRewardPoint> memberRewardPointList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberRewardPoint memberRewardPoint : memberRewardPointList) {
      if (!memberRewardPoint.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(memberRewardPoint);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberRewardPointBatchRemoveArgs(
      List<MemberRewardPoint> memberRewardPointList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberRewardPoint memberRewardPoint : memberRewardPointList) {
      if (!memberRewardPoint.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareMemberRewardPointRemoveParameters(memberRewardPoint);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchMemberRewardPointCreate(List<MemberRewardPoint> memberRewardPointList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareMemberRewardPointBatchCreateArgs(memberRewardPointList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchMemberRewardPointUpdate(List<MemberRewardPoint> memberRewardPointList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareMemberRewardPointBatchUpdateArgs(memberRewardPointList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchMemberRewardPointRemove(List<MemberRewardPoint> memberRewardPointList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareMemberRewardPointBatchRemoveArgs(memberRewardPointList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchMemberRewardPointRecover(List<MemberRewardPoint> memberRewardPointList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareMemberRewardPointBatchRecoverArgs(memberRewardPointList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitMemberRewardPointList(List<MemberRewardPoint> memberRewardPointList) {

    List<MemberRewardPoint> memberRewardPointCreateList = new ArrayList<MemberRewardPoint>();
    List<MemberRewardPoint> memberRewardPointUpdateList = new ArrayList<MemberRewardPoint>();
    List<MemberRewardPoint> memberRewardPointRemoveList = new ArrayList<MemberRewardPoint>();
    List<MemberRewardPoint> memberRewardPointRecoverList = new ArrayList<MemberRewardPoint>();

    for (MemberRewardPoint memberRewardPoint : memberRewardPointList) {
      if (memberRewardPoint.isToRemove()) {
        memberRewardPointRemoveList.add(memberRewardPoint);
        continue;
      }
      if (memberRewardPoint.isToRecover()) {
        memberRewardPointRecoverList.add(memberRewardPoint);
        continue;
      }
      if (isUpdateRequest(memberRewardPoint)) {
        if (memberRewardPoint.isChanged()) {
          memberRewardPointUpdateList.add(memberRewardPoint);
        }
        continue;
      }

      if (memberRewardPoint.isChanged()) {
        memberRewardPointCreateList.add(memberRewardPoint);
      }
    }

    return new Object[] {
      memberRewardPointCreateList,
      memberRewardPointUpdateList,
      memberRewardPointRemoveList,
      memberRewardPointRecoverList
    };
  }

  protected boolean isUpdateRequest(MemberRewardPoint memberRewardPoint) {
    return memberRewardPoint.getVersion() > 0;
  }

  protected String getSaveMemberRewardPointSQL(MemberRewardPoint memberRewardPoint) {
    if (memberRewardPoint.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(memberRewardPoint)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveMemberRewardPointParameters(MemberRewardPoint memberRewardPoint) {
    if (memberRewardPoint.isToRemove()) {
      return prepareMemberRewardPointRemoveParameters(memberRewardPoint);
    }
    if (memberRewardPoint.isToRecover()) {
      return prepareRecoverParameters(memberRewardPoint);
    }

    if (isUpdateRequest(memberRewardPoint)) {
      return prepareMemberRewardPointUpdateParameters(memberRewardPoint);
    }
    return prepareMemberRewardPointCreateParameters(memberRewardPoint);
  }

  protected Object[] prepareMemberRewardPointRemoveParameters(MemberRewardPoint memberRewardPoint) {
    return super.prepareRemoveParameters(memberRewardPoint);
  }

  protected Object[] prepareMemberRewardPointUpdateParameters(MemberRewardPoint memberRewardPoint) {
    Object[] parameters = new Object[6];

    parameters[0] = memberRewardPoint.getName();

    parameters[1] = memberRewardPoint.getPoint();

    if (memberRewardPoint.getOwner() != null) {
      parameters[2] = memberRewardPoint.getOwner().getId();
    }

    parameters[3] = memberRewardPoint.nextVersion();
    parameters[4] = memberRewardPoint.getId();
    parameters[5] = memberRewardPoint.getVersion();

    return parameters;
  }

  protected Object[] prepareMemberRewardPointCreateParameters(MemberRewardPoint memberRewardPoint) {
    Object[] parameters = new Object[4];
    if (memberRewardPoint.getId() == null) {
      String newMemberRewardPointId = getNextId();
      memberRewardPoint.setId(newMemberRewardPointId);
    }
    parameters[0] = memberRewardPoint.getId();

    parameters[1] = memberRewardPoint.getName();

    parameters[2] = memberRewardPoint.getPoint();

    if (memberRewardPoint.getOwner() != null) {
      parameters[3] = memberRewardPoint.getOwner().getId();
    }

    return parameters;
  }

  protected MemberRewardPoint saveInternalMemberRewardPoint(
      MemberRewardPoint memberRewardPoint, Map<String, Object> options) {

    if (isSaveOwnerEnabled(options)) {
      saveOwner(memberRewardPoint, options);
    }

    saveMemberRewardPoint(memberRewardPoint);

    return memberRewardPoint;
  }

  // ======================================================================================

  protected MemberRewardPoint saveOwner(
      MemberRewardPoint memberRewardPoint, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (memberRewardPoint.getOwner() == null) {
      return memberRewardPoint; // do nothing when it is null
    }

    getRetailStoreMemberDAO().save(memberRewardPoint.getOwner(), options);
    return memberRewardPoint;
  }

  public MemberRewardPoint present(
      MemberRewardPoint memberRewardPoint, Map<String, Object> options) {

    return memberRewardPoint;
  }

  protected String getTableName() {
    return MemberRewardPointTable.TABLE_NAME;
  }

  public void enhanceList(List<MemberRewardPoint> memberRewardPointList) {
    this.enhanceListInternal(memberRewardPointList, this.getMemberRewardPointMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<MemberRewardPoint> memberRewardPointList =
        ownerEntity.collectRefsWithType(MemberRewardPoint.INTERNAL_TYPE);
    this.enhanceList(memberRewardPointList);
  }

  @Override
  public SmartList<MemberRewardPoint> findMemberRewardPointWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getMemberRewardPointMapper());
  }

  @Override
  public int countMemberRewardPointWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countMemberRewardPointWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<MemberRewardPoint> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getMemberRewardPointMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<MemberRewardPoint> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getMemberRewardPointMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateMemberRewardPoint executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateMemberRewardPoint result = new CandidateMemberRewardPoint();
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
  public List<MemberRewardPoint> search(MemberRewardPointRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected MemberRewardPointMapper mapper() {
    return getMemberRewardPointMapper();
  }

  @Override
  protected MemberRewardPointMapper mapperForClazz(Class<?> clazz) {
    return MemberRewardPointMapper.mapperForClass(clazz);
  }
}
