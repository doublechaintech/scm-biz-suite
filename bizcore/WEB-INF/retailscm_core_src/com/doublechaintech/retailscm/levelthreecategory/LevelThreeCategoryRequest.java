package com.doublechaintech.retailscm.levelthreecategory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest;
import com.doublechaintech.retailscm.product.ProductRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory.*;

public class LevelThreeCategoryRequest extends BaseRequest<LevelThreeCategory> {
  public static LevelThreeCategoryRequest newInstance() {
    return new LevelThreeCategoryRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LevelThreeCategoryRequest resultByClass(Class<? extends LevelThreeCategory> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LevelThreeCategoryRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LevelThreeCategoryRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LevelThreeCategory";
  }

  public LevelThreeCategoryRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LevelThreeCategoryRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LevelThreeCategoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LevelThreeCategoryRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LevelThreeCategoryRequest selectAll() {
    return this.selectId().selectParentCategory().selectName().selectVersion();
  }

  public LevelThreeCategoryRequest selectAny() {
    return selectAll().selectProductList(Q.product().selectSelf());
  }

  public LevelThreeCategoryRequest selectSelf() {
    select(ID_PROPERTY);
    select(PARENT_CATEGORY_PROPERTY);
    select(NAME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LevelThreeCategoryRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LevelThreeCategoryRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, PARENT_CATEGORY_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public LevelThreeCategoryRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LevelThreeCategoryRequest comment(String comment) {
    return this;
  }

  public LevelThreeCategoryRequest enhance() {
    return this;
  }

  public LevelThreeCategoryRequest overrideClass(Class<? extends LevelThreeCategory> clazz) {
    return this;
  }

  public LevelThreeCategoryRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LevelThreeCategoryRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LevelThreeCategoryRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LevelThreeCategoryRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LevelThreeCategoryRequest count() {
    return countId("count");
  }

  public static LevelThreeCategoryRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LevelThreeCategoryRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LevelThreeCategoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeCategoryRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LevelThreeCategoryRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeCategoryRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LevelThreeCategoryRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LevelThreeCategoryRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LevelThreeCategoryRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LevelThreeCategoryRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LevelThreeCategoryRequest countId() {
    return countId("countId");
  }

  public LevelThreeCategoryRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LevelThreeCategoryRequest maxId() {
    return maxId("maxId");
  }

  public LevelThreeCategoryRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LevelThreeCategoryRequest minId() {
    return minId("minId");
  }

  public LevelThreeCategoryRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LevelThreeCategoryRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LevelThreeCategoryRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LevelThreeCategoryRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LevelThreeCategoryRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LevelThreeCategoryRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public LevelThreeCategoryRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeCategoryRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeCategoryRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeCategoryRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public LevelThreeCategoryRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeCategoryRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public LevelThreeCategoryRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public LevelThreeCategoryRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public LevelThreeCategoryRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public LevelThreeCategoryRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public LevelThreeCategoryRequest countName() {
    return countName("countName");
  }

  public LevelThreeCategoryRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public LevelThreeCategoryRequest maxName() {
    return maxName("maxName");
  }

  public LevelThreeCategoryRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public LevelThreeCategoryRequest minName() {
    return minName("minName");
  }

  public LevelThreeCategoryRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public LevelThreeCategoryRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public LevelThreeCategoryRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LevelThreeCategoryRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeCategoryRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeCategoryRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeCategoryRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeCategoryRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LevelThreeCategoryRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LevelThreeCategoryRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LevelThreeCategoryRequest countVersion() {
    return countVersion("countVersion");
  }

  public LevelThreeCategoryRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LevelThreeCategoryRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest minVersion() {
    return minVersion("minVersion");
  }

  public LevelThreeCategoryRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LevelThreeCategoryRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LevelThreeCategoryRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LevelThreeCategoryRequest filterByParentCategory(LevelTwoCategoryRequest parentCategory) {
    return filterByParentCategory(parentCategory, LevelTwoCategory::getId);
  }

  public LevelThreeCategoryRequest filterByParentCategory(LevelTwoCategory... parentCategory) {
    if (isEmptyParam(parentCategory)) {
      throw new IllegalArgumentException(
          "filterByParentCategory(LevelTwoCategory... parentCategory)参数不能为空!");
    }
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IN, (Object[]) parentCategory);
  }

  public LevelThreeCategoryRequest selectParentCategoryId() {
    select(PARENT_CATEGORY_PROPERTY);
    return this;
  }

  public LevelTwoCategoryRequest upToParentCategory() {
    return upToParentCategory(LevelTwoCategoryRequest.newInstance());
  }

  public LevelTwoCategoryRequest upToParentCategory(LevelTwoCategoryRequest parentCategory) {
    parentCategory.aggregateChild(PARENT_CATEGORY_PROPERTY, this);
    this.groupByParentCategory(parentCategory);
    return parentCategory;
  }

  public LevelTwoCategoryRequest endAtParentCategory(String retName) {
    return endAtParentCategory(retName, LevelTwoCategoryRequest.newInstance());
  }

  public LevelTwoCategoryRequest endAtParentCategory(
      String retName, LevelTwoCategoryRequest parentCategory) {
    parentCategory.addDynamicProperty(retName, this, PARENT_CATEGORY_PROPERTY);
    return parentCategory;
  }

  public LevelThreeCategoryRequest filterByParentCategory(String... parentCategory) {
    if (isEmptyParam(parentCategory)) {
      throw new IllegalArgumentException("filterByParentCategory(String... parentCategory)参数不能为空!");
    }
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IN, (Object[]) parentCategory);
  }

  public LevelThreeCategoryRequest filterByParentCategory(
      LevelTwoCategoryRequest parentCategory, IDRefine<LevelTwoCategory> idRefine) {
    parentCategory.unlimited();
    return addSearchCriteria(createParentCategoryCriteria(parentCategory, idRefine));
  }

  public SearchCriteria createParentCategoryCriteria(
      LevelTwoCategoryRequest parentCategory, IDRefine<LevelTwoCategory> idRefine) {
    return new RefinedIdInCriteria(
        parentCategory, PARENT_CATEGORY_PROPERTY, idRefine, LevelTwoCategory.ID_PROPERTY);
  }

  public LevelThreeCategoryRequest selectParentCategory() {
    return selectParentCategory(LevelTwoCategoryRequest.newInstance().selectSelf());
  }

  public LevelThreeCategoryRequest selectParentCategory(LevelTwoCategoryRequest parentCategory) {
    selectParent(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public LevelThreeCategoryRequest unselectParentCategory() {
    unselectParent(PARENT_CATEGORY_PROPERTY);
    return this;
  }

  public LevelThreeCategoryRequest groupByParentCategory(LevelTwoCategoryRequest parentCategory) {
    groupBy(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public LevelThreeCategoryRequest aggregateParentCategory(LevelTwoCategoryRequest parentCategory) {
    aggregateParent(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public LevelThreeCategoryRequest countParentCategory() {
    return countParentCategory("countParentCategory");
  }

  public LevelThreeCategoryRequest countParentCategory(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PARENT_CATEGORY_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByParentCategory() {
    return groupByParentCategory(PARENT_CATEGORY_PROPERTY);
  }

  public LevelThreeCategoryRequest groupByParentCategory(String ret) {
    return groupBy(ret, PARENT_CATEGORY_PROPERTY);
  }

  public LevelThreeCategoryRequest whereParentCategoryIsNull() {
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeCategoryRequest whereParentCategoryIsNotNull() {
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeCategoryRequest hasProduct() {
    return hasProduct(ProductRequest.newInstance());
  }

  public LevelThreeCategoryRequest hasProduct(Product... product) {
    if (isEmptyParam(product)) {
      throw new IllegalArgumentException("hasProduct(Product... product)参数不能为空!");
    }
    return hasProduct(
        Q.product()
            .select(Product.PARENT_CATEGORY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) product));
  }

  public LevelThreeCategoryRequest hasProduct(String... product) {
    return hasProduct(Q.product().select(Product.PARENT_CATEGORY_PROPERTY).filterById(product));
  }

  public LevelThreeCategoryRequest hasProduct(ProductRequest product) {
    return hasProduct(
        product,
        $product ->
            java.util.Optional.of($product)
                .map(Product::getParentCategory)
                .map(LevelThreeCategory::getId)
                .orElse(null));
  }

  public LevelThreeCategoryRequest hasProduct(ProductRequest product, IDRefine<Product> idRefine) {
    product.select(Product.PARENT_CATEGORY_PROPERTY);
    product.unlimited();
    return addSearchCriteria(createProductCriteria(product, idRefine));
  }

  public LevelThreeCategoryRequest hasProduct(
      ProductRequest product, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(product, Product.PARENT_CATEGORY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createProductCriteria(ProductRequest product, IDRefine<Product> idRefine) {
    return new RefinedIdInCriteria(
        product, ID_PROPERTY, idRefine, Product.PARENT_CATEGORY_PROPERTY);
  }

  public LevelThreeCategoryRequest selectProductList(ProductRequest product) {
    selectChild(Product.PARENT_CATEGORY_PROPERTY, product);
    return this;
  }

  public LevelThreeCategoryRequest selectProductList() {
    return selectProductList(ProductRequest.newInstance().selectAll());
  }

  public LevelThreeCategoryRequest unselectProductList() {
    unselectChild(Product.PARENT_CATEGORY_PROPERTY, Product.class);
    return this;
  }

  public LevelThreeCategoryRequest aggregateProductList(ProductRequest product) {
    aggregateChild(Product.PARENT_CATEGORY_PROPERTY, product);
    return this;
  }

  public LevelThreeCategoryRequest countProduct() {
    return countProduct("productCount");
  }

  public LevelThreeCategoryRequest countProduct(String retName) {
    return countProduct(retName, ProductRequest.newInstance());
  }

  public LevelThreeCategoryRequest countProduct(ProductRequest product) {
    return countProduct("productCount", product);
  }

  public LevelThreeCategoryRequest countProduct(String retName, ProductRequest product) {
    product.count();
    return statsFromProduct(retName, product);
  }

  public LevelThreeCategoryRequest statsFromProduct(String retName, ProductRequest product) {
    return addDynamicProperty(retName, product, Product.PARENT_CATEGORY_PROPERTY);
  }

  public LevelThreeCategoryRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LevelThreeCategoryRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LevelThreeCategoryRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LevelThreeCategoryRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
