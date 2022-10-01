package com.doublechaintech.retailscm.salarygrade;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.salarygrade.SalaryGrade.*;

public class SalaryGradeRequest extends BaseRequest<SalaryGrade> {
  public static SalaryGradeRequest newInstance() {
    return new SalaryGradeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SalaryGradeRequest resultByClass(Class<? extends SalaryGrade> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SalaryGradeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SalaryGradeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SalaryGrade";
  }

  public SalaryGradeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SalaryGradeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SalaryGradeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SalaryGradeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SalaryGradeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectName()
        .selectDetailDescription()
        .selectVersion();
  }

  public SalaryGradeRequest selectAny() {
    return selectAll()
        .selectEmployeeList(Q.employee().selectSelf())
        .selectEmployeeSalarySheetList(Q.employeeSalarySheet().selectSelf());
  }

  public SalaryGradeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(NAME_PROPERTY);
    select(DETAIL_DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SalaryGradeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SalaryGradeRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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
    NAME_PROPERTY,
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

  public SalaryGradeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SalaryGradeRequest comment(String comment) {
    return this;
  }

  public SalaryGradeRequest enhance() {
    return this;
  }

  public SalaryGradeRequest overrideClass(Class<? extends SalaryGrade> clazz) {
    return this;
  }

  public SalaryGradeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SalaryGradeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SalaryGradeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SalaryGradeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SalaryGradeRequest count() {
    return countId("count");
  }

  public static SalaryGradeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SalaryGradeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SalaryGradeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SalaryGradeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SalaryGradeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SalaryGradeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SalaryGradeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SalaryGradeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SalaryGradeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SalaryGradeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SalaryGradeRequest countId() {
    return countId("countId");
  }

  public SalaryGradeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SalaryGradeRequest maxId() {
    return maxId("maxId");
  }

  public SalaryGradeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SalaryGradeRequest minId() {
    return minId("minId");
  }

  public SalaryGradeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SalaryGradeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SalaryGradeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SalaryGradeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SalaryGradeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SalaryGradeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public SalaryGradeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SalaryGradeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SalaryGradeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SalaryGradeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public SalaryGradeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SalaryGradeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SalaryGradeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public SalaryGradeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public SalaryGradeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public SalaryGradeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public SalaryGradeRequest countCode() {
    return countCode("countCode");
  }

  public SalaryGradeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public SalaryGradeRequest maxCode() {
    return maxCode("maxCode");
  }

  public SalaryGradeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public SalaryGradeRequest minCode() {
    return minCode("minCode");
  }

  public SalaryGradeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public SalaryGradeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public SalaryGradeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public SalaryGradeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public SalaryGradeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public SalaryGradeRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public SalaryGradeRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SalaryGradeRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SalaryGradeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SalaryGradeRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public SalaryGradeRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SalaryGradeRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SalaryGradeRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public SalaryGradeRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public SalaryGradeRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public SalaryGradeRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public SalaryGradeRequest countName() {
    return countName("countName");
  }

  public SalaryGradeRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public SalaryGradeRequest maxName() {
    return maxName("maxName");
  }

  public SalaryGradeRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public SalaryGradeRequest minName() {
    return minName("minName");
  }

  public SalaryGradeRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public SalaryGradeRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public SalaryGradeRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public SalaryGradeRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public SalaryGradeRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public SalaryGradeRequest filterByDetailDescription(String detailDescription) {

    if (detailDescription == null) {
      return this;
    }

    return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
  }

  public SalaryGradeRequest whereDetailDescriptionIsNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SalaryGradeRequest whereDetailDescriptionIsNotNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SalaryGradeRequest filterByDetailDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SalaryGradeRequest selectDetailDescription() {
    return select(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SalaryGradeRequest unselectDetailDescription() {
    return unselect(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDetailDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SalaryGradeRequest orderByDetailDescription(boolean asc) {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SalaryGradeRequest orderByDetailDescriptionAscending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public SalaryGradeRequest orderByDetailDescriptionDescending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public SalaryGradeRequest orderByDetailDescriptionAscendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", true);
    return this;
  }

  public SalaryGradeRequest orderByDetailDescriptionDescendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", false);
    return this;
  }

  public SalaryGradeRequest countDetailDescription() {
    return countDetailDescription("countDetailDescription");
  }

  public SalaryGradeRequest countDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DETAIL_DESCRIPTION_PROPERTY);
  }

  public SalaryGradeRequest maxDetailDescription() {
    return maxDetailDescription("maxDetailDescription");
  }

  public SalaryGradeRequest maxDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DETAIL_DESCRIPTION_PROPERTY);
  }

  public SalaryGradeRequest minDetailDescription() {
    return minDetailDescription("minDetailDescription");
  }

  public SalaryGradeRequest minDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DETAIL_DESCRIPTION_PROPERTY);
  }

  public SalaryGradeRequest groupByDetailDescription() {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SalaryGradeRequest groupByDetailDescription(String ret) {
    return groupBy(ret, DETAIL_DESCRIPTION_PROPERTY);
  }

  public SalaryGradeRequest groupByDetailDescription(SqlFunction func) {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY, func);
  }

  public SalaryGradeRequest groupByDetailDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public SalaryGradeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SalaryGradeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SalaryGradeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SalaryGradeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SalaryGradeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SalaryGradeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SalaryGradeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SalaryGradeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SalaryGradeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SalaryGradeRequest countVersion() {
    return countVersion("countVersion");
  }

  public SalaryGradeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SalaryGradeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SalaryGradeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SalaryGradeRequest minVersion() {
    return minVersion("minVersion");
  }

  public SalaryGradeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SalaryGradeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SalaryGradeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SalaryGradeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SalaryGradeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SalaryGradeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SalaryGradeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SalaryGradeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public SalaryGradeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public SalaryGradeRequest selectCompanyId() {
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

  public SalaryGradeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public SalaryGradeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public SalaryGradeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public SalaryGradeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public SalaryGradeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public SalaryGradeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public SalaryGradeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public SalaryGradeRequest countCompany() {
    return countCompany("countCompany");
  }

  public SalaryGradeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public SalaryGradeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public SalaryGradeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public SalaryGradeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public SalaryGradeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SalaryGradeRequest hasEmployee() {
    return hasEmployee(EmployeeRequest.newInstance());
  }

  public SalaryGradeRequest hasEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("hasEmployee(Employee... employee)参数不能为空!");
    }
    return hasEmployee(
        Q.employee()
            .select(Employee.CURRENT_SALARY_GRADE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employee));
  }

  public SalaryGradeRequest hasEmployee(String... employee) {
    return hasEmployee(
        Q.employee().select(Employee.CURRENT_SALARY_GRADE_PROPERTY).filterById(employee));
  }

  public SalaryGradeRequest hasEmployee(EmployeeRequest employee) {
    return hasEmployee(
        employee,
        $employee ->
            java.util.Optional.of($employee)
                .map(Employee::getCurrentSalaryGrade)
                .map(SalaryGrade::getId)
                .orElse(null));
  }

  public SalaryGradeRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.select(Employee.CURRENT_SALARY_GRADE_PROPERTY);
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SalaryGradeRequest hasEmployee(
      EmployeeRequest employee, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employee, Employee.CURRENT_SALARY_GRADE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(
        employee, ID_PROPERTY, idRefine, Employee.CURRENT_SALARY_GRADE_PROPERTY);
  }

  public SalaryGradeRequest selectEmployeeList(EmployeeRequest employee) {
    selectChild(Employee.CURRENT_SALARY_GRADE_PROPERTY, employee);
    return this;
  }

  public SalaryGradeRequest selectEmployeeList() {
    return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
  }

  public SalaryGradeRequest unselectEmployeeList() {
    unselectChild(Employee.CURRENT_SALARY_GRADE_PROPERTY, Employee.class);
    return this;
  }

  public SalaryGradeRequest hasEmployeeSalarySheet() {
    return hasEmployeeSalarySheet(EmployeeSalarySheetRequest.newInstance());
  }

  public SalaryGradeRequest hasEmployeeSalarySheet(EmployeeSalarySheet... employeeSalarySheet) {
    if (isEmptyParam(employeeSalarySheet)) {
      throw new IllegalArgumentException(
          "hasEmployeeSalarySheet(EmployeeSalarySheet... employeeSalarySheet)参数不能为空!");
    }
    return hasEmployeeSalarySheet(
        Q.employeeSalarySheet()
            .select(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeSalarySheet));
  }

  public SalaryGradeRequest hasEmployeeSalarySheet(String... employeeSalarySheet) {
    return hasEmployeeSalarySheet(
        Q.employeeSalarySheet()
            .select(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY)
            .filterById(employeeSalarySheet));
  }

  public SalaryGradeRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
    return hasEmployeeSalarySheet(
        employeeSalarySheet,
        $employeeSalarySheet ->
            java.util.Optional.of($employeeSalarySheet)
                .map(EmployeeSalarySheet::getCurrentSalaryGrade)
                .map(SalaryGrade::getId)
                .orElse(null));
  }

  public SalaryGradeRequest hasEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
    employeeSalarySheet.select(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY);
    employeeSalarySheet.unlimited();
    return addSearchCriteria(createEmployeeSalarySheetCriteria(employeeSalarySheet, idRefine));
  }

  public SalaryGradeRequest hasEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeSalarySheet,
            EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createEmployeeSalarySheetCriteria(
      EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
    return new RefinedIdInCriteria(
        employeeSalarySheet,
        ID_PROPERTY,
        idRefine,
        EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY);
  }

  public SalaryGradeRequest selectEmployeeSalarySheetList(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    selectChild(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, employeeSalarySheet);
    return this;
  }

  public SalaryGradeRequest selectEmployeeSalarySheetList() {
    return selectEmployeeSalarySheetList(EmployeeSalarySheetRequest.newInstance().selectAll());
  }

  public SalaryGradeRequest unselectEmployeeSalarySheetList() {
    unselectChild(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, EmployeeSalarySheet.class);
    return this;
  }

  public SalaryGradeRequest aggregateEmployeeList(EmployeeRequest employee) {
    aggregateChild(Employee.CURRENT_SALARY_GRADE_PROPERTY, employee);
    return this;
  }

  public SalaryGradeRequest countEmployee() {
    return countEmployee("employeeCount");
  }

  public SalaryGradeRequest countEmployee(String retName) {
    return countEmployee(retName, EmployeeRequest.newInstance());
  }

  public SalaryGradeRequest countEmployee(EmployeeRequest employee) {
    return countEmployee("employeeCount", employee);
  }

  public SalaryGradeRequest countEmployee(String retName, EmployeeRequest employee) {
    employee.count();
    return statsFromEmployee(retName, employee);
  }

  public SalaryGradeRequest statsFromEmployee(String retName, EmployeeRequest employee) {
    return addDynamicProperty(retName, employee, Employee.CURRENT_SALARY_GRADE_PROPERTY);
  }

  public SalaryGradeRequest aggregateEmployeeSalarySheetList(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    aggregateChild(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, employeeSalarySheet);
    return this;
  }

  public SalaryGradeRequest countEmployeeSalarySheet() {
    return countEmployeeSalarySheet("employeeSalarySheetCount");
  }

  public SalaryGradeRequest countEmployeeSalarySheet(String retName) {
    return countEmployeeSalarySheet(retName, EmployeeSalarySheetRequest.newInstance());
  }

  public SalaryGradeRequest countEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    return countEmployeeSalarySheet("employeeSalarySheetCount", employeeSalarySheet);
  }

  public SalaryGradeRequest countEmployeeSalarySheet(
      String retName, EmployeeSalarySheetRequest employeeSalarySheet) {
    employeeSalarySheet.count();
    return statsFromEmployeeSalarySheet(retName, employeeSalarySheet);
  }

  public SalaryGradeRequest statsFromEmployeeSalarySheet(
      String retName, EmployeeSalarySheetRequest employeeSalarySheet) {
    return addDynamicProperty(
        retName, employeeSalarySheet, EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY);
  }

  public SalaryGradeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SalaryGradeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SalaryGradeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SalaryGradeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
