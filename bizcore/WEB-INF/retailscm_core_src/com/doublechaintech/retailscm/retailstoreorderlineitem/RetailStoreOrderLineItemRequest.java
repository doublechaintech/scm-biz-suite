package com.doublechaintech.retailscm.retailstoreorderlineitem;

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
import static com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem.*;

public class RetailStoreOrderLineItemRequest extends BaseRequest<RetailStoreOrderLineItem> {
  public static RetailStoreOrderLineItemRequest newInstance() {
    return new RetailStoreOrderLineItemRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreOrderLineItemRequest resultByClass(
      Class<? extends RetailStoreOrderLineItem> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreOrderLineItemRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreOrderLineItemRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreOrderLineItem";
  }

  public RetailStoreOrderLineItemRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreOrderLineItemRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreOrderLineItemRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreOrderLineItemRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreOrderLineItemRequest selectAll() {
    return this.selectId()
        .selectBizOrder()
        .selectSkuId()
        .selectSkuName()
        .selectAmount()
        .selectQuantity()
        .selectUnitOfMeasurement()
        .selectVersion();
  }

  public RetailStoreOrderLineItemRequest selectAny() {
    return selectAll();
  }

  public RetailStoreOrderLineItemRequest selectSelf() {
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

  public RetailStoreOrderLineItemRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreOrderLineItemRequest where(
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

  public RetailStoreOrderLineItemRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreOrderLineItemRequest comment(String comment) {
    return this;
  }

  public RetailStoreOrderLineItemRequest enhance() {
    return this;
  }

  public RetailStoreOrderLineItemRequest overrideClass(
      Class<? extends RetailStoreOrderLineItem> clazz) {
    return this;
  }

  public RetailStoreOrderLineItemRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreOrderLineItemRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreOrderLineItemRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreOrderLineItemRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreOrderLineItemRequest count() {
    return countId("count");
  }

  public static RetailStoreOrderLineItemRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreOrderLineItemRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreOrderLineItemRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countId() {
    return countId("countId");
  }

  public RetailStoreOrderLineItemRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreOrderLineItemRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minId() {
    return minId("minId");
  }

  public RetailStoreOrderLineItemRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterBySkuId(String skuId) {

    if (skuId == null) {
      return this;
    }

    return filterBySkuId(QueryOperator.EQUAL, skuId);
  }

  public RetailStoreOrderLineItemRequest whereSkuIdIsNull() {
    return where(SKU_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereSkuIdIsNotNull() {
    return where(SKU_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest filterBySkuId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSkuIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectSkuId() {
    return select(SKU_ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectSkuId() {
    return unselect(SKU_ID_PROPERTY);
  }

  public SearchCriteria getSkuIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SKU_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderBySkuId(boolean asc) {
    addOrderBy(SKU_ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuIdAscending() {
    addOrderBy(SKU_ID_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuIdDescending() {
    addOrderBy(SKU_ID_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuIdAscendingUsingGBK() {
    addOrderBy("convert(skuId using gbk)", true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuIdDescendingUsingGBK() {
    addOrderBy("convert(skuId using gbk)", false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countSkuId() {
    return countSkuId("countSkuId");
  }

  public RetailStoreOrderLineItemRequest countSkuId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxSkuId() {
    return maxSkuId("maxSkuId");
  }

  public RetailStoreOrderLineItemRequest maxSkuId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SKU_ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minSkuId() {
    return minSkuId("minSkuId");
  }

  public RetailStoreOrderLineItemRequest minSkuId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SKU_ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupBySkuId() {
    return groupBySkuId(SKU_ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupBySkuId(String ret) {
    return groupBy(ret, SKU_ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupBySkuId(SqlFunction func) {
    return groupBySkuId(SKU_ID_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupBySkuId(String ret, SqlFunction func) {
    super.groupBy(ret, func, SKU_ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterBySkuName(String skuName) {

    if (skuName == null) {
      return this;
    }

    return filterBySkuName(QueryOperator.EQUAL, skuName);
  }

  public RetailStoreOrderLineItemRequest whereSkuNameIsNull() {
    return where(SKU_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereSkuNameIsNotNull() {
    return where(SKU_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest filterBySkuName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSkuNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectSkuName() {
    return select(SKU_NAME_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectSkuName() {
    return unselect(SKU_NAME_PROPERTY);
  }

  public SearchCriteria getSkuNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SKU_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderBySkuName(boolean asc) {
    addOrderBy(SKU_NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuNameAscending() {
    addOrderBy(SKU_NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuNameDescending() {
    addOrderBy(SKU_NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuNameAscendingUsingGBK() {
    addOrderBy("convert(skuName using gbk)", true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderBySkuNameDescendingUsingGBK() {
    addOrderBy("convert(skuName using gbk)", false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countSkuName() {
    return countSkuName("countSkuName");
  }

  public RetailStoreOrderLineItemRequest countSkuName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_NAME_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxSkuName() {
    return maxSkuName("maxSkuName");
  }

  public RetailStoreOrderLineItemRequest maxSkuName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SKU_NAME_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minSkuName() {
    return minSkuName("minSkuName");
  }

  public RetailStoreOrderLineItemRequest minSkuName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SKU_NAME_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupBySkuName() {
    return groupBySkuName(SKU_NAME_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupBySkuName(String ret) {
    return groupBy(ret, SKU_NAME_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupBySkuName(SqlFunction func) {
    return groupBySkuName(SKU_NAME_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupBySkuName(String ret, SqlFunction func) {
    super.groupBy(ret, func, SKU_NAME_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public RetailStoreOrderLineItemRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest whereAmountBetween(
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

  public RetailStoreOrderLineItemRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countAmount() {
    return countAmount("countAmount");
  }

  public RetailStoreOrderLineItemRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public RetailStoreOrderLineItemRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minAmount() {
    return minAmount("minAmount");
  }

  public RetailStoreOrderLineItemRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public RetailStoreOrderLineItemRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterByQuantity(int quantity) {

    return filterByQuantity(QueryOperator.EQUAL, quantity);
  }

  public RetailStoreOrderLineItemRequest whereQuantityIsNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereQuantityIsNotNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest whereQuantityBetween(
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

  public RetailStoreOrderLineItemRequest whereQuantityLessThan(Integer quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityLessThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.LESS_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest whereQuantityGreaterThan(int quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityGreaterThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.GREATER_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest filterByQuantity(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectQuantity() {
    return select(QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectQuantity() {
    return unselect(QUANTITY_PROPERTY);
  }

  public SearchCriteria getQuantitySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderByQuantity(boolean asc) {
    addOrderBy(QUANTITY_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByQuantityAscending() {
    addOrderBy(QUANTITY_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByQuantityDescending() {
    addOrderBy(QUANTITY_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countQuantity() {
    return countQuantity("countQuantity");
  }

  public RetailStoreOrderLineItemRequest countQuantity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxQuantity() {
    return maxQuantity("maxQuantity");
  }

  public RetailStoreOrderLineItemRequest maxQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minQuantity() {
    return minQuantity("minQuantity");
  }

  public RetailStoreOrderLineItemRequest minQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest sumQuantity() {
    return sumQuantity("sumQuantity");
  }

  public RetailStoreOrderLineItemRequest sumQuantity(String aggName) {
    return aggregate(aggName, AggFunc.SUM, QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByQuantity() {
    return groupByQuantity(QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByQuantity(String ret) {
    return groupBy(ret, QUANTITY_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByQuantity(SqlFunction func) {
    return groupByQuantity(QUANTITY_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupByQuantity(String ret, SqlFunction func) {
    super.groupBy(ret, func, QUANTITY_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterByUnitOfMeasurement(String unitOfMeasurement) {

    if (unitOfMeasurement == null) {
      return this;
    }

    return filterByUnitOfMeasurement(QueryOperator.EQUAL, unitOfMeasurement);
  }

  public RetailStoreOrderLineItemRequest whereUnitOfMeasurementIsNull() {
    return where(UNIT_OF_MEASUREMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereUnitOfMeasurementIsNotNull() {
    return where(UNIT_OF_MEASUREMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest filterByUnitOfMeasurement(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUnitOfMeasurementSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectUnitOfMeasurement() {
    return select(UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectUnitOfMeasurement() {
    return unselect(UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public SearchCriteria getUnitOfMeasurementSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(UNIT_OF_MEASUREMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderByUnitOfMeasurement(boolean asc) {
    addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByUnitOfMeasurementAscending() {
    addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByUnitOfMeasurementDescending() {
    addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByUnitOfMeasurementAscendingUsingGBK() {
    addOrderBy("convert(unitOfMeasurement using gbk)", true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByUnitOfMeasurementDescendingUsingGBK() {
    addOrderBy("convert(unitOfMeasurement using gbk)", false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countUnitOfMeasurement() {
    return countUnitOfMeasurement("countUnitOfMeasurement");
  }

  public RetailStoreOrderLineItemRequest countUnitOfMeasurement(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxUnitOfMeasurement() {
    return maxUnitOfMeasurement("maxUnitOfMeasurement");
  }

  public RetailStoreOrderLineItemRequest maxUnitOfMeasurement(String aggName) {
    return aggregate(aggName, AggFunc.MAX, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minUnitOfMeasurement() {
    return minUnitOfMeasurement("minUnitOfMeasurement");
  }

  public RetailStoreOrderLineItemRequest minUnitOfMeasurement(String aggName) {
    return aggregate(aggName, AggFunc.MIN, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByUnitOfMeasurement() {
    return groupByUnitOfMeasurement(UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByUnitOfMeasurement(String ret) {
    return groupBy(ret, UNIT_OF_MEASUREMENT_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByUnitOfMeasurement(SqlFunction func) {
    return groupByUnitOfMeasurement(UNIT_OF_MEASUREMENT_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupByUnitOfMeasurement(String ret, SqlFunction func) {
    super.groupBy(ret, func, UNIT_OF_MEASUREMENT_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreOrderLineItemRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderLineItemRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderLineItemRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderLineItemRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderLineItemRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreOrderLineItemRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreOrderLineItemRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreOrderLineItemRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreOrderLineItemRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreOrderLineItemRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest filterByBizOrder(RetailStoreOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, RetailStoreOrder::getId);
  }

  public RetailStoreOrderLineItemRequest filterByBizOrder(RetailStoreOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(RetailStoreOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreOrderLineItemRequest selectBizOrderId() {
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

  public RetailStoreOrderLineItemRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreOrderLineItemRequest filterByBizOrder(
      RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, RetailStoreOrder.ID_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest selectBizOrder() {
    return selectBizOrder(RetailStoreOrderRequest.newInstance().selectSelf());
  }

  public RetailStoreOrderLineItemRequest selectBizOrder(RetailStoreOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderLineItemRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItemRequest groupByBizOrder(RetailStoreOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderLineItemRequest aggregateBizOrder(RetailStoreOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderLineItemRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public RetailStoreOrderLineItemRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderLineItemRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderLineItemRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderLineItemRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreOrderLineItemRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreOrderLineItemRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreOrderLineItemRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
