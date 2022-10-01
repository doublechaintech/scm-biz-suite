package com.doublechaintech.retailscm.consumerordershippinggroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup.*;

public class ConsumerOrderShippingGroupRequest extends BaseRequest<ConsumerOrderShippingGroup> {
  public static ConsumerOrderShippingGroupRequest newInstance() {
    return new ConsumerOrderShippingGroupRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ConsumerOrderShippingGroupRequest resultByClass(
      Class<? extends ConsumerOrderShippingGroup> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ConsumerOrderShippingGroupRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ConsumerOrderShippingGroupRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ConsumerOrderShippingGroup";
  }

  public ConsumerOrderShippingGroupRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ConsumerOrderShippingGroupRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ConsumerOrderShippingGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ConsumerOrderShippingGroupRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ConsumerOrderShippingGroupRequest selectAll() {
    return this.selectId().selectName().selectBizOrder().selectAmount().selectVersion();
  }

  public ConsumerOrderShippingGroupRequest selectAny() {
    return selectAll();
  }

  public ConsumerOrderShippingGroupRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ConsumerOrderShippingGroupRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ConsumerOrderShippingGroupRequest where(
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

  public ConsumerOrderShippingGroupRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ConsumerOrderShippingGroupRequest comment(String comment) {
    return this;
  }

  public ConsumerOrderShippingGroupRequest enhance() {
    return this;
  }

  public ConsumerOrderShippingGroupRequest overrideClass(
      Class<? extends ConsumerOrderShippingGroup> clazz) {
    return this;
  }

  public ConsumerOrderShippingGroupRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ConsumerOrderShippingGroupRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ConsumerOrderShippingGroupRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ConsumerOrderShippingGroupRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ConsumerOrderShippingGroupRequest count() {
    return countId("count");
  }

  public static ConsumerOrderShippingGroupRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ConsumerOrderShippingGroupRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ConsumerOrderShippingGroupRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderShippingGroupRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderShippingGroupRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ConsumerOrderShippingGroupRequest countId() {
    return countId("countId");
  }

  public ConsumerOrderShippingGroupRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest maxId() {
    return maxId("maxId");
  }

  public ConsumerOrderShippingGroupRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest minId() {
    return minId("minId");
  }

  public ConsumerOrderShippingGroupRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ConsumerOrderShippingGroupRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroupRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ConsumerOrderShippingGroupRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderShippingGroupRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderShippingGroupRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderShippingGroupRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderShippingGroupRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ConsumerOrderShippingGroupRequest countName() {
    return countName("countName");
  }

  public ConsumerOrderShippingGroupRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest maxName() {
    return maxName("maxName");
  }

  public ConsumerOrderShippingGroupRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest minName() {
    return minName("minName");
  }

  public ConsumerOrderShippingGroupRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ConsumerOrderShippingGroupRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroupRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public ConsumerOrderShippingGroupRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderShippingGroupRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderShippingGroupRequest whereAmountBetween(
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

  public ConsumerOrderShippingGroupRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderShippingGroupRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderShippingGroupRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderShippingGroupRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderShippingGroupRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public ConsumerOrderShippingGroupRequest countAmount() {
    return countAmount("countAmount");
  }

  public ConsumerOrderShippingGroupRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public ConsumerOrderShippingGroupRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest minAmount() {
    return minAmount("minAmount");
  }

  public ConsumerOrderShippingGroupRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public ConsumerOrderShippingGroupRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public ConsumerOrderShippingGroupRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroupRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ConsumerOrderShippingGroupRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderShippingGroupRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderShippingGroupRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderShippingGroupRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderShippingGroupRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ConsumerOrderShippingGroupRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ConsumerOrderShippingGroupRequest countVersion() {
    return countVersion("countVersion");
  }

  public ConsumerOrderShippingGroupRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ConsumerOrderShippingGroupRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest minVersion() {
    return minVersion("minVersion");
  }

  public ConsumerOrderShippingGroupRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ConsumerOrderShippingGroupRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ConsumerOrderShippingGroupRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroupRequest filterByBizOrder(ConsumerOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, ConsumerOrder::getId);
  }

  public ConsumerOrderShippingGroupRequest filterByBizOrder(ConsumerOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(ConsumerOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderShippingGroupRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest upToBizOrder() {
    return upToBizOrder(ConsumerOrderRequest.newInstance());
  }

  public ConsumerOrderRequest upToBizOrder(ConsumerOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public ConsumerOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, ConsumerOrderRequest.newInstance());
  }

  public ConsumerOrderRequest endAtBizOrder(String retName, ConsumerOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public ConsumerOrderShippingGroupRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderShippingGroupRequest filterByBizOrder(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, ConsumerOrder.ID_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest selectBizOrder() {
    return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
  }

  public ConsumerOrderShippingGroupRequest selectBizOrder(ConsumerOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderShippingGroupRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroupRequest groupByBizOrder(ConsumerOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderShippingGroupRequest aggregateBizOrder(ConsumerOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderShippingGroupRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public ConsumerOrderShippingGroupRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderShippingGroupRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderShippingGroupRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderShippingGroupRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ConsumerOrderShippingGroupRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ConsumerOrderShippingGroupRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ConsumerOrderShippingGroupRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
