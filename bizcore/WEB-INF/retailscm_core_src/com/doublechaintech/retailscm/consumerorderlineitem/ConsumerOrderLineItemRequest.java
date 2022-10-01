package com.doublechaintech.retailscm.consumerorderlineitem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem.*;

public class ConsumerOrderLineItemRequest extends BaseRequest<ConsumerOrderLineItem> {
  public static ConsumerOrderLineItemRequest newInstance() {
    return new ConsumerOrderLineItemRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ConsumerOrderLineItemRequest resultByClass(Class<? extends ConsumerOrderLineItem> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ConsumerOrderLineItemRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ConsumerOrderLineItemRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ConsumerOrderLineItem";
  }

  public ConsumerOrderLineItemRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ConsumerOrderLineItemRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ConsumerOrderLineItemRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ConsumerOrderLineItemRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ConsumerOrderLineItemRequest selectAll() {
    return this.selectId()
        .selectBizOrder()
        .selectSkuId()
        .selectSkuName()
        .selectPrice()
        .selectQuantity()
        .selectAmount()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public ConsumerOrderLineItemRequest selectAny() {
    return selectAll();
  }

  public ConsumerOrderLineItemRequest selectSelf() {
    select(ID_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(SKU_ID_PROPERTY);
    select(SKU_NAME_PROPERTY);
    select(PRICE_PROPERTY);
    select(QUANTITY_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ConsumerOrderLineItemRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ConsumerOrderLineItemRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    BIZ_ORDER_PROPERTY,
    SKU_ID_PROPERTY,
    SKU_NAME_PROPERTY,
    PRICE_PROPERTY,
    QUANTITY_PROPERTY,
    AMOUNT_PROPERTY,
    LAST_UPDATE_TIME_PROPERTY,
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

  public ConsumerOrderLineItemRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ConsumerOrderLineItemRequest comment(String comment) {
    return this;
  }

  public ConsumerOrderLineItemRequest enhance() {
    return this;
  }

  public ConsumerOrderLineItemRequest overrideClass(Class<? extends ConsumerOrderLineItem> clazz) {
    return this;
  }

  public ConsumerOrderLineItemRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ConsumerOrderLineItemRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ConsumerOrderLineItemRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ConsumerOrderLineItemRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ConsumerOrderLineItemRequest count() {
    return countId("count");
  }

  public static ConsumerOrderLineItemRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ConsumerOrderLineItemRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ConsumerOrderLineItemRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ConsumerOrderLineItemRequest countId() {
    return countId("countId");
  }

  public ConsumerOrderLineItemRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxId() {
    return maxId("maxId");
  }

  public ConsumerOrderLineItemRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minId() {
    return minId("minId");
  }

  public ConsumerOrderLineItemRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterBySkuId(String skuId) {

    if (skuId == null) {
      return this;
    }

    return filterBySkuId(QueryOperator.EQUAL, skuId);
  }

  public ConsumerOrderLineItemRequest whereSkuIdIsNull() {
    return where(SKU_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereSkuIdIsNotNull() {
    return where(SKU_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest filterBySkuId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSkuIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectSkuId() {
    return select(SKU_ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectSkuId() {
    return unselect(SKU_ID_PROPERTY);
  }

  public SearchCriteria getSkuIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SKU_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderBySkuId(boolean asc) {
    addOrderBy(SKU_ID_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuIdAscending() {
    addOrderBy(SKU_ID_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuIdDescending() {
    addOrderBy(SKU_ID_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuIdAscendingUsingGBK() {
    addOrderBy("convert(skuId using gbk)", true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuIdDescendingUsingGBK() {
    addOrderBy("convert(skuId using gbk)", false);
    return this;
  }

  public ConsumerOrderLineItemRequest countSkuId() {
    return countSkuId("countSkuId");
  }

  public ConsumerOrderLineItemRequest countSkuId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxSkuId() {
    return maxSkuId("maxSkuId");
  }

  public ConsumerOrderLineItemRequest maxSkuId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SKU_ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minSkuId() {
    return minSkuId("minSkuId");
  }

  public ConsumerOrderLineItemRequest minSkuId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SKU_ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupBySkuId() {
    return groupBySkuId(SKU_ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupBySkuId(String ret) {
    return groupBy(ret, SKU_ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupBySkuId(SqlFunction func) {
    return groupBySkuId(SKU_ID_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupBySkuId(String ret, SqlFunction func) {
    super.groupBy(ret, func, SKU_ID_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterBySkuName(String skuName) {

    if (skuName == null) {
      return this;
    }

    return filterBySkuName(QueryOperator.EQUAL, skuName);
  }

  public ConsumerOrderLineItemRequest whereSkuNameIsNull() {
    return where(SKU_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereSkuNameIsNotNull() {
    return where(SKU_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest filterBySkuName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSkuNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectSkuName() {
    return select(SKU_NAME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectSkuName() {
    return unselect(SKU_NAME_PROPERTY);
  }

  public SearchCriteria getSkuNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SKU_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderBySkuName(boolean asc) {
    addOrderBy(SKU_NAME_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuNameAscending() {
    addOrderBy(SKU_NAME_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuNameDescending() {
    addOrderBy(SKU_NAME_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuNameAscendingUsingGBK() {
    addOrderBy("convert(skuName using gbk)", true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderBySkuNameDescendingUsingGBK() {
    addOrderBy("convert(skuName using gbk)", false);
    return this;
  }

  public ConsumerOrderLineItemRequest countSkuName() {
    return countSkuName("countSkuName");
  }

  public ConsumerOrderLineItemRequest countSkuName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_NAME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxSkuName() {
    return maxSkuName("maxSkuName");
  }

  public ConsumerOrderLineItemRequest maxSkuName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SKU_NAME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minSkuName() {
    return minSkuName("minSkuName");
  }

  public ConsumerOrderLineItemRequest minSkuName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SKU_NAME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupBySkuName() {
    return groupBySkuName(SKU_NAME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupBySkuName(String ret) {
    return groupBy(ret, SKU_NAME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupBySkuName(SqlFunction func) {
    return groupBySkuName(SKU_NAME_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupBySkuName(String ret, SqlFunction func) {
    super.groupBy(ret, func, SKU_NAME_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterByPrice(BigDecimal price) {

    if (price == null) {
      return this;
    }

    return filterByPrice(QueryOperator.EQUAL, price);
  }

  public ConsumerOrderLineItemRequest wherePriceIsNull() {
    return where(PRICE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest wherePriceIsNotNull() {
    return where(PRICE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest wherePriceBetween(
      BigDecimal priceStart, BigDecimal priceEnd) {
    if (ObjectUtil.isEmpty(priceStart)) {
      throw new IllegalArgumentException(
          "Method wherePriceBetween, the parameter priceStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(priceEnd)) {
      throw new IllegalArgumentException(
          "Method wherePriceBetween, the parameter priceEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.BETWEEN, new Object[] {priceStart, priceEnd});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest wherePriceLessThan(BigDecimal price) {
    if (ObjectUtil.isEmpty(price)) {
      throw new IllegalArgumentException(
          "Method wherePriceLessThan, the parameter price is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.LESS_THAN, new Object[] {price});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest wherePriceGreaterThan(BigDecimal price) {
    if (ObjectUtil.isEmpty(price)) {
      throw new IllegalArgumentException(
          "Method wherePriceGreaterThan, the parameter price is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {price});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest filterByPrice(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPriceSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectPrice() {
    return select(PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectPrice() {
    return unselect(PRICE_PROPERTY);
  }

  public SearchCriteria getPriceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PRICE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderByPrice(boolean asc) {
    addOrderBy(PRICE_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByPriceAscending() {
    addOrderBy(PRICE_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByPriceDescending() {
    addOrderBy(PRICE_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest countPrice() {
    return countPrice("countPrice");
  }

  public ConsumerOrderLineItemRequest countPrice(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxPrice() {
    return maxPrice("maxPrice");
  }

  public ConsumerOrderLineItemRequest maxPrice(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minPrice() {
    return minPrice("minPrice");
  }

  public ConsumerOrderLineItemRequest minPrice(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest sumPrice() {
    return sumPrice("sumPrice");
  }

  public ConsumerOrderLineItemRequest sumPrice(String aggName) {
    return aggregate(aggName, AggFunc.SUM, PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByPrice() {
    return groupByPrice(PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByPrice(String ret) {
    return groupBy(ret, PRICE_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByPrice(SqlFunction func) {
    return groupByPrice(PRICE_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupByPrice(String ret, SqlFunction func) {
    super.groupBy(ret, func, PRICE_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterByQuantity(BigDecimal quantity) {

    if (quantity == null) {
      return this;
    }

    return filterByQuantity(QueryOperator.EQUAL, quantity);
  }

  public ConsumerOrderLineItemRequest whereQuantityIsNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereQuantityIsNotNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest whereQuantityBetween(
      BigDecimal quantityStart, BigDecimal quantityEnd) {
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

  public ConsumerOrderLineItemRequest whereQuantityLessThan(BigDecimal quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityLessThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.LESS_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest whereQuantityGreaterThan(BigDecimal quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityGreaterThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.GREATER_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest filterByQuantity(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectQuantity() {
    return select(QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectQuantity() {
    return unselect(QUANTITY_PROPERTY);
  }

  public SearchCriteria getQuantitySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderByQuantity(boolean asc) {
    addOrderBy(QUANTITY_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByQuantityAscending() {
    addOrderBy(QUANTITY_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByQuantityDescending() {
    addOrderBy(QUANTITY_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest countQuantity() {
    return countQuantity("countQuantity");
  }

  public ConsumerOrderLineItemRequest countQuantity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxQuantity() {
    return maxQuantity("maxQuantity");
  }

  public ConsumerOrderLineItemRequest maxQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minQuantity() {
    return minQuantity("minQuantity");
  }

  public ConsumerOrderLineItemRequest minQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest sumQuantity() {
    return sumQuantity("sumQuantity");
  }

  public ConsumerOrderLineItemRequest sumQuantity(String aggName) {
    return aggregate(aggName, AggFunc.SUM, QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByQuantity() {
    return groupByQuantity(QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByQuantity(String ret) {
    return groupBy(ret, QUANTITY_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByQuantity(SqlFunction func) {
    return groupByQuantity(QUANTITY_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupByQuantity(String ret, SqlFunction func) {
    super.groupBy(ret, func, QUANTITY_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public ConsumerOrderLineItemRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest whereAmountBetween(
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

  public ConsumerOrderLineItemRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest countAmount() {
    return countAmount("countAmount");
  }

  public ConsumerOrderLineItemRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public ConsumerOrderLineItemRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minAmount() {
    return minAmount("minAmount");
  }

  public ConsumerOrderLineItemRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public ConsumerOrderLineItemRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public ConsumerOrderLineItemRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public ConsumerOrderLineItemRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public ConsumerOrderLineItemRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public ConsumerOrderLineItemRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ConsumerOrderLineItemRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderLineItemRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderLineItemRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ConsumerOrderLineItemRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ConsumerOrderLineItemRequest countVersion() {
    return countVersion("countVersion");
  }

  public ConsumerOrderLineItemRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ConsumerOrderLineItemRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest minVersion() {
    return minVersion("minVersion");
  }

  public ConsumerOrderLineItemRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ConsumerOrderLineItemRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ConsumerOrderLineItemRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest filterByBizOrder(ConsumerOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, ConsumerOrder::getId);
  }

  public ConsumerOrderLineItemRequest filterByBizOrder(ConsumerOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(ConsumerOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderLineItemRequest selectBizOrderId() {
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

  public ConsumerOrderLineItemRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderLineItemRequest filterByBizOrder(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, ConsumerOrder.ID_PROPERTY);
  }

  public ConsumerOrderLineItemRequest selectBizOrder() {
    return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
  }

  public ConsumerOrderLineItemRequest selectBizOrder(ConsumerOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderLineItemRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderLineItemRequest groupByBizOrder(ConsumerOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderLineItemRequest aggregateBizOrder(ConsumerOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderLineItemRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public ConsumerOrderLineItemRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderLineItemRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderLineItemRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderLineItemRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderLineItemRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ConsumerOrderLineItemRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ConsumerOrderLineItemRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ConsumerOrderLineItemRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
