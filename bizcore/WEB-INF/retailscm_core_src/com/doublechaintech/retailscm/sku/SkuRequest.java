package com.doublechaintech.retailscm.sku;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.product.ProductRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.sku.Sku.*;

public class SkuRequest extends BaseRequest<Sku> {
  public static SkuRequest newInstance() {
    return new SkuRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SkuRequest resultByClass(Class<? extends Sku> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SkuRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SkuRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Sku";
  }

  public SkuRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SkuRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SkuRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SkuRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SkuRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectSize()
        .selectProduct()
        .selectBarcode()
        .selectPackageType()
        .selectNetContent()
        .selectPrice()
        .selectPicture()
        .selectVersion();
  }

  public SkuRequest selectAny() {
    return selectAll().selectGoodsList(Q.goods().selectSelf());
  }

  public SkuRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(SIZE_PROPERTY);
    select(PRODUCT_PROPERTY);
    select(BARCODE_PROPERTY);
    select(PACKAGE_TYPE_PROPERTY);
    select(NET_CONTENT_PROPERTY);
    select(PRICE_PROPERTY);
    select(PICTURE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SkuRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SkuRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    SIZE_PROPERTY,
    PRODUCT_PROPERTY,
    BARCODE_PROPERTY,
    PACKAGE_TYPE_PROPERTY,
    NET_CONTENT_PROPERTY,
    PRICE_PROPERTY,
    PICTURE_PROPERTY,
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

  public SkuRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SkuRequest comment(String comment) {
    return this;
  }

  public SkuRequest enhance() {
    return this;
  }

  public SkuRequest overrideClass(Class<? extends Sku> clazz) {
    return this;
  }

  public SkuRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SkuRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SkuRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SkuRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SkuRequest count() {
    return countId("count");
  }

  public static SkuRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SkuRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SkuRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SkuRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SkuRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SkuRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SkuRequest countId() {
    return countId("countId");
  }

  public SkuRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SkuRequest maxId() {
    return maxId("maxId");
  }

  public SkuRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SkuRequest minId() {
    return minId("minId");
  }

  public SkuRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SkuRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SkuRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SkuRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SkuRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SkuRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public SkuRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public SkuRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public SkuRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public SkuRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public SkuRequest countName() {
    return countName("countName");
  }

  public SkuRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public SkuRequest maxName() {
    return maxName("maxName");
  }

  public SkuRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public SkuRequest minName() {
    return minName("minName");
  }

  public SkuRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public SkuRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public SkuRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public SkuRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public SkuRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public SkuRequest filterBySize(String size) {

    if (size == null) {
      return this;
    }

    return filterBySize(QueryOperator.EQUAL, size);
  }

  public SkuRequest whereSizeIsNull() {
    return where(SIZE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest whereSizeIsNotNull() {
    return where(SIZE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterBySize(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSizeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectSize() {
    return select(SIZE_PROPERTY);
  }

  public SkuRequest unselectSize() {
    return unselect(SIZE_PROPERTY);
  }

  public SearchCriteria getSizeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SIZE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderBySize(boolean asc) {
    addOrderBy(SIZE_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderBySizeAscending() {
    addOrderBy(SIZE_PROPERTY, true);
    return this;
  }

  public SkuRequest orderBySizeDescending() {
    addOrderBy(SIZE_PROPERTY, false);
    return this;
  }

  public SkuRequest orderBySizeAscendingUsingGBK() {
    addOrderBy("convert(size using gbk)", true);
    return this;
  }

  public SkuRequest orderBySizeDescendingUsingGBK() {
    addOrderBy("convert(size using gbk)", false);
    return this;
  }

  public SkuRequest countSize() {
    return countSize("countSize");
  }

  public SkuRequest countSize(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SIZE_PROPERTY);
  }

  public SkuRequest maxSize() {
    return maxSize("maxSize");
  }

  public SkuRequest maxSize(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SIZE_PROPERTY);
  }

  public SkuRequest minSize() {
    return minSize("minSize");
  }

  public SkuRequest minSize(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SIZE_PROPERTY);
  }

  public SkuRequest groupBySize() {
    return groupBySize(SIZE_PROPERTY);
  }

  public SkuRequest groupBySize(String ret) {
    return groupBy(ret, SIZE_PROPERTY);
  }

  public SkuRequest groupBySize(SqlFunction func) {
    return groupBySize(SIZE_PROPERTY, func);
  }

  public SkuRequest groupBySize(String ret, SqlFunction func) {
    super.groupBy(ret, func, SIZE_PROPERTY);
    return this;
  }

  public SkuRequest filterByBarcode(String barcode) {

    if (barcode == null) {
      return this;
    }

    return filterByBarcode(QueryOperator.EQUAL, barcode);
  }

  public SkuRequest whereBarcodeIsNull() {
    return where(BARCODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest whereBarcodeIsNotNull() {
    return where(BARCODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterByBarcode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBarcodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectBarcode() {
    return select(BARCODE_PROPERTY);
  }

  public SkuRequest unselectBarcode() {
    return unselect(BARCODE_PROPERTY);
  }

  public SearchCriteria getBarcodeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BARCODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByBarcode(boolean asc) {
    addOrderBy(BARCODE_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByBarcodeAscending() {
    addOrderBy(BARCODE_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByBarcodeDescending() {
    addOrderBy(BARCODE_PROPERTY, false);
    return this;
  }

  public SkuRequest orderByBarcodeAscendingUsingGBK() {
    addOrderBy("convert(barcode using gbk)", true);
    return this;
  }

  public SkuRequest orderByBarcodeDescendingUsingGBK() {
    addOrderBy("convert(barcode using gbk)", false);
    return this;
  }

  public SkuRequest countBarcode() {
    return countBarcode("countBarcode");
  }

  public SkuRequest countBarcode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BARCODE_PROPERTY);
  }

  public SkuRequest maxBarcode() {
    return maxBarcode("maxBarcode");
  }

  public SkuRequest maxBarcode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BARCODE_PROPERTY);
  }

  public SkuRequest minBarcode() {
    return minBarcode("minBarcode");
  }

  public SkuRequest minBarcode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BARCODE_PROPERTY);
  }

  public SkuRequest groupByBarcode() {
    return groupByBarcode(BARCODE_PROPERTY);
  }

  public SkuRequest groupByBarcode(String ret) {
    return groupBy(ret, BARCODE_PROPERTY);
  }

  public SkuRequest groupByBarcode(SqlFunction func) {
    return groupByBarcode(BARCODE_PROPERTY, func);
  }

  public SkuRequest groupByBarcode(String ret, SqlFunction func) {
    super.groupBy(ret, func, BARCODE_PROPERTY);
    return this;
  }

  public SkuRequest filterByPackageType(String packageType) {

    if (packageType == null) {
      return this;
    }

    return filterByPackageType(QueryOperator.EQUAL, packageType);
  }

  public SkuRequest wherePackageTypeIsNull() {
    return where(PACKAGE_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest wherePackageTypeIsNotNull() {
    return where(PACKAGE_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterByPackageType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPackageTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectPackageType() {
    return select(PACKAGE_TYPE_PROPERTY);
  }

  public SkuRequest unselectPackageType() {
    return unselect(PACKAGE_TYPE_PROPERTY);
  }

  public SearchCriteria getPackageTypeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PACKAGE_TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByPackageType(boolean asc) {
    addOrderBy(PACKAGE_TYPE_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByPackageTypeAscending() {
    addOrderBy(PACKAGE_TYPE_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByPackageTypeDescending() {
    addOrderBy(PACKAGE_TYPE_PROPERTY, false);
    return this;
  }

  public SkuRequest orderByPackageTypeAscendingUsingGBK() {
    addOrderBy("convert(packageType using gbk)", true);
    return this;
  }

  public SkuRequest orderByPackageTypeDescendingUsingGBK() {
    addOrderBy("convert(packageType using gbk)", false);
    return this;
  }

  public SkuRequest countPackageType() {
    return countPackageType("countPackageType");
  }

  public SkuRequest countPackageType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PACKAGE_TYPE_PROPERTY);
  }

  public SkuRequest maxPackageType() {
    return maxPackageType("maxPackageType");
  }

  public SkuRequest maxPackageType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PACKAGE_TYPE_PROPERTY);
  }

  public SkuRequest minPackageType() {
    return minPackageType("minPackageType");
  }

  public SkuRequest minPackageType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PACKAGE_TYPE_PROPERTY);
  }

  public SkuRequest groupByPackageType() {
    return groupByPackageType(PACKAGE_TYPE_PROPERTY);
  }

  public SkuRequest groupByPackageType(String ret) {
    return groupBy(ret, PACKAGE_TYPE_PROPERTY);
  }

  public SkuRequest groupByPackageType(SqlFunction func) {
    return groupByPackageType(PACKAGE_TYPE_PROPERTY, func);
  }

  public SkuRequest groupByPackageType(String ret, SqlFunction func) {
    super.groupBy(ret, func, PACKAGE_TYPE_PROPERTY);
    return this;
  }

  public SkuRequest filterByNetContent(String netContent) {

    if (netContent == null) {
      return this;
    }

    return filterByNetContent(QueryOperator.EQUAL, netContent);
  }

  public SkuRequest whereNetContentIsNull() {
    return where(NET_CONTENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest whereNetContentIsNotNull() {
    return where(NET_CONTENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterByNetContent(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNetContentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectNetContent() {
    return select(NET_CONTENT_PROPERTY);
  }

  public SkuRequest unselectNetContent() {
    return unselect(NET_CONTENT_PROPERTY);
  }

  public SearchCriteria getNetContentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NET_CONTENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByNetContent(boolean asc) {
    addOrderBy(NET_CONTENT_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByNetContentAscending() {
    addOrderBy(NET_CONTENT_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByNetContentDescending() {
    addOrderBy(NET_CONTENT_PROPERTY, false);
    return this;
  }

  public SkuRequest orderByNetContentAscendingUsingGBK() {
    addOrderBy("convert(netContent using gbk)", true);
    return this;
  }

  public SkuRequest orderByNetContentDescendingUsingGBK() {
    addOrderBy("convert(netContent using gbk)", false);
    return this;
  }

  public SkuRequest countNetContent() {
    return countNetContent("countNetContent");
  }

  public SkuRequest countNetContent(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NET_CONTENT_PROPERTY);
  }

  public SkuRequest maxNetContent() {
    return maxNetContent("maxNetContent");
  }

  public SkuRequest maxNetContent(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NET_CONTENT_PROPERTY);
  }

  public SkuRequest minNetContent() {
    return minNetContent("minNetContent");
  }

  public SkuRequest minNetContent(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NET_CONTENT_PROPERTY);
  }

  public SkuRequest groupByNetContent() {
    return groupByNetContent(NET_CONTENT_PROPERTY);
  }

  public SkuRequest groupByNetContent(String ret) {
    return groupBy(ret, NET_CONTENT_PROPERTY);
  }

  public SkuRequest groupByNetContent(SqlFunction func) {
    return groupByNetContent(NET_CONTENT_PROPERTY, func);
  }

  public SkuRequest groupByNetContent(String ret, SqlFunction func) {
    super.groupBy(ret, func, NET_CONTENT_PROPERTY);
    return this;
  }

  public SkuRequest filterByPrice(BigDecimal price) {

    if (price == null) {
      return this;
    }

    return filterByPrice(QueryOperator.EQUAL, price);
  }

  public SkuRequest wherePriceIsNull() {
    return where(PRICE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest wherePriceIsNotNull() {
    return where(PRICE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest wherePriceBetween(BigDecimal priceStart, BigDecimal priceEnd) {
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

  public SkuRequest wherePriceLessThan(BigDecimal price) {
    if (ObjectUtil.isEmpty(price)) {
      throw new IllegalArgumentException(
          "Method wherePriceLessThan, the parameter price is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.LESS_THAN, new Object[] {price});
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest wherePriceGreaterThan(BigDecimal price) {
    if (ObjectUtil.isEmpty(price)) {
      throw new IllegalArgumentException(
          "Method wherePriceGreaterThan, the parameter price is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPriceSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {price});
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest filterByPrice(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPriceSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectPrice() {
    return select(PRICE_PROPERTY);
  }

  public SkuRequest unselectPrice() {
    return unselect(PRICE_PROPERTY);
  }

  public SearchCriteria getPriceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PRICE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByPrice(boolean asc) {
    addOrderBy(PRICE_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByPriceAscending() {
    addOrderBy(PRICE_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByPriceDescending() {
    addOrderBy(PRICE_PROPERTY, false);
    return this;
  }

  public SkuRequest countPrice() {
    return countPrice("countPrice");
  }

  public SkuRequest countPrice(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRICE_PROPERTY);
  }

  public SkuRequest maxPrice() {
    return maxPrice("maxPrice");
  }

  public SkuRequest maxPrice(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PRICE_PROPERTY);
  }

  public SkuRequest minPrice() {
    return minPrice("minPrice");
  }

  public SkuRequest minPrice(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PRICE_PROPERTY);
  }

  public SkuRequest sumPrice() {
    return sumPrice("sumPrice");
  }

  public SkuRequest sumPrice(String aggName) {
    return aggregate(aggName, AggFunc.SUM, PRICE_PROPERTY);
  }

  public SkuRequest groupByPrice() {
    return groupByPrice(PRICE_PROPERTY);
  }

  public SkuRequest groupByPrice(String ret) {
    return groupBy(ret, PRICE_PROPERTY);
  }

  public SkuRequest groupByPrice(SqlFunction func) {
    return groupByPrice(PRICE_PROPERTY, func);
  }

  public SkuRequest groupByPrice(String ret, SqlFunction func) {
    super.groupBy(ret, func, PRICE_PROPERTY);
    return this;
  }

  public SkuRequest filterByPicture(String picture) {

    if (picture == null) {
      return this;
    }

    return filterByPicture(QueryOperator.EQUAL, picture);
  }

  public SkuRequest wherePictureIsNull() {
    return where(PICTURE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest wherePictureIsNotNull() {
    return where(PICTURE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterByPicture(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPictureSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectPicture() {
    return select(PICTURE_PROPERTY);
  }

  public SkuRequest unselectPicture() {
    return unselect(PICTURE_PROPERTY);
  }

  public SearchCriteria getPictureSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PICTURE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByPicture(boolean asc) {
    addOrderBy(PICTURE_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByPictureAscending() {
    addOrderBy(PICTURE_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByPictureDescending() {
    addOrderBy(PICTURE_PROPERTY, false);
    return this;
  }

  public SkuRequest orderByPictureAscendingUsingGBK() {
    addOrderBy("convert(picture using gbk)", true);
    return this;
  }

  public SkuRequest orderByPictureDescendingUsingGBK() {
    addOrderBy("convert(picture using gbk)", false);
    return this;
  }

  public SkuRequest countPicture() {
    return countPicture("countPicture");
  }

  public SkuRequest countPicture(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PICTURE_PROPERTY);
  }

  public SkuRequest maxPicture() {
    return maxPicture("maxPicture");
  }

  public SkuRequest maxPicture(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PICTURE_PROPERTY);
  }

  public SkuRequest minPicture() {
    return minPicture("minPicture");
  }

  public SkuRequest minPicture(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PICTURE_PROPERTY);
  }

  public SkuRequest groupByPicture() {
    return groupByPicture(PICTURE_PROPERTY);
  }

  public SkuRequest groupByPicture(String ret) {
    return groupBy(ret, PICTURE_PROPERTY);
  }

  public SkuRequest groupByPicture(SqlFunction func) {
    return groupByPicture(PICTURE_PROPERTY, func);
  }

  public SkuRequest groupByPicture(String ret, SqlFunction func) {
    super.groupBy(ret, func, PICTURE_PROPERTY);
    return this;
  }

  public SkuRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SkuRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkuRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SkuRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkuRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SkuRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SkuRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SkuRequest countVersion() {
    return countVersion("countVersion");
  }

  public SkuRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SkuRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SkuRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SkuRequest minVersion() {
    return minVersion("minVersion");
  }

  public SkuRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SkuRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SkuRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SkuRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SkuRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SkuRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SkuRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SkuRequest filterByProduct(ProductRequest product) {
    return filterByProduct(product, Product::getId);
  }

  public SkuRequest filterByProduct(Product... product) {
    if (isEmptyParam(product)) {
      throw new IllegalArgumentException("filterByProduct(Product... product)参数不能为空!");
    }
    return where(PRODUCT_PROPERTY, QueryOperator.IN, (Object[]) product);
  }

  public SkuRequest selectProductId() {
    select(PRODUCT_PROPERTY);
    return this;
  }

  public ProductRequest upToProduct() {
    return upToProduct(ProductRequest.newInstance());
  }

  public ProductRequest upToProduct(ProductRequest product) {
    product.aggregateChild(PRODUCT_PROPERTY, this);
    this.groupByProduct(product);
    return product;
  }

  public ProductRequest endAtProduct(String retName) {
    return endAtProduct(retName, ProductRequest.newInstance());
  }

  public ProductRequest endAtProduct(String retName, ProductRequest product) {
    product.addDynamicProperty(retName, this, PRODUCT_PROPERTY);
    return product;
  }

  public SkuRequest filterByProduct(String... product) {
    if (isEmptyParam(product)) {
      throw new IllegalArgumentException("filterByProduct(String... product)参数不能为空!");
    }
    return where(PRODUCT_PROPERTY, QueryOperator.IN, (Object[]) product);
  }

  public SkuRequest filterByProduct(ProductRequest product, IDRefine<Product> idRefine) {
    product.unlimited();
    return addSearchCriteria(createProductCriteria(product, idRefine));
  }

  public SearchCriteria createProductCriteria(ProductRequest product, IDRefine<Product> idRefine) {
    return new RefinedIdInCriteria(product, PRODUCT_PROPERTY, idRefine, Product.ID_PROPERTY);
  }

  public SkuRequest selectProduct() {
    return selectProduct(ProductRequest.newInstance().selectSelf());
  }

  public SkuRequest selectProduct(ProductRequest product) {
    selectParent(PRODUCT_PROPERTY, product);
    return this;
  }

  public SkuRequest unselectProduct() {
    unselectParent(PRODUCT_PROPERTY);
    return this;
  }

  public SkuRequest groupByProduct(ProductRequest product) {
    groupBy(PRODUCT_PROPERTY, product);
    return this;
  }

  public SkuRequest aggregateProduct(ProductRequest product) {
    aggregateParent(PRODUCT_PROPERTY, product);
    return this;
  }

  public SkuRequest countProduct() {
    return countProduct("countProduct");
  }

  public SkuRequest countProduct(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PRODUCT_PROPERTY);
  }

  public SkuRequest groupByProduct() {
    return groupByProduct(PRODUCT_PROPERTY);
  }

  public SkuRequest groupByProduct(String ret) {
    return groupBy(ret, PRODUCT_PROPERTY);
  }

  public SkuRequest whereProductIsNull() {
    return where(PRODUCT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkuRequest whereProductIsNotNull() {
    return where(PRODUCT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkuRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public SkuRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods().select(Goods.SKU_PROPERTY).filterById(QueryOperator.IN, (Object[]) goods));
  }

  public SkuRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.SKU_PROPERTY).filterById(goods));
  }

  public SkuRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods -> java.util.Optional.of($goods).map(Goods::getSku).map(Sku::getId).orElse(null));
  }

  public SkuRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.SKU_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public SkuRequest hasGoods(GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.SKU_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.SKU_PROPERTY);
  }

  public SkuRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.SKU_PROPERTY, goods);
    return this;
  }

  public SkuRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public SkuRequest unselectGoodsList() {
    unselectChild(Goods.SKU_PROPERTY, Goods.class);
    return this;
  }

  public SkuRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.SKU_PROPERTY, goods);
    return this;
  }

  public SkuRequest countGoods() {
    return countGoods("goodsCount");
  }

  public SkuRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public SkuRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public SkuRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public SkuRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.SKU_PROPERTY);
  }

  public SkuRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SkuRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SkuRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SkuRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
