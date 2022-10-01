package com.doublechaintech.retailscm.levelthreedepartment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment.*;

public class LevelThreeDepartmentRequest extends BaseRequest<LevelThreeDepartment> {
  public static LevelThreeDepartmentRequest newInstance() {
    return new LevelThreeDepartmentRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LevelThreeDepartmentRequest resultByClass(Class<? extends LevelThreeDepartment> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LevelThreeDepartmentRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LevelThreeDepartmentRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LevelThreeDepartment";
  }

  public LevelThreeDepartmentRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LevelThreeDepartmentRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LevelThreeDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LevelThreeDepartmentRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LevelThreeDepartmentRequest selectAll() {
    return this.selectId()
        .selectBelongsTo()
        .selectName()
        .selectDescription()
        .selectFounded()
        .selectVersion();
  }

  public LevelThreeDepartmentRequest selectAny() {
    return selectAll().selectEmployeeList(Q.employee().selectSelf());
  }

  public LevelThreeDepartmentRequest selectSelf() {
    select(ID_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(NAME_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LevelThreeDepartmentRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LevelThreeDepartmentRequest where(
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

  public LevelThreeDepartmentRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LevelThreeDepartmentRequest comment(String comment) {
    return this;
  }

  public LevelThreeDepartmentRequest enhance() {
    return this;
  }

  public LevelThreeDepartmentRequest overrideClass(Class<? extends LevelThreeDepartment> clazz) {
    return this;
  }

  public LevelThreeDepartmentRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LevelThreeDepartmentRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LevelThreeDepartmentRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LevelThreeDepartmentRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LevelThreeDepartmentRequest count() {
    return countId("count");
  }

  public static LevelThreeDepartmentRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LevelThreeDepartmentRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LevelThreeDepartmentRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeDepartmentRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LevelThreeDepartmentRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LevelThreeDepartmentRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LevelThreeDepartmentRequest countId() {
    return countId("countId");
  }

  public LevelThreeDepartmentRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest maxId() {
    return maxId("maxId");
  }

  public LevelThreeDepartmentRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest minId() {
    return minId("minId");
  }

  public LevelThreeDepartmentRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LevelThreeDepartmentRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public LevelThreeDepartmentRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeDepartmentRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeDepartmentRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public LevelThreeDepartmentRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeDepartmentRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public LevelThreeDepartmentRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public LevelThreeDepartmentRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public LevelThreeDepartmentRequest countName() {
    return countName("countName");
  }

  public LevelThreeDepartmentRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public LevelThreeDepartmentRequest maxName() {
    return maxName("maxName");
  }

  public LevelThreeDepartmentRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public LevelThreeDepartmentRequest minName() {
    return minName("minName");
  }

  public LevelThreeDepartmentRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public LevelThreeDepartmentRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public LevelThreeDepartmentRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeDepartmentRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeDepartmentRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public LevelThreeDepartmentRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeDepartmentRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public LevelThreeDepartmentRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public LevelThreeDepartmentRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public LevelThreeDepartmentRequest countDescription() {
    return countDescription("countDescription");
  }

  public LevelThreeDepartmentRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public LevelThreeDepartmentRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public LevelThreeDepartmentRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public LevelThreeDepartmentRequest minDescription() {
    return minDescription("minDescription");
  }

  public LevelThreeDepartmentRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public LevelThreeDepartmentRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public LevelThreeDepartmentRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeDepartmentRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeDepartmentRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
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

  public LevelThreeDepartmentRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public LevelThreeDepartmentRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeDepartmentRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public LevelThreeDepartmentRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public LevelThreeDepartmentRequest countFounded() {
    return countFounded("countFounded");
  }

  public LevelThreeDepartmentRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public LevelThreeDepartmentRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public LevelThreeDepartmentRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public LevelThreeDepartmentRequest minFounded() {
    return minFounded("minFounded");
  }

  public LevelThreeDepartmentRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public LevelThreeDepartmentRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LevelThreeDepartmentRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeDepartmentRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeDepartmentRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LevelThreeDepartmentRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LevelThreeDepartmentRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LevelThreeDepartmentRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LevelThreeDepartmentRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LevelThreeDepartmentRequest countVersion() {
    return countVersion("countVersion");
  }

  public LevelThreeDepartmentRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LevelThreeDepartmentRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest minVersion() {
    return minVersion("minVersion");
  }

  public LevelThreeDepartmentRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LevelThreeDepartmentRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LevelThreeDepartmentRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest filterByBelongsTo(LevelTwoDepartmentRequest belongsTo) {
    return filterByBelongsTo(belongsTo, LevelTwoDepartment::getId);
  }

  public LevelThreeDepartmentRequest filterByBelongsTo(LevelTwoDepartment... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException(
          "filterByBelongsTo(LevelTwoDepartment... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public LevelThreeDepartmentRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public LevelTwoDepartmentRequest upToBelongsTo() {
    return upToBelongsTo(LevelTwoDepartmentRequest.newInstance());
  }

  public LevelTwoDepartmentRequest upToBelongsTo(LevelTwoDepartmentRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public LevelTwoDepartmentRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, LevelTwoDepartmentRequest.newInstance());
  }

  public LevelTwoDepartmentRequest endAtBelongsTo(
      String retName, LevelTwoDepartmentRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public LevelThreeDepartmentRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public LevelThreeDepartmentRequest filterByBelongsTo(
      LevelTwoDepartmentRequest belongsTo, IDRefine<LevelTwoDepartment> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      LevelTwoDepartmentRequest belongsTo, IDRefine<LevelTwoDepartment> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, LevelTwoDepartment.ID_PROPERTY);
  }

  public LevelThreeDepartmentRequest selectBelongsTo() {
    return selectBelongsTo(LevelTwoDepartmentRequest.newInstance().selectSelf());
  }

  public LevelThreeDepartmentRequest selectBelongsTo(LevelTwoDepartmentRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelThreeDepartmentRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest groupByBelongsTo(LevelTwoDepartmentRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelThreeDepartmentRequest aggregateBelongsTo(LevelTwoDepartmentRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public LevelThreeDepartmentRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public LevelThreeDepartmentRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public LevelThreeDepartmentRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public LevelThreeDepartmentRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public LevelThreeDepartmentRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LevelThreeDepartmentRequest hasEmployee() {
    return hasEmployee(EmployeeRequest.newInstance());
  }

  public LevelThreeDepartmentRequest hasEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("hasEmployee(Employee... employee)参数不能为空!");
    }
    return hasEmployee(
        Q.employee()
            .select(Employee.DEPARTMENT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employee));
  }

  public LevelThreeDepartmentRequest hasEmployee(String... employee) {
    return hasEmployee(Q.employee().select(Employee.DEPARTMENT_PROPERTY).filterById(employee));
  }

  public LevelThreeDepartmentRequest hasEmployee(EmployeeRequest employee) {
    return hasEmployee(
        employee,
        $employee ->
            java.util.Optional.of($employee)
                .map(Employee::getDepartment)
                .map(LevelThreeDepartment::getId)
                .orElse(null));
  }

  public LevelThreeDepartmentRequest hasEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.select(Employee.DEPARTMENT_PROPERTY);
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public LevelThreeDepartmentRequest hasEmployee(
      EmployeeRequest employee, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(employee, Employee.DEPARTMENT_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine, Employee.DEPARTMENT_PROPERTY);
  }

  public LevelThreeDepartmentRequest selectEmployeeList(EmployeeRequest employee) {
    selectChild(Employee.DEPARTMENT_PROPERTY, employee);
    return this;
  }

  public LevelThreeDepartmentRequest selectEmployeeList() {
    return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
  }

  public LevelThreeDepartmentRequest unselectEmployeeList() {
    unselectChild(Employee.DEPARTMENT_PROPERTY, Employee.class);
    return this;
  }

  public LevelThreeDepartmentRequest aggregateEmployeeList(EmployeeRequest employee) {
    aggregateChild(Employee.DEPARTMENT_PROPERTY, employee);
    return this;
  }

  public LevelThreeDepartmentRequest countEmployee() {
    return countEmployee("employeeCount");
  }

  public LevelThreeDepartmentRequest countEmployee(String retName) {
    return countEmployee(retName, EmployeeRequest.newInstance());
  }

  public LevelThreeDepartmentRequest countEmployee(EmployeeRequest employee) {
    return countEmployee("employeeCount", employee);
  }

  public LevelThreeDepartmentRequest countEmployee(String retName, EmployeeRequest employee) {
    employee.count();
    return statsFromEmployee(retName, employee);
  }

  public LevelThreeDepartmentRequest statsFromEmployee(String retName, EmployeeRequest employee) {
    return addDynamicProperty(retName, employee, Employee.DEPARTMENT_PROPERTY);
  }

  public LevelThreeDepartmentRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LevelThreeDepartmentRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LevelThreeDepartmentRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LevelThreeDepartmentRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
