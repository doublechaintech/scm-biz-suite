package com.doublechaintech.retailscm.productsupplyduration;

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

import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

import com.doublechaintech.retailscm.supplierproduct.SupplierProductDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ProductSupplyDurationJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements ProductSupplyDurationDAO {

  protected SupplierProductDAO supplierProductDAO;

  public void setSupplierProductDAO(SupplierProductDAO supplierProductDAO) {

    if (supplierProductDAO == null) {
      throw new IllegalStateException("Do not try to set supplierProductDAO to null.");
    }
    this.supplierProductDAO = supplierProductDAO;
  }

  public SupplierProductDAO getSupplierProductDAO() {
    if (this.supplierProductDAO == null) {
      throw new IllegalStateException(
          "The supplierProductDAO is not configured yet, please config it some where.");
    }

    return this.supplierProductDAO;
  }

  /*
  protected ProductSupplyDuration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalProductSupplyDuration(accessKey, options);
  }
  */

  public SmartList<ProductSupplyDuration> loadAll() {
    return this.loadAll(getProductSupplyDurationMapper());
  }

  public Stream<ProductSupplyDuration> loadAllAsStream() {
    return this.loadAllAsStream(getProductSupplyDurationMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public ProductSupplyDuration load(String id, Map<String, Object> options) throws Exception {
    return loadInternalProductSupplyDuration(ProductSupplyDurationTable.withId(id), options);
  }

  public ProductSupplyDuration save(
      ProductSupplyDuration productSupplyDuration, Map<String, Object> options) {

    String methodName =
        "save(ProductSupplyDuration productSupplyDuration,Map<String,Object> options)";

    assertMethodArgumentNotNull(productSupplyDuration, methodName, "productSupplyDuration");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalProductSupplyDuration(productSupplyDuration, options);
  }

  public ProductSupplyDuration clone(String productSupplyDurationId, Map<String, Object> options)
      throws Exception {

    return clone(ProductSupplyDurationTable.withId(productSupplyDurationId), options);
  }

  protected ProductSupplyDuration clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String productSupplyDurationId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    ProductSupplyDuration newProductSupplyDuration =
        loadInternalProductSupplyDuration(accessKey, options);
    newProductSupplyDuration.setVersion(0);

    saveInternalProductSupplyDuration(newProductSupplyDuration, options);

    return newProductSupplyDuration;
  }

  protected void throwIfHasException(String productSupplyDurationId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new ProductSupplyDurationVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new ProductSupplyDurationNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + productSupplyDurationId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public ProductSupplyDuration disconnectFromAll(String productSupplyDurationId, int version)
      throws Exception {

    ProductSupplyDuration productSupplyDuration =
        loadInternalProductSupplyDuration(
            ProductSupplyDurationTable.withId(productSupplyDurationId), emptyOptions());
    productSupplyDuration.clearFromAll();
    this.saveProductSupplyDuration(productSupplyDuration);
    return productSupplyDuration;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return ProductSupplyDurationTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "product_supply_duration";
  }

  @Override
  protected String getBeanName() {

    return "productSupplyDuration";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return ProductSupplyDurationTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractProductEnabled(Map<String, Object> options) {

    return checkOptions(options, ProductSupplyDurationTokens.PRODUCT);
  }

  protected boolean isSaveProductEnabled(Map<String, Object> options) {

    return checkOptions(options, ProductSupplyDurationTokens.PRODUCT);
  }

  protected ProductSupplyDurationMapper getProductSupplyDurationMapper() {
    return new ProductSupplyDurationMapper();
  }

  protected ProductSupplyDuration extractProductSupplyDuration(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      ProductSupplyDuration productSupplyDuration =
          loadSingleObject(accessKey, getProductSupplyDurationMapper());
      return productSupplyDuration;
    } catch (EmptyResultDataAccessException e) {
      throw new ProductSupplyDurationNotFoundException(
          "ProductSupplyDuration(" + accessKey + ") is not found!");
    }
  }

  protected ProductSupplyDuration loadInternalProductSupplyDuration(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    ProductSupplyDuration productSupplyDuration =
        extractProductSupplyDuration(accessKey, loadOptions);

    if (isExtractProductEnabled(loadOptions)) {
      extractProduct(productSupplyDuration, loadOptions);
    }

    return productSupplyDuration;
  }

  protected ProductSupplyDuration extractProduct(
      ProductSupplyDuration productSupplyDuration, Map<String, Object> options) throws Exception {

    if (productSupplyDuration.getProduct() == null) {
      return productSupplyDuration;
    }
    String productId = productSupplyDuration.getProduct().getId();
    if (productId == null) {
      return productSupplyDuration;
    }
    SupplierProduct product = getSupplierProductDAO().load(productId, options);
    if (product != null) {
      productSupplyDuration.setProduct(product);
    }

    return productSupplyDuration;
  }

  public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(
      String supplierProductId, Map<String, Object> options) {

    SmartList<ProductSupplyDuration> resultList =
        queryWith(
            ProductSupplyDurationTable.COLUMN_PRODUCT,
            supplierProductId,
            options,
            getProductSupplyDurationMapper());
    // analyzeProductSupplyDurationByProduct(resultList, supplierProductId, options);
    return resultList;
  }

  public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(
      String supplierProductId, int start, int count, Map<String, Object> options) {

    SmartList<ProductSupplyDuration> resultList =
        queryWithRange(
            ProductSupplyDurationTable.COLUMN_PRODUCT,
            supplierProductId,
            options,
            getProductSupplyDurationMapper(),
            start,
            count);
    // analyzeProductSupplyDurationByProduct(resultList, supplierProductId, options);
    return resultList;
  }

  public void analyzeProductSupplyDurationByProduct(
      SmartList<ProductSupplyDuration> resultList,
      String supplierProductId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countProductSupplyDurationByProduct(
      String supplierProductId, Map<String, Object> options) {

    return countWith(ProductSupplyDurationTable.COLUMN_PRODUCT, supplierProductId, options);
  }

  @Override
  public Map<String, Integer> countProductSupplyDurationByProductIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(ProductSupplyDurationTable.COLUMN_PRODUCT, ids, options);
  }

  protected ProductSupplyDuration saveProductSupplyDuration(
      ProductSupplyDuration productSupplyDuration) {

    if (!productSupplyDuration.isChanged()) {
      return productSupplyDuration;
    }

    Beans.dbUtil().cacheCleanUp(productSupplyDuration);
    String SQL = this.getSaveProductSupplyDurationSQL(productSupplyDuration);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveProductSupplyDurationParameters(productSupplyDuration);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    productSupplyDuration.incVersion();
    productSupplyDuration.afterSave();
    return productSupplyDuration;
  }

  public SmartList<ProductSupplyDuration> saveProductSupplyDurationList(
      SmartList<ProductSupplyDuration> productSupplyDurationList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitProductSupplyDurationList(productSupplyDurationList);

    batchProductSupplyDurationCreate((List<ProductSupplyDuration>) lists[CREATE_LIST_INDEX]);
    batchProductSupplyDurationUpdate((List<ProductSupplyDuration>) lists[UPDATE_LIST_INDEX]);
    batchProductSupplyDurationRemove((List<ProductSupplyDuration>) lists[REMOVE_LIST_INDEX]);
    batchProductSupplyDurationRecover((List<ProductSupplyDuration>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      if (productSupplyDuration.isChanged()) {
        productSupplyDuration.incVersion();
        productSupplyDuration.afterSave();
      }
      if (productSupplyDuration.isToRecover() || productSupplyDuration.isToRemove()) {
        productSupplyDuration.setVersion(-productSupplyDuration.getVersion());
      }
    }

    return productSupplyDurationList;
  }

  public SmartList<ProductSupplyDuration> removeProductSupplyDurationList(
      SmartList<ProductSupplyDuration> productSupplyDurationList, Map<String, Object> options) {

    super.removeList(productSupplyDurationList, options);

    return productSupplyDurationList;
  }

  protected List<Object[]> prepareProductSupplyDurationBatchCreateArgs(
      List<ProductSupplyDuration> productSupplyDurationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      Object[] parameters = prepareProductSupplyDurationCreateParameters(productSupplyDuration);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareProductSupplyDurationBatchUpdateArgs(
      List<ProductSupplyDuration> productSupplyDurationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      if (!productSupplyDuration.isChanged()) {
        continue;
      }
      Object[] parameters = prepareProductSupplyDurationUpdateParameters(productSupplyDuration);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareProductSupplyDurationBatchRecoverArgs(
      List<ProductSupplyDuration> productSupplyDurationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      if (!productSupplyDuration.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(productSupplyDuration);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareProductSupplyDurationBatchRemoveArgs(
      List<ProductSupplyDuration> productSupplyDurationList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      if (!productSupplyDuration.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareProductSupplyDurationRemoveParameters(productSupplyDuration);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchProductSupplyDurationCreate(
      List<ProductSupplyDuration> productSupplyDurationList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareProductSupplyDurationBatchCreateArgs(productSupplyDurationList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchProductSupplyDurationUpdate(
      List<ProductSupplyDuration> productSupplyDurationList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareProductSupplyDurationBatchUpdateArgs(productSupplyDurationList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchProductSupplyDurationRemove(
      List<ProductSupplyDuration> productSupplyDurationList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareProductSupplyDurationBatchRemoveArgs(productSupplyDurationList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchProductSupplyDurationRecover(
      List<ProductSupplyDuration> productSupplyDurationList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareProductSupplyDurationBatchRecoverArgs(productSupplyDurationList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitProductSupplyDurationList(
      List<ProductSupplyDuration> productSupplyDurationList) {

    List<ProductSupplyDuration> productSupplyDurationCreateList =
        new ArrayList<ProductSupplyDuration>();
    List<ProductSupplyDuration> productSupplyDurationUpdateList =
        new ArrayList<ProductSupplyDuration>();
    List<ProductSupplyDuration> productSupplyDurationRemoveList =
        new ArrayList<ProductSupplyDuration>();
    List<ProductSupplyDuration> productSupplyDurationRecoverList =
        new ArrayList<ProductSupplyDuration>();

    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      if (productSupplyDuration.isToRemove()) {
        productSupplyDurationRemoveList.add(productSupplyDuration);
        continue;
      }
      if (productSupplyDuration.isToRecover()) {
        productSupplyDurationRecoverList.add(productSupplyDuration);
        continue;
      }
      if (isUpdateRequest(productSupplyDuration)) {
        if (productSupplyDuration.isChanged()) {
          productSupplyDurationUpdateList.add(productSupplyDuration);
        }
        continue;
      }

      if (productSupplyDuration.isChanged()) {
        productSupplyDurationCreateList.add(productSupplyDuration);
      }
    }

    return new Object[] {
      productSupplyDurationCreateList,
      productSupplyDurationUpdateList,
      productSupplyDurationRemoveList,
      productSupplyDurationRecoverList
    };
  }

  protected boolean isUpdateRequest(ProductSupplyDuration productSupplyDuration) {
    return productSupplyDuration.getVersion() > 0;
  }

  protected String getSaveProductSupplyDurationSQL(ProductSupplyDuration productSupplyDuration) {
    if (productSupplyDuration.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(productSupplyDuration)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveProductSupplyDurationParameters(
      ProductSupplyDuration productSupplyDuration) {
    if (productSupplyDuration.isToRemove()) {
      return prepareProductSupplyDurationRemoveParameters(productSupplyDuration);
    }
    if (productSupplyDuration.isToRecover()) {
      return prepareRecoverParameters(productSupplyDuration);
    }

    if (isUpdateRequest(productSupplyDuration)) {
      return prepareProductSupplyDurationUpdateParameters(productSupplyDuration);
    }
    return prepareProductSupplyDurationCreateParameters(productSupplyDuration);
  }

  protected Object[] prepareProductSupplyDurationRemoveParameters(
      ProductSupplyDuration productSupplyDuration) {
    return super.prepareRemoveParameters(productSupplyDuration);
  }

  protected Object[] prepareProductSupplyDurationUpdateParameters(
      ProductSupplyDuration productSupplyDuration) {
    Object[] parameters = new Object[7];

    parameters[0] = productSupplyDuration.getQuantity();

    parameters[1] = productSupplyDuration.getDuration();

    parameters[2] = productSupplyDuration.getPrice();

    if (productSupplyDuration.getProduct() != null) {
      parameters[3] = productSupplyDuration.getProduct().getId();
    }

    parameters[4] = productSupplyDuration.nextVersion();
    parameters[5] = productSupplyDuration.getId();
    parameters[6] = productSupplyDuration.getVersion();

    return parameters;
  }

  protected Object[] prepareProductSupplyDurationCreateParameters(
      ProductSupplyDuration productSupplyDuration) {
    Object[] parameters = new Object[5];
    if (productSupplyDuration.getId() == null) {
      String newProductSupplyDurationId = getNextId();
      productSupplyDuration.setId(newProductSupplyDurationId);
    }
    parameters[0] = productSupplyDuration.getId();

    parameters[1] = productSupplyDuration.getQuantity();

    parameters[2] = productSupplyDuration.getDuration();

    parameters[3] = productSupplyDuration.getPrice();

    if (productSupplyDuration.getProduct() != null) {
      parameters[4] = productSupplyDuration.getProduct().getId();
    }

    return parameters;
  }

  protected ProductSupplyDuration saveInternalProductSupplyDuration(
      ProductSupplyDuration productSupplyDuration, Map<String, Object> options) {

    if (isSaveProductEnabled(options)) {
      saveProduct(productSupplyDuration, options);
    }

    saveProductSupplyDuration(productSupplyDuration);

    return productSupplyDuration;
  }

  // ======================================================================================

  protected ProductSupplyDuration saveProduct(
      ProductSupplyDuration productSupplyDuration, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (productSupplyDuration.getProduct() == null) {
      return productSupplyDuration; // do nothing when it is null
    }

    getSupplierProductDAO().save(productSupplyDuration.getProduct(), options);
    return productSupplyDuration;
  }

  public ProductSupplyDuration present(
      ProductSupplyDuration productSupplyDuration, Map<String, Object> options) {

    return productSupplyDuration;
  }

  protected String getTableName() {
    return ProductSupplyDurationTable.TABLE_NAME;
  }

  public void enhanceList(List<ProductSupplyDuration> productSupplyDurationList) {
    this.enhanceListInternal(productSupplyDurationList, this.getProductSupplyDurationMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<ProductSupplyDuration> productSupplyDurationList =
        ownerEntity.collectRefsWithType(ProductSupplyDuration.INTERNAL_TYPE);
    this.enhanceList(productSupplyDurationList);
  }

  @Override
  public SmartList<ProductSupplyDuration> findProductSupplyDurationWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getProductSupplyDurationMapper());
  }

  @Override
  public int countProductSupplyDurationWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countProductSupplyDurationWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<ProductSupplyDuration> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getProductSupplyDurationMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<ProductSupplyDuration> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getProductSupplyDurationMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateProductSupplyDuration executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateProductSupplyDuration result = new CandidateProductSupplyDuration();
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
  public List<ProductSupplyDuration> search(ProductSupplyDurationRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected ProductSupplyDurationMapper mapper() {
    return getProductSupplyDurationMapper();
  }

  @Override
  protected ProductSupplyDurationMapper mapperForClazz(Class<?> clazz) {
    return ProductSupplyDurationMapper.mapperForClass(clazz);
  }
}
