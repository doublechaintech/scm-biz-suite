package com.doublechaintech.retailscm.leveltwocategory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory.*;

public class LevelTwoCategoryRequest extends BaseRequest<LevelTwoCategory> {
  public static LevelTwoCategoryRequest newInstance() {
    return new LevelTwoCategoryRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LevelTwoCategoryRequest resultByClass(Class<? extends LevelTwoCategory> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LevelTwoCategoryRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LevelTwoCategoryRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LevelTwoCategory";
  }

  public LevelTwoCategoryRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LevelTwoCategoryRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LevelTwoCategoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LevelTwoCategoryRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LevelTwoCategoryRequest selectAll() {
    return this.selectId().selectParentCategory().selectName().selectVersion();
  }

  public LevelTwoCategoryRequest selectAny() {
    return selectAll().selectLevelThreeCategoryList(Q.levelThreeCategory().selectSelf());
  }

  public LevelTwoCategoryRequest selectSelf() {
    select(ID_PROPERTY);
    select(PARENT_CATEGORY_PROPERTY);
    select(NAME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LevelTwoCategoryRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LevelTwoCategoryRequest where(
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

  public LevelTwoCategoryRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LevelTwoCategoryRequest comment(String comment) {
    return this;
  }

  public LevelTwoCategoryRequest enhance() {
    return this;
  }

  public LevelTwoCategoryRequest overrideClass(Class<? extends LevelTwoCategory> clazz) {
    return this;
  }

  public LevelTwoCategoryRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LevelTwoCategoryRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LevelTwoCategoryRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LevelTwoCategoryRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LevelTwoCategoryRequest count() {
    return countId("count");
  }

  public static LevelTwoCategoryRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LevelTwoCategoryRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LevelTwoCategoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoCategoryRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LevelTwoCategoryRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoCategoryRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LevelTwoCategoryRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LevelTwoCategoryRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LevelTwoCategoryRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LevelTwoCategoryRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LevelTwoCategoryRequest countId() {
    return countId("countId");
  }

  public LevelTwoCategoryRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LevelTwoCategoryRequest maxId() {
    return maxId("maxId");
  }

  public LevelTwoCategoryRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LevelTwoCategoryRequest minId() {
    return minId("minId");
  }

  public LevelTwoCategoryRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LevelTwoCategoryRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LevelTwoCategoryRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LevelTwoCategoryRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LevelTwoCategoryRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LevelTwoCategoryRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public LevelTwoCategoryRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoCategoryRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoCategoryRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoCategoryRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public LevelTwoCategoryRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoCategoryRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public LevelTwoCategoryRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public LevelTwoCategoryRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public LevelTwoCategoryRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public LevelTwoCategoryRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public LevelTwoCategoryRequest countName() {
    return countName("countName");
  }

  public LevelTwoCategoryRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public LevelTwoCategoryRequest maxName() {
    return maxName("maxName");
  }

  public LevelTwoCategoryRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public LevelTwoCategoryRequest minName() {
    return minName("minName");
  }

  public LevelTwoCategoryRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public LevelTwoCategoryRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public LevelTwoCategoryRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LevelTwoCategoryRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoCategoryRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoCategoryRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoCategoryRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoCategoryRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LevelTwoCategoryRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LevelTwoCategoryRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LevelTwoCategoryRequest countVersion() {
    return countVersion("countVersion");
  }

  public LevelTwoCategoryRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LevelTwoCategoryRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest minVersion() {
    return minVersion("minVersion");
  }

  public LevelTwoCategoryRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LevelTwoCategoryRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LevelTwoCategoryRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LevelTwoCategoryRequest filterByParentCategory(LevelOneCategoryRequest parentCategory) {
    return filterByParentCategory(parentCategory, LevelOneCategory::getId);
  }

  public LevelTwoCategoryRequest filterByParentCategory(LevelOneCategory... parentCategory) {
    if (isEmptyParam(parentCategory)) {
      throw new IllegalArgumentException(
          "filterByParentCategory(LevelOneCategory... parentCategory)参数不能为空!");
    }
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IN, (Object[]) parentCategory);
  }

  public LevelTwoCategoryRequest selectParentCategoryId() {
    select(PARENT_CATEGORY_PROPERTY);
    return this;
  }

  public LevelOneCategoryRequest upToParentCategory() {
    return upToParentCategory(LevelOneCategoryRequest.newInstance());
  }

  public LevelOneCategoryRequest upToParentCategory(LevelOneCategoryRequest parentCategory) {
    parentCategory.aggregateChild(PARENT_CATEGORY_PROPERTY, this);
    this.groupByParentCategory(parentCategory);
    return parentCategory;
  }

  public LevelOneCategoryRequest endAtParentCategory(String retName) {
    return endAtParentCategory(retName, LevelOneCategoryRequest.newInstance());
  }

  public LevelOneCategoryRequest endAtParentCategory(
      String retName, LevelOneCategoryRequest parentCategory) {
    parentCategory.addDynamicProperty(retName, this, PARENT_CATEGORY_PROPERTY);
    return parentCategory;
  }

  public LevelTwoCategoryRequest filterByParentCategory(String... parentCategory) {
    if (isEmptyParam(parentCategory)) {
      throw new IllegalArgumentException("filterByParentCategory(String... parentCategory)参数不能为空!");
    }
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IN, (Object[]) parentCategory);
  }

  public LevelTwoCategoryRequest filterByParentCategory(
      LevelOneCategoryRequest parentCategory, IDRefine<LevelOneCategory> idRefine) {
    parentCategory.unlimited();
    return addSearchCriteria(createParentCategoryCriteria(parentCategory, idRefine));
  }

  public SearchCriteria createParentCategoryCriteria(
      LevelOneCategoryRequest parentCategory, IDRefine<LevelOneCategory> idRefine) {
    return new RefinedIdInCriteria(
        parentCategory, PARENT_CATEGORY_PROPERTY, idRefine, LevelOneCategory.ID_PROPERTY);
  }

  public LevelTwoCategoryRequest selectParentCategory() {
    return selectParentCategory(LevelOneCategoryRequest.newInstance().selectSelf());
  }

  public LevelTwoCategoryRequest selectParentCategory(LevelOneCategoryRequest parentCategory) {
    selectParent(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public LevelTwoCategoryRequest unselectParentCategory() {
    unselectParent(PARENT_CATEGORY_PROPERTY);
    return this;
  }

  public LevelTwoCategoryRequest groupByParentCategory(LevelOneCategoryRequest parentCategory) {
    groupBy(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public LevelTwoCategoryRequest aggregateParentCategory(LevelOneCategoryRequest parentCategory) {
    aggregateParent(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public LevelTwoCategoryRequest countParentCategory() {
    return countParentCategory("countParentCategory");
  }

  public LevelTwoCategoryRequest countParentCategory(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PARENT_CATEGORY_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByParentCategory() {
    return groupByParentCategory(PARENT_CATEGORY_PROPERTY);
  }

  public LevelTwoCategoryRequest groupByParentCategory(String ret) {
    return groupBy(ret, PARENT_CATEGORY_PROPERTY);
  }

  public LevelTwoCategoryRequest whereParentCategoryIsNull() {
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoCategoryRequest whereParentCategoryIsNotNull() {
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoCategoryRequest hasLevelThreeCategory() {
    return hasLevelThreeCategory(LevelThreeCategoryRequest.newInstance());
  }

  public LevelTwoCategoryRequest hasLevelThreeCategory(LevelThreeCategory... levelThreeCategory) {
    if (isEmptyParam(levelThreeCategory)) {
      throw new IllegalArgumentException(
          "hasLevelThreeCategory(LevelThreeCategory... levelThreeCategory)参数不能为空!");
    }
    return hasLevelThreeCategory(
        Q.levelThreeCategory()
            .select(LevelThreeCategory.PARENT_CATEGORY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) levelThreeCategory));
  }

  public LevelTwoCategoryRequest hasLevelThreeCategory(String... levelThreeCategory) {
    return hasLevelThreeCategory(
        Q.levelThreeCategory()
            .select(LevelThreeCategory.PARENT_CATEGORY_PROPERTY)
            .filterById(levelThreeCategory));
  }

  public LevelTwoCategoryRequest hasLevelThreeCategory(
      LevelThreeCategoryRequest levelThreeCategory) {
    return hasLevelThreeCategory(
        levelThreeCategory,
        $levelThreeCategory ->
            java.util.Optional.of($levelThreeCategory)
                .map(LevelThreeCategory::getParentCategory)
                .map(LevelTwoCategory::getId)
                .orElse(null));
  }

  public LevelTwoCategoryRequest hasLevelThreeCategory(
      LevelThreeCategoryRequest levelThreeCategory, IDRefine<LevelThreeCategory> idRefine) {
    levelThreeCategory.select(LevelThreeCategory.PARENT_CATEGORY_PROPERTY);
    levelThreeCategory.unlimited();
    return addSearchCriteria(createLevelThreeCategoryCriteria(levelThreeCategory, idRefine));
  }

  public LevelTwoCategoryRequest hasLevelThreeCategory(
      LevelThreeCategoryRequest levelThreeCategory, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            levelThreeCategory, LevelThreeCategory.PARENT_CATEGORY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLevelThreeCategoryCriteria(
      LevelThreeCategoryRequest levelThreeCategory, IDRefine<LevelThreeCategory> idRefine) {
    return new RefinedIdInCriteria(
        levelThreeCategory, ID_PROPERTY, idRefine, LevelThreeCategory.PARENT_CATEGORY_PROPERTY);
  }

  public LevelTwoCategoryRequest selectLevelThreeCategoryList(
      LevelThreeCategoryRequest levelThreeCategory) {
    selectChild(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, levelThreeCategory);
    return this;
  }

  public LevelTwoCategoryRequest selectLevelThreeCategoryList() {
    return selectLevelThreeCategoryList(LevelThreeCategoryRequest.newInstance().selectAll());
  }

  public LevelTwoCategoryRequest unselectLevelThreeCategoryList() {
    unselectChild(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, LevelThreeCategory.class);
    return this;
  }

  public LevelTwoCategoryRequest aggregateLevelThreeCategoryList(
      LevelThreeCategoryRequest levelThreeCategory) {
    aggregateChild(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, levelThreeCategory);
    return this;
  }

  public LevelTwoCategoryRequest countLevelThreeCategory() {
    return countLevelThreeCategory("levelThreeCategoryCount");
  }

  public LevelTwoCategoryRequest countLevelThreeCategory(String retName) {
    return countLevelThreeCategory(retName, LevelThreeCategoryRequest.newInstance());
  }

  public LevelTwoCategoryRequest countLevelThreeCategory(
      LevelThreeCategoryRequest levelThreeCategory) {
    return countLevelThreeCategory("levelThreeCategoryCount", levelThreeCategory);
  }

  public LevelTwoCategoryRequest countLevelThreeCategory(
      String retName, LevelThreeCategoryRequest levelThreeCategory) {
    levelThreeCategory.count();
    return statsFromLevelThreeCategory(retName, levelThreeCategory);
  }

  public LevelTwoCategoryRequest statsFromLevelThreeCategory(
      String retName, LevelThreeCategoryRequest levelThreeCategory) {
    return addDynamicProperty(
        retName, levelThreeCategory, LevelThreeCategory.PARENT_CATEGORY_PROPERTY);
  }

  public LevelTwoCategoryRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LevelTwoCategoryRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LevelTwoCategoryRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LevelTwoCategoryRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
