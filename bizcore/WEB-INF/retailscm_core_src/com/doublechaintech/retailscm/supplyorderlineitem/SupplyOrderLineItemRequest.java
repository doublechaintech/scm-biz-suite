package com.doublechaintech.retailscm.supplyorderlineitem;

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
import static com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem.*;

public class SupplyOrderLineItemRequest extends BaseRequest<SupplyOrderLineItem> {
  public static SupplyOrderLineItemRequest newInstance() {
    return new SupplyOrderLineItemRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SupplyOrderLineItemRequest resultByClass(Class<? extends SupplyOrderLineItem> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SupplyOrderLineItemRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SupplyOrderLineItemRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SupplyOrderLineItem";
  }

  public SupplyOrderLineItemRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SupplyOrderLineItemRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SupplyOrderLineItemRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SupplyOrderLineItemRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SupplyOrderLineItemRequest selectAll() {
    return this.selectId()
        .selectBizOrder()
        .selectSkuId()
        .selectSkuName()
        .selectAmount()
        .selectQuantity()
        .selectUnitOfMeasurement()
        .selectVersion();
  }

  public SupplyOrderLineItemRequest selectAny() {
    return selectAll();
  }

  public SupplyOrderLineItemRequest selectSelf() {
    select(ID_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(SKU_ID_PROPERTY);
    select(SKU_NAME_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(QUANTITY_PROPERTY);
    select(UNIT_OF_MEASUREMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SupplyOrderLineItemRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SupplyOrderLineItemRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    BIZ_ORDER_PROPERTY,
    SKU_ID_PROPERTY,
    SKU_NAME_PROPERTY,
    AMOUNT_PROPERTY,
    QUANTITY_PROPERTY,
    UNIT_OF_MEASUREMENT_PROPERTY,
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

  public SupplyOrderLineItemRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SupplyOrderLineItemRequest comment(String comment) {
    return this;
  }

  public SupplyOrderLineItemRequest enhance() {
    return this;
  }

  public SupplyOrderLineItemRequest overrideClass(Class<? extends SupplyOrderLineItem> clazz) {
    return this;
  }

  public SupplyOrderLineItemRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SupplyOrderLineItemRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SupplyOrderLineItemRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SupplyOrderLineItemRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SupplyOrderLineItemRequest count() {
    return countId("count");
  }

  public static SupplyOrderLineItemRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SupplyOrderLineItemRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SupplyOrderLineItemRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SupplyOrderLineItemRequest countId() {
    return countId("countId");
  }

  public SupplyOrderLineItemRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxId() {
    return maxId("maxId");
  }

  public SupplyOrderLineItemRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest minId() {
    return minId("minId");
  }

  public SupplyOrderLineItemRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterBySkuId(String skuId) {

    if (skuId == null) {
      return this;
    }

    return filterBySkuId(QueryOperator.EQUAL, skuId);
  }

  public SupplyOrderLineItemRequest whereSkuIdIsNull() {
    return where(SKU_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereSkuIdIsNotNull() {
    return where(SKU_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest filterBySkuId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSkuIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectSkuId() {
    return select(SKU_ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectSkuId() {
    return unselect(SKU_ID_PROPERTY);
  }

  public SearchCriteria getSkuIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SKU_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderBySkuId(boolean asc) {
    addOrderBy(SKU_ID_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuIdAscending() {
    addOrderBy(SKU_ID_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuIdDescending() {
    addOrderBy(SKU_ID_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuIdAscendingUsingGBK() {
    addOrderBy("convert(skuId using gbk)", true);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuIdDescendingUsingGBK() {
    addOrderBy("convert(skuId using gbk)", false);
    return this;
  }

  public SupplyOrderLineItemRequest countSkuId() {
    return countSkuId("countSkuId");
  }

  public SupplyOrderLineItemRequest countSkuId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxSkuId() {
    return maxSkuId("maxSkuId");
  }

  public SupplyOrderLineItemRequest maxSkuId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SKU_ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest minSkuId() {
    return minSkuId("minSkuId");
  }

  public SupplyOrderLineItemRequest minSkuId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SKU_ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupBySkuId() {
    return groupBySkuId(SKU_ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupBySkuId(String ret) {
    return groupBy(ret, SKU_ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupBySkuId(SqlFunction func) {
    return groupBySkuId(SKU_ID_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupBySkuId(String ret, SqlFunction func) {
    super.groupBy(ret, func, SKU_ID_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterBySkuName(String skuName) {

    if (skuName == null) {
      return this;
    }

    return filterBySkuName(QueryOperator.EQUAL, skuName);
  }

  public SupplyOrderLineItemRequest whereSkuNameIsNull() {
    return where(SKU_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereSkuNameIsNotNull() {
    return where(SKU_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest filterBySkuName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSkuNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectSkuName() {
    return select(SKU_NAME_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectSkuName() {
    return unselect(SKU_NAME_PROPERTY);
  }

  public SearchCriteria getSkuNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SKU_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderBySkuName(boolean asc) {
    addOrderBy(SKU_NAME_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuNameAscending() {
    addOrderBy(SKU_NAME_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuNameDescending() {
    addOrderBy(SKU_NAME_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuNameAscendingUsingGBK() {
    addOrderBy("convert(skuName using gbk)", true);
    return this;
  }

  public SupplyOrderLineItemRequest orderBySkuNameDescendingUsingGBK() {
    addOrderBy("convert(skuName using gbk)", false);
    return this;
  }

  public SupplyOrderLineItemRequest countSkuName() {
    return countSkuName("countSkuName");
  }

  public SupplyOrderLineItemRequest countSkuName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_NAME_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxSkuName() {
    return maxSkuName("maxSkuName");
  }

  public SupplyOrderLineItemRequest maxSkuName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SKU_NAME_PROPERTY);
  }

  public SupplyOrderLineItemRequest minSkuName() {
    return minSkuName("minSkuName");
  }

  public SupplyOrderLineItemRequest minSkuName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SKU_NAME_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupBySkuName() {
    return groupBySkuName(SKU_NAME_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupBySkuName(String ret) {
    return groupBy(ret, SKU_NAME_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupBySkuName(SqlFunction func) {
    return groupBySkuName(SKU_NAME_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupBySkuName(String ret, SqlFunction func) {
    super.groupBy(ret, func, SKU_NAME_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public SupplyOrderLineItemRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest whereAmountBetween(
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

  public SupplyOrderLineItemRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest countAmount() {
    return countAmount("countAmount");
  }

  public SupplyOrderLineItemRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public SupplyOrderLineItemRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest minAmount() {
    return minAmount("minAmount");
  }

  public SupplyOrderLineItemRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public SupplyOrderLineItemRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterByQuantity(int quantity) {

    return filterByQuantity(QueryOperator.EQUAL, quantity);
  }

  public SupplyOrderLineItemRequest whereQuantityIsNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereQuantityIsNotNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest whereQuantityBetween(
      Integer quantityStart, Integer quantityEnd) {
    if (ObjectUtil.isEmpty(quantityStart)) {
      throw new IllegalArgumentException(
          "Method whereQuantityBetween, the parameter quantityStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(quantityEnd)) {
      throw new IllegalArgumentException(
          "Method whereQuantityBetween, the parameter quantityEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.BETWEEN, new Object[] {quantityStart, quantityEnd});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest whereQuantityLessThan(Integer quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityLessThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.LESS_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest whereQuantityGreaterThan(int quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityGreaterThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.GREATER_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest filterByQuantity(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectQuantity() {
    return select(QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectQuantity() {
    return unselect(QUANTITY_PROPERTY);
  }

  public SearchCriteria getQuantitySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderByQuantity(boolean asc) {
    addOrderBy(QUANTITY_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderByQuantityAscending() {
    addOrderBy(QUANTITY_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByQuantityDescending() {
    addOrderBy(QUANTITY_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest countQuantity() {
    return countQuantity("countQuantity");
  }

  public SupplyOrderLineItemRequest countQuantity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxQuantity() {
    return maxQuantity("maxQuantity");
  }

  public SupplyOrderLineItemRequest maxQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest minQuantity() {
    return minQuantity("minQuantity");
  }

  public SupplyOrderLineItemRequest minQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest sumQuantity() {
    return sumQuantity("sumQuantity");
  }

  public SupplyOrderLineItemRequest sumQuantity(String aggName) {
    return aggregate(aggName, AggFunc.SUM, QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByQuantity() {
    return groupByQuantity(QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByQuantity(String ret) {
    return groupBy(ret, QUANTITY_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByQuantity(SqlFunction func) {
    return groupByQuantity(QUANTITY_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupByQuantity(String ret, SqlFunction func) {
    super.groupBy(ret, func, QUANTITY_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterByUnitOfMeasurement(String unitOfMeasurement) {

    if (unitOfMeasurement == null) {
      return this;
    }

    return filterByUnitOfMeasurement(QueryOperator.EQUAL, unitOfMeasurement);
  }

  public SupplyOrderLineItemRequest whereUnitOfMeasurementIsNull() {
    return where(UNIT_OF_MEASUREMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereUnitOfMeasurementIsNotNull() {
    return where(UNIT_OF_MEASUREMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest filterByUnitOfMeasurement(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUnitOfMeasurementSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectUnitOfMeasurement() {
    return select(UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectUnitOfMeasurement() {
    return unselect(UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SearchCriteria getUnitOfMeasurementSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(UNIT_OF_MEASUREMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderByUnitOfMeasurement(boolean asc) {
    addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderByUnitOfMeasurementAscending() {
    addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByUnitOfMeasurementDescending() {
    addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest orderByUnitOfMeasurementAscendingUsingGBK() {
    addOrderBy("convert(unitOfMeasurement using gbk)", true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByUnitOfMeasurementDescendingUsingGBK() {
    addOrderBy("convert(unitOfMeasurement using gbk)", false);
    return this;
  }

  public SupplyOrderLineItemRequest countUnitOfMeasurement() {
    return countUnitOfMeasurement("countUnitOfMeasurement");
  }

  public SupplyOrderLineItemRequest countUnitOfMeasurement(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxUnitOfMeasurement() {
    return maxUnitOfMeasurement("maxUnitOfMeasurement");
  }

  public SupplyOrderLineItemRequest maxUnitOfMeasurement(String aggName) {
    return aggregate(aggName, AggFunc.MAX, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SupplyOrderLineItemRequest minUnitOfMeasurement() {
    return minUnitOfMeasurement("minUnitOfMeasurement");
  }

  public SupplyOrderLineItemRequest minUnitOfMeasurement(String aggName) {
    return aggregate(aggName, AggFunc.MIN, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByUnitOfMeasurement() {
    return groupByUnitOfMeasurement(UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByUnitOfMeasurement(String ret) {
    return groupBy(ret, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByUnitOfMeasurement(SqlFunction func) {
    return groupByUnitOfMeasurement(UNIT_OF_MEASUREMENT_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupByUnitOfMeasurement(String ret, SqlFunction func) {
    super.groupBy(ret, func, UNIT_OF_MEASUREMENT_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SupplyOrderLineItemRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderLineItemRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderLineItemRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SupplyOrderLineItemRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SupplyOrderLineItemRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SupplyOrderLineItemRequest countVersion() {
    return countVersion("countVersion");
  }

  public SupplyOrderLineItemRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SupplyOrderLineItemRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest minVersion() {
    return minVersion("minVersion");
  }

  public SupplyOrderLineItemRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SupplyOrderLineItemRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SupplyOrderLineItemRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest filterByBizOrder(SupplyOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, SupplyOrder::getId);
  }

  public SupplyOrderLineItemRequest filterByBizOrder(SupplyOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(SupplyOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public SupplyOrderLineItemRequest selectBizOrderId() {
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

  public SupplyOrderLineItemRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public SupplyOrderLineItemRequest filterByBizOrder(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine, SupplyOrder.ID_PROPERTY);
  }

  public SupplyOrderLineItemRequest selectBizOrder() {
    return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
  }

  public SupplyOrderLineItemRequest selectBizOrder(SupplyOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderLineItemRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public SupplyOrderLineItemRequest groupByBizOrder(SupplyOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderLineItemRequest aggregateBizOrder(SupplyOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderLineItemRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public SupplyOrderLineItemRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderLineItemRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderLineItemRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderLineItemRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderLineItemRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SupplyOrderLineItemRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SupplyOrderLineItemRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SupplyOrderLineItemRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
