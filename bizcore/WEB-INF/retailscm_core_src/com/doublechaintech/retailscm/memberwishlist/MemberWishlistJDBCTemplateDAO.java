package com.doublechaintech.retailscm.memberwishlist;

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

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class MemberWishlistJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements MemberWishlistDAO {

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

  protected MemberWishlistProductDAO memberWishlistProductDAO;

  public void setMemberWishlistProductDAO(MemberWishlistProductDAO memberWishlistProductDAO) {

    if (memberWishlistProductDAO == null) {
      throw new IllegalStateException("Do not try to set memberWishlistProductDAO to null.");
    }
    this.memberWishlistProductDAO = memberWishlistProductDAO;
  }

  public MemberWishlistProductDAO getMemberWishlistProductDAO() {
    if (this.memberWishlistProductDAO == null) {
      throw new IllegalStateException(
          "The memberWishlistProductDAO is not configured yet, please config it some where.");
    }

    return this.memberWishlistProductDAO;
  }

  /*
  protected MemberWishlist load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalMemberWishlist(accessKey, options);
  }
  */

  public SmartList<MemberWishlist> loadAll() {
    return this.loadAll(getMemberWishlistMapper());
  }

  public Stream<MemberWishlist> loadAllAsStream() {
    return this.loadAllAsStream(getMemberWishlistMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public MemberWishlist load(String id, Map<String, Object> options) throws Exception {
    return loadInternalMemberWishlist(MemberWishlistTable.withId(id), options);
  }

  public MemberWishlist save(MemberWishlist memberWishlist, Map<String, Object> options) {

    String methodName = "save(MemberWishlist memberWishlist,Map<String,Object> options)";

    assertMethodArgumentNotNull(memberWishlist, methodName, "memberWishlist");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalMemberWishlist(memberWishlist, options);
  }

  public MemberWishlist clone(String memberWishlistId, Map<String, Object> options)
      throws Exception {

    return clone(MemberWishlistTable.withId(memberWishlistId), options);
  }

  protected MemberWishlist clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String memberWishlistId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    MemberWishlist newMemberWishlist = loadInternalMemberWishlist(accessKey, options);
    newMemberWishlist.setVersion(0);

    if (isSaveMemberWishlistProductListEnabled(options)) {
      for (MemberWishlistProduct item : newMemberWishlist.getMemberWishlistProductList()) {
        item.setVersion(0);
      }
    }

    saveInternalMemberWishlist(newMemberWishlist, options);

    return newMemberWishlist;
  }

  protected void throwIfHasException(String memberWishlistId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new MemberWishlistVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new MemberWishlistNotFoundException(
          "The " + this.getTableName() + "(" + memberWishlistId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public MemberWishlist disconnectFromAll(String memberWishlistId, int version) throws Exception {

    MemberWishlist memberWishlist =
        loadInternalMemberWishlist(MemberWishlistTable.withId(memberWishlistId), emptyOptions());
    memberWishlist.clearFromAll();
    this.saveMemberWishlist(memberWishlist);
    return memberWishlist;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return MemberWishlistTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "member_wishlist";
  }

  @Override
  protected String getBeanName() {

    return "memberWishlist";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return MemberWishlistTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, MemberWishlistTokens.OWNER);
  }

  protected boolean isSaveOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, MemberWishlistTokens.OWNER);
  }

  protected boolean isExtractMemberWishlistProductListEnabled(Map<String, Object> options) {
    return checkOptions(options, MemberWishlistTokens.MEMBER_WISHLIST_PRODUCT_LIST);
  }

  protected boolean isAnalyzeMemberWishlistProductListEnabled(Map<String, Object> options) {
    return MemberWishlistTokens.of(options).analyzeMemberWishlistProductListEnabled();
  }

  protected boolean isSaveMemberWishlistProductListEnabled(Map<String, Object> options) {
    return checkOptions(options, MemberWishlistTokens.MEMBER_WISHLIST_PRODUCT_LIST);
  }

  protected MemberWishlistMapper getMemberWishlistMapper() {
    return new MemberWishlistMapper();
  }

  protected MemberWishlist extractMemberWishlist(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      MemberWishlist memberWishlist = loadSingleObject(accessKey, getMemberWishlistMapper());
      return memberWishlist;
    } catch (EmptyResultDataAccessException e) {
      throw new MemberWishlistNotFoundException("MemberWishlist(" + accessKey + ") is not found!");
    }
  }

  protected MemberWishlist loadInternalMemberWishlist(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    MemberWishlist memberWishlist = extractMemberWishlist(accessKey, loadOptions);

    if (isExtractOwnerEnabled(loadOptions)) {
      extractOwner(memberWishlist, loadOptions);
    }

    if (isExtractMemberWishlistProductListEnabled(loadOptions)) {
      extractMemberWishlistProductList(memberWishlist, loadOptions);
    }

    if (isAnalyzeMemberWishlistProductListEnabled(loadOptions)) {
      analyzeMemberWishlistProductList(memberWishlist, loadOptions);
    }

    return memberWishlist;
  }

  protected MemberWishlist extractOwner(MemberWishlist memberWishlist, Map<String, Object> options)
      throws Exception {

    if (memberWishlist.getOwner() == null) {
      return memberWishlist;
    }
    String ownerId = memberWishlist.getOwner().getId();
    if (ownerId == null) {
      return memberWishlist;
    }
    RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId, options);
    if (owner != null) {
      memberWishlist.setOwner(owner);
    }

    return memberWishlist;
  }

  protected void enhanceMemberWishlistProductList(
      SmartList<MemberWishlistProduct> memberWishlistProductList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected MemberWishlist extractMemberWishlistProductList(
      MemberWishlist memberWishlist, Map<String, Object> options) {

    if (memberWishlist == null) {
      return null;
    }
    if (memberWishlist.getId() == null) {
      return memberWishlist;
    }

    SmartList<MemberWishlistProduct> memberWishlistProductList =
        getMemberWishlistProductDAO()
            .findMemberWishlistProductByOwner(memberWishlist.getId(), options);
    if (memberWishlistProductList != null) {
      enhanceMemberWishlistProductList(memberWishlistProductList, options);
      memberWishlist.setMemberWishlistProductList(memberWishlistProductList);
    }

    return memberWishlist;
  }

  protected MemberWishlist analyzeMemberWishlistProductList(
      MemberWishlist memberWishlist, Map<String, Object> options) {

    if (memberWishlist == null) {
      return null;
    }
    if (memberWishlist.getId() == null) {
      return memberWishlist;
    }

    SmartList<MemberWishlistProduct> memberWishlistProductList =
        memberWishlist.getMemberWishlistProductList();
    if (memberWishlistProductList != null) {
      getMemberWishlistProductDAO()
          .analyzeMemberWishlistProductByOwner(
              memberWishlistProductList, memberWishlist.getId(), options);
    }

    return memberWishlist;
  }

  public SmartList<MemberWishlist> findMemberWishlistByOwner(
      String retailStoreMemberId, Map<String, Object> options) {

    SmartList<MemberWishlist> resultList =
        queryWith(
            MemberWishlistTable.COLUMN_OWNER,
            retailStoreMemberId,
            options,
            getMemberWishlistMapper());
    // analyzeMemberWishlistByOwner(resultList, retailStoreMemberId, options);
    return resultList;
  }

  public SmartList<MemberWishlist> findMemberWishlistByOwner(
      String retailStoreMemberId, int start, int count, Map<String, Object> options) {

    SmartList<MemberWishlist> resultList =
        queryWithRange(
            MemberWishlistTable.COLUMN_OWNER,
            retailStoreMemberId,
            options,
            getMemberWishlistMapper(),
            start,
            count);
    // analyzeMemberWishlistByOwner(resultList, retailStoreMemberId, options);
    return resultList;
  }

  public void analyzeMemberWishlistByOwner(
      SmartList<MemberWishlist> resultList,
      String retailStoreMemberId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countMemberWishlistByOwner(String retailStoreMemberId, Map<String, Object> options) {

    return countWith(MemberWishlistTable.COLUMN_OWNER, retailStoreMemberId, options);
  }

  @Override
  public Map<String, Integer> countMemberWishlistByOwnerIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(MemberWishlistTable.COLUMN_OWNER, ids, options);
  }

  protected MemberWishlist saveMemberWishlist(MemberWishlist memberWishlist) {

    if (!memberWishlist.isChanged()) {
      return memberWishlist;
    }

    Beans.dbUtil().cacheCleanUp(memberWishlist);
    String SQL = this.getSaveMemberWishlistSQL(memberWishlist);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveMemberWishlistParameters(memberWishlist);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    memberWishlist.incVersion();
    memberWishlist.afterSave();
    return memberWishlist;
  }

  public SmartList<MemberWishlist> saveMemberWishlistList(
      SmartList<MemberWishlist> memberWishlistList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitMemberWishlistList(memberWishlistList);

    batchMemberWishlistCreate((List<MemberWishlist>) lists[CREATE_LIST_INDEX]);
    batchMemberWishlistUpdate((List<MemberWishlist>) lists[UPDATE_LIST_INDEX]);
    batchMemberWishlistRemove((List<MemberWishlist>) lists[REMOVE_LIST_INDEX]);
    batchMemberWishlistRecover((List<MemberWishlist>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (MemberWishlist memberWishlist : memberWishlistList) {
      if (memberWishlist.isChanged()) {
        memberWishlist.incVersion();
        memberWishlist.afterSave();
      }
      if (memberWishlist.isToRecover() || memberWishlist.isToRemove()) {
        memberWishlist.setVersion(-memberWishlist.getVersion());
      }
    }

    return memberWishlistList;
  }

  public SmartList<MemberWishlist> removeMemberWishlistList(
      SmartList<MemberWishlist> memberWishlistList, Map<String, Object> options) {

    super.removeList(memberWishlistList, options);

    return memberWishlistList;
  }

  protected List<Object[]> prepareMemberWishlistBatchCreateArgs(
      List<MemberWishlist> memberWishlistList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlist memberWishlist : memberWishlistList) {
      Object[] parameters = prepareMemberWishlistCreateParameters(memberWishlist);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberWishlistBatchUpdateArgs(
      List<MemberWishlist> memberWishlistList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlist memberWishlist : memberWishlistList) {
      if (!memberWishlist.isChanged()) {
        continue;
      }
      Object[] parameters = prepareMemberWishlistUpdateParameters(memberWishlist);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberWishlistBatchRecoverArgs(
      List<MemberWishlist> memberWishlistList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlist memberWishlist : memberWishlistList) {
      if (!memberWishlist.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(memberWishlist);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberWishlistBatchRemoveArgs(
      List<MemberWishlist> memberWishlistList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlist memberWishlist : memberWishlistList) {
      if (!memberWishlist.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareMemberWishlistRemoveParameters(memberWishlist);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchMemberWishlistCreate(List<MemberWishlist> memberWishlistList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareMemberWishlistBatchCreateArgs(memberWishlistList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchMemberWishlistUpdate(List<MemberWishlist> memberWishlistList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareMemberWishlistBatchUpdateArgs(memberWishlistList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchMemberWishlistRemove(List<MemberWishlist> memberWishlistList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareMemberWishlistBatchRemoveArgs(memberWishlistList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchMemberWishlistRecover(List<MemberWishlist> memberWishlistList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareMemberWishlistBatchRecoverArgs(memberWishlistList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitMemberWishlistList(List<MemberWishlist> memberWishlistList) {

    List<MemberWishlist> memberWishlistCreateList = new ArrayList<MemberWishlist>();
    List<MemberWishlist> memberWishlistUpdateList = new ArrayList<MemberWishlist>();
    List<MemberWishlist> memberWishlistRemoveList = new ArrayList<MemberWishlist>();
    List<MemberWishlist> memberWishlistRecoverList = new ArrayList<MemberWishlist>();

    for (MemberWishlist memberWishlist : memberWishlistList) {
      if (memberWishlist.isToRemove()) {
        memberWishlistRemoveList.add(memberWishlist);
        continue;
      }
      if (memberWishlist.isToRecover()) {
        memberWishlistRecoverList.add(memberWishlist);
        continue;
      }
      if (isUpdateRequest(memberWishlist)) {
        if (memberWishlist.isChanged()) {
          memberWishlistUpdateList.add(memberWishlist);
        }
        continue;
      }

      if (memberWishlist.isChanged()) {
        memberWishlistCreateList.add(memberWishlist);
      }
    }

    return new Object[] {
      memberWishlistCreateList,
      memberWishlistUpdateList,
      memberWishlistRemoveList,
      memberWishlistRecoverList
    };
  }

  protected boolean isUpdateRequest(MemberWishlist memberWishlist) {
    return memberWishlist.getVersion() > 0;
  }

  protected String getSaveMemberWishlistSQL(MemberWishlist memberWishlist) {
    if (memberWishlist.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(memberWishlist)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveMemberWishlistParameters(MemberWishlist memberWishlist) {
    if (memberWishlist.isToRemove()) {
      return prepareMemberWishlistRemoveParameters(memberWishlist);
    }
    if (memberWishlist.isToRecover()) {
      return prepareRecoverParameters(memberWishlist);
    }

    if (isUpdateRequest(memberWishlist)) {
      return prepareMemberWishlistUpdateParameters(memberWishlist);
    }
    return prepareMemberWishlistCreateParameters(memberWishlist);
  }

  protected Object[] prepareMemberWishlistRemoveParameters(MemberWishlist memberWishlist) {
    return super.prepareRemoveParameters(memberWishlist);
  }

  protected Object[] prepareMemberWishlistUpdateParameters(MemberWishlist memberWishlist) {
    Object[] parameters = new Object[5];

    parameters[0] = memberWishlist.getName();

    if (memberWishlist.getOwner() != null) {
      parameters[1] = memberWishlist.getOwner().getId();
    }

    parameters[2] = memberWishlist.nextVersion();
    parameters[3] = memberWishlist.getId();
    parameters[4] = memberWishlist.getVersion();

    return parameters;
  }

  protected Object[] prepareMemberWishlistCreateParameters(MemberWishlist memberWishlist) {
    Object[] parameters = new Object[3];
    if (memberWishlist.getId() == null) {
      String newMemberWishlistId = getNextId();
      memberWishlist.setId(newMemberWishlistId);
    }
    parameters[0] = memberWishlist.getId();

    parameters[1] = memberWishlist.getName();

    if (memberWishlist.getOwner() != null) {
      parameters[2] = memberWishlist.getOwner().getId();
    }

    return parameters;
  }

  protected MemberWishlist saveInternalMemberWishlist(
      MemberWishlist memberWishlist, Map<String, Object> options) {

    if (isSaveOwnerEnabled(options)) {
      saveOwner(memberWishlist, options);
    }

    saveMemberWishlist(memberWishlist);

    if (isSaveMemberWishlistProductListEnabled(options)) {
      saveMemberWishlistProductList(memberWishlist, options);
      // removeMemberWishlistProductList(memberWishlist, options);
      // Not delete the record

    }

    return memberWishlist;
  }

  // ======================================================================================

  protected MemberWishlist saveOwner(MemberWishlist memberWishlist, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (memberWishlist.getOwner() == null) {
      return memberWishlist; // do nothing when it is null
    }

    getRetailStoreMemberDAO().save(memberWishlist.getOwner(), options);
    return memberWishlist;
  }

  public MemberWishlist planToRemoveMemberWishlistProductList(
      MemberWishlist memberWishlist, String memberWishlistProductIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(MemberWishlistProduct.OWNER_PROPERTY, memberWishlist.getId());
    key.put(MemberWishlistProduct.ID_PROPERTY, memberWishlistProductIds);

    SmartList<MemberWishlistProduct> externalMemberWishlistProductList =
        getMemberWishlistProductDAO().findMemberWishlistProductWithKey(key, options);
    if (externalMemberWishlistProductList == null) {
      return memberWishlist;
    }
    if (externalMemberWishlistProductList.isEmpty()) {
      return memberWishlist;
    }

    for (MemberWishlistProduct memberWishlistProductItem : externalMemberWishlistProductList) {

      memberWishlistProductItem.clearFromAll();
    }

    SmartList<MemberWishlistProduct> memberWishlistProductList =
        memberWishlist.getMemberWishlistProductList();
    memberWishlistProductList.addAllToRemoveList(externalMemberWishlistProductList);
    return memberWishlist;
  }

  protected MemberWishlist saveMemberWishlistProductList(
      MemberWishlist memberWishlist, Map<String, Object> options) {

    SmartList<MemberWishlistProduct> memberWishlistProductList =
        memberWishlist.getMemberWishlistProductList();
    if (memberWishlistProductList == null) {
      // null list means nothing
      return memberWishlist;
    }
    SmartList<MemberWishlistProduct> mergedUpdateMemberWishlistProductList =
        new SmartList<MemberWishlistProduct>();

    mergedUpdateMemberWishlistProductList.addAll(memberWishlistProductList);
    if (memberWishlistProductList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateMemberWishlistProductList.addAll(memberWishlistProductList.getToRemoveList());
      memberWishlistProductList.removeAll(memberWishlistProductList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getMemberWishlistProductDAO()
        .saveMemberWishlistProductList(mergedUpdateMemberWishlistProductList, options);

    if (memberWishlistProductList.getToRemoveList() != null) {
      memberWishlistProductList.removeAll(memberWishlistProductList.getToRemoveList());
    }

    return memberWishlist;
  }

  protected MemberWishlist removeMemberWishlistProductList(
      MemberWishlist memberWishlist, Map<String, Object> options) {

    SmartList<MemberWishlistProduct> memberWishlistProductList =
        memberWishlist.getMemberWishlistProductList();
    if (memberWishlistProductList == null) {
      return memberWishlist;
    }

    SmartList<MemberWishlistProduct> toRemoveMemberWishlistProductList =
        memberWishlistProductList.getToRemoveList();

    if (toRemoveMemberWishlistProductList == null) {
      return memberWishlist;
    }
    if (toRemoveMemberWishlistProductList.isEmpty()) {
      return memberWishlist; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getMemberWishlistProductDAO()
        .removeMemberWishlistProductList(toRemoveMemberWishlistProductList, options);

    return memberWishlist;
  }

  public MemberWishlist present(MemberWishlist memberWishlist, Map<String, Object> options) {

    presentMemberWishlistProductList(memberWishlist, options);

    return memberWishlist;
  }

  // Using java8 feature to reduce the code significantly
  protected MemberWishlist presentMemberWishlistProductList(
      MemberWishlist memberWishlist, Map<String, Object> options) {

    SmartList<MemberWishlistProduct> memberWishlistProductList =
        memberWishlist.getMemberWishlistProductList();
    SmartList<MemberWishlistProduct> newList =
        presentSubList(
            memberWishlist.getId(),
            memberWishlistProductList,
            options,
            getMemberWishlistProductDAO()::countMemberWishlistProductByOwner,
            getMemberWishlistProductDAO()::findMemberWishlistProductByOwner);

    memberWishlist.setMemberWishlistProductList(newList);

    return memberWishlist;
  }

  public SmartList<MemberWishlist> requestCandidateMemberWishlistForMemberWishlistProduct(
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
        MemberWishlistTable.COLUMN_NAME,
        MemberWishlistTable.COLUMN_OWNER,
        filterKey,
        pageNo,
        pageSize,
        getMemberWishlistMapper());
  }

  protected String getTableName() {
    return MemberWishlistTable.TABLE_NAME;
  }

  public void enhanceList(List<MemberWishlist> memberWishlistList) {
    this.enhanceListInternal(memberWishlistList, this.getMemberWishlistMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<MemberWishlist> memberWishlistList =
        ownerEntity.collectRefsWithType(MemberWishlist.INTERNAL_TYPE);
    this.enhanceList(memberWishlistList);
  }

  @Override
  public SmartList<MemberWishlist> findMemberWishlistWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getMemberWishlistMapper());
  }

  @Override
  public int countMemberWishlistWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countMemberWishlistWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<MemberWishlist> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getMemberWishlistMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<MemberWishlist> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getMemberWishlistMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateMemberWishlist executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateMemberWishlist result = new CandidateMemberWishlist();
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
  public List<MemberWishlist> search(MemberWishlistRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected MemberWishlistMapper mapper() {
    return getMemberWishlistMapper();
  }

  @Override
  protected MemberWishlistMapper mapperForClazz(Class<?> clazz) {
    return MemberWishlistMapper.mapperForClass(clazz);
  }
}
