package com.doublechaintech.retailscm.consumerorderpriceadjustment;

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
import static com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment.*;

public class ConsumerOrderPriceAdjustmentRequest extends BaseRequest<ConsumerOrderPriceAdjustment> {
  public static ConsumerOrderPriceAdjustmentRequest newInstance() {
    return new ConsumerOrderPriceAdjustmentRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ConsumerOrderPriceAdjustmentRequest resultByClass(
      Class<? extends ConsumerOrderPriceAdjustment> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ConsumerOrderPriceAdjustment";
  }

  public ConsumerOrderPriceAdjustmentRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectBizOrder()
        .selectAmount()
        .selectProvider()
        .selectVersion();
  }

  public ConsumerOrderPriceAdjustmentRequest selectAny() {
    return selectAll();
  }

  public ConsumerOrderPriceAdjustmentRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(PROVIDER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    BIZ_ORDER_PROPERTY,
    AMOUNT_PROPERTY,
    PROVIDER_PROPERTY,
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

  public ConsumerOrderPriceAdjustmentRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest comment(String comment) {
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest enhance() {
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest overrideClass(
      Class<? extends ConsumerOrderPriceAdjustment> clazz) {
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest count() {
    return countId("count");
  }

  public static ConsumerOrderPriceAdjustmentRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ConsumerOrderPriceAdjustmentRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ConsumerOrderPriceAdjustmentRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPriceAdjustmentRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest countId() {
    return countId("countId");
  }

  public ConsumerOrderPriceAdjustmentRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest maxId() {
    return maxId("maxId");
  }

  public ConsumerOrderPriceAdjustmentRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest minId() {
    return minId("minId");
  }

  public ConsumerOrderPriceAdjustmentRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ConsumerOrderPriceAdjustmentRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ConsumerOrderPriceAdjustmentRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPriceAdjustmentRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest countName() {
    return countName("countName");
  }

  public ConsumerOrderPriceAdjustmentRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest maxName() {
    return maxName("maxName");
  }

  public ConsumerOrderPriceAdjustmentRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest minName() {
    return minName("minName");
  }

  public ConsumerOrderPriceAdjustmentRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public ConsumerOrderPriceAdjustmentRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest whereAmountBetween(
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

  public ConsumerOrderPriceAdjustmentRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPriceAdjustmentRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest countAmount() {
    return countAmount("countAmount");
  }

  public ConsumerOrderPriceAdjustmentRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public ConsumerOrderPriceAdjustmentRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest minAmount() {
    return minAmount("minAmount");
  }

  public ConsumerOrderPriceAdjustmentRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public ConsumerOrderPriceAdjustmentRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest filterByProvider(String provider) {

    if (provider == null) {
      return this;
    }

    return filterByProvider(QueryOperator.EQUAL, provider);
  }

  public ConsumerOrderPriceAdjustmentRequest whereProviderIsNull() {
    return where(PROVIDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest whereProviderIsNotNull() {
    return where(PROVIDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest filterByProvider(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getProviderSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest selectProvider() {
    return select(PROVIDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest unselectProvider() {
    return unselect(PROVIDER_PROPERTY);
  }

  public SearchCriteria getProviderSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PROVIDER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPriceAdjustmentRequest orderByProvider(boolean asc) {
    addOrderBy(PROVIDER_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByProviderAscending() {
    addOrderBy(PROVIDER_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByProviderDescending() {
    addOrderBy(PROVIDER_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByProviderAscendingUsingGBK() {
    addOrderBy("convert(provider using gbk)", true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByProviderDescendingUsingGBK() {
    addOrderBy("convert(provider using gbk)", false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest countProvider() {
    return countProvider("countProvider");
  }

  public ConsumerOrderPriceAdjustmentRequest countProvider(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PROVIDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest maxProvider() {
    return maxProvider("maxProvider");
  }

  public ConsumerOrderPriceAdjustmentRequest maxProvider(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PROVIDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest minProvider() {
    return minProvider("minProvider");
  }

  public ConsumerOrderPriceAdjustmentRequest minProvider(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PROVIDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByProvider() {
    return groupByProvider(PROVIDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByProvider(String ret) {
    return groupBy(ret, PROVIDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByProvider(SqlFunction func) {
    return groupByProvider(PROVIDER_PROPERTY, func);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByProvider(String ret, SqlFunction func) {
    super.groupBy(ret, func, PROVIDER_PROPERTY);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ConsumerOrderPriceAdjustmentRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPriceAdjustmentRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPriceAdjustmentRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest countVersion() {
    return countVersion("countVersion");
  }

  public ConsumerOrderPriceAdjustmentRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ConsumerOrderPriceAdjustmentRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest minVersion() {
    return minVersion("minVersion");
  }

  public ConsumerOrderPriceAdjustmentRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ConsumerOrderPriceAdjustmentRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest filterByBizOrder(ConsumerOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, ConsumerOrder::getId);
  }

  public ConsumerOrderPriceAdjustmentRequest filterByBizOrder(ConsumerOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(ConsumerOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderPriceAdjustmentRequest selectBizOrderId() {
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

  public ConsumerOrderPriceAdjustmentRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderPriceAdjustmentRequest filterByBizOrder(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, ConsumerOrder.ID_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest selectBizOrder() {
    return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
  }

  public ConsumerOrderPriceAdjustmentRequest selectBizOrder(ConsumerOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest groupByBizOrder(ConsumerOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest aggregateBizOrder(ConsumerOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public ConsumerOrderPriceAdjustmentRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderPriceAdjustmentRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPriceAdjustmentRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ConsumerOrderPriceAdjustmentRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
