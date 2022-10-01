package com.doublechaintech.retailscm.employeeaward;

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
import static com.doublechaintech.retailscm.employeeaward.EmployeeAward.*;

public class EmployeeAwardRequest extends BaseRequest<EmployeeAward> {
  public static EmployeeAwardRequest newInstance() {
    return new EmployeeAwardRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeAwardRequest resultByClass(Class<? extends EmployeeAward> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeAwardRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeAwardRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeAward";
  }

  public EmployeeAwardRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeAwardRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeAwardRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeAwardRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeAwardRequest selectAll() {
    return this.selectId()
        .selectEmployee()
        .selectCompleteTime()
        .selectType()
        .selectRemark()
        .selectVersion();
  }

  public EmployeeAwardRequest selectAny() {
    return selectAll();
  }

  public EmployeeAwardRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(COMPLETE_TIME_PROPERTY);
    select(TYPE_PROPERTY);
    select(REMARK_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeAwardRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeAwardRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {COMPLETE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    EMPLOYEE_PROPERTY,
    COMPLETE_TIME_PROPERTY,
    TYPE_PROPERTY,
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

  public EmployeeAwardRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeAwardRequest comment(String comment) {
    return this;
  }

  public EmployeeAwardRequest enhance() {
    return this;
  }

  public EmployeeAwardRequest overrideClass(Class<? extends EmployeeAward> clazz) {
    return this;
  }

  public EmployeeAwardRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeAwardRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeAwardRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeAwardRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeAwardRequest count() {
    return countId("count");
  }

  public static EmployeeAwardRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeAwardRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeAwardRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeAwardRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAwardRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeAwardRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeAwardRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeAwardRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeAwardRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeAwardRequest countId() {
    return countId("countId");
  }

  public EmployeeAwardRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeAwardRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeAwardRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeAwardRequest minId() {
    return minId("minId");
  }

  public EmployeeAwardRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeAwardRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeAwardRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeAwardRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeAwardRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeAwardRequest filterByCompleteTime(Date completeTime) {

    if (completeTime == null) {
      return this;
    }

    return filterByCompleteTime(QueryOperator.EQUAL, completeTime);
  }

  public EmployeeAwardRequest whereCompleteTimeIsNull() {
    return where(COMPLETE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAwardRequest whereCompleteTimeIsNotNull() {
    return where(COMPLETE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAwardRequest whereCompleteTimeBetween(
      Date completeTimeStart, Date completeTimeEnd) {
    if (ObjectUtil.isEmpty(completeTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereCompleteTimeBetween, the parameter completeTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(completeTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereCompleteTimeBetween, the parameter completeTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCompleteTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {completeTimeStart, completeTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest whereCompleteTimeBefore(Date completeTime) {

    if (ObjectUtil.isEmpty(completeTime)) {
      throw new IllegalArgumentException(
          "Method whereCompleteTimeBefore, the parameter completeTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCompleteTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {completeTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest whereCompleteTimeAfter(Date completeTime) {
    if (ObjectUtil.isEmpty(completeTime)) {
      throw new IllegalArgumentException(
          "Method whereCompleteTimeAfter, the parameter completeTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCompleteTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {completeTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest filterByCompleteTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCompleteTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest selectCompleteTime() {
    return select(COMPLETE_TIME_PROPERTY);
  }

  public EmployeeAwardRequest unselectCompleteTime() {
    return unselect(COMPLETE_TIME_PROPERTY);
  }

  public SearchCriteria getCompleteTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMPLETE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAwardRequest orderByCompleteTime(boolean asc) {
    addOrderBy(COMPLETE_TIME_PROPERTY, asc);
    return this;
  }

  public EmployeeAwardRequest orderByCompleteTimeAscending() {
    addOrderBy(COMPLETE_TIME_PROPERTY, true);
    return this;
  }

  public EmployeeAwardRequest orderByCompleteTimeDescending() {
    addOrderBy(COMPLETE_TIME_PROPERTY, false);
    return this;
  }

  public EmployeeAwardRequest countCompleteTime() {
    return countCompleteTime("countCompleteTime");
  }

  public EmployeeAwardRequest countCompleteTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeAwardRequest maxCompleteTime() {
    return maxCompleteTime("maxCompleteTime");
  }

  public EmployeeAwardRequest maxCompleteTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeAwardRequest minCompleteTime() {
    return minCompleteTime("minCompleteTime");
  }

  public EmployeeAwardRequest minCompleteTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeAwardRequest groupByCompleteTime() {
    return groupByCompleteTime(COMPLETE_TIME_PROPERTY);
  }

  public EmployeeAwardRequest groupByCompleteTime(String ret) {
    return groupBy(ret, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeAwardRequest groupByCompleteTime(SqlFunction func) {
    return groupByCompleteTime(COMPLETE_TIME_PROPERTY, func);
  }

  public EmployeeAwardRequest groupByCompleteTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMPLETE_TIME_PROPERTY);
    return this;
  }

  public EmployeeAwardRequest filterByType(String type) {

    if (type == null) {
      return this;
    }

    return filterByType(QueryOperator.EQUAL, type);
  }

  public EmployeeAwardRequest whereTypeIsNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAwardRequest whereTypeIsNotNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAwardRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest selectType() {
    return select(TYPE_PROPERTY);
  }

  public EmployeeAwardRequest unselectType() {
    return unselect(TYPE_PROPERTY);
  }

  public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAwardRequest orderByType(boolean asc) {
    addOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public EmployeeAwardRequest orderByTypeAscending() {
    addOrderBy(TYPE_PROPERTY, true);
    return this;
  }

  public EmployeeAwardRequest orderByTypeDescending() {
    addOrderBy(TYPE_PROPERTY, false);
    return this;
  }

  public EmployeeAwardRequest orderByTypeAscendingUsingGBK() {
    addOrderBy("convert(type using gbk)", true);
    return this;
  }

  public EmployeeAwardRequest orderByTypeDescendingUsingGBK() {
    addOrderBy("convert(type using gbk)", false);
    return this;
  }

  public EmployeeAwardRequest countType() {
    return countType("countType");
  }

  public EmployeeAwardRequest countType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TYPE_PROPERTY);
  }

  public EmployeeAwardRequest maxType() {
    return maxType("maxType");
  }

  public EmployeeAwardRequest maxType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TYPE_PROPERTY);
  }

  public EmployeeAwardRequest minType() {
    return minType("minType");
  }

  public EmployeeAwardRequest minType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TYPE_PROPERTY);
  }

  public EmployeeAwardRequest groupByType() {
    return groupByType(TYPE_PROPERTY);
  }

  public EmployeeAwardRequest groupByType(String ret) {
    return groupBy(ret, TYPE_PROPERTY);
  }

  public EmployeeAwardRequest groupByType(SqlFunction func) {
    return groupByType(TYPE_PROPERTY, func);
  }

  public EmployeeAwardRequest groupByType(String ret, SqlFunction func) {
    super.groupBy(ret, func, TYPE_PROPERTY);
    return this;
  }

  public EmployeeAwardRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public EmployeeAwardRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAwardRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAwardRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public EmployeeAwardRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAwardRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public EmployeeAwardRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public EmployeeAwardRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public EmployeeAwardRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public EmployeeAwardRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public EmployeeAwardRequest countRemark() {
    return countRemark("countRemark");
  }

  public EmployeeAwardRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public EmployeeAwardRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public EmployeeAwardRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public EmployeeAwardRequest minRemark() {
    return minRemark("minRemark");
  }

  public EmployeeAwardRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public EmployeeAwardRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public EmployeeAwardRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public EmployeeAwardRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public EmployeeAwardRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public EmployeeAwardRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeAwardRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAwardRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAwardRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAwardRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeAwardRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAwardRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeAwardRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeAwardRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeAwardRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeAwardRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeAwardRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeAwardRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeAwardRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeAwardRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeAwardRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeAwardRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeAwardRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeAwardRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeAwardRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeAwardRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeAwardRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeAwardRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeAwardRequest selectEmployeeId() {
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

  public EmployeeAwardRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeAwardRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeAwardRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeAwardRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeAwardRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeAwardRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeAwardRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeAwardRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeAwardRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeAwardRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeAwardRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeAwardRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAwardRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAwardRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeAwardRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeAwardRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeAwardRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
