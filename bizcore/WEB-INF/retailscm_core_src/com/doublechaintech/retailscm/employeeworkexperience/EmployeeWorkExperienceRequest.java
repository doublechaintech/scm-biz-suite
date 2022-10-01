package com.doublechaintech.retailscm.employeeworkexperience;

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
import static com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience.*;

public class EmployeeWorkExperienceRequest extends BaseRequest<EmployeeWorkExperience> {
  public static EmployeeWorkExperienceRequest newInstance() {
    return new EmployeeWorkExperienceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeWorkExperienceRequest resultByClass(
      Class<? extends EmployeeWorkExperience> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeWorkExperienceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeWorkExperienceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeWorkExperience";
  }

  public EmployeeWorkExperienceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeWorkExperienceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeWorkExperienceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeWorkExperienceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeWorkExperienceRequest selectAll() {
    return this.selectId()
        .selectEmployee()
        .selectStart()
        .selectEnd()
        .selectCompany()
        .selectDescription()
        .selectVersion();
  }

  public EmployeeWorkExperienceRequest selectAny() {
    return selectAll();
  }

  public EmployeeWorkExperienceRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(START_PROPERTY);
    select(END_PROPERTY);
    select(COMPANY_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeWorkExperienceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeWorkExperienceRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {START_PROPERTY, END_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    EMPLOYEE_PROPERTY,
    START_PROPERTY,
    END_PROPERTY,
    COMPANY_PROPERTY,
    DESCRIPTION_PROPERTY,
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

  public EmployeeWorkExperienceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeWorkExperienceRequest comment(String comment) {
    return this;
  }

  public EmployeeWorkExperienceRequest enhance() {
    return this;
  }

  public EmployeeWorkExperienceRequest overrideClass(
      Class<? extends EmployeeWorkExperience> clazz) {
    return this;
  }

  public EmployeeWorkExperienceRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeWorkExperienceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeWorkExperienceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeWorkExperienceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeWorkExperienceRequest count() {
    return countId("count");
  }

  public static EmployeeWorkExperienceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeWorkExperienceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeWorkExperienceRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeWorkExperienceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeWorkExperienceRequest countId() {
    return countId("countId");
  }

  public EmployeeWorkExperienceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeWorkExperienceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest minId() {
    return minId("minId");
  }

  public EmployeeWorkExperienceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeWorkExperienceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest filterByStart(Date start) {

    if (start == null) {
      return this;
    }

    return filterByStart(QueryOperator.EQUAL, start);
  }

  public EmployeeWorkExperienceRequest whereStartIsNull() {
    return where(START_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeWorkExperienceRequest whereStartIsNotNull() {
    return where(START_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeWorkExperienceRequest whereStartBetween(Date startStart, Date startEnd) {
    if (ObjectUtil.isEmpty(startStart)) {
      throw new IllegalArgumentException(
          "Method whereStartBetween, the parameter startStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(startEnd)) {
      throw new IllegalArgumentException(
          "Method whereStartBetween, the parameter startEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getStartSearchCriteria(QueryOperator.BETWEEN, new Object[] {startStart, startEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest whereStartBefore(Date start) {

    if (ObjectUtil.isEmpty(start)) {
      throw new IllegalArgumentException(
          "Method whereStartBefore, the parameter start is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getStartSearchCriteria(QueryOperator.LESS_THAN, new Object[] {start});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest whereStartAfter(Date start) {
    if (ObjectUtil.isEmpty(start)) {
      throw new IllegalArgumentException(
          "Method whereStartAfter, the parameter start is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getStartSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {start});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest filterByStart(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getStartSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest selectStart() {
    return select(START_PROPERTY);
  }

  public EmployeeWorkExperienceRequest unselectStart() {
    return unselect(START_PROPERTY);
  }

  public SearchCriteria getStartSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(START_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeWorkExperienceRequest orderByStart(boolean asc) {
    addOrderBy(START_PROPERTY, asc);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByStartAscending() {
    addOrderBy(START_PROPERTY, true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByStartDescending() {
    addOrderBy(START_PROPERTY, false);
    return this;
  }

  public EmployeeWorkExperienceRequest countStart() {
    return countStart("countStart");
  }

  public EmployeeWorkExperienceRequest countStart(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, START_PROPERTY);
  }

  public EmployeeWorkExperienceRequest maxStart() {
    return maxStart("maxStart");
  }

  public EmployeeWorkExperienceRequest maxStart(String aggName) {
    return aggregate(aggName, AggFunc.MAX, START_PROPERTY);
  }

  public EmployeeWorkExperienceRequest minStart() {
    return minStart("minStart");
  }

  public EmployeeWorkExperienceRequest minStart(String aggName) {
    return aggregate(aggName, AggFunc.MIN, START_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByStart() {
    return groupByStart(START_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByStart(String ret) {
    return groupBy(ret, START_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByStart(SqlFunction func) {
    return groupByStart(START_PROPERTY, func);
  }

  public EmployeeWorkExperienceRequest groupByStart(String ret, SqlFunction func) {
    super.groupBy(ret, func, START_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest filterByEnd(Date end) {

    if (end == null) {
      return this;
    }

    return filterByEnd(QueryOperator.EQUAL, end);
  }

  public EmployeeWorkExperienceRequest whereEndIsNull() {
    return where(END_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeWorkExperienceRequest whereEndIsNotNull() {
    return where(END_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeWorkExperienceRequest whereEndBetween(Date endStart, Date endEnd) {
    if (ObjectUtil.isEmpty(endStart)) {
      throw new IllegalArgumentException(
          "Method whereEndBetween, the parameter endStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(endEnd)) {
      throw new IllegalArgumentException(
          "Method whereEndBetween, the parameter endEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEndSearchCriteria(QueryOperator.BETWEEN, new Object[] {endStart, endEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest whereEndBefore(Date end) {

    if (ObjectUtil.isEmpty(end)) {
      throw new IllegalArgumentException(
          "Method whereEndBefore, the parameter end is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getEndSearchCriteria(QueryOperator.LESS_THAN, new Object[] {end});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest whereEndAfter(Date end) {
    if (ObjectUtil.isEmpty(end)) {
      throw new IllegalArgumentException(
          "Method whereEndAfter, the parameter end is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEndSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {end});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest filterByEnd(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEndSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest selectEnd() {
    return select(END_PROPERTY);
  }

  public EmployeeWorkExperienceRequest unselectEnd() {
    return unselect(END_PROPERTY);
  }

  public SearchCriteria getEndSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(END_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeWorkExperienceRequest orderByEnd(boolean asc) {
    addOrderBy(END_PROPERTY, asc);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByEndAscending() {
    addOrderBy(END_PROPERTY, true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByEndDescending() {
    addOrderBy(END_PROPERTY, false);
    return this;
  }

  public EmployeeWorkExperienceRequest countEnd() {
    return countEnd("countEnd");
  }

  public EmployeeWorkExperienceRequest countEnd(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, END_PROPERTY);
  }

  public EmployeeWorkExperienceRequest maxEnd() {
    return maxEnd("maxEnd");
  }

  public EmployeeWorkExperienceRequest maxEnd(String aggName) {
    return aggregate(aggName, AggFunc.MAX, END_PROPERTY);
  }

  public EmployeeWorkExperienceRequest minEnd() {
    return minEnd("minEnd");
  }

  public EmployeeWorkExperienceRequest minEnd(String aggName) {
    return aggregate(aggName, AggFunc.MIN, END_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByEnd() {
    return groupByEnd(END_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByEnd(String ret) {
    return groupBy(ret, END_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByEnd(SqlFunction func) {
    return groupByEnd(END_PROPERTY, func);
  }

  public EmployeeWorkExperienceRequest groupByEnd(String ret, SqlFunction func) {
    super.groupBy(ret, func, END_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest filterByCompany(String company) {

    if (company == null) {
      return this;
    }

    return filterByCompany(QueryOperator.EQUAL, company);
  }

  public EmployeeWorkExperienceRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeWorkExperienceRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeWorkExperienceRequest filterByCompany(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCompanySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest selectCompany() {
    return select(COMPANY_PROPERTY);
  }

  public EmployeeWorkExperienceRequest unselectCompany() {
    return unselect(COMPANY_PROPERTY);
  }

  public SearchCriteria getCompanySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMPANY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeWorkExperienceRequest orderByCompany(boolean asc) {
    addOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByCompanyAscending() {
    addOrderBy(COMPANY_PROPERTY, true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByCompanyDescending() {
    addOrderBy(COMPANY_PROPERTY, false);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByCompanyAscendingUsingGBK() {
    addOrderBy("convert(company using gbk)", true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByCompanyDescendingUsingGBK() {
    addOrderBy("convert(company using gbk)", false);
    return this;
  }

  public EmployeeWorkExperienceRequest countCompany() {
    return countCompany("countCompany");
  }

  public EmployeeWorkExperienceRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public EmployeeWorkExperienceRequest maxCompany() {
    return maxCompany("maxCompany");
  }

  public EmployeeWorkExperienceRequest maxCompany(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMPANY_PROPERTY);
  }

  public EmployeeWorkExperienceRequest minCompany() {
    return minCompany("minCompany");
  }

  public EmployeeWorkExperienceRequest minCompany(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMPANY_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByCompany(SqlFunction func) {
    return groupByCompany(COMPANY_PROPERTY, func);
  }

  public EmployeeWorkExperienceRequest groupByCompany(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMPANY_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public EmployeeWorkExperienceRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeWorkExperienceRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeWorkExperienceRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeWorkExperienceRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public EmployeeWorkExperienceRequest countDescription() {
    return countDescription("countDescription");
  }

  public EmployeeWorkExperienceRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public EmployeeWorkExperienceRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest minDescription() {
    return minDescription("minDescription");
  }

  public EmployeeWorkExperienceRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public EmployeeWorkExperienceRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeWorkExperienceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeWorkExperienceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeWorkExperienceRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeWorkExperienceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeWorkExperienceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeWorkExperienceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeWorkExperienceRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeWorkExperienceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeWorkExperienceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeWorkExperienceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeWorkExperienceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeWorkExperienceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeWorkExperienceRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeWorkExperienceRequest selectEmployeeId() {
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

  public EmployeeWorkExperienceRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeWorkExperienceRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeWorkExperienceRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeWorkExperienceRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeWorkExperienceRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeWorkExperienceRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeWorkExperienceRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeWorkExperienceRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeWorkExperienceRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeWorkExperienceRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeWorkExperienceRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeWorkExperienceRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeWorkExperienceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeWorkExperienceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeWorkExperienceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeWorkExperienceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
