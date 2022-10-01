package com.doublechaintech.retailscm.levelonecategory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.CatalogRequest;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelonecategory.LevelOneCategory.*;

public class LevelOneCategoryRequest extends BaseRequest<LevelOneCategory> {
  public static LevelOneCategoryRequest newInstance() {
    return new LevelOneCategoryRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LevelOneCategoryRequest resultByClass(Class<? extends LevelOneCategory> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LevelOneCategoryRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LevelOneCategoryRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LevelOneCategory";
  }

  public LevelOneCategoryRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LevelOneCategoryRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LevelOneCategoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LevelOneCategoryRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LevelOneCategoryRequest selectAll() {
    return this.selectId().selectCatalog().selectName().selectVersion();
  }

  public LevelOneCategoryRequest selectAny() {
    return selectAll().selectLevelTwoCategoryList(Q.levelTwoCategory().selectSelf());
  }

  public LevelOneCategoryRequest selectSelf() {
    select(ID_PROPERTY);
    select(CATALOG_PROPERTY);
    select(NAME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LevelOneCategoryRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LevelOneCategoryRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, CATALOG_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public LevelOneCategoryRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LevelOneCategoryRequest comment(String comment) {
    return this;
  }

  public LevelOneCategoryRequest enhance() {
    return this;
  }

  public LevelOneCategoryRequest overrideClass(Class<? extends LevelOneCategory> clazz) {
    return this;
  }

  public LevelOneCategoryRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LevelOneCategoryRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LevelOneCategoryRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LevelOneCategoryRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LevelOneCategoryRequest count() {
    return countId("count");
  }

  public static LevelOneCategoryRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LevelOneCategoryRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LevelOneCategoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneCategoryRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LevelOneCategoryRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneCategoryRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LevelOneCategoryRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LevelOneCategoryRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LevelOneCategoryRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LevelOneCategoryRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LevelOneCategoryRequest countId() {
    return countId("countId");
  }

  public LevelOneCategoryRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LevelOneCategoryRequest maxId() {
    return maxId("maxId");
  }

  public LevelOneCategoryRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LevelOneCategoryRequest minId() {
    return minId("minId");
  }

  public LevelOneCategoryRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LevelOneCategoryRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LevelOneCategoryRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LevelOneCategoryRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LevelOneCategoryRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LevelOneCategoryRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public LevelOneCategoryRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneCategoryRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneCategoryRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneCategoryRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public LevelOneCategoryRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneCategoryRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public LevelOneCategoryRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public LevelOneCategoryRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public LevelOneCategoryRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public LevelOneCategoryRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public LevelOneCategoryRequest countName() {
    return countName("countName");
  }

  public LevelOneCategoryRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public LevelOneCategoryRequest maxName() {
    return maxName("maxName");
  }

  public LevelOneCategoryRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public LevelOneCategoryRequest minName() {
    return minName("minName");
  }

  public LevelOneCategoryRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public LevelOneCategoryRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public LevelOneCategoryRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public LevelOneCategoryRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public LevelOneCategoryRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public LevelOneCategoryRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LevelOneCategoryRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneCategoryRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneCategoryRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneCategoryRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneCategoryRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LevelOneCategoryRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LevelOneCategoryRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LevelOneCategoryRequest countVersion() {
    return countVersion("countVersion");
  }

  public LevelOneCategoryRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LevelOneCategoryRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest minVersion() {
    return minVersion("minVersion");
  }

  public LevelOneCategoryRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LevelOneCategoryRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LevelOneCategoryRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LevelOneCategoryRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LevelOneCategoryRequest filterByCatalog(CatalogRequest catalog) {
    return filterByCatalog(catalog, Catalog::getId);
  }

  public LevelOneCategoryRequest filterByCatalog(Catalog... catalog) {
    if (isEmptyParam(catalog)) {
      throw new IllegalArgumentException("filterByCatalog(Catalog... catalog)参数不能为空!");
    }
    return where(CATALOG_PROPERTY, QueryOperator.IN, (Object[]) catalog);
  }

  public LevelOneCategoryRequest selectCatalogId() {
    select(CATALOG_PROPERTY);
    return this;
  }

  public CatalogRequest upToCatalog() {
    return upToCatalog(CatalogRequest.newInstance());
  }

  public CatalogRequest upToCatalog(CatalogRequest catalog) {
    catalog.aggregateChild(CATALOG_PROPERTY, this);
    this.groupByCatalog(catalog);
    return catalog;
  }

  public CatalogRequest endAtCatalog(String retName) {
    return endAtCatalog(retName, CatalogRequest.newInstance());
  }

  public CatalogRequest endAtCatalog(String retName, CatalogRequest catalog) {
    catalog.addDynamicProperty(retName, this, CATALOG_PROPERTY);
    return catalog;
  }

  public LevelOneCategoryRequest filterByCatalog(String... catalog) {
    if (isEmptyParam(catalog)) {
      throw new IllegalArgumentException("filterByCatalog(String... catalog)参数不能为空!");
    }
    return where(CATALOG_PROPERTY, QueryOperator.IN, (Object[]) catalog);
  }

  public LevelOneCategoryRequest filterByCatalog(
      CatalogRequest catalog, IDRefine<Catalog> idRefine) {
    catalog.unlimited();
    return addSearchCriteria(createCatalogCriteria(catalog, idRefine));
  }

  public SearchCriteria createCatalogCriteria(CatalogRequest catalog, IDRefine<Catalog> idRefine) {
    return new RefinedIdInCriteria(catalog, CATALOG_PROPERTY, idRefine, Catalog.ID_PROPERTY);
  }

  public LevelOneCategoryRequest selectCatalog() {
    return selectCatalog(CatalogRequest.newInstance().selectSelf());
  }

  public LevelOneCategoryRequest selectCatalog(CatalogRequest catalog) {
    selectParent(CATALOG_PROPERTY, catalog);
    return this;
  }

  public LevelOneCategoryRequest unselectCatalog() {
    unselectParent(CATALOG_PROPERTY);
    return this;
  }

  public LevelOneCategoryRequest groupByCatalog(CatalogRequest catalog) {
    groupBy(CATALOG_PROPERTY, catalog);
    return this;
  }

  public LevelOneCategoryRequest aggregateCatalog(CatalogRequest catalog) {
    aggregateParent(CATALOG_PROPERTY, catalog);
    return this;
  }

  public LevelOneCategoryRequest countCatalog() {
    return countCatalog("countCatalog");
  }

  public LevelOneCategoryRequest countCatalog(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CATALOG_PROPERTY);
  }

  public LevelOneCategoryRequest groupByCatalog() {
    return groupByCatalog(CATALOG_PROPERTY);
  }

  public LevelOneCategoryRequest groupByCatalog(String ret) {
    return groupBy(ret, CATALOG_PROPERTY);
  }

  public LevelOneCategoryRequest whereCatalogIsNull() {
    return where(CATALOG_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneCategoryRequest whereCatalogIsNotNull() {
    return where(CATALOG_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneCategoryRequest hasLevelTwoCategory() {
    return hasLevelTwoCategory(LevelTwoCategoryRequest.newInstance());
  }

  public LevelOneCategoryRequest hasLevelTwoCategory(LevelTwoCategory... levelTwoCategory) {
    if (isEmptyParam(levelTwoCategory)) {
      throw new IllegalArgumentException(
          "hasLevelTwoCategory(LevelTwoCategory... levelTwoCategory)参数不能为空!");
    }
    return hasLevelTwoCategory(
        Q.levelTwoCategory()
            .select(LevelTwoCategory.PARENT_CATEGORY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) levelTwoCategory));
  }

  public LevelOneCategoryRequest hasLevelTwoCategory(String... levelTwoCategory) {
    return hasLevelTwoCategory(
        Q.levelTwoCategory()
            .select(LevelTwoCategory.PARENT_CATEGORY_PROPERTY)
            .filterById(levelTwoCategory));
  }

  public LevelOneCategoryRequest hasLevelTwoCategory(LevelTwoCategoryRequest levelTwoCategory) {
    return hasLevelTwoCategory(
        levelTwoCategory,
        $levelTwoCategory ->
            java.util.Optional.of($levelTwoCategory)
                .map(LevelTwoCategory::getParentCategory)
                .map(LevelOneCategory::getId)
                .orElse(null));
  }

  public LevelOneCategoryRequest hasLevelTwoCategory(
      LevelTwoCategoryRequest levelTwoCategory, IDRefine<LevelTwoCategory> idRefine) {
    levelTwoCategory.select(LevelTwoCategory.PARENT_CATEGORY_PROPERTY);
    levelTwoCategory.unlimited();
    return addSearchCriteria(createLevelTwoCategoryCriteria(levelTwoCategory, idRefine));
  }

  public LevelOneCategoryRequest hasLevelTwoCategory(
      LevelTwoCategoryRequest levelTwoCategory, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            levelTwoCategory, LevelTwoCategory.PARENT_CATEGORY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLevelTwoCategoryCriteria(
      LevelTwoCategoryRequest levelTwoCategory, IDRefine<LevelTwoCategory> idRefine) {
    return new RefinedIdInCriteria(
        levelTwoCategory, ID_PROPERTY, idRefine, LevelTwoCategory.PARENT_CATEGORY_PROPERTY);
  }

  public LevelOneCategoryRequest selectLevelTwoCategoryList(
      LevelTwoCategoryRequest levelTwoCategory) {
    selectChild(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, levelTwoCategory);
    return this;
  }

  public LevelOneCategoryRequest selectLevelTwoCategoryList() {
    return selectLevelTwoCategoryList(LevelTwoCategoryRequest.newInstance().selectAll());
  }

  public LevelOneCategoryRequest unselectLevelTwoCategoryList() {
    unselectChild(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, LevelTwoCategory.class);
    return this;
  }

  public LevelOneCategoryRequest aggregateLevelTwoCategoryList(
      LevelTwoCategoryRequest levelTwoCategory) {
    aggregateChild(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, levelTwoCategory);
    return this;
  }

  public LevelOneCategoryRequest countLevelTwoCategory() {
    return countLevelTwoCategory("levelTwoCategoryCount");
  }

  public LevelOneCategoryRequest countLevelTwoCategory(String retName) {
    return countLevelTwoCategory(retName, LevelTwoCategoryRequest.newInstance());
  }

  public LevelOneCategoryRequest countLevelTwoCategory(LevelTwoCategoryRequest levelTwoCategory) {
    return countLevelTwoCategory("levelTwoCategoryCount", levelTwoCategory);
  }

  public LevelOneCategoryRequest countLevelTwoCategory(
      String retName, LevelTwoCategoryRequest levelTwoCategory) {
    levelTwoCategory.count();
    return statsFromLevelTwoCategory(retName, levelTwoCategory);
  }

  public LevelOneCategoryRequest statsFromLevelTwoCategory(
      String retName, LevelTwoCategoryRequest levelTwoCategory) {
    return addDynamicProperty(retName, levelTwoCategory, LevelTwoCategory.PARENT_CATEGORY_PROPERTY);
  }

  public LevelOneCategoryRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LevelOneCategoryRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LevelOneCategoryRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LevelOneCategoryRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
