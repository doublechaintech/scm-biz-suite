package com.doublechaintech.retailscm.levelthreecategory;

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

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.retailscm.product.ProductDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class LevelThreeCategoryJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements LevelThreeCategoryDAO {

  protected LevelTwoCategoryDAO levelTwoCategoryDAO;

  public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO levelTwoCategoryDAO) {

    if (levelTwoCategoryDAO == null) {
      throw new IllegalStateException("Do not try to set levelTwoCategoryDAO to null.");
    }
    this.levelTwoCategoryDAO = levelTwoCategoryDAO;
  }

  public LevelTwoCategoryDAO getLevelTwoCategoryDAO() {
    if (this.levelTwoCategoryDAO == null) {
      throw new IllegalStateException(
          "The levelTwoCategoryDAO is not configured yet, please config it some where.");
    }

    return this.levelTwoCategoryDAO;
  }

  protected ProductDAO productDAO;

  public void setProductDAO(ProductDAO productDAO) {

    if (productDAO == null) {
      throw new IllegalStateException("Do not try to set productDAO to null.");
    }
    this.productDAO = productDAO;
  }

  public ProductDAO getProductDAO() {
    if (this.productDAO == null) {
      throw new IllegalStateException(
          "The productDAO is not configured yet, please config it some where.");
    }

    return this.productDAO;
  }

  /*
  protected LevelThreeCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalLevelThreeCategory(accessKey, options);
  }
  */

  public SmartList<LevelThreeCategory> loadAll() {
    return this.loadAll(getLevelThreeCategoryMapper());
  }

  public Stream<LevelThreeCategory> loadAllAsStream() {
    return this.loadAllAsStream(getLevelThreeCategoryMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public LevelThreeCategory load(String id, Map<String, Object> options) throws Exception {
    return loadInternalLevelThreeCategory(LevelThreeCategoryTable.withId(id), options);
  }

  public LevelThreeCategory save(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    String methodName = "save(LevelThreeCategory levelThreeCategory,Map<String,Object> options)";

    assertMethodArgumentNotNull(levelThreeCategory, methodName, "levelThreeCategory");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalLevelThreeCategory(levelThreeCategory, options);
  }

  public LevelThreeCategory clone(String levelThreeCategoryId, Map<String, Object> options)
      throws Exception {

    return clone(LevelThreeCategoryTable.withId(levelThreeCategoryId), options);
  }

  protected LevelThreeCategory clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String levelThreeCategoryId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    LevelThreeCategory newLevelThreeCategory = loadInternalLevelThreeCategory(accessKey, options);
    newLevelThreeCategory.setVersion(0);

    if (isSaveProductListEnabled(options)) {
      for (Product item : newLevelThreeCategory.getProductList()) {
        item.setVersion(0);
      }
    }

    saveInternalLevelThreeCategory(newLevelThreeCategory, options);

    return newLevelThreeCategory;
  }

  protected void throwIfHasException(String levelThreeCategoryId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new LevelThreeCategoryVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new LevelThreeCategoryNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + levelThreeCategoryId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public LevelThreeCategory disconnectFromAll(String levelThreeCategoryId, int version)
      throws Exception {

    LevelThreeCategory levelThreeCategory =
        loadInternalLevelThreeCategory(
            LevelThreeCategoryTable.withId(levelThreeCategoryId), emptyOptions());
    levelThreeCategory.clearFromAll();
    this.saveLevelThreeCategory(levelThreeCategory);
    return levelThreeCategory;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return LevelThreeCategoryTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "level_three_category";
  }

  @Override
  protected String getBeanName() {

    return "levelThreeCategory";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return LevelThreeCategoryTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractParentCategoryEnabled(Map<String, Object> options) {

    return checkOptions(options, LevelThreeCategoryTokens.PARENTCATEGORY);
  }

  protected boolean isSaveParentCategoryEnabled(Map<String, Object> options) {

    return checkOptions(options, LevelThreeCategoryTokens.PARENTCATEGORY);
  }

  protected boolean isExtractProductListEnabled(Map<String, Object> options) {
    return checkOptions(options, LevelThreeCategoryTokens.PRODUCT_LIST);
  }

  protected boolean isAnalyzeProductListEnabled(Map<String, Object> options) {
    return LevelThreeCategoryTokens.of(options).analyzeProductListEnabled();
  }

  protected boolean isSaveProductListEnabled(Map<String, Object> options) {
    return checkOptions(options, LevelThreeCategoryTokens.PRODUCT_LIST);
  }

  protected LevelThreeCategoryMapper getLevelThreeCategoryMapper() {
    return new LevelThreeCategoryMapper();
  }

  protected LevelThreeCategory extractLevelThreeCategory(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      LevelThreeCategory levelThreeCategory =
          loadSingleObject(accessKey, getLevelThreeCategoryMapper());
      return levelThreeCategory;
    } catch (EmptyResultDataAccessException e) {
      throw new LevelThreeCategoryNotFoundException(
          "LevelThreeCategory(" + accessKey + ") is not found!");
    }
  }

  protected LevelThreeCategory loadInternalLevelThreeCategory(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    LevelThreeCategory levelThreeCategory = extractLevelThreeCategory(accessKey, loadOptions);

    if (isExtractParentCategoryEnabled(loadOptions)) {
      extractParentCategory(levelThreeCategory, loadOptions);
    }

    if (isExtractProductListEnabled(loadOptions)) {
      extractProductList(levelThreeCategory, loadOptions);
    }

    if (isAnalyzeProductListEnabled(loadOptions)) {
      analyzeProductList(levelThreeCategory, loadOptions);
    }

    return levelThreeCategory;
  }

  protected LevelThreeCategory extractParentCategory(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) throws Exception {

    if (levelThreeCategory.getParentCategory() == null) {
      return levelThreeCategory;
    }
    String parentCategoryId = levelThreeCategory.getParentCategory().getId();
    if (parentCategoryId == null) {
      return levelThreeCategory;
    }
    LevelTwoCategory parentCategory = getLevelTwoCategoryDAO().load(parentCategoryId, options);
    if (parentCategory != null) {
      levelThreeCategory.setParentCategory(parentCategory);
    }

    return levelThreeCategory;
  }

  protected void enhanceProductList(SmartList<Product> productList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected LevelThreeCategory extractProductList(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    if (levelThreeCategory == null) {
      return null;
    }
    if (levelThreeCategory.getId() == null) {
      return levelThreeCategory;
    }

    SmartList<Product> productList =
        getProductDAO().findProductByParentCategory(levelThreeCategory.getId(), options);
    if (productList != null) {
      enhanceProductList(productList, options);
      levelThreeCategory.setProductList(productList);
    }

    return levelThreeCategory;
  }

  protected LevelThreeCategory analyzeProductList(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    if (levelThreeCategory == null) {
      return null;
    }
    if (levelThreeCategory.getId() == null) {
      return levelThreeCategory;
    }

    SmartList<Product> productList = levelThreeCategory.getProductList();
    if (productList != null) {
      getProductDAO()
          .analyzeProductByParentCategory(productList, levelThreeCategory.getId(), options);
    }

    return levelThreeCategory;
  }

  public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(
      String levelTwoCategoryId, Map<String, Object> options) {

    SmartList<LevelThreeCategory> resultList =
        queryWith(
            LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY,
            levelTwoCategoryId,
            options,
            getLevelThreeCategoryMapper());
    // analyzeLevelThreeCategoryByParentCategory(resultList, levelTwoCategoryId, options);
    return resultList;
  }

  public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(
      String levelTwoCategoryId, int start, int count, Map<String, Object> options) {

    SmartList<LevelThreeCategory> resultList =
        queryWithRange(
            LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY,
            levelTwoCategoryId,
            options,
            getLevelThreeCategoryMapper(),
            start,
            count);
    // analyzeLevelThreeCategoryByParentCategory(resultList, levelTwoCategoryId, options);
    return resultList;
  }

  public void analyzeLevelThreeCategoryByParentCategory(
      SmartList<LevelThreeCategory> resultList,
      String levelTwoCategoryId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countLevelThreeCategoryByParentCategory(
      String levelTwoCategoryId, Map<String, Object> options) {

    return countWith(LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options);
  }

  @Override
  public Map<String, Integer> countLevelThreeCategoryByParentCategoryIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY, ids, options);
  }

  protected LevelThreeCategory saveLevelThreeCategory(LevelThreeCategory levelThreeCategory) {

    if (!levelThreeCategory.isChanged()) {
      return levelThreeCategory;
    }

    Beans.dbUtil().cacheCleanUp(levelThreeCategory);
    String SQL = this.getSaveLevelThreeCategorySQL(levelThreeCategory);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveLevelThreeCategoryParameters(levelThreeCategory);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    levelThreeCategory.incVersion();
    levelThreeCategory.afterSave();
    return levelThreeCategory;
  }

  public SmartList<LevelThreeCategory> saveLevelThreeCategoryList(
      SmartList<LevelThreeCategory> levelThreeCategoryList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitLevelThreeCategoryList(levelThreeCategoryList);

    batchLevelThreeCategoryCreate((List<LevelThreeCategory>) lists[CREATE_LIST_INDEX]);
    batchLevelThreeCategoryUpdate((List<LevelThreeCategory>) lists[UPDATE_LIST_INDEX]);
    batchLevelThreeCategoryRemove((List<LevelThreeCategory>) lists[REMOVE_LIST_INDEX]);
    batchLevelThreeCategoryRecover((List<LevelThreeCategory>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (LevelThreeCategory levelThreeCategory : levelThreeCategoryList) {
      if (levelThreeCategory.isChanged()) {
        levelThreeCategory.incVersion();
        levelThreeCategory.afterSave();
      }
      if (levelThreeCategory.isToRecover() || levelThreeCategory.isToRemove()) {
        levelThreeCategory.setVersion(-levelThreeCategory.getVersion());
      }
    }

    return levelThreeCategoryList;
  }

  public SmartList<LevelThreeCategory> removeLevelThreeCategoryList(
      SmartList<LevelThreeCategory> levelThreeCategoryList, Map<String, Object> options) {

    super.removeList(levelThreeCategoryList, options);

    return levelThreeCategoryList;
  }

  protected List<Object[]> prepareLevelThreeCategoryBatchCreateArgs(
      List<LevelThreeCategory> levelThreeCategoryList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (LevelThreeCategory levelThreeCategory : levelThreeCategoryList) {
      Object[] parameters = prepareLevelThreeCategoryCreateParameters(levelThreeCategory);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareLevelThreeCategoryBatchUpdateArgs(
      List<LevelThreeCategory> levelThreeCategoryList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (LevelThreeCategory levelThreeCategory : levelThreeCategoryList) {
      if (!levelThreeCategory.isChanged()) {
        continue;
      }
      Object[] parameters = prepareLevelThreeCategoryUpdateParameters(levelThreeCategory);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareLevelThreeCategoryBatchRecoverArgs(
      List<LevelThreeCategory> levelThreeCategoryList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (LevelThreeCategory levelThreeCategory : levelThreeCategoryList) {
      if (!levelThreeCategory.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(levelThreeCategory);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareLevelThreeCategoryBatchRemoveArgs(
      List<LevelThreeCategory> levelThreeCategoryList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (LevelThreeCategory levelThreeCategory : levelThreeCategoryList) {
      if (!levelThreeCategory.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareLevelThreeCategoryRemoveParameters(levelThreeCategory);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchLevelThreeCategoryCreate(List<LevelThreeCategory> levelThreeCategoryList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareLevelThreeCategoryBatchCreateArgs(levelThreeCategoryList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchLevelThreeCategoryUpdate(List<LevelThreeCategory> levelThreeCategoryList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareLevelThreeCategoryBatchUpdateArgs(levelThreeCategoryList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchLevelThreeCategoryRemove(List<LevelThreeCategory> levelThreeCategoryList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareLevelThreeCategoryBatchRemoveArgs(levelThreeCategoryList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchLevelThreeCategoryRecover(List<LevelThreeCategory> levelThreeCategoryList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareLevelThreeCategoryBatchRecoverArgs(levelThreeCategoryList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitLevelThreeCategoryList(List<LevelThreeCategory> levelThreeCategoryList) {

    List<LevelThreeCategory> levelThreeCategoryCreateList = new ArrayList<LevelThreeCategory>();
    List<LevelThreeCategory> levelThreeCategoryUpdateList = new ArrayList<LevelThreeCategory>();
    List<LevelThreeCategory> levelThreeCategoryRemoveList = new ArrayList<LevelThreeCategory>();
    List<LevelThreeCategory> levelThreeCategoryRecoverList = new ArrayList<LevelThreeCategory>();

    for (LevelThreeCategory levelThreeCategory : levelThreeCategoryList) {
      if (levelThreeCategory.isToRemove()) {
        levelThreeCategoryRemoveList.add(levelThreeCategory);
        continue;
      }
      if (levelThreeCategory.isToRecover()) {
        levelThreeCategoryRecoverList.add(levelThreeCategory);
        continue;
      }
      if (isUpdateRequest(levelThreeCategory)) {
        if (levelThreeCategory.isChanged()) {
          levelThreeCategoryUpdateList.add(levelThreeCategory);
        }
        continue;
      }

      if (levelThreeCategory.isChanged()) {
        levelThreeCategoryCreateList.add(levelThreeCategory);
      }
    }

    return new Object[] {
      levelThreeCategoryCreateList,
      levelThreeCategoryUpdateList,
      levelThreeCategoryRemoveList,
      levelThreeCategoryRecoverList
    };
  }

  protected boolean isUpdateRequest(LevelThreeCategory levelThreeCategory) {
    return levelThreeCategory.getVersion() > 0;
  }

  protected String getSaveLevelThreeCategorySQL(LevelThreeCategory levelThreeCategory) {
    if (levelThreeCategory.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(levelThreeCategory)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveLevelThreeCategoryParameters(LevelThreeCategory levelThreeCategory) {
    if (levelThreeCategory.isToRemove()) {
      return prepareLevelThreeCategoryRemoveParameters(levelThreeCategory);
    }
    if (levelThreeCategory.isToRecover()) {
      return prepareRecoverParameters(levelThreeCategory);
    }

    if (isUpdateRequest(levelThreeCategory)) {
      return prepareLevelThreeCategoryUpdateParameters(levelThreeCategory);
    }
    return prepareLevelThreeCategoryCreateParameters(levelThreeCategory);
  }

  protected Object[] prepareLevelThreeCategoryRemoveParameters(
      LevelThreeCategory levelThreeCategory) {
    return super.prepareRemoveParameters(levelThreeCategory);
  }

  protected Object[] prepareLevelThreeCategoryUpdateParameters(
      LevelThreeCategory levelThreeCategory) {
    Object[] parameters = new Object[5];

    if (levelThreeCategory.getParentCategory() != null) {
      parameters[0] = levelThreeCategory.getParentCategory().getId();
    }

    parameters[1] = levelThreeCategory.getName();

    parameters[2] = levelThreeCategory.nextVersion();
    parameters[3] = levelThreeCategory.getId();
    parameters[4] = levelThreeCategory.getVersion();

    return parameters;
  }

  protected Object[] prepareLevelThreeCategoryCreateParameters(
      LevelThreeCategory levelThreeCategory) {
    Object[] parameters = new Object[3];
    if (levelThreeCategory.getId() == null) {
      String newLevelThreeCategoryId = getNextId();
      levelThreeCategory.setId(newLevelThreeCategoryId);
    }
    parameters[0] = levelThreeCategory.getId();

    if (levelThreeCategory.getParentCategory() != null) {
      parameters[1] = levelThreeCategory.getParentCategory().getId();
    }

    parameters[2] = levelThreeCategory.getName();

    return parameters;
  }

  protected LevelThreeCategory saveInternalLevelThreeCategory(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    if (isSaveParentCategoryEnabled(options)) {
      saveParentCategory(levelThreeCategory, options);
    }

    saveLevelThreeCategory(levelThreeCategory);

    if (isSaveProductListEnabled(options)) {
      saveProductList(levelThreeCategory, options);
      // removeProductList(levelThreeCategory, options);
      // Not delete the record

    }

    return levelThreeCategory;
  }

  // ======================================================================================

  protected LevelThreeCategory saveParentCategory(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (levelThreeCategory.getParentCategory() == null) {
      return levelThreeCategory; // do nothing when it is null
    }

    getLevelTwoCategoryDAO().save(levelThreeCategory.getParentCategory(), options);
    return levelThreeCategory;
  }

  public LevelThreeCategory planToRemoveProductList(
      LevelThreeCategory levelThreeCategory, String productIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Product.PARENT_CATEGORY_PROPERTY, levelThreeCategory.getId());
    key.put(Product.ID_PROPERTY, productIds);

    SmartList<Product> externalProductList = getProductDAO().findProductWithKey(key, options);
    if (externalProductList == null) {
      return levelThreeCategory;
    }
    if (externalProductList.isEmpty()) {
      return levelThreeCategory;
    }

    for (Product productItem : externalProductList) {

      productItem.clearFromAll();
    }

    SmartList<Product> productList = levelThreeCategory.getProductList();
    productList.addAllToRemoveList(externalProductList);
    return levelThreeCategory;
  }

  protected LevelThreeCategory saveProductList(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    SmartList<Product> productList = levelThreeCategory.getProductList();
    if (productList == null) {
      // null list means nothing
      return levelThreeCategory;
    }
    SmartList<Product> mergedUpdateProductList = new SmartList<Product>();

    mergedUpdateProductList.addAll(productList);
    if (productList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateProductList.addAll(productList.getToRemoveList());
      productList.removeAll(productList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getProductDAO().saveProductList(mergedUpdateProductList, options);

    if (productList.getToRemoveList() != null) {
      productList.removeAll(productList.getToRemoveList());
    }

    return levelThreeCategory;
  }

  protected LevelThreeCategory removeProductList(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    SmartList<Product> productList = levelThreeCategory.getProductList();
    if (productList == null) {
      return levelThreeCategory;
    }

    SmartList<Product> toRemoveProductList = productList.getToRemoveList();

    if (toRemoveProductList == null) {
      return levelThreeCategory;
    }
    if (toRemoveProductList.isEmpty()) {
      return levelThreeCategory; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getProductDAO().removeProductList(toRemoveProductList, options);

    return levelThreeCategory;
  }

  public LevelThreeCategory present(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    presentProductList(levelThreeCategory, options);

    return levelThreeCategory;
  }

  // Using java8 feature to reduce the code significantly
  protected LevelThreeCategory presentProductList(
      LevelThreeCategory levelThreeCategory, Map<String, Object> options) {

    SmartList<Product> productList = levelThreeCategory.getProductList();
    SmartList<Product> newList =
        presentSubList(
            levelThreeCategory.getId(),
            productList,
            options,
            getProductDAO()::countProductByParentCategory,
            getProductDAO()::findProductByParentCategory);

    levelThreeCategory.setProductList(newList);

    return levelThreeCategory;
  }

  public SmartList<LevelThreeCategory> requestCandidateLevelThreeCategoryForProduct(
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
        LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY,
        LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY,
        filterKey,
        pageNo,
        pageSize,
        getLevelThreeCategoryMapper());
  }

  protected String getTableName() {
    return LevelThreeCategoryTable.TABLE_NAME;
  }

  public void enhanceList(List<LevelThreeCategory> levelThreeCategoryList) {
    this.enhanceListInternal(levelThreeCategoryList, this.getLevelThreeCategoryMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<LevelThreeCategory> levelThreeCategoryList =
        ownerEntity.collectRefsWithType(LevelThreeCategory.INTERNAL_TYPE);
    this.enhanceList(levelThreeCategoryList);
  }

  @Override
  public SmartList<LevelThreeCategory> findLevelThreeCategoryWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getLevelThreeCategoryMapper());
  }

  @Override
  public int countLevelThreeCategoryWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countLevelThreeCategoryWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<LevelThreeCategory> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getLevelThreeCategoryMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<LevelThreeCategory> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getLevelThreeCategoryMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateLevelThreeCategory executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateLevelThreeCategory result = new CandidateLevelThreeCategory();
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
  public List<LevelThreeCategory> search(LevelThreeCategoryRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected LevelThreeCategoryMapper mapper() {
    return getLevelThreeCategoryMapper();
  }

  @Override
  protected LevelThreeCategoryMapper mapperForClazz(Class<?> clazz) {
    return LevelThreeCategoryMapper.mapperForClass(clazz);
  }
}
