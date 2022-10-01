package com.doublechaintech.retailscm.employeeperformance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeperformance.EmployeePerformance.*;

public class EmployeePerformanceRequest extends BaseRequest<EmployeePerformance> {
  public static EmployeePerformanceRequest newInstance() {
    return new EmployeePerformanceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeePerformanceRequest resultByClass(Class<? extends EmployeePerformance> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeePerformanceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeePerformanceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeePerformance";
  }

  public EmployeePerformanceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeePerformanceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeePerformanceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeePerformanceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeePerformanceRequest selectAll() {
    return this.selectId().selectEmployee().selectPerformanceComment().selectVersion();
  }

  public EmployeePerformanceRequest selectAny() {
    return selectAll();
  }

  public EmployeePerformanceRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(PERFORMANCE_COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeePerformanceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeePerformanceRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, EMPLOYEE_PROPERTY, PERFORMANCE_COMMENT_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public EmployeePerformanceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeePerformanceRequest comment(String comment) {
    return this;
  }

  public EmployeePerformanceRequest enhance() {
    return this;
  }

  public EmployeePerformanceRequest overrideClass(Class<? extends EmployeePerformance> clazz) {
    return this;
  }

  public EmployeePerformanceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeePerformanceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeePerformanceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeePerformanceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeePerformanceRequest count() {
    return countId("count");
  }

  public static EmployeePerformanceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeePerformanceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeePerformanceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeePerformanceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeePerformanceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeePerformanceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeePerformanceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeePerformanceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeePerformanceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeePerformanceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeePerformanceRequest countId() {
    return countId("countId");
  }

  public EmployeePerformanceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeePerformanceRequest maxId() {
    return maxId("maxId");
  }

  public EmployeePerformanceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeePerformanceRequest minId() {
    return minId("minId");
  }

  public EmployeePerformanceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeePerformanceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeePerformanceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeePerformanceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeePerformanceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeePerformanceRequest filterByPerformanceComment(String performanceComment) {

    if (performanceComment == null) {
      return this;
    }

    return filterByPerformanceComment(QueryOperator.EQUAL, performanceComment);
  }

  public EmployeePerformanceRequest wherePerformanceCommentIsNull() {
    return where(PERFORMANCE_COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeePerformanceRequest wherePerformanceCommentIsNotNull() {
    return where(PERFORMANCE_COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeePerformanceRequest filterByPerformanceComment(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPerformanceCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeePerformanceRequest selectPerformanceComment() {
    return select(PERFORMANCE_COMMENT_PROPERTY);
  }

  public EmployeePerformanceRequest unselectPerformanceComment() {
    return unselect(PERFORMANCE_COMMENT_PROPERTY);
  }

  public SearchCriteria getPerformanceCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PERFORMANCE_COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeePerformanceRequest orderByPerformanceComment(boolean asc) {
    addOrderBy(PERFORMANCE_COMMENT_PROPERTY, asc);
    return this;
  }

  public EmployeePerformanceRequest orderByPerformanceCommentAscending() {
    addOrderBy(PERFORMANCE_COMMENT_PROPERTY, true);
    return this;
  }

  public EmployeePerformanceRequest orderByPerformanceCommentDescending() {
    addOrderBy(PERFORMANCE_COMMENT_PROPERTY, false);
    return this;
  }

  public EmployeePerformanceRequest orderByPerformanceCommentAscendingUsingGBK() {
    addOrderBy("convert(performanceComment using gbk)", true);
    return this;
  }

  public EmployeePerformanceRequest orderByPerformanceCommentDescendingUsingGBK() {
    addOrderBy("convert(performanceComment using gbk)", false);
    return this;
  }

  public EmployeePerformanceRequest countPerformanceComment() {
    return countPerformanceComment("countPerformanceComment");
  }

  public EmployeePerformanceRequest countPerformanceComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PERFORMANCE_COMMENT_PROPERTY);
  }

  public EmployeePerformanceRequest maxPerformanceComment() {
    return maxPerformanceComment("maxPerformanceComment");
  }

  public EmployeePerformanceRequest maxPerformanceComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PERFORMANCE_COMMENT_PROPERTY);
  }

  public EmployeePerformanceRequest minPerformanceComment() {
    return minPerformanceComment("minPerformanceComment");
  }

  public EmployeePerformanceRequest minPerformanceComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PERFORMANCE_COMMENT_PROPERTY);
  }

  public EmployeePerformanceRequest groupByPerformanceComment() {
    return groupByPerformanceComment(PERFORMANCE_COMMENT_PROPERTY);
  }

  public EmployeePerformanceRequest groupByPerformanceComment(String ret) {
    return groupBy(ret, PERFORMANCE_COMMENT_PROPERTY);
  }

  public EmployeePerformanceRequest groupByPerformanceComment(SqlFunction func) {
    return groupByPerformanceComment(PERFORMANCE_COMMENT_PROPERTY, func);
  }

  public EmployeePerformanceRequest groupByPerformanceComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, PERFORMANCE_COMMENT_PROPERTY);
    return this;
  }

  public EmployeePerformanceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeePerformanceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeePerformanceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeePerformanceRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeePerformanceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeePerformanceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeePerformanceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeePerformanceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeePerformanceRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeePerformanceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeePerformanceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeePerformanceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeePerformanceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeePerformanceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeePerformanceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeePerformanceRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeePerformanceRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeePerformanceRequest selectEmployeeId() {
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

  public EmployeePerformanceRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeePerformanceRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeePerformanceRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeePerformanceRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeePerformanceRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeePerformanceRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeePerformanceRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeePerformanceRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeePerformanceRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeePerformanceRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeePerformanceRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeePerformanceRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeePerformanceRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeePerformanceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeePerformanceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeePerformanceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeePerformanceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
