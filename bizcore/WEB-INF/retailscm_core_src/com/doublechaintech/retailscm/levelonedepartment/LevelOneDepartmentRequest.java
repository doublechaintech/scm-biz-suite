package com.doublechaintech.retailscm.levelonedepartment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment.*;

public class LevelOneDepartmentRequest extends BaseRequest<LevelOneDepartment> {
  public static LevelOneDepartmentRequest newInstance() {
    return new LevelOneDepartmentRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LevelOneDepartmentRequest resultByClass(Class<? extends LevelOneDepartment> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LevelOneDepartmentRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LevelOneDepartmentRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LevelOneDepartment";
  }

  public LevelOneDepartmentRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LevelOneDepartmentRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LevelOneDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LevelOneDepartmentRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LevelOneDepartmentRequest selectAll() {
    return this.selectId()
        .selectBelongsTo()
        .selectName()
        .selectDescription()
        .selectManager()
        .selectFounded()
        .selectVersion();
  }

  public LevelOneDepartmentRequest selectAny() {
    return selectAll().selectLevelTwoDepartmentList(Q.levelTwoDepartment().selectSelf());
  }

  public LevelOneDepartmentRequest selectSelf() {
    select(ID_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(NAME_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(MANAGER_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LevelOneDepartmentRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LevelOneDepartmentRequest where(
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
    MANAGER_PROPERTY,
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

  public LevelOneDepartmentRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LevelOneDepartmentRequest comment(String comment) {
    return this;
  }

  public LevelOneDepartmentRequest enhance() {
    return this;
  }

  public LevelOneDepartmentRequest overrideClass(Class<? extends LevelOneDepartment> clazz) {
    return this;
  }

  public LevelOneDepartmentRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LevelOneDepartmentRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LevelOneDepartmentRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LevelOneDepartmentRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LevelOneDepartmentRequest count() {
    return countId("count");
  }

  public static LevelOneDepartmentRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LevelOneDepartmentRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LevelOneDepartmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LevelOneDepartmentRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneDepartmentRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LevelOneDepartmentRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LevelOneDepartmentRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LevelOneDepartmentRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LevelOneDepartmentRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LevelOneDepartmentRequest countId() {
    return countId("countId");
  }

  public LevelOneDepartmentRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LevelOneDepartmentRequest maxId() {
    return maxId("maxId");
  }

  public LevelOneDepartmentRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LevelOneDepartmentRequest minId() {
    return minId("minId");
  }

  public LevelOneDepartmentRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LevelOneDepartmentRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LevelOneDepartmentRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LevelOneDepartmentRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LevelOneDepartmentRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public LevelOneDepartmentRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneDepartmentRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneDepartmentRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public LevelOneDepartmentRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneDepartmentRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public LevelOneDepartmentRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public LevelOneDepartmentRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public LevelOneDepartmentRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public LevelOneDepartmentRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public LevelOneDepartmentRequest countName() {
    return countName("countName");
  }

  public LevelOneDepartmentRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public LevelOneDepartmentRequest maxName() {
    return maxName("maxName");
  }

  public LevelOneDepartmentRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public LevelOneDepartmentRequest minName() {
    return minName("minName");
  }

  public LevelOneDepartmentRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public LevelOneDepartmentRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public LevelOneDepartmentRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneDepartmentRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneDepartmentRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public LevelOneDepartmentRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneDepartmentRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public LevelOneDepartmentRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public LevelOneDepartmentRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public LevelOneDepartmentRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public LevelOneDepartmentRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public LevelOneDepartmentRequest countDescription() {
    return countDescription("countDescription");
  }

  public LevelOneDepartmentRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public LevelOneDepartmentRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public LevelOneDepartmentRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public LevelOneDepartmentRequest minDescription() {
    return minDescription("minDescription");
  }

  public LevelOneDepartmentRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public LevelOneDepartmentRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest filterByManager(String manager) {

    if (manager == null) {
      return this;
    }

    return filterByManager(QueryOperator.EQUAL, manager);
  }

  public LevelOneDepartmentRequest whereManagerIsNull() {
    return where(MANAGER_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneDepartmentRequest whereManagerIsNotNull() {
    return where(MANAGER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneDepartmentRequest filterByManager(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getManagerSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest selectManager() {
    return select(MANAGER_PROPERTY);
  }

  public LevelOneDepartmentRequest unselectManager() {
    return unselect(MANAGER_PROPERTY);
  }

  public SearchCriteria getManagerSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MANAGER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneDepartmentRequest orderByManager(boolean asc) {
    addOrderBy(MANAGER_PROPERTY, asc);
    return this;
  }

  public LevelOneDepartmentRequest orderByManagerAscending() {
    addOrderBy(MANAGER_PROPERTY, true);
    return this;
  }

  public LevelOneDepartmentRequest orderByManagerDescending() {
    addOrderBy(MANAGER_PROPERTY, false);
    return this;
  }

  public LevelOneDepartmentRequest orderByManagerAscendingUsingGBK() {
    addOrderBy("convert(manager using gbk)", true);
    return this;
  }

  public LevelOneDepartmentRequest orderByManagerDescendingUsingGBK() {
    addOrderBy("convert(manager using gbk)", false);
    return this;
  }

  public LevelOneDepartmentRequest countManager() {
    return countManager("countManager");
  }

  public LevelOneDepartmentRequest countManager(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MANAGER_PROPERTY);
  }

  public LevelOneDepartmentRequest maxManager() {
    return maxManager("maxManager");
  }

  public LevelOneDepartmentRequest maxManager(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MANAGER_PROPERTY);
  }

  public LevelOneDepartmentRequest minManager() {
    return minManager("minManager");
  }

  public LevelOneDepartmentRequest minManager(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MANAGER_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByManager() {
    return groupByManager(MANAGER_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByManager(String ret) {
    return groupBy(ret, MANAGER_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByManager(SqlFunction func) {
    return groupByManager(MANAGER_PROPERTY, func);
  }

  public LevelOneDepartmentRequest groupByManager(String ret, SqlFunction func) {
    super.groupBy(ret, func, MANAGER_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public LevelOneDepartmentRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneDepartmentRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneDepartmentRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
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

  public LevelOneDepartmentRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public LevelOneDepartmentRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneDepartmentRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public LevelOneDepartmentRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public LevelOneDepartmentRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public LevelOneDepartmentRequest countFounded() {
    return countFounded("countFounded");
  }

  public LevelOneDepartmentRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public LevelOneDepartmentRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public LevelOneDepartmentRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public LevelOneDepartmentRequest minFounded() {
    return minFounded("minFounded");
  }

  public LevelOneDepartmentRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public LevelOneDepartmentRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LevelOneDepartmentRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneDepartmentRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneDepartmentRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelOneDepartmentRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelOneDepartmentRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LevelOneDepartmentRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LevelOneDepartmentRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LevelOneDepartmentRequest countVersion() {
    return countVersion("countVersion");
  }

  public LevelOneDepartmentRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LevelOneDepartmentRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest minVersion() {
    return minVersion("minVersion");
  }

  public LevelOneDepartmentRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LevelOneDepartmentRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LevelOneDepartmentRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest filterByBelongsTo(RetailStoreCountryCenterRequest belongsTo) {
    return filterByBelongsTo(belongsTo, RetailStoreCountryCenter::getId);
  }

  public LevelOneDepartmentRequest filterByBelongsTo(RetailStoreCountryCenter... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException(
          "filterByBelongsTo(RetailStoreCountryCenter... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public LevelOneDepartmentRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToBelongsTo() {
    return upToBelongsTo(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToBelongsTo(RetailStoreCountryCenterRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public RetailStoreCountryCenterRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtBelongsTo(
      String retName, RetailStoreCountryCenterRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public LevelOneDepartmentRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public LevelOneDepartmentRequest filterByBelongsTo(
      RetailStoreCountryCenterRequest belongsTo, IDRefine<RetailStoreCountryCenter> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      RetailStoreCountryCenterRequest belongsTo, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public LevelOneDepartmentRequest selectBelongsTo() {
    return selectBelongsTo(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public LevelOneDepartmentRequest selectBelongsTo(RetailStoreCountryCenterRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelOneDepartmentRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public LevelOneDepartmentRequest groupByBelongsTo(RetailStoreCountryCenterRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelOneDepartmentRequest aggregateBelongsTo(RetailStoreCountryCenterRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelOneDepartmentRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public LevelOneDepartmentRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public LevelOneDepartmentRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public LevelOneDepartmentRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelOneDepartmentRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelOneDepartmentRequest hasLevelTwoDepartment() {
    return hasLevelTwoDepartment(LevelTwoDepartmentRequest.newInstance());
  }

  public LevelOneDepartmentRequest hasLevelTwoDepartment(LevelTwoDepartment... levelTwoDepartment) {
    if (isEmptyParam(levelTwoDepartment)) {
      throw new IllegalArgumentException(
          "hasLevelTwoDepartment(LevelTwoDepartment... levelTwoDepartment)参数不能为空!");
    }
    return hasLevelTwoDepartment(
        Q.levelTwoDepartment()
            .select(LevelTwoDepartment.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) levelTwoDepartment));
  }

  public LevelOneDepartmentRequest hasLevelTwoDepartment(String... levelTwoDepartment) {
    return hasLevelTwoDepartment(
        Q.levelTwoDepartment()
            .select(LevelTwoDepartment.BELONGS_TO_PROPERTY)
            .filterById(levelTwoDepartment));
  }

  public LevelOneDepartmentRequest hasLevelTwoDepartment(
      LevelTwoDepartmentRequest levelTwoDepartment) {
    return hasLevelTwoDepartment(
        levelTwoDepartment,
        $levelTwoDepartment ->
            java.util.Optional.of($levelTwoDepartment)
                .map(LevelTwoDepartment::getBelongsTo)
                .map(LevelOneDepartment::getId)
                .orElse(null));
  }

  public LevelOneDepartmentRequest hasLevelTwoDepartment(
      LevelTwoDepartmentRequest levelTwoDepartment, IDRefine<LevelTwoDepartment> idRefine) {
    levelTwoDepartment.select(LevelTwoDepartment.BELONGS_TO_PROPERTY);
    levelTwoDepartment.unlimited();
    return addSearchCriteria(createLevelTwoDepartmentCriteria(levelTwoDepartment, idRefine));
  }

  public LevelOneDepartmentRequest hasLevelTwoDepartment(
      LevelTwoDepartmentRequest levelTwoDepartment, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            levelTwoDepartment, LevelTwoDepartment.BELONGS_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLevelTwoDepartmentCriteria(
      LevelTwoDepartmentRequest levelTwoDepartment, IDRefine<LevelTwoDepartment> idRefine) {
    return new RefinedIdInCriteria(
        levelTwoDepartment, ID_PROPERTY, idRefine, LevelTwoDepartment.BELONGS_TO_PROPERTY);
  }

  public LevelOneDepartmentRequest selectLevelTwoDepartmentList(
      LevelTwoDepartmentRequest levelTwoDepartment) {
    selectChild(LevelTwoDepartment.BELONGS_TO_PROPERTY, levelTwoDepartment);
    return this;
  }

  public LevelOneDepartmentRequest selectLevelTwoDepartmentList() {
    return selectLevelTwoDepartmentList(LevelTwoDepartmentRequest.newInstance().selectAll());
  }

  public LevelOneDepartmentRequest unselectLevelTwoDepartmentList() {
    unselectChild(LevelTwoDepartment.BELONGS_TO_PROPERTY, LevelTwoDepartment.class);
    return this;
  }

  public LevelOneDepartmentRequest aggregateLevelTwoDepartmentList(
      LevelTwoDepartmentRequest levelTwoDepartment) {
    aggregateChild(LevelTwoDepartment.BELONGS_TO_PROPERTY, levelTwoDepartment);
    return this;
  }

  public LevelOneDepartmentRequest countLevelTwoDepartment() {
    return countLevelTwoDepartment("levelTwoDepartmentCount");
  }

  public LevelOneDepartmentRequest countLevelTwoDepartment(String retName) {
    return countLevelTwoDepartment(retName, LevelTwoDepartmentRequest.newInstance());
  }

  public LevelOneDepartmentRequest countLevelTwoDepartment(
      LevelTwoDepartmentRequest levelTwoDepartment) {
    return countLevelTwoDepartment("levelTwoDepartmentCount", levelTwoDepartment);
  }

  public LevelOneDepartmentRequest countLevelTwoDepartment(
      String retName, LevelTwoDepartmentRequest levelTwoDepartment) {
    levelTwoDepartment.count();
    return statsFromLevelTwoDepartment(retName, levelTwoDepartment);
  }

  public LevelOneDepartmentRequest statsFromLevelTwoDepartment(
      String retName, LevelTwoDepartmentRequest levelTwoDepartment) {
    return addDynamicProperty(retName, levelTwoDepartment, LevelTwoDepartment.BELONGS_TO_PROPERTY);
  }

  public LevelOneDepartmentRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LevelOneDepartmentRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LevelOneDepartmentRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LevelOneDepartmentRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
