package com.doublechaintech.retailscm.productsupplyduration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration.*;

public class ProductSupplyDurationRequest extends BaseRequest<ProductSupplyDuration> {
  public static ProductSupplyDurationRequest newInstance() {
    return new ProductSupplyDurationRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ProductSupplyDurationRequest resultByClass(Class<? extends ProductSupplyDuration> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ProductSupplyDurationRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ProductSupplyDurationRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ProductSupplyDuration";
  }

  public ProductSupplyDurationRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ProductSupplyDurationRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ProductSupplyDurationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ProductSupplyDurationRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ProductSupplyDurationRequest selectAll() {
    return this.selectId()
        .selectQuantity()
        .selectDuration()
        .selectPrice()
        .selectProduct()
        .selectVersion();
  }

  public ProductSupplyDurationRequest selectAny() {
    return selectAll();
  }

  public ProductSupplyDurationRequest selectSelf() {
    select(ID_PROPERTY);
    select(QUANTITY_PROPERTY);
    select(DURATION_PROPERTY);
    select(PRICE_PROPERTY);
    select(PRODUCT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ProductSupplyDurationRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ProductSupplyDurationRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    QUANTITY_PROPERTY,
    DURATION_PROPERTY,
    PRICE_PROPERTY,
    PRODUCT_PROPERTY,
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

  public ProductSupplyDurationRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ProductSupplyDurationRequest comment(String comment) {
    return this;
  }

  public ProductSupplyDurationRequest enhance() {
    return this;
  }

  public ProductSupplyDurationRequest overrideClass(Class<? extends ProductSupplyDuration> clazz) {
    return this;
  }

  public ProductSupplyDurationRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ProductSupplyDurationRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ProductSupplyDurationRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ProductSupplyDurationRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ProductSupplyDurationRequest count() {
    return countId("count");
  }

  public static ProductSupplyDurationRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ProductSupplyDurationRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ProductSupplyDurationRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ProductSupplyDurationRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductSupplyDurationRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ProductSupplyDurationRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ProductSupplyDurationRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ProductSupplyDurationRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ProductSupplyDurationRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ProductSupplyDurationRequest countId() {
    return countId("countId");
  }

  public ProductSupplyDurationRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ProductSupplyDurationRequest maxId() {
    return maxId("maxId");
  }

  public ProductSupplyDurationRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ProductSupplyDurationRequest minId() {
    return minId("minId");
  }

  public ProductSupplyDurationRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ProductSupplyDurationRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ProductSupplyDurationRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ProductSupplyDurationRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ProductSupplyDurationRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ProductSupplyDurationRequest filterByQuantity(int quantity) {

    return filterByQuantity(QueryOperator.EQUAL, quantity);
  }

  public ProductSupplyDurationRequest whereQuantityIsNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductSupplyDurationRequest whereQuantityIsNotNull() {
    return where(QUANTITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductSupplyDurationRequest whereQuantityBetween(
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

  public ProductSupplyDurationRequest whereQuantityLessThan(Integer quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityLessThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.LESS_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest whereQuantityGreaterThan(int quantity) {
    if (ObjectUtil.isEmpty(quantity)) {
      throw new IllegalArgumentException(
          "Method whereQuantityGreaterThan, the parameter quantity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQuantitySearchCriteria(QueryOperator.GREATER_THAN, new Object[] {quantity});
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest filterByQuantity(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest selectQuantity() {
    return select(QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest unselectQuantity() {
    return unselect(QUANTITY_PROPERTY);
  }

  public SearchCriteria getQuantitySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductSupplyDurationRequest orderByQuantity(boolean asc) {
    addOrderBy(QUANTITY_PROPERTY, asc);
    return this;
  }

  public ProductSupplyDurationRequest orderByQuantityAscending() {
    addOrderBy(QUANTITY_PROPERTY, true);
    return this;
  }

  public ProductSupplyDurationRequest orderByQuantityDescending() {
    addOrderBy(QUANTITY_PROPERTY, false);
    return this;
  }

  public ProductSupplyDurationRequest countQuantity() {
    return countQuantity("countQuantity");
  }

  public ProductSupplyDurationRequest countQuantity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest maxQuantity() {
    return maxQuantity("maxQuantity");
  }

  public ProductSupplyDurationRequest maxQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest minQuantity() {
    return minQuantity("minQuantity");
  }

  public ProductSupplyDurationRequest minQuantity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest sumQuantity() {
    return sumQuantity("sumQuantity");
  }

  public ProductSupplyDurationRequest sumQuantity(String aggName) {
    return aggregate(aggName, AggFunc.SUM, QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByQuantity() {
    return groupByQuantity(QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByQuantity(String ret) {
    return groupBy(ret, QUANTITY_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByQuantity(SqlFunction func) {
    return groupByQuantity(QUANTITY_PROPERTY, func);
  }

  public ProductSupplyDurationRequest groupByQuantity(String ret, SqlFunction func) {
    super.groupBy(ret, func, QUANTITY_PROPERTY);
    return this;
  }

  public ProductSupplyDurationRequest filterByDuration(String duration) {

    if (duration == null) {
      return this;
    }

    return filterByDuration(QueryOperator.EQUAL, duration);
  }

  public ProductSupplyDurationRequest whereDurationIsNull() {
    return where(DURATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductSupplyDurationRequest whereDurationIsNotNull() {
    return where(DURATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductSupplyDurationRequest filterByDuration(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDurationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest selectDuration() {
    return select(DURATION_PROPERTY);
  }

  public ProductSupplyDurationRequest unselectDuration() {
    return unselect(DURATION_PROPERTY);
  }

  public SearchCriteria getDurationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DURATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductSupplyDurationRequest orderByDuration(boolean asc) {
    addOrderBy(DURATION_PROPERTY, asc);
    return this;
  }

  public ProductSupplyDurationRequest orderByDurationAscending() {
    addOrderBy(DURATION_PROPERTY, true);
    return this;
  }

  public ProductSupplyDurationRequest orderByDurationDescending() {
    addOrderBy(DURATION_PROPERTY, false);
    return this;
  }

  public ProductSupplyDurationRequest orderByDurationAscendingUsingGBK() {
    addOrderBy("convert(duration using gbk)", true);
    return this;
  }

  public ProductSupplyDurationRequest orderByDurationDescendingUsingGBK() {
    addOrderBy("convert(duration using gbk)", false);
    return this;
  }

  public ProductSupplyDurationRequest countDuration() {
    return countDuration("countDuration");
  }

  public ProductSupplyDurationRequest countDuration(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DURATION_PROPERTY);
  }

  public ProductSupplyDurationRequest maxDuration() {
    return maxDuration("maxDuration");
  }

  public ProductSupplyDurationRequest maxDuration(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DURATION_PROPERTY);
  }

  public ProductSupplyDurationRequest minDuration() {
    return minDuration("minDuration");
  }

  public ProductSupplyDurationRequest minDuration(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DURATION_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByDuration() {
    return groupByDuration(DURATION_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByDuration(String ret) {
    return groupBy(ret, DURATION_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByDuration(SqlFunction func) {
    return groupByDuration(DURATION_PROPERTY, func);
  }

  public ProductSupplyDurationRequest groupByDuration(String ret, SqlFunction func) {
    super.groupBy(ret, func, DURATION_PROPERTY);
    return this;
  }

  public ProductSupplyDurationRequest filterByPrice(BigDecimal price) {

    if (price == null) {
      return this;
    }

    return filterByPrice(QueryOperator.EQUAL, price);
  }

  public ProductSupplyDurationRequest wherePriceIsNull() {
    return where(PRICE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductSupplyDurationRequest wherePriceIsNotNull() {
    return where(PRICE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductSupplyDurationRequest wherePriceBetween(
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

  public ProductSupplyDurationRequest wherePriceLessThan(BigDecimal price) {
    if (ObjectUtil.isEmpty(price)) {
      throw new IllegalArgumentException(
          "Method wherePriceLessThan, the parameter price is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.LESS_THAN, new Object[] {price});
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest wherePriceGreaterThan(BigDecimal price) {
    if (ObjectUtil.isEmpty(price)) {
      throw new IllegalArgumentException(
          "Method wherePriceGreaterThan, the parameter price is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {price});
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest filterByPrice(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPriceSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest selectPrice() {
    return select(PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest unselectPrice() {
    return unselect(PRICE_PROPERTY);
  }

  public SearchCriteria getPriceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PRICE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductSupplyDurationRequest orderByPrice(boolean asc) {
    addOrderBy(PRICE_PROPERTY, asc);
    return this;
  }

  public ProductSupplyDurationRequest orderByPriceAscending() {
    addOrderBy(PRICE_PROPERTY, true);
    return this;
  }

  public ProductSupplyDurationRequest orderByPriceDescending() {
    addOrderBy(PRICE_PROPERTY, false);
    return this;
  }

  public ProductSupplyDurationRequest countPrice() {
    return countPrice("countPrice");
  }

  public ProductSupplyDurationRequest countPrice(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest maxPrice() {
    return maxPrice("maxPrice");
  }

  public ProductSupplyDurationRequest maxPrice(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest minPrice() {
    return minPrice("minPrice");
  }

  public ProductSupplyDurationRequest minPrice(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest sumPrice() {
    return sumPrice("sumPrice");
  }

  public ProductSupplyDurationRequest sumPrice(String aggName) {
    return aggregate(aggName, AggFunc.SUM, PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByPrice() {
    return groupByPrice(PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByPrice(String ret) {
    return groupBy(ret, PRICE_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByPrice(SqlFunction func) {
    return groupByPrice(PRICE_PROPERTY, func);
  }

  public ProductSupplyDurationRequest groupByPrice(String ret, SqlFunction func) {
    super.groupBy(ret, func, PRICE_PROPERTY);
    return this;
  }

  public ProductSupplyDurationRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ProductSupplyDurationRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductSupplyDurationRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductSupplyDurationRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductSupplyDurationRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductSupplyDurationRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ProductSupplyDurationRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ProductSupplyDurationRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ProductSupplyDurationRequest countVersion() {
    return countVersion("countVersion");
  }

  public ProductSupplyDurationRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ProductSupplyDurationRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest minVersion() {
    return minVersion("minVersion");
  }

  public ProductSupplyDurationRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ProductSupplyDurationRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ProductSupplyDurationRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ProductSupplyDurationRequest filterByProduct(SupplierProductRequest product) {
    return filterByProduct(product, SupplierProduct::getId);
  }

  public ProductSupplyDurationRequest filterByProduct(SupplierProduct... product) {
    if (isEmptyParam(product)) {
      throw new IllegalArgumentException("filterByProduct(SupplierProduct... product)参数不能为空!");
    }
    return where(PRODUCT_PROPERTY, QueryOperator.IN, (Object[]) product);
  }

  public ProductSupplyDurationRequest selectProductId() {
    select(PRODUCT_PROPERTY);
    return this;
  }

  public SupplierProductRequest upToProduct() {
    return upToProduct(SupplierProductRequest.newInstance());
  }

  public SupplierProductRequest upToProduct(SupplierProductRequest product) {
    product.aggregateChild(PRODUCT_PROPERTY, this);
    this.groupByProduct(product);
    return product;
  }

  public SupplierProductRequest endAtProduct(String retName) {
    return endAtProduct(retName, SupplierProductRequest.newInstance());
  }

  public SupplierProductRequest endAtProduct(String retName, SupplierProductRequest product) {
    product.addDynamicProperty(retName, this, PRODUCT_PROPERTY);
    return product;
  }

  public ProductSupplyDurationRequest filterByProduct(String... product) {
    if (isEmptyParam(product)) {
      throw new IllegalArgumentException("filterByProduct(String... product)参数不能为空!");
    }
    return where(PRODUCT_PROPERTY, QueryOperator.IN, (Object[]) product);
  }

  public ProductSupplyDurationRequest filterByProduct(
      SupplierProductRequest product, IDRefine<SupplierProduct> idRefine) {
    product.unlimited();
    return addSearchCriteria(createProductCriteria(product, idRefine));
  }

  public SearchCriteria createProductCriteria(
      SupplierProductRequest product, IDRefine<SupplierProduct> idRefine) {
    return new RefinedIdInCriteria(
        product, PRODUCT_PROPERTY, idRefine, SupplierProduct.ID_PROPERTY);
  }

  public ProductSupplyDurationRequest selectProduct() {
    return selectProduct(SupplierProductRequest.newInstance().selectSelf());
  }

  public ProductSupplyDurationRequest selectProduct(SupplierProductRequest product) {
    selectParent(PRODUCT_PROPERTY, product);
    return this;
  }

  public ProductSupplyDurationRequest unselectProduct() {
    unselectParent(PRODUCT_PROPERTY);
    return this;
  }

  public ProductSupplyDurationRequest groupByProduct(SupplierProductRequest product) {
    groupBy(PRODUCT_PROPERTY, product);
    return this;
  }

  public ProductSupplyDurationRequest aggregateProduct(SupplierProductRequest product) {
    aggregateParent(PRODUCT_PROPERTY, product);
    return this;
  }

  public ProductSupplyDurationRequest countProduct() {
    return countProduct("countProduct");
  }

  public ProductSupplyDurationRequest countProduct(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRODUCT_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByProduct() {
    return groupByProduct(PRODUCT_PROPERTY);
  }

  public ProductSupplyDurationRequest groupByProduct(String ret) {
    return groupBy(ret, PRODUCT_PROPERTY);
  }

  public ProductSupplyDurationRequest whereProductIsNull() {
    return where(PRODUCT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductSupplyDurationRequest whereProductIsNotNull() {
    return where(PRODUCT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductSupplyDurationRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ProductSupplyDurationRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ProductSupplyDurationRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ProductSupplyDurationRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
