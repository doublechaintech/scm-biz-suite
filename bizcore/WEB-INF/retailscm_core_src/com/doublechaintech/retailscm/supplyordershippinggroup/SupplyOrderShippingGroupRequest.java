package com.doublechaintech.retailscm.supplyordershippinggroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup.*;

public class SupplyOrderShippingGroupRequest extends BaseRequest<SupplyOrderShippingGroup> {
  public static SupplyOrderShippingGroupRequest newInstance() {
    return new SupplyOrderShippingGroupRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SupplyOrderShippingGroupRequest resultByClass(
      Class<? extends SupplyOrderShippingGroup> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SupplyOrderShippingGroupRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SupplyOrderShippingGroupRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SupplyOrderShippingGroup";
  }

  public SupplyOrderShippingGroupRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SupplyOrderShippingGroupRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SupplyOrderShippingGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SupplyOrderShippingGroupRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SupplyOrderShippingGroupRequest selectAll() {
    return this.selectId().selectName().selectBizOrder().selectAmount().selectVersion();
  }

  public SupplyOrderShippingGroupRequest selectAny() {
    return selectAll();
  }

  public SupplyOrderShippingGroupRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SupplyOrderShippingGroupRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SupplyOrderShippingGroupRequest where(
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

  public SupplyOrderShippingGroupRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SupplyOrderShippingGroupRequest comment(String comment) {
    return this;
  }

  public SupplyOrderShippingGroupRequest enhance() {
    return this;
  }

  public SupplyOrderShippingGroupRequest overrideClass(
      Class<? extends SupplyOrderShippingGroup> clazz) {
    return this;
  }

  public SupplyOrderShippingGroupRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SupplyOrderShippingGroupRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SupplyOrderShippingGroupRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SupplyOrderShippingGroupRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SupplyOrderShippingGroupRequest count() {
    return countId("count");
  }

  public static SupplyOrderShippingGroupRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SupplyOrderShippingGroupRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SupplyOrderShippingGroupRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderShippingGroupRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderShippingGroupRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SupplyOrderShippingGroupRequest countId() {
    return countId("countId");
  }

  public SupplyOrderShippingGroupRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest maxId() {
    return maxId("maxId");
  }

  public SupplyOrderShippingGroupRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest minId() {
    return minId("minId");
  }

  public SupplyOrderShippingGroupRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SupplyOrderShippingGroupRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SupplyOrderShippingGroupRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public SupplyOrderShippingGroupRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderShippingGroupRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderShippingGroupRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderShippingGroupRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderShippingGroupRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public SupplyOrderShippingGroupRequest countName() {
    return countName("countName");
  }

  public SupplyOrderShippingGroupRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest maxName() {
    return maxName("maxName");
  }

  public SupplyOrderShippingGroupRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest minName() {
    return minName("minName");
  }

  public SupplyOrderShippingGroupRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public SupplyOrderShippingGroupRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public SupplyOrderShippingGroupRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public SupplyOrderShippingGroupRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderShippingGroupRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderShippingGroupRequest whereAmountBetween(
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

  public SupplyOrderShippingGroupRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderShippingGroupRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderShippingGroupRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderShippingGroupRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderShippingGroupRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public SupplyOrderShippingGroupRequest countAmount() {
    return countAmount("countAmount");
  }

  public SupplyOrderShippingGroupRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public SupplyOrderShippingGroupRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest minAmount() {
    return minAmount("minAmount");
  }

  public SupplyOrderShippingGroupRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public SupplyOrderShippingGroupRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public SupplyOrderShippingGroupRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public SupplyOrderShippingGroupRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SupplyOrderShippingGroupRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderShippingGroupRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderShippingGroupRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderShippingGroupRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderShippingGroupRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SupplyOrderShippingGroupRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SupplyOrderShippingGroupRequest countVersion() {
    return countVersion("countVersion");
  }

  public SupplyOrderShippingGroupRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SupplyOrderShippingGroupRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest minVersion() {
    return minVersion("minVersion");
  }

  public SupplyOrderShippingGroupRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SupplyOrderShippingGroupRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SupplyOrderShippingGroupRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SupplyOrderShippingGroupRequest filterByBizOrder(SupplyOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, SupplyOrder::getId);
  }

  public SupplyOrderShippingGroupRequest filterByBizOrder(SupplyOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(SupplyOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public SupplyOrderShippingGroupRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public SupplyOrderRequest upToBizOrder() {
    return upToBizOrder(SupplyOrderRequest.newInstance());
  }

  public SupplyOrderRequest upToBizOrder(SupplyOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public SupplyOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, SupplyOrderRequest.newInstance());
  }

  public SupplyOrderRequest endAtBizOrder(String retName, SupplyOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public SupplyOrderShippingGroupRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public SupplyOrderShippingGroupRequest filterByBizOrder(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine, SupplyOrder.ID_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest selectBizOrder() {
    return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
  }

  public SupplyOrderShippingGroupRequest selectBizOrder(SupplyOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderShippingGroupRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public SupplyOrderShippingGroupRequest groupByBizOrder(SupplyOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderShippingGroupRequest aggregateBizOrder(SupplyOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderShippingGroupRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public SupplyOrderShippingGroupRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderShippingGroupRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderShippingGroupRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderShippingGroupRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SupplyOrderShippingGroupRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SupplyOrderShippingGroupRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SupplyOrderShippingGroupRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
