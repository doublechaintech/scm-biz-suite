package com.doublechaintech.retailscm.leveltwodepartment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment.*;

public class LevelTwoDepartmentRequest extends BaseRequest<LevelTwoDepartment> {
  public static LevelTwoDepartmentRequest newInstance() {
    return new LevelTwoDepartmentRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LevelTwoDepartmentRequest resultByClass(Class<? extends LevelTwoDepartment> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LevelTwoDepartmentRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LevelTwoDepartmentRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LevelTwoDepartment";
  }

  public LevelTwoDepartmentRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LevelTwoDepartmentRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LevelTwoDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LevelTwoDepartmentRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LevelTwoDepartmentRequest selectAll() {
    return this.selectId()
        .selectBelongsTo()
        .selectName()
        .selectDescription()
        .selectFounded()
        .selectVersion();
  }

  public LevelTwoDepartmentRequest selectAny() {
    return selectAll().selectLevelThreeDepartmentList(Q.levelThreeDepartment().selectSelf());
  }

  public LevelTwoDepartmentRequest selectSelf() {
    select(ID_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(NAME_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LevelTwoDepartmentRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LevelTwoDepartmentRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {FOUNDED_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    BELONGS_TO_PROPERTY,
    NAME_PROPERTY,
    DESCRIPTION_PROPERTY,
    FOUNDED_PROPERTY,
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

  public LevelTwoDepartmentRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LevelTwoDepartmentRequest comment(String comment) {
    return this;
  }

  public LevelTwoDepartmentRequest enhance() {
    return this;
  }

  public LevelTwoDepartmentRequest overrideClass(Class<? extends LevelTwoDepartment> clazz) {
    return this;
  }

  public LevelTwoDepartmentRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LevelTwoDepartmentRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LevelTwoDepartmentRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LevelTwoDepartmentRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LevelTwoDepartmentRequest count() {
    return countId("count");
  }

  public static LevelTwoDepartmentRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LevelTwoDepartmentRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LevelTwoDepartmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoDepartmentRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LevelTwoDepartmentRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LevelTwoDepartmentRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LevelTwoDepartmentRequest countId() {
    return countId("countId");
  }

  public LevelTwoDepartmentRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest maxId() {
    return maxId("maxId");
  }

  public LevelTwoDepartmentRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest minId() {
    return minId("minId");
  }

  public LevelTwoDepartmentRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LevelTwoDepartmentRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public LevelTwoDepartmentRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoDepartmentRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoDepartmentRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public LevelTwoDepartmentRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoDepartmentRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public LevelTwoDepartmentRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public LevelTwoDepartmentRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public LevelTwoDepartmentRequest countName() {
    return countName("countName");
  }

  public LevelTwoDepartmentRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public LevelTwoDepartmentRequest maxName() {
    return maxName("maxName");
  }

  public LevelTwoDepartmentRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public LevelTwoDepartmentRequest minName() {
    return minName("minName");
  }

  public LevelTwoDepartmentRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public LevelTwoDepartmentRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public LevelTwoDepartmentRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoDepartmentRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoDepartmentRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public LevelTwoDepartmentRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoDepartmentRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public LevelTwoDepartmentRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public LevelTwoDepartmentRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public LevelTwoDepartmentRequest countDescription() {
    return countDescription("countDescription");
  }

  public LevelTwoDepartmentRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public LevelTwoDepartmentRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public LevelTwoDepartmentRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public LevelTwoDepartmentRequest minDescription() {
    return minDescription("minDescription");
  }

  public LevelTwoDepartmentRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public LevelTwoDepartmentRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public LevelTwoDepartmentRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoDepartmentRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoDepartmentRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
    if (ObjectUtil.isEmpty(foundedStart)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBetween, the parameter foundedStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(foundedEnd)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBetween, the parameter foundedEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.BETWEEN, new Object[] {foundedStart, foundedEnd});
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public LevelTwoDepartmentRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoDepartmentRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public LevelTwoDepartmentRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public LevelTwoDepartmentRequest countFounded() {
    return countFounded("countFounded");
  }

  public LevelTwoDepartmentRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public LevelTwoDepartmentRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public LevelTwoDepartmentRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public LevelTwoDepartmentRequest minFounded() {
    return minFounded("minFounded");
  }

  public LevelTwoDepartmentRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public LevelTwoDepartmentRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LevelTwoDepartmentRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoDepartmentRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoDepartmentRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelTwoDepartmentRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelTwoDepartmentRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LevelTwoDepartmentRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LevelTwoDepartmentRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LevelTwoDepartmentRequest countVersion() {
    return countVersion("countVersion");
  }

  public LevelTwoDepartmentRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LevelTwoDepartmentRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest minVersion() {
    return minVersion("minVersion");
  }

  public LevelTwoDepartmentRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LevelTwoDepartmentRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LevelTwoDepartmentRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest filterByBelongsTo(LevelOneDepartmentRequest belongsTo) {
    return filterByBelongsTo(belongsTo, LevelOneDepartment::getId);
  }

  public LevelTwoDepartmentRequest filterByBelongsTo(LevelOneDepartment... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException(
          "filterByBelongsTo(LevelOneDepartment... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public LevelTwoDepartmentRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest upToBelongsTo() {
    return upToBelongsTo(LevelOneDepartmentRequest.newInstance());
  }

  public LevelOneDepartmentRequest upToBelongsTo(LevelOneDepartmentRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public LevelOneDepartmentRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, LevelOneDepartmentRequest.newInstance());
  }

  public LevelOneDepartmentRequest endAtBelongsTo(
      String retName, LevelOneDepartmentRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public LevelTwoDepartmentRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public LevelTwoDepartmentRequest filterByBelongsTo(
      LevelOneDepartmentRequest belongsTo, IDRefine<LevelOneDepartment> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      LevelOneDepartmentRequest belongsTo, IDRefine<LevelOneDepartment> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, LevelOneDepartment.ID_PROPERTY);
  }

  public LevelTwoDepartmentRequest selectBelongsTo() {
    return selectBelongsTo(LevelOneDepartmentRequest.newInstance().selectSelf());
  }

  public LevelTwoDepartmentRequest selectBelongsTo(LevelOneDepartmentRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelTwoDepartmentRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest groupByBelongsTo(LevelOneDepartmentRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelTwoDepartmentRequest aggregateBelongsTo(LevelOneDepartmentRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelTwoDepartmentRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public LevelTwoDepartmentRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public LevelTwoDepartmentRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public LevelTwoDepartmentRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelTwoDepartmentRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelTwoDepartmentRequest hasLevelThreeDepartment() {
    return hasLevelThreeDepartment(LevelThreeDepartmentRequest.newInstance());
  }

  public LevelTwoDepartmentRequest hasLevelThreeDepartment(
      LevelThreeDepartment... levelThreeDepartment) {
    if (isEmptyParam(levelThreeDepartment)) {
      throw new IllegalArgumentException(
          "hasLevelThreeDepartment(LevelThreeDepartment... levelThreeDepartment)参数不能为空!");
    }
    return hasLevelThreeDepartment(
        Q.levelThreeDepartment()
            .select(LevelThreeDepartment.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) levelThreeDepartment));
  }

  public LevelTwoDepartmentRequest hasLevelThreeDepartment(String... levelThreeDepartment) {
    return hasLevelThreeDepartment(
        Q.levelThreeDepartment()
            .select(LevelThreeDepartment.BELONGS_TO_PROPERTY)
            .filterById(levelThreeDepartment));
  }

  public LevelTwoDepartmentRequest hasLevelThreeDepartment(
      LevelThreeDepartmentRequest levelThreeDepartment) {
    return hasLevelThreeDepartment(
        levelThreeDepartment,
        $levelThreeDepartment ->
            java.util.Optional.of($levelThreeDepartment)
                .map(LevelThreeDepartment::getBelongsTo)
                .map(LevelTwoDepartment::getId)
                .orElse(null));
  }

  public LevelTwoDepartmentRequest hasLevelThreeDepartment(
      LevelThreeDepartmentRequest levelThreeDepartment, IDRefine<LevelThreeDepartment> idRefine) {
    levelThreeDepartment.select(LevelThreeDepartment.BELONGS_TO_PROPERTY);
    levelThreeDepartment.unlimited();
    return addSearchCriteria(createLevelThreeDepartmentCriteria(levelThreeDepartment, idRefine));
  }

  public LevelTwoDepartmentRequest hasLevelThreeDepartment(
      LevelThreeDepartmentRequest levelThreeDepartment, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            levelThreeDepartment, LevelThreeDepartment.BELONGS_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLevelThreeDepartmentCriteria(
      LevelThreeDepartmentRequest levelThreeDepartment, IDRefine<LevelThreeDepartment> idRefine) {
    return new RefinedIdInCriteria(
        levelThreeDepartment, ID_PROPERTY, idRefine, LevelThreeDepartment.BELONGS_TO_PROPERTY);
  }

  public LevelTwoDepartmentRequest selectLevelThreeDepartmentList(
      LevelThreeDepartmentRequest levelThreeDepartment) {
    selectChild(LevelThreeDepartment.BELONGS_TO_PROPERTY, levelThreeDepartment);
    return this;
  }

  public LevelTwoDepartmentRequest selectLevelThreeDepartmentList() {
    return selectLevelThreeDepartmentList(LevelThreeDepartmentRequest.newInstance().selectAll());
  }

  public LevelTwoDepartmentRequest unselectLevelThreeDepartmentList() {
    unselectChild(LevelThreeDepartment.BELONGS_TO_PROPERTY, LevelThreeDepartment.class);
    return this;
  }

  public LevelTwoDepartmentRequest aggregateLevelThreeDepartmentList(
      LevelThreeDepartmentRequest levelThreeDepartment) {
    aggregateChild(LevelThreeDepartment.BELONGS_TO_PROPERTY, levelThreeDepartment);
    return this;
  }

  public LevelTwoDepartmentRequest countLevelThreeDepartment() {
    return countLevelThreeDepartment("levelThreeDepartmentCount");
  }

  public LevelTwoDepartmentRequest countLevelThreeDepartment(String retName) {
    return countLevelThreeDepartment(retName, LevelThreeDepartmentRequest.newInstance());
  }

  public LevelTwoDepartmentRequest countLevelThreeDepartment(
      LevelThreeDepartmentRequest levelThreeDepartment) {
    return countLevelThreeDepartment("levelThreeDepartmentCount", levelThreeDepartment);
  }

  public LevelTwoDepartmentRequest countLevelThreeDepartment(
      String retName, LevelThreeDepartmentRequest levelThreeDepartment) {
    levelThreeDepartment.count();
    return statsFromLevelThreeDepartment(retName, levelThreeDepartment);
  }

  public LevelTwoDepartmentRequest statsFromLevelThreeDepartment(
      String retName, LevelThreeDepartmentRequest levelThreeDepartment) {
    return addDynamicProperty(
        retName, levelThreeDepartment, LevelThreeDepartment.BELONGS_TO_PROPERTY);
  }

  public LevelTwoDepartmentRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LevelTwoDepartmentRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LevelTwoDepartmentRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LevelTwoDepartmentRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
