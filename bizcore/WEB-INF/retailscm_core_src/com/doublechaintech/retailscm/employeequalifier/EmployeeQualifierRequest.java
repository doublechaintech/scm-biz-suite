package com.doublechaintech.retailscm.employeequalifier;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier.*;

public class EmployeeQualifierRequest extends BaseRequest<EmployeeQualifier> {
  public static EmployeeQualifierRequest newInstance() {
    return new EmployeeQualifierRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeQualifierRequest resultByClass(Class<? extends EmployeeQualifier> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeQualifierRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeQualifierRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeQualifier";
  }

  public EmployeeQualifierRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeQualifierRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeQualifierRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeQualifierRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeQualifierRequest selectAll() {
    return this.selectId()
        .selectEmployee()
        .selectQualifiedTime()
        .selectType()
        .selectLevel()
        .selectRemark()
        .selectVersion();
  }

  public EmployeeQualifierRequest selectAny() {
    return selectAll();
  }

  public EmployeeQualifierRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(QUALIFIED_TIME_PROPERTY);
    select(TYPE_PROPERTY);
    select(LEVEL_PROPERTY);
    select(REMARK_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeQualifierRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeQualifierRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {QUALIFIED_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    EMPLOYEE_PROPERTY,
    QUALIFIED_TIME_PROPERTY,
    TYPE_PROPERTY,
    LEVEL_PROPERTY,
    REMARK_PROPERTY,
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

  public EmployeeQualifierRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeQualifierRequest comment(String comment) {
    return this;
  }

  public EmployeeQualifierRequest enhance() {
    return this;
  }

  public EmployeeQualifierRequest overrideClass(Class<? extends EmployeeQualifier> clazz) {
    return this;
  }

  public EmployeeQualifierRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeQualifierRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeQualifierRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeQualifierRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeQualifierRequest count() {
    return countId("count");
  }

  public static EmployeeQualifierRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeQualifierRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeQualifierRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeQualifierRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeQualifierRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeQualifierRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeQualifierRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeQualifierRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeQualifierRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeQualifierRequest countId() {
    return countId("countId");
  }

  public EmployeeQualifierRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeQualifierRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeQualifierRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeQualifierRequest minId() {
    return minId("minId");
  }

  public EmployeeQualifierRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeQualifierRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeQualifierRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeQualifierRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeQualifierRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest filterByQualifiedTime(Date qualifiedTime) {

    if (qualifiedTime == null) {
      return this;
    }

    return filterByQualifiedTime(QueryOperator.EQUAL, qualifiedTime);
  }

  public EmployeeQualifierRequest whereQualifiedTimeIsNull() {
    return where(QUALIFIED_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeQualifierRequest whereQualifiedTimeIsNotNull() {
    return where(QUALIFIED_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeQualifierRequest whereQualifiedTimeBetween(
      Date qualifiedTimeStart, Date qualifiedTimeEnd) {
    if (ObjectUtil.isEmpty(qualifiedTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereQualifiedTimeBetween, the parameter qualifiedTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(qualifiedTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereQualifiedTimeBetween, the parameter qualifiedTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQualifiedTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {qualifiedTimeStart, qualifiedTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest whereQualifiedTimeBefore(Date qualifiedTime) {

    if (ObjectUtil.isEmpty(qualifiedTime)) {
      throw new IllegalArgumentException(
          "Method whereQualifiedTimeBefore, the parameter qualifiedTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getQualifiedTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {qualifiedTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest whereQualifiedTimeAfter(Date qualifiedTime) {
    if (ObjectUtil.isEmpty(qualifiedTime)) {
      throw new IllegalArgumentException(
          "Method whereQualifiedTimeAfter, the parameter qualifiedTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getQualifiedTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {qualifiedTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest filterByQualifiedTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getQualifiedTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest selectQualifiedTime() {
    return select(QUALIFIED_TIME_PROPERTY);
  }

  public EmployeeQualifierRequest unselectQualifiedTime() {
    return unselect(QUALIFIED_TIME_PROPERTY);
  }

  public SearchCriteria getQualifiedTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(QUALIFIED_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeQualifierRequest orderByQualifiedTime(boolean asc) {
    addOrderBy(QUALIFIED_TIME_PROPERTY, asc);
    return this;
  }

  public EmployeeQualifierRequest orderByQualifiedTimeAscending() {
    addOrderBy(QUALIFIED_TIME_PROPERTY, true);
    return this;
  }

  public EmployeeQualifierRequest orderByQualifiedTimeDescending() {
    addOrderBy(QUALIFIED_TIME_PROPERTY, false);
    return this;
  }

  public EmployeeQualifierRequest countQualifiedTime() {
    return countQualifiedTime("countQualifiedTime");
  }

  public EmployeeQualifierRequest countQualifiedTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, QUALIFIED_TIME_PROPERTY);
  }

  public EmployeeQualifierRequest maxQualifiedTime() {
    return maxQualifiedTime("maxQualifiedTime");
  }

  public EmployeeQualifierRequest maxQualifiedTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, QUALIFIED_TIME_PROPERTY);
  }

  public EmployeeQualifierRequest minQualifiedTime() {
    return minQualifiedTime("minQualifiedTime");
  }

  public EmployeeQualifierRequest minQualifiedTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, QUALIFIED_TIME_PROPERTY);
  }

  public EmployeeQualifierRequest groupByQualifiedTime() {
    return groupByQualifiedTime(QUALIFIED_TIME_PROPERTY);
  }

  public EmployeeQualifierRequest groupByQualifiedTime(String ret) {
    return groupBy(ret, QUALIFIED_TIME_PROPERTY);
  }

  public EmployeeQualifierRequest groupByQualifiedTime(SqlFunction func) {
    return groupByQualifiedTime(QUALIFIED_TIME_PROPERTY, func);
  }

  public EmployeeQualifierRequest groupByQualifiedTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, QUALIFIED_TIME_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest filterByType(String type) {

    if (type == null) {
      return this;
    }

    return filterByType(QueryOperator.EQUAL, type);
  }

  public EmployeeQualifierRequest whereTypeIsNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeQualifierRequest whereTypeIsNotNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeQualifierRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest selectType() {
    return select(TYPE_PROPERTY);
  }

  public EmployeeQualifierRequest unselectType() {
    return unselect(TYPE_PROPERTY);
  }

  public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeQualifierRequest orderByType(boolean asc) {
    addOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public EmployeeQualifierRequest orderByTypeAscending() {
    addOrderBy(TYPE_PROPERTY, true);
    return this;
  }

  public EmployeeQualifierRequest orderByTypeDescending() {
    addOrderBy(TYPE_PROPERTY, false);
    return this;
  }

  public EmployeeQualifierRequest orderByTypeAscendingUsingGBK() {
    addOrderBy("convert(type using gbk)", true);
    return this;
  }

  public EmployeeQualifierRequest orderByTypeDescendingUsingGBK() {
    addOrderBy("convert(type using gbk)", false);
    return this;
  }

  public EmployeeQualifierRequest countType() {
    return countType("countType");
  }

  public EmployeeQualifierRequest countType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TYPE_PROPERTY);
  }

  public EmployeeQualifierRequest maxType() {
    return maxType("maxType");
  }

  public EmployeeQualifierRequest maxType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TYPE_PROPERTY);
  }

  public EmployeeQualifierRequest minType() {
    return minType("minType");
  }

  public EmployeeQualifierRequest minType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TYPE_PROPERTY);
  }

  public EmployeeQualifierRequest groupByType() {
    return groupByType(TYPE_PROPERTY);
  }

  public EmployeeQualifierRequest groupByType(String ret) {
    return groupBy(ret, TYPE_PROPERTY);
  }

  public EmployeeQualifierRequest groupByType(SqlFunction func) {
    return groupByType(TYPE_PROPERTY, func);
  }

  public EmployeeQualifierRequest groupByType(String ret, SqlFunction func) {
    super.groupBy(ret, func, TYPE_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest filterByLevel(String level) {

    if (level == null) {
      return this;
    }

    return filterByLevel(QueryOperator.EQUAL, level);
  }

  public EmployeeQualifierRequest whereLevelIsNull() {
    return where(LEVEL_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeQualifierRequest whereLevelIsNotNull() {
    return where(LEVEL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeQualifierRequest filterByLevel(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLevelSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest selectLevel() {
    return select(LEVEL_PROPERTY);
  }

  public EmployeeQualifierRequest unselectLevel() {
    return unselect(LEVEL_PROPERTY);
  }

  public SearchCriteria getLevelSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LEVEL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeQualifierRequest orderByLevel(boolean asc) {
    addOrderBy(LEVEL_PROPERTY, asc);
    return this;
  }

  public EmployeeQualifierRequest orderByLevelAscending() {
    addOrderBy(LEVEL_PROPERTY, true);
    return this;
  }

  public EmployeeQualifierRequest orderByLevelDescending() {
    addOrderBy(LEVEL_PROPERTY, false);
    return this;
  }

  public EmployeeQualifierRequest orderByLevelAscendingUsingGBK() {
    addOrderBy("convert(level using gbk)", true);
    return this;
  }

  public EmployeeQualifierRequest orderByLevelDescendingUsingGBK() {
    addOrderBy("convert(level using gbk)", false);
    return this;
  }

  public EmployeeQualifierRequest countLevel() {
    return countLevel("countLevel");
  }

  public EmployeeQualifierRequest countLevel(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LEVEL_PROPERTY);
  }

  public EmployeeQualifierRequest maxLevel() {
    return maxLevel("maxLevel");
  }

  public EmployeeQualifierRequest maxLevel(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LEVEL_PROPERTY);
  }

  public EmployeeQualifierRequest minLevel() {
    return minLevel("minLevel");
  }

  public EmployeeQualifierRequest minLevel(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LEVEL_PROPERTY);
  }

  public EmployeeQualifierRequest groupByLevel() {
    return groupByLevel(LEVEL_PROPERTY);
  }

  public EmployeeQualifierRequest groupByLevel(String ret) {
    return groupBy(ret, LEVEL_PROPERTY);
  }

  public EmployeeQualifierRequest groupByLevel(SqlFunction func) {
    return groupByLevel(LEVEL_PROPERTY, func);
  }

  public EmployeeQualifierRequest groupByLevel(String ret, SqlFunction func) {
    super.groupBy(ret, func, LEVEL_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public EmployeeQualifierRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeQualifierRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeQualifierRequest filterByRemark(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public EmployeeQualifierRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeQualifierRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public EmployeeQualifierRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public EmployeeQualifierRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public EmployeeQualifierRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public EmployeeQualifierRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public EmployeeQualifierRequest countRemark() {
    return countRemark("countRemark");
  }

  public EmployeeQualifierRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public EmployeeQualifierRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public EmployeeQualifierRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public EmployeeQualifierRequest minRemark() {
    return minRemark("minRemark");
  }

  public EmployeeQualifierRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public EmployeeQualifierRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public EmployeeQualifierRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public EmployeeQualifierRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public EmployeeQualifierRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeQualifierRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeQualifierRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeQualifierRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeQualifierRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeQualifierRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeQualifierRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeQualifierRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeQualifierRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeQualifierRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeQualifierRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeQualifierRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeQualifierRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeQualifierRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeQualifierRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeQualifierRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeQualifierRequest selectEmployeeId() {
    select(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeRequest upToEmployee() {
    return upToEmployee(EmployeeRequest.newInstance());
  }

  public EmployeeRequest upToEmployee(EmployeeRequest employee) {
    employee.aggregateChild(EMPLOYEE_PROPERTY, this);
    this.groupByEmployee(employee);
    return employee;
  }

  public EmployeeRequest endAtEmployee(String retName) {
    return endAtEmployee(retName, EmployeeRequest.newInstance());
  }

  public EmployeeRequest endAtEmployee(String retName, EmployeeRequest employee) {
    employee.addDynamicProperty(retName, this, EMPLOYEE_PROPERTY);
    return employee;
  }

  public EmployeeQualifierRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeQualifierRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeQualifierRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeQualifierRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeQualifierRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeQualifierRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeQualifierRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeQualifierRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeQualifierRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeQualifierRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeQualifierRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeQualifierRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeQualifierRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeQualifierRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeQualifierRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeQualifierRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeQualifierRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
