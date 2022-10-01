package com.doublechaintech.retailscm.supplierproduct;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplierproduct.SupplierProduct.*;

public class SupplierProductRequest extends BaseRequest<SupplierProduct> {
  public static SupplierProductRequest newInstance() {
    return new SupplierProductRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SupplierProductRequest resultByClass(Class<? extends SupplierProduct> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SupplierProductRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SupplierProductRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SupplierProduct";
  }

  public SupplierProductRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SupplierProductRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SupplierProductRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SupplierProductRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SupplierProductRequest selectAll() {
    return this.selectId()
        .selectProductName()
        .selectProductDescription()
        .selectProductUnit()
        .selectSupplier()
        .selectVersion();
  }

  public SupplierProductRequest selectAny() {
    return selectAll().selectProductSupplyDurationList(Q.productSupplyDuration().selectSelf());
  }

  public SupplierProductRequest selectSelf() {
    select(ID_PROPERTY);
    select(PRODUCT_NAME_PROPERTY);
    select(PRODUCT_DESCRIPTION_PROPERTY);
    select(PRODUCT_UNIT_PROPERTY);
    select(SUPPLIER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SupplierProductRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SupplierProductRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    PRODUCT_NAME_PROPERTY,
    PRODUCT_DESCRIPTION_PROPERTY,
    PRODUCT_UNIT_PROPERTY,
    SUPPLIER_PROPERTY,
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

  public SupplierProductRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SupplierProductRequest comment(String comment) {
    return this;
  }

  public SupplierProductRequest enhance() {
    return this;
  }

  public SupplierProductRequest overrideClass(Class<? extends SupplierProduct> clazz) {
    return this;
  }

  public SupplierProductRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SupplierProductRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SupplierProductRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SupplierProductRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SupplierProductRequest count() {
    return countId("count");
  }

  public static SupplierProductRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SupplierProductRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SupplierProductRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplierProductRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SupplierProductRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplierProductRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SupplierProductRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SupplierProductRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SupplierProductRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SupplierProductRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SupplierProductRequest countId() {
    return countId("countId");
  }

  public SupplierProductRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SupplierProductRequest maxId() {
    return maxId("maxId");
  }

  public SupplierProductRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SupplierProductRequest minId() {
    return minId("minId");
  }

  public SupplierProductRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SupplierProductRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SupplierProductRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SupplierProductRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SupplierProductRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SupplierProductRequest filterByProductName(String productName) {

    if (productName == null) {
      return this;
    }

    return filterByProductName(QueryOperator.EQUAL, productName);
  }

  public SupplierProductRequest whereProductNameIsNull() {
    return where(PRODUCT_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplierProductRequest whereProductNameIsNotNull() {
    return where(PRODUCT_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplierProductRequest filterByProductName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getProductNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplierProductRequest selectProductName() {
    return select(PRODUCT_NAME_PROPERTY);
  }

  public SupplierProductRequest unselectProductName() {
    return unselect(PRODUCT_NAME_PROPERTY);
  }

  public SearchCriteria getProductNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PRODUCT_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplierProductRequest orderByProductName(boolean asc) {
    addOrderBy(PRODUCT_NAME_PROPERTY, asc);
    return this;
  }

  public SupplierProductRequest orderByProductNameAscending() {
    addOrderBy(PRODUCT_NAME_PROPERTY, true);
    return this;
  }

  public SupplierProductRequest orderByProductNameDescending() {
    addOrderBy(PRODUCT_NAME_PROPERTY, false);
    return this;
  }

  public SupplierProductRequest orderByProductNameAscendingUsingGBK() {
    addOrderBy("convert(productName using gbk)", true);
    return this;
  }

  public SupplierProductRequest orderByProductNameDescendingUsingGBK() {
    addOrderBy("convert(productName using gbk)", false);
    return this;
  }

  public SupplierProductRequest countProductName() {
    return countProductName("countProductName");
  }

  public SupplierProductRequest countProductName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRODUCT_NAME_PROPERTY);
  }

  public SupplierProductRequest maxProductName() {
    return maxProductName("maxProductName");
  }

  public SupplierProductRequest maxProductName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PRODUCT_NAME_PROPERTY);
  }

  public SupplierProductRequest minProductName() {
    return minProductName("minProductName");
  }

  public SupplierProductRequest minProductName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PRODUCT_NAME_PROPERTY);
  }

  public SupplierProductRequest groupByProductName() {
    return groupByProductName(PRODUCT_NAME_PROPERTY);
  }

  public SupplierProductRequest groupByProductName(String ret) {
    return groupBy(ret, PRODUCT_NAME_PROPERTY);
  }

  public SupplierProductRequest groupByProductName(SqlFunction func) {
    return groupByProductName(PRODUCT_NAME_PROPERTY, func);
  }

  public SupplierProductRequest groupByProductName(String ret, SqlFunction func) {
    super.groupBy(ret, func, PRODUCT_NAME_PROPERTY);
    return this;
  }

  public SupplierProductRequest filterByProductDescription(String productDescription) {

    if (productDescription == null) {
      return this;
    }

    return filterByProductDescription(QueryOperator.EQUAL, productDescription);
  }

  public SupplierProductRequest whereProductDescriptionIsNull() {
    return where(PRODUCT_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplierProductRequest whereProductDescriptionIsNotNull() {
    return where(PRODUCT_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplierProductRequest filterByProductDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getProductDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplierProductRequest selectProductDescription() {
    return select(PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SupplierProductRequest unselectProductDescription() {
    return unselect(PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getProductDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PRODUCT_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplierProductRequest orderByProductDescription(boolean asc) {
    addOrderBy(PRODUCT_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SupplierProductRequest orderByProductDescriptionAscending() {
    addOrderBy(PRODUCT_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public SupplierProductRequest orderByProductDescriptionDescending() {
    addOrderBy(PRODUCT_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public SupplierProductRequest orderByProductDescriptionAscendingUsingGBK() {
    addOrderBy("convert(productDescription using gbk)", true);
    return this;
  }

  public SupplierProductRequest orderByProductDescriptionDescendingUsingGBK() {
    addOrderBy("convert(productDescription using gbk)", false);
    return this;
  }

  public SupplierProductRequest countProductDescription() {
    return countProductDescription("countProductDescription");
  }

  public SupplierProductRequest countProductDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SupplierProductRequest maxProductDescription() {
    return maxProductDescription("maxProductDescription");
  }

  public SupplierProductRequest maxProductDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SupplierProductRequest minProductDescription() {
    return minProductDescription("minProductDescription");
  }

  public SupplierProductRequest minProductDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SupplierProductRequest groupByProductDescription() {
    return groupByProductDescription(PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SupplierProductRequest groupByProductDescription(String ret) {
    return groupBy(ret, PRODUCT_DESCRIPTION_PROPERTY);
  }

  public SupplierProductRequest groupByProductDescription(SqlFunction func) {
    return groupByProductDescription(PRODUCT_DESCRIPTION_PROPERTY, func);
  }

  public SupplierProductRequest groupByProductDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, PRODUCT_DESCRIPTION_PROPERTY);
    return this;
  }

  public SupplierProductRequest filterByProductUnit(String productUnit) {

    if (productUnit == null) {
      return this;
    }

    return filterByProductUnit(QueryOperator.EQUAL, productUnit);
  }

  public SupplierProductRequest whereProductUnitIsNull() {
    return where(PRODUCT_UNIT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplierProductRequest whereProductUnitIsNotNull() {
    return where(PRODUCT_UNIT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplierProductRequest filterByProductUnit(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getProductUnitSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplierProductRequest selectProductUnit() {
    return select(PRODUCT_UNIT_PROPERTY);
  }

  public SupplierProductRequest unselectProductUnit() {
    return unselect(PRODUCT_UNIT_PROPERTY);
  }

  public SearchCriteria getProductUnitSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PRODUCT_UNIT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplierProductRequest orderByProductUnit(boolean asc) {
    addOrderBy(PRODUCT_UNIT_PROPERTY, asc);
    return this;
  }

  public SupplierProductRequest orderByProductUnitAscending() {
    addOrderBy(PRODUCT_UNIT_PROPERTY, true);
    return this;
  }

  public SupplierProductRequest orderByProductUnitDescending() {
    addOrderBy(PRODUCT_UNIT_PROPERTY, false);
    return this;
  }

  public SupplierProductRequest orderByProductUnitAscendingUsingGBK() {
    addOrderBy("convert(productUnit using gbk)", true);
    return this;
  }

  public SupplierProductRequest orderByProductUnitDescendingUsingGBK() {
    addOrderBy("convert(productUnit using gbk)", false);
    return this;
  }

  public SupplierProductRequest countProductUnit() {
    return countProductUnit("countProductUnit");
  }

  public SupplierProductRequest countProductUnit(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRODUCT_UNIT_PROPERTY);
  }

  public SupplierProductRequest maxProductUnit() {
    return maxProductUnit("maxProductUnit");
  }

  public SupplierProductRequest maxProductUnit(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PRODUCT_UNIT_PROPERTY);
  }

  public SupplierProductRequest minProductUnit() {
    return minProductUnit("minProductUnit");
  }

  public SupplierProductRequest minProductUnit(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PRODUCT_UNIT_PROPERTY);
  }

  public SupplierProductRequest groupByProductUnit() {
    return groupByProductUnit(PRODUCT_UNIT_PROPERTY);
  }

  public SupplierProductRequest groupByProductUnit(String ret) {
    return groupBy(ret, PRODUCT_UNIT_PROPERTY);
  }

  public SupplierProductRequest groupByProductUnit(SqlFunction func) {
    return groupByProductUnit(PRODUCT_UNIT_PROPERTY, func);
  }

  public SupplierProductRequest groupByProductUnit(String ret, SqlFunction func) {
    super.groupBy(ret, func, PRODUCT_UNIT_PROPERTY);
    return this;
  }

  public SupplierProductRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SupplierProductRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplierProductRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplierProductRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplierProductRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SupplierProductRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplierProductRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SupplierProductRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SupplierProductRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SupplierProductRequest countVersion() {
    return countVersion("countVersion");
  }

  public SupplierProductRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SupplierProductRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SupplierProductRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SupplierProductRequest minVersion() {
    return minVersion("minVersion");
  }

  public SupplierProductRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SupplierProductRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SupplierProductRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SupplierProductRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SupplierProductRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SupplierProductRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SupplierProductRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SupplierProductRequest filterBySupplier(GoodsSupplierRequest supplier) {
    return filterBySupplier(supplier, GoodsSupplier::getId);
  }

  public SupplierProductRequest filterBySupplier(GoodsSupplier... supplier) {
    if (isEmptyParam(supplier)) {
      throw new IllegalArgumentException("filterBySupplier(GoodsSupplier... supplier)参数不能为空!");
    }
    return where(SUPPLIER_PROPERTY, QueryOperator.IN, (Object[]) supplier);
  }

  public SupplierProductRequest selectSupplierId() {
    select(SUPPLIER_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest upToSupplier() {
    return upToSupplier(GoodsSupplierRequest.newInstance());
  }

  public GoodsSupplierRequest upToSupplier(GoodsSupplierRequest supplier) {
    supplier.aggregateChild(SUPPLIER_PROPERTY, this);
    this.groupBySupplier(supplier);
    return supplier;
  }

  public GoodsSupplierRequest endAtSupplier(String retName) {
    return endAtSupplier(retName, GoodsSupplierRequest.newInstance());
  }

  public GoodsSupplierRequest endAtSupplier(String retName, GoodsSupplierRequest supplier) {
    supplier.addDynamicProperty(retName, this, SUPPLIER_PROPERTY);
    return supplier;
  }

  public SupplierProductRequest filterBySupplier(String... supplier) {
    if (isEmptyParam(supplier)) {
      throw new IllegalArgumentException("filterBySupplier(String... supplier)参数不能为空!");
    }
    return where(SUPPLIER_PROPERTY, QueryOperator.IN, (Object[]) supplier);
  }

  public SupplierProductRequest filterBySupplier(
      GoodsSupplierRequest supplier, IDRefine<GoodsSupplier> idRefine) {
    supplier.unlimited();
    return addSearchCriteria(createSupplierCriteria(supplier, idRefine));
  }

  public SearchCriteria createSupplierCriteria(
      GoodsSupplierRequest supplier, IDRefine<GoodsSupplier> idRefine) {
    return new RefinedIdInCriteria(
        supplier, SUPPLIER_PROPERTY, idRefine, GoodsSupplier.ID_PROPERTY);
  }

  public SupplierProductRequest selectSupplier() {
    return selectSupplier(GoodsSupplierRequest.newInstance().selectSelf());
  }

  public SupplierProductRequest selectSupplier(GoodsSupplierRequest supplier) {
    selectParent(SUPPLIER_PROPERTY, supplier);
    return this;
  }

  public SupplierProductRequest unselectSupplier() {
    unselectParent(SUPPLIER_PROPERTY);
    return this;
  }

  public SupplierProductRequest groupBySupplier(GoodsSupplierRequest supplier) {
    groupBy(SUPPLIER_PROPERTY, supplier);
    return this;
  }

  public SupplierProductRequest aggregateSupplier(GoodsSupplierRequest supplier) {
    aggregateParent(SUPPLIER_PROPERTY, supplier);
    return this;
  }

  public SupplierProductRequest countSupplier() {
    return countSupplier("countSupplier");
  }

  public SupplierProductRequest countSupplier(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SUPPLIER_PROPERTY);
  }

  public SupplierProductRequest groupBySupplier() {
    return groupBySupplier(SUPPLIER_PROPERTY);
  }

  public SupplierProductRequest groupBySupplier(String ret) {
    return groupBy(ret, SUPPLIER_PROPERTY);
  }

  public SupplierProductRequest whereSupplierIsNull() {
    return where(SUPPLIER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplierProductRequest whereSupplierIsNotNull() {
    return where(SUPPLIER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplierProductRequest hasProductSupplyDuration() {
    return hasProductSupplyDuration(ProductSupplyDurationRequest.newInstance());
  }

  public SupplierProductRequest hasProductSupplyDuration(
      ProductSupplyDuration... productSupplyDuration) {
    if (isEmptyParam(productSupplyDuration)) {
      throw new IllegalArgumentException(
          "hasProductSupplyDuration(ProductSupplyDuration... productSupplyDuration)参数不能为空!");
    }
    return hasProductSupplyDuration(
        Q.productSupplyDuration()
            .select(ProductSupplyDuration.PRODUCT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) productSupplyDuration));
  }

  public SupplierProductRequest hasProductSupplyDuration(String... productSupplyDuration) {
    return hasProductSupplyDuration(
        Q.productSupplyDuration()
            .select(ProductSupplyDuration.PRODUCT_PROPERTY)
            .filterById(productSupplyDuration));
  }

  public SupplierProductRequest hasProductSupplyDuration(
      ProductSupplyDurationRequest productSupplyDuration) {
    return hasProductSupplyDuration(
        productSupplyDuration,
        $productSupplyDuration ->
            java.util.Optional.of($productSupplyDuration)
                .map(ProductSupplyDuration::getProduct)
                .map(SupplierProduct::getId)
                .orElse(null));
  }

  public SupplierProductRequest hasProductSupplyDuration(
      ProductSupplyDurationRequest productSupplyDuration,
      IDRefine<ProductSupplyDuration> idRefine) {
    productSupplyDuration.select(ProductSupplyDuration.PRODUCT_PROPERTY);
    productSupplyDuration.unlimited();
    return addSearchCriteria(createProductSupplyDurationCriteria(productSupplyDuration, idRefine));
  }

  public SupplierProductRequest hasProductSupplyDuration(
      ProductSupplyDurationRequest productSupplyDuration,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            productSupplyDuration, ProductSupplyDuration.PRODUCT_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createProductSupplyDurationCriteria(
      ProductSupplyDurationRequest productSupplyDuration,
      IDRefine<ProductSupplyDuration> idRefine) {
    return new RefinedIdInCriteria(
        productSupplyDuration, ID_PROPERTY, idRefine, ProductSupplyDuration.PRODUCT_PROPERTY);
  }

  public SupplierProductRequest selectProductSupplyDurationList(
      ProductSupplyDurationRequest productSupplyDuration) {
    selectChild(ProductSupplyDuration.PRODUCT_PROPERTY, productSupplyDuration);
    return this;
  }

  public SupplierProductRequest selectProductSupplyDurationList() {
    return selectProductSupplyDurationList(ProductSupplyDurationRequest.newInstance().selectAll());
  }

  public SupplierProductRequest unselectProductSupplyDurationList() {
    unselectChild(ProductSupplyDuration.PRODUCT_PROPERTY, ProductSupplyDuration.class);
    return this;
  }

  public SupplierProductRequest aggregateProductSupplyDurationList(
      ProductSupplyDurationRequest productSupplyDuration) {
    aggregateChild(ProductSupplyDuration.PRODUCT_PROPERTY, productSupplyDuration);
    return this;
  }

  public SupplierProductRequest countProductSupplyDuration() {
    return countProductSupplyDuration("productSupplyDurationCount");
  }

  public SupplierProductRequest countProductSupplyDuration(String retName) {
    return countProductSupplyDuration(retName, ProductSupplyDurationRequest.newInstance());
  }

  public SupplierProductRequest countProductSupplyDuration(
      ProductSupplyDurationRequest productSupplyDuration) {
    return countProductSupplyDuration("productSupplyDurationCount", productSupplyDuration);
  }

  public SupplierProductRequest countProductSupplyDuration(
      String retName, ProductSupplyDurationRequest productSupplyDuration) {
    productSupplyDuration.count();
    return statsFromProductSupplyDuration(retName, productSupplyDuration);
  }

  public SupplierProductRequest statsFromProductSupplyDuration(
      String retName, ProductSupplyDurationRequest productSupplyDuration) {
    return addDynamicProperty(
        retName, productSupplyDuration, ProductSupplyDuration.PRODUCT_PROPERTY);
  }

  public SupplierProductRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SupplierProductRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SupplierProductRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SupplierProductRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
