package com.doublechaintech.retailscm.responsibilitytype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType.*;

public class ResponsibilityTypeRequest extends BaseRequest<ResponsibilityType> {
  public static ResponsibilityTypeRequest newInstance() {
    return new ResponsibilityTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ResponsibilityTypeRequest resultByClass(Class<? extends ResponsibilityType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ResponsibilityTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ResponsibilityTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ResponsibilityType";
  }

  public ResponsibilityTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ResponsibilityTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ResponsibilityTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ResponsibilityTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ResponsibilityTypeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectBaseDescription()
        .selectDetailDescription()
        .selectVersion();
  }

  public ResponsibilityTypeRequest selectAny() {
    return selectAll().selectEmployeeList(Q.employee().selectSelf());
  }

  public ResponsibilityTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(BASE_DESCRIPTION_PROPERTY);
    select(DETAIL_DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ResponsibilityTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ResponsibilityTypeRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    CODE_PROPERTY,
    COMPANY_PROPERTY,
    BASE_DESCRIPTION_PROPERTY,
    DETAIL_DESCRIPTION_PROPERTY,
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

  public ResponsibilityTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ResponsibilityTypeRequest comment(String comment) {
    return this;
  }

  public ResponsibilityTypeRequest enhance() {
    return this;
  }

  public ResponsibilityTypeRequest overrideClass(Class<? extends ResponsibilityType> clazz) {
    return this;
  }

  public ResponsibilityTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ResponsibilityTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ResponsibilityTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ResponsibilityTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ResponsibilityTypeRequest count() {
    return countId("count");
  }

  public static ResponsibilityTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ResponsibilityTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ResponsibilityTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ResponsibilityTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ResponsibilityTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ResponsibilityTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ResponsibilityTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ResponsibilityTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ResponsibilityTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ResponsibilityTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ResponsibilityTypeRequest countId() {
    return countId("countId");
  }

  public ResponsibilityTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ResponsibilityTypeRequest maxId() {
    return maxId("maxId");
  }

  public ResponsibilityTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ResponsibilityTypeRequest minId() {
    return minId("minId");
  }

  public ResponsibilityTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ResponsibilityTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ResponsibilityTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ResponsibilityTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ResponsibilityTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public ResponsibilityTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ResponsibilityTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ResponsibilityTypeRequest filterByCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ResponsibilityTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public ResponsibilityTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ResponsibilityTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public ResponsibilityTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public ResponsibilityTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public ResponsibilityTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public ResponsibilityTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public ResponsibilityTypeRequest countCode() {
    return countCode("countCode");
  }

  public ResponsibilityTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public ResponsibilityTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public ResponsibilityTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public ResponsibilityTypeRequest minCode() {
    return minCode("minCode");
  }

  public ResponsibilityTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public ResponsibilityTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest filterByBaseDescription(String baseDescription) {

    if (baseDescription == null) {
      return this;
    }

    return filterByBaseDescription(QueryOperator.EQUAL, baseDescription);
  }

  public ResponsibilityTypeRequest whereBaseDescriptionIsNull() {
    return where(BASE_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ResponsibilityTypeRequest whereBaseDescriptionIsNotNull() {
    return where(BASE_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ResponsibilityTypeRequest filterByBaseDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBaseDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ResponsibilityTypeRequest selectBaseDescription() {
    return select(BASE_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest unselectBaseDescription() {
    return unselect(BASE_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getBaseDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BASE_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ResponsibilityTypeRequest orderByBaseDescription(boolean asc) {
    addOrderBy(BASE_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public ResponsibilityTypeRequest orderByBaseDescriptionAscending() {
    addOrderBy(BASE_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public ResponsibilityTypeRequest orderByBaseDescriptionDescending() {
    addOrderBy(BASE_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public ResponsibilityTypeRequest orderByBaseDescriptionAscendingUsingGBK() {
    addOrderBy("convert(baseDescription using gbk)", true);
    return this;
  }

  public ResponsibilityTypeRequest orderByBaseDescriptionDescendingUsingGBK() {
    addOrderBy("convert(baseDescription using gbk)", false);
    return this;
  }

  public ResponsibilityTypeRequest countBaseDescription() {
    return countBaseDescription("countBaseDescription");
  }

  public ResponsibilityTypeRequest countBaseDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BASE_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest maxBaseDescription() {
    return maxBaseDescription("maxBaseDescription");
  }

  public ResponsibilityTypeRequest maxBaseDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BASE_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest minBaseDescription() {
    return minBaseDescription("minBaseDescription");
  }

  public ResponsibilityTypeRequest minBaseDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BASE_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByBaseDescription() {
    return groupByBaseDescription(BASE_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByBaseDescription(String ret) {
    return groupBy(ret, BASE_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByBaseDescription(SqlFunction func) {
    return groupByBaseDescription(BASE_DESCRIPTION_PROPERTY, func);
  }

  public ResponsibilityTypeRequest groupByBaseDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, BASE_DESCRIPTION_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest filterByDetailDescription(String detailDescription) {

    if (detailDescription == null) {
      return this;
    }

    return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
  }

  public ResponsibilityTypeRequest whereDetailDescriptionIsNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ResponsibilityTypeRequest whereDetailDescriptionIsNotNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ResponsibilityTypeRequest filterByDetailDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ResponsibilityTypeRequest selectDetailDescription() {
    return select(DETAIL_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest unselectDetailDescription() {
    return unselect(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDetailDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ResponsibilityTypeRequest orderByDetailDescription(boolean asc) {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public ResponsibilityTypeRequest orderByDetailDescriptionAscending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public ResponsibilityTypeRequest orderByDetailDescriptionDescending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public ResponsibilityTypeRequest orderByDetailDescriptionAscendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", true);
    return this;
  }

  public ResponsibilityTypeRequest orderByDetailDescriptionDescendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", false);
    return this;
  }

  public ResponsibilityTypeRequest countDetailDescription() {
    return countDetailDescription("countDetailDescription");
  }

  public ResponsibilityTypeRequest countDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DETAIL_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest maxDetailDescription() {
    return maxDetailDescription("maxDetailDescription");
  }

  public ResponsibilityTypeRequest maxDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DETAIL_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest minDetailDescription() {
    return minDetailDescription("minDetailDescription");
  }

  public ResponsibilityTypeRequest minDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DETAIL_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByDetailDescription() {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByDetailDescription(String ret) {
    return groupBy(ret, DETAIL_DESCRIPTION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByDetailDescription(SqlFunction func) {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY, func);
  }

  public ResponsibilityTypeRequest groupByDetailDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ResponsibilityTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ResponsibilityTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ResponsibilityTypeRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ResponsibilityTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ResponsibilityTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ResponsibilityTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ResponsibilityTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ResponsibilityTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public ResponsibilityTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ResponsibilityTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public ResponsibilityTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ResponsibilityTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ResponsibilityTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public ResponsibilityTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public ResponsibilityTypeRequest selectCompanyId() {
    select(COMPANY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToCompany() {
    return upToCompany(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToCompany(RetailStoreCountryCenterRequest company) {
    company.aggregateChild(COMPANY_PROPERTY, this);
    this.groupByCompany(company);
    return company;
  }

  public RetailStoreCountryCenterRequest endAtCompany(String retName) {
    return endAtCompany(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtCompany(
      String retName, RetailStoreCountryCenterRequest company) {
    company.addDynamicProperty(retName, this, COMPANY_PROPERTY);
    return company;
  }

  public ResponsibilityTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public ResponsibilityTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public ResponsibilityTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public ResponsibilityTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public ResponsibilityTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public ResponsibilityTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public ResponsibilityTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public ResponsibilityTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public ResponsibilityTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public ResponsibilityTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public ResponsibilityTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ResponsibilityTypeRequest hasEmployee() {
    return hasEmployee(EmployeeRequest.newInstance());
  }

  public ResponsibilityTypeRequest hasEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("hasEmployee(Employee... employee)参数不能为空!");
    }
    return hasEmployee(
        Q.employee()
            .select(Employee.RESPONSIBLE_FOR_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employee));
  }

  public ResponsibilityTypeRequest hasEmployee(String... employee) {
    return hasEmployee(Q.employee().select(Employee.RESPONSIBLE_FOR_PROPERTY).filterById(employee));
  }

  public ResponsibilityTypeRequest hasEmployee(EmployeeRequest employee) {
    return hasEmployee(
        employee,
        $employee ->
            java.util.Optional.of($employee)
                .map(Employee::getResponsibleFor)
                .map(ResponsibilityType::getId)
                .orElse(null));
  }

  public ResponsibilityTypeRequest hasEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.select(Employee.RESPONSIBLE_FOR_PROPERTY);
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public ResponsibilityTypeRequest hasEmployee(
      EmployeeRequest employee, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(employee, Employee.RESPONSIBLE_FOR_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(
        employee, ID_PROPERTY, idRefine, Employee.RESPONSIBLE_FOR_PROPERTY);
  }

  public ResponsibilityTypeRequest selectEmployeeList(EmployeeRequest employee) {
    selectChild(Employee.RESPONSIBLE_FOR_PROPERTY, employee);
    return this;
  }

  public ResponsibilityTypeRequest selectEmployeeList() {
    return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
  }

  public ResponsibilityTypeRequest unselectEmployeeList() {
    unselectChild(Employee.RESPONSIBLE_FOR_PROPERTY, Employee.class);
    return this;
  }

  public ResponsibilityTypeRequest aggregateEmployeeList(EmployeeRequest employee) {
    aggregateChild(Employee.RESPONSIBLE_FOR_PROPERTY, employee);
    return this;
  }

  public ResponsibilityTypeRequest countEmployee() {
    return countEmployee("employeeCount");
  }

  public ResponsibilityTypeRequest countEmployee(String retName) {
    return countEmployee(retName, EmployeeRequest.newInstance());
  }

  public ResponsibilityTypeRequest countEmployee(EmployeeRequest employee) {
    return countEmployee("employeeCount", employee);
  }

  public ResponsibilityTypeRequest countEmployee(String retName, EmployeeRequest employee) {
    employee.count();
    return statsFromEmployee(retName, employee);
  }

  public ResponsibilityTypeRequest statsFromEmployee(String retName, EmployeeRequest employee) {
    return addDynamicProperty(retName, employee, Employee.RESPONSIBLE_FOR_PROPERTY);
  }

  public ResponsibilityTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ResponsibilityTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ResponsibilityTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ResponsibilityTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
