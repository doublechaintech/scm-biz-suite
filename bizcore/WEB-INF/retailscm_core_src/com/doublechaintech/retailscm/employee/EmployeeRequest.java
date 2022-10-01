package com.doublechaintech.retailscm.employee;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest;
import com.doublechaintech.retailscm.payingoff.PayingOffRequest;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employee.Employee.*;

public class EmployeeRequest extends BaseRequest<Employee> {
  public static EmployeeRequest newInstance() {
    return new EmployeeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeRequest resultByClass(Class<? extends Employee> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Employee";
  }

  public EmployeeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeRequest selectAll() {
    return this.selectId()
        .selectCompany()
        .selectTitle()
        .selectDepartment()
        .selectFamilyName()
        .selectGivenName()
        .selectEmail()
        .selectCity()
        .selectAddress()
        .selectCellPhone()
        .selectOccupation()
        .selectResponsibleFor()
        .selectCurrentSalaryGrade()
        .selectSalaryAccount()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public EmployeeRequest selectAny() {
    return selectAll()
        .selectEmployeeCompanyTrainingList(Q.employeeCompanyTraining().selectSelf())
        .selectEmployeeSkillList(Q.employeeSkill().selectSelf())
        .selectEmployeePerformanceList(Q.employeePerformance().selectSelf())
        .selectEmployeeWorkExperienceList(Q.employeeWorkExperience().selectSelf())
        .selectEmployeeLeaveList(Q.employeeLeave().selectSelf())
        .selectEmployeeInterviewList(Q.employeeInterview().selectSelf())
        .selectEmployeeAttendanceList(Q.employeeAttendance().selectSelf())
        .selectEmployeeQualifierList(Q.employeeQualifier().selectSelf())
        .selectEmployeeEducationList(Q.employeeEducation().selectSelf())
        .selectEmployeeAwardList(Q.employeeAward().selectSelf())
        .selectEmployeeSalarySheetList(Q.employeeSalarySheet().selectSelf())
        .selectPayingOffList(Q.payingOff().selectSelf());
  }

  public EmployeeRequest selectSelf() {
    select(ID_PROPERTY);
    select(COMPANY_PROPERTY);
    select(TITLE_PROPERTY);
    select(DEPARTMENT_PROPERTY);
    select(FAMILY_NAME_PROPERTY);
    select(GIVEN_NAME_PROPERTY);
    select(EMAIL_PROPERTY);
    select(CITY_PROPERTY);
    select(ADDRESS_PROPERTY);
    select(CELL_PHONE_PROPERTY);
    select(OCCUPATION_PROPERTY);
    select(RESPONSIBLE_FOR_PROPERTY);
    select(CURRENT_SALARY_GRADE_PROPERTY);
    select(SALARY_ACCOUNT_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    COMPANY_PROPERTY,
    TITLE_PROPERTY,
    DEPARTMENT_PROPERTY,
    FAMILY_NAME_PROPERTY,
    GIVEN_NAME_PROPERTY,
    EMAIL_PROPERTY,
    CITY_PROPERTY,
    ADDRESS_PROPERTY,
    CELL_PHONE_PROPERTY,
    OCCUPATION_PROPERTY,
    RESPONSIBLE_FOR_PROPERTY,
    CURRENT_SALARY_GRADE_PROPERTY,
    SALARY_ACCOUNT_PROPERTY,
    LAST_UPDATE_TIME_PROPERTY,
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

  public EmployeeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeRequest comment(String comment) {
    return this;
  }

  public EmployeeRequest enhance() {
    return this;
  }

  public EmployeeRequest overrideClass(Class<? extends Employee> clazz) {
    return this;
  }

  public EmployeeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeRequest count() {
    return countId("count");
  }

  public static EmployeeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeRequest countId() {
    return countId("countId");
  }

  public EmployeeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeRequest minId() {
    return minId("minId");
  }

  public EmployeeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public EmployeeRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public EmployeeRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public EmployeeRequest countTitle() {
    return countTitle("countTitle");
  }

  public EmployeeRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public EmployeeRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public EmployeeRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public EmployeeRequest minTitle() {
    return minTitle("minTitle");
  }

  public EmployeeRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public EmployeeRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public EmployeeRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public EmployeeRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public EmployeeRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByFamilyName(String familyName) {

    if (familyName == null) {
      return this;
    }

    return filterByFamilyName(QueryOperator.EQUAL, familyName);
  }

  public EmployeeRequest whereFamilyNameIsNull() {
    return where(FAMILY_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereFamilyNameIsNotNull() {
    return where(FAMILY_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByFamilyName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFamilyNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectFamilyName() {
    return select(FAMILY_NAME_PROPERTY);
  }

  public EmployeeRequest unselectFamilyName() {
    return unselect(FAMILY_NAME_PROPERTY);
  }

  public SearchCriteria getFamilyNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FAMILY_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByFamilyName(boolean asc) {
    addOrderBy(FAMILY_NAME_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByFamilyNameAscending() {
    addOrderBy(FAMILY_NAME_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByFamilyNameDescending() {
    addOrderBy(FAMILY_NAME_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByFamilyNameAscendingUsingGBK() {
    addOrderBy("convert(familyName using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByFamilyNameDescendingUsingGBK() {
    addOrderBy("convert(familyName using gbk)", false);
    return this;
  }

  public EmployeeRequest countFamilyName() {
    return countFamilyName("countFamilyName");
  }

  public EmployeeRequest countFamilyName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FAMILY_NAME_PROPERTY);
  }

  public EmployeeRequest maxFamilyName() {
    return maxFamilyName("maxFamilyName");
  }

  public EmployeeRequest maxFamilyName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FAMILY_NAME_PROPERTY);
  }

  public EmployeeRequest minFamilyName() {
    return minFamilyName("minFamilyName");
  }

  public EmployeeRequest minFamilyName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FAMILY_NAME_PROPERTY);
  }

  public EmployeeRequest groupByFamilyName() {
    return groupByFamilyName(FAMILY_NAME_PROPERTY);
  }

  public EmployeeRequest groupByFamilyName(String ret) {
    return groupBy(ret, FAMILY_NAME_PROPERTY);
  }

  public EmployeeRequest groupByFamilyName(SqlFunction func) {
    return groupByFamilyName(FAMILY_NAME_PROPERTY, func);
  }

  public EmployeeRequest groupByFamilyName(String ret, SqlFunction func) {
    super.groupBy(ret, func, FAMILY_NAME_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByGivenName(String givenName) {

    if (givenName == null) {
      return this;
    }

    return filterByGivenName(QueryOperator.EQUAL, givenName);
  }

  public EmployeeRequest whereGivenNameIsNull() {
    return where(GIVEN_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereGivenNameIsNotNull() {
    return where(GIVEN_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByGivenName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getGivenNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectGivenName() {
    return select(GIVEN_NAME_PROPERTY);
  }

  public EmployeeRequest unselectGivenName() {
    return unselect(GIVEN_NAME_PROPERTY);
  }

  public SearchCriteria getGivenNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(GIVEN_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByGivenName(boolean asc) {
    addOrderBy(GIVEN_NAME_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByGivenNameAscending() {
    addOrderBy(GIVEN_NAME_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByGivenNameDescending() {
    addOrderBy(GIVEN_NAME_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByGivenNameAscendingUsingGBK() {
    addOrderBy("convert(givenName using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByGivenNameDescendingUsingGBK() {
    addOrderBy("convert(givenName using gbk)", false);
    return this;
  }

  public EmployeeRequest countGivenName() {
    return countGivenName("countGivenName");
  }

  public EmployeeRequest countGivenName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, GIVEN_NAME_PROPERTY);
  }

  public EmployeeRequest maxGivenName() {
    return maxGivenName("maxGivenName");
  }

  public EmployeeRequest maxGivenName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, GIVEN_NAME_PROPERTY);
  }

  public EmployeeRequest minGivenName() {
    return minGivenName("minGivenName");
  }

  public EmployeeRequest minGivenName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, GIVEN_NAME_PROPERTY);
  }

  public EmployeeRequest groupByGivenName() {
    return groupByGivenName(GIVEN_NAME_PROPERTY);
  }

  public EmployeeRequest groupByGivenName(String ret) {
    return groupBy(ret, GIVEN_NAME_PROPERTY);
  }

  public EmployeeRequest groupByGivenName(SqlFunction func) {
    return groupByGivenName(GIVEN_NAME_PROPERTY, func);
  }

  public EmployeeRequest groupByGivenName(String ret, SqlFunction func) {
    super.groupBy(ret, func, GIVEN_NAME_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByEmail(String email) {

    if (email == null) {
      return this;
    }

    return filterByEmail(QueryOperator.EQUAL, email);
  }

  public EmployeeRequest whereEmailIsNull() {
    return where(EMAIL_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereEmailIsNotNull() {
    return where(EMAIL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectEmail() {
    return select(EMAIL_PROPERTY);
  }

  public EmployeeRequest unselectEmail() {
    return unselect(EMAIL_PROPERTY);
  }

  public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByEmail(boolean asc) {
    addOrderBy(EMAIL_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByEmailAscending() {
    addOrderBy(EMAIL_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByEmailDescending() {
    addOrderBy(EMAIL_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByEmailAscendingUsingGBK() {
    addOrderBy("convert(email using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByEmailDescendingUsingGBK() {
    addOrderBy("convert(email using gbk)", false);
    return this;
  }

  public EmployeeRequest countEmail() {
    return countEmail("countEmail");
  }

  public EmployeeRequest countEmail(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMAIL_PROPERTY);
  }

  public EmployeeRequest maxEmail() {
    return maxEmail("maxEmail");
  }

  public EmployeeRequest maxEmail(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EMAIL_PROPERTY);
  }

  public EmployeeRequest minEmail() {
    return minEmail("minEmail");
  }

  public EmployeeRequest minEmail(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EMAIL_PROPERTY);
  }

  public EmployeeRequest groupByEmail() {
    return groupByEmail(EMAIL_PROPERTY);
  }

  public EmployeeRequest groupByEmail(String ret) {
    return groupBy(ret, EMAIL_PROPERTY);
  }

  public EmployeeRequest groupByEmail(SqlFunction func) {
    return groupByEmail(EMAIL_PROPERTY, func);
  }

  public EmployeeRequest groupByEmail(String ret, SqlFunction func) {
    super.groupBy(ret, func, EMAIL_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByCity(String city) {

    if (city == null) {
      return this;
    }

    return filterByCity(QueryOperator.EQUAL, city);
  }

  public EmployeeRequest whereCityIsNull() {
    return where(CITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereCityIsNotNull() {
    return where(CITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByCity(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectCity() {
    return select(CITY_PROPERTY);
  }

  public EmployeeRequest unselectCity() {
    return unselect(CITY_PROPERTY);
  }

  public SearchCriteria getCitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByCity(boolean asc) {
    addOrderBy(CITY_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByCityAscending() {
    addOrderBy(CITY_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByCityDescending() {
    addOrderBy(CITY_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByCityAscendingUsingGBK() {
    addOrderBy("convert(city using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByCityDescendingUsingGBK() {
    addOrderBy("convert(city using gbk)", false);
    return this;
  }

  public EmployeeRequest countCity() {
    return countCity("countCity");
  }

  public EmployeeRequest countCity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_PROPERTY);
  }

  public EmployeeRequest maxCity() {
    return maxCity("maxCity");
  }

  public EmployeeRequest maxCity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CITY_PROPERTY);
  }

  public EmployeeRequest minCity() {
    return minCity("minCity");
  }

  public EmployeeRequest minCity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CITY_PROPERTY);
  }

  public EmployeeRequest groupByCity() {
    return groupByCity(CITY_PROPERTY);
  }

  public EmployeeRequest groupByCity(String ret) {
    return groupBy(ret, CITY_PROPERTY);
  }

  public EmployeeRequest groupByCity(SqlFunction func) {
    return groupByCity(CITY_PROPERTY, func);
  }

  public EmployeeRequest groupByCity(String ret, SqlFunction func) {
    super.groupBy(ret, func, CITY_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByAddress(String address) {

    if (address == null) {
      return this;
    }

    return filterByAddress(QueryOperator.EQUAL, address);
  }

  public EmployeeRequest whereAddressIsNull() {
    return where(ADDRESS_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereAddressIsNotNull() {
    return where(ADDRESS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByAddress(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectAddress() {
    return select(ADDRESS_PROPERTY);
  }

  public EmployeeRequest unselectAddress() {
    return unselect(ADDRESS_PROPERTY);
  }

  public SearchCriteria getAddressSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByAddress(boolean asc) {
    addOrderBy(ADDRESS_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByAddressAscending() {
    addOrderBy(ADDRESS_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByAddressDescending() {
    addOrderBy(ADDRESS_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByAddressAscendingUsingGBK() {
    addOrderBy("convert(address using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByAddressDescendingUsingGBK() {
    addOrderBy("convert(address using gbk)", false);
    return this;
  }

  public EmployeeRequest countAddress() {
    return countAddress("countAddress");
  }

  public EmployeeRequest countAddress(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ADDRESS_PROPERTY);
  }

  public EmployeeRequest maxAddress() {
    return maxAddress("maxAddress");
  }

  public EmployeeRequest maxAddress(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ADDRESS_PROPERTY);
  }

  public EmployeeRequest minAddress() {
    return minAddress("minAddress");
  }

  public EmployeeRequest minAddress(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ADDRESS_PROPERTY);
  }

  public EmployeeRequest groupByAddress() {
    return groupByAddress(ADDRESS_PROPERTY);
  }

  public EmployeeRequest groupByAddress(String ret) {
    return groupBy(ret, ADDRESS_PROPERTY);
  }

  public EmployeeRequest groupByAddress(SqlFunction func) {
    return groupByAddress(ADDRESS_PROPERTY, func);
  }

  public EmployeeRequest groupByAddress(String ret, SqlFunction func) {
    super.groupBy(ret, func, ADDRESS_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByCellPhone(String cellPhone) {

    if (cellPhone == null) {
      return this;
    }

    return filterByCellPhone(QueryOperator.EQUAL, cellPhone);
  }

  public EmployeeRequest whereCellPhoneIsNull() {
    return where(CELL_PHONE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereCellPhoneIsNotNull() {
    return where(CELL_PHONE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByCellPhone(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCellPhoneSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectCellPhone() {
    return select(CELL_PHONE_PROPERTY);
  }

  public EmployeeRequest unselectCellPhone() {
    return unselect(CELL_PHONE_PROPERTY);
  }

  public SearchCriteria getCellPhoneSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CELL_PHONE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByCellPhone(boolean asc) {
    addOrderBy(CELL_PHONE_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByCellPhoneAscending() {
    addOrderBy(CELL_PHONE_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByCellPhoneDescending() {
    addOrderBy(CELL_PHONE_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderByCellPhoneAscendingUsingGBK() {
    addOrderBy("convert(cellPhone using gbk)", true);
    return this;
  }

  public EmployeeRequest orderByCellPhoneDescendingUsingGBK() {
    addOrderBy("convert(cellPhone using gbk)", false);
    return this;
  }

  public EmployeeRequest countCellPhone() {
    return countCellPhone("countCellPhone");
  }

  public EmployeeRequest countCellPhone(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CELL_PHONE_PROPERTY);
  }

  public EmployeeRequest maxCellPhone() {
    return maxCellPhone("maxCellPhone");
  }

  public EmployeeRequest maxCellPhone(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CELL_PHONE_PROPERTY);
  }

  public EmployeeRequest minCellPhone() {
    return minCellPhone("minCellPhone");
  }

  public EmployeeRequest minCellPhone(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CELL_PHONE_PROPERTY);
  }

  public EmployeeRequest groupByCellPhone() {
    return groupByCellPhone(CELL_PHONE_PROPERTY);
  }

  public EmployeeRequest groupByCellPhone(String ret) {
    return groupBy(ret, CELL_PHONE_PROPERTY);
  }

  public EmployeeRequest groupByCellPhone(SqlFunction func) {
    return groupByCellPhone(CELL_PHONE_PROPERTY, func);
  }

  public EmployeeRequest groupByCellPhone(String ret, SqlFunction func) {
    super.groupBy(ret, func, CELL_PHONE_PROPERTY);
    return this;
  }

  public EmployeeRequest filterBySalaryAccount(String salaryAccount) {

    if (salaryAccount == null) {
      return this;
    }

    return filterBySalaryAccount(QueryOperator.EQUAL, salaryAccount);
  }

  public EmployeeRequest whereSalaryAccountIsNull() {
    return where(SALARY_ACCOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereSalaryAccountIsNotNull() {
    return where(SALARY_ACCOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterBySalaryAccount(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSalaryAccountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectSalaryAccount() {
    return select(SALARY_ACCOUNT_PROPERTY);
  }

  public EmployeeRequest unselectSalaryAccount() {
    return unselect(SALARY_ACCOUNT_PROPERTY);
  }

  public SearchCriteria getSalaryAccountSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SALARY_ACCOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderBySalaryAccount(boolean asc) {
    addOrderBy(SALARY_ACCOUNT_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderBySalaryAccountAscending() {
    addOrderBy(SALARY_ACCOUNT_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderBySalaryAccountDescending() {
    addOrderBy(SALARY_ACCOUNT_PROPERTY, false);
    return this;
  }

  public EmployeeRequest orderBySalaryAccountAscendingUsingGBK() {
    addOrderBy("convert(salaryAccount using gbk)", true);
    return this;
  }

  public EmployeeRequest orderBySalaryAccountDescendingUsingGBK() {
    addOrderBy("convert(salaryAccount using gbk)", false);
    return this;
  }

  public EmployeeRequest countSalaryAccount() {
    return countSalaryAccount("countSalaryAccount");
  }

  public EmployeeRequest countSalaryAccount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SALARY_ACCOUNT_PROPERTY);
  }

  public EmployeeRequest maxSalaryAccount() {
    return maxSalaryAccount("maxSalaryAccount");
  }

  public EmployeeRequest maxSalaryAccount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SALARY_ACCOUNT_PROPERTY);
  }

  public EmployeeRequest minSalaryAccount() {
    return minSalaryAccount("minSalaryAccount");
  }

  public EmployeeRequest minSalaryAccount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SALARY_ACCOUNT_PROPERTY);
  }

  public EmployeeRequest groupBySalaryAccount() {
    return groupBySalaryAccount(SALARY_ACCOUNT_PROPERTY);
  }

  public EmployeeRequest groupBySalaryAccount(String ret) {
    return groupBy(ret, SALARY_ACCOUNT_PROPERTY);
  }

  public EmployeeRequest groupBySalaryAccount(SqlFunction func) {
    return groupBySalaryAccount(SALARY_ACCOUNT_PROPERTY, func);
  }

  public EmployeeRequest groupBySalaryAccount(String ret, SqlFunction func) {
    super.groupBy(ret, func, SALARY_ACCOUNT_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public EmployeeRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public EmployeeRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public EmployeeRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public EmployeeRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public EmployeeRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public EmployeeRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public EmployeeRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public EmployeeRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public EmployeeRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public EmployeeRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public EmployeeRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public EmployeeRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public EmployeeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public EmployeeRequest selectCompanyId() {
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

  public EmployeeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public EmployeeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public EmployeeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public EmployeeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public EmployeeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public EmployeeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public EmployeeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public EmployeeRequest countCompany() {
    return countCompany("countCompany");
  }

  public EmployeeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public EmployeeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public EmployeeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public EmployeeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByDepartment(LevelThreeDepartmentRequest department) {
    return filterByDepartment(department, LevelThreeDepartment::getId);
  }

  public EmployeeRequest filterByDepartment(LevelThreeDepartment... department) {
    if (isEmptyParam(department)) {
      throw new IllegalArgumentException(
          "filterByDepartment(LevelThreeDepartment... department)参数不能为空!");
    }
    return where(DEPARTMENT_PROPERTY, QueryOperator.IN, (Object[]) department);
  }

  public EmployeeRequest selectDepartmentId() {
    select(DEPARTMENT_PROPERTY);
    return this;
  }

  public LevelThreeDepartmentRequest upToDepartment() {
    return upToDepartment(LevelThreeDepartmentRequest.newInstance());
  }

  public LevelThreeDepartmentRequest upToDepartment(LevelThreeDepartmentRequest department) {
    department.aggregateChild(DEPARTMENT_PROPERTY, this);
    this.groupByDepartment(department);
    return department;
  }

  public LevelThreeDepartmentRequest endAtDepartment(String retName) {
    return endAtDepartment(retName, LevelThreeDepartmentRequest.newInstance());
  }

  public LevelThreeDepartmentRequest endAtDepartment(
      String retName, LevelThreeDepartmentRequest department) {
    department.addDynamicProperty(retName, this, DEPARTMENT_PROPERTY);
    return department;
  }

  public EmployeeRequest filterByDepartment(String... department) {
    if (isEmptyParam(department)) {
      throw new IllegalArgumentException("filterByDepartment(String... department)参数不能为空!");
    }
    return where(DEPARTMENT_PROPERTY, QueryOperator.IN, (Object[]) department);
  }

  public EmployeeRequest filterByDepartment(
      LevelThreeDepartmentRequest department, IDRefine<LevelThreeDepartment> idRefine) {
    department.unlimited();
    return addSearchCriteria(createDepartmentCriteria(department, idRefine));
  }

  public SearchCriteria createDepartmentCriteria(
      LevelThreeDepartmentRequest department, IDRefine<LevelThreeDepartment> idRefine) {
    return new RefinedIdInCriteria(
        department, DEPARTMENT_PROPERTY, idRefine, LevelThreeDepartment.ID_PROPERTY);
  }

  public EmployeeRequest selectDepartment() {
    return selectDepartment(LevelThreeDepartmentRequest.newInstance().selectSelf());
  }

  public EmployeeRequest selectDepartment(LevelThreeDepartmentRequest department) {
    selectParent(DEPARTMENT_PROPERTY, department);
    return this;
  }

  public EmployeeRequest unselectDepartment() {
    unselectParent(DEPARTMENT_PROPERTY);
    return this;
  }

  public EmployeeRequest groupByDepartment(LevelThreeDepartmentRequest department) {
    groupBy(DEPARTMENT_PROPERTY, department);
    return this;
  }

  public EmployeeRequest aggregateDepartment(LevelThreeDepartmentRequest department) {
    aggregateParent(DEPARTMENT_PROPERTY, department);
    return this;
  }

  public EmployeeRequest countDepartment() {
    return countDepartment("countDepartment");
  }

  public EmployeeRequest countDepartment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DEPARTMENT_PROPERTY);
  }

  public EmployeeRequest groupByDepartment() {
    return groupByDepartment(DEPARTMENT_PROPERTY);
  }

  public EmployeeRequest groupByDepartment(String ret) {
    return groupBy(ret, DEPARTMENT_PROPERTY);
  }

  public EmployeeRequest whereDepartmentIsNull() {
    return where(DEPARTMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereDepartmentIsNotNull() {
    return where(DEPARTMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByOccupation(OccupationTypeRequest occupation) {
    return filterByOccupation(occupation, OccupationType::getId);
  }

  public EmployeeRequest filterByOccupation(OccupationType... occupation) {
    if (isEmptyParam(occupation)) {
      throw new IllegalArgumentException("filterByOccupation(OccupationType... occupation)参数不能为空!");
    }
    return where(OCCUPATION_PROPERTY, QueryOperator.IN, (Object[]) occupation);
  }

  public EmployeeRequest selectOccupationId() {
    select(OCCUPATION_PROPERTY);
    return this;
  }

  public OccupationTypeRequest upToOccupation() {
    return upToOccupation(OccupationTypeRequest.newInstance());
  }

  public OccupationTypeRequest upToOccupation(OccupationTypeRequest occupation) {
    occupation.aggregateChild(OCCUPATION_PROPERTY, this);
    this.groupByOccupation(occupation);
    return occupation;
  }

  public OccupationTypeRequest endAtOccupation(String retName) {
    return endAtOccupation(retName, OccupationTypeRequest.newInstance());
  }

  public OccupationTypeRequest endAtOccupation(String retName, OccupationTypeRequest occupation) {
    occupation.addDynamicProperty(retName, this, OCCUPATION_PROPERTY);
    return occupation;
  }

  public EmployeeRequest filterByOccupation(String... occupation) {
    if (isEmptyParam(occupation)) {
      throw new IllegalArgumentException("filterByOccupation(String... occupation)参数不能为空!");
    }
    return where(OCCUPATION_PROPERTY, QueryOperator.IN, (Object[]) occupation);
  }

  public EmployeeRequest filterByOccupation(
      OccupationTypeRequest occupation, IDRefine<OccupationType> idRefine) {
    occupation.unlimited();
    return addSearchCriteria(createOccupationCriteria(occupation, idRefine));
  }

  public SearchCriteria createOccupationCriteria(
      OccupationTypeRequest occupation, IDRefine<OccupationType> idRefine) {
    return new RefinedIdInCriteria(
        occupation, OCCUPATION_PROPERTY, idRefine, OccupationType.ID_PROPERTY);
  }

  public EmployeeRequest selectOccupation() {
    return selectOccupation(OccupationTypeRequest.newInstance().selectSelf());
  }

  public EmployeeRequest selectOccupation(OccupationTypeRequest occupation) {
    selectParent(OCCUPATION_PROPERTY, occupation);
    return this;
  }

  public EmployeeRequest unselectOccupation() {
    unselectParent(OCCUPATION_PROPERTY);
    return this;
  }

  public EmployeeRequest groupByOccupation(OccupationTypeRequest occupation) {
    groupBy(OCCUPATION_PROPERTY, occupation);
    return this;
  }

  public EmployeeRequest aggregateOccupation(OccupationTypeRequest occupation) {
    aggregateParent(OCCUPATION_PROPERTY, occupation);
    return this;
  }

  public EmployeeRequest countOccupation() {
    return countOccupation("countOccupation");
  }

  public EmployeeRequest countOccupation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OCCUPATION_PROPERTY);
  }

  public EmployeeRequest groupByOccupation() {
    return groupByOccupation(OCCUPATION_PROPERTY);
  }

  public EmployeeRequest groupByOccupation(String ret) {
    return groupBy(ret, OCCUPATION_PROPERTY);
  }

  public EmployeeRequest whereOccupationIsNull() {
    return where(OCCUPATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereOccupationIsNotNull() {
    return where(OCCUPATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByResponsibleFor(ResponsibilityTypeRequest responsibleFor) {
    return filterByResponsibleFor(responsibleFor, ResponsibilityType::getId);
  }

  public EmployeeRequest filterByResponsibleFor(ResponsibilityType... responsibleFor) {
    if (isEmptyParam(responsibleFor)) {
      throw new IllegalArgumentException(
          "filterByResponsibleFor(ResponsibilityType... responsibleFor)参数不能为空!");
    }
    return where(RESPONSIBLE_FOR_PROPERTY, QueryOperator.IN, (Object[]) responsibleFor);
  }

  public EmployeeRequest selectResponsibleForId() {
    select(RESPONSIBLE_FOR_PROPERTY);
    return this;
  }

  public ResponsibilityTypeRequest upToResponsibleFor() {
    return upToResponsibleFor(ResponsibilityTypeRequest.newInstance());
  }

  public ResponsibilityTypeRequest upToResponsibleFor(ResponsibilityTypeRequest responsibleFor) {
    responsibleFor.aggregateChild(RESPONSIBLE_FOR_PROPERTY, this);
    this.groupByResponsibleFor(responsibleFor);
    return responsibleFor;
  }

  public ResponsibilityTypeRequest endAtResponsibleFor(String retName) {
    return endAtResponsibleFor(retName, ResponsibilityTypeRequest.newInstance());
  }

  public ResponsibilityTypeRequest endAtResponsibleFor(
      String retName, ResponsibilityTypeRequest responsibleFor) {
    responsibleFor.addDynamicProperty(retName, this, RESPONSIBLE_FOR_PROPERTY);
    return responsibleFor;
  }

  public EmployeeRequest filterByResponsibleFor(String... responsibleFor) {
    if (isEmptyParam(responsibleFor)) {
      throw new IllegalArgumentException("filterByResponsibleFor(String... responsibleFor)参数不能为空!");
    }
    return where(RESPONSIBLE_FOR_PROPERTY, QueryOperator.IN, (Object[]) responsibleFor);
  }

  public EmployeeRequest filterByResponsibleFor(
      ResponsibilityTypeRequest responsibleFor, IDRefine<ResponsibilityType> idRefine) {
    responsibleFor.unlimited();
    return addSearchCriteria(createResponsibleForCriteria(responsibleFor, idRefine));
  }

  public SearchCriteria createResponsibleForCriteria(
      ResponsibilityTypeRequest responsibleFor, IDRefine<ResponsibilityType> idRefine) {
    return new RefinedIdInCriteria(
        responsibleFor, RESPONSIBLE_FOR_PROPERTY, idRefine, ResponsibilityType.ID_PROPERTY);
  }

  public EmployeeRequest selectResponsibleFor() {
    return selectResponsibleFor(ResponsibilityTypeRequest.newInstance().selectSelf());
  }

  public EmployeeRequest selectResponsibleFor(ResponsibilityTypeRequest responsibleFor) {
    selectParent(RESPONSIBLE_FOR_PROPERTY, responsibleFor);
    return this;
  }

  public EmployeeRequest unselectResponsibleFor() {
    unselectParent(RESPONSIBLE_FOR_PROPERTY);
    return this;
  }

  public EmployeeRequest groupByResponsibleFor(ResponsibilityTypeRequest responsibleFor) {
    groupBy(RESPONSIBLE_FOR_PROPERTY, responsibleFor);
    return this;
  }

  public EmployeeRequest aggregateResponsibleFor(ResponsibilityTypeRequest responsibleFor) {
    aggregateParent(RESPONSIBLE_FOR_PROPERTY, responsibleFor);
    return this;
  }

  public EmployeeRequest countResponsibleFor() {
    return countResponsibleFor("countResponsibleFor");
  }

  public EmployeeRequest countResponsibleFor(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RESPONSIBLE_FOR_PROPERTY);
  }

  public EmployeeRequest groupByResponsibleFor() {
    return groupByResponsibleFor(RESPONSIBLE_FOR_PROPERTY);
  }

  public EmployeeRequest groupByResponsibleFor(String ret) {
    return groupBy(ret, RESPONSIBLE_FOR_PROPERTY);
  }

  public EmployeeRequest whereResponsibleForIsNull() {
    return where(RESPONSIBLE_FOR_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereResponsibleForIsNotNull() {
    return where(RESPONSIBLE_FOR_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest filterByCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade) {
    return filterByCurrentSalaryGrade(currentSalaryGrade, SalaryGrade::getId);
  }

  public EmployeeRequest filterByCurrentSalaryGrade(SalaryGrade... currentSalaryGrade) {
    if (isEmptyParam(currentSalaryGrade)) {
      throw new IllegalArgumentException(
          "filterByCurrentSalaryGrade(SalaryGrade... currentSalaryGrade)参数不能为空!");
    }
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IN, (Object[]) currentSalaryGrade);
  }

  public EmployeeRequest selectCurrentSalaryGradeId() {
    select(CURRENT_SALARY_GRADE_PROPERTY);
    return this;
  }

  public SalaryGradeRequest upToCurrentSalaryGrade() {
    return upToCurrentSalaryGrade(SalaryGradeRequest.newInstance());
  }

  public SalaryGradeRequest upToCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade) {
    currentSalaryGrade.aggregateChild(CURRENT_SALARY_GRADE_PROPERTY, this);
    this.groupByCurrentSalaryGrade(currentSalaryGrade);
    return currentSalaryGrade;
  }

  public SalaryGradeRequest endAtCurrentSalaryGrade(String retName) {
    return endAtCurrentSalaryGrade(retName, SalaryGradeRequest.newInstance());
  }

  public SalaryGradeRequest endAtCurrentSalaryGrade(
      String retName, SalaryGradeRequest currentSalaryGrade) {
    currentSalaryGrade.addDynamicProperty(retName, this, CURRENT_SALARY_GRADE_PROPERTY);
    return currentSalaryGrade;
  }

  public EmployeeRequest filterByCurrentSalaryGrade(String... currentSalaryGrade) {
    if (isEmptyParam(currentSalaryGrade)) {
      throw new IllegalArgumentException(
          "filterByCurrentSalaryGrade(String... currentSalaryGrade)参数不能为空!");
    }
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IN, (Object[]) currentSalaryGrade);
  }

  public EmployeeRequest filterByCurrentSalaryGrade(
      SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
    currentSalaryGrade.unlimited();
    return addSearchCriteria(createCurrentSalaryGradeCriteria(currentSalaryGrade, idRefine));
  }

  public SearchCriteria createCurrentSalaryGradeCriteria(
      SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
    return new RefinedIdInCriteria(
        currentSalaryGrade, CURRENT_SALARY_GRADE_PROPERTY, idRefine, SalaryGrade.ID_PROPERTY);
  }

  public EmployeeRequest selectCurrentSalaryGrade() {
    return selectCurrentSalaryGrade(SalaryGradeRequest.newInstance().selectSelf());
  }

  public EmployeeRequest selectCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade) {
    selectParent(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
    return this;
  }

  public EmployeeRequest unselectCurrentSalaryGrade() {
    unselectParent(CURRENT_SALARY_GRADE_PROPERTY);
    return this;
  }

  public EmployeeRequest groupByCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade) {
    groupBy(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
    return this;
  }

  public EmployeeRequest aggregateCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade) {
    aggregateParent(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
    return this;
  }

  public EmployeeRequest countCurrentSalaryGrade() {
    return countCurrentSalaryGrade("countCurrentSalaryGrade");
  }

  public EmployeeRequest countCurrentSalaryGrade(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CURRENT_SALARY_GRADE_PROPERTY);
  }

  public EmployeeRequest groupByCurrentSalaryGrade() {
    return groupByCurrentSalaryGrade(CURRENT_SALARY_GRADE_PROPERTY);
  }

  public EmployeeRequest groupByCurrentSalaryGrade(String ret) {
    return groupBy(ret, CURRENT_SALARY_GRADE_PROPERTY);
  }

  public EmployeeRequest whereCurrentSalaryGradeIsNull() {
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeRequest whereCurrentSalaryGradeIsNotNull() {
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeRequest hasEmployeeCompanyTraining() {
    return hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTraining... employeeCompanyTraining) {
    if (isEmptyParam(employeeCompanyTraining)) {
      throw new IllegalArgumentException(
          "hasEmployeeCompanyTraining(EmployeeCompanyTraining... employeeCompanyTraining)参数不能为空!");
    }
    return hasEmployeeCompanyTraining(
        Q.employeeCompanyTraining()
            .select(EmployeeCompanyTraining.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeCompanyTraining));
  }

  public EmployeeRequest hasEmployeeCompanyTraining(String... employeeCompanyTraining) {
    return hasEmployeeCompanyTraining(
        Q.employeeCompanyTraining()
            .select(EmployeeCompanyTraining.EMPLOYEE_PROPERTY)
            .filterById(employeeCompanyTraining));
  }

  public EmployeeRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return hasEmployeeCompanyTraining(
        employeeCompanyTraining,
        $employeeCompanyTraining ->
            java.util.Optional.of($employeeCompanyTraining)
                .map(EmployeeCompanyTraining::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      IDRefine<EmployeeCompanyTraining> idRefine) {
    employeeCompanyTraining.select(EmployeeCompanyTraining.EMPLOYEE_PROPERTY);
    employeeCompanyTraining.unlimited();
    return addSearchCriteria(
        createEmployeeCompanyTrainingCriteria(employeeCompanyTraining, idRefine));
  }

  public EmployeeRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeCompanyTraining,
            EmployeeCompanyTraining.EMPLOYEE_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createEmployeeCompanyTrainingCriteria(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      IDRefine<EmployeeCompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        employeeCompanyTraining, ID_PROPERTY, idRefine, EmployeeCompanyTraining.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeCompanyTrainingList(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    selectChild(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeCompanyTraining);
    return this;
  }

  public EmployeeRequest selectEmployeeCompanyTrainingList() {
    return selectEmployeeCompanyTrainingList(
        EmployeeCompanyTrainingRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeCompanyTrainingList() {
    unselectChild(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, EmployeeCompanyTraining.class);
    return this;
  }

  public EmployeeRequest hasEmployeeSkill() {
    return hasEmployeeSkill(EmployeeSkillRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeSkill(EmployeeSkill... employeeSkill) {
    if (isEmptyParam(employeeSkill)) {
      throw new IllegalArgumentException("hasEmployeeSkill(EmployeeSkill... employeeSkill)参数不能为空!");
    }
    return hasEmployeeSkill(
        Q.employeeSkill()
            .select(EmployeeSkill.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeSkill));
  }

  public EmployeeRequest hasEmployeeSkill(String... employeeSkill) {
    return hasEmployeeSkill(
        Q.employeeSkill().select(EmployeeSkill.EMPLOYEE_PROPERTY).filterById(employeeSkill));
  }

  public EmployeeRequest hasEmployeeSkill(EmployeeSkillRequest employeeSkill) {
    return hasEmployeeSkill(
        employeeSkill,
        $employeeSkill ->
            java.util.Optional.of($employeeSkill)
                .map(EmployeeSkill::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeSkill(
      EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine) {
    employeeSkill.select(EmployeeSkill.EMPLOYEE_PROPERTY);
    employeeSkill.unlimited();
    return addSearchCriteria(createEmployeeSkillCriteria(employeeSkill, idRefine));
  }

  public EmployeeRequest hasEmployeeSkill(
      EmployeeSkillRequest employeeSkill, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeSkill, EmployeeSkill.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeSkillCriteria(
      EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine) {
    return new RefinedIdInCriteria(
        employeeSkill, ID_PROPERTY, idRefine, EmployeeSkill.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeSkillList(EmployeeSkillRequest employeeSkill) {
    selectChild(EmployeeSkill.EMPLOYEE_PROPERTY, employeeSkill);
    return this;
  }

  public EmployeeRequest selectEmployeeSkillList() {
    return selectEmployeeSkillList(EmployeeSkillRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeSkillList() {
    unselectChild(EmployeeSkill.EMPLOYEE_PROPERTY, EmployeeSkill.class);
    return this;
  }

  public EmployeeRequest hasEmployeePerformance() {
    return hasEmployeePerformance(EmployeePerformanceRequest.newInstance());
  }

  public EmployeeRequest hasEmployeePerformance(EmployeePerformance... employeePerformance) {
    if (isEmptyParam(employeePerformance)) {
      throw new IllegalArgumentException(
          "hasEmployeePerformance(EmployeePerformance... employeePerformance)参数不能为空!");
    }
    return hasEmployeePerformance(
        Q.employeePerformance()
            .select(EmployeePerformance.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeePerformance));
  }

  public EmployeeRequest hasEmployeePerformance(String... employeePerformance) {
    return hasEmployeePerformance(
        Q.employeePerformance()
            .select(EmployeePerformance.EMPLOYEE_PROPERTY)
            .filterById(employeePerformance));
  }

  public EmployeeRequest hasEmployeePerformance(EmployeePerformanceRequest employeePerformance) {
    return hasEmployeePerformance(
        employeePerformance,
        $employeePerformance ->
            java.util.Optional.of($employeePerformance)
                .map(EmployeePerformance::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeePerformance(
      EmployeePerformanceRequest employeePerformance, IDRefine<EmployeePerformance> idRefine) {
    employeePerformance.select(EmployeePerformance.EMPLOYEE_PROPERTY);
    employeePerformance.unlimited();
    return addSearchCriteria(createEmployeePerformanceCriteria(employeePerformance, idRefine));
  }

  public EmployeeRequest hasEmployeePerformance(
      EmployeePerformanceRequest employeePerformance, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeePerformance, EmployeePerformance.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeePerformanceCriteria(
      EmployeePerformanceRequest employeePerformance, IDRefine<EmployeePerformance> idRefine) {
    return new RefinedIdInCriteria(
        employeePerformance, ID_PROPERTY, idRefine, EmployeePerformance.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeePerformanceList(
      EmployeePerformanceRequest employeePerformance) {
    selectChild(EmployeePerformance.EMPLOYEE_PROPERTY, employeePerformance);
    return this;
  }

  public EmployeeRequest selectEmployeePerformanceList() {
    return selectEmployeePerformanceList(EmployeePerformanceRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeePerformanceList() {
    unselectChild(EmployeePerformance.EMPLOYEE_PROPERTY, EmployeePerformance.class);
    return this;
  }

  public EmployeeRequest hasEmployeeWorkExperience() {
    return hasEmployeeWorkExperience(EmployeeWorkExperienceRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeWorkExperience(
      EmployeeWorkExperience... employeeWorkExperience) {
    if (isEmptyParam(employeeWorkExperience)) {
      throw new IllegalArgumentException(
          "hasEmployeeWorkExperience(EmployeeWorkExperience... employeeWorkExperience)参数不能为空!");
    }
    return hasEmployeeWorkExperience(
        Q.employeeWorkExperience()
            .select(EmployeeWorkExperience.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeWorkExperience));
  }

  public EmployeeRequest hasEmployeeWorkExperience(String... employeeWorkExperience) {
    return hasEmployeeWorkExperience(
        Q.employeeWorkExperience()
            .select(EmployeeWorkExperience.EMPLOYEE_PROPERTY)
            .filterById(employeeWorkExperience));
  }

  public EmployeeRequest hasEmployeeWorkExperience(
      EmployeeWorkExperienceRequest employeeWorkExperience) {
    return hasEmployeeWorkExperience(
        employeeWorkExperience,
        $employeeWorkExperience ->
            java.util.Optional.of($employeeWorkExperience)
                .map(EmployeeWorkExperience::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeWorkExperience(
      EmployeeWorkExperienceRequest employeeWorkExperience,
      IDRefine<EmployeeWorkExperience> idRefine) {
    employeeWorkExperience.select(EmployeeWorkExperience.EMPLOYEE_PROPERTY);
    employeeWorkExperience.unlimited();
    return addSearchCriteria(
        createEmployeeWorkExperienceCriteria(employeeWorkExperience, idRefine));
  }

  public EmployeeRequest hasEmployeeWorkExperience(
      EmployeeWorkExperienceRequest employeeWorkExperience,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeWorkExperience,
            EmployeeWorkExperience.EMPLOYEE_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createEmployeeWorkExperienceCriteria(
      EmployeeWorkExperienceRequest employeeWorkExperience,
      IDRefine<EmployeeWorkExperience> idRefine) {
    return new RefinedIdInCriteria(
        employeeWorkExperience, ID_PROPERTY, idRefine, EmployeeWorkExperience.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeWorkExperienceList(
      EmployeeWorkExperienceRequest employeeWorkExperience) {
    selectChild(EmployeeWorkExperience.EMPLOYEE_PROPERTY, employeeWorkExperience);
    return this;
  }

  public EmployeeRequest selectEmployeeWorkExperienceList() {
    return selectEmployeeWorkExperienceList(
        EmployeeWorkExperienceRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeWorkExperienceList() {
    unselectChild(EmployeeWorkExperience.EMPLOYEE_PROPERTY, EmployeeWorkExperience.class);
    return this;
  }

  public EmployeeRequest hasEmployeeLeave() {
    return hasEmployeeLeave(EmployeeLeaveRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeLeave(EmployeeLeave... employeeLeave) {
    if (isEmptyParam(employeeLeave)) {
      throw new IllegalArgumentException("hasEmployeeLeave(EmployeeLeave... employeeLeave)参数不能为空!");
    }
    return hasEmployeeLeave(
        Q.employeeLeave()
            .select(EmployeeLeave.WHO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeLeave));
  }

  public EmployeeRequest hasEmployeeLeave(String... employeeLeave) {
    return hasEmployeeLeave(
        Q.employeeLeave().select(EmployeeLeave.WHO_PROPERTY).filterById(employeeLeave));
  }

  public EmployeeRequest hasEmployeeLeave(EmployeeLeaveRequest employeeLeave) {
    return hasEmployeeLeave(
        employeeLeave,
        $employeeLeave ->
            java.util.Optional.of($employeeLeave)
                .map(EmployeeLeave::getWho)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeLeave(
      EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine) {
    employeeLeave.select(EmployeeLeave.WHO_PROPERTY);
    employeeLeave.unlimited();
    return addSearchCriteria(createEmployeeLeaveCriteria(employeeLeave, idRefine));
  }

  public EmployeeRequest hasEmployeeLeave(
      EmployeeLeaveRequest employeeLeave, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(employeeLeave, EmployeeLeave.WHO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeLeaveCriteria(
      EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine) {
    return new RefinedIdInCriteria(
        employeeLeave, ID_PROPERTY, idRefine, EmployeeLeave.WHO_PROPERTY);
  }

  public EmployeeRequest selectEmployeeLeaveList(EmployeeLeaveRequest employeeLeave) {
    selectChild(EmployeeLeave.WHO_PROPERTY, employeeLeave);
    return this;
  }

  public EmployeeRequest selectEmployeeLeaveList() {
    return selectEmployeeLeaveList(EmployeeLeaveRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeLeaveList() {
    unselectChild(EmployeeLeave.WHO_PROPERTY, EmployeeLeave.class);
    return this;
  }

  public EmployeeRequest hasEmployeeInterview() {
    return hasEmployeeInterview(EmployeeInterviewRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeInterview(EmployeeInterview... employeeInterview) {
    if (isEmptyParam(employeeInterview)) {
      throw new IllegalArgumentException(
          "hasEmployeeInterview(EmployeeInterview... employeeInterview)参数不能为空!");
    }
    return hasEmployeeInterview(
        Q.employeeInterview()
            .select(EmployeeInterview.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeInterview));
  }

  public EmployeeRequest hasEmployeeInterview(String... employeeInterview) {
    return hasEmployeeInterview(
        Q.employeeInterview()
            .select(EmployeeInterview.EMPLOYEE_PROPERTY)
            .filterById(employeeInterview));
  }

  public EmployeeRequest hasEmployeeInterview(EmployeeInterviewRequest employeeInterview) {
    return hasEmployeeInterview(
        employeeInterview,
        $employeeInterview ->
            java.util.Optional.of($employeeInterview)
                .map(EmployeeInterview::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeInterview(
      EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine) {
    employeeInterview.select(EmployeeInterview.EMPLOYEE_PROPERTY);
    employeeInterview.unlimited();
    return addSearchCriteria(createEmployeeInterviewCriteria(employeeInterview, idRefine));
  }

  public EmployeeRequest hasEmployeeInterview(
      EmployeeInterviewRequest employeeInterview, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeInterview, EmployeeInterview.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeInterviewCriteria(
      EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine) {
    return new RefinedIdInCriteria(
        employeeInterview, ID_PROPERTY, idRefine, EmployeeInterview.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeInterviewList(EmployeeInterviewRequest employeeInterview) {
    selectChild(EmployeeInterview.EMPLOYEE_PROPERTY, employeeInterview);
    return this;
  }

  public EmployeeRequest selectEmployeeInterviewList() {
    return selectEmployeeInterviewList(EmployeeInterviewRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeInterviewList() {
    unselectChild(EmployeeInterview.EMPLOYEE_PROPERTY, EmployeeInterview.class);
    return this;
  }

  public EmployeeRequest hasEmployeeAttendance() {
    return hasEmployeeAttendance(EmployeeAttendanceRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeAttendance(EmployeeAttendance... employeeAttendance) {
    if (isEmptyParam(employeeAttendance)) {
      throw new IllegalArgumentException(
          "hasEmployeeAttendance(EmployeeAttendance... employeeAttendance)参数不能为空!");
    }
    return hasEmployeeAttendance(
        Q.employeeAttendance()
            .select(EmployeeAttendance.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeAttendance));
  }

  public EmployeeRequest hasEmployeeAttendance(String... employeeAttendance) {
    return hasEmployeeAttendance(
        Q.employeeAttendance()
            .select(EmployeeAttendance.EMPLOYEE_PROPERTY)
            .filterById(employeeAttendance));
  }

  public EmployeeRequest hasEmployeeAttendance(EmployeeAttendanceRequest employeeAttendance) {
    return hasEmployeeAttendance(
        employeeAttendance,
        $employeeAttendance ->
            java.util.Optional.of($employeeAttendance)
                .map(EmployeeAttendance::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeAttendance(
      EmployeeAttendanceRequest employeeAttendance, IDRefine<EmployeeAttendance> idRefine) {
    employeeAttendance.select(EmployeeAttendance.EMPLOYEE_PROPERTY);
    employeeAttendance.unlimited();
    return addSearchCriteria(createEmployeeAttendanceCriteria(employeeAttendance, idRefine));
  }

  public EmployeeRequest hasEmployeeAttendance(
      EmployeeAttendanceRequest employeeAttendance, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeAttendance, EmployeeAttendance.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeAttendanceCriteria(
      EmployeeAttendanceRequest employeeAttendance, IDRefine<EmployeeAttendance> idRefine) {
    return new RefinedIdInCriteria(
        employeeAttendance, ID_PROPERTY, idRefine, EmployeeAttendance.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeAttendanceList(
      EmployeeAttendanceRequest employeeAttendance) {
    selectChild(EmployeeAttendance.EMPLOYEE_PROPERTY, employeeAttendance);
    return this;
  }

  public EmployeeRequest selectEmployeeAttendanceList() {
    return selectEmployeeAttendanceList(EmployeeAttendanceRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeAttendanceList() {
    unselectChild(EmployeeAttendance.EMPLOYEE_PROPERTY, EmployeeAttendance.class);
    return this;
  }

  public EmployeeRequest hasEmployeeQualifier() {
    return hasEmployeeQualifier(EmployeeQualifierRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeQualifier(EmployeeQualifier... employeeQualifier) {
    if (isEmptyParam(employeeQualifier)) {
      throw new IllegalArgumentException(
          "hasEmployeeQualifier(EmployeeQualifier... employeeQualifier)参数不能为空!");
    }
    return hasEmployeeQualifier(
        Q.employeeQualifier()
            .select(EmployeeQualifier.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeQualifier));
  }

  public EmployeeRequest hasEmployeeQualifier(String... employeeQualifier) {
    return hasEmployeeQualifier(
        Q.employeeQualifier()
            .select(EmployeeQualifier.EMPLOYEE_PROPERTY)
            .filterById(employeeQualifier));
  }

  public EmployeeRequest hasEmployeeQualifier(EmployeeQualifierRequest employeeQualifier) {
    return hasEmployeeQualifier(
        employeeQualifier,
        $employeeQualifier ->
            java.util.Optional.of($employeeQualifier)
                .map(EmployeeQualifier::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeQualifier(
      EmployeeQualifierRequest employeeQualifier, IDRefine<EmployeeQualifier> idRefine) {
    employeeQualifier.select(EmployeeQualifier.EMPLOYEE_PROPERTY);
    employeeQualifier.unlimited();
    return addSearchCriteria(createEmployeeQualifierCriteria(employeeQualifier, idRefine));
  }

  public EmployeeRequest hasEmployeeQualifier(
      EmployeeQualifierRequest employeeQualifier, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeQualifier, EmployeeQualifier.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeQualifierCriteria(
      EmployeeQualifierRequest employeeQualifier, IDRefine<EmployeeQualifier> idRefine) {
    return new RefinedIdInCriteria(
        employeeQualifier, ID_PROPERTY, idRefine, EmployeeQualifier.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeQualifierList(EmployeeQualifierRequest employeeQualifier) {
    selectChild(EmployeeQualifier.EMPLOYEE_PROPERTY, employeeQualifier);
    return this;
  }

  public EmployeeRequest selectEmployeeQualifierList() {
    return selectEmployeeQualifierList(EmployeeQualifierRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeQualifierList() {
    unselectChild(EmployeeQualifier.EMPLOYEE_PROPERTY, EmployeeQualifier.class);
    return this;
  }

  public EmployeeRequest hasEmployeeEducation() {
    return hasEmployeeEducation(EmployeeEducationRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeEducation(EmployeeEducation... employeeEducation) {
    if (isEmptyParam(employeeEducation)) {
      throw new IllegalArgumentException(
          "hasEmployeeEducation(EmployeeEducation... employeeEducation)参数不能为空!");
    }
    return hasEmployeeEducation(
        Q.employeeEducation()
            .select(EmployeeEducation.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeEducation));
  }

  public EmployeeRequest hasEmployeeEducation(String... employeeEducation) {
    return hasEmployeeEducation(
        Q.employeeEducation()
            .select(EmployeeEducation.EMPLOYEE_PROPERTY)
            .filterById(employeeEducation));
  }

  public EmployeeRequest hasEmployeeEducation(EmployeeEducationRequest employeeEducation) {
    return hasEmployeeEducation(
        employeeEducation,
        $employeeEducation ->
            java.util.Optional.of($employeeEducation)
                .map(EmployeeEducation::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeEducation(
      EmployeeEducationRequest employeeEducation, IDRefine<EmployeeEducation> idRefine) {
    employeeEducation.select(EmployeeEducation.EMPLOYEE_PROPERTY);
    employeeEducation.unlimited();
    return addSearchCriteria(createEmployeeEducationCriteria(employeeEducation, idRefine));
  }

  public EmployeeRequest hasEmployeeEducation(
      EmployeeEducationRequest employeeEducation, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeEducation, EmployeeEducation.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeEducationCriteria(
      EmployeeEducationRequest employeeEducation, IDRefine<EmployeeEducation> idRefine) {
    return new RefinedIdInCriteria(
        employeeEducation, ID_PROPERTY, idRefine, EmployeeEducation.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeEducationList(EmployeeEducationRequest employeeEducation) {
    selectChild(EmployeeEducation.EMPLOYEE_PROPERTY, employeeEducation);
    return this;
  }

  public EmployeeRequest selectEmployeeEducationList() {
    return selectEmployeeEducationList(EmployeeEducationRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeEducationList() {
    unselectChild(EmployeeEducation.EMPLOYEE_PROPERTY, EmployeeEducation.class);
    return this;
  }

  public EmployeeRequest hasEmployeeAward() {
    return hasEmployeeAward(EmployeeAwardRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeAward(EmployeeAward... employeeAward) {
    if (isEmptyParam(employeeAward)) {
      throw new IllegalArgumentException("hasEmployeeAward(EmployeeAward... employeeAward)参数不能为空!");
    }
    return hasEmployeeAward(
        Q.employeeAward()
            .select(EmployeeAward.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeAward));
  }

  public EmployeeRequest hasEmployeeAward(String... employeeAward) {
    return hasEmployeeAward(
        Q.employeeAward().select(EmployeeAward.EMPLOYEE_PROPERTY).filterById(employeeAward));
  }

  public EmployeeRequest hasEmployeeAward(EmployeeAwardRequest employeeAward) {
    return hasEmployeeAward(
        employeeAward,
        $employeeAward ->
            java.util.Optional.of($employeeAward)
                .map(EmployeeAward::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeAward(
      EmployeeAwardRequest employeeAward, IDRefine<EmployeeAward> idRefine) {
    employeeAward.select(EmployeeAward.EMPLOYEE_PROPERTY);
    employeeAward.unlimited();
    return addSearchCriteria(createEmployeeAwardCriteria(employeeAward, idRefine));
  }

  public EmployeeRequest hasEmployeeAward(
      EmployeeAwardRequest employeeAward, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeAward, EmployeeAward.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeAwardCriteria(
      EmployeeAwardRequest employeeAward, IDRefine<EmployeeAward> idRefine) {
    return new RefinedIdInCriteria(
        employeeAward, ID_PROPERTY, idRefine, EmployeeAward.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeAwardList(EmployeeAwardRequest employeeAward) {
    selectChild(EmployeeAward.EMPLOYEE_PROPERTY, employeeAward);
    return this;
  }

  public EmployeeRequest selectEmployeeAwardList() {
    return selectEmployeeAwardList(EmployeeAwardRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeAwardList() {
    unselectChild(EmployeeAward.EMPLOYEE_PROPERTY, EmployeeAward.class);
    return this;
  }

  public EmployeeRequest hasEmployeeSalarySheet() {
    return hasEmployeeSalarySheet(EmployeeSalarySheetRequest.newInstance());
  }

  public EmployeeRequest hasEmployeeSalarySheet(EmployeeSalarySheet... employeeSalarySheet) {
    if (isEmptyParam(employeeSalarySheet)) {
      throw new IllegalArgumentException(
          "hasEmployeeSalarySheet(EmployeeSalarySheet... employeeSalarySheet)参数不能为空!");
    }
    return hasEmployeeSalarySheet(
        Q.employeeSalarySheet()
            .select(EmployeeSalarySheet.EMPLOYEE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeSalarySheet));
  }

  public EmployeeRequest hasEmployeeSalarySheet(String... employeeSalarySheet) {
    return hasEmployeeSalarySheet(
        Q.employeeSalarySheet()
            .select(EmployeeSalarySheet.EMPLOYEE_PROPERTY)
            .filterById(employeeSalarySheet));
  }

  public EmployeeRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
    return hasEmployeeSalarySheet(
        employeeSalarySheet,
        $employeeSalarySheet ->
            java.util.Optional.of($employeeSalarySheet)
                .map(EmployeeSalarySheet::getEmployee)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
    employeeSalarySheet.select(EmployeeSalarySheet.EMPLOYEE_PROPERTY);
    employeeSalarySheet.unlimited();
    return addSearchCriteria(createEmployeeSalarySheetCriteria(employeeSalarySheet, idRefine));
  }

  public EmployeeRequest hasEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeSalarySheet, EmployeeSalarySheet.EMPLOYEE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeSalarySheetCriteria(
      EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
    return new RefinedIdInCriteria(
        employeeSalarySheet, ID_PROPERTY, idRefine, EmployeeSalarySheet.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest selectEmployeeSalarySheetList(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    selectChild(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeSalarySheet);
    return this;
  }

  public EmployeeRequest selectEmployeeSalarySheetList() {
    return selectEmployeeSalarySheetList(EmployeeSalarySheetRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectEmployeeSalarySheetList() {
    unselectChild(EmployeeSalarySheet.EMPLOYEE_PROPERTY, EmployeeSalarySheet.class);
    return this;
  }

  public EmployeeRequest hasPayingOff() {
    return hasPayingOff(PayingOffRequest.newInstance());
  }

  public EmployeeRequest hasPayingOff(PayingOff... payingOff) {
    if (isEmptyParam(payingOff)) {
      throw new IllegalArgumentException("hasPayingOff(PayingOff... payingOff)参数不能为空!");
    }
    return hasPayingOff(
        Q.payingOff()
            .select(PayingOff.PAID_FOR_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) payingOff));
  }

  public EmployeeRequest hasPayingOff(String... payingOff) {
    return hasPayingOff(Q.payingOff().select(PayingOff.PAID_FOR_PROPERTY).filterById(payingOff));
  }

  public EmployeeRequest hasPayingOff(PayingOffRequest payingOff) {
    return hasPayingOff(
        payingOff,
        $payingOff ->
            java.util.Optional.of($payingOff)
                .map(PayingOff::getPaidFor)
                .map(Employee::getId)
                .orElse(null));
  }

  public EmployeeRequest hasPayingOff(PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
    payingOff.select(PayingOff.PAID_FOR_PROPERTY);
    payingOff.unlimited();
    return addSearchCriteria(createPayingOffCriteria(payingOff, idRefine));
  }

  public EmployeeRequest hasPayingOff(
      PayingOffRequest payingOff, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(payingOff, PayingOff.PAID_FOR_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createPayingOffCriteria(
      PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
    return new RefinedIdInCriteria(payingOff, ID_PROPERTY, idRefine, PayingOff.PAID_FOR_PROPERTY);
  }

  public EmployeeRequest selectPayingOffList(PayingOffRequest payingOff) {
    selectChild(PayingOff.PAID_FOR_PROPERTY, payingOff);
    return this;
  }

  public EmployeeRequest selectPayingOffList() {
    return selectPayingOffList(PayingOffRequest.newInstance().selectAll());
  }

  public EmployeeRequest unselectPayingOffList() {
    unselectChild(PayingOff.PAID_FOR_PROPERTY, PayingOff.class);
    return this;
  }

  public EmployeeRequest aggregateEmployeeCompanyTrainingList(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    aggregateChild(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeCompanyTraining);
    return this;
  }

  public EmployeeRequest countEmployeeCompanyTraining() {
    return countEmployeeCompanyTraining("employeeCompanyTrainingCount");
  }

  public EmployeeRequest countEmployeeCompanyTraining(String retName) {
    return countEmployeeCompanyTraining(retName, EmployeeCompanyTrainingRequest.newInstance());
  }

  public EmployeeRequest countEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return countEmployeeCompanyTraining("employeeCompanyTrainingCount", employeeCompanyTraining);
  }

  public EmployeeRequest countEmployeeCompanyTraining(
      String retName, EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    employeeCompanyTraining.count();
    return statsFromEmployeeCompanyTraining(retName, employeeCompanyTraining);
  }

  public EmployeeRequest statsFromEmployeeCompanyTraining(
      String retName, EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return addDynamicProperty(
        retName, employeeCompanyTraining, EmployeeCompanyTraining.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeSkillList(EmployeeSkillRequest employeeSkill) {
    aggregateChild(EmployeeSkill.EMPLOYEE_PROPERTY, employeeSkill);
    return this;
  }

  public EmployeeRequest countEmployeeSkill() {
    return countEmployeeSkill("employeeSkillCount");
  }

  public EmployeeRequest countEmployeeSkill(String retName) {
    return countEmployeeSkill(retName, EmployeeSkillRequest.newInstance());
  }

  public EmployeeRequest countEmployeeSkill(EmployeeSkillRequest employeeSkill) {
    return countEmployeeSkill("employeeSkillCount", employeeSkill);
  }

  public EmployeeRequest countEmployeeSkill(String retName, EmployeeSkillRequest employeeSkill) {
    employeeSkill.count();
    return statsFromEmployeeSkill(retName, employeeSkill);
  }

  public EmployeeRequest statsFromEmployeeSkill(
      String retName, EmployeeSkillRequest employeeSkill) {
    return addDynamicProperty(retName, employeeSkill, EmployeeSkill.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeePerformanceList(
      EmployeePerformanceRequest employeePerformance) {
    aggregateChild(EmployeePerformance.EMPLOYEE_PROPERTY, employeePerformance);
    return this;
  }

  public EmployeeRequest countEmployeePerformance() {
    return countEmployeePerformance("employeePerformanceCount");
  }

  public EmployeeRequest countEmployeePerformance(String retName) {
    return countEmployeePerformance(retName, EmployeePerformanceRequest.newInstance());
  }

  public EmployeeRequest countEmployeePerformance(EmployeePerformanceRequest employeePerformance) {
    return countEmployeePerformance("employeePerformanceCount", employeePerformance);
  }

  public EmployeeRequest countEmployeePerformance(
      String retName, EmployeePerformanceRequest employeePerformance) {
    employeePerformance.count();
    return statsFromEmployeePerformance(retName, employeePerformance);
  }

  public EmployeeRequest statsFromEmployeePerformance(
      String retName, EmployeePerformanceRequest employeePerformance) {
    return addDynamicProperty(retName, employeePerformance, EmployeePerformance.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeWorkExperienceList(
      EmployeeWorkExperienceRequest employeeWorkExperience) {
    aggregateChild(EmployeeWorkExperience.EMPLOYEE_PROPERTY, employeeWorkExperience);
    return this;
  }

  public EmployeeRequest countEmployeeWorkExperience() {
    return countEmployeeWorkExperience("employeeWorkExperienceCount");
  }

  public EmployeeRequest countEmployeeWorkExperience(String retName) {
    return countEmployeeWorkExperience(retName, EmployeeWorkExperienceRequest.newInstance());
  }

  public EmployeeRequest countEmployeeWorkExperience(
      EmployeeWorkExperienceRequest employeeWorkExperience) {
    return countEmployeeWorkExperience("employeeWorkExperienceCount", employeeWorkExperience);
  }

  public EmployeeRequest countEmployeeWorkExperience(
      String retName, EmployeeWorkExperienceRequest employeeWorkExperience) {
    employeeWorkExperience.count();
    return statsFromEmployeeWorkExperience(retName, employeeWorkExperience);
  }

  public EmployeeRequest statsFromEmployeeWorkExperience(
      String retName, EmployeeWorkExperienceRequest employeeWorkExperience) {
    return addDynamicProperty(
        retName, employeeWorkExperience, EmployeeWorkExperience.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeLeaveList(EmployeeLeaveRequest employeeLeave) {
    aggregateChild(EmployeeLeave.WHO_PROPERTY, employeeLeave);
    return this;
  }

  public EmployeeRequest countEmployeeLeave() {
    return countEmployeeLeave("employeeLeaveCount");
  }

  public EmployeeRequest countEmployeeLeave(String retName) {
    return countEmployeeLeave(retName, EmployeeLeaveRequest.newInstance());
  }

  public EmployeeRequest countEmployeeLeave(EmployeeLeaveRequest employeeLeave) {
    return countEmployeeLeave("employeeLeaveCount", employeeLeave);
  }

  public EmployeeRequest countEmployeeLeave(String retName, EmployeeLeaveRequest employeeLeave) {
    employeeLeave.count();
    return statsFromEmployeeLeave(retName, employeeLeave);
  }

  public EmployeeRequest statsFromEmployeeLeave(
      String retName, EmployeeLeaveRequest employeeLeave) {
    return addDynamicProperty(retName, employeeLeave, EmployeeLeave.WHO_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeInterviewList(
      EmployeeInterviewRequest employeeInterview) {
    aggregateChild(EmployeeInterview.EMPLOYEE_PROPERTY, employeeInterview);
    return this;
  }

  public EmployeeRequest countEmployeeInterview() {
    return countEmployeeInterview("employeeInterviewCount");
  }

  public EmployeeRequest countEmployeeInterview(String retName) {
    return countEmployeeInterview(retName, EmployeeInterviewRequest.newInstance());
  }

  public EmployeeRequest countEmployeeInterview(EmployeeInterviewRequest employeeInterview) {
    return countEmployeeInterview("employeeInterviewCount", employeeInterview);
  }

  public EmployeeRequest countEmployeeInterview(
      String retName, EmployeeInterviewRequest employeeInterview) {
    employeeInterview.count();
    return statsFromEmployeeInterview(retName, employeeInterview);
  }

  public EmployeeRequest statsFromEmployeeInterview(
      String retName, EmployeeInterviewRequest employeeInterview) {
    return addDynamicProperty(retName, employeeInterview, EmployeeInterview.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeAttendanceList(
      EmployeeAttendanceRequest employeeAttendance) {
    aggregateChild(EmployeeAttendance.EMPLOYEE_PROPERTY, employeeAttendance);
    return this;
  }

  public EmployeeRequest countEmployeeAttendance() {
    return countEmployeeAttendance("employeeAttendanceCount");
  }

  public EmployeeRequest countEmployeeAttendance(String retName) {
    return countEmployeeAttendance(retName, EmployeeAttendanceRequest.newInstance());
  }

  public EmployeeRequest countEmployeeAttendance(EmployeeAttendanceRequest employeeAttendance) {
    return countEmployeeAttendance("employeeAttendanceCount", employeeAttendance);
  }

  public EmployeeRequest countEmployeeAttendance(
      String retName, EmployeeAttendanceRequest employeeAttendance) {
    employeeAttendance.count();
    return statsFromEmployeeAttendance(retName, employeeAttendance);
  }

  public EmployeeRequest statsFromEmployeeAttendance(
      String retName, EmployeeAttendanceRequest employeeAttendance) {
    return addDynamicProperty(retName, employeeAttendance, EmployeeAttendance.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeQualifierList(
      EmployeeQualifierRequest employeeQualifier) {
    aggregateChild(EmployeeQualifier.EMPLOYEE_PROPERTY, employeeQualifier);
    return this;
  }

  public EmployeeRequest countEmployeeQualifier() {
    return countEmployeeQualifier("employeeQualifierCount");
  }

  public EmployeeRequest countEmployeeQualifier(String retName) {
    return countEmployeeQualifier(retName, EmployeeQualifierRequest.newInstance());
  }

  public EmployeeRequest countEmployeeQualifier(EmployeeQualifierRequest employeeQualifier) {
    return countEmployeeQualifier("employeeQualifierCount", employeeQualifier);
  }

  public EmployeeRequest countEmployeeQualifier(
      String retName, EmployeeQualifierRequest employeeQualifier) {
    employeeQualifier.count();
    return statsFromEmployeeQualifier(retName, employeeQualifier);
  }

  public EmployeeRequest statsFromEmployeeQualifier(
      String retName, EmployeeQualifierRequest employeeQualifier) {
    return addDynamicProperty(retName, employeeQualifier, EmployeeQualifier.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeEducationList(
      EmployeeEducationRequest employeeEducation) {
    aggregateChild(EmployeeEducation.EMPLOYEE_PROPERTY, employeeEducation);
    return this;
  }

  public EmployeeRequest countEmployeeEducation() {
    return countEmployeeEducation("employeeEducationCount");
  }

  public EmployeeRequest countEmployeeEducation(String retName) {
    return countEmployeeEducation(retName, EmployeeEducationRequest.newInstance());
  }

  public EmployeeRequest countEmployeeEducation(EmployeeEducationRequest employeeEducation) {
    return countEmployeeEducation("employeeEducationCount", employeeEducation);
  }

  public EmployeeRequest countEmployeeEducation(
      String retName, EmployeeEducationRequest employeeEducation) {
    employeeEducation.count();
    return statsFromEmployeeEducation(retName, employeeEducation);
  }

  public EmployeeRequest statsFromEmployeeEducation(
      String retName, EmployeeEducationRequest employeeEducation) {
    return addDynamicProperty(retName, employeeEducation, EmployeeEducation.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeAwardList(EmployeeAwardRequest employeeAward) {
    aggregateChild(EmployeeAward.EMPLOYEE_PROPERTY, employeeAward);
    return this;
  }

  public EmployeeRequest countEmployeeAward() {
    return countEmployeeAward("employeeAwardCount");
  }

  public EmployeeRequest countEmployeeAward(String retName) {
    return countEmployeeAward(retName, EmployeeAwardRequest.newInstance());
  }

  public EmployeeRequest countEmployeeAward(EmployeeAwardRequest employeeAward) {
    return countEmployeeAward("employeeAwardCount", employeeAward);
  }

  public EmployeeRequest countEmployeeAward(String retName, EmployeeAwardRequest employeeAward) {
    employeeAward.count();
    return statsFromEmployeeAward(retName, employeeAward);
  }

  public EmployeeRequest statsFromEmployeeAward(
      String retName, EmployeeAwardRequest employeeAward) {
    return addDynamicProperty(retName, employeeAward, EmployeeAward.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregateEmployeeSalarySheetList(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    aggregateChild(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeSalarySheet);
    return this;
  }

  public EmployeeRequest countEmployeeSalarySheet() {
    return countEmployeeSalarySheet("employeeSalarySheetCount");
  }

  public EmployeeRequest countEmployeeSalarySheet(String retName) {
    return countEmployeeSalarySheet(retName, EmployeeSalarySheetRequest.newInstance());
  }

  public EmployeeRequest countEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
    return countEmployeeSalarySheet("employeeSalarySheetCount", employeeSalarySheet);
  }

  public EmployeeRequest countEmployeeSalarySheet(
      String retName, EmployeeSalarySheetRequest employeeSalarySheet) {
    employeeSalarySheet.count();
    return statsFromEmployeeSalarySheet(retName, employeeSalarySheet);
  }

  public EmployeeRequest statsFromEmployeeSalarySheet(
      String retName, EmployeeSalarySheetRequest employeeSalarySheet) {
    return addDynamicProperty(retName, employeeSalarySheet, EmployeeSalarySheet.EMPLOYEE_PROPERTY);
  }

  public EmployeeRequest aggregatePayingOffList(PayingOffRequest payingOff) {
    aggregateChild(PayingOff.PAID_FOR_PROPERTY, payingOff);
    return this;
  }

  public EmployeeRequest countPayingOff() {
    return countPayingOff("payingOffCount");
  }

  public EmployeeRequest countPayingOff(String retName) {
    return countPayingOff(retName, PayingOffRequest.newInstance());
  }

  public EmployeeRequest countPayingOff(PayingOffRequest payingOff) {
    return countPayingOff("payingOffCount", payingOff);
  }

  public EmployeeRequest countPayingOff(String retName, PayingOffRequest payingOff) {
    payingOff.count();
    return statsFromPayingOff(retName, payingOff);
  }

  public EmployeeRequest statsFromPayingOff(String retName, PayingOffRequest payingOff) {
    return addDynamicProperty(retName, payingOff, PayingOff.PAID_FOR_PROPERTY);
  }

  public EmployeeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
