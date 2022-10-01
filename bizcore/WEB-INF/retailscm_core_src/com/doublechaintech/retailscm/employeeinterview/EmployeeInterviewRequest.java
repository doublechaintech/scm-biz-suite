package com.doublechaintech.retailscm.employeeinterview;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeinterview.EmployeeInterview.*;

public class EmployeeInterviewRequest extends BaseRequest<EmployeeInterview> {
  public static EmployeeInterviewRequest newInstance() {
    return new EmployeeInterviewRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeInterviewRequest resultByClass(Class<? extends EmployeeInterview> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeInterviewRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeInterviewRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeInterview";
  }

  public EmployeeInterviewRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeInterviewRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeInterviewRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeInterviewRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeInterviewRequest selectAll() {
    return this.selectId().selectEmployee().selectInterviewType().selectRemark().selectVersion();
  }

  public EmployeeInterviewRequest selectAny() {
    return selectAll();
  }

  public EmployeeInterviewRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(INTERVIEW_TYPE_PROPERTY);
    select(REMARK_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeInterviewRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeInterviewRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, EMPLOYEE_PROPERTY, INTERVIEW_TYPE_PROPERTY, REMARK_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public EmployeeInterviewRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeInterviewRequest comment(String comment) {
    return this;
  }

  public EmployeeInterviewRequest enhance() {
    return this;
  }

  public EmployeeInterviewRequest overrideClass(Class<? extends EmployeeInterview> clazz) {
    return this;
  }

  public EmployeeInterviewRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeInterviewRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeInterviewRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeInterviewRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeInterviewRequest count() {
    return countId("count");
  }

  public static EmployeeInterviewRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeInterviewRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeInterviewRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeInterviewRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeInterviewRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeInterviewRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeInterviewRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeInterviewRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeInterviewRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeInterviewRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeInterviewRequest countId() {
    return countId("countId");
  }

  public EmployeeInterviewRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeInterviewRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeInterviewRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeInterviewRequest minId() {
    return minId("minId");
  }

  public EmployeeInterviewRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeInterviewRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeInterviewRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeInterviewRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeInterviewRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeInterviewRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public EmployeeInterviewRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeInterviewRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeInterviewRequest filterByRemark(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeInterviewRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public EmployeeInterviewRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeInterviewRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public EmployeeInterviewRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public EmployeeInterviewRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public EmployeeInterviewRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public EmployeeInterviewRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public EmployeeInterviewRequest countRemark() {
    return countRemark("countRemark");
  }

  public EmployeeInterviewRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public EmployeeInterviewRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public EmployeeInterviewRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public EmployeeInterviewRequest minRemark() {
    return minRemark("minRemark");
  }

  public EmployeeInterviewRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public EmployeeInterviewRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public EmployeeInterviewRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public EmployeeInterviewRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public EmployeeInterviewRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public EmployeeInterviewRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeInterviewRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeInterviewRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeInterviewRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeInterviewRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeInterviewRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeInterviewRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeInterviewRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeInterviewRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeInterviewRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeInterviewRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeInterviewRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeInterviewRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeInterviewRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeInterviewRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeInterviewRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeInterviewRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeInterviewRequest selectEmployeeId() {
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

  public EmployeeInterviewRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeInterviewRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeInterviewRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeInterviewRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeInterviewRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeInterviewRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeInterviewRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeInterviewRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeInterviewRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeInterviewRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeInterviewRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeInterviewRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeInterviewRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeInterviewRequest filterByInterviewType(InterviewTypeRequest interviewType) {
    return filterByInterviewType(interviewType, InterviewType::getId);
  }

  public EmployeeInterviewRequest filterByInterviewType(InterviewType... interviewType) {
    if (isEmptyParam(interviewType)) {
      throw new IllegalArgumentException(
          "filterByInterviewType(InterviewType... interviewType)参数不能为空!");
    }
    return where(INTERVIEW_TYPE_PROPERTY, QueryOperator.IN, (Object[]) interviewType);
  }

  public EmployeeInterviewRequest selectInterviewTypeId() {
    select(INTERVIEW_TYPE_PROPERTY);
    return this;
  }

  public InterviewTypeRequest upToInterviewType() {
    return upToInterviewType(InterviewTypeRequest.newInstance());
  }

  public InterviewTypeRequest upToInterviewType(InterviewTypeRequest interviewType) {
    interviewType.aggregateChild(INTERVIEW_TYPE_PROPERTY, this);
    this.groupByInterviewType(interviewType);
    return interviewType;
  }

  public InterviewTypeRequest endAtInterviewType(String retName) {
    return endAtInterviewType(retName, InterviewTypeRequest.newInstance());
  }

  public InterviewTypeRequest endAtInterviewType(
      String retName, InterviewTypeRequest interviewType) {
    interviewType.addDynamicProperty(retName, this, INTERVIEW_TYPE_PROPERTY);
    return interviewType;
  }

  public EmployeeInterviewRequest filterByInterviewType(String... interviewType) {
    if (isEmptyParam(interviewType)) {
      throw new IllegalArgumentException("filterByInterviewType(String... interviewType)参数不能为空!");
    }
    return where(INTERVIEW_TYPE_PROPERTY, QueryOperator.IN, (Object[]) interviewType);
  }

  public EmployeeInterviewRequest filterByInterviewType(
      InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
    interviewType.unlimited();
    return addSearchCriteria(createInterviewTypeCriteria(interviewType, idRefine));
  }

  public SearchCriteria createInterviewTypeCriteria(
      InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
    return new RefinedIdInCriteria(
        interviewType, INTERVIEW_TYPE_PROPERTY, idRefine, InterviewType.ID_PROPERTY);
  }

  public EmployeeInterviewRequest selectInterviewType() {
    return selectInterviewType(InterviewTypeRequest.newInstance().selectSelf());
  }

  public EmployeeInterviewRequest selectInterviewType(InterviewTypeRequest interviewType) {
    selectParent(INTERVIEW_TYPE_PROPERTY, interviewType);
    return this;
  }

  public EmployeeInterviewRequest unselectInterviewType() {
    unselectParent(INTERVIEW_TYPE_PROPERTY);
    return this;
  }

  public EmployeeInterviewRequest groupByInterviewType(InterviewTypeRequest interviewType) {
    groupBy(INTERVIEW_TYPE_PROPERTY, interviewType);
    return this;
  }

  public EmployeeInterviewRequest aggregateInterviewType(InterviewTypeRequest interviewType) {
    aggregateParent(INTERVIEW_TYPE_PROPERTY, interviewType);
    return this;
  }

  public EmployeeInterviewRequest countInterviewType() {
    return countInterviewType("countInterviewType");
  }

  public EmployeeInterviewRequest countInterviewType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, INTERVIEW_TYPE_PROPERTY);
  }

  public EmployeeInterviewRequest groupByInterviewType() {
    return groupByInterviewType(INTERVIEW_TYPE_PROPERTY);
  }

  public EmployeeInterviewRequest groupByInterviewType(String ret) {
    return groupBy(ret, INTERVIEW_TYPE_PROPERTY);
  }

  public EmployeeInterviewRequest whereInterviewTypeIsNull() {
    return where(INTERVIEW_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeInterviewRequest whereInterviewTypeIsNotNull() {
    return where(INTERVIEW_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeInterviewRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeInterviewRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeInterviewRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeInterviewRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
