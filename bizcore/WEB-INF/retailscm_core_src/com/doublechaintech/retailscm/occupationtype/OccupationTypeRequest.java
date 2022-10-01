package com.doublechaintech.retailscm.occupationtype;

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
import static com.doublechaintech.retailscm.occupationtype.OccupationType.*;

public class OccupationTypeRequest extends BaseRequest<OccupationType> {
  public static OccupationTypeRequest newInstance() {
    return new OccupationTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public OccupationTypeRequest resultByClass(Class<? extends OccupationType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public OccupationTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public OccupationTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "OccupationType";
  }

  public OccupationTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public OccupationTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public OccupationTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public OccupationTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public OccupationTypeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectDescription()
        .selectDetailDescription()
        .selectVersion();
  }

  public OccupationTypeRequest selectAny() {
    return selectAll().selectEmployeeList(Q.employee().selectSelf());
  }

  public OccupationTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(DETAIL_DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public OccupationTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public OccupationTypeRequest where(
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
    DESCRIPTION_PROPERTY,
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

  public OccupationTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public OccupationTypeRequest comment(String comment) {
    return this;
  }

  public OccupationTypeRequest enhance() {
    return this;
  }

  public OccupationTypeRequest overrideClass(Class<? extends OccupationType> clazz) {
    return this;
  }

  public OccupationTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public OccupationTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public OccupationTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public OccupationTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public OccupationTypeRequest count() {
    return countId("count");
  }

  public static OccupationTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public OccupationTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public OccupationTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OccupationTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public OccupationTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OccupationTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public OccupationTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public OccupationTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public OccupationTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public OccupationTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public OccupationTypeRequest countId() {
    return countId("countId");
  }

  public OccupationTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public OccupationTypeRequest maxId() {
    return maxId("maxId");
  }

  public OccupationTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public OccupationTypeRequest minId() {
    return minId("minId");
  }

  public OccupationTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public OccupationTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public OccupationTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public OccupationTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public OccupationTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public OccupationTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public OccupationTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public OccupationTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OccupationTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OccupationTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public OccupationTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OccupationTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public OccupationTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public OccupationTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public OccupationTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public OccupationTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public OccupationTypeRequest countCode() {
    return countCode("countCode");
  }

  public OccupationTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public OccupationTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public OccupationTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public OccupationTypeRequest minCode() {
    return minCode("minCode");
  }

  public OccupationTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public OccupationTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public OccupationTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public OccupationTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public OccupationTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public OccupationTypeRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public OccupationTypeRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public OccupationTypeRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OccupationTypeRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OccupationTypeRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OccupationTypeRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public OccupationTypeRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public OccupationTypeRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public OccupationTypeRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public OccupationTypeRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public OccupationTypeRequest countDescription() {
    return countDescription("countDescription");
  }

  public OccupationTypeRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public OccupationTypeRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest minDescription() {
    return minDescription("minDescription");
  }

  public OccupationTypeRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public OccupationTypeRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public OccupationTypeRequest filterByDetailDescription(String detailDescription) {

    if (detailDescription == null) {
      return this;
    }

    return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
  }

  public OccupationTypeRequest whereDetailDescriptionIsNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public OccupationTypeRequest whereDetailDescriptionIsNotNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OccupationTypeRequest filterByDetailDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OccupationTypeRequest selectDetailDescription() {
    return select(DETAIL_DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest unselectDetailDescription() {
    return unselect(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDetailDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OccupationTypeRequest orderByDetailDescription(boolean asc) {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public OccupationTypeRequest orderByDetailDescriptionAscending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public OccupationTypeRequest orderByDetailDescriptionDescending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public OccupationTypeRequest orderByDetailDescriptionAscendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", true);
    return this;
  }

  public OccupationTypeRequest orderByDetailDescriptionDescendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", false);
    return this;
  }

  public OccupationTypeRequest countDetailDescription() {
    return countDetailDescription("countDetailDescription");
  }

  public OccupationTypeRequest countDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DETAIL_DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest maxDetailDescription() {
    return maxDetailDescription("maxDetailDescription");
  }

  public OccupationTypeRequest maxDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DETAIL_DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest minDetailDescription() {
    return minDetailDescription("minDetailDescription");
  }

  public OccupationTypeRequest minDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DETAIL_DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest groupByDetailDescription() {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest groupByDetailDescription(String ret) {
    return groupBy(ret, DETAIL_DESCRIPTION_PROPERTY);
  }

  public OccupationTypeRequest groupByDetailDescription(SqlFunction func) {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY, func);
  }

  public OccupationTypeRequest groupByDetailDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public OccupationTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public OccupationTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public OccupationTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OccupationTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OccupationTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public OccupationTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OccupationTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public OccupationTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public OccupationTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public OccupationTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public OccupationTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public OccupationTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public OccupationTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public OccupationTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public OccupationTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public OccupationTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public OccupationTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public OccupationTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public OccupationTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public OccupationTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public OccupationTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public OccupationTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public OccupationTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public OccupationTypeRequest selectCompanyId() {
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

  public OccupationTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public OccupationTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public OccupationTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public OccupationTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public OccupationTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public OccupationTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public OccupationTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public OccupationTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public OccupationTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public OccupationTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public OccupationTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public OccupationTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public OccupationTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OccupationTypeRequest hasEmployee() {
    return hasEmployee(EmployeeRequest.newInstance());
  }

  public OccupationTypeRequest hasEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("hasEmployee(Employee... employee)参数不能为空!");
    }
    return hasEmployee(
        Q.employee()
            .select(Employee.OCCUPATION_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employee));
  }

  public OccupationTypeRequest hasEmployee(String... employee) {
    return hasEmployee(Q.employee().select(Employee.OCCUPATION_PROPERTY).filterById(employee));
  }

  public OccupationTypeRequest hasEmployee(EmployeeRequest employee) {
    return hasEmployee(
        employee,
        $employee ->
            java.util.Optional.of($employee)
                .map(Employee::getOccupation)
                .map(OccupationType::getId)
                .orElse(null));
  }

  public OccupationTypeRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.select(Employee.OCCUPATION_PROPERTY);
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public OccupationTypeRequest hasEmployee(
      EmployeeRequest employee, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(employee, Employee.OCCUPATION_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine, Employee.OCCUPATION_PROPERTY);
  }

  public OccupationTypeRequest selectEmployeeList(EmployeeRequest employee) {
    selectChild(Employee.OCCUPATION_PROPERTY, employee);
    return this;
  }

  public OccupationTypeRequest selectEmployeeList() {
    return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
  }

  public OccupationTypeRequest unselectEmployeeList() {
    unselectChild(Employee.OCCUPATION_PROPERTY, Employee.class);
    return this;
  }

  public OccupationTypeRequest aggregateEmployeeList(EmployeeRequest employee) {
    aggregateChild(Employee.OCCUPATION_PROPERTY, employee);
    return this;
  }

  public OccupationTypeRequest countEmployee() {
    return countEmployee("employeeCount");
  }

  public OccupationTypeRequest countEmployee(String retName) {
    return countEmployee(retName, EmployeeRequest.newInstance());
  }

  public OccupationTypeRequest countEmployee(EmployeeRequest employee) {
    return countEmployee("employeeCount", employee);
  }

  public OccupationTypeRequest countEmployee(String retName, EmployeeRequest employee) {
    employee.count();
    return statsFromEmployee(retName, employee);
  }

  public OccupationTypeRequest statsFromEmployee(String retName, EmployeeRequest employee) {
    return addDynamicProperty(retName, employee, Employee.OCCUPATION_PROPERTY);
  }

  public OccupationTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public OccupationTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public OccupationTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public OccupationTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
