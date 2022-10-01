package com.doublechaintech.retailscm.retailstoreordershippinggroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup.*;

public class RetailStoreOrderShippingGroupRequest
    extends BaseRequest<RetailStoreOrderShippingGroup> {
  public static RetailStoreOrderShippingGroupRequest newInstance() {
    return new RetailStoreOrderShippingGroupRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreOrderShippingGroupRequest resultByClass(
      Class<? extends RetailStoreOrderShippingGroup> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreOrderShippingGroupRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreOrderShippingGroup";
  }

  public RetailStoreOrderShippingGroupRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreOrderShippingGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest selectAll() {
    return this.selectId().selectName().selectBizOrder().selectAmount().selectVersion();
  }

  public RetailStoreOrderShippingGroupRequest selectAny() {
    return selectAll();
  }

  public RetailStoreOrderShippingGroupRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreOrderShippingGroupRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, BIZ_ORDER_PROPERTY, AMOUNT_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public RetailStoreOrderShippingGroupRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest comment(String comment) {
    return this;
  }

  public RetailStoreOrderShippingGroupRequest enhance() {
    return this;
  }

  public RetailStoreOrderShippingGroupRequest overrideClass(
      Class<? extends RetailStoreOrderShippingGroup> clazz) {
    return this;
  }

  public RetailStoreOrderShippingGroupRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest count() {
    return countId("count");
  }

  public static RetailStoreOrderShippingGroupRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreOrderShippingGroupRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreOrderShippingGroupRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderShippingGroupRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest countId() {
    return countId("countId");
  }

  public RetailStoreOrderShippingGroupRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreOrderShippingGroupRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest minId() {
    return minId("minId");
  }

  public RetailStoreOrderShippingGroupRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreOrderShippingGroupRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreOrderShippingGroupRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderShippingGroupRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderShippingGroupRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderShippingGroupRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest countName() {
    return countName("countName");
  }

  public RetailStoreOrderShippingGroupRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreOrderShippingGroupRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest minName() {
    return minName("minName");
  }

  public RetailStoreOrderShippingGroupRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreOrderShippingGroupRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public RetailStoreOrderShippingGroupRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderShippingGroupRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderShippingGroupRequest whereAmountBetween(
      BigDecimal amountStart, BigDecimal amountEnd) {
    if (ObjectUtil.isEmpty(amountStart)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(amountEnd)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.BETWEEN, new Object[] {amountStart, amountEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderShippingGroupRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest countAmount() {
    return countAmount("countAmount");
  }

  public RetailStoreOrderShippingGroupRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public RetailStoreOrderShippingGroupRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest minAmount() {
    return minAmount("minAmount");
  }

  public RetailStoreOrderShippingGroupRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public RetailStoreOrderShippingGroupRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public RetailStoreOrderShippingGroupRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreOrderShippingGroupRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderShippingGroupRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderShippingGroupRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderShippingGroupRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderShippingGroupRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreOrderShippingGroupRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreOrderShippingGroupRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreOrderShippingGroupRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreOrderShippingGroupRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreOrderShippingGroupRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest filterByBizOrder(RetailStoreOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, RetailStoreOrder::getId);
  }

  public RetailStoreOrderShippingGroupRequest filterByBizOrder(RetailStoreOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(RetailStoreOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreOrderShippingGroupRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest upToBizOrder() {
    return upToBizOrder(RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreOrderRequest upToBizOrder(RetailStoreOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public RetailStoreOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreOrderRequest endAtBizOrder(String retName, RetailStoreOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public RetailStoreOrderShippingGroupRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreOrderShippingGroupRequest filterByBizOrder(
      RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, RetailStoreOrder.ID_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest selectBizOrder() {
    return selectBizOrder(RetailStoreOrderRequest.newInstance().selectSelf());
  }

  public RetailStoreOrderShippingGroupRequest selectBizOrder(RetailStoreOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest groupByBizOrder(RetailStoreOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest aggregateBizOrder(RetailStoreOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public RetailStoreOrderShippingGroupRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderShippingGroupRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderShippingGroupRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderShippingGroupRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreOrderShippingGroupRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreOrderShippingGroupRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
