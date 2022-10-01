package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.PageUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseRequest<T extends BaseEntity> implements Cloneable {
  private Set<String> selects = new LinkedHashSet<>();
  private List<SearchCriteria> searchCriteriaList = new ArrayList<>();
  private Map<String, BaseRequest> parentSelects = new LinkedHashMap<>();
  private Map<String, BaseRequest> childrenSelects = new LinkedHashMap<>();
  private SimpleOrderBy orderBy = new SimpleOrderBy();
  private Aggregation aggregation = new Aggregation();
  private Map<String, BaseRequest> parentAggregations = new LinkedHashMap<>();
  private Map<String, BaseRequest> childrenAggregations = new LinkedHashMap<>();
  private Map<String, BaseRequest> groupBys = new LinkedHashMap<>();
  private List<DynamicAttributeRequest> dynamicAttributes = new ArrayList<>();
  private int offset;
  private int size = 1000;
  private String partitionProperty;
  private Object userContext;
  private String model;
  private Class<?> clazz;

  protected void overrideResultByClass(Class<?> clazz) {
    this.clazz = clazz;
  }

  public Class<?> getClazz() {
    return this.clazz;
  }

  public void doAddSearchCriteria(SearchCriteria pSearchCriteria) {

    if (pSearchCriteria instanceof SimplePropertyCriteria) {
      SimplePropertyCriteria spc = (SimplePropertyCriteria) pSearchCriteria;
      if (spc.isVersionPropertyCriteria()) {
        // should remove all version
        removeAllVersionCriteria();
      }
    }

    searchCriteriaList.add(pSearchCriteria);
  }

  public void removeAllVersionCriteria() {
    Iterator<SearchCriteria> it = searchCriteriaList.iterator();
    while (it.hasNext()) {

      SearchCriteria sc = it.next();
      if (!(sc instanceof SimplePropertyCriteria)) {
        continue;
      }
      SimplePropertyCriteria spc = (SimplePropertyCriteria) sc;
      if (!spc.isVersionPropertyCriteria()) {
        continue;
      }
      // Do something
      it.remove();
    }
  }

  public BaseRequest addJsonLimiter(JsonNode jsonNode) {
    if (jsonNode == null) {
      return this;
    }

    Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();

    jsonNode
        .fields()
        .forEachRemaining(
            field -> {
              String fieldName = field.getKey();
              JsonNode fieldValue = field.getValue();
              if ("_start".equals(fieldName)) {

                setOffset(fieldValue.intValue());
              }
              if ("_size".equals(fieldName)) {
                setSize(fieldValue.intValue());
              }
            });
    return this;
  }

  protected void addJsonPager(JsonNode jsonNode) {

    if (jsonNode == null) {
      return;
    }
    Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();

    AtomicInteger pageNumber = new AtomicInteger();
    jsonNode
        .fields()
        .forEachRemaining(
            field -> {
              String fieldName = field.getKey();
              JsonNode fieldValue = field.getValue();
              if ("_page".equals(fieldName) && fieldValue.intValue() > 0) {
                pageNumber.set(fieldValue.intValue());
              }
              if ("_pageSize".equals(fieldName) && fieldValue.intValue() > 0) {
                setSize(fieldValue.intValue());
              }
            });

    if (pageNumber.get() > 0) {
      int start = PageUtil.getStart(pageNumber.get() - 1, getSize());
      setOffset(start);
    }
  }

  /*
   * 只是告诉了一个字段，order by 正序 "_orderBy":"name"
   * 根据一个字段排序，并指出正序还是反序  "_orderBy":{"field": "name","useAsc": true}
   * 使用多个字段排序 "_orderBy":[{"field": "name","useAsc": true}]
   * */

  protected void addSingleJsonOrderBy(JsonNode jsonValueNode) {
    String field = jsonValueNode.get("field").asText();
    if (!isOneOfSelfField(field)) {
      return;
    }
    Boolean useAsc = jsonValueNode.get("useAsc").booleanValue();
    this.addOrderBy(field, useAsc);
    return;
  }

  public void addJsonOrderBy(JsonNode jsonNode) {
    if (jsonNode == null) {
      return;
    }

    JsonNode fieldValue = jsonNode.get("_orderBy");
    if (fieldValue == null) {
      return;
    }

    // 单个文本
    if (fieldValue.isTextual()) {
      if (!isOneOfSelfField(fieldValue.asText())) {
        return;
      }
      this.addOrderBy(fieldValue.asText(), false);
      return;
    }
    // value是一个对象，支持一个字段的排序
    if (fieldValue.isObject()) {
      addSingleJsonOrderBy(fieldValue);
      return;
    }
    // value是一个数组，支持一个到多个排序
    if (fieldValue.isArray()) {
      fieldValue
          .elements()
          .forEachRemaining(
              element -> {
                addSingleJsonOrderBy(element);
              });
      return;
    }
  }

  public void mergeClauses(JsonNode jsonExpr) {
    this.addJsonFilter(jsonExpr); // where name='x'
    this.addJsonOrderBy(jsonExpr); // order by age
    this.addJsonLimiter(jsonExpr); // limit 0,1000
    this.addJsonPager(jsonExpr);
  }

  public Object getUserContext() {
    return userContext;
  }

  public void setUserContext(Object pUserContext) {
    userContext = pUserContext;
  }

  public abstract String getInternalType();

  public BaseRequest<T> select(String... names) {
    if (names == null) {
      return this;
    }
    selects.addAll(Arrays.asList(names));
    return this;
  }

  public BaseRequest<T> aggregateName(String aggregationName) {
    aggregation.setName(aggregationName);
    return this;
  }

  public BaseRequest<T> aggregate(String aggName, AggFunc fuc, String... properties) {
    aggregation.aggregate(aggName, fuc, properties);
    return this;
  }

  public BaseRequest<T> groupBy(String propertyName) {
    aggregation.groupBy(propertyName, SqlFunction.SELF, propertyName);
    return this;
  }

  protected boolean isOneOfSelfField(String fieldName) {
    return false;
  }

  public BaseRequest<T> groupBy(String ret, SqlFunction fun, String... properties) {
    aggregation.groupBy(ret, fun, properties);
    return this;
  }

  public BaseRequest<T> aggregateParent(String name, BaseRequest request) {
    parentAggregations.put(name, request);
    return this;
  }

  public BaseRequest<T> groupBy(String name, BaseRequest request) {
    this.groupBy(name);
    groupBys.put(name, request);
    return this;
  }

  public BaseRequest<T> aggregateChild(String name, BaseRequest request) {
    childrenAggregations.put(request.getInternalType() + name, request);
    return this;
  }

  public void selectParent(String name, BaseRequest request) {
    if (!name.equals(RetailscmBaseUtils.getParentLinkName(getInternalType()))) {
      RetailscmBaseUtils.enhanceRequest(request);
    }
    request.unlimited();
    select(name);
    parentSelects.put(name, request);
  }

  public void selectChild(String name, BaseRequest request) {
    if (!name.equals(RetailscmBaseUtils.getParentLinkName(request.getInternalType()))) {
      RetailscmBaseUtils.enhanceRequest(request);
    }
    childrenSelects.put(request.getInternalType() + name, request);
  }

  public BaseRequest<T> unselect(String... name) {
    if (name == null) {
      return this;
    }
    selects.removeAll(Arrays.asList(name));
    return this;
  }

  public void unselectParent(String name) {
    unselect(name);
    parentSelects.remove(name);
  }

  public <R extends BaseEntity> void unselectChild(String name, Class<R> childClass) {
    childrenSelects.remove(childClass.getSimpleName() + name);
  }

  public BaseRequest<T> unlimited() {
    this.size = Integer.MAX_VALUE;
    return this;
  }

  public boolean hasLimit() {
    return !ObjectUtil.equals(this.size, Integer.MAX_VALUE);
  }

  public boolean hasData() {
    return !ObjectUtil.equals(this.size, 0);
  }

  public List<SearchCriteria> getSearchCriteriaList() {
    return searchCriteriaList;
  }

  public void setSearchCriteriaList(List<SearchCriteria> pSearchCriteriaList) {
    searchCriteriaList = pSearchCriteriaList;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int pOffset) {
    offset = pOffset;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int pSize) {
    size = pSize;
  }

  public Set<String> getSelects() {
    return selects;
  }

  public void setSelects(Set<String> pSelects) {
    selects = pSelects;
  }

  public Map<String, BaseRequest> getParentSelects() {
    return parentSelects;
  }

  public void setParentSelects(Map<String, BaseRequest> pParentSelects) {
    parentSelects = pParentSelects;
  }

  public Map<String, BaseRequest> getChildrenSelects() {
    return childrenSelects;
  }

  public void setChildrenSelects(Map<String, BaseRequest> pChildrenSelects) {
    childrenSelects = pChildrenSelects;
  }

  public void addOrderBy(String property, boolean asc) {
    orderBy.addOrderBy(property, asc);
  }

  public SimpleOrderBy getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(SimpleOrderBy pOrderBy) {
    orderBy = pOrderBy;
  }

  public Aggregation getAggregation() {
    return aggregation;
  }

  public void setAggregation(Aggregation pAggregation) {
    aggregation = pAggregation;
  }

  public Map<String, BaseRequest> getParentAggregations() {
    return parentAggregations;
  }

  public void setParentAggregations(Map<String, BaseRequest> pParentAggregations) {
    parentAggregations = pParentAggregations;
  }

  public Map<String, BaseRequest> getChildrenAggregations() {
    return childrenAggregations;
  }

  public void setChildrenAggregations(Map<String, BaseRequest> pChildrenAggregations) {
    childrenAggregations = pChildrenAggregations;
  }

  public Map<String, BaseRequest> getGroupBys() {
    return groupBys;
  }

  public void setGroupBys(Map<String, BaseRequest> pGroupBys) {
    groupBys = pGroupBys;
  }

  public String getPartitionProperty() {
    return partitionProperty;
  }

  public void setPartitionProperty(String pPartitionProperty) {
    partitionProperty = pPartitionProperty;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String pModel) {
    model = pModel;
  }

  public boolean isEmpty() {
    return getSelects().isEmpty() && getAggregation().isEmpty();
  }

  public boolean hasDataQuery() {
    if (getSelects().isEmpty()) {
      return false;
    }
    return hasData();
  }

  public boolean hasSimpleAgg() {
    return !getAggregation().isEmpty();
  }

  public boolean hasComplexAgg() {
    return !getChildrenAggregations().isEmpty() || !getParentAggregations().isEmpty();
  }

  public boolean hasAgg() {
    return hasSimpleAgg() || hasComplexAgg();
  }

  public boolean hasComplexGroupBy() {
    return !groupBys.isEmpty();
  }

  public boolean hasSimpleGroupBy() {
    return !aggregation.getGroupColumns().isEmpty();
  }

  public String getAggregationName() {
    String name = aggregation.getName();
    if (StrUtil.isEmpty(name)) {
      return getInternalType();
    }
    return name;
  }

  public AggFunc getFunc(String aggReturnName) {
    return aggregation.getFunc(aggReturnName);
  }

  // support for search from a json node

  public int countElements(Iterator<JsonNode> elements) {
    int value = 0;

    while (elements.hasNext()) {
      elements.next();
      value++;
    }
    return value;
  }

  public boolean isRange(Iterator<JsonNode> elements) {
    return countElements(elements) == 2;
    // two means range here
  }

  public JsonNodeType firstElementType(Iterator<JsonNode> elements) {

    if (elements.hasNext()) {

      return elements.next().getNodeType();
    }
    return JsonNodeType.MISSING;
  }

  public QueryOperator guessOperator(String name, JsonNode value) {

    JsonNodeType nodeType = value.getNodeType();
    if (nodeType == JsonNodeType.STRING) {

      String valueExpr = value.asText();
      QueryOperator operator = QueryOperator.operatorByValue(valueExpr);
      if (operator != null) {
        return operator;
      }
      return QueryOperator.CONTAIN;
    }
    if (nodeType == JsonNodeType.NUMBER || nodeType == JsonNodeType.BOOLEAN) {
      return QueryOperator.EQUAL;
    }
    // ARRAY OF STRINGS
    if (value.isArray() && firstElementType(value.elements()) == JsonNodeType.STRING) {
      return QueryOperator.IN;
    }
    // ARRAY OF NUMBERS, AND SIZE > 0

    // ARRAY OF STRINGS
    if (value.isArray() && firstElementType(value.elements()) == JsonNodeType.STRING) {
      return QueryOperator.IN;
    }
    // ARRAY OF OBJECTs
    if (value.isArray() && firstElementType(value.elements()) == JsonNodeType.OBJECT) {
      return QueryOperator.IN;
    }
    // ARRAY OF POJOs
    if (value.isArray() && firstElementType(value.elements()) == JsonNodeType.POJO) {
      return QueryOperator.IN;
    }
    // Other types like number, use
    if (value.isArray() && isRange(value.elements())) {
      return QueryOperator.BETWEEN; // this should be between
    }
    return QueryOperator.EQUAL;
  }

  protected boolean isDateOrTimeField(String fieldName) {
    return false;
  }

  protected Object[] guessValue(String fieldName, JsonNode fieldValue) {

    if (!fieldValue.isArray()) {
      Object[] result = new Object[1];

      result[0] = unwrapValue(fieldValue);

      return result;
    }
    // for arrays here

    int count = countElements(fieldValue.elements());
    Object[] result = new Object[count];

    Iterator<JsonNode> elements = fieldValue.elements();
    JsonNodeType type = firstElementType(fieldValue.elements());
    int index = 0;

    while (elements.hasNext()) {
      JsonNode node = elements.next();
      if (isDateOrTimeField(fieldName)) {
        result[index] = unwrapDateTimeValue(node);
        index++;
        continue;
      }
      result[index] = unwrapValue(node);

      index++;
    }

    return result;
  }

  public void addJsonFilter(JsonNode jsonNode) {
    if (jsonNode == null) {
      return;
    }
    Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
    while (fields.hasNext()) {
      Map.Entry<String, JsonNode> field = fields.next();
      String fieldName = field.getKey();
      if (!isOneOfSelfField(fieldName)) {
        continue;
      }
      JsonNode fieldValue = field.getValue();
      this.doAddSearchCriteria(
          new SimplePropertyCriteria(
              fieldName, guessOperator(fieldName, fieldValue), guessValue(fieldName, fieldValue)));
    }
  }

  protected Object unwrapDateTimeValue(JsonNode node) {

    Object value = unwrapValue(node);
    return new Date((Long) value);
  }

  protected Object unwrapValue(JsonNode node) {

    if (node.isNull()) {
      return null;
    }
    if (node.isTextual()) {
      return node.asText().trim();
    }
    if (node.isDouble()) {
      return node.asDouble();
    }
    if (node.isFloat()) {
      return node.asDouble();
    }
    if (node.isBigInteger()) {
      return node.asLong();
    }
    if (node.isBigDecimal()) {
      return node.asDouble();
    }
    if (node.isNumber()) {
      return node.asLong();
    }
    if (node.isBoolean()) {
      return node.asBoolean();
    }
    if (node.isPojo()) {
      return node.get("id").asText();
    }
    if (node.isObject()) {
      return node.get("id").asText();
    }

    return node.asText().trim();

    // if (type == JsonNodeType.STRING)

  }

  protected boolean isDateOrTimeField(String fieldName, String datetimeFields[]) {

    return isOneOf(fieldName, datetimeFields);
  }

  protected boolean isOneOf(String value, String[] candidates) {
    if (value == null) {
      return false;
    }
    if (candidates == null) {
      return false;
    }
    for (String candidate : candidates) {
      if (value.equals(candidate)) {
        return true;
      }
    }
    return false;
  }

  public List<DynamicAttributeRequest> getDynamicAttributes() {
    return dynamicAttributes;
  }

  public void setDynamicAttributes(List<DynamicAttributeRequest> pDynamicAttributes) {
    dynamicAttributes = pDynamicAttributes;
  }

  public boolean isEmptyParam(Object param) {
    if (ObjectUtil.isEmpty(param)) {
      return true;
    }

    if (ArrayUtil.isArray(param)) {
      int length = ArrayUtil.length(param);
      for (int i = 0; i < length; i++) {
        Object o = ArrayUtil.get(param, i);
        if (o != null) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public SmartList<T> executeForList(Object ctx) {
    return Searcher.search(ctx, this);
  }

  public T execute(Object ctx) {
    return Searcher.searchOne(ctx, this);
  }

  public T executeWithDefault(Object ctx, T defaultValue) {
    T dbItem = execute(ctx);
    return dbItem == null ? defaultValue : dbItem;
  }

  public T executeWithDefaultProvider(Object ctx, java.util.function.Supplier<T> provider) {
    T dbItem = execute(ctx);
    return dbItem == null ? (provider == null ? null : provider.get()) : dbItem;
  }
}
