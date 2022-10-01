package com.doublechaintech.retailscm.treenode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.treenode.TreeNode.*;

public class TreeNodeRequest extends BaseRequest<TreeNode> {
  public static TreeNodeRequest newInstance() {
    return new TreeNodeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TreeNodeRequest resultByClass(Class<? extends TreeNode> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TreeNodeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TreeNodeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TreeNode";
  }

  public TreeNodeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TreeNodeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TreeNodeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TreeNodeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TreeNodeRequest selectAll() {
    return this.selectId()
        .selectNodeId()
        .selectNodeType()
        .selectLeftValue()
        .selectRightValue()
        .selectVersion();
  }

  public TreeNodeRequest selectAny() {
    return selectAll();
  }

  public TreeNodeRequest selectSelf() {
    select(ID_PROPERTY);
    select(NODE_ID_PROPERTY);
    select(NODE_TYPE_PROPERTY);
    select(LEFT_VALUE_PROPERTY);
    select(RIGHT_VALUE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TreeNodeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TreeNodeRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NODE_ID_PROPERTY,
    NODE_TYPE_PROPERTY,
    LEFT_VALUE_PROPERTY,
    RIGHT_VALUE_PROPERTY,
    VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public TreeNodeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TreeNodeRequest comment(String comment) {
    return this;
  }

  public TreeNodeRequest enhance() {
    return this;
  }

  public TreeNodeRequest overrideClass(Class<? extends TreeNode> clazz) {
    return this;
  }

  public TreeNodeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TreeNodeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TreeNodeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TreeNodeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TreeNodeRequest count() {
    return countId("count");
  }

  public static TreeNodeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TreeNodeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TreeNodeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TreeNodeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TreeNodeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TreeNodeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TreeNodeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TreeNodeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TreeNodeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TreeNodeRequest countId() {
    return countId("countId");
  }

  public TreeNodeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TreeNodeRequest maxId() {
    return maxId("maxId");
  }

  public TreeNodeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TreeNodeRequest minId() {
    return minId("minId");
  }

  public TreeNodeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TreeNodeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TreeNodeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TreeNodeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TreeNodeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TreeNodeRequest filterByNodeId(String nodeId) {

    if (nodeId == null) {
      return this;
    }

    return filterByNodeId(QueryOperator.EQUAL, nodeId);
  }

  public TreeNodeRequest whereNodeIdIsNull() {
    return where(NODE_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public TreeNodeRequest whereNodeIdIsNotNull() {
    return where(NODE_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TreeNodeRequest filterByNodeId(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNodeIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest selectNodeId() {
    return select(NODE_ID_PROPERTY);
  }

  public TreeNodeRequest unselectNodeId() {
    return unselect(NODE_ID_PROPERTY);
  }

  public SearchCriteria getNodeIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NODE_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TreeNodeRequest orderByNodeId(boolean asc) {
    addOrderBy(NODE_ID_PROPERTY, asc);
    return this;
  }

  public TreeNodeRequest orderByNodeIdAscending() {
    addOrderBy(NODE_ID_PROPERTY, true);
    return this;
  }

  public TreeNodeRequest orderByNodeIdDescending() {
    addOrderBy(NODE_ID_PROPERTY, false);
    return this;
  }

  public TreeNodeRequest orderByNodeIdAscendingUsingGBK() {
    addOrderBy("convert(nodeId using gbk)", true);
    return this;
  }

  public TreeNodeRequest orderByNodeIdDescendingUsingGBK() {
    addOrderBy("convert(nodeId using gbk)", false);
    return this;
  }

  public TreeNodeRequest countNodeId() {
    return countNodeId("countNodeId");
  }

  public TreeNodeRequest countNodeId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NODE_ID_PROPERTY);
  }

  public TreeNodeRequest maxNodeId() {
    return maxNodeId("maxNodeId");
  }

  public TreeNodeRequest maxNodeId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NODE_ID_PROPERTY);
  }

  public TreeNodeRequest minNodeId() {
    return minNodeId("minNodeId");
  }

  public TreeNodeRequest minNodeId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NODE_ID_PROPERTY);
  }

  public TreeNodeRequest groupByNodeId() {
    return groupByNodeId(NODE_ID_PROPERTY);
  }

  public TreeNodeRequest groupByNodeId(String ret) {
    return groupBy(ret, NODE_ID_PROPERTY);
  }

  public TreeNodeRequest groupByNodeId(SqlFunction func) {
    return groupByNodeId(NODE_ID_PROPERTY, func);
  }

  public TreeNodeRequest groupByNodeId(String ret, SqlFunction func) {
    super.groupBy(ret, func, NODE_ID_PROPERTY);
    return this;
  }

  public TreeNodeRequest filterByNodeType(String nodeType) {

    if (nodeType == null) {
      return this;
    }

    return filterByNodeType(QueryOperator.EQUAL, nodeType);
  }

  public TreeNodeRequest whereNodeTypeIsNull() {
    return where(NODE_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TreeNodeRequest whereNodeTypeIsNotNull() {
    return where(NODE_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TreeNodeRequest filterByNodeType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNodeTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest selectNodeType() {
    return select(NODE_TYPE_PROPERTY);
  }

  public TreeNodeRequest unselectNodeType() {
    return unselect(NODE_TYPE_PROPERTY);
  }

  public SearchCriteria getNodeTypeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NODE_TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TreeNodeRequest orderByNodeType(boolean asc) {
    addOrderBy(NODE_TYPE_PROPERTY, asc);
    return this;
  }

  public TreeNodeRequest orderByNodeTypeAscending() {
    addOrderBy(NODE_TYPE_PROPERTY, true);
    return this;
  }

  public TreeNodeRequest orderByNodeTypeDescending() {
    addOrderBy(NODE_TYPE_PROPERTY, false);
    return this;
  }

  public TreeNodeRequest orderByNodeTypeAscendingUsingGBK() {
    addOrderBy("convert(nodeType using gbk)", true);
    return this;
  }

  public TreeNodeRequest orderByNodeTypeDescendingUsingGBK() {
    addOrderBy("convert(nodeType using gbk)", false);
    return this;
  }

  public TreeNodeRequest countNodeType() {
    return countNodeType("countNodeType");
  }

  public TreeNodeRequest countNodeType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NODE_TYPE_PROPERTY);
  }

  public TreeNodeRequest maxNodeType() {
    return maxNodeType("maxNodeType");
  }

  public TreeNodeRequest maxNodeType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NODE_TYPE_PROPERTY);
  }

  public TreeNodeRequest minNodeType() {
    return minNodeType("minNodeType");
  }

  public TreeNodeRequest minNodeType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NODE_TYPE_PROPERTY);
  }

  public TreeNodeRequest groupByNodeType() {
    return groupByNodeType(NODE_TYPE_PROPERTY);
  }

  public TreeNodeRequest groupByNodeType(String ret) {
    return groupBy(ret, NODE_TYPE_PROPERTY);
  }

  public TreeNodeRequest groupByNodeType(SqlFunction func) {
    return groupByNodeType(NODE_TYPE_PROPERTY, func);
  }

  public TreeNodeRequest groupByNodeType(String ret, SqlFunction func) {
    super.groupBy(ret, func, NODE_TYPE_PROPERTY);
    return this;
  }

  public TreeNodeRequest filterByLeftValue(int leftValue) {

    return filterByLeftValue(QueryOperator.EQUAL, leftValue);
  }

  public TreeNodeRequest whereLeftValueIsNull() {
    return where(LEFT_VALUE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TreeNodeRequest whereLeftValueIsNotNull() {
    return where(LEFT_VALUE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TreeNodeRequest whereLeftValueBetween(Integer leftValueStart, Integer leftValueEnd) {
    if (ObjectUtil.isEmpty(leftValueStart)) {
      throw new IllegalArgumentException(
          "Method whereLeftValueBetween, the parameter leftValueStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(leftValueEnd)) {
      throw new IllegalArgumentException(
          "Method whereLeftValueBetween, the parameter leftValueEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeftValueSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {leftValueStart, leftValueEnd});
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest whereLeftValueLessThan(Integer leftValue) {
    if (ObjectUtil.isEmpty(leftValue)) {
      throw new IllegalArgumentException(
          "Method whereLeftValueLessThan, the parameter leftValue is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeftValueSearchCriteria(QueryOperator.LESS_THAN, new Object[] {leftValue});
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest whereLeftValueGreaterThan(int leftValue) {
    if (ObjectUtil.isEmpty(leftValue)) {
      throw new IllegalArgumentException(
          "Method whereLeftValueGreaterThan, the parameter leftValue is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeftValueSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {leftValue});
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest filterByLeftValue(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLeftValueSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest selectLeftValue() {
    return select(LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest unselectLeftValue() {
    return unselect(LEFT_VALUE_PROPERTY);
  }

  public SearchCriteria getLeftValueSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LEFT_VALUE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TreeNodeRequest orderByLeftValue(boolean asc) {
    addOrderBy(LEFT_VALUE_PROPERTY, asc);
    return this;
  }

  public TreeNodeRequest orderByLeftValueAscending() {
    addOrderBy(LEFT_VALUE_PROPERTY, true);
    return this;
  }

  public TreeNodeRequest orderByLeftValueDescending() {
    addOrderBy(LEFT_VALUE_PROPERTY, false);
    return this;
  }

  public TreeNodeRequest countLeftValue() {
    return countLeftValue("countLeftValue");
  }

  public TreeNodeRequest countLeftValue(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest maxLeftValue() {
    return maxLeftValue("maxLeftValue");
  }

  public TreeNodeRequest maxLeftValue(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest minLeftValue() {
    return minLeftValue("minLeftValue");
  }

  public TreeNodeRequest minLeftValue(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest sumLeftValue() {
    return sumLeftValue("sumLeftValue");
  }

  public TreeNodeRequest sumLeftValue(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest groupByLeftValue() {
    return groupByLeftValue(LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest groupByLeftValue(String ret) {
    return groupBy(ret, LEFT_VALUE_PROPERTY);
  }

  public TreeNodeRequest groupByLeftValue(SqlFunction func) {
    return groupByLeftValue(LEFT_VALUE_PROPERTY, func);
  }

  public TreeNodeRequest groupByLeftValue(String ret, SqlFunction func) {
    super.groupBy(ret, func, LEFT_VALUE_PROPERTY);
    return this;
  }

  public TreeNodeRequest filterByRightValue(int rightValue) {

    return filterByRightValue(QueryOperator.EQUAL, rightValue);
  }

  public TreeNodeRequest whereRightValueIsNull() {
    return where(RIGHT_VALUE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TreeNodeRequest whereRightValueIsNotNull() {
    return where(RIGHT_VALUE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TreeNodeRequest whereRightValueBetween(Integer rightValueStart, Integer rightValueEnd) {
    if (ObjectUtil.isEmpty(rightValueStart)) {
      throw new IllegalArgumentException(
          "Method whereRightValueBetween, the parameter rightValueStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(rightValueEnd)) {
      throw new IllegalArgumentException(
          "Method whereRightValueBetween, the parameter rightValueEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRightValueSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {rightValueStart, rightValueEnd});
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest whereRightValueLessThan(Integer rightValue) {
    if (ObjectUtil.isEmpty(rightValue)) {
      throw new IllegalArgumentException(
          "Method whereRightValueLessThan, the parameter rightValue is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRightValueSearchCriteria(QueryOperator.LESS_THAN, new Object[] {rightValue});
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest whereRightValueGreaterThan(int rightValue) {
    if (ObjectUtil.isEmpty(rightValue)) {
      throw new IllegalArgumentException(
          "Method whereRightValueGreaterThan, the parameter rightValue is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRightValueSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {rightValue});
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest filterByRightValue(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRightValueSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest selectRightValue() {
    return select(RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest unselectRightValue() {
    return unselect(RIGHT_VALUE_PROPERTY);
  }

  public SearchCriteria getRightValueSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(RIGHT_VALUE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TreeNodeRequest orderByRightValue(boolean asc) {
    addOrderBy(RIGHT_VALUE_PROPERTY, asc);
    return this;
  }

  public TreeNodeRequest orderByRightValueAscending() {
    addOrderBy(RIGHT_VALUE_PROPERTY, true);
    return this;
  }

  public TreeNodeRequest orderByRightValueDescending() {
    addOrderBy(RIGHT_VALUE_PROPERTY, false);
    return this;
  }

  public TreeNodeRequest countRightValue() {
    return countRightValue("countRightValue");
  }

  public TreeNodeRequest countRightValue(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest maxRightValue() {
    return maxRightValue("maxRightValue");
  }

  public TreeNodeRequest maxRightValue(String aggName) {
    return aggregate(aggName, AggFunc.MAX, RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest minRightValue() {
    return minRightValue("minRightValue");
  }

  public TreeNodeRequest minRightValue(String aggName) {
    return aggregate(aggName, AggFunc.MIN, RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest sumRightValue() {
    return sumRightValue("sumRightValue");
  }

  public TreeNodeRequest sumRightValue(String aggName) {
    return aggregate(aggName, AggFunc.SUM, RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest groupByRightValue() {
    return groupByRightValue(RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest groupByRightValue(String ret) {
    return groupBy(ret, RIGHT_VALUE_PROPERTY);
  }

  public TreeNodeRequest groupByRightValue(SqlFunction func) {
    return groupByRightValue(RIGHT_VALUE_PROPERTY, func);
  }

  public TreeNodeRequest groupByRightValue(String ret, SqlFunction func) {
    super.groupBy(ret, func, RIGHT_VALUE_PROPERTY);
    return this;
  }

  public TreeNodeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TreeNodeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TreeNodeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TreeNodeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TreeNodeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TreeNodeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TreeNodeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TreeNodeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TreeNodeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TreeNodeRequest countVersion() {
    return countVersion("countVersion");
  }

  public TreeNodeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TreeNodeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TreeNodeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TreeNodeRequest minVersion() {
    return minVersion("minVersion");
  }

  public TreeNodeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TreeNodeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TreeNodeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TreeNodeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TreeNodeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TreeNodeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TreeNodeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TreeNodeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TreeNodeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TreeNodeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TreeNodeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
