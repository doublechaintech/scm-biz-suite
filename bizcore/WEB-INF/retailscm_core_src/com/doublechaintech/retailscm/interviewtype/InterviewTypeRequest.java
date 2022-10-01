package com.doublechaintech.retailscm.interviewtype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.interviewtype.InterviewType.*;

public class InterviewTypeRequest extends BaseRequest<InterviewType> {
  public static InterviewTypeRequest newInstance() {
    return new InterviewTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public InterviewTypeRequest resultByClass(Class<? extends InterviewType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public InterviewTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public InterviewTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "InterviewType";
  }

  public InterviewTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public InterviewTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public InterviewTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public InterviewTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public InterviewTypeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectDescription()
        .selectDetailDescription()
        .selectVersion();
  }

  public InterviewTypeRequest selectAny() {
    return selectAll().selectEmployeeInterviewList(Q.employeeInterview().selectSelf());
  }

  public InterviewTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(DETAIL_DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public InterviewTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public InterviewTypeRequest where(
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

  public InterviewTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public InterviewTypeRequest comment(String comment) {
    return this;
  }

  public InterviewTypeRequest enhance() {
    return this;
  }

  public InterviewTypeRequest overrideClass(Class<? extends InterviewType> clazz) {
    return this;
  }

  public InterviewTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public InterviewTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public InterviewTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public InterviewTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public InterviewTypeRequest count() {
    return countId("count");
  }

  public static InterviewTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public InterviewTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public InterviewTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InterviewTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public InterviewTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InterviewTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public InterviewTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public InterviewTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public InterviewTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public InterviewTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public InterviewTypeRequest countId() {
    return countId("countId");
  }

  public InterviewTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public InterviewTypeRequest maxId() {
    return maxId("maxId");
  }

  public InterviewTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public InterviewTypeRequest minId() {
    return minId("minId");
  }

  public InterviewTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public InterviewTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public InterviewTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public InterviewTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public InterviewTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public InterviewTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public InterviewTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public InterviewTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InterviewTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InterviewTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public InterviewTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InterviewTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public InterviewTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public InterviewTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public InterviewTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public InterviewTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public InterviewTypeRequest countCode() {
    return countCode("countCode");
  }

  public InterviewTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public InterviewTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public InterviewTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public InterviewTypeRequest minCode() {
    return minCode("minCode");
  }

  public InterviewTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public InterviewTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public InterviewTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public InterviewTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public InterviewTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public InterviewTypeRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public InterviewTypeRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public InterviewTypeRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InterviewTypeRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InterviewTypeRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InterviewTypeRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public InterviewTypeRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public InterviewTypeRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public InterviewTypeRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public InterviewTypeRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public InterviewTypeRequest countDescription() {
    return countDescription("countDescription");
  }

  public InterviewTypeRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public InterviewTypeRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest minDescription() {
    return minDescription("minDescription");
  }

  public InterviewTypeRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public InterviewTypeRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public InterviewTypeRequest filterByDetailDescription(String detailDescription) {

    if (detailDescription == null) {
      return this;
    }

    return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
  }

  public InterviewTypeRequest whereDetailDescriptionIsNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public InterviewTypeRequest whereDetailDescriptionIsNotNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InterviewTypeRequest filterByDetailDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InterviewTypeRequest selectDetailDescription() {
    return select(DETAIL_DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest unselectDetailDescription() {
    return unselect(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDetailDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InterviewTypeRequest orderByDetailDescription(boolean asc) {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public InterviewTypeRequest orderByDetailDescriptionAscending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public InterviewTypeRequest orderByDetailDescriptionDescending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public InterviewTypeRequest orderByDetailDescriptionAscendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", true);
    return this;
  }

  public InterviewTypeRequest orderByDetailDescriptionDescendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", false);
    return this;
  }

  public InterviewTypeRequest countDetailDescription() {
    return countDetailDescription("countDetailDescription");
  }

  public InterviewTypeRequest countDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DETAIL_DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest maxDetailDescription() {
    return maxDetailDescription("maxDetailDescription");
  }

  public InterviewTypeRequest maxDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DETAIL_DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest minDetailDescription() {
    return minDetailDescription("minDetailDescription");
  }

  public InterviewTypeRequest minDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DETAIL_DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest groupByDetailDescription() {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest groupByDetailDescription(String ret) {
    return groupBy(ret, DETAIL_DESCRIPTION_PROPERTY);
  }

  public InterviewTypeRequest groupByDetailDescription(SqlFunction func) {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY, func);
  }

  public InterviewTypeRequest groupByDetailDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public InterviewTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public InterviewTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public InterviewTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InterviewTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InterviewTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public InterviewTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InterviewTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public InterviewTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public InterviewTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public InterviewTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public InterviewTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public InterviewTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public InterviewTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public InterviewTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public InterviewTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public InterviewTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public InterviewTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public InterviewTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public InterviewTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public InterviewTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public InterviewTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public InterviewTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public InterviewTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public InterviewTypeRequest selectCompanyId() {
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

  public InterviewTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public InterviewTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public InterviewTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public InterviewTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public InterviewTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public InterviewTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public InterviewTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public InterviewTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public InterviewTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public InterviewTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public InterviewTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public InterviewTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public InterviewTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InterviewTypeRequest hasEmployeeInterview() {
    return hasEmployeeInterview(EmployeeInterviewRequest.newInstance());
  }

  public InterviewTypeRequest hasEmployeeInterview(EmployeeInterview... employeeInterview) {
    if (isEmptyParam(employeeInterview)) {
      throw new IllegalArgumentException(
          "hasEmployeeInterview(EmployeeInterview... employeeInterview)参数不能为空!");
    }
    return hasEmployeeInterview(
        Q.employeeInterview()
            .select(EmployeeInterview.INTERVIEW_TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeInterview));
  }

  public InterviewTypeRequest hasEmployeeInterview(String... employeeInterview) {
    return hasEmployeeInterview(
        Q.employeeInterview()
            .select(EmployeeInterview.INTERVIEW_TYPE_PROPERTY)
            .filterById(employeeInterview));
  }

  public InterviewTypeRequest hasEmployeeInterview(EmployeeInterviewRequest employeeInterview) {
    return hasEmployeeInterview(
        employeeInterview,
        $employeeInterview ->
            java.util.Optional.of($employeeInterview)
                .map(EmployeeInterview::getInterviewType)
                .map(InterviewType::getId)
                .orElse(null));
  }

  public InterviewTypeRequest hasEmployeeInterview(
      EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine) {
    employeeInterview.select(EmployeeInterview.INTERVIEW_TYPE_PROPERTY);
    employeeInterview.unlimited();
    return addSearchCriteria(createEmployeeInterviewCriteria(employeeInterview, idRefine));
  }

  public InterviewTypeRequest hasEmployeeInterview(
      EmployeeInterviewRequest employeeInterview, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeInterview, EmployeeInterview.INTERVIEW_TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeInterviewCriteria(
      EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine) {
    return new RefinedIdInCriteria(
        employeeInterview, ID_PROPERTY, idRefine, EmployeeInterview.INTERVIEW_TYPE_PROPERTY);
  }

  public InterviewTypeRequest selectEmployeeInterviewList(
      EmployeeInterviewRequest employeeInterview) {
    selectChild(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, employeeInterview);
    return this;
  }

  public InterviewTypeRequest selectEmployeeInterviewList() {
    return selectEmployeeInterviewList(EmployeeInterviewRequest.newInstance().selectAll());
  }

  public InterviewTypeRequest unselectEmployeeInterviewList() {
    unselectChild(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, EmployeeInterview.class);
    return this;
  }

  public InterviewTypeRequest aggregateEmployeeInterviewList(
      EmployeeInterviewRequest employeeInterview) {
    aggregateChild(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, employeeInterview);
    return this;
  }

  public InterviewTypeRequest countEmployeeInterview() {
    return countEmployeeInterview("employeeInterviewCount");
  }

  public InterviewTypeRequest countEmployeeInterview(String retName) {
    return countEmployeeInterview(retName, EmployeeInterviewRequest.newInstance());
  }

  public InterviewTypeRequest countEmployeeInterview(EmployeeInterviewRequest employeeInterview) {
    return countEmployeeInterview("employeeInterviewCount", employeeInterview);
  }

  public InterviewTypeRequest countEmployeeInterview(
      String retName, EmployeeInterviewRequest employeeInterview) {
    employeeInterview.count();
    return statsFromEmployeeInterview(retName, employeeInterview);
  }

  public InterviewTypeRequest statsFromEmployeeInterview(
      String retName, EmployeeInterviewRequest employeeInterview) {
    return addDynamicProperty(
        retName, employeeInterview, EmployeeInterview.INTERVIEW_TYPE_PROPERTY);
  }

  public InterviewTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public InterviewTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public InterviewTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public InterviewTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
