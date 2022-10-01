package com.doublechaintech.retailscm.leavetype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.leavetype.LeaveType.*;

public class LeaveTypeRequest extends BaseRequest<LeaveType> {
  public static LeaveTypeRequest newInstance() {
    return new LeaveTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LeaveTypeRequest resultByClass(Class<? extends LeaveType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LeaveTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LeaveTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LeaveType";
  }

  public LeaveTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LeaveTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LeaveTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LeaveTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LeaveTypeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectDescription()
        .selectDetailDescription()
        .selectVersion();
  }

  public LeaveTypeRequest selectAny() {
    return selectAll().selectEmployeeLeaveList(Q.employeeLeave().selectSelf());
  }

  public LeaveTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(DETAIL_DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LeaveTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LeaveTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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

  public LeaveTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LeaveTypeRequest comment(String comment) {
    return this;
  }

  public LeaveTypeRequest enhance() {
    return this;
  }

  public LeaveTypeRequest overrideClass(Class<? extends LeaveType> clazz) {
    return this;
  }

  public LeaveTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LeaveTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LeaveTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LeaveTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LeaveTypeRequest count() {
    return countId("count");
  }

  public static LeaveTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LeaveTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LeaveTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LeaveTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LeaveTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LeaveTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LeaveTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LeaveTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LeaveTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LeaveTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LeaveTypeRequest countId() {
    return countId("countId");
  }

  public LeaveTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LeaveTypeRequest maxId() {
    return maxId("maxId");
  }

  public LeaveTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LeaveTypeRequest minId() {
    return minId("minId");
  }

  public LeaveTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LeaveTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LeaveTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LeaveTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LeaveTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LeaveTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public LeaveTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public LeaveTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LeaveTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LeaveTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public LeaveTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LeaveTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public LeaveTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public LeaveTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public LeaveTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public LeaveTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public LeaveTypeRequest countCode() {
    return countCode("countCode");
  }

  public LeaveTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public LeaveTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public LeaveTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public LeaveTypeRequest minCode() {
    return minCode("minCode");
  }

  public LeaveTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public LeaveTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public LeaveTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public LeaveTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public LeaveTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public LeaveTypeRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public LeaveTypeRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LeaveTypeRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LeaveTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LeaveTypeRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LeaveTypeRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public LeaveTypeRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public LeaveTypeRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public LeaveTypeRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public LeaveTypeRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public LeaveTypeRequest countDescription() {
    return countDescription("countDescription");
  }

  public LeaveTypeRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public LeaveTypeRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest minDescription() {
    return minDescription("minDescription");
  }

  public LeaveTypeRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public LeaveTypeRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public LeaveTypeRequest filterByDetailDescription(String detailDescription) {

    if (detailDescription == null) {
      return this;
    }

    return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
  }

  public LeaveTypeRequest whereDetailDescriptionIsNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LeaveTypeRequest whereDetailDescriptionIsNotNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LeaveTypeRequest filterByDetailDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LeaveTypeRequest selectDetailDescription() {
    return select(DETAIL_DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest unselectDetailDescription() {
    return unselect(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDetailDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LeaveTypeRequest orderByDetailDescription(boolean asc) {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public LeaveTypeRequest orderByDetailDescriptionAscending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public LeaveTypeRequest orderByDetailDescriptionDescending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public LeaveTypeRequest orderByDetailDescriptionAscendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", true);
    return this;
  }

  public LeaveTypeRequest orderByDetailDescriptionDescendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", false);
    return this;
  }

  public LeaveTypeRequest countDetailDescription() {
    return countDetailDescription("countDetailDescription");
  }

  public LeaveTypeRequest countDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DETAIL_DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest maxDetailDescription() {
    return maxDetailDescription("maxDetailDescription");
  }

  public LeaveTypeRequest maxDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DETAIL_DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest minDetailDescription() {
    return minDetailDescription("minDetailDescription");
  }

  public LeaveTypeRequest minDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DETAIL_DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest groupByDetailDescription() {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest groupByDetailDescription(String ret) {
    return groupBy(ret, DETAIL_DESCRIPTION_PROPERTY);
  }

  public LeaveTypeRequest groupByDetailDescription(SqlFunction func) {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY, func);
  }

  public LeaveTypeRequest groupByDetailDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public LeaveTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LeaveTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LeaveTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LeaveTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LeaveTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LeaveTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LeaveTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LeaveTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LeaveTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LeaveTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public LeaveTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LeaveTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LeaveTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LeaveTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public LeaveTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LeaveTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LeaveTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LeaveTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LeaveTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LeaveTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LeaveTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LeaveTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public LeaveTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public LeaveTypeRequest selectCompanyId() {
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

  public LeaveTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public LeaveTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public LeaveTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public LeaveTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public LeaveTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public LeaveTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public LeaveTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public LeaveTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public LeaveTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public LeaveTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public LeaveTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public LeaveTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public LeaveTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LeaveTypeRequest hasEmployeeLeave() {
    return hasEmployeeLeave(EmployeeLeaveRequest.newInstance());
  }

  public LeaveTypeRequest hasEmployeeLeave(EmployeeLeave... employeeLeave) {
    if (isEmptyParam(employeeLeave)) {
      throw new IllegalArgumentException("hasEmployeeLeave(EmployeeLeave... employeeLeave)参数不能为空!");
    }
    return hasEmployeeLeave(
        Q.employeeLeave()
            .select(EmployeeLeave.TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeLeave));
  }

  public LeaveTypeRequest hasEmployeeLeave(String... employeeLeave) {
    return hasEmployeeLeave(
        Q.employeeLeave().select(EmployeeLeave.TYPE_PROPERTY).filterById(employeeLeave));
  }

  public LeaveTypeRequest hasEmployeeLeave(EmployeeLeaveRequest employeeLeave) {
    return hasEmployeeLeave(
        employeeLeave,
        $employeeLeave ->
            java.util.Optional.of($employeeLeave)
                .map(EmployeeLeave::getType)
                .map(LeaveType::getId)
                .orElse(null));
  }

  public LeaveTypeRequest hasEmployeeLeave(
      EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine) {
    employeeLeave.select(EmployeeLeave.TYPE_PROPERTY);
    employeeLeave.unlimited();
    return addSearchCriteria(createEmployeeLeaveCriteria(employeeLeave, idRefine));
  }

  public LeaveTypeRequest hasEmployeeLeave(
      EmployeeLeaveRequest employeeLeave, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(employeeLeave, EmployeeLeave.TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeLeaveCriteria(
      EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine) {
    return new RefinedIdInCriteria(
        employeeLeave, ID_PROPERTY, idRefine, EmployeeLeave.TYPE_PROPERTY);
  }

  public LeaveTypeRequest selectEmployeeLeaveList(EmployeeLeaveRequest employeeLeave) {
    selectChild(EmployeeLeave.TYPE_PROPERTY, employeeLeave);
    return this;
  }

  public LeaveTypeRequest selectEmployeeLeaveList() {
    return selectEmployeeLeaveList(EmployeeLeaveRequest.newInstance().selectAll());
  }

  public LeaveTypeRequest unselectEmployeeLeaveList() {
    unselectChild(EmployeeLeave.TYPE_PROPERTY, EmployeeLeave.class);
    return this;
  }

  public LeaveTypeRequest aggregateEmployeeLeaveList(EmployeeLeaveRequest employeeLeave) {
    aggregateChild(EmployeeLeave.TYPE_PROPERTY, employeeLeave);
    return this;
  }

  public LeaveTypeRequest countEmployeeLeave() {
    return countEmployeeLeave("employeeLeaveCount");
  }

  public LeaveTypeRequest countEmployeeLeave(String retName) {
    return countEmployeeLeave(retName, EmployeeLeaveRequest.newInstance());
  }

  public LeaveTypeRequest countEmployeeLeave(EmployeeLeaveRequest employeeLeave) {
    return countEmployeeLeave("employeeLeaveCount", employeeLeave);
  }

  public LeaveTypeRequest countEmployeeLeave(String retName, EmployeeLeaveRequest employeeLeave) {
    employeeLeave.count();
    return statsFromEmployeeLeave(retName, employeeLeave);
  }

  public LeaveTypeRequest statsFromEmployeeLeave(
      String retName, EmployeeLeaveRequest employeeLeave) {
    return addDynamicProperty(retName, employeeLeave, EmployeeLeave.TYPE_PROPERTY);
  }

  public LeaveTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LeaveTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LeaveTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LeaveTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
