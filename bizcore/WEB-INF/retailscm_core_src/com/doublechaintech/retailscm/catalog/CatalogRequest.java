package com.doublechaintech.retailscm.catalog;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.catalog.Catalog.*;

public class CatalogRequest extends BaseRequest<Catalog> {
  public static CatalogRequest newInstance() {
    return new CatalogRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public CatalogRequest resultByClass(Class<? extends Catalog> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public CatalogRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public CatalogRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Catalog";
  }

  public CatalogRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public CatalogRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public CatalogRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public CatalogRequest select(String... names) {
    super.select(names);
    return this;
  }

  public CatalogRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectOwner()
        .selectSubCount()
        .selectAmount()
        .selectVersion();
  }

  public CatalogRequest selectAny() {
    return selectAll().selectLevelOneCategoryList(Q.levelOneCategory().selectSelf());
  }

  public CatalogRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(OWNER_PROPERTY);
    select(SUB_COUNT_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public CatalogRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public CatalogRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    OWNER_PROPERTY,
    SUB_COUNT_PROPERTY,
    AMOUNT_PROPERTY,
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

  public CatalogRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public CatalogRequest comment(String comment) {
    return this;
  }

  public CatalogRequest enhance() {
    return this;
  }

  public CatalogRequest overrideClass(Class<? extends Catalog> clazz) {
    return this;
  }

  public CatalogRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public CatalogRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public CatalogRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public CatalogRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public CatalogRequest count() {
    return countId("count");
  }

  public static CatalogRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public CatalogRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public CatalogRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest selectId() {
    return select(ID_PROPERTY);
  }

  public CatalogRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CatalogRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public CatalogRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public CatalogRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public CatalogRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public CatalogRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public CatalogRequest countId() {
    return countId("countId");
  }

  public CatalogRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public CatalogRequest maxId() {
    return maxId("maxId");
  }

  public CatalogRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public CatalogRequest minId() {
    return minId("minId");
  }

  public CatalogRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public CatalogRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public CatalogRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public CatalogRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public CatalogRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public CatalogRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public CatalogRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CatalogRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CatalogRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public CatalogRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CatalogRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public CatalogRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public CatalogRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public CatalogRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public CatalogRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public CatalogRequest countName() {
    return countName("countName");
  }

  public CatalogRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public CatalogRequest maxName() {
    return maxName("maxName");
  }

  public CatalogRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public CatalogRequest minName() {
    return minName("minName");
  }

  public CatalogRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public CatalogRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public CatalogRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public CatalogRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public CatalogRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public CatalogRequest filterBySubCount(int subCount) {

    return filterBySubCount(QueryOperator.EQUAL, subCount);
  }

  public CatalogRequest whereSubCountIsNull() {
    return where(SUB_COUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public CatalogRequest whereSubCountIsNotNull() {
    return where(SUB_COUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CatalogRequest whereSubCountBetween(Integer subCountStart, Integer subCountEnd) {
    if (ObjectUtil.isEmpty(subCountStart)) {
      throw new IllegalArgumentException(
          "Method whereSubCountBetween, the parameter subCountStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(subCountEnd)) {
      throw new IllegalArgumentException(
          "Method whereSubCountBetween, the parameter subCountEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getSubCountSearchCriteria(QueryOperator.BETWEEN, new Object[] {subCountStart, subCountEnd});
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest whereSubCountLessThan(Integer subCount) {
    if (ObjectUtil.isEmpty(subCount)) {
      throw new IllegalArgumentException(
          "Method whereSubCountLessThan, the parameter subCount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getSubCountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {subCount});
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest whereSubCountGreaterThan(int subCount) {
    if (ObjectUtil.isEmpty(subCount)) {
      throw new IllegalArgumentException(
          "Method whereSubCountGreaterThan, the parameter subCount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getSubCountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {subCount});
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest filterBySubCount(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSubCountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest selectSubCount() {
    return select(SUB_COUNT_PROPERTY);
  }

  public CatalogRequest unselectSubCount() {
    return unselect(SUB_COUNT_PROPERTY);
  }

  public SearchCriteria getSubCountSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SUB_COUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CatalogRequest orderBySubCount(boolean asc) {
    addOrderBy(SUB_COUNT_PROPERTY, asc);
    return this;
  }

  public CatalogRequest orderBySubCountAscending() {
    addOrderBy(SUB_COUNT_PROPERTY, true);
    return this;
  }

  public CatalogRequest orderBySubCountDescending() {
    addOrderBy(SUB_COUNT_PROPERTY, false);
    return this;
  }

  public CatalogRequest countSubCount() {
    return countSubCount("countSubCount");
  }

  public CatalogRequest countSubCount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SUB_COUNT_PROPERTY);
  }

  public CatalogRequest maxSubCount() {
    return maxSubCount("maxSubCount");
  }

  public CatalogRequest maxSubCount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SUB_COUNT_PROPERTY);
  }

  public CatalogRequest minSubCount() {
    return minSubCount("minSubCount");
  }

  public CatalogRequest minSubCount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SUB_COUNT_PROPERTY);
  }

  public CatalogRequest sumSubCount() {
    return sumSubCount("sumSubCount");
  }

  public CatalogRequest sumSubCount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, SUB_COUNT_PROPERTY);
  }

  public CatalogRequest groupBySubCount() {
    return groupBySubCount(SUB_COUNT_PROPERTY);
  }

  public CatalogRequest groupBySubCount(String ret) {
    return groupBy(ret, SUB_COUNT_PROPERTY);
  }

  public CatalogRequest groupBySubCount(SqlFunction func) {
    return groupBySubCount(SUB_COUNT_PROPERTY, func);
  }

  public CatalogRequest groupBySubCount(String ret, SqlFunction func) {
    super.groupBy(ret, func, SUB_COUNT_PROPERTY);
    return this;
  }

  public CatalogRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public CatalogRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public CatalogRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CatalogRequest whereAmountBetween(BigDecimal amountStart, BigDecimal amountEnd) {
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

  public CatalogRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public CatalogRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CatalogRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public CatalogRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public CatalogRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public CatalogRequest countAmount() {
    return countAmount("countAmount");
  }

  public CatalogRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public CatalogRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public CatalogRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public CatalogRequest minAmount() {
    return minAmount("minAmount");
  }

  public CatalogRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public CatalogRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public CatalogRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public CatalogRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public CatalogRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public CatalogRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public CatalogRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public CatalogRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public CatalogRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CatalogRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CatalogRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CatalogRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public CatalogRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CatalogRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public CatalogRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public CatalogRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public CatalogRequest countVersion() {
    return countVersion("countVersion");
  }

  public CatalogRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public CatalogRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public CatalogRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public CatalogRequest minVersion() {
    return minVersion("minVersion");
  }

  public CatalogRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public CatalogRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public CatalogRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public CatalogRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public CatalogRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public CatalogRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public CatalogRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public CatalogRequest filterByOwner(RetailStoreCountryCenterRequest owner) {
    return filterByOwner(owner, RetailStoreCountryCenter::getId);
  }

  public CatalogRequest filterByOwner(RetailStoreCountryCenter... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreCountryCenter... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public CatalogRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToOwner() {
    return upToOwner(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToOwner(RetailStoreCountryCenterRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreCountryCenterRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtOwner(
      String retName, RetailStoreCountryCenterRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public CatalogRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public CatalogRequest filterByOwner(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        owner, OWNER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public CatalogRequest selectOwner() {
    return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public CatalogRequest selectOwner(RetailStoreCountryCenterRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public CatalogRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public CatalogRequest groupByOwner(RetailStoreCountryCenterRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public CatalogRequest aggregateOwner(RetailStoreCountryCenterRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public CatalogRequest countOwner() {
    return countOwner("countOwner");
  }

  public CatalogRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public CatalogRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public CatalogRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public CatalogRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public CatalogRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CatalogRequest hasLevelOneCategory() {
    return hasLevelOneCategory(LevelOneCategoryRequest.newInstance());
  }

  public CatalogRequest hasLevelOneCategory(LevelOneCategory... levelOneCategory) {
    if (isEmptyParam(levelOneCategory)) {
      throw new IllegalArgumentException(
          "hasLevelOneCategory(LevelOneCategory... levelOneCategory)参数不能为空!");
    }
    return hasLevelOneCategory(
        Q.levelOneCategory()
            .select(LevelOneCategory.CATALOG_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) levelOneCategory));
  }

  public CatalogRequest hasLevelOneCategory(String... levelOneCategory) {
    return hasLevelOneCategory(
        Q.levelOneCategory()
            .select(LevelOneCategory.CATALOG_PROPERTY)
            .filterById(levelOneCategory));
  }

  public CatalogRequest hasLevelOneCategory(LevelOneCategoryRequest levelOneCategory) {
    return hasLevelOneCategory(
        levelOneCategory,
        $levelOneCategory ->
            java.util.Optional.of($levelOneCategory)
                .map(LevelOneCategory::getCatalog)
                .map(Catalog::getId)
                .orElse(null));
  }

  public CatalogRequest hasLevelOneCategory(
      LevelOneCategoryRequest levelOneCategory, IDRefine<LevelOneCategory> idRefine) {
    levelOneCategory.select(LevelOneCategory.CATALOG_PROPERTY);
    levelOneCategory.unlimited();
    return addSearchCriteria(createLevelOneCategoryCriteria(levelOneCategory, idRefine));
  }

  public CatalogRequest hasLevelOneCategory(
      LevelOneCategoryRequest levelOneCategory, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            levelOneCategory, LevelOneCategory.CATALOG_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLevelOneCategoryCriteria(
      LevelOneCategoryRequest levelOneCategory, IDRefine<LevelOneCategory> idRefine) {
    return new RefinedIdInCriteria(
        levelOneCategory, ID_PROPERTY, idRefine, LevelOneCategory.CATALOG_PROPERTY);
  }

  public CatalogRequest selectLevelOneCategoryList(LevelOneCategoryRequest levelOneCategory) {
    selectChild(LevelOneCategory.CATALOG_PROPERTY, levelOneCategory);
    return this;
  }

  public CatalogRequest selectLevelOneCategoryList() {
    return selectLevelOneCategoryList(LevelOneCategoryRequest.newInstance().selectAll());
  }

  public CatalogRequest unselectLevelOneCategoryList() {
    unselectChild(LevelOneCategory.CATALOG_PROPERTY, LevelOneCategory.class);
    return this;
  }

  public CatalogRequest aggregateLevelOneCategoryList(LevelOneCategoryRequest levelOneCategory) {
    aggregateChild(LevelOneCategory.CATALOG_PROPERTY, levelOneCategory);
    return this;
  }

  public CatalogRequest countLevelOneCategory() {
    return countLevelOneCategory("levelOneCategoryCount");
  }

  public CatalogRequest countLevelOneCategory(String retName) {
    return countLevelOneCategory(retName, LevelOneCategoryRequest.newInstance());
  }

  public CatalogRequest countLevelOneCategory(LevelOneCategoryRequest levelOneCategory) {
    return countLevelOneCategory("levelOneCategoryCount", levelOneCategory);
  }

  public CatalogRequest countLevelOneCategory(
      String retName, LevelOneCategoryRequest levelOneCategory) {
    levelOneCategory.count();
    return statsFromLevelOneCategory(retName, levelOneCategory);
  }

  public CatalogRequest statsFromLevelOneCategory(
      String retName, LevelOneCategoryRequest levelOneCategory) {
    return addDynamicProperty(retName, levelOneCategory, LevelOneCategory.CATALOG_PROPERTY);
  }

  public CatalogRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public CatalogRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public CatalogRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CatalogRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
