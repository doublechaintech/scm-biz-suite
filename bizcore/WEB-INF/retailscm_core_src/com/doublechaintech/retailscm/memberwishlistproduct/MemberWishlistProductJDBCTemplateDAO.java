package com.doublechaintech.retailscm.memberwishlistproduct;

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

import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;

import com.doublechaintech.retailscm.memberwishlist.MemberWishlistDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class MemberWishlistProductJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements MemberWishlistProductDAO {

  protected MemberWishlistDAO memberWishlistDAO;

  public void setMemberWishlistDAO(MemberWishlistDAO memberWishlistDAO) {

    if (memberWishlistDAO == null) {
      throw new IllegalStateException("Do not try to set memberWishlistDAO to null.");
    }
    this.memberWishlistDAO = memberWishlistDAO;
  }

  public MemberWishlistDAO getMemberWishlistDAO() {
    if (this.memberWishlistDAO == null) {
      throw new IllegalStateException(
          "The memberWishlistDAO is not configured yet, please config it some where.");
    }

    return this.memberWishlistDAO;
  }

  /*
  protected MemberWishlistProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalMemberWishlistProduct(accessKey, options);
  }
  */

  public SmartList<MemberWishlistProduct> loadAll() {
    return this.loadAll(getMemberWishlistProductMapper());
  }

  public Stream<MemberWishlistProduct> loadAllAsStream() {
    return this.loadAllAsStream(getMemberWishlistProductMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public MemberWishlistProduct load(String id, Map<String, Object> options) throws Exception {
    return loadInternalMemberWishlistProduct(MemberWishlistProductTable.withId(id), options);
  }

  public MemberWishlistProduct save(
      MemberWishlistProduct memberWishlistProduct, Map<String, Object> options) {

    String methodName =
        "save(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options)";

    assertMethodArgumentNotNull(memberWishlistProduct, methodName, "memberWishlistProduct");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalMemberWishlistProduct(memberWishlistProduct, options);
  }

  public MemberWishlistProduct clone(String memberWishlistProductId, Map<String, Object> options)
      throws Exception {

    return clone(MemberWishlistProductTable.withId(memberWishlistProductId), options);
  }

  protected MemberWishlistProduct clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String memberWishlistProductId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    MemberWishlistProduct newMemberWishlistProduct =
        loadInternalMemberWishlistProduct(accessKey, options);
    newMemberWishlistProduct.setVersion(0);

    saveInternalMemberWishlistProduct(newMemberWishlistProduct, options);

    return newMemberWishlistProduct;
  }

  protected void throwIfHasException(String memberWishlistProductId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new MemberWishlistProductVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new MemberWishlistProductNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + memberWishlistProductId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public MemberWishlistProduct disconnectFromAll(String memberWishlistProductId, int version)
      throws Exception {

    MemberWishlistProduct memberWishlistProduct =
        loadInternalMemberWishlistProduct(
            MemberWishlistProductTable.withId(memberWishlistProductId), emptyOptions());
    memberWishlistProduct.clearFromAll();
    this.saveMemberWishlistProduct(memberWishlistProduct);
    return memberWishlistProduct;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return MemberWishlistProductTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "member_wishlist_product";
  }

  @Override
  protected String getBeanName() {

    return "memberWishlistProduct";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return MemberWishlistProductTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, MemberWishlistProductTokens.OWNER);
  }

  protected boolean isSaveOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, MemberWishlistProductTokens.OWNER);
  }

  protected MemberWishlistProductMapper getMemberWishlistProductMapper() {
    return new MemberWishlistProductMapper();
  }

  protected MemberWishlistProduct extractMemberWishlistProduct(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      MemberWishlistProduct memberWishlistProduct =
          loadSingleObject(accessKey, getMemberWishlistProductMapper());
      return memberWishlistProduct;
    } catch (EmptyResultDataAccessException e) {
      throw new MemberWishlistProductNotFoundException(
          "MemberWishlistProduct(" + accessKey + ") is not found!");
    }
  }

  protected MemberWishlistProduct loadInternalMemberWishlistProduct(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    MemberWishlistProduct memberWishlistProduct =
        extractMemberWishlistProduct(accessKey, loadOptions);

    if (isExtractOwnerEnabled(loadOptions)) {
      extractOwner(memberWishlistProduct, loadOptions);
    }

    return memberWishlistProduct;
  }

  protected MemberWishlistProduct extractOwner(
      MemberWishlistProduct memberWishlistProduct, Map<String, Object> options) throws Exception {

    if (memberWishlistProduct.getOwner() == null) {
      return memberWishlistProduct;
    }
    String ownerId = memberWishlistProduct.getOwner().getId();
    if (ownerId == null) {
      return memberWishlistProduct;
    }
    MemberWishlist owner = getMemberWishlistDAO().load(ownerId, options);
    if (owner != null) {
      memberWishlistProduct.setOwner(owner);
    }

    return memberWishlistProduct;
  }

  public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(
      String memberWishlistId, Map<String, Object> options) {

    SmartList<MemberWishlistProduct> resultList =
        queryWith(
            MemberWishlistProductTable.COLUMN_OWNER,
            memberWishlistId,
            options,
            getMemberWishlistProductMapper());
    // analyzeMemberWishlistProductByOwner(resultList, memberWishlistId, options);
    return resultList;
  }

  public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(
      String memberWishlistId, int start, int count, Map<String, Object> options) {

    SmartList<MemberWishlistProduct> resultList =
        queryWithRange(
            MemberWishlistProductTable.COLUMN_OWNER,
            memberWishlistId,
            options,
            getMemberWishlistProductMapper(),
            start,
            count);
    // analyzeMemberWishlistProductByOwner(resultList, memberWishlistId, options);
    return resultList;
  }

  public void analyzeMemberWishlistProductByOwner(
      SmartList<MemberWishlistProduct> resultList,
      String memberWishlistId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countMemberWishlistProductByOwner(
      String memberWishlistId, Map<String, Object> options) {

    return countWith(MemberWishlistProductTable.COLUMN_OWNER, memberWishlistId, options);
  }

  @Override
  public Map<String, Integer> countMemberWishlistProductByOwnerIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(MemberWishlistProductTable.COLUMN_OWNER, ids, options);
  }

  protected MemberWishlistProduct saveMemberWishlistProduct(
      MemberWishlistProduct memberWishlistProduct) {

    if (!memberWishlistProduct.isChanged()) {
      return memberWishlistProduct;
    }

    Beans.dbUtil().cacheCleanUp(memberWishlistProduct);
    String SQL = this.getSaveMemberWishlistProductSQL(memberWishlistProduct);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveMemberWishlistProductParameters(memberWishlistProduct);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    memberWishlistProduct.incVersion();
    memberWishlistProduct.afterSave();
    return memberWishlistProduct;
  }

  public SmartList<MemberWishlistProduct> saveMemberWishlistProductList(
      SmartList<MemberWishlistProduct> memberWishlistProductList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitMemberWishlistProductList(memberWishlistProductList);

    batchMemberWishlistProductCreate((List<MemberWishlistProduct>) lists[CREATE_LIST_INDEX]);
    batchMemberWishlistProductUpdate((List<MemberWishlistProduct>) lists[UPDATE_LIST_INDEX]);
    batchMemberWishlistProductRemove((List<MemberWishlistProduct>) lists[REMOVE_LIST_INDEX]);
    batchMemberWishlistProductRecover((List<MemberWishlistProduct>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (MemberWishlistProduct memberWishlistProduct : memberWishlistProductList) {
      if (memberWishlistProduct.isChanged()) {
        memberWishlistProduct.incVersion();
        memberWishlistProduct.afterSave();
      }
      if (memberWishlistProduct.isToRecover() || memberWishlistProduct.isToRemove()) {
        memberWishlistProduct.setVersion(-memberWishlistProduct.getVersion());
      }
    }

    return memberWishlistProductList;
  }

  public SmartList<MemberWishlistProduct> removeMemberWishlistProductList(
      SmartList<MemberWishlistProduct> memberWishlistProductList, Map<String, Object> options) {

    super.removeList(memberWishlistProductList, options);

    return memberWishlistProductList;
  }

  protected List<Object[]> prepareMemberWishlistProductBatchCreateArgs(
      List<MemberWishlistProduct> memberWishlistProductList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlistProduct memberWishlistProduct : memberWishlistProductList) {
      Object[] parameters = prepareMemberWishlistProductCreateParameters(memberWishlistProduct);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberWishlistProductBatchUpdateArgs(
      List<MemberWishlistProduct> memberWishlistProductList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlistProduct memberWishlistProduct : memberWishlistProductList) {
      if (!memberWishlistProduct.isChanged()) {
        continue;
      }
      Object[] parameters = prepareMemberWishlistProductUpdateParameters(memberWishlistProduct);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberWishlistProductBatchRecoverArgs(
      List<MemberWishlistProduct> memberWishlistProductList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlistProduct memberWishlistProduct : memberWishlistProductList) {
      if (!memberWishlistProduct.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(memberWishlistProduct);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareMemberWishlistProductBatchRemoveArgs(
      List<MemberWishlistProduct> memberWishlistProductList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (MemberWishlistProduct memberWishlistProduct : memberWishlistProductList) {
      if (!memberWishlistProduct.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareMemberWishlistProductRemoveParameters(memberWishlistProduct);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchMemberWishlistProductCreate(
      List<MemberWishlistProduct> memberWishlistProductList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareMemberWishlistProductBatchCreateArgs(memberWishlistProductList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchMemberWishlistProductUpdate(
      List<MemberWishlistProduct> memberWishlistProductList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareMemberWishlistProductBatchUpdateArgs(memberWishlistProductList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchMemberWishlistProductRemove(
      List<MemberWishlistProduct> memberWishlistProductList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareMemberWishlistProductBatchRemoveArgs(memberWishlistProductList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchMemberWishlistProductRecover(
      List<MemberWishlistProduct> memberWishlistProductList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareMemberWishlistProductBatchRecoverArgs(memberWishlistProductList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitMemberWishlistProductList(
      List<MemberWishlistProduct> memberWishlistProductList) {

    List<MemberWishlistProduct> memberWishlistProductCreateList =
        new ArrayList<MemberWishlistProduct>();
    List<MemberWishlistProduct> memberWishlistProductUpdateList =
        new ArrayList<MemberWishlistProduct>();
    List<MemberWishlistProduct> memberWishlistProductRemoveList =
        new ArrayList<MemberWishlistProduct>();
    List<MemberWishlistProduct> memberWishlistProductRecoverList =
        new ArrayList<MemberWishlistProduct>();

    for (MemberWishlistProduct memberWishlistProduct : memberWishlistProductList) {
      if (memberWishlistProduct.isToRemove()) {
        memberWishlistProductRemoveList.add(memberWishlistProduct);
        continue;
      }
      if (memberWishlistProduct.isToRecover()) {
        memberWishlistProductRecoverList.add(memberWishlistProduct);
        continue;
      }
      if (isUpdateRequest(memberWishlistProduct)) {
        if (memberWishlistProduct.isChanged()) {
          memberWishlistProductUpdateList.add(memberWishlistProduct);
        }
        continue;
      }

      if (memberWishlistProduct.isChanged()) {
        memberWishlistProductCreateList.add(memberWishlistProduct);
      }
    }

    return new Object[] {
      memberWishlistProductCreateList,
      memberWishlistProductUpdateList,
      memberWishlistProductRemoveList,
      memberWishlistProductRecoverList
    };
  }

  protected boolean isUpdateRequest(MemberWishlistProduct memberWishlistProduct) {
    return memberWishlistProduct.getVersion() > 0;
  }

  protected String getSaveMemberWishlistProductSQL(MemberWishlistProduct memberWishlistProduct) {
    if (memberWishlistProduct.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(memberWishlistProduct)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveMemberWishlistProductParameters(
      MemberWishlistProduct memberWishlistProduct) {
    if (memberWishlistProduct.isToRemove()) {
      return prepareMemberWishlistProductRemoveParameters(memberWishlistProduct);
    }
    if (memberWishlistProduct.isToRecover()) {
      return prepareRecoverParameters(memberWishlistProduct);
    }

    if (isUpdateRequest(memberWishlistProduct)) {
      return prepareMemberWishlistProductUpdateParameters(memberWishlistProduct);
    }
    return prepareMemberWishlistProductCreateParameters(memberWishlistProduct);
  }

  protected Object[] prepareMemberWishlistProductRemoveParameters(
      MemberWishlistProduct memberWishlistProduct) {
    return super.prepareRemoveParameters(memberWishlistProduct);
  }

  protected Object[] prepareMemberWishlistProductUpdateParameters(
      MemberWishlistProduct memberWishlistProduct) {
    Object[] parameters = new Object[5];

    parameters[0] = memberWishlistProduct.getName();

    if (memberWishlistProduct.getOwner() != null) {
      parameters[1] = memberWishlistProduct.getOwner().getId();
    }

    parameters[2] = memberWishlistProduct.nextVersion();
    parameters[3] = memberWishlistProduct.getId();
    parameters[4] = memberWishlistProduct.getVersion();

    return parameters;
  }

  protected Object[] prepareMemberWishlistProductCreateParameters(
      MemberWishlistProduct memberWishlistProduct) {
    Object[] parameters = new Object[3];
    if (memberWishlistProduct.getId() == null) {
      String newMemberWishlistProductId = getNextId();
      memberWishlistProduct.setId(newMemberWishlistProductId);
    }
    parameters[0] = memberWishlistProduct.getId();

    parameters[1] = memberWishlistProduct.getName();

    if (memberWishlistProduct.getOwner() != null) {
      parameters[2] = memberWishlistProduct.getOwner().getId();
    }

    return parameters;
  }

  protected MemberWishlistProduct saveInternalMemberWishlistProduct(
      MemberWishlistProduct memberWishlistProduct, Map<String, Object> options) {

    if (isSaveOwnerEnabled(options)) {
      saveOwner(memberWishlistProduct, options);
    }

    saveMemberWishlistProduct(memberWishlistProduct);

    return memberWishlistProduct;
  }

  // ======================================================================================

  protected MemberWishlistProduct saveOwner(
      MemberWishlistProduct memberWishlistProduct, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (memberWishlistProduct.getOwner() == null) {
      return memberWishlistProduct; // do nothing when it is null
    }

    getMemberWishlistDAO().save(memberWishlistProduct.getOwner(), options);
    return memberWishlistProduct;
  }

  public MemberWishlistProduct present(
      MemberWishlistProduct memberWishlistProduct, Map<String, Object> options) {

    return memberWishlistProduct;
  }

  protected String getTableName() {
    return MemberWishlistProductTable.TABLE_NAME;
  }

  public void enhanceList(List<MemberWishlistProduct> memberWishlistProductList) {
    this.enhanceListInternal(memberWishlistProductList, this.getMemberWishlistProductMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<MemberWishlistProduct> memberWishlistProductList =
        ownerEntity.collectRefsWithType(MemberWishlistProduct.INTERNAL_TYPE);
    this.enhanceList(memberWishlistProductList);
  }

  @Override
  public SmartList<MemberWishlistProduct> findMemberWishlistProductWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getMemberWishlistProductMapper());
  }

  @Override
  public int countMemberWishlistProductWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countMemberWishlistProductWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<MemberWishlistProduct> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getMemberWishlistProductMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<MemberWishlistProduct> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getMemberWishlistProductMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateMemberWishlistProduct executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateMemberWishlistProduct result = new CandidateMemberWishlistProduct();
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
  public List<MemberWishlistProduct> search(MemberWishlistProductRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected MemberWishlistProductMapper mapper() {
    return getMemberWishlistProductMapper();
  }

  @Override
  protected MemberWishlistProductMapper mapperForClazz(Class<?> clazz) {
    return MemberWishlistProductMapper.mapperForClass(clazz);
  }
}
