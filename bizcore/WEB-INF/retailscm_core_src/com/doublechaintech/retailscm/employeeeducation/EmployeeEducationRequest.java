package com.doublechaintech.retailscm.employeeeducation;

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
import static com.doublechaintech.retailscm.employeeeducation.EmployeeEducation.*;

public class EmployeeEducationRequest extends BaseRequest<EmployeeEducation> {
  public static EmployeeEducationRequest newInstance() {
    return new EmployeeEducationRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeEducationRequest resultByClass(Class<? extends EmployeeEducation> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeEducationRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeEducationRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeEducation";
  }

  public EmployeeEducationRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeEducationRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeEducationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeEducationRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeEducationRequest selectAll() {
    return this.selectId()
        .selectEmployee()
        .selectCompleteTime()
        .selectType()
        .selectRemark()
        .selectVersion();
  }

  public EmployeeEducationRequest selectAny() {
    return selectAll();
  }

  public EmployeeEducationRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(COMPLETE_TIME_PROPERTY);
    select(TYPE_PROPERTY);
    select(REMARK_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeEducationRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeEducationRequest where(
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

  public EmployeeEducationRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeEducationRequest comment(String comment) {
    return this;
  }

  public EmployeeEducationRequest enhance() {
    return this;
  }

  public EmployeeEducationRequest overrideClass(Class<? extends EmployeeEducation> clazz) {
    return this;
  }

  public EmployeeEducationRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeEducationRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeEducationRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeEducationRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeEducationRequest count() {
    return countId("count");
  }

  public static EmployeeEducationRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeEducationRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeEducationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeEducationRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeEducationRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeEducationRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeEducationRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeEducationRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeEducationRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeEducationRequest countId() {
    return countId("countId");
  }

  public EmployeeEducationRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeEducationRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeEducationRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeEducationRequest minId() {
    return minId("minId");
  }

  public EmployeeEducationRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeEducationRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeEducationRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeEducationRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeEducationRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeEducationRequest filterByCompleteTime(Date completeTime) {

    if (completeTime == null) {
      return this;
    }

    return filterByCompleteTime(QueryOperator.EQUAL, completeTime);
  }

  public EmployeeEducationRequest whereCompleteTimeIsNull() {
    return where(COMPLETE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeEducationRequest whereCompleteTimeIsNotNull() {
    return where(COMPLETE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeEducationRequest whereCompleteTimeBetween(
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

  public EmployeeEducationRequest whereCompleteTimeBefore(Date completeTime) {

    if (ObjectUtil.isEmpty(completeTime)) {
      throw new IllegalArgumentException(
          "Method whereCompleteTimeBefore, the parameter completeTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCompleteTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {completeTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest whereCompleteTimeAfter(Date completeTime) {
    if (ObjectUtil.isEmpty(completeTime)) {
      throw new IllegalArgumentException(
          "Method whereCompleteTimeAfter, the parameter completeTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCompleteTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {completeTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest filterByCompleteTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCompleteTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest selectCompleteTime() {
    return select(COMPLETE_TIME_PROPERTY);
  }

  public EmployeeEducationRequest unselectCompleteTime() {
    return unselect(COMPLETE_TIME_PROPERTY);
  }

  public SearchCriteria getCompleteTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMPLETE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeEducationRequest orderByCompleteTime(boolean asc) {
    addOrderBy(COMPLETE_TIME_PROPERTY, asc);
    return this;
  }

  public EmployeeEducationRequest orderByCompleteTimeAscending() {
    addOrderBy(COMPLETE_TIME_PROPERTY, true);
    return this;
  }

  public EmployeeEducationRequest orderByCompleteTimeDescending() {
    addOrderBy(COMPLETE_TIME_PROPERTY, false);
    return this;
  }

  public EmployeeEducationRequest countCompleteTime() {
    return countCompleteTime("countCompleteTime");
  }

  public EmployeeEducationRequest countCompleteTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeEducationRequest maxCompleteTime() {
    return maxCompleteTime("maxCompleteTime");
  }

  public EmployeeEducationRequest maxCompleteTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeEducationRequest minCompleteTime() {
    return minCompleteTime("minCompleteTime");
  }

  public EmployeeEducationRequest minCompleteTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeEducationRequest groupByCompleteTime() {
    return groupByCompleteTime(COMPLETE_TIME_PROPERTY);
  }

  public EmployeeEducationRequest groupByCompleteTime(String ret) {
    return groupBy(ret, COMPLETE_TIME_PROPERTY);
  }

  public EmployeeEducationRequest groupByCompleteTime(SqlFunction func) {
    return groupByCompleteTime(COMPLETE_TIME_PROPERTY, func);
  }

  public EmployeeEducationRequest groupByCompleteTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMPLETE_TIME_PROPERTY);
    return this;
  }

  public EmployeeEducationRequest filterByType(String type) {

    if (type == null) {
      return this;
    }

    return filterByType(QueryOperator.EQUAL, type);
  }

  public EmployeeEducationRequest whereTypeIsNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeEducationRequest whereTypeIsNotNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeEducationRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest selectType() {
    return select(TYPE_PROPERTY);
  }

  public EmployeeEducationRequest unselectType() {
    return unselect(TYPE_PROPERTY);
  }

  public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeEducationRequest orderByType(boolean asc) {
    addOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public EmployeeEducationRequest orderByTypeAscending() {
    addOrderBy(TYPE_PROPERTY, true);
    return this;
  }

  public EmployeeEducationRequest orderByTypeDescending() {
    addOrderBy(TYPE_PROPERTY, false);
    return this;
  }

  public EmployeeEducationRequest orderByTypeAscendingUsingGBK() {
    addOrderBy("convert(type using gbk)", true);
    return this;
  }

  public EmployeeEducationRequest orderByTypeDescendingUsingGBK() {
    addOrderBy("convert(type using gbk)", false);
    return this;
  }

  public EmployeeEducationRequest countType() {
    return countType("countType");
  }

  public EmployeeEducationRequest countType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TYPE_PROPERTY);
  }

  public EmployeeEducationRequest maxType() {
    return maxType("maxType");
  }

  public EmployeeEducationRequest maxType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TYPE_PROPERTY);
  }

  public EmployeeEducationRequest minType() {
    return minType("minType");
  }

  public EmployeeEducationRequest minType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TYPE_PROPERTY);
  }

  public EmployeeEducationRequest groupByType() {
    return groupByType(TYPE_PROPERTY);
  }

  public EmployeeEducationRequest groupByType(String ret) {
    return groupBy(ret, TYPE_PROPERTY);
  }

  public EmployeeEducationRequest groupByType(SqlFunction func) {
    return groupByType(TYPE_PROPERTY, func);
  }

  public EmployeeEducationRequest groupByType(String ret, SqlFunction func) {
    super.groupBy(ret, func, TYPE_PROPERTY);
    return this;
  }

  public EmployeeEducationRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public EmployeeEducationRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeEducationRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeEducationRequest filterByRemark(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public EmployeeEducationRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeEducationRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public EmployeeEducationRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public EmployeeEducationRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public EmployeeEducationRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public EmployeeEducationRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public EmployeeEducationRequest countRemark() {
    return countRemark("countRemark");
  }

  public EmployeeEducationRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public EmployeeEducationRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public EmployeeEducationRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public EmployeeEducationRequest minRemark() {
    return minRemark("minRemark");
  }

  public EmployeeEducationRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public EmployeeEducationRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public EmployeeEducationRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public EmployeeEducationRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public EmployeeEducationRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public EmployeeEducationRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeEducationRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeEducationRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeEducationRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeEducationRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeEducationRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeEducationRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeEducationRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeEducationRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeEducationRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeEducationRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeEducationRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeEducationRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeEducationRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeEducationRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeEducationRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeEducationRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeEducationRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeEducationRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeEducationRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeEducationRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeEducationRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeEducationRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeEducationRequest selectEmployeeId() {
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

  public EmployeeEducationRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeEducationRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeEducationRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeEducationRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeEducationRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeEducationRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeEducationRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeEducationRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeEducationRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeEducationRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeEducationRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeEducationRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeEducationRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeEducationRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeEducationRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeEducationRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeEducationRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
