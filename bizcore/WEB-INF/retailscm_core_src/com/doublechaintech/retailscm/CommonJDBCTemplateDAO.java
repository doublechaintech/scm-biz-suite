package com.doublechaintech.retailscm;

import com.doublechaintech.retailscm.search.*;
import static com.doublechaintech.retailscm.search.SqlBuilder.prepareFullDataSql;
import static com.doublechaintech.retailscm.search.SqlBuilder.prepareParametersAndCondition;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.terapico.utils.TextUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class CommonJDBCTemplateDAO extends BaseEntity {

  public static final String USER_CONTEXT = "userContext";
  public static final String AGGREGATIONS = "aggregations";

  public <T extends BaseEntity> List<T> searchInternal(BaseRequest<T> pRequest) {
    if (pRequest.isEmpty()) {
      return Collections.emptyList();
    }
    Map<String, Object> parameters = new HashMap<>();
    parameters.put(USER_CONTEXT, pRequest.getUserContext());
    String condition = prepareParametersAndCondition(pRequest, parameters);

    SmartList<T> ret = new SmartList<>();
    doQueryDataList(pRequest, condition, parameters, ret);
    enhanceWithAggregation(pRequest, condition, parameters, ret);
    enhanceWithDynamicAttributes(pRequest, condition, parameters, ret);
    return ret;
  }

  private <T extends BaseEntity> void enhanceWithDynamicAttributes(
      BaseRequest<T> request, String condition, Map<String, Object> parameters, SmartList<T> ret) {
    List<DynamicAttributeRequest> dynamicAttributes = request.getDynamicAttributes();
    if (ObjectUtil.isEmpty(dynamicAttributes)) {
      return;
    }

    if (ObjectUtil.isEmpty(ret)) {
      return;
    }

    Map<String, T> IdItemMapping = CollectionUtil.toMap(ret, new HashMap<>(), BaseEntity::getId);

    for (DynamicAttributeRequest dynamicAttribute : dynamicAttributes) {
      String dynamicAttributeName = dynamicAttribute.getName();
      dynamicAttribute
          .getRequest()
          .doAddSearchCriteria(
              new SimplePropertyCriteria(
                  dynamicAttribute.getParentProperty(), QueryOperator.IN, ret));
      // 不需要数据
      dynamicAttribute.getRequest().setSize(0);

      // 增加parent的group by
      dynamicAttribute.getRequest().groupBy(dynamicAttribute.getParentProperty());

      AggregationResult aggregation =
          Searcher.aggregation(request.getUserContext(), dynamicAttribute.getRequest());

      if (ObjectUtil.isEmpty(aggregation)) {
        continue;
      }

      List<AggregationItem> data = aggregation.getData();
      if (ObjectUtil.isEmpty(data)) {
        continue;
      }

      for (AggregationItem datum : data) {
        Map<String, String> dimensions = new LinkedHashMap<>(datum.getDimensions());
        String parentId = dimensions.remove(dynamicAttribute.getParentProperty());
        if (parentId == null) {
          continue;
        }

        T parent = IdItemMapping.get(parentId);
        if (parent == null) {
          continue;
        }

        String attributeName = dynamicAttributeName;
        if (!ObjectUtil.isEmpty(dimensions)) {
          for (String v : dimensions.values()) {
            attributeName = attributeName + ":" + v;
          }
        }
        parent.appendDynamicProperty(
            attributeName, CollectionUtil.getFirst(datum.getValues().values()));
      }
    }
  }

  private void enhanceWithAggregation(
      BaseRequest request, String condition, Map<String, Object> parameters, BaseEntity bindPoint) {
    List<AggregationContext> aggregations = findAggregations(request, condition, parameters);
    for (AggregationContext aggregation : aggregations) {
      handleGroupBy(aggregation, bindPoint);
    }
  }

  private void handleGroupBy(AggregationContext aggregation, BaseEntity ret) {
    BaseRequest request = aggregation.getRequest();
    if (!request.hasSimpleAgg()) {
      return;
    }
    List<AggregationItem> aggregationResults =
        getAggregationResults(request, aggregation.getPreCondition(), aggregation.getParameters());
    if (request.hasComplexGroupBy()) {
      List<String> toBeRemoveDimensions = new ArrayList<>();
      advanceGroupBy(request.getGroupBys(), aggregationResults, toBeRemoveDimensions);
      Map<Map<String, String>, AggregationItem> resultMap = new HashMap<>();
      for (AggregationItem aggregationResult : aggregationResults) {
        MapUtil.removeAny(
            aggregationResult.getDimensions(),
            toBeRemoveDimensions.toArray(new String[toBeRemoveDimensions.size()]));
        Map<String, String> dimensions = aggregationResult.getDimensions();
        AggregationItem existed = resultMap.get(dimensions);
        if (existed == null) {
          resultMap.put(dimensions, aggregationResult);
          continue;
        }

        Map<String, Object> values = existed.getValues();
        Map<String, Object> newValue = aggregationResult.getValues();
        existed.setValues(merge(request, values, newValue));
      }

      aggregationResults = new ArrayList<>(resultMap.values());
    }

    addAggregationResult(ret, request.getAggregationName(), aggregationResults);
  }

  private void addAggregationResult(
      BaseEntity ret, String aggregationName, List<AggregationItem> aggregationItems) {
    List<AggregationResult> results = (List<AggregationResult>) ret.valueByKey(AGGREGATIONS);
    if (results == null) {
      results = new ArrayList<>();
      ret.addItemToValueMap(AGGREGATIONS, results);
    }

    AggregationResult result = new AggregationResult();
    results.add(result);
    result.setName(aggregationName);
    result.setData(aggregationItems);
  }

  private Map<String, Object> merge(
      BaseRequest request, Map<String, Object> pValues, Map<String, Object> pNewValue) {
    Map<String, Object> ret = new HashMap<>();
    pValues.forEach(
        (k, v) -> {
          Object o = pNewValue.get(k);
          ret.put(k, merge(request.getFunc(k), v, o));
        });
    return ret;
  }

  private Object merge(AggFunc func, Object v1, Object v2) {
    return func.merge(v1, v2);
  }

  private void advanceGroupBy(
      Map<String, BaseRequest> groupBys,
      List<AggregationItem> results,
      List<String> toBeRemoveDimensions) {
    if (groupBys.isEmpty()) {
      return;
    }
    if (results.isEmpty()) {
      return;
    }
    for (Map.Entry<String, BaseRequest> entry : groupBys.entrySet()) {
      String k = entry.getKey();
      BaseRequest v = entry.getValue();
      List<String> groupSelects = v.getAggregation().getGroupSelects();
      if (!groupSelects.isEmpty()) {
        toBeRemoveDimensions.add(k);
        String sql =
            String.format(
                "SELECT id,%s FROM %s WHERE id in (:ids)",
                CollectionUtil.join(groupSelects, ","), getTableName(v));
        Map<String, Object> params = new HashMap<>();
        params.put("ids", groupValues(results, k));

        // SQLLogger.logDebug("group by sql:" + sql);
        // logParameters(params);
        List<Map<String, String>> list =
            Beans.namedParameterJdbcTemplate().query(sql, params, new AggregationGroupByMapper());
        enhanceAggWithGroup(results, list, k);
      }
      advanceGroupBy(v.getGroupBys(), results, toBeRemoveDimensions);
    }
  }

  private List<AggregationItem> enhanceAggWithGroup(
      List<AggregationItem> results, List<Map<String, String>> list, String idProperty) {
    Map<String, Map<String, String>> toMap = new HashMap<>();
    for (Map<String, String> d : list) {
      String id = d.remove("id");
      toMap.put(id, d);
    }

    for (AggregationItem result : results) {
      String id = result.group(idProperty);
      result.getDimensions().putAll(toMap.get(id));
    }
    return results;
  }

  private List<String> groupValues(List<AggregationItem> results, String property) {
    if (results.isEmpty()) {
      return Collections.emptyList();
    }
    return results.stream().map(r -> r.group(property)).collect(Collectors.toList());
  }

  private List<AggregationContext> findAggregations(
      BaseRequest request, String condition, Map<String, Object> parameters) {
    List<AggregationContext> ret = new ArrayList<>();
    if (request.hasSimpleAgg()) {
      AggregationContext context = new AggregationContext();
      context.setParameters(new HashMap<>(parameters));
      context.setRequest(request);
      context.setPreCondition(condition);
      ret.add(context);
    }

    if (request.hasComplexAgg()) {
      Map<String, BaseRequest> parentAggregations = request.getParentAggregations();
      parentAggregations.forEach(
          (k, v) -> {
            if (!v.hasAgg()) {
              return;
            }
            List<String> ids = searchParentIds(request, condition, k, parameters);
            if (CollectionUtil.isEmpty(ids)) {
              return;
            }
            Map<String, Object> parentParameters = new HashMap<>();
            String parentCondition = prepareParametersAndCondition(v, parentParameters);
            String finalParentCondition = "id in (:current_ids)";
            parentParameters.put("current_ids", ids);
            if (!StrUtil.isEmpty(parentCondition)) {
              finalParentCondition = finalParentCondition + " and " + parentCondition;
            }
            List<AggregationContext> aggregations =
                findAggregations(v, finalParentCondition, parentParameters);
            ret.addAll(aggregations);
          });

      Map<String, BaseRequest> childrenAggregations = request.getChildrenAggregations();
      childrenAggregations.forEach(
          (k, v) -> {
            if (!v.hasAgg()) {
              return;
            }
            List<String> ids = searchCurrentIds(request, condition, parameters);
            if (CollectionUtil.isEmpty(ids)) {
              return;
            }
            Map<String, Object> childrenParameters = new HashMap<>();
            String childCondition = prepareParametersAndCondition(v, childrenParameters);
            String finalChildCondition =
                String.format(
                    "%s in (:current_ids)",
                    StrUtil.toUnderlineCase(StrUtil.removePrefix(k, v.getInternalType())));
            childrenParameters.put("current_ids", ids);
            if (!StrUtil.isEmpty(childCondition)) {
              finalChildCondition = finalChildCondition + " and " + childCondition;
            }
            List<AggregationContext> aggregations =
                findAggregations(v, finalChildCondition, childrenParameters);
            ret.addAll(aggregations);
          });
    }

    return ret;
  }

  private List<String> searchCurrentIds(
      BaseRequest request, String condition, Map<String, Object> parameters) {
    String sql = String.format("select id from %s", getTableName(request));
    if (!StrUtil.isEmpty(condition)) {
      sql = sql + " where " + condition;
    }
    // SQLLogger.logDebug("findAggregation sql:" + sql);
    Map<String, Object> refinedParameters = new HashMap<>(parameters);
    refinedParameters.remove(USER_CONTEXT);
    // logParameters(refinedParameters);
    return Beans.namedParameterJdbcTemplate().queryForList(sql, refinedParameters, String.class);
  }

  private List<String> searchParentIds(
      BaseRequest request,
      String parentCondition,
      String parentProperty,
      Map<String, Object> parameters) {
    String sql =
        String.format(
            "select %s from %s", StrUtil.toUnderlineCase(parentProperty), getTableName(request));
    if (!StrUtil.isEmpty(parentCondition)) {
      sql = sql + " where " + parentCondition;
    }

    SQLLogger.logDebug("findAggregation sql:" + sql);

    Map<String, Object> refinedParameters = new HashMap<>(parameters);
    refinedParameters.remove(USER_CONTEXT);
    logParameters(refinedParameters);
    return Beans.namedParameterJdbcTemplate().queryForList(sql, refinedParameters, String.class);
  }

  private <T extends BaseEntity> void doQueryDataList(
      BaseRequest pRequest, String condition, Map<String, Object> parameters, SmartList<T> ret) {
    if (!pRequest.hasDataQuery()) {
      return;
    }

    if ("false".equalsIgnoreCase(condition) || "0".equalsIgnoreCase(condition)) {
      SQLLogger.logDebug("搜索条件为false,无结果集");
      return;
    }

    String sql = prepareFullDataSql(pRequest, condition);
    if (sql == null) {
      return;
    }
    // logDebug("data sql:" + sql);
    Map<String, Object> refinedParameters = new HashMap<>(parameters);
    refinedParameters.remove(USER_CONTEXT);
    // logParameters(refinedParameters);
    List<T> list =
        Beans.namedParameterJdbcTemplate()
            .query(sql, refinedParameters, mapperFromRequest(pRequest));

    ret.addAll(list);
  }

  protected RowMapper mapperFromRequest(BaseRequest pRequest) {

    if (pRequest.getClazz() == null) {
      return mapper();
    }
    return mapperForClazz(pRequest.getClazz());
  }

  private void logParameters(Map<String, Object> refinedParameters) {
    try {
      SQLLogger.logDebug("parameters:" + paramExprOf(refinedParameters));
    } catch (Exception pE) {
      pE.printStackTrace();
    }
  }

  protected String wrapArray(Object arrayObject) {
    int length = ArrayUtil.length(arrayObject);

    if (length <= 20) {
      return String.format("%d items ) %s(%d)", length, arrayObject.toString());
    }

    return String.format(
        "(%d items ) %s ... %s ",
        length,
        ArrayUtil.sub(arrayObject, 0, 10).toString(),
        ArrayUtil.sub(arrayObject, length - 1, -10).toString());
  }

  protected String wrapCollection(Collection collectionObject) {
    int length = collectionObject.size();
    Object[] arrayObject = collectionObject.toArray();
    if (length <= 20) {
      return String.format("(%d items) %s", length, collectionObject.toString());
    }

    return String.format(
        "(%d items ) %s ... %s ",
        length,
        CollectionUtil.sub(collectionObject, 0, 10).toString(),
        CollectionUtil.sub(collectionObject, length - 1, -10).toString());
  }

  protected String paramExprOf(Map<String, Object> refinedParameters) {

    return refinedParameters.entrySet().stream()
        .map(
            e -> {
              if (ArrayUtil.isArray(e.getValue())) {
                return String.format("\n\t\t%s: %s", e.getKey(), wrapArray(e.getValue()));
              }

              if (e.getValue() instanceof Collection) {
                return String.format(
                    "\n\t\t%s: %s", e.getKey(), wrapCollection((Collection) e.getValue()));
              }

              return String.format(
                  "\n\t\t%s: %s ", e.getKey(), SQLLogger.wrapValueInSQL(e.getValue()));
            })
        .collect(Collectors.joining(""));
  }

  private List<AggregationItem> getAggregationResults(
      BaseRequest request, String condition, Map<String, Object> parameters) {
    Aggregation aggregation = request.getAggregation();
    List<String> aggColumns = aggregation.getAggSelects();
    String aggSelects = aggColumns.stream().collect(Collectors.joining(","));

    List<String> groupColumns = aggregation.getGroupColumns();
    String groupBySelects = groupColumns.stream().collect(Collectors.joining(","));

    String sql = "SELECT ";
    sql = sql + aggSelects + "\n\t\t FROM " + getTableName(request);

    if (!StrUtil.isEmpty(condition)) {
      sql = sql + " WHERE " + condition;
    }

    if (!StrUtil.isEmpty(groupBySelects)) {
      sql = sql + "\n\t\t GROUP BY " + groupBySelects;
    }

    // SQLLogger.logDebug("aggregate sql:" + sql);
    Map<String, Object> refinedParameters = new HashMap<>(parameters);
    refinedParameters.remove(USER_CONTEXT);
    // logParameters(refinedParameters);

    List<AggregationItem> aggregationResults =
        Beans.namedParameterJdbcTemplate()
            .query(sql, refinedParameters, new AggregationItemMapper());

    return aggregationResults;
  }

  private String getTableName(BaseRequest request) {
    return StrUtil.toUnderlineCase(request.getInternalType()) + "_data";
  }

  protected RowMapper mapper() {
    return null;
  }

  protected RowMapper mapperForClazz(Class<?> clazz) {
    return null;
  }

  protected String getSelectAllSQL() {

    // return new String[]{"name","bize_order","card_number","billing_address"};
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from ");
    stringBuilder.append(this.getTableName());
    return stringBuilder.toString();
  }

  protected <T extends BaseEntity> SmartList<T> loadAll(RowMapper<T> mapper) {

    return this.queryForList(getSelectAllSQL(), new Object[] {}, mapper);
  }

  protected <T extends BaseEntity> Stream<T> loadAllAsStream(RowMapper<T> mapper) {
    return this.queryForStream(getSelectAllSQL(), new Object[] {}, mapper);
  }

  /** */
  private static final long serialVersionUID = 1L;

  private JdbcTemplate jdbcTemplate;

  protected <T extends BaseEntity> void handleNotFullFilled(
      Map<String, T> entityMap, List<T> databaseEntityList) {}

  public <T extends BaseEntity> void enhanceListInternal(List<T> entityList, RowMapper<T> mapper) {

    if (entityList == null) {
      // noting to be enhanced
      return;
    }

    if (entityList.isEmpty()) {
      // noting to be enhanced
      return;
    }
    // put id into a set
    Map<String, T> entityMap = new HashMap<String, T>();
    for (T entity : entityList) {
      if (entity == null) {
        continue;
      }
      if (entity.getId() == null) {
        continue;
      }
      entityMap.put(entity.getId(), entity);
    }
    Object idArray[] = entityMap.keySet().toArray();
    if (idArray.length < 1) {
      return;
    }
    String SQL =
        getListQuerySQL(
            idArray); // MySql does not support set array as parameter, meanwhile oracle and PgSQL
    // support it
    List<T> databaseEntityList = this.queryForList(SQL, entityMap.keySet().toArray(), mapper);
    if (databaseEntityList == null) {
      // found nothing
      return;
    }

    if (databaseEntityList.isEmpty()) {
      // found nothing
      return;
    }

    if (databaseEntityList.size() != idArray.length) {
      // some of the AvailableToken may not be fetched, just ignore, things are not perfect too!
      handleNotFullFilled(entityMap, databaseEntityList);
    }

    for (T entity : databaseEntityList) {
      if (entity == null) {
        continue;
      }
      if (entity.getId() == null) {
        continue;
      }
      entityMap.put(entity.getId(), entity);
    }

    // find and copy the value
    for (T entity : entityList) {
      if (entity == null) {
        continue;
      }
      if (entity.getId() == null) {
        continue;
      }
      T entityInMap = entityMap.get(entity.getId());
      // may missing the value;
      if (entityInMap == null) {
        // this is very strange, it means the database query has some big issue;
        // it means found something other than the expected value;
        continue;
      }

      entityInMap.copyTo((T) entity); // the entity has been filled;
      Beans.dbUtil().markEnhanced(entity);
    }
  }

  protected <T extends BaseEntity> SmartList<T> presentSubList(
      String ownerObjectId,
      SmartList<T> list,
      Map<String, Object> options,
      BiFunction<String, Map<String, Object>, Integer> countFunction,
      FourParameterFunction<String, Integer, Integer, Map<String, Object>, SmartList<T>>
          fillDataFromDBFunction) {

    if (list == null) {
      return null;
    }
    String targetObjectName = list.getListInternalName();
    int listSize = list.size();
    int rowsPerPage = rowsPerPageOf(targetObjectName, options);

    list.setRowsPerPage(rowsPerPage);

    if (listSize <= rowsPerPage) {
      // do not need to put a pagination object to it, it just fills out a page or less than a page
      return list;
    }
    int currentPage = currentPageNumberOf(targetObjectName, options);
    // page must be calculated with this step
    int count = listSize;
    if (listSize >= this.getMaxRows()) {
      // fix the count because the list is not a full list
      count = countFunction.apply(ownerObjectId, options);
      // need to be a method reference

    }

    int maxPageNumber = count / rowsPerPage + ((count % rowsPerPage == 0) ? 0 : 1);
    if (currentPage > maxPageNumber) {
      currentPage = maxPageNumber;
    }

    if (isCurrentPageInLoadedList(listSize, currentPage, rowsPerPage)) {

      // get a sub list from it
      int fromIndex = (currentPage - 1) * rowsPerPage;
      int toIndex = calcToIndex(listSize, currentPage, rowsPerPage);
      SmartList<T> sublist = list.subListOf(fromIndex, toIndex);
      sublist.setListInternalName(targetObjectName);
      sublist.setTotalCount(count);
      sublist.setCurrentPageNumber(currentPage);
      sublist.setRowsPerPage(rowsPerPage);
      sublist.setMetaInfo(list.getMetaInfo());
      sublist.setStatsInfo(list.getStatsInfo());
      return sublist;
      // bookCopy.setLossAssessmentRecordList(lossAssessmentRecordList);
      // return bookCopy;
    }
    int start = (currentPage - 1) * rowsPerPage;
    SmartList<T> newList = fillDataFromDBFunction.apply(ownerObjectId, start, rowsPerPage, options);
    newList.setListInternalName(targetObjectName);
    newList.setTotalCount(count);
    newList.setCurrentPageNumber(currentPage);
    newList.setRowsPerPage(rowsPerPage);
    newList.setMetaInfo(list.getMetaInfo());
    newList.setStatsInfo(list.getStatsInfo());
    return newList;
  }

  @FunctionalInterface
  public interface FourParameterFunction<P1, P2, P3, P4, R> {
    R apply(P1 p1, P2 p2, P3 p3, P4 p4);
  }

  public int getMaxRows() {
    return 1000;
  }

  protected Map<String, Object> emptyOptions() {
    return new HashMap<String, Object>();
  }

  public void resetNextId() {
    this.currentMax.set(-1L);
  }

  protected void handleDeleteOneError(String objectId, int version) throws Exception {
    // the version has been changed, the client should reload it and ensure
    // this can be deleted
    String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
    Object[] parameters = new Object[] {objectId};
    // int count = queryForObject(SQL, Integer.class, parameters);
    int count = this.queryInt(SQL, parameters);

    throwIfHasException(objectId, version, count);
  }

  protected void throwIfHasException(String objectId, int version, int count) throws Exception {}

  protected static final String DATABASE_PRODUCT_INFORMIX = "Informix Server".toLowerCase();
  protected static final String DATABASE_PRODUCT_GBASE = "GBase Server".toLowerCase();
  protected static final String DATABASE_PRODUCT_MYSQL = "MySQL".toLowerCase();
  protected static final String DATABASE_PRODUCT_PGSQL = "PostgreSQL".toLowerCase();
  protected static final String DATABASE_PRODUCT_ORACLE = "Oracle".toLowerCase();
  protected static final String DATABASE_PRODUCT_MSSQL = "Microsoft SQL Server".toLowerCase();
  protected static final String DATABASE_PRODUCT_H2 = "H2".toLowerCase();

  protected String wrapRangeQuery(String body) {

    if (getDatabaseProductName().equals(DATABASE_PRODUCT_MYSQL)) {
      return this.join("select ", body, " limit ?, ?");
    }
    if (getDatabaseProductName().equals(DATABASE_PRODUCT_H2)) {
      return this.join("select ", body, " limit ?, ?");
    }
    if (getDatabaseProductName().equals(DATABASE_PRODUCT_GBASE)) {
      return this.join("select skip ? first ? ", body);
    }
    if (getDatabaseProductName().equals(DATABASE_PRODUCT_INFORMIX)) {
      return this.join("select skip ? first ? ", body);
    }
    if (getDatabaseProductName().equals(DATABASE_PRODUCT_PGSQL)) {
      return this.join("select  ", body, " offset ? limit ?");
    }

    if (getDatabaseProductName().equals(DATABASE_PRODUCT_ORACLE)) {
      // not tested yet, more issue is here
      return this.join(
          "select * from (",
          "select a.*, rownum rowno from (",
          "select ",
          body,
          ") _internal where _internal.rownum<=? ",
          ") _external where _external.rownum>=? ");
    }
    return this.join("select ", body, " offset ? limit ?");
  }

  protected String currentDatabaseProductName = null;

  protected String getDatabaseProductName() {

    if (currentDatabaseProductName != null) {
      return currentDatabaseProductName;
    }
    // only call the connection to get product by the first time;
    Connection conn = null;
    try {
      conn = jdbcTemplate.getDataSource().getConnection();
      return currentDatabaseProductName = conn.getMetaData().getDatabaseProductName().toLowerCase();
    } catch (Exception e) {
      return null;
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          // Do nothing
          SQLLogger.logDebug("Trying to close connection error: " + e.getMessage());
        }
      }
    }
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }
  // Having following methods to allow easier logging, performance optimization
  // The data can be read from read only databases with slave-master arch

  protected void checkBatchReturn(int[] affectedNumbers) {
    if (affectedNumbers == null || affectedNumbers.length == 0) {
      return;
    }

    for (int affectedNumber : affectedNumbers) {
      if (affectedNumber != 1) {
        throw new IllegalStateException(
            "The save operation should return value = 1, while the value = "
                + affectedNumber
                + ". If the value = 0, it means the target record has been updated by someone else!");
      }
    }
  }

  protected int[] batchUpdate(String sql, List<Object[]> args) {
    if (args.isEmpty()) {
      return new int[0];
    }

    int[] counts = getJdbcTemplate().batchUpdate(sql, args);
    logSQLAndParamList("batchUpdate", sql, args, counts);
    return counts;
  }

  protected int[] batchRemove(String sql, List<Object[]> args) {
    if (args.isEmpty()) {
      return new int[0];
    }

    int[] counts = getJdbcTemplate().batchUpdate(sql, args);
    logSQLAndParamList("batchRemove", sql, args, counts);
    return counts;
  }

  protected int[] batchRecover(String sql, List<Object[]> args) {
    if (args.isEmpty()) {
      return new int[0];
    }
    int[] counts = getJdbcTemplate().batchUpdate(sql, args);
    logSQLAndParamList("batchRecover", sql, args, counts);
    return counts;
  }

  public int singleUpdate(String sql, Object[] parameters) {
    try {
      int count = getJdbcTemplate().update(sql, parameters);
      SQLLogger.logSQLAndParameters(sql, parameters, count + " UPDATED");
      return count;
    } catch (Throwable t) {
      SQLLogger.logSQLAndParameters(sql, parameters, "FAIL with: " + t.getMessage());
      throw t;
    }
  }
  // compatiable with old code
  protected int update(String sql, Object[] parameters) {
    return this.singleUpdate(sql, parameters);
  }

  protected <T extends BaseEntity> T queryForObject(
      String sql, Object[] parameters, RowMapper<T> mapper) {
    // return getJdbcTemplate().batchUpdate(sql, args);

    return wrapWithLog(
        "loadSingleObj",
        sql,
        parameters,
        getJdbcTemplate().queryForObject(sql, parameters, mapper));
  }

  protected <T extends BaseEntity> T loadSingleObject(AccessKey accessKey, RowMapper<T> mapper) {
    // return getJdbcTemplate().batchUpdate(sql, args);
    // String sql="select * from "+ this.getTableName() +" where " + accessKey.getColumnName() + "=
    // ?";
    String sql =
        this.join(
            "select * from ", this.getTableName(), " where ", accessKey.getColumnName(), "= ?");
    Object[] parameters = {accessKey.getValue()};

    return wrapWithLog(
        "loadSingleObject",
        sql,
        parameters,
        getJdbcTemplate().queryForObject(sql, parameters, mapper));
  }

  protected <T extends BaseEntity> T wrapWithLog(
      String methodName, String sql, Object[] parameters, T result) {
    if (result == null) {
      SQLLogger.logSQLAndParameters(sql, parameters, "NULL");
      return null;
    }
    SQLLogger.logSQLAndParameters(sql, parameters, result.getId());

    return result;
  }
  /*
  	protected void logSQLAndParameters2(String method, String sql,Object [] parameters) {

  		System.out.println(timeExpr()+": "+method+" excuting: "+ sql);

  		for(int i=0;i<parameters.length;i++){
  			logDebug("\t\tp["+i+"]:\t"+parameters[i]);
  		}
  	}
  */

  protected void logSQLAndParameters1(String method, String sql, Object[] parameters) {
    SQLLogger.logSQLAndParameters(sql, parameters, "UNKNOWN");
  }

  protected void logSQLAndParamList(String method, String sql, List<Object[]> args, int[] counts) {
    // System.out.println(timeExpr()+": "+method+"batch excuting: "+ sql);

    int counter = 0;
    for (Object[] parameters : args) {

      SQLLogger.logSQLAndParameters(sql, parameters, counts[counter] + " UPDATED");
      counter++;
    }
  }

  protected <T extends BaseEntity> T queryForObject(
      String sql, Class<T> clazz, Object[] parameters) {
    // return getJdbcTemplate().batchUpdate(sql, args);

    return this.wrapWithLog(
        "queryForObject",
        sql,
        parameters,
        getJdbcTemplate().queryForObject(sql, clazz, parameters));
  }
  // List<Order> orderList = getJdbcTemplate().query(SQL, new Object[]{confirmationId},
  // getMapper());

  protected <T extends BaseEntity> SmartList<T> queryForList(
      String sql, Object[] parameters, RowMapper<T> mapper) {
    // return getJdbcTemplate().batchUpdate(sql, args);

    // return getJdbcTemplate().query(sql,parameters,mapper);
    List<T> originList = getJdbcTemplate().query(sql, parameters, mapper);
    SQLLogger.logSQLAndParameters(sql, parameters, originList.size() + " ROWS");
    SmartList<T> smartList = new SmartList<T>();
    smartList.addAll(originList);
    return smartList;
  }

  protected <T extends BaseEntity> Stream<T> queryForStream(
      String sql, Object[] parameters, RowMapper<T> mapper) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      connection = getJdbcTemplate().getDataSource().getConnection();
      preparedStatement =
          connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      ArgumentPreparedStatementSetter argumentPreparedStatementSetter =
          new ArgumentPreparedStatementSetter(parameters);
      argumentPreparedStatementSetter.setValues(preparedStatement);
      preparedStatement.setFetchSize(Integer.MIN_VALUE);
      rs = preparedStatement.executeQuery();
      return new ResultSetIterable(connection, preparedStatement, rs, mapper).stream();
    } catch (Exception e) {
      e.printStackTrace();
      try {
        if (connection != null) {
          connection.close();
        }
        if (rs != null) {
          rs.close();
        }
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } catch (Exception ex) {

      }
    }
    return Stream.empty();
  }

  protected Integer queryInt(String sql, Object[] parameters) {
    // return getJdbcTemplate().batchUpdate(sql, args);

    // return getJdbcTemplate().query(sql,parameters,mapper);

    Integer result = getJdbcTemplate().queryForObject(sql, parameters, Integer.class);
    SQLLogger.logSQLAndParameters(sql, parameters, "RESULT: " + result);
    return result;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  static boolean inCloseCharRang(char test, char start, char end) {
    if (test < start) {
      return false;
    }
    if (test > end) {
      return false;
    }
    return true;
  }

  static Object[] parse(String maxId) {

    if (maxId == null) {
      return new Object[] {"USER", 1L};
    }

    Object ret[] = new Object[2];
    StringBuilder numberBuffer = new StringBuilder();
    StringBuilder prefixBuffer = new StringBuilder();
    StringBuilder currentBuffer = numberBuffer;
    char[] chs = maxId.toCharArray();

    int length = chs.length;
    for (int i = 0; i < length; i++) {
      char ch = chs[length - i - 1];
      if (inCloseCharRang(ch, '0', '9')) {
        currentBuffer.insert(0, ch);
        continue;
      }
      currentBuffer = prefixBuffer;
      currentBuffer.insert(0, ch);
    }

    ret[0] = prefixBuffer.toString();
    String numberExpr = numberBuffer.toString();
    if (numberExpr.isEmpty()) {
      ret[1] = 0L;
      return ret;
    }

    ret[1] = Long.parseLong(numberExpr);
    return ret;
  }

  // static final String ID_FORMAT="USER%06d";

  // There is an issue when runing this code under cluster environment
  // Since other instance running the same code and keep conflicting each other
  // When running under a cluster environment, we need a global unique id to ensure
  // The id will not be repeated

  protected AtomicLong currentMax = new AtomicLong(-1L);

  protected String getNextId() {
    synchronized (currentMax) {
      if (currentMax.get() > 0) {

        return String.format(getIdFormat(), currentMax.incrementAndGet());
      }
      // The following logic just run when the first time loaded the id from table
      try {
        String SQL = "select max(id) from " + getName() + "_data";
        String maxId = getJdbcTemplate().queryForObject(SQL, String.class);
        if (maxId == null) {
          currentMax.set(1L);
          ;
          return String.format(getIdFormat(), 1);
        }

        Object ret[] = parse(maxId);
        currentMax.set((Long) ret[1] + 1);
        // System.out.println(this.getClass().getName()+this.hashCode()+":getNextId(start from
        // "+maxId+")="+currentMax);
        return String.format(getIdFormat(), currentMax.get());

      } catch (EmptyResultDataAccessException e) {
        currentMax.set(1L);
        return String.format(getIdFormat(), 1);
      }
    }
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public static String getShortName(String name) {
    String ar[] = name.split("_");
    String ret = ar[0].substring(0, 1).toUpperCase();

    for (int i = 1; i < ar.length; i++) {
      ret += ar[i].substring(0, 1).toUpperCase();
    }
    return ret;
  }

  protected String getIdColumnName() {
    return "id";
  }

  protected String getVersionColumnName() {
    return "version";
  }

  protected abstract String[] getNormalColumnNames();

  protected abstract String getName();

  protected abstract String getBeanName();

  protected String getTableName() {
    return this.getName() + "_data";
  }

  protected String getBeanListName() {
    return getBeanName() + "List";
  }

  protected String getCreateSQL() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("insert into ");
    stringBuilder.append(this.getTableName());
    stringBuilder.append("(id, ");
    stringBuilder.append(join());
    stringBuilder.append(", version)values(?, ");
    stringBuilder.append(getCreateParametersPlaceHolders());
    stringBuilder.append(", 1)");

    return stringBuilder.toString();
  }

  protected String getUpdateSQL() {

    // return new String[]{"name","bize_order","card_number","billing_address"};
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update ");
    stringBuilder.append(this.getTableName());
    stringBuilder.append(" set ");
    stringBuilder.append(joinUpdate());
    stringBuilder.append(", version = ? ");

    stringBuilder.append("where id=? and version=?");

    return stringBuilder.toString();
  }

  protected Object[] prepareRemoveParameters(BaseEntity baseEntity) {

    Object[] parameters = new Object[3];
    parameters[0] = 0 - Math.abs(baseEntity.getVersion());
    parameters[1] = baseEntity.getId(); // where id =
    parameters[2] = baseEntity.getVersion(); // and version=""
    return parameters;
  }

  protected Object[] prepareRecoverParameters(BaseEntity baseEntity) {

    Object[] parameters = new Object[1];
    parameters[0] = baseEntity.getId();
    return parameters;
  }

  protected String getRemoveSQL() {
    // return new String[]{"name","bize_order","card_number","billing_address"};
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update ");
    stringBuilder.append(this.getTableName());
    stringBuilder.append(" set version = ? ");
    stringBuilder.append("where id=? and version=?");
    return stringBuilder.toString();
  }

  protected String getRecoverSQL() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update ");
    stringBuilder.append(this.getTableName());
    stringBuilder.append(" set version = abs(version) ");
    stringBuilder.append("where id=? ");
    return stringBuilder.toString();
  }

  protected String getCreateParametersPlaceHolders() {

    int length = getNormalColumnNames().length;
    return repeatAndJoin("?", ", ", length);
  }

  protected String joinUpdateParametersPlaceHolders() {

    int length = getNormalColumnNames().length;
    return repeatAndJoin("?", ", ", length);
  }

  protected String repeatAndJoin(String value, String delimiter, int times) {
    return IntStream.range(0, times).mapToObj(i -> value).collect(Collectors.joining(delimiter));
  }

  protected String joinPlaceHolders(String[] parameters) {
    return repeatAndJoin("?", ",", parameters.length);
  }

  protected String join() {
    String columNames[] = getNormalColumnNames();
    return Arrays.asList(columNames).stream().collect(Collectors.joining(", "));
  }

  protected String joinUpdate() {

    String columNames[] = getNormalColumnNames();
    return Arrays.asList(columNames).stream()
        .map(columnName -> columnName + " = ?")
        .collect(Collectors.joining(", "));
  }

  public <T extends BaseEntity> SmartList<T> removeList(
      SmartList<T> entityList, Map<String, Object> options) {

    // if(true) throw new IllegalStateException("removeList-----");
    // System.out.println("removeList-----");
    return entityList;
  }

  protected int calcToIndex(int totalLoadSize, int currentPage, int rowsPerPage) {
    int lastIndex = currentPage * rowsPerPage;
    if (lastIndex > totalLoadSize) {
      return totalLoadSize;
    }
    return lastIndex;
  }

  protected boolean isCurrentPageInLoadedList(int totalLoadSize, int currentPage, int rowsPerPage) {

    if (currentPage * rowsPerPage <= totalLoadSize) { // is this really needed????????
      return true;
    }

    if (totalLoadSize < this.getMaxRows()) {
      // full loaded
      return true;
    }

    return false;
  }

  protected int rowsPerPageOf(String objectName, Map<String, Object> options) {
    // first get the value from options
    // acceleratorAccountList
    Object object = options.get(objectName + "RowsPerPage");
    if (object == null) {
      return 20;
    }
    if (object instanceof Integer) {
      return (Integer) object;
    }
    // From the front end, this value may be a string.
    try {
      int rowsPerPage = Integer.parseInt(object.toString());
      if (rowsPerPage > 1000) {
        return 1000; // prevent large rows
      }
      return rowsPerPage;
    } catch (Exception e) {
      return 20;
    }
  }

  protected int currentPageNumberOf(String objectName, Map<String, Object> options) {
    Object currentPageObject = options.get(objectName + "CurrentPage");
    if (currentPageObject == null) {
      return 1;
    }
    if (currentPageObject instanceof Integer) {
      return (Integer) currentPageObject;
    }
    // From the front end, this value may be a string.
    String object = (String) currentPageObject;
    try {
      int rowsPerPage = Integer.parseInt(object);
      return rowsPerPage;
    } catch (Exception e) {
      return 1;
    }
  }

  protected void convertListOptions(
      Map<String, Object> options, String fromPrefix, String toPrefix) {

    Map<String, Object> optionsToMerge = new HashMap<String, Object>();

    Set<Map.Entry<String, Object>> entrySet = options.entrySet();

    for (Map.Entry<String, Object> entry : entrySet) {

      String key = entry.getKey();
      if (!key.startsWith(fromPrefix + ".")) {
        // eg. "XYListAsSender"=>XYList
        continue;
      }
      int startIndex = key.indexOf('.');
      if (startIndex < 1) {
        continue;
      }
      String remainKeyPart = key.substring(startIndex);
      String newKey = this.join(toPrefix, remainKeyPart);

      optionsToMerge.put(newKey, entry.getValue());
    }
    // to avoid concurrent modification
    Set<Map.Entry<String, Object>> mergeEntrySet = optionsToMerge.entrySet();
    for (Map.Entry<String, Object> entry : mergeEntrySet) {
      options.put(entry.getKey(), entry.getValue());
    }
  }

  /*
  protected Object [] joinArrays(Object [] arr1, Object[] arr2) {
  		Object [] objs = new Object[arr1.length+arr2.length];
  		int index = 0;
  		for(Object obj:arr1){
  			objs[index++] = obj;
  		}
  		for(Object obj:arr2){
  			objs[index++] = obj;
  		}
  		return objs;

  	}*/

  protected Object[] joinArrays(Object[][] arrays) {
    if (arrays == null) {
      throw new IllegalArgumentException("joinArrays(Object [][] arrays): arrays can not be NULL");
    }

    int length = 0;

    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i] == null) {
        throw new IllegalArgumentException(
            "joinArrays(Object [][] arrays): arrays[" + i + "] with can not be NULL");
      }
      length += arrays[i].length;
    }

    Object[] result = new Object[length];
    int offset = 0;
    for (int i = 0; i < arrays.length; i++) {
      // length += arrays[i].length;
      Object[] element = arrays[i];

      System.arraycopy(element, 0, result, offset, element.length);
      offset += element.length;
    }

    return result;
  }

  protected String getListQuerySQL(Object[] array) {

    String SQL =
        "select * from "
            + this.getTableName()
            + " where id in ("
            + repeatExpr("?", ",", array.length)
            + ")";

    return SQL;
  }

  protected String repeatExpr(String string, String delimit, int length) {
    if (length <= 0) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (i > 0) {
        stringBuilder.append(delimit);
      }
      stringBuilder.append(string);
    }

    return stringBuilder.toString();
  }

  protected int countWith(String target, Object value, Map<String, Object> options) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(target, value);
    return this.countWith(key, options);
  }

  protected QueryCriteria createQueryCriteria(Map<String, Object> options) {
    return QueryCriteria.createCriteriaFromOptions(this.getBeanListName(), options);
  }

  protected <T extends BaseEntity> SmartList<T> queryWith(
      String target, Object value, Map<String, Object> options, RowMapper<T> mapper) {

    QueryCriteria qc = this.createQueryCriteria(options);

    String SQL =
        "select * from " + this.getTableName() + " where " + target + " = ? " + qc.getSQL();

    Object[] parameters =
        this.joinArrays(new Object[][] {new Object[] {value}, qc.getParameters()});
    SmartList<T> resultList = queryForList(SQL, parameters, mapper);
    return resultList;
  }

  protected <T extends BaseEntity> SmartList<T> queryWith(
      MultipleAccessKey key, Map<String, Object> options, RowMapper<T> mapper) {
    QueryCriteria qc = this.createQueryCriteria(options);
    if (key.isEmpty()) {
      throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
    }
    String SQL = "select * from " + this.getTableName() + " where" + key.sql() + qc.getSQL();

    Object[] parameters = this.joinArrays(new Object[][] {key.params(), qc.getParameters()});
    SmartList<T> resultList = queryForList(SQL, parameters, mapper);
    return resultList;
  }

  protected int countWith(MultipleAccessKey key, Map<String, Object> options) {
    if (key.isEmpty()) {
      throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
    }
    QueryCriteria qc = this.createQueryCriteria(options);

    String SQL =
        "select count(*) from " + this.getTableName() + " where " + key.sql() + qc.getSQL();

    Object[] parameters = this.joinArrays(new Object[][] {key.params(), qc.getParameters()});
    Integer count = queryInt(SQL, parameters);
    if (count == null) {
      // return the value anyways
      return 0;
    }
    return count;
  }

  protected Map<String, Integer> countWithIds(
      String target, String[] ids, Map<String, Object> options) {
    if (ids == null || ids.length == 0) {
      return new HashMap<>();
    }
    String SQL =
        "select "
            + target
            + " as id, count(*) as count from "
            + this.getTableName()
            + " where "
            + target
            + " in ("
            + TextUtil.repeat("?", ids.length, ",", true)
            + ") group by "
            + target;
    Object[] parametersArray = ids;
    List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(SQL, parametersArray);
    if (result == null || result.isEmpty()) {
      return new HashMap<>();
    }
    Map<String, Integer> cntMap = new HashMap<>();
    for (Map<String, Object> data : result) {
      String key = String.valueOf(data.get("id"));
      Number value = (Number) data.get("count");
      cntMap.put(key, value.intValue());
    }
    SQLLogger.logSQLAndParameters(SQL, ids, cntMap.size() + " Counts");
    return cntMap;
  }
  // 先支持一个Key好了, 后面再扩展到多Key场景
  protected Map<String, Integer> countWithGroup(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {
    if (filterKey.isEmpty()) {
      throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
    }
    QueryCriteria qc = this.createQueryCriteria(options);
    /*
    if(groupKey == null){
    	throw new IllegalArgumentException("method countWithGroup: param groupKey can not be null");
    }
    if(groupKey.length == 0){
    	throw new IllegalArgumentException("method countWithGroup: param groupKey can not be empty");
    }
    String groupKeyExpr = this.joinArray(",",groupKey);
    */

    String internalKey = this.mapToInternalColumn(groupKey);
    checkFieldName(internalKey);
    String SQL =
        "select count(*) as count, "
            + internalKey
            + " from "
            + this.getTableName()
            + " where "
            + filterKey.sql()
            + qc.getSQL()
            + " group by "
            + internalKey;

    Object[] parameters = this.joinArrays(new Object[][] {filterKey.params(), qc.getParameters()});
    if (parameters.length == 0) {
      // if there are no parameters, where does not make sence
      SQL =
          "select count(*) as count, "
              + internalKey
              + " from "
              + this.getTableName()
              + " group by "
              + internalKey;
    }

    SQLLogger.logSQLAndParameters(SQL, parameters, "PENDING");
    Map<String, Integer> result =
        this.getJdbcTemplate()
            .query(
                SQL,
                parameters,
                new ResultSetExtractor<Map<String, Integer>>() {

                  @Override
                  public Map<String, Integer> extractData(ResultSet rs)
                      throws SQLException, DataAccessException {
                    Map<String, Integer> countResult = new CountingResultMap();

                    while (rs.next()) {

                      int count = rs.getInt(1);
                      // int resultCount = rs.get
                      String key = rs.getString(2);

                      countResult.put(key, count);
                    }

                    return countResult;
                  }
                });

    return result;
  }

  protected String joinArray(String delimiter, Object[] args) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      if (i > 0) stringBuilder.append(delimiter);
      stringBuilder.append(args[i]);
    }
    return stringBuilder.toString();
  }

  protected <T extends BaseEntity> SmartList<T> queryWithRange(
      String target,
      Object value,
      Map<String, Object> options,
      RowMapper<T> mapper,
      int start,
      int count) {
    QueryCriteria qc = this.createQueryCriteria(options);
    String SQL =
        wrapRangeQuery(
            "* from " + this.getTableName() + " where " + target + " = ? " + qc.getSQL());

    Object[] parameters =
        this.joinArrays(
            new Object[][] {new Object[] {value}, qc.getParameters(), new Object[] {start, count}});

    SmartList<T> resultList = queryForList(SQL, parameters, mapper);
    return resultList;
  }

  public <T extends BaseEntity> SmartList<T> findAllCandidateByFilter(
      String fieldName, String filterKey, int pageNo, int pageSize, RowMapper<T> mapper) {
    return findAllCandidateByFilter(fieldName, null, filterKey, pageNo, pageSize, mapper);
  }

  public <T extends BaseEntity> SmartList<T> findAllCandidateByFilter(
      String fieldName,
      String notNullColName,
      String filterKey,
      int pageNo,
      int pageSize,
      RowMapper<T> mapper) {
    Object[] preparedResult =
        constractFindAllByFilterParams(fieldName, notNullColName, filterKey, pageNo, pageSize);
    String sqlCount = (String) preparedResult[0];
    Object[] countParams = (Object[]) preparedResult[1];
    String sqlQuery = (String) preparedResult[2];
    Object[] params = (Object[]) preparedResult[3];
    int totalNum = this.queryInt(sqlCount, countParams);
    SmartList<T> resultList = this.queryForList(sqlQuery, params, mapper);
    resultList.setTotalCount(totalNum);
    resultList.setCurrentPageNumber(pageNo);
    resultList.setRowsPerPage(pageSize);
    return resultList;
  }

  protected Object[] constractFindAllByFilterParams(
      String fieldName, String notNullColName, String filterKey, int pageNo, int pageSize) {
    if (filterKey == null || filterKey.trim().isEmpty()) {
      return constructFindAllWithoutFilterKey(fieldName, notNullColName, pageNo, pageSize);
    }
    return constractFindAllWithFilterKey(fieldName, notNullColName, filterKey, pageNo, pageSize);
  }

  protected Object[] constructFindAllWithoutFilterKey(
      String fieldName, String notNullColName, int pageNo, int pageSize) {
    String querySQL =
        wrapRangeQuery(
            "* from "
                + this.getTableName()
                + (notNullColName == null ? "" : " where " + notNullColName + " is not null ")
                + " order by "
                + fieldName
                + " asc ");
    String countSQL =
        "select count(*) from "
            + this.getTableName()
            + (notNullColName == null ? "" : " where " + notNullColName + " is not null ");
    Object[] params = new Object[] {(pageNo - 1) * pageSize, pageSize};
    return new Object[] {countSQL, new Object[] {}, querySQL, params};
  }

  protected Object[] constractFindAllWithFilterKey(
      String fieldName, String notNullColName, String filterKey, int pageNo, int pageSize) {
    String notNullClause =
        notNullColName == null ? "" : (" and " + notNullColName + " is not null ");
    String querySQL =
        wrapRangeQuery(
            "* from "
                + this.getTableName()
                + " where "
                + fieldName
                + " like ? "
                + notNullClause
                + " order by "
                + fieldName
                + " asc ");
    String countSQL =
        "select count(*) from "
            + this.getTableName()
            + " where "
            + fieldName
            + " like ? "
            + notNullClause;
    Object[] countParams = new Object[] {'%' + filterKey + '%'};
    Object[] queryParams = new Object[] {'%' + filterKey + '%', (pageNo - 1) * pageSize, pageSize};
    return new Object[] {countSQL, countParams, querySQL, queryParams};
  }
  /*
  protected Object[] constructFindAllWithoutFilterKey(String fieldName, int pageNo, int pageSize) {
  	String querySQL = "select * from " + this.getTableName() + " order by " + fieldName + " asc limit ?,?";
  	String countSQL = "select count(*) from " + this.getTableName();
  	Object[] params = new Object[] { (pageNo - 1) * pageSize, pageSize };
  	return new Object[] { countSQL, new Object[] {}, querySQL, params };
  }

  protected Object[] constractFindAllWithFilterKey(String fieldName, String filterKey, int pageNo, int pageSize) {
  	String querySQL = "select * from " + this.getTableName() + " where " + fieldName + " like ? order by " + fieldName + " asc limit ?,?";
  	String countSQL = "select count(*) from " + this.getTableName() + " where " + fieldName + " like ? ";
  	Object[] countParams = new Object[] { '%' + filterKey + '%' };
  	Object[] queryParams = new Object[] { '%' + filterKey + '%', (pageNo - 1) * pageSize, pageSize };
  	return new Object[] { countSQL, countParams, querySQL, queryParams };
  }
  */

  protected void assertMethodArgumentNotNull(Object object, String method, String parameterName) {
    if (object == null) {
      throw new IllegalArgumentException(
          "Method:" + method + ": parameter '" + parameterName + "' shoud NOT be null");
    }
  }

  protected void assertMethodIntArgumentGreaterThan(
      int value, int targetValue, String method, String parameterName) {
    if (value <= targetValue) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' shoud greater than "
              + targetValue
              + " but it is: "
              + value);
    }
  }

  protected void assertMethodIntArgumentLessThan(
      int value, int targetValue, String method, String parameterName) {
    if (value >= targetValue) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' shoud less than "
              + targetValue
              + " but it is: "
              + value);
    }
  }

  protected void assertMethodIntArgumentInClosedRange(
      int value, int startValue, int endValue, String method, String parameterName) {

    if (startValue > endValue) {
      throw new IllegalArgumentException(
          "When calling the check method, please note your parameter, endValue < startValue");
    }

    if (value < startValue) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' shoud be in closed range: ["
              + startValue
              + ","
              + endValue
              + "] but it is: "
              + value);
    }
    if (value > endValue) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' shoud be in closed range: ["
              + startValue
              + ","
              + endValue
              + "] but it is: "
              + value);
    }
  }

  protected void assertMethodStringArgumentLengthInClosedRange(
      String value, int lengthMin, int lengthMax, String method, String parameterName) {

    if (lengthMin < 0) {
      throw new IllegalArgumentException(
          "The method assertMethodStringArgumentLengthInClosedRange lengMin should not less than 0");
    }

    if (lengthMin > lengthMax) {
      throw new IllegalArgumentException(
          "The method assertMethodStringArgumentLengthInClosedRange lengMin less or equal lengthMax");
    }

    if (value == null) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' length shoud be in closed range: ["
              + lengthMin
              + ","
              + lengthMax
              + "] but it is null");
    }
    if (value.length() < lengthMin) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' length shoud be in closed range: ["
              + lengthMin
              + ","
              + lengthMax
              + "] but it is: "
              + value.length());
    }
    if (value.length() > lengthMax) {
      throw new IllegalArgumentException(
          "Method:"
              + method
              + ": parameter '"
              + parameterName
              + "' length shoud be in closed range: ["
              + lengthMin
              + ","
              + lengthMax
              + "] but it is: "
              + value.length());
    }
  }

  protected String wrapWithDate(String fieldName) {

    return this.join("date(", fieldName, ")");
  }

  protected String formatKeyForDateLine(String fieldName) {

    return this.join(fieldName, "OfDateline");
  }

  protected void logSQLAndParameters(
      String methdName, String sql, Object[] parameters, String result) {
    SQLLogger.logSQLAndParameters(sql, parameters, result);
  }

  // wrapWithDate
  protected List<AggrResult> statsWithGroup(
      Class<? extends BaseEntity> type,
      String groupKey,
      MultipleAccessKey filterKey,
      Map<String, Object> options) {
    if (filterKey.isEmpty()) {
      throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
    }
    QueryCriteria qc = this.createQueryCriteria(options);

    String internalKey = this.mapToInternalColumn(groupKey);
    checkGroupKey(internalKey); // open for functions
    String SQL =
        "select "
            + internalKey
            + " as date_key, count(*) as count from "
            + this.getTableName()
            + " where "
            + filterKey.sql()
            + qc.getSQL()
            + " group by date_key";

    Object[] parameters = this.joinArrays(new Object[][] {filterKey.params(), qc.getParameters()});
    if (parameters.length == 0) {
      // if there are no parameters, where does not make sence
      SQL =
          "select "
              + internalKey
              + " as date_key, count(*) as count from "
              + this.getTableName()
              + " group by date_key";
    }

    SQLLogger.logSQLAndParameters(SQL, parameters, "PENDING");
    List<AggrResult> result =
        this.getJdbcTemplate()
            .query(
                SQL,
                parameters,
                new ResultSetExtractor<List<AggrResult>>() {

                  @Override
                  public List<AggrResult> extractData(ResultSet rs)
                      throws SQLException, DataAccessException {

                    List<AggrResult> resultList = new ArrayList<AggrResult>();

                    while (rs.next()) {
                      AggrResult result = new AggrResult();
                      Object key = rs.getObject(1);
                      int count = rs.getInt(2);

                      BaseEntity objectKey = convertToBaseEntityKey(type, key);

                      result.setKey(objectKey);
                      result.setValue(count);

                      resultList.add(result);
                    }

                    return resultList;
                  }

                  protected BaseEntity convertToBaseEntityKey(
                      Class<? extends BaseEntity> type, Object key) {

                    if (key != null && (key instanceof Date)) {
                      DateKey objectKey = new DateKey();
                      objectKey.setId(objectKey.toString());
                      objectKey.setDateValue((Date) key);
                      return objectKey;
                    }

                    try {
                      BaseEntity objectKey = type.newInstance();
                      objectKey.setId(key == null ? null : key.toString());
                      return objectKey;
                    } catch (InstantiationException e) {
                      return null; // god bless code not going here
                    } catch (IllegalAccessException e) {
                      return null; // god bless code not going here
                    }
                  }
                });

    return result;
  }
}

class CountingResultMap extends HashMap<String, Integer> {

  /** */
  private static final long serialVersionUID = 1L;

  @Override
  public Integer get(Object key) {

    Integer value = super.get(key);
    if (value == null) {
      return 0;
    }
    return value;
  }
}
